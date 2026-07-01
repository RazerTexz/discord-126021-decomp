package androidx.appcompat.widget;

import android.widget.AbsListView;
import android.widget.AbsListView$OnScrollListener;

/* JADX INFO: loaded from: classes.dex */
public class ListPopupWindow$PopupScrollListener implements AbsListView$OnScrollListener {
    public final /* synthetic */ ListPopupWindow this$0;

    public ListPopupWindow$PopupScrollListener(ListPopupWindow listPopupWindow) {
        this.this$0 = listPopupWindow;
    }

    @Override // android.widget.AbsListView$OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView$OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 1 || this.this$0.isInputMethodNotNeeded() || this.this$0.mPopup.getContentView() == null) {
            return;
        }
        ListPopupWindow listPopupWindow = this.this$0;
        listPopupWindow.mHandler.removeCallbacks(listPopupWindow.mResizePopupRunnable);
        this.this$0.mResizePopupRunnable.run();
    }
}
