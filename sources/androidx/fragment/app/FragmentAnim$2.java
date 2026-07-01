package androidx.fragment.app;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation$AnimationListener;
import androidx.core.os.CancellationSignal;

/* JADX INFO: loaded from: classes.dex */
public class FragmentAnim$2 implements Animation$AnimationListener {
    public final /* synthetic */ FragmentTransition$Callback val$callback;
    public final /* synthetic */ ViewGroup val$container;
    public final /* synthetic */ Fragment val$fragment;
    public final /* synthetic */ CancellationSignal val$signal;

    public FragmentAnim$2(ViewGroup viewGroup, Fragment fragment, FragmentTransition$Callback fragmentTransition$Callback, CancellationSignal cancellationSignal) {
        this.val$container = viewGroup;
        this.val$fragment = fragment;
        this.val$callback = fragmentTransition$Callback;
        this.val$signal = cancellationSignal;
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.val$container.post(new FragmentAnim$2$1(this));
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
