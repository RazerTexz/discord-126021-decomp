package androidx.appcompat.view.menu;

import android.widget.PopupWindow$OnDismissListener;

/* JADX INFO: loaded from: classes.dex */
public class MenuPopupHelper$1 implements PopupWindow$OnDismissListener {
    public final /* synthetic */ MenuPopupHelper this$0;

    public MenuPopupHelper$1(MenuPopupHelper menuPopupHelper) {
        this.this$0 = menuPopupHelper;
    }

    @Override // android.widget.PopupWindow$OnDismissListener
    public void onDismiss() {
        this.this$0.onDismiss();
    }
}
