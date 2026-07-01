package com.discord.widgets.user.search;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.discord.R$id;
import com.discord.databinding.WidgetGlobalSearchItemGuildBinding;
import com.discord.databinding.WidgetGuildsListItemGuildBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.utilities.extensions.SimpleDraweeViewExtensionsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGlobalSearchGuildsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsAdapter$ItemGuild extends WidgetGlobalSearchGuildsAdapter$Item {
    private final WidgetGlobalSearchItemGuildBinding binding;
    private final WidgetGuildsListItemGuildBinding bindingGuild;
    private final int overlayColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchGuildsAdapter$ItemGuild(WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter, int i, @ColorInt int i2) {
        super(i, widgetGlobalSearchGuildsAdapter);
        m.checkNotNullParameter(widgetGlobalSearchGuildsAdapter, "adapter");
        this.overlayColor = i2;
        View view = this.itemView;
        int i3 = R$id.guilds_item_selected;
        ImageView imageView = (ImageView) view.findViewById(R$id.guilds_item_selected);
        if (imageView != null) {
            i3 = R$id.guilds_item_unread;
            ImageView imageView2 = (ImageView) view.findViewById(R$id.guilds_item_unread);
            if (imageView2 != null) {
                WidgetGlobalSearchItemGuildBinding widgetGlobalSearchItemGuildBinding = new WidgetGlobalSearchItemGuildBinding((RelativeLayout) view, imageView, imageView2);
                m.checkNotNullExpressionValue(widgetGlobalSearchItemGuildBinding, "WidgetGlobalSearchItemGuildBinding.bind(itemView)");
                this.binding = widgetGlobalSearchItemGuildBinding;
                WidgetGuildsListItemGuildBinding widgetGuildsListItemGuildBindingA = WidgetGuildsListItemGuildBinding.a(this.itemView);
                m.checkNotNullExpressionValue(widgetGuildsListItemGuildBindingA, "WidgetGuildsListItemGuildBinding.bind(itemView)");
                this.bindingGuild = widgetGuildsListItemGuildBindingA;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter$Item, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGlobalSearchGuildsModel$Item widgetGlobalSearchGuildsModel$Item) {
        onConfigure(i, widgetGlobalSearchGuildsModel$Item);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter$Item
    public void onConfigure(int position, WidgetGlobalSearchGuildsModel$Item data) {
        Guild guild;
        m.checkNotNullParameter(data, "data");
        super.onConfigure2(position, data);
        Guild guild2 = data.getGuild();
        boolean z2 = guild2 != null && guild2.hasIcon();
        SimpleDraweeView simpleDraweeView = this.bindingGuild.d;
        m.checkNotNullExpressionValue(simpleDraweeView, "bindingGuild.guildsItemAvatar");
        boolean zIsSelected = data.isSelected();
        Guild guild3 = data.getGuild();
        Integer numValueOf = Integer.valueOf(this.overlayColor);
        SimpleDraweeView simpleDraweeView2 = this.bindingGuild.d;
        m.checkNotNullExpressionValue(simpleDraweeView2, "bindingGuild.guildsItemAvatar");
        SimpleDraweeViewExtensionsKt.setGuildIcon$default(simpleDraweeView, zIsSelected, guild3, simpleDraweeView2.getResources().getDimensionPixelSize(2131165449), null, numValueOf, null, null, false, null, 488, null);
        TextView textView = this.bindingGuild.e;
        m.checkNotNullExpressionValue(textView, "bindingGuild.guildsItemAvatarText");
        String shortName = null;
        if (!z2 && (guild = data.getGuild()) != null) {
            shortName = guild.getShortName();
        }
        textView.setText(shortName);
        TextView textView2 = this.bindingGuild.h;
        m.checkNotNullExpressionValue(textView2, "bindingGuild.guildsItemMentions");
        configureMentionsCount(textView2, data.getMentionCount());
        ImageView imageView = this.bindingGuild.i;
        m.checkNotNullExpressionValue(imageView, "bindingGuild.guildsItemVoice");
        imageView.setVisibility(data.getConnectedToVoice() ? 0 : 8);
        ImageView imageView2 = this.binding.c;
        m.checkNotNullExpressionValue(imageView2, "binding.guildsItemUnread");
        imageView2.setVisibility(data.isUnread() ? 0 : 8);
        ImageView imageView3 = this.binding.f2404b;
        m.checkNotNullExpressionValue(imageView3, "binding.guildsItemSelected");
        imageView3.setVisibility(data.isSelected() ? 0 : 8);
    }
}
