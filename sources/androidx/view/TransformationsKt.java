package androidx.view;

import androidx.arch.core.util.Function;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Transformations.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TransformationsKt {
    public static final <X> LiveData<X> distinctUntilChanged(LiveData<X> liveData) {
        C12238m.checkNotNullParameter(liveData, "$this$distinctUntilChanged");
        LiveData<X> liveDataDistinctUntilChanged = Transformations.distinctUntilChanged(liveData);
        C12238m.checkNotNullExpressionValue(liveDataDistinctUntilChanged, "Transformations.distinctUntilChanged(this)");
        return liveDataDistinctUntilChanged;
    }

    public static final <X, Y> LiveData<Y> map(LiveData<X> liveData, final Function1<? super X, ? extends Y> function1) {
        C12238m.checkNotNullParameter(liveData, "$this$map");
        C12238m.checkNotNullParameter(function1, "transform");
        LiveData<Y> map = Transformations.map(liveData, new Function<X, Y>() { // from class: androidx.lifecycle.TransformationsKt.map.1
            @Override // androidx.arch.core.util.Function
            public final Y apply(X x2) {
                return (Y) function1.invoke(x2);
            }
        });
        C12238m.checkNotNullExpressionValue(map, "Transformations.map(this) { transform(it) }");
        return map;
    }

    public static final <X, Y> LiveData<Y> switchMap(LiveData<X> liveData, final Function1<? super X, ? extends LiveData<Y>> function1) {
        C12238m.checkNotNullParameter(liveData, "$this$switchMap");
        C12238m.checkNotNullParameter(function1, "transform");
        LiveData<Y> liveDataSwitchMap = Transformations.switchMap(liveData, new Function<X, LiveData<Y>>() { // from class: androidx.lifecycle.TransformationsKt.switchMap.1
            @Override // androidx.arch.core.util.Function
            public final LiveData<Y> apply(X x2) {
                return (LiveData) function1.invoke(x2);
            }
        });
        C12238m.checkNotNullExpressionValue(liveDataSwitchMap, "Transformations.switchMap(this) { transform(it) }");
        return liveDataSwitchMap;
    }
}
