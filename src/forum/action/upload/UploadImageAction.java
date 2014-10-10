package forum.action.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadImageAction extends ActionSupport{
	private static final long serialVersionUID = 1957465159328752330L;
	
	private File imageFile;
    private String imageName;
    private Map<String, String> jsonMap = new HashMap<String, String>();
                                                               
    public File getImageFile() {
        return imageFile;
    }
                                                           
    public void setImageFile(File imageFile) {
        this.imageFile = imageFile;
    }
                                                           
    public String getImageName() {
        return imageName;
    }
                                                           
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
                                                               
    public Map<String, String> getJsonMap() {
        return jsonMap;
    }
                                                           
    public void setJsonMap(Map<String, String> jsonMap) {
        this.jsonMap = jsonMap;
    }
                                                           
    public String uploadImage(){
        try {  
        	String savePath = ServletActionContext.getServletContext().getRealPath("/images/upload");
            FileOutputStream fos = new FileOutputStream(savePath + "\\" + this.getImageName());
            FileInputStream fis = new FileInputStream(getImageFile());
            byte[] buffer = new byte[1024 * 1024];  
            int length = 0;  
            while ((length = fis.read(buffer)) > 0) {  
                fos.write(buffer, 0, length);  
            }  
            fis.close();
            fos.close();
            String uploadedImageFilePath = "..\\"+ "images\\upload\\" +this.getImageName();
            jsonMap.put("serverImagePath", uploadedImageFilePath);
        } catch (FileNotFoundException ex) {  
            ex.printStackTrace();  
        } catch (IOException ex) {  
            ex.printStackTrace();  
        } 
        return "success";
    }
}
