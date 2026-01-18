import tkinter as tk
from add_task_funcitons import *
from search_task_functions import *
from delete_task_functions import *

def main_menu():
    root = tk.Tk()
    root.title("Tasks Managment") 
    root.geometry("540x600")

    frame = tk.Frame(root)
    frame.pack()

    title_label = tk.Label(frame, text="Task Manager", font=('Comic Sans MS',18))
    title_label.pack(side='top',pady=12)

    #****************************** Buttons ********************************

    btn_add_task = tk.Button(frame, text='Add Task', font=('Comic Sans MS',12), height= 3, width=27,
                             command= lambda: add_task_frame(root))
    btn_add_task.pack(pady=12)

    btn_search_task = tk.Button(frame, text='Search Task', font=('Comic Sans MS',18), height= 2, width=18,
                                command= lambda: search_all_tasks(root))
    btn_search_task.pack(pady= 12)

    btn_delete_task = tk.Button(frame, text='Delete Task', font=('Comic Sans MS',18), width= 18, height=2,
                                command= lambda: delete_task(root))
    btn_delete_task.pack(pady=12)


    root.mainloop()