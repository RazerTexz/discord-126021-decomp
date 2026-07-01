package com.discord.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.discord.R$a;
import com.discord.utilities.dimen.DimenUtils;
import d0.z.d.m;

/* JADX INFO: compiled from: CutoutView.kt */
/* JADX INFO: loaded from: classes2.dex */
public class CutoutView extends FrameLayout {
    public static final int j = DimenUtils.dpToPixels(14);
    public static final int k = DimenUtils.dpToPixels(8);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public CutoutView$a style;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public boolean isCutoutEnabled;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public Path drawBounds;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public int lastWidth;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public int lastHeight;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CutoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        this.style = CutoutView$a$d.a;
        this.isCutoutEnabled = true;
        setWillNotDraw(false);
        int[] iArr = R$a.CutoutView;
        m.checkNotNullExpressionValue(iArr, "R.styleable.CutoutView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        if (typedArrayObtainStyledAttributes.getInt(2, 0) == 1) {
            setStyle(new CutoutView$a$a(typedArrayObtainStyledAttributes.getDimensionPixelSize(1, j), typedArrayObtainStyledAttributes.getDimensionPixelSize(0, k)));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Path path;
        m.checkNotNullParameter(canvas, "canvas");
        int iSave = canvas.save();
        try {
            if (this.isCutoutEnabled && (path = this.drawBounds) != null) {
                canvas.clipPath(path);
            }
            super.draw(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public final CutoutView$a getStyle() {
        return this.style;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (isInEditMode()) {
            if (getChildCount() == 0) {
                View view = new View(getContext());
                view.setBackgroundColor((int) 4278255360L);
                addView(view);
                setStyle(new CutoutView$a$a(0, 0, 3));
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth == this.lastWidth && measuredHeight == this.lastHeight && this.drawBounds != null) {
            return;
        }
        this.lastWidth = measuredWidth;
        this.lastHeight = measuredHeight;
        CutoutView$a cutoutView$a = this.style;
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        this.drawBounds = cutoutView$a.a(context, measuredWidth, measuredHeight);
    }

    public final void setCutoutEnabled(boolean z2) {
        if (this.isCutoutEnabled != z2) {
            this.isCutoutEnabled = z2;
            invalidate();
        }
    }

    public final void setStyle(CutoutView$a cutoutView$a) {
        m.checkNotNullParameter(cutoutView$a, "value");
        this.style = cutoutView$a;
        if (this.lastWidth <= 0 || this.lastHeight <= 0) {
            return;
        }
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        this.drawBounds = cutoutView$a.a(context, this.lastWidth, this.lastHeight);
        invalidate();
    }
}
