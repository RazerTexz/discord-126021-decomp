package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.n.c0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a$b implements p$b {
    public final ArrayList<d0.e0.p.d.m0.k.v.g<?>> a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c$a f3375b;
    public final /* synthetic */ d0.e0.p.d.m0.g.e c;
    public final /* synthetic */ d0.e0.p.d.m0.c.e d;

    public c$a$b(c$a c_a, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.e eVar2) {
        this.f3375b = c_a;
        this.c = eVar;
        this.d = eVar2;
    }

    @Override // d0.e0.p.d.m0.e.b.p$b
    public void visit(Object obj) {
        this.a.add(c$a.access$createConstant(this.f3375b, this.c, obj));
    }

    @Override // d0.e0.p.d.m0.e.b.p$b
    public void visitClassLiteral(d0.e0.p.d.m0.k.v.f fVar) {
        d0.z.d.m.checkNotNullParameter(fVar, "value");
        this.a.add(new d0.e0.p.d.m0.k.v.r(fVar));
    }

    @Override // d0.e0.p.d.m0.e.b.p$b
    public void visitEnd() {
        c1 annotationParameterByName = d0.e0.p.d.m0.e.a.g0.a.getAnnotationParameterByName(this.c, this.d);
        if (annotationParameterByName != null) {
            HashMap mapAccess$getArguments$p = c$a.access$getArguments$p(this.f3375b);
            d0.e0.p.d.m0.g.e eVar = this.c;
            d0.e0.p.d.m0.k.v.h hVar = d0.e0.p.d.m0.k.v.h.a;
            List<? extends d0.e0.p.d.m0.k.v.g<?>> listCompact = d0.e0.p.d.m0.p.a.compact(this.a);
            c0 type = annotationParameterByName.getType();
            d0.z.d.m.checkNotNullExpressionValue(type, "parameter.type");
            mapAccess$getArguments$p.put(eVar, hVar.createArrayValue(listCompact, type));
        }
    }

    @Override // d0.e0.p.d.m0.e.b.p$b
    public void visitEnum(d0.e0.p.d.m0.g.a aVar, d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(aVar, "enumClassId");
        d0.z.d.m.checkNotNullParameter(eVar, "enumEntryName");
        this.a.add(new d0.e0.p.d.m0.k.v.j(aVar, eVar));
    }
}
