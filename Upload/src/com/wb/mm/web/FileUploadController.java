package com.wb.mm.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

	public class FileUploadController {  
		  
	    public void handleFileUpload(FileUploadEvent event) throws IOException {
	    	System.out.println("Hello File up Loader");
	        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
	        System.out.println(event.getFile().getFileName()); 
	        File filez = new File(event.getFile().getFileName());
    		System.out.println(" This is suppose to work : " + filez.getCanonicalPath()); 
    		
    		
	        String path = FacesContext.getCurrentInstance().getExternalContext()
	                .getRealPath("/");
	        
	        UploadedFile file = event.getFile();
	        String fileName = file.getFileName();
	        long fileSize = file.getSize();
	        InputStream myInputStream = file.getInputstream();
	        
	        String nameFile = FilenameUtils.getName(event.getFile().getFileName());
	        
	        System.out.println("This is the : " + nameFile);
	        
	        InputStream inputStream = event.getFile().getInputstream();
	        OutputStream out = new FileOutputStream(new File(event.getFile().getFileName()));
	           		int read = 0;
	           		byte[] bytes = new byte[1024];
	        		while ((read = inputStream.read(bytes)) != -1) {
	        		out.write(bytes, 0, read);
	        		((PrintStream) out).println(read);
	        		}
	        		
	        		inputStream.close();
	        		
	        		out.flush();
	        		
	        		out.close();
	        //Save myInputStream in a directory of your choice and store that path in DB
	        /*try {
	        	 
	      	  String filename = "sample.xls";
	      	  String finalfile = "";
	      	  String workingDir = System.getProperty("user.dir");
	   
	      	  String your_os = System.getProperty("os.name").toLowerCase();
	      	  if(your_os.indexOf("win") >= 0){
	      		  finalfile = workingDir + "\\" + filename;
	      	  }else if(your_os.indexOf( "nix") >=0 || your_os.indexOf( "nux") >=0){
	      		  finalfile = workingDir + "/" + filename;
	      	  }else{
	      		  finalfile = workingDir + "{others}" + filename;
	      	  }
	   
	      	  System.out.println("Final filepath : " + finalfile);
	      	  File file = new File(finalfile);
	   
	  	  if (file.createNewFile()){
	  	     System.out.println("Done");
	  	  }else{
	  	     System.out.println("File already exists!");
	  	  }
	   
	      	} catch (IOException e) {
	  	     e.printStackTrace();*/
	        		
	        		 		
	  	     
	 try	
		{
		 		  
			FileInputStream filee = new FileInputStream(new File(filez.getCanonicalPath()));
			XSSFWorkbook wb = new XSSFWorkbook(filee);
			
			XSSFSheet sheet = wb.getSheetAt(0);
			
			Iterator<Row> rowIterator = sheet.iterator();
			while(rowIterator.hasNext())
			{
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				 
				while(cellIterator.hasNext())
				{
					Cell cell = cellIterator.next();
					switch (cell.getCellType())
					{
					case Cell.CELL_TYPE_NUMERIC:
						 System.out.print(cell.getNumericCellValue() + "\t");
						 break;
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue() + "\t");
						break;
					}
				    }
				    System.out.print(" ");
			   }
		
		        filee.close();
		     }
		     catch (Exception ex){
		    	 ex.printStackTrace();
		     }
		
	}

    }
	    
	
	
	

