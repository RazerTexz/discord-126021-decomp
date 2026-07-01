package androidx.appcompat.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuPresenter$OpenOverflowRunnable implements Runnable {
    private ActionMenuPresenter$OverflowPopup mPopup;
    public final /* synthetic */ ActionMenuPresenter this$0;

    public ActionMenuPresenter$OpenOverflowRunnable(ActionMenuPresenter actionMenuPresenter, ActionMenuPresenter$OverflowPopup actionMenuPresenter$OverflowPopup) {
        this.this$0 = actionMenuPresenter;
        this.mPopup = actionMenuPresenter$OverflowPopup;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (ActionMenuPresenter.access$400(this.this$0) != null) {
            ActionMenuPresenter.access$500(this.this$0).changeMenuMode();
        }
        View view = (View) ActionMenuPresenter.access$600(this.this$0);
        if (view != null && view.getWindowToken() != null && this.mPopup.tryShow()) {
            this.this$0.mOverflowPopup = this.mPopup;
        }
        this.this$0.mPostedOpenRunnable = null;
    }
}
