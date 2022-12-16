/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


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
public class ProfessorDAO 
{
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

    private Connection conn;
    
    public ProfessorDAO()
    {
        this.conn = new Conexao().getConexao();
    }
    public void inserir(Professor p)throws Exception
    {
        String sql = "INSERT INTO Professor(id,nome,CPF) VALUES(?,?,?)";
        
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(2, p.getNome());
            stmt.setInt(1,p.getId());
            stmt.setString(3, p.getCPF());
            
            stmt.execute();
        }
        catch (Exception e) 
        {
            throw new Exception(e.getMessage());
        }
    }
    public void atualizar(Professor p)throws Exception
    {
        String sql = "UPDATE Professor SET nome=?,CPF=? WHERE id = ?";
        
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setInt(3, p.getId());
            stmt.setString(2, p.getCPF());
            
            stmt.execute();
        }
        catch (Exception e) 
        {
            throw new Exception(e.getMessage());
        }
    }
    public void deletar (int id) throws Exception
    {
        String sql = "DELETE FROM Professor WHERE id=?";
        
        try 
        {
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            stmt.execute();
        }
        catch (Exception e) 
        {
            throw new Exception(e.getMessage());
        }
        
    }
    public Professor getProfessor(int id) throws Exception
    {
        
        Professor p = new Professor();
        String sql = "SELECT * FROM Professor WHERE id = ? ORDER BY nome";
        
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            rs.first();
            
            p.setCPF(rs.getString("CPF"));
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
        }
        catch (Exception e) 
        {
            throw new Exception(e.getMessage());
        }
        
        return p;        
    }
    public List<Professor> getProfessores() throws Exception
    {
        List<Professor> lista = new ArrayList();
        
        String sql = "SELECT * FROM Professor";
        
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
            
                Professor p = new Professor();
                p.setCPF(rs.getString("CPF"));
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));

                lista.add(p);
            }
        }
        catch (Exception e) 
        {
            throw new Exception(e.getMessage());
        }
            
        return lista;
    }
}


