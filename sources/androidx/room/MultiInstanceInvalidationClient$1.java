package androidx.room;

/* JADX INFO: loaded from: classes.dex */
public class MultiInstanceInvalidationClient$1 extends IMultiInstanceInvalidationCallback$Stub {
    public final /* synthetic */ MultiInstanceInvalidationClient this$0;

    public MultiInstanceInvalidationClient$1(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.this$0 = multiInstanceInvalidationClient;
    }

    @Override // androidx.room.IMultiInstanceInvalidationCallback
    public void onInvalidation(String[] strArr) {
        this.this$0.mExecutor.execute(new MultiInstanceInvalidationClient$1$1(this, strArr));
    }
}
