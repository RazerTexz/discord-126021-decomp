package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.widget.PopupWindow$OnDismissListener;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatSpinner$DropdownPopup$3 implements PopupWindow$OnDismissListener {
    public final /* synthetic */ AppCompatSpinner$DropdownPopup this$1;
    public final /* synthetic */ ViewTreeObserver$OnGlobalLayoutListener val$layoutListener;

    public AppCompatSpinner$DropdownPopup$3(AppCompatSpinner$DropdownPopup appCompatSpinner$DropdownPopup, ViewTreeObserver$OnGlobalLayoutListener viewTreeObserver$OnGlobalLayoutListener) {
        this.this$1 = appCompatSpinner$DropdownPopup;
        this.val$layoutListener = viewTreeObserver$OnGlobalLayoutListener;
    }

    @Override // android.widget.PopupWindow$OnDismissListener
    public void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.this$1.this$0.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.val$layoutListener);
        }
    }
}
