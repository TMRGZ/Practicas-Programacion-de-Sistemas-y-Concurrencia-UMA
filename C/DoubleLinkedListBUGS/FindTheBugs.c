#include <stdio.h>
#include <stdlib.h>
#include "LinkedList.h"

int main(int argc, char** argv) {
    TList list;
	create(&list);

    Add(&list, 6);
	Add(&list, 5);
	Add(&list, 3);
	Add(&list, 4);
	Add(&list, 2);
	Add(&list, 1);
	show(list);
    
	return 0;
}
