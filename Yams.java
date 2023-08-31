import java.io.*;
import java.util.Scanner;

class Yams {
    static Scanner saisie = new Scanner(System.in);
    
    public static void afficheBanniere() {
	System.out.println("*********************************************");
        System.out.println("**                                         **");
	System.out.println("**               Le  Yams                  **");
	System.out.println("**                                         **");                     System.out.println("*********************************************");
    }


               /* Tri des Des (tri par selection) */
    public static void echanger(int[]tab,int a,int b) { 

	int aux = tab[a];tab[a]=tab[b];tab[b]=aux; }


    public static void tride(int[]tab) {
	for ( int i=0; i<tab.length-1;i++)
	    {  
		int min = i; 
		for (int j = i+1; j<tab.length;j++)
		    { 
			if (tab[j] < tab[min])
			    {
				min=j;
			     }
		    }
		echanger(tab,i,min);
	    }
          } 

 public static int[]lancerde(int[]tab) {
        int n=0;
        int m=0;
	boolean[]relancer = new boolean[5];  /*Tableau de boolean pour relancer */

    for (int g=0;g<5;g++) 
		{ relancer[g]=true;}
  for (int h=0;h<3;h++)                /* Boucle pour relancer les De(s) */ 
            {
  for  (int i=0;i<5;i++)
	 { if (relancer[i]) { tab[i]=(int)(Math.random()*6+1);}}
	tride(tab);
	    for (int g=0;g<5;g++)
	            { System.out.println("De n "+(g+1)+"="+tab[g]);}


	                  if (h != 2) { 
		             for (int k=0;k<5;k++) 
		                   { relancer[k]=false;}
        
	    
 System.out.println("Combien de De(s) voulez vous relancer ? (Sinon taper 0)"); 
  n = saisie.nextInt();
		        if (n==0) {return tab;} 
			if(n>0) {
				      for (int i=0;i<n;i++) 
					  {
			 System.out.println("Quel numero de De voulez vous relancer ?");
				       m = saisie.nextInt();relancer[m-1]=true; }}}}
	return tab;}

    /*Les Contrats */
    public static void sommescontrats(int choix,int[]tab,int[]scores,int j,int[]bonus) {
        int total=0;
	for ( int g=0;g<5;g++)
	    { if (tab[g]==choix) { total=total + choix;}}
        scores[j]=scores[j]+total;
	bonus[j]=bonus[j]+total;
	System.out.println("Vous avez obtenu : "+total+" points");
	    }
    public static void brelan(int[]tab,int[]scores,int j) {
	int total=0;
	int somme=0;
        int marqueur=0;
	for (int g=0;g<tab.length-2;g++)
	    { if (tab[g]==tab[g+2]) {  marqueur=1;}  } 
	      if(marqueur==1) 
		  { for (int i=0;i<tab.length;i++) 
                                    { somme=tab[i]+somme;}
		      { total=somme;} }
	scores[j]=scores[j]+total;
	System.out.println("Vous avez obtenu : "+total+" points");}

   public static void full(int[]tab,int[]scores,int j) {
	int total=0;
        for (int g=0;g<tab.length;g++) 
	    { if (((tab[0]==tab[1]) && (tab[2]==tab[4])) || ((tab[3]==tab[4] && tab[0]==tab[2]))) { total=25;} }
	scores[j]=scores[j]+total;
	System.out.println("Vous avez obtenu : "+total+" points");}
 
 public static void carre(int[]tab,int[]scores,int j) {
	int total=0;
	int somme=0;
        int marqueur=0;
        
	for (int g=0;g<tab.length;g++) 
	    { if(tab[0]==tab[3] || tab[1]==tab[4]) { marqueur=1;}}
		if(marqueur==1)
		    {
                     for (int i=0;i<tab.length;i++ ) 
			 { somme=tab[i]+somme;}
		     { total=somme;} }
		scores[j]=scores[j]+total;
		System.out.println("Vous avez obtenu : "+total+" points");}  
        
    public static void petitesuite(int[]tab,int[]scores,int j) {
	int marqueur=0;
        int marqueur1=0;
        int marqueur2=0;
        int marqueur3=0;
        int marqueur4=0;
	int marqueur5=0;
	int marqueur6=0;

        int total=0;
	for (int g=1;g<7;g++)
            { for (int i=0;i<5;i++) 
		    { if(tab[i]==g) { i=5;marqueur=marqueur+1;} } 
	    }
	for (int l=0;l<tab.length;l++) 
	    { if(tab[l]==4) { marqueur1=1;}
		if(tab[l]==3) {marqueur2=1;} }
	if( (marqueur >= 4) && (marqueur1==1) && (marqueur2==1) )
            { total=30;} scores[j]=scores[j]+total;
	    System.out.println("Vous avez obtenu : "+total+" points");}




    
    public static void grandesuite(int[]tab,int[]scores,int j) {
	int total=0;
	for (int g=0;g<tab.length;g++)
	    { if( (tab[0]==1 && tab[1]==2 && tab[2]==3 && tab[3]==4 && tab[4]==5)  || (tab[0]==2 && tab[1]==3 && tab[2]==4 && tab[3]==5 && tab[4]==6) ) {{ total=40;} }
	    }scores[j]=scores[j]+total;
		System.out.println("Vous avez obtenu : "+total+" points");}
   
    
    public static void yams(int[]tab,int[]scores,int j) {
	int total=0;
        
	for (int g=0;g<tab.length;g++)
          { if(tab[0]==tab[4]) {
		  
		  { total=50;} } }
	scores[j]=scores[j]+total;
	      System.out.println("Vous avez obtenu : "+total+" points");}
    public static void chance(int[]tab,int[]scores,int j) {
	int somme=0;
	int total=0;
       
	for (int g=0;g<tab.length;g++) {
	    somme=tab[g]+somme; }
	total=somme; 
	scores[j]=scores[j]+total;
	System.out.println("Vous avez obtenu : "+total+" points");}

