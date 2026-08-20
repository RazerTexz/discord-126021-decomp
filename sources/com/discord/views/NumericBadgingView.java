package com.discord.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.discord.C5419R;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.font.FontUtils;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: NumericBadgingView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NumericBadgingView extends CutoutView {

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public float badgeTextSizePx;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public int badgeTextPaddingVerticalPx;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public float badgeInsetSizePx;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public RectF badgeRect;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public String badgeString;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public final Paint badgePaint;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    public final Paint textPaint;

    /* JADX INFO: renamed from: com.discord.views.NumericBadgingView$a */
    /* JADX INFO: compiled from: NumericBadgingView.kt */
    public static final class C7079a implements CutoutView.InterfaceC7075a {

        /* JADX INFO: renamed from: a */
        public final RectF f19090a;

        /* JADX INFO: renamed from: b */
        public final float f19091b;

        public C7079a(RectF rectF, float f) {
            C12238m.checkNotNullParameter(rectF, "badgeRect");
            this.f19090a = rectF;
            this.f19091b = f;
        }

        @Override // com.discord.views.CutoutView.InterfaceC7075a
        /* JADX INFO: renamed from: a */
        public Path mo8543a(Context context, int i, int i2) {
            C12238m.checkNotNullParameter(context, "context");
            RectF rectF = new RectF(0.0f, 0.0f, this.f19090a.width(), this.f19090a.height());
            if (C1460d.m478U0(context)) {
                rectF.offset(i - this.f19090a.width(), 0.0f);
            }
            float f = this.f19091b;
            rectF.inset(-f, -f);
            Path path = new Path();
            float fHeight = ((2 * this.f19091b) + this.f19090a.height()) / 2.0f;
            path.addRoundRect(rectF, fHeight, fHeight, Path.Direction.CW);
            Path path2 = new Path();
            path2.addRect(0.0f, 0.0f, i, i2, Path.Direction.CW);
            Path path3 = new Path(path2);
            path3.op(path, Path.Op.DIFFERENCE);
            return path3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C7079a)) {
                return false;
            }
            C7079a c7079a = (C7079a) obj;
            return C12238m.areEqual(this.f19090a, c7079a.f19090a) && Float.compare(this.f19091b, c7079a.f19091b) == 0;
        }

        public int hashCode() {
            RectF rectF = this.f19090a;
            return Float.floatToIntBits(this.f19091b) + ((rectF != null ? rectF.hashCode() : 0) * 31);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("BadgeRectStyle(badgeRect=");
            sbM833U.append(this.f19090a);
            sbM833U.append(", insetPx=");
            sbM833U.append(this.f19091b);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NumericBadgingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
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
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setTextSize(this.badgeTextSizePx);
        paint2.setColor((int) 4294967295L);
        this.textPaint = paint2;
        setWillNotDraw(false);
        int[] iArr = C5419R.a.NumericBadgingView;
        C12238m.checkNotNullExpressionValue(iArr, "R.styleable.NumericBadgingView");
        Context context2 = getContext();
        C12238m.checkNotNullExpressionValue(context2, "context");
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr);
        C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        paint.setColor(typedArrayObtainStyledAttributes.getColor(0, 0));
        if (paint.getColor() == 0) {
            paint.setColor(ContextCompat.getColor(context, C5419R.color.status_red_500));
        }
        paint2.setColor(typedArrayObtainStyledAttributes.getColor(1, 0));
        if (paint2.getColor() == 0) {
            paint2.setColor(ContextCompat.getColor(context, C5419R.color.white));
        }
        paint2.setTypeface(FontUtils.INSTANCE.getThemedFont(context, C5419R.attr.font_primary_semibold));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // com.discord.views.CutoutView, android.view.View
    public void draw(Canvas canvas) {
        C12238m.checkNotNullParameter(canvas, "canvas");
        super.draw(canvas);
        if (this.badgeString.length() == 0) {
            return;
        }
        Context context = getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        float measuredWidth = C1460d.m478U0(context) ? getMeasuredWidth() - (this.badgeRect.width() / 2.0f) : this.badgeRect.width() / 2.0f;
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
            setStyle(CutoutView.InterfaceC7075a.d.f19062a);
            return;
        }
        this.badgeString = number >= 100 ? "99+" : String.valueOf(number);
        float textSize = this.textPaint.getTextSize() + this.badgeTextPaddingVerticalPx;
        float f = textSize / 2.0f;
        float fMeasureText = number >= 10 ? (this.textPaint.measureText(this.badgeString) + textSize) / 2.0f : f;
        this.badgeRect.set(-fMeasureText, -f, fMeasureText, f);
        setStyle(new C7079a(this.badgeRect, this.badgeInsetSizePx));
        invalidate();
    }
}
