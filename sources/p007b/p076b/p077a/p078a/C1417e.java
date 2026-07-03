package p007b.p076b.p077a.p078a;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.b.a.a.e */
/* JADX INFO: compiled from: FilesFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C1417e implements SwipeRefreshLayout.OnRefreshListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Function0 f2132a;

    public C1417e(Function0 function0) {
        this.f2132a = function0;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public final /* synthetic */ void onRefresh() {
        C12238m.checkNotNullExpressionValue(this.f2132a.invoke(), "invoke(...)");
    }
}
