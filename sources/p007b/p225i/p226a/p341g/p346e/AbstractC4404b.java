package p007b.p225i.p226a.p341g.p346e;

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

/* JADX INFO: renamed from: b.i.a.g.e.b */
/* JADX INFO: compiled from: BaseMotionStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4404b implements InterfaceC4412j {

    /* JADX INFO: renamed from: a */
    public final Context f11621a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ExtendedFloatingActionButton f11622b;

    /* JADX INFO: renamed from: c */
    public final ArrayList<Animator.AnimatorListener> f11623c = new ArrayList<>();

    /* JADX INFO: renamed from: d */
    public final C4403a f11624d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public MotionSpec f11625e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public MotionSpec f11626f;

    /* JADX INFO: renamed from: b.i.a.g.e.b$a */
    /* JADX INFO: compiled from: BaseMotionStrategy.java */
    public class a extends Property<ExtendedFloatingActionButton, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
            ExtendedFloatingActionButton extendedFloatingActionButton2 = extendedFloatingActionButton;
            return Float.valueOf(AnimationUtils.lerp(0.0f, 1.0f, (Color.alpha(extendedFloatingActionButton2.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton2.originalTextCsl.getColorForState(extendedFloatingActionButton2.getDrawableState(), AbstractC4404b.this.f11622b.originalTextCsl.getDefaultColor()))));
        }

        @Override // android.util.Property
        public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f) {
            ExtendedFloatingActionButton extendedFloatingActionButton2 = extendedFloatingActionButton;
            Float f2 = f;
            int colorForState = extendedFloatingActionButton2.originalTextCsl.getColorForState(extendedFloatingActionButton2.getDrawableState(), AbstractC4404b.this.f11622b.originalTextCsl.getDefaultColor());
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(Color.argb((int) (AnimationUtils.lerp(0.0f, Color.alpha(colorForState) / 255.0f, f2.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
            if (f2.floatValue() == 1.0f) {
                extendedFloatingActionButton2.silentlyUpdateTextColor(extendedFloatingActionButton2.originalTextCsl);
            } else {
                extendedFloatingActionButton2.silentlyUpdateTextColor(colorStateListValueOf);
            }
        }
    }

    public AbstractC4404b(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton, C4403a c4403a) {
        this.f11622b = extendedFloatingActionButton;
        this.f11621a = extendedFloatingActionButton.getContext();
        this.f11624d = c4403a;
    }

    @Override // p007b.p225i.p226a.p341g.p346e.InterfaceC4412j
    @CallSuper
    /* JADX INFO: renamed from: a */
    public void mo6078a() {
        this.f11624d.f11620a = null;
    }

    @Override // p007b.p225i.p226a.p341g.p346e.InterfaceC4412j
    @CallSuper
    /* JADX INFO: renamed from: e */
    public void mo6079e() {
        this.f11624d.f11620a = null;
    }

    @Override // p007b.p225i.p226a.p341g.p346e.InterfaceC4412j
    /* JADX INFO: renamed from: f */
    public AnimatorSet mo6080f() {
        return m6081h(m6082i());
    }

    @NonNull
    /* JADX INFO: renamed from: h */
    public AnimatorSet m6081h(@NonNull MotionSpec motionSpec) {
        ArrayList arrayList = new ArrayList();
        if (motionSpec.hasPropertyValues("opacity")) {
            arrayList.add(motionSpec.getAnimator("opacity", this.f11622b, View.ALPHA));
        }
        if (motionSpec.hasPropertyValues("scale")) {
            arrayList.add(motionSpec.getAnimator("scale", this.f11622b, View.SCALE_Y));
            arrayList.add(motionSpec.getAnimator("scale", this.f11622b, View.SCALE_X));
        }
        if (motionSpec.hasPropertyValues("width")) {
            arrayList.add(motionSpec.getAnimator("width", this.f11622b, ExtendedFloatingActionButton.WIDTH));
        }
        if (motionSpec.hasPropertyValues("height")) {
            arrayList.add(motionSpec.getAnimator("height", this.f11622b, ExtendedFloatingActionButton.HEIGHT));
        }
        if (motionSpec.hasPropertyValues("paddingStart")) {
            arrayList.add(motionSpec.getAnimator("paddingStart", this.f11622b, ExtendedFloatingActionButton.PADDING_START));
        }
        if (motionSpec.hasPropertyValues("paddingEnd")) {
            arrayList.add(motionSpec.getAnimator("paddingEnd", this.f11622b, ExtendedFloatingActionButton.PADDING_END));
        }
        if (motionSpec.hasPropertyValues("labelOpacity")) {
            arrayList.add(motionSpec.getAnimator("labelOpacity", this.f11622b, new a(Float.class, "LABEL_OPACITY_PROPERTY")));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    /* JADX INFO: renamed from: i */
    public final MotionSpec m6082i() {
        MotionSpec motionSpec = this.f11626f;
        if (motionSpec != null) {
            return motionSpec;
        }
        if (this.f11625e == null) {
            this.f11625e = MotionSpec.createFromResource(this.f11621a, mo6112b());
        }
        return (MotionSpec) Preconditions.checkNotNull(this.f11625e);
    }

    @Override // p007b.p225i.p226a.p341g.p346e.InterfaceC4412j
    @CallSuper
    public void onAnimationStart(Animator animator) {
        C4403a c4403a = this.f11624d;
        Animator animator2 = c4403a.f11620a;
        if (animator2 != null) {
            animator2.cancel();
        }
        c4403a.f11620a = animator;
    }
}
