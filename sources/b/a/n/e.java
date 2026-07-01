package b.a.n;

import android.animation.Animator;
import com.discord.overlay.OverlayManager;
import com.discord.overlay.views.OverlayBubbleWrap;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: Animator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Animator.AnimatorListener {
    public final /* synthetic */ OverlayManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OverlayBubbleWrap f249b;

    public e(OverlayManager overlayManager, OverlayBubbleWrap overlayBubbleWrap) {
        this.a = overlayManager;
        this.f249b = overlayBubbleWrap;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animator");
        if (this.a.trashWrap != null) {
            OverlayBubbleWrap overlayBubbleWrap = this.f249b;
            Intrinsics3.checkNotNullParameter(overlayBubbleWrap, "bubble");
            Intrinsics3.checkNotNullParameter(overlayBubbleWrap, "bubble");
        }
        TrashEventListener trashEventListener = this.a.trashEventListener;
        if (trashEventListener != null) {
            trashEventListener.b(this.f249b);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animator");
    }
}
