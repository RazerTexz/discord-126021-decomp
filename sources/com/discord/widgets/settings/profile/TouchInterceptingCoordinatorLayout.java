package com.discord.widgets.settings.profile;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TouchInterceptingCoordinatorLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TouchInterceptingCoordinatorLayout extends CoordinatorLayout {
    private Function1<? super MotionEvent, Boolean> onInterceptTouchEvent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TouchInterceptingCoordinatorLayout(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
    }

    public final Function1<MotionEvent, Boolean> getOnInterceptTouchEvent() {
        return this.onInterceptTouchEvent;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Function1<? super MotionEvent, Boolean> function1 = this.onInterceptTouchEvent;
        return function1 != null ? function1.invoke(event).booleanValue() : super.onInterceptTouchEvent(event);
    }

    public final void setOnInterceptTouchEvent(Function1<? super MotionEvent, Boolean> function1) {
        this.onInterceptTouchEvent = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TouchInterceptingCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TouchInterceptingCoordinatorLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TouchInterceptingCoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TouchInterceptingCoordinatorLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
