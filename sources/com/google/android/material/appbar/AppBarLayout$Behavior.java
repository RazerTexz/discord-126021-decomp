package com.google.android.material.appbar;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes3.dex */
public class AppBarLayout$Behavior extends AppBarLayout$BaseBehavior<AppBarLayout> {
    public AppBarLayout$Behavior() {
    }

    @Override // b.i.a.g.a.c
    public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
        return super.getLeftAndRightOffset();
    }

    @Override // b.i.a.g.a.c
    public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
        return super.getTopAndBottomOffset();
    }

    @Override // b.i.a.g.a.c
    public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
        return super.isHorizontalOffsetEnabled();
    }

    @Override // b.i.a.g.a.c
    public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
        return super.isVerticalOffsetEnabled();
    }

    @Override // com.google.android.material.appbar.AppBarLayout$BaseBehavior
    public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i) {
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    @Override // com.google.android.material.appbar.AppBarLayout$BaseBehavior
    public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
        return super.onMeasureChild(coordinatorLayout, appBarLayout, i, i2, i3, i4);
    }

    @Override // com.google.android.material.appbar.AppBarLayout$BaseBehavior
    public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
    }

    @Override // com.google.android.material.appbar.AppBarLayout$BaseBehavior
    public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5, iArr);
    }

    @Override // com.google.android.material.appbar.AppBarLayout$BaseBehavior
    public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, Parcelable parcelable) {
        super.onRestoreInstanceState(coordinatorLayout, appBarLayout, parcelable);
    }

    @Override // com.google.android.material.appbar.AppBarLayout$BaseBehavior
    public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout) {
        return super.onSaveInstanceState(coordinatorLayout, appBarLayout);
    }

    @Override // com.google.android.material.appbar.AppBarLayout$BaseBehavior
    public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, View view2, int i, int i2) {
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i, i2);
    }

    @Override // com.google.android.material.appbar.AppBarLayout$BaseBehavior
    public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i) {
        super.onStopNestedScroll(coordinatorLayout, appBarLayout, view, i);
    }

    @Override // com.google.android.material.appbar.AppBarLayout$BaseBehavior
    public /* bridge */ /* synthetic */ void setDragCallback(@Nullable AppBarLayout$BaseBehavior$BaseDragCallback appBarLayout$BaseBehavior$BaseDragCallback) {
        super.setDragCallback(appBarLayout$BaseBehavior$BaseDragCallback);
    }

    @Override // b.i.a.g.a.c
    public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z2) {
        super.setHorizontalOffsetEnabled(z2);
    }

    @Override // b.i.a.g.a.c
    public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i) {
        return super.setLeftAndRightOffset(i);
    }

    @Override // b.i.a.g.a.c
    public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i) {
        return super.setTopAndBottomOffset(i);
    }

    @Override // b.i.a.g.a.c
    public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z2) {
        super.setVerticalOffsetEnabled(z2);
    }

    public AppBarLayout$Behavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
