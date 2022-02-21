package model;

import java.util.List;

public interface ImageDAO {

    void deleteImageById(int id);
    Image getImageById(int id);
    void updateImageCategory(int id);
    void deleteImagesByCategory(String category);
    List<Image> listImagesByCategory(String category);
    void addNewImage(Image image);

}

/**
 * A console admin-nal a kép tároló service-t lehet adminisztrálni.
 * Be lehet vele jelentkezni a szerverre (akár kapcsolódni az adatbázishoz is),
 * és az alábbi műveleteket lehet vele végrehajtani:
 *      kép törlése id alapján,
 *      kép letöltése id alapján,
 *      kép kategóriájának megváltoztatása,
 *      képek törlése kategóriák alapján,
 *      statisztika lekérdezése, melyik kategóriájú képből hány van, stb…
 */