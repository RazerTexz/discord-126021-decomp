package com.discord.widgets.guilds.invite;

import d0.z.d.k;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ViewInviteSettingsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ViewInviteSettingsSheet$2 extends k implements Function1<Integer, String> {
    public ViewInviteSettingsSheet$2(ViewInviteSettingsSheet viewInviteSettingsSheet) {
        super(1, viewInviteSettingsSheet, ViewInviteSettingsSheet.class, "getMaxUsesString", "getMaxUsesString(I)Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final String invoke(int i) {
        return ViewInviteSettingsSheet.access$getMaxUsesString((ViewInviteSettingsSheet) this.receiver, i);
    }
}
