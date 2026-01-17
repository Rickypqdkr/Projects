import tkinter as tk
import sqlite3

from add_task_funcitons import clean_window
from tkinter import messagebox
from main_menu import conexion

def delete_task(frame):
    clean_window(frame)
    #print('Deleteing task')
    frame_dalete = tk.Frame(frame)
    frame_dalete.pack()

    label_delete_task = tk.Label(frame_dalete, text='Enter Title of task to delete', font=('Comic Sans MS',18))
    label_delete_task.pack(pady=12)

    box_delete_task = tk.Entry(frame_dalete, font=('Comic Sans MS',18))
    box_delete_task.pack(pady=12)

    btn_delete_task = tk.Button(frame_dalete, text='DELETE', font=('Comic Sans MS',18), 
                                command= lambda: btn_delete_fnt(box_delete_task))
    btn_delete_task.pack(pady=12)

#******************************* Button Functions *******************************
def btn_delete_fnt(entry_titleBox_task):
    entry_title_task = entry_titleBox_task.get().strip()
    if not entry_title_task or entry_title_task.isspace():
        print('Please Enter title of task to delete')
        messagebox.showerror('Error', 'Enter title task to delete')
        return
    conn = conexion()
    if conn:
        try:
            cursor = conn.cursor()
            sentence_sql = '''DELETE FROM tasks WHERE LOWER(title) LIKE ?'''
            data = (f'%{entry_title_task}%', )
            cursor.execute(sentence_sql, data)
            conn.commit()
            if cursor.rowcount == 0:
                messagebox.showerror('Error', 'Task was not deleted')
            else:
                messagebox.showinfo('Delete task', f'Delete task{entry_title_task} Delete Successfully {cursor.rowcount} ')
                entry_titleBox_task.delete(0,tk.END)
        except sqlite3.Error as e:
            print (f'Errer deleteing task: {e}')
            messagebox.showerror('Error', f'An error occurred while deleting the task: {e}')
        finally:
            conn.close()
        

