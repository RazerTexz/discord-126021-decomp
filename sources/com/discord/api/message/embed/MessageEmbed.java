package com.discord.api.message.embed;

import b.d.b.a.outline;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: compiled from: MessageEmbed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class MessageEmbed {
    private final EmbedAuthor author;
    private final Integer color;
    private final String description;
    private final List<EmbedField> fields;
    private final EmbedFooter footer;
    private final EmbedImage image;
    private final EmbedProvider provider;
    private final EmbedThumbnail thumbnail;
    private final UtcDateTime timestamp;
    private final String title;
    private final EmbedType type;
    private final String url;
    private final EmbedVideo video;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final EmbedAuthor getAuthor() {
        return this.author;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Integer getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<EmbedField> d() {
        return this.fields;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final EmbedFooter getFooter() {
        return this.footer;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageEmbed)) {
            return false;
        }
        MessageEmbed messageEmbed = (MessageEmbed) other;
        return Intrinsics3.areEqual(this.title, messageEmbed.title) && Intrinsics3.areEqual(this.type, messageEmbed.type) && Intrinsics3.areEqual(this.description, messageEmbed.description) && Intrinsics3.areEqual(this.url, messageEmbed.url) && Intrinsics3.areEqual(this.timestamp, messageEmbed.timestamp) && Intrinsics3.areEqual(this.color, messageEmbed.color) && Intrinsics3.areEqual(this.footer, messageEmbed.footer) && Intrinsics3.areEqual(this.image, messageEmbed.image) && Intrinsics3.areEqual(this.thumbnail, messageEmbed.thumbnail) && Intrinsics3.areEqual(this.video, messageEmbed.video) && Intrinsics3.areEqual(this.provider, messageEmbed.provider) && Intrinsics3.areEqual(this.author, messageEmbed.author) && Intrinsics3.areEqual(this.fields, messageEmbed.fields);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final EmbedImage getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final EmbedProvider getProvider() {
        return this.provider;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final EmbedThumbnail getThumbnail() {
        return this.thumbnail;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        EmbedType embedType = this.type;
        int iHashCode2 = (iHashCode + (embedType != null ? embedType.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.url;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime = this.timestamp;
        int iHashCode5 = (iHashCode4 + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        Integer num = this.color;
        int iHashCode6 = (iHashCode5 + (num != null ? num.hashCode() : 0)) * 31;
        EmbedFooter embedFooter = this.footer;
        int iHashCode7 = (iHashCode6 + (embedFooter != null ? embedFooter.hashCode() : 0)) * 31;
        EmbedImage embedImage = this.image;
        int iHashCode8 = (iHashCode7 + (embedImage != null ? embedImage.hashCode() : 0)) * 31;
        EmbedThumbnail embedThumbnail = this.thumbnail;
        int iHashCode9 = (iHashCode8 + (embedThumbnail != null ? embedThumbnail.hashCode() : 0)) * 31;
        EmbedVideo embedVideo = this.video;
        int iHashCode10 = (iHashCode9 + (embedVideo != null ? embedVideo.hashCode() : 0)) * 31;
        EmbedProvider embedProvider = this.provider;
        int iHashCode11 = (iHashCode10 + (embedProvider != null ? embedProvider.hashCode() : 0)) * 31;
        EmbedAuthor embedAuthor = this.author;
        int iHashCode12 = (iHashCode11 + (embedAuthor != null ? embedAuthor.hashCode() : 0)) * 31;
        List<EmbedField> list = this.fields;
        return iHashCode12 + (list != null ? list.hashCode() : 0);
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final UtcDateTime getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final EmbedType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final EmbedVideo getVideo() {
        return this.video;
    }

    public String toString() {
        StringBuilder sbU = outline.U("MessageEmbed(title=");
        sbU.append(this.title);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", url=");
        sbU.append(this.url);
        sbU.append(", timestamp=");
        sbU.append(this.timestamp);
        sbU.append(", color=");
        sbU.append(this.color);
        sbU.append(", footer=");
        sbU.append(this.footer);
        sbU.append(", image=");
        sbU.append(this.image);
        sbU.append(", thumbnail=");
        sbU.append(this.thumbnail);
        sbU.append(", video=");
        sbU.append(this.video);
        sbU.append(", provider=");
        sbU.append(this.provider);
        sbU.append(", author=");
        sbU.append(this.author);
        sbU.append(", fields=");
        return outline.L(sbU, this.fields, ")");
    }
}
