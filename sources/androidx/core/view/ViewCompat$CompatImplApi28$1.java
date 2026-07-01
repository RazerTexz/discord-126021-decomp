package androidx.core.view;

import android.view.KeyEvent;
import android.view.View;
import android.view.View$OnUnhandledKeyEventListener;

/* JADX INFO: loaded from: classes.dex */
public class ViewCompat$CompatImplApi28$1 implements View$OnUnhandledKeyEventListener {
    public final /* synthetic */ ViewCompat$OnUnhandledKeyEventListenerCompat val$listener;

    public ViewCompat$CompatImplApi28$1(ViewCompat$OnUnhandledKeyEventListenerCompat viewCompat$OnUnhandledKeyEventListenerCompat) {
        this.val$listener = viewCompat$OnUnhandledKeyEventListenerCompat;
    }

    @Override // android.view.View$OnUnhandledKeyEventListener
    public boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
        return this.val$listener.onUnhandledKeyEvent(view, keyEvent);
    }
}
