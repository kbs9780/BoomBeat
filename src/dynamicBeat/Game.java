package dynamicBeat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Game extends Thread {

	private Image noteRouteLineImage = new ImageIcon(getClass().getResource("/images/noteRouteLine.png"))
			.getImage();
	private Image judgementLineImage = new ImageIcon(getClass().getResource("/images/judgementLine.png"))
			.getImage();
	private Image gameInfoImage = new ImageIcon(getClass().getResource("/images/gameInfo.png"))
			.getImage();
	private Image noteRouteAImage = new ImageIcon(getClass().getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(getClass().getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(getClass().getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(getClass().getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(getClass().getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(getClass().getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(getClass().getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(getClass().getResource("/images/noteRoute.png")).getImage();
	private Image judgeImage ;
	private Image keyPadAImage = new ImageIcon(getClass().getResource("/images/keyPadBasic.png")).getImage();
	private Image keyPadSImage = new ImageIcon(getClass().getResource("/images/keyPadBasic.png")).getImage();
	private Image keyPadDImage = new ImageIcon(getClass().getResource("/images/keyPadBasic.png")).getImage();
	private Image keyPadSpace1Image = new ImageIcon(getClass().getResource("/images/keyPadBasic.png")).getImage();
	private Image keyPadSpace2Image = new ImageIcon(getClass().getResource("/images/keyPadBasic.png")).getImage();
	private Image keyPadJImage = new ImageIcon(getClass().getResource("/images/keyPadBasic.png")).getImage();
	private Image keyPadKImage = new ImageIcon(getClass().getResource("/images/keyPadBasic.png")).getImage();
	private Image keyPadLImage = new ImageIcon(getClass().getResource("/images/keyPadBasic.png")).getImage();


	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;

	int score;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}


	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteAImage, 228, 30, null);
		g.drawImage(noteRouteSImage, 332, 30, null);
		g.drawImage(noteRouteDImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		
		for(int i = 0; i < noteList.size(); i++)
		{
			Note note = noteList.get(i);
			if(note.getY() > 620) {
				judgeImage = new ImageIcon(getClass().getResource("/images/judgeMiss.png")).getImage();
			}
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}
			else {
				note.screenDraw(g);
			}
		}
		g.setColor(Color.white);
		g.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING, 
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("A", 270, 609);
		g.drawString("S", 374, 609);
		g.drawString("D", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString(""+score, 565, 702);
		g.drawImage(judgeImage, 460, 420, null);
		g.drawImage(keyPadAImage, 228, 580, null);
		g.drawImage(keyPadSImage, 332, 580, null);
		g.drawImage(keyPadDImage, 436, 580, null);
		g.drawImage(keyPadSpace1Image, 540, 580, null);
		g.drawImage(keyPadSpace2Image, 640, 580, null);
		g.drawImage(keyPadJImage, 744, 580, null);
		g.drawImage(keyPadKImage, 848, 580, null);
		g.drawImage(keyPadLImage, 952, 580, null);
	}
	
	public void pressA() {
		judge("A");
		noteRouteAImage = new ImageIcon(getClass().getResource("/images/noteRoutePressed.png")).getImage();
		keyPadAImage = new ImageIcon(getClass().getResource("/images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseA() {
		noteRouteAImage = new ImageIcon(getClass().getResource("/images/noteRoute.png")).getImage();
		keyPadAImage = new ImageIcon(getClass().getResource("/images/keyPadBasic.png")).getImage();
	}
	
	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(getClass().getResource("/images/noteRoutePressed.png")).getImage();
		keyPadSImage = new ImageIcon(getClass().getResource("/images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseS() {
		noteRouteSImage = new ImageIcon(getClass().getResource("/images/noteRoute.png")).getImage();
		keyPadSImage = new ImageIcon(getClass().getResource("/images/keyPadBasic.png")).getImage();
	}

	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(getClass().getResource("/images/noteRoutePressed.png")).getImage();
		keyPadDImage = new ImageIcon(getClass().getResource("/images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseD() {
		noteRouteDImage = new ImageIcon(getClass().getResource("/images/noteRoute.png")).getImage();
		keyPadDImage = new ImageIcon(getClass().getResource("/images/keyPadBasic.png")).getImage();
	}

	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(getClass().getResource("/images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(getClass().getResource("/images/noteRoutePressed.png")).getImage();
		keyPadSpace1Image = new ImageIcon(getClass().getResource("/images/keyPadPressed.png")).getImage();
		keyPadSpace2Image = new ImageIcon(getClass().getResource("/images/keyPadPressed.png")).getImage();
		new Music("drumBig1.mp3", false).start();
	}
	
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(getClass().getResource("/images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(getClass().getResource("/images/noteRoute.png")).getImage();
		keyPadSpace1Image = new ImageIcon(getClass().getResource("/images/keyPadBasic.png")).getImage();
		keyPadSpace2Image = new ImageIcon(getClass().getResource("/images/keyPadBasic.png")).getImage();
	}
	
	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(getClass().getResource("/images/noteRoutePressed.png")).getImage();
		keyPadJImage = new ImageIcon(getClass().getResource("/images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(getClass().getResource("/images/noteRoute.png")).getImage();
		keyPadJImage = new ImageIcon(getClass().getResource("/images/keyPadBasic.png")).getImage();
	}
	
	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(getClass().getResource("/images/noteRoutePressed.png")).getImage();
		keyPadKImage = new ImageIcon(getClass().getResource("/images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseK() {
		noteRouteKImage = new ImageIcon(getClass().getResource("/images/noteRoute.png")).getImage();
		keyPadKImage = new ImageIcon(getClass().getResource("/images/keyPadBasic.png")).getImage();
	}
	
	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(getClass().getResource("/images/noteRoutePressed.png")).getImage();
		keyPadLImage = new ImageIcon(getClass().getResource("/images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseL() {
		noteRouteLImage = new ImageIcon(getClass().getResource("/images/noteRoute.png")).getImage();
		keyPadLImage = new ImageIcon(getClass().getResource("/images/keyPadBasic.png")).getImage();
	}
	
	@Override
	public void run() {
		dropNotes(this.titleName);
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	  
	public void dropNotes(String titleName) {
		Random rn = new Random();
		String [] Key = {"A" , "S" , "D" , "Space" , "J" , "K" , "L"} ;
		int a ,b = 0;
		int[] Time = new int[1000];
		int[] TimeEasy = new int [1000];
		for(int i =0; i<TimeEasy.length;i++) {
			TimeEasy[i] = rn.nextInt(1000)+1;
			for(int j = 0 ; j<i ; j++) {
				if(TimeEasy[i]==TimeEasy[j]) { 
					--i;
				break;
				}//if
			}//for j
		}//for i

				for(int i =0; i<TimeEasy.length;i++) {
					for (int j =0;j<TimeEasy.length;j++) {
						if(TimeEasy[i]<TimeEasy[j]) {
						a=TimeEasy[i];
						TimeEasy[i]=TimeEasy[j];
						TimeEasy[j]=a;
					 }//if arry		
					}//for j
				}//for i
				for(int arryNum : TimeEasy) {
					 Time[b] = arryNum ;
				b++;}
			
		Beat[] beats = null;
		if(titleName.equals("Joakim Karud - Mighty Love") && difficulty.equals("Easy")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 1000;
			beats = new Beat[200] ;
			 for (int i = 0 ; i < beats.length ; i++) {
				beats [i] = new Beat (startTime+gap*Time[i],Key[rn.nextInt(7)]);
			 }
		}
		else if (titleName.equals("Joakim Karud - Mighty Love")&& difficulty.equals("Hard")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 500;
			beats = new Beat[500] ;
			 for (int i = 0 ; i < beats.length ; i++) {
				beats [i] = new Beat (startTime+gap*Time[i],Key[rn.nextInt(7)]);
			 }
		}
		else if (titleName.equals("Joakim Karud - Wild Flower")&& difficulty.equals("Easy")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 1000;
			beats = new Beat[350] ;
			 for (int i = 0 ; i < beats.length ; i++) {
				beats [i] = new Beat (startTime+gap*Time[i],Key[rn.nextInt(7)]);
			 }
		}
		else if (titleName.equals("Joakim Karud - Wild Flower")&& difficulty.equals("Hard")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 300;
			beats = new Beat[800] ;
			 for (int i = 0 ; i < beats.length ; i++) {
				beats [i] = new Beat (startTime+gap*Time[i],Key[rn.nextInt(7)]);
			 }
		}
		else if (titleName.equals("Bensound - Energy")&& difficulty.equals("Easy")) {
			int startTime = 7500 - Main.REACH_TIME * 1000;
			int gap = 1000;
			beats = new Beat[200] ;
			 for (int i = 0 ; i < beats.length ; i++) {
				beats [i] = new Beat (startTime+gap*Time[i],Key[rn.nextInt(7)]);
			 }
		}
		else if (titleName.equals("Bensound - Energy")&& difficulty.equals("Hard")) {
			int startTime = 7500 - Main.REACH_TIME * 1000;
			int gap = 500;
			beats = new Beat[700] ;
			 for (int i = 0 ; i < beats.length ; i++) {
				beats [i] = new Beat (startTime+gap*Time[i],Key[rn.nextInt(7)]);
			 }
		}
		int i = 0;
		gameMusic.start();
		while(i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

	public void judge(String input) {
		for( int i = 0 ; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}

	public void judgeEvent(String judge ) {

		if(judge.equals("Miss")) {
			judgeImage=new ImageIcon(getClass().getResource("/images/judgeMiss.png")).getImage();
		}
		else if(judge.equals("Late")) {
			judgeImage=new ImageIcon(getClass().getResource("/images/judgeLate.png")).getImage();
			score += 4 ;
		}
		else if(judge.equals("Good")) {
			judgeImage=new ImageIcon(getClass().getResource("/images/judgeGood.png")).getImage();
			score += 6 ;
		}
		else if(judge.equals("Great")) {
			judgeImage=new ImageIcon(getClass().getResource("/images/judgeGreat.png")).getImage();
			score += 8 ;
		}
		else if(judge.equals("Perfect")) {
			judgeImage=new ImageIcon(getClass().getResource("/images/judgePerfect.png")).getImage();
			score += 10 ;
		}
		else if(judge.equals("Early")) {
			judgeImage=new ImageIcon(getClass().getResource("/images/judgeEarly.png")).getImage();
			score += 4 ;
		}
	}

}
