package com.discord.widgets.channels;

import com.discord.models.user.User;
import d0.z.d.k;
import d0.z.d.m;
import java.util.Collection;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGroupInviteFriends$Model$Companion$getForAdd$1$1 extends k implements Function2<Collection<? extends User>, String, WidgetGroupInviteFriends$Model$Companion$AddedUsersInput> {
    public static final WidgetGroupInviteFriends$Model$Companion$getForAdd$1$1 INSTANCE = new WidgetGroupInviteFriends$Model$Companion$getForAdd$1$1();

    public WidgetGroupInviteFriends$Model$Companion$getForAdd$1$1() {
        super(2, WidgetGroupInviteFriends$Model$Companion$AddedUsersInput.class, "<init>", "<init>(Ljava/util/Collection;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ WidgetGroupInviteFriends$Model$Companion$AddedUsersInput invoke(Collection<? extends User> collection, String str) {
        return invoke2(collection, str);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGroupInviteFriends$Model$Companion$AddedUsersInput invoke2(Collection<? extends User> collection, String str) {
        m.checkNotNullParameter(collection, "p1");
        m.checkNotNullParameter(str, "p2");
        return new WidgetGroupInviteFriends$Model$Companion$AddedUsersInput(collection, str);
    }
}
