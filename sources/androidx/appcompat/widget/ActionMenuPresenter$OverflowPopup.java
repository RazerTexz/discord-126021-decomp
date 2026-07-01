package androidx.appcompat.widget;

import android.content.Context;
import android.view.View;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.core.view.GravityCompat;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuPresenter$OverflowPopup extends MenuPopupHelper {
    public final /* synthetic */ ActionMenuPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionMenuPresenter$OverflowPopup(ActionMenuPresenter actionMenuPresenter, Context context, MenuBuilder menuBuilder, View view, boolean z2) {
        super(context, menuBuilder, view, z2, R$attr.actionOverflowMenuStyle);
        this.this$0 = actionMenuPresenter;
        setGravity(GravityCompat.END);
        setPresenterCallback(actionMenuPresenter.mPopupPresenterCallback);
    }

    @Override // androidx.appcompat.view.menu.MenuPopupHelper
    public void onDismiss() {
        if (ActionMenuPresenter.access$000(this.this$0) != null) {
            ActionMenuPresenter.access$100(this.this$0).close();
        }
        this.this$0.mOverflowPopup = null;
        super.onDismiss();
    }
}
