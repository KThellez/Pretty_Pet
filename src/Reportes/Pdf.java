/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import Modelo.*;
import Vista.*;
import com.itextpdf.text.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
public class Pdf {

    private File ruta_destino;
   
    private String codigoCliente;

    public Pdf() {
        ruta_destino = null;
            }

    

    /* metodo que hace uso de la clase itext para manipular archivos PDF*/
    public void crear_PDF(String t, String a, String k, /*Object p, String m, */ String dato,
            Costumer cliente, NewSale venta) {
        //abre ventana de dialogo "guardar"
        //Colocar_Destino();

        //si destino es diferente de null
        //if (this.ruta_destino != null) {
        
        String cod = CodAleatorio.getRandomString(3);
        
        try {
            VentaDAO veni = new VentaDAO();
            File file = new File("src/Pdfs/" + dato + "-" +veni.IdVenta()+".pdf");
            // se crea instancia del documento
            try (FileOutputStream pdfOS = new FileOutputStream(file)) {
                // se crea instancia del documento
                Document pdf = new Document();
                // se establece una instancia a un documento pdf
                PdfWriter.getInstance(pdf, pdfOS);
                pdf.open();// se abre el documento
                pdf.add(new Chunk(""));

                pdf.addTitle(t); // se añade el titulo
                pdf.addAuthor(a); // se añade el autor del documento
                //pdf.addSubject(s); //se añade el asunto del documento
                pdf.addKeywords(k); //Se agregan palabras claves
                //pdf.add(new Paragraph(""+p+"\n"));
                //pdf.add(new Paragraph(""+m+"\n"));

                Image img = Image.getInstance("src/Imagenes/logo.png");

                Paragraph fecha = new Paragraph();
                Font fuente = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
                fecha.add(Chunk.NEWLINE);
                Date date = new Date();

                fecha.add("Factura:"+ veni.IdVenta()+"\n Codigo: "+cod+" \n" + "Fecha: " + new SimpleDateFormat("dd-mm-yyyy").format(date) + "\n\n");

                PdfPTable encabezado = new PdfPTable(4);
                encabezado.setWidthPercentage(100);
                encabezado.getDefaultCell().setBorder(0);
                float[] ColumnEncabezado = new float[]{10f, 30f, 70f, 40f};
                encabezado.setWidths(ColumnEncabezado);
                encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);

                encabezado.addCell(img);
                DatosEmpresa empresa = new DatosEmpresa();
                
                String id = empresa.getTxtID().getText();
                String nom = empresa.getTxtName().getText();
                String tel = empresa.getTxtPhone().getText();
                String direc = empresa.getTxtAddress().getText();

                encabezado.addCell("");
                encabezado.addCell("Id: " + id + "\nNombre: " + nom + "\nTelefono: "
                        + tel + "\nDireccion: " + direc);

                encabezado.addCell(fecha);
                pdf.add(encabezado);

                Paragraph cli = new Paragraph();
                cli.add(Chunk.NEWLINE);
                cli.add("Datos de clientes:" + "\n\n");
                pdf.add(cli);

                PdfPTable tablaCli = new PdfPTable(4);
                tablaCli.setWidthPercentage(100);
                tablaCli.getDefaultCell().setBorder(0);
                float[] ColumnCli = new float[]{20f, 50f, 30f, 40f};
                tablaCli.setWidths(ColumnCli);
                tablaCli.setHorizontalAlignment(Element.ALIGN_LEFT);

                PdfPCell cl1 = new PdfPCell(new Phrase("Id",fuente));
                PdfPCell cl2 = new PdfPCell(new Phrase("Nombre",fuente));
                PdfPCell cl3 = new PdfPCell(new Phrase("Telefono:",fuente));
                PdfPCell cl4 = new PdfPCell(new Phrase("Direccion",fuente));
                cl1.setBorder(0);
                cl2.setBorder(0);
                cl3.setBorder(0);
                cl4.setBorder(0);
                
                cl1.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cl2.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cl3.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cl4.setBackgroundColor(BaseColor.LIGHT_GRAY);
                
                tablaCli.addCell(cl1);
                tablaCli.addCell(cl2);
                tablaCli.addCell(cl3);
                tablaCli.addCell(cl4);

                tablaCli.addCell(venta.getTxtCustomerId().getText());
                tablaCli.addCell(venta.getTxtCustomerName().getText() + " "
                        + venta.getTxtCustomerLastName().getText());
                tablaCli.addCell(cliente.getTxtPhone().getText());
                tablaCli.addCell(cliente.getTxtAddress().getText());

                pdf.add(tablaCli);

                ///////////
                PdfPTable tablaVen = new PdfPTable(5);
                tablaVen.setWidthPercentage(100);
                tablaVen.getDefaultCell().setBorder(0);
                float[] ColumnVen = new float[]{20f, 50f, 30f, 40f, 40f};
                tablaVen.setWidths(ColumnVen);
                tablaVen.setHorizontalAlignment(Element.ALIGN_LEFT);

                PdfPCell pr1 = new PdfPCell(new Phrase("Codigo de Barras" ,fuente));
                PdfPCell pr2 = new PdfPCell(new Phrase("Nombre",fuente));
                PdfPCell pr3 = new PdfPCell(new Phrase("Cantidad:",fuente));
                PdfPCell pr4 = new PdfPCell(new Phrase("Precio Unitario",fuente));
                PdfPCell pr5 = new PdfPCell(new Phrase("Precio Total",fuente));
                pr1.setBorder(0);
                pr2.setBorder(0);
                pr3.setBorder(0);
                pr4.setBorder(0);
                pr5.setBorder(0);
                tablaVen.addCell(pr1);
                tablaVen.addCell(pr2);
                tablaVen.addCell(pr3);
                tablaVen.addCell(pr4);
                tablaVen.addCell(pr5);
                /*
                tablaVen.addCell(venta.getTxtIdCode().getText());
                tablaVen.addCell(venta.getTxtName().getText());
                tablaVen.addCell(venta.getTxtAmount().getText());
                tablaVen.addCell(venta.getTxtPrice().getText());
                tablaVen.addCell(venta.getTxtTotalToPay().getText());*/

                for (int i = 0; i < venta.getTablaNewSale().getRowCount(); i++) {
                    String code = venta.getTablaNewSale().getValueAt(i, 0).toString();
                    String name = venta.getTablaNewSale().getValueAt(i, 1).toString();
                    String amount = venta.getTablaNewSale().getValueAt(i, 3).toString();
                    String price = venta.getTablaNewSale().getValueAt(i, 4).toString();
                    String total = venta.getTablaNewSale().getValueAt(i, 5).toString();
                    tablaVen.addCell(code);
                    tablaVen.addCell(name);
                    tablaVen.addCell(amount);
                    tablaVen.addCell(price);
                    tablaVen.addCell(total);
                }
                
                pdf.add(tablaVen);
                
                Paragraph info = new Paragraph();
                
                info.add(Chunk.NEWLINE);
                info.add("total a pagar: " + venta.getTxtTotalToPay().getText());
                info.setAlignment(Element.ALIGN_RIGHT);
                
                pdf.add(info);
                
                Paragraph firma = new Paragraph();
                firma.add(Chunk.NEWLINE);
                firma.add("Firma:\n\n----------------------- ");
                firma.setAlignment(Element.ALIGN_CENTER);
                
                pdf.add(firma);
                
                Paragraph mensaje = new Paragraph();
                mensaje.add(Chunk.NEWLINE);
                mensaje.add("Gracias por su compra, vuelva pronto");
                mensaje.add("\n\nContactenos\n\n");
                mensaje.add(empresa.getTxtEmailAddress().getText());
                mensaje.setAlignment(Element.ALIGN_CENTER);
                
                pdf.add(mensaje);

                // se añade el contendio del PDF
                pdf.close(); //se cierra el PDF&
                pdfOS.close();
            }
            JOptionPane.showMessageDialog(null, "Documento PDF creado");

            Desktop.getDesktop().open(file);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error PDF " + ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(Pdf.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*abre la ventana de dialogo GUARDAR*/
    public void Colocar_Destino() {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo PDF", "pdf", "PDF");
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            this.ruta_destino = fileChooser.getSelectedFile().getAbsoluteFile();

        }
    }

    public File getRuta_destino() {
        return ruta_destino;
    }

    public void setRuta_destino(File ruta_destino) {
        this.ruta_destino = ruta_destino;
    }
    
}
