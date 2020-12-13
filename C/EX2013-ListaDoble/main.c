#include "Lista.h"

int main(void) {
	T_Lista lista;
	crear(&lista);

	insertar(&lista, 1);
	insertar(&lista, 2);
	insertar(&lista, -1);
	insertar(&lista, 0);
	
	imprimir(lista, 0);
	imprimir(lista, 1);
	
	eliminar(&lista, 2);
	
	imprimir(lista, 0);
	imprimir(lista, 1);

	destruir(&lista);
	
	imprimir(lista, 0);
	imprimir(lista, 1);
	return EXIT_SUCCESS;
}