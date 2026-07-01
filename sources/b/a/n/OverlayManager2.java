package b.a.n;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import b.a.n.h.OverlayTrashWrap;
import b.d.b.a.outline;
import com.discord.overlay.OverlayManager;
import com.discord.overlay.R;
import com.discord.overlay.views.OverlayBubbleWrap;
import d0.z.d.Intrinsics3;
import java.util.Objects;

/* JADX INFO: renamed from: b.a.n.a, reason: use source file name */
/* JADX INFO: compiled from: OverlayManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OverlayManager2 implements View.OnTouchListener {
    public final /* synthetic */ OverlayManager j;

    public OverlayManager2(OverlayManager overlayManager) {
        this.j = overlayManager;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002c  */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z2;
        Intrinsics3.checkNotNullExpressionValue(motionEvent, "event");
        int action = motionEvent.getAction();
        if (action == 1 || action == 2) {
            OverlayTrashWrap overlayTrashWrap = this.j.trashWrap;
            if (overlayTrashWrap != null) {
                if (overlayTrashWrap.n.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            if (z2) {
                Objects.requireNonNull(view, "null cannot be cast to non-null type com.discord.overlay.views.OverlayBubbleWrap");
                OverlayBubbleWrap overlayBubbleWrap = (OverlayBubbleWrap) view;
                if (motionEvent.getAction() == 1) {
                    OverlayManager overlayManager = this.j;
                    Objects.requireNonNull(overlayManager);
                    Point point = overlayBubbleWrap.anchorPosition;
                    if (point != null) {
                        Point point2 = overlayBubbleWrap.actualPosition;
                        point2.x = point.x;
                        point2.y = point.y;
                        String simpleName = overlayBubbleWrap.getClass().getSimpleName();
                        StringBuilder sbU = outline.U("Moved to anchor [");
                        sbU.append(overlayBubbleWrap.actualPosition);
                        sbU.append(']');
                        Log.d(simpleName, sbU.toString());
                    }
                    overlayManager.c(null);
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(overlayBubbleWrap.getContext(), R.a.fade_out);
                    animatorLoadAnimator.setTarget(overlayBubbleWrap);
                    animatorLoadAnimator.addListener(new e(overlayManager, overlayBubbleWrap));
                    animatorLoadAnimator.start();
                    OverlayBubbleWrap.c(overlayBubbleWrap, (int) overlayBubbleWrap.getX(), (overlayBubbleWrap.getHeight() / 2) + ((int) overlayBubbleWrap.getY()), null, 4, null);
                    return true;
                }
                this.j.c(overlayBubbleWrap);
            } else {
                this.j.c(null);
            }
        }
        return false;
    }
}
