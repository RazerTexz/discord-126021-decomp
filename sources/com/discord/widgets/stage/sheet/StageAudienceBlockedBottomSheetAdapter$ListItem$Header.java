package com.discord.widgets.stage.sheet;

import b.d.b.a.a;

/* JADX INFO: compiled from: StageAudienceBlockedBottomSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StageAudienceBlockedBottomSheetAdapter$ListItem$Header extends StageAudienceBlockedBottomSheetAdapter$ListItem {
    private final String key;
    private final int numBlockedUsers;
    private final int type;

    public StageAudienceBlockedBottomSheetAdapter$ListItem$Header(int i) {
        super(null);
        this.numBlockedUsers = i;
        this.key = "AudienceBlockedHeader";
    }

    public static /* synthetic */ StageAudienceBlockedBottomSheetAdapter$ListItem$Header copy$default(StageAudienceBlockedBottomSheetAdapter$ListItem$Header stageAudienceBlockedBottomSheetAdapter$ListItem$Header, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = stageAudienceBlockedBottomSheetAdapter$ListItem$Header.numBlockedUsers;
        }
        return stageAudienceBlockedBottomSheetAdapter$ListItem$Header.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getNumBlockedUsers() {
        return this.numBlockedUsers;
    }

    public final StageAudienceBlockedBottomSheetAdapter$ListItem$Header copy(int numBlockedUsers) {
        return new StageAudienceBlockedBottomSheetAdapter$ListItem$Header(numBlockedUsers);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StageAudienceBlockedBottomSheetAdapter$ListItem$Header) && this.numBlockedUsers == ((StageAudienceBlockedBottomSheetAdapter$ListItem$Header) other).numBlockedUsers;
        }
        return true;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final int getNumBlockedUsers() {
        return this.numBlockedUsers;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return this.numBlockedUsers;
    }

    public String toString() {
        return a.B(a.U("Header(numBlockedUsers="), this.numBlockedUsers, ")");
    }
}
