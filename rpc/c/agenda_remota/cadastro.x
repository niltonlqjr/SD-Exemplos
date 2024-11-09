struct dados_contato{
    char nome[255];
    char telefone[32];
}

program agenda{
    version contato{
        int cadastra(dados_contato) = 1;
    } = 1;
} = 0x20000000;