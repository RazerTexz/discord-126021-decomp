package p507d0.p513e0.p514p.p515d.p517m0.p552k.p555u.p556a;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.C11896f;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11922f0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11939l;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12016y0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12017z;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.u.a.d */
/* JADX INFO: compiled from: CapturedTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11806d {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.u.a.d$a */
    /* JADX INFO: compiled from: CapturedTypeConstructor.kt */
    public static final class a extends AbstractC12240o implements Function0<AbstractC11913c0> {
        public final /* synthetic */ InterfaceC12012w0 $this_createCapturedIfNeeded;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC12012w0 interfaceC12012w0) {
            super(0);
            this.$this_createCapturedIfNeeded = interfaceC12012w0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AbstractC11913c0 invoke() {
            AbstractC11913c0 type = this.$this_createCapturedIfNeeded.getType();
            C12238m.checkNotNullExpressionValue(type, "this@createCapturedIfNeeded.type");
            return type;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.u.a.d$b */
    /* JADX INFO: compiled from: CapturedTypeConstructor.kt */
    public static final class b extends C11939l {

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ boolean f24434c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z2, AbstractC12018z0 abstractC12018z0) {
            super(abstractC12018z0);
            this.f24434c = z2;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0
        public boolean approximateContravariantCapturedTypes() {
            return this.f24434c;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.C11939l, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0
        public InterfaceC12012w0 get(AbstractC11913c0 abstractC11913c0) {
            C12238m.checkNotNullParameter(abstractC11913c0, "key");
            InterfaceC12012w0 interfaceC12012w0 = super.get(abstractC11913c0);
            if (interfaceC12012w0 == null) {
                return null;
            }
            InterfaceC11352h declarationDescriptor = abstractC11913c0.getConstructor().getDeclarationDescriptor();
            return C11806d.m9941a(interfaceC12012w0, declarationDescriptor instanceof InterfaceC11477z0 ? (InterfaceC11477z0) declarationDescriptor : null);
        }
    }

    /* JADX INFO: renamed from: a */
    public static final InterfaceC12012w0 m9941a(InterfaceC12012w0 interfaceC12012w0, InterfaceC11477z0 interfaceC11477z0) {
        if (interfaceC11477z0 == null || interfaceC12012w0.getProjectionKind() == EnumC11935j1.INVARIANT) {
            return interfaceC12012w0;
        }
        if (interfaceC11477z0.getVariance() != interfaceC12012w0.getProjectionKind()) {
            return new C12016y0(createCapturedType(interfaceC12012w0));
        }
        if (!interfaceC12012w0.isStarProjection()) {
            return new C12016y0(interfaceC12012w0.getType());
        }
        InterfaceC11905o interfaceC11905o = C11896f.f24710b;
        C12238m.checkNotNullExpressionValue(interfaceC11905o, "NO_LOCKS");
        return new C12016y0(new C11922f0(interfaceC11905o, new a(interfaceC12012w0)));
    }

    public static final AbstractC11913c0 createCapturedType(InterfaceC12012w0 interfaceC12012w0) {
        C12238m.checkNotNullParameter(interfaceC12012w0, "typeProjection");
        return new C11803a(interfaceC12012w0, null, false, null, 14, null);
    }

    public static final boolean isCaptured(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        return abstractC11913c0.getConstructor() instanceof InterfaceC11804b;
    }

    public static final AbstractC12018z0 wrapWithCapturingSubstitution(AbstractC12018z0 abstractC12018z0, boolean z2) {
        C12238m.checkNotNullParameter(abstractC12018z0, "<this>");
        if (!(abstractC12018z0 instanceof C12017z)) {
            return new b(z2, abstractC12018z0);
        }
        C12017z c12017z = (C12017z) abstractC12018z0;
        InterfaceC11477z0[] parameters = c12017z.getParameters();
        List<Pair> listZip = C12141k.zip(c12017z.getArguments(), c12017z.getParameters());
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listZip, 10));
        for (Pair pair : listZip) {
            arrayList.add(m9941a((InterfaceC12012w0) pair.getFirst(), (InterfaceC11477z0) pair.getSecond()));
        }
        Object[] array = arrayList.toArray(new InterfaceC12012w0[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return new C12017z(parameters, (InterfaceC12012w0[]) array, z2);
    }

    public static /* synthetic */ AbstractC12018z0 wrapWithCapturingSubstitution$default(AbstractC12018z0 abstractC12018z0, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return wrapWithCapturingSubstitution(abstractC12018z0, z2);
    }
}
