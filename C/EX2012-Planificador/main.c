#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "Planificador.h"

int main() {
	T_Planificador planificador;
	crear(&planificador);
	insertar_tarea(&planificador, 4, "t8");
	insertar_tarea(&planificador, 8, "t1");
	insertar_tarea(&planificador, 3, "t7");
	insertar_tarea(&planificador, 8, "t2");
	insertar_tarea(&planificador, 1, "t3");
	mostrar(planificador);
	planificar(&planificador);
	mostrar(planificador);
	int pru = 0;
	eliminar_tarea(&planificador, "t7", &pru);
	mostrar(planificador);
	destruir(&planificador);
	return 0;
}