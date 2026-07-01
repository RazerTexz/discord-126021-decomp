package androidx.appcompat.widget;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarOverlayLayout$3 implements Runnable {
    public final /* synthetic */ ActionBarOverlayLayout this$0;

    public ActionBarOverlayLayout$3(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.this$0 = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.haltActionBarHideOffsetAnimations();
        ActionBarOverlayLayout actionBarOverlayLayout = this.this$0;
        actionBarOverlayLayout.mCurrentActionBarTopAnimator = actionBarOverlayLayout.mActionBarTop.animate().translationY(-this.this$0.mActionBarTop.getHeight()).setListener(this.this$0.mTopAnimatorListener);
    }
}
