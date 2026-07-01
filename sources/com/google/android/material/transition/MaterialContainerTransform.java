package com.google.android.material.transition;

import android.R$id;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build$VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.view.ViewCompat;
import androidx.transition.ArcMotion;
import androidx.transition.PathMotion;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import b.d.b.a.a;
import b.i.a.g.l.b;
import b.i.a.g.l.d;
import b.i.a.g.l.e;
import b.i.a.g.l.j;
import b.i.a.g.l.k;
import com.google.android.material.R$attr;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

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
    private MaterialContainerTransform$ProgressThresholds fadeProgressThresholds;

    @Nullable
    private MaterialContainerTransform$ProgressThresholds scaleMaskProgressThresholds;

    @Nullable
    private MaterialContainerTransform$ProgressThresholds scaleProgressThresholds;

    @Nullable
    private MaterialContainerTransform$ProgressThresholds shapeMaskProgressThresholds;
    private float startElevation;

    @Nullable
    private ShapeAppearanceModel startShapeAppearanceModel;

    @Nullable
    private View startView;
    private static final String TAG = MaterialContainerTransform.class.getSimpleName();
    private static final String PROP_BOUNDS = "materialContainerTransition:bounds";
    private static final String PROP_SHAPE_APPEARANCE = "materialContainerTransition:shapeAppearance";
    private static final String[] TRANSITION_PROPS = {PROP_BOUNDS, PROP_SHAPE_APPEARANCE};
    private static final MaterialContainerTransform$c DEFAULT_ENTER_THRESHOLDS = new MaterialContainerTransform$c(new MaterialContainerTransform$ProgressThresholds(0.0f, 0.25f), new MaterialContainerTransform$ProgressThresholds(0.0f, 1.0f), new MaterialContainerTransform$ProgressThresholds(0.0f, 1.0f), new MaterialContainerTransform$ProgressThresholds(0.0f, 0.75f), null);
    private static final MaterialContainerTransform$c DEFAULT_RETURN_THRESHOLDS = new MaterialContainerTransform$c(new MaterialContainerTransform$ProgressThresholds(0.6f, 0.9f), new MaterialContainerTransform$ProgressThresholds(0.0f, 1.0f), new MaterialContainerTransform$ProgressThresholds(0.0f, 0.9f), new MaterialContainerTransform$ProgressThresholds(0.3f, 0.9f), null);
    private static final MaterialContainerTransform$c DEFAULT_ENTER_THRESHOLDS_ARC = new MaterialContainerTransform$c(new MaterialContainerTransform$ProgressThresholds(0.1f, 0.4f), new MaterialContainerTransform$ProgressThresholds(0.1f, 1.0f), new MaterialContainerTransform$ProgressThresholds(0.1f, 1.0f), new MaterialContainerTransform$ProgressThresholds(0.1f, 0.9f), null);
    private static final MaterialContainerTransform$c DEFAULT_RETURN_THRESHOLDS_ARC = new MaterialContainerTransform$c(new MaterialContainerTransform$ProgressThresholds(0.6f, 0.9f), new MaterialContainerTransform$ProgressThresholds(0.0f, 0.9f), new MaterialContainerTransform$ProgressThresholds(0.0f, 0.9f), new MaterialContainerTransform$ProgressThresholds(0.2f, 0.9f), null);
    private boolean drawDebugEnabled = false;
    private boolean holdAtEndEnabled = false;

    @IdRes
    private int drawingViewId = R$id.content;

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

    public MaterialContainerTransform() {
        this.elevationShadowEnabled = Build$VERSION.SDK_INT >= 28;
        this.startElevation = -1.0f;
        this.endElevation = -1.0f;
        setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }

    public static /* synthetic */ boolean access$300(MaterialContainerTransform materialContainerTransform) {
        return materialContainerTransform.holdAtEndEnabled;
    }

    private MaterialContainerTransform$c buildThresholdsGroup(boolean z2) {
        PathMotion pathMotion = getPathMotion();
        return ((pathMotion instanceof ArcMotion) || (pathMotion instanceof MaterialArcMotion)) ? getThresholdsOrDefault(z2, DEFAULT_ENTER_THRESHOLDS_ARC, DEFAULT_RETURN_THRESHOLDS_ARC) : getThresholdsOrDefault(z2, DEFAULT_ENTER_THRESHOLDS, DEFAULT_RETURN_THRESHOLDS);
    }

    private static RectF calculateDrawableBounds(View view, @Nullable View view2, float f, float f2) {
        if (view2 == null) {
            return new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        }
        RectF rectFC = k.c(view2);
        rectFC.offset(f, f2);
        return rectFC;
    }

    private static ShapeAppearanceModel captureShapeAppearance(@NonNull View view, @NonNull RectF rectF, @Nullable ShapeAppearanceModel shapeAppearanceModel) {
        ShapeAppearanceModel shapeAppearance = getShapeAppearance(view, shapeAppearanceModel);
        RectF rectF2 = k.a;
        return shapeAppearance.withTransformedCornerSizes(new j(rectF));
    }

    private static void captureValues(@NonNull TransitionValues transitionValues, @Nullable View view, @IdRes int i, @Nullable ShapeAppearanceModel shapeAppearanceModel) {
        RectF rectFC;
        if (i != -1) {
            View view2 = transitionValues.view;
            RectF rectF = k.a;
            View viewFindViewById = view2.findViewById(i);
            if (viewFindViewById == null) {
                viewFindViewById = k.b(view2, i);
            }
            transitionValues.view = viewFindViewById;
        } else if (view != null) {
            transitionValues.view = view;
        } else {
            View view3 = transitionValues.view;
            int i2 = com.google.android.material.R$id.mtrl_motion_snapshot_view;
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
            RectF rectF2 = k.a;
            rectFC = new RectF(view5.getLeft(), view5.getTop(), view5.getRight(), view5.getBottom());
        } else {
            rectFC = k.c(view5);
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
        int i = com.google.android.material.R$id.mtrl_motion_snapshot_view;
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

    private MaterialContainerTransform$c getThresholdsOrDefault(boolean z2, MaterialContainerTransform$c materialContainerTransform$c, MaterialContainerTransform$c materialContainerTransform$c2) {
        if (!z2) {
            materialContainerTransform$c = materialContainerTransform$c2;
        }
        return new MaterialContainerTransform$c((MaterialContainerTransform$ProgressThresholds) k.a(this.fadeProgressThresholds, materialContainerTransform$c.a), (MaterialContainerTransform$ProgressThresholds) k.a(this.scaleProgressThresholds, materialContainerTransform$c.f3086b), (MaterialContainerTransform$ProgressThresholds) k.a(this.scaleMaskProgressThresholds, materialContainerTransform$c.c), (MaterialContainerTransform$ProgressThresholds) k.a(this.shapeMaskProgressThresholds, materialContainerTransform$c.d), null);
    }

    @StyleRes
    private static int getTransitionShapeAppearanceResId(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{R$attr.transitionShapeAppearance});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private boolean isEntering(@NonNull RectF rectF, @NonNull RectF rectF2) {
        int i = this.transitionDirection;
        if (i == 0) {
            RectF rectF3 = k.a;
            return rectF2.height() * rectF2.width() > rectF.height() * rectF.width();
        }
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return false;
        }
        StringBuilder sbU = a.U("Invalid transition direction: ");
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
        b.i.a.g.l.a aVar;
        d dVar;
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
                    viewB = k.b(view3, this.drawingViewId);
                    view3 = null;
                }
                RectF rectFC = k.c(viewB);
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
                    aVar = zIsEntering ? b.a : b.f1631b;
                } else if (i5 == 1) {
                    aVar = zIsEntering ? b.f1631b : b.a;
                } else if (i5 == 2) {
                    aVar = b.c;
                } else {
                    if (i5 != 3) {
                        throw new IllegalArgumentException(a.q("Invalid fade mode: ", i5));
                    }
                    aVar = b.d;
                }
                b.i.a.g.l.a aVar2 = aVar;
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
                    dVar = z3 ? e.a : e.f1633b;
                } else if (i6 == 1) {
                    dVar = e.a;
                } else {
                    if (i6 != 2) {
                        throw new IllegalArgumentException(a.q("Invalid fit mode: ", i6));
                    }
                    dVar = e.f1633b;
                }
                MaterialContainerTransform$d materialContainerTransform$d = new MaterialContainerTransform$d(pathMotion, view, rectF, shapeAppearanceModel, elevationOrDefault, view2, rectF2, shapeAppearanceModel2, elevationOrDefault2, i, i2, i3, i4, zIsEntering, z2, aVar2, dVar, buildThresholdsGroup(zIsEntering), this.drawDebugEnabled, null);
                materialContainerTransform$d.setBounds(Math.round(rectFCalculateDrawableBounds.left), Math.round(rectFCalculateDrawableBounds.top), Math.round(rectFCalculateDrawableBounds.right), Math.round(rectFCalculateDrawableBounds.bottom));
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat.addUpdateListener(new MaterialContainerTransform$a(this, materialContainerTransform$d));
                addListener(new MaterialContainerTransform$b(this, view4, materialContainerTransform$d, view, view2));
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
    public MaterialContainerTransform$ProgressThresholds getFadeProgressThresholds() {
        return this.fadeProgressThresholds;
    }

    public int getFitMode() {
        return this.fitMode;
    }

    @Nullable
    public MaterialContainerTransform$ProgressThresholds getScaleMaskProgressThresholds() {
        return this.scaleMaskProgressThresholds;
    }

    @Nullable
    public MaterialContainerTransform$ProgressThresholds getScaleProgressThresholds() {
        return this.scaleProgressThresholds;
    }

    @ColorInt
    public int getScrimColor() {
        return this.scrimColor;
    }

    @Nullable
    public MaterialContainerTransform$ProgressThresholds getShapeMaskProgressThresholds() {
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

    public void setFadeProgressThresholds(@Nullable MaterialContainerTransform$ProgressThresholds materialContainerTransform$ProgressThresholds) {
        this.fadeProgressThresholds = materialContainerTransform$ProgressThresholds;
    }

    public void setFitMode(int i) {
        this.fitMode = i;
    }

    public void setHoldAtEndEnabled(boolean z2) {
        this.holdAtEndEnabled = z2;
    }

    public void setScaleMaskProgressThresholds(@Nullable MaterialContainerTransform$ProgressThresholds materialContainerTransform$ProgressThresholds) {
        this.scaleMaskProgressThresholds = materialContainerTransform$ProgressThresholds;
    }

    public void setScaleProgressThresholds(@Nullable MaterialContainerTransform$ProgressThresholds materialContainerTransform$ProgressThresholds) {
        this.scaleProgressThresholds = materialContainerTransform$ProgressThresholds;
    }

    public void setScrimColor(@ColorInt int i) {
        this.scrimColor = i;
    }

    public void setShapeMaskProgressThresholds(@Nullable MaterialContainerTransform$ProgressThresholds materialContainerTransform$ProgressThresholds) {
        this.shapeMaskProgressThresholds = materialContainerTransform$ProgressThresholds;
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
