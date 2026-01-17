import tkinter as tk
from Buttons_Functions_Arithmetic import *
from Functions_Calc_Temperature import *
#*************** Main Functions_Options **************************************************
def main_window (root):
    btn_Calculator = tk.Button(root, text='Calculator', width= 12 , height=3, font= ('Comic Sans MS', 12), command= lambda: show_arithmetic_calculator(root))
    btn_Calculator.pack(pady= 42)

    btn_Temperature = tk.Button(root, text='Temperature', width= 12 , height=3, font= ('Comic Sans MS', 12), command= lambda: show_temperature_calculator(root))
    btn_Temperature.pack(pady=18)
   

def clean_window(root):
    for widget in root.winfo_children():
        widget.destroy()


def show_arithmetic_calculator(root):

    clean_window(root)
    label = tk.Label(root, text='Calculator Arithmetic',font=('Cominc Sans MS',18))
    label.pack()

    #***************** Display ****************************************
    display = tk.Entry(root, font=('Comic Sans MS',27),width= 18, borderwidth=6, justify='right')
    set_display(display)
    display.pack()

    #******************************* Buttons *******************************
    frame_btns = tk.Frame(root)
    frame_btns.pack()

    btn_1 = tk.Button(frame_btns,text='1',width=6,height=6, command= btn_1_fnc)
    btn_2 = tk.Button(frame_btns,text='2',width=6,height=6, command= btn_2_fnc)
    btn_3 = tk.Button(frame_btns,text='3',width=6,height=6, command= btn_3_fnc)
#
    btn_4 = tk.Button(frame_btns,text='4',width=6,height=6, command=btn_4_fnc)
    btn_5 = tk.Button(frame_btns,text='5',width=6,height=6, command=btn_5_fnc)
    btn_6 = tk.Button(frame_btns,text='6',width=6,height=6, command=btn_6_fnc)

    btn_7 = tk.Button(frame_btns,text='7',width=6,height=6, command=btn_7_fnc)
    btn_8 = tk.Button(frame_btns,text='8',width=6,height=6, command=btn_8_fnc)
    btn_9 = tk.Button(frame_btns,text='9',width=6,height=6, command=btn_9_fnc)
    btn_0 = tk.Button(frame_btns,text='0',width=6,height=6, command=btn_0_fnc)

    btn_add = tk.Button(frame_btns,text='+',width=6,height=6, command=btn_add_fnc)
    btn_sub = tk.Button(frame_btns,text='-',width=6,height=6, command=btn_sub_fnc)
    btn_mult = tk.Button(frame_btns,text='*',width=6,height=6, command=btn_mult_fnc)
    btn_div = tk.Button(frame_btns,text='/',width=6,height=6, command=btn_div_fnc)
    
    btn_equal = tk.Button(frame_btns,text='=',width=6,height=6, command=btn_equal_fnc)
    btn_point = tk.Button(frame_btns,text='.',width=6,height=6, command=btn_point_fnc)

    btn_c = tk.Button(frame_btns,text='C',width=6,height=6, command=btn_c_fnc)
    btn_ac = tk.Button(frame_btns,text='AC',width=6,height=6, command=btn_ac_fnc)
##//////******************** Button Return and Function *************
    def btn_rtn_fnc(root):
        clean_window(root)
        main_window(root)
    btn_return = tk.Button(frame_btns, text='<<<', width=6,height=12, command= lambda: btn_rtn_fnc(root))

    btn_1.grid(row=1,column=0)
    btn_2.grid(row=1,column=1)
    btn_3.grid(row=1,column=2)

    btn_4.grid(row=2,column=0)
    btn_5.grid(row=2,column=1)
    btn_6.grid(row=2,column=2)

    btn_7.grid(row=3,column=0)
    btn_8.grid(row=3,column=1)
    btn_9.grid(row=3,column=2)
    btn_0.grid(row=4, column= 0)

    btn_add.grid(row=1,column=3)
    btn_sub.grid(row=2,column=3)
    btn_mult.grid(row=3,column=3)
    btn_div.grid(row=4,column=3)

    btn_equal.grid(row=4, column=1)
    btn_point.grid(row=4,column=2)

    btn_c.grid(row=3, column=4)
    btn_ac.grid(row=4,column=4)

    btn_return.grid(row=1,column=4, rowspan=2)
    
    
def show_temperature_calculator(root):
    clean_window(root)
    frame_tmp = tk.Frame()
    frame_tmp.pack()
    label_tmp = tk.Label(frame_tmp,text='Temperature', font=('Comic Sans MS', 18))
    label_tmp.pack(side='top', pady=(15,30))
    label_enter_tmp = tk.Label(frame_tmp, text='Enter the desired Temperature', font=('Comic Sans MS', 18))
    label_enter_tmp.pack()
    #************************** Grades °C *****************************************
    label_temp_c = tk.Label(frame_tmp, text='°C', font=('Comic Sans MS', 18))
    label_temp_c.pack(side='top') 
    #****************** Entry  °C******************************************************************
    box_temp_c = tk.Entry(frame_tmp,width=9,font=('Comic Sans MS', 18), borderwidth=3,border=3,relief='solid')
    box_temp_c.pack(pady=12)
    
    #************************** Grades °F *****************************************
    label_temp_f = tk.Label(frame_tmp, text='°F', font=('Comic Sans MS', 18))
    label_temp_f.pack(side='top') 
    #**************** Entry °F******************************************************
    box_temp_f = tk.Entry(frame_tmp,width=9,font=('Comic Sans MS', 18), borderwidth=3,border=3, relief='solid')
    box_temp_f.pack(pady=12)

    box_temp_c.bind('<KeyRelease>', lambda event,entry_c= box_temp_c,entry_f=box_temp_f:temp_f_fnc(event,entry_c,entry_f))
    box_temp_f.bind('<KeyRelease>',lambda event,entry_c= box_temp_c,entry_f=box_temp_f:temp_c_fnc(event,entry_c,entry_f))

    #************************* Button Return *******************************************
    ##//////******************** Button Return and Function *************
    def btn_rtn_fnc(root):
        clean_window(root)
        main_window(root)
    btn_return = tk.Button(frame_tmp, text='<<<', width=6,height=6, command= lambda: btn_rtn_fnc(root))
    btn_return.pack(side='bottom')
    
    
    

    
    