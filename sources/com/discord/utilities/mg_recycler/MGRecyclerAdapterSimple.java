package com.discord.utilities.mg_recycler;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.recyclerview.widget.DiffUtil$DiffResult;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.recycler.DiffCreator;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.o;
import d0.t.g0;
import d0.t.n;
import d0.z.d.m;
import j0.p.a;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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

    public MGRecyclerAdapterSimple(RecyclerView recyclerView) {
        this(recyclerView, false, 2, null);
    }

    public /* synthetic */ MGRecyclerAdapterSimple(RecyclerView recyclerView, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, (i & 2) != 0 ? true : z2);
    }

    public static final /* synthetic */ void access$dispatchUpdates(MGRecyclerAdapterSimple mGRecyclerAdapterSimple, DiffUtil$DiffResult diffUtil$DiffResult, List list, List list2) {
        mGRecyclerAdapterSimple.dispatchUpdates(diffUtil$DiffResult, list, list2);
    }

    public static final /* synthetic */ DiffCreator access$getDiffCreator$p(MGRecyclerAdapterSimple mGRecyclerAdapterSimple) {
        return mGRecyclerAdapterSimple.diffCreator;
    }

    public static final /* synthetic */ Subscription access$getDiffingSubscription$p(MGRecyclerAdapterSimple mGRecyclerAdapterSimple) {
        return mGRecyclerAdapterSimple.diffingSubscription;
    }

    public static final /* synthetic */ void access$handleError(MGRecyclerAdapterSimple mGRecyclerAdapterSimple, Throwable th) {
        mGRecyclerAdapterSimple.handleError(th);
    }

    public static final /* synthetic */ void access$setDiffingSubscription$p(MGRecyclerAdapterSimple mGRecyclerAdapterSimple, Subscription subscription) {
        mGRecyclerAdapterSimple.diffingSubscription = subscription;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final void dispatchUpdates(DiffUtil$DiffResult diffResult, List<? extends D> oldData, List<? extends D> newData) {
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
        AppLog.g.e("Unable to configure recycler.", throwable, g0.mapOf(o.to("adapterClass", getClass().getSimpleName())));
    }

    public final List<D> getInternalData() {
        return this.internalData;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapter
    public /* bridge */ /* synthetic */ Object getItem(int i) {
        return getItem(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.internalData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemViewType(int position) {
        return getItem(position).getType();
    }

    public void setData(List<? extends D> data) {
        m.checkNotNullParameter(data, "data");
        unsubscribeFromUpdates();
        List<? extends D> list = this.internalData;
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
        Observable observableX = Observable.D(new MGRecyclerAdapterSimple$setData$1(this, list, data)).X(a.a());
        m.checkNotNullExpressionValue(observableX, "Observable\n            .…Schedulers.computation())");
        Observable observableUi = ObservableExtensionsKt.ui(observableX);
        Class<?> cls = getClass();
        MGRecyclerAdapterSimple$setData$2 mGRecyclerAdapterSimple$setData$2 = new MGRecyclerAdapterSimple$setData$2(this, list, data);
        ObservableExtensionsKt.appSubscribe$default(observableUi, cls, (Context) null, new MGRecyclerAdapterSimple$setData$4(this), new MGRecyclerAdapterSimple$setData$3(this), (Function0) null, (Function0) null, mGRecyclerAdapterSimple$setData$2, 50, (Object) null);
    }

    public final void setOnUpdated(Function2<? super List<? extends D>, ? super List<? extends D>, Unit> onUpdated) {
        m.checkNotNullParameter(onUpdated, "onUpdated");
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
        m.checkNotNullParameter(recyclerView, "recycler");
        this.deferredDiffs = z2;
        this.internalData = n.emptyList();
        this.diffCreator = new DiffCreator<>(null);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapter
    public D getItem(int position) {
        return this.internalData.get(position);
    }
}
