package view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import model.Amizade;
import model.Cupom;
import model.EmpresaParceira;
import model.ExcecaoLogin;
import model.Pessoa;
import model.Produto;
import model.Proposta;
import model.Publicacao;
import model.SolicitacaoAmizade;
import dao.AmizadeDAO;
import dao.CupomDAO;
import dao.EmpresaParceiraDAO;
import dao.PessoaDAO;
import dao.ProdutoDAO;
import dao.PropostaDAO;
import dao.PublicacaoDAO;
import dao.SolicitacaoAmizadeDAO;

public class Index {

	public static void main(String[] args) throws ExcecaoLogin {

		Menu menu = new Menu();

		Scanner leitura = new Scanner(System.in);

		// Todas as pessoas cadastradas
		// ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

		// Todas as empresas cadastradas
		// ArrayList<EmpresaParceira> empresas = new ArrayList<EmpresaParceira>();

		// Todas as publica��es postadas
		// ArrayList<Publicacao> publicacoes = new ArrayList<Publicacao>();

		// Todos os cupons criados
		// ArrayList<Cupom> cupons = new ArrayList<Cupom>();

		// Amigos
		// ArrayList<Amizade> amizades = new ArrayList<Amizade>();

		// Solicita��es de Amizade
		// ArrayList<SolicitacaoAmizade> solicitacoes = new ArrayList<SolicitacaoAmizade>();

		// Vari�vel de controle para a pessoa atual logada
		Pessoa logadoPessoa = new Pessoa();

		// Var�avel de controle para a empresa parceira logada
		EmpresaParceira logadoEmp = new EmpresaParceira();

		// PS: S� uma empresa ou uma pessoa pode estar logada ao mesmo tempo

		// CADASTROS INICIAIS PARA TER DADOS J� REGISTRADOS

		// Criando objeto do tipo Pessoa
		Pessoa p1 = new Pessoa();
		PessoaDAO pDAO = new PessoaDAO();
		p1.setNome("Jos� Aparecido");
		p1.setCpf("241.241.241-241");
		p1.setNomeUsuario("jose123");
		p1.setEmail("aparecido.santos@gmail.com");
		p1.setSenha("123");

		// Salvando pessoa recem criada no ArrayList de pessoas cadastradas
		// pessoas.add(p1);

		// Salvando pessoa recem criada no BD de pessoas cadastradas
		// pDAO1.insere(p1);

		// Criando objeto do tipo Produto
		Produto prod = new Produto();

		// Criando objeto do tipo Publica��o
		Publicacao pub1 = new Publicacao();

		// Editando dados do objeto do tipo Publica��o
		pub1.setUsuario(p1);
		pub1.setData("25-09-2021");
		pub1.setTipoNegociacao("Troca");
		pub1.setDetalhes("Carro antigo, em estado degradante, por�m, �timo para retiradas de pe�as");

		// Editando dados do objeto do tipo Produto
		prod.setTipoProduto("Carro");
		prod.setDescricao("Gol 1989 - Sucata");
		prod.setEstado("Ruim");

		// Adicionando o produto recem criado na publica��o recem criada
		pub1.setProduto(prod);

		// Adicionando a publica��o recem criada no ArrayList que armazena todas as
		// publica��es do sistema
		// publicacoes.add(pub1);

		// Criando objeto do tipo Pessoa
		PessoaDAO pDAO2 = new PessoaDAO();
		Pessoa p2 = new Pessoa();
		p2.setNome("Victor Sheldon");
		p2.setCpf("241.241.241-241");
		p2.setNomeUsuario("sheldon123");
		p2.setEmail("sheldon@gmail.com");
		p2.setSenha("123");
		p2.getSolicitacoesAmizade().add(p1);

		// Salvando pessoa recem criada no ArrayList de pessoas cadastradas
		// pessoas.add(p2);

		// Salvando pessoa recem criada no BD de pessoas cadastradas
		// pDAO1.insere(p2);

		// Criando objeto do tipo Publica��o
		Publicacao pub2 = new Publicacao();

		// Criando objeto do tipo Produto
		Produto prod2 = new Produto();

		// Editando dados do objeto do tipo Publica��o
		pub2.setUsuario(p2);
		pub2.setData("25-09-2021");
		pub2.setTipoNegociacao("Doar");
		pub2.setDetalhes("Computador Gamer, antigo, com algumas pe�as para reaproveitar.");

		// Editando dados do objeto do tipo Produto
		prod2.setTipoProduto("Eletr�nico");
		prod2.setDescricao("Computador - Desktop");
		prod2.setEstado("Ruim");

		// Adicionando o produto recem criado na publica��o recem criada
		pub2.setProduto(prod2);

		// Adicionando a publica��o recem criada no ArrayList que armazena todas as
		// publica��es do sistema
		// publicacoes.add(pub2);

		// Criando objeto Proposta do Tipo DAO
		PropostaDAO propDAO = new PropostaDAO();

		// Criando objeto Produto do Tipo DAO
		ProdutoDAO prodDAO = new ProdutoDAO();

		// Criando objeto Publicacacao do Tipo DAO
		PublicacaoDAO pubDAO = new PublicacaoDAO();

		// Criando objeto Cupom do Tipo DAO
		CupomDAO cDAO = new CupomDAO();

		// Criando objeto Amizade do Tipo DAO
		AmizadeDAO amiDAO = new AmizadeDAO();

		// Criando objeto SolicitacaoAmizade do Tipo DAO
		SolicitacaoAmizadeDAO soliDAO = new SolicitacaoAmizadeDAO();

		// Criando objeto do tipo Empresa Parceira
		EmpresaParceira emp1 = new EmpresaParceira();
		EmpresaParceiraDAO empDAO = new EmpresaParceiraDAO();
		emp1.setNomeFantasia("Americanas");
		emp1.setRazaoSocial("B2W � Companhia Digital");
		emp1.setCnpj("41.798.949/0001-66");
		emp1.setNomeUsuario("ame123");
		emp1.setEmail("americanasCompre@gmail.com");
		emp1.setSenha("123");

		// Adicionando o objeto de empresa parceira, recem criada, no BD
		// empDAO.insere(emp1);

		// Adicionando o objeto de empresa parceira, recem criada, no arraylist que
		// armazena todas as empresas
		// empresas.add(emp1);

		// ------------ MENU INICIAL ------------

		int opcao = -1;

		// While parao programa ficar se repetindo at� o usu�rio apertar a op��o 0
		// (zero) do menu
		while (opcao != 0) {

			// -------------------------------------------- ATEN��O
			// --------------------------------------------
			// Verifica se h� uma pessoa logada (usando a variavel logadoPessoa)
			if (logadoPessoa.getNomeUsuario() != null) {
				// Caso tenha, chama o menu passando essa Pessoa (Para aparecer o nome dela em
				// "logado como x"
				menu.menuInicial(logadoPessoa);
			} else {
				// Caso n�o tenha nenhuma pessoa logada, envia a empresa logada (para tamb�m
				// aparecer "logado como x")
				// Caso n�o tenha nenhuma empresa logada, envia null como argumento (ningu�m
				// est� logado)
				menu.menuInicial(logadoEmp);
			}
			// A variavel opcao ir� armazenar a escolha do usu�rio para o menu previamente
			// exibido
			opcao = Integer.parseInt(leitura.nextLine());

			switch (opcao) {

			// Caso a pessoa tenha escolhido 1 no primeiro menu, ela vir� para "Cadastrar
			// novo usu�rio"
			case 1:
				// MENU CADASTRO DE NOVO USU�RIO

				int escolhaCad = -1;

				while (escolhaCad != 0) {

					menu.menuUsuario();
					leitura = new Scanner(System.in);
					escolhaCad = Integer.parseInt(leitura.nextLine());

					switch (escolhaCad) {
					case 1:

						// CADASTRO DE PESSOA

						String nome = new String();
						String cpf = new String();
						String nomeUsuario = new String();
						String email = new String();
						String senha = new String();

						Pessoa p = new Pessoa();

						System.out.print("Entre com um nome: ");
						nome = leitura.nextLine();

						System.out.print("Entre com um CPF: ");
						cpf = leitura.nextLine();
						while (verificaCadastroCPF(pDAO.consulta(), cpf) == false) {
							System.out.println("CPF j� cadastrado: ");
							System.out.print("Entre com um CPF: ");
							cpf = leitura.nextLine();
						}

						System.out.print("Entre com um nome de usu�rio: ");
						nomeUsuario = leitura.nextLine();
						while (verificaCadastroNomeUsuario(pDAO.consulta(), nomeUsuario) == false) {
							System.out.println("Nome de usu�rio j� cadastrado: ");
							System.out.print("Entre com um nome de usu�rio: ");
							nomeUsuario = leitura.nextLine();
						}

						System.out.print("Entre com um email: ");
						email = leitura.nextLine();
						System.out.print("Entre com uma senha: ");
						senha = leitura.nextLine();

						p.setNome(nome);
						p.setCpf(cpf);
						p.setNomeUsuario(nomeUsuario);
						p.setEmail(email);
						p.setSenha(senha);

						// INSERINDO PESSOA NO BD
						pDAO.insere(p);

						// pessoas.add(p);

						break; // FIM CADASTRO PESSOA

					case 2:

						// CADASTRO EMPRESA PARCEIRA

						EmpresaParceira emp = new EmpresaParceira();

						String nome1 = new String();
						String cnpj = new String();
						String razaoSocial = new String();
						String nomeUsuario1 = new String();
						String email1 = new String();
						String senha1 = new String();

						System.out.print("Entre com um nome: ");
						nome1 = leitura.nextLine();

						System.out.print("Entre com a raz�o social: ");
						razaoSocial = leitura.nextLine();

						System.out.print("Entre com um CNPJ: ");
						cnpj = leitura.nextLine();
						while (verificaCadastroCNPJ(empDAO.consulta(), cnpj) == false) {
							System.out.println("CNPJ j� cadastrado: ");
							System.out.print("Entre com um CNPJ: ");
							cnpj = leitura.nextLine();
						}

						System.out.print("Entre com um nome de usu�rio: ");
						nomeUsuario1 = leitura.nextLine();
						while (verificaCadastroNomeUsuario(nomeUsuario1, empDAO.consulta()) == false) {
							System.out.println("Nome de usu�rio j� cadastrado: ");
							System.out.print("Entre com um nome de usu�rio: ");
							nomeUsuario1 = leitura.nextLine();
						}

						System.out.print("Entre com um email: ");
						email1 = leitura.nextLine();
						System.out.print("Entre com uma senha: ");
						senha1 = leitura.nextLine();

						emp.setNomeFantasia(nome1);
						emp.setRazaoSocial(razaoSocial);
						emp.setCnpj(cnpj);
						emp.setNomeUsuario(nomeUsuario1);
						emp.setEmail(email1);
						emp.setSenha(senha1);

						// empresas.add(emp);

						empDAO.insere(emp);

						break; // FIM CADASTRO EMPRESA PARCEIRA
					}

				}

				break; // FIM CADASTRO DE USU�RIOS - OPCAO 1 MENU INICIAL

			// OPCAO 2 MENU PRINCIPAL - REALIZAR LOGIN
			case 2:

				int escolhaLogin = -1;

				menu.menuLogin();
				leitura = new Scanner(System.in);
				escolhaLogin = Integer.parseInt(leitura.nextLine());

				switch (escolhaLogin) {
				case 1:

					// LOGIN COMO PESSOA

					if (logadoPessoa.getNomeUsuario() == null && logadoEmp.getNomeUsuario() == null) {
						
						try {

							System.out.print("Entre com o nome de usu�rio:");
							String loginPessoa = leitura.nextLine();
							System.out.print("Entre com a senha:");
							String senhaPessoa = leitura.nextLine();

							/*
							 * for (Pessoa p : pessoas) { if (p.getNomeUsuario().equals(loginPessoa) &&
							 * p.getSenha().equals(senhaPessoa)) { logadoPessoa = p;
							 * System.out.println("Voc� est� logado na plataforma!"); cred = true; } }
							 */
							/*
							 * boolean cred = false;
							 * 
							 * for (Pessoa p : pDAO.consulta()) { if (p.getNomeUsuario().equals(loginPessoa)
							 * && p.getSenha().equals(senhaPessoa)) { logadoPessoa = p;
							 * System.out.println("Voc� est� logado na plataforma!"); cred = true; } }
							 * 
							 * System.out.println(); if (cred == false)
							 * System.out.println("Credenciais incorretas.");
							 */

							logadoPessoa = verificaCred(pDAO.consulta(), loginPessoa, senhaPessoa);

						} catch (ExcecaoLogin e) {

							System.out.println(e.getMessage());
						}

					} else {

						System.out.println();
						System.out.println("Um usu�rio j� est� conectado");

					}

					break; // FIM LOGIN COMO PESSOA

				case 2:

					// LOGIN COMO EMPRESA PARCEIRA

					if (logadoPessoa.getNomeUsuario() == null && logadoEmp.getNomeUsuario() == null) {

						try {
							System.out.print("Entre com o nome de usu�rio:");
							String loginEmp = leitura.nextLine();
							System.out.print("Entre com a senha:");
							String senhaEmp = leitura.nextLine();

							/*
							 * boolean cred = false;
							 * 
							 * for (EmpresaParceira emp : empDAO.consulta()) { if
							 * (emp.getNomeUsuario().equals(loginEmp) && emp.getSenha().equals(senhaEmp)) {
							 * logadoEmp = emp; System.out.println("Voc� est� logado na plataforma!"); cred
							 * = true; } }
							 * 
							 * System.out.println(); if (cred == false)
							 * System.out.println("Credenciais incorretas.");
							 */
							logadoEmp = verificaCred(loginEmp, senhaEmp, empDAO.consulta());
						} catch (ExcecaoLogin e) {
							System.out.println(e.getMessage());
						}

					} else {

						System.out.println();
						System.out.println("Um usu�rio j� est� conectado.");

					}

					break; // FIM LOGIN COMO EMPRESA PARCEIRA
				}

				break; // FIM OPCAO 2 MENU PRINCIPAL - REALIZAR LOGIN

			// OPCAO 3 MENU PRINCIPAL - PUBLICAR
			case 3:

				// MENU PUBLICA��ES

				int escolhaPubli = -1;
				menu.menuPublicacoes();

				leitura = new Scanner(System.in);
				escolhaPubli = Integer.parseInt(leitura.nextLine());

				switch (escolhaPubli) {

				// OPCAO 1 MENU PUBLICA��ES - PUBLICAR
				case 1:

					if (logadoPessoa.getNomeUsuario() != null) {

						int neg = 0;

						Publicacao pub = new Publicacao();

						Produto prod1 = new Produto();
						pub.setUsuario(logadoPessoa);
						pub.setNomeUsuario(pub.getUsuario().getNomeUsuario());
						pub.setData("2021-09-25");

						System.out.print("Entre com o ID do produto:");
						int idProduto = Integer.parseInt(leitura.nextLine());
						while (verificaIDProduto(idProduto, prodDAO.consulta()) == false) {
							System.out.println("ID j� cadastrado: ");
							System.out.print("Entre com o ID do produto: ");
							idProduto = Integer.parseInt(leitura.nextLine());
						}
						prod1.setIdProduto(idProduto);

						System.out.print("Entre com o tipo do produto:");
						prod1.setTipoProduto(leitura.nextLine());
						System.out.print("Entre com a descri��o:");
						prod1.setDescricao(leitura.nextLine());
						System.out.print("Entre com o estado do produto:");
						prod1.setEstado(leitura.nextLine());

						System.out.print("Entre com o ID da publica��o:");
						int idPublicacao = Integer.parseInt(leitura.nextLine());
						while (verificaIDPublicacao(idPublicacao, pubDAO.consulta()) == false) {
							System.out.println("ID j� cadastrado: ");
							System.out.print("Entre com o ID da publica��o: ");
							idPublicacao = Integer.parseInt(leitura.nextLine());
						}
						pub.setIdPublicacao(idPublicacao);

						menu.tiposNegociacao();
						neg = Integer.parseInt(leitura.nextLine());

						switch (neg) {
						case 1:
							pub.setTipoNegociacao("Troca");
							break;
						case 2:
							pub.setTipoNegociacao("Doa��o");
							break;
						case 3:
							pub.setTipoNegociacao("Empr�stimo");
							// pub.setPrivacidade(true); priva someste para amigos emprestar
							break;
						}

						System.out.println("Entre com alguns detalhes:");
						pub.setDetalhes(leitura.nextLine());

						pub.setProduto(prod1);
						pub.setIdProduto(pub.getProduto().getIdProduto());

						prodDAO.insere(prod1);

						// publicacoes.add(pub);
						pubDAO.insere(pub);

						System.out.println("\nPublica��o adicionada com sucesso!");

					} else {
						System.out.println();
						System.out.println("Voc� precisa estar logado na plataforma para publicar.");
					}

					break; // FIM OPCAO 1 MENU PUBLICA��ES - PUBLICAR

				// OPCAO 2 FEED MENU PUBLICA��ES
				case 2:

					int index = 0;
					int propor = -1;
					int codPubli = -1;

					if (logadoPessoa.getNomeUsuario() != null) {

						for (Publicacao p : pubDAO.consulta()) {

							if (p.isDisponivel() /* && p.isPrivacidade() == false */) {

								System.out.println(
										"------------------------------------------------------------------------");
								System.out.println();
								// System.out.println("C�digo Publica��o: " + index);
								System.out.println("C�digo Publica��o: " + p.getIdPublicacao());
								System.out.println("Nome Usu�rio: " + p.getNomeUsuario() + " Data: " + p.getData());
								System.out.println("Negocia��o Desejada: " + p.getTipoNegociacao());
								System.out.println(
										"Tipo Produto: " + prodDAO.consulta().get(p.getIdProduto()).getTipoProduto());
								System.out.println(
										"Estado Produto: " + prodDAO.consulta().get(p.getIdProduto()).getEstado());
								System.out.println("Descri��o Produto: "
										+ prodDAO.consulta().get(p.getIdProduto()).getDescricao());
								System.out.println("Detalhes: " + p.getDetalhes());
								System.out.println();
								System.out.println(
										"------------------------------------------------------------------------");

							} /*
								 * Privacidade para Amigos (EMPR�STIMO) REFATORAR else {
								 * 
								 * if (p.isPrivacidade() == true &&
								 * p.getUsuario().getAmigos().contains(logadoPessoa)) {
								 * 
								 * System.out.println(
								 * "------------------------------------------------------------------------");
								 * System.out.println(); //System.out.println("C�digo Publica��o: " + index);
								 * System.out.println("C�digo Publica��o: " + p.getIdPublicacao());
								 * System.out.println("Nome Usu�rio: " + p.getUsuario().getNomeUsuario() +
								 * " Data: " + p.getData()); System.out.println("Negocia��o Desejada: " +
								 * p.getTipoNegociacao()); System.out.println("Tipo Produto: " +
								 * p.getProduto().getTipoProduto()); System.out.println("Estado Produto: " +
								 * p.getProduto().getEstado()); System.out.println("Descri��o Produto: " +
								 * p.getProduto().getDescricao());
								 * System.out.println("Detalhes: "+p.getDetalhes()); System.out.println();
								 * System.out.println(
								 * "------------------------------------------------------------------------");
								 * } }
								 */
							// index++;
						}

						System.out.println(
								"Deseja realizar uma proposta? Digite 1 para sim ou qualquer N� p/ prosseguir: ");
						propor = Integer.parseInt(leitura.nextLine());

						if (propor == 1) {

							System.out.print("Entre com o c�digo da publica��o que deseja realizar proposta: ");
							codPubli = Integer.parseInt(leitura.nextLine());

							Proposta proposta = new Proposta();

							// proposta.setSolicitante(logadoPessoa);

							System.out.print("Entre com o ID da proposta: ");
							int idProposta = Integer.parseInt(leitura.nextLine());
							while (verificaIDProposta(idProposta, propDAO.consulta()) == false) {
								System.out.println("ID j� cadastrado: ");
								System.out.print("Entre com o ID da proposta: ");
								idProposta = Integer.parseInt(leitura.nextLine());
							}
							proposta.setIdProposta(idProposta);
							proposta.setData("25-09-2021");
							// proposta.setTipoProposta(publicacoes.get(codPubli).getTipoNegociacao());
							proposta.setTipoProposta(pubDAO.consulta().get(codPubli).getTipoNegociacao());
							// System.err.println("\nATEN��O! Essa publica��o s� aceita apenas negocia��es
							// do tipo: "+publicacoes.get(codPubli).getTipoNegociacao()+"\n");
							System.err.println("\nATEN��O! Essa publica��o s� aceita apenas negocia��es do tipo: "
									+ pubDAO.consulta().get(codPubli).getTipoNegociacao() + "\n");
							System.out.print("Entre com a descri��o do que deseja propor: ");
							proposta.setDescricao(leitura.nextLine());
							proposta.setPublicacao_idPublicacao(codPubli);
							proposta.setPessoa_nomeUsuario(logadoPessoa.getNomeUsuario());

							// publicacoes.get(codPubli).getPropostasRecebidas().add(proposta);

							propDAO.insere(proposta);

						}

					} else {
						System.out.println();
						System.out.println("Voc� precisa estar logado na plataforma.");
					}

					break; // FIM OPCAO 2 FEED MENU PUBLICA��ES

				// OPCAO 3 MINHAS PUBLICACOES MENU PUBLICA��ES
				case 3:

					index = 0;
					codPubli = -1;
					int codProp = 0;
					int aceitarProp = -1;
					boolean publiDisponivel = false;

					if (logadoPessoa.getNomeUsuario() != null) {
						System.out.println("Perfil: " + logadoPessoa.getNomeUsuario());
						for (Publicacao p : pubDAO.consulta()) {

							if (p.isDisponivel() && p.getNomeUsuario().equals(logadoPessoa.getNomeUsuario())) {
								System.out.println(
										"------------------------------------------------------------------------");
								System.out.println();
								// System.out.println("C�digo Publica��o: " + index);
								System.out.println("C�digo Publica��o: " + p.getIdPublicacao());
								System.out.println("Nome Usu�rio: " + p.getNomeUsuario() + " Data: " + p.getData());
								System.out.println("Negocia��o Desejada: " + p.getTipoNegociacao());
								System.out.println(
										"Tipo Produto: " + prodDAO.consulta().get(p.getIdProduto()).getTipoProduto());
								System.out.println(
										"Estado Produto: " + prodDAO.consulta().get(p.getIdProduto()).getEstado());
								System.out.println("Descri��o Produto: "
										+ prodDAO.consulta().get(p.getIdProduto()).getDescricao());
								System.out.println("Detalhes: " + p.getDetalhes());
								System.out.println();
								System.out.println(
										"------------------------------------------------------------------------");
								publiDisponivel = true;
							}
							// index++;
						}
						// caso usu�rio n�o tiver nenhuma publica��o disponivel ele n�o ir� apresentar
						// nada, portanto n�o apresenta as propostas
						/*
						 * if (publiDisponivel == false) { break; }
						 */

						System.out.println("""
								O que voc� deseja?
								1. Propostas de uma publica��o
								2. Editar uma publica��o
								3. Excluir uma publica��o
								(Ou digite qualquer n�mero para prosseguir)""");
						int opcaoMinhasPubli = Integer.parseInt(leitura.nextLine());

						switch (opcaoMinhasPubli) {
						// OPCAO 1 - VER PROPOSTAS - MINHAS PUBLICACOES
						case 1:

							System.out.print("Entre com o c�digo da publica��o que deseja ver propostas: ");
							codPubli = Integer.parseInt(leitura.nextLine());

							/*
							 * for (Proposta prop : publicacoes.get(codPubli).getPropostasRecebidas()) {
							 * 
							 * if (publicacoes.get(codPubli).getUsuario().equals(logadoPessoa)) {
							 * 
							 * System.out.println(
							 * "------------------------------------------------------------------------");
							 * System.out.println(); System.out.println("C�digo Proposta: " + codProp);
							 * System.out.println("Data: " + prop.getData()); System.out
							 * .println("Usu�rio solicitante: " + prop.getSolicitante().getNomeUsuario());
							 * System.out.println("Negocia��o: " + prop.getTipoProposta());
							 * System.out.println("Descri��o: " + prop.getDescricao());
							 * System.out.println(); System.out.println(
							 * "------------------------------------------------------------------------");
							 * 
							 * } codProp++; }
							 */

							for (Proposta prop : propDAO.consulta()) {

								if (prop.getPublicacao_idPublicacao() == codPubli) {

									System.out.println(
											"------------------------------------------------------------------------");
									System.out.println();
									// System.out.println("C�digo Proposta: " + codProp);
									System.out.println("C�digo Proposta: " + prop.getIdProposta());
									System.out.println("Data: " + prop.getData());
									System.out.println("Usu�rio solicitante: " + prop.getPessoa_nomeUsuario());
									System.out.println("Negocia��o: " + prop.getTipoProposta());
									System.out.println("Descri��o: " + prop.getDescricao());
									System.out.println("idPub: " + prop.getPublicacao_idPublicacao());
									System.out.println();
									System.out.println(
											"------------------------------------------------------------------------");

								}
								// codProp++;
							}

							System.out.println(
									"Deseja aceitar uma proposta? Digite 1 para sim ou qualquer N� p/ prosseguir:  ");
							aceitarProp = Integer.parseInt(leitura.nextLine());

							if (aceitarProp == 1) {

								System.out.print("Entre com o c�digo da proposta que deseja aceitar: ");
								codProp = Integer.parseInt(leitura.nextLine());

								// publicacoes.get(codPubli).setPropostaAceita(publicacoes.get(codPubli).getPropostasRecebidas().get(codProp));

								// publicacoes.get(codPubli).getPropostasRecebidas().remove(codProp);

								// publicacoes.get(codPubli).setDisponivel(false);
								
								pubDAO.consulta().get(codPubli).getEstadoPublicacao().alterarVisibilidade(codPubli);
								
//								pubDAO.editarIsDisponivel(pubDAO.consulta()
//										.get(propDAO.consulta().get(codProp).getPublicacao_idPublicacao()), false);

							}

							break; // FIM OPCAO 1 - VER PROPOSTAS - MINHAS PUBLICACOES

						// OPCAO 2 - EDITAR - MINHAS PUBLICACOES
						case 2:

							System.out.print("Entre com o c�digo da publica��o que deseja editar: ");
							codPubli = Integer.parseInt(leitura.nextLine());

							System.out.println("""
									O que voc� deseja editar?

									1. Estado Produto
									2. Tipo do Produto
									3. Descri��o do Produto
									4. Tipo de Negocia��o""");
							int opcaoEditarPublic = Integer.parseInt(leitura.nextLine());

							switch (opcaoEditarPublic) {
							case 1:
								System.out.print("\nEntre com o estado do produto atualizado: ");
								// publicacoes.get(codPubli).getProduto().setEstado(leitura.nextLine());
								String estado = leitura.nextLine();
								prodDAO.editarEstado(
										prodDAO.consulta().get(pubDAO.consulta().get(codPubli).getIdProduto()), estado);
								break;

							case 2:
								System.out.print("\nEntre com o tipo do produto atualizado: ");
								// publicacoes.get(codPubli).getProduto().setTipoProduto(leitura.nextLine());
								String tipoProd = leitura.nextLine();
								prodDAO.editarTipoProduto(
										prodDAO.consulta().get(pubDAO.consulta().get(codPubli).getIdProduto()),
										tipoProd);
								break;

							case 3:
								System.out.print("\nEntre com a descri��o do produto atualizada: ");
								// publicacoes.get(codPubli).getProduto().setDescricao(leitura.nextLine());
								String descricao = leitura.nextLine();
								prodDAO.editarDescricao(
										prodDAO.consulta().get(pubDAO.consulta().get(codPubli).getIdProduto()),
										descricao);
								break;

							case 4:
								menu.tiposNegociacao();
								int neg = Integer.parseInt(leitura.nextLine());

								switch (neg) {
								case 1:
									// publicacoes.get(codPubli).setTipoNegociacao("Troca");
									pubDAO.editarTipoNegociacao(pubDAO.consulta().get(codPubli), "Troca");
									break;
								case 2:
									// publicacoes.get(codPubli).setTipoNegociacao("Doa��o");
									pubDAO.editarTipoNegociacao(pubDAO.consulta().get(codPubli), "Doa��o");
									break;
								case 3:
									// publicacoes.get(codPubli).setTipoNegociacao("Empr�stimo");
									// publicacoes.get(codPubli).setPrivacidade(true); priva someste para amigos
									// emprestar
									pubDAO.editarTipoNegociacao(pubDAO.consulta().get(codPubli), "Empr�stimo");
									break;
								}
								break;
							}

							break; // FIM OPCAO 2 - EDITAR - MINHAS PUBLICACOES

						// OPCAO 3 - EXCLUIR - MINHAS PUBLICACOES
						case 3:

							System.out.print("Entre com o c�digo da publica��o que deseja excluir: ");
							codPubli = Integer.parseInt(leitura.nextLine());

							// publicacoes.remove(codPubli);

							pubDAO.excluir(pubDAO.consulta().get(codPubli));

							break; // FIM OPCAO 3 - EXCLUIR - MINHAS PUBLICACOES

						}

					} else {
						System.out.println();
						System.out.println("Voc� precisa estar logado na plataforma.");
					}

					break; // FIM OPCAO 3 MINHAS PUBLICA��ES MENU PUBLICA��ES

				}
				break;// FIM OPCAO 3 MENU PRINCIPAL - PUBLICAR

			// OPCAO 4 MENU PRINCIPAL - CADASTRAR CUPOM
			case 4:

				if (logadoEmp.getNomeUsuario() != null) {

					Cupom c = new Cupom();
					int idCupom = -1;

					System.out.print("Entre com o ID do Cupom: ");
					idCupom = Integer.parseInt(leitura.nextLine());
					while (verificaIDCupom(idCupom, cDAO.consulta()) == false) {
						System.out.println("ID j� cadastrado: ");
						System.out.print("Entre com o ID do Cupom: ");
						idCupom = Integer.parseInt(leitura.nextLine());
					}
					c.setIdCupom(idCupom);
					System.out.print("Entre com a validade: ");
					c.setValidade(leitura.nextLine());
					System.out.print("Entre com o valor do desconto: ");
					c.setValor(Double.parseDouble(leitura.nextLine()));
					System.out.print("Entre com a descri��o (Nome Cupom): ");
					c.setDescricao(leitura.nextLine());
					c.setEmpresa(logadoEmp);
					c.setEmpresaParceira_nomeUsuario(logadoEmp.getNomeUsuario());
					System.out.println("Insira o nome de usu�rio que receber� este cupom: ");

					leitura = new Scanner(System.in);
					String nomeUsuario = leitura.nextLine();
					for (Pessoa p : pDAO.consulta()) {
						if (p.getNomeUsuario().equals(nomeUsuario)) {
							c.setPessoa_nomeUsuario(nomeUsuario);
						}
					}

					// cupons.add(c);
					cDAO.insere(c);

					System.out.println("Cupom cadastrado com sucesso!");

				} else {
					if (logadoPessoa.getNomeUsuario() != null) {
						System.out.println("---- Cupons Dispon�veis ----");
						for (Cupom cp : cDAO.consulta()) {
							if (cp.getPessoa_nomeUsuario().equals(logadoPessoa.getNomeUsuario())) {
								System.out.println();
								System.out.println("Validade: " + cp.getValidade());
								System.out.println(cp.isValid() ? "Cupom V�lido" : "Cupom Inv�lido");
								System.out.println("Valor do Cupom: " + cp.getValor());
								System.out.println("Descri��o: " + cp.getDescricao());
								System.out.println("Empresa: " + cp.getEmpresaParceira_nomeUsuario() + "/n");
							}
						}
					} else {
						System.out.println();
						System.out.println("Voc� precisa estar logado para acessar essa op��o!");
					}
				}

				break;// FIM OPCAO 4 MENU PRINCIPAL - CADASTRAR CUPOM

			// OPCAO 5 AMIZADE
			case 5:

				if (logadoPessoa.getNomeUsuario() != null) {

					int escolhaAmi = -1;

					menu.menuAmizades();
					escolhaAmi = Integer.parseInt(leitura.nextLine());

					switch (escolhaAmi) {
					case 1:

						System.out.println("\nLista de Amigos: ");
						System.out.println();

						for (Amizade a : amiDAO.consulta()) {
							if (a.getNomeUsuario().equals(logadoPessoa.getNomeUsuario()))
								System.out.println(a.getNomeUsuario1());
						}

						break;

					case 2:

						int aceitarAmizade = -1;
						System.out.println("\nSolicita��es de Amizades: ");
						System.out.println();

						// utiliza-se esse tipo "comum" de for, pois o ArrayList n�o permite exclus�o
						// usando o For each

						for (SolicitacaoAmizade s : soliDAO.consulta()) {

							if (s.getNomeUsuario1().equals(logadoPessoa.getNomeUsuario())) {

								System.out.println(s.getNomeUsuario());

								System.out.println("""

										Voc� deseja aceitar essa pessoa como amiga?
										Digite 1 para aceitar, 2 para remover ou qualquer n�mero para prosseguir:""");
								aceitarAmizade = Integer.parseInt(leitura.nextLine());

								if (aceitarAmizade == 1) {

									// adicionando ambos na lista de amigos
									/*
									 * logadoPessoa.getAmigos().add(p); p.getAmigos().add(logadoPessoa);
									 */

									Amizade a = new Amizade();
									Amizade a1 = new Amizade();

									a.setNomeUsuario(logadoPessoa.getNomeUsuario());
									a.setNomeUsuario1(s.getNomeUsuario());

									a1.setNomeUsuario(s.getNomeUsuario());
									a1.setNomeUsuario1(logadoPessoa.getNomeUsuario());

									amiDAO.insere(a);
									amiDAO.insere(a1);
									soliDAO.excluir(s);

									// removendo da lista de solicita��es ap�s adicionar
									// logadoPessoa.getSolicitacoesAmizade().remove(p);

								} else {
									if (aceitarAmizade == 2) {
										// removendo da lista de solicita��es
										// logadoPessoa.getSolicitacoesAmizade().remove(p);
										soliDAO.excluir(s);
									}

								}

							}

						}

						break;
					}

				} else {
					System.out.println();
					System.out.println("Voc� precisa estar logado para acessar essa op��o!");
				}

				break;// FIM 5 AMIZADE

			// OPCAO 6 MENU PRINCIPAL - BUSCAR PERFIL
			case 6:
				// variavel para buscar um nome de usuario

				if (logadoPessoa.getNomeUsuario() != null) {
					String nomeUsu = null;
					int solicitarAmizade = -1;
					int desfazerAmizade = -1;
					boolean amizadeExiste = false;

					System.out.println();
					System.out.print("Entre com o nome do usu�rio que deseja buscar: ");
					nomeUsu = leitura.nextLine();

					Amizade a = new Amizade();
					Amizade a1 = new Amizade();

					a.setNomeUsuario(logadoPessoa.getNomeUsuario());
					a.setNomeUsuario1(nomeUsu);

					a1.setNomeUsuario(nomeUsu);
					a1.setNomeUsuario1(logadoPessoa.getNomeUsuario());

					for (Pessoa p : pDAO.consulta()) {

						if (p.getNomeUsuario().equals(nomeUsu)) {

							System.out.println("Usu�rio: " + p.getNomeUsuario());

							// verifica se s�o amigos

							for (Amizade ami : amiDAO.consulta()) {

								if (ami.getNomeUsuario().equals(logadoPessoa.getNomeUsuario())
										&& ami.getNomeUsuario1().equals(nomeUsu)) {

									amizadeExiste = true;

									System.out.println("Teste");
									System.out.println(ami.getNomeUsuario().equals(logadoPessoa.getNomeUsuario()));
									System.out.println(ami.getNomeUsuario1().equals(nomeUsu));

									System.out.println("Voc�s j� s�o amigos.\n");

									System.out.print("Desfazer Amizade? Digite 1: ");
									desfazerAmizade = Integer.parseInt(leitura.nextLine());

									if (desfazerAmizade == 1) {

										// desfazendo amizade entre os dois amigos

										/*
										 * logadoPessoa.getAmigos().remove(logadoPessoa.getAmigos().indexOf(p));
										 * 
										 * p.getAmigos().remove(p.getAmigos().indexOf(logadoPessoa));
										 */

										amiDAO.excluir(a);
										amiDAO.excluir(a1);
									}
								} /*
									 * else {
									 * 
									 * 
									 * 
									 * SolicitacaoAmizade s1 = new SolicitacaoAmizade();
									 * 
									 * s1.setNomeUsuario(logadoPessoa.getNomeUsuario());
									 * s1.setNomeUsuario1(nomeUsu);
									 * 
									 * System.out.print(
									 * "Deseja enviar uma solicita��o de amizade? Digite 1 para Sim ou qualquer n�mero para prosseguir: "
									 * ); solicitarAmizade = Integer.parseInt(leitura.nextLine());
									 * 
									 * if (solicitarAmizade == 1) { soliDAO.insere(s1); }
									 * 
									 * }
									 */

							}

							if (amizadeExiste == false) {
								SolicitacaoAmizade s1 = new SolicitacaoAmizade();

								s1.setNomeUsuario(logadoPessoa.getNomeUsuario());
								s1.setNomeUsuario1(nomeUsu);

								System.out.print(
										"Deseja enviar uma solicita��o de amizade? Digite 1 para Sim ou qualquer n�mero para prosseguir: ");
								solicitarAmizade = Integer.parseInt(leitura.nextLine());

								if (solicitarAmizade == 1) {
									soliDAO.insere(s1);
								}
							}

						}
					}

				} else {
					System.out.println();
					System.out.println("Voc� precisa estar logado para acessar essa op��o!");
				}

				break;// FIM 6 BUSCAR PERFIL

			// OPCAO 7 MENU PRINCIPAL - logout
			case 7:

				logadoPessoa = new Pessoa();
				logadoEmp = new EmpresaParceira();

				break;// FIM 7 MENU PRINCIPAL - logout

			}

		}

	}

