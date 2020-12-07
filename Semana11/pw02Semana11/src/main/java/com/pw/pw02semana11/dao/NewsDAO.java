/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pw.pw02semana11.dao;

import com.pw.pw02semana11.models.Category;
import com.pw.pw02semana11.models.News;
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
public class NewsDAO {

//CREATE TABLE `news` (
//  `idnews` int NOT NULL AUTO_INCREMENT,
//  `title` varchar(60) DEFAULT NULL,
//  `description` text,
//  `pathImage` varchar(60) DEFAULT NULL,
//  `category` int DEFAULT NULL,
//  PRIMARY KEY (`idnews`),
//  UNIQUE KEY `idnews_UNIQUE` (`idnews`),
//  KEY `fk_news_category_idx` (`category`),
//  CONSTRAINT `fk_news_category` FOREIGN KEY (`category`) REFERENCES `category` (`idcategory`)
//) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
//USE `pw02`;
//DROP procedure IF EXISTS `insertNews`;
//
//DELIMITER $$
//USE `pw02`$$
//CREATE PROCEDURE `insertNews` (
//IN `pTitle` varchar(60),
//IN `pDescription` text,
//IN `pPathImage` varchar(60),
//IN `pCategory` int)
//BEGIN
//INSERT INTO `pw02`.`news`
//(`title`,
//`description`,
//`pathImage`,
//`category`)
//VALUES
//(pTitle,
//pDescription,
//pPathImage,
//pCategory);
//END$$
//
//DELIMITER ;
//
    public static int insertNews(News news) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL insertNews(?, ?, ?, ?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, news.getTitle());
            statement.setString(2, news.getDescription());
            statement.setString(3, news.getPathImage());
            statement.setInt(4, news.getCategory().getId());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }
//USE `pw02`;
//DROP procedure IF EXISTS `getNews`;
//
//DELIMITER $$
//USE `pw02`$$
//CREATE PROCEDURE `getNews` ()
//BEGIN
//SELECT `news`.`idnews`,
//    `news`.`title`,
//    `news`.`description`,
//    `news`.`pathImage`,
//    `news`.`category`
//FROM `pw02`.`news`;
//
//END$$
//
//DELIMITER ;
//

    public static List<News> getNews() {
        List<News> news = new ArrayList<>();
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL getNews();";
            CallableStatement statement = con.prepareCall(sql);
            
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt(1);
                String title = result.getString(2);
                String description = result.getString(3);
                String pathImage = result.getString(4);
                int idCategory = result.getInt(5);
                Category category = CategoryDAO.getCategory(idCategory);
                news.add(new News(id, title, description, pathImage, category));
            }
            return news;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return news;
    }
    
//  USE `pw02`;
//DROP procedure IF EXISTS `getNew`;
//
//DELIMITER $$
//USE `pw02`$$
//CREATE PROCEDURE `getNew` (
//IN `pIdnews` int)
//BEGIN
//
//SELECT `news`.`idnews`,
//    `news`.`title`,
//    `news`.`description`,
//    `news`.`pathImage`,
//    `news`.`category`
//FROM `pw02`.`news`
//WHERE `news`.`idnews` = pIdnews;
//
//END$$
//
//DELIMITER ;
//
  
    public static News getNew(int idNews) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL getNew(?);";
            CallableStatement statement = con.prepareCall(sql);
            
            statement.setInt(1, idNews);
            
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                int id = result.getInt(1);
                String title = result.getString(2);
                String description = result.getString(3);
                String pathImage = result.getString(4);
                int idCategory = result.getInt(5);
                Category category = CategoryDAO.getCategory(idCategory);
                return new News(id, title, description, pathImage, category);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return null;
    }

}
