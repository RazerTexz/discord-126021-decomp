package b.a.y;

import kotlin.jvm.functions.Function4;
import rx.functions.Func4;

/* JADX INFO: compiled from: OverlayMenuView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class u implements Func4 {
    public final /* synthetic */ Function4 a;

    public u(Function4 function4) {
        this.a = function4;
    }

    @Override // rx.functions.Func4
    public final /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4) {
        return this.a.invoke(obj, obj2, obj3, obj4);
    }
}
