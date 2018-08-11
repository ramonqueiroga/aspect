package com.example.aspect.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.apache.commons.collections4.CollectionUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reserva")
public class ReservaEntity implements Serializable {

    private static final long serialVersionUID = -1975058715458929897L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reserva_id")
    private Integer id;

    @Column(name = "localizador")
    private String localizador;

    @OneToMany(mappedBy = "reservaEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BilheteEntity> bilhetes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocalizador() {
        return localizador;
    }

    public void setLocalizador(String localizador) {
        this.localizador = localizador;
    }

    public List<BilheteEntity> getBilhetes() {
        return bilhetes;
    }

    public void setBilhetes(List<BilheteEntity> bilhetes) {
        this.bilhetes = bilhetes;
    }

    public void addBilhete(BilheteEntity bilheteEntity) {
        if(CollectionUtils.isEmpty(this.bilhetes)) {
            this.bilhetes = new ArrayList<>();
        }
        this.bilhetes.add(bilheteEntity);
    }

}
