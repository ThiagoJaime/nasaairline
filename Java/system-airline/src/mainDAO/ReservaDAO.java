package mainDAO;

import factory.ConnectionFactory;
import model.Reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    // Inserção de Dados
    public void insertReserva(Reserva reserva) {
        String sql = "INSERT INTO Reserva (cliente_id, promocao_id, destino_id, valor, data_ida, data_return) VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, reserva.getCliente().getIdCliente());
            pstm.setInt(2, reserva.getPromocao().getIdPromocao());
            pstm.setInt(3, reserva.getDestino().getIdDestino());
            pstm.setDouble(4, reserva.getValor());
            pstm.setObject(5,  reserva.getDataIda());
            pstm.setObject(6, reserva.getDataRetorno());

            pstm.execute();
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

    // Exclusão de Dados
    public void deleteReserva(int id) {
        String sql = "DELETE FROM Reserva WHERE id_reserva = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
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
    public void updateReserva(Reserva reserva) {
        String sql = "UPDATE Reserva SET cliente_id = ?, promocao_id = ?, destino_id = ?, valor = ?, data_ida = ?, data_return = ? WHERE id_reserva = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, reserva.getCliente().getIdCliente());
            pstm.setInt(2, reserva.getPromocao().getIdPromocao());
            pstm.setInt(3, reserva.getDestino().getIdDestino());
            pstm.setDouble(4, reserva.getValor());
            pstm.setObject(5, reserva.getDataIda());
            pstm.setObject(6, reserva.getDataRetorno());
            pstm.setInt(7, reserva.getIdReserva());

            pstm.execute();
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
    public List<Reserva> getAllReservas() {
        String sql = "SELECT * FROM Reserva";

        List<Reserva> reservas = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Reserva reserva = new Reserva();
                reserva.setIdReserva(rset.getInt("id_reserva"));
                reserva.setCliente(new ClientesDAO().getClienteById(rset.getInt("cliente_id")));
                reserva.setPromocao(new PromocoesDAO().getPromocaoById(rset.getInt("promocao_id")));
                reserva.setDestino(new DestinosDAO().getDestinoById(rset.getInt("destino_id")));
                reserva.setValor(rset.getDouble("valor"));
                reserva.setDataIda((LocalDateTime) rset.getObject("data_ida"));
                reserva.setDataRetorno((LocalDateTime) rset.getObject("data_return"));

                reservas.add(reserva);
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
        return reservas;
    }

    // Obter reserva por ID
    public Reserva getReservaById(int id) {
        String sql = "SELECT * FROM Reserva WHERE id_reserva = ?";
        Reserva reserva = null;

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rset = pstm.executeQuery();

            if (rset.next()) {
                reserva = new Reserva();
                reserva.setIdReserva(rset.getInt("id_reserva"));
                reserva.setCliente(new ClientesDAO().getClienteById(rset.getInt("cliente_id")));
                reserva.setPromocao(new PromocoesDAO().getPromocaoById(rset.getInt("promocao_id")));
                reserva.setDestino(new DestinosDAO().getDestinoById(rset.getInt("destino_id")));
                reserva.setValor(rset.getDouble("valor"));
                reserva.setDataIda((LocalDateTime) rset.getObject("data_ida"));
               reserva.setDataRetorno((LocalDateTime) rset.getObject("data_return"));
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
        return reserva;
    }
}
