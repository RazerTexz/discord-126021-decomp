package b.i.a.g.g;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.IndeterminateDrawable;

/* JADX INFO: renamed from: b.i.a.g.g.g, reason: use source file name */
/* JADX INFO: compiled from: IndeterminateAnimatorDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class IndeterminateAnimatorDelegate<T extends Animator> {
    public IndeterminateDrawable a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f1623b;
    public final int[] c;

    public IndeterminateAnimatorDelegate(int i) {
        this.f1623b = new float[i * 2];
        this.c = new int[i];
    }

    public abstract void a();

    public float b(int i, int i2, int i3) {
        return (i - i2) / i3;
    }

    public abstract void c();

    public abstract void d(@NonNull Animatable2Compat.AnimationCallback animationCallback);

    public abstract void e();

    public abstract void f();

    public abstract void g();
}
