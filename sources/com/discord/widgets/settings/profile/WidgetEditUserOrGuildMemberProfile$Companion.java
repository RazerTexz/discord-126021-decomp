package com.discord.widgets.settings.profile;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.app.AppTransitionActivity$Transition;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile$Companion {
    private WidgetEditUserOrGuildMemberProfile$Companion() {
    }

    public static /* synthetic */ void launch$default(WidgetEditUserOrGuildMemberProfile$Companion widgetEditUserOrGuildMemberProfile$Companion, Context context, AppTransitionActivity$Transition appTransitionActivity$Transition, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            appTransitionActivity$Transition = null;
        }
        if ((i & 4) != 0) {
            l = null;
        }
        widgetEditUserOrGuildMemberProfile$Companion.launch(context, appTransitionActivity$Transition, l);
    }

    public final void launch(Context context, AppTransitionActivity$Transition transition, Long guildId) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        if (transition != null) {
            intent.putExtra("transition", transition);
        }
        if (guildId != null) {
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId.longValue());
        }
        j.d(context, WidgetEditUserOrGuildMemberProfile.class, intent);
        StoreAnalytics.onUserSettingsPaneViewed$default(StoreStream.Companion.getAnalytics(), "User Profile", null, 2, null);
    }

    public /* synthetic */ WidgetEditUserOrGuildMemberProfile$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
