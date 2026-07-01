package d0.e0.p.d;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.i.g$f;
import java.util.Collection;
import java.util.List;
import kotlin.Triple;

/* JADX INFO: compiled from: KPackageImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends i {
    public final c0$b<n$a> m;
    public final Class<?> n;

    public n(Class<?> cls, String str) {
        d0.z.d.m.checkNotNullParameter(cls, "jClass");
        this.n = cls;
        c0$b<n$a> c0_bLazy = c0.lazy(new n$b(this));
        d0.z.d.m.checkNotNullExpressionValue(c0_bLazy, "ReflectProperties.lazy { Data() }");
        this.m = c0_bLazy;
    }

    @Override // d0.e0.p.d.i
    public Class<?> c() {
        Class<?> multifileFacade = this.m.invoke().getMultifileFacade();
        return multifileFacade != null ? multifileFacade : getJClass();
    }

    public boolean equals(Object obj) {
        return (obj instanceof n) && d0.z.d.m.areEqual(getJClass(), ((n) obj).getJClass());
    }

    @Override // d0.e0.p.d.i
    public Collection<d0.e0.p.d.m0.c.l> getConstructorDescriptors() {
        return d0.t.n.emptyList();
    }

    @Override // d0.e0.p.d.i
    public Collection<d0.e0.p.d.m0.c.x> getFunctions(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.m.invoke().getScope().getContributedFunctions(eVar, d0.e0.p.d.m0.d.b.d.FROM_REFLECTION);
    }

    @Override // d0.z.d.e
    public Class<?> getJClass() {
        return this.n;
    }

    @Override // d0.e0.p.d.i
    public n0 getLocalProperty(int i) {
        Triple<d0.e0.p.d.m0.f.a0.b.g, d0.e0.p.d.m0.f.l, d0.e0.p.d.m0.f.a0.b.f> metadata = this.m.invoke().getMetadata();
        if (metadata == null) {
            return null;
        }
        d0.e0.p.d.m0.f.a0.b.g gVarComponent1 = metadata.component1();
        d0.e0.p.d.m0.f.l lVarComponent2 = metadata.component2();
        d0.e0.p.d.m0.f.a0.b.f fVarComponent3 = metadata.component3();
        g$f<d0.e0.p.d.m0.f.l, List<d0.e0.p.d.m0.f.n>> g_f = d0.e0.p.d.m0.f.a0.a.n;
        d0.z.d.m.checkNotNullExpressionValue(g_f, "JvmProtoBuf.packageLocalVariable");
        d0.e0.p.d.m0.f.n nVar = (d0.e0.p.d.m0.f.n) d0.e0.p.d.m0.f.z.e.getExtensionOrNull(lVarComponent2, g_f, i);
        if (nVar == null) {
            return null;
        }
        Class<?> jClass = getJClass();
        d0.e0.p.d.m0.f.t typeTable = lVarComponent2.getTypeTable();
        d0.z.d.m.checkNotNullExpressionValue(typeTable, "packageProto.typeTable");
        return (n0) j0.deserializeToDescriptor(jClass, nVar, gVarComponent1, new d0.e0.p.d.m0.f.z.g(typeTable), fVarComponent3, n$c.j);
    }

    @Override // d0.e0.p.d.i
    public Collection<n0> getProperties(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.m.invoke().getScope().getContributedVariables(eVar, d0.e0.p.d.m0.d.b.d.FROM_REFLECTION);
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("file class ");
        sbU.append(d0.e0.p.d.m0.c.k1.b.b.getClassId(getJClass()).asSingleFqName());
        return sbU.toString();
    }
}
