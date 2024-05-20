package EPS;

import Exceptions.InvaliedGenderException;

public class info {
    private String name;
    private int age;
    private char gender;
    public info(String name,int age,char gender) throws InvaliedGenderException {
        this.name=name;
        this.age=age;
        if (gender!='m'&&gender!='f'&&gender!='F'&&gender!='M')
            throw new InvaliedGenderException();
        this.gender=gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
