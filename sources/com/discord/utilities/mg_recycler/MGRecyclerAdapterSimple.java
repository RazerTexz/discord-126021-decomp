package com.discord.utilities.mg_recycler;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.recycler.DiffCreator;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.Tuples;
import d0.t.Collections2;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.p.Schedulers2;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: MGRecyclerAdapterSimple.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class MGRecyclerAdapterSimple<D extends MGRecyclerDataPayload> extends MGRecyclerAdapter<D> {
    private final boolean deferredDiffs;
    private final DiffCreator<List<D>, MGRecyclerViewHolder<MGRecyclerAdapterSimple<D>, D>> diffCreator;
    private Subscription diffingSubscription;
    private List<? extends D> internalData;
    private Function2<? super List<? extends D>, ? super List<? extends D>, Unit> onUpdated;

    /* JADX INFO: renamed from: com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple$setData$2, reason: invalid class name */
    /* JADX INFO: compiled from: MGRecyclerAdapterSimple.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<DiffUtil.DiffResult, Unit> {
        public final /* synthetic */ List $newData;
        public final /* synthetic */ List $oldData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List list, List list2) {
            super(1);
            this.$oldData = list;
            this.$newData = list2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DiffUtil.DiffResult diffResult) {
            invoke2(diffResult);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DiffUtil.DiffResult diffResult) {
            MGRecyclerAdapterSimple.this.dispatchUpdates(diffResult, this.$oldData, this.$newData);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple$setData$3, reason: invalid class name */
    /* JADX INFO: compiled from: MGRecyclerAdapterSimple.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            MGRecyclerAdapterSimple mGRecyclerAdapterSimple = MGRecyclerAdapterSimple.this;
            Throwable throwable = error.getThrowable();
            Intrinsics3.checkNotNullExpressionValue(throwable, "error.throwable");
            mGRecyclerAdapterSimple.handleError(throwable);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple$setData$4, reason: invalid class name */
    /* JADX INFO: compiled from: MGRecyclerAdapterSimple.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            MGRecyclerAdapterSimple.this.diffingSubscription = subscription;
        }
    }

    public MGRecyclerAdapterSimple(RecyclerView recyclerView) {
        this(recyclerView, false, 2, null);
    }

    public /* synthetic */ MGRecyclerAdapterSimple(RecyclerView recyclerView, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, (i & 2) != 0 ? true : z2);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final void dispatchUpdates(DiffUtil.DiffResult diffResult, List<? extends D> oldData, List<? extends D> newData) {
        this.internalData = newData;
        if (diffResult != null) {
            diffResult.dispatchUpdatesTo(this);
        } else {
            notifyDataSetChanged();
        }
        Function2<? super List<? extends D>, ? super List<? extends D>, Unit> function2 = this.onUpdated;
        if (function2 != null) {
            function2.invoke(oldData, newData);
        }
    }

    private final void handleError(Throwable throwable) {
        AppLog.g.e("Unable to configure recycler.", throwable, MapsJVM.mapOf(Tuples.to("adapterClass", getClass().getSimpleName())));
    }

    public final List<D> getInternalData() {
        return this.internalData;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.internalData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return getItem(position).getType();
    }

    public void setData(final List<? extends D> data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        unsubscribeFromUpdates();
        final List<? extends D> list = this.internalData;
        if (list.isEmpty()) {
            dispatchUpdates(null, list, data);
            return;
        }
        if (!this.deferredDiffs) {
            try {
                dispatchUpdates(this.diffCreator.calculateDiffResult(list, data), list, data);
                return;
            } catch (Throwable th) {
                handleError(th);
                return;
            }
        }
        Observable observableX = Observable.D(new Callable<DiffUtil.DiffResult>() { // from class: com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple.setData.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public final DiffUtil.DiffResult call() {
                return MGRecyclerAdapterSimple.this.diffCreator.calculateDiffResult(list, data);
            }
        }).X(Schedulers2.a());
        Intrinsics3.checkNotNullExpressionValue(observableX, "Observable\n            .…Schedulers.computation())");
        Observable observableUi = ObservableExtensionsKt.ui(observableX);
        Class<?> cls = getClass();
        ObservableExtensionsKt.appSubscribe(observableUi, (Class<?>) cls, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass4()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass3()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(list, data));
    }

    public final void setOnUpdated(Function2<? super List<? extends D>, ? super List<? extends D>, Unit> onUpdated) {
        Intrinsics3.checkNotNullParameter(onUpdated, "onUpdated");
        this.onUpdated = onUpdated;
    }

    public final void unsubscribeFromUpdates() {
        Subscription subscription = this.diffingSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.diffingSubscription = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MGRecyclerAdapterSimple(RecyclerView recyclerView, boolean z2) {
        super(recyclerView);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.deferredDiffs = z2;
        this.internalData = Collections2.emptyList();
        this.diffCreator = new DiffCreator<>(null);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapter
    public D getItem(int position) {
        return this.internalData.get(position);
    }
}
