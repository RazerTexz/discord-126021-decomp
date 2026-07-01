package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CascadingMenuPopup$1 implements ViewTreeObserver$OnGlobalLayoutListener {
    public final /* synthetic */ CascadingMenuPopup this$0;

    public CascadingMenuPopup$1(CascadingMenuPopup cascadingMenuPopup) {
        this.this$0 = cascadingMenuPopup;
    }

    @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (!this.this$0.isShowing() || this.this$0.mShowingMenus.size() <= 0 || this.this$0.mShowingMenus.get(0).window.isModal()) {
            return;
        }
        View view = this.this$0.mShownAnchorView;
        if (view == null || !view.isShown()) {
            this.this$0.dismiss();
            return;
        }
        Iterator<CascadingMenuPopup$CascadingMenuInfo> it = this.this$0.mShowingMenus.iterator();
        while (it.hasNext()) {
            it.next().window.show();
        }
    }
}
