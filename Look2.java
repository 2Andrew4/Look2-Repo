package feel.good;
import javax.swing.*;
// import javax.swing.JRootPane.RootLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.net.UnknownHostException;
import java.io.IOException;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.*;
// import java.net.Socket;
import java.net.MalformedURLException;
// import java.net.UnknownHostException;
import java.io.*;
// import java.beans.PropertyVetoException;
// von mir website@luna-net.org
public class Look2 extends JFrame implements ActionListener {
	
	private JLayeredPane desktop;
	private JEditorPane jeditP;
	private JScrollPane editorSP;
	private FileBrowser fileBrowser;
//	private LayerBrowser layerBrowser;
	private JMenuBar menuBar;
	private JMenu menuFile, menuHelp, menuOpen, menuTB, menuCt;
	private Action actKreuzschalter;
	private JMenuItem jmiHelp, jmiAbout;
	private JMenuItem jmiNew, jmiClose, jmiSave, jmiSaveAs;
	private JMenuItem jmiOpenFile, jmiOpenWeb, jmiConnect;
	private JMenuItem jmiKreuzschalter, jmiTBSchalter;
	private Action actHelp, actAbout, actNew, actClose, actSave, actSaveAs, actOpenFile, actOpenWeb, actConnect;
	private KeyStroke keyStroke;
	/**
	 * A Textfield to see life what is going on at the moment
	 * and the compound for further streaming the content of.
	 */ 
	private JTextField jtfStatus, eZeile;
	/**
	 *  The Label to execute per booleon the Help Window in Model-Desktop.
	*/ 	
	private JTextArea labH;
	/**
	 * It is in developement and send about "aliasout" (neither without break
	 * (switch) for filetypes) the alias-usage and "fview" the connected
	 * filestream of all filetypes by protocol-request into the shell.
	 */ 
	private JTextArea aliasout, fview;
	/**
	 * The common Container-class stack builder
	 */ 
	private Container contentPane;
	/** 
	 * Override action with package java.net about URL.
	 */ 
	private URL url;
	/**
	 * An own style wrote, used with the class "Font" by override.
	 */ 
	private Font fntSansFett;
	/**
	 * in developement the fantasy of the author is wishing a popup to see the content
	 * of the request.
	 */ 
	private String tbar = "";
//	private String tbar = jtfStatus.getText(); tbar get of <- + tbar
    /**
     * Declaration to round up the String of url.
     */ 
	private String urlString, daten, osY;
	/**
	 * A little tricky for further implementing the Icon-Path
	 * by set of size for.
	 */ 
	private String iconSize = "24";
	/**
	 * The inherited abstract class Button and interface Action use
	 * String by placeholder to present a tooltip.
	 */ 
	private String strNew = "Make a new utf-8 file";
	/**
	 * The inherited abstract class Button and interface Action use
	 * String by placeholder to present a tooltip
	 */
	private String strOpF = "Open a locale file";
	/**
	 * The inherited abstract class Button and interface Action use
	 * String by placeholder to present a tooltip.
	 */ 
	private String strOpW = "Open a file online";
	/**
	 * The inherited abstract class Button and interface Action use
	 * String by placeholder to present a tooltip.
	 */
	private String strSave = "Save directly";
	/**
	 * The inherited abstract class Button and interface Action use
	 * String by placeholder to present a tooltip.
	 */
	private String strHelp = "Content Help";
	/**
	 * The inherited abstract class Button and interface Action use
	 * String by placeholder to present a tooltip.
	 */
	private String strAbout = "Experience more about the Author";
	/**
	 * The inherited abstract class Button and interface Action use
	 * String by placeholder to present a tooltip.
	 */
	private String strClose = "Toggle Menu-Bar";
	/**
	 * The inherited abstract class Button and interface Action use
	 * String by placeholder to present a tooltip.
	 */
	private String strConnect="Connec Net Ressource";
	/**
	 * The content for the help-panel.
	 */ 
	private String hilfet ="<html>Attention is giving, make a new utf-8 file<br>"+
	           " overwrites all content of the panel without recall.<br>"+
	           " Output of all files utf-8 !<br>"+
	           " With STR-E ask about the content of located files<br>"+
		   " about all protocols how filfe:// http:// https:// ftp:// <br> "+
		   " the ipadress of an alias like www.you.com<br>" +
		   " used the same shortcut STR*E!<br> "+
		   " Ask with input in the row at button of the window<br>"+
		   " the answers would stacking inside the panel and per request <br>"+
		   " also in the folder of executable<br>"+
		   " no overwriting pro session of answers.<br></html>";
	/** 
	 * An additionally string for usage whats going on in view-panel!
	 */ 	   
	private String tout;
	/**
	 * The names inside the source to form the taken icons in applications!
	 */   
	private ImageIcon icoNew, icoOpenFile, icoOpenWeb, icoSave, icoHelp, icoAbout, icoSaveAs, icoClose, icoConnect;
	/**
	 * The invisible toolbar value taken by in- and decremet operator!
	 */ 
	private int redu, redu1;
	/**
	 * The start-value for the (in these model without choice-option)
	 * Request-Log-Files in the same directory how the Look2.jar is started.
	 */ 
	private int ser = 1;
	/**
	 * The treasure of class File also taken over FileBrowser Class the sister class of the model.
	 * And to round up with these declaration with booleon-function for
	 * planed question by overwriting of already existing file.
	 */ 
	private File file;
	/**
	 * Easy to grab the Toolbar inside the desktop-model.
	 */ 
	private JToolBar toolBase;
	/** 
	 * The inside window for the info about
	 */ 
	private JInternalFrame infoFrame;
	/**
	 * The first drop start the info-window with usage in text-row,
	 * the second drop on the info button deletes the info in the info text row,
	 * the third drop is how the first (need more assertions to steer the window also).
	 */  
	private static int bs1;
	/**
	 * The already taled boolean boolean-name for the inside windows with int bs1 (info entsch)
	 *  and ever true (help areaW).
	 */ 
	private boolean entsch, areaW;
	/** 
	 * Override action with package java.net about InetAddress.
	 */ 
	private InetAddress adresse;
//	private char wrapch;
    /**
     * Connection to the sister class FileBrowser
     * represents a dialog-window to save as!
     */ 
	private void saveAs(){
	fileBrowser.saveFileAs(jeditP.getText(), null, "./");
	}
     /**
     * Connection to the sister class FileBrowser
     * represents a dialog-window to save!
     */ 
	private void save(){
	fileBrowser.saveFileAs(file.toString(), jeditP.getText(), "./");
        }
	/** 
	 * All is nothing without events to observe and mix with a action.
	 * The Model-Window save to close.
	 */ 
	public void actionPerformed(ActionEvent ae) {
	if(ae.getSource().equals(jmiClose)){
		System.exit(0);}
	if(ae.getSource().equals(jmiSaveAs)){
		saveAs();
		jtfStatus.setText("\"Save as\" choosen!");}	
	}

