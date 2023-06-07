
# Pruebas de software

Los desarrolladores "ODIAMOS" las pruebas !!!!! 
A los desarrolladores NOS ENCANTAN LAS PRUEBAS !

# Para que sirven las pruebas?

- Para verificar el cumplimiento de unos requisitos
- Ayudarnos en el desarrollo de nuevo código. TDD, BDD, ATDD
- Para descubrir la mayor cantidad posible de fallos en el código antes de ponerlo en producción
  Una vez, detectado un fallo, habrá que identificar el DEFECTO que causa ese fallo (DEBUGGING, depuración).
  Si bien... el debugging no tiene que ver con el testing (es algo que se hace desde desarrollo)
  lo que me interesa es poder ser capaz de identificar ese DEFECTO lo más rápido posible:
    Recopilar toda la información disponible para ayudar en el proceso de debugging <<<
- Para descubrir la mayor cantidad posible de defectos en el código antes de ponerlo en producción. Revisión del producto por un ojo crítico, experto. -> SONARQUBE
    REQ1: El sistema debe ofrecer unos tiempos de respuesta aceptables para los usuarios.
    REQ1v2: El sistema debe ofrecer para tal operación un tiempo de respuesta inferior a 200ms.
    REQ1v3: El sistema, instalado en un entorno con tales características, al realizar una determinada secuencia de operaciones (que se especifique), y con una carga de trabajo X, debe ofrecer un tiempo de respuesta con un percentil 95 inferior a 200ms.
- Pero, las pruebas sirven para conseguir información que permita un análisis de causas raices, que permita identificar a su vez los errores que se están comentiendo para buscar acciones correctivas y preventivas que permitan evitar nuevos errores y por ende defecto y fallos en el futuro.
- Para ayudarnos a entender mejor el producto. > Aportar información al CORE de la empresa
- Ayudarnos en la gestión del proyecto y la toma de decisiones.
        El software funcionando es la MEDIDA principal de PROGRESO.

        La medida que vamos a usar a partir de ahora para ver el grado de avance de un proyecto (gestión) es "el software funcionando"
                            ||
                    software que funciona < Las pruebas son las que dicen que el software funciona

        Lo que usamos hoy en día para determinar el grado de avance de un proyecto son el número de pruebas SUPERADAS !

## Vocabulario que usamos en el mundo del testing

- Error     Los humanos somos los que cometemos errores
- Defecto   Al cometer un error, los humanos introducimos defectos en un producto
- Fallo     Llamamos fallo a la manifestación de un defecto... si bien NO TODO defecto tiene porque manifestarse en forma de FALLO.

## Metodologías ágiles

La principal característica es entregar el producto de forma incremental al cliente, favoreciendo un rápido feedback (retroalimentación)

- Dia 15 de un proyecto ya hay una versión en producción 100% funcional!
  Cuidado! Quizás solo entrego un 5% de la funcionalidad, pero 100% funcional!!
    Pruebas a nivel de producción! 5%
- Dia 30: +10%
    Pruebas a nivel de producción! 10% + 5%
- Dia 45: +5%
    Pruebas a nivel de producción! 5% + 10% + 5%
- Dia 60: +20%
    Pruebas a nivel de producción! 20% + 5% + 10% + 5%

Las pruebas al usar metodologías ágiles se me multiplican... Me crecen como enanos!!!
De dónde sale la pasta para ésto? NO HAY PASTA !!!!
Esto solo tiene una solución: AUTOMATIZACION: Necesitamos automatizar las pruebas!
Antes esto era una pijada que algunos frikis hacíamos... Hoy en día es una obligación. No hay otra!


## DEV-->OPS 

Quiero automatizar TODO Lo que hay entre el desarrollo y la operación de un sistema !!!!

Jenkins!, AzureDevops (TFS), Github Actions, GitlabCI/CD, Travis CI, Bamboo, TeamCity

- Integración Continua
- Entrega Continua
- Despliegue continuo

## Tipos de pruebas

Cualquier prueba se debe centrar en una UNICA CARACTERISICA de un componente/sistema...
Por qué una prueba se debe centrar en una sola característica?
    Si una prueba no se supera, es que tengo un fallo en el sistema / defecto.
    Si la prueba es dinámica -> Fallo (tendremos que averiguar el defecto)
        Para ayudarnos a identificar el defecto, será más sencillo, ssi la prueba solo prueba una característica... En ella tendremos el DEFECTO !
    Si la prueba es estática -> Defecto

Se clasifican de acuerdo a diferentes taxonomías:

### En base al nivel de la prueba

