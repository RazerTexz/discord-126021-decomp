package b.i.a.g.e;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.ArrayList;

/* JADX INFO: renamed from: b.i.a.g.e.b, reason: use source file name */
/* JADX INFO: compiled from: BaseMotionStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseMotionStrategy implements MotionStrategy {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ExtendedFloatingActionButton f1611b;
    public final ArrayList<Animator.AnimatorListener> c = new ArrayList<>();
    public final AnimatorTracker d;

    @Nullable
    public MotionSpec e;

    @Nullable
    public MotionSpec f;

    /* JADX INFO: renamed from: b.i.a.g.e.b$a */
    /* JADX INFO: compiled from: BaseMotionStrategy.java */
    public class a extends Property<ExtendedFloatingActionButton, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
            ExtendedFloatingActionButton extendedFloatingActionButton2 = extendedFloatingActionButton;
            return Float.valueOf(AnimationUtils.lerp(0.0f, 1.0f, (Color.alpha(extendedFloatingActionButton2.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton2.originalTextCsl.getColorForState(extendedFloatingActionButton2.getDrawableState(), BaseMotionStrategy.this.f1611b.originalTextCsl.getDefaultColor()))));
        }

        @Override // android.util.Property
        public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f) {
            ExtendedFloatingActionButton extendedFloatingActionButton2 = extendedFloatingActionButton;
            Float f2 = f;
            int colorForState = extendedFloatingActionButton2.originalTextCsl.getColorForState(extendedFloatingActionButton2.getDrawableState(), BaseMotionStrategy.this.f1611b.originalTextCsl.getDefaultColor());
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(Color.argb((int) (AnimationUtils.lerp(0.0f, Color.alpha(colorForState) / 255.0f, f2.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
            if (f2.floatValue() == 1.0f) {
                extendedFloatingActionButton2.silentlyUpdateTextColor(extendedFloatingActionButton2.originalTextCsl);
            } else {
                extendedFloatingActionButton2.silentlyUpdateTextColor(colorStateListValueOf);
            }
        }
    }

    public BaseMotionStrategy(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton, AnimatorTracker animatorTracker) {
        this.f1611b = extendedFloatingActionButton;
        this.a = extendedFloatingActionButton.getContext();
        this.d = animatorTracker;
    }

    @Override // b.i.a.g.e.MotionStrategy
    @CallSuper
    public void a() {
        this.d.a = null;
    }

    @Override // b.i.a.g.e.MotionStrategy
    @CallSuper
    public void e() {
        this.d.a = null;
    }

    @Override // b.i.a.g.e.MotionStrategy
    public AnimatorSet f() {
        return h(i());
    }

    @NonNull
    public AnimatorSet h(@NonNull MotionSpec motionSpec) {
        ArrayList arrayList = new ArrayList();
        if (motionSpec.hasPropertyValues("opacity")) {
            arrayList.add(motionSpec.getAnimator("opacity", this.f1611b, View.ALPHA));
        }
        if (motionSpec.hasPropertyValues("scale")) {
            arrayList.add(motionSpec.getAnimator("scale", this.f1611b, View.SCALE_Y));
            arrayList.add(motionSpec.getAnimator("scale", this.f1611b, View.SCALE_X));
        }
        if (motionSpec.hasPropertyValues("width")) {
            arrayList.add(motionSpec.getAnimator("width", this.f1611b, ExtendedFloatingActionButton.WIDTH));
        }
        if (motionSpec.hasPropertyValues("height")) {
            arrayList.add(motionSpec.getAnimator("height", this.f1611b, ExtendedFloatingActionButton.HEIGHT));
        }
        if (motionSpec.hasPropertyValues("paddingStart")) {
            arrayList.add(motionSpec.getAnimator("paddingStart", this.f1611b, ExtendedFloatingActionButton.PADDING_START));
        }
        if (motionSpec.hasPropertyValues("paddingEnd")) {
            arrayList.add(motionSpec.getAnimator("paddingEnd", this.f1611b, ExtendedFloatingActionButton.PADDING_END));
        }
        if (motionSpec.hasPropertyValues("labelOpacity")) {
            arrayList.add(motionSpec.getAnimator("labelOpacity", this.f1611b, new a(Float.class, "LABEL_OPACITY_PROPERTY")));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    public final MotionSpec i() {
        MotionSpec motionSpec = this.f;
        if (motionSpec != null) {
            return motionSpec;
        }
        if (this.e == null) {
            this.e = MotionSpec.createFromResource(this.a, b());
        }
        return (MotionSpec) Preconditions.checkNotNull(this.e);
    }

    @Override // b.i.a.g.e.MotionStrategy
    @CallSuper
    public void onAnimationStart(Animator animator) {
        AnimatorTracker animatorTracker = this.d;
        Animator animator2 = animatorTracker.a;
        if (animator2 != null) {
            animator2.cancel();
        }
        animatorTracker.a = animator;
    }
}