    /**
     * The Log-File_Handling!
     */ 

	public void adressT() {
		DataOutputStream textin;
			aliasout = new JTextArea("", 1, 3);
			aliasout.setFont(fntSansFett);
			aliasout.setBackground(Color.black);
			aliasout.setForeground(Color.white);
			aliasout.setBounds(30, 210, 258, 120);
			aliasout.setVisible(false);
			add(aliasout);
		
	FileOutputStream gibt;
	BufferedOutputStream uebergibt;
	try {
	daten = chanR();
	gibt = new FileOutputStream("Request " + Integer.toString(ser) + " of " + daten);
	textin = new DataOutputStream(gibt);
	textin.writeBytes(eZeile.getText());

	//** also ok mixed usage in outputfile **//
	//	textin.writeBytes(Double.toString(ser)+eZeile.getText()); 

	// currently hidden 
	aliasout.append(eZeile.getText());
	aliasout.append(textin.toString());
	// end currently
	uebergibt = new BufferedOutputStream(gibt);
	}
	catch (IOException ioe) {
	System.out.println(" Irgendetwas ging schief ");
	jtfStatus.setText("Nanu was nun");
 	}
 	
 	}
	
//	public void Formatter(Appendable  
	
	/**
	 * A getter for the container stack to get it with all Buttons
	 * Menues and Shortcuts.
	 */ 
	
