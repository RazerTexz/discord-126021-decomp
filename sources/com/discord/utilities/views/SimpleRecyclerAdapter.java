package com.discord.utilities.views;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.views.SimpleRecyclerAdapter$ViewHolder;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SimpleRecyclerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public class SimpleRecyclerAdapter<T, VH extends SimpleRecyclerAdapter$ViewHolder<T>> extends RecyclerView$Adapter<VH> {
    public static final SimpleRecyclerAdapter$Companion Companion = new SimpleRecyclerAdapter$Companion(null);
    private final Function2<LayoutInflater, ViewGroup, VH> createViewHolder;
    private List<? extends T> data;

    public /* synthetic */ SimpleRecyclerAdapter(List list, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? n.emptyList() : list, function2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        onBindViewHolder((SimpleRecyclerAdapter$ViewHolder) recyclerView$ViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setData(List<? extends T> data) {
        m.checkNotNullParameter(data, "data");
        this.data = data;
        notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleRecyclerAdapter(List<? extends T> list, Function2<? super LayoutInflater, ? super ViewGroup, ? extends VH> function2) {
        m.checkNotNullParameter(list, "data");
        m.checkNotNullParameter(function2, "createViewHolder");
        this.data = list;
        this.createViewHolder = function2;
    }

    public void onBindViewHolder(VH holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        holder.bind(this.data.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        Function2<LayoutInflater, ViewGroup, VH> function2 = this.createViewHolder;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        m.checkNotNullExpressionValue(layoutInflaterFrom, "LayoutInflater.from(parent.context)");
        return function2.invoke(layoutInflaterFrom, parent);
    }
}
