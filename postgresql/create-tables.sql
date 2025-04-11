CREATE TABLE "lote"(
    "id" SERIAL NOT NULL,
    "data_entrega" DATE NOT NULL,
    "observacao" VARCHAR(255) NOT NULL,
    "id_orgaodonatario" INTEGER NOT NULL,
    "id_orgaofiscalizador" INTEGER NOT NULL
);
ALTER TABLE
    "lote" ADD PRIMARY KEY("id");
CREATE TABLE "orgaofiscalizador"(
    "id" SERIAL NOT NULL,
    "nome" VARCHAR(255) NOT NULL,
    "descricao" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "orgaofiscalizador" ADD PRIMARY KEY("id");
CREATE TABLE "orgaodonatario"(
    "id" SERIAL NOT NULL,
    "nome" VARCHAR(255) NOT NULL,
    "endereco" VARCHAR(255) NOT NULL,
    "telefone" VARCHAR(255) NOT NULL,
    "horario_funcionamento" VARCHAR(255) NOT NULL,
    "descricao" TEXT NOT NULL
);
ALTER TABLE
    "orgaodonatario" ADD PRIMARY KEY("id");
CREATE TABLE "produto"(
    "codigo" INTEGER NOT NULL,
    "nome" VARCHAR(255) NOT NULL,
    "descricao" TEXT NOT NULL,
    "id_lote" INTEGER
);
ALTER TABLE
    "produto" ADD PRIMARY KEY("codigo");
ALTER TABLE
    "lote" ADD CONSTRAINT "lote_id_orgaofiscalizador_foreign" FOREIGN KEY("id_orgaofiscalizador") REFERENCES "orgaofiscalizador"("id");
ALTER TABLE
    "lote" ADD CONSTRAINT "lote_id_orgaodonatario_foreign" FOREIGN KEY("id_orgaodonatario") REFERENCES "orgaodonatario"("id");