package androidx.loader.content;

import androidx.core.os.OperationCanceledException;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: Add missing generic type declarations: [D] */
/* JADX INFO: loaded from: classes.dex */
public final class AsyncTaskLoader$LoadTask<D> extends ModernAsyncTask<Void, Void, D> implements Runnable {
    private final CountDownLatch mDone = new CountDownLatch(1);
    public final /* synthetic */ AsyncTaskLoader this$0;
    public boolean waiting;

    public AsyncTaskLoader$LoadTask(AsyncTaskLoader asyncTaskLoader) {
        this.this$0 = asyncTaskLoader;
    }

    @Override // androidx.loader.content.ModernAsyncTask
    public /* bridge */ /* synthetic */ Object doInBackground(Void[] voidArr) {
        return doInBackground2(voidArr);
    }

    @Override // androidx.loader.content.ModernAsyncTask
    public void onCancelled(D d) {
        try {
            this.this$0.dispatchOnCancelled(this, d);
        } finally {
            this.mDone.countDown();
        }
    }

    @Override // androidx.loader.content.ModernAsyncTask
    public void onPostExecute(D d) {
        try {
            this.this$0.dispatchOnLoadComplete(this, d);
        } finally {
            this.mDone.countDown();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.waiting = false;
        this.this$0.executePendingTask();
    }

    public void waitForLoader() {
        try {
            this.mDone.await();
        } catch (InterruptedException unused) {
        }
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    public D doInBackground2(Void... voidArr) {
        try {
            return (D) this.this$0.onLoadInBackground();
        } catch (OperationCanceledException e) {
            if (isCancelled()) {
                return null;
            }
            throw e;
        }
    }
}
