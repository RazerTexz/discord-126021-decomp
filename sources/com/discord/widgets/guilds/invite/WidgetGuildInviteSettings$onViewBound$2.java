package com.discord.widgets.guilds.invite;

import d0.z.d.k;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildInviteSettings$onViewBound$2 extends k implements Function1<Integer, String> {
    public WidgetGuildInviteSettings$onViewBound$2(WidgetGuildInviteSettings widgetGuildInviteSettings) {
        super(1, widgetGuildInviteSettings, WidgetGuildInviteSettings.class, "getMaxUsesString", "getMaxUsesString(I)Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final String invoke(int i) {
        return WidgetGuildInviteSettings.access$getMaxUsesString((WidgetGuildInviteSettings) this.receiver, i);
    }
}
