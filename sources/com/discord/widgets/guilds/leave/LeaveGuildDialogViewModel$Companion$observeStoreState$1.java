package com.discord.widgets.guilds.leave;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import rx.functions.Func2;

/* JADX INFO: compiled from: LeaveGuildDialogViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LeaveGuildDialogViewModel$Companion$observeStoreState$1<T1, T2, R> implements Func2<Guild, Boolean, LeaveGuildDialogViewModel$StoreState> {
    public static final LeaveGuildDialogViewModel$Companion$observeStoreState$1 INSTANCE = new LeaveGuildDialogViewModel$Companion$observeStoreState$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ LeaveGuildDialogViewModel$StoreState call(Guild guild, Boolean bool) {
        return call2(guild, bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final LeaveGuildDialogViewModel$StoreState call2(Guild guild, Boolean bool) {
        if (guild == null) {
            return LeaveGuildDialogViewModel$StoreState$Invalid.INSTANCE;
        }
        m.checkNotNullExpressionValue(bool, "isLurking");
        return new LeaveGuildDialogViewModel$StoreState$Valid(guild, bool.booleanValue());
    }
}
