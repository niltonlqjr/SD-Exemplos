struct dados_soma{
    float a;
    float b;
};

program exemplo{
    version soma_remota{
        float soma(dados_soma) = 1;
    } = 1;
} = 0x11111;