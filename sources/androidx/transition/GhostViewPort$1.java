package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver$OnPreDrawListener;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class GhostViewPort$1 implements ViewTreeObserver$OnPreDrawListener {
    public final /* synthetic */ GhostViewPort this$0;

    public GhostViewPort$1(GhostViewPort ghostViewPort) {
        this.this$0 = ghostViewPort;
    }

    @Override // android.view.ViewTreeObserver$OnPreDrawListener
    public boolean onPreDraw() {
        View view;
        ViewCompat.postInvalidateOnAnimation(this.this$0);
        GhostViewPort ghostViewPort = this.this$0;
        ViewGroup viewGroup = ghostViewPort.mStartParent;
        if (viewGroup == null || (view = ghostViewPort.mStartView) == null) {
            return true;
        }
        viewGroup.endViewTransition(view);
        ViewCompat.postInvalidateOnAnimation(this.this$0.mStartParent);
        GhostViewPort ghostViewPort2 = this.this$0;
        ghostViewPort2.mStartParent = null;
        ghostViewPort2.mStartView = null;
        return true;
    }
}
