package com.discord.widgets.servers.guildboost;

import android.view.View;
import android.widget.TextView;
import com.discord.R$layout;
import com.discord.databinding.ViewNitroBoostPerksListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: GuildBoostPerkViewAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostPerkViewAdapter$PerkViewHolder extends MGRecyclerViewHolder<GuildBoostPerkViewAdapter, GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem> {
    private final ViewNitroBoostPerksListItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostPerkViewAdapter$PerkViewHolder(GuildBoostPerkViewAdapter guildBoostPerkViewAdapter) {
        super(R$layout.view_nitro_boost_perks_list_item, guildBoostPerkViewAdapter);
        m.checkNotNullParameter(guildBoostPerkViewAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        ViewNitroBoostPerksListItemBinding viewNitroBoostPerksListItemBinding = new ViewNitroBoostPerksListItemBinding(textView, textView);
        m.checkNotNullExpressionValue(viewNitroBoostPerksListItemBinding, "ViewNitroBoostPerksListItemBinding.bind(itemView)");
        this.binding = viewNitroBoostPerksListItemBinding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem guildBoostPerkViewAdapter$GuildBoostPerkViewListItem) {
        onConfigure2(i, guildBoostPerkViewAdapter$GuildBoostPerkViewListItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        TextView textView = this.binding.f2205b;
        m.checkNotNullExpressionValue(textView, "binding.perkViewContentListItem");
        textView.setText(data.getText());
        TextView textView2 = this.binding.f2205b;
        m.checkNotNullExpressionValue(textView2, "binding.perkViewContentListItem");
        DrawableCompat.setCompoundDrawablesCompat$default(textView2, data.getIconResId(), 0, 0, 0, 14, (Object) null);
    }
}
