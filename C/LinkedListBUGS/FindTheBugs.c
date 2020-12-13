#include "LinkedList.h"

void main()
{
	TList list;
	create(&list);
	insert(&list, 14);
	insert(&list, 16);
	insert(&list, 38);
	insert(&list, 215);
	show(list);
	insert(&list, 3007);
	show(list);
	delete(&list);
	show(list);
	delete(&list);
	delete(&list);
	show(list);
	destroy(&list);
	show(list);
}
