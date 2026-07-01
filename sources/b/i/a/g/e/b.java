package b.i.a.g.e;

import android.animation.Animator;
import android.animation.Animator$AnimatorListener;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.ArrayList;

/* JADX INFO: compiled from: BaseMotionStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements j {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ExtendedFloatingActionButton f1611b;
    public final ArrayList<Animator$AnimatorListener> c = new ArrayList<>();
    public final a d;

    @Nullable
    public MotionSpec e;

    @Nullable
    public MotionSpec f;

    public b(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton, a aVar) {
        this.f1611b = extendedFloatingActionButton;
        this.a = extendedFloatingActionButton.getContext();
        this.d = aVar;
    }

    @Override // b.i.a.g.e.j
    @CallSuper
    public void a() {
        this.d.a = null;
    }

    @Override // b.i.a.g.e.j
    @CallSuper
    public void e() {
        this.d.a = null;
    }

    @Override // b.i.a.g.e.j
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
            arrayList.add(motionSpec.getAnimator("labelOpacity", this.f1611b, new b$a(this, Float.class, "LABEL_OPACITY_PROPERTY")));
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

    @Override // b.i.a.g.e.j
    @CallSuper
    public void onAnimationStart(Animator animator) {
        a aVar = this.d;
        Animator animator2 = aVar.a;
        if (animator2 != null) {
            animator2.cancel();
        }
        aVar.a = animator;
    }
}
