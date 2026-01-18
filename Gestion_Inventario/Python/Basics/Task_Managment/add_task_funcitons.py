import sqlite3
import tkinter as tk

from tkinter import messagebox
from datetime import datetime
from data_base import conexion


calendar_window = None
def clean_window(root):#****************** Clean Windows ********************************
    for widget in root.winfo_children():
        widget.destroy()

#****************************** Functions Add tasks ********************************
def add_task_btn(title_var, description_var, date_var, hour_var):
    if not title_var or not description_var or not date_var or not hour_var :
        messagebox.showerror('Validation Error',"Please fill all fields ")
        return
    var_title, var_description, var_date, var_hour = title_var.strip(), description_var.strip(), date_var.strip(), hour_var.strip()
    date, hour = date_fnt(var_date, var_hour)
    if date is None or hour is None:
        return
    
    #************************** Conexion Data Base ******************************************
    conn = conexion()
    if conn:
        try:
            cursor = conn.cursor()
            sentence_sql = '''INSERT INTO tasks (Title, Description, hour, Date)
                                VALUES(?,?,?,?)'''
            data = (var_title, var_description, hour, date)
            cursor.execute(sentence_sql, data)
            conn.commit()
            print("Add Task Successfully")
            messagebox.showinfo('Task Successfully', 'Add task Successfully')
        except sqlite3.Error as e:
            print(f'Error adding task: , {e}')
            messagebox.showerror('Error', 'Error adding task')
        finally:
            conn.close()



#********************************* Calendar Functions ********************************
def date_fnt(date_var, hour_var):
    try:
        var_date = datetime.strptime(date_var.strip(), '%Y-%m-%d').date()
        var_hour = datetime.strptime(hour_var.strip(), '%H:%M').time()
        formated_date = var_date.strftime('%Y-%m-%d')
        formated_hour = var_hour.strftime('%H:%M')
        return formated_date, formated_hour
    except ValueError as e:
        print(f'Validation Date Error {e}')
        messagebox.showerror('Error Format','Invalid Date and hour format ')
        return None, None
#******************************* Function Date **********************************
def add_task_frame(root):
    clean_window(root)
    label_title_add_task = tk.Label(root, text='Add Task', font=('Comic Sans MS',21))
    label_title_add_task.pack(side='top', pady=12)

    frame_add_task = tk.Frame(root)
    frame_add_task.pack(side='top', pady=12, padx=20, anchor='w')
    #****************************** Title ************************************************
    label_title_task = tk.Label(frame_add_task, text='Task Title', font=('Comic Sans MS',18))
    label_title_task.grid(column=0, row=3, pady= 12)

    box_title_task = tk.Entry(frame_add_task, font=('Comic Sans MS',18), width= 21)
    box_title_task.grid(column= 3, row= 3, padx=12)

    #*************************************** Descriptions ************************************************
    label_description_task = tk.Label(frame_add_task, text='Task description', font=('Comic Sans MS',18))
    label_description_task.grid(column= 0, row= 6, pady= 12)

    box_description_task = tk.Entry(frame_add_task, font=('Comic Sans MS',18), width= 21)
    box_description_task.grid(column= 3, row= 6, padx=12)
#
    #*************************************** Date *****************************************
    label_date_task= tk.Label(frame_add_task, text='Date (YYYY-MM-DD)', font=('Comic Sans MS',18))
    label_date_task.grid(column= 0, row= 12, pady=12)

    box_date_task = tk.Entry(frame_add_task, font=('Comic Sans MS',18), width=21)
    box_date_task.grid(column= 3, row= 12, padx=12)
    
    #************************************ Hour ******************************************
    label_hour_task= tk.Label(frame_add_task, text='HOUR (HH-MM)', font=('Comic Sans MS',18))
    label_hour_task.grid(column= 0, row= 15, pady=12)

    box_hour_task = tk.Entry(frame_add_task, font=('Comic Sans MS',18), width=21)
    box_hour_task.grid(column= 3, row= 15, padx=12)
    #******************************************** Button Add Task ********************************
    btn_add_task_title = tk.Button(frame_add_task, text='Add Task',
                                    font=('Comic Sans MS',12),
                                    command= lambda: add_task_btn(box_title_task.get(), 
                                                                  box_description_task.get(),
                                                                    box_date_task.get(),
                                                                    box_hour_task.get()))
    btn_add_task_title.grid(column= 3, row= 18, padx= 6)


    
    