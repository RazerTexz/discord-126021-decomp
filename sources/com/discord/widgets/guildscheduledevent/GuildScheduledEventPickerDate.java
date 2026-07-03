package com.discord.widgets.guildscheduledevent;

import java.io.Serializable;
import java.util.Calendar;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildScheduledEventPickerDateTime.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventPickerDate implements Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int dayOfMonth;
    private final int month;
    private final int year;

    /* JADX INFO: compiled from: GuildScheduledEventPickerDateTime.kt */
    public static final class Companion {
        private Companion() {
        }

        public final GuildScheduledEventPickerDate now() {
            Calendar calendar = Calendar.getInstance();
            return new GuildScheduledEventPickerDate(calendar.get(1), calendar.get(2), calendar.get(5));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GuildScheduledEventPickerDate(int i, int i2, int i3) {
        this.year = i;
        this.month = i2;
        this.dayOfMonth = i3;
    }

    public static /* synthetic */ GuildScheduledEventPickerDate copy$default(GuildScheduledEventPickerDate guildScheduledEventPickerDate, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = guildScheduledEventPickerDate.year;
        }
        if ((i4 & 2) != 0) {
            i2 = guildScheduledEventPickerDate.month;
        }
        if ((i4 & 4) != 0) {
            i3 = guildScheduledEventPickerDate.dayOfMonth;
        }
        return guildScheduledEventPickerDate.copy(i, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getYear() {
        return this.year;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMonth() {
        return this.month;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public final GuildScheduledEventPickerDate copy(int year, int month, int dayOfMonth) {
        return new GuildScheduledEventPickerDate(year, month, dayOfMonth);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventPickerDate)) {
            return false;
        }
        GuildScheduledEventPickerDate guildScheduledEventPickerDate = (GuildScheduledEventPickerDate) other;
        return this.year == guildScheduledEventPickerDate.year && this.month == guildScheduledEventPickerDate.month && this.dayOfMonth == guildScheduledEventPickerDate.dayOfMonth;
    }

    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public final int getMonth() {
        return this.month;
    }

    public final int getYear() {
        return this.year;
    }

    public int hashCode() {
        return (((this.year * 31) + this.month) * 31) + this.dayOfMonth;
    }

    public final long toMillis() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(this.year, this.month, this.dayOfMonth, 0, 0);
        C12238m.checkNotNullExpressionValue(calendar, "Calendar.getInstance().a…, dayOfMonth, 0, 0)\n    }");
        return calendar.getTimeInMillis();
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("GuildScheduledEventPickerDate(year=");
        sbM833U.append(this.year);
        sbM833U.append(", month=");
        sbM833U.append(this.month);
        sbM833U.append(", dayOfMonth=");
        return C1643a.m814B(sbM833U, this.dayOfMonth, ")");
    }
}
