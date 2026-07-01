package com.google.android.material.transition;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.Path;
import android.graphics.Path$Op;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region$Op;
import android.graphics.Shader$TileMode;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.transition.PathMotion;
import b.i.a.g.l.a;
import b.i.a.g.l.c;
import b.i.a.g.l.d;
import b.i.a.g.l.f;
import b.i.a.g.l.g;
import b.i.a.g.l.k;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class MaterialContainerTransform$d extends Drawable {
    public final MaterialContainerTransform$c A;
    public final a B;
    public final d C;
    public final boolean D;
    public final Paint E;
    public final Path F;
    public c G;
    public f H;
    public RectF I;
    public float J;
    public float K;
    public float L;
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f3087b;
    public final ShapeAppearanceModel c;
    public final float d;
    public final View e;
    public final RectF f;
    public final ShapeAppearanceModel g;
    public final float h;
    public final Paint i;
    public final Paint j;
    public final Paint k;
    public final Paint l;
    public final Paint m;
    public final g n;
    public final PathMeasure o;
    public final float p;
    public final float[] q;
    public final boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float f3088s;
    public final float t;
    public final boolean u;
    public final MaterialShapeDrawable v;
    public final RectF w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final RectF f3089x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final RectF f3090y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final RectF f3091z;

    public MaterialContainerTransform$d(PathMotion pathMotion, View view, RectF rectF, ShapeAppearanceModel shapeAppearanceModel, float f, View view2, RectF rectF2, ShapeAppearanceModel shapeAppearanceModel2, float f2, int i, int i2, int i3, int i4, boolean z2, boolean z3, a aVar, d dVar, MaterialContainerTransform$c materialContainerTransform$c, boolean z4, MaterialContainerTransform$a materialContainerTransform$a) {
        Paint paint = new Paint();
        this.i = paint;
        Paint paint2 = new Paint();
        this.j = paint2;
        Paint paint3 = new Paint();
        this.k = paint3;
        this.l = new Paint();
        Paint paint4 = new Paint();
        this.m = paint4;
        this.n = new g();
        this.q = new float[]{rectF.centerX(), rectF.top};
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.v = materialShapeDrawable;
        Paint paint5 = new Paint();
        this.E = paint5;
        this.F = new Path();
        this.a = view;
        this.f3087b = rectF;
        this.c = shapeAppearanceModel;
        this.d = f;
        this.e = view2;
        this.f = rectF2;
        this.g = shapeAppearanceModel2;
        this.h = f2;
        this.r = z2;
        this.u = z3;
        this.B = aVar;
        this.C = dVar;
        this.A = materialContainerTransform$c;
        this.D = z4;
        WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        this.f3088s = displayMetrics.widthPixels;
        this.t = displayMetrics.heightPixels;
        paint.setColor(i);
        paint2.setColor(i2);
        paint3.setColor(i3);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(0));
        materialShapeDrawable.setShadowCompatibilityMode(2);
        materialShapeDrawable.setShadowBitmapDrawingEnable(false);
        materialShapeDrawable.setShadowColor(-7829368);
        RectF rectF3 = new RectF(rectF);
        this.w = rectF3;
        this.f3089x = new RectF(rectF3);
        RectF rectF4 = new RectF(rectF3);
        this.f3090y = rectF4;
        this.f3091z = new RectF(rectF4);
        PointF pointFC = c(rectF);
        PointF pointFC2 = c(rectF2);
        PathMeasure pathMeasure = new PathMeasure(pathMotion.getPath(pointFC.x, pointFC.y, pointFC2.x, pointFC2.y), false);
        this.o = pathMeasure;
        this.p = pathMeasure.getLength();
        paint4.setStyle(Paint$Style.FILL);
        RectF rectF5 = k.a;
        paint4.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i4, i4, Shader$TileMode.CLAMP));
        paint5.setStyle(Paint$Style.STROKE);
        paint5.setStrokeWidth(10.0f);
        e(0.0f);
    }

    public static PointF c(RectF rectF) {
        return new PointF(rectF.centerX(), rectF.top);
    }

    public final void a(Canvas canvas) {
        d(canvas, this.k);
        Rect bounds = getBounds();
        RectF rectF = this.f3090y;
        k.h(canvas, bounds, rectF.left, rectF.top, this.H.f1634b, this.G.f1632b, new MaterialContainerTransform$d$b(this));
    }

    public final void b(Canvas canvas) {
        d(canvas, this.j);
        Rect bounds = getBounds();
        RectF rectF = this.w;
        k.h(canvas, bounds, rectF.left, rectF.top, this.H.a, this.G.a, new MaterialContainerTransform$d$a(this));
    }

    public final void d(Canvas canvas, Paint paint) {
        if (paint.getColor() == 0 || paint.getAlpha() <= 0) {
            return;
        }
        canvas.drawRect(getBounds(), paint);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.m.getAlpha() > 0) {
            canvas.drawRect(getBounds(), this.m);
        }
        int iSave = this.D ? canvas.save() : -1;
        if (this.u && this.J > 0.0f) {
            canvas.save();
            canvas.clipPath(this.n.a, Region$Op.DIFFERENCE);
            if (Build$VERSION.SDK_INT > 28) {
                ShapeAppearanceModel shapeAppearanceModel = this.n.e;
                if (shapeAppearanceModel.isRoundRect(this.I)) {
                    float cornerSize = shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.I);
                    canvas.drawRoundRect(this.I, cornerSize, cornerSize, this.l);
                } else {
                    canvas.drawPath(this.n.a, this.l);
                }
            } else {
                MaterialShapeDrawable materialShapeDrawable = this.v;
                RectF rectF = this.I;
                materialShapeDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                this.v.setElevation(this.J);
                this.v.setShadowVerticalOffset((int) this.K);
                this.v.setShapeAppearanceModel(this.n.e);
                this.v.draw(canvas);
            }
            canvas.restore();
        }
        g gVar = this.n;
        if (Build$VERSION.SDK_INT >= 23) {
            canvas.clipPath(gVar.a);
        } else {
            canvas.clipPath(gVar.f1635b);
            canvas.clipPath(gVar.c, Region$Op.UNION);
        }
        d(canvas, this.i);
        if (this.G.c) {
            b(canvas);
            a(canvas);
        } else {
            a(canvas);
            b(canvas);
        }
        if (this.D) {
            canvas.restoreToCount(iSave);
            RectF rectF2 = this.w;
            Path path = this.F;
            PointF pointFC = c(rectF2);
            if (this.L == 0.0f) {
                path.reset();
                path.moveTo(pointFC.x, pointFC.y);
            } else {
                path.lineTo(pointFC.x, pointFC.y);
                this.E.setColor(-65281);
                canvas.drawPath(path, this.E);
            }
            RectF rectF3 = this.f3089x;
            this.E.setColor(InputDeviceCompat.SOURCE_ANY);
            canvas.drawRect(rectF3, this.E);
            RectF rectF4 = this.w;
            this.E.setColor(-16711936);
            canvas.drawRect(rectF4, this.E);
            RectF rectF5 = this.f3091z;
            this.E.setColor(-16711681);
            canvas.drawRect(rectF5, this.E);
            RectF rectF6 = this.f3090y;
            this.E.setColor(-16776961);
            canvas.drawRect(rectF6, this.E);
        }
    }

    public final void e(float f) {
        float f2;
        float f3;
        this.L = f;
        this.m.setAlpha((int) (this.r ? k.d(0.0f, 255.0f, f) : k.d(255.0f, 0.0f, f)));
        this.o.getPosTan(this.p * f, this.q, null);
        float[] fArr = this.q;
        float fA = fArr[0];
        float fA2 = fArr[1];
        if (f > 1.0f || f < 0.0f) {
            if (f > 1.0f) {
                f2 = 0.99f;
                f3 = (f - 1.0f) / 0.00999999f;
            } else {
                f2 = 0.01f;
                f3 = (f / 0.01f) * (-1.0f);
            }
            this.o.getPosTan(this.p * f2, fArr, null);
            float[] fArr2 = this.q;
            float f4 = fArr2[0];
            float f5 = fArr2[1];
            fA = b.d.b.a.a.a(fA, f4, f3, fA);
            fA2 = b.d.b.a.a.a(fA2, f5, f3, fA2);
        }
        float f6 = fA;
        float f7 = fA2;
        f fVarA = this.C.a(f, ((Float) Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform$ProgressThresholds.access$1000(this.A.f3086b)))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform$ProgressThresholds.access$1100(this.A.f3086b)))).floatValue(), this.f3087b.width(), this.f3087b.height(), this.f.width(), this.f.height());
        this.H = fVarA;
        RectF rectF = this.w;
        float f8 = fVarA.c / 2.0f;
        rectF.set(f6 - f8, f7, f8 + f6, fVarA.d + f7);
        RectF rectF2 = this.f3090y;
        f fVar = this.H;
        float f9 = fVar.e / 2.0f;
        rectF2.set(f6 - f9, f7, f9 + f6, fVar.f + f7);
        this.f3089x.set(this.w);
        this.f3091z.set(this.f3090y);
        float fFloatValue = ((Float) Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform$ProgressThresholds.access$1000(this.A.c)))).floatValue();
        float fFloatValue2 = ((Float) Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform$ProgressThresholds.access$1100(this.A.c)))).floatValue();
        boolean zB = this.C.b(this.H);
        RectF rectF3 = zB ? this.f3089x : this.f3091z;
        float fE = k.e(0.0f, 1.0f, fFloatValue, fFloatValue2, f);
        if (!zB) {
            fE = 1.0f - fE;
        }
        this.C.c(rectF3, fE, this.H);
        this.I = new RectF(Math.min(this.f3089x.left, this.f3091z.left), Math.min(this.f3089x.top, this.f3091z.top), Math.max(this.f3089x.right, this.f3091z.right), Math.max(this.f3089x.bottom, this.f3091z.bottom));
        g gVar = this.n;
        ShapeAppearanceModel shapeAppearanceModelBuild = this.c;
        ShapeAppearanceModel shapeAppearanceModel = this.g;
        RectF rectF4 = this.w;
        RectF rectF5 = this.f3089x;
        RectF rectF6 = this.f3091z;
        MaterialContainerTransform$ProgressThresholds materialContainerTransform$ProgressThresholds = this.A.d;
        Objects.requireNonNull(gVar);
        float start = materialContainerTransform$ProgressThresholds.getStart();
        float end = materialContainerTransform$ProgressThresholds.getEnd();
        RectF rectF7 = k.a;
        if (f >= start) {
            if (f > end) {
                shapeAppearanceModelBuild = shapeAppearanceModel;
            } else {
                shapeAppearanceModelBuild = ((shapeAppearanceModelBuild.getTopLeftCornerSize().getCornerSize(rectF4) == 0.0f && shapeAppearanceModelBuild.getTopRightCornerSize().getCornerSize(rectF4) == 0.0f && shapeAppearanceModelBuild.getBottomRightCornerSize().getCornerSize(rectF4) == 0.0f && shapeAppearanceModelBuild.getBottomLeftCornerSize().getCornerSize(rectF4) == 0.0f) ? false : true ? shapeAppearanceModelBuild : shapeAppearanceModel).toBuilder().setTopLeftCornerSize(new AbsoluteCornerSize(k.e(shapeAppearanceModelBuild.getTopLeftCornerSize().getCornerSize(rectF4), shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(rectF6), start, end, f))).setTopRightCornerSize(new AbsoluteCornerSize(k.e(shapeAppearanceModelBuild.getTopRightCornerSize().getCornerSize(rectF4), shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF6), start, end, f))).setBottomLeftCornerSize(new AbsoluteCornerSize(k.e(shapeAppearanceModelBuild.getBottomLeftCornerSize().getCornerSize(rectF4), shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(rectF6), start, end, f))).setBottomRightCornerSize(new AbsoluteCornerSize(k.e(shapeAppearanceModelBuild.getBottomRightCornerSize().getCornerSize(rectF4), shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(rectF6), start, end, f))).build();
            }
        }
        gVar.e = shapeAppearanceModelBuild;
        gVar.d.calculatePath(shapeAppearanceModelBuild, 1.0f, rectF5, gVar.f1635b);
        gVar.d.calculatePath(gVar.e, 1.0f, rectF6, gVar.c);
        if (Build$VERSION.SDK_INT >= 23) {
            gVar.a.op(gVar.f1635b, gVar.c, Path$Op.UNION);
        }
        this.J = k.d(this.d, this.h, f);
        float fCenterX = ((this.I.centerX() / (this.f3088s / 2.0f)) - 1.0f) * 0.3f;
        float fCenterY = (this.I.centerY() / this.t) * 1.5f;
        float f10 = this.J;
        float f11 = (int) (fCenterY * f10);
        this.K = f11;
        this.l.setShadowLayer(f10, (int) (fCenterX * f10), f11, 754974720);
        this.G = this.B.a(f, ((Float) Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform$ProgressThresholds.access$1000(this.A.a)))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform$ProgressThresholds.access$1100(this.A.a)))).floatValue());
        if (this.j.getColor() != 0) {
            this.j.setAlpha(this.G.a);
        }
        if (this.k.getColor() != 0) {
            this.k.setAlpha(this.G.f1632b);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        throw new UnsupportedOperationException("Setting alpha on is not supported");
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        throw new UnsupportedOperationException("Setting a color filter is not supported");
    }
}
