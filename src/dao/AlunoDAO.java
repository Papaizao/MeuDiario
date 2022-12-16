/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Aluno;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Walker.Souza
 */
public class AlunoDAO
{
    private Connection conn;
    
    public AlunoDAO()
    {
        this.conn = new Conexao().getConexao();
    }
    public void inserir(Aluno a)throws Exception
    {
        String sql = "INSERT INTO Aluno(RA,nome,CPF) VALUES(?,?,?)";
        
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(2, a.getNome());
            stmt.setInt(1, a.getRA());
            stmt.setString(3, a.getCPF());            
            stmt.execute();
        }
        catch (Exception e) 
        {
            throw new Exception(e.getMessage());
        }
    }
    public void atualizar(Aluno a)throws Exception
    {
        String sql = "UPDATE Aluno SET nome=?,CPF=? WHERE RA = ?";
        
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, a.getNome());
            stmt.setInt(3, a.getRA());
            stmt.setString(2, a.getCPF());            
            stmt.execute();
        }
        catch (Exception e) 
        {
            throw new Exception(e.getMessage());
        }
    }
    public void deletar (int a) throws Exception
    {
        String sql = "DELETE FROM Aluno where RA=?";
        
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, a);
            
            stmt.execute();
        }
        catch (Exception e) 
        {
            throw new Exception(e.getMessage());
        }
        
    }
    public List<Aluno> getAlunos() throws Exception
    {
        List<Aluno> lista = new ArrayList();
        
        String sql = "SELECT * FROM Aluno ORDER BY nome";
        
        try 
        {            
            PreparedStatement stmt = this.conn.prepareStatement(sql);            
            ResultSet rs = stmt.executeQuery();                  
            
             while(rs.next())
            {
                Aluno a = new Aluno();
                a.setCPF(rs.getString("CPF"));
                a.setNome(rs.getString("nome"));
                a.setRA(rs.getInt("RA"));                                
                
                lista.add(a);
            }            
        }
        catch (Exception e) 
        {
            throw new Exception(e.getMessage());
        }
        
        return lista;        
    }
    public Aluno getAluno(int RA) throws Exception
    {
        List<Aluno> lista = new ArrayList();
        
        String sql = "SELECT * FROM Aluno WHERE RA =?";
        
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, RA);
            
            ResultSet rs = stmt.executeQuery();
            rs.first();
            
            Aluno a = new Aluno();
            a.setCPF(rs.getString("CPF"));
            a.setNome(rs.getString("nome"));          
            a.setRA(rs.getInt("RA"));
            
            return a;
        }
        catch (Exception e) 
        {
            throw new Exception(e.getMessage());
        }     
    }
    public List<Aluno> filtro(String texto) throws Exception
    {
        
        List<Aluno> lista = new ArrayList();
        String sql = "SELECT * FROM Aluno WHERE nome LIKE ?";
        
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, "%" + texto + "%");
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
               Aluno a = new Aluno();
               a.setCPF(rs.getString("CPF"));
               a.setNome(rs.getString("nome"));         
               a.setRA(rs.getInt("RA"));  
               lista.add(a);
            }
            return lista;
        }
        catch (Exception e) 
        {
            throw new Exception(e.getMessage());
        }   
    }
}
