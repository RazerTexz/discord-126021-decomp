package com.discord.widgets.stickers;

import b.d.b.a.a;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStickers$StickerPackState;
import d0.z.d.m;

/* JADX INFO: compiled from: StickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class StickerSheetViewModel$StoreState {
    private final MeUser meUser;
    private final StoreStickers$StickerPackState stickerPack;

    public StickerSheetViewModel$StoreState(StoreStickers$StickerPackState storeStickers$StickerPackState, MeUser meUser) {
        m.checkNotNullParameter(storeStickers$StickerPackState, "stickerPack");
        m.checkNotNullParameter(meUser, "meUser");
        this.stickerPack = storeStickers$StickerPackState;
        this.meUser = meUser;
    }

    public static /* synthetic */ StickerSheetViewModel$StoreState copy$default(StickerSheetViewModel$StoreState stickerSheetViewModel$StoreState, StoreStickers$StickerPackState storeStickers$StickerPackState, MeUser meUser, int i, Object obj) {
        if ((i & 1) != 0) {
            storeStickers$StickerPackState = stickerSheetViewModel$StoreState.stickerPack;
        }
        if ((i & 2) != 0) {
            meUser = stickerSheetViewModel$StoreState.meUser;
        }
        return stickerSheetViewModel$StoreState.copy(storeStickers$StickerPackState, meUser);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreStickers$StickerPackState getStickerPack() {
        return this.stickerPack;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MeUser getMeUser() {
        return this.meUser;
    }

    public final StickerSheetViewModel$StoreState copy(StoreStickers$StickerPackState stickerPack, MeUser meUser) {
        m.checkNotNullParameter(stickerPack, "stickerPack");
        m.checkNotNullParameter(meUser, "meUser");
        return new StickerSheetViewModel$StoreState(stickerPack, meUser);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerSheetViewModel$StoreState)) {
            return false;
        }
        StickerSheetViewModel$StoreState stickerSheetViewModel$StoreState = (StickerSheetViewModel$StoreState) other;
        return m.areEqual(this.stickerPack, stickerSheetViewModel$StoreState.stickerPack) && m.areEqual(this.meUser, stickerSheetViewModel$StoreState.meUser);
    }

    public final MeUser getMeUser() {
        return this.meUser;
    }

    public final StoreStickers$StickerPackState getStickerPack() {
        return this.stickerPack;
    }

    public int hashCode() {
        StoreStickers$StickerPackState storeStickers$StickerPackState = this.stickerPack;
        int iHashCode = (storeStickers$StickerPackState != null ? storeStickers$StickerPackState.hashCode() : 0) * 31;
        MeUser meUser = this.meUser;
        return iHashCode + (meUser != null ? meUser.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(stickerPack=");
        sbU.append(this.stickerPack);
        sbU.append(", meUser=");
        sbU.append(this.meUser);
        sbU.append(")");
        return sbU.toString();
    }
}
