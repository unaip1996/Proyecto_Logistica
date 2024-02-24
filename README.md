# Proyecto de Gestión Logística 


<h3>Introducción al proyecto</h3>

Este proyecto es un trabajo de universidad, ahora mismo el servicio de BD en AWS no está en funcionamiento, precisamente por eso, este proyecto se ha vuelto de visibilidad pública y las credenciales están expuestas.

Se pretende ampliar y darle mantenimiento como producto en un futuro.

Estas son las características desde las que partimos:

<h3>Funcionalidad</h3>

Tendremos 5 áreas funcionales o grandes bloques: Registro al sistema, operaciones, rutas, empaquetado y facturación. Si entramos en detalle con una breve descripción:

- Registro al sistema: Se deberá gestionar acciones CRUD de usuarios de acceso al sistema, esta gestión deberá estar asociada a unos roles que nos permitan tener una serie de permisos concretos.
- Operaciones: Se definirá las operaciones como elemento base, cada operación tendrá relacionada toda la información de ruta, empaquetado y facturación.
- Rutas (routing): En este bloque el usuario definirá el tipo de ruta (terrestre, marítima o aérea) cada una con un esquema de datos diferentes. Ejemplo: puertos origen y destino, nombre del expedidor, exportador o cargador (shipper), nombre del destinatario o receptor de la mercancía (consignee)…
- Empaquetado (packing): Esta sección se encargará de definir todo aquello relacionado con la mercancía. Ejemplo: número de contenedores relacionados, peso y tamaño del producto a transportar…
- Facturación (billing): En este apartado se llevará la lógica de la facturación a seguir, validaremos datos para poder generar facturas correctamente a partir de líneas pendientes a facturar.

A continuación, se va a detallar cada módulo comentado a grandes rasgos, el alumno deberá entrar en más detalle creando una solución funcionalmente correcta. Es interesante buscar vocabulario dentro del ámbito del transporte de mercancías para así, hablar con propiedad en la terminología empleada de campos.

En el registro del sistema, dar de alta a usuarios será una operación sólo disponible para usuarios Administradores. Los cuales tendrán un nombre/identificador (caracteres, mín. 1, máx. 10), clave (caracteres, mín. 4, máx. 8), tipo de usuario según roles, teléfono, y email.

Las operaciones son el elemento base, se crea una operación a realizar, se trata de movimiento de producto para gestionar su logística, de ella se relacionará toda la lógica de datos de rutas, empaquetado y facturación. La operación se puede considerar una unidad funcional cerrada.

Al crear una operación se debe asignar el tipo de ruta, a partir de este punto, la lógica y esquema de datos será diferente, igual que las diferentes interfaces a mostrar.

Las rutas describirán la trazabilidad de la mercancía entre 2 puntos del planeta, se gestionará tanto las fechas como lugares físicos origen destino. También existirá la posibilidad de que un contenedor cambie de medio de transporte en su trayectoria de entrega. Todo esto tiene que estar bien definido.

Tener en cuenta posibles imprevistos como retrasos. El empaquetado contendrá toda la información relativa al producto para su correcta gestión en todo el transporte. El módulo de facturación es el encargado de saber precio final de la operación, cada producto se puede relacionar con un concepto, que este a su vez tiene un coste definido. Se deberá abordar el IVA que irá relacionado al concepto a facturar. Ejemplo: concepto “freight” (sin impuestos).

<h3>Especificaciones</h3>
- Realizar un diagrama de clases del proyecto.
- Diagrama de casos de uso teniendo en cuenta lógica.
- Acciones según diferentes roles, (administrador, jefe de sección, operario…)
- Guardar mediante logs trazabilidad de operaciones.
- Valorar hacer integraciones con “sistema B”.
- Control de excepciones.
