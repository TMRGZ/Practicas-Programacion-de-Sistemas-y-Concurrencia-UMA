/*
 * Complejos.h
 *
 *  Created on: 7 mar. 2018
 *      Author: mmar
 */

#ifndef COMPLEJOS_H_
#define COMPLEJOS_H_

struct Complejo{
	double preal,pimag;
};

int inicializar(struct Complejo *c);
void escribir(struct Complejo c);
int inicListaComplejos(struct Complejo *lista, int tam);
void escListaComplejos(struct Complejo lista[],int tam);

#endif /* COMPLEJOS_H_ */
