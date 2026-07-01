package defpackage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$State;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: GifStaggeredGridItemDecoration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class u extends RecyclerView$ItemDecoration {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3849b;

    public u(int i, int i2) {
        this.a = i;
        this.f3849b = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView$State recyclerView$State) {
        m.checkNotNullParameter(rect, "outRect");
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(recyclerView, "parent");
        m.checkNotNullParameter(recyclerView$State, "state");
        super.getItemOffsets(rect, view, recyclerView, recyclerView$State);
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        rect.set(rect.left, rect.top, ((StaggeredGridLayoutManager$LayoutParams) layoutParams).getSpanIndex() == this.f3849b - 1 ? 0 : this.a, rect.bottom);
    }
}
