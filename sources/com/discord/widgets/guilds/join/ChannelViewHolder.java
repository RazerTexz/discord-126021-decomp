package com.discord.widgets.guilds.join;

import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.welcome.GuildWelcomeChannel;
import com.discord.databinding.WidgetGuildWelcomeChannelBinding;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.stores.StoreStream;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildWelcomeSheetChannelAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelViewHolder extends BaseChannelViewHolder {
    private final WidgetGuildWelcomeChannelBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    public ChannelViewHolder(WidgetGuildWelcomeChannelBinding widgetGuildWelcomeChannelBinding) {
        m.checkNotNullParameter(widgetGuildWelcomeChannelBinding, "binding");
        CardView cardView = widgetGuildWelcomeChannelBinding.a;
        m.checkNotNullExpressionValue(cardView, "binding.root");
        super(cardView);
        this.binding = widgetGuildWelcomeChannelBinding;
    }

    @Override // com.discord.widgets.guilds.join.BaseChannelViewHolder
    public void bind(ChannelItem data) {
        m.checkNotNullParameter(data, "data");
        super.bind(data);
        ChannelItem$ChannelData channelItem$ChannelData = (ChannelItem$ChannelData) data;
        SimpleDraweeView simpleDraweeView = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildWelcomeChannelEmoji");
        int mediaProxySize = IconUtils.getMediaProxySize(simpleDraweeView.getLayoutParams().width);
        GuildWelcomeChannel welcomeChannel = channelItem$ChannelData.getWelcomeChannel();
        m.checkNotNullParameter(welcomeChannel, "$this$getEmojiUri");
        Long emojiId = welcomeChannel.getEmojiId();
        String imageUri = emojiId != null ? ModelEmojiCustom.getImageUri(emojiId.longValue(), false, mediaProxySize) : null;
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.guildWelcomeChannelDescription");
        textView.setText(channelItem$ChannelData.getWelcomeChannel().getDescription());
        TextView textView2 = this.binding.e;
        m.checkNotNullExpressionValue(textView2, "binding.guildWelcomeChannelName");
        Channel channelFindChannelById = StoreStream.Companion.getChannels().findChannelById(channelItem$ChannelData.getWelcomeChannel().getChannelId());
        textView2.setText(String.valueOf(channelFindChannelById != null ? ChannelUtils.c(channelFindChannelById) : null));
        this.binding.f2456b.setOnClickListener(new ChannelViewHolder$bind$1(data));
        if (imageUri != null) {
            SimpleDraweeView simpleDraweeView2 = this.binding.d;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildWelcomeChannelEmoji");
            MGImages.setImage$default(simpleDraweeView2, imageUri, 0, 0, false, null, null, 124, null);
            SimpleDraweeView simpleDraweeView3 = this.binding.d;
            m.checkNotNullExpressionValue(simpleDraweeView3, "binding.guildWelcomeChannelEmoji");
            simpleDraweeView3.setVisibility(0);
            TextView textView3 = this.binding.f;
            m.checkNotNullExpressionValue(textView3, "binding.guildWelcomeChannelUnicodeEmoji");
            textView3.setVisibility(8);
            return;
        }
        if (channelItem$ChannelData.getWelcomeChannel().getEmojiName() != null) {
            SimpleDraweeView simpleDraweeView4 = this.binding.d;
            m.checkNotNullExpressionValue(simpleDraweeView4, "binding.guildWelcomeChannelEmoji");
            simpleDraweeView4.setVisibility(8);
            TextView textView4 = this.binding.f;
            m.checkNotNullExpressionValue(textView4, "binding.guildWelcomeChannelUnicodeEmoji");
            textView4.setVisibility(0);
            TextView textView5 = this.binding.f;
            m.checkNotNullExpressionValue(textView5, "binding.guildWelcomeChannelUnicodeEmoji");
            textView5.setText(channelItem$ChannelData.getWelcomeChannel().getEmojiName());
        }
    }
}
