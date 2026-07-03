package p507d0.p512d0;

import java.lang.Comparable;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.d0.a */
/* JADX INFO: compiled from: Range.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11221a<T extends Comparable<? super T>> {

    /* JADX INFO: renamed from: d0.d0.a$a */
    /* JADX INFO: compiled from: Range.kt */
    public static final class a {
        public static <T extends Comparable<? super T>> boolean contains(InterfaceC11221a<T> interfaceC11221a, T t) {
            C12238m.checkNotNullParameter(t, "value");
            return t.compareTo(interfaceC11221a.getStart()) >= 0 && t.compareTo(interfaceC11221a.getEndInclusive()) <= 0;
        }

        public static <T extends Comparable<? super T>> boolean isEmpty(InterfaceC11221a<T> interfaceC11221a) {
            return interfaceC11221a.getStart().compareTo(interfaceC11221a.getEndInclusive()) > 0;
        }
    }

    boolean contains(T t);

    T getEndInclusive();

    T getStart();
}
