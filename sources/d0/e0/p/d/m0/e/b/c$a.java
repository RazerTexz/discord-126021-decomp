package d0.e0.p.d.m0.e.b;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.u0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a implements p$a {
    public final HashMap<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.k.v.g<?>> a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d0.e0.p.d.m0.c.e f3373b;
    public final /* synthetic */ c c;
    public final /* synthetic */ List<d0.e0.p.d.m0.c.g1.c> d;
    public final /* synthetic */ u0 e;

    public c$a(d0.e0.p.d.m0.c.e eVar, c cVar, List<d0.e0.p.d.m0.c.g1.c> list, u0 u0Var) {
        this.f3373b = eVar;
        this.c = cVar;
        this.d = list;
        this.e = u0Var;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.k.v.g access$createConstant(c$a c_a, d0.e0.p.d.m0.g.e eVar, Object obj) {
        return c_a.a(eVar, obj);
    }

    public static final /* synthetic */ HashMap access$getArguments$p(c$a c_a) {
        return c_a.a;
    }

    public final d0.e0.p.d.m0.k.v.g<?> a(d0.e0.p.d.m0.g.e eVar, Object obj) {
        d0.e0.p.d.m0.k.v.g<?> gVarCreateConstantValue = d0.e0.p.d.m0.k.v.h.a.createConstantValue(obj);
        return gVarCreateConstantValue == null ? d0.e0.p.d.m0.k.v.k.f3474b.create(d0.z.d.m.stringPlus("Unsupported annotation argument: ", eVar)) : gVarCreateConstantValue;
    }

    @Override // d0.e0.p.d.m0.e.b.p$a
    public void visit(d0.e0.p.d.m0.g.e eVar, Object obj) {
        if (eVar != null) {
            this.a.put(eVar, a(eVar, obj));
        }
    }

    @Override // d0.e0.p.d.m0.e.b.p$a
    public p$a visitAnnotation(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.g.a aVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        ArrayList arrayList = new ArrayList();
        c cVar = this.c;
        u0 u0Var = u0.a;
        d0.z.d.m.checkNotNullExpressionValue(u0Var, "NO_SOURCE");
        p$a p_aH = cVar.h(aVar, u0Var, arrayList);
        d0.z.d.m.checkNotNull(p_aH);
        return new c$a$a(p_aH, this, eVar, arrayList);
    }

    @Override // d0.e0.p.d.m0.e.b.p$a
    public p$b visitArray(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new c$a$b(this, eVar, this.f3373b);
    }

    @Override // d0.e0.p.d.m0.e.b.p$a
    public void visitClassLiteral(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.k.v.f fVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(fVar, "value");
        this.a.put(eVar, new d0.e0.p.d.m0.k.v.r(fVar));
    }

    @Override // d0.e0.p.d.m0.e.b.p$a
    public void visitEnd() {
        this.d.add(new d0.e0.p.d.m0.c.g1.d(this.f3373b.getDefaultType(), this.a, this.e));
    }

    @Override // d0.e0.p.d.m0.e.b.p$a
    public void visitEnum(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.g.a aVar, d0.e0.p.d.m0.g.e eVar2) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(aVar, "enumClassId");
        d0.z.d.m.checkNotNullParameter(eVar2, "enumEntryName");
        this.a.put(eVar, new d0.e0.p.d.m0.k.v.j(aVar, eVar2));
    }
}
