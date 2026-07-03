package com.discord.widgets.channels.permissions;

import com.discord.models.user.User;
import com.discord.utilities.user.UserUtils;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.C12236k;

/* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced$Model$Companion$get$1$sortedUsers$2 */
/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C7545x6e0b1e05 extends C12236k implements Function2<User, User, Integer> {
    public static final C7545x6e0b1e05 INSTANCE = new C7545x6e0b1e05();

    public C7545x6e0b1e05() {
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
