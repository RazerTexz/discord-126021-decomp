package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p580t.C12160r;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.k */
/* JADX INFO: compiled from: MemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11772k {
    public static final Set<C11716e> flatMapClassifierNamesOrNull(Iterable<? extends InterfaceC11770i> iterable) {
        C12238m.checkNotNullParameter(iterable, "<this>");
        HashSet hashSet = new HashSet();
        Iterator<? extends InterfaceC11770i> it = iterable.iterator();
        while (it.hasNext()) {
            Set<C11716e> classifierNames = it.next().getClassifierNames();
            if (classifierNames == null) {
                return null;
            }
            C12160r.addAll(hashSet, classifierNames);
        }
        return hashSet;
    }
}
