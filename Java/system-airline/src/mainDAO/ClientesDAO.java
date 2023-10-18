package mainDAO;

import factory.ConnectionFactory;
import model.Clientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {

    // Inserção de Dados
    public void insertCliente(Clientes cliente) {
        String sql = "INSERT INTO Clientes(nome, email, senha, telefone) VALUES(?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL(); // Obtém uma conexão com o banco de dados.
            pstm = conn.prepareStatement(sql); // Prepara a instrução SQL.

            // Define os valores dos parâmetros com base no objeto Cliente fornecido.
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getEmail());
            pstm.setString(3, cliente.getSenha());
            pstm.setString(4, cliente.getTelefone());

            pstm.execute(); // Executa a inserção.

        } catch (Exception e) {
            e.printStackTrace(); // Trata exceções, se ocorrerem.
        } finally {
            try {
                if (pstm != null) {
                    pstm.close(); // Fecha a instrução preparada.
                }
                if (conn != null) {
                    conn.close(); // Fecha a conexão com o banco de dados.
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Exclusão de Dados
    public void deleteById(int id) {
        String sql = "DELETE FROM Clientes WHERE id_cliente = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id); // Define o ID do cliente a ser excluído.
            pstm.execute(); // Executa a exclusão.

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Atualização de Dados
    public void updateCliente(Clientes cliente) {
        String sql = "UPDATE Clientes SET nome = ?, email = ?, senha = ?, telefone = ? WHERE id_cliente = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            // Define os valores dos parâmetros com base no objeto Cliente fornecido.
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getEmail());
            pstm.setString(3, cliente.getSenha());
            pstm.setString(4, cliente.getTelefone());
            pstm.setInt(5, cliente.getIdCliente()); // Define o ID do cliente a ser atualizado.

            pstm.execute(); // Executa a atualização.

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Exibição de Dados
    public List<Clientes> getAllClientes() {
        String sql = "SELECT * FROM Clientes";

        List<Clientes> clientes = new ArrayList<Clientes>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery(); // Executa a consulta.

            while (rset.next()) {
                Clientes cliente = new Clientes();

                // Define os atributos do objeto Cliente com base nos resultados da consulta.
                cliente.setIdCliente(rset.getInt("id_cliente"));
                cliente.setNome(rset.getString("nome"));
                cliente.setEmail(rset.getString("email"));
                cliente.setSenha(rset.getString("senha"));
                cliente.setTelefone(rset.getString("telefone"));

                clientes.add(cliente); // Adiciona o objeto Cliente à lista.

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return clientes; // Retorna a lista de clientes.
    }

    // Obter cliente por ID
    public Clientes getClienteById(int id) {
        String sql = "SELECT * FROM Clientes WHERE id_cliente = ?";
        Clientes cliente = null;

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id); // Define o ID do cliente a ser buscado.
            rset = pstm.executeQuery(); // Executa a consulta.

            if (rset.next()) {
                 cliente = new Clientes();

                // Define os atributos do objeto Cliente com base nos resultados da consulta.
                cliente.setIdCliente(rset.getInt("id_cliente"));
                cliente.setNome(rset.getString("nome"));
                cliente.setEmail(rset.getString("email"));
                cliente.setSenha(rset.getString("senha"));
                cliente.setTelefone(rset.getString("telefone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return cliente; // Retorna o objeto Cliente encontrado.
    }
}
