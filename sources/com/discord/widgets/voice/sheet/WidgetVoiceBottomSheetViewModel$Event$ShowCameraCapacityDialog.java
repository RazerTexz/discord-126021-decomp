package com.discord.widgets.voice.sheet;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetVoiceBottomSheetViewModel$Event$ShowCameraCapacityDialog extends WidgetVoiceBottomSheetViewModel$Event {
    private final int guildMaxVideoChannelUsers;

    public WidgetVoiceBottomSheetViewModel$Event$ShowCameraCapacityDialog(int i) {
        super(null);
        this.guildMaxVideoChannelUsers = i;
    }

    public static /* synthetic */ WidgetVoiceBottomSheetViewModel$Event$ShowCameraCapacityDialog copy$default(WidgetVoiceBottomSheetViewModel$Event$ShowCameraCapacityDialog widgetVoiceBottomSheetViewModel$Event$ShowCameraCapacityDialog, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetVoiceBottomSheetViewModel$Event$ShowCameraCapacityDialog.guildMaxVideoChannelUsers;
        }
        return widgetVoiceBottomSheetViewModel$Event$ShowCameraCapacityDialog.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getGuildMaxVideoChannelUsers() {
        return this.guildMaxVideoChannelUsers;
    }

    public final WidgetVoiceBottomSheetViewModel$Event$ShowCameraCapacityDialog copy(int guildMaxVideoChannelUsers) {
        return new WidgetVoiceBottomSheetViewModel$Event$ShowCameraCapacityDialog(guildMaxVideoChannelUsers);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetVoiceBottomSheetViewModel$Event$ShowCameraCapacityDialog) && this.guildMaxVideoChannelUsers == ((WidgetVoiceBottomSheetViewModel$Event$ShowCameraCapacityDialog) other).guildMaxVideoChannelUsers;
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
