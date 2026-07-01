package b.a.n;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View$OnTouchListener;
import com.discord.overlay.OverlayManager;
import com.discord.overlay.R$a;
import com.discord.overlay.views.OverlayBubbleWrap;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: OverlayManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a implements View$OnTouchListener {
    public final /* synthetic */ OverlayManager j;

    public a(OverlayManager overlayManager) {
        this.j = overlayManager;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002c  */
    @Override // android.view.View$OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z2;
        m.checkNotNullExpressionValue(motionEvent, "event");
        int action = motionEvent.getAction();
        if (action == 1 || action == 2) {
            b.a.n.h.a aVar = this.j.trashWrap;
            if (aVar != null) {
                if (aVar.n.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
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
                        StringBuilder sbU = b.d.b.a.a.U("Moved to anchor [");
                        sbU.append(overlayBubbleWrap.actualPosition);
                        sbU.append(']');
                        Log.d(simpleName, sbU.toString());
                    }
                    overlayManager.c(null);
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(overlayBubbleWrap.getContext(), R$a.fade_out);
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
