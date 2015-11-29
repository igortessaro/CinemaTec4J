/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.cinema.swing;

import com.jdf.swing.helper.JComboBoxHelper;
import com.jdf.swing.helper.jtable.JTableHelper;
import com.senac.cinema.Controller.FilmeController;
import com.senac.cinema.Controller.SalaController;
import com.senac.cinema.Controller.SecaoController;
import com.senac.cinema.Domain.Filme;
import com.senac.cinema.Domain.Sala;
import com.senac.cinema.Domain.Secao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Igor
 */
public class jiFrameSecao extends javax.swing.JInternalFrame {

    private final SalaController salaController;
    private final FilmeController filmeComtroller;
    private final SecaoController controller;
    private final JTableHelper<Secao> tableHelper;

    public jiFrameSecao() {
        this.salaController = new SalaController();
        this.filmeComtroller = new FilmeController();
        this.controller = new SecaoController();
        initComponents();
        this.atualizarCombos();
        tableHelper = new JTableHelper<>(tbSecao);
        this.pesquisar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDataInicio = new javax.swing.JTextField();
        lblHoraInicio = new javax.swing.JLabel();
        txtHoraInicio = new javax.swing.JTextField();
        lblTempoDuracao = new javax.swing.JLabel();
        txtTempoDuracao = new javax.swing.JTextField();
        lblSala = new javax.swing.JLabel();
        cbSalas = new javax.swing.JComboBox<>();
        lblFilme = new javax.swing.JLabel();
        cbFilmes = new javax.swing.JComboBox<>();
        scrollPaneSecoes = new javax.swing.JScrollPane();
        tbSecao = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JToggleButton();
        btnSalvar = new javax.swing.JToggleButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        lblCodigo.setText("Código");

        jLabel1.setText("Data de Inicio");

        lblHoraInicio.setText("Hora Inicio");

        lblTempoDuracao.setText("Tempo de Duração");

        lblSala.setText("Sala");

        cbSalas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblFilme.setText("Filme");

        cbFilmes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tbSecao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbSecao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSecaoMouseClicked(evt);
            }
        });
        scrollPaneSecoes.setViewportView(tbSecao);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCodigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataInicio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblHoraInicio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblTempoDuracao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTempoDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollPaneSecoes, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblFilme)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbFilmes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lblSala)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbSalas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHoraInicio)
                    .addComponent(txtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTempoDuracao)
                    .addComponent(txtTempoDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSala)
                    .addComponent(cbSalas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFilme))
                .addGap(27, 27, 27)
                .addComponent(scrollPaneSecoes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnLimpar)
                    .addComponent(btnSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String idString = txtCodigo.getText();

        if (idString != null && !idString.isEmpty()) {
            int codigo = Integer.parseInt(idString);

            try {
                controller.excluir(codigo);
                JOptionPane.showMessageDialog(this, "Seção excluida com sucesso.");
                this.pesquisar();
                this.btnLimparActionPerformed(null);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    public void pesquisar() {
        List<Secao> secaoList = null;

        secaoList = this.controller.obterTodos();

        tableHelper.setModel(secaoList);
    }

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtCodigo.setText(null);
        txtDataInicio.setText(null);
        txtHoraInicio.setText(null);
        txtTempoDuracao.setText(null);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String codigo = txtCodigo.getText();
        Secao entity = new Secao();
        try {
            if (codigo != null && !codigo.isEmpty()) {
                entity.setId(Integer.parseInt(codigo));
            }

            String data = txtDataInicio.getText();
            String hora = txtHoraInicio.getText();

            String dataHora = data + ' ' + hora;

            String format = "dd/MM/yyyy HH:mm";

            SimpleDateFormat sdf = new SimpleDateFormat(format);

            entity.setDataHoraInicio(sdf.parse(dataHora));

            entity.setTempoDuracaoMinutos(Integer.parseInt(txtTempoDuracao.getText()));

            Filme filme = (Filme)cbFilmes.getSelectedItem();
            entity.setFilmeId(filme.getId());

            Sala sala = (Sala)cbSalas.getSelectedItem();
            entity.setSalaId(sala.getId());

            if (entity.getId() > 0) {
                this.controller.atualizar(entity);
                JOptionPane.showMessageDialog(this, "Seção atualizada com sucesso.");
            } else {
                this.controller.adicionar(entity);
                JOptionPane.showMessageDialog(this, "Seção salva com sucesso.");
            }

            this.pesquisar();
            this.btnLimparActionPerformed(null);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void tbSecaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSecaoMouseClicked
        Integer id = tableHelper.getSelectedObject().getId();
        txtCodigo.setText(id.toString());

        Integer tempoDuracao = tableHelper.getSelectedObject().getTempoDuracaoMinutos();
        txtTempoDuracao.setText(tempoDuracao.toString());

        cbFilmes.setSelectedItem(tableHelper.getSelectedObject().getFilme());
        cbSalas.setSelectedItem(tableHelper.getSelectedObject().getSala());

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        Date dataHoraInicio = tableHelper.getSelectedObject().getDataHoraInicio();        
        String dataInicio = df.format(dataHoraInicio);
        
        txtDataInicio.setText(dataInicio);
        
        df = new SimpleDateFormat("HH:mm");
        String horaInicio = df.format(dataHoraInicio);
        
        txtHoraInicio.setText(horaInicio);
    }//GEN-LAST:event_tbSecaoMouseClicked

    public void atualizarCombos() {
        JComboBoxHelper chSala = new JComboBoxHelper(cbSalas);
        chSala.setModel(this.salaController.obterTodos());

        JComboBoxHelper chFilme = new JComboBoxHelper(cbFilmes);
        chFilme.setModel(this.filmeComtroller.obterTodos());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JToggleButton btnLimpar;
    private javax.swing.JToggleButton btnSalvar;
    private javax.swing.JComboBox<String> cbFilmes;
    private javax.swing.JComboBox<String> cbSalas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblFilme;
    private javax.swing.JLabel lblHoraInicio;
    private javax.swing.JLabel lblSala;
    private javax.swing.JLabel lblTempoDuracao;
    private javax.swing.JScrollPane scrollPaneSecoes;
    private javax.swing.JTable tbSecao;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDataInicio;
    private javax.swing.JTextField txtHoraInicio;
    private javax.swing.JTextField txtTempoDuracao;
    // End of variables declaration//GEN-END:variables
}
