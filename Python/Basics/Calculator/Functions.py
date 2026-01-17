import tkinter as tk

var_1, var_2,asw, operation = '','','',''
display_reference = None

def button_1_clicked():
    global var_1
    var_1 = var_1 + '1'
    update_display(var_1)
def button_2_clicked():
    global var_1
    var_1 = var_1 + '2'
    update_display(var_1)
def button_3_clicked():
    global var_1
    var_1 = var_1 + '3'
    update_display(var_1)

def button_4_clicked():
    global var_1
    var_1 = var_1 + '4'
    update_display(var_1)
def button_5_clicked():
    global var_1
    var_1 = var_1 + '5'
    update_display(var_1)
def button_6_clicked():
    global var_1
    var_1 = var_1 + '6'
    update_display(var_1)

def button_7_clicked():
    global var_1
    var_1 = var_1 + '7'
    update_display(var_1)
def button_8_clicked():
    global var_1
    var_1 = var_1 + '8'
    update_display(var_1)
def button_9_clicked():
    global var_1
    var_1 = var_1 + '9'
    update_display(var_1)

def button_0_clicked():
    global var_1
    var_1 = var_1 + '0'
    update_display(var_1)


def button_add_clicked():
    global operation, var_1,var_2
    operation ='+'
    var_2 = var_1
    var_1 = ''

def button_substraction_clicked():
    global operation, var_1, var_2
    operation ='-'
    var_2 = var_1
    var_1 = ''
    
def button_multiplication_clicked():
    global operation, var_1, var_2
    operation ='*'
    var_2 = var_1
    var_1 = ''

def button_div_clicked():
    global operation, var_1, var_2
    operation ='/'
    var_2 = var_1
    var_1 = ''

def button_point_clicked():
    global var_1
    if '.' not in var_1:
        var_1 += '.'
    update_display(var_1)
def button_equal_clicked():
    global var_1, var_2, asw, operation
    try:
        if operation == '+':
            asw = str(float(var_2)+ float(var_1))
            update_display(asw)
            #print(asw)
        elif operation == '-':
            asw = str(float(var_2) - float(var_1))
            update_display(asw)
            #print(asw)
        elif operation == '*':
            asw = str(float(var_2) * float(var_1))
            update_display(asw)
            #print(asw)
        elif operation == '/':
            asw = str(float(var_2) / float(var_1))
            update_display(asw)
            #print(asw)
    except ZeroDivisionError:
        asw = "Zero Division"
        update_display(asw)
    except ValueError:
        asw = " Vars Erros"
        update_display(asw)
    except Exception as e:
        asw = "Error"
        update_display(asw)

    var_1, var_2, asw = '','',''

#*************************** Display ****************************************
def set_display(display):
    global display_reference
    display_reference = display

def update_display(txt):
    display_reference.delete(0, tk.END)
    display_reference.insert(0,txt)


# ************************* Btn Clear **************************
def button_c():
    global var_1
    var_1 = var_1[:-1]
    update_display(var_1)

def button_ac():
    global var_1, var_2, asw, operation
    var_1, var_2,asw, operation = '','','',''
    update_display('')