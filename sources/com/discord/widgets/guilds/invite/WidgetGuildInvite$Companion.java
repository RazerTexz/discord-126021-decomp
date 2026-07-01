package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.stores.StoreInviteSettings$InviteCode;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInvite$Companion {
    private WidgetGuildInvite$Companion() {
    }

    public final void launch(Context context, StoreInviteSettings$InviteCode inviteCode) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(inviteCode, "inviteCode");
        Intent intent = new Intent();
        intent.putExtra("EXTRA_CODE", inviteCode);
        j.d(context, WidgetGuildInvite.class, intent);
    }

    public /* synthetic */ WidgetGuildInvite$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