	public JToolBar getToolBase(){
	tbar = "Get it";
	JToolBar toolBase = new JToolBar();
	icoNew = new ImageIcon("icons/bl_gr_"+iconSize+"_neue_datei.gif");
	icoOpenFile = new ImageIcon("icons/bl_gr_"+iconSize+"_oeffnen.gif");
	icoOpenWeb = new ImageIcon("icons/bl_gr_"+iconSize+"_oeffnen_web.gif");
	icoSave = new ImageIcon("icons/bl_gr_"+iconSize+"_speichern.gif");
	icoHelp = new ImageIcon("icons/bl_gr_"+iconSize+"_hilfe.gif");
	icoAbout = new ImageIcon("icons/bl_gr_"+iconSize+"_info.gif");
	icoClose = new ImageIcon("icons/"+iconSize+"_schliessen.gif");
	icoSaveAs = new ImageIcon("icons/bl_gr_"+iconSize+"_speichern_unter.gif");
	icoConnect = new ImageIcon("icons/Up"+iconSize+".gif");	
	
	//Menu
	menuBar=new JMenuBar();
	this.setJMenuBar(menuBar);
	
	menuFile=new JMenu("File");
		actNew=new AbstractAction("Neu", icoNew) {
		public void actionPerformed(ActionEvent ae) {
		jtfStatus.setText("File \"New\" choosen"); 
		jeditP.setText("");
		jeditP.setEditable(true);
		jeditP.setVisible(true);
		}
		};
		actNew.putValue(Action.SHORT_DESCRIPTION, strNew);
		jmiNew = menuFile.add(actNew);
		jmiNew.setToolTipText(strNew);
		jmiNew.setMnemonic(KeyEvent.VK_N); // << wird in der GUI auch unterstrichen
		keyStroke=KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK);
		actNew.putValue(Action.ACCELERATOR_KEY, keyStroke);
		jmiNew.addActionListener(this);
		menuFile.setMnemonic('f');	
		menuFile.addSeparator();
	
		menuOpen=new JMenu("Open");
		menuOpen.setToolTipText("what would you like open?");
		menuFile.add(menuOpen);
		menuOpen.setMnemonic('f');
		
