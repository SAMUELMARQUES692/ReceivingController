-- 1. Adiciona a coluna sem restrições
ALTER TABLE controle_recebimentos
    ADD COLUMN ticket VARCHAR(50);

-- 2. Preenche os registros existentes com um valor temporário único
UPDATE controle_recebimentos
SET ticket = CONCAT('ticket_', id)
WHERE ticket IS NULL;

-- 3. Agora aplica o NOT NULL
ALTER TABLE controle_recebimentos
    ALTER COLUMN ticket SET NOT NULL;

-- 4. Adiciona a constraint de unicidade
ALTER TABLE controle_recebimentos
    ADD CONSTRAINT uk_ticket UNIQUE (ticket);