package com.discord.widgets.guildscheduledevent;

import b.d.b.a.a;
import java.io.Serializable;

/* JADX INFO: compiled from: GuildScheduledEventPickerDateTime.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventPickerTime implements Serializable {
    private final int hourOfDay;
    private final int minute;
    private final int second;

    public GuildScheduledEventPickerTime(int i, int i2, int i3) {
        this.hourOfDay = i;
        this.minute = i2;
        this.second = i3;
    }

    public static /* synthetic */ GuildScheduledEventPickerTime copy$default(GuildScheduledEventPickerTime guildScheduledEventPickerTime, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = guildScheduledEventPickerTime.hourOfDay;
        }
        if ((i4 & 2) != 0) {
            i2 = guildScheduledEventPickerTime.minute;
        }
        if ((i4 & 4) != 0) {
            i3 = guildScheduledEventPickerTime.second;
        }
        return guildScheduledEventPickerTime.copy(i, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getHourOfDay() {
        return this.hourOfDay;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMinute() {
        return this.minute;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSecond() {
        return this.second;
    }

    public final GuildScheduledEventPickerTime copy(int hourOfDay, int minute, int second) {
        return new GuildScheduledEventPickerTime(hourOfDay, minute, second);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventPickerTime)) {
            return false;
        }
        GuildScheduledEventPickerTime guildScheduledEventPickerTime = (GuildScheduledEventPickerTime) other;
        return this.hourOfDay == guildScheduledEventPickerTime.hourOfDay && this.minute == guildScheduledEventPickerTime.minute && this.second == guildScheduledEventPickerTime.second;
    }

    public final int getHourOfDay() {
        return this.hourOfDay;
    }

    public final int getMinute() {
        return this.minute;
    }

    public final int getSecond() {
        return this.second;
    }

    public int hashCode() {
        return (((this.hourOfDay * 31) + this.minute) * 31) + this.second;
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildScheduledEventPickerTime(hourOfDay=");
        sbU.append(this.hourOfDay);
        sbU.append(", minute=");
        sbU.append(this.minute);
        sbU.append(", second=");
        return a.B(sbU, this.second, ")");
    }
}
