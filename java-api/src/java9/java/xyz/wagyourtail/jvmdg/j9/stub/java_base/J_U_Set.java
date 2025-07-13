package xyz.wagyourtail.jvmdg.j9.stub.java_base;


import xyz.wagyourtail.jvmdg.version.Ref;
import xyz.wagyourtail.jvmdg.version.Stub;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class J_U_Set {

    @Stub(ref = @Ref("Ljava/util/Set;"))
    public static <E> Set<E> of() {
        return Collections.emptySet();
    }

    @Stub(ref = @Ref("Ljava/util/Set;"))
    public static <E> Set<E> of(E e1) {
        return Collections.singleton(e1);
    }

    @Stub(ref = @Ref("Ljava/util/Set;"))
    public static <E> Set<E> of(E e1, E e2) {
        return Collections.unmodifiableSet(new HashSet<>(Arrays.asList(e1, e2)));
    }

    @Stub(ref = @Ref("Ljava/util/Set;"))
    public static <E> Set<E> of(E e1, E e2, E e3) {
        return Collections.unmodifiableSet(new HashSet<>(Arrays.asList(e1, e2, e3)));
    }

    @Stub(ref = @Ref("Ljava/util/Set;"))
    public static <E> Set<E> of(E e1, E e2, E e3, E e4) {
        return Collections.unmodifiableSet(new HashSet<>(Arrays.asList(e1, e2, e3, e4)));
    }

    @Stub(ref = @Ref("Ljava/util/Set;"))
    public static <E> Set<E> of(E e1, E e2, E e3, E e4, E e5) {
        return Collections.unmodifiableSet(new HashSet<>(Arrays.asList(e1, e2, e3, e4, e5)));
    }

    @Stub(ref = @Ref("Ljava/util/Set;"))
    public static <E> Set<E> of(E e1, E e2, E e3, E e4, E e5, E e6) {
        return Collections.unmodifiableSet(new HashSet<>(Arrays.asList(e1, e2, e3, e4, e5, e6)));
    }

    @Stub(ref = @Ref("Ljava/util/Set;"))
    public static <E> Set<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7) {
        return Collections.unmodifiableSet(new HashSet<>(Arrays.asList(e1, e2, e3, e4, e5, e6, e7)));
    }

    @Stub(ref = @Ref("Ljava/util/Set;"))
    public static <E> Set<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        return Collections.unmodifiableSet(new HashSet<>(Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8)));
    }

    @Stub(ref = @Ref("Ljava/util/Set;"))
    public static <E> Set<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
        return Collections.unmodifiableSet(new HashSet<>(Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9)));
    }

    @Stub(ref = @Ref("Ljava/util/Set;"))
    public static <E> Set<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
        return Collections.unmodifiableSet(new HashSet<>(Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10)));
    }

    @SafeVarargs
    @Stub(ref = @Ref("Ljava/util/Set;"))
    public static <E> Set<E> of(E... elements) {
        if (elements.length == 0) {
            return of();
        }
        return Collections.unmodifiableSet(new HashSet<>(Arrays.asList(elements)));
    }


}
