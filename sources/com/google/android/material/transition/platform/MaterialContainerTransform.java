package com.google.android.material.transition.platform;

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
import android.transition.ArcMotion;
import android.transition.PathMotion;
import android.transition.Transition;
import android.transition.TransitionValues;
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
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
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
import p007b.p225i.p226a.p341g.p353l.p354l.AbstractC4478i;
import p007b.p225i.p226a.p341g.p353l.p354l.C4471b;
import p007b.p225i.p226a.p341g.p353l.p354l.C4472c;
import p007b.p225i.p226a.p341g.p353l.p354l.C4474e;
import p007b.p225i.p226a.p341g.p353l.p354l.C4475f;
import p007b.p225i.p226a.p341g.p353l.p354l.C4476g;
import p007b.p225i.p226a.p341g.p353l.p354l.C4479j;
import p007b.p225i.p226a.p341g.p353l.p354l.C4480k;
import p007b.p225i.p226a.p341g.p353l.p354l.InterfaceC4470a;
import p007b.p225i.p226a.p341g.p353l.p354l.InterfaceC4473d;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
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
    private static final C11057c DEFAULT_ENTER_THRESHOLDS = new C11057c(new ProgressThresholds(0.0f, 0.25f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.75f), null);
    private static final C11057c DEFAULT_RETURN_THRESHOLDS = new C11057c(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.3f, 0.9f), null);
    private static final C11057c DEFAULT_ENTER_THRESHOLDS_ARC = new C11057c(new ProgressThresholds(0.1f, 0.4f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 0.9f), null);
    private static final C11057c DEFAULT_RETURN_THRESHOLDS_ARC = new C11057c(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.2f, 0.9f), null);
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

    /* JADX INFO: renamed from: com.google.android.material.transition.platform.MaterialContainerTransform$a */
    public class C11055a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ C11058d f21340a;

        public C11055a(MaterialContainerTransform materialContainerTransform, C11058d c11058d) {
            this.f21340a = c11058d;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            C11058d c11058d = this.f21340a;
            float animatedFraction = valueAnimator.getAnimatedFraction();
            if (c11058d.f21361L != animatedFraction) {
                c11058d.m9174e(animatedFraction);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.transition.platform.MaterialContainerTransform$b */
    public class C11056b extends AbstractC4478i {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ View f21341a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ C11058d f21342b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ View f21343c;

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ View f21344d;

        public C11056b(View view, C11058d c11058d, View view2, View view3) {
            this.f21341a = view;
            this.f21342b = c11058d;
            this.f21343c = view2;
            this.f21344d = view3;
        }

        @Override // p007b.p225i.p226a.p341g.p353l.p354l.AbstractC4478i, android.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            MaterialContainerTransform.this.removeListener(this);
            if (MaterialContainerTransform.this.holdAtEndEnabled) {
                return;
            }
            this.f21343c.setAlpha(1.0f);
            this.f21344d.setAlpha(1.0f);
            ViewUtils.getOverlay(this.f21341a).remove(this.f21342b);
        }

        @Override // p007b.p225i.p226a.p341g.p353l.p354l.AbstractC4478i, android.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
            ViewUtils.getOverlay(this.f21341a).add(this.f21342b);
            this.f21343c.setAlpha(0.0f);
            this.f21344d.setAlpha(0.0f);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.transition.platform.MaterialContainerTransform$c */
    public static class C11057c {

        /* JADX INFO: renamed from: a */
        @NonNull
        public final ProgressThresholds f21346a;

        /* JADX INFO: renamed from: b */
        @NonNull
        public final ProgressThresholds f21347b;

        /* JADX INFO: renamed from: c */
        @NonNull
        public final ProgressThresholds f21348c;

        /* JADX INFO: renamed from: d */
        @NonNull
        public final ProgressThresholds f21349d;

        public C11057c(ProgressThresholds progressThresholds, ProgressThresholds progressThresholds2, ProgressThresholds progressThresholds3, ProgressThresholds progressThresholds4, C11055a c11055a) {
            this.f21346a = progressThresholds;
            this.f21347b = progressThresholds2;
            this.f21348c = progressThresholds3;
            this.f21349d = progressThresholds4;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.transition.platform.MaterialContainerTransform$d */
    public static final class C11058d extends Drawable {

        /* JADX INFO: renamed from: A */
        public final C11057c f21350A;

        /* JADX INFO: renamed from: B */
        public final InterfaceC4470a f21351B;

        /* JADX INFO: renamed from: C */
        public final InterfaceC4473d f21352C;

        /* JADX INFO: renamed from: D */
        public final boolean f21353D;

        /* JADX INFO: renamed from: E */
        public final Paint f21354E;

        /* JADX INFO: renamed from: F */
        public final Path f21355F;

        /* JADX INFO: renamed from: G */
        public C4472c f21356G;

        /* JADX INFO: renamed from: H */
        public C4475f f21357H;

        /* JADX INFO: renamed from: I */
        public RectF f21358I;

        /* JADX INFO: renamed from: J */
        public float f21359J;

        /* JADX INFO: renamed from: K */
        public float f21360K;

        /* JADX INFO: renamed from: L */
        public float f21361L;

        /* JADX INFO: renamed from: a */
        public final View f21362a;

        /* JADX INFO: renamed from: b */
        public final RectF f21363b;

        /* JADX INFO: renamed from: c */
        public final ShapeAppearanceModel f21364c;

        /* JADX INFO: renamed from: d */
        public final float f21365d;

        /* JADX INFO: renamed from: e */
        public final View f21366e;

        /* JADX INFO: renamed from: f */
        public final RectF f21367f;

        /* JADX INFO: renamed from: g */
        public final ShapeAppearanceModel f21368g;

        /* JADX INFO: renamed from: h */
        public final float f21369h;

        /* JADX INFO: renamed from: i */
        public final Paint f21370i;

        /* JADX INFO: renamed from: j */
        public final Paint f21371j;

        /* JADX INFO: renamed from: k */
        public final Paint f21372k;

        /* JADX INFO: renamed from: l */
        public final Paint f21373l;

        /* JADX INFO: renamed from: m */
        public final Paint f21374m;

        /* JADX INFO: renamed from: n */
        public final C4476g f21375n;

        /* JADX INFO: renamed from: o */
        public final PathMeasure f21376o;

        /* JADX INFO: renamed from: p */
        public final float f21377p;

        /* JADX INFO: renamed from: q */
        public final float[] f21378q;

        /* JADX INFO: renamed from: r */
        public final boolean f21379r;

        /* JADX INFO: renamed from: s */
        public final float f21380s;

        /* JADX INFO: renamed from: t */
        public final float f21381t;

        /* JADX INFO: renamed from: u */
        public final boolean f21382u;

        /* JADX INFO: renamed from: v */
        public final MaterialShapeDrawable f21383v;

        /* JADX INFO: renamed from: w */
        public final RectF f21384w;

        /* JADX INFO: renamed from: x */
        public final RectF f21385x;

        /* JADX INFO: renamed from: y */
        public final RectF f21386y;

        /* JADX INFO: renamed from: z */
        public final RectF f21387z;

        /* JADX INFO: renamed from: com.google.android.material.transition.platform.MaterialContainerTransform$d$a */
        public class a implements C4480k.a {
            public a() {
            }

            @Override // p007b.p225i.p226a.p341g.p353l.p354l.C4480k.a
            /* JADX INFO: renamed from: a */
            public void mo6208a(Canvas canvas) {
                C11058d.this.f21362a.draw(canvas);
            }
        }

        /* JADX INFO: renamed from: com.google.android.material.transition.platform.MaterialContainerTransform$d$b */
        public class b implements C4480k.a {
            public b() {
            }

            @Override // p007b.p225i.p226a.p341g.p353l.p354l.C4480k.a
            /* JADX INFO: renamed from: a */
            public void mo6208a(Canvas canvas) {
                C11058d.this.f21366e.draw(canvas);
            }
        }

        public C11058d(PathMotion pathMotion, View view, RectF rectF, ShapeAppearanceModel shapeAppearanceModel, float f, View view2, RectF rectF2, ShapeAppearanceModel shapeAppearanceModel2, float f2, int i, int i2, int i3, int i4, boolean z2, boolean z3, InterfaceC4470a interfaceC4470a, InterfaceC4473d interfaceC4473d, C11057c c11057c, boolean z4, C11055a c11055a) {
            Paint paint = new Paint();
            this.f21370i = paint;
            Paint paint2 = new Paint();
            this.f21371j = paint2;
            Paint paint3 = new Paint();
            this.f21372k = paint3;
            this.f21373l = new Paint();
            Paint paint4 = new Paint();
            this.f21374m = paint4;
            this.f21375n = new C4476g();
            this.f21378q = new float[]{rectF.centerX(), rectF.top};
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            this.f21383v = materialShapeDrawable;
            Paint paint5 = new Paint();
            this.f21354E = paint5;
            this.f21355F = new Path();
            this.f21362a = view;
            this.f21363b = rectF;
            this.f21364c = shapeAppearanceModel;
            this.f21365d = f;
            this.f21366e = view2;
            this.f21367f = rectF2;
            this.f21368g = shapeAppearanceModel2;
            this.f21369h = f2;
            this.f21379r = z2;
            this.f21382u = z3;
            this.f21351B = interfaceC4470a;
            this.f21352C = interfaceC4473d;
            this.f21350A = c11057c;
            this.f21353D = z4;
            WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            this.f21380s = displayMetrics.widthPixels;
            this.f21381t = displayMetrics.heightPixels;
            paint.setColor(i);
            paint2.setColor(i2);
            paint3.setColor(i3);
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(0));
            materialShapeDrawable.setShadowCompatibilityMode(2);
            materialShapeDrawable.setShadowBitmapDrawingEnable(false);
            materialShapeDrawable.setShadowColor(-7829368);
            RectF rectF3 = new RectF(rectF);
            this.f21384w = rectF3;
            this.f21385x = new RectF(rectF3);
            RectF rectF4 = new RectF(rectF3);
            this.f21386y = rectF4;
            this.f21387z = new RectF(rectF4);
            PointF pointFM9170c = m9170c(rectF);
            PointF pointFM9170c2 = m9170c(rectF2);
            PathMeasure pathMeasure = new PathMeasure(pathMotion.getPath(pointFM9170c.x, pointFM9170c.y, pointFM9170c2.x, pointFM9170c2.y), false);
            this.f21376o = pathMeasure;
            this.f21377p = pathMeasure.getLength();
            paint4.setStyle(Paint.Style.FILL);
            RectF rectF5 = C4480k.f11937a;
            paint4.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i4, i4, Shader.TileMode.CLAMP));
            paint5.setStyle(Paint.Style.STROKE);
            paint5.setStrokeWidth(10.0f);
            m9174e(0.0f);
        }

        /* JADX INFO: renamed from: c */
        public static PointF m9170c(RectF rectF) {
            return new PointF(rectF.centerX(), rectF.top);
        }

        /* JADX INFO: renamed from: a */
        public final void m9171a(Canvas canvas) {
            m9173d(canvas, this.f21372k);
            Rect bounds = getBounds();
            RectF rectF = this.f21386y;
            C4480k.m6207h(canvas, bounds, rectF.left, rectF.top, this.f21357H.f11926b, this.f21356G.f11921b, new b());
        }

        /* JADX INFO: renamed from: b */
        public final void m9172b(Canvas canvas) {
            m9173d(canvas, this.f21371j);
            Rect bounds = getBounds();
            RectF rectF = this.f21384w;
            C4480k.m6207h(canvas, bounds, rectF.left, rectF.top, this.f21357H.f11925a, this.f21356G.f11920a, new a());
        }

        /* JADX INFO: renamed from: d */
        public final void m9173d(Canvas canvas, Paint paint) {
            if (paint.getColor() == 0 || paint.getAlpha() <= 0) {
                return;
            }
            canvas.drawRect(getBounds(), paint);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            if (this.f21374m.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.f21374m);
            }
            int iSave = this.f21353D ? canvas.save() : -1;
            if (this.f21382u && this.f21359J > 0.0f) {
                canvas.save();
                canvas.clipPath(this.f21375n.f11931a, Region.Op.DIFFERENCE);
                if (Build.VERSION.SDK_INT > 28) {
                    ShapeAppearanceModel shapeAppearanceModel = this.f21375n.f11935e;
                    if (shapeAppearanceModel.isRoundRect(this.f21358I)) {
                        float cornerSize = shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.f21358I);
                        canvas.drawRoundRect(this.f21358I, cornerSize, cornerSize, this.f21373l);
                    } else {
                        canvas.drawPath(this.f21375n.f11931a, this.f21373l);
                    }
                } else {
                    MaterialShapeDrawable materialShapeDrawable = this.f21383v;
                    RectF rectF = this.f21358I;
                    materialShapeDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                    this.f21383v.setElevation(this.f21359J);
                    this.f21383v.setShadowVerticalOffset((int) this.f21360K);
                    this.f21383v.setShapeAppearanceModel(this.f21375n.f11935e);
                    this.f21383v.draw(canvas);
                }
                canvas.restore();
            }
            C4476g c4476g = this.f21375n;
            if (Build.VERSION.SDK_INT >= 23) {
                canvas.clipPath(c4476g.f11931a);
            } else {
                canvas.clipPath(c4476g.f11932b);
                canvas.clipPath(c4476g.f11933c, Region.Op.UNION);
            }
            m9173d(canvas, this.f21370i);
            if (this.f21356G.f11922c) {
                m9172b(canvas);
                m9171a(canvas);
            } else {
                m9171a(canvas);
                m9172b(canvas);
            }
            if (this.f21353D) {
                canvas.restoreToCount(iSave);
                RectF rectF2 = this.f21384w;
                Path path = this.f21355F;
                PointF pointFM9170c = m9170c(rectF2);
                if (this.f21361L == 0.0f) {
                    path.reset();
                    path.moveTo(pointFM9170c.x, pointFM9170c.y);
                } else {
                    path.lineTo(pointFM9170c.x, pointFM9170c.y);
                    this.f21354E.setColor(-65281);
                    canvas.drawPath(path, this.f21354E);
                }
                RectF rectF3 = this.f21385x;
                this.f21354E.setColor(InputDeviceCompat.SOURCE_ANY);
                canvas.drawRect(rectF3, this.f21354E);
                RectF rectF4 = this.f21384w;
                this.f21354E.setColor(-16711936);
                canvas.drawRect(rectF4, this.f21354E);
                RectF rectF5 = this.f21387z;
                this.f21354E.setColor(-16711681);
                canvas.drawRect(rectF5, this.f21354E);
                RectF rectF6 = this.f21386y;
                this.f21354E.setColor(-16776961);
                canvas.drawRect(rectF6, this.f21354E);
            }
        }

        /* JADX INFO: renamed from: e */
        public final void m9174e(float f) {
            float f2;
            float f3;
            this.f21361L = f;
            this.f21374m.setAlpha((int) (this.f21379r ? C4480k.m6203d(0.0f, 255.0f, f) : C4480k.m6203d(255.0f, 0.0f, f)));
            this.f21376o.getPosTan(this.f21377p * f, this.f21378q, null);
            float[] fArr = this.f21378q;
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
                this.f21376o.getPosTan(this.f21377p * f2, fArr, null);
                float[] fArr2 = this.f21378q;
                float f4 = fArr2[0];
                float f5 = fArr2[1];
                fM839a = C1643a.m839a(fM839a, f4, f3, fM839a);
                fM839a2 = C1643a.m839a(fM839a2, f5, f3, fM839a2);
            }
            float f6 = fM839a;
            float f7 = fM839a2;
            C4475f c4475fMo6197a = this.f21352C.mo6197a(f, ((Float) Preconditions.checkNotNull(Float.valueOf(this.f21350A.f21347b.start))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.f21350A.f21347b.end))).floatValue(), this.f21363b.width(), this.f21363b.height(), this.f21367f.width(), this.f21367f.height());
            this.f21357H = c4475fMo6197a;
            RectF rectF = this.f21384w;
            float f8 = c4475fMo6197a.f11927c / 2.0f;
            rectF.set(f6 - f8, f7, f8 + f6, c4475fMo6197a.f11928d + f7);
            RectF rectF2 = this.f21386y;
            C4475f c4475f = this.f21357H;
            float f9 = c4475f.f11929e / 2.0f;
            rectF2.set(f6 - f9, f7, f9 + f6, c4475f.f11930f + f7);
            this.f21385x.set(this.f21384w);
            this.f21387z.set(this.f21386y);
            float fFloatValue = ((Float) Preconditions.checkNotNull(Float.valueOf(this.f21350A.f21348c.start))).floatValue();
            float fFloatValue2 = ((Float) Preconditions.checkNotNull(Float.valueOf(this.f21350A.f21348c.end))).floatValue();
            boolean zMo6198b = this.f21352C.mo6198b(this.f21357H);
            RectF rectF3 = zMo6198b ? this.f21385x : this.f21387z;
            float fM6204e = C4480k.m6204e(0.0f, 1.0f, fFloatValue, fFloatValue2, f);
            if (!zMo6198b) {
                fM6204e = 1.0f - fM6204e;
            }
            this.f21352C.mo6199c(rectF3, fM6204e, this.f21357H);
            this.f21358I = new RectF(Math.min(this.f21385x.left, this.f21387z.left), Math.min(this.f21385x.top, this.f21387z.top), Math.max(this.f21385x.right, this.f21387z.right), Math.max(this.f21385x.bottom, this.f21387z.bottom));
            C4476g c4476g = this.f21375n;
            ShapeAppearanceModel shapeAppearanceModelBuild = this.f21364c;
            ShapeAppearanceModel shapeAppearanceModel = this.f21368g;
            RectF rectF4 = this.f21384w;
            RectF rectF5 = this.f21385x;
            RectF rectF6 = this.f21387z;
            ProgressThresholds progressThresholds = this.f21350A.f21349d;
            Objects.requireNonNull(c4476g);
            float start = progressThresholds.getStart();
            float end = progressThresholds.getEnd();
            RectF rectF7 = C4480k.f11937a;
            if (f >= start) {
                if (f > end) {
                    shapeAppearanceModelBuild = shapeAppearanceModel;
                } else {
                    shapeAppearanceModelBuild = ((shapeAppearanceModelBuild.getTopLeftCornerSize().getCornerSize(rectF4) == 0.0f && shapeAppearanceModelBuild.getTopRightCornerSize().getCornerSize(rectF4) == 0.0f && shapeAppearanceModelBuild.getBottomRightCornerSize().getCornerSize(rectF4) == 0.0f && shapeAppearanceModelBuild.getBottomLeftCornerSize().getCornerSize(rectF4) == 0.0f) ? false : true ? shapeAppearanceModelBuild : shapeAppearanceModel).toBuilder().setTopLeftCornerSize(new AbsoluteCornerSize(C4480k.m6204e(shapeAppearanceModelBuild.getTopLeftCornerSize().getCornerSize(rectF4), shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(rectF6), start, end, f))).setTopRightCornerSize(new AbsoluteCornerSize(C4480k.m6204e(shapeAppearanceModelBuild.getTopRightCornerSize().getCornerSize(rectF4), shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF6), start, end, f))).setBottomLeftCornerSize(new AbsoluteCornerSize(C4480k.m6204e(shapeAppearanceModelBuild.getBottomLeftCornerSize().getCornerSize(rectF4), shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(rectF6), start, end, f))).setBottomRightCornerSize(new AbsoluteCornerSize(C4480k.m6204e(shapeAppearanceModelBuild.getBottomRightCornerSize().getCornerSize(rectF4), shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(rectF6), start, end, f))).build();
                }
            }
            c4476g.f11935e = shapeAppearanceModelBuild;
            c4476g.f11934d.calculatePath(shapeAppearanceModelBuild, 1.0f, rectF5, c4476g.f11932b);
            c4476g.f11934d.calculatePath(c4476g.f11935e, 1.0f, rectF6, c4476g.f11933c);
            if (Build.VERSION.SDK_INT >= 23) {
                c4476g.f11931a.op(c4476g.f11932b, c4476g.f11933c, Path.Op.UNION);
            }
            this.f21359J = C4480k.m6203d(this.f21365d, this.f21369h, f);
            float fCenterX = ((this.f21358I.centerX() / (this.f21380s / 2.0f)) - 1.0f) * 0.3f;
            float fCenterY = (this.f21358I.centerY() / this.f21381t) * 1.5f;
            float f10 = this.f21359J;
            float f11 = (int) (fCenterY * f10);
            this.f21360K = f11;
            this.f21373l.setShadowLayer(f10, (int) (fCenterX * f10), f11, 754974720);
            this.f21356G = this.f21351B.mo6195a(f, ((Float) Preconditions.checkNotNull(Float.valueOf(this.f21350A.f21346a.start))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.f21350A.f21346a.end))).floatValue());
            if (this.f21371j.getColor() != 0) {
                this.f21371j.setAlpha(this.f21356G.f11920a);
            }
            if (this.f21372k.getColor() != 0) {
                this.f21372k.setAlpha(this.f21356G.f11921b);
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

    private C11057c buildThresholdsGroup(boolean z2) {
        PathMotion pathMotion = getPathMotion();
        return ((pathMotion instanceof ArcMotion) || (pathMotion instanceof MaterialArcMotion)) ? getThresholdsOrDefault(z2, DEFAULT_ENTER_THRESHOLDS_ARC, DEFAULT_RETURN_THRESHOLDS_ARC) : getThresholdsOrDefault(z2, DEFAULT_ENTER_THRESHOLDS, DEFAULT_RETURN_THRESHOLDS);
    }

    private static RectF calculateDrawableBounds(View view, @Nullable View view2, float f, float f2) {
        if (view2 == null) {
            return new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        }
        RectF rectFM6202c = C4480k.m6202c(view2);
        rectFM6202c.offset(f, f2);
        return rectFM6202c;
    }

    private static ShapeAppearanceModel captureShapeAppearance(@NonNull View view, @NonNull RectF rectF, @Nullable ShapeAppearanceModel shapeAppearanceModel) {
        ShapeAppearanceModel shapeAppearance = getShapeAppearance(view, shapeAppearanceModel);
        RectF rectF2 = C4480k.f11937a;
        return shapeAppearance.withTransformedCornerSizes(new C4479j(rectF));
    }

    private static void captureValues(@NonNull TransitionValues transitionValues, @Nullable View view, @IdRes int i, @Nullable ShapeAppearanceModel shapeAppearanceModel) {
        RectF rectFM6202c;
        if (i != -1) {
            View view2 = transitionValues.view;
            RectF rectF = C4480k.f11937a;
            View viewFindViewById = view2.findViewById(i);
            if (viewFindViewById == null) {
                viewFindViewById = C4480k.m6201b(view2, i);
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
            RectF rectF2 = C4480k.f11937a;
            rectFM6202c = new RectF(view5.getLeft(), view5.getTop(), view5.getRight(), view5.getBottom());
        } else {
            rectFM6202c = C4480k.m6202c(view5);
        }
        transitionValues.values.put(PROP_BOUNDS, rectFM6202c);
        transitionValues.values.put(PROP_SHAPE_APPEARANCE, captureShapeAppearance(view5, rectFM6202c, shapeAppearanceModel));
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

    private C11057c getThresholdsOrDefault(boolean z2, C11057c c11057c, C11057c c11057c2) {
        if (!z2) {
            c11057c = c11057c2;
        }
        return new C11057c((ProgressThresholds) C4480k.m6200a(this.fadeProgressThresholds, c11057c.f21346a), (ProgressThresholds) C4480k.m6200a(this.scaleProgressThresholds, c11057c.f21347b), (ProgressThresholds) C4480k.m6200a(this.scaleMaskProgressThresholds, c11057c.f21348c), (ProgressThresholds) C4480k.m6200a(this.shapeMaskProgressThresholds, c11057c.f21349d), null);
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
            RectF rectF3 = C4480k.f11937a;
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

    @Override // android.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues, this.endView, this.endViewId, this.endShapeAppearanceModel);
    }

    @Override // android.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues, this.startView, this.startViewId, this.startShapeAppearanceModel);
    }

    @Override // android.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        View viewM6201b;
        InterfaceC4470a interfaceC4470a;
        InterfaceC4473d interfaceC4473d;
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
                    viewM6201b = (View) view3.getParent();
                } else {
                    viewM6201b = C4480k.m6201b(view3, this.drawingViewId);
                    view3 = null;
                }
                RectF rectFM6202c = C4480k.m6202c(viewM6201b);
                float f = -rectFM6202c.left;
                float f2 = -rectFM6202c.top;
                RectF rectFCalculateDrawableBounds = calculateDrawableBounds(viewM6201b, view3, f, f2);
                rectF.offset(f, f2);
                rectF2.offset(f, f2);
                boolean zIsEntering = isEntering(rectF, rectF2);
                PathMotion pathMotion = getPathMotion();
                float elevationOrDefault = getElevationOrDefault(this.startElevation, view);
                float elevationOrDefault2 = getElevationOrDefault(this.endElevation, view2);
                int i = this.containerColor;
                int i2 = this.startContainerColor;
                int i3 = this.endContainerColor;
                View view4 = viewM6201b;
                int i4 = this.scrimColor;
                boolean z2 = this.elevationShadowEnabled;
                int i5 = this.fadeMode;
                boolean z3 = true;
                if (i5 == 0) {
                    interfaceC4470a = zIsEntering ? C4471b.f11916a : C4471b.f11917b;
                } else if (i5 == 1) {
                    interfaceC4470a = zIsEntering ? C4471b.f11917b : C4471b.f11916a;
                } else if (i5 == 2) {
                    interfaceC4470a = C4471b.f11918c;
                } else {
                    if (i5 != 3) {
                        throw new IllegalArgumentException(C1643a.m871q("Invalid fade mode: ", i5));
                    }
                    interfaceC4470a = C4471b.f11919d;
                }
                InterfaceC4470a interfaceC4470a2 = interfaceC4470a;
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
                    interfaceC4473d = z3 ? C4474e.f11923a : C4474e.f11924b;
                } else if (i6 == 1) {
                    interfaceC4473d = C4474e.f11923a;
                } else {
                    if (i6 != 2) {
                        throw new IllegalArgumentException(C1643a.m871q("Invalid fit mode: ", i6));
                    }
                    interfaceC4473d = C4474e.f11924b;
                }
                C11058d c11058d = new C11058d(pathMotion, view, rectF, shapeAppearanceModel, elevationOrDefault, view2, rectF2, shapeAppearanceModel2, elevationOrDefault2, i, i2, i3, i4, zIsEntering, z2, interfaceC4470a2, interfaceC4473d, buildThresholdsGroup(zIsEntering), this.drawDebugEnabled, null);
                c11058d.setBounds(Math.round(rectFCalculateDrawableBounds.left), Math.round(rectFCalculateDrawableBounds.top), Math.round(rectFCalculateDrawableBounds.right), Math.round(rectFCalculateDrawableBounds.bottom));
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat.addUpdateListener(new C11055a(this, c11058d));
                addListener(new C11056b(view4, c11058d, view, view2));
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

    @Override // android.transition.Transition
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