- Unitarias         Se centra en una característica de un COMPONENTE AISLADO del sistema !!!
                    A veces es facil hacer una prueba de un componente aislado...
                    Otras no... y aquí es donde entran LOS MOCKEADORES ! Mockito
                    Mockito y otras herramientas de mock, lo que nos permiten es AISLAR UN COMPONENTE para realizarle pruebas unitarias.

                    Si he realizado a todos los componentes de mi sistema pruebas unitarias y han ido bien, necesito hacer más pruebas? SI:

                        MOTOR       BIELA       RUEDA       FRENOS

- Integración       Se centra en la COMUNICACION entre componentes
                        MOTOR -> BIELA
                        BIELA -> RUEDA
                        FRENOS -> RUEDA

- Sistema(End2End)  Se centran el COMPORTAMIENTO  del sistema en su conjunto

- Aceptación        Las que me piden. Y habitualmente son un subconjunto de las anteriores.

Si he realizado todas las pruebas de aceptación y van bien... no hay necesidad de más pruebas... PERO ESTO ES TOTALMENTE INOPERATIVO Y DESACONSEJADO... Por qué?
1. Cúando puedo hacerlas? Cuando tengo el sistema en su conjunto... Y hasta entonces? no hago pruebas? 
2. Me ayudan a identificar el problema?  NO... 

### En base al procedimiento de ejecución de la prueba:

- Pruebas estáticas: Son las que no requieren poner el sistema en fuincionamiento
                        Sirven para identificar: DEFECTOS
- Pruebas dinámicas: Son las que SI requieren poner el sistema en fuincionamiento
                        Sirven para identificar: FALLOS

### En base al objeto de pruebas

- Pruebas funcionales
- Pruebas no funcionales:
  - Rendimiento
  - Carga
  - Estres
  - UX

### Pruebas de regresión

Básicamente es cualquier pruebas que VUELVO a ejecutar, oootra vez !

### En base al procedimiento de ejecución: 

- Automatizadas
- Manual

### En base al conocimiento que tengo del sistema/componente al desarrollar la pruebas

- Caja blanca -> Desarrolladores
- Caja negra  -> Tester

### JUNIT

Framework de automatización de pruebas, de todo tipo !

Hay 2 versiones hoy en día muy diferentes entre si:

        MAYOR de Junit
        v
- Junit 4 -> Solo se usa ya en proyectos legacy
- Junit 5 -> Este es el que se usa hoy en día ! NOMBRE EN CLAVE JUPITER

Junit5, es un framework MODULAR, es decir que tiene un montón de librerías (módulos)
Ese es un concepto que sale nuevo en Java9

    module < Nuevo en Java 1.9 (proyecto Jigsaw)
        package
            class
            interface


    module-info.java

    module {
        exports
        uses
        provides
        ...
    }

Pero adicionalmente en JUNIT 5 -> JUNIT Platform ENGINE:
Básicamente es un concentrador de pruebas... Me permite ejecutar, usando el framework de JUnit, pruebas de muchos tipos... y usando muchas otras herramientas:
- Microservicio: Springboot (Springboot test)
- Cucumber (BDD)

---

# Framework? vs librería?

Un framework puede contener 1 o varias librerías... pero impone una metodologñia de uso de las mismas.

Cuando hablamos de librería, nos referimos a una porciñón de código reutilizable, que puedo integrar de forma sencilla en mi desarrollo.
---

# Versiones de software

4.13.1

                    Cuándo se incrementan?

- MAJOR: 4          Cambios que no respetan retrocompatibilidad
                    Quitar cosas del código (funciones):
                        - Deprecated 
                        - Refactorización
- MINOR: 13         Nueva funcionalidad 
                    Funcionalidad marcada como obsoleta (@Depretacted)
                      Opcionalmente pueden venir arreglos de bugs
- PATCH: 1          Arreglo de un bug (fix)

--- 

Vamos a usar MAVEN

## Qué es maven?

Herramienta de AUTOMATIZACION ! GRADLE, SBT, MSBUILD DOTNET NUGGET, NPM, YARM, WEBPACK, POETRY
Me permiten estas herramientas automatizar tareas habituales des mi proyecto (en desarrollo de software)
- Gestionar dependencias
- Compilación
- Ejecución de las pruebas <<<<<
- Empaquetado (.jar, .war, .ear)
- Mandar mi código a Sonarqube
- Generar una imagen de contenedor con un miscervicio instalado realizado con Spring

### Maven me "impone" una determinada estructura de proyecto

proyecto/
    |- src
    |   |- main
    |   |   |- java         El código de mi proyecto
    |   |   |- resources    Archivos adicionales que necesite mi proyecto (configuraciones...)
    |   |   |- webapp
    |   |- test
    |       |- java         El código de los programas de pruebas que monto para probar
    |       |               el programa principal de mi proyecto
    |       |- resources    Archivos adicionales que necesiten mis programas de prueba
    |- pom.xml

### POM.XML