	public static boolean verificaCadastroCPF (ArrayList<Pessoa> pessoas, String cpf) {

		boolean var = true;

		for (Pessoa p : pessoas) {
			if (p.getCpf().equals(cpf)) {
				var = false;
			}
		}
		return var;
	}

	public static boolean verificaCadastroCNPJ(ArrayList<EmpresaParceira> empresas, String cnpj) {

		boolean var = true;

		for (EmpresaParceira emp : empresas) {
			if (emp.getCnpj().equals(cnpj)) {
				var = false;
			}
		}
		return var;
	}

	public static boolean verificaCadastroNomeUsuario(ArrayList<Pessoa> pessoas, String nomeUsu) {

		boolean var = true;

		for (Pessoa p : pessoas) {
			if (p.getNomeUsuario().equals(nomeUsu)) {
				var = false;
			}
		}
		return var;
	}

	public static boolean verificaCadastroNomeUsuario(String nomeUsu, ArrayList<EmpresaParceira> empresas) {

		boolean var = true;

		for (EmpresaParceira emp : empresas) {
			if (emp.getNomeUsuario().equals(nomeUsu)) {
				var = false;
			}
		}
		return var;
	}

	public static boolean verificaIDProduto(int idProduto, ArrayList<Produto> produtos) {

		boolean var = true;

		for (Produto produto : produtos) {
			if (produto.getIdProduto() == idProduto) {
				var = false;
			}
		}
		return var;
	}

