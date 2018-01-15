import db.DBArtist;
import models.Artist;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        DBArtist.deleteAll();
        Artist artist1 = new Artist("Metallica", 48);
        Artist artist2 = new Artist("AC/DC");
        DBArtist.save(artist1);
        DBArtist.save(artist2);
        System.out.println("Artist ID: " + artist1.getId());
        System.out.println("Artist Age: " + artist1.getAge());

        List<Artist> artists = DBArtist.getArtists();
        for (Artist artist : artists){
            System.out.println(artist.getName());
        }
    }
}
