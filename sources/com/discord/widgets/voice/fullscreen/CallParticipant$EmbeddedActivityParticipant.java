package com.discord.widgets.voice.fullscreen;

import b.d.b.a.a;
import com.discord.api.application.ApplicationAsset;
import com.discord.models.commands.Application;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.models.guild.UserGuildMember;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: CallParticipant.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class CallParticipant$EmbeddedActivityParticipant extends CallParticipant {
    private final Application application;
    private final ApplicationAsset backgroundAsset;
    private final EmbeddedActivity embeddedActivity;
    private final String id;
    private final List<UserGuildMember> participantsInActivity;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallParticipant$EmbeddedActivityParticipant(EmbeddedActivity embeddedActivity, List<UserGuildMember> list, Application application, ApplicationAsset applicationAsset) {
        super(null);
        m.checkNotNullParameter(embeddedActivity, "embeddedActivity");
        m.checkNotNullParameter(list, "participantsInActivity");
        m.checkNotNullParameter(application, "application");
        this.embeddedActivity = embeddedActivity;
        this.participantsInActivity = list;
        this.application = application;
        this.backgroundAsset = applicationAsset;
        this.id = String.valueOf(application.getId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CallParticipant$EmbeddedActivityParticipant copy$default(CallParticipant$EmbeddedActivityParticipant callParticipant$EmbeddedActivityParticipant, EmbeddedActivity embeddedActivity, List list, Application application, ApplicationAsset applicationAsset, int i, Object obj) {
        if ((i & 1) != 0) {
            embeddedActivity = callParticipant$EmbeddedActivityParticipant.embeddedActivity;
        }
        if ((i & 2) != 0) {
            list = callParticipant$EmbeddedActivityParticipant.participantsInActivity;
        }
        if ((i & 4) != 0) {
            application = callParticipant$EmbeddedActivityParticipant.application;
        }
        if ((i & 8) != 0) {
            applicationAsset = callParticipant$EmbeddedActivityParticipant.backgroundAsset;
        }
        return callParticipant$EmbeddedActivityParticipant.copy(embeddedActivity, list, application, applicationAsset);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final EmbeddedActivity getEmbeddedActivity() {
        return this.embeddedActivity;
    }

    public final List<UserGuildMember> component2() {
        return this.participantsInActivity;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ApplicationAsset getBackgroundAsset() {
        return this.backgroundAsset;
    }

    public final CallParticipant$EmbeddedActivityParticipant copy(EmbeddedActivity embeddedActivity, List<UserGuildMember> participantsInActivity, Application application, ApplicationAsset backgroundAsset) {
        m.checkNotNullParameter(embeddedActivity, "embeddedActivity");
        m.checkNotNullParameter(participantsInActivity, "participantsInActivity");
        m.checkNotNullParameter(application, "application");
        return new CallParticipant$EmbeddedActivityParticipant(embeddedActivity, participantsInActivity, application, backgroundAsset);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallParticipant$EmbeddedActivityParticipant)) {
            return false;
        }
        CallParticipant$EmbeddedActivityParticipant callParticipant$EmbeddedActivityParticipant = (CallParticipant$EmbeddedActivityParticipant) other;
        return m.areEqual(this.embeddedActivity, callParticipant$EmbeddedActivityParticipant.embeddedActivity) && m.areEqual(this.participantsInActivity, callParticipant$EmbeddedActivityParticipant.participantsInActivity) && m.areEqual(this.application, callParticipant$EmbeddedActivityParticipant.application) && m.areEqual(this.backgroundAsset, callParticipant$EmbeddedActivityParticipant.backgroundAsset);
    }

    public final Application getApplication() {
        return this.application;
    }

    public final ApplicationAsset getBackgroundAsset() {
        return this.backgroundAsset;
    }

    public final EmbeddedActivity getEmbeddedActivity() {
        return this.embeddedActivity;
    }

    @Override // com.discord.widgets.voice.fullscreen.CallParticipant
    public String getId() {
        return this.id;
    }

    public final List<UserGuildMember> getParticipantsInActivity() {
        return this.participantsInActivity;
    }

    @Override // com.discord.widgets.voice.fullscreen.CallParticipant
    public boolean hasActiveVideo() {
        return false;
    }

    public int hashCode() {
        EmbeddedActivity embeddedActivity = this.embeddedActivity;
        int iHashCode = (embeddedActivity != null ? embeddedActivity.hashCode() : 0) * 31;
        List<UserGuildMember> list = this.participantsInActivity;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        Application application = this.application;
        int iHashCode3 = (iHashCode2 + (application != null ? application.hashCode() : 0)) * 31;
        ApplicationAsset applicationAsset = this.backgroundAsset;
        return iHashCode3 + (applicationAsset != null ? applicationAsset.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("EmbeddedActivityParticipant(embeddedActivity=");
        sbU.append(this.embeddedActivity);
        sbU.append(", participantsInActivity=");
        sbU.append(this.participantsInActivity);
        sbU.append(", application=");
        sbU.append(this.application);
        sbU.append(", backgroundAsset=");
        sbU.append(this.backgroundAsset);
        sbU.append(")");
        return sbU.toString();
    }
}
