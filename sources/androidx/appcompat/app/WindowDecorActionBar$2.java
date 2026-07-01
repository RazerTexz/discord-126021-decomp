package androidx.appcompat.app;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
public class WindowDecorActionBar$2 extends ViewPropertyAnimatorListenerAdapter {
    public final /* synthetic */ WindowDecorActionBar this$0;

    public WindowDecorActionBar$2(WindowDecorActionBar windowDecorActionBar) {
        this.this$0 = windowDecorActionBar;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationEnd(View view) {
        WindowDecorActionBar windowDecorActionBar = this.this$0;
        windowDecorActionBar.mCurrentShowAnim = null;
        windowDecorActionBar.mContainerView.requestLayout();
    }
}
