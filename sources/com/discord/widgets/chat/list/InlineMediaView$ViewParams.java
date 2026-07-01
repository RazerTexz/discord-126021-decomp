package com.discord.widgets.chat.list;

import b.d.b.a.a;
import com.discord.api.message.embed.EmbedType;
import com.discord.embed.RenderableEmbedMedia;
import d0.z.d.m;

/* JADX INFO: compiled from: InlineMediaView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class InlineMediaView$ViewParams {
    private final boolean autoPlayGifs;
    private final EmbedType embedType;
    private final RenderableEmbedMedia previewImage;
    private final String progressiveMediaUri;
    private final Integer targetHeight;
    private final Integer targetWidth;

    public InlineMediaView$ViewParams(RenderableEmbedMedia renderableEmbedMedia, String str, EmbedType embedType, Integer num, Integer num2, boolean z2) {
        this.previewImage = renderableEmbedMedia;
        this.progressiveMediaUri = str;
        this.embedType = embedType;
        this.targetWidth = num;
        this.targetHeight = num2;
        this.autoPlayGifs = z2;
    }

    public static /* synthetic */ InlineMediaView$ViewParams copy$default(InlineMediaView$ViewParams inlineMediaView$ViewParams, RenderableEmbedMedia renderableEmbedMedia, String str, EmbedType embedType, Integer num, Integer num2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            renderableEmbedMedia = inlineMediaView$ViewParams.previewImage;
        }
        if ((i & 2) != 0) {
            str = inlineMediaView$ViewParams.progressiveMediaUri;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            embedType = inlineMediaView$ViewParams.embedType;
        }
        EmbedType embedType2 = embedType;
        if ((i & 8) != 0) {
            num = inlineMediaView$ViewParams.targetWidth;
        }
        Integer num3 = num;
        if ((i & 16) != 0) {
            num2 = inlineMediaView$ViewParams.targetHeight;
        }
        Integer num4 = num2;
        if ((i & 32) != 0) {
            z2 = inlineMediaView$ViewParams.autoPlayGifs;
        }
        return inlineMediaView$ViewParams.copy(renderableEmbedMedia, str2, embedType2, num3, num4, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final RenderableEmbedMedia getPreviewImage() {
        return this.previewImage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getProgressiveMediaUri() {
        return this.progressiveMediaUri;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final EmbedType getEmbedType() {
        return this.embedType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getTargetWidth() {
        return this.targetWidth;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getTargetHeight() {
        return this.targetHeight;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getAutoPlayGifs() {
        return this.autoPlayGifs;
    }

    public final InlineMediaView$ViewParams copy(RenderableEmbedMedia previewImage, String progressiveMediaUri, EmbedType embedType, Integer targetWidth, Integer targetHeight, boolean autoPlayGifs) {
        return new InlineMediaView$ViewParams(previewImage, progressiveMediaUri, embedType, targetWidth, targetHeight, autoPlayGifs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InlineMediaView$ViewParams)) {
            return false;
        }
        InlineMediaView$ViewParams inlineMediaView$ViewParams = (InlineMediaView$ViewParams) other;
        return m.areEqual(this.previewImage, inlineMediaView$ViewParams.previewImage) && m.areEqual(this.progressiveMediaUri, inlineMediaView$ViewParams.progressiveMediaUri) && m.areEqual(this.embedType, inlineMediaView$ViewParams.embedType) && m.areEqual(this.targetWidth, inlineMediaView$ViewParams.targetWidth) && m.areEqual(this.targetHeight, inlineMediaView$ViewParams.targetHeight) && this.autoPlayGifs == inlineMediaView$ViewParams.autoPlayGifs;
    }

    public final boolean getAutoPlayGifs() {
        return this.autoPlayGifs;
    }

    public final EmbedType getEmbedType() {
        return this.embedType;
    }

    public final RenderableEmbedMedia getPreviewImage() {
        return this.previewImage;
    }

    public final String getProgressiveMediaUri() {
        return this.progressiveMediaUri;
    }

    public final Integer getTargetHeight() {
        return this.targetHeight;
    }

    public final Integer getTargetWidth() {
        return this.targetWidth;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        RenderableEmbedMedia renderableEmbedMedia = this.previewImage;
        int iHashCode = (renderableEmbedMedia != null ? renderableEmbedMedia.hashCode() : 0) * 31;
        String str = this.progressiveMediaUri;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        EmbedType embedType = this.embedType;
        int iHashCode3 = (iHashCode2 + (embedType != null ? embedType.hashCode() : 0)) * 31;
        Integer num = this.targetWidth;
        int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.targetHeight;
        int iHashCode5 = (iHashCode4 + (num2 != null ? num2.hashCode() : 0)) * 31;
        boolean z2 = this.autoPlayGifs;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode5 + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewParams(previewImage=");
        sbU.append(this.previewImage);
        sbU.append(", progressiveMediaUri=");
        sbU.append(this.progressiveMediaUri);
        sbU.append(", embedType=");
        sbU.append(this.embedType);
        sbU.append(", targetWidth=");
        sbU.append(this.targetWidth);
        sbU.append(", targetHeight=");
        sbU.append(this.targetHeight);
        sbU.append(", autoPlayGifs=");
        return a.O(sbU, this.autoPlayGifs, ")");
    }
}
