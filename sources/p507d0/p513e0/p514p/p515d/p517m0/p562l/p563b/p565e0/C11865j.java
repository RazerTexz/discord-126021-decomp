package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11476z;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11457p0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11468v;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11366c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11368d0;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11703b;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11708g;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11709h;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11710i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.j */
/* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11865j extends C11366c0 implements InterfaceC11857b {

    /* JADX INFO: renamed from: J */
    public final C11689n f24599J;

    /* JADX INFO: renamed from: K */
    public final InterfaceC11704c f24600K;

    /* JADX INFO: renamed from: L */
    public final C11708g f24601L;

    /* JADX INFO: renamed from: M */
    public final C11710i f24602M;

    /* JADX INFO: renamed from: N */
    public final InterfaceC11861f f24603N;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11865j(InterfaceC11450m interfaceC11450m, InterfaceC11453n0 interfaceC11453n0, InterfaceC11344g interfaceC11344g, EnumC11476z enumC11476z, AbstractC11466u abstractC11466u, boolean z2, C11716e c11716e, InterfaceC11321b.a aVar, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, C11689n c11689n, InterfaceC11704c interfaceC11704c, C11708g c11708g, C11710i c11710i, InterfaceC11861f interfaceC11861f) {
        super(interfaceC11450m, interfaceC11453n0, interfaceC11344g, enumC11476z, abstractC11466u, z2, c11716e, aVar, InterfaceC11467u0.f23099a, z3, z4, z7, false, z5, z6);
        C12238m.checkNotNullParameter(interfaceC11450m, "containingDeclaration");
        C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
        C12238m.checkNotNullParameter(enumC11476z, "modality");
        C12238m.checkNotNullParameter(abstractC11466u, "visibility");
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(aVar, "kind");
        C12238m.checkNotNullParameter(c11689n, "proto");
        C12238m.checkNotNullParameter(interfaceC11704c, "nameResolver");
        C12238m.checkNotNullParameter(c11708g, "typeTable");
        C12238m.checkNotNullParameter(c11710i, "versionRequirementTable");
        this.f24599J = c11689n;
        this.f24600K = interfaceC11704c;
        this.f24601L = c11708g;
        this.f24602M = c11710i;
        this.f24603N = interfaceC11861f;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11366c0
    /* JADX INFO: renamed from: b */
    public C11366c0 mo9394b(InterfaceC11450m interfaceC11450m, EnumC11476z enumC11476z, AbstractC11466u abstractC11466u, InterfaceC11453n0 interfaceC11453n0, InterfaceC11321b.a aVar, C11716e c11716e, InterfaceC11467u0 interfaceC11467u0) {
        C12238m.checkNotNullParameter(interfaceC11450m, "newOwner");
        C12238m.checkNotNullParameter(enumC11476z, "newModality");
        C12238m.checkNotNullParameter(abstractC11466u, "newVisibility");
        C12238m.checkNotNullParameter(aVar, "kind");
        C12238m.checkNotNullParameter(c11716e, "newName");
        C12238m.checkNotNullParameter(interfaceC11467u0, "source");
        return new C11865j(interfaceC11450m, interfaceC11453n0, getAnnotations(), enumC11476z, abstractC11466u, isVar(), c11716e, aVar, isLateInit(), isConst(), isExternal(), isDelegated(), isExpect(), getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g
    public InterfaceC11861f getContainerSource() {
        return this.f24603N;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g
    public InterfaceC11704c getNameResolver() {
        return this.f24600K;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g
    public C11708g getTypeTable() {
        return this.f24601L;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g
    public C11710i getVersionRequirementTable() {
        return this.f24602M;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g
    public List<C11709h> getVersionRequirements() {
        return InterfaceC11857b.a.getVersionRequirements(this);
    }

    public final void initialize(C11368d0 c11368d0, InterfaceC11457p0 interfaceC11457p0, InterfaceC11468v interfaceC11468v, InterfaceC11468v interfaceC11468v2, InterfaceC11862g.a aVar) {
        C12238m.checkNotNullParameter(aVar, "isExperimentalCoroutineInReleaseEnvironment");
        super.initialize(c11368d0, interfaceC11457p0, interfaceC11468v, interfaceC11468v2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11366c0, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public boolean isExternal() {
        Boolean bool = C11703b.f24019C.get(getProto().getFlags());
        C12238m.checkNotNullExpressionValue(bool, "IS_EXTERNAL_PROPERTY.get(proto.flags)");
        return bool.booleanValue();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g
    public C11689n getProto() {
        return this.f24599J;
    }
}
