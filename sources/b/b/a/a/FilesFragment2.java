package b.b.a.a;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: b.b.a.a.e, reason: use source file name */
/* JADX INFO: compiled from: FilesFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FilesFragment2 implements SwipeRefreshLayout.OnRefreshListener {
    public final /* synthetic */ Function0 a;

    public FilesFragment2(Function0 function0) {
        this.a = function0;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public final /* synthetic */ void onRefresh() {
        Intrinsics3.checkNotNullExpressionValue(this.a.invoke(), "invoke(...)");
    }
}
