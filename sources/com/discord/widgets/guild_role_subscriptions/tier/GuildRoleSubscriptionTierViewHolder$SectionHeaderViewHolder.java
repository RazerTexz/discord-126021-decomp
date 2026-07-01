package com.discord.widgets.guild_role_subscriptions.tier;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.d.b.a.a;
import com.discord.databinding.ViewGuildRoleSubscriptionSectionHeaderItemBinding;
import com.discord.utilities.resources.StringResourceUtilsKt;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionTierViewHolder$SectionHeaderViewHolder extends GuildRoleSubscriptionTierViewHolder {
    private final ViewGuildRoleSubscriptionSectionHeaderItemBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    public GuildRoleSubscriptionTierViewHolder$SectionHeaderViewHolder(ViewGuildRoleSubscriptionSectionHeaderItemBinding viewGuildRoleSubscriptionSectionHeaderItemBinding) {
        m.checkNotNullParameter(viewGuildRoleSubscriptionSectionHeaderItemBinding, "binding");
        LinearLayout linearLayout = viewGuildRoleSubscriptionSectionHeaderItemBinding.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.root");
        super(linearLayout, null);
        this.binding = viewGuildRoleSubscriptionSectionHeaderItemBinding;
        View view = this.itemView;
        view.setPadding(0, 0, 0, 0);
        view.setBackground(null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final ViewGuildRoleSubscriptionSectionHeaderItemBinding getBinding() {
        return this.binding;
    }

    public static /* synthetic */ GuildRoleSubscriptionTierViewHolder$SectionHeaderViewHolder copy$default(GuildRoleSubscriptionTierViewHolder$SectionHeaderViewHolder guildRoleSubscriptionTierViewHolder$SectionHeaderViewHolder, ViewGuildRoleSubscriptionSectionHeaderItemBinding viewGuildRoleSubscriptionSectionHeaderItemBinding, int i, Object obj) {
        if ((i & 1) != 0) {
            viewGuildRoleSubscriptionSectionHeaderItemBinding = guildRoleSubscriptionTierViewHolder$SectionHeaderViewHolder.binding;
        }
        return guildRoleSubscriptionTierViewHolder$SectionHeaderViewHolder.copy(viewGuildRoleSubscriptionSectionHeaderItemBinding);
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierViewHolder
    public void bind(GuildRoleSubscriptionTierAdapterItem item) {
        CharSequence i18nPluralString;
        m.checkNotNullParameter(item, "item");
        GuildRoleSubscriptionTierAdapterItem$SectionHeader guildRoleSubscriptionTierAdapterItem$SectionHeader = (GuildRoleSubscriptionTierAdapterItem$SectionHeader) item;
        if (guildRoleSubscriptionTierAdapterItem$SectionHeader.getTitleResId() != null) {
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            i18nPluralString = view.getContext().getString(guildRoleSubscriptionTierAdapterItem$SectionHeader.getTitleResId().intValue());
        } else {
            i18nPluralString = (guildRoleSubscriptionTierAdapterItem$SectionHeader.getTitlePluralResId() == null || guildRoleSubscriptionTierAdapterItem$SectionHeader.getFormatArgument() == null) ? null : StringResourceUtilsKt.getI18nPluralString(a.x(this.itemView, "itemView", "itemView.context"), guildRoleSubscriptionTierAdapterItem$SectionHeader.getTitlePluralResId().intValue(), guildRoleSubscriptionTierAdapterItem$SectionHeader.getFormatArgument().intValue(), guildRoleSubscriptionTierAdapterItem$SectionHeader.getFormatArgument());
        }
        TextView textView = this.binding.f2198b;
        m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionSectionHeader");
        textView.setText(i18nPluralString);
    }

    public final GuildRoleSubscriptionTierViewHolder$SectionHeaderViewHolder copy(ViewGuildRoleSubscriptionSectionHeaderItemBinding binding) {
        m.checkNotNullParameter(binding, "binding");
        return new GuildRoleSubscriptionTierViewHolder$SectionHeaderViewHolder(binding);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildRoleSubscriptionTierViewHolder$SectionHeaderViewHolder) && m.areEqual(this.binding, ((GuildRoleSubscriptionTierViewHolder$SectionHeaderViewHolder) other).binding);
        }
        return true;
    }

    public int hashCode() {
        ViewGuildRoleSubscriptionSectionHeaderItemBinding viewGuildRoleSubscriptionSectionHeaderItemBinding = this.binding;
        if (viewGuildRoleSubscriptionSectionHeaderItemBinding != null) {
            return viewGuildRoleSubscriptionSectionHeaderItemBinding.hashCode();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$ViewHolder
    public String toString() {
        StringBuilder sbU = a.U("SectionHeaderViewHolder(binding=");
        sbU.append(this.binding);
        sbU.append(")");
        return sbU.toString();
    }
}
