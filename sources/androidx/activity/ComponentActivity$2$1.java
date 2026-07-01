package androidx.activity;

import androidx.activity.result.contract.ActivityResultContract$SynchronousResult;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity$2$1 implements Runnable {
    public final /* synthetic */ ComponentActivity$2 this$1;
    public final /* synthetic */ int val$requestCode;
    public final /* synthetic */ ActivityResultContract$SynchronousResult val$synchronousResult;

    public ComponentActivity$2$1(ComponentActivity$2 componentActivity$2, int i, ActivityResultContract$SynchronousResult activityResultContract$SynchronousResult) {
        this.this$1 = componentActivity$2;
        this.val$requestCode = i;
        this.val$synchronousResult = activityResultContract$SynchronousResult;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$1.dispatchResult(this.val$requestCode, this.val$synchronousResult.getValue());
    }
}
