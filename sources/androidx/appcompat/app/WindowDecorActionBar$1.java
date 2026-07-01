package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
public class WindowDecorActionBar$1 extends ViewPropertyAnimatorListenerAdapter {
    public final /* synthetic */ WindowDecorActionBar this$0;

    public WindowDecorActionBar$1(WindowDecorActionBar windowDecorActionBar) {
        this.this$0 = windowDecorActionBar;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationEnd(View view) {
        View view2;
        WindowDecorActionBar windowDecorActionBar = this.this$0;
        if (windowDecorActionBar.mContentAnimations && (view2 = windowDecorActionBar.mContentView) != null) {
            view2.setTranslationY(0.0f);
            this.this$0.mContainerView.setTranslationY(0.0f);
        }
        this.this$0.mContainerView.setVisibility(8);
        this.this$0.mContainerView.setTransitioning(false);
        WindowDecorActionBar windowDecorActionBar2 = this.this$0;
        windowDecorActionBar2.mCurrentShowAnim = null;
        windowDecorActionBar2.completeDeferredDestroyActionMode();
        ActionBarOverlayLayout actionBarOverlayLayout = this.this$0.mOverlayLayout;
        if (actionBarOverlayLayout != null) {
            ViewCompat.requestApplyInsets(actionBarOverlayLayout);
        }
    }
}
