package org.michaelliu.demo.java.designpattern.creator.factory.abstractfactory;

/**
 * Created by Michael on 7/2/16.
 */
public class DogFactory implements AbstractAnimalFactory {

    @Override
    public Animal createAnimal() {
        return new Dog();
    }

}
