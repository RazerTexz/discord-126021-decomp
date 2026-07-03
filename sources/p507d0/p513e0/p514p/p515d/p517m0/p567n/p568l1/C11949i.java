package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12005t;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.EnumC11973b;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11974c;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.i */
/* JADX INFO: compiled from: NewCapturedType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11949i extends AbstractC11934j0 implements InterfaceC11974c {

    /* JADX INFO: renamed from: k */
    public final EnumC11973b f24809k;

    /* JADX INFO: renamed from: l */
    public final C11950j f24810l;

    /* JADX INFO: renamed from: m */
    public final AbstractC11932i1 f24811m;

    /* JADX INFO: renamed from: n */
    public final InterfaceC11344g f24812n;

    /* JADX INFO: renamed from: o */
    public final boolean f24813o;

    /* JADX INFO: renamed from: p */
    public final boolean f24814p;

    public /* synthetic */ C11949i(EnumC11973b enumC11973b, C11950j c11950j, AbstractC11932i1 abstractC11932i1, InterfaceC11344g interfaceC11344g, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(enumC11973b, c11950j, abstractC11932i1, (i & 8) != 0 ? InterfaceC11344g.f22735f.getEMPTY() : interfaceC11344g, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? false : z3);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11338a
    public InterfaceC11344g getAnnotations() {
        return this.f24812n;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public List<InterfaceC12012w0> getArguments() {
        return C12147n.emptyList();
    }

    public final EnumC11973b getCaptureStatus() {
        return this.f24809k;
    }

    public final AbstractC11932i1 getLowerType() {
        return this.f24811m;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public InterfaceC11770i getMemberScope() {
        InterfaceC11770i interfaceC11770iCreateErrorScope = C12005t.createErrorScope("No member resolution should be done on captured type!", true);
        C12238m.checkNotNullExpressionValue(interfaceC11770iCreateErrorScope, "createErrorScope(\"No member resolution should be done on captured type!\", true)");
        return interfaceC11770iCreateErrorScope;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public boolean isMarkedNullable() {
        return this.f24813o;
    }

    public final boolean isProjectionNotNull() {
        return this.f24814p;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public C11950j getConstructor() {
        return this.f24810l;
    }

    public C11949i(EnumC11973b enumC11973b, C11950j c11950j, AbstractC11932i1 abstractC11932i1, InterfaceC11344g interfaceC11344g, boolean z2, boolean z3) {
        C12238m.checkNotNullParameter(enumC11973b, "captureStatus");
        C12238m.checkNotNullParameter(c11950j, "constructor");
        C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
        this.f24809k = enumC11973b;
        this.f24810l = c11950j;
        this.f24811m = abstractC11932i1;
        this.f24812n = interfaceC11344g;
        this.f24813o = z2;
        this.f24814p = z3;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public C11949i makeNullableAsSpecified(boolean z2) {
        return new C11949i(this.f24809k, getConstructor(), this.f24811m, getAnnotations(), z2, false, 32, null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public C11949i refine(AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        EnumC11973b enumC11973b = this.f24809k;
        C11950j c11950jRefine = getConstructor().refine(abstractC11947g);
        AbstractC11932i1 abstractC11932i1 = this.f24811m;
        return new C11949i(enumC11973b, c11950jRefine, abstractC11932i1 == null ? null : abstractC11947g.refineType(abstractC11932i1).unwrap(), getAnnotations(), isMarkedNullable(), false, 32, null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public C11949i replaceAnnotations(InterfaceC11344g interfaceC11344g) {
        C12238m.checkNotNullParameter(interfaceC11344g, "newAnnotations");
        return new C11949i(this.f24809k, getConstructor(), this.f24811m, interfaceC11344g, isMarkedNullable(), false, 32, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C11949i(EnumC11973b enumC11973b, AbstractC11932i1 abstractC11932i1, InterfaceC12012w0 interfaceC12012w0, InterfaceC11477z0 interfaceC11477z0) {
        this(enumC11973b, new C11950j(interfaceC12012w0, null, null, interfaceC11477z0, 6, null), abstractC11932i1, null, false, false, 56, null);
        C12238m.checkNotNullParameter(enumC11973b, "captureStatus");
        C12238m.checkNotNullParameter(interfaceC12012w0, "projection");
        C12238m.checkNotNullParameter(interfaceC11477z0, "typeParameter");
    }
}
