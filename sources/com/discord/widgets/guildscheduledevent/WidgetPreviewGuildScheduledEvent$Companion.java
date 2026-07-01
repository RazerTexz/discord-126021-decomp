package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.fragment.app.Fragment;
import b.a.d.j;
import com.discord.app.AppTransitionActivity$Transition;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetPreviewGuildScheduledEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPreviewGuildScheduledEvent$Companion {
    private WidgetPreviewGuildScheduledEvent$Companion() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void launch$default(WidgetPreviewGuildScheduledEvent$Companion widgetPreviewGuildScheduledEvent$Companion, Context context, GuildScheduledEventModel guildScheduledEventModel, WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData widgetPreviewGuildScheduledEvent$Companion$ExistingEventData, ActivityResultLauncher activityResultLauncher, boolean z2, int i, Object obj) {
        widgetPreviewGuildScheduledEvent$Companion.launch(context, guildScheduledEventModel, (i & 4) != 0 ? null : widgetPreviewGuildScheduledEvent$Companion$ExistingEventData, (i & 8) != 0 ? null : activityResultLauncher, (i & 16) != 0 ? false : z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActivityResultLauncher registerForResult$default(WidgetPreviewGuildScheduledEvent$Companion widgetPreviewGuildScheduledEvent$Companion, Fragment fragment, Function3 function3, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        return widgetPreviewGuildScheduledEvent$Companion.registerForResult(fragment, function3, function0);
    }

    public final ActivityResultLauncher<Intent> createJoinOnStartActivityRegistration(Fragment fragment, Function0<Unit> onEventStarted) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(onEventStarted, "onEventStarted");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new WidgetPreviewGuildScheduledEvent$Companion$createJoinOnStartActivityRegistration$1(fragment, onEventStarted));
        m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…entStarted)\n      }\n    }");
        return activityResultLauncherRegisterForActivityResult;
    }

    public final void launch(Context context, GuildScheduledEventModel eventModel, WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData existingEventData, ActivityResultLauncher<Intent> launcher, boolean fromSettings) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(eventModel, "eventModel");
        Intent intent = new Intent();
        intent.putExtra("INTENT_EXTRA_EVENT_MODEL", eventModel);
        if (existingEventData != null) {
            intent.putExtra("INTENT_EXTRA_EXISTING_EVENT_DATA", existingEventData);
        }
        if (fromSettings) {
            intent.putExtra("transition", AppTransitionActivity$Transition.TYPE_SLIDE_HORIZONTAL);
        }
        if (launcher != null) {
            j.g.f(context, launcher, WidgetPreviewGuildScheduledEvent.class, intent);
        } else {
            j.d(context, WidgetPreviewGuildScheduledEvent.class, intent);
        }
    }

    public final ActivityResultLauncher<Intent> registerForResult(Fragment fragment, Function3<? super Long, ? super Long, ? super Boolean, Unit> onEventCreated, Function0<Unit> onQuit) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(onEventCreated, "onEventCreated");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new WidgetPreviewGuildScheduledEvent$Companion$registerForResult$1(onEventCreated, onQuit));
        m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
        return activityResultLauncherRegisterForActivityResult;
    }

    public /* synthetic */ WidgetPreviewGuildScheduledEvent$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
