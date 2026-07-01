package b.a.a.a;

import kotlin.jvm.functions.Function2;
import rx.functions.Func2;

/* JADX INFO: compiled from: GuildBoostCancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h implements Func2 {
    public final /* synthetic */ Function2 j;

    public h(Function2 function2) {
        this.j = function2;
    }

    @Override // rx.functions.Func2
    public final /* synthetic */ Object call(Object obj, Object obj2) {
        return this.j.invoke(obj, obj2);
    }
}
