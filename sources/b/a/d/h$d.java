package b.a.d;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AppPermissions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h$d extends d0.z.d.o implements Function1<Map<String, ? extends Boolean>, Unit> {
    public final /* synthetic */ Function0 $onFailure;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$d(Function0 function0) {
        super(1);
        this.$onFailure = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Map<String, ? extends Boolean> map) {
        d0.z.d.m.checkNotNullParameter(map, "it");
        this.$onFailure.invoke();
        return Unit.a;
    }
}
