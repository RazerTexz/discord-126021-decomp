package androidx.viewpager2.adapter;

import android.view.View;
import android.view.View$OnLayoutChangeListener;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class FragmentStateAdapter$1 implements View$OnLayoutChangeListener {
    public final /* synthetic */ FragmentStateAdapter this$0;
    public final /* synthetic */ FrameLayout val$container;
    public final /* synthetic */ FragmentViewHolder val$holder;

    public FragmentStateAdapter$1(FragmentStateAdapter fragmentStateAdapter, FrameLayout frameLayout, FragmentViewHolder fragmentViewHolder) {
        this.this$0 = fragmentStateAdapter;
        this.val$container = frameLayout;
        this.val$holder = fragmentViewHolder;
    }

    @Override // android.view.View$OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.val$container.getParent() != null) {
            this.val$container.removeOnLayoutChangeListener(this);
            this.this$0.placeFragmentInViewHolder(this.val$holder);
        }
    }
}
