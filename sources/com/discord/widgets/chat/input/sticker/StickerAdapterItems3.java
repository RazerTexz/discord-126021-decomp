package com.discord.widgets.chat.input.sticker;

import b.d.b.a.outline;
import com.discord.api.sticker.Sticker;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.stickers.StickerUtils;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.StickerItem, reason: use source file name */
/* JADX INFO: compiled from: StickerAdapterItems.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StickerAdapterItems3 implements MGRecyclerDataPayload {
    private final String key;
    private final Mode mode;
    private final StickerUtils.StickerSendability sendability;
    private final Sticker sticker;
    private final int stickerAnimationSettings;
    private final int type;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.StickerItem$Mode */
    /* JADX INFO: compiled from: StickerAdapterItems.kt */
    public enum Mode {
        OWNED,
        STORE
    }

    public StickerAdapterItems3(Sticker sticker, int i, Mode mode, StickerUtils.StickerSendability stickerSendability) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        Intrinsics3.checkNotNullParameter(mode, "mode");
        Intrinsics3.checkNotNullParameter(stickerSendability, "sendability");
        this.sticker = sticker;
        this.stickerAnimationSettings = i;
        this.mode = mode;
        this.sendability = stickerSendability;
        this.type = 1;
        StringBuilder sbU = outline.U("sticker:");
        sbU.append(sticker.getId());
        this.key = sbU.toString();
    }

    public static /* synthetic */ StickerAdapterItems3 copy$default(StickerAdapterItems3 stickerAdapterItems3, Sticker sticker, int i, Mode mode, StickerUtils.StickerSendability stickerSendability, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sticker = stickerAdapterItems3.sticker;
        }
        if ((i2 & 2) != 0) {
            i = stickerAdapterItems3.stickerAnimationSettings;
        }
        if ((i2 & 4) != 0) {
            mode = stickerAdapterItems3.mode;
        }
        if ((i2 & 8) != 0) {
            stickerSendability = stickerAdapterItems3.sendability;
        }
        return stickerAdapterItems3.copy(sticker, i, mode, stickerSendability);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Sticker getSticker() {
        return this.sticker;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getStickerAnimationSettings() {
        return this.stickerAnimationSettings;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Mode getMode() {
        return this.mode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final StickerUtils.StickerSendability getSendability() {
        return this.sendability;
    }

    public final StickerAdapterItems3 copy(Sticker sticker, int stickerAnimationSettings, Mode mode, StickerUtils.StickerSendability sendability) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        Intrinsics3.checkNotNullParameter(mode, "mode");
        Intrinsics3.checkNotNullParameter(sendability, "sendability");
        return new StickerAdapterItems3(sticker, stickerAnimationSettings, mode, sendability);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerAdapterItems3)) {
            return false;
        }
        StickerAdapterItems3 stickerAdapterItems3 = (StickerAdapterItems3) other;
        return Intrinsics3.areEqual(this.sticker, stickerAdapterItems3.sticker) && this.stickerAnimationSettings == stickerAdapterItems3.stickerAnimationSettings && Intrinsics3.areEqual(this.mode, stickerAdapterItems3.mode) && Intrinsics3.areEqual(this.sendability, stickerAdapterItems3.sendability);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Mode getMode() {
        return this.mode;
    }

    public final StickerUtils.StickerSendability getSendability() {
        return this.sendability;
    }

    public final Sticker getSticker() {
        return this.sticker;
    }

    public final int getStickerAnimationSettings() {
        return this.stickerAnimationSettings;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        Sticker sticker = this.sticker;
        int iHashCode = (((sticker != null ? sticker.hashCode() : 0) * 31) + this.stickerAnimationSettings) * 31;
        Mode mode = this.mode;
        int iHashCode2 = (iHashCode + (mode != null ? mode.hashCode() : 0)) * 31;
        StickerUtils.StickerSendability stickerSendability = this.sendability;
        return iHashCode2 + (stickerSendability != null ? stickerSendability.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("StickerItem(sticker=");
        sbU.append(this.sticker);
        sbU.append(", stickerAnimationSettings=");
        sbU.append(this.stickerAnimationSettings);
        sbU.append(", mode=");
        sbU.append(this.mode);
        sbU.append(", sendability=");
        sbU.append(this.sendability);
        sbU.append(")");
        return sbU.toString();
    }
}
