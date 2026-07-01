package com.discord.widgets.user.search;

import android.widget.TextView;
import com.discord.databinding.WidgetGuildsListItemDmBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGlobalSearchGuildsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsAdapter$ItemDirectMessage extends WidgetGlobalSearchGuildsAdapter$Item {
    private final WidgetGuildsListItemDmBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchGuildsAdapter$ItemDirectMessage(WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter, int i) {
        super(i, widgetGlobalSearchGuildsAdapter);
        m.checkNotNullParameter(widgetGlobalSearchGuildsAdapter, "adapter");
        WidgetGuildsListItemDmBinding widgetGuildsListItemDmBindingA = WidgetGuildsListItemDmBinding.a(this.itemView);
        m.checkNotNullExpressionValue(widgetGuildsListItemDmBindingA, "WidgetGuildsListItemDmBinding.bind(itemView)");
        this.binding = widgetGuildsListItemDmBindingA;
    }

    @Override // com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter$Item, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGlobalSearchGuildsModel$Item widgetGlobalSearchGuildsModel$Item) {
        onConfigure(i, widgetGlobalSearchGuildsModel$Item);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter$Item
    public void onConfigure(int position, WidgetGlobalSearchGuildsModel$Item data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure2(position, data);
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.guildsItemDmCount");
        configureMentionsCount(textView, data.getMentionCount());
        SimpleDraweeView simpleDraweeView = this.binding.f2459b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildsItemDmAvatar");
        IconUtils.setIcon$default(simpleDraweeView, data.getChannel(), 2131165293, (MGImages$ChangeDetector) null, 8, (Object) null);
    }
}
