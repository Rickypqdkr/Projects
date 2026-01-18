import tkinter as tk
import sqlite3
from Functions_Btns_Main_Window import *

def database():
    conn = sqlite3.connect('contacts.db')
    cursor = conn.cursor()

    cursor.execute('''
                   CREATE TABLE IF NOT EXISTS contacts(
                    id INTEGER PRIMARY KEY,
                    name TEXT,
                    last_name TEXT,
                    phone_number TEXT,
                    email   text
                   )
                   ''')
    conn.commit()
    conn.close()

def main_window():

    root = tk.Tk()
    root.title("Personal Agenda")
    root.geometry('540x600')

    frame = tk.Frame(root)
    frame.pack()

    tittle_label = tk.Label(frame,text="Personal Agenda", font=('Comic Sans MS',18))
    tittle_label.pack(side='top',pady=12)
    #************************ Btns ************************

    btn_new_contact = tk.Button(frame,text="New Contact",width=12,height=3,font=("Comic Sans MS",12), command= lambda: btn_new_contact_fnct(root) )
    btn_new_contact.pack(pady=12)

    btn_search = tk.Button(frame,text="Search",width=12,height=3,font=("Comic Sans MS",12), command= lambda: btn_search_fnct(root))
    btn_search.pack(pady=12)

    btn_delete = tk.Button(frame,text="Delete",width=12, height=3, font=("Comic Sans MS",12), command= lambda: btn_delete_fnct_main(root))
    btn_delete.pack(pady=12)

    root.mainloop()


    