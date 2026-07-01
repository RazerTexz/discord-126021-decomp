package androidx.loader.content;

/* JADX INFO: loaded from: classes.dex */
public class ModernAsyncTask$AsyncTaskResult<Data> {
    public final Data[] mData;
    public final ModernAsyncTask mTask;

    public ModernAsyncTask$AsyncTaskResult(ModernAsyncTask modernAsyncTask, Data... dataArr) {
        this.mTask = modernAsyncTask;
        this.mData = dataArr;
    }
}
