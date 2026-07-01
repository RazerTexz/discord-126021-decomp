package com.discord.widgets.channels;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import b.a.d.j;
import com.discord.app.AppFragment;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetCreateChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateChannel$Companion {
    private WidgetCreateChannel$Companion() {
    }

    public static /* synthetic */ void launch$default(WidgetCreateChannel$Companion widgetCreateChannel$Companion, Context context, ActivityResultLauncher activityResultLauncher, long j, int i, Long l, boolean z2, boolean z3, boolean z4, boolean z5, int i2, Object obj) {
        widgetCreateChannel$Companion.launch(context, activityResultLauncher, j, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? null : l, (i2 & 32) != 0 ? false : z2, (i2 & 64) != 0 ? false : z3, (i2 & 128) != 0 ? false : z4, (i2 & 256) != 0 ? false : z5);
    }

    public static /* synthetic */ void show$default(WidgetCreateChannel$Companion widgetCreateChannel$Companion, Context context, long j, int i, Long l, int i2, Object obj) {
        int i3 = (i2 & 4) != 0 ? 0 : i;
        if ((i2 & 8) != 0) {
            l = null;
        }
        widgetCreateChannel$Companion.show(context, j, i3, l);
    }

    public final void launch(Context context, ActivityResultLauncher<Intent> launcher, long guildId, int type, Long categoryId, boolean shouldChannelDefaultPrivate, boolean provideResultOnly, boolean disablePrivateSwitch, boolean disableAnnouncementChannelType) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(launcher, "launcher");
        j jVar = j.g;
        Intent intent = new Intent();
        intent.putExtra("INTENT_GUILD_ID", guildId);
        intent.putExtra("INTENT_TYPE", type);
        intent.putExtra("INTENT_CATEGORY_ID", categoryId);
        intent.putExtra("INTENT_PROVIDE_RESULT_ONLY", provideResultOnly);
        intent.putExtra("INTENT_SHOULD_CHANNEL_DEFAULT_PRIVATE", shouldChannelDefaultPrivate);
        intent.putExtra("INTENT_DISABLE_PRIVATE_SWITCH", disablePrivateSwitch);
        intent.putExtra("INTENT_DISABLE_ANNOUNCEMENT_CHANNEL_TYPE", disableAnnouncementChannelType);
        jVar.f(context, launcher, WidgetCreateChannel.class, intent);
    }

    public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function3<? super Long, ? super String, ? super Integer, Unit> callback) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(callback, "callback");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new WidgetCreateChannel$Companion$registerForResult$1(callback));
        m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
        return activityResultLauncherRegisterForActivityResult;
    }

    public final void show(Context context, long guildId, int type, Long categoryId) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("INTENT_GUILD_ID", guildId);
        intent.putExtra("INTENT_TYPE", type);
        intent.putExtra("INTENT_CATEGORY_ID", categoryId);
        j.d(context, WidgetCreateChannel.class, intent);
    }

    public /* synthetic */ WidgetCreateChannel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
