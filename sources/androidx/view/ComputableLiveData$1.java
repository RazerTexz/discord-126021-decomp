package androidx.view;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes.dex */
public class ComputableLiveData$1<T> extends LiveData<T> {
    public final /* synthetic */ ComputableLiveData this$0;

    public ComputableLiveData$1(ComputableLiveData computableLiveData) {
        this.this$0 = computableLiveData;
    }

    @Override // androidx.view.LiveData
    public void onActive() {
        ComputableLiveData computableLiveData = this.this$0;
        computableLiveData.mExecutor.execute(computableLiveData.mRefreshRunnable);
    }
}
