package androidx.work.impl.utils;

/* JADX INFO: loaded from: classes.dex */
public class LiveDataUtils$1$1 implements Runnable {
    public final /* synthetic */ LiveDataUtils$1 this$0;
    public final /* synthetic */ Object val$input;

    public LiveDataUtils$1$1(LiveDataUtils$1 liveDataUtils$1, Object obj) {
        this.this$0 = liveDataUtils$1;
        this.val$input = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [Out, java.lang.Object] */
    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.this$0.val$lock) {
            ?? Apply = this.this$0.val$mappingMethod.apply(this.val$input);
            LiveDataUtils$1 liveDataUtils$1 = this.this$0;
            Out out = liveDataUtils$1.mCurrentOutput;
            if (out == 0 && Apply != 0) {
                liveDataUtils$1.mCurrentOutput = Apply;
                liveDataUtils$1.val$outputLiveData.postValue(Apply);
            } else if (out != 0 && !out.equals(Apply)) {
                LiveDataUtils$1 liveDataUtils$2 = this.this$0;
                liveDataUtils$2.mCurrentOutput = Apply;
                liveDataUtils$2.val$outputLiveData.postValue(Apply);
            }
        }
    }
}
