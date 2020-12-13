/*
 * Complejos.c
 *
 *  Created on: 7 mar. 2018
 *      Author: mmar
 */

#include "Complejos.h"

int inicializar(struct Complejo *c)
{
	//c->preal = 2.0;//(*c).preal = 1.0;
	//c->pimag = 2.0; //(*c).pimag = 1.0;
	int v;
	printf("Introduce un numero complejo \n");
	v = scanf("%lf %lf", &(c->preal),&(c->pimag));
	return v;
}

int inicListaComplejos(struct Complejo *lista, int tam)
{
	int i=0;
	int fin = 0;
	int v;
	while (i<tam && !fin){
		v = inicializar(lista+i);
		if (v!=2) fin = 1;
		else i++;
	}
	return i;
}

void escribir(struct Complejo c)
{
	printf("(%.2lf,%.2lf) \n",c.preal,c.pimag);
}

void escListaComplejos(struct Complejo lista[],int tam)
{
	int i;
	for (i=0;i<tam; i++){
		escribir(lista[i]);
	}
}

int main()
{
	double *c = inicializar3(1, 1);
	double *d = inicializar3(2, 2);

	struct Complejo cc = inicializarComplejo(1.1, 2.2);


}
