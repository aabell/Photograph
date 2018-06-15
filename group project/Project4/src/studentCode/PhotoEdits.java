package studentCode;

import java.awt.Color;

import photograph.Photograph;
import photograph.PictureUtil;
import photograph.Pixel;

public class PhotoEdits {
	/**
	 * Retains only the blue channel from a photograph
	 * 
	 * @param photo A photograph
	 * @return A new Photograph with the red and green channels removed
	 */
	public static Photograph makeBlue(Photograph photo)
	{
		// Make sure the photograph exists before changing it
		if (photo == null)
			return photo;   // return null if there's no photo
		
		// Return null if other consistency checks fail. None apply here.
		
		// Create a new photograph of same size so we don't clobber
		// the input
		Photograph result = new Photograph(photo.getWd(), photo.getHt());
		
		// For each pixel in the photograph
		for (int y = 0; y < photo.getHt(); y++) {
			for (int x = 0; x < photo.getWd(); x++) {
				Pixel pin = photo.getPixel(x, y); //get the original pixel
				Pixel pout = new Pixel(0,0 , pin.getBlue()); // create a new pixel
				// pout only keeps the blue 'channel' from the original photograph
				
				result.setPixel(x,y , pout); // write the pixel to the new photograph
			}
		}
		
		return result; // return the new photograph
	} // END makeBlue
	
	/*
	 * Here you add your own code.  I no longer supply the starter code for
	 * each method - you need to create the full code according to the project
	 * specification in ELMS.
	 */

	public static Photograph makeGreen(Photograph photo)
	{
		
		if (photo == null)
			return photo;   
		Photograph result = new Photograph(photo.getWd(), photo.getHt());
		
		
		for (int y = 0; y < photo.getHt(); y++) {
			for (int x = 0; x < photo.getWd(); x++) {
				Pixel pin = photo.getPixel(x, y); 
				Pixel pout = new Pixel(0 , pin.getGreen(),0); 
				
				result.setPixel(x,y,pout); 
			}
		}
		return result;
	}
	public static Photograph makeRed(Photograph photo)
	{
		
		if (photo == null)
			return photo;   
		Photograph result = new Photograph(photo.getWd(), photo.getHt());
		
		
		for (int y = 0; y < photo.getHt(); y++) {
			for (int x = 0; x < photo.getWd(); x++) {
				Pixel pin = photo.getPixel(x, y); 
				Pixel pout = new Pixel( pin.getRed(),0,0); 
				
				result.setPixel(x,y,pout); 
			}
		}
		return result;
	}
	public static Photograph dim(Photograph photo,double n)
	{
		if (photo == null || n<=0.0 || n>1)
			return null;
		
Photograph result = new Photograph(photo.getWd(), photo.getHt());
		
		
		for (int y = 0; y < photo.getHt(); y++) {
			for (int x = 0; x < photo.getWd(); x++) {
				Pixel pin = photo.getPixel(x, y);
				int Red,Green,Blue;
								Pixel pout = new Pixel((int) (pin.getRed()*n),(int) (pin.getGreen()*n),(int)(pin.getBlue()*n)); 
				
				result.setPixel(x,y,pout);
	}
	}
	return result;
	}
	public static Photograph flipVertical (Photograph photo)
	{
		
		Photograph result = new Photograph(photo.getWd(), photo.getHt());	
		for (int i=0;i<photo.getWd();i++)
	        for (int j=0;j<photo.getHt()/2;j++)
	        {
	        	Pixel pin = photo.getPixel(i, j);
	        result.setPixel(i, j, photo.getPixel(i, photo.getHt()-j-1));
	            result.setPixel(i, photo.getHt()-j-1, pin);
	        }
		return result;
	}
	public static Photograph flipHorizontal (Photograph photo){
		Photograph result = new Photograph(photo.getWd(), photo.getHt());
		for (int i=0;i<photo.getWd()/2;i++)
	        for (int j=0;j<photo.getHt();j++)
	        {
	        	Pixel pin1 = photo.getPixel(i,j);
	            Pixel pin = photo.getPixel(photo.getWd()-(i+1), j);
	            
	            result.setPixel(i, j,pin);
	            result.setPixel(photo.getWd()-(i+1),j,pin1);
	        }
		

 
		return result;
	}
	public static Photograph posterize(Photograph photo){
		Photograph result = new Photograph(photo.getWd(), photo.getHt());
		for (int i=0;i<photo.getWd();i++)
	        for (int j=0;j<photo.getHt();j++){
	        	Pixel pin = photo.getPixel(i, j);
	        	int r=pin.getRed();
	        	int g=pin.getGreen();
	        	int b=pin.getBlue();
	        	
	        	
	        	if (b<128){
	        		
	        		b=0;
	        	}
	        	if (g<128) {
	        		
	        		g=0;
	        		
	        	}
	           if(r<128)
	        	{
	        		r=0;
	        		
	        	}
	        	
	        	
	
                 Pixel pout = new Pixel( r,g,b); 
				
				result.setPixel(i,j,pout);
	        }
	      return result;

}
	public static Photograph redFilter(Photograph photo, double n)
	{
		
		if (photo == null || n<=0.0 || n>1)
			return null; 
		Photograph result = new Photograph(photo.getWd(), photo.getHt());
		
		
		for (int y = 0; y < photo.getHt(); y++) {
			for (int x = 0; x < photo.getWd(); x++) {
				Pixel pin = photo.getPixel(x, y); 
				Pixel pout = new Pixel( (int) (pin.getRed()*n),pin.getGreen(),pin.getBlue()); 
				
				result.setPixel(x,y,pout); 
			}
		}
		return result;
	}
	public static Photograph greenFilter(Photograph photo, double n)
	{
		
		if (photo == null || n<=0.0 || n>1)
			return null; 
		Photograph result = new Photograph(photo.getWd(), photo.getHt());
		
		
		for (int y = 0; y < photo.getHt(); y++) {
			for (int x = 0; x < photo.getWd(); x++) {
				Pixel pin = photo.getPixel(x, y); 
				Pixel pout = new Pixel( pin.getRed(),( (int ) (pin.getGreen()*n)),pin.getBlue()); 
				
				result.setPixel(x,y,pout); 
			}
		}
		return result;
	}
	public static Photograph blueFilter(Photograph photo, double n)
	{
		
		if (photo == null || n<=0.0 || n>1)
			return null; 
		Photograph result = new Photograph(photo.getWd(), photo.getHt());
		
		
		for (int y = 0; y < photo.getHt(); y++) {
			for (int x = 0; x < photo.getWd(); x++) {
				Pixel pin = photo.getPixel(x, y); 
				Pixel pout = new Pixel( pin.getRed(),pin.getGreen(),( (int) (pin.getBlue()*n))); 
				
				result.setPixel(x,y,pout); 
			}
		}
		return result;
	}
	public static Photograph grayscale(Photograph photo){ 
		                 
		                Photograph result = new Photograph(photo.getWd(), photo.getHt()); 
		                for (int y = 0; y < photo.getHt(); y++) { 
		                        for (int x = 0; x < photo.getWd(); x++) { 
		                               Pixel pin = photo.getPixel(x, y);  
		                            int gray= ((int) (pin.getRed()*0.2989))+((int)(pin.getGreen()*0.587))+((int)(pin.getBlue()*0.114));  
		                         
		                                Pixel pout = new Pixel(gray,gray,gray);  
		                               result.setPixel(x,y,pout);  
		                        } 
		                } 
		        return result; 
		                 
		        
}
		
	
	
	
	// YOUR CODE ENDS HERE
}
