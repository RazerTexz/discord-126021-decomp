package androidx.viewpager2.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager2$RecyclerViewImpl extends RecyclerView {
    public final /* synthetic */ ViewPager2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPager2$RecyclerViewImpl(@NonNull ViewPager2 viewPager2, Context context) {
        super(context);
        this.this$0 = viewPager2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    @RequiresApi(23)
    public CharSequence getAccessibilityClassName() {
        return this.this$0.mAccessibilityProvider.handlesRvGetAccessibilityClassName() ? this.this$0.mAccessibilityProvider.onRvGetAccessibilityClassName() : super.getAccessibilityClassName();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setFromIndex(this.this$0.mCurrentItem);
        accessibilityEvent.setToIndex(this.this$0.mCurrentItem);
        this.this$0.mAccessibilityProvider.onRvInitializeAccessibilityEvent(accessibilityEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.this$0.isUserInputEnabled() && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.this$0.isUserInputEnabled() && super.onTouchEvent(motionEvent);
    }
}
