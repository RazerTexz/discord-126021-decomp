package com.discord.utilities.view.rounded;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.utils.R$b;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RoundedCoordinatorLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RoundedCoordinatorLayout extends CoordinatorLayout {
    private final RoundedCornerViewCoordinator roundedViewCoordinator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedCoordinatorLayout(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        this.roundedViewCoordinator = new RoundedCornerViewCoordinator();
    }

    /* JADX INFO: renamed from: access$draw$s-747643027, reason: not valid java name */
    public static final /* synthetic */ void m22access$draw$s747643027(RoundedCoordinatorLayout roundedCoordinatorLayout, Canvas canvas) {
        super.draw(canvas);
    }

    private final void initialize(AttributeSet attrs) {
        RoundedCornerViewCoordinator roundedCornerViewCoordinator = this.roundedViewCoordinator;
        int[] iArr = R$b.RoundedCoordinatorLayout;
        m.checkNotNullExpressionValue(iArr, "R.styleable.RoundedCoordinatorLayout");
        roundedCornerViewCoordinator.initialize(this, attrs, iArr, R$b.RoundedCoordinatorLayout_topLeftRadius, R$b.RoundedCoordinatorLayout_topRightRadius, R$b.RoundedCoordinatorLayout_bottomLeftRadius, R$b.RoundedCoordinatorLayout_bottomRightRadius);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        m.checkNotNullParameter(canvas, "canvas");
        this.roundedViewCoordinator.draw(canvas, new RoundedCoordinatorLayout$draw$1(this));
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.roundedViewCoordinator.onSizeChanged(w, h);
    }

    public final void updateTopLeftRadius(float radius) {
        this.roundedViewCoordinator.updateRadius(this, radius, RoundedCornerViewCoordinator$Corner.TOP_LEFT);
    }

    public final void updateTopRightRadius(float radius) {
        this.roundedViewCoordinator.updateRadius(this, radius, RoundedCornerViewCoordinator$Corner.TOP_RIGHT);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        this.roundedViewCoordinator = new RoundedCornerViewCoordinator();
        initialize(attributeSet);
    }

    public /* synthetic */ RoundedCoordinatorLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedCoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        this.roundedViewCoordinator = new RoundedCornerViewCoordinator();
        initialize(attributeSet);
    }

    public /* synthetic */ RoundedCoordinatorLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
