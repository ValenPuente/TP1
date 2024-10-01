import listas
import random    

def main():
    # 1° Pedimos log in al usuario:
    usuario = listas.ingresarUsuario() # para que el usuario sea válido, debe ser alfanumérico, mayor a 6 caracteres y menor a 12.
    print(f"\033[92m\nBienvenido {usuario.capitalize()}\n\033[0m")


    # 2° creo las listas necesarias para el programa:
    legajos = [] # lista paralela a las filas de la matriz
    meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"] # lista paralela a las columnas de la matriz
    matriz = [] # toda matriz empieza como una lista vacía
    
    # 3° Le pedimos al usuario que ingrese los números de Legajos válidos de 4 cifras que quiera, sin repetir:
    legajo = listas.cargarLegajos(legajos)
    while legajo != -1:
        legajos.append(legajo)
        matriz.append([random.randint(0,100) for _ in range(12)]) # creo la fila y las columnas correspondientes al legajo ingresado, y cargo las columnas de manera random. ¡Usamos listas por comprensión para ir creando la matriz!
        legajo = listas.cargarLegajos(legajos) # le damos la posibilidad de que cargue otro o -1 para finalizar.
    # Imprimos los legajos ingresados->
    if len(legajos) == 0:
        print("No se han ingresado legajos.")
    else:
        print("\nLos número de legajos ingresados fueron: ", end="")
        listas.imprimirLegajos(legajos)
              
        # 4° Calculamos las ventas totales de cada empleado en el año y quien fue el que más y menos ventas anuales tuvo:
        ventas_empleados = [0] * len(legajos) # Lista paralela a los legajos. Usamos esta lista como acumulador.
        # sumamos las ventas que hizo cada empleado, que sería sumar fila por fila.
        for f in range(len(matriz)):
            for c in range(12):
                ventas_empleados[f] = ventas_empleados[f] + matriz[f][c]
        
        # 5° Vemos que empleados tienen la posibilidad de acceder al bono:
        bonos = [] # lista paralela a la lista de legajos y a las filas de la matriz
        for ventas in ventas_empleados:
            if ventas >= 600:
                bonos.append("SÍ")
            else:
                bonos.append("NO")
                
        # 6° Imprimimos matriz de manera prolija
        listas.imprimirMatriz(matriz, legajos, meses, ventas_empleados, bonos)
        
        # 7° Informamos quienes son aquellos dos empleados que más y menos ventas tuvieron.
        print(f"\033[92m\nEl empleado que tuvo más ventas anuales fue {legajos[ventas_empleados.index(max(ventas_empleados))]} con un total de {max(ventas_empleados)} ventas\033[0m")
        # acá estoy buscando dentro de la lista legajos el índice que es equivalente al índice de la lista ventas donde se encuentra la mayor cantidad de ventas.
        print(f"\033[91mEl empleado que tuvo menor ventas anuales fue {legajos[ventas_empleados.index(min(ventas_empleados))]} con un total de {min(ventas_empleados)} ventas\033[0m")

        # 8° Informamos en una lista ascendente los meses que más ventas tuvieron.
        ventas_meses = [0] * 12 # usamos la lista como acumulador
        # sumamos las ventas de todos los meses, que sería sumar cada columna.
        for f in range(len(matriz)):
            for c in range(12): # ventas_meses es paralela a las columnas
                ventas_meses[c] += matriz[f][c]
        # para ordenar las dos listas paralelas, ventas_meses y meses, las junto en una sola lista y aplicamos el método sort.
        datos = list(zip(meses, ventas_meses))
        datos.sort(key = lambda x : x[1]) # tomamos como criterio de ordenamiento a la lista ventas_meses. USAMOS FUNCIÓN LAMBDA.
        print("\n", "\033[1mMESES CON SUS RESPECTIVO TOTAL DE VENTAS ORDENADO DE FORMA ASCENDENTE:\033[0m".center(162), "\n")

        listas.imprimirMeses(datos)

if __name__ == "__main__":
    main()