package com.discord.widgets.guildscheduledevent;

import b.d.b.a.outline;
import java.io.Serializable;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventPickerTime, reason: use source file name */
/* JADX INFO: compiled from: GuildScheduledEventPickerDateTime.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventPickerDateTime3 implements Serializable {
    private final int hourOfDay;
    private final int minute;
    private final int second;

    public GuildScheduledEventPickerDateTime3(int i, int i2, int i3) {
        this.hourOfDay = i;
        this.minute = i2;
        this.second = i3;
    }

    public static /* synthetic */ GuildScheduledEventPickerDateTime3 copy$default(GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = guildScheduledEventPickerDateTime3.hourOfDay;
        }
        if ((i4 & 2) != 0) {
            i2 = guildScheduledEventPickerDateTime3.minute;
        }
        if ((i4 & 4) != 0) {
            i3 = guildScheduledEventPickerDateTime3.second;
        }
        return guildScheduledEventPickerDateTime3.copy(i, i2, i3);
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

    public final GuildScheduledEventPickerDateTime3 copy(int hourOfDay, int minute, int second) {
        return new GuildScheduledEventPickerDateTime3(hourOfDay, minute, second);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventPickerDateTime3)) {
            return false;
        }
        GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3 = (GuildScheduledEventPickerDateTime3) other;
        return this.hourOfDay == guildScheduledEventPickerDateTime3.hourOfDay && this.minute == guildScheduledEventPickerDateTime3.minute && this.second == guildScheduledEventPickerDateTime3.second;
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
        StringBuilder sbU = outline.U("GuildScheduledEventPickerTime(hourOfDay=");
        sbU.append(this.hourOfDay);
        sbU.append(", minute=");
        sbU.append(this.minute);
        sbU.append(", second=");
        return outline.B(sbU, this.second, ")");
    }
}
