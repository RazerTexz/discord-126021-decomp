package androidx.appcompat.app;

import android.view.Window$Callback;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter$Callback;

/* JADX INFO: loaded from: classes.dex */
public final class ToolbarActionBar$ActionMenuPresenterCallback implements MenuPresenter$Callback {
    private boolean mClosingActionMenu;
    public final /* synthetic */ ToolbarActionBar this$0;

    public ToolbarActionBar$ActionMenuPresenterCallback(ToolbarActionBar toolbarActionBar) {
        this.this$0 = toolbarActionBar;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter$Callback
    public void onCloseMenu(@NonNull MenuBuilder menuBuilder, boolean z2) {
        if (this.mClosingActionMenu) {
            return;
        }
        this.mClosingActionMenu = true;
        this.this$0.mDecorToolbar.dismissPopupMenus();
        Window$Callback window$Callback = this.this$0.mWindowCallback;
        if (window$Callback != null) {
            window$Callback.onPanelClosed(108, menuBuilder);
        }
        this.mClosingActionMenu = false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter$Callback
    public boolean onOpenSubMenu(@NonNull MenuBuilder menuBuilder) {
        Window$Callback window$Callback = this.this$0.mWindowCallback;
        if (window$Callback == null) {
            return false;
        }
        window$Callback.onMenuOpened(108, menuBuilder);
        return true;
    }
}
