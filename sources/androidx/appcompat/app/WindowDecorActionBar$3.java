package androidx.appcompat.app;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;

/* JADX INFO: loaded from: classes.dex */
public class WindowDecorActionBar$3 implements ViewPropertyAnimatorUpdateListener {
    public final /* synthetic */ WindowDecorActionBar this$0;

    public WindowDecorActionBar$3(WindowDecorActionBar windowDecorActionBar) {
        this.this$0 = windowDecorActionBar;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorUpdateListener
    public void onAnimationUpdate(View view) {
        ((View) this.this$0.mContainerView.getParent()).invalidate();
    }
}
