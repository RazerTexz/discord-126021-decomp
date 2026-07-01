package com.discord.widgets.chat.list;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PublishActionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PublishActionDialog$Companion {
    private PublishActionDialog$Companion() {
    }

    public static /* synthetic */ void show$default(PublishActionDialog$Companion publishActionDialog$Companion, FragmentManager fragmentManager, long j, long j2, Function0 function0, Integer num, int i, Object obj) {
        publishActionDialog$Companion.show(fragmentManager, j, j2, function0, (i & 16) != 0 ? null : num);
    }

    public final void show(FragmentManager fragmentManager, long messageId, long channelId, Function0<Unit> onSuccess, Integer dialogTheme) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        PublishActionDialog publishActionDialog = new PublishActionDialog();
        if (onSuccess != null) {
            PublishActionDialog.access$setOnSuccess$p(publishActionDialog, onSuccess);
        }
        Bundle bundleT = a.T("com.discord.intent.extra.EXTRA_MESSAGE_ID", messageId);
        bundleT.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
        if (dialogTheme != null) {
            bundleT.putInt("theme_id", dialogTheme.intValue());
        }
        publishActionDialog.setArguments(bundleT);
        publishActionDialog.show(fragmentManager, PublishActionDialog.class.getName());
    }

    public /* synthetic */ PublishActionDialog$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
