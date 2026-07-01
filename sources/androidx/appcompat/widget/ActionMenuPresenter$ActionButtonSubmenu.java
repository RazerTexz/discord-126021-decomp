package androidx.appcompat.widget;

import android.content.Context;
import android.view.View;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuPresenter$ActionButtonSubmenu extends MenuPopupHelper {
    public final /* synthetic */ ActionMenuPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionMenuPresenter$ActionButtonSubmenu(ActionMenuPresenter actionMenuPresenter, Context context, SubMenuBuilder subMenuBuilder, View view) {
        super(context, subMenuBuilder, view, false, R$attr.actionOverflowMenuStyle);
        this.this$0 = actionMenuPresenter;
        if (!((MenuItemImpl) subMenuBuilder.getItem()).isActionButton()) {
            View view2 = actionMenuPresenter.mOverflowButton;
            setAnchorView(view2 == null ? (View) ActionMenuPresenter.access$200(actionMenuPresenter) : view2);
        }
        setPresenterCallback(actionMenuPresenter.mPopupPresenterCallback);
    }

    @Override // androidx.appcompat.view.menu.MenuPopupHelper
    public void onDismiss() {
        ActionMenuPresenter actionMenuPresenter = this.this$0;
        actionMenuPresenter.mActionButtonPopup = null;
        actionMenuPresenter.mOpenSubMenuId = 0;
        super.onDismiss();
    }
}
