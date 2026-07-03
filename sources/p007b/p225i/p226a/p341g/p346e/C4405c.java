package p007b.p225i.p226a.p341g.p346e;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

/* JADX INFO: renamed from: b.i.a.g.e.c */
/* JADX INFO: compiled from: BorderDrawable.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class C4405c extends Drawable {

    /* JADX INFO: renamed from: b */
    @NonNull
    public final Paint f11629b;

    /* JADX INFO: renamed from: h */
    @Dimension
    public float f11635h;

    /* JADX INFO: renamed from: i */
    @ColorInt
    public int f11636i;

    /* JADX INFO: renamed from: j */
    @ColorInt
    public int f11637j;

    /* JADX INFO: renamed from: k */
    @ColorInt
    public int f11638k;

    /* JADX INFO: renamed from: l */
    @ColorInt
    public int f11639l;

    /* JADX INFO: renamed from: m */
    @ColorInt
    public int f11640m;

    /* JADX INFO: renamed from: o */
    public ShapeAppearanceModel f11642o;

    /* JADX INFO: renamed from: p */
    @Nullable
    public ColorStateList f11643p;

    /* JADX INFO: renamed from: a */
    public final ShapeAppearancePathProvider f11628a = ShapeAppearancePathProvider.getInstance();

    /* JADX INFO: renamed from: c */
    public final Path f11630c = new Path();

    /* JADX INFO: renamed from: d */
    public final Rect f11631d = new Rect();

    /* JADX INFO: renamed from: e */
    public final RectF f11632e = new RectF();

    /* JADX INFO: renamed from: f */
    public final RectF f11633f = new RectF();

    /* JADX INFO: renamed from: g */
    public final b f11634g = new b(null);

    /* JADX INFO: renamed from: n */
    public boolean f11641n = true;

    /* JADX INFO: renamed from: b.i.a.g.e.c$b */
    /* JADX INFO: compiled from: BorderDrawable.java */
    public class b extends Drawable.ConstantState {
        public b(a aVar) {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return C4405c.this;
        }
    }

    public C4405c(ShapeAppearanceModel shapeAppearanceModel) {
        this.f11642o = shapeAppearanceModel;
        Paint paint = new Paint(1);
        this.f11629b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public RectF m6083a() {
        this.f11633f.set(getBounds());
        return this.f11633f;
    }

    /* JADX INFO: renamed from: b */
    public void m6084b(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f11640m = colorStateList.getColorForState(getState(), this.f11640m);
        }
        this.f11643p = colorStateList;
        this.f11641n = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f11641n) {
            Paint paint = this.f11629b;
            Rect rect = this.f11631d;
            copyBounds(rect);
            float fHeight = this.f11635h / rect.height();
            paint.setShader(new LinearGradient(0.0f, rect.top, 0.0f, rect.bottom, new int[]{ColorUtils.compositeColors(this.f11636i, this.f11640m), ColorUtils.compositeColors(this.f11637j, this.f11640m), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.f11637j, 0), this.f11640m), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.f11639l, 0), this.f11640m), ColorUtils.compositeColors(this.f11639l, this.f11640m), ColorUtils.compositeColors(this.f11638k, this.f11640m)}, new float[]{0.0f, fHeight, 0.5f, 0.5f, 1.0f - fHeight, 1.0f}, Shader.TileMode.CLAMP));
            this.f11641n = false;
        }
        float strokeWidth = this.f11629b.getStrokeWidth() / 2.0f;
        copyBounds(this.f11631d);
        this.f11632e.set(this.f11631d);
        float fMin = Math.min(this.f11642o.getTopLeftCornerSize().getCornerSize(m6083a()), this.f11632e.width() / 2.0f);
        if (this.f11642o.isRoundRect(m6083a())) {
            this.f11632e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f11632e, fMin, fMin, this.f11629b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f11634g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f11635h > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.f11642o.isRoundRect(m6083a())) {
            outline.setRoundRect(getBounds(), this.f11642o.getTopLeftCornerSize().getCornerSize(m6083a()));
            return;
        }
        copyBounds(this.f11631d);
        this.f11632e.set(this.f11631d);
        this.f11628a.calculatePath(this.f11642o, 1.0f, this.f11632e, this.f11630c);
        if (this.f11630c.isConvex()) {
            outline.setConvexPath(this.f11630c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        if (!this.f11642o.isRoundRect(m6083a())) {
            return true;
        }
        int iRound = Math.round(this.f11635h);
        rect.set(iRound, iRound, iRound, iRound);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f11643p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f11641n = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f11643p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.f11640m)) != this.f11640m) {
            this.f11641n = true;
            this.f11640m = colorForState;
        }
        if (this.f11641n) {
            invalidateSelf();
        }
        return this.f11641n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, m76to = 255) int i) {
        this.f11629b.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f11629b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
