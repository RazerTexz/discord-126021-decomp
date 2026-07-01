package com.discord.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.IntRange;
import androidx.annotation.Px;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.utilities.dimen.DimenUtils;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: CutoutView.kt */
/* JADX INFO: loaded from: classes2.dex */
public class CutoutView extends FrameLayout {
    public static final int j = DimenUtils.dpToPixels(14);
    public static final int k = DimenUtils.dpToPixels(8);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public a style;

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
        Intrinsics3.checkNotNullParameter(context, "context");
        this.style = a.d.a;
        this.isCutoutEnabled = true;
        setWillNotDraw(false);
        int[] iArr = R.a.CutoutView;
        Intrinsics3.checkNotNullExpressionValue(iArr, "R.styleable.CutoutView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        if (typedArrayObtainStyledAttributes.getInt(2, 0) == 1) {
            setStyle(new a.C0233a(typedArrayObtainStyledAttributes.getDimensionPixelSize(1, j), typedArrayObtainStyledAttributes.getDimensionPixelSize(0, k)));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Path path;
        Intrinsics3.checkNotNullParameter(canvas, "canvas");
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

    public final a getStyle() {
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
                setStyle(new a.C0233a(0, 0, 3));
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
        a aVar = this.style;
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        this.drawBounds = aVar.a(context, measuredWidth, measuredHeight);
    }

    public final void setCutoutEnabled(boolean z2) {
        if (this.isCutoutEnabled != z2) {
            this.isCutoutEnabled = z2;
            invalidate();
        }
    }

    public final void setStyle(a aVar) {
        Intrinsics3.checkNotNullParameter(aVar, "value");
        this.style = aVar;
        if (this.lastWidth <= 0 || this.lastHeight <= 0) {
            return;
        }
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        this.drawBounds = aVar.a(context, this.lastWidth, this.lastHeight);
        invalidate();
    }

    /* JADX INFO: compiled from: CutoutView.kt */
    public interface a {

        /* JADX INFO: compiled from: CutoutView.kt */
        public static final class b implements a {
            public final int a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f2827b;

            public b(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
                this.a = i;
                this.f2827b = i2;
            }

            @Override // com.discord.views.CutoutView.a
            public Path a(Context context, int i, int i2) {
                Intrinsics3.checkNotNullParameter(context, "context");
                float f = i;
                int i3 = this.a;
                float f2 = i3 - (f / 2.0f);
                float f3 = i3 * 2.0f;
                float f4 = -f2;
                float f5 = i2 + f2;
                if (AnimatableValueParser.U0(context)) {
                    float f6 = f - this.f2827b;
                    RectF rectF = new RectF(f6, f4, f3 + f6, f5);
                    Path path = new Path();
                    path.moveTo(f4, f4);
                    path.arcTo(rectF, 270.0f, -180.0f);
                    path.lineTo(f4, f5);
                    path.close();
                    return path;
                }
                float f7 = this.f2827b;
                RectF rectF2 = new RectF(f7 - f3, f4, f7, f5);
                Path path2 = new Path();
                float f8 = f + f2;
                path2.moveTo(f8, f4);
                path2.arcTo(rectF2, 270.0f, 180.0f);
                path2.lineTo(f8, f5);
                path2.close();
                return path2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return this.a == bVar.a && this.f2827b == bVar.f2827b;
            }

            public int hashCode() {
                return (this.a * 31) + this.f2827b;
            }

            public String toString() {
                StringBuilder sbU = outline.U("End(cutCurveRadiusPx=");
                sbU.append(this.a);
                sbU.append(", cutDistanceInwardFromEdgePx=");
                return outline.B(sbU, this.f2827b, ")");
            }
        }

        /* JADX INFO: compiled from: CutoutView.kt */
        public static final class c implements a {
            public final int a;

            public c(int i) {
                this.a = i;
            }

            @Override // com.discord.views.CutoutView.a
            public Path a(Context context, int i, int i2) {
                Intrinsics3.checkNotNullParameter(context, "context");
                float f = this.a;
                Resources resources = context.getResources();
                Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
                float f2 = f * resources.getDisplayMetrics().density;
                float f3 = i2;
                float f4 = f3 / 2.0f;
                if (AnimatableValueParser.U0(context)) {
                    Path path = new Path();
                    float f5 = i + f2;
                    path.moveTo(0.0f, 0.0f);
                    path.lineTo(f5, 0.0f);
                    path.arcTo(new RectF(f5 - f4, 0.0f, f5 + f4, f3), 270.0f, -180.0f);
                    path.lineTo(0.0f, f3);
                    path.lineTo(0.0f, 0.0f);
                    return path;
                }
                Path path2 = new Path();
                float f6 = -f2;
                float f7 = i;
                path2.moveTo(f7, 0.0f);
                path2.lineTo(f6, 0.0f);
                path2.arcTo(new RectF(f6 - f4, 0.0f, f6 + f4, f3), 270.0f, 180.0f);
                path2.lineTo(f7, f3);
                path2.lineTo(f7, 0.0f);
                return path2;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof c) && this.a == ((c) obj).a;
                }
                return true;
            }

            public int hashCode() {
                return this.a;
            }

            public String toString() {
                return outline.B(outline.U("EndOverlap(offsetDp="), this.a, ")");
            }
        }

        /* JADX INFO: compiled from: CutoutView.kt */
        public static final class d implements a {
            public static final d a = new d();

            @Override // com.discord.views.CutoutView.a
            public Path a(Context context, int i, int i2) {
                Intrinsics3.checkNotNullParameter(context, "context");
                return null;
            }
        }

        Path a(Context context, int i, int i2);

        /* JADX INFO: renamed from: com.discord.views.CutoutView$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CutoutView.kt */
        public static final class C0233a implements a {
            public final int a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f2826b;

            public C0233a() {
                int i = CutoutView.j;
                int i2 = CutoutView.k;
                this.a = i;
                this.f2826b = i2;
            }

            @Override // com.discord.views.CutoutView.a
            public Path a(Context context, int i, int i2) {
                Intrinsics3.checkNotNullParameter(context, "context");
                Path path = new Path();
                path.addRect(0.0f, 0.0f, i, i2, Path.Direction.CW);
                Path path2 = new Path();
                path2.addCircle(AnimatableValueParser.U0(context) ? i - this.f2826b : this.f2826b, this.f2826b, this.a, Path.Direction.CW);
                Path path3 = new Path(path);
                path3.op(path2, Path.Op.DIFFERENCE);
                return path3;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0233a)) {
                    return false;
                }
                C0233a c0233a = (C0233a) obj;
                return this.a == c0233a.a && this.f2826b == c0233a.f2826b;
            }

            public int hashCode() {
                return (this.a * 31) + this.f2826b;
            }

            public String toString() {
                StringBuilder sbU = outline.U("CircularBadge(badgeRadius=");
                sbU.append(this.a);
                sbU.append(", inset=");
                return outline.B(sbU, this.f2826b, ")");
            }

            public C0233a(int i, int i2, int i3) {
                i = (i3 & 1) != 0 ? CutoutView.j : i;
                i2 = (i3 & 2) != 0 ? CutoutView.k : i2;
                this.a = i;
                this.f2826b = i2;
            }

            public C0233a(@Px int i, @Px int i2) {
                this.a = i;
                this.f2826b = i2;
            }
        }
    }
}
