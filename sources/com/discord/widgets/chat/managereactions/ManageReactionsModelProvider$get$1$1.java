package com.discord.widgets.chat.managereactions;

import androidx.core.app.NotificationCompat;
import com.discord.api.permission.Permission;
import com.discord.models.guild.Guild;
import com.discord.utilities.permissions.PermissionUtils;
import rx.functions.Func2;

/* JADX INFO: compiled from: ManageReactionsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsModelProvider$get$1$1<T1, T2, R> implements Func2<Long, Guild, Boolean> {
    public final /* synthetic */ boolean $isMeMfaEnabled;

    public ManageReactionsModelProvider$get$1$1(boolean z2) {
        this.$isMeMfaEnabled = z2;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Boolean call(Long l, Guild guild) {
        return call2(l, guild);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Long l, Guild guild) {
        return Boolean.valueOf(guild != null && PermissionUtils.canAndIsElevated(Permission.MANAGE_MESSAGES, l, this.$isMeMfaEnabled, guild.getMfaLevel()));
    }
}
