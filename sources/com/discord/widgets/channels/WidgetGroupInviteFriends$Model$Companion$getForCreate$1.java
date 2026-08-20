package com.discord.widgets.channels;

import com.discord.models.user.User;
import java.util.Collection;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGroupInviteFriends$Model$Companion$getForCreate$1 extends C12236k implements Function2<Collection<? extends User>, String, WidgetGroupInviteFriends.Model.Companion.AddedUsersInput> {
    public static final WidgetGroupInviteFriends$Model$Companion$getForCreate$1 INSTANCE = new WidgetGroupInviteFriends$Model$Companion$getForCreate$1();

    public WidgetGroupInviteFriends$Model$Companion$getForCreate$1() {
        super(2, WidgetGroupInviteFriends.Model.Companion.AddedUsersInput.class, "<init>", "<init>(Ljava/util/Collection;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final WidgetGroupInviteFriends.Model.Companion.AddedUsersInput invoke(Collection<? extends User> collection, String str) {
        C12238m.checkNotNullParameter(collection, "p1");
        C12238m.checkNotNullParameter(str, "p2");
        return new WidgetGroupInviteFriends.Model.Companion.AddedUsersInput(collection, str);
    }
}
