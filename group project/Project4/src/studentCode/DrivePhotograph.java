package studentCode;

import photograph.*;

public class DrivePhotograph {

	/**
	 * This is where you can play with photographs to see 
	 * how your code is working, and to play around with different
	 * manipulations.
	 * 
	 * This code will not be tested by the submit server, so feel free
	 * to modify as you wish.
	 */
	public static void main(String[] args) {
		
		
		
		// You can read a photograph from a URL or from a file on your computer
		Photograph p = new Photograph("http://www.cs.umd.edu/~pugh/testudo.jpg");
		//Photograph r = new Photograph("http://www.cs.umd.edu/~pugh/testudo.jpg");
		// Here you create a window to show the photograph
		PictureUtil.show(p, "Original Picture"); 
		
		
		// And this is how you see what your picture manipulations do
		
		        	        	
		 PictureUtil.show(PhotoEdits.makeBlue(p), "Blue");
		PictureUtil.show(PhotoEdits.makeGreen(p), "Green");
		PictureUtil.show(PhotoEdits.makeRed(p), "Red");
		PictureUtil.show(PhotoEdits.flipHorizontal(p), "horizontal");
		PictureUtil.show(PhotoEdits.flipVertical(p), "vertical");
		PictureUtil.show(PhotoEdits.posterize(p), "posterize");
		PictureUtil.show(PhotoEdits.dim(p,0.6), "dim");
		PictureUtil.show(PhotoEdits.redFilter(p,0.6), "redFilter");
		PictureUtil.show(PhotoEdits.grayscale(p), "grayscale");
		PictureUtil.show(PhotoEdits.greenFilter(p,0.6),"greenFilter");
		PictureUtil.show(PhotoEdits.blueFilter(p,0.6), "blueFilter");
		
}
}