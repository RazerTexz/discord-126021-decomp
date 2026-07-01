package com.discord.widgets.chat.input;

import b.d.b.a.a;
import com.lytefast.flexinput.model.Attachment;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChatInputViewModel$Event$FilesTooLarge extends ChatInputViewModel$Event {
    private final List<Attachment<?>> attachments;
    private final float currentFileSizeMB;
    private final boolean hasGif;
    private final boolean hasImage;
    private final boolean hasVideo;
    private final boolean isUserPremium;
    private final float maxAttachmentSizeMB;
    private final int maxFileSizeMB;
    private final Function0<Unit> onResendCompressed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChatInputViewModel$Event$FilesTooLarge(int i, float f, float f2, boolean z2, List<? extends Attachment<?>> list, boolean z3, boolean z4, boolean z5, Function0<Unit> function0) {
        super(null);
        m.checkNotNullParameter(list, "attachments");
        this.maxFileSizeMB = i;
        this.currentFileSizeMB = f;
        this.maxAttachmentSizeMB = f2;
        this.isUserPremium = z2;
        this.attachments = list;
        this.hasImage = z3;
        this.hasVideo = z4;
        this.hasGif = z5;
        this.onResendCompressed = function0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatInputViewModel$Event$FilesTooLarge copy$default(ChatInputViewModel$Event$FilesTooLarge chatInputViewModel$Event$FilesTooLarge, int i, float f, float f2, boolean z2, List list, boolean z3, boolean z4, boolean z5, Function0 function0, int i2, Object obj) {
        return chatInputViewModel$Event$FilesTooLarge.copy((i2 & 1) != 0 ? chatInputViewModel$Event$FilesTooLarge.maxFileSizeMB : i, (i2 & 2) != 0 ? chatInputViewModel$Event$FilesTooLarge.currentFileSizeMB : f, (i2 & 4) != 0 ? chatInputViewModel$Event$FilesTooLarge.maxAttachmentSizeMB : f2, (i2 & 8) != 0 ? chatInputViewModel$Event$FilesTooLarge.isUserPremium : z2, (i2 & 16) != 0 ? chatInputViewModel$Event$FilesTooLarge.attachments : list, (i2 & 32) != 0 ? chatInputViewModel$Event$FilesTooLarge.hasImage : z3, (i2 & 64) != 0 ? chatInputViewModel$Event$FilesTooLarge.hasVideo : z4, (i2 & 128) != 0 ? chatInputViewModel$Event$FilesTooLarge.hasGif : z5, (i2 & 256) != 0 ? chatInputViewModel$Event$FilesTooLarge.onResendCompressed : function0);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getMaxFileSizeMB() {
        return this.maxFileSizeMB;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getCurrentFileSizeMB() {
        return this.currentFileSizeMB;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getMaxAttachmentSizeMB() {
        return this.maxAttachmentSizeMB;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsUserPremium() {
        return this.isUserPremium;
    }

    public final List<Attachment<?>> component5() {
        return this.attachments;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getHasImage() {
        return this.hasImage;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getHasVideo() {
        return this.hasVideo;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getHasGif() {
        return this.hasGif;
    }

    public final Function0<Unit> component9() {
        return this.onResendCompressed;
    }

    public final ChatInputViewModel$Event$FilesTooLarge copy(int maxFileSizeMB, float currentFileSizeMB, float maxAttachmentSizeMB, boolean isUserPremium, List<? extends Attachment<?>> attachments, boolean hasImage, boolean hasVideo, boolean hasGif, Function0<Unit> onResendCompressed) {
        m.checkNotNullParameter(attachments, "attachments");
        return new ChatInputViewModel$Event$FilesTooLarge(maxFileSizeMB, currentFileSizeMB, maxAttachmentSizeMB, isUserPremium, attachments, hasImage, hasVideo, hasGif, onResendCompressed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatInputViewModel$Event$FilesTooLarge)) {
            return false;
        }
        ChatInputViewModel$Event$FilesTooLarge chatInputViewModel$Event$FilesTooLarge = (ChatInputViewModel$Event$FilesTooLarge) other;
        return this.maxFileSizeMB == chatInputViewModel$Event$FilesTooLarge.maxFileSizeMB && Float.compare(this.currentFileSizeMB, chatInputViewModel$Event$FilesTooLarge.currentFileSizeMB) == 0 && Float.compare(this.maxAttachmentSizeMB, chatInputViewModel$Event$FilesTooLarge.maxAttachmentSizeMB) == 0 && this.isUserPremium == chatInputViewModel$Event$FilesTooLarge.isUserPremium && m.areEqual(this.attachments, chatInputViewModel$Event$FilesTooLarge.attachments) && this.hasImage == chatInputViewModel$Event$FilesTooLarge.hasImage && this.hasVideo == chatInputViewModel$Event$FilesTooLarge.hasVideo && this.hasGif == chatInputViewModel$Event$FilesTooLarge.hasGif && m.areEqual(this.onResendCompressed, chatInputViewModel$Event$FilesTooLarge.onResendCompressed);
    }

    public final List<Attachment<?>> getAttachments() {
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

    public final int getMaxFileSizeMB() {
        return this.maxFileSizeMB;
    }

    public final Function0<Unit> getOnResendCompressed() {
        return this.onResendCompressed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iFloatToIntBits = (Float.floatToIntBits(this.maxAttachmentSizeMB) + ((Float.floatToIntBits(this.currentFileSizeMB) + (this.maxFileSizeMB * 31)) * 31)) * 31;
        boolean z2 = this.isUserPremium;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iFloatToIntBits + r1) * 31;
        List<Attachment<?>> list = this.attachments;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        boolean z3 = this.hasImage;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (iHashCode + r2) * 31;
        boolean z4 = this.hasVideo;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.hasGif;
        int i4 = (i3 + (z5 ? 1 : z5)) * 31;
        Function0<Unit> function0 = this.onResendCompressed;
        return i4 + (function0 != null ? function0.hashCode() : 0);
    }

    public final boolean isUserPremium() {
        return this.isUserPremium;
    }

    public String toString() {
        StringBuilder sbU = a.U("FilesTooLarge(maxFileSizeMB=");
        sbU.append(this.maxFileSizeMB);
        sbU.append(", currentFileSizeMB=");
        sbU.append(this.currentFileSizeMB);
        sbU.append(", maxAttachmentSizeMB=");
        sbU.append(this.maxAttachmentSizeMB);
        sbU.append(", isUserPremium=");
        sbU.append(this.isUserPremium);
        sbU.append(", attachments=");
        sbU.append(this.attachments);
        sbU.append(", hasImage=");
        sbU.append(this.hasImage);
        sbU.append(", hasVideo=");
        sbU.append(this.hasVideo);
        sbU.append(", hasGif=");
        sbU.append(this.hasGif);
        sbU.append(", onResendCompressed=");
        sbU.append(this.onResendCompressed);
        sbU.append(")");
        return sbU.toString();
    }
}
