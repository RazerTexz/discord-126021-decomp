package com.discord.widgets.channels.threads.browser;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.ThreadBrowserItemWarningBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetThreadBrowserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserAdapter$WarningItem extends MGRecyclerViewHolder<WidgetThreadBrowserAdapter, WidgetThreadBrowserAdapter$Item> {
    private final ThreadBrowserItemWarningBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserAdapter$WarningItem(WidgetThreadBrowserAdapter widgetThreadBrowserAdapter) {
        super(R$layout.thread_browser_item_warning, widgetThreadBrowserAdapter);
        m.checkNotNullParameter(widgetThreadBrowserAdapter, "adapter");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(R$id.warning);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.warning)));
        }
        ThreadBrowserItemWarningBinding threadBrowserItemWarningBinding = new ThreadBrowserItemWarningBinding((ConstraintLayout) view, textView);
        m.checkNotNullExpressionValue(threadBrowserItemWarningBinding, "ThreadBrowserItemWarningBinding.bind(itemView)");
        this.binding = threadBrowserItemWarningBinding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetThreadBrowserAdapter$Item widgetThreadBrowserAdapter$Item) {
        onConfigure2(i, widgetThreadBrowserAdapter$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetThreadBrowserAdapter$Item data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        TextView textView = this.binding.f2160b;
        m.checkNotNullExpressionValue(textView, "binding.warning");
        textView.setText(b.h(((WidgetThreadBrowserAdapter) this.adapter).getContext(), 2131889327, new Object[0], null, 4).toString());
    }
}
