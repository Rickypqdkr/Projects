import tkinter as tk
from tkinter import messagebox
from tkinter import ttk
import sqlite3

def veiw_contact(contact):
    info_table = ttk.Treeview(columns=("Name", "Last Name", "Phone_number", "Email"))
    info_table.pack(pady=12)
    info_table.heading("#0", text="ID")
    info_table.heading("#0", text="Name")
    info_table.heading("#0", text="Last Name")
    info_table.heading("#0", text="Phone_number")
    info_table.heading("#0", text="Email")

    info_table.insert("", "end", values=   (contact[0], contact[1], contact[2], contact[3]))


def btn_save_function(entry_name, entry_last_name, entry_phone, entry_email):
    
    #****************************** Get information about new contact ****************************

    #****************************** Get data of entrys ****************************
    name = entry_name.get().strip()
    last_name = entry_last_name.get().strip()
    phone= entry_phone.get().strip()
    email = entry_email.get().strip()
    
    #********************************* Validate required fields ****************************
    if not name or not phone:
        tk.messagebox.showerror("Please enter a name and a phone number")
        return

    #**************************** Connect Data Base ********************************
    conn = sqlite3.connect('contacts.db')
    cursor = conn.cursor()

    #*************************** Insert Data in database ********************************
    cursor.execute(""" INSERT INTO contacts (name, last_name, phone_number, email)
                   VALUES (?,?,?,?) """, (name,last_name or None,phone, email or None))

    #********************* Save Changes ****************************************************
    conn.commit()
    conn.close()
    tk.messagebox.showinfo("Succesfully","You added a new contact")

    #************************************ Clean Entries ************************************************
    entry_name.delete(0,tk.END)
    entry_last_name.delete(0,tk.END)
    entry_phone.delete(0,tk.END)
    entry_email.delete(0,tk.END)

def btn_search_fnct_db(entry_name, entry_phone):
    name = entry_name.get().strip()
    phone = entry_phone.get().strip()

    #************************** Connect Database ************************************************

    if name or phone:
        conn = sqlite3.connect('contacts.db')
        cursor = conn.cursor()

        query = """SELECT * FROM contacts WHERE (name LIKE ? or ? IS NULL) AND (phone_number LIKE ? OR ? IS NULL)"""
        parameters = [f"%{name}%", name, f"%{phone}%", phone]

        cursor.execute(query,parameters)

        result = cursor.fetchall()

        if result :
            for contact in result :
               messagebox.showinfo("", f"name : {contact[1]}  lastname : {contact[2]}  phone : {contact[3]}  email : {contact[4]}")
            #contact = result[0]
            #veiw_contact(contact)
        else:
            messagebox.showinfo("", "Result not Found")

        conn.close()
    else:
        messagebox.showinfo("","You should Enter name or phone number by contact")

def btn_delete_contact_db(entry_name, entry_last_name, entry_phone_number ,entry_email):
    name = entry_name.get().strip()
    last_name = entry_last_name.get().strip()
    phone_number = entry_phone_number.get().strip()
    email = entry_email.get().strip()

    #if not name and not last_name and not phone_number and not email:
    #    messagebox.showerror("Error", " You must enter a field to delete the contact")
    if name or last_name or phone_number or email:
    
        conn = sqlite3.connect('contacts.db')
        cursor = conn.cursor()

        query = """DELETE FROM contacts WHERE(name LIKE ? AND last_name LIKE ? AND phone_number LIKE ? AND email LIKE ?)"""
        parameter_like = [f"%{name}%",f"%{last_name}%",f"%{phone_number}%",f"%{email}%"]
        #print(f'Finally Query: {query} , \n {parameter_like}')

        cursor.execute(query, parameter_like)

        messagebox.showinfo("Contact deleted", "Contact deleted")
        conn.commit()

        conn.close()
    else:
        messagebox.showerror("Error", " You must enter a field to delete the contact")

        
            

    
    


    






