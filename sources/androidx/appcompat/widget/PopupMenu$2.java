package androidx.appcompat.widget;

import android.widget.PopupWindow$OnDismissListener;

/* JADX INFO: loaded from: classes.dex */
public class PopupMenu$2 implements PopupWindow$OnDismissListener {
    public final /* synthetic */ PopupMenu this$0;

    public PopupMenu$2(PopupMenu popupMenu) {
        this.this$0 = popupMenu;
    }

    @Override // android.widget.PopupWindow$OnDismissListener
    public void onDismiss() {
        PopupMenu popupMenu = this.this$0;
        PopupMenu$OnDismissListener popupMenu$OnDismissListener = popupMenu.mOnDismissListener;
        if (popupMenu$OnDismissListener != null) {
            popupMenu$OnDismissListener.onDismiss(popupMenu);
        }
    }
}
