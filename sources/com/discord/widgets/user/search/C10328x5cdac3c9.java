package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.permissions.PermissionUtils;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.user.search.WidgetGlobalSearchModel$Companion$DEFAULT_PERMISSIONS_PREDICATE$1 */
/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C10328x5cdac3c9 extends AbstractC12240o implements Function2<Channel, Map<Long, ? extends Long>, Boolean> {
    public static final C10328x5cdac3c9 INSTANCE = new C10328x5cdac3c9();

    public C10328x5cdac3c9() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(Channel channel, Map<Long, ? extends Long> map) {
        return Boolean.valueOf(invoke2(channel, (Map<Long, Long>) map));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Channel channel, Map<Long, Long> map) {
        C12238m.checkNotNullParameter(channel, "channel");
        C12238m.checkNotNullParameter(map, ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS);
        return PermissionUtils.hasAccess(channel, map);
    }
}
