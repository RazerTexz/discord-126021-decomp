package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.s */
/* JADX INFO: compiled from: ErrorType.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12003s extends AbstractC11934j0 {

    /* JADX INFO: renamed from: k */
    public final InterfaceC12008u0 f24871k;

    /* JADX INFO: renamed from: l */
    public final InterfaceC11770i f24872l;

    /* JADX INFO: renamed from: m */
    public final List<InterfaceC12012w0> f24873m;

    /* JADX INFO: renamed from: n */
    public final boolean f24874n;

    /* JADX INFO: renamed from: o */
    public final String f24875o;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C12003s(InterfaceC12008u0 interfaceC12008u0, InterfaceC11770i interfaceC11770i) {
        this(interfaceC12008u0, interfaceC11770i, null, false, null, 28, null);
        C12238m.checkNotNullParameter(interfaceC12008u0, "constructor");
        C12238m.checkNotNullParameter(interfaceC11770i, "memberScope");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C12003s(InterfaceC12008u0 interfaceC12008u0, InterfaceC11770i interfaceC11770i, List<? extends InterfaceC12012w0> list, boolean z2) {
        this(interfaceC12008u0, interfaceC11770i, list, z2, null, 16, null);
        C12238m.checkNotNullParameter(interfaceC12008u0, "constructor");
        C12238m.checkNotNullParameter(interfaceC11770i, "memberScope");
        C12238m.checkNotNullParameter(list, "arguments");
    }

    public /* synthetic */ C12003s(InterfaceC12008u0 interfaceC12008u0, InterfaceC11770i interfaceC11770i, List list, boolean z2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC12008u0, interfaceC11770i, (i & 4) != 0 ? C12147n.emptyList() : list, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? "???" : str);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11338a
    public InterfaceC11344g getAnnotations() {
        return InterfaceC11344g.f22735f.getEMPTY();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public List<InterfaceC12012w0> getArguments() {
        return this.f24873m;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public InterfaceC12008u0 getConstructor() {
        return this.f24871k;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public InterfaceC11770i getMemberScope() {
        return this.f24872l;
    }

    public String getPresentableName() {
        return this.f24875o;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public boolean isMarkedNullable() {
        return this.f24874n;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public C12003s refine(AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        return this;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public AbstractC11934j0 replaceAnnotations(InterfaceC11344g interfaceC11344g) {
        C12238m.checkNotNullParameter(interfaceC11344g, "newAnnotations");
        return this;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getConstructor());
        sb.append(getArguments().isEmpty() ? "" : C12163u.joinToString(getArguments(), ", ", "<", ">", -1, "...", null));
        return sb.toString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public AbstractC11934j0 makeNullableAsSpecified(boolean z2) {
        return new C12003s(getConstructor(), getMemberScope(), getArguments(), z2, null, 16, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C12003s(InterfaceC12008u0 interfaceC12008u0, InterfaceC11770i interfaceC11770i, List<? extends InterfaceC12012w0> list, boolean z2, String str) {
        C12238m.checkNotNullParameter(interfaceC12008u0, "constructor");
        C12238m.checkNotNullParameter(interfaceC11770i, "memberScope");
        C12238m.checkNotNullParameter(list, "arguments");
        C12238m.checkNotNullParameter(str, "presentableName");
        this.f24871k = interfaceC12008u0;
        this.f24872l = interfaceC11770i;
        this.f24873m = list;
        this.f24874n = z2;
        this.f24875o = str;
    }
}
