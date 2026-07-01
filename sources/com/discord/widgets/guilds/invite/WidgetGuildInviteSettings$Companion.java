package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.fragment.app.DialogFragment;
import b.a.d.j;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteSettings$Companion {
    private WidgetGuildInviteSettings$Companion() {
    }

    public final void launch(Context context, ActivityResultLauncher<Intent> launcher, Long channelId, long guildId, String source) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(launcher, "launcher");
        m.checkNotNullParameter(source, "source");
        AnalyticsTracker.openModal$default("Link Settings", source, null, 4, null);
        Intent intent = new Intent();
        if (channelId != null) {
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId.longValue());
        }
        intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        j.g.f(context, launcher, WidgetGuildInviteSettings.class, intent);
    }

    public final ActivityResultLauncher<Intent> registerForResult(DialogFragment fragment, Function1<? super GuildInvite, Unit> callback) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(callback, "callback");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new WidgetGuildInviteSettings$Companion$registerForResult$1(callback));
        m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
        return activityResultLauncherRegisterForActivityResult;
    }

    public /* synthetic */ WidgetGuildInviteSettings$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
