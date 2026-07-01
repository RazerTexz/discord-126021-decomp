package androidx.appcompat.app;

import android.view.Window$Callback;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter$Callback;

/* JADX INFO: loaded from: classes.dex */
public final class AppCompatDelegateImpl$PanelMenuPresenterCallback implements MenuPresenter$Callback {
    public final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$PanelMenuPresenterCallback(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter$Callback
    public void onCloseMenu(@NonNull MenuBuilder menuBuilder, boolean z2) {
        MenuBuilder rootMenu = menuBuilder.getRootMenu();
        boolean z3 = rootMenu != menuBuilder;
        AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
        if (z3) {
            menuBuilder = rootMenu;
        }
        AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureStateFindMenuPanel = appCompatDelegateImpl.findMenuPanel(menuBuilder);
        if (appCompatDelegateImpl$PanelFeatureStateFindMenuPanel != null) {
            if (!z3) {
                this.this$0.closePanel(appCompatDelegateImpl$PanelFeatureStateFindMenuPanel, z2);
            } else {
                this.this$0.callOnPanelClosed(appCompatDelegateImpl$PanelFeatureStateFindMenuPanel.featureId, appCompatDelegateImpl$PanelFeatureStateFindMenuPanel, rootMenu);
                this.this$0.closePanel(appCompatDelegateImpl$PanelFeatureStateFindMenuPanel, true);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter$Callback
    public boolean onOpenSubMenu(@NonNull MenuBuilder menuBuilder) {
        Window$Callback windowCallback;
        if (menuBuilder != menuBuilder.getRootMenu()) {
            return true;
        }
        AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
        if (!appCompatDelegateImpl.mHasActionBar || (windowCallback = appCompatDelegateImpl.getWindowCallback()) == null || this.this$0.mIsDestroyed) {
            return true;
        }
        windowCallback.onMenuOpened(108, menuBuilder);
        return true;
    }
}
