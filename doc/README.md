# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  \<22\>/\<23\>)
Autor/a: \<Guillermo González Vázquez\>   uvus:\<QGW9316\>

El dataset trata de series de en plataformas de streaming como netflix.


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.\<Serie\>**: Paquete que contiene los tipos del proyecto.
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

**Criterio de ordenación**: Se ordenan por la fecha de esteno, la nota, el titulo y el año

**Otras operaciones**:
 
-	getTipoAge(): Nos devuelve un tipo Age del string de la edad recomendada.
- parseaBoolean( String s): Nos devuele un booleano según si el string es "Y" u otra cosa.
- toString(): Nos da una representación como cadena de la serie
- incorporaSerie(String s): Incorpora la serie a la lista


#### Tipos auxiliares
- SerieDeseada: Es un tipo que tiene como propiedades una nota y una valor de netflix. Se usa para compara si una serie es como queremos o no

### Factoría
Descripción breve de la factoría.

- _método 1_: Descripción del método 1.
-	_método 2_: Descripción del método 2.

### Tipo Contenedor

Descripción breve del tipo contenedor.

**Propiedades**:

- _propiedad1_, de tipo \<Tipo1\>, consultable. 
- _propiedad2_, de tipo \<Tipo2\>, consultable y modificable. 
- ...
- 
**Constructores**: 

- C1: Descripción del constructor 1.
- C2: Descripción del constructor 2.
- ...

**Restricciones**:
 
- R1: Descripción de la restricción 1.
- R2: Descripción de la restricción 2.
- ...
- 
**Criterio de igualdad**: Describir el criterio de igualdad

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay).

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...
