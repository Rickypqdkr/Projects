import tkinter as tk
from Functions import *

root = tk.Tk()
root.title('Calculator')

#********************* Entry and display ***********************************************
display = tk.Entry(root,font=('Arial',24),width=15, borderwidth=6, justify='right')
display.grid(row=0, column=0, columnspan=6, padx=12, pady=12)
set_display(display)

#******************************** Create Buttons ******************************
btn1 = tk.Button(root,text='1',width=6,height=6,command=button_1_clicked)
btn2 = tk.Button(root,text='2',width=6,height=6,command=button_2_clicked)
btn3 = tk.Button(root,text='3',width=6,height=6,command=button_3_clicked)

btn4 = tk.Button(root,text='4',width=6,height=6,command=button_4_clicked)
btn5 = tk.Button(root,text='5',width=6,height=6,command=button_5_clicked)
btn6 = tk.Button(root,text='6',width=6,height=6,command=button_6_clicked)

btn7 = tk.Button(root,text='7',width=6,height=6,command=button_7_clicked)
btn8 = tk.Button(root,text='8',width=6,height=6,command=button_8_clicked)
btn9 = tk.Button(root,text='9',width=6,height=6,command=button_9_clicked)

btn0 = tk.Button(root,text='0',width=6,height=6,command=button_0_clicked)
btn_point = tk.Button(root, text='.',width=6,height=6, command=button_point_clicked)

btn_add = tk.Button(root,text='+',width=6,height=6,command=button_add_clicked)
btn_sustractuib = tk.Button(root,text='-',width=6,height=6,command=button_substraction_clicked)
btn_multiplication = tk.Button(root,text='*',width=6,height=6,command=button_multiplication_clicked)
btn_div = tk.Button(root, text='/',width=6,height=6, command=button_div_clicked)
btn_equal = tk.Button(root,text='=',width=6,height=6, command=button_equal_clicked)

#****************** Btn Clear **********************************
btn_c = tk.Button(root,text='C',width=6,height=12,command= button_c)
btn_ac = tk.Button(root,text='AC',width=6,height=12,command=button_ac)


#******************** Grid ********************************************
btn1.grid(row=1, column=0) 
btn2.grid(row=1, column=1)
btn3.grid(row=1, column=2)

btn4.grid(row=2, column=0) 
btn5.grid(row=2, column=1)
btn6.grid(row=2, column=2)

btn7.grid(row=3, column=0) 
btn8.grid(row=3, column=1)
btn9.grid(row=3, column=2)
btn0.grid(row=4,column=0)

btn_point.grid(row=4,column=1)

btn_add.grid(row=1, column=3) 
btn_sustractuib.grid(row=2, column=3)
btn_multiplication.grid(row=3, column=3)
btn_div.grid(row=4,column=3)
btn_equal.grid(row=4,column=2)

# *************************** Btn Clear numbers *************************
btn_c.grid(row=1, column=5,rowspan=2)
btn_ac.grid(row=3, column=5, rowspan=2)

root.mainloop()

