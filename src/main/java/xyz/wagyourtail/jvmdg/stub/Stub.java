package xyz.wagyourtail.jvmdg.stub;


import xyz.wagyourtail.jvmdg.Ref;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Stub {

    int opcVers();

    Ref ref() default @Ref("");

    Class<?>[] include() default {};

    boolean subtypes() default false;

    boolean subtypesOnly() default false;

    boolean returnDecendant() default false;

}