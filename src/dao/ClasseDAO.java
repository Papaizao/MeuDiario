/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Aluno;
import beans.Classe;
import beans.Professor;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Walker.Souza
 */
public class ClasseDAO 
{
    private Connection conn;
    
    public ClasseDAO()
    {
        this.conn = new Conexao().getConexao();
        
    }
    public void inserir(String turma,int id, int ra)throws Exception
    {
        String sql = "INSERT INTO classe(turma,idProfessor,RAAluno) VALUES(?,?,?)";
        
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(2, id);
            stmt.setString(1,turma);
            stmt.setInt(3, ra);
            
            
            stmt.execute();
        }
        catch (Exception e) 
        {
            throw new Exception(e.getMessage());
        }
    }
    public void atualizar(double media, String turma)throws Exception
    {
        String sql = "UPDATE classe SET media=? WHERE turma= ?";
        
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
          
            stmt.setDouble(1, media);
            stmt.setString(2, turma);
            
            
            stmt.execute();
        }
        catch (Exception e) 
        {
            throw new Exception(e.getMessage());
        }
    }
    public void deletar (String turma) throws Exception
    {
        String sql = "DELETE FROM Classe where turma=?";
        
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, turma);
            
            stmt.execute();
        }
        catch (Exception e) 
        {
            throw new Exception(e.getMessage());
        }
        
    }
    public List<Classe> getClasses() throws Exception
    {
        List<Classe> lista = new ArrayList();
        
        String sql = "SELECT * FROM Classe ORDER BY turma";
        
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);            
            
            ResultSet rs = stmt.executeQuery();            
            while(rs.next())
            {
                Aluno a = new Aluno();
                a.setRA(rs.getInt("RAAluno"));

                Professor p = new Professor();
                p.setId(rs.getInt("idProfessor"));

                Classe c = new Classe();
                c.setProfessor(p.getId());
                c.setTurma(rs.getString("turma"));
                c.setAluno(a.getRA());
                c.setMedia(rs.getDouble("media"));
                
                lista.add(c);
            }
        }
        catch (Exception e) 
        {
            throw new Exception(e.getMessage());
        }          
             return lista;       
    }
    public List<Classe> getClasse(String texto) throws Exception
    {
        List<Classe> lista = new ArrayList();
        
        String sql = "SELECT * FROM Classe WHERE turma LIKE ?";
        
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, "%" + texto + "%");
            
            ResultSet rs = stmt.executeQuery();            
            while(rs.next())
            {
                Aluno a = new Aluno();
                a.setRA(rs.getInt("RAAluno"));

                Professor p = new Professor();
                p.setId(rs.getInt("idProfessor"));

                Classe c = new Classe();
                c.setProfessor(p.getId());
                c.setTurma(rs.getString("turma"));
                c.setAluno(a.getRA());
                c.setMedia(rs.getDouble("media"));
                
                lista.add(c);
            }
             return lista;
        }
        catch (Exception e) 
        {
            throw new Exception(e.getMessage());
        }            
      
    }
    public Classe getClass(String texto) throws Exception
    {
        
        
        String sql = "SELECT * FROM Classe WHERE turma = ?";
        
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, texto);
            
            ResultSet rs = stmt.executeQuery();
            rs.first();
            
            Aluno a = new Aluno();
            a.setRA(rs.getInt("RAAluno"));
            
            Professor p = new Professor();
            p.setId(rs.getInt("idProfessor"));
            
            Classe c = new Classe();
            c.setProfessor(p.getId());
            c.setTurma(rs.getString("turma"));
            c.setAluno(a.getRA());
            c.setMedia(rs.getDouble("media"));
            
            return c;
        }
        catch (Exception e) 
        {
            throw new Exception(e.getMessage());
        }          
       
    }
}

