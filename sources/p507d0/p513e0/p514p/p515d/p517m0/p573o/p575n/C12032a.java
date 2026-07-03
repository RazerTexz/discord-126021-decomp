package p507d0.p513e0.p514p.p515d.p517m0.p573o.p575n;

import java.util.Collection;
import java.util.LinkedHashSet;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12041i;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.o.n.a */
/* JADX INFO: compiled from: scopeUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12032a {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Collection<T> concat(Collection<? extends T> collection, Collection<? extends T> collection2) {
        C12238m.checkNotNullParameter(collection2, "collection");
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == 0) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    public static final C12041i<InterfaceC11770i> listOfNonEmptyScopes(Iterable<? extends InterfaceC11770i> iterable) {
        C12238m.checkNotNullParameter(iterable, "scopes");
        C12041i<InterfaceC11770i> c12041i = new C12041i<>();
        for (InterfaceC11770i interfaceC11770i : iterable) {
            InterfaceC11770i interfaceC11770i2 = interfaceC11770i;
            if ((interfaceC11770i2 == null || interfaceC11770i2 == InterfaceC11770i.b.f24373b) ? false : true) {
                c12041i.add(interfaceC11770i);
            }
        }
        return c12041i;
    }
}
