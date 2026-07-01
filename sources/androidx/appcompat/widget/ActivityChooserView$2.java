package androidx.appcompat.widget;

import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import androidx.core.view.ActionProvider;

/* JADX INFO: loaded from: classes.dex */
public class ActivityChooserView$2 implements ViewTreeObserver$OnGlobalLayoutListener {
    public final /* synthetic */ ActivityChooserView this$0;

    public ActivityChooserView$2(ActivityChooserView activityChooserView) {
        this.this$0 = activityChooserView;
    }

    @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.this$0.isShowingPopup()) {
            if (!this.this$0.isShown()) {
                this.this$0.getListPopupWindow().dismiss();
                return;
            }
            this.this$0.getListPopupWindow().show();
            ActionProvider actionProvider = this.this$0.mProvider;
            if (actionProvider != null) {
                actionProvider.subUiVisibilityChanged(true);
            }
        }
    }
}
