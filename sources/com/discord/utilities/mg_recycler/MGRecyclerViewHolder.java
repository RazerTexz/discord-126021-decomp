package com.discord.utilities.mg_recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import d0.z.d.m;
import rx.Subscription;

/* JADX INFO: compiled from: MGRecyclerViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public class MGRecyclerViewHolder<T extends MGRecyclerAdapter<D>, D> extends RecyclerView$ViewHolder {
    public final T adapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MGRecyclerViewHolder(View view, T t) {
        super(view);
        m.checkNotNullParameter(view, "itemView");
        m.checkNotNullParameter(t, "adapter");
        this.adapter = t;
    }

    public Subscription getSubscription() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T onBindViewHolder(int position) {
        T t = this.adapter;
        Subscription subscription = getSubscription();
        if (subscription != null) {
            t.getCellSubscriptions().c(subscription);
        }
        onConfigure(position, t.getItem(position));
        Subscription subscription2 = getSubscription();
        if (subscription2 != null) {
            t.getCellSubscriptions().a(subscription2);
        }
        return t;
    }

    public void onConfigure(int position, D data) {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MGRecyclerViewHolder(@LayoutRes int i, T t) {
        m.checkNotNullParameter(t, "adapter");
        RecyclerView recycler = t.getRecycler();
        View viewInflate = LayoutInflater.from(recycler.getContext()).inflate(i, (ViewGroup) recycler, false);
        m.checkNotNullExpressionValue(viewInflate, "adapter.recycler.let {\n …se) // ktlint-disable\n  }");
        this(viewInflate, t);
    }
}
