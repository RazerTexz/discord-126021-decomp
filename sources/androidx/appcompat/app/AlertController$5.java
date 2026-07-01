package androidx.appcompat.app;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class AlertController$5 implements Runnable {
    public final /* synthetic */ AlertController this$0;
    public final /* synthetic */ View val$bottom;
    public final /* synthetic */ View val$top;

    public AlertController$5(AlertController alertController, View view, View view2) {
        this.this$0 = alertController;
        this.val$top = view;
        this.val$bottom = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlertController.manageScrollIndicators(this.this$0.mListView, this.val$top, this.val$bottom);
    }
}
