package model;


import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.base64.Base64;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ImageDaoJdbc implements ImageDAO{
    DataSource ds;


    public void deleteImageById(String id) {
        try(Connection c = ds.getConnection()) {
            String query = "DELETE FROM image WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, id.toString());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException();
        }
    }

    public Image getImageById(String id) {
        UUID uuid = UUID.fromString(id);
        try(Connection c = ds.getConnection()) {
            String query = "SELECT id, category, content, extension FROM image WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setObject(1, uuid);
            ResultSet rs = ps.executeQuery();
            byte[] content = rs.getBytes(3);
            Image image = new Image(uuid, rs.getString(2), content, rs.getString(4) );
            return image;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public String getStringImgFromBytes (byte[] bytes) {
        String result = new String(Base64.encode(bytes));
        return result;
    }


    public void updateImageCategory(String id, String category) {
        UUID uuid = UUID.fromString(id);
        try(Connection c = ds.getConnection()) {
            String query = "UPDATE image SET category = ? WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, category);
            ps.setObject(2, uuid);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException();
        }
    }

    public void deleteImagesByCategory(String category) {
        try(Connection c = ds.getConnection()) {
            String query = "DELETE FROM image WHERE category = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, category);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException();
        }
    }

    public List<Image> listImagesByCategory(String category) {
        List<Image> images = new ArrayList<>();
        try(Connection c =ds.getConnection()) {
            String query = "SELECT id, category, content, extension FROM image WHERE category = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                byte[] content = rs.getBytes(3);
                UUID uuid = UUID.fromString(rs.getString(1));
                Image image = new Image(uuid, rs.getString(2), content, rs.getString(4));
                images.add(image);
            }
            return images;
        } catch (SQLException throwables) {
            throw new RuntimeException();
        }
    }

    public void addNewImage(Image image) {
        try(Connection c =ds.getConnection()) {
            String query = "INSERT INTO image VALUES(?, ?, ?, ?)";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setObject(1, image.getUuid());
            ps.setString(2, image.getCategory());
            ps.setString(3, image.getContent().toString());
            ps.setString(4, image.getExtension());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException();
        }
    }
}
