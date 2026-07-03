package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11480b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11798p;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.p575n.C12032a;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12041i;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.o */
/* JADX INFO: compiled from: TypeIntersectionScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11776o extends AbstractC11762a {

    /* JADX INFO: renamed from: b */
    public static final a f24381b = new a(null);

    /* JADX INFO: renamed from: c */
    public final InterfaceC11770i f24382c;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.o$a */
    /* JADX INFO: compiled from: TypeIntersectionScope.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final InterfaceC11770i create(String str, Collection<? extends AbstractC11913c0> collection) {
            C12238m.checkNotNullParameter(str, "message");
            C12238m.checkNotNullParameter(collection, "types");
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(collection, 10));
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(((AbstractC11913c0) it.next()).getMemberScope());
            }
            C12041i<InterfaceC11770i> c12041iListOfNonEmptyScopes = C12032a.listOfNonEmptyScopes(arrayList);
            InterfaceC11770i interfaceC11770iCreateOrSingle$descriptors = C11763b.f24333b.createOrSingle$descriptors(str, c12041iListOfNonEmptyScopes);
            return c12041iListOfNonEmptyScopes.size() <= 1 ? interfaceC11770iCreateOrSingle$descriptors : new C11776o(str, interfaceC11770iCreateOrSingle$descriptors, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.o$b */
    /* JADX INFO: compiled from: TypeIntersectionScope.kt */
    public static final class b extends AbstractC12240o implements Function1<InterfaceC11318a, InterfaceC11318a> {

        /* JADX INFO: renamed from: j */
        public static final b f24383j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final InterfaceC11318a invoke(InterfaceC11318a interfaceC11318a) {
            C12238m.checkNotNullParameter(interfaceC11318a, "<this>");
            return interfaceC11318a;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.o$c */
    /* JADX INFO: compiled from: TypeIntersectionScope.kt */
    public static final class c extends AbstractC12240o implements Function1<InterfaceC11465t0, InterfaceC11318a> {

        /* JADX INFO: renamed from: j */
        public static final c f24384j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final InterfaceC11318a invoke(InterfaceC11465t0 interfaceC11465t0) {
            C12238m.checkNotNullParameter(interfaceC11465t0, "<this>");
            return interfaceC11465t0;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.o$d */
    /* JADX INFO: compiled from: TypeIntersectionScope.kt */
    public static final class d extends AbstractC12240o implements Function1<InterfaceC11453n0, InterfaceC11318a> {

        /* JADX INFO: renamed from: j */
        public static final d f24385j = new d();

        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final InterfaceC11318a invoke(InterfaceC11453n0 interfaceC11453n0) {
            C12238m.checkNotNullParameter(interfaceC11453n0, "<this>");
            return interfaceC11453n0;
        }
    }

    public C11776o(String str, InterfaceC11770i interfaceC11770i, DefaultConstructorMarker defaultConstructorMarker) {
        this.f24382c = interfaceC11770i;
    }

    public static final InterfaceC11770i create(String str, Collection<? extends AbstractC11913c0> collection) {
        return f24381b.create(str, collection);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11762a
    /* JADX INFO: renamed from: a */
    public InterfaceC11770i mo9910a() {
        return this.f24382c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11762a, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public Collection<InterfaceC11450m> getContributedDescriptors(C11765d c11765d, Function1<? super C11716e, Boolean> function1) {
        C12238m.checkNotNullParameter(c11765d, "kindFilter");
        C12238m.checkNotNullParameter(function1, "nameFilter");
        Collection<InterfaceC11450m> contributedDescriptors = super.getContributedDescriptors(c11765d, function1);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : contributedDescriptors) {
            if (((InterfaceC11450m) obj) instanceof InterfaceC11318a) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List list = (List) pair.component1();
        return C12163u.plus(C11798p.selectMostSpecificInEachOverridableGroup(list, b.f24383j), (Iterable) pair.component2());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11762a, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Collection<InterfaceC11465t0> getContributedFunctions(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return C11798p.selectMostSpecificInEachOverridableGroup(super.getContributedFunctions(c11716e, interfaceC11480b), c.f24384j);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11762a, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Collection<InterfaceC11453n0> getContributedVariables(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return C11798p.selectMostSpecificInEachOverridableGroup(super.getContributedVariables(c11716e, interfaceC11480b), d.f24385j);
    }
}
