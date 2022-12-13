fx: newton.o dichotomy.o main.o
	gcc -o fx newton.o dichotomy.o main.o -g -lm 
newton.o: include/newton.c
	gcc -c -o newton.o include/newton.c -g
dichotomy.o: include/dichotomy.c
	gcc -c -o dichotomy.o include/dichotomy.c 
main.o: src/main.c
	gcc -c -o  main.o src/main.c -g
clean:
	rm  *.o
