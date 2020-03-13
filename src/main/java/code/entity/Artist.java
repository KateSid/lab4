package code.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_artist", updatable = false, nullable = false)
    private int idArtist;
    @Column(name = "name_artist", length = 50, nullable = false)
    private String nameArtist;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Artist")
    private ArrayList<Album> albums;

}
