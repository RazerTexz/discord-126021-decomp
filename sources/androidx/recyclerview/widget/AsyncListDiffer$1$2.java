package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public class AsyncListDiffer$1$2 implements Runnable {
    public final /* synthetic */ AsyncListDiffer$1 this$1;
    public final /* synthetic */ DiffUtil$DiffResult val$result;

    public AsyncListDiffer$1$2(AsyncListDiffer$1 asyncListDiffer$1, DiffUtil$DiffResult diffUtil$DiffResult) {
        this.this$1 = asyncListDiffer$1;
        this.val$result = diffUtil$DiffResult;
    }

    @Override // java.lang.Runnable
    public void run() {
        AsyncListDiffer$1 asyncListDiffer$1 = this.this$1;
        AsyncListDiffer asyncListDiffer = asyncListDiffer$1.this$0;
        if (asyncListDiffer.mMaxScheduledGeneration == asyncListDiffer$1.val$runGeneration) {
            asyncListDiffer.latchList(asyncListDiffer$1.val$newList, this.val$result, asyncListDiffer$1.val$commitCallback);
        }
    }
}
