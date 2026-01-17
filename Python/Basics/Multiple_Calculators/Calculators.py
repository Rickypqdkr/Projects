import tkinter as tk
from Functions import *

root = tk.Tk()
root.title('Calculators')
root.geometry('450x510')


# ********************* Tittle *************************************
tittle_lebel = tk.Label(root, text= 'Calculators', font= ('Comic Sans MS',16))
tittle_lebel.pack(side='top',pady=(15,30))

if __name__ == '__main__':
    main_window(root)
    root.mainloop()

