package com.example.aspect.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bilhete")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class BilheteEntity implements Serializable {

    private static final long serialVersionUID = 8779843913102145041L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bilhete_id")
    private Integer id;

    @Column(name = "numero")
    private String numero;

    @ManyToOne(cascade = CascadeType.ALL)
    private ReservaEntity reservaEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @JsonIgnore
    public ReservaEntity getReservaEntity() {
        return reservaEntity;
    }

    public void setReservaEntity(ReservaEntity reservaEntity) {
        this.reservaEntity = reservaEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BilheteEntity that = (BilheteEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (numero != null ? !numero.equals(that.numero) : that.numero != null) return false;
        return reservaEntity != null ? reservaEntity.equals(that.reservaEntity) : that.reservaEntity == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (numero != null ? numero.hashCode() : 0);
        result = 31 * result + (reservaEntity != null ? reservaEntity.hashCode() : 0);
        return result;
    }
}
