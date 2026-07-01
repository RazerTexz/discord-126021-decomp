package androidx.appcompat.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View$OnTouchListener;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes.dex */
public class ListPopupWindow$PopupTouchInterceptor implements View$OnTouchListener {
    public final /* synthetic */ ListPopupWindow this$0;

    public ListPopupWindow$PopupTouchInterceptor(ListPopupWindow listPopupWindow) {
        this.this$0 = listPopupWindow;
    }

    @Override // android.view.View$OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PopupWindow popupWindow;
        int action = motionEvent.getAction();
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        if (action == 0 && (popupWindow = this.this$0.mPopup) != null && popupWindow.isShowing() && x2 >= 0 && x2 < this.this$0.mPopup.getWidth() && y2 >= 0 && y2 < this.this$0.mPopup.getHeight()) {
            ListPopupWindow listPopupWindow = this.this$0;
            listPopupWindow.mHandler.postDelayed(listPopupWindow.mResizePopupRunnable, 250L);
            return false;
        }
        if (action != 1) {
            return false;
        }
        ListPopupWindow listPopupWindow2 = this.this$0;
        listPopupWindow2.mHandler.removeCallbacks(listPopupWindow2.mResizePopupRunnable);
        return false;
    }
}
