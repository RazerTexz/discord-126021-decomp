package com.discord.widgets.channels.threads.browser;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.ThreadBrowserItemHeaderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetThreadBrowserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserAdapter$HeaderItem extends MGRecyclerViewHolder<WidgetThreadBrowserAdapter, WidgetThreadBrowserAdapter$Item> {
    private final ThreadBrowserItemHeaderBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserAdapter$HeaderItem(WidgetThreadBrowserAdapter widgetThreadBrowserAdapter) {
        super(R$layout.thread_browser_item_header, widgetThreadBrowserAdapter);
        m.checkNotNullParameter(widgetThreadBrowserAdapter, "adapter");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(R$id.header_name);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.header_name)));
        }
        ThreadBrowserItemHeaderBinding threadBrowserItemHeaderBinding = new ThreadBrowserItemHeaderBinding((ConstraintLayout) view, textView);
        m.checkNotNullExpressionValue(threadBrowserItemHeaderBinding, "ThreadBrowserItemHeaderBinding.bind(itemView)");
        this.binding = threadBrowserItemHeaderBinding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetThreadBrowserAdapter$Item widgetThreadBrowserAdapter$Item) {
        onConfigure2(i, widgetThreadBrowserAdapter$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetThreadBrowserAdapter$Item data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        WidgetThreadBrowserAdapter$Item$Header widgetThreadBrowserAdapter$Item$Header = (WidgetThreadBrowserAdapter$Item$Header) data;
        TextView textView = this.binding.f2158b;
        m.checkNotNullExpressionValue(textView, "binding.headerName");
        textView.setText(b.h(((WidgetThreadBrowserAdapter) this.adapter).getContext(), widgetThreadBrowserAdapter$Item$Header.getStringResId(), new Object[]{Integer.valueOf(widgetThreadBrowserAdapter$Item$Header.getCount())}, null, 4).toString());
    }
}
