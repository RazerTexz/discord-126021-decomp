package com.discord.utilities.mg_recycler;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.SelfHealingLinearLayoutManager;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: MGRecyclerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class MGRecyclerAdapter<D> extends RecyclerView.Adapter<MGRecyclerViewHolder<?, D>> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CompositeSubscription cellSubscriptions;
    private RecyclerView recycler;

    /* JADX INFO: compiled from: MGRecyclerAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public final <D, T extends MGRecyclerAdapter<D>> T configure(T adapter) {
            Intrinsics3.checkNotNullParameter(adapter, "adapter");
            try {
                RecyclerView recycler = adapter.getRecycler();
                RecyclerView.LayoutManager layoutManager = adapter.getRecycler().getLayoutManager();
                RecyclerView.ItemAnimator itemAnimator = null;
                if (!(layoutManager instanceof LinearLayoutManager)) {
                    layoutManager = null;
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                SelfHealingLinearLayoutManager selfHealingLinearLayoutManager = new SelfHealingLinearLayoutManager(adapter.getRecycler(), adapter, linearLayoutManager != null ? linearLayoutManager.getOrientation() : 1, false);
                selfHealingLinearLayoutManager.setSmoothScrollbarEnabled(true);
                recycler.setLayoutManager(selfHealingLinearLayoutManager);
                recycler.setAdapter(adapter);
                recycler.setHasFixedSize(true);
                RecyclerView.ItemAnimator itemAnimator2 = recycler.getItemAnimator();
                if (itemAnimator2 instanceof SimpleItemAnimator) {
                    itemAnimator = itemAnimator2;
                }
                SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) itemAnimator;
                if (simpleItemAnimator != null) {
                    simpleItemAnimator.setSupportsChangeAnimations(false);
                }
                return adapter;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MGRecyclerAdapter(RecyclerView recyclerView) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.recycler = recyclerView;
        this.cellSubscriptions = new CompositeSubscription();
    }

    public static final <D, T extends MGRecyclerAdapter<D>> T configure(T t) {
        return (T) INSTANCE.configure(t);
    }

    public final void dispose() {
        this.cellSubscriptions.b();
    }

    public final CompositeSubscription getCellSubscriptions() {
        return this.cellSubscriptions;
    }

    public final Context getContext() {
        Context context = getRecycler().getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "recycler.context");
        return context;
    }

    public abstract D getItem(int position);

    public RecyclerView getRecycler() {
        return this.recycler;
    }

    @SuppressLint({"StringFormatMatches"})
    public final IllegalArgumentException invalidViewTypeException(int viewType) {
        Context context = getRecycler().getContext();
        return new IllegalArgumentException(String.valueOf(context != null ? FormatUtils.b(context, R.string.android_unknown_view_holder, new Object[]{Integer.valueOf(viewType)}, (4 & 4) != 0 ? FormatUtils.b.j : null) : null));
    }

    public void setRecycler(RecyclerView recyclerView) {
        Intrinsics3.checkNotNullParameter(recyclerView, "<set-?>");
        this.recycler = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MGRecyclerViewHolder<?, D> holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        holder.onBindViewHolder(position);
    }
}
