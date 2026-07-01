package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.domain.ModelMemberVerificationForm;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreGuildMemberVerificationForm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreGuildMemberVerificationForm$MemberVerificationFormData {
    private final StoreGuildMemberVerificationForm$FetchStates fetchState;
    private final ModelMemberVerificationForm form;

    public StoreGuildMemberVerificationForm$MemberVerificationFormData(StoreGuildMemberVerificationForm$FetchStates storeGuildMemberVerificationForm$FetchStates, ModelMemberVerificationForm modelMemberVerificationForm) {
        m.checkNotNullParameter(storeGuildMemberVerificationForm$FetchStates, "fetchState");
        this.fetchState = storeGuildMemberVerificationForm$FetchStates;
        this.form = modelMemberVerificationForm;
    }

    public static /* synthetic */ StoreGuildMemberVerificationForm$MemberVerificationFormData copy$default(StoreGuildMemberVerificationForm$MemberVerificationFormData storeGuildMemberVerificationForm$MemberVerificationFormData, StoreGuildMemberVerificationForm$FetchStates storeGuildMemberVerificationForm$FetchStates, ModelMemberVerificationForm modelMemberVerificationForm, int i, Object obj) {
        if ((i & 1) != 0) {
            storeGuildMemberVerificationForm$FetchStates = storeGuildMemberVerificationForm$MemberVerificationFormData.fetchState;
        }
        if ((i & 2) != 0) {
            modelMemberVerificationForm = storeGuildMemberVerificationForm$MemberVerificationFormData.form;
        }
        return storeGuildMemberVerificationForm$MemberVerificationFormData.copy(storeGuildMemberVerificationForm$FetchStates, modelMemberVerificationForm);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreGuildMemberVerificationForm$FetchStates getFetchState() {
        return this.fetchState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ModelMemberVerificationForm getForm() {
        return this.form;
    }

    public final StoreGuildMemberVerificationForm$MemberVerificationFormData copy(StoreGuildMemberVerificationForm$FetchStates fetchState, ModelMemberVerificationForm form) {
        m.checkNotNullParameter(fetchState, "fetchState");
        return new StoreGuildMemberVerificationForm$MemberVerificationFormData(fetchState, form);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreGuildMemberVerificationForm$MemberVerificationFormData)) {
            return false;
        }
        StoreGuildMemberVerificationForm$MemberVerificationFormData storeGuildMemberVerificationForm$MemberVerificationFormData = (StoreGuildMemberVerificationForm$MemberVerificationFormData) other;
        return m.areEqual(this.fetchState, storeGuildMemberVerificationForm$MemberVerificationFormData.fetchState) && m.areEqual(this.form, storeGuildMemberVerificationForm$MemberVerificationFormData.form);
    }

    public final StoreGuildMemberVerificationForm$FetchStates getFetchState() {
        return this.fetchState;
    }

    public final ModelMemberVerificationForm getForm() {
        return this.form;
    }

    public int hashCode() {
        StoreGuildMemberVerificationForm$FetchStates storeGuildMemberVerificationForm$FetchStates = this.fetchState;
        int iHashCode = (storeGuildMemberVerificationForm$FetchStates != null ? storeGuildMemberVerificationForm$FetchStates.hashCode() : 0) * 31;
        ModelMemberVerificationForm modelMemberVerificationForm = this.form;
        return iHashCode + (modelMemberVerificationForm != null ? modelMemberVerificationForm.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("MemberVerificationFormData(fetchState=");
        sbU.append(this.fetchState);
        sbU.append(", form=");
        sbU.append(this.form);
        sbU.append(")");
        return sbU.toString();
    }
}
