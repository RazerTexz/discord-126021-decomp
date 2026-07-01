package d0.e0.p.d.m0.e.a.g0;

import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.m.n;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.j0;
import d0.t.h0;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.y;
import java.util.Collection;
import java.util.Map;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public class b implements d0.e0.p.d.m0.c.g1.c, d0.e0.p.d.m0.e.a.h0.i {
    public static final /* synthetic */ KProperty<Object>[] a = {a0.property1(new y(a0.getOrCreateKotlinClass(b.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.g.b f3314b;
    public final u0 c;
    public final d0.e0.p.d.m0.m.j d;
    public final d0.e0.p.d.m0.e.a.k0.b e;
    public final boolean f;

    public b(d0.e0.p.d.m0.e.a.i0.g gVar, d0.e0.p.d.m0.e.a.k0.a aVar, d0.e0.p.d.m0.g.b bVar) {
        Collection<d0.e0.p.d.m0.e.a.k0.b> arguments;
        m.checkNotNullParameter(gVar, "c");
        m.checkNotNullParameter(bVar, "fqName");
        this.f3314b = bVar;
        u0 u0VarSource = aVar == null ? null : gVar.getComponents().getSourceElementFactory().source(aVar);
        if (u0VarSource == null) {
            u0VarSource = u0.a;
            m.checkNotNullExpressionValue(u0VarSource, "NO_SOURCE");
        }
        this.c = u0VarSource;
        this.d = gVar.getStorageManager().createLazyValue(new b$a(gVar, this));
        this.e = (aVar == null || (arguments = aVar.getArguments()) == null) ? null : (d0.e0.p.d.m0.e.a.k0.b) u.firstOrNull(arguments);
        this.f = m.areEqual(aVar != null ? Boolean.valueOf(aVar.isIdeExternalAnnotation()) : null, Boolean.TRUE);
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public Map<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.k.v.g<?>> getAllValueArguments() {
        return h0.emptyMap();
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public d0.e0.p.d.m0.g.b getFqName() {
        return this.f3314b;
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public u0 getSource() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public /* bridge */ /* synthetic */ c0 getType() {
        return getType();
    }

    @Override // d0.e0.p.d.m0.e.a.h0.i
    public boolean isIdeExternalAnnotation() {
        return this.f;
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public j0 getType() {
        return (j0) n.getValue(this.d, this, (KProperty<?>) a[0]);
    }
}
