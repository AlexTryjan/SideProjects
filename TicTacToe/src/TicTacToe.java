import java.awt.*;
//Implement options to change difficulty (always block 3 rand etc)
import java.awt.event.*;

import javax.swing.*;
public class TicTacToe implements ActionListener
{
    JFrame window = new JFrame("TicTacToe");
    boolean[][] occupied = new boolean[3][3];
    /*JButton buttons[0] = new JButton("");
    JButton buttons[1] = new JButton("");
    JButton buttons[2] = new JButton("");
    JButton buttons[3] = new JButton("");
    JButton buttons[4] = new JButton("");
    JButton buttons[5] = new JButton("");
    JButton buttons[6] = new JButton("");
    JButton buttons[7] = new JButton("");
    JButton buttons[8] = new JButton("");*/
    JButton[] buttons = new JButton[9];
    static String play;
    static String comp;
    boolean win = false;
    int count = 0;
    public boolean tie = false;
    TicTacToe()
    {
        window.setSize(300,300);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout(3,3));
        for(int i = 0; i < 9; i++) {
        	buttons[i] = new JButton("");
        	window.add(buttons[i]);
        	buttons[i].addActionListener(this);
        }
        window.setVisible(true);
    }
    public void actionPerformed(ActionEvent a)
    {
    	int i = 0;
    	int j = 0;
        for(JButton button : buttons) {
        	if(a.getSource() == button) {
            	button.setText(play);
            	occupied[j][i] = true;
            	button.setEnabled(false);
        	}
        	if(i == 2) {j++; i = 0;}
        	else i++;
        }
    	/*if(a.getSource() == buttons[0]) {
        	buttons[0].setText(play);
        	occupied[0][0] = true;
        	buttons[0].setEnabled(false);
        }
        if(a.getSource() == buttons[1]) {
            buttons[1].setText(play);
            occupied[0][1] = true;
            buttons[1].setEnabled(false);
        }
        if(a.getSource() == buttons[2]) {
            buttons[2].setText(play);
            occupied[0][2] = true;
            buttons[2].setEnabled(false);
        }
        if(a.getSource() == buttons[3]) {
            buttons[3].setText(play);
            occupied[1][0] = true;
            buttons[3].setEnabled(false);
        }
        if(a.getSource() == buttons[4]) {
            buttons[4].setText(play);
            occupied[1][1] = true;
            buttons[4].setEnabled(false);
        }
        if(a.getSource() == buttons[5]) {
            buttons[5].setText(play);
            occupied[1][2] = true;
            buttons[5].setEnabled(false);
        }
        if(a.getSource() == buttons[6]) {
            buttons[6].setText(play);
            occupied[2][0] = true;
            buttons[6].setEnabled(false);
        }
        if(a.getSource() == buttons[7]) {
            buttons[7].setText(play);
            occupied[2][1] = true;
            buttons[7].setEnabled(false);
        }
        if(a.getSource() == buttons[8]) {
            buttons[8].setText(play);
            occupied[2][2] = true;
            buttons[8].setEnabled(false);
        }*/
        count++;
        testresults();
        if(win==true) {
            for(JButton button : buttons) {
            	button.setEnabled(false);
            }
            playerwins();
        }
        else
            computer();
    }
    public void computer()
    {	
    	int p = 0; //if p == 7 is true, the computer already made a move this turn
    	if(count == 1 && p != 7) { //If turn two (player started)
    		if(buttons[1].getText() == play || buttons[3].getText() == play) { 
    			if(buttons[0].isEnabled()) { //Computer tries to go top left   CASE:// cP- OR 	c--
    	            buttons[0].setText(comp);										// ---		P--
    	            buttons[0].setEnabled(false);									// ---		---
    	            occupied[0][0] = true;
    	            p = 7;
    	            }
    		}
    	else if(buttons[5].getText() == play || buttons[7].getText() == play) {
			if(buttons[8].isEnabled()) { //Computer tries to go bottom right   CASE:// --- OR	---
	            buttons[8].setText(comp);											// --P		---
	            buttons[8].setEnabled(false);										// --c		-Pc
	            occupied[2][2] = true;
	            p = 7;
	            }
			}
    	}
    	if(p != 7 && buttons[4].getText() == "") { //If we haven't gone & middle is open, we try for middle
    			if(buttons[4].isEnabled()) {
    	            buttons[4].setText(comp);
    	            buttons[4].setEnabled(false);
    	            occupied[0][2] = true;
    	            p = 7;
    	            }
    	} //Checks if it can win next by looking at all instances of two of its moves in a row. If it can win, it will
    	else if(buttons[0].getText() == buttons[1].getText() && buttons[0].getText() != "" && buttons[2].isEnabled() == true && buttons[1].getText() == comp)
        {
    		if(buttons[2].isEnabled()) {
            buttons[2].setText(comp);
            buttons[2].setEnabled(false);
            occupied[0][2] = true;
            p = 7;
            }
        }
        else if(buttons[0].getText() == buttons[2].getText() && buttons[0].getText() != "" && buttons[1].isEnabled() == true && buttons[2].getText() == comp)
        {
        	if(buttons[1].isEnabled()) {
            buttons[1].setText(comp);
            buttons[1].setEnabled(false);
            occupied[0][1] = true;
            p = 7;
            }
        }
        else if(buttons[1].getText() == buttons[2].getText() && buttons[1].getText() != "" && buttons[0].isEnabled() == true && buttons[2].getText() == comp)
        {
        	if(buttons[0].isEnabled()) {
            buttons[0].setText(comp);
            buttons[0].setEnabled(false);
            occupied[0][0] = true;
            p = 7;  
        	}	
        }
        else if(buttons[3].getText() == buttons[4].getText() && buttons[3].getText() != "" && buttons[5].isEnabled() == true && buttons[4].getText() == comp)
        {
        	if(buttons[5].isEnabled()) {
            buttons[5].setText(comp);
            buttons[5].setEnabled(false);
            occupied[1][2] = true;
            p = 7;  
        	}
        }
        else if(buttons[3].getText() == buttons[5].getText() && buttons[3].getText() != "" && buttons[4].isEnabled() == true && buttons[5].getText() == comp)
        {
        	if(buttons[4].isEnabled()) {
            buttons[4].setText(comp);
            buttons[4].setEnabled(false);
            occupied[1][1] = true;
            p = 7;  
        	}
        }
        else if(buttons[4].getText() == buttons[5].getText() && buttons[4].getText() != "" && buttons[3].isEnabled() == true && buttons[5].getText() == comp)
        {
        	if(buttons[3].isEnabled()) {
            buttons[3].setText(comp);
            buttons[3].setEnabled(false);
            occupied[1][0] = true;
            p = 7; 
        	}
        }
        else if(buttons[6].getText() == buttons[7].getText() && buttons[6].getText() != "" && buttons[8].isEnabled() == true && buttons[7].getText() == comp)
        {	
        	if(buttons[8].isEnabled()) {
            buttons[8].setText(comp);
            buttons[8].setEnabled(false);
            occupied[2][2] = true;
            p = 7;  
        	}
        }
        else if(buttons[6].getText() == buttons[8].getText() && buttons[6].getText() != "" && buttons[7].isEnabled() == true && buttons[8].getText() == comp)
        {
        	if(buttons[7].isEnabled()) {
            buttons[7].setText(comp);
            buttons[7].setEnabled(false);
            occupied[2][1] = true;
            p = 7;  
        	}
        }
        else if(buttons[7].getText() == buttons[8].getText() && buttons[7].getText() != "" && buttons[6].isEnabled() == true && buttons[8].getText() == comp)
        {
        	if(buttons[6].isEnabled()) {
            buttons[6].setText(comp);
            buttons[6].setEnabled(false);
            occupied[2][0] = true;
            p = 7; 
        	}
        }
        else if(buttons[0].getText() == buttons[3].getText() && buttons[0].getText() != "" && buttons[6].isEnabled() == true && buttons[3].getText() == comp)
        {	
        	if(buttons[6].isEnabled()) {
            buttons[6].setText(comp);
            buttons[6].setEnabled(false);
            occupied[2][0] = true;
            p = 7;  
        	}
        }
        else if(buttons[0].getText() == buttons[6].getText() && buttons[0].getText() != "" && buttons[3].isEnabled() == true && buttons[6].getText() == comp)
        {	
        	if(buttons[3].isEnabled()) {
            buttons[3].setText(comp);
            buttons[3].setEnabled(false);
            occupied[1][0] = true;
            p = 7;  
        	}
        }
        else if(buttons[3].getText() == buttons[6].getText() && buttons[3].getText() != "" && buttons[0].isEnabled() == true && buttons[6].getText() == comp)
        {
        	if(buttons[0].isEnabled()) {
            buttons[0].setText(comp);
            buttons[0].setEnabled(false);
            occupied[0][0] = true;
            p = 7; 
        	}
        }
        else if(buttons[1].getText() == buttons[4].getText() && buttons[1].getText() != "" && buttons[7].isEnabled() == true && buttons[4].getText() == comp)
        {	
        	if(buttons[7].isEnabled()) {
            buttons[7].setText(comp);
            buttons[7].setEnabled(false);
            occupied[2][1] = true;
            p = 7;  
        	}
        }
        else if(buttons[1].getText() == buttons[7].getText() && buttons[1].getText() != "" && buttons[4].isEnabled() == true && buttons[7].getText() == comp)
        {	
        	if(buttons[4].isEnabled()) {
            buttons[4].setText(comp);
            buttons[4].setEnabled(false);
            occupied[1][1] = true;
            p = 7;  
        	}
        }
        else if(buttons[4].getText() == buttons[7].getText() && buttons[4].getText() != "" && buttons[1].isEnabled() == true && buttons[7].getText() == comp)
        {
        	if(buttons[1].isEnabled()) {
            buttons[1].setText(comp);
            buttons[1].setEnabled(false);
            occupied[0][1] = true;
            p = 7; 
        	}
        }
        else if(buttons[2].getText() == buttons[5].getText() && buttons[2].getText() != "" && buttons[8].isEnabled() == true && buttons[5].getText() == comp)
        {
        	if(buttons[8].isEnabled()) {
            buttons[8].setText(comp);
            buttons[8].setEnabled(false);
            occupied[2][2] = true;
            p = 7; 
        	}
        }
        else if(buttons[2].getText() == buttons[8].getText() && buttons[2].getText() != "" && buttons[5].isEnabled() == true && buttons[8].getText() == comp)
        {	
        	if(buttons[5].isEnabled()) {
            buttons[5].setText(comp);
            buttons[5].setEnabled(false);
            occupied[1][2] = true;
            p = 7;  
        	}
        }
        else if(buttons[5].getText() == buttons[8].getText() && buttons[5].getText() != "" && buttons[2].isEnabled() == true && buttons[8].getText() == comp)
        {	
        	if(buttons[2].isEnabled()) {
            buttons[2].setText(comp);
            buttons[2].setEnabled(false);
            occupied[0][2] = true;
            p = 7;  
        	}
        }
        else if(buttons[0].getText() == buttons[4].getText() && buttons[0].getText() != "" && buttons[8].isEnabled() == true && buttons[4].getText() == comp)
        {
        	if(buttons[8].isEnabled()) {
            buttons[8].setText(comp);
            buttons[8].setEnabled(false);
            occupied[2][2] = true;
            p = 7; 
        	}
        }
        else if(buttons[0].getText() == buttons[8].getText() && buttons[0].getText() != "" && buttons[4].isEnabled() == true && buttons[8].getText() == comp)
        {	
        	if(buttons[4].isEnabled()) {
            buttons[4].setText(comp);
            buttons[4].setEnabled(false);
            occupied[1][1] = true;
            p = 7;  
        	}
        }
        else if(buttons[4].getText() == buttons[8].getText() && buttons[4].getText() != "" && buttons[0].isEnabled() == true && buttons[4].getText() == comp)
        {	
        	if(buttons[0].isEnabled()) {
            buttons[0].setText(comp);
            buttons[0].setEnabled(false);
            occupied[0][0] = true;
            p = 7;  
        	}
        }
        else if(buttons[2].getText() == buttons[4].getText() && buttons[2].getText() != "" && buttons[6].isEnabled() == true && buttons[4].getText() == comp)
        {	
        	if(buttons[6].isEnabled()) {
            buttons[6].setText(comp);
            buttons[6].setEnabled(false);
            occupied[2][0] = true;
            p = 7;  
        	}
        }
        else if(buttons[2].getText() == buttons[6].getText() && buttons[2].getText() != "" && buttons[4].isEnabled() == true && buttons[6].getText() == comp)
        {	
        	if(buttons[4].isEnabled()) {
            buttons[4].setText(comp);
            buttons[4].setEnabled(false);
            occupied[1][1] = true;
            p = 7;  
        	}
        }
        else if(buttons[4].getText() == buttons[6].getText() && buttons[4].getText() != "" && buttons[2].isEnabled() == true && buttons[4].getText() == comp)
        {	
        	if(buttons[2].isEnabled()) {
            buttons[2].setText(comp);
            buttons[2].setEnabled(false);
            occupied[0][2] = true;
            p = 7;  
        	}
        }
    	if(p == 7) {} //Checks to see if it needs to block. Looks for two player moves in a row. Will block if it can (otherwise it would lose)
    	else if(buttons[0].getText() == buttons[1].getText() && buttons[0].getText() != "" && buttons[2].isEnabled() == true)
        {
    		if(buttons[2].isEnabled()) {
            buttons[2].setText(comp);
            buttons[2].setEnabled(false);
            occupied[0][2] = true;
            p = 7;
            }
        }
        else if(buttons[0].getText() == buttons[2].getText() && buttons[0].getText() != "" && buttons[1].isEnabled() == true)
        {
        	if(buttons[1].isEnabled()) {
            buttons[1].setText(comp);
            buttons[1].setEnabled(false);
            occupied[0][1] = true;
            p = 7;
            }
        }
        else if(buttons[1].getText() == buttons[2].getText() && buttons[1].getText() != "" && buttons[0].isEnabled() == true)
        {
        	if(buttons[0].isEnabled()) {
            buttons[0].setText(comp);
            buttons[0].setEnabled(false);
            occupied[0][0] = true;
            p = 7;  
        }	
        }
        else if(buttons[3].getText() == buttons[4].getText() && buttons[3].getText() != "" && buttons[5].isEnabled() == true)
        {
        	if(buttons[5].isEnabled()) {
            buttons[5].setText(comp);
            buttons[5].setEnabled(false);
            occupied[1][2] = true;
            p = 7;  
        	}
        }
        else if(buttons[3].getText() == buttons[5].getText() && buttons[3].getText() != "" && buttons[4].isEnabled() == true)
        {
        	if(buttons[4].isEnabled()) {
            buttons[4].setText(comp);
            buttons[4].setEnabled(false);
            occupied[1][1] = true;
            p = 7;  
        	}
        }
        else if(buttons[4].getText() == buttons[5].getText() && buttons[4].getText() != "" && buttons[3].isEnabled() == true)
        {
        	if(buttons[3].isEnabled()) {
            buttons[3].setText(comp);
            buttons[3].setEnabled(false);
            occupied[1][0] = true;
            p = 7; 
        	}
        }
        else if(buttons[6].getText() == buttons[7].getText() && buttons[6].getText() != "" && buttons[8].isEnabled() == true)
        {	
        	if(buttons[8].isEnabled()) {
            buttons[8].setText(comp);
            buttons[8].setEnabled(false);
            occupied[2][2] = true;
            p = 7;  
        	}
        }
        else if(buttons[6].getText() == buttons[8].getText() && buttons[6].getText() != "" && buttons[7].isEnabled() == true)
        {
        	if(buttons[7].isEnabled()) {
            buttons[7].setText(comp);
            buttons[7].setEnabled(false);
            occupied[2][1] = true;
            p = 7;  
        	}
        }
        else if(buttons[7].getText() == buttons[8].getText() && buttons[7].getText() != "" && buttons[6].isEnabled() == true)
        {
        	if(buttons[6].isEnabled()) {
            buttons[6].setText(comp);
            buttons[6].setEnabled(false);
            occupied[2][0] = true;
            p = 7; 
        	}
        }
        else if(buttons[0].getText() == buttons[3].getText() && buttons[0].getText() != "" && buttons[6].isEnabled() == true)
        {	
        	if(buttons[6].isEnabled()) {
            buttons[6].setText(comp);
            buttons[6].setEnabled(false);
            occupied[2][0] = true;
            p = 7;  
        	}
        }
        else if(buttons[0].getText() == buttons[6].getText() && buttons[0].getText() != "" && buttons[3].isEnabled() == true)
        {	
        	if(buttons[3].isEnabled()) {
            buttons[3].setText(comp);
            buttons[3].setEnabled(false);
            occupied[1][0] = true;
            p = 7;  
        	}
        }
        else if(buttons[3].getText() == buttons[6].getText() && buttons[3].getText() != "" && buttons[0].isEnabled() == true)
        {
        	if(buttons[0].isEnabled()) {
            buttons[0].setText(comp);
            buttons[0].setEnabled(false);
            occupied[0][0] = true;
            p = 7; 
        	}
        }
        else if(buttons[1].getText() == buttons[4].getText() && buttons[1].getText() != "" && buttons[7].isEnabled() == true)
        {	
        	if(buttons[7].isEnabled()) {
            buttons[7].setText(comp);
            buttons[7].setEnabled(false);
            occupied[2][1] = true;
            p = 7;  
        	}
        }
        else if(buttons[1].getText() == buttons[7].getText() && buttons[1].getText() != "" && buttons[4].isEnabled() == true)
        {	
        	if(buttons[4].isEnabled()) {
            buttons[4].setText(comp);
            buttons[4].setEnabled(false);
            occupied[1][1] = true;
            p = 7;  
        	}
        }
        else if(buttons[4].getText() == buttons[7].getText() && buttons[4].getText() != "" && buttons[1].isEnabled() == true)
        {
        	if(buttons[1].isEnabled()) {
            buttons[1].setText(comp);
            buttons[1].setEnabled(false);
            occupied[0][1] = true;
            p = 7; 
        	}
        }
        else if(buttons[2].getText() == buttons[5].getText() && buttons[2].getText() != "" && buttons[8].isEnabled() == true)
        {
        	if(buttons[8].isEnabled()) {
            buttons[8].setText(comp);
            buttons[8].setEnabled(false);
            occupied[2][2] = true;
            p = 7; 
        	}
        }
        else if(buttons[2].getText() == buttons[8].getText() && buttons[2].getText() != "" && buttons[5].isEnabled() == true)
        {	
        	if(buttons[5].isEnabled()) {
            buttons[5].setText(comp);
            buttons[5].setEnabled(false);
            occupied[1][2] = true;
            p = 7;  
        	}
        }
        else if(buttons[5].getText() == buttons[8].getText() && buttons[5].getText() != "" && buttons[2].isEnabled() == true)
        {	
        	if(buttons[2].isEnabled()) {
            buttons[2].setText(comp);
            buttons[2].setEnabled(false);
            occupied[0][2] = true;
            p = 7;  
        	}
        }
        else if(buttons[0].getText() == buttons[4].getText() && buttons[0].getText() != "" && buttons[8].isEnabled() == true)
        {
        	if(buttons[8].isEnabled()) {
            buttons[8].setText(comp);
            buttons[8].setEnabled(false);
            occupied[2][2] = true;
            p = 7; 
        	}
        }
        else if(buttons[0].getText() == buttons[8].getText() && buttons[0].getText() != "" && buttons[4].isEnabled() == true)
        {	
        	if(buttons[4].isEnabled()) {
            buttons[4].setText(comp);
            buttons[4].setEnabled(false);
            occupied[1][1] = true;
            p = 7;  
        	}
        }
        else if(buttons[4].getText() == buttons[8].getText() && buttons[4].getText() != "" && buttons[0].isEnabled() == true)
        {	
        	if(buttons[0].isEnabled()) {
            buttons[0].setText(comp);
            buttons[0].setEnabled(false);
            occupied[0][0] = true;
            p = 7;  
        	}
        }
        else if(buttons[2].getText() == buttons[4].getText() && buttons[2].getText() != "" && buttons[6].isEnabled() == true)
        {	
        	if(buttons[6].isEnabled()) {
            buttons[6].setText(comp);
            buttons[6].setEnabled(false);
            occupied[2][0] = true;
            p = 7;  
        	}
        }
        else if(buttons[2].getText() == buttons[6].getText() && buttons[2].getText() != "" && buttons[4].isEnabled() == true)
        {	
        	if(buttons[4].isEnabled()) {
            buttons[4].setText(comp);
            buttons[4].setEnabled(false);
            occupied[1][1] = true;
            p = 7;  
        	}
        }
        else if(buttons[4].getText() == buttons[6].getText() && buttons[4].getText() != "" && buttons[2].isEnabled() == true)
        {	
        	if(buttons[2].isEnabled()) {
            buttons[2].setText(comp);
            buttons[2].setEnabled(false);
            occupied[0][2] = true;
            p = 7;  
        	}
        }
    	//Checks various cases if it is no longer turn one or two and it can't win/block.
    	if(count == 3 && p!= 7) { 
    		if(buttons[1].getText() == buttons[8].getText() && buttons[1].getText() == play) {
    			if(buttons[2].isEnabled()) {		//CASE:	-Pc  Picks enclosed corner (c) if this case arises
    	            buttons[2].setText(comp);		//		---
    	            buttons[2].setEnabled(false);	//		--P
    	            occupied[0][2] = true;
    	            p = 7;  
    	        	}
    		}
    	}
    	if(count == 3 && p!= 7) {
    		if(buttons[1].getText() == buttons[6].getText() && buttons[1].getText() == play) {
    			if(buttons[0].isEnabled()) {		//CASE:	cP- Picks enclosed corner (c) if this case arises
    	            buttons[0].setText(comp);		//		---
    	            buttons[0].setEnabled(false);	//		p--
    	            occupied[0][0] = true;
    	            p = 7;  
    	        	}
    		}
    	}
    	if(count == 3 && p!= 7) {
    		if(buttons[7].getText() == buttons[0].getText() && buttons[7].getText() == play) {
    			if(buttons[6].isEnabled()) {		//CASE:	P-- Same corner case
    	            buttons[6].setText(comp);		//		---
    	            buttons[6].setEnabled(false);	//		cP-
    	            occupied[2][0] = true;
    	            p = 7;  
    	        	}
    		}
    	}
    	if(count == 3 && p!= 7) {
    		if(buttons[7].getText() == buttons[2].getText() && buttons[7].getText() == play) {
    			if(buttons[8].isEnabled()) {		//CASE: --P
    	            buttons[8].setText(comp);		//		---
    	            buttons[8].setEnabled(false);	//		-Pc
    	            occupied[2][2] = true;
    	            p = 7;  
    	        	}
    		}
    	}
    	if(count == 3 && p!= 7) {
    		if(buttons[3].getText() == buttons[2].getText() && buttons[3].getText() == play) {
    			if(buttons[0].isEnabled()) {		//CASE:	c-P
    	            buttons[0].setText(comp);		//		P--
    	            buttons[0].setEnabled(false);	//		---
    	            occupied[0][0] = true;
    	            p = 7;  
    	        	}
    		}
    	}
    	if(count == 3 && p!= 7) {
    		if(buttons[3].getText() == buttons[8].getText() && buttons[3].getText() == play) {
    			if(buttons[6].isEnabled()) {		//CASE:	---
    	            buttons[6].setText(comp);		//		P--
    	            buttons[6].setEnabled(false);	//		c-P
    	            occupied[2][0] = true;
    	            p = 7;  
    	        	}
    		}
    	}
    	if(count == 3 && p!= 7) {
    		if(buttons[5].getText() == buttons[0].getText() && buttons[5].getText() == play) {
    			if(buttons[2].isEnabled()) {		//CASE:	P-c
    	            buttons[2].setText(comp);		//		--P
    	            buttons[2].setEnabled(false);	//		---
    	            occupied[0][2] = true;
    	            p = 7;  
    	        	}
    		}
    	}
    	if(count == 3 && p!= 7) {
    		if(buttons[5].getText() == buttons[6].getText() && buttons[5].getText() == play) {
    			if(buttons[8].isEnabled()) {		//CASE:	---
    	            buttons[8].setText(comp);		//		--P
    	            buttons[8].setEnabled(false);	//		P-c
    	            occupied[2][2] = true;
    	            p = 7;  
    	        	}
    		}
    	}
    	if(count == 0) { //NEW CASE: Offensive Moves(computer went first)
    		
    		int BOX = (int)(4.0 * Math.random()) + 1; 
            switch (BOX) { // computer's first move is to one of the corners (chooses at random)
             case 1: if(buttons[0].isEnabled()) {
                        buttons[0].setText(comp);
                        buttons[0].setEnabled(false); //Top Left
                        occupied[0][0] = true; 
                        p = 7;
                    }
                    break;
             case 2: if(buttons[2].isEnabled()) {
                        buttons[2].setText(comp);
                        buttons[2].setEnabled(false); //Top Right
                        occupied[0][2] = true;
                        p = 7;
                    }
                    break;
             case 3: if(buttons[6].isEnabled()) {
                        buttons[6].setText(comp);
                        buttons[6].setEnabled(false); //Bottom Left
                        occupied[2][0] = true;
                        p = 7;
                    }
                    break;
             case 4: if(buttons[8].isEnabled()) {
                        buttons[8].setText(comp);
                        buttons[8].setEnabled(false); //Botton Right
                        occupied[2][2] = true; 
                        p = 7;
                    }
            }
    	}
    	if((buttons[6].getText() == buttons[4].getText() && buttons[2].getText() != buttons[4].getText()) ||
           (buttons[2].getText() == buttons[4].getText() && buttons[4].getText() != buttons[6].getText()))
	    	{ 				//NEW CASE: if there are two similar moves and one opponent move in a diagonal (PPC or CCP on diagonal)
    			if(p!=7) {	//we put next move at one of the two remaining open corners
    			
	    		int BOX = (int)(2.0 * Math.random()) + 1;
	            switch (BOX) {
	             case 1: if(buttons[0].isEnabled()) {
	                        buttons[0].setText(comp);
	                        buttons[0].setEnabled(false);
	                        occupied[0][0] = true;
	                        p = 7;
	                    }
	                    break;
	             case 2: if(buttons[8].isEnabled()) {
	                        buttons[8].setText(comp);
	                        buttons[8].setEnabled(false);
	                        occupied[2][2] = true;
	                        p = 7;
	                    }
	                    break;
	            }}
	    	}
    	if((buttons[0].getText() == buttons[4].getText() && buttons[8].getText() != buttons[4].getText()) ||
    	           (buttons[8].getText() == buttons[4].getText() && buttons[4].getText() != buttons[0].getText()))
    		    	{	if(p!=7){ //SAME CASE: using the other two corners/ checking for other two diagonals)
    	    			
    		    		int BOX = (int)(2.0 * Math.random()) + 1;
    		            switch (BOX) {
    		             case 1: if(buttons[2].isEnabled()) {
    		                        buttons[2].setText(comp);
    		                        buttons[2].setEnabled(false);
    		                        occupied[0][2] = true;
    		                        p = 7;
    		                    }
    		                    break;
    		             case 2: if(buttons[6].isEnabled()) {
    		                        buttons[6].setText(comp);
    		                        buttons[6].setEnabled(false);
    		                        occupied[2][0] = true;
    		                        p = 7;
    		                    }
    		                    break;
    		            }}
    		    	}
    	else if(count == 3 && p != 7) {//NEW CASE: 
    		if((buttons[0].getText() == buttons[8].getText() && buttons[4].getText() != buttons[0].getText()) ||
    	    		   (buttons[2].getText() == buttons[6].getText() && buttons[4].getText() != buttons[0].getText())) {
    	    		p = 7;
    	    		int BOX = (int)(4.0 * Math.random()) + 1;
    	            switch (BOX) {
    	             case 1: if(buttons[1].isEnabled()) {
    	                        buttons[1].setText(comp);
    	                        buttons[1].setEnabled(false);
    	                        occupied[0][1] = true;
    	                        p = 7;
    	                    }
    	                    break;
    	             case 2: if(buttons[3].isEnabled()) {
    	                        buttons[3].setText(comp);
    	                        buttons[3].setEnabled(false);
    	                        occupied[1][0] = true;
    	                        p = 7;
    	                    }
    	                    break;
    	             case 3: if(buttons[5].isEnabled()) {
    	                        buttons[5].setText(comp);
    	                        buttons[5].setEnabled(false);
    	                        occupied[1][2] = true;
    	                        p = 7;
    	                    }
    	                    break;
    	             case 4: if(buttons[7].isEnabled()) {
    	                        buttons[7].setText(comp);
    	                        buttons[7].setEnabled(false);
    	                        occupied[2][1] = true; 
    	                        p = 7;
    	                    }
    	            }
    	    	}
    	//oxx xo* o*o
    	else if(buttons[0].getText() == buttons[8].getText() && buttons[4].getText() != buttons[0].getText() && p!=7 && buttons[0].getText() != "" && buttons[4].getText() != "")
        {	
        	if(buttons[2].isEnabled()) {
            buttons[2].setText(comp);
            buttons[2].setEnabled(false);
            occupied[0][2] = true;
            p = 7;  
        	}
        }
    	}
       if(p != 7) {
        do{
            int BOX = (int)(9.0 * Math.random()) + 1;
            switch (BOX) {
             case 1: if(buttons[0].isEnabled()) {
                        buttons[0].setText(comp);
                        buttons[0].setEnabled(false);
                        occupied[0][0] = true;
                        p = 100;  
                    }
                    break;
             case 2: if(buttons[1].isEnabled()) {
                        buttons[1].setText(comp);
                        buttons[1].setEnabled(false);
                        occupied[0][1] = true;
                        p = 100;
                    }
                    break;
             case 3: if(buttons[2].isEnabled()) {
                        buttons[2].setText(comp);
                        buttons[2].setEnabled(false);
                        occupied[0][2] = true;
                        p = 100; 
                    }
                    break;
             case 4: if(buttons[3].isEnabled()) {
                        buttons[3].setText(comp);
                        buttons[3].setEnabled(false);
                        occupied[1][0] = true;
                        p = 100;  
                    }
                    break;
             case 5: if(buttons[4].isEnabled()) {
                        buttons[4].setText(comp);
                        buttons[4].setEnabled(false);
                        occupied[1][1] = true;
                        p = 100; 
                    }
                    break;
             case 6: if(buttons[5].isEnabled()) {
                        buttons[5].setText(comp);
                        buttons[5].setEnabled(false);
                        occupied[1][2] = true;
                        p = 100;    
                    }
                    break;
             case 7: if(buttons[6].isEnabled()) {
                        buttons[6].setText(comp);
                        buttons[6].setEnabled(false);
                        occupied[2][0] = true;
                        p = 100; 
                    }
                    break;
             case 8: if(buttons[7].isEnabled()) {
                        buttons[7].setText(comp);
                        buttons[7].setEnabled(false);
                        occupied[2][1] = true;
                        p = 100;  
                    }
                    break;
             case 9: if(buttons[8].isEnabled()) {
                        buttons[8].setText(comp);
                        buttons[8].setEnabled(false);
                        occupied[2][2] = true;
                        p = 100;
                    }
                    break;
            }
        } while(p!=100);
       }
        count++;
        testresults();
        if(win==true) {
            buttons[0].setEnabled(false);
            buttons[1].setEnabled(false);
            buttons[2].setEnabled(false);
            buttons[3].setEnabled(false);
            buttons[4].setEnabled(false);
            buttons[5].setEnabled(false);
            buttons[6].setEnabled(false);
            buttons[7].setEnabled(false);
            buttons[8].setEnabled(false);
            computerwins();
        }
    	
    }
    public void testresults()
    {
        if(buttons[0].getText() == buttons[1].getText() && buttons[1].getText() == buttons[2].getText() && buttons[0].getText() != "")
        {win = true;}
        else if(buttons[3].getText() == buttons[4].getText() && buttons[4].getText() == buttons[5].getText() && buttons[3].getText() != "")
        {win = true;}
        else if(buttons[6].getText() == buttons[7].getText() && buttons[7].getText() == buttons[8].getText() && buttons[6].getText() != "")
        {win = true;}
        else if(buttons[0].getText() == buttons[4].getText() && buttons[4].getText() == buttons[8].getText() && buttons[0].getText() != "")
        {win = true;}
        else if(buttons[2].getText() == buttons[4].getText() && buttons[4].getText() == buttons[6].getText() && buttons[2].getText() != "")
        {win = true;}
        else if(buttons[0].getText() == buttons[3].getText() && buttons[3].getText() == buttons[6].getText() && buttons[0].getText() != "")
        {win = true;}
        else if(buttons[1].getText() == buttons[4].getText() && buttons[4].getText() == buttons[7].getText() && buttons[1].getText() != "")
        {win = true;}
        else if(buttons[2].getText() == buttons[5].getText() && buttons[5].getText() == buttons[8].getText() && buttons[2].getText() != "")
        {win = true;}
        else if(count>=9)
        {win = true;
         tie = true;}
    }
    public void playerwins() {
        if(tie==true)//occupied[0][0]==occupied[0][1]&&occupied[0][1]==occupied[0][2]&&occupied[0][2]==occupied[1][0]&&occupied[1][0]==occupied[1][1]&&occupied[1][1]==occupied[1][2]&&occupied[1][2]==occupied[2][0]&&occupied[2][0]==occupied[2][1]&&occupied[2][1]==occupied[2][2]&&tie==true)
            System.out.println("It's a tie!");
        else
            System.out.println("Player Wins");
    }
    public void computerwins() {
        if(tie==true)//occupied[0][0]==occupied[0][1]&&occupied[0][1]==occupied[0][2]&&occupied[0][2]==occupied[1][0]&&occupied[1][0]==occupied[1][1]&&occupied[1][1]==occupied[1][2]&&occupied[1][2]==occupied[2][0]&&occupied[2][0]==occupied[2][1]&&occupied[2][1]==occupied[2][2]&&tie==true)
            System.out.println("It's a tie!");
        else
            System.out.println("Computer Wins");
    }
    public static void main(String[] args) {
        Object[] options = {"O","X"};
        int n = JOptionPane.showOptionDialog(null,"Would you like to be X's or O's?","Tic-Tac-Toe",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        if(n==1) {
            play="X";
            comp="O"; 
        }
        else {
            play="O";
            comp="X";
        }
        Object[] option = {"Yes","No"};
        int k = JOptionPane.showOptionDialog(null,"Would you like to go first?","Tic-Tac-Toe",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
        if(k==1) {
        	JOptionPane.showMessageDialog(null,"You will go second.\nGood Luck!");
            TicTacToe G = new TicTacToe();
            G.computer();
        }
        else{
        JOptionPane.showMessageDialog(null,"You will go first.\nGood Luck!");
        new TicTacToe();
            }
    }
}