package org.example.StoryTelling;
import org.example.Enums.FOODStatus;
import org.example.Enums.ITEMStatus;
import org.example.Enums.METHODSofCooking;
import org.example.Enums.REASONS;
import org.example.Excaptions.CustomException;
import org.example.Excaptions.FailedExcapiton;
import org.example.Items.Fire;
import org.example.Items.Food;
import org.example.Items.Item;
import org.example.Locations.Location;
import org.example.Persons.*;

import java.util.Scanner;

public class Story {


    static Statment stat = new Statment("?", "", "do not");

    public void check_stat(String s){
        if(s == stat.no()){
            System.out.println(" Я не буду этого делать !!");
        }else if(s == stat.ask()){
            System.out.println("?");
        }
    }

    public void defaultStory() throws CustomException, FailedExcapiton {

        Human hero1 = new Human("John", 22, 175);
        Annotation this_story = new Annotation(hero1, "you", "a story about a man who is imprisoned on an island where savages live");
        Item think = new Item("Think", ITEMStatus.ACTIVE, hero1);
        Saint god = new Saint("God", 100000, 175);
        hero1.use(think, REASONS.knowledge);
        god.carry(hero1, REASONS.love);

        Item life_rule = new Item(" Life rule " , ITEMStatus.ACTIVE, hero1);
        hero1.create(life_rule, REASONS.understanding);
        Item inner_voice = new Item(" Inner voice", ITEMStatus.ACTIVE, hero1);
        hero1.listen(inner_voice, REASONS.habit);

        Item pin = new Item("Pin", ITEMStatus.ACTIVE);
        Item wood = new Item("Billet", ITEMStatus.ACTIVE);
        hero1.use(pin, REASONS.fear);
        check_stat(stat.no());
        hero1.use(wood, REASONS.fear);
        check_stat(stat.no());
        Item gun = new Item("Gun", ITEMStatus.ACTIVE);
        hero1.use(gun);
        check_stat(stat.no());


        Savage savage = new Savage("Savage", 21, 160);
        savage.listen(hero1, REASONS.suggestion);
        Item scare = new Item("Scare", ITEMStatus.ACTIVE);
        hero1.have(scare);

        Location forest = new Location("Forest", 0.3);
        Location rock = new Location("High rock", 100 );
        Location home = new Location("Home", 0.5, rock);
        hero1.addOwn(home);
        hero1.find(home, REASONS.interest);
        hero1.moveTo(home, REASONS.love);
        for(Item i: hero1.own){
            hero1.moveTo(home, i);
        }


        Item weed = new Item("Weed", ITEMStatus.ACTIVE);
        Fire fire = new Fire("Cave", ITEMStatus.ACTIVE,weed, home, true);

        hero1.scared(fire.getSmoke(), REASONS.logic);
        check_stat(stat.yes());

        Food bread = new Food("Bread",  1200, FOODStatus.RAW, new METHODSofCooking[]{METHODSofCooking.BAKEING, METHODSofCooking.FRYING, METHODSofCooking.BOILING});


        hero1.cook(bread, METHODSofCooking.BAKEING);
        check_stat(stat.no());

        Food beef = new Food("Beef", 4000, FOODStatus.RAW, new METHODSofCooking[]{METHODSofCooking.BOILING, METHODSofCooking.FRYING, METHODSofCooking.BAKEING});


        hero1.cook(beef, METHODSofCooking.BOILING);
        check_stat(stat.no());


        hero1.moveTo(forest);
        check_stat(stat.yes());

        Item brancheas = new Item("Little branches", ITEMStatus.ACTIVE, forest);
        hero1.burn(fire, brancheas);
        check_stat(stat.yes());

        Item coal = new Item("Coal", ITEMStatus.ACTIVE, forest);
        hero1.create(coal, REASONS.necessity);
        check_stat(stat.ask());

        hero1.moveTo(home, coal);
        check_stat(stat.yes());
        fire.makeSmoke(false);


        hero1.moveTo(forest);
        check_stat(stat.yes());

        Location bash = new Location("A Bush", 0.2, forest);
        hero1.watch(bash);
        check_stat(stat.yes());

        Location cave = new Location("Cave", 0.2);

        hero1.find(cave);
        check_stat(stat.yes());

        hero1.moveTo(cave, REASONS.interest);
        check_stat(stat.yes());
        Demon demon = new Demon("Satan", 666, 200);
        demon.scare(hero1);
        hero1.scared(demon);
        hero1.moveTo(forest, REASONS.fear);
        hero1.moveTo(cave, REASONS.logic);

        Animal goat = new Animal("Goat", 12, 89);
        hero1.scared(goat);
        goat.die();
        goat.eat(bread);

    }
}
