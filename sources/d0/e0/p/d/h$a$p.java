package d0.e0.p.d;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KClassImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$a$p extends d0.z.d.o implements Function0<String> {
    public final /* synthetic */ h$a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$a$p(h$a h_a) {
        super(0);
        this.this$0 = h_a;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        if (this.this$0.p.getJClass().isAnonymousClass()) {
            return null;
        }
        d0.e0.p.d.m0.g.a aVarAccess$getClassId$p = h.access$getClassId$p(this.this$0.p);
        if (aVarAccess$getClassId$p.isLocal()) {
            h$a h_a = this.this$0;
            return h$a.access$calculateLocalClassName(h_a, h_a.p.getJClass());
        }
        String strAsString = aVarAccess$getClassId$p.getShortClassName().asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "classId.shortClassName.asString()");
        return strAsString;
    }
}
