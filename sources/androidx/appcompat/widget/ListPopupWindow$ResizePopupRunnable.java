package androidx.appcompat.widget;

import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class ListPopupWindow$ResizePopupRunnable implements Runnable {
    public final /* synthetic */ ListPopupWindow this$0;

    public ListPopupWindow$ResizePopupRunnable(ListPopupWindow listPopupWindow) {
        this.this$0 = listPopupWindow;
    }

    @Override // java.lang.Runnable
    public void run() {
        DropDownListView dropDownListView = this.this$0.mDropDownList;
        if (dropDownListView == null || !ViewCompat.isAttachedToWindow(dropDownListView) || this.this$0.mDropDownList.getCount() <= this.this$0.mDropDownList.getChildCount()) {
            return;
        }
        int childCount = this.this$0.mDropDownList.getChildCount();
        ListPopupWindow listPopupWindow = this.this$0;
        if (childCount <= listPopupWindow.mListItemExpandMaximum) {
            listPopupWindow.mPopup.setInputMethodMode(2);
            this.this$0.show();
        }
    }
}
