package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$OnChildAttachStateChangeListener;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager2$4 implements RecyclerView$OnChildAttachStateChangeListener {
    public final /* synthetic */ ViewPager2 this$0;

    public ViewPager2$4(ViewPager2 viewPager2) {
        this.this$0 = viewPager2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(@NonNull View view) {
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams) view.getLayoutParams();
        if (((ViewGroup$MarginLayoutParams) recyclerView$LayoutParams).width != -1 || ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParams).height != -1) {
            throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(@NonNull View view) {
    }
}
