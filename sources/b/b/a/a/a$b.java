package b.b.a.a;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation$AnimationListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AddContentDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$b implements Animation$AnimationListener {
    public final /* synthetic */ a j;
    public final /* synthetic */ boolean k;

    public a$b(a aVar, boolean z2) {
        this.j = aVar;
        this.k = z2;
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        Function1<? super View, Unit> function1;
        d0.z.d.m.checkNotNullParameter(animation, "animation");
        this.j.dismissAllowingStateLoss();
        if (!this.k || (view = this.j.getView()) == null || (function1 = this.j.onKeyboardSelectedListener) == null) {
            return;
        }
        d0.z.d.m.checkNotNullExpressionValue(view, "it");
        function1.invoke(view);
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationRepeat(Animation animation) {
        d0.z.d.m.checkNotNullParameter(animation, "animation");
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationStart(Animation animation) {
        d0.z.d.m.checkNotNullParameter(animation, "animation");
    }
}
