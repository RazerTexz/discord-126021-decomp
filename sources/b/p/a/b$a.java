package b.p.a;

import android.view.animation.Animation;
import android.view.animation.Animation$AnimationListener;
import android.widget.LinearLayout;
import com.tapadoo.alerter.R$d;

/* JADX INFO: compiled from: Alert.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$a implements Animation$AnimationListener {
    public final /* synthetic */ b j;

    public b$a(b bVar) {
        this.j = bVar;
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationEnd(Animation animation) {
        d0.z.d.m.checkNotNullParameter(animation, "animation");
        b bVar = this.j;
        bVar.clearAnimation();
        bVar.setVisibility(8);
        bVar.postDelayed(new e(bVar), 100);
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationRepeat(Animation animation) {
        d0.z.d.m.checkNotNullParameter(animation, "animation");
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationStart(Animation animation) {
        d0.z.d.m.checkNotNullParameter(animation, "animation");
        b bVar = this.j;
        int i = R$d.llAlertBackground;
        LinearLayout linearLayout = (LinearLayout) bVar.c(i);
        if (linearLayout != null) {
            linearLayout.setOnClickListener(null);
        }
        LinearLayout linearLayout2 = (LinearLayout) this.j.c(i);
        if (linearLayout2 != null) {
            linearLayout2.setClickable(false);
        }
    }
}
