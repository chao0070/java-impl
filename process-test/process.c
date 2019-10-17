#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
	FILE *fp;
	fp = fopen("process-log.txt", "a+");
	if (fp == NULL) {
		printf("Error in file opening\n");
		exit(1);
	}
	int count = 0;
	while (1) {
		count++;
		printf("Printing\n");
		fprintf(fp, "Writting into file at: %d\n", count);
		fflush(fp);
		sleep(2);
	}
	return 0;
}