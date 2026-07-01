package b.a.d;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AppPermissions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h$h extends d0.z.d.o implements Function1<Map<String, ? extends Boolean>, Unit> {
    public final /* synthetic */ Function0 $onFailure;
    public final /* synthetic */ h this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$h(h hVar, Function0 function0) {
        super(1);
        this.this$0 = hVar;
        this.$onFailure = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Map<String, ? extends Boolean> map) {
        d0.z.d.m.checkNotNullParameter(map, "it");
        Function0 function0 = this.$onFailure;
        if (function0 == null || ((Unit) function0.invoke()) == null) {
            h.a(this.this$0, 2131893768);
        }
        return Unit.a;
    }
}
