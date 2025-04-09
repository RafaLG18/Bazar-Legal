CREATE TABLE "lote"(
    "id" INTEGER NOT NULL,
    "dataEntrega" DATE NOT NULL,
    "observacao" VARCHAR(255) NOT NULL,
    "id_orgaoDonatario" INTEGER NOT NULL,
    "id_orgaoFiscalizador" INTEGER NOT NULL,
    "id_produto" INTEGER NOT NULL
);
ALTER TABLE
    "lote" ADD PRIMARY KEY("id");
CREATE TABLE "OrgaoFiscalizador"(
    "id" INTEGER NOT NULL,
    "nome" VARCHAR(255) NOT NULL,
    "descricao" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "OrgaoFiscalizador" ADD PRIMARY KEY("id");
CREATE TABLE "OrgaoDonatario"(
    "id" INTEGER NOT NULL,
    "nome" VARCHAR(255) NOT NULL,
    "endereco" VARCHAR(255) NOT NULL,
    "telefone" VARCHAR(255) NOT NULL,
    "horarioFuncionamento" VARCHAR(255) NOT NULL,
    "descricao" TEXT NOT NULL
);
ALTER TABLE
    "OrgaoDonatario" ADD PRIMARY KEY("id");
CREATE TABLE "Produto"(
    "codigo" INTEGER NOT NULL,
    "nome" VARCHAR(255) NOT NULL,
    "descricao" TEXT NOT NULL
);
ALTER TABLE
    "Produto" ADD PRIMARY KEY("codigo");
ALTER TABLE
    "lote" ADD CONSTRAINT "lote_id_orgaodonatario_foreign" FOREIGN KEY("id_orgaoDonatario") REFERENCES "OrgaoDonatario"("id");
ALTER TABLE
    "lote" ADD CONSTRAINT "lote_id_orgaofiscalizador_foreign" FOREIGN KEY("id_orgaoFiscalizador") REFERENCES "OrgaoFiscalizador"("id");
ALTER TABLE
    "lote" ADD CONSTRAINT "lote_id_produto_foreign" FOREIGN KEY("id_produto") REFERENCES "Produto"("codigo");