package p507d0.p513e0.p514p.p515d.p517m0.p552k.p555u.p556a;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12005t;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11974c;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.u.a.a */
/* JADX INFO: compiled from: CapturedTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11803a extends AbstractC11934j0 implements InterfaceC11974c {

    /* JADX INFO: renamed from: k */
    public final InterfaceC12012w0 f24428k;

    /* JADX INFO: renamed from: l */
    public final InterfaceC11804b f24429l;

    /* JADX INFO: renamed from: m */
    public final boolean f24430m;

    /* JADX INFO: renamed from: n */
    public final InterfaceC11344g f24431n;

    public /* synthetic */ C11803a(InterfaceC12012w0 interfaceC12012w0, InterfaceC11804b interfaceC11804b, boolean z2, InterfaceC11344g interfaceC11344g, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC12012w0, (i & 2) != 0 ? new C11805c(interfaceC12012w0) : interfaceC11804b, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? InterfaceC11344g.f22735f.getEMPTY() : interfaceC11344g);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11338a
    public InterfaceC11344g getAnnotations() {
        return this.f24431n;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public List<InterfaceC12012w0> getArguments() {
        return C12147n.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public InterfaceC11770i getMemberScope() {
        InterfaceC11770i interfaceC11770iCreateErrorScope = C12005t.createErrorScope("No member resolution should be done on captured type, it used only during constraint system resolution", true);
        C12238m.checkNotNullExpressionValue(interfaceC11770iCreateErrorScope, "createErrorScope(\n            \"No member resolution should be done on captured type, it used only during constraint system resolution\", true\n        )");
        return interfaceC11770iCreateErrorScope;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public boolean isMarkedNullable() {
        return this.f24430m;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0
    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Captured(");
        sbM833U.append(this.f24428k);
        sbM833U.append(')');
        sbM833U.append(isMarkedNullable() ? "?" : "");
        return sbM833U.toString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public InterfaceC11804b getConstructor() {
        return this.f24429l;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public C11803a makeNullableAsSpecified(boolean z2) {
        return z2 == isMarkedNullable() ? this : new C11803a(this.f24428k, getConstructor(), z2, getAnnotations());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public C11803a refine(AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        InterfaceC12012w0 interfaceC12012w0Refine = this.f24428k.refine(abstractC11947g);
        C12238m.checkNotNullExpressionValue(interfaceC12012w0Refine, "typeProjection.refine(kotlinTypeRefiner)");
        return new C11803a(interfaceC12012w0Refine, getConstructor(), isMarkedNullable(), getAnnotations());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public C11803a replaceAnnotations(InterfaceC11344g interfaceC11344g) {
        C12238m.checkNotNullParameter(interfaceC11344g, "newAnnotations");
        return new C11803a(this.f24428k, getConstructor(), isMarkedNullable(), interfaceC11344g);
    }

    public C11803a(InterfaceC12012w0 interfaceC12012w0, InterfaceC11804b interfaceC11804b, boolean z2, InterfaceC11344g interfaceC11344g) {
        C12238m.checkNotNullParameter(interfaceC12012w0, "typeProjection");
        C12238m.checkNotNullParameter(interfaceC11804b, "constructor");
        C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
        this.f24428k = interfaceC12012w0;
        this.f24429l = interfaceC11804b;
        this.f24430m = z2;
        this.f24431n = interfaceC11344g;
    }
}
