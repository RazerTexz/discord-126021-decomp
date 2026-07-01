package com.discord.widgets.servers.member_verification;

import b.d.b.a.a;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreNotices$Notice;
import com.discord.stores.StoreStream;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.t.m;
import d0.z.d.a0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MemberVerificationSuccessDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationSuccessDialog$Companion {
    private MemberVerificationSuccessDialog$Companion() {
    }

    public final void enqueue(long guildId) {
        StoreNotices notices = StoreStream.Companion.getNotices();
        String strT = a.t("GUILD_JOIN_REQUEST_SUCCESS_", guildId);
        notices.requestToShow(new StoreNotices$Notice(strT, null, 0L, 0, false, m.listOf(a0.getOrCreateKotlinClass(WidgetHome.class)), 0L, false, 0L, new MemberVerificationSuccessDialog$Companion$enqueue$memberVerificationSuccessDialogNotice$1(guildId, notices, strT), 150, null));
    }

    public /* synthetic */ MemberVerificationSuccessDialog$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
