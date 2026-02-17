### `Punto 1. Diagrama de Clases.`


<img width="791" height="744" alt="image" src="https://github.com/user-attachments/assets/ebd993e2-1aee-4d7a-b149-bb76732118cb" />


Punto 2. Ejemplo de SOA.
 Arquitectura elegida: SOA (Service-Oriented Architecture)

Ventajas
- Reutilizacion: los servicios se pueden usar en multiples aplicaciones.
- Interoperabilidad: permite integrar sistemas con tecnologias distintas.
- Escalabilidad: cada servicio puede escalarse de forma independiente.
- Mantenibilidad: cambios en un servicio afectan menos al resto del sistema.
- Alineacion con negocio: servicios se definen por capacidades del negocio.

Ejemplo sencillo
Un sistema de universidad expone servicios independientes:
- Servicio de Matricula: crea y consulta inscripciones.
- Servicio de Pagos: registra y valida pagos.
- Servicio de Notas: consulta calificaciones.

Cada aplicacion (portal web, app movil, sistemas internos) consume estos servicios via HTTP/REST. Si cambia el Servicio de Pagos, el resto del sistema sigue funcionando mientras la interfaz del servicio se mantenga.

Bibliografia
- Erl, T. (2005). Service-Oriented Architecture: Concepts, Technology, and Design. Prentice Hall.
- OASIS. (2006). Reference Model for Service Oriented Architecture 1.0. https://docs.oasis-open.org/soa-rm/v1.0/soa-rm.pdf
- IBM. (2023). What is SOA (Service-Oriented Architecture). https://www.ibm.com/topics/soa
