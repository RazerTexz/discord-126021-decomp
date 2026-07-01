package b.a.n;

import android.view.View;
import android.view.View$OnAttachStateChangeListener;
import androidx.core.view.ViewCompat;
import d0.z.d.m;

/* JADX INFO: compiled from: OverlayManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d$a implements View$OnAttachStateChangeListener {
    public final /* synthetic */ d j;

    public d$a(d dVar) {
        this.j = dVar;
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        m.checkNotNullParameter(view, "v");
        if (!ViewCompat.isLaidOut(view) || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(new d$a$a(this, view));
            return;
        }
        View viewFindViewWithTag = view.findViewWithTag(this.j.m);
        m.checkNotNullExpressionValue(viewFindViewWithTag, "v.findViewWithTag(anchorViewTag)");
        this.j.l.b(viewFindViewWithTag);
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        if (ViewCompat.isAttachedToWindow(this.j.l)) {
            this.j.l.setBubbleTouchable(true);
            this.j.l.a(true);
        }
    }
}
