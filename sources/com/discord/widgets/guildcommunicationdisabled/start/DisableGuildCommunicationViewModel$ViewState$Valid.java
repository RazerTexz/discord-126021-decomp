package com.discord.widgets.guildcommunicationdisabled.start;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: DisableGuildCommunicationViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class DisableGuildCommunicationViewModel$ViewState$Valid extends DisableGuildCommunicationViewModel$ViewState {
    private final long guildId;
    private final TimeDurationDisabledCommunication selectedDurationOption;
    private final User user;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisableGuildCommunicationViewModel$ViewState$Valid(User user, long j, TimeDurationDisabledCommunication timeDurationDisabledCommunication) {
        super(null);
        m.checkNotNullParameter(timeDurationDisabledCommunication, "selectedDurationOption");
        this.user = user;
        this.guildId = j;
        this.selectedDurationOption = timeDurationDisabledCommunication;
    }

    public static /* synthetic */ DisableGuildCommunicationViewModel$ViewState$Valid copy$default(DisableGuildCommunicationViewModel$ViewState$Valid disableGuildCommunicationViewModel$ViewState$Valid, User user, long j, TimeDurationDisabledCommunication timeDurationDisabledCommunication, int i, Object obj) {
        if ((i & 1) != 0) {
            user = disableGuildCommunicationViewModel$ViewState$Valid.user;
        }
        if ((i & 2) != 0) {
            j = disableGuildCommunicationViewModel$ViewState$Valid.guildId;
        }
        if ((i & 4) != 0) {
            timeDurationDisabledCommunication = disableGuildCommunicationViewModel$ViewState$Valid.selectedDurationOption;
        }
        return disableGuildCommunicationViewModel$ViewState$Valid.copy(user, j, timeDurationDisabledCommunication);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final TimeDurationDisabledCommunication getSelectedDurationOption() {
        return this.selectedDurationOption;
    }

    public final DisableGuildCommunicationViewModel$ViewState$Valid copy(User user, long guildId, TimeDurationDisabledCommunication selectedDurationOption) {
        m.checkNotNullParameter(selectedDurationOption, "selectedDurationOption");
        return new DisableGuildCommunicationViewModel$ViewState$Valid(user, guildId, selectedDurationOption);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DisableGuildCommunicationViewModel$ViewState$Valid)) {
            return false;
        }
        DisableGuildCommunicationViewModel$ViewState$Valid disableGuildCommunicationViewModel$ViewState$Valid = (DisableGuildCommunicationViewModel$ViewState$Valid) other;
        return m.areEqual(this.user, disableGuildCommunicationViewModel$ViewState$Valid.user) && this.guildId == disableGuildCommunicationViewModel$ViewState$Valid.guildId && m.areEqual(this.selectedDurationOption, disableGuildCommunicationViewModel$ViewState$Valid.selectedDurationOption);
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final TimeDurationDisabledCommunication getSelectedDurationOption() {
        return this.selectedDurationOption;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        User user = this.user;
        int iA = (b.a(this.guildId) + ((user != null ? user.hashCode() : 0) * 31)) * 31;
        TimeDurationDisabledCommunication timeDurationDisabledCommunication = this.selectedDurationOption;
        return iA + (timeDurationDisabledCommunication != null ? timeDurationDisabledCommunication.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(user=");
        sbU.append(this.user);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", selectedDurationOption=");
        sbU.append(this.selectedDurationOption);
        sbU.append(")");
        return sbU.toString();
    }
}
