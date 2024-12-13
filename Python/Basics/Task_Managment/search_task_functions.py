import tkinter as tk
import sqlite3
from tkinter import messagebox, ttk
from add_task_funcitons import clean_window
from data_base import conexion

#**************************** Function Search all Tasks ****************************
def search_allTasks_fnt():
    conn = conexion()
    if conn:
        try:
            cursor = conn. cursor()
            cursor.execute(''' SELECT * FROM tasks''')
            tasks = cursor.fetchall()
            if tasks:
                return tasks
                        
        except sqlite3.Error as e:
            print(f'Error, not found tasks {e}')
            messagebox.showerror('Error', 'Not found Tasks')
        finally:
            conn.close()
#***************************************** Display all Tasks ******************************
def display_allTasks_fnt(tasks):
    top = tk.Toplevel()
    top.title('All Tasks')
    top.geometry('600x400')
    #****************************** Create Tree view ****************************
    tree = ttk.Treeview(top, columns=('ID', 'Title', 'Description', 'Hour', 'Date'), show='headings')
    tree.heading('ID', text='ID')
    tree.heading('Title', text='Title')
    tree.heading('Description', text='Description')
    tree.heading('Hour', text='Hour')
    tree.heading('Date', text='Date')
    tree.column('ID', width=50)
    tree.column('Title', width=50)
    tree.column('Description', width=50)
    tree.column('Hour', width=50)
    tree.column('Date', width=50)
    tree.pack(fill='both', expand=True, pady=12)
    #************************************* Insert Data into treeview ****************************

    for task in tasks:
        tree.insert("", tk.END, values=task)
    
    #****************************** Close Button *************************************
    btn_close = tk.Button(top, text='Close', command=top.destroy)
    btn_close.pack(pady=10)

#********************************** Function any task *************************************
def any_task_funt(frame):
    #conn = conexion()
    #if conn:
    #    cursor = conn.cursor()
    clean_window(frame)
    frame_any_task = tk.Frame(frame)
    frame_any_task.pack()

    label_any_task = tk.Label(frame_any_task, text='Enter Title task', font=('Comic Sans MS',18))
    label_any_task.pack(side='top',pady=12)

    box_title_task = tk.Entry(frame_any_task,font=('Comic Sans MS',18), width=21)
    box_title_task.pack(pady=12)

    btn_search_any_task = tk.Button(frame_any_task, text='Search Task', font=('Comic Sans MS',18),
                                    command= lambda: btn_any_task_fnt(box_title_task))
    btn_search_any_task.pack(pady=12)

def btn_any_task_fnt(entry_title_widget):
    entry_title = entry_title_widget.get()
    if not entry_title:
        print("Error not Title task, please Enter title task")
        messagebox.showerror('Error ', 'Please enter title task')
    entry_title = entry_title.strip()
    #*********************************** Conexion ******************************
    conn = conexion()
    if conn:
        try:
            cursor = conn.cursor()
            sentence_sql = ''' SELECT * FROM tasks WHERE title LIKE ? '''
            data = (f'%{entry_title}%',)
            cursor.execute(sentence_sql, data)
            tasks = cursor.fetchall()
            if not tasks:
                messagebox.showerror('Not Found task', 'Not Found Task')
                return
            for task in tasks:
                print(f'Task Found')
                print(f'Title: {task[1]} -> Hour: {task[3]} -> Date: {task[4]}')
                messagebox.showinfo('Task', f'Task: {task[1]} - Hour: {task[3]} - Date: {task[4]}')
                entry_title_widget.delete(0,tk.END)
        except sqlite3.Error as e:
            print(f'Error executing command: {e}')
        finally:
            conn.close()



def search_all_tasks(root):
    clean_window(root)

    frame_search_taskes = tk.Frame(root)
    frame_search_taskes.pack()
   
    label_titleSearch_tasks = tk.Label(frame_search_taskes, text="Search  tasks", font=('Comic Sans MS',24))
    label_titleSearch_tasks.pack(side='top', pady=12)
    #************************  Some Task *******************************************
    btn_some_task = tk.Button(frame_search_taskes, text='Task', font=('Comic Sans MS',18),
                              command= lambda: any_task_funt(frame_search_taskes))
    btn_some_task.pack(pady=12)
 #********************************** All Tasks ************************************************************
    btn_searchAll_tasks = tk.Button(frame_search_taskes, text='Search all Tasks',
                                    font=('Comic Sans MS',18),
                                    command= lambda: display_allTasks_fnt(search_allTasks_fnt()))
    btn_searchAll_tasks.pack(side='top', pady=12)

    
    
