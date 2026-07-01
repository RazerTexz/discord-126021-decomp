package com.discord.widgets.friends;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetFriendsAdd.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsAdd$Companion {
    private WidgetFriendsAdd$Companion() {
    }

    public static /* synthetic */ void show$default(WidgetFriendsAdd$Companion widgetFriendsAdd$Companion, Context context, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        widgetFriendsAdd$Companion.show(context, str, str2);
    }

    public final void show(Context context, String str) {
        show$default(this, context, null, str, 2, null);
    }

    public final void show(Context context, String query, String source) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(source, "source");
        AnalyticsTracker.openModal$default("Add Friend Modal", source, null, 4, null);
        Intent intent = new Intent();
        intent.putExtra("android.intent.extra.TEXT", query);
        j.d(context, WidgetFriendsAdd.class, intent);
    }

    public /* synthetic */ WidgetFriendsAdd$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
