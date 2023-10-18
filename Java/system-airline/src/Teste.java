import mainDAO.ClientesDAO;
import mainDAO.DestinosDAO;
import mainDAO.PromocoesDAO;
import mainDAO.ReservaDAO;
import model.Clientes;
import model.Destinos;
import model.Promocoes;
import model.Reserva;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.List;

public class Teste {

    public static void main(String[] args) {
        // Instâncias dos DAOs
        ClientesDAO clientesDAO = new ClientesDAO();
        DestinosDAO destinosDAO = new DestinosDAO();
        PromocoesDAO promocoesDAO = new PromocoesDAO();
        ReservaDAO reservaDAO = new ReservaDAO();

        Scanner scanner = new Scanner(System.in);

        // Programa Principal
        while (true) {
            System.out.println("-----------------------------");
            System.out.println("        Nasa Airline         ");
            System.out.println("-----------------------------");
            System.out.println("[1] Inserir");
            System.out.println("[2] Atualizar");
            System.out.println("[3] Listar");
            System.out.println("[4] Deletar");
            System.out.println("[5] Finalizar Programa");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {

                // Insert
                case 1:
                    System.out.println("-----------------------------");
                    System.out.println("           Inserir           ");
                    System.out.println("-----------------------------");
                    System.out.println("[1] Clientes");
                    System.out.println("[2] Destinos");
                    System.out.println("[3] Promoção");
                    System.out.println("[4] Reserva");
                    System.out.print("Escolha a tabela: ");
                    int tblInserir = scanner.nextInt();
                    scanner.nextLine();

                    switch (tblInserir) {
                        case 1:
                            System.out.println("-----------------------------");
                            System.out.println("       Inserir Clientes      ");
                            System.out.println("-----------------------------");
                            System.out.print("Nome: ");
                            String nomeCliente = scanner.nextLine();
                            System.out.print("Email: ");
                            String emailCliente = scanner.nextLine();
                            System.out.print("Senha: ");
                            String senhaCliente = scanner.nextLine();
                            System.out.print("Telefone: ");
                            String telefoneCliente = scanner.nextLine();

                            Clientes novoCliente = new Clientes(nomeCliente, emailCliente, senhaCliente, telefoneCliente);

                            // Inserir cliente no banco de dados
                            clientesDAO.insertCliente(novoCliente);

                            System.out.println("Cliente inserido com sucesso!");
                            break;

                        case 2:
                            System.out.println("-----------------------------");
                            System.out.println("       Inserir Destinos      ");
                            System.out.println("-----------------------------");
                            System.out.print("País: ");
                            String paisDestino = scanner.nextLine();
                            System.out.print("Preço: ");
                            double precoDestino = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("avaliacao: ");
                            int avaliacaoDestino = scanner.nextInt();
                            System.out.print("ID da promoção: ");
                            int promoId = scanner.nextInt();
                            Promocoes promocao = promocoesDAO.getPromocaoById(promoId);

                            if (promocao == null || promocao != null) {
                                Destinos novoDestino = new Destinos(paisDestino, precoDestino, avaliacaoDestino);

                                // Inserir destino no banco de dados
                                destinosDAO.insertDestino(novoDestino);

                                System.out.println("Destino inserido com sucesso!");
                            }
                            break;

                        case 3:
                            System.out.println("-----------------------------");
                            System.out.println("       Inserir Promoção      ");
                            System.out.println("-----------------------------");
                            System.out.print("Desconto: ");
                            double descontoPromo = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Validade da Promoção [formato yyyy-MM-dd HH:mm:ss]: ");
                            String validadePromocao = scanner.nextLine();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            LocalDateTime validadePromo = LocalDateTime.parse(validadePromocao, formatter);
                         
                            Promocoes novaPromocao = new Promocoes(descontoPromo, validadePromo);

                            // Inserir promoção no banco de dados
                            promocoesDAO.insertPromocao(novaPromocao);

                            System.out.println("Promoção inserida com sucesso!");
                            break;

                        case 4:
                            System.out.println("-----------------------------");
                            System.out.println("        Inserir Reserva       ");
                            System.out.println("-----------------------------");
                            System.out.print("Data e hora da ida [formato yyyy-MM-dd HH:mm:ss]: ");
                            String dataIda = scanner.nextLine();
                            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            LocalDateTime dataIdaViagem = LocalDateTime.parse(dataIda, formatter1);
                            System.out.print("Data e hora do retorno [formato yyyy-MM-dd HH:mm:ss]: ");
                            String dataRetorno = scanner.nextLine();
                            LocalDateTime dataRetornoViagem = LocalDateTime.parse(dataRetorno, formatter1);
                  
                            System.out.print("Valor: ");
                            double valor = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("ID Cliente: ");
                            int idCliente = scanner.nextInt();
                            Clientes cliente = clientesDAO.getClienteById(idCliente);
                            System.out.print("ID Destino: ");
                            int idDestino = scanner.nextInt();
                            Destinos destino = destinosDAO.getDestinoById(idDestino);
                            System.out.print("ID Promocão: ");
                            int idPromocao = scanner.nextInt();
                            Promocoes promocao1 = promocoesDAO.getPromocaoById(idPromocao);

                            if (cliente != null && destino != null) {
                                Reserva novaReserva = new Reserva(cliente, promocao1, destino, valor, dataIdaViagem, dataRetornoViagem);

                                // Inserir reserva no banco de dados
                                reservaDAO.insertReserva(novaReserva);

                                System.out.println("Reserva inserida com sucesso!");
                            } else {
                                System.out.println("ID não corresponde a nenhum cliente ou destino");
                            }
                            break;

                        default:
                            System.out.println("Opção Inválida!");
                            break;
                    }
                    break;

                // Update
                case 2:
                    System.out.println("-----------------------------");
                    System.out.println("           Atualizar         ");
                    System.out.println("-----------------------------");
                    System.out.println("[1] Clientes");
                    System.out.println("[2] Destinos");
                    System.out.println("[3] Promoção");
                    System.out.println("[4] Reserva");
                    System.out.print("Escolha a tabela: ");
                    int tblAtualizar = scanner.nextInt();
                    scanner.nextLine();

                    switch (tblAtualizar) {
                        case 1:
                            System.out.println("-----------------------------");
                            System.out.println("      Atualizar Clientes     ");
                            System.out.println("-----------------------------");
                            System.out.print("ID do cliente: ");
                            int clienteId = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Nome: ");
                            String nomeCliente = scanner.nextLine();
                            System.out.print("Email: ");
                            String emailCliente = scanner.nextLine();
                            System.out.print("Senha: ");
                            String senhaCliente = scanner.nextLine();
                            System.out.print("Telefone: ");
                            String telefoneCliente = scanner.nextLine();

                            Clientes upCliente = new Clientes(clienteId, nomeCliente, emailCliente, senhaCliente, telefoneCliente);

                            // Atualizar cliente no banco de dados
                            clientesDAO.updateCliente(upCliente);

                            System.out.println("Cliente atualizado com sucesso!");
                            break;

                        case 2:
                            System.out.println("-----------------------------");
                            System.out.println("      Atualizar Destinos     ");
                            System.out.println("-----------------------------");
                            System.out.print("ID do destino: ");
                            int destinoId = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("País: ");
                            String nomeDestino = scanner.nextLine();
                            System.out.print("Preço: ");
                            double precoDestino = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Avaliação: ");
                            int avaliacaoDestino = scanner.nextInt();
                            System.out.print("ID da promoção: ");
                            int promoId = scanner.nextInt();
                            Promocoes promocao = promocoesDAO.getPromocaoById(promoId);

                            if (promocao != null) {
                                Destinos upDestino = new Destinos(destinoId, nomeDestino, precoDestino, avaliacaoDestino);

                                // Atualizar destino no banco de dados
                                destinosDAO.updateDestino(upDestino);

                                System.out.println("Destino atualizado com sucesso!");
                            }
                            break;

                        case 3:
                            System.out.println("-----------------------------");
                            System.out.println("      Atualizar Promoção     ");
                            System.out.println("-----------------------------");
                            System.out.print("ID da promoção: ");
                            int promoId1 = scanner.nextInt();
                            System.out.print("Preço: ");
                            double descontoPromo = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Validade da Promoção [formato yyyy-MM-dd HH:mm:ss]: ");
                            String validadePromocao = scanner.nextLine();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            LocalDateTime validadePromo = LocalDateTime.parse(validadePromocao, formatter);
                         
                            Promocoes upPromocao = new Promocoes(promoId1, descontoPromo, validadePromo);

                            // Atualizar promoção no banco de dados
                            promocoesDAO.updatePromocao(upPromocao);

                            System.out.println("Promoção atualizada com sucesso!");
                            break;

                        case 4:
                            System.out.println("-----------------------------");
                            System.out.println("      Atualizar Reserva      ");
                            System.out.println("-----------------------------");
                            
                            System.out.print("ID da reserva: ");
                            int reservaId = scanner.nextInt();
                            scanner.nextLine();
                            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            System.out.print("Data e hora da ida [formato yyyy-MM-dd]: ");
                            String dataIda = scanner.nextLine();
                            LocalDateTime dataIdaViagem = LocalDateTime.parse(dataIda, formatter1);
                            System.out.print("Data e hora do retorno [formato yyyy-MM-dd]: ");
                            String dataRetorno = scanner.nextLine();
                            LocalDateTime dataRetornoViagem = LocalDateTime.parse(dataRetorno, formatter1);
                           
                            System.out.print("Valor: ");
                            double valor = scanner.nextDouble();
                            System.out.print("ID Cliente: ");
                            int idCliente = scanner.nextInt();
                            System.out.print("ID Destino: ");
                            int idDestino = scanner.nextInt();
                            System.out.print("ID Promocão: ");
                            int idPromocao = scanner.nextInt();
                            Promocoes promocao1 = promocoesDAO.getPromocaoById(idPromocao);
                            
                            Clientes cliente = clientesDAO.getClienteById(idCliente);
                            Destinos destino = destinosDAO.getDestinoById(idDestino);

                            if (cliente != null && destino != null) {
                                Reserva upReserva = new Reserva(reservaId, cliente, promocao1, destino, valor, dataIdaViagem, dataRetornoViagem);

                                // Atualizar reserva no banco de dados
                                reservaDAO.updateReserva(upReserva);

                                System.out.println("Reserva atualizada com sucesso!");
                            } else {
                                System.out.println("ID não corresponde a nenhum cliente ou destino");
                            }
                            break;

                        default:
                            System.out.println("Opção Inválida!");
                            break;
                    }
                    break;

                // Select
                case 3:
                    System.out.println("-----------------------------");
                    System.out.println("            Listar           ");
                    System.out.println("-----------------------------");
                    System.out.println("[1] Clientes");
                    System.out.println("[2] Destinos");
                    System.out.println("[3] Promoção");
                    System.out.println("[4] Reserva");
                    System.out.print("Escolha a tabela: ");
                    int tblSelecionar = scanner.nextInt();
                    scanner.nextLine();

                    switch (tblSelecionar) {
                        case 1:
                            System.out.println("-----------------------------");
                            System.out.println("       Listar Clientes       ");
                            System.out.println("-----------------------------");
                            List<Clientes> clientes = clientesDAO.getAllClientes();
                            for (Clientes cliente : clientes) {
                                System.out.println("ID do cliente: " + cliente.getIdCliente());
                                System.out.println("Nome: " + cliente.getNome());
                                System.out.println("Email: " + cliente.getEmail());
                                System.out.println("Senha: " + cliente.getSenha());
                                System.out.println("Telefone: " + cliente.getTelefone());
                                System.out.println();
                            }
                            break;

                        case 2:
                            System.out.println("-----------------------------");
                            System.out.println("       Listar Destinos       ");
                            System.out.println("-----------------------------");
                            List<Destinos> destinos = destinosDAO.getAllDestinos();
                            for (Destinos destino : destinos) {
                                System.out.println("ID do destino: " + destino.getIdDestino());
                                System.out.println("País: " + destino.getPais());
                                System.out.println("Preço: " + destino.getPreco());
                                System.out.println("Duração: " + destino.getDuracao());
                                System.out.println();
                            }
                            break;

                        case 3:
                            System.out.println("-----------------------------");
                            System.out.println("       Listar Promoções      ");
                            System.out.println("-----------------------------");
                            List<Promocoes> promocoes = promocoesDAO.getAllPromocoes();
                            for (Promocoes promocao : promocoes) {
                                System.out.println("ID da Promoção: " + promocao.getIdPromocao());
                                System.out.println("Preço: " + promocao.getPrecoPromo());
                                System.out.println("Validade da Promoção: " + promocao.getValidade());                       
                                System.out.println();
                            }
                            break;

                        case 4:
                            System.out.println("-----------------------------");
                            System.out.println("       Listar Reservas       ");
                            System.out.println("-----------------------------");
                            List<Reserva> reservas = reservaDAO.getAllReservas();
                            for (Reserva reserva : reservas) {
                                System.out.println("ID da Reserva: " + reserva.getIdReserva());
                                System.out.println("ID Cliente: " + reserva.getCliente().getIdCliente());
                                System.out.println("ID Destino: " + reserva.getDestino().getIdDestino());
                                System.out.println("Data de Ida: " + reserva.getDataIda());
                                System.out.println("Data de Retorno: " + reserva.getDataRetorno());
                                System.out.println("Valor: " + reserva.getValor());
                                System.out.println("Promoção: " + reserva.getPromocao());
                                System.out.println();
                            }
                            break;

                        default:
                            System.out.println("Opção Inválida!");
                            break;
                    }
                    break;

                // Delete
                case 4:
                    System.out.println("-----------------------------");
                    System.out.println("            Deletar          ");
                    System.out.println("-----------------------------");
                    System.out.println("[1] Clientes");
                    System.out.println("[2] Destinos");
                    System.out.println("[3] Promoção");
                    System.out.println("[4] Reserva");
                    System.out.print("Escolha a tabela: ");
                    int tblExcluir = scanner.nextInt();
                    scanner.nextLine();

                    switch (tblExcluir) {
                        case 1:
                            System.out.println("-----------------------------");
                            System.out.println("      Deletar Clientes       ");
                            System.out.println("-----------------------------");
                            System.out.print("ID do Cliente que desejar excluir do banco: ");
                            int idClienteDelete = scanner.nextInt();
                            System.out.println();

                            // Excluir cliente no banco de dados
                            clientesDAO.deleteById(idClienteDelete);

                            System.out.println("*** Cliente excluído com sucesso! ***");
                            break;

                        case 2:
                            System.out.println("-----------------------------");
                            System.out.println("      Deletar Destinos       ");
                            System.out.println("-----------------------------");
                            System.out.print("ID do Destino que desejar excluir do banco: ");
                            int idDestinoDelete = scanner.nextInt();
                            System.out.println();

                            // Excluir destino no banco de dados
                            destinosDAO.deleteDestino(idDestinoDelete);

                            System.out.println("*** Destino excluído com sucesso! ***");
                            break;

                        case 3:
                            System.out.println("-----------------------------");
                            System.out.println("      Deletar Promoções      ");
                            System.out.println("-----------------------------");
                            System.out.print("ID da Promoção que desejar excluir do banco: ");
                            int idPromoDelete = scanner.nextInt();
                            System.out.println();

                            // Excluir promoção no banco de dados
                            promocoesDAO.deletePromocao(idPromoDelete);

                            System.out.println("*** Promoção excluída com sucesso! ***");
                            break;

                        case 4:
                            System.out.println("-----------------------------");
                            System.out.println("       Deletar Reserva       ");
                            System.out.println("-----------------------------");
                            System.out.print("ID da Reserva que desejar excluir do banco: ");
                            int idReservaDelete = scanner.nextInt();
                            System.out.println();

                            // Excluir reserva no banco de dados
                            reservaDAO.deleteReserva(idReservaDelete);

                            System.out.println("*** Reserva excluída com sucesso! ***");
                            break;

                        default:
                            System.out.println("Opção Inválida!");
                            break;
                    }
                    break;

                case 5:
                    System.out.println("*** Programa Finalizado! ***");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("*** Opção Inválida! ***");
                    break;
            }
        }
    }
}
