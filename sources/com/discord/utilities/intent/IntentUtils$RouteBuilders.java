package com.discord.utilities.intent;

import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.a.d.m0.a;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.g0.t;
import d0.z.d.m;

/* JADX INFO: compiled from: IntentUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntentUtils$RouteBuilders {
    public static final IntentUtils$RouteBuilders INSTANCE = new IntentUtils$RouteBuilders();

    private IntentUtils$RouteBuilders() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.String] */
    public static final Intent selectChannel(long channelId, long guildId, Long messageId) {
        Object objValueOf = (guildId == 0 || guildId == -1) ? "@me" : Long.valueOf(guildId);
        if (messageId == 0) {
            messageId = "";
        }
        return new Intent("android.intent.action.VIEW", Uri.parse("discord://app/channels/" + objValueOf + MentionUtilsKt.SLASH_CHAR + channelId + MentionUtilsKt.SLASH_CHAR + messageId));
    }

    public static /* synthetic */ Intent selectChannel$default(long j, long j2, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = 0;
        }
        if ((i & 4) != 0) {
            l = null;
        }
        return selectChannel(j, j2, l);
    }

    public static final Intent selectExternalEvent(long guildId, Long eventId) {
        return new Intent("android.intent.action.VIEW", Uri.parse("discord://app/events/" + ((guildId == 0 || guildId == -1) ? "@me" : Long.valueOf(guildId)) + MentionUtilsKt.SLASH_CHAR + eventId));
    }

    public static final Intent selectGuild(long guildId) {
        return new Intent("android.intent.action.VIEW", Uri.parse("discord://app/channels/" + ((guildId == 0 || guildId == -1) ? "@me" : Long.valueOf(guildId))));
    }

    public static final Intent selectUserProfile(long userId) {
        return new Intent("android.intent.action.VIEW", Uri.parse("discord://app/users/" + userId));
    }

    public final Intent connectVoice(long voiceChannelId) {
        return new Intent("com.discord.intent.action.CONNECT", Uri.parse("discord://app/connect/" + voiceChannelId));
    }

    public final Intent selectDirectMessage(long userId) {
        return new Intent("android.intent.action.VIEW", Uri.parse("discord://app/channels/@me/user/" + userId));
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0037  */
    /* JADX WARN: Instruction removed from duplicated block: B:9:0x0037, please report this as an issue */
    public final Intent selectGuildTemplate(String guildTemplateText, String source) {
        Uri uri = Uri.parse(guildTemplateText);
        m.checkNotNullExpressionValue(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        if (uri.getScheme() == null) {
            if (guildTemplateText != null) {
                a aVar = a.G;
                if (t.startsWith$default(guildTemplateText, a.e, false, 2, null)) {
                    uri = Uri.parse("https://" + guildTemplateText);
                } else {
                    uri = Uri.parse("discord://app/template/" + guildTemplateText + "?source=" + source);
                }
            } else {
                uri = Uri.parse("discord://app/template/" + guildTemplateText + "?source=" + source);
            }
        }
        Intent data = new Intent().setData(uri);
        m.checkNotNullExpressionValue(data, "Intent().setData(uriMerged)");
        return data;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0037  */
    /* JADX WARN: Instruction removed from duplicated block: B:9:0x0037, please report this as an issue */
    public final Intent selectInvite(String inviteText, String source) {
        Uri uri = Uri.parse(inviteText);
        m.checkNotNullExpressionValue(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        if (uri.getScheme() == null) {
            if (inviteText != null) {
                a aVar = a.G;
                if (t.startsWith$default(inviteText, a.d, false, 2, null)) {
                    uri = Uri.parse("https://" + inviteText);
                } else {
                    uri = Uri.parse("discord://app/invite/" + inviteText + "?source=" + source);
                }
            } else {
                uri = Uri.parse("discord://app/invite/" + inviteText + "?source=" + source);
            }
        }
        Intent data = new Intent().setData(uri);
        m.checkNotNullExpressionValue(data, "Intent().setData(uriMerged)");
        return data;
    }
}
