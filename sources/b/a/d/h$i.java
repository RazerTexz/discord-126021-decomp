package b.a.d;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AppPermissions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h$i extends d0.z.d.o implements Function1<Map<String, ? extends Boolean>, Unit> {
    public final /* synthetic */ h this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$i(h hVar) {
        super(1);
        this.this$0 = hVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Map<String, ? extends Boolean> map) {
        Map<String, ? extends Boolean> map2 = map;
        d0.z.d.m.checkNotNullParameter(map2, "grantResults");
        Boolean bool = map2.get("android.permission.RECORD_AUDIO");
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        if (bool.booleanValue()) {
            Boolean bool2 = map2.get("android.permission.CAMERA");
            if (bool2 == null) {
                bool2 = Boolean.FALSE;
            }
            if (bool2.booleanValue()) {
                h.a(this.this$0, 2131893239);
            } else {
                h.a(this.this$0, 2131893239);
            }
        } else {
            h.a(this.this$0, 2131893768);
        }
        return Unit.a;
    }
}
