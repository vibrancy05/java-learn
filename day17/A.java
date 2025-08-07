package day17;

public @interface A {
    String value();
    String []name();
    int age() default 18;
}
