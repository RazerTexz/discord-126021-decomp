package com.discord.widgets.channels.threads.browser;

import android.view.View;
import com.discord.R$layout;
import com.discord.databinding.ThreadBrowserItemThreadBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetThreadBrowserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserAdapter$ThreadItem extends MGRecyclerViewHolder<WidgetThreadBrowserAdapter, WidgetThreadBrowserAdapter$Item> {
    private final ThreadBrowserItemThreadBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserAdapter$ThreadItem(WidgetThreadBrowserAdapter widgetThreadBrowserAdapter) {
        super(R$layout.thread_browser_item_thread, widgetThreadBrowserAdapter);
        m.checkNotNullParameter(widgetThreadBrowserAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        ThreadBrowserThreadView threadBrowserThreadView = (ThreadBrowserThreadView) view;
        ThreadBrowserItemThreadBinding threadBrowserItemThreadBinding = new ThreadBrowserItemThreadBinding(threadBrowserThreadView, threadBrowserThreadView);
        m.checkNotNullExpressionValue(threadBrowserItemThreadBinding, "ThreadBrowserItemThreadBinding.bind(itemView)");
        this.binding = threadBrowserItemThreadBinding;
    }

    public static final /* synthetic */ WidgetThreadBrowserAdapter access$getAdapter$p(WidgetThreadBrowserAdapter$ThreadItem widgetThreadBrowserAdapter$ThreadItem) {
        return (WidgetThreadBrowserAdapter) widgetThreadBrowserAdapter$ThreadItem.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetThreadBrowserAdapter$Item widgetThreadBrowserAdapter$Item) {
        onConfigure2(i, widgetThreadBrowserAdapter$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetThreadBrowserAdapter$Item data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        WidgetThreadBrowserAdapter$Item$Thread widgetThreadBrowserAdapter$Item$Thread = (WidgetThreadBrowserAdapter$Item$Thread) data;
        this.binding.f2159b.setThreadData(widgetThreadBrowserAdapter$Item$Thread.getThreadData());
        this.binding.f2159b.setOnClickListener(new WidgetThreadBrowserAdapter$ThreadItem$onConfigure$1(this, widgetThreadBrowserAdapter$Item$Thread));
        this.binding.f2159b.setOnLongClickListener(new WidgetThreadBrowserAdapter$ThreadItem$onConfigure$2(this, widgetThreadBrowserAdapter$Item$Thread));
    }
}
