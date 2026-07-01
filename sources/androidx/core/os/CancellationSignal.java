package androidx.core.os;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class CancellationSignal {
    private boolean mCancelInProgress;
    private Object mCancellationSignalObj;
    private boolean mIsCanceled;
    private CancellationSignal$OnCancelListener mOnCancelListener;

    private void waitForCancelFinishedLocked() {
        while (this.mCancelInProgress) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void cancel() {
        synchronized (this) {
            if (this.mIsCanceled) {
                return;
            }
            this.mIsCanceled = true;
            this.mCancelInProgress = true;
            CancellationSignal$OnCancelListener cancellationSignal$OnCancelListener = this.mOnCancelListener;
            Object obj = this.mCancellationSignalObj;
            if (cancellationSignal$OnCancelListener != null) {
                try {
                    cancellationSignal$OnCancelListener.onCancel();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.mCancelInProgress = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null) {
                ((android.os.CancellationSignal) obj).cancel();
            }
            synchronized (this) {
                this.mCancelInProgress = false;
                notifyAll();
            }
        }
    }

    @Nullable
    public Object getCancellationSignalObject() {
        Object obj;
        synchronized (this) {
            if (this.mCancellationSignalObj == null) {
                android.os.CancellationSignal cancellationSignal = new android.os.CancellationSignal();
                this.mCancellationSignalObj = cancellationSignal;
                if (this.mIsCanceled) {
                    cancellationSignal.cancel();
                }
            }
            obj = this.mCancellationSignalObj;
        }
        return obj;
    }

    public boolean isCanceled() {
        boolean z2;
        synchronized (this) {
            z2 = this.mIsCanceled;
        }
        return z2;
    }

    public void setOnCancelListener(@Nullable CancellationSignal$OnCancelListener cancellationSignal$OnCancelListener) {
        synchronized (this) {
            waitForCancelFinishedLocked();
            if (this.mOnCancelListener == cancellationSignal$OnCancelListener) {
                return;
            }
            this.mOnCancelListener = cancellationSignal$OnCancelListener;
            if (this.mIsCanceled && cancellationSignal$OnCancelListener != null) {
                cancellationSignal$OnCancelListener.onCancel();
            }
        }
    }

    public void throwIfCanceled() {
        if (isCanceled()) {
            throw new OperationCanceledException();
        }
    }
}
