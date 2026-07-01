package androidx.appcompat.view.menu;

import android.view.View;
import android.view.View$OnAttachStateChangeListener;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public class StandardMenuPopup$2 implements View$OnAttachStateChangeListener {
    public final /* synthetic */ StandardMenuPopup this$0;

    public StandardMenuPopup$2(StandardMenuPopup standardMenuPopup) {
        this.this$0 = standardMenuPopup;
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
            StandardMenuPopup standardMenuPopup = this.this$0;
            standardMenuPopup.mTreeObserver.removeGlobalOnLayoutListener(standardMenuPopup.mGlobalLayoutListener);
        }
        view.removeOnAttachStateChangeListener(this);
    }
}
