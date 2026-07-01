package androidx.appcompat.widget;

import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public class ForwardingListener$DisallowIntercept implements Runnable {
    public final /* synthetic */ ForwardingListener this$0;

    public ForwardingListener$DisallowIntercept(ForwardingListener forwardingListener) {
        this.this$0 = forwardingListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewParent parent = this.this$0.mSrc.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }
}
