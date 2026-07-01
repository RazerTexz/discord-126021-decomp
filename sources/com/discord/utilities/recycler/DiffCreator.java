package com.discord.utilities.recycler;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DiffUtil$DiffResult;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.app.AppComponent;
import com.discord.utilities.collections.ShallowPartitionMap;
import com.discord.utilities.collections.ShallowPartitionMap$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: DiffCreator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DiffCreator<T extends List<? extends DiffKeyProvider>, VH extends RecyclerView$ViewHolder> {
    public static final DiffCreator$Companion Companion = new DiffCreator$Companion(null);
    private static final int EXPENSIVE_DIFF_THRESHOLD = 225;
    private Subscription asyncDiffSubscription;
    private final AppComponent asyncDiffSubscriptionScope;
    private final PublishSubject<DiffCreator$UpdateRequest<T, VH>> updateRequestsSubject = PublishSubject.k0();

    public DiffCreator(AppComponent appComponent) {
        this.asyncDiffSubscriptionScope = appComponent;
        if (appComponent != null) {
            subscribeToAsyncUpdateRequests(appComponent);
        }
    }

    public static final /* synthetic */ Subscription access$getAsyncDiffSubscription$p(DiffCreator diffCreator) {
        return diffCreator.asyncDiffSubscription;
    }

    public static final /* synthetic */ void access$setAsyncDiffSubscription$p(DiffCreator diffCreator, Subscription subscription) {
        diffCreator.asyncDiffSubscription = subscription;
    }

    public static final /* synthetic */ void access$setItemsAndDispatchUpdate(DiffCreator diffCreator, RecyclerView$Adapter recyclerView$Adapter, Function1 function1, List list, DiffUtil$DiffResult diffUtil$DiffResult) {
        diffCreator.setItemsAndDispatchUpdate(recyclerView$Adapter, function1, list, diffUtil$DiffResult);
    }

    private final DiffCreator$createDiffUtilCallback$1 createDiffUtilCallback(T oldItems, T newItems) {
        return new DiffCreator$createDiffUtilCallback$1(oldItems, newItems);
    }

    private final boolean isExpensiveDiff(T oldItems, T newItems) {
        if (Math.abs(newItems.size() - oldItems.size()) > 225) {
            return true;
        }
        ShallowPartitionMap shallowPartitionMapCreate$default = ShallowPartitionMap$Companion.create$default(ShallowPartitionMap.Companion, oldItems.size(), 0, 0, null, 14, null);
        ArrayList arrayList = new ArrayList();
        Iterator it = oldItems.iterator();
        while (it.hasNext()) {
            shallowPartitionMapCreate$default.put(((DiffKeyProvider) it.next()).getKey(), Unit.a);
        }
        Iterator it2 = newItems.iterator();
        while (it2.hasNext()) {
            String key = ((DiffKeyProvider) it2.next()).getKey();
            if (!shallowPartitionMapCreate$default.containsKey(key)) {
                arrayList.add(key);
            }
            shallowPartitionMapCreate$default.remove(key);
        }
        return arrayList.size() + shallowPartitionMapCreate$default.size() > 225;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"NotifyDataSetChanged"})
    private final void setItemsAndDispatchUpdate(RecyclerView$Adapter<VH> adapter, Function1<? super T, Unit> setItems, T newItems, DiffUtil$DiffResult diffResult) {
        setItems.invoke(newItems);
        if (diffResult != null) {
            diffResult.dispatchUpdatesTo(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    private final void subscribeToAsyncUpdateRequests(AppComponent asyncDiffSubscriptionScope) {
        PublishSubject<DiffCreator$UpdateRequest<T, VH>> publishSubject = this.updateRequestsSubject;
        m.checkNotNullExpressionValue(publishSubject, "updateRequestsSubject");
        Observable observableG = ObservableExtensionsKt.computationBuffered(publishSubject).G(new DiffCreator$subscribeToAsyncUpdateRequests$1(this));
        m.checkNotNullExpressionValue(observableG, "updateRequestsSubject\n  …ms)\n          )\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableG, asyncDiffSubscriptionScope, null, 2, null), DiffCreator.class, (Context) null, new DiffCreator$subscribeToAsyncUpdateRequests$2(this), (Function1) null, (Function0) null, (Function0) null, new DiffCreator$subscribeToAsyncUpdateRequests$3(this), 58, (Object) null);
    }

    public final DiffUtil$DiffResult calculateDiffResult(T oldItems, T newItems) {
        m.checkNotNullParameter(oldItems, "oldItems");
        m.checkNotNullParameter(newItems, "newItems");
        if (isExpensiveDiff(oldItems, newItems)) {
            return null;
        }
        return DiffUtil.calculateDiff(createDiffUtilCallback(oldItems, newItems), true);
    }

    public final void dispatchDiffUpdates(RecyclerView$Adapter<VH> adapter, Function1<? super T, Unit> setItems, T oldItems, T newItems) {
        m.checkNotNullParameter(adapter, "adapter");
        m.checkNotNullParameter(setItems, "setItems");
        m.checkNotNullParameter(oldItems, "oldItems");
        m.checkNotNullParameter(newItems, "newItems");
        setItemsAndDispatchUpdate(adapter, setItems, newItems, calculateDiffResult(oldItems, newItems));
    }

    @MainThread
    public final void dispatchDiffUpdatesAsync(RecyclerView$Adapter<VH> adapter, Function1<? super T, Unit> setItems, T oldItems, T newItems) {
        m.checkNotNullParameter(adapter, "adapter");
        m.checkNotNullParameter(setItems, "setItems");
        m.checkNotNullParameter(oldItems, "oldItems");
        m.checkNotNullParameter(newItems, "newItems");
        if (this.asyncDiffSubscriptionScope == null) {
            throw new IllegalStateException("to use async diffs, provide an asyncDiffSubscriptionScope");
        }
        Subscription subscription = this.asyncDiffSubscription;
        if (subscription == null || subscription.isUnsubscribed()) {
            subscribeToAsyncUpdateRequests(this.asyncDiffSubscriptionScope);
        }
        PublishSubject<DiffCreator$UpdateRequest<T, VH>> publishSubject = this.updateRequestsSubject;
        publishSubject.k.onNext(new DiffCreator$UpdateRequest<>(adapter, setItems, oldItems, newItems));
    }
}
