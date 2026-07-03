package p007b.p008a.p036n;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.discord.overlay.C5570R;
import com.discord.overlay.OverlayManager;
import com.discord.overlay.views.OverlayBubbleWrap;
import java.util.Objects;
import p007b.p008a.p036n.p038h.C1173a;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.n.a */
/* JADX INFO: compiled from: OverlayManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnTouchListenerC1166a implements View.OnTouchListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ OverlayManager f1547j;

    public ViewOnTouchListenerC1166a(OverlayManager overlayManager) {
        this.f1547j = overlayManager;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002c  */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z2;
        C12238m.checkNotNullExpressionValue(motionEvent, "event");
        int action = motionEvent.getAction();
        if (action == 1 || action == 2) {
            C1173a c1173a = this.f1547j.trashWrap;
            if (c1173a != null) {
                if (c1173a.f1565n.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
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
                    OverlayManager overlayManager = this.f1547j;
                    Objects.requireNonNull(overlayManager);
                    Point point = overlayBubbleWrap.anchorPosition;
                    if (point != null) {
                        Point point2 = overlayBubbleWrap.actualPosition;
                        point2.x = point.x;
                        point2.y = point.y;
                        String simpleName = overlayBubbleWrap.getClass().getSimpleName();
                        StringBuilder sbM833U = C1643a.m833U("Moved to anchor [");
                        sbM833U.append(overlayBubbleWrap.actualPosition);
                        sbM833U.append(']');
                        Log.d(simpleName, sbM833U.toString());
                    }
                    overlayManager.m8432c(null);
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(overlayBubbleWrap.getContext(), C5570R.a.fade_out);
                    animatorLoadAnimator.setTarget(overlayBubbleWrap);
                    animatorLoadAnimator.addListener(new C1170e(overlayManager, overlayBubbleWrap));
                    animatorLoadAnimator.start();
                    OverlayBubbleWrap.m8434c(overlayBubbleWrap, (int) overlayBubbleWrap.getX(), (overlayBubbleWrap.getHeight() / 2) + ((int) overlayBubbleWrap.getY()), null, 4, null);
                    return true;
                }
                this.f1547j.m8432c(overlayBubbleWrap);
            } else {
                this.f1547j.m8432c(null);
            }
        }
        return false;
    }
}
