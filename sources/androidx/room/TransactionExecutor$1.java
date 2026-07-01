package androidx.room;

/* JADX INFO: loaded from: classes.dex */
public class TransactionExecutor$1 implements Runnable {
    public final /* synthetic */ TransactionExecutor this$0;
    public final /* synthetic */ Runnable val$command;

    public TransactionExecutor$1(TransactionExecutor transactionExecutor, Runnable runnable) {
        this.this$0 = transactionExecutor;
        this.val$command = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.val$command.run();
        } finally {
            this.this$0.scheduleNext();
        }
    }
}
