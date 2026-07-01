package androidx.view;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class MediatorLiveData$Source<V> implements Observer<V> {
    public final LiveData<V> mLiveData;
    public final Observer<? super V> mObserver;
    public int mVersion = -1;

    public MediatorLiveData$Source(LiveData<V> liveData, Observer<? super V> observer) {
        this.mLiveData = liveData;
        this.mObserver = observer;
    }

    @Override // androidx.view.Observer
    public void onChanged(@Nullable V v) {
        if (this.mVersion != this.mLiveData.getVersion()) {
            this.mVersion = this.mLiveData.getVersion();
            this.mObserver.onChanged(v);
        }
    }

    public void plug() {
        this.mLiveData.observeForever(this);
    }

    public void unplug() {
        this.mLiveData.removeObserver(this);
    }
}
