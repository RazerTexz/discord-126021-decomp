package androidx.appcompat.app;

import android.os.Message;
import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: loaded from: classes.dex */
public class AlertController$1 implements View$OnClickListener {
    public final /* synthetic */ AlertController this$0;

    public AlertController$1(AlertController alertController) {
        this.this$0 = alertController;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        Message messageObtain;
        Message message;
        Message message2;
        Message message3;
        AlertController alertController = this.this$0;
        if (view == alertController.mButtonPositive && (message3 = alertController.mButtonPositiveMessage) != null) {
            messageObtain = Message.obtain(message3);
        } else if (view != alertController.mButtonNegative || (message2 = alertController.mButtonNegativeMessage) == null) {
            messageObtain = (view != alertController.mButtonNeutral || (message = alertController.mButtonNeutralMessage) == null) ? null : Message.obtain(message);
        } else {
            messageObtain = Message.obtain(message2);
        }
        if (messageObtain != null) {
            messageObtain.sendToTarget();
        }
        AlertController alertController2 = this.this$0;
        alertController2.mHandler.obtainMessage(1, alertController2.mDialog).sendToTarget();
    }
}
