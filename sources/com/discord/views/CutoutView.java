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
import com.discord.C5419R;
import com.discord.utilities.dimen.DimenUtils;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: CutoutView.kt */
/* JADX INFO: loaded from: classes2.dex */
public class CutoutView extends FrameLayout {

    /* JADX INFO: renamed from: j */
    public static final int f19050j = DimenUtils.dpToPixels(14);

    /* JADX INFO: renamed from: k */
    public static final int f19051k = DimenUtils.dpToPixels(8);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public InterfaceC7075a style;

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
        C12238m.checkNotNullParameter(context, "context");
        this.style = InterfaceC7075a.d.f19062a;
        this.isCutoutEnabled = true;
        setWillNotDraw(false);
        int[] iArr = C5419R.a.CutoutView;
        C12238m.checkNotNullExpressionValue(iArr, "R.styleable.CutoutView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        if (typedArrayObtainStyledAttributes.getInt(2, 0) == 1) {
            setStyle(new InterfaceC7075a.a(typedArrayObtainStyledAttributes.getDimensionPixelSize(1, f19050j), typedArrayObtainStyledAttributes.getDimensionPixelSize(0, f19051k)));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Path path;
        C12238m.checkNotNullParameter(canvas, "canvas");
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

    public final InterfaceC7075a getStyle() {
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
                setStyle(new InterfaceC7075a.a(0, 0, 3));
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
        InterfaceC7075a interfaceC7075a = this.style;
        Context context = getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        this.drawBounds = interfaceC7075a.mo8543a(context, measuredWidth, measuredHeight);
    }

    public final void setCutoutEnabled(boolean z2) {
        if (this.isCutoutEnabled != z2) {
            this.isCutoutEnabled = z2;
            invalidate();
        }
    }

    public final void setStyle(InterfaceC7075a interfaceC7075a) {
        C12238m.checkNotNullParameter(interfaceC7075a, "value");
        this.style = interfaceC7075a;
        if (this.lastWidth <= 0 || this.lastHeight <= 0) {
            return;
        }
        Context context = getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        this.drawBounds = interfaceC7075a.mo8543a(context, this.lastWidth, this.lastHeight);
        invalidate();
    }

    /* JADX INFO: renamed from: com.discord.views.CutoutView$a */
    /* JADX INFO: compiled from: CutoutView.kt */
    public interface InterfaceC7075a {

        /* JADX INFO: renamed from: com.discord.views.CutoutView$a$b */
        /* JADX INFO: compiled from: CutoutView.kt */
        public static final class b implements InterfaceC7075a {

            /* JADX INFO: renamed from: a */
            public final int f19059a;

            /* JADX INFO: renamed from: b */
            public final int f19060b;

            public b(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
                this.f19059a = i;
                this.f19060b = i2;
            }

            @Override // com.discord.views.CutoutView.InterfaceC7075a
            /* JADX INFO: renamed from: a */
            public Path mo8543a(Context context, int i, int i2) {
                C12238m.checkNotNullParameter(context, "context");
                float f = i;
                int i3 = this.f19059a;
                float f2 = i3 - (f / 2.0f);
                float f3 = i3 * 2.0f;
                float f4 = -f2;
                float f5 = i2 + f2;
                if (C1460d.m478U0(context)) {
                    float f6 = f - this.f19060b;
                    RectF rectF = new RectF(f6, f4, f3 + f6, f5);
                    Path path = new Path();
                    path.moveTo(f4, f4);
                    path.arcTo(rectF, 270.0f, -180.0f);
                    path.lineTo(f4, f5);
                    path.close();
                    return path;
                }
                float f7 = this.f19060b;
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
                return this.f19059a == bVar.f19059a && this.f19060b == bVar.f19060b;
            }

            public int hashCode() {
                return (this.f19059a * 31) + this.f19060b;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("End(cutCurveRadiusPx=");
                sbM833U.append(this.f19059a);
                sbM833U.append(", cutDistanceInwardFromEdgePx=");
                return C1643a.m814B(sbM833U, this.f19060b, ")");
            }
        }

        /* JADX INFO: renamed from: com.discord.views.CutoutView$a$c */
        /* JADX INFO: compiled from: CutoutView.kt */
        public static final class c implements InterfaceC7075a {

            /* JADX INFO: renamed from: a */
            public final int f19061a;

            public c(int i) {
                this.f19061a = i;
            }

            @Override // com.discord.views.CutoutView.InterfaceC7075a
            /* JADX INFO: renamed from: a */
            public Path mo8543a(Context context, int i, int i2) {
                C12238m.checkNotNullParameter(context, "context");
                float f = this.f19061a;
                Resources resources = context.getResources();
                C12238m.checkNotNullExpressionValue(resources, "context.resources");
                float f2 = f * resources.getDisplayMetrics().density;
                float f3 = i2;
                float f4 = f3 / 2.0f;
                if (C1460d.m478U0(context)) {
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
                    return (obj instanceof c) && this.f19061a == ((c) obj).f19061a;
                }
                return true;
            }

            public int hashCode() {
                return this.f19061a;
            }

            public String toString() {
                return C1643a.m814B(C1643a.m833U("EndOverlap(offsetDp="), this.f19061a, ")");
            }
        }

        /* JADX INFO: renamed from: com.discord.views.CutoutView$a$d */
        /* JADX INFO: compiled from: CutoutView.kt */
        public static final class d implements InterfaceC7075a {

            /* JADX INFO: renamed from: a */
            public static final d f19062a = new d();

            @Override // com.discord.views.CutoutView.InterfaceC7075a
            /* JADX INFO: renamed from: a */
            public Path mo8543a(Context context, int i, int i2) {
                C12238m.checkNotNullParameter(context, "context");
                return null;
            }
        }

        /* JADX INFO: renamed from: a */
        Path mo8543a(Context context, int i, int i2);

        /* JADX INFO: renamed from: com.discord.views.CutoutView$a$a */
        /* JADX INFO: compiled from: CutoutView.kt */
        public static final class a implements InterfaceC7075a {

            /* JADX INFO: renamed from: a */
            public final int f19057a;

            /* JADX INFO: renamed from: b */
            public final int f19058b;

            public a() {
                int i = CutoutView.f19050j;
                int i2 = CutoutView.f19051k;
                this.f19057a = i;
                this.f19058b = i2;
            }

            @Override // com.discord.views.CutoutView.InterfaceC7075a
            /* JADX INFO: renamed from: a */
            public Path mo8543a(Context context, int i, int i2) {
                C12238m.checkNotNullParameter(context, "context");
                Path path = new Path();
                path.addRect(0.0f, 0.0f, i, i2, Path.Direction.CW);
                Path path2 = new Path();
                path2.addCircle(C1460d.m478U0(context) ? i - this.f19058b : this.f19058b, this.f19058b, this.f19057a, Path.Direction.CW);
                Path path3 = new Path(path);
                path3.op(path2, Path.Op.DIFFERENCE);
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
                return this.f19057a == aVar.f19057a && this.f19058b == aVar.f19058b;
            }

            public int hashCode() {
                return (this.f19057a * 31) + this.f19058b;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("CircularBadge(badgeRadius=");
                sbM833U.append(this.f19057a);
                sbM833U.append(", inset=");
                return C1643a.m814B(sbM833U, this.f19058b, ")");
            }

            public a(int i, int i2, int i3) {
                i = (i3 & 1) != 0 ? CutoutView.f19050j : i;
                i2 = (i3 & 2) != 0 ? CutoutView.f19051k : i2;
                this.f19057a = i;
                this.f19058b = i2;
            }

            public a(@Px int i, @Px int i2) {
                this.f19057a = i;
                this.f19058b = i2;
            }
        }
    }
}
