/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#ifndef _PONTOS_H_RPCGEN
#define _PONTOS_H_RPCGEN

#include <rpc/rpc.h>


#ifdef __cplusplus
extern "C" {
#endif


struct ponto {
	double x;
	double y;
};
typedef struct ponto ponto;

struct dois_pontos {
	struct ponto p1;
	struct ponto p2;
};
typedef struct dois_pontos dois_pontos;

#define exemplo 1
#define exemplo_v1 1

#if defined(__STDC__) || defined(__cplusplus)
#define distancia 1
extern  double * distancia_1(dois_pontos *, CLIENT *);
extern  double * distancia_1_svc(dois_pontos *, struct svc_req *);
#define soma 2
extern  struct ponto * soma_1(dois_pontos *, CLIENT *);
extern  struct ponto * soma_1_svc(dois_pontos *, struct svc_req *);
extern int exemplo_1_freeresult (SVCXPRT *, xdrproc_t, caddr_t);

#else /* K&R C */
#define distancia 1
extern  double * distancia_1();
extern  double * distancia_1_svc();
#define soma 2
extern  struct ponto * soma_1();
extern  struct ponto * soma_1_svc();
extern int exemplo_1_freeresult ();
#endif /* K&R C */

/* the xdr functions */

#if defined(__STDC__) || defined(__cplusplus)
extern  bool_t xdr_ponto (XDR *, ponto*);
extern  bool_t xdr_dois_pontos (XDR *, dois_pontos*);

#else /* K&R C */
extern bool_t xdr_ponto ();
extern bool_t xdr_dois_pontos ();

#endif /* K&R C */

#ifdef __cplusplus
}
#endif

#endif /* !_PONTOS_H_RPCGEN */
