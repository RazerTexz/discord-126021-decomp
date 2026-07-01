package androidx.appcompat.app;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatDelegateImpl$6$1 extends ViewPropertyAnimatorListenerAdapter {
    public final /* synthetic */ AppCompatDelegateImpl$6 this$1;

    public AppCompatDelegateImpl$6$1(AppCompatDelegateImpl$6 appCompatDelegateImpl$6) {
        this.this$1 = appCompatDelegateImpl$6;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationEnd(View view) {
        this.this$1.this$0.mActionModeView.setAlpha(1.0f);
        this.this$1.this$0.mFadeAnim.setListener(null);
        this.this$1.this$0.mFadeAnim = null;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationStart(View view) {
        this.this$1.this$0.mActionModeView.setVisibility(0);
    }
}
