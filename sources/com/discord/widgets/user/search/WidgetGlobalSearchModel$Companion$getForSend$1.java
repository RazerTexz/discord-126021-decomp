package com.discord.widgets.user.search;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.permissions.PermissionUtils;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$getForSend$1 extends o implements Function2<Channel, Map<Long, ? extends Long>, Boolean> {
    public static final WidgetGlobalSearchModel$Companion$getForSend$1 INSTANCE = new WidgetGlobalSearchModel$Companion$getForSend$1();

    public WidgetGlobalSearchModel$Companion$getForSend$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(Channel channel, Map<Long, ? extends Long> map) {
        return Boolean.valueOf(invoke2(channel, (Map<Long, Long>) map));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Channel channel, Map<Long, Long> map) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(map, ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS);
        if (ChannelUtils.G(channel)) {
            PermissionUtils permissionUtils = PermissionUtils.INSTANCE;
            Object objD = a.d(channel, map);
            if (objD == null) {
                objD = 0L;
            }
            if (permissionUtils.hasAccessWrite(channel, (Long) objD)) {
                return true;
            }
        }
        return false;
    }
}
