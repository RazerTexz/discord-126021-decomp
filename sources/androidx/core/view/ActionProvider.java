package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActionProvider {
    private static final String TAG = "ActionProvider(support)";
    private final Context mContext;
    private SubUiVisibilityListener mSubUiVisibilityListener;
    private VisibilityListener mVisibilityListener;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface SubUiVisibilityListener {
        void onSubUiVisibilityChanged(boolean z2);
    }

    public interface VisibilityListener {
        void onActionProviderVisibilityChanged(boolean z2);
    }

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

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void reset() {
        this.mVisibilityListener = null;
        this.mSubUiVisibilityListener = null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSubUiVisibilityListener(SubUiVisibilityListener subUiVisibilityListener) {
        this.mSubUiVisibilityListener = subUiVisibilityListener;
    }

    public void setVisibilityListener(VisibilityListener visibilityListener) {
        if (this.mVisibilityListener != null && visibilityListener != null) {
            StringBuilder sbM833U = C1643a.m833U("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            sbM833U.append(getClass().getSimpleName());
            sbM833U.append(" instance while it is still in use somewhere else?");
            Log.w(TAG, sbM833U.toString());
        }
        this.mVisibilityListener = visibilityListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void subUiVisibilityChanged(boolean z2) {
        SubUiVisibilityListener subUiVisibilityListener = this.mSubUiVisibilityListener;
        if (subUiVisibilityListener != null) {
            subUiVisibilityListener.onSubUiVisibilityChanged(z2);
        }
    }
}
