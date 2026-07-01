package com.discord.utilities.views;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ContentResizingCoordinatorLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContentResizingCoordinatorLayout$onMeasure$3 extends o implements Function2<Integer, Integer, Unit> {
    public final /* synthetic */ int $heightMeasureSpec;
    public final /* synthetic */ int $widthMeasureSpec;
    public final /* synthetic */ ContentResizingCoordinatorLayout this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentResizingCoordinatorLayout$onMeasure$3(ContentResizingCoordinatorLayout contentResizingCoordinatorLayout, int i, int i2) {
        super(2);
        this.this$0 = contentResizingCoordinatorLayout;
        this.$widthMeasureSpec = i;
        this.$heightMeasureSpec = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
        invoke(num.intValue(), num2.intValue());
        return Unit.a;
    }

    public final void invoke(int i, int i2) {
        ContentResizingCoordinatorLayout contentResizingCoordinatorLayout = this.this$0;
        ContentResizingCoordinatorLayout.access$updateContentLayoutParams(contentResizingCoordinatorLayout, ContentResizingCoordinatorLayout.access$getCurrentVerticalOffset$p(contentResizingCoordinatorLayout), ContentResizingCoordinatorLayout.access$getAppBarLayout$p(this.this$0).getMeasuredHeight(), this.this$0.getMeasuredHeight(), this.$widthMeasureSpec, this.$heightMeasureSpec);
    }
}
