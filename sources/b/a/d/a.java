package b.a.d;

import kotlin.jvm.functions.Function3;
import rx.functions.Action3;

/* JADX INFO: compiled from: App.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Action3 {
    public final /* synthetic */ Function3 j;

    public a(Function3 function3) {
        this.j = function3;
    }

    @Override // rx.functions.Action3
    public final /* synthetic */ void call(Object obj, Object obj2, Object obj3) {
        d0.z.d.m.checkNotNullExpressionValue(this.j.invoke(obj, obj2, obj3), "invoke(...)");
    }
}
