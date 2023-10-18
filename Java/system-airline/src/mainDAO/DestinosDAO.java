package mainDAO;

import factory.ConnectionFactory;
import model.Destinos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DestinosDAO {

    public void insertDestino(Destinos destino) {
        String sql = "INSERT INTO destinos (pais, preco, auracao) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, destino.getPais());
            pstm.setDouble(2, destino.getPreco());
            pstm.setInt(3, destino.getDuracao());

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

    public void deleteDestino(int id) {
        String sql = "DELETE FROM destinos WHERE id_destino = ?";

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

    public void updateDestino(Destinos destino) {
        String sql = "UPDATE destinos SET pais = ?, preco = ?, auracao = ? WHERE id_destino = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, destino.getPais());
            pstm.setDouble(2, destino.getPreco());
            pstm.setInt(3, destino.getDuracao());
            pstm.setInt(4, destino.getIdDestino());

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

    public List<Destinos> getAllDestinos() {
        String sql = "SELECT * FROM destinos";

        List<Destinos> destinosLista = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Destinos destino = new Destinos();

                destino.setIdDestino(rset.getInt("id_destino"));
                destino.setPais(rset.getString("pais"));
                destino.setPreco(rset.getDouble("preco"));
                destino.setDuracao(rset.getInt("duracao"));

                destinosLista.add(destino);

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
        return destinosLista;
    }

    public Destinos getDestinoById(int id) {
        String sql = "SELECT * FROM destinos WHERE id_destino = ?";
        Destinos destino = null;

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rset = pstm.executeQuery();

            if (rset.next()) {
                destino = new Destinos();

                destino.setIdDestino(rset.getInt("id_destino"));
                destino.setPais(rset.getString("pais"));
                destino.setPreco(rset.getDouble("preco"));
                destino.setDuracao(rset.getInt("duracao"));
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

        return destino;
    }
}
