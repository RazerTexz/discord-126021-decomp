package com.discord.utilities.mg_recycler;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.a.k.b;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: MGRecyclerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class MGRecyclerAdapter<D> extends RecyclerView$Adapter<MGRecyclerViewHolder<?, D>> {
    public static final MGRecyclerAdapter$Companion Companion = new MGRecyclerAdapter$Companion(null);
    private final CompositeSubscription cellSubscriptions;
    private RecyclerView recycler;

    public MGRecyclerAdapter(RecyclerView recyclerView) {
        m.checkNotNullParameter(recyclerView, "recycler");
        this.recycler = recyclerView;
        this.cellSubscriptions = new CompositeSubscription();
    }

    public static final <D, T extends MGRecyclerAdapter<D>> T configure(T t) {
        return (T) Companion.configure(t);
    }

    public final void dispose() {
        this.cellSubscriptions.b();
    }

    public final CompositeSubscription getCellSubscriptions() {
        return this.cellSubscriptions;
    }

    public final Context getContext() {
        Context context = getRecycler().getContext();
        m.checkNotNullExpressionValue(context, "recycler.context");
        return context;
    }

    public abstract D getItem(int position);

    public RecyclerView getRecycler() {
        return this.recycler;
    }

    @SuppressLint({"StringFormatMatches"})
    public final IllegalArgumentException invalidViewTypeException(int viewType) {
        Context context = getRecycler().getContext();
        return new IllegalArgumentException(String.valueOf(context != null ? b.h(context, 2131886424, new Object[]{Integer.valueOf(viewType)}, null, 4) : null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        onBindViewHolder((MGRecyclerViewHolder) recyclerView$ViewHolder, i);
    }

    public void setRecycler(RecyclerView recyclerView) {
        m.checkNotNullParameter(recyclerView, "<set-?>");
        this.recycler = recyclerView;
    }

    public void onBindViewHolder(MGRecyclerViewHolder<?, D> holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        holder.onBindViewHolder(position);
    }
}
