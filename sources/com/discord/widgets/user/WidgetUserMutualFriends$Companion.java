package com.discord.widgets.user;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.models.user.User;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMutualFriends$Companion {
    private WidgetUserMutualFriends$Companion() {
    }

    public final void show(Context context, User user) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(user, "user");
        Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_USER_ID", user.getId());
        m.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(Intents.EXTRA_USER_ID, user.id)");
        j.d(context, WidgetUserMutualFriends.class, intentPutExtra);
    }

    public /* synthetic */ WidgetUserMutualFriends$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
