/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "pontos.h"
#include <math.h>
double *
distancia_1_svc(dois_pontos *argp, struct svc_req *rqstp)
{
	static double  result;

	struct ponto p,q;
	p = argp->p1;
	q = argp->p2;

	result = sqrt(pow(p.x-q.x,2) + pow(p.y-q.y,2));

	return &result;
}

struct ponto *
soma_1_svc(dois_pontos *argp, struct svc_req *rqstp)
{
	static struct ponto  result;
	struct ponto p,q;
	p = argp->p1;
	q = argp->p2;

	result.x = p.x+q.x;
	result.y = p.y+q.y;

	return &result;
}
