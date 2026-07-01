package androidx.appcompat.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ListPopupWindow$2 implements Runnable {
    public final /* synthetic */ ListPopupWindow this$0;

    public ListPopupWindow$2(ListPopupWindow listPopupWindow) {
        this.this$0 = listPopupWindow;
    }

    @Override // java.lang.Runnable
    public void run() {
        View anchorView = this.this$0.getAnchorView();
        if (anchorView == null || anchorView.getWindowToken() == null) {
            return;
        }
        this.this$0.show();
    }
}
