/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pw.pw02semana11.dao;

import com.pw.pw02semana11.models.Commentary;
import com.pw.pw02semana11.models.User;
import com.pw.pw02semana11.utils.DbConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author magoc
 */
public class CommentaryDAO {

//    CREATE TABLE `pw02`.`commentary` (
//  `idcommentary` INT NOT NULL AUTO_INCREMENT,
//  `content` TEXT NULL,
//  `idNews` INT NULL,
//  `idUser` INT NULL,
//  `parent` INT NULL,
//  PRIMARY KEY (`idcommentary`),
//  UNIQUE INDEX `idcommentary_UNIQUE` (`idcommentary` ASC) VISIBLE,
//  INDEX `fk_user_commentary_idx` (`idUser` ASC) VISIBLE,
//  INDEX `fk_news_commentary_idx` (`idNews` ASC) VISIBLE,
//  CONSTRAINT `fk_user_commentary`
//    FOREIGN KEY (`idUser`)
//    REFERENCES `pw02`.`user` (`idUser`)
//    ON DELETE NO ACTION
//    ON UPDATE NO ACTION,
//  CONSTRAINT `fk_news_commentary`
//    FOREIGN KEY (`idNews`)
//    REFERENCES `pw02`.`news` (`idnews`)
//    ON DELETE NO ACTION
//    ON UPDATE NO ACTION);
//    USE `pw02`;
//DROP procedure IF EXISTS `insertComentary`;
//
//DELIMITER $$
//USE `pw02`$$
//CREATE PROCEDURE `insertComentary` (
//IN `pContent` text,
//IN `pIdNews` int,
//IN `pIdUser` int,
//IN `pParent` int
//)
//BEGIN
//INSERT INTO `commentary`
//(`content`,
//`idNews`,
//`idUser`,
//`parent`)
//VALUES
//(pContent,
//pIdNews,
//pIdUser,
//pParent);
//END$$
//
//DELIMITER ;
//
    public static int insertCommentary(Commentary commentary) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL insertComentary(?, ?, ?, ?);";
            CallableStatement statement = con.prepareCall(sql);

            statement.setString(1, commentary.getContent());
            statement.setInt(2, commentary.getIdNews());
            statement.setInt(3, commentary.getUser().getId());
            statement.setInt(4, commentary.getParent());

            return statement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CommentaryDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }

//USE `pw02`;
//DROP procedure IF EXISTS `getCommentariesByNew`;
//
//DELIMITER $$
//USE `pw02`$$
//CREATE PROCEDURE `getCommentariesByNew` (
//IN `pIdnews` int
//)
//BEGIN
//SELECT `commentary`.`idcommentary`,
//    `commentary`.`content`,
//    `commentary`.`idNews`,
//    `commentary`.`idUser`,
//    `commentary`.`parent`
//FROM `pw02`.`commentary`
//WHERE `commentary`.`idNews` = `pIdnews`;
//
//END$$
//
//DELIMITER ;
//
    public static List<Commentary> getCommentariesByNews(int idNews) {
        List<Commentary> commentaries = new ArrayList<>();
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL getCommentariesByNew(?)";
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, idNews);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt(1);
                String content = result.getString(2);
                int idNew = result.getInt(3);
                int idUser = result.getInt(4);
                int parent = result.getInt(5);
                User user = UserDAO.getUser(idUser);
                commentaries.add(new Commentary(id, content, idNews, user, parent));
            }
            return commentaries;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CommentaryDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return commentaries;
    }

    
//    USE `pw02`;
//DROP procedure IF EXISTS `deleteCommentary`;
//
//DELIMITER $$
//USE `pw02`$$
//CREATE PROCEDURE `deleteCommentary` (
//IN `pIdCommentary` int)
//BEGIN
//DELETE FROM `pw02`.`commentary`
//WHERE `commentary`.`idcommentary` = pIdCommentary;
//
//END$$
//
//DELIMITER ;
//

    public static int deleteCommentary(int idCommentary) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL deleteCommentary(?);";
            CallableStatement statement = con.prepareCall(sql);

            statement.setInt(1, idCommentary);

            return statement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CommentaryDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }
}