- Datos identificativos del proyecto para maven:
    - groupId           ID De un grupo de proyectos
    - artifactId        Este es el ID del proyecto dentro eso si de un grupo de proyecto
    - version
- Dependencias
- Plugins
    Maven no sabe hacer la O con un cantuto... todo lo hace a través de PLUGINS
    Por defecto viene con una docena de plugins preconfigurados:
        - compiler
        - resource
        - jar
        - surefire -> Ejecutar pruebas con  JUNIT
    A veces queremos añadir plugins nuevos: Arrancar un microservicio con sprongboot desde maven
                                            Mandar mi código a sonarqube
    A veces queremos cambiar la configuración de los plugins existentes (versión, comportamiento predefinido)

# Goals de maven

A maven le podemos pedir que ejecute tareas AUTOMATICAMENTE para evitar hacerlas nosotros a mano... A esas tareas le llamamos GOALS:
- compile       Compila lo que hay en src/main/java y deja el resultado en target/classes/
                También copia lo que hay en src/main/resources en target/classes/
     ^^
- test-compile  Compila lo que hay en src/test/java y deja el resultado en target/test-classes/
                También copia lo que hay en src/test/resources en target/test-classes/
     ^^
- test          Ejecuta a través del plugin surefire los programas de pruebas que existan en la 
                carpeta target/test-classes... y genera un informe con el resultado, que se 
                deja en la carpeta target/surefire-reports
     ^^
- package       Empaqueta lo que hay en target/classes en un archivo .jar, que deja en la 
                carpeta target/
- install       Copia el arfacto (.jar, .war) en mi carpeta .m2
                Eso permite que mi .jar pueda ser usado como DEPENDENCIA en  otros proyectos, dentro de mi máquina
- clean         Borra la carpeta target de mi proyecto
                Maven va realizando las tareas de forma incremental.
                    La primera vez compila el proyecto entero.
                    La segunda compila solo lo que haya cambiado... MEJOR RENDIMIENTO

#### CARPETA .m2

Como empieza por PUNTO el nombre de la carpeta eso significa que es OCULTO 
Se encuentra dentro de nuestra carpeta de usaurio.
En esa carpeta es donde maven va almacenando librerías para que otros proyectos puedan utilizarlas.
Cuando un proyecto tiene una dependencia, lo primero que hace maven es mirar si la tiene en esa carpeta... si no, la descarga de maven central (o el repo de artefactos que tengamos configurado en la empresa)


$ mvn clean install 

---
Me fio de las ejecuciones de las pruebas que hace un desarrollador en su máquina? NO
    Por qué? Su máquina está malea'
Me fio de las ejecuciones de las pruebas que hace un tester en su máquina? NO
    Por qué? Su máquina está malea'
Me fio de las ejecuciones de las pruebas que se hace en un entorno de pruebas precreado? POCO
    Hoy en día quiero entornos de pruebas de USAR y TIRAR !... porque según pasa el tiempo, se malean !

Y en esos entornos de pruebas (pre) precreados o generados adhoc con contenedores... tengo ahí el eclipse? o el springtool o el Intellij? NO....

Java + maven

---

API
 Colección  de Interfaces

TDD: Test Driven Development

---
Java 9, 10, 11.
Diccionarios en múltiples idiomas a los que podemos pedir palabras, significados, alternativas
        manana ? mañana, manzana, banana, ananá

    interface Diccionario {
        String getIdioma();
        boolean existe(String palabra);
        List<String> getSignificados(String palabra) throws NoSuchWordException;
            Y si la palabra no tiene significados, que devuelve esta función?
            - null          \
            - Lista vacia   / No es explicito el comportamiento de la función
                                    O miro el código (si es que lo tengo a mano)
                                    o miro la docu (si es que la han montado)
            - Exception NoSuchWordException. Si es explicita... pero hace uso de una Exception.. que es un recurso caro, que se plantea para otros escenarios.
        Optional<List<String>> getSignificados(String palabra) throws NoSuchWordException;
    }
    interface SuministradorDeDiccionarios {
        boolean tienesDiccionarioDe(String idioma);
        Optional<Diccionario> getDiccionario(idioma);
            Si no hay diccionario? 
             - null? Desde JAVA 1.8, una función NO PUEDE DEVOLVER NULL
                     Puede hacerlo según el lenguaje, pero está considerado una práctica HORRIBLE... de las peores cosas que puedo hacer en JAVA

                     Esto es una de esas "MIERDAS" que detecta el SONARQUBE.
                     De las más graves...
                     Por qué devolver null es una FATALMENTE HORRIBLE Y DESPRECIABLE PRACTICA?
    }

