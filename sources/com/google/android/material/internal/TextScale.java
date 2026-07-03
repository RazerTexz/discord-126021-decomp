package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TextScale extends Transition {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    /* JADX INFO: renamed from: com.google.android.material.internal.TextScale$a */
    public class C10947a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ TextView f21046a;

        public C10947a(TextScale textScale, TextView textView) {
            this.f21046a = textView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f21046a.setScaleX(fFloatValue);
            this.f21046a.setScaleY(fFloatValue);
        }
    }

    private void captureValues(@NonNull TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view instanceof TextView) {
            transitionValues.values.put(PROPNAME_SCALE, Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null || !(transitionValues.view instanceof TextView)) {
            return null;
        }
        View view = transitionValues2.view;
        if (!(view instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) view;
        Map<String, Object> map = transitionValues.values;
        Map<String, Object> map2 = transitionValues2.values;
        float fFloatValue = map.get(PROPNAME_SCALE) != null ? ((Float) map.get(PROPNAME_SCALE)).floatValue() : 1.0f;
        float fFloatValue2 = map2.get(PROPNAME_SCALE) != null ? ((Float) map2.get(PROPNAME_SCALE)).floatValue() : 1.0f;
        if (fFloatValue == fFloatValue2) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, fFloatValue2);
        valueAnimatorOfFloat.addUpdateListener(new C10947a(this, textView));
        return valueAnimatorOfFloat;
    }
}
