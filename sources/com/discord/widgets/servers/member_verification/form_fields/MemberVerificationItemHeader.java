package com.discord.widgets.servers.member_verification.form_fields;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: MemberVerificationItemHeader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MemberVerificationItemHeader implements MemberVerificationItem {
    private final String key;
    private final String title;
    private final int type;

    public MemberVerificationItemHeader(String str) {
        Intrinsics3.checkNotNullParameter(str, "title");
        this.title = str;
        this.key = str;
    }

    public static /* synthetic */ MemberVerificationItemHeader copy$default(MemberVerificationItemHeader memberVerificationItemHeader, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = memberVerificationItemHeader.title;
        }
        return memberVerificationItemHeader.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final MemberVerificationItemHeader copy(String title) {
        Intrinsics3.checkNotNullParameter(title, "title");
        return new MemberVerificationItemHeader(title);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof MemberVerificationItemHeader) && Intrinsics3.areEqual(this.title, ((MemberVerificationItemHeader) other).title);
        }
        return true;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final String getTitle() {
        return this.title;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.title;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.J(outline.U("MemberVerificationItemHeader(title="), this.title, ")");
    }
}