---
Es un fichero PEPINILLO: GHERKIN (que procesaremos con PEPINO (Cucumber)
Característica: SuministradorDeDiccionarios
    Escenario: Preguntar por un idioma que se de antemano que existe
            Dado un suministrador que tiene idioma "ES"
            Cuando le pregunto si tiene un diccionario de idioma "ES"
                boolean respuesta = suminsitrador.tienesDiccionarioDe("ES")
            Entonces me tiene que contestar que si
                respuesta == true
    Escenario: Preguntar por un idioma que se de antemano que no existe
            Dado un suministrador que no tiene idioma "ELFICO"
            Cuando le pregunto si tiene un diccionario de idioma "ELFICO"
                boolean respuesta = suminsitrador.tienesDiccionarioDe("ELFICO")
            Entonces me tiene que contestar que no
                respuesta == false
    Escenario: Solicitar un diccionario de un idioma que se de antemano se que no existe
            Dado un suministrador que no tiene idioma "ELFICO"
            Cuando le pido un diccionario de idioma "ELFICO"
                Optional<Diccionario> diccionario = suminsitrador.getDiccionario("ELFICO")
            Entonces no me tiene que devolver NADA
                diccionario.isEmpty()
    Escenario: Solicitar un diccionario de un idioma que se de antemano se que SI existe
            Dado un suministrador que tiene idioma "ES"
            Cuando le pido un diccionario de idioma "ES"
                Diccionario diccionario = suminsitrador.getDiccionario("ES")
            Entonces me tiene que devolver el diccionario de idioma "ES"
                diccionario.isPresent()
                diccionario.getIdioma().equals("ES")


Característica: Diccionario
    Esquema de Escenario: Preguntar a un diccionario de "ES" por una palabra que existe
            Dado que tengo un diccionario de idioma "ES"
            Cuando le pregunto si existe la palabra "<palabra>" 
                boolean respuesta = diccionarioEspanol.existe(palabra)
            Entonces me tiene que contestar que si
                respuesta == true    
        Ejemplos:
            | palabra |
            | manzana |
            | Manzana |
            | MANZANA |
    Escenario: Preguntar a un diccionario de "ES" por la palabra null
            Dado que tengo un diccionario de idioma "ES"
            Cuando le pregunto si existe la palabra null 
                boolean respuesta = diccionarioEspanol.existe(null)
            Entonces me tiene que contestar que no
                respuesta == false
            Alternativa: Entonces me tiene que lanzar un NullPointerException
    Escenario: Preguntar a un diccionario de "ES" por la palabra "manana"
            Dado que tengo un diccionario de idioma "ES"
            Cuando le pregunto si existe la palabra "manana" 
                boolean respuesta = diccionarioEspanol.existe("manana")
            Entonces me tiene que contestar que no
                respuesta == false




    interface Diccionario {
        String getIdioma();
        boolean existe(String palabra);
        Optional<List<String>> getSignificados(String palabra) throws NoSuchWordException;
    }

---

# Spring

Framework de Java para el desarrollo de aplicaciones

Nos ofrece inversión de control.

Para qué?, para poder realizar una sencilla inyección de dependencias.

Para qué? para conseguir inversión de dependencias.

# Inversion de dependencias

Si yo voy a usar desde una clase, otra clase, puede y suele, no importarme la implementación que se haya hecho de la clase... si no tan solo que ese objeto que voy autilizar tenga los métodos que me interesan... Que cumpla con un contrato (interfaz)


//import java.util.ArrayList; // Esta linea es el cancer de un proyecto

...

public void miFuncion(List<String> miLista){
    //List<String> miLista == new ArrayList<>();
                            /// He jodido la inversión de dependencias 

    miLista.size();
    miLista.get(5);
    miLista.indexOf("pepinillo");
    ...
}

# Inyección de dependencias

Patrón de diseño de software (OOP), por el que una clase no crea una instancia de un objeto... sino que le es suministrada

# Inversión de control

Patrón de diseño de software por el cual delego el control del flujo de ejecución de mi programa a un tercero.

main(){
    ... tarea 1
    ... tarea 2
    ... tarea 3
}

En nuestro caso, el control lo vamos a delegar a Spring, que es un framework de INVERSION DE CONTROL !

main(){
    Spring, encargate de ejecutar mi aplicación.
        Spring lo flipa? y dice? que aplicación tio? 
        Yo le daré a Spring la configuración de mi aplicación.
        Quiero una aplicación que tenga un servicio rest
        Quiero una aplciación que conecte con una BBDD y gestióne usuario... cositas
        Quiero
        Quiero
        quiero
}

La gracia, es que al ser Spring quien controla la ejecución, es Spring quien crea instancias de mis clases.
A spring puedo decirle que quiero una instancia de una clase.. pero que esa clase necesita en su contructor unos parametros.
Y Spring automaticamente inyectará esos valores, creando las instancias de otras clases que deba crear -> Inyección de dependencias.
Lo que me permitirá montar clases que respeten el principio de Inmversion de dependencias.




