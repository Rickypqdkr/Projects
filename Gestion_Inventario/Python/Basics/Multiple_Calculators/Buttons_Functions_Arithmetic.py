import tkinter as tk

#******************************* Aritmetic Calculator **********************
var_1, var_2, asw, operations = '','','',''
display_reference = None

#********************** Buttons Functions ***********************

def btn_1_fnc():
    global var_1
    var_1 = var_1 + '1'
    update_display(var_1)

def btn_2_fnc():
    global var_1
    var_1 = var_1 + '2'
    update_display(var_1)

def btn_3_fnc():
    global var_1
    var_1 = var_1 + '3'
    update_display(var_1)

def btn_4_fnc():
    global var_1
    var_1 = var_1 + '4'
    update_display(var_1)

def btn_5_fnc():
    global var_1
    var_1 = var_1 + '5'
    update_display(var_1)

def btn_6_fnc():
    global var_1
    var_1 = var_1 + '6'
    update_display(var_1)

def btn_7_fnc():
    global var_1
    var_1 = var_1 + '7'
    update_display(var_1)

def btn_8_fnc():
    global var_1
    var_1 = var_1 + '8'
    update_display(var_1)

def btn_9_fnc():
    global var_1
    var_1 = var_1 + '9'
    update_display(var_1)

def btn_0_fnc():
    global var_1
    var_1 = var_1 + '0'
    update_display(var_1)

def btn_add_fnc():
    global var_1, var_2, operations
    operations = '+'
    var_2 = var_1
    var_1= ''
    
def btn_sub_fnc():
    global var_1, var_2, operations
    operations = '-'
    var_2 = var_1
    var_1= ''

def btn_mult_fnc():
    global var_1, var_2, operations
    operations = '*'
    var_2 = var_1
    var_1= ''

def btn_div_fnc():
    global var_1, var_2, operations
    operations = '/'
    var_2 = var_1
    var_1= ''

def btn_point_fnc():
    global  var_1
    var_1 += '.'
    update_display(var_1)

def btn_equal_fnc():
    global var_1,var_2, asw, operations
    try:
        if operations == '+':
            asw = str(float(var_2) +  float(var_1))
            update_display(asw)

        if operations == '-':
            asw = str(float(var_2) -  float(var_1))
            update_display(asw)

        if operations == '*':
            asw = str(float(var_2) *  float(var_1))
            update_display(asw)

        if operations == '/':
            asw = str(float(var_2) /  float(var_1))
            update_display(asw)

    except ZeroDivisionError:
        asw = 'Zero Division'
        update_display(asw)
    except Exception as e:
        asw = 'Error'
        update_display(asw)

    var_1,var_2,asw,operations= '','','',''

def btn_c_fnc():
    global  var_1
    var_1 = var_1[:-1]
    update_display(var_1)

def btn_ac_fnc():
    global  var_1,var_2,asw,operations
    var_1,var_2,asw,operations= '','','',''
    update_display('')

#*****************************  Display *********************************
def set_display(display):
    global display_reference
    display_reference = display
def update_display(txt):
    display_reference.delete(0,tk.END)
    display_reference.insert(0,txt)

