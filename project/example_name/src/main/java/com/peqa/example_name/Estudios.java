package com.peqa.example_name;

import java.util.List;
import java.util.ArrayList;


public class Estudios {
    List<Estudio> estudios = new ArrayList<Estudio>();

    public void agregarEstudio(String _institucion, String _titulo){
        Estudio estudio = new Estudio();
        estudio.setInstitucion(_institucion);
        estudio.setTitulo(_titulo);
        estudios.add(estudio);
    }

    public List<Estudio> getEstudios(){
        return estudios;
    }

    public int getCantidad(){
        return estudios.size();
    }
}
