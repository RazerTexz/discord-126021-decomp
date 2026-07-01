package androidx.work.impl;

import androidx.annotation.NonNull;
import b.i.b.d.a.a;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
public class Processor$FutureListener implements Runnable {

    @NonNull
    private ExecutionListener mExecutionListener;

    @NonNull
    private a<Boolean> mFuture;

    @NonNull
    private String mWorkSpecId;

    public Processor$FutureListener(@NonNull ExecutionListener executionListener, @NonNull String str, @NonNull a<Boolean> aVar) {
        this.mExecutionListener = executionListener;
        this.mWorkSpecId = str;
        this.mFuture = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zBooleanValue;
        try {
            zBooleanValue = this.mFuture.get().booleanValue();
        } catch (InterruptedException | ExecutionException unused) {
            zBooleanValue = true;
        }
        this.mExecutionListener.onExecuted(this.mWorkSpecId, zBooleanValue);
    }
}
