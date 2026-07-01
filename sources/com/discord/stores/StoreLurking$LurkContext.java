package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: StoreLurking.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreLurking$LurkContext {
    private final long guildId;
    private final boolean shouldNavigate;

    public StoreLurking$LurkContext(long j, boolean z2) {
        this.guildId = j;
        this.shouldNavigate = z2;
    }

    public static /* synthetic */ StoreLurking$LurkContext copy$default(StoreLurking$LurkContext storeLurking$LurkContext, long j, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = storeLurking$LurkContext.guildId;
        }
        if ((i & 2) != 0) {
            z2 = storeLurking$LurkContext.shouldNavigate;
        }
        return storeLurking$LurkContext.copy(j, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShouldNavigate() {
        return this.shouldNavigate;
    }

    public final StoreLurking$LurkContext copy(long guildId, boolean shouldNavigate) {
        return new StoreLurking$LurkContext(guildId, shouldNavigate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreLurking$LurkContext)) {
            return false;
        }
        StoreLurking$LurkContext storeLurking$LurkContext = (StoreLurking$LurkContext) other;
        return this.guildId == storeLurking$LurkContext.guildId && this.shouldNavigate == storeLurking$LurkContext.shouldNavigate;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final boolean getShouldNavigate() {
        return this.shouldNavigate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int iA = b.a(this.guildId) * 31;
        boolean z2 = this.shouldNavigate;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iA + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("LurkContext(guildId=");
        sbU.append(this.guildId);
        sbU.append(", shouldNavigate=");
        return a.O(sbU, this.shouldNavigate, ")");
    }
}
