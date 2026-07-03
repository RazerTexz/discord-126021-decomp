package com.discord.utilities.recycler;

import android.annotation.SuppressLint;
import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.discord.app.AppComponent;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.collections.ShallowPartitionMap;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: DiffCreator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DiffCreator<T extends List<? extends DiffKeyProvider>, VH extends RecyclerView.ViewHolder> {
    private static final int EXPENSIVE_DIFF_THRESHOLD = 225;
    private Subscription asyncDiffSubscription;
    private final AppComponent asyncDiffSubscriptionScope;
    private final PublishSubject<UpdateRequest<T, VH>> updateRequestsSubject = PublishSubject.m11133k0();

    /* JADX INFO: compiled from: DiffCreator.kt */
    public static final /* data */ class UpdateRequest<T, VH extends RecyclerView.ViewHolder> {
        private final RecyclerView.Adapter<VH> adapter;
        private final T newItems;
        private final T oldItems;
        private final Function1<T, Unit> setItems;

        /* JADX WARN: Multi-variable type inference failed */
        public UpdateRequest(RecyclerView.Adapter<VH> adapter, Function1<? super T, Unit> function1, T t, T t2) {
            C12238m.checkNotNullParameter(adapter, "adapter");
            C12238m.checkNotNullParameter(function1, "setItems");
            this.adapter = adapter;
            this.setItems = function1;
            this.oldItems = t;
            this.newItems = t2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UpdateRequest copy$default(UpdateRequest updateRequest, RecyclerView.Adapter adapter, Function1 function1, Object obj, Object obj2, int i, Object obj3) {
            if ((i & 1) != 0) {
                adapter = updateRequest.adapter;
            }
            if ((i & 2) != 0) {
                function1 = updateRequest.setItems;
            }
            if ((i & 4) != 0) {
                obj = updateRequest.oldItems;
            }
            if ((i & 8) != 0) {
                obj2 = updateRequest.newItems;
            }
            return updateRequest.copy(adapter, function1, obj, obj2);
        }

        public final RecyclerView.Adapter<VH> component1() {
            return this.adapter;
        }

        public final Function1<T, Unit> component2() {
            return this.setItems;
        }

        public final T component3() {
            return this.oldItems;
        }

        public final T component4() {
            return this.newItems;
        }

        public final UpdateRequest<T, VH> copy(RecyclerView.Adapter<VH> adapter, Function1<? super T, Unit> setItems, T oldItems, T newItems) {
            C12238m.checkNotNullParameter(adapter, "adapter");
            C12238m.checkNotNullParameter(setItems, "setItems");
            return new UpdateRequest<>(adapter, setItems, oldItems, newItems);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateRequest)) {
                return false;
            }
            UpdateRequest updateRequest = (UpdateRequest) other;
            return C12238m.areEqual(this.adapter, updateRequest.adapter) && C12238m.areEqual(this.setItems, updateRequest.setItems) && C12238m.areEqual(this.oldItems, updateRequest.oldItems) && C12238m.areEqual(this.newItems, updateRequest.newItems);
        }

        public final RecyclerView.Adapter<VH> getAdapter() {
            return this.adapter;
        }

        public final T getNewItems() {
            return this.newItems;
        }

        public final T getOldItems() {
            return this.oldItems;
        }

        public final Function1<T, Unit> getSetItems() {
            return this.setItems;
        }

        public int hashCode() {
            RecyclerView.Adapter<VH> adapter = this.adapter;
            int iHashCode = (adapter != null ? adapter.hashCode() : 0) * 31;
            Function1<T, Unit> function1 = this.setItems;
            int iHashCode2 = (iHashCode + (function1 != null ? function1.hashCode() : 0)) * 31;
            T t = this.oldItems;
            int iHashCode3 = (iHashCode2 + (t != null ? t.hashCode() : 0)) * 31;
            T t2 = this.newItems;
            return iHashCode3 + (t2 != null ? t2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("UpdateRequest(adapter=");
            sbM833U.append(this.adapter);
            sbM833U.append(", setItems=");
            sbM833U.append(this.setItems);
            sbM833U.append(", oldItems=");
            sbM833U.append(this.oldItems);
            sbM833U.append(", newItems=");
            sbM833U.append(this.newItems);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.recycler.DiffCreator$subscribeToAsyncUpdateRequests$2 */
    /* JADX INFO: compiled from: DiffCreator.kt */
    public static final class C68482 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C68482() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            DiffCreator.this.asyncDiffSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.recycler.DiffCreator$subscribeToAsyncUpdateRequests$3 */
    /* JADX INFO: compiled from: DiffCreator.kt */
    public static final class C68493 extends AbstractC12240o implements Function1<Pair<? extends UpdateRequest<T, VH>, ? extends DiffUtil.DiffResult>, Unit> {
        public C68493() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke((Pair) obj);
            return Unit.f27425a;
        }

        public final void invoke(Pair<UpdateRequest<T, VH>, ? extends DiffUtil.DiffResult> pair) {
            UpdateRequest<T, VH> updateRequestComponent1 = pair.component1();
            DiffCreator.this.setItemsAndDispatchUpdate(updateRequestComponent1.getAdapter(), updateRequestComponent1.getSetItems(), updateRequestComponent1.getNewItems(), pair.component2());
        }
    }

    public DiffCreator(AppComponent appComponent) {
        this.asyncDiffSubscriptionScope = appComponent;
        if (appComponent != null) {
            subscribeToAsyncUpdateRequests(appComponent);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.discord.utilities.recycler.DiffCreator$createDiffUtilCallback$1] */
    private final C68461 createDiffUtilCallback(final T oldItems, final T newItems) {
        return new DiffUtil.Callback() { // from class: com.discord.utilities.recycler.DiffCreator.createDiffUtilCallback.1
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                return C12238m.areEqual((DiffKeyProvider) oldItems.get(oldItemPosition), (DiffKeyProvider) newItems.get(newItemPosition));
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                return C12238m.areEqual(((DiffKeyProvider) oldItems.get(oldItemPosition)).getKey(), ((DiffKeyProvider) newItems.get(newItemPosition)).getKey());
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getNewListSize() {
                return newItems.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getOldListSize() {
                return oldItems.size();
            }
        };
    }

    private final boolean isExpensiveDiff(T oldItems, T newItems) {
        if (Math.abs(newItems.size() - oldItems.size()) > 225) {
            return true;
        }
        ShallowPartitionMap shallowPartitionMapCreate$default = ShallowPartitionMap.Companion.create$default(ShallowPartitionMap.INSTANCE, oldItems.size(), 0, 0, null, 14, null);
        ArrayList arrayList = new ArrayList();
        Iterator it = oldItems.iterator();
        while (it.hasNext()) {
            shallowPartitionMapCreate$default.put(((DiffKeyProvider) it.next()).getKey(), Unit.f27425a);
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
    private final void setItemsAndDispatchUpdate(RecyclerView.Adapter<VH> adapter, Function1<? super T, Unit> setItems, T newItems, DiffUtil.DiffResult diffResult) {
        setItems.invoke(newItems);
        if (diffResult != null) {
            diffResult.dispatchUpdatesTo(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    private final void subscribeToAsyncUpdateRequests(AppComponent asyncDiffSubscriptionScope) {
        PublishSubject<UpdateRequest<T, VH>> publishSubject = this.updateRequestsSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "updateRequestsSubject");
        Observable observableM11083G = ObservableExtensionsKt.computationBuffered(publishSubject).m11083G(new InterfaceC12589b<UpdateRequest<T, VH>, Pair<? extends UpdateRequest<T, VH>, ? extends DiffUtil.DiffResult>>() { // from class: com.discord.utilities.recycler.DiffCreator.subscribeToAsyncUpdateRequests.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // p637j0.p641k.InterfaceC12589b
            public final Pair<UpdateRequest<T, VH>, DiffUtil.DiffResult> call(UpdateRequest<T, VH> updateRequest) {
                return new Pair<>(updateRequest, DiffCreator.this.calculateDiffResult((List) updateRequest.getOldItems(), (List) updateRequest.getNewItems()));
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "updateRequestsSubject\n  …ms)\n          )\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11083G, asyncDiffSubscriptionScope, null, 2, null), (Class<?>) DiffCreator.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C68482()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C68493());
    }

    public final DiffUtil.DiffResult calculateDiffResult(T oldItems, T newItems) {
        C12238m.checkNotNullParameter(oldItems, "oldItems");
        C12238m.checkNotNullParameter(newItems, "newItems");
        if (isExpensiveDiff(oldItems, newItems)) {
            return null;
        }
        return DiffUtil.calculateDiff(createDiffUtilCallback(oldItems, newItems), true);
    }

    public final void dispatchDiffUpdates(RecyclerView.Adapter<VH> adapter, Function1<? super T, Unit> setItems, T oldItems, T newItems) {
        C12238m.checkNotNullParameter(adapter, "adapter");
        C12238m.checkNotNullParameter(setItems, "setItems");
        C12238m.checkNotNullParameter(oldItems, "oldItems");
        C12238m.checkNotNullParameter(newItems, "newItems");
        setItemsAndDispatchUpdate(adapter, setItems, newItems, calculateDiffResult(oldItems, newItems));
    }

    @MainThread
    public final void dispatchDiffUpdatesAsync(RecyclerView.Adapter<VH> adapter, Function1<? super T, Unit> setItems, T oldItems, T newItems) {
        C12238m.checkNotNullParameter(adapter, "adapter");
        C12238m.checkNotNullParameter(setItems, "setItems");
        C12238m.checkNotNullParameter(oldItems, "oldItems");
        C12238m.checkNotNullParameter(newItems, "newItems");
        if (this.asyncDiffSubscriptionScope == null) {
            throw new IllegalStateException("to use async diffs, provide an asyncDiffSubscriptionScope");
        }
        Subscription subscription = this.asyncDiffSubscription;
        if (subscription == null || subscription.isUnsubscribed()) {
            subscribeToAsyncUpdateRequests(this.asyncDiffSubscriptionScope);
        }
        PublishSubject<UpdateRequest<T, VH>> publishSubject = this.updateRequestsSubject;
        publishSubject.f27650k.onNext(new UpdateRequest<>(adapter, setItems, oldItems, newItems));
    }
}
