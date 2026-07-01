package androidx.view;

import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;

/* JADX INFO: Add missing generic type declarations: [X] */
/* JADX INFO: loaded from: classes.dex */
public class Transformations$1<X> implements Observer<X> {
    public final /* synthetic */ Function val$mapFunction;
    public final /* synthetic */ MediatorLiveData val$result;

    public Transformations$1(MediatorLiveData mediatorLiveData, Function function) {
        this.val$result = mediatorLiveData;
        this.val$mapFunction = function;
    }

    @Override // androidx.view.Observer
    public void onChanged(@Nullable X x2) {
        this.val$result.setValue(this.val$mapFunction.apply(x2));
    }
}
