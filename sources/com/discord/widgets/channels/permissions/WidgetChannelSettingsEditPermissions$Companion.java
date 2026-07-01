package com.discord.widgets.channels.permissions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import android.widget.TextView$BufferType;
import androidx.annotation.AttrRes;
import androidx.annotation.IdRes;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.a.d.j;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.api.permission.Permission;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.spans.TypefaceSpanCompat;
import com.discord.widgets.search.WidgetSearch;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelSettingsEditPermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsEditPermissions$Companion {
    private WidgetChannelSettingsEditPermissions$Companion() {
    }

    public static final /* synthetic */ long access$getPermission(WidgetChannelSettingsEditPermissions$Companion widgetChannelSettingsEditPermissions$Companion, int i) {
        return widgetChannelSettingsEditPermissions$Companion.getPermission(i);
    }

    public static final /* synthetic */ void access$setTextWithFont(WidgetChannelSettingsEditPermissions$Companion widgetChannelSettingsEditPermissions$Companion, TextView textView, String str, int i) {
        widgetChannelSettingsEditPermissions$Companion.setTextWithFont(textView, str, i);
    }

    private final void create(Context context, long guildId, long channelId, long targetId, int type) {
        Intent intent = new Intent();
        intent.putExtra(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, guildId);
        intent.putExtra("INTENT_EXTRA_CHANNEL_ID", channelId);
        intent.putExtra(WidgetSearch.INTENT_EXTRA_TARGET_ID, targetId);
        intent.putExtra("INTENT_EXTRA_TYPE", type);
        j.d(context, WidgetChannelSettingsEditPermissions.class, intent);
    }

    @SuppressLint({"NonConstantResourceId"})
    private final long getPermission(@IdRes int permissionSettingId) {
        switch (permissionSettingId) {
            case R$id.channel_permission_events_manage_events /* 2131362385 */:
                return Permission.MANAGE_EVENTS;
            case R$id.channel_permission_general_create_instant_invite /* 2131362386 */:
                return 1L;
            case R$id.channel_permission_general_manage_channel /* 2131362387 */:
                return 16L;
            case R$id.channel_permission_general_manage_permissions /* 2131362388 */:
                return Permission.MANAGE_ROLES;
            case R$id.channel_permission_general_manage_threads /* 2131362389 */:
                return Permission.MANAGE_THREADS;
            case R$id.channel_permission_general_manage_webhooks /* 2131362390 */:
                return Permission.MANAGE_WEBHOOKS;
            case R$id.channel_permission_owner_view /* 2131362391 */:
            default:
                throw new IllegalArgumentException(a.q("Invalid ID: ", permissionSettingId));
            case R$id.channel_permission_stage_request_to_speak /* 2131362392 */:
                return Permission.REQUEST_TO_SPEAK;
            case R$id.channel_permission_text_add_reactions /* 2131362393 */:
                return 64L;
            case R$id.channel_permission_text_attach_files /* 2131362394 */:
                return Permission.ATTACH_FILES;
            case R$id.channel_permission_text_create_private_threads /* 2131362395 */:
                return Permission.CREATE_PRIVATE_THREADS;
            case R$id.channel_permission_text_create_public_threads /* 2131362396 */:
                return Permission.CREATE_PUBLIC_THREADS;
            case R$id.channel_permission_text_embed_links /* 2131362397 */:
                return Permission.EMBED_LINKS;
            case R$id.channel_permission_text_manage_messages /* 2131362398 */:
                return Permission.MANAGE_MESSAGES;
            case R$id.channel_permission_text_mention_everyone /* 2131362399 */:
                return Permission.MENTION_EVERYONE;
            case R$id.channel_permission_text_read_message_history /* 2131362400 */:
                return Permission.READ_MESSAGE_HISTORY;
            case R$id.channel_permission_text_read_messages /* 2131362401 */:
                return Permission.VIEW_CHANNEL;
            case R$id.channel_permission_text_send_messages /* 2131362402 */:
                return Permission.SEND_MESSAGES;
            case R$id.channel_permission_text_send_messages_in_threads /* 2131362403 */:
                return Permission.SEND_MESSAGES_IN_THREADS;
            case R$id.channel_permission_text_send_tts_messages /* 2131362404 */:
                return Permission.SEND_TTS_MESSAGES;
            case R$id.channel_permission_text_use_external_emojis /* 2131362405 */:
                return Permission.USE_EXTERNAL_EMOJIS;
            case R$id.channel_permission_text_use_external_stickers /* 2131362406 */:
                return Permission.USE_EXTERNAL_STICKERS;
            case R$id.channel_permission_use_application_commands /* 2131362407 */:
                return Permission.USE_APPLICATION_COMMANDS;
            case R$id.channel_permission_voice_connect /* 2131362408 */:
                return Permission.CONNECT;
            case R$id.channel_permission_voice_deafen_members /* 2131362409 */:
                return Permission.DEAFEN_MEMBERS;
            case R$id.channel_permission_voice_move_members /* 2131362410 */:
                return Permission.MOVE_MEMBERS;
            case R$id.channel_permission_voice_mute_members /* 2131362411 */:
                return Permission.MUTE_MEMBERS;
            case R$id.channel_permission_voice_priority_speaker /* 2131362412 */:
                return 256L;
            case R$id.channel_permission_voice_speak /* 2131362413 */:
                return Permission.SPEAK;
            case R$id.channel_permission_voice_use_vad /* 2131362414 */:
                return Permission.USE_VAD;
            case R$id.channel_permission_voice_video /* 2131362415 */:
                return 512L;
        }
    }

    private final void setTextWithFont(TextView textView, String str, @AttrRes int i) {
        FontUtils fontUtils = FontUtils.INSTANCE;
        Context context = textView.getContext();
        m.checkNotNullExpressionValue(context, "context");
        Typeface themedFont = fontUtils.getThemedFont(context, i);
        if (themedFont != null) {
            TypefaceSpanCompat typefaceSpanCompat = new TypefaceSpanCompat(themedFont);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(typefaceSpanCompat, 0, spannableStringBuilder.length(), 33);
            textView.setText(spannableStringBuilder, TextView$BufferType.SPANNABLE);
        }
    }

    public final void createForRole(Context context, long guildId, long channelId, long targetId) {
        m.checkNotNullParameter(context, "context");
        create(context, guildId, channelId, targetId, 1);
    }

    public final void createForUser(Context context, long guildId, long channelId, long targetId) {
        m.checkNotNullParameter(context, "context");
        create(context, guildId, channelId, targetId, 0);
    }

    public /* synthetic */ WidgetChannelSettingsEditPermissions$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
