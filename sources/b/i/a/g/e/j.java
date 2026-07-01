package b.i.a.g.e;

import android.animation.Animator;
import android.animation.AnimatorSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.Nullable;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$OnChangedCallback;

/* JADX INFO: compiled from: MotionStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public interface j {
    void a();

    @AnimatorRes
    int b();

    void c();

    boolean d();

    void e();

    AnimatorSet f();

    void g(@Nullable ExtendedFloatingActionButton$OnChangedCallback extendedFloatingActionButton$OnChangedCallback);

    void onAnimationStart(Animator animator);
}
