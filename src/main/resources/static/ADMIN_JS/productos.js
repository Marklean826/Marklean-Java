// Función para abrir el popup de crear producto
function abrirPopupCrearProducto() {
    document.getElementById("popupCrearProducto").style.display = "block";
}

// Función para cerrar el popup de crear producto
function cerrarPopupCrearProducto() {
    document.getElementById("popupCrearProducto").style.display = "none";
}

// Función para abrir el popup de agregar stock
function abrirPopupAgregarStock() {
    document.getElementById("popupAgregarStock").style.display = "block";
}

// Función para cerrar el popup de agregar stock
function cerrarPopupAgregarStock() {
    document.getElementById("popupAgregarStock").style.display = "none";
}

// Agregar eventos a los botones para abrir los popups
document.getElementById("nuevoProductoBtn").onclick = abrirPopupCrearProducto;
document.getElementById("agregarStockBtn").onclick = abrirPopupAgregarStock;

// Cerrar los popups al hacer clic fuera del contenido del popup
window.onclick = function(event) {
    const popupCrear = document.getElementById("popupCrearProducto");
    const popupAgregar = document.getElementById("popupAgregarStock");
    
    if (event.target === popupCrear) {
        cerrarPopupCrearProducto();
    }
    if (event.target === popupAgregar) {
        cerrarPopupAgregarStock();
    }
};

// Función para actualizar el stock
function actualizarStock(productId) {
    const cantidad = prompt("¿Cuántos productos deseas agregar al stock?");
    if (cantidad != null && !isNaN(cantidad) && cantidad > 0) {
        fetch(`/api/productos/${productId}/actualizar`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ cantidad: cantidad })
        })
        .then(response => response.json())
        .then(data => {
            alert('Stock actualizado correctamente');
            const stockCell = document.querySelector(`#producto-${productId} .stock`);
            stockCell.textContent = data.stock;
        })
        .catch(error => {
            alert('Error al actualizar el stock');
        });
    }
}

document.querySelector("#crearProductoForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Evita que el formulario se envíe de forma convencional

    const formData = new FormData(this);
    
    // Crear el objeto producto con los datos del formulario
    const producto = {
        nombre: formData.get('nombre'),
        categoria: formData.get('categoria'),
        tipo: formData.get('tipo'),
        estado: formData.get('estado'),
        precio: parseFloat(formData.get('precio')),  // Asegúrate de que 'precio' sea un número
        stock: parseInt(formData.get('stock'), 10)  // Asegúrate de que 'stock' sea un número entero
    };

    // Verifica si todos los campos del formulario están correctamente definidos
    console.log("Producto a crear: ", producto);

    // Enviar los datos al backend utilizando fetch
    fetch("/productos", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(producto)  // Convierte el objeto producto a JSON
    })
    .then(response => response.json())  // Espera una respuesta JSON
    .then(producto => {
        console.log("Producto creado correctamente: ", producto);  // Verifica la respuesta del servidor
        
        // Asegúrate de que el producto devuelto tiene los valores correctos, incluyendo el ID
        if (producto && producto.id) {
            // Añadir el nuevo producto a la tabla de productos
            const productosTableBody = document.querySelector("#productosExistentes tbody");
            const newRow = document.createElement("tr");
            newRow.id = `producto-${producto.id}`;
            newRow.innerHTML = `
                <td>${producto.id}</td>
                <td>${producto.nombre}</td>
                <td>${producto.categoria}</td>
                <td>${producto.tipo}</td>
                <td>${producto.estado}</td>
                <td>${producto.precio}</td>
                <td class="stock">${producto.stock}</td>
                <td>
                    <button onclick="eliminarProducto(${producto.id})">Eliminar</button>
                </td>
            `;
            productosTableBody.appendChild(newRow);

            // Cierra el formulario y limpia los campos
            cerrarPopupCrearProducto();
        } else {
            console.error("No se recibió un producto válido del servidor");
        }
    })
    .catch(error => {
        console.error("Error al crear el producto: ", error);
        alert("Hubo un problema al crear el producto. Intenta nuevamente.");
    });
});


