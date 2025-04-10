CREATE TABLE "Lote"(
    "id" INTEGER NOT NULL,
    "dataEntrega" DATE NOT NULL,
    "observacao" VARCHAR(255) NOT NULL,
    "id_orgaoDonatario" INTEGER NOT NULL,
    "id_orgaoFiscalizador" INTEGER NOT NULL
);
ALTER TABLE
    "Lote" ADD PRIMARY KEY("id");
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
    "descricao" TEXT NOT NULL,
    "id_lote" INTEGER NOT NULL
);
ALTER TABLE
    "Produto" ADD PRIMARY KEY("codigo");
ALTER TABLE
    "Lote" ADD CONSTRAINT "lote_id_orgaofiscalizador_foreign" FOREIGN KEY("id_orgaoFiscalizador") REFERENCES "OrgaoFiscalizador"("id");
ALTER TABLE
    "Lote" ADD CONSTRAINT "lote_id_orgaodonatario_foreign" FOREIGN KEY("id_orgaoDonatario") REFERENCES "OrgaoDonatario"("id");
ALTER TABLE
    "Produto" ADD CONSTRAINT "produto_id_lote_foreign" FOREIGN KEY("id_lote") REFERENCES "Lote"("id");