	public static boolean verificaIDPublicacao(int idPublicacao, ArrayList<Publicacao> publicacoes) {

		boolean var = true;

		for (Publicacao publicacao : publicacoes) {
			if (publicacao.getIdPublicacao() == idPublicacao) {
				var = false;
			}
		}
		return var;
	}

	public static boolean verificaIDProposta(int idProposta, ArrayList<Proposta> propostas) {

		boolean var = true;

		for (Proposta proposta : propostas) {
			if (proposta.getIdProposta() == idProposta) {
				var = false;
			}
		}
		return var;
	}

	public static boolean verificaIDCupom(int idCupom, ArrayList<Cupom> cupons) {

		boolean var = true;

		for (Cupom cupom : cupons) {
			if (cupom.getIdCupom() == idCupom) {
				var = false;
			}
		}
		return var;
	}
	
	public static Pessoa verificaCred(ArrayList<Pessoa> pessoas, String loginPessoa, String senhaPessoa) throws ExcecaoLogin{

		for (Pessoa p : pessoas) {
			if (p.getNomeUsuario().equals(loginPessoa) && p.getSenha().equals(senhaPessoa)) {
				//logadoPessoa = p;
				System.out.println("Voc� est� logado na plataforma!");
				return p;
			}
		}

		System.out.println();
		throw new ExcecaoLogin("Credenciais incorretas.");
		
	}
	
	public static EmpresaParceira verificaCred(String loginEmp, String senhaEmp, ArrayList<EmpresaParceira> empresas) throws ExcecaoLogin{

		for (EmpresaParceira emp : empresas) {
			if (emp.getNomeUsuario().equals(loginEmp) && emp.getSenha().equals(senhaEmp)) {
				//logadoEmp = emp;
				System.out.println("Voc� est� logado na plataforma!");
				return emp;
			}
		}

		System.out.println();
		throw new ExcecaoLogin("Credenciais incorretas.");
	}
	
}
