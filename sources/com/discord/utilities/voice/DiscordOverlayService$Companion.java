package com.discord.utilities.voice;

import android.content.Context;
import android.content.Intent;
import com.discord.app.AppLog;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: DiscordOverlayService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DiscordOverlayService$Companion {
    private DiscordOverlayService$Companion() {
    }

    public static final /* synthetic */ Intent access$createOverlayIntent(DiscordOverlayService$Companion discordOverlayService$Companion, Context context, String str) {
        return discordOverlayService$Companion.createOverlayIntent(context, str);
    }

    private final Intent createOverlayIntent(Context context, String action) {
        return new Intent(action, null, context, DiscordOverlayService.class);
    }

    private final void tryStartOverlayService(Context context, String action, boolean checkEnabled) {
        if (StoreStream.Companion.getUserSettings().getIsMobileOverlayEnabled() || !checkEnabled) {
            try {
                context.startService(createOverlayIntent(context, action));
            } catch (Exception e) {
                AppLog.g.v("OverlayService", "Overlay request failed.", e);
            }
        }
    }

    public static /* synthetic */ void tryStartOverlayService$default(DiscordOverlayService$Companion discordOverlayService$Companion, Context context, String str, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        discordOverlayService$Companion.tryStartOverlayService(context, str, z2);
    }

    public final void launchForClose(Context context) {
        m.checkNotNullParameter(context, "context");
        tryStartOverlayService(context, "com.discord.actions.OVERLAY_CLOSE", false);
    }

    public final void launchForConnect(Context context) {
        m.checkNotNullParameter(context, "context");
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        if (!storeStream$Companion.getUserSettings().getIsMobileOverlayEnabled()) {
            b.a.d.m.g(context, 2131893574, 1, null, 8);
            return;
        }
        WeakReference weakReference = new WeakReference(context);
        Observable observableG = ObservableExtensionsKt.takeSingleUntilTimeout$default(storeStream$Companion.getRtcConnection().getConnectionState(), 1000L, false, 2, null).G(DiscordOverlayService$Companion$launchForConnect$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "StoreStream\n            …          }\n            }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableG), DiscordOverlayService.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new DiscordOverlayService$Companion$launchForConnect$2(weakReference), 60, (Object) null);
    }

    public final void launchForVoice(Context context) {
        m.checkNotNullParameter(context, "context");
        tryStartOverlayService$default(this, context, "com.discord.actions.OVERLAY_VOICE", false, 4, null);
    }

    public final void launchForVoiceChannelSelect(Context context) {
        m.checkNotNullParameter(context, "context");
        tryStartOverlayService$default(this, context, "com.discord.actions.OVERLAY_SELECTOR", false, 4, null);
    }

    public /* synthetic */ DiscordOverlayService$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
