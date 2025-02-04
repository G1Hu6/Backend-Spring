package com.orm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.orm.dao.PlayerDao;
import com.orm.dao.PlayerDaoImpl;
import com.orm.entities.Player;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
/**
 *Spring-Orm Console Project !
 *
 */
public class App 
{
    public static void main( String[] args) throws java.io.IOException
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("com/orm/ormconfig.xml");
        
    	PlayerDao playerDao = context.getBean("playerDao", PlayerDao.class);
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	char chr = ' ';
    	do {
    		System.out.println("--------------------Welcome to my Spring-Orm Console project -------------------");
    		System.out.println("SELECT 1 : to INSERT player");
    		System.out.println("SELECT 2 : to DISPLAY single player");
    		System.out.println("SELECT 3 : to DISPLAY ALL players");
    		System.out.println("SELECT 4 : to DELETE player");
    		System.out.println("SELECT 5 : to UPDATE player");
    		System.out.println("SELECT 6 : EXIT");
    		
    		System.out.println("Enter Your Choice :");
    		int choice = Integer.parseInt(br.readLine());
    		
    		boolean isExit = false;
    		switch(choice) {
    		
    			case 1 :{
    				Player player = new Player();
    				System.out.println("Enter Player id :");
    				player.setId( Integer.parseInt(br.readLine()));
    				System.out.println("Enter Player name :");
    				player.setName(br.readLine());
    				System.out.println("Enter Player jercy number :");
    				player.setJerNo( Integer.parseInt(br.readLine()));
    				System.out.println("Enter Player total scores :");
    				player.setTotalScore( Integer.parseInt(br.readLine()));
    				int result = 0;
    				try {
    					result = playerDao.insertPlayer(player);
    				}catch(Exception e) {
    					System.out.println("Please Enter Correct Input...");
    					e.getMessage();
    				}
    				System.out.println("Player is inserted with id :" + result);
    				break;
    			}
    			case 2 :{
    				System.out.println("Enter player Id :");
    				int playerId =  Integer.parseInt(br.readLine());
    				
    				Player p = playerDao.getPlayer(playerId);

					System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					System.out.println("Id :" + p.getId());
					System.out.println("Name :" + p.getName());
					System.out.println("JercyNo :" + p.getJerNo());
					System.out.println("Score :" + p.getTotalScore());
					System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    				break;
    			}
    			case 3 :{
    				
    				List<Player> totalPlayers = playerDao.getAllPlayers();
    				for(Player p : totalPlayers) {
    					
    					System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    					System.out.println("Id :" + p.getId());
    					System.out.println("Name :" + p.getName());
    					System.out.println("JercyNo :" + p.getJerNo());
    					System.out.println("Score :" + p.getTotalScore());
    					System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    				}
    				break;
    			}
    			case 4 :{
    				
    				System.out.println("Enter player Id :");
    				int playerId =  Integer.parseInt(br.readLine());
    				if(playerDao.deletePlayer(playerId)) {
    					System.out.println("Player is deleated");
    				
    				}else {
    					System.out.println("Please Enter valid Id");
    				}
    				break;
    			}
    			case 5 :{
    				
    				Player player = new Player();
    				System.out.println("Enter Player id :");
    				player.setId( Integer.parseInt(br.readLine()));
    				System.out.println("Enter Player name :");
    				player.setName(br.readLine());
    				System.out.println("Enter Player jercy number :");
    				player.setJerNo( Integer.parseInt(br.readLine()));
    				System.out.println("Enter Player total scores :");
    				player.setTotalScore( Integer.parseInt(br.readLine()));
    				try {
    					playerDao.updatePlayer(player);
    				}catch(Exception e) {
    					System.out.println("Please Enter Correct Input...");
    					e.getMessage();
    				}
    				break;
    			}
    			case 6 :{
    				isExit = true;
    				chr = 'Y';
    				break;
    			}
    			default :{
    				System.out.println("Please Enter valid number !!!");
    				break;
    			}
    		}
    		if(!isExit) {
    			System.out.println("Do you want to Continue (Y | y)");
        		chr = br.readLine().charAt(0);
    		}
    		
    	}while(chr == 'Y' || chr == 'y');
        System.out.println("-----------------------------Thank You !!!!-------------------------");
    }
}
