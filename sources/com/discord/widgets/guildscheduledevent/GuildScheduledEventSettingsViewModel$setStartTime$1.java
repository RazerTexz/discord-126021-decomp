package com.discord.widgets.guildscheduledevent;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildScheduledEventSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventSettingsViewModel$setStartTime$1 extends o implements Function1<GuildScheduledEventModel, GuildScheduledEventModel> {
    public final /* synthetic */ GuildScheduledEventPickerTime $newStartTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventSettingsViewModel$setStartTime$1(GuildScheduledEventPickerTime guildScheduledEventPickerTime) {
        super(1);
        this.$newStartTime = guildScheduledEventPickerTime;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ GuildScheduledEventModel invoke(GuildScheduledEventModel guildScheduledEventModel) {
        return invoke2(guildScheduledEventModel);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final GuildScheduledEventModel invoke2(GuildScheduledEventModel guildScheduledEventModel) {
        m.checkNotNullParameter(guildScheduledEventModel, "$receiver");
        return GuildScheduledEventModel.copy$default(guildScheduledEventModel, 0L, null, null, null, null, this.$newStartTime, null, null, null, null, null, null, null, 8159, null);
    }
}
