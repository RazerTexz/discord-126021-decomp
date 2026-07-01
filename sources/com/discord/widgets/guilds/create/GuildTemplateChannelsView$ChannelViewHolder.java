package com.discord.widgets.guilds.create;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import com.discord.R$id;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.GuildTemplateChannelsItemViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: GuildTemplateChannelsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildTemplateChannelsView$ChannelViewHolder extends MGRecyclerViewHolder<GuildTemplateChannelsView$ChannelsAdapter, GuildTemplateChannelsView$ChannelDataPayload> {
    private final GuildTemplateChannelsItemViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildTemplateChannelsView$ChannelViewHolder(@LayoutRes int i, GuildTemplateChannelsView$ChannelsAdapter guildTemplateChannelsView$ChannelsAdapter) {
        super(i, guildTemplateChannelsView$ChannelsAdapter);
        m.checkNotNullParameter(guildTemplateChannelsView$ChannelsAdapter, "adapter");
        View view = this.itemView;
        int i2 = R$id.guild_template_channels_item_image;
        ImageView imageView = (ImageView) view.findViewById(R$id.guild_template_channels_item_image);
        if (imageView != null) {
            i2 = R$id.guild_template_channels_item_name;
            TextView textView = (TextView) view.findViewById(R$id.guild_template_channels_item_name);
            if (textView != null) {
                GuildTemplateChannelsItemViewBinding guildTemplateChannelsItemViewBinding = new GuildTemplateChannelsItemViewBinding((LinearLayout) view, imageView, textView);
                m.checkNotNullExpressionValue(guildTemplateChannelsItemViewBinding, "GuildTemplateChannelsIte…iewBinding.bind(itemView)");
                this.binding = guildTemplateChannelsItemViewBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, GuildTemplateChannelsView$ChannelDataPayload guildTemplateChannelsView$ChannelDataPayload) {
        onConfigure2(i, guildTemplateChannelsView$ChannelDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, GuildTemplateChannelsView$ChannelDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.guildTemplateChannelsItemName");
        textView.setText(ChannelUtils.c(data.getChannel()));
        if (ChannelUtils.k(data.getChannel())) {
            this.binding.f2123b.setImageResource(2131231664);
        } else if (ChannelUtils.J(data.getChannel())) {
            this.binding.f2123b.setImageResource(2131231640);
        } else {
            this.binding.f2123b.setImageResource(2131231631);
        }
        if (data.getChannel().getParentId() > 0) {
            ImageView imageView = this.binding.f2123b;
            m.checkNotNullExpressionValue(imageView, "binding.guildTemplateChannelsItemImage");
            ViewGroup$LayoutParams layoutParams = imageView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            Resources resources = ((GuildTemplateChannelsView$ChannelsAdapter) this.adapter).getContext().getResources();
            m.checkNotNullExpressionValue(resources, "adapter.context.resources");
            ((ViewGroup$MarginLayoutParams) layoutParams).leftMargin = (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics());
        }
    }
}
