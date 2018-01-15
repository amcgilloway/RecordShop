import db.DBAlbum;
import db.DBArtist;
import models.Album;
import models.Artist;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        DBAlbum.deleteAll();
        DBArtist.deleteAll();
        Artist artist1 = new Artist("Metallica");
        Artist artist2 = new Artist("AC/DC");
        DBArtist.save(artist1);
        DBArtist.save(artist2);
        System.out.println("Artist ID: " + artist1.getId());

        Album album1 = new Album("Black Album", "Rock", artist1);
        Album album2 = new Album("High Voltage", "Rock", artist2);
        DBAlbum.saveAlbum(album1);
        DBAlbum.saveAlbum(album2);

        List<Artist> artists = DBArtist.getArtists();
        for (Artist artist : artists){
            System.out.println(artist.getName());
        }
    }
}
