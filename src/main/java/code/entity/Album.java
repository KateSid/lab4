package code.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_album", nullable = false)
    private int idAlbum;
    @ManyToOne
    @JoinColumn(name="id_artist")
    private Artist artist;
    @Column(name = "name_album", length = 50, nullable = false)
    private String nameAlbum;
    @Column(name = "genre", length = 50, nullable = false)
    private String genre;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="id_album")
    private Set<Composition> compositions= new HashSet<>();

    public Album(Artist artist, String nameAlbum, String genre, Set<Composition> compositions) {
        this.artist = artist;
        this.nameAlbum = nameAlbum;
        this.genre = genre;
        this.compositions = compositions;
    }
}