	       	  actOpenFile=new AbstractAction("Open", icoOpenFile) {
	       	  public void actionPerformed(ActionEvent ae) 
	          {
	  	try {
		  jtfStatus.setText("File open choosen");
	       	  jeditP.setText(fileBrowser.chooseText("Textfile surely read","text/plain"));
	       	  jeditP.setVisible(true);    
	        } catch (IndexOutOfBoundsException io) {
	       	  jtfStatus.setText("IndexOutOfBoundsException" +io); }
	       	  }
	          };
		  actOpenFile.putValue(Action.SHORT_DESCRIPTION, strOpF);
		  keyStroke=KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK);
		  actOpenFile.putValue(Action.ACCELERATOR_KEY, keyStroke);
	       	  jmiOpenFile = menuOpen.add(actOpenFile);
	       	  jmiOpenFile.setToolTipText(strOpF);
		  jmiOpenFile.setMnemonic(KeyEvent.VK_T);
	       	  jmiOpenFile.addActionListener(this);
		  menuOpen.add(jmiOpenFile);
		  
	      actOpenWeb=new AbstractAction("Open URL", icoOpenWeb) {
	          public void actionPerformed(ActionEvent ae) {
	  	try {
		  if(jtfStatus.getText()!=null) {
	       	  jtfStatus.setText("Open URL choosen");
	       	  
	       	  url=fileBrowser.chooseURL("Please choose","./");
	 	  String sUrl = url.toString();
	       	  // url=fileBrowser.chooseText("Choose File","");
	       	   jeditP.setText(sUrl); } 
	        } catch (IndexOutOfBoundsException idoex) {
	       	  jtfStatus.setText("IndexOutOfBoundsException" +idoex); }
	       	  }
	          };
		  actOpenWeb.putValue(Action.SHORT_DESCRIPTION, strOpW);
		  keyStroke=KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK);
		  actOpenWeb.putValue(Action.ACCELERATOR_KEY, keyStroke);
	          jmiOpenWeb = menuOpen.add(actOpenWeb);
		  jmiOpenWeb.setToolTipText(strOpW);
		  jmiOpenWeb.setMnemonic('U');
		  jmiOpenWeb.addActionListener(this);
		  menuOpen.add(jmiOpenWeb);
		  
	jmiClose=new JMenuItem("Close", icoClose);
	jmiClose.setToolTipText("Drive down the program");
	jmiClose.setMnemonic('l');
	jmiClose.addActionListener(this);
	menuFile.add(jmiClose);
	menuFile.addSeparator();
	
	actSave=new AbstractAction(strSave, icoSave) {
	public void actionPerformed(ActionEvent ae) {
	if(file != null) {
	jtfStatus.setText("Overwrite the file");
	save();
	}
	else
	jtfStatus.setText("New choice of: \"File - Save As ...\".");		
	saveAs();
	}
	};
	actSave.putValue(Action.SHORT_DESCRIPTION, strSave);
	keyStroke=KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK);
	actSave.putValue(Action.ACCELERATOR_KEY, keyStroke);
	jmiSave = menuFile.add(actSave);
	jmiSave.setToolTipText(strSave);
	jmiSave.setMnemonic('S');
	jmiSave.addActionListener(this);
	menuFile.add(jmiSave);
	
	jmiSaveAs=new JMenuItem("Save As", icoSaveAs);
	jmiSaveAs.setToolTipText("Save As with new file name");
	jmiSaveAs.setMnemonic('v');
	jmiSaveAs.addActionListener(this);
	menuFile.add(jmiSaveAs);
	
		menuHelp=new JMenu("Help");
	        menuHelp.setMnemonic('H');
		  actHelp=new AbstractAction("Help", icoHelp) {
		  public void actionPerformed(ActionEvent ae) {
		  jtfStatus.setText("View the Content of help choosen");
		  showHelp(); }
		  };
		  actHelp.putValue(Action.SHORT_DESCRIPTION, strHelp);
		  keyStroke=KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0);
		  actHelp.putValue(Action.ACCELERATOR_KEY, keyStroke);
		  jmiHelp = menuFile.add(actHelp);
		  jmiHelp.setToolTipText(strHelp);
		  jmiHelp.setMnemonic('i');
		  jmiHelp.addActionListener(this);
		  menuHelp.add(jmiHelp);
		  menuHelp.addSeparator();
		  actAbout=new AbstractAction("About", icoAbout) {
		  public void actionPerformed(ActionEvent ae) {
		  	jtfStatus.setText("Information about the program");
			showInfo();
		  }
		  };
		  actAbout.putValue(Action.SHORT_DESCRIPTION, strAbout);
		  keyStroke=KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK);
		  actAbout.putValue(Action.ACCELERATOR_KEY, keyStroke);
		  jmiAbout = menuFile.add(actAbout);
		  jmiAbout.setToolTipText(strAbout);
		  jmiAbout.setMnemonic('r');
		  jmiAbout.addActionListener(this);
		  menuHelp.add(jmiAbout);
	
		
	menuTB=new JMenu("View");
	  menuTB.setVisible(true);//<<<<
	  menuTB.setMnemonic('W');
	  	actKreuzschalter=new AbstractAction("MenuBar invisible", icoClose) {
	  	int redu1=0;
	  	public void actionPerformed(ActionEvent ae) {
	  		 if (redu1==0){
			  menuBar.setVisible(false);
			 redu1++;
			 jtfStatus.setText("Menu-Bar invisible,"
			 +" the shortcuts are now inactive!"); }
			 else if (redu1>=0) {
			  menuBar.setVisible(true);
			   redu1--;  
			   jtfStatus.setText("All are now again active, "
			   +"the Menu-Bar is again visible!"); }
	        	 } 
	  	};
	  	// keystroke hier nur in Verbindung mit menuTB.setVisible(true); 
	  	actKreuzschalter.putValue(Action.SHORT_DESCRIPTION, strClose);
		  keyStroke=KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK);
	  	actKreuzschalter.putValue(Action.ACCELERATOR_KEY, keyStroke);
	  	jmiKreuzschalter = menuFile.add(actKreuzschalter);
	  	jmiKreuzschalter.setToolTipText(strClose);
	  	jmiKreuzschalter.setMnemonic('m');
	  	jmiKreuzschalter.addActionListener(this);  
	   		menuTB.add(jmiKreuzschalter);
	   		menuTB.addSeparator();
	   		jmiTBSchalter=new JMenuItem("Here Inside");
	  	  menuFile.add(jmiTBSchalter);
	  	  jmiTBSchalter.setToolTipText("Here right for toggle");
	  	  jmiTBSchalter.setMnemonic('H');
		  jmiTBSchalter.setVisible(false);
	  	  jmiTBSchalter.addActionListener(this);
	  	  	menuTB.add(jmiTBSchalter);

	menuCt=new JMenu("Explore");
	  menuCt.setVisible(true);
	  menuCt.setMnemonic('E');
		actConnect=new AbstractAction("Request of an Internetresource", icoConnect) {
		public void actionPerformed(ActionEvent ae) {
		  jtfStatus.setText("Online");
		  aufziehen();
			chanR();
		//	  rChan();
			adressT();
			ser++;
		}
	};
	actConnect.putValue(Action.SHORT_DESCRIPTION, strConnect);
	 keyStroke=KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK);
	actConnect.putValue(Action.ACCELERATOR_KEY, keyStroke);
	jmiConnect=menuFile.add(actConnect);
	jmiConnect.setToolTipText(strConnect);
