package p007b.p008a.p036n;

import android.animation.Animator;
import com.discord.overlay.OverlayManager;
import com.discord.overlay.views.OverlayBubbleWrap;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.n.e */
/* JADX INFO: compiled from: Animator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1170e implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ OverlayManager f1555a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ OverlayBubbleWrap f1556b;

    public C1170e(OverlayManager overlayManager, OverlayBubbleWrap overlayBubbleWrap) {
        this.f1555a = overlayManager;
        this.f1556b = overlayBubbleWrap;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        C12238m.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        C12238m.checkNotNullParameter(animator, "animator");
        if (this.f1555a.trashWrap != null) {
            OverlayBubbleWrap overlayBubbleWrap = this.f1556b;
            C12238m.checkNotNullParameter(overlayBubbleWrap, "bubble");
            C12238m.checkNotNullParameter(overlayBubbleWrap, "bubble");
        }
        InterfaceC1171f interfaceC1171f = this.f1555a.trashEventListener;
        if (interfaceC1171f != null) {
            interfaceC1171f.mo228b(this.f1556b);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        C12238m.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        C12238m.checkNotNullParameter(animator, "animator");
    }
}
