package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.fragment.app.Fragment;
import b.a.d.j;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$Companion {
    private WidgetGuildScheduledEventSettings$Companion() {
    }

    public final void launch(Context context, ActivityResultLauncher<Intent> launcher, long guildId, GuildScheduledEventEntityType entityType, Long channelId, String externalLocation, Long existingGuildScheduledEventId) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(launcher, "launcher");
        m.checkNotNullParameter(entityType, "entityType");
        Intent intent = new Intent();
        intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        intent.putExtra("EXTRA_ENTITY_TYPE", entityType);
        if (channelId != null) {
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId.longValue());
        }
        if (externalLocation != null) {
            intent.putExtra("EXTRA_EXTERNAL_LOCATION", externalLocation);
        }
        if (existingGuildScheduledEventId != null) {
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", existingGuildScheduledEventId.longValue());
        }
        j.g.f(context, launcher, WidgetGuildScheduledEventSettings.class, intent);
    }

    public final ActivityResultLauncher<Intent> registerForResult(Fragment fragment, Function0<Unit> onFinished, Function0<Unit> onQuit) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(onFinished, "onFinished");
        m.checkNotNullParameter(onQuit, "onQuit");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new WidgetGuildScheduledEventSettings$Companion$registerForResult$1(onFinished, onQuit));
        m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
        return activityResultLauncherRegisterForActivityResult;
    }

    public /* synthetic */ WidgetGuildScheduledEventSettings$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
