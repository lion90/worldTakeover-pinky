package com.uy.lion.worldTakeover.pinky.persistence;

import com.uy.lion.worldTakeover.pinky.entities.Paro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lion
 * @since 18/06/17
 */
public enum ParoDAO {

    INSTANCE;

    public Paro fetchParo(LocalDateTime dDate) {
        PreparedStatement oStatement;
        try {
            oStatement = PersistenceManager.statement("SELECT * FROM \"paro\" WHERE ? BETWEEN \"beginDate\" AND \"endDate\"");
            oStatement.setTimestamp(1, Timestamp.valueOf(dDate));
            ResultSet oResult = oStatement.executeQuery();
            if (oResult.next()) {
                return resultSetToParo(oResult);
            } else {
                return null;
            }

        } catch (SQLException e) {
            //FIXME [LION] I shall implement logging.
            e.printStackTrace();
            //FIXME [LION] I shall create exceptions.
            throw new RuntimeException();
        }
    }

    public List<Paro> fetchAll() {
        try {
            PreparedStatement oStatement = PersistenceManager.statement("SELECT * FROM \"paro\"");
            ResultSet oResult = oStatement.executeQuery();
//            oStatement.getResultSet();
            List<Paro> colReturn = new ArrayList<>(oResult.getFetchSize());
            while (oResult.next()) {
                colReturn.add(this.resultSetToParo(oResult));
            }
            return colReturn;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    /**
     * Unsafe method. ResultSet validations should be performed by client.
     *
     * @param oResult Query result containing Paro info.
     * @return Paro instance obtained from DB.
     */
    private Paro resultSetToParo(ResultSet oResult) {
        Paro oReturn;
        try {
            int nId = oResult.getInt("idParo");
            LocalDateTime dBeginDate = oResult.getTimestamp("beginDate").toLocalDateTime();
            LocalDateTime dEndDate = oResult.getTimestamp("endDate").toLocalDateTime();
            String sStrikeType = oResult.getString("strikeType");
            oReturn = new Paro(nId, dBeginDate, dEndDate, sStrikeType);
        } catch (SQLException e) {
            //FIXME [LION] I shall implement logging.
            e.printStackTrace();
            //FIXME [LION] I shall create exceptions.
            throw new RuntimeException();
        }
        return oReturn;
    }

}
