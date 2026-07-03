package p007b.p225i.p226a.p341g.p348g;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.IndeterminateDrawable;

/* JADX INFO: renamed from: b.i.a.g.g.g */
/* JADX INFO: compiled from: IndeterminateAnimatorDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4421g<T extends Animator> {

    /* JADX INFO: renamed from: a */
    public IndeterminateDrawable f11736a;

    /* JADX INFO: renamed from: b */
    public final float[] f11737b;

    /* JADX INFO: renamed from: c */
    public final int[] f11738c;

    public AbstractC4421g(int i) {
        this.f11737b = new float[i * 2];
        this.f11738c = new int[i];
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo6123a();

    /* JADX INFO: renamed from: b */
    public float m6130b(int i, int i2, int i3) {
        return (i - i2) / i3;
    }

    /* JADX INFO: renamed from: c */
    public abstract void mo6124c();

    /* JADX INFO: renamed from: d */
    public abstract void mo6125d(@NonNull Animatable2Compat.AnimationCallback animationCallback);

    /* JADX INFO: renamed from: e */
    public abstract void mo6126e();

    /* JADX INFO: renamed from: f */
    public abstract void mo6127f();

    /* JADX INFO: renamed from: g */
    public abstract void mo6128g();
}
