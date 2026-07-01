package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ModelMemberVerificationFormResponse.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelMemberVerificationFormResponse {
    private final ApplicationStatus applicationStatus;
    private final List<ModelMemberVerificationForm$FormField> formResponses;
    private final Long guildId;
    private final String lastSeen;

    public ModelMemberVerificationFormResponse(String str, ApplicationStatus applicationStatus, List<ModelMemberVerificationForm$FormField> list, Long l) {
        m.checkNotNullParameter(applicationStatus, "applicationStatus");
        this.lastSeen = str;
        this.applicationStatus = applicationStatus;
        this.formResponses = list;
        this.guildId = l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelMemberVerificationFormResponse copy$default(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse, String str, ApplicationStatus applicationStatus, List list, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelMemberVerificationFormResponse.lastSeen;
        }
        if ((i & 2) != 0) {
            applicationStatus = modelMemberVerificationFormResponse.applicationStatus;
        }
        if ((i & 4) != 0) {
            list = modelMemberVerificationFormResponse.formResponses;
        }
        if ((i & 8) != 0) {
            l = modelMemberVerificationFormResponse.guildId;
        }
        return modelMemberVerificationFormResponse.copy(str, applicationStatus, list, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLastSeen() {
        return this.lastSeen;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ApplicationStatus getApplicationStatus() {
        return this.applicationStatus;
    }

    public final List<ModelMemberVerificationForm$FormField> component3() {
        return this.formResponses;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    public final ModelMemberVerificationFormResponse copy(String lastSeen, ApplicationStatus applicationStatus, List<ModelMemberVerificationForm$FormField> formResponses, Long guildId) {
        m.checkNotNullParameter(applicationStatus, "applicationStatus");
        return new ModelMemberVerificationFormResponse(lastSeen, applicationStatus, formResponses, guildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelMemberVerificationFormResponse)) {
            return false;
        }
        ModelMemberVerificationFormResponse modelMemberVerificationFormResponse = (ModelMemberVerificationFormResponse) other;
        return m.areEqual(this.lastSeen, modelMemberVerificationFormResponse.lastSeen) && m.areEqual(this.applicationStatus, modelMemberVerificationFormResponse.applicationStatus) && m.areEqual(this.formResponses, modelMemberVerificationFormResponse.formResponses) && m.areEqual(this.guildId, modelMemberVerificationFormResponse.guildId);
    }

    public final ApplicationStatus getApplicationStatus() {
        return this.applicationStatus;
    }

    public final List<ModelMemberVerificationForm$FormField> getFormResponses() {
        return this.formResponses;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final String getLastSeen() {
        return this.lastSeen;
    }

    public int hashCode() {
        String str = this.lastSeen;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        ApplicationStatus applicationStatus = this.applicationStatus;
        int iHashCode2 = (iHashCode + (applicationStatus != null ? applicationStatus.hashCode() : 0)) * 31;
        List<ModelMemberVerificationForm$FormField> list = this.formResponses;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Long l = this.guildId;
        return iHashCode3 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelMemberVerificationFormResponse(lastSeen=");
        sbU.append(this.lastSeen);
        sbU.append(", applicationStatus=");
        sbU.append(this.applicationStatus);
        sbU.append(", formResponses=");
        sbU.append(this.formResponses);
        sbU.append(", guildId=");
        return a.G(sbU, this.guildId, ")");
    }
}
