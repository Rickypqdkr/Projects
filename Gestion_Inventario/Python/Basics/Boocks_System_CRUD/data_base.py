import sqlite3
from sqlite3 import Error

#************************ Conecta database ********************************
def conexion_db():
    try:
        conexion = sqlite3.connect('store_books_db.db')        
        return conexion
    except Error as e:
        print(f"Error connecting database {e}")
        return None
#******************* Create table ********************************
def create_table():
    conexion_database = conexion_db()
    if conexion_database:
        try:
            cursor = conexion_database.cursor()
            cursor.execute('''CREATE TABLE IF NOT EXISTS books (
                           ID INTEGER PRIMARY KEY AUTOINCREMENT,
                           title TEXT NOT NULL,
                           author TEXT NOT NULL,
                           price REAL NOT NULL,
                           amount INTEGER NOT NULL)''')
            conexion_database.commit()
            print(f'Created table successfully')
        except sqlite3.Error as e:
            print(f'Error creating table {e}')
        finally:
            conexion_database.close()



#***************************** CRUD Operations ********************************
#***************************** Add book **************************************
def add_book(title, author, price, amount):
    #******************* Establish conexion ******************************************
    conn = conexion_db()
    if conn:
        try:
            cursor = conn.cursor()
            sentence_sql = ''' INSERT INTO books (title, author, price, amount)
                                VALUES(?,?,?,?)'''
            data = (title, author, price, amount)
            cursor.execute(sentence_sql, data)
            conn.commit()
            print(f'Book added successfully {title}, {author}, {price}, {amount}')
        except sqlite3.Error as e:
            print(f'Error adding book {e}')
        finally:
            conn.close()

#********************************** Read *****************************************
def get_books():
    conn = conexion_db()
    if conn:
        try:
            cursor = conn.cursor()
            cursor.execute('SELECT * FROM books')
            books = cursor.fetchall()
            for book in books:
                print(f'ID: {book[0]} , title: {book[1]}, author: {book[2]} ,price: {book[3]}, amount: {book[4]}')
        except sqlite3.Error as e:
            print(f'Error getting books {e}')
        finally:
            conn.close()
#******************************* Get book for title or author********************************
def get_book_for_title_or_author(title_or_author):
    if not title_or_author.strip():#************* .strip() -> Delete Leading and trailing whitespaces ****  
        print(f'Search term cannont be empty')
        return
    conn = conexion_db()
    if conn:
        try:
            cursor = conn.cursor()
            cursor.execute(''' SELECT * FROM books WHERE title LIKE ? OR author LIKE ?''', ('%'+title_or_author+'%', '%'+title_or_author+'%' ))
            books= cursor.fetchall()
            if not books:
                print(f'No books found with title or author: {title_or_author}')
                return
            for book in books:
                print(f'ID: {book[0]}, title: {book[1]}, author: {book[2]}, price: {book[3]}, amount:  {book[4]} ')
        except sqlite3.Error as e:
            print(f'Error searching book, {e}')
        finally:
            conn.close()
#******************************** Update information about books ***************
def update_information(book_ID, field, new_value):
            if field not in ['title', 'author', 'price', 'amount']:
                print('Invalid field name')
                return
            
            #**** validate data type by price or amount ****************
            try:
                if field == 'price':
                    new_value = float(new_value)
                elif field == 'amount':
                    new_value = int(new_value)
            except ValueError:
                print(f' Invalid value for {field}. Ensure it is the correct type')
                return
            
            conn = conexion_db()
            if conn:
                try:
                    cursor = conn.cursor()
                    sql_query = (f''' UPDATE books
                                 SET {field} = ?
                                 WHERE ID = ?''')
                    cursor.execute(sql_query, (new_value, book_ID))
                    conn.commit()
                    if cursor.rowcount == 0:
                        print('Book not updated successfully')
                    else:
                        print(f'Book ID {book_ID}, updated successfully')
                except sqlite3.Error as e:
                    print(f"Error Update: {e}")
                finally:
                    conn.close()
#****************************** Delete information book ****************************
def delete_info_book(author=None, title=None):
    if not author or not title:
        print('You must provide an author and title to delete a book')
        return
    author, title = author.strip(), title.strip()
    #******************************* Dinamic Search ************************************
    
    sql_query =f"DELETE FROM books WHERE LOWER(author) = LOWER(?) AND LOWER(title) = LOWER(?)"
    conn = conexion_db()
    if conn:
        try:
            cursor = conn.cursor()
            cursor.execute(sql_query, (author.strip(), title.strip()))
            conn.commit()
            if cursor.rowcount == 0:
                print('Book not deleted successfully')
            else:
                print(f'{cursor.rowcount} book deleted successfully')
        except sqlite3.Error as e:
            print(f'An error occurred while deleting the book(s): {e}')
        finally:
            conn.close()