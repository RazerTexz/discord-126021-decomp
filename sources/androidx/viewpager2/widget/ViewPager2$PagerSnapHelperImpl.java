package androidx.viewpager2.widget;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager2$PagerSnapHelperImpl extends PagerSnapHelper {
    public final /* synthetic */ ViewPager2 this$0;

    public ViewPager2$PagerSnapHelperImpl(ViewPager2 viewPager2) {
        this.this$0 = viewPager2;
    }

    @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
    @Nullable
    public View findSnapView(RecyclerView$LayoutManager recyclerView$LayoutManager) {
        if (this.this$0.isFakeDragging()) {
            return null;
        }
        return super.findSnapView(recyclerView$LayoutManager);
    }
}
