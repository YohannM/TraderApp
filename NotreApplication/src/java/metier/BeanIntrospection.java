/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.io.*;
import java.beans.*;
import java.lang.reflect.*;

public class BeanIntrospection {


    public static void main(String args[]) throws Exception {
        new BeanIntrospection("metier.Trade");
    }

    public BeanIntrospection(String nomClasse) throws Exception {

        Class monBeanClasse = Class.forName(nomClasse);
        MethodDescriptor[] methodDescriptor;
        BeanInfo bi = Introspector.getBeanInfo(monBeanClasse, monBeanClasse.getSuperclass());
        BeanDescriptor unBeanDescriptor = bi.getBeanDescriptor();

        System.out.println("Nom du bean    : " + unBeanDescriptor.getName());

        System.out.println("Classe du bean : " + unBeanDescriptor.getBeanClass());

        System.out.println("");
        
        System.out.println("Liste des propriétés :");

        PropertyDescriptor[] propertyDescriptor = bi.getPropertyDescriptors();

        for (int i = 0; i < propertyDescriptor.length; i++) {

            System.out.println(" \tNom propriete    : "
                    + propertyDescriptor[i].getName());

            System.out.println(" \tType propriete   : "
                    + propertyDescriptor[i].getPropertyType());

            System.out.println(" \tGetter propriete : "
                    + propertyDescriptor[i].getReadMethod());

            System.out.println(" \tSetter propriete : "
                    + propertyDescriptor[i].getWriteMethod());

        }

        System.out.println("");
        methodDescriptor = bi.getMethodDescriptors();
        
        System.out.println("Liste des méthodes :");
        
        for (int i = 0; i < methodDescriptor.length; i++) {
            System.out.println(" \tMethode : " + methodDescriptor[i].getName());
        }
        
        System.out.println("");
        
        EventSetDescriptor[] unEventSetDescriptor = bi.getEventSetDescriptors();
        
        for (int i = 0; i < unEventSetDescriptor.length; i++) {
            System.out.println(" \tNom evt: " + unEventSetDescriptor[i].getName());

            System.out.println(" \tMethode add evt : " + unEventSetDescriptor[i].getAddListenerMethod());

            System.out.println(" \tMethode remove evt : " + unEventSetDescriptor[i].getRemoveListenerMethod());

            methodDescriptor = unEventSetDescriptor[i].getListenerMethodDescriptors();
            
            for (int j = 0; j < methodDescriptor.length; j++) {
                System.out.println(" \tEvent Type: " + methodDescriptor[j].getName());
            }
        }
        
        System.out.println("");
        
    }


}