    /* Bloc contrat*/ 
    public static void retourbloccontrat(boolean[][]tab,int n) {
	for (int g=0;g<n;g++) 
	    { for (int k=0;k<13;k++) 
		    {tab[g][k]=false;}
	    }
		 }
    







    /* Prog */      

    public static void main(String[] args) {
	System.out.println("\n");
        System.out.println("\n");
	afficheBanniere();
        boolean[][]bloccontrat;
        int[]accumulationscores; 
	int n;
	int[]bonus;
        System.out.println("\n");
        System.out.println("\n");
	System.out.println( "Nombre de joueur(s) ?");
        n=saisie.nextInt();
        accumulationscores=new int[n];
        bloccontrat=new boolean[n][13];
	bonus=new int[n];
        retourbloccontrat(bloccontrat,n);
	for (int g=1;g<=13;g++) /* Nbs Tours */
     { System.out.println("\n");System.out.println("   Tour n "+g+"\n");
	    for( int j=0;j<n;j++)
		{ System.out.println("\n");System.out.println("C'est au tour du joueur "+(j+1));
	    int[]tab = new int[5];
            lancerde(tab);
            

            int choix=0;
            
	    System.out.println("Listes des 13 contrats ");
            System.out.println("1) les 1 : somme des 1");
            System.out.println("2) les 2 : somme des 2");
            System.out.println("3) les 3 : somme des 3");
            System.out.println("4) les 4 : somme des 4");
            System.out.println("5) les 5 : somme des 5");
            System.out.println("6) les 6 : somme des 6");
            System.out.println("7) le brelan (au moins 3 de identiques) : somme des  5 des; ");
            System.out.println("8) le full (3 des identiques + 2 autres des identiques) : 25 points; ");
            System.out.println("9) le carre (au moins 4 des identiques) : sommes des 5 des;");
            System.out.println("10) la petite suite (4 des qui se suivent : 1,2,3,4 ou 2,3,4,5 ou 3,4,5,6) : 30 points");
            System.out.println("11) la grande suite (5 des qui se suivent : 1,2,3,4,5 ou 2,3,4,5,6) : 40 points ");
            System.out.println("12) le Yams (5 des identiques) : 50 points");
            System.out.println("13) la chance : somme des 5 des.");
	    do { 
            System.out.println(" Valider un contrat ");
	    choix = saisie.nextInt();
		} while (bloccontrat[j][choix-1]==true);
	    if (choix == 1) { sommescontrats(choix,tab,accumulationscores,j,bonus);bloccontrat[j][choix-1]=true;}
            if (choix == 2) { sommescontrats(choix,tab,accumulationscores,j,bonus);bloccontrat[j][choix-1]=true;}
            if (choix == 3) { sommescontrats(choix,tab,accumulationscores,j,bonus);bloccontrat[j][choix-1]=true;} 
            if (choix == 4) { sommescontrats(choix,tab,accumulationscores,j,bonus);bloccontrat[j][choix-1]=true;}
            if (choix == 5) { sommescontrats(choix,tab,accumulationscores,j,bonus);bloccontrat[j][choix-1]=true;}
            if (choix == 6) { sommescontrats(choix,tab,accumulationscores,j,bonus);bloccontrat[j][choix-1]=true;}
            if (choix == 7) { brelan(tab,accumulationscores,j);bloccontrat[j][choix-1]=true;}
            if (choix == 8) { full(tab,accumulationscores,j);bloccontrat[j][choix-1]=true;}
	    if (choix == 9) { carre(tab,accumulationscores,j);bloccontrat[j][choix-1]=true;}
            if (choix == 10) { petitesuite(tab,accumulationscores,j);bloccontrat[j][choix-1]=true;}
	    if (choix == 11) { grandesuite(tab,accumulationscores,j);bloccontrat[j][choix-1]=true;}
            if (choix == 12) {yams(tab,accumulationscores,j);bloccontrat[j][choix-1]=true;} 
            if (choix == 13) {chance(tab,accumulationscores,j);bloccontrat[j][choix-1]=true;} 
            System.out.println("Scores du joueur "+(j+1)+" : "+accumulationscores[j]+" points");
if (bonus[j] >=63 && g==13) 
    { 
accumulationscores[j]=accumulationscores[j]+35;

	     System.out.println("Vous avez obtenu un Bonus de 35 points");
	     System.out.println("Votre score final est de : "+accumulationscores[j]+" points"); }
if (bonus[j] < 63 && g==13) {
             System.out.println("Vous n avez pas obtenu de Bonus ");
             System.out.println("Votre score final est de : "+accumulationscores[j]+" points");

	    }
          }
        }      
     }
}
