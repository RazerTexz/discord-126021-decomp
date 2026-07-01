package com.discord.widgets.servers.member_verification.form_fields;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: MemberVerificationItemMultipleChoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MemberVerificationItemMultipleChoice implements MemberVerificationItem {
    private final List<String> choices;
    private final int fieldIndex;
    private final String key;
    private final Integer response;
    private final int type;

    public MemberVerificationItemMultipleChoice(int i, List<String> list, Integer num) {
        m.checkNotNullParameter(list, "choices");
        this.fieldIndex = i;
        this.choices = list;
        this.response = num;
        this.type = 6;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(getType());
        this.key = sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MemberVerificationItemMultipleChoice copy$default(MemberVerificationItemMultipleChoice memberVerificationItemMultipleChoice, int i, List list, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = memberVerificationItemMultipleChoice.fieldIndex;
        }
        if ((i2 & 2) != 0) {
            list = memberVerificationItemMultipleChoice.choices;
        }
        if ((i2 & 4) != 0) {
            num = memberVerificationItemMultipleChoice.response;
        }
        return memberVerificationItemMultipleChoice.copy(i, list, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getFieldIndex() {
        return this.fieldIndex;
    }

    public final List<String> component2() {
        return this.choices;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getResponse() {
        return this.response;
    }

    public final MemberVerificationItemMultipleChoice copy(int fieldIndex, List<String> choices, Integer response) {
        m.checkNotNullParameter(choices, "choices");
        return new MemberVerificationItemMultipleChoice(fieldIndex, choices, response);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberVerificationItemMultipleChoice)) {
            return false;
        }
        MemberVerificationItemMultipleChoice memberVerificationItemMultipleChoice = (MemberVerificationItemMultipleChoice) other;
        return this.fieldIndex == memberVerificationItemMultipleChoice.fieldIndex && m.areEqual(this.choices, memberVerificationItemMultipleChoice.choices) && m.areEqual(this.response, memberVerificationItemMultipleChoice.response);
    }

    public final List<String> getChoices() {
        return this.choices;
    }

    public final int getFieldIndex() {
        return this.fieldIndex;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Integer getResponse() {
        return this.response;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        int i = this.fieldIndex * 31;
        List<String> list = this.choices;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        Integer num = this.response;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("MemberVerificationItemMultipleChoice(fieldIndex=");
        sbU.append(this.fieldIndex);
        sbU.append(", choices=");
        sbU.append(this.choices);
        sbU.append(", response=");
        return a.F(sbU, this.response, ")");
    }
}
