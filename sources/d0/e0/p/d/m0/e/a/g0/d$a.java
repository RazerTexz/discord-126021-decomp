package d0.e0.p.d.m0.e.a.g0;

import d0.e0.p.d.m0.b.k$a;
import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.t;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a extends o implements Function1<c0, d0.e0.p.d.m0.n.c0> {
    public static final d$a j = new d$a();

    public d$a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.n.c0 invoke(c0 c0Var) {
        return invoke2(c0Var);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final d0.e0.p.d.m0.n.c0 invoke2(c0 c0Var) {
        m.checkNotNullParameter(c0Var, "module");
        c1 annotationParameterByName = a.getAnnotationParameterByName(c.a.getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm(), c0Var.getBuiltIns().getBuiltInClassByFqName(k$a.A));
        d0.e0.p.d.m0.n.c0 type = annotationParameterByName == null ? null : annotationParameterByName.getType();
        if (type != null) {
            return type;
        }
        j0 j0VarCreateErrorType = t.createErrorType("Error: AnnotationTarget[]");
        m.checkNotNullExpressionValue(j0VarCreateErrorType, "createErrorType(\"Error: AnnotationTarget[]\")");
        return j0VarCreateErrorType;
    }
}
