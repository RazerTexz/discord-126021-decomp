package com.discord.utilities.voice;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.content.ContextCompat;
import com.discord.app.AppLog;
import com.discord.utilities.extensions.PendingIntentExtensionsKt;
import com.discord.utilities.logging.Logger;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: VoiceEngineForegroundService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceEngineForegroundService$Companion {
    private VoiceEngineForegroundService$Companion() {
    }

    public final Function0<Unit> getOnDisconnect() {
        return VoiceEngineForegroundService.access$getOnDisconnect$cp();
    }

    public final Function0<Unit> getOnToggleSelfDeafen() {
        return VoiceEngineForegroundService.access$getOnToggleSelfDeafen$cp();
    }

    public final Function0<Unit> getOnToggleSelfMute() {
        return VoiceEngineForegroundService.access$getOnToggleSelfMute$cp();
    }

    public final void setOnDisconnect(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        VoiceEngineForegroundService.access$setOnDisconnect$cp(function0);
    }

    public final void setOnToggleSelfDeafen(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        VoiceEngineForegroundService.access$setOnToggleSelfDeafen$cp(function0);
    }

    public final void setOnToggleSelfMute(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        VoiceEngineForegroundService.access$setOnToggleSelfMute$cp(function0);
    }

    public final Intent stageInviteAckIntent(Context context, long channelId, boolean accept) {
        m.checkNotNullParameter(context, "context");
        boolean z2 = ContextCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") == 0;
        if (accept && !z2) {
            Intent intent = new Intent(context, (Class<?>) WidgetCallFullscreen.class);
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            return intent;
        }
        Intent intent2 = new Intent(context, (Class<?>) VoiceEngineForegroundService.class);
        intent2.setAction(accept ? "com.discord.utilities.voice.action.stage_invite_accept" : "com.discord.utilities.voice.action.stage_invite_decline");
        intent2.putExtra("com.discord.utilities.voice.extra.channel_id", channelId);
        return intent2;
    }

    public final PendingIntent stageInviteAckPendingIntent(Context context, long channelId, boolean accept) {
        m.checkNotNullParameter(context, "context");
        PendingIntent service = PendingIntent.getService(context, 0, stageInviteAckIntent(context, channelId, accept), PendingIntentExtensionsKt.immutablePendingIntentFlag(1207959552));
        m.checkNotNullExpressionValue(service, "PendingIntent.getService…AG_UPDATE_CURRENT),\n    )");
        return service;
    }

    public final void startForegroundAndBind(VoiceEngineForegroundService$Connection connection, CharSequence title, CharSequence subtitle, boolean selfMute, boolean selfDeafen, boolean selfStream, long channelId, Long guildId, boolean isProximityLockEnabled, boolean canSpeak) {
        m.checkNotNullParameter(connection, "connection");
        m.checkNotNullParameter(title, "title");
        m.checkNotNullParameter(subtitle, "subtitle");
        try {
            Logger.v$default(AppLog.g, "DiscordVoiceService", "Bind service connection.", null, 4, null);
            Context context = connection.getContext();
            Intent intent = new Intent(connection.getContext(), (Class<?>) VoiceEngineForegroundService.class);
            intent.setAction("com.discord.utilities.voice.action.start_foreground");
            intent.putExtra("com.discord.utilities.voice.extra.title", title);
            intent.putExtra("com.discord.utilities.voice.extra.title_subtext", subtitle);
            intent.putExtra("com.discord.utilities.voice.extra.item_muted", selfMute);
            intent.putExtra("com.discord.utilities.voice.extra.item_deafened", selfDeafen);
            intent.putExtra("com.discord.utilities.voice.extra.item_streaming", selfStream);
            intent.putExtra("com.discord.utilities.voice.extra.item_can_speak", canSpeak);
            intent.putExtra("com.discord.utilities.voice.extra.proximity_lock_enabled", isProximityLockEnabled);
            intent.putExtra("com.discord.utilities.voice.extra.channel_id", channelId);
            intent.putExtra("com.discord.utilities.voice.extra.guild_id", guildId);
            context.startService(intent);
            connection.getContext().bindService(new Intent(connection.getContext(), (Class<?>) VoiceEngineForegroundService.class), connection.getConnection(), 1);
        } catch (Exception e) {
            AppLog.g.v("DiscordVoiceService", "Unable to bind service connection.", e);
        }
    }

    public final void startStream(VoiceEngineForegroundService$Connection connection, Intent permissionIntent) {
        m.checkNotNullParameter(connection, "connection");
        m.checkNotNullParameter(permissionIntent, "permissionIntent");
        Context context = connection.getContext();
        Intent intent = new Intent(context, (Class<?>) VoiceEngineForegroundService.class);
        intent.setAction("com.discord.utilities.voice.action.start_stream");
        intent.putExtra("android.intent.extra.INTENT", permissionIntent);
        context.startService(intent);
    }

    public final void stopForegroundAndUnbind(VoiceEngineForegroundService$Connection connection) {
        m.checkNotNullParameter(connection, "connection");
        try {
            if (connection.getService() == null || connection.isUnbinding()) {
                return;
            }
            Logger.v$default(AppLog.g, "DiscordVoiceService", "Unbind service connection.", null, 4, null);
            connection.setUnbinding(true);
            Context context = connection.getContext();
            Intent intent = new Intent(connection.getContext(), (Class<?>) VoiceEngineForegroundService.class);
            intent.setAction("com.discord.utilities.voice.action.stop");
            context.startService(intent);
            connection.getContext().unbindService(connection.getConnection());
        } catch (Exception e) {
            AppLog.g.v("DiscordVoiceService", "Unable to unbind service connection.", e);
        }
    }

    public final void stopStream(VoiceEngineForegroundService$Connection connection) {
        m.checkNotNullParameter(connection, "connection");
        Context context = connection.getContext();
        Intent intent = new Intent(context, (Class<?>) VoiceEngineForegroundService.class);
        intent.setAction("com.discord.utilities.voice.action.stop_stream");
        context.startService(intent);
    }

    public /* synthetic */ VoiceEngineForegroundService$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
