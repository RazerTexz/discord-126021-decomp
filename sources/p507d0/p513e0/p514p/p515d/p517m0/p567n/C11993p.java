package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.p */
/* JADX INFO: compiled from: DisjointKeysUnionTypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11993p extends AbstractC12018z0 {

    /* JADX INFO: renamed from: b */
    public static final a f24852b = new a(null);

    /* JADX INFO: renamed from: c */
    public final AbstractC12018z0 f24853c;

    /* JADX INFO: renamed from: d */
    public final AbstractC12018z0 f24854d;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.p$a */
    /* JADX INFO: compiled from: DisjointKeysUnionTypeSubstitution.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final AbstractC12018z0 create(AbstractC12018z0 abstractC12018z0, AbstractC12018z0 abstractC12018z1) {
            C12238m.checkNotNullParameter(abstractC12018z0, "first");
            C12238m.checkNotNullParameter(abstractC12018z1, "second");
            if (abstractC12018z0.isEmpty()) {
                return abstractC12018z1;
            }
            return abstractC12018z1.isEmpty() ? abstractC12018z0 : new C11993p(abstractC12018z0, abstractC12018z1, null);
        }
    }

    public C11993p(AbstractC12018z0 abstractC12018z0, AbstractC12018z0 abstractC12018z1, DefaultConstructorMarker defaultConstructorMarker) {
        this.f24853c = abstractC12018z0;
        this.f24854d = abstractC12018z1;
    }

    public static final AbstractC12018z0 create(AbstractC12018z0 abstractC12018z0, AbstractC12018z0 abstractC12018z1) {
        return f24852b.create(abstractC12018z0, abstractC12018z1);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0
    public boolean approximateCapturedTypes() {
        return this.f24853c.approximateCapturedTypes() || this.f24854d.approximateCapturedTypes();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0
    public boolean approximateContravariantCapturedTypes() {
        return this.f24853c.approximateContravariantCapturedTypes() || this.f24854d.approximateContravariantCapturedTypes();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0
    public InterfaceC11344g filterAnnotations(InterfaceC11344g interfaceC11344g) {
        C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
        return this.f24854d.filterAnnotations(this.f24853c.filterAnnotations(interfaceC11344g));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0
    public InterfaceC12012w0 get(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "key");
        InterfaceC12012w0 interfaceC12012w0 = this.f24853c.get(abstractC11913c0);
        return interfaceC12012w0 == null ? this.f24854d.get(abstractC11913c0) : interfaceC12012w0;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0
    public boolean isEmpty() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0
    public AbstractC11913c0 prepareTopLevelType(AbstractC11913c0 abstractC11913c0, EnumC11935j1 enumC11935j1) {
        C12238m.checkNotNullParameter(abstractC11913c0, "topLevelType");
        C12238m.checkNotNullParameter(enumC11935j1, ModelAuditLogEntry.CHANGE_KEY_POSITION);
        return this.f24854d.prepareTopLevelType(this.f24853c.prepareTopLevelType(abstractC11913c0, enumC11935j1), enumC11935j1);
    }
}
