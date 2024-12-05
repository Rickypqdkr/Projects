from data_base import create_table, add_book, get_books, get_book_for_title_or_author, update_information, delete_info_book

def menu():
    create_table()
    while True:
        print("********************* Menu ******************  \n")
        print("1. Add a new book")
        print("2. Search all books")
        print("3. Search books for author or title")
        print("4. Update information about some book")
        print("5. Delete book for author or title")
        print("0. Exit program")
        
        option = int(input("Select any option \n"))

        if option == 1:
            title = input("Book Title ")
            author = input("Book Author ")
            price = float(input("Book Price "))
            amount = int(input("Book Amount "))
            add_book(title, author, price, amount)
        elif option == 2:
            get_books()
        elif option == 3:
            title_author = input("Book Title or author ")
            get_book_for_title_or_author(title_author)
        elif option == 4:
            id_book = int(input("Enter ID book "))
            field = input("Enter field'll to change ")
            new_value = input("Enter new value ")
            update_information(id_book,field,new_value)
        elif option == 5:
            print("Enter book's author and book's title ")
            author, title = input("Enter the author "), input("Enter the book title ")
            delete_info_book(author, title)
        elif option == 0:
            print("Exit")
            break


            
if __name__ == '__main__':
    menu()
    