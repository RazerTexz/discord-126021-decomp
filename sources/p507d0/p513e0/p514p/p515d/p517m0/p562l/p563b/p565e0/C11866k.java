package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11476z;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11374g0;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11708g;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11709h;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11710i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.k */
/* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11866k extends C11374g0 implements InterfaceC11857b {

    /* JADX INFO: renamed from: M */
    public final C11684i f24604M;

    /* JADX INFO: renamed from: N */
    public final InterfaceC11704c f24605N;

    /* JADX INFO: renamed from: O */
    public final C11708g f24606O;

    /* JADX INFO: renamed from: P */
    public final C11710i f24607P;

    /* JADX INFO: renamed from: Q */
    public final InterfaceC11861f f24608Q;

    /* JADX INFO: renamed from: R */
    public InterfaceC11862g.a f24609R;

    public /* synthetic */ C11866k(InterfaceC11450m interfaceC11450m, InterfaceC11465t0 interfaceC11465t0, InterfaceC11344g interfaceC11344g, C11716e c11716e, InterfaceC11321b.a aVar, C11684i c11684i, InterfaceC11704c interfaceC11704c, C11708g c11708g, C11710i c11710i, InterfaceC11861f interfaceC11861f, InterfaceC11467u0 interfaceC11467u0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC11450m, interfaceC11465t0, interfaceC11344g, c11716e, aVar, c11684i, interfaceC11704c, c11708g, c11710i, interfaceC11861f, (i & 1024) != 0 ? null : interfaceC11467u0);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11374g0, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q
    /* JADX INFO: renamed from: b */
    public AbstractC11391q mo9373b(InterfaceC11450m interfaceC11450m, InterfaceC11472x interfaceC11472x, InterfaceC11321b.a aVar, C11716e c11716e, InterfaceC11344g interfaceC11344g, InterfaceC11467u0 interfaceC11467u0) {
        C11716e c11716e2;
        C12238m.checkNotNullParameter(interfaceC11450m, "newOwner");
        C12238m.checkNotNullParameter(aVar, "kind");
        C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
        C12238m.checkNotNullParameter(interfaceC11467u0, "source");
        InterfaceC11465t0 interfaceC11465t0 = (InterfaceC11465t0) interfaceC11472x;
        if (c11716e == null) {
            C11716e name = getName();
            C12238m.checkNotNullExpressionValue(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            c11716e2 = name;
        } else {
            c11716e2 = c11716e;
        }
        C11866k c11866k = new C11866k(interfaceC11450m, interfaceC11465t0, interfaceC11344g, c11716e2, aVar, getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource(), interfaceC11467u0);
        c11866k.setHasStableParameterNames(hasStableParameterNames());
        c11866k.f24609R = getCoroutinesExperimentalCompatibilityMode();
        return c11866k;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g
    public InterfaceC11861f getContainerSource() {
        return this.f24608Q;
    }

    public InterfaceC11862g.a getCoroutinesExperimentalCompatibilityMode() {
        return this.f24609R;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g
    public InterfaceC11704c getNameResolver() {
        return this.f24605N;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g
    public C11708g getTypeTable() {
        return this.f24606O;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g
    public C11710i getVersionRequirementTable() {
        return this.f24607P;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g
    public List<C11709h> getVersionRequirements() {
        return InterfaceC11857b.a.getVersionRequirements(this);
    }

    public final C11374g0 initialize(InterfaceC11459q0 interfaceC11459q0, InterfaceC11459q0 interfaceC11459q1, List<? extends InterfaceC11477z0> list, List<? extends InterfaceC11326c1> list2, AbstractC11913c0 abstractC11913c0, EnumC11476z enumC11476z, AbstractC11466u abstractC11466u, Map<? extends InterfaceC11318a.a<?>, ?> map, InterfaceC11862g.a aVar) {
        C12238m.checkNotNullParameter(list, "typeParameters");
        C12238m.checkNotNullParameter(list2, "unsubstitutedValueParameters");
        C12238m.checkNotNullParameter(abstractC11466u, "visibility");
        C12238m.checkNotNullParameter(map, "userDataMap");
        C12238m.checkNotNullParameter(aVar, "isExperimentalCoroutineInReleaseEnvironment");
        C11374g0 c11374g0Initialize = super.initialize(interfaceC11459q0, interfaceC11459q1, list, list2, abstractC11913c0, enumC11476z, abstractC11466u, map);
        C12238m.checkNotNullExpressionValue(c11374g0Initialize, "super.initialize(\n            extensionReceiverParameter,\n            dispatchReceiverParameter,\n            typeParameters,\n            unsubstitutedValueParameters,\n            unsubstitutedReturnType,\n            modality,\n            visibility,\n            userDataMap\n        )");
        this.f24609R = aVar;
        return c11374g0Initialize;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11866k(InterfaceC11450m interfaceC11450m, InterfaceC11465t0 interfaceC11465t0, InterfaceC11344g interfaceC11344g, C11716e c11716e, InterfaceC11321b.a aVar, C11684i c11684i, InterfaceC11704c interfaceC11704c, C11708g c11708g, C11710i c11710i, InterfaceC11861f interfaceC11861f, InterfaceC11467u0 interfaceC11467u0) {
        super(interfaceC11450m, interfaceC11465t0, interfaceC11344g, c11716e, aVar, interfaceC11467u0 == null ? InterfaceC11467u0.f23099a : interfaceC11467u0);
        C12238m.checkNotNullParameter(interfaceC11450m, "containingDeclaration");
        C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(aVar, "kind");
        C12238m.checkNotNullParameter(c11684i, "proto");
        C12238m.checkNotNullParameter(interfaceC11704c, "nameResolver");
        C12238m.checkNotNullParameter(c11708g, "typeTable");
        C12238m.checkNotNullParameter(c11710i, "versionRequirementTable");
        this.f24604M = c11684i;
        this.f24605N = interfaceC11704c;
        this.f24606O = c11708g;
        this.f24607P = c11710i;
        this.f24608Q = interfaceC11861f;
        this.f24609R = InterfaceC11862g.a.COMPATIBLE;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g
    public C11684i getProto() {
        return this.f24604M;
    }
}
