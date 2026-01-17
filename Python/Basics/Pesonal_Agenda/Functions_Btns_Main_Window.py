import tkinter as tk
from Functions_Btns_DataBase import *

def btn_return_fnt(root):
    clean_window(root)
    frame = tk.Frame(root)
    frame.pack()

    tittle_label = tk.Label(frame,text="Personal Agenda", font=('Comic Sans MS',18))
    tittle_label.pack(side='top',pady=12)
    #**************************************** Btns ********************************************************

    btn_new_contact = tk.Button(frame,text="New Contact",width=12,height=3,font=("Comic Sans MS",12), command= lambda: btn_new_contact_fnct(root) )
    btn_new_contact.pack(pady=12)

    btn_search = tk.Button(frame,text="Search",width=12,height=3,font=("Comic Sans MS",12),command= lambda: btn_search_fnct(root))
    btn_search.pack(pady=12)

    btn_delete = tk.Button(frame,text="Delete",width=12, height=3, font=("Comic Sans MS",12), command= lambda: btn_delete_fnct_main(root))
    btn_delete.pack(pady=12)

    root.mainloop()
   

def clean_window(root):
    for widget in root.winfo_children():
        widget.destroy()

def btn_new_contact_fnct(root):
    clean_window(root)
    label_name = tk.Label(root,text='Name', font=('Comic Sans MS',18))
    label_name.pack(side= 'top',pady=12)
    box_name = tk.Entry(root,font=('Comic Sans MS',18))
    box_name.pack(side= 'top',pady=12)

    label_last_name = tk.Label(root,text='Last Name', font=('Comic Sans MS',18))
    label_last_name.pack(side= 'top',pady=12)
    box_last_name = tk.Entry(root,font=('Comic Sans MS',18))
    box_last_name.pack(side= 'top',pady=12)

    label_phone = tk.Label(root,text='Phone', font=('Comic Sans MS',18))
    label_phone.pack(side= 'top',pady=12)
    box_phone = tk.Entry(root,font=('Comic Sans MS',18))
    box_phone.pack(side= 'top',pady=12)

    label_email = tk.Label(root,text='email', font=('Comic Sans MS',18))
    label_email.pack(side= 'top',pady=12)
    box_email = tk.Entry(root,font=('Comic Sans MS',18))
    box_email.pack(side= 'top',pady=12)

    #************************************ Btn Save ****************************************
    btn_save = tk.Button(root,text='Save', font=('Comic Sans MS',18),command= lambda entry_name = box_name, entry_last_name = box_last_name, entry_phone = box_phone, entry_email= box_email: btn_save_function(entry_name, entry_last_name, entry_phone, entry_email))
    btn_save.place(x=180,y=500)
    
    #********************************* Btn Return ********************************
    btn_return = tk.Button(root,text='<<<<<', font=('Comic Sans MS',18), command= lambda: btn_return_fnt(root))
    btn_return.place(x=300,y=500)


def btn_search_fnct(root):
    clean_window(root)
    label_search_contact = tk.Label(root, text= 'Search Contact', font=('Comic Sans MS',21))
    label_search_contact.pack(side= 'top', pady=12)

    label_name = tk.Label(root, text= 'Name', font=('Comic Sans MS',18))
    label_name.place(x=12,y=90)
    box_name = tk.Entry(root, font=('Comic Sans MS',18))
    box_name.place(x=126, y=90)

    label_phone = tk.Label(root, text= 'Phone', font=('Comic Sans MS',18))
    label_phone.place(x=12, y=180)
    box_phone = tk.Entry(root, font=('Comic Sans MS',18))
    box_phone.place(x=126, y=180)

    btn_search = tk.Button(root, text='Search', font=('Comic Sans MS',18), command= lambda entry_name= box_name, entry_phone= box_phone: btn_search_fnct_db(entry_name, entry_phone))
    btn_search.place(x=150, y=270)

    btn_return = tk.Button(root,text='<<<<<', font=('Comic Sans MS',18), command= lambda: btn_return_fnt(root))
    btn_return.place(x=300,y=270)

def btn_delete_fnct_main(root):
    clean_window(root)
    label_delete = tk.Label(root, text="Delete Contact", font=('Comic Sans MS',18))
    label_delete.pack(side='top',pady=12)
    

    label_name = tk.Label(root, text="Name", font=('Comic Sans MS',18))
    label_name.place(x=18,y=90)
    entry_name = tk.Entry(root, font=('Comic Sans MS',18))
    entry_name.place(x=180,y=90)

    label_last_name = tk.Label(root, text="Last Name", font=('Comic Sans MS',18))
    label_last_name.place(x=18,y=150)
    entry_last_name = tk.Entry(root, font=('Comic Sans MS',18))
    entry_last_name.place(x=180,y=150)

    label_phone_number = tk.Label(root, text="Phone", font=('Comic Sans MS',18))
    label_phone_number.place(x=18,y=210)
    entry_phone_number = tk.Entry(root, font=('Comic Sans MS',18))
    entry_phone_number.place(x=180,y=210)

    label_email = tk.Label(root, text="Email", font=('Comic Sans MS',18))
    label_email.place(x=18,y=270)
    entry_email = tk.Entry(root, font=('Comic Sans MS',18))
    entry_email.place(x=180,y=270)

    #//****************************** Buttons ****************************
    btn_return = tk.Button(root,text='<<<<<', font=('Comic Sans MS',18), command= lambda: btn_return_fnt(root))
    btn_return.place(x=330,y=330)

    btn_delete = tk.Button(root, text="Delete", font=('Comic Sans MS',18), command= lambda name= entry_name,last_name= entry_last_name, phone_number= entry_phone_number, email= entry_email: btn_delete_contact_db(name,last_name,phone_number,email))
    btn_delete.place(x=180,y=330)




