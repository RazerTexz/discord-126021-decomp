package androidx.recyclerview.widget;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AsyncListDiffer$1 implements Runnable {
    public final /* synthetic */ AsyncListDiffer this$0;
    public final /* synthetic */ Runnable val$commitCallback;
    public final /* synthetic */ List val$newList;
    public final /* synthetic */ List val$oldList;
    public final /* synthetic */ int val$runGeneration;

    public AsyncListDiffer$1(AsyncListDiffer asyncListDiffer, List list, List list2, int i, Runnable runnable) {
        this.this$0 = asyncListDiffer;
        this.val$oldList = list;
        this.val$newList = list2;
        this.val$runGeneration = i;
        this.val$commitCallback = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.mMainThreadExecutor.execute(new AsyncListDiffer$1$2(this, DiffUtil.calculateDiff(new AsyncListDiffer$1$1(this))));
    }
}
