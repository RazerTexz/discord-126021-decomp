package androidx.view;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;

/* JADX INFO: loaded from: classes.dex */
public class Transformations {
    private Transformations() {
    }

    @NonNull
    @MainThread
    public static <X> LiveData<X> distinctUntilChanged(@NonNull LiveData<X> liveData) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.3
            public boolean mFirstTime = true;

            @Override // androidx.view.Observer
            public void onChanged(X x2) {
                T value = mediatorLiveData.getValue();
                if (this.mFirstTime || ((value == 0 && x2 != null) || !(value == 0 || value.equals(x2)))) {
                    this.mFirstTime = false;
                    mediatorLiveData.setValue(x2);
                }
            }
        });
        return mediatorLiveData;
    }

    @NonNull
    @MainThread
    public static <X, Y> LiveData<Y> map(@NonNull LiveData<X> liveData, @NonNull final Function<X, Y> function) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.1
            @Override // androidx.view.Observer
            public void onChanged(@Nullable X x2) {
                mediatorLiveData.setValue(function.apply(x2));
            }
        });
        return mediatorLiveData;
    }

    @NonNull
    @MainThread
    public static <X, Y> LiveData<Y> switchMap(@NonNull LiveData<X> liveData, @NonNull final Function<X, LiveData<Y>> function) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.2
            public LiveData<Y> mSource;

            @Override // androidx.view.Observer
            public void onChanged(@Nullable X x2) {
                LiveData<Y> liveData2 = (LiveData) function.apply(x2);
                Object obj = this.mSource;
                if (obj == liveData2) {
                    return;
                }
                if (obj != null) {
                    mediatorLiveData.removeSource(obj);
                }
                this.mSource = liveData2;
                if (liveData2 != 0) {
                    mediatorLiveData.addSource(liveData2, new Observer<Y>() { // from class: androidx.lifecycle.Transformations.2.1
                        @Override // androidx.view.Observer
                        public void onChanged(@Nullable Y y2) {
                            mediatorLiveData.setValue(y2);
                        }
                    });
                }
            }
        });
        return mediatorLiveData;
    }
}
