package androidx.view;

import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;

/* JADX INFO: Add missing generic type declarations: [X] */
/* JADX INFO: loaded from: classes.dex */
public class Transformations$2<X> implements Observer<X> {
    public LiveData<Y> mSource;
    public final /* synthetic */ MediatorLiveData val$result;
    public final /* synthetic */ Function val$switchMapFunction;

    public Transformations$2(Function function, MediatorLiveData mediatorLiveData) {
        this.val$switchMapFunction = function;
        this.val$result = mediatorLiveData;
    }

    @Override // androidx.view.Observer
    public void onChanged(@Nullable X x2) {
        LiveData<Y> liveData = (LiveData) this.val$switchMapFunction.apply(x2);
        Object obj = this.mSource;
        if (obj == liveData) {
            return;
        }
        if (obj != null) {
            this.val$result.removeSource(obj);
        }
        this.mSource = liveData;
        if (liveData != 0) {
            this.val$result.addSource(liveData, new Transformations$2$1(this));
        }
    }
}
