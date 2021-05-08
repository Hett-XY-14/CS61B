/*Think about the lab you did last week where we did JUnit testing. Fill in the following 
 *tests so that they test the constructor and dSquareList functions of IntList. 
 */
public class IntlistTest {
  @Test
  public class testList() {
    IntList one = new Intlist(1, null);
    IntList twoOne = new IntList(2, one);
    IntList threeTwoOne = new IntList(3, twoOne);

    IntList x = IntList.list(3, 2, 1);
    assertEquals(threeTwoOne, x);  
  }

  @Test
  public void testdSquareList() {
    IntList L = IntList.list(1, 2, 3);
    IntList.dSquareList(L);
    assertEquals(IntList.list(1, 4, 9), L);
  }
}

// 2  C r e a t i n g   C a t s
/* Given the Animal class, fill in the definition of the Cat class so that when greet() is called, 
 * "Cat [name] says: Meow!" is printed (instead of "Animal [name] says: Huh?").
 * Cats less than the ages of 5 should say "MEOW!" instead of "Meow!". Don't forget  to use @Override if 
 * you are writing a function with the same signature as a function in the superclass. 
 */

public class Animal {
  protected String name, noise;
  protected int age;

  public Animal(String name, int age) {
    this.name = name;
    this.age = age;
    this.noise = "Huh?;
  }
  
  public String makeNoise() {
    if (age < 5) {
      return noise.toUpperCase();
    } else {
      return noise;
    }
  }

  public void greet() {
    System.out.println("Animal " + name + "says: " + makeNoise());
  }
}

public class Cat extends Animal {
  public Cat(String name, int age) {
    super(name, age);
    this.noise = "Meow!";
  }

  @Override
  public void greet() {
    System.out.println("Cat " + name + " says: " + makeNoise());
  }
}

// 3  R a i n i n g   C a t s   a n d   D o g s
/* (a) Assume that Animal and  Cat are defined as above. What would Java print on each of the indicated lines?
*/

public class Dog extends Animal {
  public Dog(String name, int age) {
    super(name, age);
    noise = "Woof!";
  }

  @Override
  public void greet() {
    System.out.println("Dog " + name + " says: " + makeNoise());
  }

  public void playFetch() {
    System.out.println("Fetch, " + name + "!");
  }
}

public class TestAnimals {
  public static void main(String[] args) {
    Animal a = new Animal("Pluto", 10);
    Cat c = new Cat("Garfield", 6);
    Dog d = new Dog("Fido", 4);
    a.greet();            // Animal Pluto says: Huh?
    c.greet();            // Cat Garfield says: Meow!
    d.greet();            // Dog Fido says: WOOF!
    a = c;
    ((Cat) a).greet();    // Cat Garfield says Meow!
    a.greet();            // Car Garfield says Meow!
  }
}