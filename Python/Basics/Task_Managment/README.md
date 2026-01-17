# Task Management System

Un sistema simple de gestión de tareas desarrollado en Python con interfaz gráfica usando Tkinter y SQLite para el almacenamiento de datos.

## Características

- Agregar: Añade tareas con detalles como título, descripción, hora y fecha.
- Eliminar tareas:Elimina tareas del sistema utilizando su título.
- Buscar:  Busca todas las tareas o una tarea específica por su título
- Interfaz gráfica intuitiva: Navega por las diferentes funcionalidades de manera visual.

## Requisitos previos

- Python 3.x
- Tkinter (incluido en Python)
- SQLite3 (incluido en Python)

## Instalación

1. Clona el repositorio en tu maquina local:
    git clone https://github.com/Rickypqdkr/Projects.git
    cd Projects/Python/Basics/Task_Managment

2. Crea y activa un entorno virtual:
    python -m venv env
    source env/bin/activate   # En Windows: env\Scripts\activate

3. Instala dependencias 
    pip install -r requirements.txt
    - Tkinter (incluido en Python)
    - SQLite3 (incluido en Python)

4. Ejecuta el programa

    python main_task_managment.py

## Estructura del proyecto

├── add_task_functions.py    # Funciones relacionadas con agregar tareas
├── delete_task_functions.py # Funciones relacionadas con eliminar tareas
├── search_task_functions.py # Funciones relacionadas con buscar tareas
├── data_base.py             # Configuración de la base de datos SQLite
├── main_menu.py             # Archivo principal de la interfaz gráfica
├── main_task_managment.py   # Entrada principal del programa
└── README.md                # Documentación del proyecto

## Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.


