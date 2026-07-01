package androidx.view;

import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map$Entry;

/* JADX INFO: loaded from: classes.dex */
public class MediatorLiveData<T> extends MutableLiveData<T> {
    private SafeIterableMap<LiveData<?>, MediatorLiveData$Source<?>> mSources = new SafeIterableMap<>();

    @MainThread
    public <S> void addSource(@NonNull LiveData<S> liveData, @NonNull Observer<? super S> observer) {
        MediatorLiveData$Source<?> mediatorLiveData$Source = new MediatorLiveData$Source<>(liveData, observer);
        MediatorLiveData$Source<?> mediatorLiveData$SourcePutIfAbsent = this.mSources.putIfAbsent(liveData, mediatorLiveData$Source);
        if (mediatorLiveData$SourcePutIfAbsent != null && mediatorLiveData$SourcePutIfAbsent.mObserver != observer) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        }
        if (mediatorLiveData$SourcePutIfAbsent == null && hasActiveObservers()) {
            mediatorLiveData$Source.plug();
        }
    }

    @Override // androidx.view.LiveData
    @CallSuper
    public void onActive() {
        Iterator<Map$Entry<LiveData<?>, MediatorLiveData$Source<?>>> it = this.mSources.iterator();
        while (it.hasNext()) {
            it.next().getValue().plug();
        }
    }

    @Override // androidx.view.LiveData
    @CallSuper
    public void onInactive() {
        Iterator<Map$Entry<LiveData<?>, MediatorLiveData$Source<?>>> it = this.mSources.iterator();
        while (it.hasNext()) {
            it.next().getValue().unplug();
        }
    }

    @MainThread
    public <S> void removeSource(@NonNull LiveData<S> liveData) {
        MediatorLiveData$Source<?> mediatorLiveData$SourceRemove = this.mSources.remove(liveData);
        if (mediatorLiveData$SourceRemove != null) {
            mediatorLiveData$SourceRemove.unplug();
        }
    }
}
