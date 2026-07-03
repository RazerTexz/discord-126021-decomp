package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11475y0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.r0 */
/* JADX INFO: compiled from: TypeAliasExpansion.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12002r0 {

    /* JADX INFO: renamed from: a */
    public static final a f24866a = new a(null);

    /* JADX INFO: renamed from: b */
    public final C12002r0 f24867b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC11475y0 f24868c;

    /* JADX INFO: renamed from: d */
    public final List<InterfaceC12012w0> f24869d;

    /* JADX INFO: renamed from: e */
    public final Map<InterfaceC11477z0, InterfaceC12012w0> f24870e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.r0$a */
    /* JADX INFO: compiled from: TypeAliasExpansion.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final C12002r0 create(C12002r0 c12002r0, InterfaceC11475y0 interfaceC11475y0, List<? extends InterfaceC12012w0> list) {
            C12238m.checkNotNullParameter(interfaceC11475y0, "typeAliasDescriptor");
            C12238m.checkNotNullParameter(list, "arguments");
            List<InterfaceC11477z0> parameters = interfaceC11475y0.getTypeConstructor().getParameters();
            C12238m.checkNotNullExpressionValue(parameters, "typeAliasDescriptor.typeConstructor.parameters");
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(parameters, 10));
            Iterator<T> it = parameters.iterator();
            while (it.hasNext()) {
                arrayList.add(((InterfaceC11477z0) it.next()).getOriginal());
            }
            return new C12002r0(c12002r0, interfaceC11475y0, list, C12136h0.toMap(C12163u.zip(arrayList, list)), null);
        }
    }

    public C12002r0(C12002r0 c12002r0, InterfaceC11475y0 interfaceC11475y0, List list, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this.f24867b = c12002r0;
        this.f24868c = interfaceC11475y0;
        this.f24869d = list;
        this.f24870e = map;
    }

    public final List<InterfaceC12012w0> getArguments() {
        return this.f24869d;
    }

    public final InterfaceC11475y0 getDescriptor() {
        return this.f24868c;
    }

    public final InterfaceC12012w0 getReplacement(InterfaceC12008u0 interfaceC12008u0) {
        C12238m.checkNotNullParameter(interfaceC12008u0, "constructor");
        InterfaceC11352h declarationDescriptor = interfaceC12008u0.getDeclarationDescriptor();
        if (declarationDescriptor instanceof InterfaceC11477z0) {
            return this.f24870e.get(declarationDescriptor);
        }
        return null;
    }

    public final boolean isRecursion(InterfaceC11475y0 interfaceC11475y0) {
        C12238m.checkNotNullParameter(interfaceC11475y0, "descriptor");
        if (!C12238m.areEqual(this.f24868c, interfaceC11475y0)) {
            C12002r0 c12002r0 = this.f24867b;
            if (!(c12002r0 == null ? false : c12002r0.isRecursion(interfaceC11475y0))) {
                return false;
            }
        }
        return true;
    }
}
