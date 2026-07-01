package androidx.asynclayoutinflater.view;

import android.os.Message;
import android.util.Log;
import androidx.core.util.Pools$SynchronizedPool;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class AsyncLayoutInflater$InflateThread extends Thread {
    private static final AsyncLayoutInflater$InflateThread sInstance;
    private ArrayBlockingQueue<AsyncLayoutInflater$InflateRequest> mQueue = new ArrayBlockingQueue<>(10);
    private Pools$SynchronizedPool<AsyncLayoutInflater$InflateRequest> mRequestPool = new Pools$SynchronizedPool<>(10);

    static {
        AsyncLayoutInflater$InflateThread asyncLayoutInflater$InflateThread = new AsyncLayoutInflater$InflateThread();
        sInstance = asyncLayoutInflater$InflateThread;
        asyncLayoutInflater$InflateThread.start();
    }

    private AsyncLayoutInflater$InflateThread() {
    }

    public static AsyncLayoutInflater$InflateThread getInstance() {
        return sInstance;
    }

    public void enqueue(AsyncLayoutInflater$InflateRequest asyncLayoutInflater$InflateRequest) {
        try {
            this.mQueue.put(asyncLayoutInflater$InflateRequest);
        } catch (InterruptedException e) {
            throw new RuntimeException("Failed to enqueue async inflate request", e);
        }
    }

    public AsyncLayoutInflater$InflateRequest obtainRequest() {
        AsyncLayoutInflater$InflateRequest asyncLayoutInflater$InflateRequestAcquire = this.mRequestPool.acquire();
        return asyncLayoutInflater$InflateRequestAcquire == null ? new AsyncLayoutInflater$InflateRequest() : asyncLayoutInflater$InflateRequestAcquire;
    }

    public void releaseRequest(AsyncLayoutInflater$InflateRequest asyncLayoutInflater$InflateRequest) {
        asyncLayoutInflater$InflateRequest.callback = null;
        asyncLayoutInflater$InflateRequest.inflater = null;
        asyncLayoutInflater$InflateRequest.parent = null;
        asyncLayoutInflater$InflateRequest.resid = 0;
        asyncLayoutInflater$InflateRequest.view = null;
        this.mRequestPool.release(asyncLayoutInflater$InflateRequest);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (true) {
            runInner();
        }
    }

    public void runInner() {
        try {
            AsyncLayoutInflater$InflateRequest asyncLayoutInflater$InflateRequestTake = this.mQueue.take();
            try {
                asyncLayoutInflater$InflateRequestTake.view = asyncLayoutInflater$InflateRequestTake.inflater.mInflater.inflate(asyncLayoutInflater$InflateRequestTake.resid, asyncLayoutInflater$InflateRequestTake.parent, false);
            } catch (RuntimeException e) {
                Log.w("AsyncLayoutInflater", "Failed to inflate resource in the background! Retrying on the UI thread", e);
            }
            Message.obtain(asyncLayoutInflater$InflateRequestTake.inflater.mHandler, 0, asyncLayoutInflater$InflateRequestTake).sendToTarget();
        } catch (InterruptedException e2) {
            Log.w("AsyncLayoutInflater", e2);
        }
    }
}
