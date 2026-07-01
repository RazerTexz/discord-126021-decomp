package androidx.activity;

import android.content.Intent;
import android.content.IntentSender$SendIntentException;
import androidx.activity.result.contract.ActivityResultContracts$StartIntentSenderForResult;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity$2$2 implements Runnable {
    public final /* synthetic */ ComponentActivity$2 this$1;
    public final /* synthetic */ IntentSender$SendIntentException val$e;
    public final /* synthetic */ int val$requestCode;

    public ComponentActivity$2$2(ComponentActivity$2 componentActivity$2, int i, IntentSender$SendIntentException intentSender$SendIntentException) {
        this.this$1 = componentActivity$2;
        this.val$requestCode = i;
        this.val$e = intentSender$SendIntentException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$1.dispatchResult(this.val$requestCode, 0, new Intent().setAction(ActivityResultContracts$StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST).putExtra(ActivityResultContracts$StartIntentSenderForResult.EXTRA_SEND_INTENT_EXCEPTION, this.val$e));
    }
}
