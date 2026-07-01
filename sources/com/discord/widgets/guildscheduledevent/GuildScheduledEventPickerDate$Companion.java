package com.discord.widgets.guildscheduledevent;

import java.util.Calendar;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildScheduledEventPickerDateTime.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventPickerDate$Companion {
    private GuildScheduledEventPickerDate$Companion() {
    }

    public final GuildScheduledEventPickerDate now() {
        Calendar calendar = Calendar.getInstance();
        return new GuildScheduledEventPickerDate(calendar.get(1), calendar.get(2), calendar.get(5));
    }

    public /* synthetic */ GuildScheduledEventPickerDate$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
