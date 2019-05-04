/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import JavaBeans.DocumentFacade;
import entities.Document;
import entities.User;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

/**
 *
 * @author ahmed
 */
@Named(value = "fileupload")
@SessionScoped
public class fileupload implements Serializable {
     @EJB
    private DocumentFacade documentfacade;
    private Part file;
    Document doc = new Document();
   

    /**
     * Creates a new instance of fileupload
     */
    public fileupload() {
    }
    public void upload() throws IOException {
                FacesContext facesContext = FacesContext.getCurrentInstance();
               
        
        User x=(User)facesContext.getExternalContext().getSessionMap().get("user");
        Scanner s = new Scanner(getFile().getInputStream());

        String fileContent = s.useDelimiter("\\A").next();
                                        s.close();

        Files.write(Paths.get("F:\\"+file.getSubmittedFileName()), fileContent.getBytes(),StandardOpenOption.CREATE);
        doc.setIdUser(x);
        doc.setPath("F:\\"+file.getSubmittedFileName());
        doc.setNomDoc(file.getSubmittedFileName());
        doc.setType("");
        this.documentfacade.create(doc);

    }

    /**
     * @return the file
     */
    public Part getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(Part file) {
        this.file = file;
    }
    
}
