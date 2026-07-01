package d0.e0.p.d.m0.e.b;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a$a implements p$a {
    public final /* synthetic */ p$a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p$a f3374b;
    public final /* synthetic */ c$a c;
    public final /* synthetic */ d0.e0.p.d.m0.g.e d;
    public final /* synthetic */ ArrayList<d0.e0.p.d.m0.c.g1.c> e;

    public c$a$a(p$a p_a, c$a c_a, d0.e0.p.d.m0.g.e eVar, ArrayList<d0.e0.p.d.m0.c.g1.c> arrayList) {
        this.f3374b = p_a;
        this.c = c_a;
        this.d = eVar;
        this.e = arrayList;
        this.a = p_a;
    }

    @Override // d0.e0.p.d.m0.e.b.p$a
    public void visit(d0.e0.p.d.m0.g.e eVar, Object obj) {
        this.a.visit(eVar, obj);
    }

    @Override // d0.e0.p.d.m0.e.b.p$a
    public p$a visitAnnotation(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.g.a aVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        return this.a.visitAnnotation(eVar, aVar);
    }

    @Override // d0.e0.p.d.m0.e.b.p$a
    public p$b visitArray(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.a.visitArray(eVar);
    }

    @Override // d0.e0.p.d.m0.e.b.p$a
    public void visitClassLiteral(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.k.v.f fVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(fVar, "value");
        this.a.visitClassLiteral(eVar, fVar);
    }

    @Override // d0.e0.p.d.m0.e.b.p$a
    public void visitEnd() {
        this.f3374b.visitEnd();
        c$a.access$getArguments$p(this.c).put(this.d, new d0.e0.p.d.m0.k.v.a((d0.e0.p.d.m0.c.g1.c) d0.t.u.single((List) this.e)));
    }

    @Override // d0.e0.p.d.m0.e.b.p$a
    public void visitEnum(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.g.a aVar, d0.e0.p.d.m0.g.e eVar2) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(aVar, "enumClassId");
        d0.z.d.m.checkNotNullParameter(eVar2, "enumEntryName");
        this.a.visitEnum(eVar, aVar, eVar2);
    }
}
