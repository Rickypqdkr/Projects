import tkinter as tk

def open_new_window():
    # Limpiar la ventana principal
    for widget in root.winfo_children():
        widget.destroy()

    # Colocar el mensaje en la ventana principal
    label = tk.Label(root, text='Hi open window successful', font=('Comic Sans MS', 18))
    label.pack()

    frame = tk.Frame(root)
    frame.pack()
    #******************************** Buttons ***********************************
    btn_1 = tk.Button(frame,text='1',width=3,height=3)
    btn_2 = tk.Button(frame,text='2',width=3,height=3)
    btn_4 = tk.Button(frame,text='4',width=3,height=3)
    btn_5 = tk.Button(frame,text='5',width=3,height=3)

    btn_return = tk.Button(frame, text=' <- ' , width=3, height=3, command= main_window)

    btn_1.grid(row=1,column=0)
    btn_2.grid(row=1,column=1)
    btn_4.grid(row=2,column=0)
    btn_5.grid(row=2,column=1)

    btn_return.grid(row=3,column=0)
#*************************** Input Value *******************************************
def input_value_fnc():
    for widget in root.winfo_children():
        widget.destroy()
    #***************** Input ***************************
    entry = tk.Entry(root)
    entry.pack()

    #**************************** Function for Button *******************************

    def btn_show_value_fnc():
        inp_value = entry.get()
        label_value.config(text=f'the value is {inp_value}',font=('Comic Sans MS',18))


    btn_value = tk.Button(root, text='Show Value', height=6,width=6, command=btn_show_value_fnc)
    btn_value.pack()

    label_value = tk.Label(root, text='')
    label_value.pack()
#****************************************** Input Value and multiply for two **************
def multiply_by_two_fnc():
    
    for widget in root.winfo_children():
        widget.destroy()

    #***************** Function multiplay ********************
    def multiply_value(event):
        value = entry.get()
        if value.isdigit():
            result = int(value)*2
            entry_result.delete(0, tk.END)
            entry_result.insert(0,str(result))
    #********************* Function sum **************************
    def sum_value(event):
        value = entry_result.get()
        if value.isdigit():
            result = int(value) + 2
            entry.delete(0,tk.END)
            entry.insert(0,str(result))
            

    entry = tk.Entry(root, width=9, font=('Comic Sans MS',18), borderwidth=2)
    entry.pack()
    entry.bind('<KeyRelease>',multiply_value)# ***** vincula la funcion con soltar una tecla
    
    entry_result= tk.Entry(root, width=9, font=('Comic Sans MS',18), borderwidth=2)
    entry_result.pack()
    entry_result.bind('<KeyRelease>', sum_value)
    


#************************** #* Main **********************************

def main_window ():
    for widget in root.winfo_children():
        widget.destroy()

    btn_open_W = tk.Button(root, text='Open Window', font=('Comic Sans MS', 18), command=open_new_window)
    btn_open_W.pack()

    #***************************** Input Value ********************************
    btn_input = tk.Button(root, text='Input Values',font=('Comic Sans MS',18), command= input_value_fnc)
    btn_input.pack()
    #************************** Multiply for two input value *****************************
    btn_multiply_two = tk.Button(root, text='Multiply two', font=('Comic Sans MS',18), command=multiply_by_two_fnc)
    btn_multiply_two.pack()

#**********************************************************************

root = tk.Tk()
root.title('Probe Open Window')
root.geometry('300x300')

if __name__ == '__main__':
    main_window()
    root.mainloop()