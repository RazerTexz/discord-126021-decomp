package com.discord.utilities.views;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout$OnOffsetChangedListener;

/* JADX INFO: compiled from: ContentResizingCoordinatorLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContentResizingCoordinatorLayout$onMeasure$2 implements AppBarLayout$OnOffsetChangedListener {
    public final /* synthetic */ int $heightMeasureSpec;
    public final /* synthetic */ int $widthMeasureSpec;
    public final /* synthetic */ ContentResizingCoordinatorLayout this$0;

    public ContentResizingCoordinatorLayout$onMeasure$2(ContentResizingCoordinatorLayout contentResizingCoordinatorLayout, int i, int i2) {
        this.this$0 = contentResizingCoordinatorLayout;
        this.$widthMeasureSpec = i;
        this.$heightMeasureSpec = i2;
    }

    @Override // com.google.android.material.appbar.AppBarLayout$OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout$BaseOnOffsetChangedListener
    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        ContentResizingCoordinatorLayout.access$setCurrentVerticalOffset$p(this.this$0, i);
        ContentResizingCoordinatorLayout contentResizingCoordinatorLayout = this.this$0;
        ContentResizingCoordinatorLayout.access$updateContentLayoutParams(contentResizingCoordinatorLayout, i, ContentResizingCoordinatorLayout.access$getAppBarLayout$p(contentResizingCoordinatorLayout).getMeasuredHeight(), this.this$0.getMeasuredHeight(), this.$widthMeasureSpec, this.$heightMeasureSpec);
    }
}
