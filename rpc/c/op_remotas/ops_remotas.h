/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#ifndef _OPS_REMOTAS_H_RPCGEN
#define _OPS_REMOTAS_H_RPCGEN

#include <rpc/rpc.h>


#ifdef __cplusplus
extern "C" {
#endif


#define operacoes 0x20000000
#define operacoes_ORIG 1

#if defined(__STDC__) || defined(__cplusplus)
#define sucessor 1
extern  int * sucessor_1(int *, CLIENT *);
extern  int * sucessor_1_svc(int *, struct svc_req *);
#define antecessor 2
extern  int * antecessor_1(int *, CLIENT *);
extern  int * antecessor_1_svc(int *, struct svc_req *);
#define quadrado 3
extern  int * quadrado_1(int *, CLIENT *);
extern  int * quadrado_1_svc(int *, struct svc_req *);
#define raiz 4
extern  double * raiz_1(int *, CLIENT *);
extern  double * raiz_1_svc(int *, struct svc_req *);
extern int operacoes_1_freeresult (SVCXPRT *, xdrproc_t, caddr_t);

#else /* K&R C */
#define sucessor 1
extern  int * sucessor_1();
extern  int * sucessor_1_svc();
#define antecessor 2
extern  int * antecessor_1();
extern  int * antecessor_1_svc();
#define quadrado 3
extern  int * quadrado_1();
extern  int * quadrado_1_svc();
#define raiz 4
extern  double * raiz_1();
extern  double * raiz_1_svc();
extern int operacoes_1_freeresult ();
#endif /* K&R C */

#ifdef __cplusplus
}
#endif

#endif /* !_OPS_REMOTAS_H_RPCGEN */