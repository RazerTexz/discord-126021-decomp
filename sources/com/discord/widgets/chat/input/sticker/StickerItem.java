package com.discord.widgets.chat.input.sticker;

import b.d.b.a.a;
import com.discord.api.sticker.Sticker;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.stickers.StickerUtils$StickerSendability;
import d0.z.d.m;

/* JADX INFO: compiled from: StickerAdapterItems.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StickerItem implements MGRecyclerDataPayload {
    private final String key;
    private final StickerItem$Mode mode;
    private final StickerUtils$StickerSendability sendability;
    private final Sticker sticker;
    private final int stickerAnimationSettings;
    private final int type;

    public StickerItem(Sticker sticker, int i, StickerItem$Mode stickerItem$Mode, StickerUtils$StickerSendability stickerUtils$StickerSendability) {
        m.checkNotNullParameter(sticker, "sticker");
        m.checkNotNullParameter(stickerItem$Mode, "mode");
        m.checkNotNullParameter(stickerUtils$StickerSendability, "sendability");
        this.sticker = sticker;
        this.stickerAnimationSettings = i;
        this.mode = stickerItem$Mode;
        this.sendability = stickerUtils$StickerSendability;
        this.type = 1;
        StringBuilder sbU = a.U("sticker:");
        sbU.append(sticker.getId());
        this.key = sbU.toString();
    }

    public static /* synthetic */ StickerItem copy$default(StickerItem stickerItem, Sticker sticker, int i, StickerItem$Mode stickerItem$Mode, StickerUtils$StickerSendability stickerUtils$StickerSendability, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sticker = stickerItem.sticker;
        }
        if ((i2 & 2) != 0) {
            i = stickerItem.stickerAnimationSettings;
        }
        if ((i2 & 4) != 0) {
            stickerItem$Mode = stickerItem.mode;
        }
        if ((i2 & 8) != 0) {
            stickerUtils$StickerSendability = stickerItem.sendability;
        }
        return stickerItem.copy(sticker, i, stickerItem$Mode, stickerUtils$StickerSendability);
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
    public final StickerItem$Mode getMode() {
        return this.mode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final StickerUtils$StickerSendability getSendability() {
        return this.sendability;
    }

    public final StickerItem copy(Sticker sticker, int stickerAnimationSettings, StickerItem$Mode mode, StickerUtils$StickerSendability sendability) {
        m.checkNotNullParameter(sticker, "sticker");
        m.checkNotNullParameter(mode, "mode");
        m.checkNotNullParameter(sendability, "sendability");
        return new StickerItem(sticker, stickerAnimationSettings, mode, sendability);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerItem)) {
            return false;
        }
        StickerItem stickerItem = (StickerItem) other;
        return m.areEqual(this.sticker, stickerItem.sticker) && this.stickerAnimationSettings == stickerItem.stickerAnimationSettings && m.areEqual(this.mode, stickerItem.mode) && m.areEqual(this.sendability, stickerItem.sendability);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final StickerItem$Mode getMode() {
        return this.mode;
    }

    public final StickerUtils$StickerSendability getSendability() {
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
        StickerItem$Mode stickerItem$Mode = this.mode;
        int iHashCode2 = (iHashCode + (stickerItem$Mode != null ? stickerItem$Mode.hashCode() : 0)) * 31;
        StickerUtils$StickerSendability stickerUtils$StickerSendability = this.sendability;
        return iHashCode2 + (stickerUtils$StickerSendability != null ? stickerUtils$StickerSendability.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StickerItem(sticker=");
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
