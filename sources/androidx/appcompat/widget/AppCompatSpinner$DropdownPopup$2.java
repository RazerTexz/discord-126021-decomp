package androidx.appcompat.widget;

import android.view.ViewTreeObserver$OnGlobalLayoutListener;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatSpinner$DropdownPopup$2 implements ViewTreeObserver$OnGlobalLayoutListener {
    public final /* synthetic */ AppCompatSpinner$DropdownPopup this$1;

    public AppCompatSpinner$DropdownPopup$2(AppCompatSpinner$DropdownPopup appCompatSpinner$DropdownPopup) {
        this.this$1 = appCompatSpinner$DropdownPopup;
    }

    @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
    public void onGlobalLayout() {
        AppCompatSpinner$DropdownPopup appCompatSpinner$DropdownPopup = this.this$1;
        if (!appCompatSpinner$DropdownPopup.isVisibleToUser(appCompatSpinner$DropdownPopup.this$0)) {
            this.this$1.dismiss();
        } else {
            this.this$1.computeContentWidth();
            AppCompatSpinner$DropdownPopup.access$001(this.this$1);
        }
    }
}
