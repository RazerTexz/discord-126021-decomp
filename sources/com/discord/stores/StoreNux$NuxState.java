package com.discord.stores;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreNux.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreNux$NuxState {
    private final boolean addGuildHint;
    private final boolean contactSyncCompleted;
    private final boolean firstOpen;
    private final Long guildBoostHintGuildId;
    private final boolean postRegister;
    private final boolean postRegisterWithInvite;

    public StoreNux$NuxState() {
        this(false, false, false, false, false, null, 63, null);
    }

    public StoreNux$NuxState(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Long l) {
        this.postRegister = z2;
        this.postRegisterWithInvite = z3;
        this.contactSyncCompleted = z4;
        this.firstOpen = z5;
        this.addGuildHint = z6;
        this.guildBoostHintGuildId = l;
    }

    public static /* synthetic */ StoreNux$NuxState copy$default(StoreNux$NuxState storeNux$NuxState, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = storeNux$NuxState.postRegister;
        }
        if ((i & 2) != 0) {
            z3 = storeNux$NuxState.postRegisterWithInvite;
        }
        boolean z7 = z3;
        if ((i & 4) != 0) {
            z4 = storeNux$NuxState.contactSyncCompleted;
        }
        boolean z8 = z4;
        if ((i & 8) != 0) {
            z5 = storeNux$NuxState.firstOpen;
        }
        boolean z9 = z5;
        if ((i & 16) != 0) {
            z6 = storeNux$NuxState.addGuildHint;
        }
        boolean z10 = z6;
        if ((i & 32) != 0) {
            l = storeNux$NuxState.guildBoostHintGuildId;
        }
        return storeNux$NuxState.copy(z2, z7, z8, z9, z10, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getPostRegister() {
        return this.postRegister;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getPostRegisterWithInvite() {
        return this.postRegisterWithInvite;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getContactSyncCompleted() {
        return this.contactSyncCompleted;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getFirstOpen() {
        return this.firstOpen;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getAddGuildHint() {
        return this.addGuildHint;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getGuildBoostHintGuildId() {
        return this.guildBoostHintGuildId;
    }

    public final StoreNux$NuxState copy(boolean postRegister, boolean postRegisterWithInvite, boolean contactSyncCompleted, boolean firstOpen, boolean addGuildHint, Long guildBoostHintGuildId) {
        return new StoreNux$NuxState(postRegister, postRegisterWithInvite, contactSyncCompleted, firstOpen, addGuildHint, guildBoostHintGuildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreNux$NuxState)) {
            return false;
        }
        StoreNux$NuxState storeNux$NuxState = (StoreNux$NuxState) other;
        return this.postRegister == storeNux$NuxState.postRegister && this.postRegisterWithInvite == storeNux$NuxState.postRegisterWithInvite && this.contactSyncCompleted == storeNux$NuxState.contactSyncCompleted && this.firstOpen == storeNux$NuxState.firstOpen && this.addGuildHint == storeNux$NuxState.addGuildHint && m.areEqual(this.guildBoostHintGuildId, storeNux$NuxState.guildBoostHintGuildId);
    }

    public final boolean getAddGuildHint() {
        return this.addGuildHint;
    }

    public final boolean getContactSyncCompleted() {
        return this.contactSyncCompleted;
    }

    public final boolean getFirstOpen() {
        return this.firstOpen;
    }

    public final Long getGuildBoostHintGuildId() {
        return this.guildBoostHintGuildId;
    }

    public final boolean getPostRegister() {
        return this.postRegister;
    }

    public final boolean getPostRegisterWithInvite() {
        return this.postRegisterWithInvite;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        boolean z2 = this.postRegister;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.postRegisterWithInvite;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.contactSyncCompleted;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.firstOpen;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i4 = (i3 + r4) * 31;
        boolean z6 = this.addGuildHint;
        int i5 = (i4 + (z6 ? 1 : z6)) * 31;
        Long l = this.guildBoostHintGuildId;
        return i5 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("NuxState(postRegister=");
        sbU.append(this.postRegister);
        sbU.append(", postRegisterWithInvite=");
        sbU.append(this.postRegisterWithInvite);
        sbU.append(", contactSyncCompleted=");
        sbU.append(this.contactSyncCompleted);
        sbU.append(", firstOpen=");
        sbU.append(this.firstOpen);
        sbU.append(", addGuildHint=");
        sbU.append(this.addGuildHint);
        sbU.append(", guildBoostHintGuildId=");
        return a.G(sbU, this.guildBoostHintGuildId, ")");
    }

    public /* synthetic */ StoreNux$NuxState(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? false : z4, (i & 8) != 0 ? false : z5, (i & 16) == 0 ? z6 : false, (i & 32) != 0 ? null : l);
    }
}
