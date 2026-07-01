package androidx.appcompat.widget;

import androidx.appcompat.view.menu.ActionMenuItemView$PopupCallback;
import androidx.appcompat.view.menu.ShowableListMenu;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuPresenter$ActionMenuPopupCallback extends ActionMenuItemView$PopupCallback {
    public final /* synthetic */ ActionMenuPresenter this$0;

    public ActionMenuPresenter$ActionMenuPopupCallback(ActionMenuPresenter actionMenuPresenter) {
        this.this$0 = actionMenuPresenter;
    }

    @Override // androidx.appcompat.view.menu.ActionMenuItemView$PopupCallback
    public ShowableListMenu getPopup() {
        ActionMenuPresenter$ActionButtonSubmenu actionMenuPresenter$ActionButtonSubmenu = this.this$0.mActionButtonPopup;
        if (actionMenuPresenter$ActionButtonSubmenu != null) {
            return actionMenuPresenter$ActionButtonSubmenu.getPopup();
        }
        return null;
    }
}
