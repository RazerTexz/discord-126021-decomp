package com.discord.widgets.media;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.a.d.j;
import b.c.a.a0.d;
import com.discord.api.message.attachment.MessageAttachment;
import com.discord.api.message.attachment.MessageAttachmentType;
import com.discord.api.message.embed.EmbedType;
import com.discord.api.message.embed.EmbedVideo;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.embed.RenderableEmbedMedia;
import com.discord.player.MediaSource;
import com.discord.player.MediaType;
import com.discord.utilities.embed.EmbedResourceUtils;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMedia$Companion {
    private WidgetMedia$Companion() {
    }

    public final void launch(Context context, MessageAttachment attachment) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attachment, "attachment");
        MessageAttachmentType messageAttachmentTypeE = attachment.e();
        launch(context, attachment.getFilename(), attachment.getProxyUrl(), messageAttachmentTypeE.ordinal() != 0 ? null : attachment.getProxyUrl(), attachment.getProxyUrl(), attachment.getWidth(), attachment.getHeight(), messageAttachmentTypeE == MessageAttachmentType.VIDEO ? MediaType.VIDEO : null);
    }

    public /* synthetic */ WidgetMedia$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001c  */
    public final void launch(Context context, MessageEmbed embed) {
        String str;
        int iOrdinal;
        String url;
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(embed, "embed");
        EmbedType type = embed.getType();
        if (type != null && ((iOrdinal = type.ordinal()) == 2 || iOrdinal == 7)) {
            EmbedVideo video = embed.getVideo();
            if (video == null || (url = video.getProxyUrl()) == null) {
                EmbedVideo video2 = embed.getVideo();
                if (video2 != null) {
                    url = video2.getUrl();
                } else {
                    str = null;
                }
            }
            str = url;
        } else {
            str = null;
        }
        RenderableEmbedMedia previewImage = EmbedResourceUtils.INSTANCE.getPreviewImage(embed);
        launch(context, embed.getTitle(), embed.getUrl(), str, previewImage != null ? previewImage.url : null, previewImage != null ? previewImage.width : null, previewImage != null ? previewImage.height : null, embed.getType() == EmbedType.GIFV ? MediaType.GIFV : MediaType.VIDEO);
    }

    private final void launch(Context context, String title, String uri, String progressiveMediaUri, String previewImageUri, Integer width, Integer height, MediaType mediaType) {
        MediaSource mediaSourceP = (progressiveMediaUri == null || mediaType == null) ? null : d.P(mediaType, progressiveMediaUri, "javaClass");
        Intent intentPutExtra = new Intent().putExtra("INTENT_TITLE", title);
        if (uri == null) {
            uri = previewImageUri;
        }
        Intent intentPutExtra2 = intentPutExtra.putExtra("INTENT_MEDIA_URL", uri).putExtra("INTENT_IMAGE_URL", previewImageUri).putExtra("INTENT_MEDIA_WIDTH", width).putExtra("INTENT_MEDIA_HEIGHT", height).putExtra("INTENT_MEDIA_SOURCE", mediaSourceP);
        m.checkNotNullExpressionValue(intentPutExtra2, "Intent()\n          .putE…EDIA_SOURCE, mediaSource)");
        j.d(context, WidgetMedia.class, intentPutExtra2);
    }
}
