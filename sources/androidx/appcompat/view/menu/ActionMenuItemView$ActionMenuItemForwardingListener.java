package androidx.appcompat.view.menu;

import androidx.appcompat.widget.ForwardingListener;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView$ActionMenuItemForwardingListener extends ForwardingListener {
    public final /* synthetic */ ActionMenuItemView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionMenuItemView$ActionMenuItemForwardingListener(ActionMenuItemView actionMenuItemView) {
        super(actionMenuItemView);
        this.this$0 = actionMenuItemView;
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public ShowableListMenu getPopup() {
        ActionMenuItemView$PopupCallback actionMenuItemView$PopupCallback = this.this$0.mPopupCallback;
        if (actionMenuItemView$PopupCallback != null) {
            return actionMenuItemView$PopupCallback.getPopup();
        }
        return null;
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public boolean onForwardingStarted() {
        ShowableListMenu popup;
        ActionMenuItemView actionMenuItemView = this.this$0;
        MenuBuilder$ItemInvoker menuBuilder$ItemInvoker = actionMenuItemView.mItemInvoker;
        return menuBuilder$ItemInvoker != null && menuBuilder$ItemInvoker.invokeItem(actionMenuItemView.mItemData) && (popup = getPopup()) != null && popup.isShowing();
    }
}
