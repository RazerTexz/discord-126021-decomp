package androidx.core.provider;

import androidx.core.util.Consumer;

/* JADX INFO: loaded from: classes.dex */
public class RequestExecutor$ReplyRunnable$1 implements Runnable {
    public final /* synthetic */ RequestExecutor$ReplyRunnable this$0;
    public final /* synthetic */ Consumer val$consumer;
    public final /* synthetic */ Object val$result;

    public RequestExecutor$ReplyRunnable$1(RequestExecutor$ReplyRunnable requestExecutor$ReplyRunnable, Consumer consumer, Object obj) {
        this.this$0 = requestExecutor$ReplyRunnable;
        this.val$consumer = consumer;
        this.val$result = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$consumer.accept(this.val$result);
    }
}
