package edu.tcu.cs.hogwartsartifactsonline.wizard;

import edu.tcu.cs.hogwartsartifactsonline.artifact.Artifact;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Wizard implements Serializable {
    @Id
    private Integer id;
    private String name;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "owner")
    private List<Artifact> artifiacts = new ArrayList<>();

    public Wizard() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Artifact> getArtifiacts() {
        return artifiacts;
    }

    public void setArtifiacts(List<Artifact> artifiacts) {
        this.artifiacts = artifiacts;
    }

    public void addArtifact(Artifact artifact) {
        artifact.setOwner(this);
        this.artifiacts.add(artifact);
    }

    public Integer getNumberOfArtifacts() {
        return this.artifiacts.size();
    }
}
