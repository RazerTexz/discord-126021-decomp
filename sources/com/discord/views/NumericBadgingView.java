package com.discord.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint$Align;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import b.c.a.a0.d;
import com.discord.R$a;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.font.FontUtils;
import d0.z.d.m;

/* JADX INFO: compiled from: NumericBadgingView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NumericBadgingView extends CutoutView {

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public float badgeTextSizePx;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public int badgeTextPaddingVerticalPx;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    public float badgeInsetSizePx;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public RectF badgeRect;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public String badgeString;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public final Paint badgePaint;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    public final Paint textPaint;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NumericBadgingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        this.badgeTextSizePx = DimenUtils.dpToPixels(12);
        this.badgeTextPaddingVerticalPx = DimenUtils.dpToPixels(8);
        this.badgeInsetSizePx = DimenUtils.dpToPixels(4);
        this.badgeRect = new RectF();
        this.badgeString = "";
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor((int) 4294901760L);
        this.badgePaint = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setTextAlign(Paint$Align.CENTER);
        paint2.setTextSize(this.badgeTextSizePx);
        paint2.setColor((int) 4294967295L);
        this.textPaint = paint2;
        setWillNotDraw(false);
        int[] iArr = R$a.NumericBadgingView;
        m.checkNotNullExpressionValue(iArr, "R.styleable.NumericBadgingView");
        Context context2 = getContext();
        m.checkNotNullExpressionValue(context2, "context");
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr);
        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        paint.setColor(typedArrayObtainStyledAttributes.getColor(0, 0));
        if (paint.getColor() == 0) {
            paint.setColor(ContextCompat.getColor(context, 2131100382));
        }
        paint2.setColor(typedArrayObtainStyledAttributes.getColor(1, 0));
        if (paint2.getColor() == 0) {
            paint2.setColor(ContextCompat.getColor(context, 2131100487));
        }
        paint2.setTypeface(FontUtils.INSTANCE.getThemedFont(context, 2130969396));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // com.discord.views.CutoutView, android.view.View
    public void draw(Canvas canvas) {
        m.checkNotNullParameter(canvas, "canvas");
        super.draw(canvas);
        if (this.badgeString.length() == 0) {
            return;
        }
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        float measuredWidth = d.U0(context) ? getMeasuredWidth() - (this.badgeRect.width() / 2.0f) : this.badgeRect.width() / 2.0f;
        float fHeight = this.badgeRect.height() / 2.0f;
        int iSave = canvas.save();
        canvas.translate(measuredWidth, fHeight);
        try {
            float fHeight2 = this.badgeRect.height() / 2.0f;
            canvas.drawRoundRect(this.badgeRect, fHeight2, fHeight2, this.badgePaint);
            canvas.drawText(this.badgeString, 0.0f, -((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    @Override // com.discord.views.CutoutView, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (isInEditMode()) {
            setBadgeNumber(42);
        }
    }

    public final void setBadgeNumber(int number) {
        if (number <= 0) {
            this.badgeString = "";
            setStyle(CutoutView$a$d.a);
            return;
        }
        this.badgeString = number >= 100 ? "99+" : String.valueOf(number);
        float textSize = this.textPaint.getTextSize() + this.badgeTextPaddingVerticalPx;
        float f = textSize / 2.0f;
        float fMeasureText = number >= 10 ? (this.textPaint.measureText(this.badgeString) + textSize) / 2.0f : f;
        this.badgeRect.set(-fMeasureText, -f, fMeasureText, f);
        setStyle(new NumericBadgingView$a(this.badgeRect, this.badgeInsetSizePx));
        invalidate();
    }
}
