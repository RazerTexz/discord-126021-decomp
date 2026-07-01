package androidx.appcompat.app;

import android.view.View;
import android.widget.PopupWindow;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatDelegateImpl$ActionModeCallbackWrapperV9$1 extends ViewPropertyAnimatorListenerAdapter {
    public final /* synthetic */ AppCompatDelegateImpl$ActionModeCallbackWrapperV9 this$1;

    public AppCompatDelegateImpl$ActionModeCallbackWrapperV9$1(AppCompatDelegateImpl$ActionModeCallbackWrapperV9 appCompatDelegateImpl$ActionModeCallbackWrapperV9) {
        this.this$1 = appCompatDelegateImpl$ActionModeCallbackWrapperV9;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationEnd(View view) {
        this.this$1.this$0.mActionModeView.setVisibility(8);
        AppCompatDelegateImpl appCompatDelegateImpl = this.this$1.this$0;
        PopupWindow popupWindow = appCompatDelegateImpl.mActionModePopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        } else if (appCompatDelegateImpl.mActionModeView.getParent() instanceof View) {
            ViewCompat.requestApplyInsets((View) this.this$1.this$0.mActionModeView.getParent());
        }
        this.this$1.this$0.mActionModeView.removeAllViews();
        this.this$1.this$0.mFadeAnim.setListener(null);
        AppCompatDelegateImpl appCompatDelegateImpl2 = this.this$1.this$0;
        appCompatDelegateImpl2.mFadeAnim = null;
        ViewCompat.requestApplyInsets(appCompatDelegateImpl2.mSubDecor);
    }
}
