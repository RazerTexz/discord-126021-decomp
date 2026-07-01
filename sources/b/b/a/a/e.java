package b.b.a.a;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout$OnRefreshListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: FilesFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements SwipeRefreshLayout$OnRefreshListener {
    public final /* synthetic */ Function0 a;

    public e(Function0 function0) {
        this.a = function0;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout$OnRefreshListener
    public final /* synthetic */ void onRefresh() {
        d0.z.d.m.checkNotNullExpressionValue(this.a.invoke(), "invoke(...)");
    }
}
