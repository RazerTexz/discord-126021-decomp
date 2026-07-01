package androidx.viewpager2.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Recycler;
import androidx.recyclerview.widget.RecyclerView$State;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager2$LinearLayoutManagerImpl extends LinearLayoutManager {
    public final /* synthetic */ ViewPager2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPager2$LinearLayoutManagerImpl(ViewPager2 viewPager2, Context context) {
        super(context);
        this.this$0 = viewPager2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void calculateExtraLayoutSpace(@NonNull RecyclerView$State recyclerView$State, @NonNull int[] iArr) {
        int offscreenPageLimit = this.this$0.getOffscreenPageLimit();
        if (offscreenPageLimit == -1) {
            super.calculateExtraLayoutSpace(recyclerView$State, iArr);
            return;
        }
        int pageSize = this.this$0.getPageSize() * offscreenPageLimit;
        iArr[0] = pageSize;
        iArr[1] = pageSize;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView$Recycler recyclerView$Recycler, @NonNull RecyclerView$State recyclerView$State, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(recyclerView$Recycler, recyclerView$State, accessibilityNodeInfoCompat);
        this.this$0.mAccessibilityProvider.onLmInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public boolean performAccessibilityAction(@NonNull RecyclerView$Recycler recyclerView$Recycler, @NonNull RecyclerView$State recyclerView$State, int i, @Nullable Bundle bundle) {
        return this.this$0.mAccessibilityProvider.handlesLmPerformAccessibilityAction(i) ? this.this$0.mAccessibilityProvider.onLmPerformAccessibilityAction(i) : super.performAccessibilityAction(recyclerView$Recycler, recyclerView$State, i, bundle);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z2, boolean z3) {
        return false;
    }
}
