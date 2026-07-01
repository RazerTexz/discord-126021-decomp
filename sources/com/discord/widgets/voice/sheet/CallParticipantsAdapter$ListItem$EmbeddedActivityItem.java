package com.discord.widgets.voice.sheet;

import b.d.b.a.a;
import com.discord.models.commands.Application;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.models.guild.UserGuildMember;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class CallParticipantsAdapter$ListItem$EmbeddedActivityItem extends CallParticipantsAdapter$ListItem {
    private final Application application;
    private final EmbeddedActivity embeddedActivity;
    private final String key;
    private final List<UserGuildMember> participants;
    private final int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallParticipantsAdapter$ListItem$EmbeddedActivityItem(EmbeddedActivity embeddedActivity, List<UserGuildMember> list, Application application) {
        super(null);
        m.checkNotNullParameter(embeddedActivity, "embeddedActivity");
        m.checkNotNullParameter(list, "participants");
        m.checkNotNullParameter(application, "application");
        this.embeddedActivity = embeddedActivity;
        this.participants = list;
        this.application = application;
        this.type = 6;
        this.key = String.valueOf(embeddedActivity.getApplicationId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CallParticipantsAdapter$ListItem$EmbeddedActivityItem copy$default(CallParticipantsAdapter$ListItem$EmbeddedActivityItem callParticipantsAdapter$ListItem$EmbeddedActivityItem, EmbeddedActivity embeddedActivity, List list, Application application, int i, Object obj) {
        if ((i & 1) != 0) {
            embeddedActivity = callParticipantsAdapter$ListItem$EmbeddedActivityItem.embeddedActivity;
        }
        if ((i & 2) != 0) {
            list = callParticipantsAdapter$ListItem$EmbeddedActivityItem.participants;
        }
        if ((i & 4) != 0) {
            application = callParticipantsAdapter$ListItem$EmbeddedActivityItem.application;
        }
        return callParticipantsAdapter$ListItem$EmbeddedActivityItem.copy(embeddedActivity, list, application);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final EmbeddedActivity getEmbeddedActivity() {
        return this.embeddedActivity;
    }

    public final List<UserGuildMember> component2() {
        return this.participants;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    public final CallParticipantsAdapter$ListItem$EmbeddedActivityItem copy(EmbeddedActivity embeddedActivity, List<UserGuildMember> participants, Application application) {
        m.checkNotNullParameter(embeddedActivity, "embeddedActivity");
        m.checkNotNullParameter(participants, "participants");
        m.checkNotNullParameter(application, "application");
        return new CallParticipantsAdapter$ListItem$EmbeddedActivityItem(embeddedActivity, participants, application);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallParticipantsAdapter$ListItem$EmbeddedActivityItem)) {
            return false;
        }
        CallParticipantsAdapter$ListItem$EmbeddedActivityItem callParticipantsAdapter$ListItem$EmbeddedActivityItem = (CallParticipantsAdapter$ListItem$EmbeddedActivityItem) other;
        return m.areEqual(this.embeddedActivity, callParticipantsAdapter$ListItem$EmbeddedActivityItem.embeddedActivity) && m.areEqual(this.participants, callParticipantsAdapter$ListItem$EmbeddedActivityItem.participants) && m.areEqual(this.application, callParticipantsAdapter$ListItem$EmbeddedActivityItem.application);
    }

    public final Application getApplication() {
        return this.application;
    }

    public final EmbeddedActivity getEmbeddedActivity() {
        return this.embeddedActivity;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final List<UserGuildMember> getParticipants() {
        return this.participants;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        EmbeddedActivity embeddedActivity = this.embeddedActivity;
        int iHashCode = (embeddedActivity != null ? embeddedActivity.hashCode() : 0) * 31;
        List<UserGuildMember> list = this.participants;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        Application application = this.application;
        return iHashCode2 + (application != null ? application.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("EmbeddedActivityItem(embeddedActivity=");
        sbU.append(this.embeddedActivity);
        sbU.append(", participants=");
        sbU.append(this.participants);
        sbU.append(", application=");
        sbU.append(this.application);
        sbU.append(")");
        return sbU.toString();
    }
}
