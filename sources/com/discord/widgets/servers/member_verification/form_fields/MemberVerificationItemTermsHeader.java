package com.discord.widgets.servers.member_verification.form_fields;


/* JADX INFO: compiled from: MemberVerificationItemTermsHeader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationItemTermsHeader implements MemberVerificationItem {
    private final int type = 1;
    private final String key = String.valueOf(getType());

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }
}
