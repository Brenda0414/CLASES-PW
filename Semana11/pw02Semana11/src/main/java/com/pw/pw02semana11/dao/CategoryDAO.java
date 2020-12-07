/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pw.pw02semana11.dao;

import com.pw.pw02semana11.models.Category;
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
public class CategoryDAO {

//    CREATE TABLE `pw02`.`category` (
//  `idcategory` INT NOT NULL AUTO_INCREMENT,
//  `name` VARCHAR(60) NULL,
//  `order` INT NULL,
//  `parent` INT NULL,
//  PRIMARY KEY (`idcategory`),
//  UNIQUE INDEX `idcategory_UNIQUE` (`idcategory` ASC) VISIBLE);
//ALTER TABLE `pw02`.`category` 
//ADD INDEX `fk_parent_category_idx` (`parent` ASC) VISIBLE;
//;
//ALTER TABLE `pw02`.`category` 
//ADD CONSTRAINT `fk_parent_category`
//  FOREIGN KEY (`parent`)
//  REFERENCES `pw02`.`category` (`idcategory`)
//  ON DELETE NO ACTION
//  ON UPDATE NO ACTION;
//    USE `pw02`;
//    DROP procedure IF EXISTS `insertCategory`;
//
//    DELIMITER $$
//    USE `pw02`$$
//    CREATE PROCEDURE `insertCategory` (
//    IN `pName` varchar(60),
//    IN `pOrder` int,
//    IN `pParent` int)
//    BEGIN
//    INSERT INTO `pw02`.`category`
//    (`name`,
//    `order`,
//    `parent`)
//    VALUES
//    (pName,
//    pOrder,
//    pParent);
//
//    END$$
//
//    DELIMITER ;
    public static int insertCategory(Category category) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL insertCategory(?,?,?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, category.getName());
            statement.setInt(2, category.getOrder());
            statement.setInt(3, category.getParent());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }

//USE `pw02`;
//DROP procedure IF EXISTS `getCategories`;
//
//USE `pw02`;
//DROP procedure IF EXISTS `pw02`.`getCategories`;
//;
//
//DELIMITER $$
//USE `pw02`$$
//CREATE DEFINER=`root`@`localhost` PROCEDURE `getCategories`()
//BEGIN
//SELECT `category`.`idcategory`,
//    `category`.`name`,
//    `category`.`order`,
//    `category`.`parent`
//FROM `pw02`.`category`
//ORDER BY `category`.`order`, `category`.`name`;
//
//END$$
//
//DELIMITER ;
    public static List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL getCategories();";
            CallableStatement statement = con.prepareCall(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt(1);
                String name = result.getString(2);
                int order = result.getInt(3);
                int parent = result.getInt(4);
                categories.add(new Category(id, name, order, parent));
            }
            return categories;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return categories;
    }
    
//    USE `pw02`;
//DROP procedure IF EXISTS `getCategory`;
//
//DELIMITER $$
//USE `pw02`$$
//CREATE PROCEDURE `getCategory` (
//IN `pIdcategory` int
//)
//BEGIN
//SELECT `category`.`idcategory`,
//    `category`.`name`,
//    `category`.`order`,
//    `category`.`parent`
//FROM `pw02`.`category`
//WHERE `category`.`idcategory` = pIdcategory;
//END$$
//
//DELIMITER ;
//

    public static Category getCategory(int idCategory) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL getCategory(?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, idCategory);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt(1);
                String name = result.getString(2);
                int order = result.getInt(3);
                int parent = result.getInt(4);
                return new Category(id, name, order, parent);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

}
