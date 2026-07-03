package com.discord.widgets.chat.input.sticker;

import com.discord.api.sticker.Sticker;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.stickers.StickerUtils;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StickerAdapterItems.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StickerItem implements MGRecyclerDataPayload {
    private final String key;
    private final Mode mode;
    private final StickerUtils.StickerSendability sendability;
    private final Sticker sticker;
    private final int stickerAnimationSettings;
    private final int type;

    /* JADX INFO: compiled from: StickerAdapterItems.kt */
    public enum Mode {
        OWNED,
        STORE
    }

    public StickerItem(Sticker sticker, int i, Mode mode, StickerUtils.StickerSendability stickerSendability) {
        C12238m.checkNotNullParameter(sticker, "sticker");
        C12238m.checkNotNullParameter(mode, "mode");
        C12238m.checkNotNullParameter(stickerSendability, "sendability");
        this.sticker = sticker;
        this.stickerAnimationSettings = i;
        this.mode = mode;
        this.sendability = stickerSendability;
        this.type = 1;
        StringBuilder sbM833U = C1643a.m833U("sticker:");
        sbM833U.append(sticker.getId());
        this.key = sbM833U.toString();
    }

    public static /* synthetic */ StickerItem copy$default(StickerItem stickerItem, Sticker sticker, int i, Mode mode, StickerUtils.StickerSendability stickerSendability, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sticker = stickerItem.sticker;
        }
        if ((i2 & 2) != 0) {
            i = stickerItem.stickerAnimationSettings;
        }
        if ((i2 & 4) != 0) {
            mode = stickerItem.mode;
        }
        if ((i2 & 8) != 0) {
            stickerSendability = stickerItem.sendability;
        }
        return stickerItem.copy(sticker, i, mode, stickerSendability);
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

    public final StickerItem copy(Sticker sticker, int stickerAnimationSettings, Mode mode, StickerUtils.StickerSendability sendability) {
        C12238m.checkNotNullParameter(sticker, "sticker");
        C12238m.checkNotNullParameter(mode, "mode");
        C12238m.checkNotNullParameter(sendability, "sendability");
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
        return C12238m.areEqual(this.sticker, stickerItem.sticker) && this.stickerAnimationSettings == stickerItem.stickerAnimationSettings && C12238m.areEqual(this.mode, stickerItem.mode) && C12238m.areEqual(this.sendability, stickerItem.sendability);
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
        StringBuilder sbM833U = C1643a.m833U("StickerItem(sticker=");
        sbM833U.append(this.sticker);
        sbM833U.append(", stickerAnimationSettings=");
        sbM833U.append(this.stickerAnimationSettings);
        sbM833U.append(", mode=");
        sbM833U.append(this.mode);
        sbM833U.append(", sendability=");
        sbM833U.append(this.sendability);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
