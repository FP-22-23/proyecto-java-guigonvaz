# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  \<22\>/\<23\>)
Autor/a: \<Guillermo González Vázquez\>   uvus:\<QGW9316\>

El dataset trata de series de en plataformas de streaming como netflix.


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.\<Serie\>**: Paquete que contiene los tipos del proyecto.
  * **fp.\<VideClub\>**: Paquete que contiene el contenedor de Serie.
  * **fp.\<FactoriaSerie\>**: Paquete que contiene las funciones de lectura de fichero.
  * **fp.\<Serie\>.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset o datasets del proyecto
    * **\<Datos.csv\>**: Añade una descripción genérica del dataset.
    
## Estructura del *dataset*

El dataset está compuesto por \<7\> columnas, con la siguiente descripción:

* **\<columna 1>**: de tipo \<String\>, representa el título de la serie
* **\<columna 2>**: de tipo \<Integer\>, representa el año en que salió la serie
* **\<columna 3>**: de tipo \<Stirng\>, representa la edad adecuada para ver la serie
* **\<columna 4>**: de tipo \<Double\>, representa la puntuacion que tiene la serie(sobre 10)
* **\<columna 5>**: de tipo \<Stirng\>, representa si la serie está disponible en Netflix
* **\<columna 6>**: de tipo \<Stirng\>, representa si la serie está disponible en Prime video
* **\<columna 7>**: de tipo \<LocalDate\>, representa la fecha de lanzamiento de la serie

## Tipos implementados

### Tipo Base
Descripción breve del tipo base.

**Propiedades**:

- titulo, de tipo \<String\>, consultable y modificable. 
- year, de tipo \<Integer\>, consultable y modificable. 
- edadRecomendada, de tipo \<String\>, consultable y modificable. 
- fEstreno, de tipo \<LocalDate\>, consultable y modificable. 
- nota, de tipo \<Double\>, consultable y modificable. 
- netflix, de tipo \<Boolean\>, consultable y modificable. 
- prime, de tipo \<Boolean\>, consultable y modificable. 
- series, de tipo \<List<String>\>, consultable y modificable. 
- 
**Constructores**: 

- C1: Constructor con todas las propiedades del tipo
- C2: Constructor con el titulo y la nota, pone a false netflix y prime
- ...

**Restricciones**:
 
- R1: El titulo no puede ser igual a null
- R2: La nota ha de ser mayor que 0.0 y menor que 10.0

**Criterio de igualdad**: Dos Series son iguales si su fecha de estreno, titulo, nota y año son las mismas

**Criterio de ordenación**: Se ordenan por el titulo y la fecha de estreno

**Otras operaciones**:
 
-	getTipoAge(): Nos devuelve un tipo Age del string de la edad recomendada.
- parseaBoolean( String s): Nos devuele un booleano según si el string es "Y" u otra cosa.
- toString(): Nos da una representación como cadena de la serie
- incorporaSerie(String s): Incorpora la serie a la lista


#### Tipos auxiliares
- SerieDeseada: Es un tipo que tiene como propiedades una nota y una valor de netflix. Se usa para compara si una serie es como queremos o no

### Factoría
Descripción breve de la factoría.

- \<String\>leeSerie: Lee un String que contiene una serie y devuelve una Serie
-	\<List<Serie>\>leeSeries : Lee un archivocsv y devuelve una lista con las Series en dicho archivo
- \<static\>parseaBoolean: Convierte una cadena en un boolean

### Tipo Contenedor

Es un VideoClub que contiene las siguientes cosa:

**Propiedades**:

- titulo, de tipo \<String\>, consultable y modificable 
- year, de tipo \<Integer\>, consultable y modificable. 
- nota, de tipo \<Double\>, consultable y modificable. 
- series, de tipo \<List<Serie>\> modificable.
**Constructores**: 

- C1: Usa todas las propiedades básicas (excepto la colección) y crea un objeto de tipo contenedor sin ningún elemento en la colección.
- C2: Usa todas las propiedades básicas y crea un objeto de tipo contenedor con todos los elementos de la colección
- C3: Recibe un stream de objetos del tipo base y crea un objeto del tipo contenedor con todos los elementos del stream

**Restricciones**:
 
- R1: El año tiene que ser >0.
- R2: El título ha de ser no nulo.
- ...
- 
**Criterio de igualdad**: Dos VideoClub son iguales si lo son sus títulos, years y notas

**Criterio de ordenación**: No hay.

**Otras operaciones**:
 
-	numeroSeries: Obtiene el número de series en la colección
- addSeries: Recibe una colección de elementos y los añade a series
- eliminarSerie: Recibe una serie y la elimina de series
- existeSerieBuscada: Recibe una serie como parámetro y nos dice si existe o no en series
- existeSerieBuscada2: Recibe una serie como parámetro y nos dice si existe o no en series

- notaMedia: Calcula la nota media de series
- notaMedia2: Calcula la nota media de series

- seleccionarSeriePorNota: Recibe como parámetro una nota y nos devuleve una lista de las series que tienen dicha nota
- seleccionarSeriePorNota2: Recibe como parámetro una nota y nos devuleve una lista de las series que tienen dicha nota

- agruparSeriesPorYear: Devuelve un Map donde las claves son los años y los valores una lista de series de ese año  
- agruparSeriesPorYear2: Devuelve un Map donde las claves son los años y los valores una lista de series de ese año  

- numSeriesPorNota: Devuelve un Map que da el número de series con x nota
- getSerieMasVieja: Nos devuelve la serie más vieja de series
- getNMejoresSeriesRecientesNetflix: Recibe como parámetro un número y nos devuelve una lista con las n series con mejor nota en los últimos años
- getTitulosPorNota: Devuelve un Map que tiene como claves las notas y sus valores son listas formadas por los títulos de las series con dicha nota
- getMejorSeriePorYear: Nos devuelve un Map con la serie con más nota por año
- numSeriesPorNotaOrdenadas: Agrupa las notas de forma ordenada y tiene como valores las veces que aparece la nota
- notaMasRepetida: Devuelve un Map con la nota que más veces se repite
