package androidx.viewpager2.widget;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager2$SmoothScrollToPosition implements Runnable {
    private final int mPosition;
    private final RecyclerView mRecyclerView;

    public ViewPager2$SmoothScrollToPosition(int i, RecyclerView recyclerView) {
        this.mPosition = i;
        this.mRecyclerView = recyclerView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mRecyclerView.smoothScrollToPosition(this.mPosition);
    }
}
