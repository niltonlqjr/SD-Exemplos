struct ponto{
    double x;
    double y;
};

struct dois_pontos{
    struct ponto p1;
    struct ponto p2;
};

program exemplo{
    version exemplo_v1{
        double distancia(dois_pontos) = 1;
        struct ponto soma(dois_pontos) = 2;
    } = 1;
} = 1;