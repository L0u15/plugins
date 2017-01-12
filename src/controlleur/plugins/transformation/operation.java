package controlleur.plugins.transformation;

import java.util.ArrayList;

/**
 *
 * @author gianni
 */

public class operation
{
   
    //Transformation logarithme
    
    public static double ln(double a)
    {
        return Math.log(a);    
    }
    
    //Transformation Box-cox
    
    public static double BoxCox( double x, double alpha)
    {
        
        if(alpha > 0)
        {
        return (Math.pow(x, alpha) -1) / alpha;
        }
        else if(alpha == 0)
        {
        return Math.log(x);
        }
         throw new IllegalArgumentException("valeur non acceptée :"+alpha);
    }
    
    //Transformation logistique pour les données Intervalle ]0,1[
    
    public static double logistique(double x)
    {
         if( x<1 && x>0)
        {
        return Math.log(x/(1-x)); 
        }
        System.out.println("les données ne sont pas dans l'intervalle ]0,1[ :");
    return x;
    }
    
//mtn faire les test ex dans box cox ne doit recevoir un true que alpha =0 et alpha >1 et false pour le negatif    
    
    public static boolean testBoxCox(double alpha)
    {
       return alpha >= 0;
    
    }
    
    public static boolean testLogistique(double beta)
    {
       return (beta <1 && beta > 0);
       
    }
            
    
    
    /*public static void main(String[] args)
    {
        double testLog = 6;
        double resultatLog ;
        
        
        double testBoX = 6.0;
        double testBoxY = 2.0;
        double testBoxY1 = 0.0;
        double testBoxY2 = -1;
        double resultatBox ;
        
        
        double logis1 = 0.25;
        double logis2 = 2.0;
        double resultatlogi;
        
        
        resultatLog = ln(testLog);
        System.out.println("résultat de logarithme : "+ resultatLog);
        
        resultatBox = BoxCox(testBoX,testBoxY);
        System.out.println("résultat de BoxCox : "+resultatBox);
        
        resultatBox = BoxCox(testBoX,testBoxY1);
        System.out.println("résultat de BoxCox : "+resultatBox);
        
        resultatBox = BoxCox(testBoX,testBoxY2);
        System.out.println("résultat de BoxCox : "+resultatBox);
        
        resultatlogi = logistique(logis1);
        System.out.println("résultat de logistique :"+ resultatlogi);
        
        resultatlogi = logistique(logis2);
        System.out.println("résultat de logistique :"+ resultatlogi);
    }*/

        
}
 
