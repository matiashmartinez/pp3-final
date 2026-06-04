# Gestión de Servicio Técnico - SmartHard (PP3 Final)

Este proyecto consiste en el diseño e implementación de un sistema de escritorio para la **Gestión de Servicios Técnicos**, desarrollado como trabajo final para la materia **Práctica Profesionalizante III (2023)** de la Tecnicatura Superior en Análisis y Programación de Sistemas.

El software resuelve de manera integral las falencias organizativas del caso de estudio **SmartHard**, automatizando el registro de clientes, el control de órdenes de servicio y la emisión de reportes técnicos que previamente se manejaban de forma manual o en planillas de cálculo aisladas.

---

## 🚀 Características Principales

* **Autenticación y Roles:** Sistema de Login seguro para la protección de datos y restricción de funcionalidades avanzadas según el rol del usuario (Administrador/Técnico).
* **Gestión de Clientes (CRUD):** Alta, baja, modificación y filtrado dinámico de clientes con validaciones robustas en tiempo real (formatos de DNI, emails y teléfonos).
* **Control de Órdenes de Servicio:** Registro detallado de solicitudes de soporte (Servicio Técnico, Armado de Equipos, etc.), asignación de costos estimados, fechas de entrega y trazabilidad de estados (`Pendiente`, `Finalizado`, `Entregado`).
* **Generación de Reportes en PDF:** Automatización de documentos de entrega (RMA / Órdenes de Servicio) listos para impresión o envío por correo electrónico al cliente.
* **Manejo de Excepciones:** Arquitectura preparada para capturar errores de conexión y excepciones SQL, mostrando alertas visuales claras al usuario (ej. control de DNI duplicados).

---

## 🛠️ Tecnologías y Arquitectura

* **Lenguaje:** Java
* **Interfaz Gráfica:** JavaFX (diseño limpio y profesional adaptado a la experiencia de usuario).
* **Base de Datos:** MySQL (Modelo Relacional normalizado con restricciones de integridad y claves foráneas).
* **Patrón de Diseño:** **MVC (Modelo-Vista-Controlador)**, garantizando una separación clara entre la lógica de negocio, los datos y la interfaz de usuario.
* **Principios de Diseño:** Orientación a Objetos robusta, priorizando la composición sobre la herencia para un código más mantenible y escalable.

---

## 📋 Metodología de Desarrollo

El desarrollo se estructuró bajo metodologías ágiles (**SCRUM**), dividiendo el ciclo de vida del software en las siguientes fases documentadas:
1.  **Relevamiento e Historias de Usuario:** Definición del *Product Backlog* agrupado en Épicas organizadas por prioridades del negocio.
2.  **Modelado de Datos:** Diseño del diagrama de entidad-relación enfocado en la consistencia y escalabilidad.
3.  **Casos de Prueba:** Escenarios rigurosos con criterios de aceptación claros para asegurar la calidad del producto final (QA).

---

## Documentación adicional y capturas en /docs
---