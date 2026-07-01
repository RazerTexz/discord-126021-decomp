package b.a.n;

import android.animation.Animator;
import android.animation.Animator$AnimatorListener;
import com.discord.overlay.OverlayManager;
import com.discord.overlay.views.OverlayBubbleWrap;
import d0.z.d.m;

/* JADX INFO: compiled from: Animator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Animator$AnimatorListener {
    public final /* synthetic */ OverlayManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OverlayBubbleWrap f249b;

    public e(OverlayManager overlayManager, OverlayBubbleWrap overlayBubbleWrap) {
        this.a = overlayManager;
        this.f249b = overlayBubbleWrap;
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationCancel(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
        if (this.a.trashWrap != null) {
            OverlayBubbleWrap overlayBubbleWrap = this.f249b;
            m.checkNotNullParameter(overlayBubbleWrap, "bubble");
            m.checkNotNullParameter(overlayBubbleWrap, "bubble");
        }
        f fVar = this.a.trashEventListener;
        if (fVar != null) {
            fVar.b(this.f249b);
        }
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
    }
}