//	jmiConnect.setMnemonic('I'); // <<< islimited()
	jmiConnect.addActionListener(this);
		menuCt.add(actConnect);
		menuCt.addSeparator();
		jmiConnect=new JMenuItem("In Net");
		jmiConnect.setVisible(false);
		menuFile.add(jmiConnect);
	jmiConnect.setToolTipText(strConnect);
	jmiConnect.addActionListener(this);
		menuCt.add(jmiConnect);
	  	  	
	
	toolBase.add(actNew);
	toolBase.add(actOpenFile);
	toolBase.add(actOpenWeb);
	toolBase.addSeparator();
	toolBase.add(actSave);
	toolBase.addSeparator();
	toolBase.add(actHelp);
	toolBase.add(actAbout);
	toolBase.add(actKreuzschalter);
	toolBase.add(actConnect);
	
	menuBar.add(menuFile);
	menuBar.add(menuHelp);
	menuBar.add(menuTB);
	menuBar.add(menuCt);
	return toolBase;
	}
	/**
	 * The application-loop for the Help-Window (innerclass)
	 */ 
	public void showHelp() {
		areaW=true;
	 JInternalFrame helpFrame=new JInternalFrame("Help", true);
		   
		   helpFrame.setLocation(100,100);
		   helpFrame.setSize(460,460);
		   helpFrame.setDefaultCloseOperation(1);
		   helpFrame.setClosable(true);
		   desktop.add(helpFrame, "MODAL");
		   helpFrame.setVisible(true);
		    JLabel labH =new JLabel("hilfet,0");
		    JScrollPane editorSP= new JScrollPane(labH);
	           helpFrame.add(BorderLayout.CENTER, editorSP);
	           labH.setText(hilfet);
	 } 
	 /**
	 * The application-loop for the Info-Window (innerclass)
	 */ 
	public void showInfo() {
		    int bs=0;
		   JInternalFrame infoFrame=new JInternalFrame("Info", entsch);
		   try {
		   desktop.putLayer(infoFrame, 300);
		  if(bs1<=0) {
		  entsch=true;	   	 
		  infoFrame.setSize(280, 160);
		  infoFrame.setLocation(170, 190);
		  infoFrame.setDefaultCloseOperation(1);
		  infoFrame.setClosable(true);
		 
		  infoFrame.show();  
		  infoFrame.setResizable(false);
		  desktop.add(infoFrame, "POPUP");
		  infoFrame.toFront();
		  infoFrame.setVisible(true);
		  infoFrame.setClosed(false);
		  JLabel infoLabel=new JLabel("<html><body style=\"text-align:center; vertical-"
		  +"align:middle;\">&nbsp;<H2>Local- + Net-SightWindow</H2><p>"
		  +"&nbsp;<br>Author: a@t <br>"
		  +"&nbsp;Version: Springtime 2019 <br>"
		  +"&nbsp; website@luna-net.org"
		  +"</p></body></html>", 0);
		  infoFrame.add(BorderLayout.NORTH, infoLabel);
		  bs1++; }
		  else if(bs1==1) {
		  entsch=false;
	          jtfStatus.setText("");
		  infoFrame.isClosable();
		  infoFrame.setClosed(true);
	          infoFrame.setVisible(false);
		  infoFrame.hide();
	          desktop.remove(infoFrame);
	  	//  desktop.dispose();
		
		  bs1--; } 
		   } catch (ArrayIndexOutOfBoundsException aix) {
		   System.out.println("at "+aix);
		   }
		     catch (java.beans.PropertyVetoException pve) {
		   System.out.println("at "+pve); }
	}	
	/**
	 * The application-loop for the input urls with protocol string before. 
	 * To see the textfile in the shell -> all other fileformats
	 * need more love how decoding of or convert of by taking of the first signs in fileformats
	 * to interpret them.
	 */ 
	public void aufziehen() {

		JPanel panel = new JPanel();
    		panel.setLayout(new BorderLayout(500, 500));
			panel.getPreferredSize();
			
		urlString=eZeile.getText();
		
		try {
			URL url= new URL(urlString);
			URLConnection connec = url.openConnection(); // Verbindung herstellen
			BufferedReader br = new BufferedReader(new
			InputStreamReader(connec.getInputStream()));
			String input;
			if ((input = br.readLine()) != null) {
				while ((input = br.readLine()) != null) {
			// liest die Kopfzeile
		//	if((input=reader.readLine()) !=null)
		
		//	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		//	connec.setRequestMethod("GET");
		//	connec.setRequestProperty("Accept", "application/json");
 
     /**   if (connec.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + connec.getResponseCode()); }
		**/		
			System.out.println(input); }
			
			// String eadi = input.toString();
		
			 JLabel label = new JLabel("SourceView in Terminal");
				label.setFont(new Font("Georgia", Font.PLAIN, 14));
				label.setForeground(new Color(227, 106, 106));
				label.setBounds(30, 1, 258, 10);
				panel.add(label, BorderLayout.CENTER);
			
			panel.add(new TextArea());
		
			fview = new JTextArea();
			fview.setLineWrap(true);
			fview.insert(input, 1);
			fview.append(input);
			fview.setFont(new Font("Georgia", Font.PLAIN, 14));
			fview.setBackground(Color.black);
			fview.setForeground(Color.white);
			fview.setBounds(30, 11, 258, 420);
			fview.setVisible(true);
		
			add(fview);
					
    				panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    				JFrame halter = new JFrame();
    		halter.setBounds(30, 0, 258, 430);
			halter.add(label);
			halter.add(fview);
        		halter.pack();
        		halter.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        		halter.setVisible(true);  } 
				
			// insert catch
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.toString());
		}  
		   // is more present from environment of ipv6 
		  catch (UnknownHostException uhe) {
			System.out.println(uhe+"The Above is for the same input field protocol requester");  
		  }
		  catch (MalformedURLException malurle) {
			String osY = ("Protokoll x: "+malurle.toString());
			
		} catch (ArrayIndexOutOfBoundsException aioe) {
			System.out.println(aioe.toString());
			
		} catch (IOException ioe) {
			System.out.println(ioe.toString());
			
		} 
	} 
	/**
	 *  The TLD translator application-loop (TOP Level Domain begins with www).
	 *  To see also the multiple use of one
	 *  address by more alliases for and builds a stack for all
	 *  requests inside the view.
	 * @return the number code address
	 * 
	 */ 

		public String chanR() {
		urlString = eZeile.getText();
		tout = "- ip-address of alias ";
		try {

			// InetAddress adresse=null;
			adresse = InetAddress.getByName(urlString);
			jtfStatus.setText(tout + urlString + " = "
					+ adresse.getHostAddress());
			String vorher = jeditP.getText();
			jeditP.setText(vorher + tout + urlString + " = "
					+ adresse.getHostAddress() + "\n");

		} catch (ArrayIndexOutOfBoundsException aioe) {
			System.out.println(aioe.toString());

		} catch (IOException ioe) {
			System.out.println(ioe.toString());
		}

		return (adresse.getHostAddress().toString());

	}
	/**
	 *  The TLD translator application-loop (TOP Level Domain begins with www).
	 *  To see also the multiple use of one
	 *  address by more alliases for and builds a row for all
	 *  requests inside the view.
	 * @return the number code address
	 * 
	 */ 
