package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11448l;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11373g;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11679d;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11708g;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11709h;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11710i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.c */
/* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11858c extends C11373g implements InterfaceC11857b {

    /* JADX INFO: renamed from: O */
    public final C11679d f24523O;

    /* JADX INFO: renamed from: P */
    public final InterfaceC11704c f24524P;

    /* JADX INFO: renamed from: Q */
    public final C11708g f24525Q;

    /* JADX INFO: renamed from: R */
    public final C11710i f24526R;

    /* JADX INFO: renamed from: S */
    public final InterfaceC11861f f24527S;

    /* JADX INFO: renamed from: T */
    public InterfaceC11862g.a f24528T;

    public /* synthetic */ C11858c(InterfaceC11330e interfaceC11330e, InterfaceC11448l interfaceC11448l, InterfaceC11344g interfaceC11344g, boolean z2, InterfaceC11321b.a aVar, C11679d c11679d, InterfaceC11704c interfaceC11704c, C11708g c11708g, C11710i c11710i, InterfaceC11861f interfaceC11861f, InterfaceC11467u0 interfaceC11467u0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC11330e, interfaceC11448l, interfaceC11344g, z2, aVar, c11679d, interfaceC11704c, c11708g, c11710i, interfaceC11861f, (i & 1024) != 0 ? null : interfaceC11467u0);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11373g, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q
    /* JADX INFO: renamed from: b */
    public /* bridge */ /* synthetic */ AbstractC11391q mo9373b(InterfaceC11450m interfaceC11450m, InterfaceC11472x interfaceC11472x, InterfaceC11321b.a aVar, C11716e c11716e, InterfaceC11344g interfaceC11344g, InterfaceC11467u0 interfaceC11467u0) {
        return m9953f(interfaceC11450m, interfaceC11472x, aVar, interfaceC11344g, interfaceC11467u0);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11373g
    /* JADX INFO: renamed from: e */
    public /* bridge */ /* synthetic */ C11373g mo9373b(InterfaceC11450m interfaceC11450m, InterfaceC11472x interfaceC11472x, InterfaceC11321b.a aVar, C11716e c11716e, InterfaceC11344g interfaceC11344g, InterfaceC11467u0 interfaceC11467u0) {
        return m9953f(interfaceC11450m, interfaceC11472x, aVar, interfaceC11344g, interfaceC11467u0);
    }

    /* JADX INFO: renamed from: f */
    public C11858c m9953f(InterfaceC11450m interfaceC11450m, InterfaceC11472x interfaceC11472x, InterfaceC11321b.a aVar, InterfaceC11344g interfaceC11344g, InterfaceC11467u0 interfaceC11467u0) {
        C12238m.checkNotNullParameter(interfaceC11450m, "newOwner");
        C12238m.checkNotNullParameter(aVar, "kind");
        C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
        C12238m.checkNotNullParameter(interfaceC11467u0, "source");
        C11858c c11858c = new C11858c((InterfaceC11330e) interfaceC11450m, (InterfaceC11448l) interfaceC11472x, interfaceC11344g, this.f22874N, aVar, getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource(), interfaceC11467u0);
        c11858c.setHasStableParameterNames(hasStableParameterNames());
        c11858c.setCoroutinesExperimentalCompatibilityMode$deserialization(getCoroutinesExperimentalCompatibilityMode());
        return c11858c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g
    public InterfaceC11861f getContainerSource() {
        return this.f24527S;
    }

    public InterfaceC11862g.a getCoroutinesExperimentalCompatibilityMode() {
        return this.f24528T;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g
    public InterfaceC11704c getNameResolver() {
        return this.f24524P;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g
    public C11708g getTypeTable() {
        return this.f24525Q;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g
    public C11710i getVersionRequirementTable() {
        return this.f24526R;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g
    public List<C11709h> getVersionRequirements() {
        return InterfaceC11857b.a.getVersionRequirements(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public boolean isExternal() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x
    public boolean isInline() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x
    public boolean isSuspend() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x
    public boolean isTailrec() {
        return false;
    }

    public void setCoroutinesExperimentalCompatibilityMode$deserialization(InterfaceC11862g.a aVar) {
        C12238m.checkNotNullParameter(aVar, "<set-?>");
        this.f24528T = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11858c(InterfaceC11330e interfaceC11330e, InterfaceC11448l interfaceC11448l, InterfaceC11344g interfaceC11344g, boolean z2, InterfaceC11321b.a aVar, C11679d c11679d, InterfaceC11704c interfaceC11704c, C11708g c11708g, C11710i c11710i, InterfaceC11861f interfaceC11861f, InterfaceC11467u0 interfaceC11467u0) {
        super(interfaceC11330e, interfaceC11448l, interfaceC11344g, z2, aVar, interfaceC11467u0 == null ? InterfaceC11467u0.f23099a : interfaceC11467u0);
        C12238m.checkNotNullParameter(interfaceC11330e, "containingDeclaration");
        C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
        C12238m.checkNotNullParameter(aVar, "kind");
        C12238m.checkNotNullParameter(c11679d, "proto");
        C12238m.checkNotNullParameter(interfaceC11704c, "nameResolver");
        C12238m.checkNotNullParameter(c11708g, "typeTable");
        C12238m.checkNotNullParameter(c11710i, "versionRequirementTable");
        this.f24523O = c11679d;
        this.f24524P = interfaceC11704c;
        this.f24525Q = c11708g;
        this.f24526R = c11710i;
        this.f24527S = interfaceC11861f;
        this.f24528T = InterfaceC11862g.a.COMPATIBLE;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g
    public C11679d getProto() {
        return this.f24523O;
    }
}
