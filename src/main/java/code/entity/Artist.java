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
@Table(name = "Artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_artist")
    private int idArtist;
    @Column(name = "name_artist", unique=true)
    private String nameArtist;
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="id_artist")
    private Set<Album> albums= new HashSet<>();

    public Artist(String nameArtist, Set<Album> albums) {
        this.nameArtist = nameArtist;
        this.albums = albums;
    }
}
