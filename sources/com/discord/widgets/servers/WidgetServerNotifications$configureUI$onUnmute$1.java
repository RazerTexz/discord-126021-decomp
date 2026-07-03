package com.discord.widgets.servers;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserGuildSettings;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetServerNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotifications$configureUI$onUnmute$1 extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ WidgetServerNotifications this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerNotifications$configureUI$onUnmute$1(WidgetServerNotifications widgetServerNotifications, long j) {
        super(0);
        this.this$0 = widgetServerNotifications;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreUserGuildSettings.setGuildMuted$default(StoreStream.INSTANCE.getUserGuildSettings(), this.this$0.requireContext(), this.$guildId, false, null, 8, null);
    }
}
