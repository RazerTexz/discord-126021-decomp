package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import com.discord.models.domain.ModelAuditLogEntry;
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
import p507d0.p512d0.C11226f;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.C11583p;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11581n;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11584q;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11585r;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11587t;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11590w;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p578f0.C12078q;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.a */
/* JADX INFO: compiled from: DeclaredMemberIndex.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C11534a implements InterfaceC11535b {

    /* JADX INFO: renamed from: a */
    public final InterfaceC11574g f23322a;

    /* JADX INFO: renamed from: b */
    public final Function1<InterfaceC11584q, Boolean> f23323b;

    /* JADX INFO: renamed from: c */
    public final Function1<InterfaceC11585r, Boolean> f23324c;

    /* JADX INFO: renamed from: d */
    public final Map<C11716e, List<InterfaceC11585r>> f23325d;

    /* JADX INFO: renamed from: e */
    public final Map<C11716e, InterfaceC11581n> f23326e;

    /* JADX INFO: renamed from: f */
    public final Map<C11716e, InterfaceC11590w> f23327f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.a$a */
    /* JADX INFO: compiled from: DeclaredMemberIndex.kt */
    public static final class a extends AbstractC12240o implements Function1<InterfaceC11585r, Boolean> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(InterfaceC11585r interfaceC11585r) {
            return Boolean.valueOf(invoke2(interfaceC11585r));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(InterfaceC11585r interfaceC11585r) {
            C12238m.checkNotNullParameter(interfaceC11585r, "m");
            return ((Boolean) C11534a.this.f23323b.invoke(interfaceC11585r)).booleanValue() && !C11583p.isObjectMethodInInterface(interfaceC11585r);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C11534a(InterfaceC11574g interfaceC11574g, Function1<? super InterfaceC11584q, Boolean> function1) {
        C12238m.checkNotNullParameter(interfaceC11574g, "jClass");
        C12238m.checkNotNullParameter(function1, "memberFilter");
        this.f23322a = interfaceC11574g;
        this.f23323b = function1;
        a aVar = new a();
        this.f23324c = aVar;
        Sequence sequenceFilter = C12078q.filter(C12163u.asSequence(interfaceC11574g.getMethods()), aVar);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : sequenceFilter) {
            C11716e name = ((InterfaceC11585r) obj).getName();
            Object arrayList = linkedHashMap.get(name);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(name, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        this.f23325d = linkedHashMap;
        Sequence sequenceFilter2 = C12078q.filter(C12163u.asSequence(this.f23322a.getFields()), this.f23323b);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj2 : sequenceFilter2) {
            linkedHashMap2.put(((InterfaceC11581n) obj2).getName(), obj2);
        }
        this.f23326e = linkedHashMap2;
        Collection<InterfaceC11590w> recordComponents = this.f23322a.getRecordComponents();
        Function1<InterfaceC11584q, Boolean> function2 = this.f23323b;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : recordComponents) {
            if (function2.invoke((InterfaceC11584q) obj3).booleanValue()) {
                arrayList2.add(obj3);
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (Object obj4 : arrayList2) {
            linkedHashMap3.put(((InterfaceC11590w) obj4).getName(), obj4);
        }
        this.f23327f = linkedHashMap3;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.InterfaceC11535b
    public InterfaceC11581n findFieldByName(C11716e c11716e) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.f23326e.get(c11716e);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.InterfaceC11535b
    public Collection<InterfaceC11585r> findMethodsByName(C11716e c11716e) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        List<InterfaceC11585r> list = this.f23325d.get(c11716e);
        return list == null ? C12147n.emptyList() : list;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.InterfaceC11535b
    public InterfaceC11590w findRecordComponentByName(C11716e c11716e) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.f23327f.get(c11716e);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.InterfaceC11535b
    public Set<C11716e> getFieldNames() {
        Sequence sequenceFilter = C12078q.filter(C12163u.asSequence(this.f23322a.getFields()), this.f23323b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = sequenceFilter.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((InterfaceC11587t) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.InterfaceC11535b
    public Set<C11716e> getMethodNames() {
        Sequence sequenceFilter = C12078q.filter(C12163u.asSequence(this.f23322a.getMethods()), this.f23324c);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = sequenceFilter.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((InterfaceC11587t) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.InterfaceC11535b
    public Set<C11716e> getRecordComponentNames() {
        return this.f23327f.keySet();
    }
}
