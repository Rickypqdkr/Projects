import tkinter as tk

def temp_f_fnc(event, entry_c, entry_f):
    value = entry_c.get()
    if value.isdigit():
        celcius = float(value)
        fahrenheit = round((celcius*1.8) +32,3)
        entry_f.delete(0,tk.END)
        entry_f.insert(0,str(fahrenheit))

def temp_c_fnc(event, entry_c, entry_f):
    value = entry_f.get()
    if value.isdigit():
        fahrenheit = float(value)
        celcius = round((fahrenheit -32)*(5/9),3)
        entry_c.delete(0,tk.END)
        entry_c.insert(0,str(celcius))