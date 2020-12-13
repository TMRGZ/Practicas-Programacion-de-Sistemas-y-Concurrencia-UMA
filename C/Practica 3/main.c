#include <stdio.h>
#include "Cola.h"

unsigned k[4] = {128, 129, 130, 131};


void decrypt(unsigned int *v, unsigned int *k) {
    unsigned sum = 0xc6ef3720;
    const unsigned delta = 0x9e3779b9;

    for (int i = 0; i < 32; i++) {
        v[1] -= (((v[0] << 4) + k[2]) ^ (v[0] + sum) ^ ((v[0] >> 5) + k[3]));
        v[0] -= (((v[1] << 4) + k[0]) ^ (v[1] + sum) ^ ((v[1] >> 5) + k[1]));
        sum -= delta;
    }
}

void pruebaDecrypt() {
    unsigned v[2] = {0, 0};
    decrypt(v, k);
    printf("%u %u \n", v[0], v[1]);
}

void descifrarFichero(char *fentrada, char *fsalida) {
    FILE *fe = fopen(fentrada, "rb");
    FILE *fs = fopen(fsalida, "wb");
    unsigned tam;
    unsigned v[2];

    if (fe == NULL || fs == NULL) {
        perror("error");
    } else {
        fread(&tam, sizeof(unsigned), 1, fe);

        while (fread(v, sizeof(unsigned), 2, fe) == 2) {
            decrypt(v, k);

            if (tam >= 8) {
                fwrite(v, sizeof(unsigned), 2, fs);
                tam = tam - 8;
            } else if (tam > 0) {
                fwrite(v, sizeof(char), tam, fs);
            }
        }
        fclose(fe);
        fclose(fs);
    }
}

/*int leerFichero(char *nombre, Cola *cola)
{
	//devuelve el tama�o del fichero
	FILE *f = fopen(nombre, "r");

	while (true)
	{

	}

}*/

void escribirFichero(Cola *cola, int tam, char *nombre) {

}

int main() {
    //pruebaDecrypt();
    //descifrarFichero("crisantemoCifrado.cyf", "crisantemo.png");

    Cola cola;
    unsigned v1[2] = {0, 1};
    unsigned v2[2] = {2, 3};
    crear(&cola);
    insertar(&cola, &v1);
    insertar(&cola, &v2);
    recorrer(cola);
    destruir(&cola);

    return 0;
}