package code.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_artist")
    private Artist artist;
    @Column(name = "name_album", length = 50, nullable = false)
    private String nameAlbum;
    @Column(name = "genre", length = 50, nullable = false)
    private String genre;
    @OneToMany( fetch = FetchType.LAZY, targetEntity = Composition.class,mappedBy = "album")
    private List<Composition> compositions;

}
