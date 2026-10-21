# ¿Se recogen todos los valores?
No. La hebra escritora genera los valores del 0 al 99, pero el lector no los recoge todos. Por ejemplo, en una ejecución me salió `0` y después `99` repetido hasta completar las 100 lecturas, es decir, solo 2 valores distintos de los 100 generados. Además, cada ejecución da un resultado distinto (en otras me salió `0 0 99 99 ...` o incluso solo `99`).

## ¿Qué ocurre?
Las dos hebras trabajan a la vez sobre la misma variable sin ningún tipo de coordinación:

1. La hebra escritora solo hace una asignación (`v = i`) en cada vuelta, así que termina sus 100 `set` en microsegundos.
2. La hebra lectora en cada vuelta hace un `println`, que es muchísimo más lento que una asignación.
3. Cuando el lector vuelve a leer, el escritor ya ha terminado y `v` vale 99, así que todas las lecturas siguientes devuelven 99.

El `0` del principio probablemente ni siquiera es el 0 escrito por la hebra, sino el valor por defecto de `v`, porque el lector comienza antes que el escritor. El reparto de tiempo lo decide el planificador del sistema, por eso el resultado cambia en cada ejecución.

## ¿Cómo se soluciona?
Hay tres cambios, que están como comentario en el código:

1. En `HebraSet`, añadir `Thread.sleep(50)` después de cada `set`, para que el lector tenga tiempo de leer cada valor antes de que cambie.
2. En `HebraGet`, guardar el valor `anterior` y contar los `leidos`. Solo se imprime cuando el valor cambia, para no repetir lecturas, y el bucle termina cuando se han recogido 100 valores.
3. En `VariableCompartida`, declarar `v` como `volatile`. Sin esto, el lector no llega a ver los cambios del escritor.

Con los tres cambios se imprimen los 100 valores, del 0 al 99 y en orden.

Esta solución depende de la temporización: el `sleep` hace que sea muy difícil perder un valor, pero no lo garantiza. Para garantizarlo habría que sincronizar las hebras con `synchronized`, de forma que el escritor no escriba hasta que el lector haya leído el valor anterior.