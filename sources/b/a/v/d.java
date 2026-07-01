package b.a.v;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import b.i.a.f.e.o.f;
import com.discord.tooltips.SparkleView;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import d0.z.d.m;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SparkleView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends Animatable2Compat$AnimationCallback {
    public final /* synthetic */ SparkleView a;

    public d(SparkleView sparkleView) {
        this.a = sparkleView;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback
    public void onAnimationEnd(Drawable drawable) {
        m.checkNotNullParameter(drawable, "drawable");
        CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(this.a);
        if (coroutineScope != null) {
            f.H0(coroutineScope, null, null, new d$a(this, null), 3, null);
        }
    }
}
