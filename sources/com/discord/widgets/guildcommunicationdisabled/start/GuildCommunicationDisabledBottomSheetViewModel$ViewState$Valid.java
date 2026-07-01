package com.discord.widgets.guildcommunicationdisabled.start;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildCommunicationDisabledBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildCommunicationDisabledBottomSheetViewModel$ViewState$Valid extends GuildCommunicationDisabledBottomSheetViewModel$ViewState {
    private final String guildName;
    private final long timeoutTimeLeftMs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildCommunicationDisabledBottomSheetViewModel$ViewState$Valid(long j, String str) {
        super(null);
        m.checkNotNullParameter(str, "guildName");
        this.timeoutTimeLeftMs = j;
        this.guildName = str;
    }

    public static /* synthetic */ GuildCommunicationDisabledBottomSheetViewModel$ViewState$Valid copy$default(GuildCommunicationDisabledBottomSheetViewModel$ViewState$Valid guildCommunicationDisabledBottomSheetViewModel$ViewState$Valid, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = guildCommunicationDisabledBottomSheetViewModel$ViewState$Valid.timeoutTimeLeftMs;
        }
        if ((i & 2) != 0) {
            str = guildCommunicationDisabledBottomSheetViewModel$ViewState$Valid.guildName;
        }
        return guildCommunicationDisabledBottomSheetViewModel$ViewState$Valid.copy(j, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getTimeoutTimeLeftMs() {
        return this.timeoutTimeLeftMs;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    public final GuildCommunicationDisabledBottomSheetViewModel$ViewState$Valid copy(long timeoutTimeLeftMs, String guildName) {
        m.checkNotNullParameter(guildName, "guildName");
        return new GuildCommunicationDisabledBottomSheetViewModel$ViewState$Valid(timeoutTimeLeftMs, guildName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildCommunicationDisabledBottomSheetViewModel$ViewState$Valid)) {
            return false;
        }
        GuildCommunicationDisabledBottomSheetViewModel$ViewState$Valid guildCommunicationDisabledBottomSheetViewModel$ViewState$Valid = (GuildCommunicationDisabledBottomSheetViewModel$ViewState$Valid) other;
        return this.timeoutTimeLeftMs == guildCommunicationDisabledBottomSheetViewModel$ViewState$Valid.timeoutTimeLeftMs && m.areEqual(this.guildName, guildCommunicationDisabledBottomSheetViewModel$ViewState$Valid.guildName);
    }

    public final String getGuildName() {
        return this.guildName;
    }

    public final long getTimeoutTimeLeftMs() {
        return this.timeoutTimeLeftMs;
    }

    public int hashCode() {
        int iA = b.a(this.timeoutTimeLeftMs) * 31;
        String str = this.guildName;
        return iA + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(timeoutTimeLeftMs=");
        sbU.append(this.timeoutTimeLeftMs);
        sbU.append(", guildName=");
        return a.J(sbU, this.guildName, ")");
    }
}
