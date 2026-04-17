CREATE TABLE controle_recebimentos(
    id BIGSERIAL PRIMARY KEY,
    nome_empresa VARCHAR(100) NOT NULL,
    nome_transportadora VARCHAR(100) NOT NULL,
    tipo_carro VARCHAR(50) NOT NULL,
    notas_fiscais VARCHAR(200) NOT NULL,
    horario_marcado TIMESTAMP NOT NULL,
    horario_inicial TIMESTAMP NOT NULL,
    horario_de_finalizacao TIMESTAMP NOT NULL,
    observacoes VARCHAR(500)

);