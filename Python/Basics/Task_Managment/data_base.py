import sqlite3 

def conexion():
    try:
        conexion_db = sqlite3.connect('task_managment_db.db')
        return conexion_db
    except sqlite3.Error as e:
        print(f"Erro connecting to task_managment_db:  {e}")
        return None

def create_table():
    conn = conexion()
    if conn:
        try:
            cursor = conn.cursor()
            cursor.execute('''CREATE TABLE IF NOT EXISTS tasks (
                           ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                           Title TEXT NOT NULL,
                           Description TEXT NOT NULL,
                           hour DATATIME NOT NULL,
                           Date DATETIME NOT NULL)''')
            conn.commit()
            print("Created table successfully")
        except sqlite3.Error as e:
            print(f' Error creatint table in database: {e}')

        finally:
            conn.close()
