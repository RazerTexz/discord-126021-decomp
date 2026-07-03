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
import com.google.android.material.C10817R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p341g.p353l.AbstractC4467i;
import p007b.p225i.p226a.p341g.p353l.C4460b;
import p007b.p225i.p226a.p341g.p353l.C4461c;
import p007b.p225i.p226a.p341g.p353l.C4463e;
import p007b.p225i.p226a.p341g.p353l.C4464f;
import p007b.p225i.p226a.p341g.p353l.C4465g;
import p007b.p225i.p226a.p341g.p353l.C4468j;
import p007b.p225i.p226a.p341g.p353l.C4469k;
import p007b.p225i.p226a.p341g.p353l.InterfaceC4459a;
import p007b.p225i.p226a.p341g.p353l.InterfaceC4462d;

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
    private static final C11046c DEFAULT_ENTER_THRESHOLDS = new C11046c(new ProgressThresholds(0.0f, 0.25f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.75f), null);
    private static final C11046c DEFAULT_RETURN_THRESHOLDS = new C11046c(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.3f, 0.9f), null);
    private static final C11046c DEFAULT_ENTER_THRESHOLDS_ARC = new C11046c(new ProgressThresholds(0.1f, 0.4f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 0.9f), null);
    private static final C11046c DEFAULT_RETURN_THRESHOLDS_ARC = new C11046c(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.2f, 0.9f), null);
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

        @FloatRange(from = 0.0d, m75to = 1.0d)
        private final float end;

        @FloatRange(from = 0.0d, m75to = 1.0d)
        private final float start;

        public ProgressThresholds(@FloatRange(from = 0.0d, m75to = 1.0d) float f, @FloatRange(from = 0.0d, m75to = 1.0d) float f2) {
            this.start = f;
            this.end = f2;
        }

        @FloatRange(from = 0.0d, m75to = 1.0d)
        public float getEnd() {
            return this.end;
        }

        @FloatRange(from = 0.0d, m75to = 1.0d)
        public float getStart() {
            return this.start;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TransitionDirection {
    }

    /* JADX INFO: renamed from: com.google.android.material.transition.MaterialContainerTransform$a */
    public class C11044a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ C11047d f21266a;

        public C11044a(MaterialContainerTransform materialContainerTransform, C11047d c11047d) {
            this.f21266a = c11047d;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            C11047d c11047d = this.f21266a;
            float animatedFraction = valueAnimator.getAnimatedFraction();
            if (c11047d.f21287L != animatedFraction) {
                c11047d.m9169e(animatedFraction);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.transition.MaterialContainerTransform$b */
    public class C11045b extends AbstractC4467i {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ View f21267a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ C11047d f21268b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ View f21269c;

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ View f21270d;

        public C11045b(View view, C11047d c11047d, View view2, View view3) {
            this.f21267a = view;
            this.f21268b = c11047d;
            this.f21269c = view2;
            this.f21270d = view3;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            MaterialContainerTransform.this.removeListener(this);
            if (MaterialContainerTransform.this.holdAtEndEnabled) {
                return;
            }
            this.f21269c.setAlpha(1.0f);
            this.f21270d.setAlpha(1.0f);
            ViewUtils.getOverlay(this.f21267a).remove(this.f21268b);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
            ViewUtils.getOverlay(this.f21267a).add(this.f21268b);
            this.f21269c.setAlpha(0.0f);
            this.f21270d.setAlpha(0.0f);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.transition.MaterialContainerTransform$c */
    public static class C11046c {

        /* JADX INFO: renamed from: a */
        @NonNull
        public final ProgressThresholds f21272a;

        /* JADX INFO: renamed from: b */
        @NonNull
        public final ProgressThresholds f21273b;

        /* JADX INFO: renamed from: c */
        @NonNull
        public final ProgressThresholds f21274c;

        /* JADX INFO: renamed from: d */
        @NonNull
        public final ProgressThresholds f21275d;

        public C11046c(ProgressThresholds progressThresholds, ProgressThresholds progressThresholds2, ProgressThresholds progressThresholds3, ProgressThresholds progressThresholds4, C11044a c11044a) {
            this.f21272a = progressThresholds;
            this.f21273b = progressThresholds2;
            this.f21274c = progressThresholds3;
            this.f21275d = progressThresholds4;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.transition.MaterialContainerTransform$d */
    public static final class C11047d extends Drawable {

        /* JADX INFO: renamed from: A */
        public final C11046c f21276A;

        /* JADX INFO: renamed from: B */
        public final InterfaceC4459a f21277B;

        /* JADX INFO: renamed from: C */
        public final InterfaceC4462d f21278C;

        /* JADX INFO: renamed from: D */
        public final boolean f21279D;

        /* JADX INFO: renamed from: E */
        public final Paint f21280E;

        /* JADX INFO: renamed from: F */
        public final Path f21281F;

        /* JADX INFO: renamed from: G */
        public C4461c f21282G;

        /* JADX INFO: renamed from: H */
        public C4464f f21283H;

        /* JADX INFO: renamed from: I */
        public RectF f21284I;

        /* JADX INFO: renamed from: J */
        public float f21285J;

        /* JADX INFO: renamed from: K */
        public float f21286K;

        /* JADX INFO: renamed from: L */
        public float f21287L;

        /* JADX INFO: renamed from: a */
        public final View f21288a;

        /* JADX INFO: renamed from: b */
        public final RectF f21289b;

        /* JADX INFO: renamed from: c */
        public final ShapeAppearanceModel f21290c;

        /* JADX INFO: renamed from: d */
        public final float f21291d;

        /* JADX INFO: renamed from: e */
        public final View f21292e;

        /* JADX INFO: renamed from: f */
        public final RectF f21293f;

        /* JADX INFO: renamed from: g */
        public final ShapeAppearanceModel f21294g;

        /* JADX INFO: renamed from: h */
        public final float f21295h;

        /* JADX INFO: renamed from: i */
        public final Paint f21296i;

        /* JADX INFO: renamed from: j */
        public final Paint f21297j;

        /* JADX INFO: renamed from: k */
        public final Paint f21298k;

        /* JADX INFO: renamed from: l */
        public final Paint f21299l;

        /* JADX INFO: renamed from: m */
        public final Paint f21300m;

        /* JADX INFO: renamed from: n */
        public final C4465g f21301n;

        /* JADX INFO: renamed from: o */
        public final PathMeasure f21302o;

        /* JADX INFO: renamed from: p */
        public final float f21303p;

        /* JADX INFO: renamed from: q */
        public final float[] f21304q;

        /* JADX INFO: renamed from: r */
        public final boolean f21305r;

        /* JADX INFO: renamed from: s */
        public final float f21306s;

        /* JADX INFO: renamed from: t */
        public final float f21307t;

        /* JADX INFO: renamed from: u */
        public final boolean f21308u;

        /* JADX INFO: renamed from: v */
        public final MaterialShapeDrawable f21309v;

        /* JADX INFO: renamed from: w */
        public final RectF f21310w;

        /* JADX INFO: renamed from: x */
        public final RectF f21311x;

        /* JADX INFO: renamed from: y */
        public final RectF f21312y;

        /* JADX INFO: renamed from: z */
        public final RectF f21313z;

        /* JADX INFO: renamed from: com.google.android.material.transition.MaterialContainerTransform$d$a */
        public class a implements C4469k.a {
            public a() {
            }

            @Override // p007b.p225i.p226a.p341g.p353l.C4469k.a
            /* JADX INFO: renamed from: a */
            public void mo6194a(Canvas canvas) {
                C11047d.this.f21288a.draw(canvas);
            }
        }

        /* JADX INFO: renamed from: com.google.android.material.transition.MaterialContainerTransform$d$b */
        public class b implements C4469k.a {
            public b() {
            }

            @Override // p007b.p225i.p226a.p341g.p353l.C4469k.a
            /* JADX INFO: renamed from: a */
            public void mo6194a(Canvas canvas) {
                C11047d.this.f21292e.draw(canvas);
            }
        }

        public C11047d(PathMotion pathMotion, View view, RectF rectF, ShapeAppearanceModel shapeAppearanceModel, float f, View view2, RectF rectF2, ShapeAppearanceModel shapeAppearanceModel2, float f2, int i, int i2, int i3, int i4, boolean z2, boolean z3, InterfaceC4459a interfaceC4459a, InterfaceC4462d interfaceC4462d, C11046c c11046c, boolean z4, C11044a c11044a) {
            Paint paint = new Paint();
            this.f21296i = paint;
            Paint paint2 = new Paint();
            this.f21297j = paint2;
            Paint paint3 = new Paint();
            this.f21298k = paint3;
            this.f21299l = new Paint();
            Paint paint4 = new Paint();
            this.f21300m = paint4;
            this.f21301n = new C4465g();
            this.f21304q = new float[]{rectF.centerX(), rectF.top};
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            this.f21309v = materialShapeDrawable;
            Paint paint5 = new Paint();
            this.f21280E = paint5;
            this.f21281F = new Path();
            this.f21288a = view;
            this.f21289b = rectF;
            this.f21290c = shapeAppearanceModel;
            this.f21291d = f;
            this.f21292e = view2;
            this.f21293f = rectF2;
            this.f21294g = shapeAppearanceModel2;
            this.f21295h = f2;
            this.f21305r = z2;
            this.f21308u = z3;
            this.f21277B = interfaceC4459a;
            this.f21278C = interfaceC4462d;
            this.f21276A = c11046c;
            this.f21279D = z4;
            WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            this.f21306s = displayMetrics.widthPixels;
            this.f21307t = displayMetrics.heightPixels;
            paint.setColor(i);
            paint2.setColor(i2);
            paint3.setColor(i3);
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(0));
            materialShapeDrawable.setShadowCompatibilityMode(2);
            materialShapeDrawable.setShadowBitmapDrawingEnable(false);
            materialShapeDrawable.setShadowColor(-7829368);
            RectF rectF3 = new RectF(rectF);
            this.f21310w = rectF3;
            this.f21311x = new RectF(rectF3);
            RectF rectF4 = new RectF(rectF3);
            this.f21312y = rectF4;
            this.f21313z = new RectF(rectF4);
            PointF pointFM9165c = m9165c(rectF);
            PointF pointFM9165c2 = m9165c(rectF2);
            PathMeasure pathMeasure = new PathMeasure(pathMotion.getPath(pointFM9165c.x, pointFM9165c.y, pointFM9165c2.x, pointFM9165c2.y), false);
            this.f21302o = pathMeasure;
            this.f21303p = pathMeasure.getLength();
            paint4.setStyle(Paint.Style.FILL);
            RectF rectF5 = C4469k.f11915a;
            paint4.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i4, i4, Shader.TileMode.CLAMP));
            paint5.setStyle(Paint.Style.STROKE);
            paint5.setStrokeWidth(10.0f);
            m9169e(0.0f);
        }

        /* JADX INFO: renamed from: c */
        public static PointF m9165c(RectF rectF) {
            return new PointF(rectF.centerX(), rectF.top);
        }

        /* JADX INFO: renamed from: a */
        public final void m9166a(Canvas canvas) {
            m9168d(canvas, this.f21298k);
            Rect bounds = getBounds();
            RectF rectF = this.f21312y;
            C4469k.m6193h(canvas, bounds, rectF.left, rectF.top, this.f21283H.f11904b, this.f21282G.f11899b, new b());
        }

        /* JADX INFO: renamed from: b */
        public final void m9167b(Canvas canvas) {
            m9168d(canvas, this.f21297j);
            Rect bounds = getBounds();
            RectF rectF = this.f21310w;
            C4469k.m6193h(canvas, bounds, rectF.left, rectF.top, this.f21283H.f11903a, this.f21282G.f11898a, new a());
        }

        /* JADX INFO: renamed from: d */
        public final void m9168d(Canvas canvas, Paint paint) {
            if (paint.getColor() == 0 || paint.getAlpha() <= 0) {
                return;
            }
            canvas.drawRect(getBounds(), paint);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            if (this.f21300m.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.f21300m);
            }
            int iSave = this.f21279D ? canvas.save() : -1;
            if (this.f21308u && this.f21285J > 0.0f) {
                canvas.save();
                canvas.clipPath(this.f21301n.f11909a, Region.Op.DIFFERENCE);
                if (Build.VERSION.SDK_INT > 28) {
                    ShapeAppearanceModel shapeAppearanceModel = this.f21301n.f11913e;
                    if (shapeAppearanceModel.isRoundRect(this.f21284I)) {
                        float cornerSize = shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.f21284I);
                        canvas.drawRoundRect(this.f21284I, cornerSize, cornerSize, this.f21299l);
                    } else {
                        canvas.drawPath(this.f21301n.f11909a, this.f21299l);
                    }
                } else {
                    MaterialShapeDrawable materialShapeDrawable = this.f21309v;
                    RectF rectF = this.f21284I;
                    materialShapeDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                    this.f21309v.setElevation(this.f21285J);
                    this.f21309v.setShadowVerticalOffset((int) this.f21286K);
                    this.f21309v.setShapeAppearanceModel(this.f21301n.f11913e);
                    this.f21309v.draw(canvas);
                }
                canvas.restore();
            }
            C4465g c4465g = this.f21301n;
            if (Build.VERSION.SDK_INT >= 23) {
                canvas.clipPath(c4465g.f11909a);
            } else {
                canvas.clipPath(c4465g.f11910b);
                canvas.clipPath(c4465g.f11911c, Region.Op.UNION);
            }
            m9168d(canvas, this.f21296i);
            if (this.f21282G.f11900c) {
                m9167b(canvas);
                m9166a(canvas);
            } else {
                m9166a(canvas);
                m9167b(canvas);
            }
            if (this.f21279D) {
                canvas.restoreToCount(iSave);
                RectF rectF2 = this.f21310w;
                Path path = this.f21281F;
                PointF pointFM9165c = m9165c(rectF2);
                if (this.f21287L == 0.0f) {
                    path.reset();
                    path.moveTo(pointFM9165c.x, pointFM9165c.y);
                } else {
                    path.lineTo(pointFM9165c.x, pointFM9165c.y);
                    this.f21280E.setColor(-65281);
                    canvas.drawPath(path, this.f21280E);
                }
                RectF rectF3 = this.f21311x;
                this.f21280E.setColor(InputDeviceCompat.SOURCE_ANY);
                canvas.drawRect(rectF3, this.f21280E);
                RectF rectF4 = this.f21310w;
                this.f21280E.setColor(-16711936);
                canvas.drawRect(rectF4, this.f21280E);
                RectF rectF5 = this.f21313z;
                this.f21280E.setColor(-16711681);
                canvas.drawRect(rectF5, this.f21280E);
                RectF rectF6 = this.f21312y;
                this.f21280E.setColor(-16776961);
                canvas.drawRect(rectF6, this.f21280E);
            }
        }

        /* JADX INFO: renamed from: e */
        public final void m9169e(float f) {
            float f2;
            float f3;
            this.f21287L = f;
            this.f21300m.setAlpha((int) (this.f21305r ? C4469k.m6189d(0.0f, 255.0f, f) : C4469k.m6189d(255.0f, 0.0f, f)));
            this.f21302o.getPosTan(this.f21303p * f, this.f21304q, null);
            float[] fArr = this.f21304q;
            float fM839a = fArr[0];
            float fM839a2 = fArr[1];
            if (f > 1.0f || f < 0.0f) {
                if (f > 1.0f) {
                    f2 = 0.99f;
                    f3 = (f - 1.0f) / 0.00999999f;
                } else {
                    f2 = 0.01f;
                    f3 = (f / 0.01f) * (-1.0f);
                }
                this.f21302o.getPosTan(this.f21303p * f2, fArr, null);
                float[] fArr2 = this.f21304q;
                float f4 = fArr2[0];
                float f5 = fArr2[1];
                fM839a = C1643a.m839a(fM839a, f4, f3, fM839a);
                fM839a2 = C1643a.m839a(fM839a2, f5, f3, fM839a2);
            }
            float f6 = fM839a;
            float f7 = fM839a2;
            C4464f c4464fMo6183a = this.f21278C.mo6183a(f, ((Float) Preconditions.checkNotNull(Float.valueOf(this.f21276A.f21273b.start))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.f21276A.f21273b.end))).floatValue(), this.f21289b.width(), this.f21289b.height(), this.f21293f.width(), this.f21293f.height());
            this.f21283H = c4464fMo6183a;
            RectF rectF = this.f21310w;
            float f8 = c4464fMo6183a.f11905c / 2.0f;
            rectF.set(f6 - f8, f7, f8 + f6, c4464fMo6183a.f11906d + f7);
            RectF rectF2 = this.f21312y;
            C4464f c4464f = this.f21283H;
            float f9 = c4464f.f11907e / 2.0f;
            rectF2.set(f6 - f9, f7, f9 + f6, c4464f.f11908f + f7);
            this.f21311x.set(this.f21310w);
            this.f21313z.set(this.f21312y);
            float fFloatValue = ((Float) Preconditions.checkNotNull(Float.valueOf(this.f21276A.f21274c.start))).floatValue();
            float fFloatValue2 = ((Float) Preconditions.checkNotNull(Float.valueOf(this.f21276A.f21274c.end))).floatValue();
            boolean zMo6184b = this.f21278C.mo6184b(this.f21283H);
            RectF rectF3 = zMo6184b ? this.f21311x : this.f21313z;
            float fM6190e = C4469k.m6190e(0.0f, 1.0f, fFloatValue, fFloatValue2, f);
            if (!zMo6184b) {
                fM6190e = 1.0f - fM6190e;
            }
            this.f21278C.mo6185c(rectF3, fM6190e, this.f21283H);
            this.f21284I = new RectF(Math.min(this.f21311x.left, this.f21313z.left), Math.min(this.f21311x.top, this.f21313z.top), Math.max(this.f21311x.right, this.f21313z.right), Math.max(this.f21311x.bottom, this.f21313z.bottom));
            C4465g c4465g = this.f21301n;
            ShapeAppearanceModel shapeAppearanceModelBuild = this.f21290c;
            ShapeAppearanceModel shapeAppearanceModel = this.f21294g;
            RectF rectF4 = this.f21310w;
            RectF rectF5 = this.f21311x;
            RectF rectF6 = this.f21313z;
            ProgressThresholds progressThresholds = this.f21276A.f21275d;
            Objects.requireNonNull(c4465g);
            float start = progressThresholds.getStart();
            float end = progressThresholds.getEnd();
            RectF rectF7 = C4469k.f11915a;
            if (f >= start) {
                if (f > end) {
                    shapeAppearanceModelBuild = shapeAppearanceModel;
                } else {
                    shapeAppearanceModelBuild = ((shapeAppearanceModelBuild.getTopLeftCornerSize().getCornerSize(rectF4) == 0.0f && shapeAppearanceModelBuild.getTopRightCornerSize().getCornerSize(rectF4) == 0.0f && shapeAppearanceModelBuild.getBottomRightCornerSize().getCornerSize(rectF4) == 0.0f && shapeAppearanceModelBuild.getBottomLeftCornerSize().getCornerSize(rectF4) == 0.0f) ? false : true ? shapeAppearanceModelBuild : shapeAppearanceModel).toBuilder().setTopLeftCornerSize(new AbsoluteCornerSize(C4469k.m6190e(shapeAppearanceModelBuild.getTopLeftCornerSize().getCornerSize(rectF4), shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(rectF6), start, end, f))).setTopRightCornerSize(new AbsoluteCornerSize(C4469k.m6190e(shapeAppearanceModelBuild.getTopRightCornerSize().getCornerSize(rectF4), shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF6), start, end, f))).setBottomLeftCornerSize(new AbsoluteCornerSize(C4469k.m6190e(shapeAppearanceModelBuild.getBottomLeftCornerSize().getCornerSize(rectF4), shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(rectF6), start, end, f))).setBottomRightCornerSize(new AbsoluteCornerSize(C4469k.m6190e(shapeAppearanceModelBuild.getBottomRightCornerSize().getCornerSize(rectF4), shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(rectF6), start, end, f))).build();
                }
            }
            c4465g.f11913e = shapeAppearanceModelBuild;
            c4465g.f11912d.calculatePath(shapeAppearanceModelBuild, 1.0f, rectF5, c4465g.f11910b);
            c4465g.f11912d.calculatePath(c4465g.f11913e, 1.0f, rectF6, c4465g.f11911c);
            if (Build.VERSION.SDK_INT >= 23) {
                c4465g.f11909a.op(c4465g.f11910b, c4465g.f11911c, Path.Op.UNION);
            }
            this.f21285J = C4469k.m6189d(this.f21291d, this.f21295h, f);
            float fCenterX = ((this.f21284I.centerX() / (this.f21306s / 2.0f)) - 1.0f) * 0.3f;
            float fCenterY = (this.f21284I.centerY() / this.f21307t) * 1.5f;
            float f10 = this.f21285J;
            float f11 = (int) (fCenterY * f10);
            this.f21286K = f11;
            this.f21299l.setShadowLayer(f10, (int) (fCenterX * f10), f11, 754974720);
            this.f21282G = this.f21277B.mo6181a(f, ((Float) Preconditions.checkNotNull(Float.valueOf(this.f21276A.f21272a.start))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.f21276A.f21272a.end))).floatValue());
            if (this.f21297j.getColor() != 0) {
                this.f21297j.setAlpha(this.f21282G.f11898a);
            }
            if (this.f21298k.getColor() != 0) {
                this.f21298k.setAlpha(this.f21282G.f11899b);
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

    private C11046c buildThresholdsGroup(boolean z2) {
        PathMotion pathMotion = getPathMotion();
        return ((pathMotion instanceof ArcMotion) || (pathMotion instanceof MaterialArcMotion)) ? getThresholdsOrDefault(z2, DEFAULT_ENTER_THRESHOLDS_ARC, DEFAULT_RETURN_THRESHOLDS_ARC) : getThresholdsOrDefault(z2, DEFAULT_ENTER_THRESHOLDS, DEFAULT_RETURN_THRESHOLDS);
    }

    private static RectF calculateDrawableBounds(View view, @Nullable View view2, float f, float f2) {
        if (view2 == null) {
            return new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        }
        RectF rectFM6188c = C4469k.m6188c(view2);
        rectFM6188c.offset(f, f2);
        return rectFM6188c;
    }

    private static ShapeAppearanceModel captureShapeAppearance(@NonNull View view, @NonNull RectF rectF, @Nullable ShapeAppearanceModel shapeAppearanceModel) {
        ShapeAppearanceModel shapeAppearance = getShapeAppearance(view, shapeAppearanceModel);
        RectF rectF2 = C4469k.f11915a;
        return shapeAppearance.withTransformedCornerSizes(new C4468j(rectF));
    }

    private static void captureValues(@NonNull TransitionValues transitionValues, @Nullable View view, @IdRes int i, @Nullable ShapeAppearanceModel shapeAppearanceModel) {
        RectF rectFM6188c;
        if (i != -1) {
            View view2 = transitionValues.view;
            RectF rectF = C4469k.f11915a;
            View viewFindViewById = view2.findViewById(i);
            if (viewFindViewById == null) {
                viewFindViewById = C4469k.m6187b(view2, i);
            }
            transitionValues.view = viewFindViewById;
        } else if (view != null) {
            transitionValues.view = view;
        } else {
            View view3 = transitionValues.view;
            int i2 = C10817R.id.mtrl_motion_snapshot_view;
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
            RectF rectF2 = C4469k.f11915a;
            rectFM6188c = new RectF(view5.getLeft(), view5.getTop(), view5.getRight(), view5.getBottom());
        } else {
            rectFM6188c = C4469k.m6188c(view5);
        }
        transitionValues.values.put(PROP_BOUNDS, rectFM6188c);
        transitionValues.values.put(PROP_SHAPE_APPEARANCE, captureShapeAppearance(view5, rectFM6188c, shapeAppearanceModel));
    }

    private static float getElevationOrDefault(float f, View view) {
        return f != -1.0f ? f : ViewCompat.getElevation(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static ShapeAppearanceModel getShapeAppearance(@NonNull View view, @Nullable ShapeAppearanceModel shapeAppearanceModel) {
        if (shapeAppearanceModel != null) {
            return shapeAppearanceModel;
        }
        int i = C10817R.id.mtrl_motion_snapshot_view;
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

    private C11046c getThresholdsOrDefault(boolean z2, C11046c c11046c, C11046c c11046c2) {
        if (!z2) {
            c11046c = c11046c2;
        }
        return new C11046c((ProgressThresholds) C4469k.m6186a(this.fadeProgressThresholds, c11046c.f21272a), (ProgressThresholds) C4469k.m6186a(this.scaleProgressThresholds, c11046c.f21273b), (ProgressThresholds) C4469k.m6186a(this.scaleMaskProgressThresholds, c11046c.f21274c), (ProgressThresholds) C4469k.m6186a(this.shapeMaskProgressThresholds, c11046c.f21275d), null);
    }

    @StyleRes
    private static int getTransitionShapeAppearanceResId(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{C10817R.attr.transitionShapeAppearance});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private boolean isEntering(@NonNull RectF rectF, @NonNull RectF rectF2) {
        int i = this.transitionDirection;
        if (i == 0) {
            RectF rectF3 = C4469k.f11915a;
            return rectF2.height() * rectF2.width() > rectF.height() * rectF.width();
        }
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return false;
        }
        StringBuilder sbM833U = C1643a.m833U("Invalid transition direction: ");
        sbM833U.append(this.transitionDirection);
        throw new IllegalArgumentException(sbM833U.toString());
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
        View viewM6187b;
        InterfaceC4459a interfaceC4459a;
        InterfaceC4462d interfaceC4462d;
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
                    viewM6187b = (View) view3.getParent();
                } else {
                    viewM6187b = C4469k.m6187b(view3, this.drawingViewId);
                    view3 = null;
                }
                RectF rectFM6188c = C4469k.m6188c(viewM6187b);
                float f = -rectFM6188c.left;
                float f2 = -rectFM6188c.top;
                RectF rectFCalculateDrawableBounds = calculateDrawableBounds(viewM6187b, view3, f, f2);
                rectF.offset(f, f2);
                rectF2.offset(f, f2);
                boolean zIsEntering = isEntering(rectF, rectF2);
                PathMotion pathMotion = getPathMotion();
                float elevationOrDefault = getElevationOrDefault(this.startElevation, view);
                float elevationOrDefault2 = getElevationOrDefault(this.endElevation, view2);
                int i = this.containerColor;
                int i2 = this.startContainerColor;
                int i3 = this.endContainerColor;
                View view4 = viewM6187b;
                int i4 = this.scrimColor;
                boolean z2 = this.elevationShadowEnabled;
                int i5 = this.fadeMode;
                boolean z3 = true;
                if (i5 == 0) {
                    interfaceC4459a = zIsEntering ? C4460b.f11894a : C4460b.f11895b;
                } else if (i5 == 1) {
                    interfaceC4459a = zIsEntering ? C4460b.f11895b : C4460b.f11894a;
                } else if (i5 == 2) {
                    interfaceC4459a = C4460b.f11896c;
                } else {
                    if (i5 != 3) {
                        throw new IllegalArgumentException(C1643a.m871q("Invalid fade mode: ", i5));
                    }
                    interfaceC4459a = C4460b.f11897d;
                }
                InterfaceC4459a interfaceC4459a2 = interfaceC4459a;
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
                    interfaceC4462d = z3 ? C4463e.f11901a : C4463e.f11902b;
                } else if (i6 == 1) {
                    interfaceC4462d = C4463e.f11901a;
                } else {
                    if (i6 != 2) {
                        throw new IllegalArgumentException(C1643a.m871q("Invalid fit mode: ", i6));
                    }
                    interfaceC4462d = C4463e.f11902b;
                }
                C11047d c11047d = new C11047d(pathMotion, view, rectF, shapeAppearanceModel, elevationOrDefault, view2, rectF2, shapeAppearanceModel2, elevationOrDefault2, i, i2, i3, i4, zIsEntering, z2, interfaceC4459a2, interfaceC4462d, buildThresholdsGroup(zIsEntering), this.drawDebugEnabled, null);
                c11047d.setBounds(Math.round(rectFCalculateDrawableBounds.left), Math.round(rectFCalculateDrawableBounds.top), Math.round(rectFCalculateDrawableBounds.right), Math.round(rectFCalculateDrawableBounds.bottom));
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat.addUpdateListener(new C11044a(this, c11047d));
                addListener(new C11045b(view4, c11047d, view, view2));
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
