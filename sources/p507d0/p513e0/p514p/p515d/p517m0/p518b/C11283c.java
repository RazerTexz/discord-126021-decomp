package p507d0.p513e0.p514p.p515d.p517m0.p518b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.c */
/* JADX INFO: compiled from: CompanionObjectMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11283c {

    /* JADX INFO: renamed from: a */
    public static final C11283c f22455a = new C11283c();

    /* JADX INFO: renamed from: b */
    public static final Set<C11712a> f22456b;

    static {
        Set<EnumC11289i> set = EnumC11289i.f22472j;
        C11291k c11291k = C11291k.f22488a;
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(C11291k.getPrimitiveFqName((EnumC11289i) it.next()));
        }
        C11713b safe = C11291k.a.f22542g.toSafe();
        C12238m.checkNotNullExpressionValue(safe, "string.toSafe()");
        List listPlus = C12163u.plus((Collection<? extends C11713b>) arrayList, safe);
        C11713b safe2 = C11291k.a.f22546i.toSafe();
        C12238m.checkNotNullExpressionValue(safe2, "_boolean.toSafe()");
        List listPlus2 = C12163u.plus((Collection<? extends C11713b>) listPlus, safe2);
        C11713b safe3 = C11291k.a.f22563r.toSafe();
        C12238m.checkNotNullExpressionValue(safe3, "_enum.toSafe()");
        List listPlus3 = C12163u.plus((Collection<? extends C11713b>) listPlus2, safe3);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it2 = listPlus3.iterator();
        while (it2.hasNext()) {
            linkedHashSet.add(C11712a.topLevel((C11713b) it2.next()));
        }
        f22456b = linkedHashSet;
    }

    public final Set<C11712a> allClassesWithIntrinsicCompanions() {
        return f22456b;
    }

    public final Set<C11712a> getClassIds() {
        return f22456b;
    }
}