/*
	public String rChan() {
	aliaS=eZeile.getText();
	barry="Alias = ";
	try {
			adresse=InetAddress.getHostName(aliaS);
			jtfStatus.setText(barry+aliaS+" = Alias der Nummer "
			+adresse.getHostAddress());
			String vorher =jeditP.getText();
			jeditP.setText(vorher+" = "
			+adresse.getHostAddress()+" - ");
			System.out.println(tout+urlString+" = "
			+adresse.getHostAddress());
			
			
		} catch (ArrayIndexOutOfBoundsException aioe) {
			System.out.println(aioe.toString());
			
		} catch (IOException ioe) {
			System.out.println(ioe.toString());
		}

		return (adresse.getHostAddress().toString()+" - ");		
	    }
	}
*/
    /**
     * The container stack for the last feel given for styling.
     */ 
	public Look2() {
//	super("Get it" + tbar); // send to declaration tbar "Get it"
	
	super("");
	// super(tbar);  // is taken as first also if super(""); before
	this.setSize(600, 450);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	desktop=getLayeredPane();
	Container contentPane = this.getContentPane();
	contentPane.add(BorderLayout.NORTH, this.getToolBase());
	
	// Statusleiste
	jtfStatus = new JTextField("");
	jtfStatus.setBackground(Color.BLACK);
	jtfStatus.setForeground(Color.WHITE);
	jtfStatus.setEditable(false);
	
	fileBrowser=new FileBrowser(jtfStatus);
	JPanel panel = new JPanel();
	panel.setLayout(new BorderLayout());
	panel.add(BorderLayout.PAGE_START, jtfStatus);
	contentPane.add(BorderLayout.CENTER, panel);
	
	jeditP = new JEditorPane();
	JScrollPane editorSP= new JScrollPane(jeditP);
	panel.add(BorderLayout.CENTER, editorSP);
	contentPane.add(BorderLayout.CENTER, panel);
		// Eingabezeile
	eZeile = new JTextField("");
	eZeile.setBackground(Color.WHITE);
	eZeile.setForeground(Color.BLACK);
	eZeile.setEditable(true);
	panel.add(BorderLayout.PAGE_END, eZeile);
	contentPane.add(BorderLayout.CENTER, panel);
	this.setVisible(true);
	}
	/**
	 * A depending round up! The main String.
	 */ 
	public static void main(String [] args) {
	new Look2();
	}
}	
