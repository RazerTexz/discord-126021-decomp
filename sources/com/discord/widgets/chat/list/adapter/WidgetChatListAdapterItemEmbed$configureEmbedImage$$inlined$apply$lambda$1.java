package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.embed.RenderableEmbedMedia;
import com.discord.utilities.embed.EmbedResourceUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.widgets.media.WidgetMedia;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed$configureEmbedImage$$inlined$apply$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ MessageEmbed $embed$inlined;
    public final /* synthetic */ RenderableEmbedMedia $previewImage$inlined;
    public final /* synthetic */ MessageEmbed $this_apply;
    public final /* synthetic */ WidgetChatListAdapterItemEmbed this$0;

    public WidgetChatListAdapterItemEmbed$configureEmbedImage$$inlined$apply$lambda$1(MessageEmbed messageEmbed, WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed, RenderableEmbedMedia renderableEmbedMedia, MessageEmbed messageEmbed2) {
        this.$this_apply = messageEmbed;
        this.this$0 = widgetChatListAdapterItemEmbed;
        this.$previewImage$inlined = renderableEmbedMedia;
        this.$embed$inlined = messageEmbed2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        String externalOpenUrl = EmbedResourceUtils.INSTANCE.getExternalOpenUrl(this.$this_apply);
        if (externalOpenUrl != null) {
            UriHandler.handleOrUntrusted(a.x(view, "view", "view.context"), externalOpenUrl, this.$embed$inlined.getTitle());
        } else {
            WidgetMedia.Companion.launch(a.x(view, "view", "view.context"), this.$embed$inlined);
        }
    }
}
