#include "arbolbb.h"

int main2()
{
	T_Arbol arbol;
	Crear(&arbol);
	Mostrar(arbol);
	Insertar(&arbol, 5);
	Mostrar(arbol);
	Insertar(&arbol, 7);
	Mostrar(arbol);
	Insertar(&arbol, 2);
	Mostrar(arbol);
	Insertar(&arbol, 2);
	Mostrar(arbol);
	
	FILE *f = fopen("Test.txt", "w");
	Salvar(arbol, f);
	fclose(f);

	return 0;
}