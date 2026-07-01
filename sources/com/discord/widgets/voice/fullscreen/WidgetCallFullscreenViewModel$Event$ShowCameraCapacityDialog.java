package com.discord.widgets.voice.fullscreen;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetCallFullscreenViewModel$Event$ShowCameraCapacityDialog extends WidgetCallFullscreenViewModel$Event {
    private final int guildMaxVideoChannelUsers;

    public WidgetCallFullscreenViewModel$Event$ShowCameraCapacityDialog(int i) {
        super(null);
        this.guildMaxVideoChannelUsers = i;
    }

    public static /* synthetic */ WidgetCallFullscreenViewModel$Event$ShowCameraCapacityDialog copy$default(WidgetCallFullscreenViewModel$Event$ShowCameraCapacityDialog widgetCallFullscreenViewModel$Event$ShowCameraCapacityDialog, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetCallFullscreenViewModel$Event$ShowCameraCapacityDialog.guildMaxVideoChannelUsers;
        }
        return widgetCallFullscreenViewModel$Event$ShowCameraCapacityDialog.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getGuildMaxVideoChannelUsers() {
        return this.guildMaxVideoChannelUsers;
    }

    public final WidgetCallFullscreenViewModel$Event$ShowCameraCapacityDialog copy(int guildMaxVideoChannelUsers) {
        return new WidgetCallFullscreenViewModel$Event$ShowCameraCapacityDialog(guildMaxVideoChannelUsers);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetCallFullscreenViewModel$Event$ShowCameraCapacityDialog) && this.guildMaxVideoChannelUsers == ((WidgetCallFullscreenViewModel$Event$ShowCameraCapacityDialog) other).guildMaxVideoChannelUsers;
        }
        return true;
    }

    public final int getGuildMaxVideoChannelUsers() {
        return this.guildMaxVideoChannelUsers;
    }

    public int hashCode() {
        return this.guildMaxVideoChannelUsers;
    }

    public String toString() {
        return a.B(a.U("ShowCameraCapacityDialog(guildMaxVideoChannelUsers="), this.guildMaxVideoChannelUsers, ")");
    }
}
