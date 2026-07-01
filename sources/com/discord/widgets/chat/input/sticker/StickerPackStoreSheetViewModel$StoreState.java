package com.discord.widgets.chat.input.sticker;

import b.d.b.a.a;
import com.discord.models.user.User;
import com.discord.stores.StoreStickers$StickerPackState;
import d0.z.d.m;

/* JADX INFO: compiled from: StickerPackStoreSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StickerPackStoreSheetViewModel$StoreState {
    private final User meUser;
    private final int stickerAnimationSettings;
    private final StoreStickers$StickerPackState stickerPack;

    public StickerPackStoreSheetViewModel$StoreState(StoreStickers$StickerPackState storeStickers$StickerPackState, int i, User user) {
        m.checkNotNullParameter(storeStickers$StickerPackState, "stickerPack");
        m.checkNotNullParameter(user, "meUser");
        this.stickerPack = storeStickers$StickerPackState;
        this.stickerAnimationSettings = i;
        this.meUser = user;
    }

    public static /* synthetic */ StickerPackStoreSheetViewModel$StoreState copy$default(StickerPackStoreSheetViewModel$StoreState stickerPackStoreSheetViewModel$StoreState, StoreStickers$StickerPackState storeStickers$StickerPackState, int i, User user, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            storeStickers$StickerPackState = stickerPackStoreSheetViewModel$StoreState.stickerPack;
        }
        if ((i2 & 2) != 0) {
            i = stickerPackStoreSheetViewModel$StoreState.stickerAnimationSettings;
        }
        if ((i2 & 4) != 0) {
            user = stickerPackStoreSheetViewModel$StoreState.meUser;
        }
        return stickerPackStoreSheetViewModel$StoreState.copy(storeStickers$StickerPackState, i, user);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreStickers$StickerPackState getStickerPack() {
        return this.stickerPack;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getStickerAnimationSettings() {
        return this.stickerAnimationSettings;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final User getMeUser() {
        return this.meUser;
    }

    public final StickerPackStoreSheetViewModel$StoreState copy(StoreStickers$StickerPackState stickerPack, int stickerAnimationSettings, User meUser) {
        m.checkNotNullParameter(stickerPack, "stickerPack");
        m.checkNotNullParameter(meUser, "meUser");
        return new StickerPackStoreSheetViewModel$StoreState(stickerPack, stickerAnimationSettings, meUser);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerPackStoreSheetViewModel$StoreState)) {
            return false;
        }
        StickerPackStoreSheetViewModel$StoreState stickerPackStoreSheetViewModel$StoreState = (StickerPackStoreSheetViewModel$StoreState) other;
        return m.areEqual(this.stickerPack, stickerPackStoreSheetViewModel$StoreState.stickerPack) && this.stickerAnimationSettings == stickerPackStoreSheetViewModel$StoreState.stickerAnimationSettings && m.areEqual(this.meUser, stickerPackStoreSheetViewModel$StoreState.meUser);
    }

    public final User getMeUser() {
        return this.meUser;
    }

    public final int getStickerAnimationSettings() {
        return this.stickerAnimationSettings;
    }

    public final StoreStickers$StickerPackState getStickerPack() {
        return this.stickerPack;
    }

    public int hashCode() {
        StoreStickers$StickerPackState storeStickers$StickerPackState = this.stickerPack;
        int iHashCode = (((storeStickers$StickerPackState != null ? storeStickers$StickerPackState.hashCode() : 0) * 31) + this.stickerAnimationSettings) * 31;
        User user = this.meUser;
        return iHashCode + (user != null ? user.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(stickerPack=");
        sbU.append(this.stickerPack);
        sbU.append(", stickerAnimationSettings=");
        sbU.append(this.stickerAnimationSettings);
        sbU.append(", meUser=");
        sbU.append(this.meUser);
        sbU.append(")");
        return sbU.toString();
    }
}
