package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.ShowableListMenu;

/* JADX INFO: loaded from: classes.dex */
public class ListPopupWindow$1 extends ForwardingListener {
    public final /* synthetic */ ListPopupWindow this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListPopupWindow$1(ListPopupWindow listPopupWindow, View view) {
        super(view);
        this.this$0 = listPopupWindow;
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public /* bridge */ /* synthetic */ ShowableListMenu getPopup() {
        return getPopup();
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public ListPopupWindow getPopup() {
        return this.this$0;
    }
}
