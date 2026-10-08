/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amran.solution.javaStream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author amranhossain
 */
public class FindDistinctFromArray {

    public static void main(String[] args) {
        
        
        
        List<Tainer> trainers = new ArrayList<>();
        trainers.add(new Tainer("Java", true));
        trainers.add(new Tainer("Spring Boot", true));
        trainers.add(new Tainer("Java", true));
        trainers.add(new Tainer("Kafaka", true));
        trainers.add(new Tainer("Kafaka", false));
        

        String result = trainers.stream().filter(Tainer::isCertified)
                .map(m -> m.skill)
                .distinct()
                .collect(Collectors.joining(","));
        
        System.out.println("Result: " + result);

    }

    public static class Tainer {

        String skill;
        boolean certified;

        public Tainer(String skill, boolean certified) {
            this.skill = skill;
            this.certified = certified;
        }
        
        

        public String getSkill() {
            return skill;
        }

        public void setSkill(String skill) {
            this.skill = skill;
        }

        public boolean isCertified() {
            return certified;
        }

        public void setCertified(boolean certified) {
            this.certified = certified;
        }
    }
}
