/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp3.st.utils;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javax.swing.JOptionPane;
import pp3.st.modelo.Servicio;

public class PDFUtil {

    private static final Font titulo = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
    private static final Font parrafo = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

    private static final Font categoria = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font subCategoria = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static final Font fontAzul = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLUE);
    private static final Font fontBold = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
    private static final String headImg = "src/pp3/st/recursos/logosuperior.png";

    public void mostrarReporte(Servicio s) {

        Document documento = new Document();

        String ruta = System.getProperty("user.home");

        try {
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/R-" + s.getIdservicio() + ".pdf"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDFUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(PDFUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        documento.open();
        documento.addTitle("MegaTecnología Servicio Técnico");

        Chunk linea = Chunk.NEWLINE;

        Image header = null;
        Image wsp = null;
        try {
            header = Image.getInstance("src/pp3/st/recursos/logosuperior2.png");
            header.scaleToFit(350, 650);
            header.setAlignment(Chunk.ALIGN_CENTER);

        } catch (BadElementException ex) {
            System.err.println(ex.getCause());

        } catch (IOException ex) {
            System.err.println(ex.getCause());
        }

        try {
            wsp = Image.getInstance("src/pp3/st/recursos/contacto.png");
        } catch (BadElementException ex) {
            System.err.println(ex.getCause());
        } catch (IOException ex) {
            System.err.println(ex.getCause());
        }

        wsp.setAlignment(Chunk.ALIGN_CENTER);
        wsp.scaleToFit(250, 400);

        Paragraph subt = new Paragraph();
        Paragraph pagoSubt = new Paragraph();
        Paragraph pago = new Paragraph();
        Paragraph contacto = new Paragraph();
        Paragraph espacio = new Paragraph();
        Paragraph fecha = new Paragraph();

        fecha.add(LocalDate.now().toString());
        fecha.setAlignment(Chunk.ALIGN_TOP);
        fecha.setAlignment(Chunk.ALIGN_RIGHT);
        contacto.setAlignment(Chunk.ALIGN_CENTER);
        subt.setAlignment(Chunk.ALIGN_CENTER);
        subt.setFont(fontAzul);
        espacio.add("\n");

        pagoSubt.setFont(fontBold);
        pagoSubt.add("\n Métodos de pago: \n");

        pago.add("\n Formas de pago: \n  "
                + "\nEfectivo, Débito, Transferencia \n"
                + "\nConsultar por pagos con tarjetas de crédito \n\n");

        //ESTRUCTURA TABLA CLIENTE
        PdfPTable tablaCliente = new PdfPTable(4);
        tablaCliente.addCell("DNI");
        tablaCliente.addCell("Apellido");
        tablaCliente.addCell("Nombre");
        tablaCliente.addCell("Teléfono");
        try {
            documento.add(espacio);
        } catch (DocumentException ex) {
            Logger.getLogger(PDFUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        //ESTRUCTURA TABLA ENCABEZADO SERVICIO TECNICO
        PdfPTable tablaST = new PdfPTable(6);
        tablaST.addCell("Tipo de orden ST");
        tablaST.addCell("ID Servicio Técnico");
        tablaST.addCell("Fecha Estimada");
        tablaST.addCell("Costo estimado");
        tablaST.addCell("Factura");
        tablaST.addCell("Tipo producto");

        //SINCRONIZACION DE DATOS DE TABLA  CLIENTE
        tablaCliente.addCell(s.getCliente().getDni());
        tablaCliente.addCell(s.getCliente().getApellido());
        tablaCliente.addCell(s.getCliente().getNombre());
        tablaCliente.addCell(s.getCliente().getTelefono());

        //ESTRUCTURA TABLA DETALLE SERVICIO TECNICO - 
        PdfPTable tablaDetalleST = new PdfPTable(1);
        tablaDetalleST.addCell("Detalle");

        //SINCRONIZACION DE DATOS TABLA SERVICIO TECNICO - DETALLE
        tablaDetalleST.addCell(s.getDetalle());

        //SINCRONIZACION DE DATOS DE TABLA SERVICIO TECNICO - ENCABEZADO
        tablaST.addCell(s.getTipoServicio().getDescripcion());
        tablaST.addCell(Integer.toString(s.getIdservicio()));
        tablaST.addCell(s.getFechaServicio().toString());
        tablaST.addCell("$"+s.getCosto());
        tablaST.addCell(s.getNumFactura());
        tablaST.addCell(s.getTipoProducto());
        try {
            documento.add(fecha);
            documento.add(header);

            documento.add(subt);
            documento.add(espacio);
            documento.add(tablaCliente);
            documento.add(espacio);
            documento.add(tablaST);
            documento.add(espacio);
            documento.add(tablaDetalleST);

            documento.add(espacio);
//            documento.add(pago);
//            documento.add(espacio);

            documento.add(wsp);

            documento.add(contacto);

            JOptionPane.showMessageDialog(null, "Documento creado exitosamente", "Atención", 1);
            documento.close();
        } catch (DocumentException e) {
            e.getMessage();
        }

    }
    
    
    
    
}
