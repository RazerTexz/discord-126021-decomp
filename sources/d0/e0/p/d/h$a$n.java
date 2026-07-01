package d0.e0.p.d;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KClassImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$a$n extends d0.z.d.o implements Function0<String> {
    public final /* synthetic */ h$a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$a$n(h$a h_a) {
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
            return null;
        }
        return aVarAccess$getClassId$p.asSingleFqName().asString();
    }
}
