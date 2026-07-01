package androidx.appcompat.view.menu;

import android.view.View;
import android.view.View$OnAttachStateChangeListener;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public class CascadingMenuPopup$2 implements View$OnAttachStateChangeListener {
    public final /* synthetic */ CascadingMenuPopup this$0;

    public CascadingMenuPopup$2(CascadingMenuPopup cascadingMenuPopup) {
        this.this$0 = cascadingMenuPopup;
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        ViewTreeObserver viewTreeObserver = this.this$0.mTreeObserver;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.this$0.mTreeObserver = view.getViewTreeObserver();
            }
            CascadingMenuPopup cascadingMenuPopup = this.this$0;
            cascadingMenuPopup.mTreeObserver.removeGlobalOnLayoutListener(cascadingMenuPopup.mGlobalLayoutListener);
        }
        view.removeOnAttachStateChangeListener(this);
    }
}
