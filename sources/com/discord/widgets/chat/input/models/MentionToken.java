package com.discord.widgets.chat.input.models;

import b.d.b.a.outline;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: MentionToken.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MentionToken {
    private final String formattedToken;
    private final boolean isAtStart;
    private final LeadingIdentifier leadingIdentifier;
    private final int startIndex;
    private final String token;

    public MentionToken(LeadingIdentifier leadingIdentifier, String str, boolean z2, int i) {
        Intrinsics3.checkNotNullParameter(leadingIdentifier, "leadingIdentifier");
        Intrinsics3.checkNotNullParameter(str, "token");
        this.leadingIdentifier = leadingIdentifier;
        this.token = str;
        this.isAtStart = z2;
        this.startIndex = i;
        this.formattedToken = StringsJVM.replaceFirst$default(str, String.valueOf(leadingIdentifier.getIdentifier()), "", false, 4, null);
    }

    public static /* synthetic */ MentionToken copy$default(MentionToken mentionToken, LeadingIdentifier leadingIdentifier, String str, boolean z2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            leadingIdentifier = mentionToken.leadingIdentifier;
        }
        if ((i2 & 2) != 0) {
            str = mentionToken.token;
        }
        if ((i2 & 4) != 0) {
            z2 = mentionToken.isAtStart;
        }
        if ((i2 & 8) != 0) {
            i = mentionToken.startIndex;
        }
        return mentionToken.copy(leadingIdentifier, str, z2, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LeadingIdentifier getLeadingIdentifier() {
        return this.leadingIdentifier;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsAtStart() {
        return this.isAtStart;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getStartIndex() {
        return this.startIndex;
    }

    public final MentionToken copy(LeadingIdentifier leadingIdentifier, String token, boolean isAtStart, int startIndex) {
        Intrinsics3.checkNotNullParameter(leadingIdentifier, "leadingIdentifier");
        Intrinsics3.checkNotNullParameter(token, "token");
        return new MentionToken(leadingIdentifier, token, isAtStart, startIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MentionToken)) {
            return false;
        }
        MentionToken mentionToken = (MentionToken) other;
        return Intrinsics3.areEqual(this.leadingIdentifier, mentionToken.leadingIdentifier) && Intrinsics3.areEqual(this.token, mentionToken.token) && this.isAtStart == mentionToken.isAtStart && this.startIndex == mentionToken.startIndex;
    }

    public final String getFormattedToken() {
        return this.formattedToken;
    }

    public final LeadingIdentifier getLeadingIdentifier() {
        return this.leadingIdentifier;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final String getToken() {
        return this.token;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        LeadingIdentifier leadingIdentifier = this.leadingIdentifier;
        int iHashCode = (leadingIdentifier != null ? leadingIdentifier.hashCode() : 0) * 31;
        String str = this.token;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.isAtStart;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return ((iHashCode2 + r1) * 31) + this.startIndex;
    }

    public final boolean isAtStart() {
        return this.isAtStart;
    }

    public String toString() {
        StringBuilder sbU = outline.U("MentionToken(leadingIdentifier=");
        sbU.append(this.leadingIdentifier);
        sbU.append(", token=");
        sbU.append(this.token);
        sbU.append(", isAtStart=");
        sbU.append(this.isAtStart);
        sbU.append(", startIndex=");
        return outline.B(sbU, this.startIndex, ")");
    }
}
