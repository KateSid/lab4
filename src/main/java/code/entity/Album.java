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
@Table(name = "Album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_album", updatable = false, nullable = false)
    private int idAlbum;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_artist")
    private Artist artist;
    @Column(name = "name_album", length = 50, nullable = false)
    private String nameAlbum;
    @Column(name = "genre", length = 50, nullable = false)
    private String genre;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Album")
    private ArrayList<Composition> compositions;

}
