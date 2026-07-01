package com.discord.widgets.user.search;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import b.a.k.b;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGlobalSearchGuildsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class WidgetGlobalSearchGuildsAdapter$Item extends MGRecyclerViewHolder<WidgetGlobalSearchGuildsAdapter, WidgetGlobalSearchGuildsModel$Item> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchGuildsAdapter$Item(@LayoutRes int i, WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter) {
        super(i, widgetGlobalSearchGuildsAdapter);
        m.checkNotNullParameter(widgetGlobalSearchGuildsAdapter, "adapter");
    }

    public static final /* synthetic */ WidgetGlobalSearchGuildsAdapter access$getAdapter$p(WidgetGlobalSearchGuildsAdapter$Item widgetGlobalSearchGuildsAdapter$Item) {
        return (WidgetGlobalSearchGuildsAdapter) widgetGlobalSearchGuildsAdapter$Item.adapter;
    }

    public final void configureMentionsCount(TextView textView, int count) {
        m.checkNotNullParameter(textView, "textView");
        if (count < 1) {
            ViewExtensions.setTextAndVisibilityBy(textView, null);
            textView.setContentDescription(null);
            return;
        }
        textView.setVisibility(0);
        textView.setText(String.valueOf(count));
        Context context = textView.getContext();
        m.checkNotNullExpressionValue(context, "context");
        textView.setBackgroundResource(DrawableCompat.getThemedDrawableRes$default(context, 2130969901, 0, 2, (Object) null));
        textView.setContentDescription(b.h(context, 2131892954, new Object[]{String.valueOf(count)}, null, 4));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGlobalSearchGuildsModel$Item widgetGlobalSearchGuildsModel$Item) {
        onConfigure2(i, widgetGlobalSearchGuildsModel$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetGlobalSearchGuildsModel$Item data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        this.itemView.setOnClickListener(new WidgetGlobalSearchGuildsAdapter$Item$onConfigure$1(this, position, data));
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        ViewExtensions.setOnLongClickListenerConsumeClick(view, new WidgetGlobalSearchGuildsAdapter$Item$onConfigure$2(this, position, data));
    }
}
