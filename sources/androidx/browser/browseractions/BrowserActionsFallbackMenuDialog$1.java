package androidx.browser.browseractions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
public class BrowserActionsFallbackMenuDialog$1 extends AnimatorListenerAdapter {
    public final /* synthetic */ BrowserActionsFallbackMenuDialog this$0;
    public final /* synthetic */ boolean val$isEnterAnimation;

    public BrowserActionsFallbackMenuDialog$1(BrowserActionsFallbackMenuDialog browserActionsFallbackMenuDialog, boolean z2) {
        this.this$0 = browserActionsFallbackMenuDialog;
        this.val$isEnterAnimation = z2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.val$isEnterAnimation) {
            return;
        }
        BrowserActionsFallbackMenuDialog.access$001(this.this$0);
    }
}
