-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pessoa` (
  `nomeUsuario` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(20) NULL,
  `nome` VARCHAR(100) NULL,
  `email` VARCHAR(200) NULL,
  `senha` VARCHAR(50) NULL,
  PRIMARY KEY (`nomeUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EmpresaParceira`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`EmpresaParceira` (
  `nomeUsuario` VARCHAR(45) NOT NULL,
  `cnpj` VARCHAR(20) NULL,
  `razaoSocial` VARCHAR(200) NULL,
  `nomeFantasia` VARCHAR(200) NULL,
  `email` VARCHAR(200) NULL,
  `senha` VARCHAR(50) NULL,
  PRIMARY KEY (`nomeUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cupom`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cupom` (
  `idCupom` INT NOT NULL,
  `validade` DATE NULL,
  `isValid` TINYINT NULL,
  `valor` DOUBLE NULL,
  `descricao` VARCHAR(45) NULL,
  `EmpresaParceira_nomeUsuario` VARCHAR(45) NOT NULL,
  `Pessoa_nomeUsuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCupom`, `EmpresaParceira_nomeUsuario`, `Pessoa_nomeUsuario`),
  INDEX `fk_Cupom_EmpresaParceira1_idx` (`EmpresaParceira_nomeUsuario` ASC) VISIBLE,
  INDEX `fk_Cupom_Pessoa1_idx` (`Pessoa_nomeUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Cupom_EmpresaParceira1`
    FOREIGN KEY (`EmpresaParceira_nomeUsuario`)
    REFERENCES `mydb`.`EmpresaParceira` (`nomeUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cupom_Pessoa1`
    FOREIGN KEY (`Pessoa_nomeUsuario`)
    REFERENCES `mydb`.`Pessoa` (`nomeUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Produto` (
  `idProduto` INT NOT NULL,
  `estado` VARCHAR(45) NULL,
  `tipoProduto` VARCHAR(45) NULL,
  `descricao` VARCHAR(500) NULL,
  PRIMARY KEY (`idProduto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Publicacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Publicacao` (
  `idPublicacao` INT NOT NULL,
  `detalhes` VARCHAR(100) NULL,
  `data` VARCHAR(20) NULL,
  `privacidade` TINYINT NULL,
  `isDisponivel` TINYINT NULL,
  `tipoNegociacao` VARCHAR(45) NULL,
  `Produto_idProduto` INT NOT NULL,
  `Pessoa_nomeUsuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPublicacao`, `Produto_idProduto`, `Pessoa_nomeUsuario`),
  INDEX `fk_Publicacao_Produto1_idx` (`Produto_idProduto` ASC) VISIBLE,
  INDEX `fk_Publicacao_Pessoa1_idx` (`Pessoa_nomeUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Publicacao_Produto1`
    FOREIGN KEY (`Produto_idProduto`)
    REFERENCES `mydb`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Publicacao_Pessoa1`
    FOREIGN KEY (`Pessoa_nomeUsuario`)
    REFERENCES `mydb`.`Pessoa` (`nomeUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Proposta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Proposta` (
  `idProposta` INT NOT NULL,
  `data` VARCHAR(45) NULL,
  `tipoProposta` VARCHAR(45) NULL,
  `descricao` VARCHAR(500) NULL,
  `Publicacao_idPublicacao` INT NOT NULL,
  `Pessoa_nomeUsuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProposta`, `Publicacao_idPublicacao`, `Pessoa_nomeUsuario`),
  INDEX `fk_Proposta_Publicacao1_idx` (`Publicacao_idPublicacao` ASC) VISIBLE,
  INDEX `fk_Proposta_Pessoa1_idx` (`Pessoa_nomeUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Proposta_Publicacao1`
    FOREIGN KEY (`Publicacao_idPublicacao`)
    REFERENCES `mydb`.`Publicacao` (`idPublicacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Proposta_Pessoa1`
    FOREIGN KEY (`Pessoa_nomeUsuario`)
    REFERENCES `mydb`.`Pessoa` (`nomeUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Emprestimo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Emprestimo` (
  `idEmprestimo` INT NOT NULL,
  `dataDevolucao` DATE NULL,
  `Publicacao_idPublicacao` INT NOT NULL,
  PRIMARY KEY (`idEmprestimo`, `Publicacao_idPublicacao`),
  INDEX `fk_Emprestimo_Publicacao1_idx` (`Publicacao_idPublicacao` ASC) VISIBLE,
  CONSTRAINT `fk_Emprestimo_Publicacao1`
    FOREIGN KEY (`Publicacao_idPublicacao`)
    REFERENCES `mydb`.`Publicacao` (`idPublicacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Amizade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Amizade` (
  `Pessoa_nomeUsuario` VARCHAR(45) NOT NULL,
  `Pessoa_nomeUsuario1` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Pessoa_nomeUsuario`, `Pessoa_nomeUsuario1`),
  INDEX `fk_Pessoa_has_Pessoa_Pessoa2_idx` (`Pessoa_nomeUsuario1` ASC) VISIBLE,
  INDEX `fk_Pessoa_has_Pessoa_Pessoa1_idx` (`Pessoa_nomeUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Pessoa_has_Pessoa_Pessoa1`
    FOREIGN KEY (`Pessoa_nomeUsuario`)
    REFERENCES `mydb`.`Pessoa` (`nomeUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pessoa_has_Pessoa_Pessoa2`
    FOREIGN KEY (`Pessoa_nomeUsuario1`)
    REFERENCES `mydb`.`Pessoa` (`nomeUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`SolicitacoesAmizade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`SolicitacoesAmizade` (
  `Pessoa_nomeUsuario` VARCHAR(45) NOT NULL,
  `Pessoa_nomeUsuario1` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Pessoa_nomeUsuario`, `Pessoa_nomeUsuario1`),
  INDEX `fk_Pessoa_has_Pessoa_Pessoa2_idx` (`Pessoa_nomeUsuario1` ASC) VISIBLE,
  INDEX `fk_Pessoa_has_Pessoa_Pessoa1_idx` (`Pessoa_nomeUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Pessoa_has_Pessoa_Pessoa10`
    FOREIGN KEY (`Pessoa_nomeUsuario`)
    REFERENCES `mydb`.`Pessoa` (`nomeUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pessoa_has_Pessoa_Pessoa20`
    FOREIGN KEY (`Pessoa_nomeUsuario1`)
    REFERENCES `mydb`.`Pessoa` (`nomeUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

insert into pessoa (nomeUsuario,cpf,nome,email,senha) values ("ken123",123,"ken","ken123",123);
insert into pessoa (nomeUsuario,cpf,nome,email,senha) values ("jose123",1234,"ken1","ken12","123");

insert into produto (idProduto,estado,tipoProduto,descricao) values (0,0,0,0);
insert into publicacao (idPublicacao,detalhes,data,privacidade,isDisponivel,tiponegociacao,produto_idProduto,pessoa_nomeUsuario) values (0,1,1,1,1,"troca",0,"ken123");
insert into publicacao (idPublicacao,detalhes,data,privacidade,isDisponivel,tiponegociacao,produto_idProduto,pessoa_nomeUsuario) values (1,1,1,1,1,"troca",0,"ken123");

insert into amizade (Pessoa_nomeUsuario, Pessoa_nomeUsuario1) values ("ken123", "jose123");
insert into amizade (Pessoa_nomeUsuario, Pessoa_nomeUsuario1) values ("jose123", "ken123");

select * from amizade;

-- update publicacao set tipoNegociacao = "Troca" where idPublicacao = 1;
select * from publicacao;
select * from produto;


select * from proposta;


use mydb;
