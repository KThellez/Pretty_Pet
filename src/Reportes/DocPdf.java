/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import Controlador.Controlador;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class DocPdf {
    
    private void pdf() {

        try {
            FileOutputStream pdf;
            File file = new File("src/Pdfs/venta.pdf");
            pdf = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, pdf);
            
            doc.open();

            Image img = Image.getInstance("src/Imagenes/logo.png");

            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.CYAN);
            fecha.add(Chunk.NEWLINE);
            Date date = new Date();
            fecha.add("# Factura: 1" + "Fecha: " + new SimpleDateFormat("dd-mm-yyyy").format(date) + "\n\n");

            PdfPTable encabezado = new PdfPTable(4);
            encabezado.setWidthPercentage(100);
            encabezado.getDefaultCell().setBorder(0);
            float[] ColumnEncabezado = new float[]{20f, 30f, 70f, 40f};
            encabezado.setWidths(ColumnEncabezado);
            encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);

            encabezado.addCell(img);

            String id = "20192578003";
            String nom = "PetPrettyStore";
            String tel = "3123326913";
            String direc = "Bogota D.C - Colombia";

            encabezado.addCell("Id: " + id + "\nNombre: " + nom + "\nTelefono: "
                    + tel + "\nDireccion: " + direc);

            encabezado.addCell(fecha);

            doc.add(encabezado);

            doc.close();
            pdf.close();

        } catch (ExceptionInInitializerError ex) {
            JOptionPane.showInputDialog(ex.getMessage());
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
