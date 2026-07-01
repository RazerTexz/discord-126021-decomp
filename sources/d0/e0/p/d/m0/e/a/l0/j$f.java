package d0.e0.p.d.m0.e.a.l0;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j$f extends d0.z.d.o implements Function1<q$a$a, Unit> {
    public final /* synthetic */ String $JLObject;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j$f(String str) {
        super(1);
        this.$JLObject = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(q$a$a q_a_a) {
        invoke2(q_a_a);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(q$a$a q_a_a) {
        d0.z.d.m.checkNotNullParameter(q_a_a, "<this>");
        q_a_a.returns(this.$JLObject, j.access$getNOT_PLATFORM$p$s1730278749());
    }
}
