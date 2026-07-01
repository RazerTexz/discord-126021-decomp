package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetCreateChannelAddMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateChannelAddMember$Companion {
    private WidgetCreateChannelAddMember$Companion() {
    }

    public final void create(Context context, long channelId) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
        j.d(context, WidgetCreateChannelAddMember.class, intent);
    }

    public /* synthetic */ WidgetCreateChannelAddMember$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
