package b.a.d;

import androidx.activity.result.ActivityResultCallback;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AppPermissions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h$b<O> implements ActivityResultCallback<Map<String, Boolean>> {
    public final /* synthetic */ h a;

    public h$b(h hVar) {
        this.a = hVar;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Map<String, Boolean> map) {
        Map<String, Boolean> map2 = map;
        if (map2.containsValue(Boolean.FALSE)) {
            Function1<? super Map<String, Boolean>, Unit> function1 = this.a.m;
            if (function1 != null) {
                d0.z.d.m.checkNotNullExpressionValue(map2, "grantResults");
                function1.invoke(map2);
            }
        } else {
            Function0<Unit> function0 = this.a.l;
            if (function0 != null) {
                function0.invoke();
            }
        }
        h hVar = this.a;
        hVar.m = null;
        hVar.l = null;
        hVar.n = 0L;
    }
}
