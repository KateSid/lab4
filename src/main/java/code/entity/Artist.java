package code.entity;

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
    @Column(name = "name_artist")
    private String nameArtist;
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Album.class,mappedBy = "artist")
    private Set<Album> albums= new HashSet<>();

}
