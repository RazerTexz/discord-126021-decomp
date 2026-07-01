package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.permissions.PermissionUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$DEFAULT_PERMISSIONS_PREDICATE$1 extends Lambda implements Function2<Channel, Map<Long, ? extends Long>, Boolean> {
    public static final WidgetGlobalSearchModel$Companion$DEFAULT_PERMISSIONS_PREDICATE$1 INSTANCE = new WidgetGlobalSearchModel$Companion$DEFAULT_PERMISSIONS_PREDICATE$1();

    public WidgetGlobalSearchModel$Companion$DEFAULT_PERMISSIONS_PREDICATE$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(Channel channel, Map<Long, ? extends Long> map) {
        return Boolean.valueOf(invoke2(channel, (Map<Long, Long>) map));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Channel channel, Map<Long, Long> map) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(map, ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS);
        return PermissionUtils.hasAccess(channel, map);
    }
}
