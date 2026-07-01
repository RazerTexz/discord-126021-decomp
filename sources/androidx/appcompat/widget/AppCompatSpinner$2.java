package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatSpinner$2 implements ViewTreeObserver$OnGlobalLayoutListener {
    public final /* synthetic */ AppCompatSpinner this$0;

    public AppCompatSpinner$2(AppCompatSpinner appCompatSpinner) {
        this.this$0 = appCompatSpinner;
    }

    @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (!this.this$0.getInternalPopup().isShowing()) {
            this.this$0.showPopup();
        }
        ViewTreeObserver viewTreeObserver = this.this$0.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeOnGlobalLayoutListener(this);
        }
    }
}
