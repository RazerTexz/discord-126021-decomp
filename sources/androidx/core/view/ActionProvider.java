package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActionProvider {
    private static final String TAG = "ActionProvider(support)";
    private final Context mContext;
    private ActionProvider$SubUiVisibilityListener mSubUiVisibilityListener;
    private ActionProvider$VisibilityListener mVisibilityListener;

    public ActionProvider(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public abstract View onCreateActionView();

    public View onCreateActionView(MenuItem menuItem) {
        return onCreateActionView();
    }

    public boolean onPerformDefaultAction() {
        return false;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public void refreshVisibility() {
        if (this.mVisibilityListener == null || !overridesItemVisibility()) {
            return;
        }
        this.mVisibilityListener.onActionProviderVisibilityChanged(isVisible());
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public void reset() {
        this.mVisibilityListener = null;
        this.mSubUiVisibilityListener = null;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public void setSubUiVisibilityListener(ActionProvider$SubUiVisibilityListener actionProvider$SubUiVisibilityListener) {
        this.mSubUiVisibilityListener = actionProvider$SubUiVisibilityListener;
    }

    public void setVisibilityListener(ActionProvider$VisibilityListener actionProvider$VisibilityListener) {
        if (this.mVisibilityListener != null && actionProvider$VisibilityListener != null) {
            StringBuilder sbU = a.U("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            sbU.append(getClass().getSimpleName());
            sbU.append(" instance while it is still in use somewhere else?");
            Log.w(TAG, sbU.toString());
        }
        this.mVisibilityListener = actionProvider$VisibilityListener;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public void subUiVisibilityChanged(boolean z2) {
        ActionProvider$SubUiVisibilityListener actionProvider$SubUiVisibilityListener = this.mSubUiVisibilityListener;
        if (actionProvider$SubUiVisibilityListener != null) {
            actionProvider$SubUiVisibilityListener.onSubUiVisibilityChanged(z2);
        }
    }
}
