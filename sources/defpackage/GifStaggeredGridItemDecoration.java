package defpackage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import d0.z.d.Intrinsics3;
import java.util.Objects;

/* JADX INFO: renamed from: u, reason: use source file name */
/* JADX INFO: compiled from: GifStaggeredGridItemDecoration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifStaggeredGridItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3849b;

    public GifStaggeredGridItemDecoration(int i, int i2) {
        this.a = i;
        this.f3849b = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics3.checkNotNullParameter(rect, "outRect");
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(recyclerView, "parent");
        Intrinsics3.checkNotNullParameter(state, "state");
        super.getItemOffsets(rect, view, recyclerView, state);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        rect.set(rect.left, rect.top, ((StaggeredGridLayoutManager.LayoutParams) layoutParams).getSpanIndex() == this.f3849b - 1 ? 0 : this.a, rect.bottom);
    }
}
