/*
 * Ejemplo.c
 *
 *  Created on: 7 mar. 2018
 *      Author: mmar
 */


#include <stdio.h>

void eliminar(char cadena[],char c){
	int i = 0,j;
	while (cadena[i]!=0){
		if (cadena[i] == c){
			/*j = i;
			while (cadena[j]!=0){
				cadena[j] = cadena[j+1];
				j++;
			}*/
			for (j=i; cadena[j]!=0;j++)
				cadena[j] = cadena[j+1];
		} else i++;
	}
}

void eliminar2(char cadena[],char c){
	int i=0,j=0;
	while (cadena[i]!='\0'){
		if (cadena[i]!=c){
			cadena[j] = cadena[i];
			j++;
		}
		i++;
	}
	cadena[j]='\0';
}
void intercambiar(int* ap,int* bp){
	//intercambiar los valores de a y b
	int aux = *ap;
	*ap = *bp;
	*bp = aux;
}

int main1(){
	char cadena[20] = "Hoooola Moondo";
	eliminar2(cadena,'o');
	printf("%s",cadena);
	return 0;
}
int main3(){
	int x = 8, y = 25;
	intercambiar(&x,&y);
	printf("x = %d, y = %d\n",x,y);
	return 0;
}


int  inicializar2(double comp[]){
	//comp[0]=2.2;
	//comp[1]=3.3;
	int v;
	printf("Introduce un numero complejo \n");
	v = scanf("%lf %lf", &comp[0],&comp[1]);
	return v;
}



double *inicializar3(double a, double b){
	double c[2]; //código modificado
	c[0]=a; c[1] = b; //Por qué no funciona?
	return c;
}


int main4(){
	double comp[2];
    inicializar2(comp);
    printf("(%.2lf,%.2lf)",comp[0],comp[1]);
	return 0;
}

int main5(){
	struct Complejo lista[20];
	int l;
	//inicializar(&c);
	//printf("(%.2lf,%.2lf)",c.preal,c.pimag);

	l = inicListaComplejos(lista,20);
	escListaComplejos(lista,l);
	return 0;
}


int main(){
	double *c = inicializar3(1,1);
	double *d = inicializar3(2,2);
	printf("%lf %lf",c[0],c[1]);
}
