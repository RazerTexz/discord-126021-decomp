package androidx.view;

import androidx.arch.core.util.Function;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: androidx.lifecycle.TransformationsKt, reason: use source file name */
/* JADX INFO: compiled from: Transformations.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Transformations2 {
    public static final <X> LiveData<X> distinctUntilChanged(LiveData<X> liveData) {
        Intrinsics3.checkNotNullParameter(liveData, "$this$distinctUntilChanged");
        LiveData<X> liveDataDistinctUntilChanged = Transformations.distinctUntilChanged(liveData);
        Intrinsics3.checkNotNullExpressionValue(liveDataDistinctUntilChanged, "Transformations.distinctUntilChanged(this)");
        return liveDataDistinctUntilChanged;
    }

    public static final <X, Y> LiveData<Y> map(LiveData<X> liveData, final Function1<? super X, ? extends Y> function1) {
        Intrinsics3.checkNotNullParameter(liveData, "$this$map");
        Intrinsics3.checkNotNullParameter(function1, "transform");
        LiveData<Y> map = Transformations.map(liveData, new Function<X, Y>() { // from class: androidx.lifecycle.TransformationsKt.map.1
            @Override // androidx.arch.core.util.Function
            public final Y apply(X x2) {
                return (Y) function1.invoke(x2);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(map, "Transformations.map(this) { transform(it) }");
        return map;
    }

    public static final <X, Y> LiveData<Y> switchMap(LiveData<X> liveData, final Function1<? super X, ? extends LiveData<Y>> function1) {
        Intrinsics3.checkNotNullParameter(liveData, "$this$switchMap");
        Intrinsics3.checkNotNullParameter(function1, "transform");
        LiveData<Y> liveDataSwitchMap = Transformations.switchMap(liveData, new Function<X, LiveData<Y>>() { // from class: androidx.lifecycle.TransformationsKt.switchMap.1
            @Override // androidx.arch.core.util.Function
            public final LiveData<Y> apply(X x2) {
                return (LiveData) function1.invoke(x2);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(liveDataSwitchMap, "Transformations.switchMap(this) { transform(it) }");
        return liveDataSwitchMap;
    }
}
