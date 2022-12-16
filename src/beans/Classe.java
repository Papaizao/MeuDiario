/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author Walker.Souza
 */
public class Classe
{    
    private String turma;
    private int id;
    private int ra;
    private double media=0;
    
    public Classe()
    {
        
    }
    
    public double getMedia() {
        return media;
    }

    public void setMedia(double nota) {
        this.media = nota;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public int getId() {
        return id;
    }

    public void setProfessor(int id) {
        this.id = id;
    }

    public int getRA() {
        return ra;
    }

    public void setAluno(int ra) {
        this.ra = ra;
    }
            
}
