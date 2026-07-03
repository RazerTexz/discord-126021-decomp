package com.discord.widgets.chat.input.models;

import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: MentionToken.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MentionToken {
    private final String formattedToken;
    private final boolean isAtStart;
    private final LeadingIdentifier leadingIdentifier;
    private final int startIndex;
    private final String token;

    public MentionToken(LeadingIdentifier leadingIdentifier, String str, boolean z2, int i) {
        C12238m.checkNotNullParameter(leadingIdentifier, "leadingIdentifier");
        C12238m.checkNotNullParameter(str, "token");
        this.leadingIdentifier = leadingIdentifier;
        this.token = str;
        this.isAtStart = z2;
        this.startIndex = i;
        this.formattedToken = C12103t.replaceFirst$default(str, String.valueOf(leadingIdentifier.getIdentifier()), "", false, 4, null);
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
        C12238m.checkNotNullParameter(leadingIdentifier, "leadingIdentifier");
        C12238m.checkNotNullParameter(token, "token");
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
        return C12238m.areEqual(this.leadingIdentifier, mentionToken.leadingIdentifier) && C12238m.areEqual(this.token, mentionToken.token) && this.isAtStart == mentionToken.isAtStart && this.startIndex == mentionToken.startIndex;
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
        StringBuilder sbM833U = C1643a.m833U("MentionToken(leadingIdentifier=");
        sbM833U.append(this.leadingIdentifier);
        sbM833U.append(", token=");
        sbM833U.append(this.token);
        sbM833U.append(", isAtStart=");
        sbM833U.append(this.isAtStart);
        sbM833U.append(", startIndex=");
        return C1643a.m814B(sbM833U, this.startIndex, ")");
    }
}
