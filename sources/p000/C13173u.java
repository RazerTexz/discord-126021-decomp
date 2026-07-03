package p000;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.Objects;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: u */
/* JADX INFO: compiled from: GifStaggeredGridItemDecoration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C13173u extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a */
    public final int f27927a;

    /* JADX INFO: renamed from: b */
    public final int f27928b;

    public C13173u(int i, int i2) {
        this.f27927a = i;
        this.f27928b = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        C12238m.checkNotNullParameter(rect, "outRect");
        C12238m.checkNotNullParameter(view, "view");
        C12238m.checkNotNullParameter(recyclerView, "parent");
        C12238m.checkNotNullParameter(state, "state");
        super.getItemOffsets(rect, view, recyclerView, state);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        rect.set(rect.left, rect.top, ((StaggeredGridLayoutManager.LayoutParams) layoutParams).getSpanIndex() == this.f27928b - 1 ? 0 : this.f27927a, rect.bottom);
    }
}
