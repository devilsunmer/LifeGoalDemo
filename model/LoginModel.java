package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginModel {
	
	private JTextField usernameField;
	private JPasswordField passwordField=new JPasswordField();
	private JTextField imageTextIn;
	String PasswordIn=new String(passwordField.getPassword());
	
	private static String imageTextInside="";
	
	JLabel imageText = new JLabel();
	
	/**產生並更新驗證圖片回傳給view設定**/
	public void imageTextSetRule(JLabel imageText) {
		
		imageTextInside=imageTextSet(4);
		ImageIcon Icon=imageTextInsideIcon(imageTextInside);
		imageText.setIcon(Icon);
		

	}
	
	/**產生驗證碼文字**/
	private static String imageTextSet(int numberInimage) {
        String chars = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
        StringBuilder count = new StringBuilder();
        Random ran = new Random();
        for (int i = 0; i < numberInimage; i++) {
        	count.append(chars.charAt(ran.nextInt(chars.length())));
        }
        return count.toString();
    }
	
	/**根據驗證碼文字產生圖片icon**/
	private static ImageIcon imageTextInsideIcon(String code) {
		int wight=120,high=40;
		BufferedImage image=new BufferedImage(wight,high,BufferedImage.TYPE_INT_RGB);
		Graphics2D photo=image.createGraphics();
		
		// 背景
		photo.setColor(new Color(255,255,255));
		photo.fillRect(0, 0, 120,40);

        // 隨機顏色與字體
		photo.setFont(new Font("Arial", Font.BOLD, 20));
		photo.setColor(new Color(0,0,0));
		photo.drawString(code, 15, 28);

        // 干擾線
		photo.setColor(new Color(192,192,192));
        for (int i = 0; i < 5; i++) {
        	Random ran = new Random();
        	photo.drawLine(ran.nextInt(wight), ran.nextInt(high), ran.nextInt(wight), ran.nextInt(high));
        }

        photo.dispose();

        return new ImageIcon(image);
	}
	
	public String getImageTextInside() {
        return imageTextInside;
    }
	
	public Integer parseGoal(String goalText) {
	    // 檢查是否是有效數字，若不是則設置為默認值 0
	    try {
	        if (goalText.equals("(空)")) {
	            return 0; // 或者選擇你希望的默認值
	        }
	        return Integer.parseInt(goalText.trim()); // 轉換為數字
	    } catch (NumberFormatException e) {
	        System.out.println("無效的數字輸入，將返回默認值 0");
	        return 0; // 默認值
	    }
	}

}

    

	
