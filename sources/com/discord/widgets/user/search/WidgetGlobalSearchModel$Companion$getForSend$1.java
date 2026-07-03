package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.permissions.PermissionUtils;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$getForSend$1 extends AbstractC12240o implements Function2<Channel, Map<Long, ? extends Long>, Boolean> {
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
        C12238m.checkNotNullParameter(channel, "channel");
        C12238m.checkNotNullParameter(map, ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS);
        if (ChannelUtils.m7672G(channel)) {
            PermissionUtils permissionUtils = PermissionUtils.INSTANCE;
            Object objM845d = C1643a.m845d(channel, map);
            if (objM845d == null) {
                objM845d = 0L;
            }
            if (permissionUtils.hasAccessWrite(channel, (Long) objM845d)) {
                return true;
            }
        }
        return false;
    }
}
