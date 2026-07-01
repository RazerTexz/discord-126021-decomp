package d0.e0.p.d.m0.e.a.i0.l;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.d0._Ranges;
import d0.e0.p.d.m0.e.a.k0.javaLoading;
import d0.e0.p.d.m0.e.a.k0.t;
import d0.e0.p.d.m0.e.a.k0.w;
import d0.e0.p.d.m0.g.Name;
import d0.f0._Sequences2;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.a, reason: use source file name */
/* JADX INFO: compiled from: DeclaredMemberIndex.kt */
/* JADX INFO: loaded from: classes3.dex */
public class DeclaredMemberIndex implements DeclaredMemberIndex2 {
    public final d0.e0.p.d.m0.e.a.k0.g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<d0.e0.p.d.m0.e.a.k0.q, Boolean> f3325b;
    public final Function1<d0.e0.p.d.m0.e.a.k0.r, Boolean> c;
    public final Map<Name, List<d0.e0.p.d.m0.e.a.k0.r>> d;
    public final Map<Name, d0.e0.p.d.m0.e.a.k0.n> e;
    public final Map<Name, w> f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.a$a */
    /* JADX INFO: compiled from: DeclaredMemberIndex.kt */
    public static final class a extends Lambda implements Function1<d0.e0.p.d.m0.e.a.k0.r, Boolean> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(d0.e0.p.d.m0.e.a.k0.r rVar) {
            return Boolean.valueOf(invoke2(rVar));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(d0.e0.p.d.m0.e.a.k0.r rVar) {
            Intrinsics3.checkNotNullParameter(rVar, "m");
            return ((Boolean) DeclaredMemberIndex.this.f3325b.invoke(rVar)).booleanValue() && !javaLoading.isObjectMethodInInterface(rVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeclaredMemberIndex(d0.e0.p.d.m0.e.a.k0.g gVar, Function1<? super d0.e0.p.d.m0.e.a.k0.q, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(gVar, "jClass");
        Intrinsics3.checkNotNullParameter(function1, "memberFilter");
        this.a = gVar;
        this.f3325b = function1;
        a aVar = new a();
        this.c = aVar;
        Sequence sequenceFilter = _Sequences2.filter(_Collections.asSequence(gVar.getMethods()), aVar);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : sequenceFilter) {
            Name name = ((d0.e0.p.d.m0.e.a.k0.r) obj).getName();
            Object arrayList = linkedHashMap.get(name);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(name, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        this.d = linkedHashMap;
        Sequence sequenceFilter2 = _Sequences2.filter(_Collections.asSequence(this.a.getFields()), this.f3325b);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj2 : sequenceFilter2) {
            linkedHashMap2.put(((d0.e0.p.d.m0.e.a.k0.n) obj2).getName(), obj2);
        }
        this.e = linkedHashMap2;
        Collection<w> recordComponents = this.a.getRecordComponents();
        Function1<d0.e0.p.d.m0.e.a.k0.q, Boolean> function2 = this.f3325b;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : recordComponents) {
            if (function2.invoke((d0.e0.p.d.m0.e.a.k0.q) obj3).booleanValue()) {
                arrayList2.add(obj3);
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (Object obj4 : arrayList2) {
            linkedHashMap3.put(((w) obj4).getName(), obj4);
        }
        this.f = linkedHashMap3;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.DeclaredMemberIndex2
    public d0.e0.p.d.m0.e.a.k0.n findFieldByName(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.e.get(name);
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.DeclaredMemberIndex2
    public Collection<d0.e0.p.d.m0.e.a.k0.r> findMethodsByName(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        List<d0.e0.p.d.m0.e.a.k0.r> list = this.d.get(name);
        return list == null ? Collections2.emptyList() : list;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.DeclaredMemberIndex2
    public w findRecordComponentByName(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.f.get(name);
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.DeclaredMemberIndex2
    public Set<Name> getFieldNames() {
        Sequence sequenceFilter = _Sequences2.filter(_Collections.asSequence(this.a.getFields()), this.f3325b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = sequenceFilter.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((t) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.DeclaredMemberIndex2
    public Set<Name> getMethodNames() {
        Sequence sequenceFilter = _Sequences2.filter(_Collections.asSequence(this.a.getMethods()), this.c);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = sequenceFilter.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((t) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.DeclaredMemberIndex2
    public Set<Name> getRecordComponentNames() {
        return this.f.keySet();
    }
}
