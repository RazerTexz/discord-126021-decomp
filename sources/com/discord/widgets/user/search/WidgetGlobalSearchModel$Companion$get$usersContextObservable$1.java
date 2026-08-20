package com.discord.widgets.user.search;

import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import java.util.Map;
import kotlin.jvm.functions.Function4;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetGlobalSearchModel$Companion$get$usersContextObservable$1 extends C12236k implements Function4<Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<Long, ? extends Integer>, Map<Long, ? extends Map<Long, ? extends GuildMember>>, WidgetGlobalSearchModel.UsersContext> {
    public static final WidgetGlobalSearchModel$Companion$get$usersContextObservable$1 INSTANCE = new WidgetGlobalSearchModel$Companion$get$usersContextObservable$1();

    public WidgetGlobalSearchModel$Companion$get$usersContextObservable$1() {
        super(4, WidgetGlobalSearchModel.UsersContext.class, "<init>", "<init>(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel.UsersContext invoke(Map<Long, ? extends User> map, Map<Long, ? extends Presence> map2, Map<Long, ? extends Integer> map3, Map<Long, ? extends Map<Long, ? extends GuildMember>> map4) {
        return invoke2(map, (Map<Long, Presence>) map2, (Map<Long, Integer>) map3, (Map<Long, ? extends Map<Long, GuildMember>>) map4);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel.UsersContext invoke2(Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, Integer> map3, Map<Long, ? extends Map<Long, GuildMember>> map4) {
        C12238m.checkNotNullParameter(map, "p1");
        C12238m.checkNotNullParameter(map2, "p2");
        C12238m.checkNotNullParameter(map3, "p3");
        C12238m.checkNotNullParameter(map4, "p4");
        return new WidgetGlobalSearchModel.UsersContext(map, map2, map3, map4);
    }
}
