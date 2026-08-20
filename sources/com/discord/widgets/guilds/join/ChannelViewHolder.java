package com.discord.widgets.guilds.join;

import android.view.View;
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
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildWelcomeSheetChannelAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelViewHolder extends BaseChannelViewHolder {
    private final WidgetGuildWelcomeChannelBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    public ChannelViewHolder(WidgetGuildWelcomeChannelBinding widgetGuildWelcomeChannelBinding) {
        C12238m.checkNotNullParameter(widgetGuildWelcomeChannelBinding, "binding");
        CardView cardView = widgetGuildWelcomeChannelBinding.f17079a;
        C12238m.checkNotNullExpressionValue(cardView, "binding.root");
        super(cardView);
        this.binding = widgetGuildWelcomeChannelBinding;
    }

    @Override // com.discord.widgets.guilds.join.BaseChannelViewHolder
    public void bind(final ChannelItem data) {
        C12238m.checkNotNullParameter(data, "data");
        super.bind(data);
        ChannelItem.ChannelData channelData = (ChannelItem.ChannelData) data;
        SimpleDraweeView simpleDraweeView = this.binding.f17082d;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildWelcomeChannelEmoji");
        int mediaProxySize = IconUtils.getMediaProxySize(simpleDraweeView.getLayoutParams().width);
        GuildWelcomeChannel welcomeChannel = channelData.getWelcomeChannel();
        C12238m.checkNotNullParameter(welcomeChannel, "$this$getEmojiUri");
        Long emojiId = welcomeChannel.getEmojiId();
        String imageUri = emojiId != null ? ModelEmojiCustom.getImageUri(emojiId.longValue(), false, mediaProxySize) : null;
        TextView textView = this.binding.f17081c;
        C12238m.checkNotNullExpressionValue(textView, "binding.guildWelcomeChannelDescription");
        textView.setText(channelData.getWelcomeChannel().getDescription());
        TextView textView2 = this.binding.f17083e;
        C12238m.checkNotNullExpressionValue(textView2, "binding.guildWelcomeChannelName");
        Channel channelFindChannelById = StoreStream.INSTANCE.getChannels().findChannelById(channelData.getWelcomeChannel().getChannelId());
        textView2.setText(String.valueOf(channelFindChannelById != null ? ChannelUtils.m7679c(channelFindChannelById) : null));
        this.binding.f17080b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.join.ChannelViewHolder.bind.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ((ChannelItem.ChannelData) data).getGoToChannel().invoke(Long.valueOf(((ChannelItem.ChannelData) data).getWelcomeChannel().getChannelId()), Integer.valueOf(((ChannelItem.ChannelData) data).getIndex()));
                ((ChannelItem.ChannelData) data).getDismissSheet().invoke();
            }
        });
        if (imageUri != null) {
            SimpleDraweeView simpleDraweeView2 = this.binding.f17082d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildWelcomeChannelEmoji");
            MGImages.setImage$default(simpleDraweeView2, imageUri, 0, 0, false, null, null, 124, null);
            SimpleDraweeView simpleDraweeView3 = this.binding.f17082d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.guildWelcomeChannelEmoji");
            simpleDraweeView3.setVisibility(0);
            TextView textView3 = this.binding.f17084f;
            C12238m.checkNotNullExpressionValue(textView3, "binding.guildWelcomeChannelUnicodeEmoji");
            textView3.setVisibility(8);
            return;
        }
        if (channelData.getWelcomeChannel().getEmojiName() != null) {
            SimpleDraweeView simpleDraweeView4 = this.binding.f17082d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView4, "binding.guildWelcomeChannelEmoji");
            simpleDraweeView4.setVisibility(8);
            TextView textView4 = this.binding.f17084f;
            C12238m.checkNotNullExpressionValue(textView4, "binding.guildWelcomeChannelUnicodeEmoji");
            textView4.setVisibility(0);
            TextView textView5 = this.binding.f17084f;
            C12238m.checkNotNullExpressionValue(textView5, "binding.guildWelcomeChannelUnicodeEmoji");
            textView5.setText(channelData.getWelcomeChannel().getEmojiName());
        }
    }
}
