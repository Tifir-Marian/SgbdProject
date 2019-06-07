/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractclass.components;

import java.awt.BorderLayout;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author User
 */
public abstract class Tabel extends JFrame{
    protected String columns[];
    protected String rows[][];
    protected JTable albumTable;
    
    protected Tabel()
    {
        init();
    }
    
    protected void init()
    {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(rootPaneCheckingEnabled);
 
    }
    protected void setData(String columns[],List<String[]> rows)
    {
        this.columns=columns;
        this.rows= new String[rows.size()][];
        int liniaCurrenta=0;
        for(String[] index : rows)
        { 
            
            List<String> tmp =Arrays.asList(index);
            String[] linieCompleta = new String[Arrays.asList(index).size()];
            int auxiliar=0;
            for (String indexColoane : tmp)
            {
                linieCompleta[auxiliar]=indexColoane;          
                auxiliar++;
            }
            this.rows[liniaCurrenta]=linieCompleta;
            liniaCurrenta++;
        }
        setTable(columns,this.rows);
    }

    public String[] getColumns() {
        return columns;
    }

    public String[][] getRows() {
        return rows;
    }
    void setTable(String[] columns,String[][] rows){
        albumTable = new JTable(rows,columns);
        albumTable.setFillsViewportHeight(rootPaneCheckingEnabled);
        JScrollPane albumScroll = new JScrollPane(albumTable);
        add(albumScroll,BorderLayout.CENTER);
    }
    JTable getTable(){
        return albumTable;
    }
}
