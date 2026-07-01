package d0.e0.p.d.m0.e.a.i0.l;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LazyJavaAnnotationDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$b extends d0.z.d.o implements Function0<d0.e0.p.d.m0.g.b> {
    public final /* synthetic */ e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$b(e eVar) {
        super(0);
        this.this$0 = eVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.g.b invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final d0.e0.p.d.m0.g.b invoke() {
        d0.e0.p.d.m0.g.a classId = e.access$getJavaAnnotation$p(this.this$0).getClassId();
        if (classId == null) {
            return null;
        }
        return classId.asSingleFqName();
    }
}
