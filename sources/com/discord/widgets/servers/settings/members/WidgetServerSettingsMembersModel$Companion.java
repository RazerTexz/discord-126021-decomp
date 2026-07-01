package com.discord.widgets.servers.settings.members;

import com.discord.api.role.GuildRole;
import com.discord.stores.StoreStream;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsMembersModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsMembersModel$Companion {
    private WidgetServerSettingsMembersModel$Companion() {
    }

    public static final /* synthetic */ Comparator access$sortMembersComparator(WidgetServerSettingsMembersModel$Companion widgetServerSettingsMembersModel$Companion) {
        return widgetServerSettingsMembersModel$Companion.sortMembersComparator();
    }

    public static final /* synthetic */ Map access$sortRoles(WidgetServerSettingsMembersModel$Companion widgetServerSettingsMembersModel$Companion, Map map) {
        return widgetServerSettingsMembersModel$Companion.sortRoles(map);
    }

    private final Comparator<WidgetServerSettingsMembersModel$MemberItem> sortMembersComparator() {
        return WidgetServerSettingsMembersModel$Companion$sortMembersComparator$1.INSTANCE;
    }

    private final Map<Long, GuildRole> sortRoles(Map<Long, GuildRole> guildRoles) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(guildRoles.size());
        ArrayList arrayList = new ArrayList(guildRoles.values());
        Collections.sort(arrayList, RoleUtils.getROLE_COMPARATOR());
        for (Object obj : arrayList) {
            linkedHashMap.put(Long.valueOf(((GuildRole) obj).getId()), obj);
        }
        return linkedHashMap;
    }

    public final Observable<WidgetServerSettingsMembersModel> get(long guildId, Observable<String> filterPublisher, Observable<Long> roleFilterPublisher) {
        m.checkNotNullParameter(filterPublisher, "filterPublisher");
        m.checkNotNullParameter(roleFilterPublisher, "roleFilterPublisher");
        Observable<R> observableY = StoreStream.Companion.getGuilds().observeComputed(guildId).Y(new WidgetServerSettingsMembersModel$Companion$get$1(guildId, filterPublisher, roleFilterPublisher));
        m.checkNotNullExpressionValue(observableY, "StoreStream\n            …          }\n            }");
        Observable<WidgetServerSettingsMembersModel> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
        m.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetServerSettingsMembersModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