// Función para eliminar un producto
function eliminarProducto(productId) {
    fetch(`/api/productos/${productId}`, {
        method: 'DELETE',
    })
    .then(response => {
        if (response.ok) {
            const row = document.querySelector(`#producto-${productId}`);
            row.remove();
        } else {
            throw new Error('Error al eliminar el producto');
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

// Función para buscar productos
function buscarProducto(event) {
    event.preventDefault();

    const nombreProducto = document.getElementById('nombreProducto').value;
    const estadoProducto = document.getElementById('estadoProducto').value;

    let query = `/productos/buscar?nombreProducto=${nombreProducto}`;
    if (estadoProducto && estadoProducto !== "") {
        query += `&estadoProducto=${estadoProducto}`;
    }

    fetch(query)
        .then(response => response.json())
        .then(productos => {
            const productosTableBody = document.getElementById("productosTableBody");
            productosTableBody.innerHTML = '';

            if (productos.length === 0) {
                productosTableBody.innerHTML = '<tr><td colspan="8">No se encontraron productos.</td></tr>';
            } else {
                productos.forEach(producto => {
                    const newRow = document.createElement("tr");
                    newRow.innerHTML = `
                        <td>${producto.id}</td>
                        <td>${producto.nombre}</td>
                        <td>${producto.categoria}</td>
                        <td>${producto.tipo}</td>
                        <td>${producto.estado}</td>
                        <td>${producto.precio}</td>
                        <td>${producto.stock}</td>
                        <td>
                            <button onclick="eliminarProducto(${producto.id})">Eliminar</button>
                        </td>
                    `;
                    productosTableBody.appendChild(newRow);
                });
            }

            document.getElementById('volverBtn').style.display = 'inline-block';
        })
        .catch(error => console.error('Error al buscar productos:', error));
}

// Función para volver a mostrar todos los productos
function mostrarTodosLosProductos() {
    fetch('/productos')
        .then(response => response.json())
        .then(productos => {
            const productosTableBody = document.getElementById("productosTableBody");
            productosTableBody.innerHTML = '';

            productos.forEach(producto => {
                const newRow = document.createElement("tr");
                newRow.innerHTML = `
                    <td>${producto.id}</td>
                    <td>${producto.nombre}</td>
                    <td>${producto.categoria}</td>
                    <td>${producto.tipo}</td>
                    <td>${producto.estado}</td>
                    <td>${producto.precio}</td>
                    <td>${producto.stock}</td>
                    <td>
                        <button onclick="eliminarProducto(${producto.id})">Eliminar</button>
                    </td>
                `;
                productosTableBody.appendChild(newRow);
            });

            document.getElementById('volverBtn').style.display = 'none';
        })
        .catch(error => console.error('Error al cargar productos:', error));
}

// Evento para el botón "Volver"
document.getElementById("volverBtn").onclick = mostrarTodosLosProductos;


// Función para abrir el popup de crear producto
function abrirPopupCrearProducto() {
    document.getElementById("popupCrearProducto").style.display = "block";
}

// Función para cerrar el popup de crear producto
function cerrarPopupCrearProducto() {
    document.getElementById("popupCrearProducto").style.display = "none";
}

// Función para agregar producto
document.querySelector("#crearProductoForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Evita que el formulario se envíe de forma convencional

    const formData = new FormData(this);
    
    // Crear el objeto producto con los datos del formulario
    const producto = {
        nombre: formData.get('nombre'),
        categoria: formData.get('categoria'),
        tipo: formData.get('tipo'),
        estado: formData.get('estado'),
        precio: parseFloat(formData.get('precio')),  // Asegúrate de que 'precio' sea un número
        stock: parseInt(formData.get('stock'), 10)  // Asegúrate de que 'stock' sea un número entero
    };

    // Enviar los datos al backend utilizando fetch
    fetch("/productos", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(producto)  // Convierte el objeto producto a JSON
    })
    .then(response => response.json())  // Espera una respuesta JSON
    .then(producto => {
        if (producto && producto.id) {
            // Añadir el nuevo producto a la tabla de productos
            const productosTableBody = document.querySelector("#productosExistentes tbody");
            const newRow = document.createElement("tr");
            newRow.id = `producto-${producto.id}`;
            newRow.innerHTML = `
                <td>${producto.id}</td>
                <td>${producto.nombre}</td>
                <td>${producto.categoria}</td>
                <td>${producto.tipo}</td>
                <td>${producto.estado}</td>
                <td>${producto.precio}</td>
                <td class="stock">${producto.stock}</td>
                <td>
                    <button onclick="eliminarProducto(${producto.id})">Eliminar</button>
                </td>
            `;
            productosTableBody.appendChild(newRow);
            cerrarPopupCrearProducto();
        } else {
            alert("Error al crear el producto.");
        }
    })
    .catch(error => {
        console.error("Error al crear el producto: ", error);
        alert("Hubo un problema al crear el producto. Intenta nuevamente.");
    });
});
