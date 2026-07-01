package com.discord.widgets.channels.memberlist;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelMembersListViewModel$Event$Error extends WidgetChannelMembersListViewModel$Event {
    private final int code;

    public WidgetChannelMembersListViewModel$Event$Error(int i) {
        super(null);
        this.code = i;
    }

    public static /* synthetic */ WidgetChannelMembersListViewModel$Event$Error copy$default(WidgetChannelMembersListViewModel$Event$Error widgetChannelMembersListViewModel$Event$Error, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetChannelMembersListViewModel$Event$Error.code;
        }
        return widgetChannelMembersListViewModel$Event$Error.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    public final WidgetChannelMembersListViewModel$Event$Error copy(int code) {
        return new WidgetChannelMembersListViewModel$Event$Error(code);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetChannelMembersListViewModel$Event$Error) && this.code == ((WidgetChannelMembersListViewModel$Event$Error) other).code;
        }
        return true;
    }

    public final int getCode() {
        return this.code;
    }

    public int hashCode() {
        return this.code;
    }

    public String toString() {
        return a.B(a.U("Error(code="), this.code, ")");
    }
}
