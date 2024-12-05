# Store Books Database

Este proyecto es una aplicación simple para gestionar una base de datos de libros utilizando SQLite. Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre una tabla de libros.

## Requisitos

- Python 3.x
- SQLite3

## Instalación

1. Clona este repositorio

2. Asegúrate de tener Python y SQLite instalados en tu sistema.

### Crear la base de datos y la tabla

Ejecuta el script para crear la base de datos y la tabla de libros:

### Operaciones CRUD

- **Agregar un libro**: Usa la función `add_book(title, author, price, amount)`
- **Obtener todos los libros**: Usa la función `get_books()`
- **Buscar libros por título o autor**: Usa `get_book_for_title(title)` o `get_book_for_author(author)`
- **Actualizar información de un libro**: Usa `update_information(book_ID, field, new_value)`
- **Eliminar un libro**: Usa `delete_info_book(author, title)`

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o un pull request para discutir cualquier cambio que desees realizar.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.