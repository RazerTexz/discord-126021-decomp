package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11787e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12005t;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0;
import p507d0.p578f0.C12078q;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.a1 */
/* JADX INFO: compiled from: typeParameterUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11320a1 {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.a1$a */
    /* JADX INFO: compiled from: typeParameterUtils.kt */
    public static final class a extends AbstractC12240o implements Function1<InterfaceC11450m, Boolean> {

        /* JADX INFO: renamed from: j */
        public static final a f22673j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(InterfaceC11450m interfaceC11450m) {
            return Boolean.valueOf(invoke2(interfaceC11450m));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(InterfaceC11450m interfaceC11450m) {
            C12238m.checkNotNullParameter(interfaceC11450m, "it");
            return interfaceC11450m instanceof InterfaceC11318a;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.a1$b */
    /* JADX INFO: compiled from: typeParameterUtils.kt */
    public static final class b extends AbstractC12240o implements Function1<InterfaceC11450m, Boolean> {

        /* JADX INFO: renamed from: j */
        public static final b f22674j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(InterfaceC11450m interfaceC11450m) {
            return Boolean.valueOf(invoke2(interfaceC11450m));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(InterfaceC11450m interfaceC11450m) {
            C12238m.checkNotNullParameter(interfaceC11450m, "it");
            return !(interfaceC11450m instanceof InterfaceC11448l);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.a1$c */
    /* JADX INFO: compiled from: typeParameterUtils.kt */
    public static final class c extends AbstractC12240o implements Function1<InterfaceC11450m, Sequence<? extends InterfaceC11477z0>> {

        /* JADX INFO: renamed from: j */
        public static final c f22675j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Sequence<InterfaceC11477z0> invoke(InterfaceC11450m interfaceC11450m) {
            C12238m.checkNotNullParameter(interfaceC11450m, "it");
            List<InterfaceC11477z0> typeParameters = ((InterfaceC11318a) interfaceC11450m).getTypeParameters();
            C12238m.checkNotNullExpressionValue(typeParameters, "it as CallableDescriptor).typeParameters");
            return C12163u.asSequence(typeParameters);
        }
    }

    /* JADX INFO: renamed from: a */
    public static final C11449l0 m9383a(AbstractC11913c0 abstractC11913c0, InterfaceC11359i interfaceC11359i, int i) {
        if (interfaceC11359i == null || C12005t.isError(interfaceC11359i)) {
            return null;
        }
        int size = interfaceC11359i.getDeclaredTypeParameters().size() + i;
        if (interfaceC11359i.isInner()) {
            List<InterfaceC12012w0> listSubList = abstractC11913c0.getArguments().subList(i, size);
            InterfaceC11450m containingDeclaration = interfaceC11359i.getContainingDeclaration();
            return new C11449l0(interfaceC11359i, listSubList, m9383a(abstractC11913c0, containingDeclaration instanceof InterfaceC11359i ? (InterfaceC11359i) containingDeclaration : null, size));
        }
        if (size != abstractC11913c0.getArguments().size()) {
            C11787e.isLocal(interfaceC11359i);
        }
        return new C11449l0(interfaceC11359i, abstractC11913c0.getArguments().subList(i, abstractC11913c0.getArguments().size()), null);
    }

    public static final C11449l0 buildPossiblyInnerType(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        InterfaceC11352h declarationDescriptor = abstractC11913c0.getConstructor().getDeclarationDescriptor();
        return m9383a(abstractC11913c0, declarationDescriptor instanceof InterfaceC11359i ? (InterfaceC11359i) declarationDescriptor : null, 0);
    }

    public static final List<InterfaceC11477z0> computeConstructorTypeParameters(InterfaceC11359i interfaceC11359i) {
        List<InterfaceC11477z0> listEmptyList;
        InterfaceC11450m next;
        InterfaceC12008u0 typeConstructor;
        C12238m.checkNotNullParameter(interfaceC11359i, "<this>");
        List<InterfaceC11477z0> declaredTypeParameters = interfaceC11359i.getDeclaredTypeParameters();
        C12238m.checkNotNullExpressionValue(declaredTypeParameters, "declaredTypeParameters");
        if (!interfaceC11359i.isInner() && !(interfaceC11359i.getContainingDeclaration() instanceof InterfaceC11318a)) {
            return declaredTypeParameters;
        }
        List list = C12078q.toList(C12078q.flatMap(C12078q.filter(C12078q.takeWhile(C11836a.getParents(interfaceC11359i), a.f22673j), b.f22674j), c.f22675j));
        Iterator<InterfaceC11450m> it = C11836a.getParents(interfaceC11359i).iterator();
        do {
            listEmptyList = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(next instanceof InterfaceC11330e));
        InterfaceC11330e interfaceC11330e = (InterfaceC11330e) next;
        if (interfaceC11330e != null && (typeConstructor = interfaceC11330e.getTypeConstructor()) != null) {
            listEmptyList = typeConstructor.getParameters();
        }
        if (listEmptyList == null) {
            listEmptyList = C12147n.emptyList();
        }
        if (list.isEmpty() && listEmptyList.isEmpty()) {
            List<InterfaceC11477z0> declaredTypeParameters2 = interfaceC11359i.getDeclaredTypeParameters();
            C12238m.checkNotNullExpressionValue(declaredTypeParameters2, "declaredTypeParameters");
            return declaredTypeParameters2;
        }
        List<InterfaceC11477z0> listPlus = C12163u.plus((Collection) list, (Iterable) listEmptyList);
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listPlus, 10));
        for (InterfaceC11477z0 interfaceC11477z0 : listPlus) {
            C12238m.checkNotNullExpressionValue(interfaceC11477z0, "it");
            arrayList.add(new C11324c(interfaceC11477z0, interfaceC11359i, declaredTypeParameters.size()));
        }
        return C12163u.plus((Collection) declaredTypeParameters, (Iterable) arrayList);
    }
}
