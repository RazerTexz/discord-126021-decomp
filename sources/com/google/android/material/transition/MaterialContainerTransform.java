package com.google.android.material.transition;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.transition.ArcMotion;
import androidx.transition.PathMotion;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import b.d.b.a.outline;
import b.i.a.g.l.FadeModeEvaluator;
import b.i.a.g.l.FadeModeEvaluators;
import b.i.a.g.l.FadeModeResult;
import b.i.a.g.l.FitModeEvaluator;
import b.i.a.g.l.FitModeEvaluators;
import b.i.a.g.l.FitModeResult;
import b.i.a.g.l.MaskEvaluator;
import b.i.a.g.l.TransitionListenerAdapter2;
import b.i.a.g.l.TransitionUtils2;
import b.i.a.g.l.TransitionUtils3;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class MaterialContainerTransform extends Transition {
    private static final float ELEVATION_NOT_SET = -1.0f;
    public static final int FADE_MODE_CROSS = 2;
    public static final int FADE_MODE_IN = 0;
    public static final int FADE_MODE_OUT = 1;
    public static final int FADE_MODE_THROUGH = 3;
    public static final int FIT_MODE_AUTO = 0;
    public static final int FIT_MODE_HEIGHT = 2;
    public static final int FIT_MODE_WIDTH = 1;
    public static final int TRANSITION_DIRECTION_AUTO = 0;
    public static final int TRANSITION_DIRECTION_ENTER = 1;
    public static final int TRANSITION_DIRECTION_RETURN = 2;
    private boolean elevationShadowEnabled;
    private float endElevation;

    @Nullable
    private ShapeAppearanceModel endShapeAppearanceModel;

    @Nullable
    private View endView;

    @Nullable
    private ProgressThresholds fadeProgressThresholds;

    @Nullable
    private ProgressThresholds scaleMaskProgressThresholds;

    @Nullable
    private ProgressThresholds scaleProgressThresholds;

    @Nullable
    private ProgressThresholds shapeMaskProgressThresholds;
    private float startElevation;

    @Nullable
    private ShapeAppearanceModel startShapeAppearanceModel;

    @Nullable
    private View startView;
    private static final String TAG = MaterialContainerTransform.class.getSimpleName();
    private static final String PROP_BOUNDS = "materialContainerTransition:bounds";
    private static final String PROP_SHAPE_APPEARANCE = "materialContainerTransition:shapeAppearance";
    private static final String[] TRANSITION_PROPS = {PROP_BOUNDS, PROP_SHAPE_APPEARANCE};
    private static final c DEFAULT_ENTER_THRESHOLDS = new c(new ProgressThresholds(0.0f, 0.25f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.75f), null);
    private static final c DEFAULT_RETURN_THRESHOLDS = new c(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.3f, 0.9f), null);
    private static final c DEFAULT_ENTER_THRESHOLDS_ARC = new c(new ProgressThresholds(0.1f, 0.4f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 0.9f), null);
    private static final c DEFAULT_RETURN_THRESHOLDS_ARC = new c(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.2f, 0.9f), null);
    private boolean drawDebugEnabled = false;
    private boolean holdAtEndEnabled = false;

    @IdRes
    private int drawingViewId = R.id.content;

    @IdRes
    private int startViewId = -1;

    @IdRes
    private int endViewId = -1;

    @ColorInt
    private int containerColor = 0;

    @ColorInt
    private int startContainerColor = 0;

    @ColorInt
    private int endContainerColor = 0;

    @ColorInt
    private int scrimColor = 1375731712;
    private int transitionDirection = 0;
    private int fadeMode = 0;
    private int fitMode = 0;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface FadeMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface FitMode {
    }

    public static class ProgressThresholds {

        @FloatRange(from = 0.0d, to = 1.0d)
        private final float end;

        @FloatRange(from = 0.0d, to = 1.0d)
        private final float start;

        public ProgressThresholds(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
            this.start = f;
            this.end = f2;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float getEnd() {
            return this.end;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float getStart() {
            return this.start;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TransitionDirection {
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ d a;

        public a(MaterialContainerTransform materialContainerTransform, d dVar) {
            this.a = dVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            d dVar = this.a;
            float animatedFraction = valueAnimator.getAnimatedFraction();
            if (dVar.L != animatedFraction) {
                dVar.e(animatedFraction);
            }
        }
    }

    public class b extends TransitionListenerAdapter2 {
        public final /* synthetic */ View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f3085b;
        public final /* synthetic */ View c;
        public final /* synthetic */ View d;

        public b(View view, d dVar, View view2, View view3) {
            this.a = view;
            this.f3085b = dVar;
            this.c = view2;
            this.d = view3;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            MaterialContainerTransform.this.removeListener(this);
            if (MaterialContainerTransform.this.holdAtEndEnabled) {
                return;
            }
            this.c.setAlpha(1.0f);
            this.d.setAlpha(1.0f);
            ViewUtils.getOverlay(this.a).remove(this.f3085b);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
            ViewUtils.getOverlay(this.a).add(this.f3085b);
            this.c.setAlpha(0.0f);
            this.d.setAlpha(0.0f);
        }
    }

    public static class c {

        @NonNull
        public final ProgressThresholds a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public final ProgressThresholds f3086b;

        @NonNull
        public final ProgressThresholds c;

        @NonNull
        public final ProgressThresholds d;

        public c(ProgressThresholds progressThresholds, ProgressThresholds progressThresholds2, ProgressThresholds progressThresholds3, ProgressThresholds progressThresholds4, a aVar) {
            this.a = progressThresholds;
            this.f3086b = progressThresholds2;
            this.c = progressThresholds3;
            this.d = progressThresholds4;
        }
    }

    public static final class d extends Drawable {
        public final c A;
        public final FadeModeEvaluator B;
        public final FitModeEvaluator C;
        public final boolean D;
        public final Paint E;
        public final Path F;
        public FadeModeResult G;
        public FitModeResult H;
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
        public final MaskEvaluator n;
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

        public class a implements TransitionUtils3.a {
            public a() {
            }

            @Override // b.i.a.g.l.TransitionUtils3.a
            public void a(Canvas canvas) {
                d.this.a.draw(canvas);
            }
        }

        public class b implements TransitionUtils3.a {
            public b() {
            }

            @Override // b.i.a.g.l.TransitionUtils3.a
            public void a(Canvas canvas) {
                d.this.e.draw(canvas);
            }
        }

        public d(PathMotion pathMotion, View view, RectF rectF, ShapeAppearanceModel shapeAppearanceModel, float f, View view2, RectF rectF2, ShapeAppearanceModel shapeAppearanceModel2, float f2, int i, int i2, int i3, int i4, boolean z2, boolean z3, FadeModeEvaluator fadeModeEvaluator, FitModeEvaluator fitModeEvaluator, c cVar, boolean z4, a aVar) {
            Paint paint = new Paint();
            this.i = paint;
            Paint paint2 = new Paint();
            this.j = paint2;
            Paint paint3 = new Paint();
            this.k = paint3;
            this.l = new Paint();
            Paint paint4 = new Paint();
            this.m = paint4;
            this.n = new MaskEvaluator();
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
            this.B = fadeModeEvaluator;
            this.C = fitModeEvaluator;
            this.A = cVar;
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
            paint4.setStyle(Paint.Style.FILL);
            RectF rectF5 = TransitionUtils3.a;
            paint4.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i4, i4, Shader.TileMode.CLAMP));
            paint5.setStyle(Paint.Style.STROKE);
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
            TransitionUtils3.h(canvas, bounds, rectF.left, rectF.top, this.H.f1634b, this.G.f1632b, new b());
        }

        public final void b(Canvas canvas) {
            d(canvas, this.j);
            Rect bounds = getBounds();
            RectF rectF = this.w;
            TransitionUtils3.h(canvas, bounds, rectF.left, rectF.top, this.H.a, this.G.a, new a());
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
                canvas.clipPath(this.n.a, Region.Op.DIFFERENCE);
                if (Build.VERSION.SDK_INT > 28) {
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
            MaskEvaluator maskEvaluator = this.n;
            if (Build.VERSION.SDK_INT >= 23) {
                canvas.clipPath(maskEvaluator.a);
            } else {
                canvas.clipPath(maskEvaluator.f1635b);
                canvas.clipPath(maskEvaluator.c, Region.Op.UNION);
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
            this.m.setAlpha((int) (this.r ? TransitionUtils3.d(0.0f, 255.0f, f) : TransitionUtils3.d(255.0f, 0.0f, f)));
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
                fA = outline.a(fA, f4, f3, fA);
                fA2 = outline.a(fA2, f5, f3, fA2);
            }
            float f6 = fA;
            float f7 = fA2;
            FitModeResult fitModeResultA = this.C.a(f, ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f3086b.start))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f3086b.end))).floatValue(), this.f3087b.width(), this.f3087b.height(), this.f.width(), this.f.height());
            this.H = fitModeResultA;
            RectF rectF = this.w;
            float f8 = fitModeResultA.c / 2.0f;
            rectF.set(f6 - f8, f7, f8 + f6, fitModeResultA.d + f7);
            RectF rectF2 = this.f3090y;
            FitModeResult fitModeResult = this.H;
            float f9 = fitModeResult.e / 2.0f;
            rectF2.set(f6 - f9, f7, f9 + f6, fitModeResult.f + f7);
            this.f3089x.set(this.w);
            this.f3091z.set(this.f3090y);
            float fFloatValue = ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.c.start))).floatValue();
            float fFloatValue2 = ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.c.end))).floatValue();
            boolean zB = this.C.b(this.H);
            RectF rectF3 = zB ? this.f3089x : this.f3091z;
            float fE = TransitionUtils3.e(0.0f, 1.0f, fFloatValue, fFloatValue2, f);
            if (!zB) {
                fE = 1.0f - fE;
            }
            this.C.c(rectF3, fE, this.H);
            this.I = new RectF(Math.min(this.f3089x.left, this.f3091z.left), Math.min(this.f3089x.top, this.f3091z.top), Math.max(this.f3089x.right, this.f3091z.right), Math.max(this.f3089x.bottom, this.f3091z.bottom));
            MaskEvaluator maskEvaluator = this.n;
            ShapeAppearanceModel shapeAppearanceModelBuild = this.c;
            ShapeAppearanceModel shapeAppearanceModel = this.g;
            RectF rectF4 = this.w;
            RectF rectF5 = this.f3089x;
            RectF rectF6 = this.f3091z;
            ProgressThresholds progressThresholds = this.A.d;
            Objects.requireNonNull(maskEvaluator);
            float start = progressThresholds.getStart();
            float end = progressThresholds.getEnd();
            RectF rectF7 = TransitionUtils3.a;
            if (f >= start) {
                if (f > end) {
                    shapeAppearanceModelBuild = shapeAppearanceModel;
                } else {
                    shapeAppearanceModelBuild = ((shapeAppearanceModelBuild.getTopLeftCornerSize().getCornerSize(rectF4) == 0.0f && shapeAppearanceModelBuild.getTopRightCornerSize().getCornerSize(rectF4) == 0.0f && shapeAppearanceModelBuild.getBottomRightCornerSize().getCornerSize(rectF4) == 0.0f && shapeAppearanceModelBuild.getBottomLeftCornerSize().getCornerSize(rectF4) == 0.0f) ? false : true ? shapeAppearanceModelBuild : shapeAppearanceModel).toBuilder().setTopLeftCornerSize(new AbsoluteCornerSize(TransitionUtils3.e(shapeAppearanceModelBuild.getTopLeftCornerSize().getCornerSize(rectF4), shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(rectF6), start, end, f))).setTopRightCornerSize(new AbsoluteCornerSize(TransitionUtils3.e(shapeAppearanceModelBuild.getTopRightCornerSize().getCornerSize(rectF4), shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF6), start, end, f))).setBottomLeftCornerSize(new AbsoluteCornerSize(TransitionUtils3.e(shapeAppearanceModelBuild.getBottomLeftCornerSize().getCornerSize(rectF4), shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(rectF6), start, end, f))).setBottomRightCornerSize(new AbsoluteCornerSize(TransitionUtils3.e(shapeAppearanceModelBuild.getBottomRightCornerSize().getCornerSize(rectF4), shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(rectF6), start, end, f))).build();
                }
            }
            maskEvaluator.e = shapeAppearanceModelBuild;
            maskEvaluator.d.calculatePath(shapeAppearanceModelBuild, 1.0f, rectF5, maskEvaluator.f1635b);
            maskEvaluator.d.calculatePath(maskEvaluator.e, 1.0f, rectF6, maskEvaluator.c);
            if (Build.VERSION.SDK_INT >= 23) {
                maskEvaluator.a.op(maskEvaluator.f1635b, maskEvaluator.c, Path.Op.UNION);
            }
            this.J = TransitionUtils3.d(this.d, this.h, f);
            float fCenterX = ((this.I.centerX() / (this.f3088s / 2.0f)) - 1.0f) * 0.3f;
            float fCenterY = (this.I.centerY() / this.t) * 1.5f;
            float f10 = this.J;
            float f11 = (int) (fCenterY * f10);
            this.K = f11;
            this.l.setShadowLayer(f10, (int) (fCenterX * f10), f11, 754974720);
            this.G = this.B.a(f, ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.a.start))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.a.end))).floatValue());
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

    public MaterialContainerTransform() {
        this.elevationShadowEnabled = Build.VERSION.SDK_INT >= 28;
        this.startElevation = -1.0f;
        this.endElevation = -1.0f;
        setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }

    private c buildThresholdsGroup(boolean z2) {
        PathMotion pathMotion = getPathMotion();
        return ((pathMotion instanceof ArcMotion) || (pathMotion instanceof MaterialArcMotion)) ? getThresholdsOrDefault(z2, DEFAULT_ENTER_THRESHOLDS_ARC, DEFAULT_RETURN_THRESHOLDS_ARC) : getThresholdsOrDefault(z2, DEFAULT_ENTER_THRESHOLDS, DEFAULT_RETURN_THRESHOLDS);
    }

    private static RectF calculateDrawableBounds(View view, @Nullable View view2, float f, float f2) {
        if (view2 == null) {
            return new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        }
        RectF rectFC = TransitionUtils3.c(view2);
        rectFC.offset(f, f2);
        return rectFC;
    }

    private static ShapeAppearanceModel captureShapeAppearance(@NonNull View view, @NonNull RectF rectF, @Nullable ShapeAppearanceModel shapeAppearanceModel) {
        ShapeAppearanceModel shapeAppearance = getShapeAppearance(view, shapeAppearanceModel);
        RectF rectF2 = TransitionUtils3.a;
        return shapeAppearance.withTransformedCornerSizes(new TransitionUtils2(rectF));
    }

    private static void captureValues(@NonNull TransitionValues transitionValues, @Nullable View view, @IdRes int i, @Nullable ShapeAppearanceModel shapeAppearanceModel) {
        RectF rectFC;
        if (i != -1) {
            View view2 = transitionValues.view;
            RectF rectF = TransitionUtils3.a;
            View viewFindViewById = view2.findViewById(i);
            if (viewFindViewById == null) {
                viewFindViewById = TransitionUtils3.b(view2, i);
            }
            transitionValues.view = viewFindViewById;
        } else if (view != null) {
            transitionValues.view = view;
        } else {
            View view3 = transitionValues.view;
            int i2 = com.google.android.material.R.id.mtrl_motion_snapshot_view;
            if (view3.getTag(i2) instanceof View) {
                View view4 = (View) transitionValues.view.getTag(i2);
                transitionValues.view.setTag(i2, null);
                transitionValues.view = view4;
            }
        }
        View view5 = transitionValues.view;
        if (!ViewCompat.isLaidOut(view5) && view5.getWidth() == 0 && view5.getHeight() == 0) {
            return;
        }
        if (view5.getParent() == null) {
            RectF rectF2 = TransitionUtils3.a;
            rectFC = new RectF(view5.getLeft(), view5.getTop(), view5.getRight(), view5.getBottom());
        } else {
            rectFC = TransitionUtils3.c(view5);
        }
        transitionValues.values.put(PROP_BOUNDS, rectFC);
        transitionValues.values.put(PROP_SHAPE_APPEARANCE, captureShapeAppearance(view5, rectFC, shapeAppearanceModel));
    }

    private static float getElevationOrDefault(float f, View view) {
        return f != -1.0f ? f : ViewCompat.getElevation(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static ShapeAppearanceModel getShapeAppearance(@NonNull View view, @Nullable ShapeAppearanceModel shapeAppearanceModel) {
        if (shapeAppearanceModel != null) {
            return shapeAppearanceModel;
        }
        int i = com.google.android.material.R.id.mtrl_motion_snapshot_view;
        if (view.getTag(i) instanceof ShapeAppearanceModel) {
            return (ShapeAppearanceModel) view.getTag(i);
        }
        Context context = view.getContext();
        int transitionShapeAppearanceResId = getTransitionShapeAppearanceResId(context);
        if (transitionShapeAppearanceResId != -1) {
            return ShapeAppearanceModel.builder(context, transitionShapeAppearanceResId, 0).build();
        }
        return view instanceof Shapeable ? ((Shapeable) view).getShapeAppearanceModel() : ShapeAppearanceModel.builder().build();
    }

    private c getThresholdsOrDefault(boolean z2, c cVar, c cVar2) {
        if (!z2) {
            cVar = cVar2;
        }
        return new c((ProgressThresholds) TransitionUtils3.a(this.fadeProgressThresholds, cVar.a), (ProgressThresholds) TransitionUtils3.a(this.scaleProgressThresholds, cVar.f3086b), (ProgressThresholds) TransitionUtils3.a(this.scaleMaskProgressThresholds, cVar.c), (ProgressThresholds) TransitionUtils3.a(this.shapeMaskProgressThresholds, cVar.d), null);
    }

    @StyleRes
    private static int getTransitionShapeAppearanceResId(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{com.google.android.material.R.attr.transitionShapeAppearance});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private boolean isEntering(@NonNull RectF rectF, @NonNull RectF rectF2) {
        int i = this.transitionDirection;
        if (i == 0) {
            RectF rectF3 = TransitionUtils3.a;
            return rectF2.height() * rectF2.width() > rectF.height() * rectF.width();
        }
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return false;
        }
        StringBuilder sbU = outline.U("Invalid transition direction: ");
        sbU.append(this.transitionDirection);
        throw new IllegalArgumentException(sbU.toString());
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues, this.endView, this.endViewId, this.endShapeAppearanceModel);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues, this.startView, this.startViewId, this.startShapeAppearanceModel);
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        View viewB;
        FadeModeEvaluator fadeModeEvaluator;
        FitModeEvaluator fitModeEvaluator;
        if (transitionValues != null && transitionValues2 != null) {
            RectF rectF = (RectF) transitionValues.values.get(PROP_BOUNDS);
            ShapeAppearanceModel shapeAppearanceModel = (ShapeAppearanceModel) transitionValues.values.get(PROP_SHAPE_APPEARANCE);
            if (rectF != null && shapeAppearanceModel != null) {
                RectF rectF2 = (RectF) transitionValues2.values.get(PROP_BOUNDS);
                ShapeAppearanceModel shapeAppearanceModel2 = (ShapeAppearanceModel) transitionValues2.values.get(PROP_SHAPE_APPEARANCE);
                if (rectF2 == null || shapeAppearanceModel2 == null) {
                    Log.w(TAG, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
                    return null;
                }
                View view = transitionValues.view;
                View view2 = transitionValues2.view;
                View view3 = view2.getParent() != null ? view2 : view;
                if (this.drawingViewId == view3.getId()) {
                    viewB = (View) view3.getParent();
                } else {
                    viewB = TransitionUtils3.b(view3, this.drawingViewId);
                    view3 = null;
                }
                RectF rectFC = TransitionUtils3.c(viewB);
                float f = -rectFC.left;
                float f2 = -rectFC.top;
                RectF rectFCalculateDrawableBounds = calculateDrawableBounds(viewB, view3, f, f2);
                rectF.offset(f, f2);
                rectF2.offset(f, f2);
                boolean zIsEntering = isEntering(rectF, rectF2);
                PathMotion pathMotion = getPathMotion();
                float elevationOrDefault = getElevationOrDefault(this.startElevation, view);
                float elevationOrDefault2 = getElevationOrDefault(this.endElevation, view2);
                int i = this.containerColor;
                int i2 = this.startContainerColor;
                int i3 = this.endContainerColor;
                View view4 = viewB;
                int i4 = this.scrimColor;
                boolean z2 = this.elevationShadowEnabled;
                int i5 = this.fadeMode;
                boolean z3 = true;
                if (i5 == 0) {
                    fadeModeEvaluator = zIsEntering ? FadeModeEvaluators.a : FadeModeEvaluators.f1631b;
                } else if (i5 == 1) {
                    fadeModeEvaluator = zIsEntering ? FadeModeEvaluators.f1631b : FadeModeEvaluators.a;
                } else if (i5 == 2) {
                    fadeModeEvaluator = FadeModeEvaluators.c;
                } else {
                    if (i5 != 3) {
                        throw new IllegalArgumentException(outline.q("Invalid fade mode: ", i5));
                    }
                    fadeModeEvaluator = FadeModeEvaluators.d;
                }
                FadeModeEvaluator fadeModeEvaluator2 = fadeModeEvaluator;
                int i6 = this.fitMode;
                if (i6 == 0) {
                    float fWidth = rectF.width();
                    float fHeight = rectF.height();
                    float fWidth2 = rectF2.width();
                    float fHeight2 = rectF2.height();
                    float f3 = (fHeight2 * fWidth) / fWidth2;
                    float f4 = (fWidth2 * fHeight) / fWidth;
                    if (!zIsEntering ? f4 < fHeight2 : f3 < fHeight) {
                        z3 = false;
                    }
                    fitModeEvaluator = z3 ? FitModeEvaluators.a : FitModeEvaluators.f1633b;
                } else if (i6 == 1) {
                    fitModeEvaluator = FitModeEvaluators.a;
                } else {
                    if (i6 != 2) {
                        throw new IllegalArgumentException(outline.q("Invalid fit mode: ", i6));
                    }
                    fitModeEvaluator = FitModeEvaluators.f1633b;
                }
                d dVar = new d(pathMotion, view, rectF, shapeAppearanceModel, elevationOrDefault, view2, rectF2, shapeAppearanceModel2, elevationOrDefault2, i, i2, i3, i4, zIsEntering, z2, fadeModeEvaluator2, fitModeEvaluator, buildThresholdsGroup(zIsEntering), this.drawDebugEnabled, null);
                dVar.setBounds(Math.round(rectFCalculateDrawableBounds.left), Math.round(rectFCalculateDrawableBounds.top), Math.round(rectFCalculateDrawableBounds.right), Math.round(rectFCalculateDrawableBounds.bottom));
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat.addUpdateListener(new a(this, dVar));
                addListener(new b(view4, dVar, view, view2));
                return valueAnimatorOfFloat;
            }
            Log.w(TAG, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
        }
        return null;
    }

    @ColorInt
    public int getContainerColor() {
        return this.containerColor;
    }

    @IdRes
    public int getDrawingViewId() {
        return this.drawingViewId;
    }

    @ColorInt
    public int getEndContainerColor() {
        return this.endContainerColor;
    }

    public float getEndElevation() {
        return this.endElevation;
    }

    @Nullable
    public ShapeAppearanceModel getEndShapeAppearanceModel() {
        return this.endShapeAppearanceModel;
    }

    @Nullable
    public View getEndView() {
        return this.endView;
    }

    @IdRes
    public int getEndViewId() {
        return this.endViewId;
    }

    public int getFadeMode() {
        return this.fadeMode;
    }

    @Nullable
    public ProgressThresholds getFadeProgressThresholds() {
        return this.fadeProgressThresholds;
    }

    public int getFitMode() {
        return this.fitMode;
    }

    @Nullable
    public ProgressThresholds getScaleMaskProgressThresholds() {
        return this.scaleMaskProgressThresholds;
    }

    @Nullable
    public ProgressThresholds getScaleProgressThresholds() {
        return this.scaleProgressThresholds;
    }

    @ColorInt
    public int getScrimColor() {
        return this.scrimColor;
    }

    @Nullable
    public ProgressThresholds getShapeMaskProgressThresholds() {
        return this.shapeMaskProgressThresholds;
    }

    @ColorInt
    public int getStartContainerColor() {
        return this.startContainerColor;
    }

    public float getStartElevation() {
        return this.startElevation;
    }

    @Nullable
    public ShapeAppearanceModel getStartShapeAppearanceModel() {
        return this.startShapeAppearanceModel;
    }

    @Nullable
    public View getStartView() {
        return this.startView;
    }

    @IdRes
    public int getStartViewId() {
        return this.startViewId;
    }

    public int getTransitionDirection() {
        return this.transitionDirection;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return TRANSITION_PROPS;
    }

    public boolean isDrawDebugEnabled() {
        return this.drawDebugEnabled;
    }

    public boolean isElevationShadowEnabled() {
        return this.elevationShadowEnabled;
    }

    public boolean isHoldAtEndEnabled() {
        return this.holdAtEndEnabled;
    }

    public void setAllContainerColors(@ColorInt int i) {
        this.containerColor = i;
        this.startContainerColor = i;
        this.endContainerColor = i;
    }

    public void setContainerColor(@ColorInt int i) {
        this.containerColor = i;
    }

    public void setDrawDebugEnabled(boolean z2) {
        this.drawDebugEnabled = z2;
    }

    public void setDrawingViewId(@IdRes int i) {
        this.drawingViewId = i;
    }

    public void setElevationShadowEnabled(boolean z2) {
        this.elevationShadowEnabled = z2;
    }

    public void setEndContainerColor(@ColorInt int i) {
        this.endContainerColor = i;
    }

    public void setEndElevation(float f) {
        this.endElevation = f;
    }

    public void setEndShapeAppearanceModel(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.endShapeAppearanceModel = shapeAppearanceModel;
    }

    public void setEndView(@Nullable View view) {
        this.endView = view;
    }

    public void setEndViewId(@IdRes int i) {
        this.endViewId = i;
    }

    public void setFadeMode(int i) {
        this.fadeMode = i;
    }

    public void setFadeProgressThresholds(@Nullable ProgressThresholds progressThresholds) {
        this.fadeProgressThresholds = progressThresholds;
    }

    public void setFitMode(int i) {
        this.fitMode = i;
    }

    public void setHoldAtEndEnabled(boolean z2) {
        this.holdAtEndEnabled = z2;
    }

    public void setScaleMaskProgressThresholds(@Nullable ProgressThresholds progressThresholds) {
        this.scaleMaskProgressThresholds = progressThresholds;
    }

    public void setScaleProgressThresholds(@Nullable ProgressThresholds progressThresholds) {
        this.scaleProgressThresholds = progressThresholds;
    }

    public void setScrimColor(@ColorInt int i) {
        this.scrimColor = i;
    }

    public void setShapeMaskProgressThresholds(@Nullable ProgressThresholds progressThresholds) {
        this.shapeMaskProgressThresholds = progressThresholds;
    }

    public void setStartContainerColor(@ColorInt int i) {
        this.startContainerColor = i;
    }

    public void setStartElevation(float f) {
        this.startElevation = f;
    }

    public void setStartShapeAppearanceModel(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.startShapeAppearanceModel = shapeAppearanceModel;
    }

    public void setStartView(@Nullable View view) {
        this.startView = view;
    }

    public void setStartViewId(@IdRes int i) {
        this.startViewId = i;
    }

    public void setTransitionDirection(int i) {
        this.transitionDirection = i;
    }
}
