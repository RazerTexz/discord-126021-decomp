package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.C10817R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.slider.BaseOnChangeListener;
import com.google.android.material.slider.BaseOnSliderTouchListener;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>> extends View {
    private static final String EXCEPTION_ILLEGAL_DISCRETE_VALUE = "Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_STEP_SIZE = "The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range";
    private static final String EXCEPTION_ILLEGAL_VALUE = "Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)";
    private static final String EXCEPTION_ILLEGAL_VALUE_FROM = "valueFrom(%s) must be smaller than valueTo(%s)";
    private static final String EXCEPTION_ILLEGAL_VALUE_TO = "valueTo(%s) must be greater than valueFrom(%s)";
    private static final int HALO_ALPHA = 63;
    private static final long LABEL_ANIMATION_ENTER_DURATION = 83;
    private static final long LABEL_ANIMATION_EXIT_DURATION = 117;
    private static final double THRESHOLD = 1.0E-4d;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    public static final int UNIT_PX = 0;
    public static final int UNIT_VALUE = 1;
    private static final String WARNING_FLOATING_POINT_ERRROR = "Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.";
    private BaseSlider<S, L, T>.RunnableC10979d accessibilityEventSender;

    @NonNull
    private final C10980e accessibilityHelper;
    private final AccessibilityManager accessibilityManager;
    private int activeThumbIdx;

    @NonNull
    private final Paint activeTicksPaint;

    @NonNull
    private final Paint activeTrackPaint;

    @NonNull
    private final List<L> changeListeners;
    private int defaultThumbRadius;
    private boolean dirtyConfig;
    private int focusedThumbIdx;
    private boolean forceDrawCompatHalo;
    private LabelFormatter formatter;

    @NonNull
    private ColorStateList haloColor;

    @NonNull
    private final Paint haloPaint;
    private int haloRadius;

    @NonNull
    private final Paint inactiveTicksPaint;

    @NonNull
    private final Paint inactiveTrackPaint;
    private boolean isLongPress;
    private int labelBehavior;

    @NonNull
    private final InterfaceC10981f labelMaker;
    private int labelPadding;

    @NonNull
    private final List<TooltipDrawable> labels;
    private boolean labelsAreAnimatedIn;
    private ValueAnimator labelsInAnimator;
    private ValueAnimator labelsOutAnimator;
    private MotionEvent lastEvent;
    private int minTrackSidePadding;
    private final int scaledTouchSlop;
    private int separationUnit;
    private float stepSize;

    @NonNull
    private final MaterialShapeDrawable thumbDrawable;
    private boolean thumbIsPressed;

    @NonNull
    private final Paint thumbPaint;
    private int thumbRadius;

    @NonNull
    private ColorStateList tickColorActive;

    @NonNull
    private ColorStateList tickColorInactive;
    private boolean tickVisible;
    private float[] ticksCoordinates;
    private float touchDownX;

    @NonNull
    private final List<T> touchListeners;
    private float touchPosition;

    @NonNull
    private ColorStateList trackColorActive;

    @NonNull
    private ColorStateList trackColorInactive;
    private int trackHeight;
    private int trackSidePadding;
    private int trackTop;
    private int trackWidth;
    private float valueFrom;
    private float valueTo;
    private ArrayList<Float> values;
    private int widgetHeight;
    private static final String TAG = BaseSlider.class.getSimpleName();
    public static final int DEF_STYLE_RES = C10817R.style.Widget_MaterialComponents_Slider;

    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new C10975a();

        /* JADX INFO: renamed from: j */
        public float f21107j;

        /* JADX INFO: renamed from: k */
        public float f21108k;

        /* JADX INFO: renamed from: l */
        public ArrayList<Float> f21109l;

        /* JADX INFO: renamed from: m */
        public float f21110m;

        /* JADX INFO: renamed from: n */
        public boolean f21111n;

        /* JADX INFO: renamed from: com.google.android.material.slider.BaseSlider$SliderState$a */
        public static class C10975a implements Parcelable.Creator<SliderState> {
            @Override // android.os.Parcelable.Creator
            @NonNull
            public SliderState createFromParcel(@NonNull Parcel parcel) {
                return new SliderState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public SliderState[] newArray(int i) {
                return new SliderState[i];
            }
        }

        public SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.f21107j);
            parcel.writeFloat(this.f21108k);
            parcel.writeList(this.f21109l);
            parcel.writeFloat(this.f21110m);
            parcel.writeBooleanArray(new boolean[]{this.f21111n});
        }

        public SliderState(Parcel parcel, C10976a c10976a) {
            super(parcel);
            this.f21107j = parcel.readFloat();
            this.f21108k = parcel.readFloat();
            ArrayList<Float> arrayList = new ArrayList<>();
            this.f21109l = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.f21110m = parcel.readFloat();
            this.f21111n = parcel.createBooleanArray()[0];
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.slider.BaseSlider$a */
    public class C10976a implements InterfaceC10981f {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ AttributeSet f21112a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ int f21113b;

        public C10976a(AttributeSet attributeSet, int i) {
            this.f21112a = attributeSet;
            this.f21113b = i;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.slider.BaseSlider$b */
    public class C10977b implements ValueAnimator.AnimatorUpdateListener {
        public C10977b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Iterator it = BaseSlider.this.labels.iterator();
            while (it.hasNext()) {
                ((TooltipDrawable) it.next()).setRevealFraction(fFloatValue);
            }
            ViewCompat.postInvalidateOnAnimation(BaseSlider.this);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.slider.BaseSlider$c */
    public class C10978c extends AnimatorListenerAdapter {
        public C10978c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            Iterator it = BaseSlider.this.labels.iterator();
            while (it.hasNext()) {
                ViewUtils.getContentViewOverlay(BaseSlider.this).remove((TooltipDrawable) it.next());
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.slider.BaseSlider$d */
    public class RunnableC10979d implements Runnable {

        /* JADX INFO: renamed from: j */
        public int f21117j = -1;

        public RunnableC10979d(C10976a c10976a) {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.this.accessibilityHelper.sendEventForVirtualView(this.f21117j, 4);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.slider.BaseSlider$e */
    public static class C10980e extends ExploreByTouchHelper {

        /* JADX INFO: renamed from: a */
        public final BaseSlider<?, ?, ?> f21119a;

        /* JADX INFO: renamed from: b */
        public Rect f21120b;

        public C10980e(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.f21120b = new Rect();
            this.f21119a = baseSlider;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public int getVirtualViewAt(float f, float f2) {
            for (int i = 0; i < this.f21119a.getValues().size(); i++) {
                this.f21119a.updateBoundsForVirturalViewId(i, this.f21120b);
                if (this.f21120b.contains((int) f, (int) f2)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void getVisibleVirtualViews(List<Integer> list) {
            for (int i = 0; i < this.f21119a.getValues().size(); i++) {
                list.add(Integer.valueOf(i));
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            if (!this.f21119a.isEnabled()) {
                return false;
            }
            if (i2 != 4096 && i2 != 8192) {
                if (i2 == 16908349 && bundle != null && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
                    if (this.f21119a.snapThumbToValue(i, bundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE))) {
                        this.f21119a.updateHaloHotspot();
                        this.f21119a.postInvalidate();
                        invalidateVirtualView(i);
                        return true;
                    }
                }
                return false;
            }
            float fCalculateStepIncrement = this.f21119a.calculateStepIncrement(20);
            if (i2 == 8192) {
                fCalculateStepIncrement = -fCalculateStepIncrement;
            }
            if (this.f21119a.isRtl()) {
                fCalculateStepIncrement = -fCalculateStepIncrement;
            }
            if (!this.f21119a.snapThumbToValue(i, MathUtils.clamp(this.f21119a.getValues().get(i).floatValue() + fCalculateStepIncrement, this.f21119a.getValueFrom(), this.f21119a.getValueTo()))) {
                return false;
            }
            this.f21119a.updateHaloHotspot();
            this.f21119a.postInvalidate();
            invalidateVirtualView(i);
            return true;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            String string;
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            List<Float> values = this.f21119a.getValues();
            float fFloatValue = values.get(i).floatValue();
            float valueFrom = this.f21119a.getValueFrom();
            float valueTo = this.f21119a.getValueTo();
            if (this.f21119a.isEnabled()) {
                if (fFloatValue > valueFrom) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
                if (fFloatValue < valueTo) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
            }
            accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, valueFrom, valueTo, fFloatValue));
            accessibilityNodeInfoCompat.setClassName(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.f21119a.getContentDescription() != null) {
                sb.append(this.f21119a.getContentDescription());
                sb.append(",");
            }
            if (values.size() > 1) {
                if (i == this.f21119a.getValues().size() - 1) {
                    string = this.f21119a.getContext().getString(C10817R.string.material_slider_range_end);
                } else {
                    string = i == 0 ? this.f21119a.getContext().getString(C10817R.string.material_slider_range_start) : "";
                }
                sb.append(string);
                sb.append(this.f21119a.formatValue(fFloatValue));
            }
            accessibilityNodeInfoCompat.setContentDescription(sb.toString());
            this.f21119a.updateBoundsForVirturalViewId(i, this.f21120b);
            accessibilityNodeInfoCompat.setBoundsInParent(this.f21120b);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.slider.BaseSlider$f */
    public interface InterfaceC10981f {
    }

    public BaseSlider(@NonNull Context context) {
        this(context, null);
    }

    private void attachLabelToContentView(TooltipDrawable tooltipDrawable) {
        tooltipDrawable.setRelativeToView(ViewUtils.getContentView(this));
    }

    private Float calculateIncrementForKey(int i) {
        float fCalculateStepIncrement = this.isLongPress ? calculateStepIncrement(20) : calculateStepIncrement();
        if (i == 21) {
            if (!isRtl()) {
                fCalculateStepIncrement = -fCalculateStepIncrement;
            }
            return Float.valueOf(fCalculateStepIncrement);
        }
        if (i == 22) {
            if (isRtl()) {
                fCalculateStepIncrement = -fCalculateStepIncrement;
            }
            return Float.valueOf(fCalculateStepIncrement);
        }
        if (i == 69) {
            return Float.valueOf(-fCalculateStepIncrement);
        }
        if (i == 70 || i == 81) {
            return Float.valueOf(fCalculateStepIncrement);
        }
        return null;
    }

    private float calculateStepIncrement() {
        float f = this.stepSize;
        if (f == 0.0f) {
            return 1.0f;
        }
        return f;
    }

    private int calculateTop() {
        return this.trackTop + (this.labelBehavior == 1 ? this.labels.get(0).getIntrinsicHeight() : 0);
    }

    private ValueAnimator createLabelAnimator(boolean z2) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(getAnimatorCurrentValueOrDefault(z2 ? this.labelsOutAnimator : this.labelsInAnimator, z2 ? 0.0f : 1.0f), z2 ? 1.0f : 0.0f);
        valueAnimatorOfFloat.setDuration(z2 ? LABEL_ANIMATION_ENTER_DURATION : LABEL_ANIMATION_EXIT_DURATION);
        valueAnimatorOfFloat.setInterpolator(z2 ? AnimationUtils.DECELERATE_INTERPOLATOR : AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        valueAnimatorOfFloat.addUpdateListener(new C10977b());
        return valueAnimatorOfFloat;
    }

    private void createLabelPool() {
        if (this.labels.size() > this.values.size()) {
            List<TooltipDrawable> listSubList = this.labels.subList(this.values.size(), this.labels.size());
            for (TooltipDrawable tooltipDrawable : listSubList) {
                if (ViewCompat.isAttachedToWindow(this)) {
                    detachLabelFromContentView(tooltipDrawable);
                }
            }
            listSubList.clear();
        }
        while (true) {
            if (this.labels.size() >= this.values.size()) {
                break;
            }
            C10976a c10976a = (C10976a) this.labelMaker;
            TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(BaseSlider.this.getContext(), c10976a.f21112a, C10817R.styleable.Slider, c10976a.f21113b, DEF_STYLE_RES, new int[0]);
            TooltipDrawable labelDrawable = parseLabelDrawable(BaseSlider.this.getContext(), typedArrayObtainStyledAttributes);
            typedArrayObtainStyledAttributes.recycle();
            this.labels.add(labelDrawable);
            if (ViewCompat.isAttachedToWindow(this)) {
                attachLabelToContentView(labelDrawable);
            }
        }
        int i = this.labels.size() != 1 ? 1 : 0;
        Iterator<TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            it.next().setStrokeWidth(i);
        }
    }

    private void detachLabelFromContentView(TooltipDrawable tooltipDrawable) {
        ViewOverlayImpl contentViewOverlay = ViewUtils.getContentViewOverlay(this);
        if (contentViewOverlay != null) {
            contentViewOverlay.remove(tooltipDrawable);
            tooltipDrawable.detachView(ViewUtils.getContentView(this));
        }
    }

    private float dimenToValue(float f) {
        if (f == 0.0f) {
            return 0.0f;
        }
        float f2 = (f - this.trackSidePadding) / this.trackWidth;
        float f3 = this.valueFrom;
        return C1643a.m839a(f3, this.valueTo, f2, f3);
    }

    private void dispatchOnChangedFromUser(int i) {
        Iterator<L> it = this.changeListeners.iterator();
        while (it.hasNext()) {
            it.next().onValueChange(this, this.values.get(i).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        scheduleAccessibilityEventSender(i);
    }

    private void dispatchOnChangedProgramatically() {
        for (L l : this.changeListeners) {
            Iterator<Float> it = this.values.iterator();
            while (it.hasNext()) {
                l.onValueChange(this, it.next().floatValue(), false);
            }
        }
    }

    private void drawActiveTrack(@NonNull Canvas canvas, int i, int i2) {
        float[] activeRange = getActiveRange();
        int i3 = this.trackSidePadding;
        float f = i;
        float f2 = i2;
        canvas.drawLine((activeRange[0] * f) + i3, f2, (activeRange[1] * f) + i3, f2, this.activeTrackPaint);
    }

    private void drawInactiveTrack(@NonNull Canvas canvas, int i, int i2) {
        float[] activeRange = getActiveRange();
        int i3 = this.trackSidePadding;
        float f = i;
        float f2 = (activeRange[1] * f) + i3;
        if (f2 < i3 + i) {
            float f3 = i2;
            canvas.drawLine(f2, f3, i3 + i, f3, this.inactiveTrackPaint);
        }
        int i4 = this.trackSidePadding;
        float f4 = (activeRange[0] * f) + i4;
        if (f4 > i4) {
            float f5 = i2;
            canvas.drawLine(i4, f5, f4, f5, this.inactiveTrackPaint);
        }
    }

    private void drawThumbs(@NonNull Canvas canvas, int i, int i2) {
        if (!isEnabled()) {
            Iterator<Float> it = this.values.iterator();
            while (it.hasNext()) {
                canvas.drawCircle((normalizeValue(it.next().floatValue()) * i) + this.trackSidePadding, i2, this.thumbRadius, this.thumbPaint);
            }
        }
        for (Float f : this.values) {
            canvas.save();
            int iNormalizeValue = this.trackSidePadding + ((int) (normalizeValue(f.floatValue()) * i));
            int i3 = this.thumbRadius;
            canvas.translate(iNormalizeValue - i3, i2 - i3);
            this.thumbDrawable.draw(canvas);
            canvas.restore();
        }
    }

    private void ensureLabelsAdded() {
        if (this.labelBehavior == 2) {
            return;
        }
        if (!this.labelsAreAnimatedIn) {
            this.labelsAreAnimatedIn = true;
            ValueAnimator valueAnimatorCreateLabelAnimator = createLabelAnimator(true);
            this.labelsInAnimator = valueAnimatorCreateLabelAnimator;
            this.labelsOutAnimator = null;
            valueAnimatorCreateLabelAnimator.start();
        }
        Iterator<TooltipDrawable> it = this.labels.iterator();
        for (int i = 0; i < this.values.size() && it.hasNext(); i++) {
            if (i != this.focusedThumbIdx) {
                setValueForLabel(it.next(), this.values.get(i).floatValue());
            }
        }
        if (!it.hasNext()) {
            throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.labels.size()), Integer.valueOf(this.values.size())));
        }
        setValueForLabel(it.next(), this.values.get(this.focusedThumbIdx).floatValue());
    }

    private void ensureLabelsRemoved() {
        if (this.labelsAreAnimatedIn) {
            this.labelsAreAnimatedIn = false;
            ValueAnimator valueAnimatorCreateLabelAnimator = createLabelAnimator(false);
            this.labelsOutAnimator = valueAnimatorCreateLabelAnimator;
            this.labelsInAnimator = null;
            valueAnimatorCreateLabelAnimator.addListener(new C10978c());
            this.labelsOutAnimator.start();
        }
    }

    private void focusThumbOnFocusGained(int i) {
        if (i == 1) {
            moveFocus(Integer.MAX_VALUE);
            return;
        }
        if (i == 2) {
            moveFocus(Integer.MIN_VALUE);
        } else if (i == 17) {
            moveFocusInAbsoluteDirection(Integer.MAX_VALUE);
        } else {
            if (i != 66) {
                return;
            }
            moveFocusInAbsoluteDirection(Integer.MIN_VALUE);
        }
    }

    private String formatValue(float f) {
        if (hasLabelFormatter()) {
            return this.formatter.getFormattedValue(f);
        }
        return String.format(((float) ((int) f)) == f ? "%.0f" : "%.2f", Float.valueOf(f));
    }

    private float[] getActiveRange() {
        float fFloatValue = ((Float) Collections.max(getValues())).floatValue();
        float fFloatValue2 = ((Float) Collections.min(getValues())).floatValue();
        if (this.values.size() == 1) {
            fFloatValue2 = this.valueFrom;
        }
        float fNormalizeValue = normalizeValue(fFloatValue2);
        float fNormalizeValue2 = normalizeValue(fFloatValue);
        return isRtl() ? new float[]{fNormalizeValue2, fNormalizeValue} : new float[]{fNormalizeValue, fNormalizeValue2};
    }

    private static float getAnimatorCurrentValueOrDefault(ValueAnimator valueAnimator, float f) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return f;
        }
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        valueAnimator.cancel();
        return fFloatValue;
    }

    private float getClampedValue(int i, float f) {
        float minSeparation = this.stepSize == 0.0f ? getMinSeparation() : 0.0f;
        if (this.separationUnit == 0) {
            minSeparation = dimenToValue(minSeparation);
        }
        if (isRtl()) {
            minSeparation = -minSeparation;
        }
        int i2 = i + 1;
        int i3 = i - 1;
        return MathUtils.clamp(f, i3 < 0 ? this.valueFrom : this.values.get(i3).floatValue() + minSeparation, i2 >= this.values.size() ? this.valueTo : this.values.get(i2).floatValue() - minSeparation);
    }

    @ColorInt
    private int getColorForState(@NonNull ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    private float getValueOfTouchPosition() {
        double dSnapPosition = snapPosition(this.touchPosition);
        if (isRtl()) {
            dSnapPosition = 1.0d - dSnapPosition;
        }
        float f = this.valueTo;
        float f2 = this.valueFrom;
        return (float) ((dSnapPosition * ((double) (f - f2))) + ((double) f2));
    }

    private float getValueOfTouchPositionAbsolute() {
        float f = this.touchPosition;
        if (isRtl()) {
            f = 1.0f - f;
        }
        float f2 = this.valueTo;
        float f3 = this.valueFrom;
        return C1643a.m839a(f2, f3, f, f3);
    }

    private void invalidateTrack() {
        this.inactiveTrackPaint.setStrokeWidth(this.trackHeight);
        this.activeTrackPaint.setStrokeWidth(this.trackHeight);
        this.inactiveTicksPaint.setStrokeWidth(this.trackHeight / 2.0f);
        this.activeTicksPaint.setStrokeWidth(this.trackHeight / 2.0f);
    }

    private boolean isInVerticalScrollingContainer() {
        ViewParent parent = getParent();
        while (true) {
            if (!(parent instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = parent.getParent();
        }
    }

    private void loadResources(@NonNull Resources resources) {
        this.widgetHeight = resources.getDimensionPixelSize(C10817R.dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(C10817R.dimen.mtrl_slider_track_side_padding);
        this.minTrackSidePadding = dimensionPixelOffset;
        this.trackSidePadding = dimensionPixelOffset;
        this.defaultThumbRadius = resources.getDimensionPixelSize(C10817R.dimen.mtrl_slider_thumb_radius);
        this.trackTop = resources.getDimensionPixelOffset(C10817R.dimen.mtrl_slider_track_top);
        this.labelPadding = resources.getDimensionPixelSize(C10817R.dimen.mtrl_slider_label_padding);
    }

    private void maybeCalculateTicksCoordinates() {
        if (this.stepSize <= 0.0f) {
            return;
        }
        validateConfigurationIfDirty();
        int iMin = Math.min((int) (((this.valueTo - this.valueFrom) / this.stepSize) + 1.0f), (this.trackWidth / (this.trackHeight * 2)) + 1);
        float[] fArr = this.ticksCoordinates;
        if (fArr == null || fArr.length != iMin * 2) {
            this.ticksCoordinates = new float[iMin * 2];
        }
        float f = this.trackWidth / (iMin - 1);
        for (int i = 0; i < iMin * 2; i += 2) {
            float[] fArr2 = this.ticksCoordinates;
            fArr2[i] = ((i / 2) * f) + this.trackSidePadding;
            fArr2[i + 1] = calculateTop();
        }
    }

    private void maybeDrawHalo(@NonNull Canvas canvas, int i, int i2) {
        if (shouldDrawCompatHalo()) {
            int iNormalizeValue = (int) ((normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * i) + this.trackSidePadding);
            if (Build.VERSION.SDK_INT < 28) {
                int i3 = this.haloRadius;
                canvas.clipRect(iNormalizeValue - i3, i2 - i3, iNormalizeValue + i3, i3 + i2, Region.Op.UNION);
            }
            canvas.drawCircle(iNormalizeValue, i2, this.haloRadius, this.haloPaint);
        }
    }

    private void maybeDrawTicks(@NonNull Canvas canvas) {
        if (!this.tickVisible || this.stepSize <= 0.0f) {
            return;
        }
        float[] activeRange = getActiveRange();
        int iPivotIndex = pivotIndex(this.ticksCoordinates, activeRange[0]);
        int iPivotIndex2 = pivotIndex(this.ticksCoordinates, activeRange[1]);
        int i = iPivotIndex * 2;
        canvas.drawPoints(this.ticksCoordinates, 0, i, this.inactiveTicksPaint);
        int i2 = iPivotIndex2 * 2;
        canvas.drawPoints(this.ticksCoordinates, i, i2 - i, this.activeTicksPaint);
        float[] fArr = this.ticksCoordinates;
        canvas.drawPoints(fArr, i2, fArr.length - i2, this.inactiveTicksPaint);
    }

    private void maybeIncreaseTrackSidePadding() {
        this.trackSidePadding = this.minTrackSidePadding + Math.max(this.thumbRadius - this.defaultThumbRadius, 0);
        if (ViewCompat.isLaidOut(this)) {
            updateTrackWidth(getWidth());
        }
    }

    private boolean moveFocus(int i) {
        int i2 = this.focusedThumbIdx;
        int iClamp = (int) MathUtils.clamp(((long) i2) + ((long) i), 0L, this.values.size() - 1);
        this.focusedThumbIdx = iClamp;
        if (iClamp == i2) {
            return false;
        }
        if (this.activeThumbIdx != -1) {
            this.activeThumbIdx = iClamp;
        }
        updateHaloHotspot();
        postInvalidate();
        return true;
    }

    private boolean moveFocusInAbsoluteDirection(int i) {
        if (isRtl()) {
            i = i == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i;
        }
        return moveFocus(i);
    }

    private float normalizeValue(float f) {
        float f2 = this.valueFrom;
        float f3 = (f - f2) / (this.valueTo - f2);
        return isRtl() ? 1.0f - f3 : f3;
    }

    private Boolean onKeyDownNoActiveThumb(int i, @NonNull KeyEvent keyEvent) {
        if (i == 61) {
            if (keyEvent.hasNoModifiers()) {
                return Boolean.valueOf(moveFocus(1));
            }
            return keyEvent.isShiftPressed() ? Boolean.valueOf(moveFocus(-1)) : Boolean.FALSE;
        }
        if (i != 66) {
            if (i != 81) {
                if (i == 69) {
                    moveFocus(-1);
                    return Boolean.TRUE;
                }
                if (i != 70) {
                    switch (i) {
                        case 21:
                            moveFocusInAbsoluteDirection(-1);
                            return Boolean.TRUE;
                        case 22:
                            moveFocusInAbsoluteDirection(1);
                            return Boolean.TRUE;
                        case 23:
                            break;
                        default:
                            return null;
                    }
                }
            }
            moveFocus(1);
            return Boolean.TRUE;
        }
        this.activeThumbIdx = this.focusedThumbIdx;
        postInvalidate();
        return Boolean.TRUE;
    }

    private void onStartTrackingTouch() {
        Iterator<T> it = this.touchListeners.iterator();
        while (it.hasNext()) {
            it.next().onStartTrackingTouch(this);
        }
    }

    private void onStopTrackingTouch() {
        Iterator<T> it = this.touchListeners.iterator();
        while (it.hasNext()) {
            it.next().onStopTrackingTouch(this);
        }
    }

    @NonNull
    private static TooltipDrawable parseLabelDrawable(@NonNull Context context, @NonNull TypedArray typedArray) {
        return TooltipDrawable.createFromAttributes(context, null, 0, typedArray.getResourceId(C10817R.styleable.Slider_labelStyle, C10817R.style.Widget_MaterialComponents_Tooltip));
    }

    private static int pivotIndex(float[] fArr, float f) {
        return Math.round(f * ((fArr.length / 2) - 1));
    }

    private void processAttributes(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, C10817R.styleable.Slider, i, DEF_STYLE_RES, new int[0]);
        this.valueFrom = typedArrayObtainStyledAttributes.getFloat(C10817R.styleable.Slider_android_valueFrom, 0.0f);
        this.valueTo = typedArrayObtainStyledAttributes.getFloat(C10817R.styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.valueFrom));
        this.stepSize = typedArrayObtainStyledAttributes.getFloat(C10817R.styleable.Slider_android_stepSize, 0.0f);
        int i2 = C10817R.styleable.Slider_trackColor;
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i2);
        int i3 = zHasValue ? i2 : C10817R.styleable.Slider_trackColorInactive;
        if (!zHasValue) {
            i2 = C10817R.styleable.Slider_trackColorActive;
        }
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, i3);
        if (colorStateList == null) {
            colorStateList = AppCompatResources.getColorStateList(context, C10817R.color.material_slider_inactive_track_color);
        }
        setTrackInactiveTintList(colorStateList);
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, i2);
        if (colorStateList2 == null) {
            colorStateList2 = AppCompatResources.getColorStateList(context, C10817R.color.material_slider_active_track_color);
        }
        setTrackActiveTintList(colorStateList2);
        this.thumbDrawable.setFillColor(MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, C10817R.styleable.Slider_thumbColor));
        int i4 = C10817R.styleable.Slider_thumbStrokeColor;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            setThumbStrokeColor(MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, i4));
        }
        setThumbStrokeWidth(typedArrayObtainStyledAttributes.getDimension(C10817R.styleable.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList colorStateList3 = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, C10817R.styleable.Slider_haloColor);
        if (colorStateList3 == null) {
            colorStateList3 = AppCompatResources.getColorStateList(context, C10817R.color.material_slider_halo_color);
        }
        setHaloTintList(colorStateList3);
        this.tickVisible = typedArrayObtainStyledAttributes.getBoolean(C10817R.styleable.Slider_tickVisible, true);
        int i5 = C10817R.styleable.Slider_tickColor;
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(i5);
        int i6 = zHasValue2 ? i5 : C10817R.styleable.Slider_tickColorInactive;
        if (!zHasValue2) {
            i5 = C10817R.styleable.Slider_tickColorActive;
        }
        ColorStateList colorStateList4 = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, i6);
        if (colorStateList4 == null) {
            colorStateList4 = AppCompatResources.getColorStateList(context, C10817R.color.material_slider_inactive_tick_marks_color);
        }
        setTickInactiveTintList(colorStateList4);
        ColorStateList colorStateList5 = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, i5);
        if (colorStateList5 == null) {
            colorStateList5 = AppCompatResources.getColorStateList(context, C10817R.color.material_slider_active_tick_marks_color);
        }
        setTickActiveTintList(colorStateList5);
        setThumbRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(C10817R.styleable.Slider_thumbRadius, 0));
        setHaloRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(C10817R.styleable.Slider_haloRadius, 0));
        setThumbElevation(typedArrayObtainStyledAttributes.getDimension(C10817R.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(C10817R.styleable.Slider_trackHeight, 0));
        this.labelBehavior = typedArrayObtainStyledAttributes.getInt(C10817R.styleable.Slider_labelBehavior, 0);
        if (!typedArrayObtainStyledAttributes.getBoolean(C10817R.styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void scheduleAccessibilityEventSender(int i) {
        BaseSlider<S, L, T>.RunnableC10979d runnableC10979d = this.accessibilityEventSender;
        if (runnableC10979d == null) {
            this.accessibilityEventSender = new RunnableC10979d(null);
        } else {
            removeCallbacks(runnableC10979d);
        }
        BaseSlider<S, L, T>.RunnableC10979d runnableC10979d2 = this.accessibilityEventSender;
        runnableC10979d2.f21117j = i;
        postDelayed(runnableC10979d2, 200L);
    }

    private void setValueForLabel(TooltipDrawable tooltipDrawable, float f) {
        tooltipDrawable.setText(formatValue(f));
        int iNormalizeValue = (this.trackSidePadding + ((int) (normalizeValue(f) * this.trackWidth))) - (tooltipDrawable.getIntrinsicWidth() / 2);
        int iCalculateTop = calculateTop() - (this.labelPadding + this.thumbRadius);
        tooltipDrawable.setBounds(iNormalizeValue, iCalculateTop - tooltipDrawable.getIntrinsicHeight(), tooltipDrawable.getIntrinsicWidth() + iNormalizeValue, iCalculateTop);
        Rect rect = new Rect(tooltipDrawable.getBounds());
        DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(this), this, rect);
        tooltipDrawable.setBounds(rect);
        ViewUtils.getContentViewOverlay(this).add(tooltipDrawable);
    }

    private void setValuesInternal(@NonNull ArrayList<Float> arrayList) {
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be set");
        }
        Collections.sort(arrayList);
        if (this.values.size() == arrayList.size() && this.values.equals(arrayList)) {
            return;
        }
        this.values = arrayList;
        this.dirtyConfig = true;
        this.focusedThumbIdx = 0;
        updateHaloHotspot();
        createLabelPool();
        dispatchOnChangedProgramatically();
        postInvalidate();
    }

    private boolean shouldDrawCompatHalo() {
        return this.forceDrawCompatHalo || !(getBackground() instanceof RippleDrawable);
    }

    private boolean snapActiveThumbToValue(float f) {
        return snapThumbToValue(this.activeThumbIdx, f);
    }

    private double snapPosition(float f) {
        float f2 = this.stepSize;
        if (f2 <= 0.0f) {
            return f;
        }
        int i = (int) ((this.valueTo - this.valueFrom) / f2);
        return ((double) Math.round(f * i)) / ((double) i);
    }

    private boolean snapThumbToValue(int i, float f) {
        if (Math.abs(f - this.values.get(i).floatValue()) < THRESHOLD) {
            return false;
        }
        this.values.set(i, Float.valueOf(getClampedValue(i, f)));
        this.focusedThumbIdx = i;
        dispatchOnChangedFromUser(i);
        return true;
    }

    private boolean snapTouchPosition() {
        return snapActiveThumbToValue(getValueOfTouchPosition());
    }

    private void updateHaloHotspot() {
        if (shouldDrawCompatHalo() || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            int iNormalizeValue = (int) ((normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * this.trackWidth) + this.trackSidePadding);
            int iCalculateTop = calculateTop();
            int i = this.haloRadius;
            DrawableCompat.setHotspotBounds(background, iNormalizeValue - i, iCalculateTop - i, iNormalizeValue + i, iCalculateTop + i);
        }
    }

    private void updateTrackWidth(int i) {
        this.trackWidth = Math.max(i - (this.trackSidePadding * 2), 0);
        maybeCalculateTicksCoordinates();
    }

    private void validateConfigurationIfDirty() {
        if (this.dirtyConfig) {
            validateValueFrom();
            validateValueTo();
            validateStepSize();
            validateValues();
            warnAboutFloatingPointError();
            this.dirtyConfig = false;
        }
    }

    private void validateStepSize() {
        if (this.stepSize > 0.0f && !valueLandsOnTick(this.valueTo)) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, Float.toString(this.stepSize), Float.toString(this.valueFrom), Float.toString(this.valueTo)));
        }
    }

    private void validateValueFrom() {
        if (this.valueFrom >= this.valueTo) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE_FROM, Float.toString(this.valueFrom), Float.toString(this.valueTo)));
        }
    }

    private void validateValueTo() {
        if (this.valueTo <= this.valueFrom) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE_TO, Float.toString(this.valueTo), Float.toString(this.valueFrom)));
        }
    }

    private void validateValues() {
        for (Float f : this.values) {
            if (f.floatValue() < this.valueFrom || f.floatValue() > this.valueTo) {
                throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE, Float.toString(f.floatValue()), Float.toString(this.valueFrom), Float.toString(this.valueTo)));
            }
            if (this.stepSize > 0.0f && !valueLandsOnTick(f.floatValue())) {
                throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_DISCRETE_VALUE, Float.toString(f.floatValue()), Float.toString(this.valueFrom), Float.toString(this.stepSize), Float.toString(this.stepSize)));
            }
        }
    }

    private boolean valueLandsOnTick(float f) {
        double dDoubleValue = new BigDecimal(Float.toString(f)).subtract(new BigDecimal(Float.toString(this.valueFrom))).divide(new BigDecimal(Float.toString(this.stepSize)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(dDoubleValue)) - dDoubleValue) < THRESHOLD;
    }

    private float valueToX(float f) {
        return (normalizeValue(f) * this.trackWidth) + this.trackSidePadding;
    }

    private void warnAboutFloatingPointError() {
        float f = this.stepSize;
        if (f == 0.0f) {
            return;
        }
        if (((int) f) != f) {
            Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERRROR, "stepSize", Float.valueOf(f)));
        }
        float f2 = this.valueFrom;
        if (((int) f2) != f2) {
            Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERRROR, "valueFrom", Float.valueOf(f2)));
        }
        float f3 = this.valueTo;
        if (((int) f3) != f3) {
            Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERRROR, "valueTo", Float.valueOf(f3)));
        }
    }

    public void addOnChangeListener(@Nullable L l) {
        this.changeListeners.add(l);
    }

    public void addOnSliderTouchListener(@NonNull T t) {
        this.touchListeners.add(t);
    }

    public void clearOnChangeListeners() {
        this.changeListeners.clear();
    }

    public void clearOnSliderTouchListeners() {
        this.touchListeners.clear();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        return this.accessibilityHelper.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.inactiveTrackPaint.setColor(getColorForState(this.trackColorInactive));
        this.activeTrackPaint.setColor(getColorForState(this.trackColorActive));
        this.inactiveTicksPaint.setColor(getColorForState(this.tickColorInactive));
        this.activeTicksPaint.setColor(getColorForState(this.tickColorActive));
        for (TooltipDrawable tooltipDrawable : this.labels) {
            if (tooltipDrawable.isStateful()) {
                tooltipDrawable.setState(getDrawableState());
            }
        }
        if (this.thumbDrawable.isStateful()) {
            this.thumbDrawable.setState(getDrawableState());
        }
        this.haloPaint.setColor(getColorForState(this.haloColor));
        this.haloPaint.setAlpha(63);
    }

    @VisibleForTesting
    public void forceDrawCompatHalo(boolean z2) {
        this.forceDrawCompatHalo = z2;
    }

    @Override // android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    @VisibleForTesting
    public final int getAccessibilityFocusedVirtualViewId() {
        return this.accessibilityHelper.getAccessibilityFocusedVirtualViewId();
    }

    public int getActiveThumbIndex() {
        return this.activeThumbIdx;
    }

    public int getFocusedThumbIndex() {
        return this.focusedThumbIdx;
    }

    @Dimension
    public int getHaloRadius() {
        return this.haloRadius;
    }

    @NonNull
    public ColorStateList getHaloTintList() {
        return this.haloColor;
    }

    public int getLabelBehavior() {
        return this.labelBehavior;
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.stepSize;
    }

    public float getThumbElevation() {
        return this.thumbDrawable.getElevation();
    }

    @Dimension
    public int getThumbRadius() {
        return this.thumbRadius;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.thumbDrawable.getStrokeColor();
    }

    public float getThumbStrokeWidth() {
        return this.thumbDrawable.getStrokeWidth();
    }

    @NonNull
    public ColorStateList getThumbTintList() {
        return this.thumbDrawable.getFillColor();
    }

    @NonNull
    public ColorStateList getTickActiveTintList() {
        return this.tickColorActive;
    }

    @NonNull
    public ColorStateList getTickInactiveTintList() {
        return this.tickColorInactive;
    }

    @NonNull
    public ColorStateList getTickTintList() {
        if (this.tickColorInactive.equals(this.tickColorActive)) {
            return this.tickColorActive;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    @NonNull
    public ColorStateList getTrackActiveTintList() {
        return this.trackColorActive;
    }

    @Dimension
    public int getTrackHeight() {
        return this.trackHeight;
    }

    @NonNull
    public ColorStateList getTrackInactiveTintList() {
        return this.trackColorInactive;
    }

    @Dimension
    public int getTrackSidePadding() {
        return this.trackSidePadding;
    }

    @NonNull
    public ColorStateList getTrackTintList() {
        if (this.trackColorInactive.equals(this.trackColorActive)) {
            return this.trackColorActive;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    @Dimension
    public int getTrackWidth() {
        return this.trackWidth;
    }

    public float getValueFrom() {
        return this.valueFrom;
    }

    public float getValueTo() {
        return this.valueTo;
    }

    @NonNull
    public List<Float> getValues() {
        return new ArrayList(this.values);
    }

    public boolean hasLabelFormatter() {
        return this.formatter != null;
    }

    public final boolean isRtl() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    public boolean isTickVisible() {
        return this.tickVisible;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator<TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            attachLabelToContentView(it.next());
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        BaseSlider<S, L, T>.RunnableC10979d runnableC10979d = this.accessibilityEventSender;
        if (runnableC10979d != null) {
            removeCallbacks(runnableC10979d);
        }
        this.labelsAreAnimatedIn = false;
        Iterator<TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            detachLabelFromContentView(it.next());
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        if (this.dirtyConfig) {
            validateConfigurationIfDirty();
            maybeCalculateTicksCoordinates();
        }
        super.onDraw(canvas);
        int iCalculateTop = calculateTop();
        drawInactiveTrack(canvas, this.trackWidth, iCalculateTop);
        if (((Float) Collections.max(getValues())).floatValue() > this.valueFrom) {
            drawActiveTrack(canvas, this.trackWidth, iCalculateTop);
        }
        maybeDrawTicks(canvas);
        if ((this.thumbIsPressed || isFocused()) && isEnabled()) {
            maybeDrawHalo(canvas, this.trackWidth, iCalculateTop);
            if (this.activeThumbIdx != -1) {
                ensureLabelsAdded();
            }
        }
        drawThumbs(canvas, this.trackWidth, iCalculateTop);
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z2, int i, @Nullable Rect rect) {
        super.onFocusChanged(z2, i, rect);
        if (z2) {
            focusThumbOnFocusGained(i);
            this.accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
        } else {
            this.activeThumbIdx = -1;
            ensureLabelsRemoved();
            this.accessibilityHelper.clearKeyboardFocusForVirtualView(this.focusedThumbIdx);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, @NonNull KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.values.size() == 1) {
            this.activeThumbIdx = 0;
        }
        if (this.activeThumbIdx == -1) {
            Boolean boolOnKeyDownNoActiveThumb = onKeyDownNoActiveThumb(i, keyEvent);
            return boolOnKeyDownNoActiveThumb != null ? boolOnKeyDownNoActiveThumb.booleanValue() : super.onKeyDown(i, keyEvent);
        }
        this.isLongPress |= keyEvent.isLongPress();
        Float fCalculateIncrementForKey = calculateIncrementForKey(i);
        if (fCalculateIncrementForKey != null) {
            if (snapActiveThumbToValue(fCalculateIncrementForKey.floatValue() + this.values.get(this.activeThumbIdx).floatValue())) {
                updateHaloHotspot();
                postInvalidate();
            }
            return true;
        }
        if (i != 23) {
            if (i == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return moveFocus(1);
                }
                if (keyEvent.isShiftPressed()) {
                    return moveFocus(-1);
                }
                return false;
            }
            if (i != 66) {
                return super.onKeyDown(i, keyEvent);
            }
        }
        this.activeThumbIdx = -1;
        ensureLabelsRemoved();
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, @NonNull KeyEvent keyEvent) {
        this.isLongPress = false;
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.widgetHeight + (this.labelBehavior == 1 ? this.labels.get(0).getIntrinsicHeight() : 0), BasicMeasure.EXACTLY));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.valueFrom = sliderState.f21107j;
        this.valueTo = sliderState.f21108k;
        setValuesInternal(sliderState.f21109l);
        this.stepSize = sliderState.f21110m;
        if (sliderState.f21111n) {
            requestFocus();
        }
        dispatchOnChangedProgramatically();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.f21107j = this.valueFrom;
        sliderState.f21108k = this.valueTo;
        sliderState.f21109l = new ArrayList<>(this.values);
        sliderState.f21110m = this.stepSize;
        sliderState.f21111n = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        updateTrackWidth(i);
        updateHaloHotspot();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x2 = motionEvent.getX();
        float f = (x2 - this.trackSidePadding) / this.trackWidth;
        this.touchPosition = f;
        float fMax = Math.max(0.0f, f);
        this.touchPosition = fMax;
        this.touchPosition = Math.min(1.0f, fMax);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.touchDownX = x2;
            if (!isInVerticalScrollingContainer()) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (pickActiveThumb()) {
                    requestFocus();
                    this.thumbIsPressed = true;
                    snapTouchPosition();
                    updateHaloHotspot();
                    invalidate();
                    onStartTrackingTouch();
                }
            }
        } else if (actionMasked == 1) {
            this.thumbIsPressed = false;
            MotionEvent motionEvent2 = this.lastEvent;
            if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && Math.abs(this.lastEvent.getX() - motionEvent.getX()) <= this.scaledTouchSlop && Math.abs(this.lastEvent.getY() - motionEvent.getY()) <= this.scaledTouchSlop && pickActiveThumb()) {
                onStartTrackingTouch();
            }
            if (this.activeThumbIdx != -1) {
                snapTouchPosition();
                this.activeThumbIdx = -1;
                onStopTrackingTouch();
            }
            ensureLabelsRemoved();
            invalidate();
        } else if (actionMasked == 2) {
            if (!this.thumbIsPressed) {
                if (isInVerticalScrollingContainer() && Math.abs(x2 - this.touchDownX) < this.scaledTouchSlop) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                onStartTrackingTouch();
            }
            if (pickActiveThumb()) {
                this.thumbIsPressed = true;
                snapTouchPosition();
                updateHaloHotspot();
                invalidate();
            }
        }
        setPressed(this.thumbIsPressed);
        this.lastEvent = MotionEvent.obtain(motionEvent);
        return true;
    }

    public boolean pickActiveThumb() {
        if (this.activeThumbIdx != -1) {
            return true;
        }
        float valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
        float fValueToX = valueToX(valueOfTouchPositionAbsolute);
        this.activeThumbIdx = 0;
        float fAbs = Math.abs(this.values.get(0).floatValue() - valueOfTouchPositionAbsolute);
        for (int i = 1; i < this.values.size(); i++) {
            float fAbs2 = Math.abs(this.values.get(i).floatValue() - valueOfTouchPositionAbsolute);
            float fValueToX2 = valueToX(this.values.get(i).floatValue());
            if (Float.compare(fAbs2, fAbs) > 1) {
                break;
            }
            boolean z2 = !isRtl() ? fValueToX2 - fValueToX >= 0.0f : fValueToX2 - fValueToX <= 0.0f;
            if (Float.compare(fAbs2, fAbs) < 0) {
                this.activeThumbIdx = i;
            } else {
                if (Float.compare(fAbs2, fAbs) != 0) {
                    continue;
                } else {
                    if (Math.abs(fValueToX2 - fValueToX) < this.scaledTouchSlop) {
                        this.activeThumbIdx = -1;
                        return false;
                    }
                    if (z2) {
                        this.activeThumbIdx = i;
                    }
                }
            }
            fAbs = fAbs2;
        }
        return this.activeThumbIdx != -1;
    }

    public void removeOnChangeListener(@NonNull L l) {
        this.changeListeners.remove(l);
    }

    public void removeOnSliderTouchListener(@NonNull T t) {
        this.touchListeners.remove(t);
    }

    public void setActiveThumbIndex(int i) {
        this.activeThumbIdx = i;
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        setLayerType(z2 ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i) {
        if (i < 0 || i >= this.values.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.focusedThumbIdx = i;
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(i);
        postInvalidate();
    }

    public void setHaloRadius(@IntRange(from = 0) @Dimension int i) {
        if (i == this.haloRadius) {
            return;
        }
        this.haloRadius = i;
        Drawable background = getBackground();
        if (shouldDrawCompatHalo() || !(background instanceof RippleDrawable)) {
            postInvalidate();
        } else {
            DrawableUtils.setRippleDrawableRadius((RippleDrawable) background, this.haloRadius);
        }
    }

    public void setHaloRadiusResource(@DimenRes int i) {
        setHaloRadius(getResources().getDimensionPixelSize(i));
    }

    public void setHaloTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.haloColor)) {
            return;
        }
        this.haloColor = colorStateList;
        Drawable background = getBackground();
        if (!shouldDrawCompatHalo() && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        this.haloPaint.setColor(getColorForState(colorStateList));
        this.haloPaint.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i) {
        if (this.labelBehavior != i) {
            this.labelBehavior = i;
            requestLayout();
        }
    }

    public void setLabelFormatter(@Nullable LabelFormatter labelFormatter) {
        this.formatter = labelFormatter;
    }

    public void setSeparationUnit(int i) {
        this.separationUnit = i;
    }

    public void setStepSize(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, Float.toString(f), Float.toString(this.valueFrom), Float.toString(this.valueTo)));
        }
        if (this.stepSize != f) {
            this.stepSize = f;
            this.dirtyConfig = true;
            postInvalidate();
        }
    }

    public void setThumbElevation(float f) {
        this.thumbDrawable.setElevation(f);
    }

    public void setThumbElevationResource(@DimenRes int i) {
        setThumbElevation(getResources().getDimension(i));
    }

    public void setThumbRadius(@IntRange(from = 0) @Dimension int i) {
        if (i == this.thumbRadius) {
            return;
        }
        this.thumbRadius = i;
        maybeIncreaseTrackSidePadding();
        this.thumbDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCorners(0, this.thumbRadius).build());
        MaterialShapeDrawable materialShapeDrawable = this.thumbDrawable;
        int i2 = this.thumbRadius;
        materialShapeDrawable.setBounds(0, 0, i2 * 2, i2 * 2);
        postInvalidate();
    }

    public void setThumbRadiusResource(@DimenRes int i) {
        setThumbRadius(getResources().getDimensionPixelSize(i));
    }

    public void setThumbStrokeColor(@Nullable ColorStateList colorStateList) {
        this.thumbDrawable.setStrokeColor(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(@ColorRes int i) {
        if (i != 0) {
            setThumbStrokeColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    public void setThumbStrokeWidth(float f) {
        this.thumbDrawable.setStrokeWidth(f);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(@DimenRes int i) {
        if (i != 0) {
            setThumbStrokeWidth(getResources().getDimension(i));
        }
    }

    public void setThumbTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.thumbDrawable.getFillColor())) {
            return;
        }
        this.thumbDrawable.setFillColor(colorStateList);
        invalidate();
    }

    public void setTickActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.tickColorActive)) {
            return;
        }
        this.tickColorActive = colorStateList;
        this.activeTicksPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.tickColorInactive)) {
            return;
        }
        this.tickColorInactive = colorStateList;
        this.inactiveTicksPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTickTintList(@NonNull ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z2) {
        if (this.tickVisible != z2) {
            this.tickVisible = z2;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.trackColorActive)) {
            return;
        }
        this.trackColorActive = colorStateList;
        this.activeTrackPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTrackHeight(@IntRange(from = 0) @Dimension int i) {
        if (this.trackHeight != i) {
            this.trackHeight = i;
            invalidateTrack();
            postInvalidate();
        }
    }

    public void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.trackColorInactive)) {
            return;
        }
        this.trackColorInactive = colorStateList;
        this.inactiveTrackPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTrackTintList(@NonNull ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f) {
        this.valueFrom = f;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setValueTo(float f) {
        this.valueTo = f;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setValues(@NonNull Float... fArr) {
        ArrayList<Float> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    public void updateBoundsForVirturalViewId(int i, Rect rect) {
        int iNormalizeValue = this.trackSidePadding + ((int) (normalizeValue(getValues().get(i).floatValue()) * this.trackWidth));
        int iCalculateTop = calculateTop();
        int i2 = this.thumbRadius;
        rect.set(iNormalizeValue - i2, iCalculateTop - i2, iNormalizeValue + i2, iCalculateTop + i2);
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, C10817R.attr.sliderStyle);
    }

    private float calculateStepIncrement(int i) {
        float fCalculateStepIncrement = calculateStepIncrement();
        float f = (this.valueTo - this.valueFrom) / fCalculateStepIncrement;
        float f2 = i;
        return f <= f2 ? fCalculateStepIncrement : Math.round(f / f2) * fCalculateStepIncrement;
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.labels = new ArrayList();
        this.changeListeners = new ArrayList();
        this.touchListeners = new ArrayList();
        this.labelsAreAnimatedIn = false;
        this.thumbIsPressed = false;
        this.values = new ArrayList<>();
        this.activeThumbIdx = -1;
        this.focusedThumbIdx = -1;
        this.stepSize = 0.0f;
        this.tickVisible = true;
        this.isLongPress = false;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.thumbDrawable = materialShapeDrawable;
        this.separationUnit = 0;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.inactiveTrackPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.activeTrackPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        Paint paint3 = new Paint(1);
        this.thumbPaint = paint3;
        paint3.setStyle(Paint.Style.FILL);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint4 = new Paint(1);
        this.haloPaint = paint4;
        paint4.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint();
        this.inactiveTicksPaint = paint5;
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeCap(Paint.Cap.ROUND);
        Paint paint6 = new Paint();
        this.activeTicksPaint = paint6;
        paint6.setStyle(Paint.Style.STROKE);
        paint6.setStrokeCap(Paint.Cap.ROUND);
        loadResources(context2.getResources());
        this.labelMaker = new C10976a(attributeSet, i);
        processAttributes(context2, attributeSet, i);
        setFocusable(true);
        setClickable(true);
        materialShapeDrawable.setShadowCompatibilityMode(2);
        this.scaledTouchSlop = ViewConfiguration.get(context2).getScaledTouchSlop();
        C10980e c10980e = new C10980e(this);
        this.accessibilityHelper = c10980e;
        ViewCompat.setAccessibilityDelegate(this, c10980e);
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    public void setValues(@NonNull List<Float> list) {
        setValuesInternal(new ArrayList<>(list));
    }
}
