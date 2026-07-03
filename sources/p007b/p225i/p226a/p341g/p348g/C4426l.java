package p007b.p225i.p226a.p341g.p348g;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;
import com.google.android.material.C10817R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.g.g.l */
/* JADX INFO: compiled from: LinearIndeterminateDisjointAnimatorDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4426l extends AbstractC4421g<ObjectAnimator> {

    /* JADX INFO: renamed from: d */
    public static final int[] f11751d = {533, 567, 850, 750};

    /* JADX INFO: renamed from: e */
    public static final int[] f11752e = {1267, 1000, 333, 0};

    /* JADX INFO: renamed from: f */
    public static final Property<C4426l, Float> f11753f = new a(Float.class, "animationFraction");

    /* JADX INFO: renamed from: g */
    public ObjectAnimator f11754g;

    /* JADX INFO: renamed from: h */
    public final Interpolator[] f11755h;

    /* JADX INFO: renamed from: i */
    public final BaseProgressIndicatorSpec f11756i;

    /* JADX INFO: renamed from: j */
    public int f11757j;

    /* JADX INFO: renamed from: k */
    public boolean f11758k;

    /* JADX INFO: renamed from: l */
    public float f11759l;

    /* JADX INFO: renamed from: m */
    public boolean f11760m;

    /* JADX INFO: renamed from: n */
    public Animatable2Compat.AnimationCallback f11761n;

    /* JADX INFO: renamed from: b.i.a.g.g.l$a */
    /* JADX INFO: compiled from: LinearIndeterminateDisjointAnimatorDelegate.java */
    public static class a extends Property<C4426l, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(C4426l c4426l) {
            return Float.valueOf(c4426l.f11759l);
        }

        @Override // android.util.Property
        public void set(C4426l c4426l, Float f) {
            C4426l c4426l2 = c4426l;
            float fFloatValue = f.floatValue();
            c4426l2.f11759l = fFloatValue;
            int i = (int) (fFloatValue * 1800.0f);
            for (int i2 = 0; i2 < 4; i2++) {
                c4426l2.f11737b[i2] = Math.max(0.0f, Math.min(1.0f, c4426l2.f11755h[i2].getInterpolation(c4426l2.m6130b(i, C4426l.f11752e[i2], C4426l.f11751d[i2]))));
            }
            if (c4426l2.f11758k) {
                Arrays.fill(c4426l2.f11738c, MaterialColors.compositeARGBWithAlpha(c4426l2.f11756i.indicatorColors[c4426l2.f11757j], c4426l2.f11736a.getAlpha()));
                c4426l2.f11758k = false;
            }
            c4426l2.f11736a.invalidateSelf();
        }
    }

    public C4426l(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.f11757j = 0;
        this.f11761n = null;
        this.f11756i = linearProgressIndicatorSpec;
        this.f11755h = new Interpolator[]{AnimationUtilsCompat.loadInterpolator(context, C10817R.animator.linear_indeterminate_line1_head_interpolator), AnimationUtilsCompat.loadInterpolator(context, C10817R.animator.linear_indeterminate_line1_tail_interpolator), AnimationUtilsCompat.loadInterpolator(context, C10817R.animator.linear_indeterminate_line2_head_interpolator), AnimationUtilsCompat.loadInterpolator(context, C10817R.animator.linear_indeterminate_line2_tail_interpolator)};
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4421g
    /* JADX INFO: renamed from: a */
    public void mo6123a() {
        ObjectAnimator objectAnimator = this.f11754g;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4421g
    /* JADX INFO: renamed from: c */
    public void mo6124c() {
        m6133h();
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4421g
    /* JADX INFO: renamed from: d */
    public void mo6125d(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.f11761n = animationCallback;
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4421g
    /* JADX INFO: renamed from: e */
    public void mo6126e() {
        if (this.f11736a.isVisible()) {
            this.f11760m = true;
            this.f11754g.setRepeatCount(0);
        } else {
            ObjectAnimator objectAnimator = this.f11754g;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
        }
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4421g
    /* JADX INFO: renamed from: f */
    public void mo6127f() {
        if (this.f11754g == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f11753f, 0.0f, 1.0f);
            this.f11754g = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(1800L);
            this.f11754g.setInterpolator(null);
            this.f11754g.setRepeatCount(-1);
            this.f11754g.addListener(new C4425k(this));
        }
        m6133h();
        this.f11754g.start();
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4421g
    /* JADX INFO: renamed from: g */
    public void mo6128g() {
        this.f11761n = null;
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: h */
    public void m6133h() {
        this.f11757j = 0;
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(this.f11756i.indicatorColors[0], this.f11736a.getAlpha());
        int[] iArr = this.f11738c;
        iArr[0] = iCompositeARGBWithAlpha;
        iArr[1] = iCompositeARGBWithAlpha;
    }
}
