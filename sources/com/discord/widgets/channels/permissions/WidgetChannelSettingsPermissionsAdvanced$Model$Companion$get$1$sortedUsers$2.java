package com.discord.widgets.channels.permissions;

import com.discord.models.user.User;
import com.discord.utilities.user.UserUtils;
import d0.z.d.k;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSettingsPermissionsAdvanced$Model$Companion$get$1$sortedUsers$2 extends k implements Function2<User, User, Integer> {
    public static final WidgetChannelSettingsPermissionsAdvanced$Model$Companion$get$1$sortedUsers$2 INSTANCE = new WidgetChannelSettingsPermissionsAdvanced$Model$Companion$get$1$sortedUsers$2();

    public WidgetChannelSettingsPermissionsAdvanced$Model$Companion$get$1$sortedUsers$2() {
        super(2, UserUtils.class, "compareUserNames", "compareUserNames(Lcom/discord/models/user/User;Lcom/discord/models/user/User;)I", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Integer invoke(User user, User user2) {
        return Integer.valueOf(invoke2(user, user2));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(User user, User user2) {
        return UserUtils.INSTANCE.compareUserNames(user, user2);
    }
}
