package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.ShowableListMenu;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuPresenter$OverflowMenuButton$1 extends ForwardingListener {
    public final /* synthetic */ ActionMenuPresenter$OverflowMenuButton this$1;
    public final /* synthetic */ ActionMenuPresenter val$this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionMenuPresenter$OverflowMenuButton$1(ActionMenuPresenter$OverflowMenuButton actionMenuPresenter$OverflowMenuButton, View view, ActionMenuPresenter actionMenuPresenter) {
        super(view);
        this.this$1 = actionMenuPresenter$OverflowMenuButton;
        this.val$this$0 = actionMenuPresenter;
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public ShowableListMenu getPopup() {
        ActionMenuPresenter$OverflowPopup actionMenuPresenter$OverflowPopup = this.this$1.this$0.mOverflowPopup;
        if (actionMenuPresenter$OverflowPopup == null) {
            return null;
        }
        return actionMenuPresenter$OverflowPopup.getPopup();
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public boolean onForwardingStarted() {
        this.this$1.this$0.showOverflowMenu();
        return true;
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public boolean onForwardingStopped() {
        ActionMenuPresenter actionMenuPresenter = this.this$1.this$0;
        if (actionMenuPresenter.mPostedOpenRunnable != null) {
            return false;
        }
        actionMenuPresenter.hideOverflowMenu();
        return true;
    }
}
