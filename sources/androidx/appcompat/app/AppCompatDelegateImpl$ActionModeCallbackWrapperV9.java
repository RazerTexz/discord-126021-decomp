package androidx.appcompat.app;

import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ActionMode$Callback;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatDelegateImpl$ActionModeCallbackWrapperV9 implements ActionMode$Callback {
    private ActionMode$Callback mWrapped;
    public final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$ActionModeCallbackWrapperV9(AppCompatDelegateImpl appCompatDelegateImpl, ActionMode$Callback actionMode$Callback) {
        this.this$0 = appCompatDelegateImpl;
        this.mWrapped = actionMode$Callback;
    }

    @Override // androidx.appcompat.view.ActionMode$Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.mWrapped.onActionItemClicked(actionMode, menuItem);
    }

    @Override // androidx.appcompat.view.ActionMode$Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.mWrapped.onCreateActionMode(actionMode, menu);
    }

    @Override // androidx.appcompat.view.ActionMode$Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.mWrapped.onDestroyActionMode(actionMode);
        AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
        if (appCompatDelegateImpl.mActionModePopup != null) {
            appCompatDelegateImpl.mWindow.getDecorView().removeCallbacks(this.this$0.mShowActionModePopup);
        }
        AppCompatDelegateImpl appCompatDelegateImpl2 = this.this$0;
        if (appCompatDelegateImpl2.mActionModeView != null) {
            appCompatDelegateImpl2.endOnGoingFadeAnimation();
            AppCompatDelegateImpl appCompatDelegateImpl3 = this.this$0;
            appCompatDelegateImpl3.mFadeAnim = ViewCompat.animate(appCompatDelegateImpl3.mActionModeView).alpha(0.0f);
            this.this$0.mFadeAnim.setListener(new AppCompatDelegateImpl$ActionModeCallbackWrapperV9$1(this));
        }
        AppCompatDelegateImpl appCompatDelegateImpl4 = this.this$0;
        AppCompatCallback appCompatCallback = appCompatDelegateImpl4.mAppCompatCallback;
        if (appCompatCallback != null) {
            appCompatCallback.onSupportActionModeFinished(appCompatDelegateImpl4.mActionMode);
        }
        AppCompatDelegateImpl appCompatDelegateImpl5 = this.this$0;
        appCompatDelegateImpl5.mActionMode = null;
        ViewCompat.requestApplyInsets(appCompatDelegateImpl5.mSubDecor);
    }

    @Override // androidx.appcompat.view.ActionMode$Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        ViewCompat.requestApplyInsets(this.this$0.mSubDecor);
        return this.mWrapped.onPrepareActionMode(actionMode, menu);
    }
}
