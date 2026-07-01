package com.discord.widgets.chat.input;

import b.d.b.a.a;
import com.lytefast.flexinput.model.Attachment;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChatInputViewModel$AttachmentContext {
    private final List<Float> attachmentSizes;
    private final ArrayList<Attachment<?>> attachments;
    private final float currentFileSizeMB;
    private final boolean hasGif;
    private final boolean hasImage;
    private final boolean hasVideo;
    private final float maxAttachmentSizeMB;

    public ChatInputViewModel$AttachmentContext(ArrayList<Attachment<?>> arrayList, boolean z2, boolean z3, boolean z4, List<Float> list, float f, float f2) {
        m.checkNotNullParameter(arrayList, "attachments");
        m.checkNotNullParameter(list, "attachmentSizes");
        this.attachments = arrayList;
        this.hasImage = z2;
        this.hasVideo = z3;
        this.hasGif = z4;
        this.attachmentSizes = list;
        this.currentFileSizeMB = f;
        this.maxAttachmentSizeMB = f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatInputViewModel$AttachmentContext copy$default(ChatInputViewModel$AttachmentContext chatInputViewModel$AttachmentContext, ArrayList arrayList, boolean z2, boolean z3, boolean z4, List list, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = chatInputViewModel$AttachmentContext.attachments;
        }
        if ((i & 2) != 0) {
            z2 = chatInputViewModel$AttachmentContext.hasImage;
        }
        boolean z5 = z2;
        if ((i & 4) != 0) {
            z3 = chatInputViewModel$AttachmentContext.hasVideo;
        }
        boolean z6 = z3;
        if ((i & 8) != 0) {
            z4 = chatInputViewModel$AttachmentContext.hasGif;
        }
        boolean z7 = z4;
        if ((i & 16) != 0) {
            list = chatInputViewModel$AttachmentContext.attachmentSizes;
        }
        List list2 = list;
        if ((i & 32) != 0) {
            f = chatInputViewModel$AttachmentContext.currentFileSizeMB;
        }
        float f3 = f;
        if ((i & 64) != 0) {
            f2 = chatInputViewModel$AttachmentContext.maxAttachmentSizeMB;
        }
        return chatInputViewModel$AttachmentContext.copy(arrayList, z5, z6, z7, list2, f3, f2);
    }

    public final ArrayList<Attachment<?>> component1() {
        return this.attachments;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getHasImage() {
        return this.hasImage;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getHasVideo() {
        return this.hasVideo;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getHasGif() {
        return this.hasGif;
    }

    public final List<Float> component5() {
        return this.attachmentSizes;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final float getCurrentFileSizeMB() {
        return this.currentFileSizeMB;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final float getMaxAttachmentSizeMB() {
        return this.maxAttachmentSizeMB;
    }

    public final ChatInputViewModel$AttachmentContext copy(ArrayList<Attachment<?>> attachments, boolean hasImage, boolean hasVideo, boolean hasGif, List<Float> attachmentSizes, float currentFileSizeMB, float maxAttachmentSizeMB) {
        m.checkNotNullParameter(attachments, "attachments");
        m.checkNotNullParameter(attachmentSizes, "attachmentSizes");
        return new ChatInputViewModel$AttachmentContext(attachments, hasImage, hasVideo, hasGif, attachmentSizes, currentFileSizeMB, maxAttachmentSizeMB);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatInputViewModel$AttachmentContext)) {
            return false;
        }
        ChatInputViewModel$AttachmentContext chatInputViewModel$AttachmentContext = (ChatInputViewModel$AttachmentContext) other;
        return m.areEqual(this.attachments, chatInputViewModel$AttachmentContext.attachments) && this.hasImage == chatInputViewModel$AttachmentContext.hasImage && this.hasVideo == chatInputViewModel$AttachmentContext.hasVideo && this.hasGif == chatInputViewModel$AttachmentContext.hasGif && m.areEqual(this.attachmentSizes, chatInputViewModel$AttachmentContext.attachmentSizes) && Float.compare(this.currentFileSizeMB, chatInputViewModel$AttachmentContext.currentFileSizeMB) == 0 && Float.compare(this.maxAttachmentSizeMB, chatInputViewModel$AttachmentContext.maxAttachmentSizeMB) == 0;
    }

    public final List<Float> getAttachmentSizes() {
        return this.attachmentSizes;
    }

    public final ArrayList<Attachment<?>> getAttachments() {
        return this.attachments;
    }

    public final float getCurrentFileSizeMB() {
        return this.currentFileSizeMB;
    }

    public final boolean getHasGif() {
        return this.hasGif;
    }

    public final boolean getHasImage() {
        return this.hasImage;
    }

    public final boolean getHasVideo() {
        return this.hasVideo;
    }

    public final float getMaxAttachmentSizeMB() {
        return this.maxAttachmentSizeMB;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        ArrayList<Attachment<?>> arrayList = this.attachments;
        int iHashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        boolean z2 = this.hasImage;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        boolean z3 = this.hasVideo;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        boolean z4 = this.hasGif;
        int i3 = (i2 + (z4 ? 1 : z4)) * 31;
        List<Float> list = this.attachmentSizes;
        return Float.floatToIntBits(this.maxAttachmentSizeMB) + ((Float.floatToIntBits(this.currentFileSizeMB) + ((i3 + (list != null ? list.hashCode() : 0)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("AttachmentContext(attachments=");
        sbU.append(this.attachments);
        sbU.append(", hasImage=");
        sbU.append(this.hasImage);
        sbU.append(", hasVideo=");
        sbU.append(this.hasVideo);
        sbU.append(", hasGif=");
        sbU.append(this.hasGif);
        sbU.append(", attachmentSizes=");
        sbU.append(this.attachmentSizes);
        sbU.append(", currentFileSizeMB=");
        sbU.append(this.currentFileSizeMB);
        sbU.append(", maxAttachmentSizeMB=");
        sbU.append(this.maxAttachmentSizeMB);
        sbU.append(")");
        return sbU.toString();
    }
}
