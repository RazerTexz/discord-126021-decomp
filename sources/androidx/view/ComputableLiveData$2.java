package androidx.view;

import androidx.annotation.WorkerThread;

/* JADX INFO: loaded from: classes.dex */
public class ComputableLiveData$2 implements Runnable {
    public final /* synthetic */ ComputableLiveData this$0;

    public ComputableLiveData$2(ComputableLiveData computableLiveData) {
        this.this$0 = computableLiveData;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // java.lang.Runnable
    @WorkerThread
    public void run() {
        do {
            boolean z2 = false;
            if (this.this$0.mComputing.compareAndSet(false, true)) {
                Object objCompute = null;
                boolean z3 = false;
                while (this.this$0.mInvalid.compareAndSet(true, false)) {
                    try {
                        objCompute = this.this$0.compute();
                        z3 = true;
                    } catch (Throwable th) {
                        this.this$0.mComputing.set(false);
                        throw th;
                    }
                }
                if (z3) {
                    this.this$0.mLiveData.postValue((T) objCompute);
                }
                this.this$0.mComputing.set(false);
                z2 = z3;
            }
            if (!z2) {
                return;
            }
        } while (this.this$0.mInvalid.get());
    }
}
