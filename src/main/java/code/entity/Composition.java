package code.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Composition")
public class Composition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_composition", updatable = false, nullable = false)
    private int idComposition;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_album")
    private Album album;
    @Column(name = "name_composition", length = 50, nullable = false)
    private int nameComposition;
    @Column(name = "duration", length = 50, nullable = false)
    private int duration;
}
