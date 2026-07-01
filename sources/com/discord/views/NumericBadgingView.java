package com.discord.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.font.FontUtils;
import com.discord.views.CutoutView;
import d0.z.d.Intrinsics3;

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

    /* JADX INFO: compiled from: NumericBadgingView.kt */
    public static final class a implements CutoutView.a {
        public final RectF a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f2831b;

        public a(RectF rectF, float f) {
            Intrinsics3.checkNotNullParameter(rectF, "badgeRect");
            this.a = rectF;
            this.f2831b = f;
        }

        @Override // com.discord.views.CutoutView.a
        public Path a(Context context, int i, int i2) {
            Intrinsics3.checkNotNullParameter(context, "context");
            RectF rectF = new RectF(0.0f, 0.0f, this.a.width(), this.a.height());
            if (AnimatableValueParser.U0(context)) {
                rectF.offset(i - this.a.width(), 0.0f);
            }
            float f = this.f2831b;
            rectF.inset(-f, -f);
            Path path = new Path();
            float fHeight = ((2 * this.f2831b) + this.a.height()) / 2.0f;
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
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics3.areEqual(this.a, aVar.a) && Float.compare(this.f2831b, aVar.f2831b) == 0;
        }

        public int hashCode() {
            RectF rectF = this.a;
            return Float.floatToIntBits(this.f2831b) + ((rectF != null ? rectF.hashCode() : 0) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("BadgeRectStyle(badgeRect=");
            sbU.append(this.a);
            sbU.append(", insetPx=");
            sbU.append(this.f2831b);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NumericBadgingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
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
        int[] iArr = R.a.NumericBadgingView;
        Intrinsics3.checkNotNullExpressionValue(iArr, "R.styleable.NumericBadgingView");
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        paint.setColor(typedArrayObtainStyledAttributes.getColor(0, 0));
        if (paint.getColor() == 0) {
            paint.setColor(ContextCompat.getColor(context, R.color.status_red_500));
        }
        paint2.setColor(typedArrayObtainStyledAttributes.getColor(1, 0));
        if (paint2.getColor() == 0) {
            paint2.setColor(ContextCompat.getColor(context, R.color.white));
        }
        paint2.setTypeface(FontUtils.INSTANCE.getThemedFont(context, R.attr.font_primary_semibold));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // com.discord.views.CutoutView, android.view.View
    public void draw(Canvas canvas) {
        Intrinsics3.checkNotNullParameter(canvas, "canvas");
        super.draw(canvas);
        if (this.badgeString.length() == 0) {
            return;
        }
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        float measuredWidth = AnimatableValueParser.U0(context) ? getMeasuredWidth() - (this.badgeRect.width() / 2.0f) : this.badgeRect.width() / 2.0f;
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
            setStyle(CutoutView.a.d.a);
            return;
        }
        this.badgeString = number >= 100 ? "99+" : String.valueOf(number);
        float textSize = this.textPaint.getTextSize() + this.badgeTextPaddingVerticalPx;
        float f = textSize / 2.0f;
        float fMeasureText = number >= 10 ? (this.textPaint.measureText(this.badgeString) + textSize) / 2.0f : f;
        this.badgeRect.set(-fMeasureText, -f, fMeasureText, f);
        setStyle(new a(this.badgeRect, this.badgeInsetSizePx));
        invalidate();
    }
}
