package com.discord.utilities.fcm;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.Html;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.Person;
import androidx.core.app.RemoteInput;
import androidx.core.graphics.drawable.IconCompat;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.adjust.sdk.Constants;
import com.discord.R;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.message.Message;
import com.discord.api.message.activity.MessageActivity;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.sticker.Sticker;
import com.discord.api.user.User;
import com.discord.app.AppActivity;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.nullserializable.NullSerializable;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.extensions.PendingIntentExtensions;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.media.AppSound;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.time.Clock;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.forums.ForumUtils;
import d0.Tuples;
import d0.d0._Ranges;
import d0.g0.StringNumberConversions;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import kotlin.Tuples2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NotificationData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationData {
    private static final int ACTIVITY_TYPE_PLAYING = 0;
    private static final int ACTIVITY_TYPE_STREAMING = 1;
    private static final String ANALYTICS_ACTIVITY_NAME = "activity_name";
    private static final String ANALYTICS_ACTIVITY_TYPE = "activity_type";
    private static final String ANALYTICS_CHANNEL_ID = "channel_id";
    private static final String ANALYTICS_CHANNEL_TYPE = "channel_type";
    private static final String ANALYTICS_GUILD_ID = "guild_id";
    private static final String ANALYTICS_MESSAGE_ID = "message_id";
    private static final String ANALYTICS_MESSAGE_TYPE = "message_type";
    private static final String ANALYTICS_NOTIF_IN_APP = "notif_in_app";
    private static final String ANALYTICS_NOTIF_TYPE = "notif_type";
    private static final String ANALYTICS_NOTIF_USER_ID = "notif_user_id";
    private static final String ANALYTICS_REL_TYPE = "rel_type";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String GROUP_KEY_PREFIX = "GROUP_";
    private static final int MSG_MUTE_MIN_COUNT = 2;
    public static final String REPLYING_TO_UNTRANSLATED = "replying to";
    public static final String TYPE_ACTIVITY_START = "ACTIVITY_START";
    public static final String TYPE_APPLICATION_LIBRARY_INSTALL_COMPLETE = "APPLICATION_LIBRARY_INSTALL_COMPLETE";
    public static final String TYPE_CALL_RING = "CALL_RING";
    public static final String TYPE_FORUM_THREAD_CREATED = "FORUM_THREAD_CREATED";
    public static final String TYPE_GENERIC_PUSH_NOTIFICATION_SENT = "GENERIC_PUSH_NOTIFICATION_SENT";
    public static final String TYPE_GUILD_SCHEDULED_EVENT_UPDATE = "GUILD_SCHEDULED_EVENT_UPDATE";
    public static final String TYPE_MESSAGE_CREATE = "MESSAGE_CREATE";
    public static final String TYPE_RELATIONSHIP_ADD = "RELATIONSHIP_ADD";
    public static final String TYPE_STAGE_INSTANCE_CREATE = "STAGE_INSTANCE_CREATE";
    public static final int UNSET_INT = -1;
    public static final long UNSET_LONG = -1;
    private final List<Long> ackChannelIds;
    private final String activityName;
    private final int activityType;
    private final String applicationIcon;
    private final long applicationId;
    private final String applicationName;
    private final Channel channel;
    private final String deeplink;
    private final boolean expandSubtitle;
    private final String guildIcon;
    private final long guildId;
    private final String guildMemberAvatar;
    private final String guildName;
    private final GuildScheduledEventEntityType guildScheduledEventEntityType;
    private final Long guildScheduledEventId;
    private final boolean isGroupConversation;
    private final MessageActivityType messageActivityType;
    private final String messageApplicationName;
    private final String messageContent;
    private final long messageId;
    private final int messageType;
    private final String notificationChannel;
    private final String notificationId;
    private final NotificationData3 notificationType;
    private final Channel parentChannel;
    private final int relationshipType;
    private final String stageInstanceTopic;
    private final Sticker sticker;
    private final String subtitle;
    private final String subtitleResName;
    private final String title;
    private final String titleResName;
    private final String trackingType;
    private final String type;
    private final String userAvatar;
    private final Integer userDiscriminator;
    private final long userId;
    private final String userUsername;

    /* JADX INFO: compiled from: NotificationData.kt */
    public static final class Companion {
        private Companion() {
        }

        private final void copyIntIntoMap(Intent intent, Map<String, Object> map, String str) {
            int intExtra = intent != null ? intent.getIntExtra(str, -1) : -1;
            if (intExtra < 0) {
                return;
            }
            map.put(str, Integer.valueOf(intExtra));
        }

        private final void copyLongIntoMap(Intent intent, Map<String, Object> map, String str) {
            long longExtra = intent != null ? intent.getLongExtra(str, -1L) : -1L;
            if (longExtra < 0) {
                return;
            }
            map.put(str, Long.valueOf(longExtra));
        }

        private final void copyStringIntoMap(Intent intent, Map<String, Object> map, String str) {
            String stringExtra;
            if (intent == null || (stringExtra = intent.getStringExtra(str)) == null) {
                return;
            }
            Intrinsics3.checkNotNullExpressionValue(stringExtra, "this?.getStringExtra(key) ?: return");
            if (stringExtra.length() == 0) {
                return;
            }
            map.put(str, stringExtra);
        }

        private final List<Long> parseAckChannelIds(String longStringsConcatenated) {
            if (longStringsConcatenated == null) {
                longStringsConcatenated = "";
            }
            List listSplit$default = Strings4.split$default((CharSequence) longStringsConcatenated, new String[]{","}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listSplit$default, 10));
            Iterator it = listSplit$default.iterator();
            while (true) {
                long jLongValue = -1;
                if (!it.hasNext()) {
                    break;
                }
                Long longOrNull = StringNumberConversions.toLongOrNull((String) it.next());
                if (longOrNull != null) {
                    jLongValue = longOrNull.longValue();
                }
                arrayList.add(Long.valueOf(jLongValue));
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (((Number) obj).longValue() != -1) {
                    arrayList2.add(obj);
                }
            }
            return arrayList2;
        }

        public final Map<String, Object> buildTrackingData(Intent intent) {
            String stringExtra;
            HashMap map = new HashMap();
            copyStringIntoMap(intent, map, NotificationData.ANALYTICS_NOTIF_TYPE);
            copyLongIntoMap(intent, map, NotificationData.ANALYTICS_NOTIF_USER_ID);
            copyLongIntoMap(intent, map, NotificationData.ANALYTICS_MESSAGE_ID);
            copyLongIntoMap(intent, map, "guild_id");
            copyLongIntoMap(intent, map, "channel_id");
            copyIntIntoMap(intent, map, NotificationData.ANALYTICS_MESSAGE_TYPE);
            copyIntIntoMap(intent, map, NotificationData.ANALYTICS_CHANNEL_TYPE);
            copyIntIntoMap(intent, map, NotificationData.ANALYTICS_REL_TYPE);
            copyIntIntoMap(intent, map, NotificationData.ANALYTICS_ACTIVITY_TYPE);
            copyStringIntoMap(intent, map, NotificationData.ANALYTICS_ACTIVITY_NAME);
            if (intent != null && (stringExtra = intent.getStringExtra("com.discord.intent.ORIGIN_SOURCE")) != null) {
                map.put(NotificationData.ANALYTICS_NOTIF_IN_APP, Boolean.valueOf(StringsJVM.equals(stringExtra, "com.discord.intent.ORIGIN_NOTIF_INAPP", true)));
            }
            return map;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;

        static {
            GuildScheduledEventEntityType.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            GuildScheduledEventEntityType guildScheduledEventEntityType = GuildScheduledEventEntityType.STAGE_INSTANCE;
            iArr[guildScheduledEventEntityType.ordinal()] = 1;
            GuildScheduledEventEntityType guildScheduledEventEntityType2 = GuildScheduledEventEntityType.VOICE;
            iArr[guildScheduledEventEntityType2.ordinal()] = 2;
            GuildScheduledEventEntityType guildScheduledEventEntityType3 = GuildScheduledEventEntityType.EXTERNAL;
            iArr[guildScheduledEventEntityType3.ordinal()] = 3;
            GuildScheduledEventEntityType.values();
            int[] iArr2 = new int[5];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[guildScheduledEventEntityType.ordinal()] = 1;
            iArr2[guildScheduledEventEntityType2.ordinal()] = 2;
            iArr2[guildScheduledEventEntityType3.ordinal()] = 3;
            GuildScheduledEventEntityType.values();
            int[] iArr3 = new int[5];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[guildScheduledEventEntityType.ordinal()] = 1;
            iArr3[guildScheduledEventEntityType2.ordinal()] = 2;
            iArr3[guildScheduledEventEntityType3.ordinal()] = 3;
            GuildScheduledEventEntityType.values();
            int[] iArr4 = new int[5];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[guildScheduledEventEntityType.ordinal()] = 1;
            iArr4[guildScheduledEventEntityType2.ordinal()] = 2;
            iArr4[guildScheduledEventEntityType3.ordinal()] = 3;
            NotificationData3.values();
            int[] iArr5 = new int[1];
            $EnumSwitchMapping$4 = iArr5;
            iArr5[NotificationData3.Reminder.ordinal()] = 1;
            GuildScheduledEventEntityType.values();
            int[] iArr6 = new int[5];
            $EnumSwitchMapping$5 = iArr6;
            iArr6[guildScheduledEventEntityType.ordinal()] = 1;
            iArr6[guildScheduledEventEntityType2.ordinal()] = 2;
            iArr6[guildScheduledEventEntityType3.ordinal()] = 3;
            GuildScheduledEventEntityType.values();
            int[] iArr7 = new int[5];
            $EnumSwitchMapping$6 = iArr7;
            iArr7[guildScheduledEventEntityType.ordinal()] = 1;
            iArr7[guildScheduledEventEntityType2.ordinal()] = 2;
            iArr7[guildScheduledEventEntityType3.ordinal()] = 3;
        }
    }

    public NotificationData(String str, long j, MessageActivityType messageActivityType, String str2, int i, String str3, Channel channel, Channel channel2, List<Long> list, long j2, String str4, Integer num, String str5, String str6, int i2, String str7, long j3, String str8, String str9, int i3, String str10, long j4, String str11, String str12, Sticker sticker, String str13, String str14, String str15, String str16, String str17, GuildScheduledEventEntityType guildScheduledEventEntityType, Long l, NotificationData3 notificationData3, String str18, String str19, boolean z2, String str20) {
        Intrinsics3.checkNotNullParameter(str, "type");
        Intrinsics3.checkNotNullParameter(channel2, "channel");
        Intrinsics3.checkNotNullParameter(list, "ackChannelIds");
        this.type = str;
        this.messageId = j;
        this.messageActivityType = messageActivityType;
        this.messageApplicationName = str2;
        this.messageType = i;
        this.messageContent = str3;
        this.parentChannel = channel;
        this.channel = channel2;
        this.ackChannelIds = list;
        this.userId = j2;
        this.userUsername = str4;
        this.userDiscriminator = num;
        this.userAvatar = str5;
        this.guildMemberAvatar = str6;
        this.relationshipType = i2;
        this.deeplink = str7;
        this.guildName = str8;
        this.guildIcon = str9;
        this.activityType = i3;
        this.activityName = str10;
        this.applicationId = j4;
        this.applicationName = str11;
        this.applicationIcon = str12;
        this.sticker = sticker;
        this.title = str13;
        this.subtitle = str14;
        this.titleResName = str15;
        this.subtitleResName = str16;
        this.stageInstanceTopic = str17;
        this.guildScheduledEventEntityType = guildScheduledEventEntityType;
        this.guildScheduledEventId = l;
        this.notificationType = notificationData3;
        this.trackingType = str18;
        this.notificationChannel = str19;
        this.expandSubtitle = z2;
        this.notificationId = str20;
        Long lValueOf = Long.valueOf(j3);
        boolean z3 = false;
        long jLongValue = -1;
        lValueOf = (lValueOf.longValue() > (-1L) ? 1 : (lValueOf.longValue() == (-1L) ? 0 : -1)) == 0 ? null : lValueOf;
        if (lValueOf != null) {
            jLongValue = lValueOf.longValue();
        } else {
            int type = channel2.getType();
            if (type == 1 || type == 3) {
                jLongValue = 0;
            }
        }
        this.guildId = jLongValue;
        if (Intrinsics3.areEqual(str, TYPE_MESSAGE_CREATE) && (channel2.getType() == 0 || channel2.getType() == 2 || channel2.getType() == 3 || channel2.getType() == 10 || channel2.getType() == 11 || channel2.getType() == 12)) {
            z3 = true;
        }
        this.isGroupConversation = z3;
    }

    private final Intent addTrackingData(Intent intent) {
        String str = this.trackingType;
        if (str == null) {
            str = this.type;
        }
        Intent intentPutExtra = intent.putExtra(ANALYTICS_NOTIF_TYPE, str).putExtra(ANALYTICS_NOTIF_USER_ID, this.userId).putExtra(ANALYTICS_MESSAGE_ID, this.messageId).putExtra(ANALYTICS_MESSAGE_TYPE, this.messageType).putExtra("guild_id", this.guildId).putExtra("channel_id", this.channel.getId()).putExtra(ANALYTICS_CHANNEL_TYPE, this.channel.getType()).putExtra(ANALYTICS_REL_TYPE, this.relationshipType).putExtra(ANALYTICS_ACTIVITY_TYPE, this.activityType).putExtra(ANALYTICS_ACTIVITY_NAME, this.activityName);
        Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "intent\n        .putExtra…IVITY_NAME, activityName)");
        return intentPutExtra;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
    
        if (r0.equals(com.discord.utilities.fcm.NotificationData.TYPE_FORUM_THREAD_CREATED) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
    
        if (r0.equals(com.discord.utilities.fcm.NotificationData.TYPE_RELATIONSHIP_ADD) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0014, code lost:
    
        if (r0.equals(com.discord.utilities.fcm.NotificationData.TYPE_MESSAGE_CREATE) != false) goto L19;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Intent getContentIntentInternal() {
        String str = this.type;
        switch (str.hashCode()) {
            case -1502317553:
                if (str.equals(TYPE_GENERIC_PUSH_NOTIFICATION_SENT)) {
                    String str2 = this.deeplink;
                    if (str2 == null) {
                        str2 = "";
                    }
                    return new Intent("android.intent.action.VIEW", Uri.parse(str2));
                }
                return IntentUtils.RouteBuilders.selectChannel$default(this.channel.getId(), this.guildId, null, 4, null);
            case -1489275252:
                if (str.equals(TYPE_GUILD_SCHEDULED_EVENT_UPDATE)) {
                    GuildScheduledEventEntityType guildScheduledEventEntityType = this.guildScheduledEventEntityType;
                    if (guildScheduledEventEntityType != null) {
                        int iOrdinal = guildScheduledEventEntityType.ordinal();
                        if (iOrdinal == 1 || iOrdinal == 2) {
                            return IntentUtils.RouteBuilders.INSTANCE.connectVoice(this.channel.getId());
                        }
                        if (iOrdinal == 3) {
                            return IntentUtils.RouteBuilders.selectExternalEvent(this.guildId, this.guildScheduledEventId);
                        }
                    }
                    return new Intent("android.intent.action.VIEW", IntentUtils.RouteBuilders.Uris.INSTANCE.getApp());
                }
                return IntentUtils.RouteBuilders.selectChannel$default(this.channel.getId(), this.guildId, null, 4, null);
            case -1327124998:
                break;
            case -1263316859:
                if (str.equals(TYPE_STAGE_INSTANCE_CREATE)) {
                    return IntentUtils.RouteBuilders.INSTANCE.connectVoice(this.channel.getId());
                }
                return IntentUtils.RouteBuilders.selectChannel$default(this.channel.getId(), this.guildId, null, 4, null);
            case -437641071:
                break;
            case 974015250:
                if (str.equals(TYPE_ACTIVITY_START)) {
                    return IntentUtils.RouteBuilders.INSTANCE.selectDirectMessage(this.userId);
                }
                return IntentUtils.RouteBuilders.selectChannel$default(this.channel.getId(), this.guildId, null, 4, null);
            case 998188116:
                break;
            default:
                return IntentUtils.RouteBuilders.selectChannel$default(this.channel.getId(), this.guildId, null, 4, null);
        }
        return this.channel.getType() != 1 ? IntentUtils.RouteBuilders.selectChannel$default(this.channel.getId(), this.guildId, null, 4, null) : IntentUtils.RouteBuilders.selectChannel$default(this.channel.getId(), 0L, null, 4, null);
    }

    private final String getIconUrlForChannel() {
        int type = this.channel.getType();
        if (type != 0) {
            if (type == 1) {
                return getIconUrlForUser();
            }
            if (type != 2 && type != 5) {
                switch (type) {
                    case 10:
                    case 11:
                    case 12:
                        break;
                    default:
                        return IconUtils.getForChannel$default(this.channel.getId(), this.channel.getIcon(), this.channel.getType(), true, null, 16, null);
                }
            }
        }
        return IconUtils.getForGuild$default(Long.valueOf(this.guildId), this.guildIcon, "", false, null, 24, null);
    }

    private final String getIconUrlForGuildMember() {
        return IconUtils.INSTANCE.getForGuildMember(this.guildMemberAvatar, this.guildId, this.userId, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? false : false);
    }

    private final CharSequence resNameToString(Context context, String resourceName, String fallback) {
        Resources resources = context.getResources();
        int identifier = resources != null ? resources.getIdentifier(resourceName, "string", context.getPackageName()) : 0;
        return identifier == 0 ? fallback : FormatUtils.b(context, identifier, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
    }

    public static /* synthetic */ CharSequence resNameToString$default(NotificationData notificationData, Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        return notificationData.resNameToString(context, str, str2);
    }

    public final boolean canDisplayInApp() {
        int iOrdinal;
        if (Intrinsics3.areEqual(this.type, TYPE_STAGE_INSTANCE_CREATE)) {
            return true;
        }
        if (!Intrinsics3.areEqual(this.type, TYPE_GUILD_SCHEDULED_EVENT_UPDATE)) {
            return this.channel.getId() == -1;
        }
        GuildScheduledEventEntityType guildScheduledEventEntityType = this.guildScheduledEventEntityType;
        return guildScheduledEventEntityType != null && ((iOrdinal = guildScheduledEventEntityType.ordinal()) == 1 || iOrdinal == 2 || iOrdinal == 3);
    }

    public final NotificationData copyForDirectReply(Message message) {
        NullSerializable<String> nullSerializableA;
        String strA;
        String discriminator;
        String username;
        Intrinsics3.checkNotNullParameter(message, "message");
        long id2 = message.getId();
        MessageActivity activity = message.getActivity();
        MessageActivityType type = activity != null ? activity.getType() : null;
        Application application = message.getApplication();
        String name = application != null ? application.getName() : null;
        Integer type2 = message.getType();
        Intrinsics3.checkNotNull(type2);
        int iIntValue = type2.intValue();
        String content = message.getContent();
        Channel channelA = Channel.a(this.channel, null, 0, 0L, null, 0L, message.getChannelId(), 0L, null, null, 0, null, 0, 0, null, 0L, 0L, null, false, 0L, null, 0, null, null, null, null, null, null, null, null, null, null, null, -33);
        List listEmptyList = Collections2.emptyList();
        User author = message.getAuthor();
        long id3 = author != null ? author.getId() : 0L;
        User author2 = message.getAuthor();
        String str = (author2 == null || (username = author2.getUsername()) == null) ? "" : username;
        User author3 = message.getAuthor();
        Integer intOrNull = (author3 == null || (discriminator = author3.getDiscriminator()) == null) ? null : StringNumberConversions.toIntOrNull(discriminator);
        User author4 = message.getAuthor();
        String str2 = (author4 == null || (nullSerializableA = author4.a()) == null || (strA = nullSerializableA.a()) == null) ? "" : strA;
        GuildMember member = message.getMember();
        String avatar = member != null ? member.getAvatar() : null;
        long j = this.guildId;
        String str3 = this.guildName;
        long j2 = id3;
        String str4 = this.guildIcon;
        List<Sticker> listB = message.B();
        return new NotificationData(TYPE_MESSAGE_CREATE, id2, type, name, iIntValue, content, null, channelA, listEmptyList, j2, str, intOrNull, str2, avatar, -1, null, j, str3, str4, -1, null, -1L, null, null, listB != null ? (Sticker) _Collections.firstOrNull((List) listB) : null, null, null, null, null, null, null, null, null, null, null, false, null);
    }

    public final List<Long> getAckChannelIds() {
        return this.ackChannelIds;
    }

    @RequiresApi(24)
    @SuppressLint({"UnspecifiedImmutableFlag"})
    public final NotificationCompat.Action getCallAction(Context ctx, boolean isAcceptAction) {
        Intrinsics3.checkNotNullParameter(ctx, "ctx");
        if (!Intrinsics3.areEqual(this.type, TYPE_CALL_RING)) {
            return null;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(ctx, 0, addTrackingData(NotificationActions.INSTANCE.callAction(ctx, this.channel.getId(), this.messageId, isAcceptAction)), PendingIntentExtensions.immutablePendingIntentFlag$default(0, 1, null));
        Tuples2 tuples2 = isAcceptAction ? Tuples.to(Integer.valueOf(R.string.join_call), Integer.valueOf(R.color.status_green_600)) : Tuples.to(Integer.valueOf(R.string.decline), Integer.valueOf(R.color.status_red_500));
        int iIntValue = ((Number) tuples2.component1()).intValue();
        int iIntValue2 = ((Number) tuples2.component2()).intValue();
        StringBuilder sbU = outline.U("**");
        sbU.append(FormatUtils.b(ctx, iIntValue, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null));
        sbU.append("**");
        return new NotificationCompat.Action.Builder(isAcceptAction ? R.drawable.ic_call_24dp : R.drawable.ic_call_disconnect_24dp, FormatUtils.g(sbU.toString(), new Object[0], new NotificationData2(ctx, iIntValue2)), broadcast).build();
    }

    public final long getChannelId() {
        return this.channel.getId();
    }

    public final CharSequence getContent(Context context) {
        CharSequence charSequenceG;
        GuildScheduledEventEntityType guildScheduledEventEntityType;
        Intrinsics3.checkNotNullParameter(context, "context");
        String str = this.type;
        switch (str.hashCode()) {
            case -1502317553:
                if (!str.equals(TYPE_GENERIC_PUSH_NOTIFICATION_SENT)) {
                    return "";
                }
                String str2 = this.subtitleResName;
                if (str2 != null) {
                    String str3 = this.subtitle;
                    return resNameToString(context, str2, str3 != null ? str3 : "");
                }
                charSequenceG = this.subtitle;
                if (charSequenceG == null) {
                    return "";
                }
                break;
            case -1489275252:
                if (!str.equals(TYPE_GUILD_SCHEDULED_EVENT_UPDATE) || (guildScheduledEventEntityType = this.guildScheduledEventEntityType) == null) {
                    return "";
                }
                int iOrdinal = guildScheduledEventEntityType.ordinal();
                if (iOrdinal == 1 || iOrdinal == 2) {
                    return FormatUtils.b(context, R.string.guild_scheduled_event_stage_start_body, new Object[]{this.stageInstanceTopic, this.userUsername}, (4 & 4) != 0 ? FormatUtils.b.j : null);
                }
                return iOrdinal != 3 ? "" : FormatUtils.b(context, R.string.guild_scheduled_event_external_start_body, new Object[]{this.stageInstanceTopic}, (4 & 4) != 0 ? FormatUtils.b.j : null);
            case -1327124998:
                if (!str.equals(TYPE_RELATIONSHIP_ADD)) {
                    return "";
                }
                int i = this.relationshipType;
                if (i != 1) {
                    return i != 3 ? "" : FormatUtils.b(context, R.string.notification_pending_friend_request, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
                }
                return FormatUtils.b(context, R.string.notification_accepted_friend_request, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
            case -1263316859:
                return str.equals(TYPE_STAGE_INSTANCE_CREATE) ? FormatUtils.b(context, R.string.stage_start_push_notification_body, new Object[]{this.userUsername, this.stageInstanceTopic}, (4 & 4) != 0 ? FormatUtils.b.j : null) : "";
            case -1237752112:
                return str.equals(TYPE_APPLICATION_LIBRARY_INSTALL_COMPLETE) ? FormatUtils.b(context, R.string.game_library_notification_game_installed_body, new Object[]{this.applicationName}, (4 & 4) != 0 ? FormatUtils.b.j : null) : "";
            case -437641071:
                return str.equals(TYPE_FORUM_THREAD_CREATED) ? FormatUtils.b(context, R.string.forum_channel_thread_created_push_body_mobile, new Object[]{this.channel.getName(), this.userUsername}, (4 & 4) != 0 ? FormatUtils.b.j : null) : "";
            case 974015250:
                return (str.equals(TYPE_ACTIVITY_START) && this.activityType == 0) ? FormatUtils.b(context, R.string.notification_body_start_game, new Object[]{this.userUsername, this.activityName}, (4 & 4) != 0 ? FormatUtils.b.j : null) : "";
            case 998188116:
                if (!str.equals(TYPE_MESSAGE_CREATE)) {
                    return "";
                }
                int type = this.channel.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type != 2) {
                            if (type != 3) {
                                if (type != 5) {
                                    switch (type) {
                                        case 10:
                                        case 11:
                                        case 12:
                                            break;
                                        default:
                                            return "";
                                    }
                                    return null;
                                }
                            }
                        }
                    }
                    if (this.messageActivityType == MessageActivityType.JOIN) {
                        return FormatUtils.b(context, R.string.notification_message_create_dm_activity_join, new Object[]{this.userUsername, this.messageApplicationName}, (4 & 4) != 0 ? FormatUtils.b.j : null);
                    }
                    Sticker sticker = this.sticker;
                    if (sticker != null) {
                        return FormatUtils.b(context, R.string.sticker_notification_body, new Object[]{sticker.getName()}, (4 & 4) != 0 ? FormatUtils.b.j : null);
                    }
                    String str4 = this.messageContent;
                    if (str4 != null) {
                        charSequenceG = FormatUtils.g(str4, new Object[0], (2 & 2) != 0 ? FormatUtils.e.j : null);
                        break;
                    }
                    return null;
                }
                if (this.messageType == 7) {
                    return FormatUtils.b(context, MessageUtils.INSTANCE.getSystemMessageUserJoin(context, this.messageId), new Object[]{this.userUsername}, (4 & 4) != 0 ? FormatUtils.b.j : null);
                }
                if (this.messageActivityType == MessageActivityType.JOIN) {
                    return FormatUtils.b(context, R.string.notification_message_create_guild_activity_join, new Object[]{this.userUsername, this.messageApplicationName}, (4 & 4) != 0 ? FormatUtils.b.j : null);
                }
                Sticker sticker2 = this.sticker;
                if (sticker2 != null) {
                    return FormatUtils.b(context, R.string.sticker_notification_body, new Object[]{sticker2.getName()}, (4 & 4) != 0 ? FormatUtils.b.j : null);
                }
                String str5 = this.messageContent;
                if (str5 != null) {
                    charSequenceG = FormatUtils.g(str5, new Object[0], (2 & 2) != 0 ? FormatUtils.e.j : null);
                    break;
                }
                return null;
            case 1770025841:
                return str.equals(TYPE_CALL_RING) ? FormatUtils.g(FormatUtils.b(context, R.string.overlay_friend_calling, new Object[]{outline.J(outline.U("**"), this.userUsername, "**")}, (4 & 4) != 0 ? FormatUtils.b.j : null), new Object[0], (2 & 2) != 0 ? FormatUtils.e.j : null) : "";
            default:
                return "";
        }
        return charSequenceG;
    }

    @SuppressLint({"UnspecifiedImmutableFlag"})
    public final PendingIntent getContentIntent(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intent contentIntentInternal = getContentIntentInternal();
        contentIntentInternal.putExtra("com.discord.intent.ORIGIN_SOURCE", "com.discord.intent.ORIGIN_NOTIF");
        contentIntentInternal.setClass(context, AppActivity.Main.class);
        PendingIntent activity = PendingIntent.getActivity(context, 0, addTrackingData(contentIntentInternal), PendingIntentExtensions.immutablePendingIntentFlag(134217728));
        Intrinsics3.checkNotNullExpressionValue(activity, "PendingIntent.getActivit…LAG_UPDATE_CURRENT)\n    )");
        return activity;
    }

    @SuppressLint({"UnspecifiedImmutableFlag"})
    public final PendingIntent getContentIntentInApp(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intent contentIntentInternal = getContentIntentInternal();
        contentIntentInternal.putExtra("com.discord.intent.ORIGIN_SOURCE", "com.discord.intent.ORIGIN_NOTIF_INAPP");
        contentIntentInternal.setClass(context, AppActivity.Main.class);
        PendingIntent activity = PendingIntent.getActivity(context, 0, addTrackingData(contentIntentInternal), PendingIntentExtensions.immutablePendingIntentFlag(134217728));
        Intrinsics3.checkNotNullExpressionValue(activity, "PendingIntent.getActivit…LAG_UPDATE_CURRENT)\n    )");
        return activity;
    }

    public final CharSequence getConversationTitle(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        String str = this.type;
        if (str.hashCode() != 998188116 || !str.equals(TYPE_MESSAGE_CREATE)) {
            return null;
        }
        int type = this.channel.getType();
        if (type != 0 && type != 5 && type != 2) {
            if (type == 3) {
                return ChannelUtils.e(this.channel, context, false, 2);
            }
            switch (type) {
                case 10:
                case 11:
                case 12:
                    break;
                default:
                    return null;
            }
        }
        return FormatUtils.g(this.guildName + " _" + ChannelUtils.e(this.channel, context, false, 2) + '_', new Object[0], (2 & 2) != 0 ? FormatUtils.e.j : null);
    }

    @SuppressLint({"UnspecifiedImmutableFlag"})
    public final PendingIntent getDeleteIntent(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, NotificationActions.INSTANCE.delete(context, this.channel.getId()), PendingIntentExtensions.immutablePendingIntentFlag(134217728));
        Intrinsics3.checkNotNullExpressionValue(broadcast, "PendingIntent.getBroadca…LAG_UPDATE_CURRENT)\n    )");
        return broadcast;
    }

    @RequiresApi(24)
    @SuppressLint({"UnspecifiedImmutableFlag"})
    public final NotificationCompat.Action getDirectReplyAction(Context ctx, Set<Long> deniedChannels) {
        Intrinsics3.checkNotNullParameter(ctx, "ctx");
        Intrinsics3.checkNotNullParameter(deniedChannels, "deniedChannels");
        if ((!Intrinsics3.areEqual(this.type, TYPE_MESSAGE_CREATE)) || deniedChannels.contains(Long.valueOf(this.channel.getId()))) {
            return null;
        }
        RemoteInput remoteInputBuild = new RemoteInput.Builder("discord_notif_text_input").setLabel(FormatUtils.b(ctx, R.string.send_message, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null)).build();
        Intrinsics3.checkNotNullExpressionValue(remoteInputBuild, "RemoteInput.Builder(Inte…essage))\n        .build()");
        return new NotificationCompat.Action.Builder(R.drawable.ic_send_white_24dp, FormatUtils.b(ctx, R.string.notification_reply, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null), PendingIntent.getBroadcast(ctx, (int) this.channel.getId(), addTrackingData(NotificationActions.INSTANCE.directReply(ctx, this.channel.getId(), getTitle(ctx))), PendingIntentExtensions.mutablePendingIntentFlag(134217728))).addRemoteInput(remoteInputBuild).setAllowGeneratedReplies(true).build();
    }

    @SuppressLint({"UnspecifiedImmutableFlag"})
    public final PendingIntent getFullScreenIntent(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        if (!Intrinsics3.areEqual(getNotificationCategory(), NotificationCompat.CATEGORY_CALL)) {
            return null;
        }
        Intent intent = new Intent(context, (Class<?>) AppActivity.IncomingCall.class);
        intent.addFlags(268435456);
        return PendingIntent.getActivity(context, 0, addTrackingData(intent), PendingIntentExtensions.immutablePendingIntentFlag(134217728));
    }

    public final String getGroupKey() {
        StringBuilder sbU = outline.U(GROUP_KEY_PREFIX);
        sbU.append(this.type);
        return sbU.toString();
    }

    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0055  */
    /* JADX WARN: Code duplicated, block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:? A[RETURN, SYNTHETIC] */
    public final String getIconUrl() {
        String forGuild$default;
        String str = this.type;
        switch (str) {
            case "GUILD_SCHEDULED_EVENT_UPDATE":
                if (!str.equals(TYPE_GUILD_SCHEDULED_EVENT_UPDATE)) {
                    return "";
                }
                forGuild$default = IconUtils.getForGuild$default(Long.valueOf(this.guildId), this.guildIcon, "", false, null, 24, null);
                if (forGuild$default == null) {
                    return "";
                }
                return forGuild$default;
            case "RELATIONSHIP_ADD":
                if (!str.equals(TYPE_RELATIONSHIP_ADD)) {
                    return "";
                }
                String str2 = this.applicationIcon;
                if (str2 != null) {
                    return IconUtils.getApplicationIcon$default(this.applicationId, str2, 0, 4, (Object) null);
                }
                return "";
            case "STAGE_INSTANCE_CREATE":
                if (!str.equals(TYPE_GUILD_SCHEDULED_EVENT_UPDATE)) {
                    return "";
                }
                forGuild$default = IconUtils.getForGuild$default(Long.valueOf(this.guildId), this.guildIcon, "", false, null, 24, null);
                if (forGuild$default == null) {
                    return "";
                }
                return forGuild$default;
            case "APPLICATION_LIBRARY_INSTALL_COMPLETE":
                if (!str.equals(TYPE_RELATIONSHIP_ADD)) {
                    return "";
                }
                String str3 = this.applicationIcon;
                if (str3 != null) {
                    return IconUtils.getApplicationIcon$default(this.applicationId, str3, 0, 4, (Object) null);
                }
                return "";
            case "FORUM_THREAD_CREATED":
                if (!str.equals(TYPE_GUILD_SCHEDULED_EVENT_UPDATE)) {
                    return "";
                }
                forGuild$default = IconUtils.getForGuild$default(Long.valueOf(this.guildId), this.guildIcon, "", false, null, 24, null);
                if (forGuild$default == null) {
                    return "";
                }
                return forGuild$default;
            case "ACTIVITY_START":
                if (!str.equals(TYPE_RELATIONSHIP_ADD)) {
                    return "";
                }
                String str4 = this.applicationIcon;
                if (str4 != null) {
                    return IconUtils.getApplicationIcon$default(this.applicationId, str4, 0, 4, (Object) null);
                }
                return "";
            case "MESSAGE_CREATE":
            case "CALL_RING":
                if (!str.equals(TYPE_MESSAGE_CREATE)) {
                    return "";
                }
                forGuild$default = getIconUrlForChannel();
                if (forGuild$default == null) {
                    return "";
                }
                return forGuild$default;
            default:
                return "";
        }
    }

    public final String getIconUrlForAvatar() {
        String iconUrlForGuildMember = getIconUrlForGuildMember();
        return iconUrlForGuildMember != null ? iconUrlForGuildMember : getIconUrlForUser();
    }

    public final String getIconUrlForUser() {
        return IconUtils.getForUser$default(Long.valueOf(this.userId), this.userAvatar, this.userDiscriminator, false, null, 24, null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final String getKey() {
        GuildScheduledEventEntityType guildScheduledEventEntityType;
        String str = this.type;
        switch (str.hashCode()) {
            case -1502317553:
                if (!str.equals(TYPE_GENERIC_PUSH_NOTIFICATION_SENT)) {
                    return "";
                }
                return this.type + this.deeplink;
            case -1489275252:
                if (!str.equals(TYPE_GUILD_SCHEDULED_EVENT_UPDATE) || (guildScheduledEventEntityType = this.guildScheduledEventEntityType) == null) {
                    return "";
                }
                int iOrdinal = guildScheduledEventEntityType.ordinal();
                if (iOrdinal == 1 || iOrdinal == 2) {
                    return this.type + this.channel.getId();
                }
                if (iOrdinal != 3) {
                    return "";
                }
                return this.type + this.guildId;
            case -1327124998:
                if (!str.equals(TYPE_RELATIONSHIP_ADD)) {
                    return "";
                }
                NotificationData3 notificationData3 = this.notificationType;
                if (notificationData3 != null && notificationData3.ordinal() == 0) {
                    return this.type + this.notificationType;
                }
                return this.type + this.userId;
            case -1263316859:
                if (!str.equals(TYPE_STAGE_INSTANCE_CREATE)) {
                    return "";
                }
                break;
            case -1237752112:
                if (!str.equals(TYPE_APPLICATION_LIBRARY_INSTALL_COMPLETE)) {
                    return "";
                }
                return this.type + this.applicationId;
            case -437641071:
                if (!str.equals(TYPE_FORUM_THREAD_CREATED)) {
                    return "";
                }
                break;
            case 974015250:
                if (!str.equals(TYPE_ACTIVITY_START)) {
                    return "";
                }
                return this.type + this.activityType + this.activityName;
            case 998188116:
                if (!str.equals(TYPE_MESSAGE_CREATE)) {
                    return "";
                }
                break;
            case 1770025841:
                if (!str.equals(TYPE_CALL_RING)) {
                    return "";
                }
                break;
            default:
                return "";
        }
        return this.type + this.channel.getId();
    }

    @RequiresApi(24)
    @SuppressLint({"UnspecifiedImmutableFlag"})
    public final NotificationCompat.Action getMarkAsReadAction(Context ctx) {
        Intrinsics3.checkNotNullParameter(ctx, "ctx");
        if (!Intrinsics3.areEqual(this.type, TYPE_MESSAGE_CREATE)) {
            return null;
        }
        return new NotificationCompat.Action.Builder(R.drawable.ic_check_grey_24dp, FormatUtils.b(ctx, R.string.mark_as_read, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null), PendingIntent.getBroadcast(ctx, 0, addTrackingData(NotificationActions.INSTANCE.markAsRead(ctx, this.channel.getId(), this.messageId)), PendingIntentExtensions.immutablePendingIntentFlag$default(0, 1, null))).build();
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final long getMessageIdTimestamp() {
        return (this.messageId >>> 22) + SnowflakeUtils.DISCORD_EPOCH;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:25:0x004c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0050 A[ORIG_RETURN, RETURN] */
    public final String getNotificationCategory() {
        switch (this.type) {
            case "GENERIC_PUSH_NOTIFICATION_SENT":
            case "GUILD_SCHEDULED_EVENT_UPDATE":
            case "RELATIONSHIP_ADD":
            case "STAGE_INSTANCE_CREATE":
                return NotificationCompat.CATEGORY_SOCIAL;
            case "APPLICATION_LIBRARY_INSTALL_COMPLETE":
                return "progress";
            case "ACTIVITY_START":
                return NotificationCompat.CATEGORY_SOCIAL;
            case "CALL_RING":
                return NotificationCompat.CATEGORY_CALL;
            default:
                return NotificationCompat.CATEGORY_MESSAGE;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:31:0x0060 A[ORIG_RETURN, RETURN] */
    public final String getNotificationChannelId() {
        String str = this.type;
        switch (str) {
            case "GENERIC_PUSH_NOTIFICATION_SENT":
                String str2 = this.notificationChannel;
                return str2 != null ? str2 : NotificationClient.NOTIF_GENERAL;
            case "GUILD_SCHEDULED_EVENT_UPDATE":
                return NotificationClient.NOTIF_GUILD_SCHEDULED_EVENT_START;
            case "STAGE_INSTANCE_CREATE":
                return NotificationClient.NOTIF_CHANNEL_STAGE_START;
            case "FORUM_THREAD_CREATED":
                return NotificationClient.NOTIF_CHANNEL_FORUM_POST_CREATE;
            case "MESSAGE_CREATE":
                int type = this.channel.getType();
                return (type == 1 || type == 3) ? NotificationClient.NOTIF_CHANNEL_MESSAGES_DIRECT : NotificationClient.NOTIF_CHANNEL_MESSAGES;
            case "CALL_RING":
                return NotificationClient.NOTIF_CHANNEL_CALLS;
            default:
                if (str.equals(TYPE_GENERIC_PUSH_NOTIFICATION_SENT)) {
                    String str3 = this.notificationChannel;
                    return str3 != null ? str3 : NotificationClient.NOTIF_GENERAL;
                }
                return NotificationClient.NOTIF_CHANNEL_SOCIAL;
        }
    }

    public final String getNotificationId() {
        return this.notificationId;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x0042 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x0055 A[ORIG_RETURN, RETURN] */
    public final int getNotificationPriority() {
        String notificationChannelId = getNotificationChannelId();
        switch (notificationChannelId.hashCode()) {
            case -1917463435:
                if (notificationChannelId.equals(NotificationClient.NOTIF_CHANNEL_MESSAGES_DIRECT)) {
                    return 1;
                }
                return -1;
            case -1813183603:
                notificationChannelId.equals(NotificationClient.NOTIF_CHANNEL_SOCIAL);
                return -1;
            case -1241096946:
                if (notificationChannelId.equals(NotificationClient.NOTIF_CHANNEL_STAGE_START)) {
                    return 0;
                }
                return -1;
            case -397449876:
                if (notificationChannelId.equals(NotificationClient.NOTIF_CHANNEL_MESSAGES)) {
                    return 0;
                }
                return -1;
            case 64872885:
                if (notificationChannelId.equals(NotificationClient.NOTIF_CHANNEL_CALLS)) {
                    return 2;
                }
                return -1;
            case 526428889:
                if (notificationChannelId.equals(NotificationClient.NOTIF_CHANNEL_MEDIA_CONNECTIONS)) {
                    return 2;
                }
                return -1;
            case 803834207:
                if (notificationChannelId.equals(NotificationClient.NOTIF_GUILD_SCHEDULED_EVENT_START)) {
                    return 0;
                }
                return -1;
            case 1584505032:
                notificationChannelId.equals(NotificationClient.NOTIF_GENERAL);
                return -1;
            default:
                return -1;
        }
    }

    public final Uri getNotificationSound(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        String str = this.type;
        if (str.hashCode() != 1770025841 || !str.equals(TYPE_CALL_RING)) {
            return null;
        }
        StringBuilder sbU = outline.U("android.resource://");
        sbU.append(context.getPackageName() + MentionUtils.SLASH_CHAR + AppSound.INSTANCE.getSOUND_CALL_RINGING().getResId());
        String string = sbU.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder()\n        …)\n            .toString()");
        return Uri.parse(string);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00ae  */
    public final Person getSender(Context context) {
        String strReplaceAfterLast$default;
        MessageActivityType messageActivityType;
        Intrinsics3.checkNotNullParameter(context, "context");
        IconCompat iconCompatCreateWithContentUri = null;
        CharSequence charSequenceB = (!Intrinsics3.areEqual(this.type, TYPE_MESSAGE_CREATE) || this.messageType == 7 || (messageActivityType = this.messageActivityType) == MessageActivityType.SPECTATE || messageActivityType == MessageActivityType.JOIN) ? FormatUtils.b(context, R.string.discord, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null) : this.userUsername;
        String strValueOf = String.valueOf(this.userId);
        String str = this.subtitle;
        if (str != null && charSequenceB != null) {
            if (this.messageType != 19 || str.length() <= 11) {
                StringBuilder sbU = outline.U("<b>");
                sbU.append(Html.escapeHtml(charSequenceB));
                sbU.append("</b> ");
                sbU.append(Html.escapeHtml(this.subtitle));
                charSequenceB = Html.fromHtml(sbU.toString());
            } else {
                String str2 = this.subtitle;
                Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
                String strSubstring = str2.substring(0, 11);
                Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (Intrinsics3.areEqual(strSubstring, REPLYING_TO_UNTRANSLATED)) {
                    StringBuilder sbU2 = outline.U("<b>");
                    sbU2.append(Html.escapeHtml(charSequenceB));
                    sbU2.append("</b> ");
                    String str3 = this.subtitle;
                    Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring2 = str3.substring(0, 11);
                    Intrinsics3.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    sbU2.append(Html.escapeHtml(strSubstring2));
                    sbU2.append("<b>");
                    String str4 = this.subtitle;
                    Objects.requireNonNull(str4, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring3 = str4.substring(11);
                    Intrinsics3.checkNotNullExpressionValue(strSubstring3, "(this as java.lang.String).substring(startIndex)");
                    sbU2.append(Html.escapeHtml(strSubstring3));
                    sbU2.append("</b>");
                    charSequenceB = Html.fromHtml(sbU2.toString());
                } else {
                    StringBuilder sbU3 = outline.U("<b>");
                    sbU3.append(Html.escapeHtml(charSequenceB));
                    sbU3.append("</b> ");
                    sbU3.append(Html.escapeHtml(this.subtitle));
                    charSequenceB = Html.fromHtml(sbU3.toString());
                }
            }
            StringBuilder sbU4 = outline.U(strValueOf);
            sbU4.append(this.subtitle);
            strValueOf = sbU4.toString();
        }
        String forUser$default = IconUtils.getForUser$default(Long.valueOf(this.userId), this.userAvatar, null, false, null, 28, null);
        if (forUser$default != null && (strReplaceAfterLast$default = Strings4.replaceAfterLast$default(forUser$default, '.', "jpg", null, 4, null)) != null) {
            iconCompatCreateWithContentUri = IconCompat.createWithContentUri(strReplaceAfterLast$default);
        }
        Person personBuild = new Person.Builder().setName(charSequenceB).setKey(strValueOf).setIcon(iconCompatCreateWithContentUri).setImportant(this.relationshipType == 1).build();
        Intrinsics3.checkNotNullExpressionValue(personBuild, "Person.Builder()\n       …_FRIEND)\n        .build()");
        return personBuild;
    }

    public final boolean getShouldGroup() {
        String str = this.type;
        int iHashCode = str.hashCode();
        return iHashCode == 974015250 ? str.equals(TYPE_ACTIVITY_START) : iHashCode == 998188116 && str.equals(TYPE_MESSAGE_CREATE);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:13:0x0024 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:17:0x0031 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final boolean getShouldUseBigText() {
        String str = this.type;
        switch (str.hashCode()) {
            case -1502317553:
                if (str.equals(TYPE_GENERIC_PUSH_NOTIFICATION_SENT)) {
                    return this.expandSubtitle;
                }
                return false;
            case -1489275252:
                if (str.equals(TYPE_GUILD_SCHEDULED_EVENT_UPDATE)) {
                    return true;
                }
                return false;
            case -1263316859:
                if (str.equals(TYPE_STAGE_INSTANCE_CREATE)) {
                    return true;
                }
                return false;
            case -437641071:
                if (str.equals(TYPE_FORUM_THREAD_CREATED)) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public final int getSmallIcon() {
        String str = this.type;
        int iHashCode = str.hashCode();
        if (iHashCode != -1327124998) {
            if (iHashCode != 998188116) {
                if (iHashCode == 1770025841 && str.equals(TYPE_CALL_RING)) {
                    return R.drawable.ic_notification_call_24dp;
                }
            } else if (str.equals(TYPE_MESSAGE_CREATE)) {
                return R.drawable.ic_notification_message_24dp;
            }
        } else if (str.equals(TYPE_RELATIONSHIP_ADD)) {
            return R.drawable.ic_notification_friends_24dp;
        }
        return R.drawable.ic_notification_24dp;
    }

    public final Sticker getSticker() {
        return this.sticker;
    }

    @RequiresApi(24)
    @SuppressLint({"UnspecifiedImmutableFlag"})
    public final NotificationCompat.Action getTimedMute(Context ctx, Clock clock, int numMessages) {
        Intrinsics3.checkNotNullParameter(ctx, "ctx");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        if ((!Intrinsics3.areEqual(this.type, TYPE_MESSAGE_CREATE)) || numMessages < 2) {
            return null;
        }
        return new NotificationCompat.Action.Builder(R.drawable.ic_notifications_off_grey_24dp, FormatUtils.b(ctx, R.string.notification_mute_1_hour, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null), PendingIntent.getBroadcast(ctx, 0, addTrackingData(NotificationActions.INSTANCE.timedMute(ctx, this.guildId, this.channel.getId(), clock.currentTimeMillis() + 3600000)), PendingIntentExtensions.immutablePendingIntentFlag$default(0, 1, null))).build();
    }

    public final CharSequence getTitle(Context context) {
        String str;
        GuildScheduledEventEntityType guildScheduledEventEntityType;
        Intrinsics3.checkNotNullParameter(context, "context");
        String str2 = this.type;
        switch (str2.hashCode()) {
            case -1502317553:
                if (!str2.equals(TYPE_GENERIC_PUSH_NOTIFICATION_SENT)) {
                    return "";
                }
                String str3 = this.titleResName;
                if (str3 != null) {
                    String str4 = this.title;
                    return resNameToString(context, str3, str4 != null ? str4 : "");
                }
                str = this.title;
                if (str == null) {
                    return "";
                }
                break;
            case -1489275252:
                if (!str2.equals(TYPE_GUILD_SCHEDULED_EVENT_UPDATE) || (guildScheduledEventEntityType = this.guildScheduledEventEntityType) == null) {
                    return "";
                }
                int iOrdinal = guildScheduledEventEntityType.ordinal();
                return (iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) ? FormatUtils.b(context, R.string.guild_scheduled_event_stage_start_title, new Object[]{this.guildName}, (4 & 4) != 0 ? FormatUtils.b.j : null) : "";
            case -1327124998:
                if (!str2.equals(TYPE_RELATIONSHIP_ADD)) {
                    return "";
                }
                if ((this.notificationType != NotificationData3.Reminder || (str = this.title) == null) && (str = this.userUsername) == null) {
                    return "";
                }
                break;
            case -1263316859:
                return str2.equals(TYPE_STAGE_INSTANCE_CREATE) ? FormatUtils.b(context, R.string.stage_start_push_notification_title, new Object[]{this.guildName}, (4 & 4) != 0 ? FormatUtils.b.j : null) : "";
            case -1237752112:
                return str2.equals(TYPE_APPLICATION_LIBRARY_INSTALL_COMPLETE) ? FormatUtils.b(context, R.string.game_library_notification_game_installed_title, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null) : "";
            case -437641071:
                if (!str2.equals(TYPE_FORUM_THREAD_CREATED)) {
                    return "";
                }
                Object[] objArr = new Object[2];
                objArr[0] = this.guildName;
                Channel channel = this.parentChannel;
                objArr[1] = channel != null ? channel.getName() : null;
                return FormatUtils.b(context, R.string.forum_channel_thread_created_push_title_mobile, objArr, (4 & 4) != 0 ? FormatUtils.b.j : null);
            case 974015250:
                return (str2.equals(TYPE_ACTIVITY_START) && this.activityType == 0) ? FormatUtils.b(context, R.string.notification_title_start_game, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null) : "";
            case 998188116:
                if (!str2.equals(TYPE_MESSAGE_CREATE)) {
                    return "";
                }
                int type = this.channel.getType();
                if (type != 0) {
                    if (type == 1) {
                        str = this.userUsername;
                        if (str == null) {
                            return "";
                        }
                    } else if (type != 2) {
                        if (type == 3) {
                            return ChannelUtils.e(this.channel, context, false, 2);
                        }
                        if (type != 5) {
                            switch (type) {
                                case 10:
                                case 11:
                                case 12:
                                    break;
                                default:
                                    return "";
                            }
                        }
                    }
                }
                return FormatUtils.g(this.guildName + " _" + ChannelUtils.e(this.channel, context, false, 2) + '_', new Object[0], (2 & 2) != 0 ? FormatUtils.e.j : null);
            case 1770025841:
                if (str2.equals(TYPE_CALL_RING)) {
                    return this.channel.getType() != 1 ? ChannelUtils.c(this.channel) : FormatUtils.b(context, R.string.incoming_call, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
                }
                return "";
            default:
                return "";
        }
        return str;
    }

    public final String getTrackingType() {
        return this.trackingType;
    }

    public final String getType() {
        return this.type;
    }

    public final long getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: isGroupConversation, reason: from getter */
    public final boolean getIsGroupConversation() {
        return this.isGroupConversation;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x007e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final boolean isValid() {
        GuildScheduledEventEntityType guildScheduledEventEntityType;
        String str = this.type;
        switch (str.hashCode()) {
            case -1502317553:
                if (str.equals(TYPE_GENERIC_PUSH_NOTIFICATION_SENT)) {
                    return true;
                }
                return false;
            case -1489275252:
                if (!str.equals(TYPE_GUILD_SCHEDULED_EVENT_UPDATE) || (guildScheduledEventEntityType = this.guildScheduledEventEntityType) == null) {
                    return false;
                }
                int iOrdinal = guildScheduledEventEntityType.ordinal();
                if (iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) {
                    return true;
                }
                return false;
            case -1327124998:
                if (str.equals(TYPE_RELATIONSHIP_ADD)) {
                    return true;
                }
                return false;
            case -1263316859:
                if (str.equals(TYPE_STAGE_INSTANCE_CREATE)) {
                    return true;
                }
                return false;
            case -1237752112:
                if (str.equals(TYPE_APPLICATION_LIBRARY_INSTALL_COMPLETE)) {
                    return true;
                }
                return false;
            case -437641071:
                if (str.equals(TYPE_FORUM_THREAD_CREATED)) {
                    return ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, this.guildId, null, 2, null);
                }
                return false;
            case 974015250:
                if (!str.equals(TYPE_ACTIVITY_START) || this.activityType == 1) {
                    return false;
                }
                return true;
            case 998188116:
                if (str.equals(TYPE_MESSAGE_CREATE)) {
                    return true;
                }
                return false;
            case 1770025841:
                if (str.equals(TYPE_CALL_RING)) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    /* JADX INFO: compiled from: NotificationData.kt */
    public static final class DisplayPayload {
        private NotificationData data;
        private final LinkedHashMap<Long, NotificationData> extras;
        private final int id;
        private boolean ignoreNextClearForAck;

        public DisplayPayload(NotificationData notificationData) {
            Intrinsics3.checkNotNullParameter(notificationData, "data");
            this.data = notificationData;
            this.id = new Random().nextInt(Integer.MAX_VALUE);
            this.extras = new LinkedHashMap<>();
        }

        private final void trimExtrasWhenOversized(int maxExtras) {
            if (this.extras.size() < maxExtras) {
                return;
            }
            Set<Map.Entry<Long, NotificationData>> setEntrySet = this.extras.entrySet();
            Intrinsics3.checkNotNullExpressionValue(setEntrySet, "extras\n          .entries");
            List<Map.Entry> listDrop = _Collections.drop(setEntrySet, this.extras.size() - (maxExtras / 2));
            LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(listDrop, 10)), 16));
            for (Map.Entry entry : listDrop) {
                linkedHashMap.put((Long) entry.getKey(), (NotificationData) entry.getValue());
            }
            this.extras.clear();
            this.extras.putAll(linkedHashMap);
        }

        public static /* synthetic */ void update$default(DisplayPayload displayPayload, NotificationData notificationData, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 20;
            }
            displayPayload.update(notificationData, i);
        }

        public final NotificationData getData() {
            return this.data;
        }

        public final synchronized List<NotificationData> getExtras() {
            Collection<NotificationData> collectionValues;
            collectionValues = this.extras.values();
            Intrinsics3.checkNotNullExpressionValue(collectionValues, "extras.values");
            return _Collections.toList(collectionValues);
        }

        public final int getId() {
            return this.id;
        }

        public final boolean getIgnoreNextClearForAck() {
            return this.ignoreNextClearForAck;
        }

        public final void setData(NotificationData notificationData) {
            Intrinsics3.checkNotNullParameter(notificationData, "<set-?>");
            this.data = notificationData;
        }

        public final void setIgnoreNextClearForAck(boolean z2) {
            this.ignoreNextClearForAck = z2;
        }

        public final synchronized void update(NotificationData data, int maxExtras) {
            Intrinsics3.checkNotNullParameter(data, "data");
            this.data = data;
            trimExtrasWhenOversized(maxExtras);
            if (data.getShouldGroup()) {
                this.extras.put(Long.valueOf(data.getMessageId()), data);
            } else {
                this.extras.clear();
            }
        }

        public DisplayPayload() {
            this(new NotificationData());
        }
    }

    public NotificationData() {
        this(new HashMap());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NotificationData(Map<String, String> map) {
        Integer num;
        String string;
        Integer intOrNull;
        Long longOrNull;
        Integer intOrNull2;
        Long longOrNull2;
        Integer intOrNull3;
        Long longOrNull3;
        Long longOrNull4;
        Long longOrNull5;
        Integer intOrNull4;
        Long longOrNull6;
        Long longOrNull7;
        Integer intOrNull5;
        Integer intOrNull6;
        Long longOrNull8;
        Intrinsics3.checkNotNullParameter(map, "data");
        String str = map.get("type");
        String str2 = str == null ? "" : str;
        String str3 = map.get(ANALYTICS_MESSAGE_ID);
        long jLongValue = (str3 == null || (longOrNull8 = StringNumberConversions.toLongOrNull(str3)) == null) ? -1L : longOrNull8.longValue();
        String str4 = map.get("message_activity_type");
        String string2 = null;
        MessageActivityType messageActivityTypeA = (str4 == null || (intOrNull6 = StringNumberConversions.toIntOrNull(str4)) == null) ? null : MessageActivityType.INSTANCE.a(intOrNull6);
        String str5 = map.get("message_application_name");
        String str6 = map.get("message_type_");
        int iIntValue = (str6 == null || (intOrNull5 = StringNumberConversions.toIntOrNull(str6)) == null) ? -1 : intOrNull5.intValue();
        String str7 = map.get("message_content");
        String str8 = map.get("guild_id");
        long jLongValue2 = (str8 == null || (longOrNull7 = StringNumberConversions.toLongOrNull(str8)) == null) ? -1L : longOrNull7.longValue();
        String str9 = map.get("parent_name");
        if (str9 != null) {
            string2 = FormatUtils.g(outline.y("!!", str9, "!!"), new Object[0], (2 & 2) != 0 ? FormatUtils.e.j : null).toString();
        }
        String str10 = map.get("parent_id");
        Channel channel = new Channel(null, -1, jLongValue2, string2, 0L, (str10 == null || (longOrNull6 = StringNumberConversions.toLongOrNull(str10)) == null) ? -1L : longOrNull6.longValue(), 0L, null, null, 0, null, 0, 0, null, 0L, 0L, null, false, 0L, null, 0, null, map.get(ModelAuditLogEntry.CHANGE_KEY_REGION_OVERRIDE), null, null, null, null, null, null, null, null, null);
        String str11 = map.get(ANALYTICS_CHANNEL_TYPE);
        int iIntValue2 = (str11 == null || (intOrNull4 = StringNumberConversions.toIntOrNull(str11)) == null) ? -1 : intOrNull4.intValue();
        String str12 = map.get("guild_id");
        long jLongValue3 = (str12 == null || (longOrNull5 = StringNumberConversions.toLongOrNull(str12)) == null) ? -1L : longOrNull5.longValue();
        String str13 = map.get("channel_name");
        if (str13 != null) {
            num = null;
            string = FormatUtils.g(outline.y("!!", str13, "!!"), new Object[0], (2 & 2) != 0 ? FormatUtils.e.j : null).toString();
        } else {
            num = null;
            string = null;
        }
        String str14 = map.get("channel_id");
        Channel channel2 = new Channel(null, iIntValue2, jLongValue3, string, 0L, (str14 == null || (longOrNull4 = StringNumberConversions.toLongOrNull(str14)) == null) ? -1L : longOrNull4.longValue(), 0L, null, null, 0, null, 0, 0, map.get("channel_icon"), 0L, 0L, null, false, 0L, null, 0, null, map.get(ModelAuditLogEntry.CHANGE_KEY_REGION_OVERRIDE), null, null, null, null, null, null, null, null, null);
        List ackChannelIds = INSTANCE.parseAckChannelIds(map.get("channel_ids"));
        String str15 = map.get("user_id");
        long jLongValue4 = (str15 == null || (longOrNull3 = StringNumberConversions.toLongOrNull(str15)) == null) ? -1L : longOrNull3.longValue();
        String str16 = map.get("user_username");
        String str17 = map.get("user_discriminator");
        Integer intOrNull7 = str17 != null ? StringNumberConversions.toIntOrNull(str17) : num;
        String str18 = map.get("user_avatar");
        String str19 = map.get("user_guild_avatar");
        String str20 = map.get(ANALYTICS_REL_TYPE);
        int iIntValue3 = (str20 == null || (intOrNull3 = StringNumberConversions.toIntOrNull(str20)) == null) ? -1 : intOrNull3.intValue();
        String str21 = map.get(Constants.DEEPLINK);
        String str22 = map.get("guild_id");
        long jLongValue5 = (str22 == null || (longOrNull2 = StringNumberConversions.toLongOrNull(str22)) == null) ? -1L : longOrNull2.longValue();
        String str23 = map.get("guild_name");
        String str24 = map.get("guild_icon");
        String str25 = map.get(ANALYTICS_ACTIVITY_TYPE);
        int iIntValue4 = (str25 == null || (intOrNull2 = StringNumberConversions.toIntOrNull(str25)) == null) ? -1 : intOrNull2.intValue();
        String str26 = map.get(ANALYTICS_ACTIVITY_NAME);
        String str27 = map.get(ModelAuditLogEntry.CHANGE_KEY_APPLICATION_ID);
        long jLongValue6 = (str27 == null || (longOrNull = StringNumberConversions.toLongOrNull(str27)) == null) ? -1L : longOrNull.longValue();
        String str28 = map.get("application_name");
        String str29 = map.get("application_icon");
        Sticker fromMessageNotificationJson = StickerUtils.INSTANCE.parseFromMessageNotificationJson(map.get("message"));
        String str30 = map.get("title");
        String str31 = map.get("subtitle");
        String str32 = map.get("title_resource_name");
        String str33 = map.get("subtitle_resource_name");
        String str34 = map.get("stage_instance_topic");
        String str35 = map.get("guild_scheduled_event_entity_type");
        GuildScheduledEventEntityType guildScheduledEventEntityTypeA = (str35 == null || (intOrNull = StringNumberConversions.toIntOrNull(str35)) == null) ? num : GuildScheduledEventEntityType.INSTANCE.a(intOrNull.intValue());
        String str36 = map.get("guild_scheduled_event_id");
        Long longOrNull9 = str36 != null ? StringNumberConversions.toLongOrNull(str36) : num;
        String str37 = map.get("notification_type");
        NotificationData3 notificationData3 = str37 != null ? NotificationData3.INSTANCE.parse(str37) : num;
        String str38 = map.get("tracking_type");
        String str39 = map.get("notification_channel");
        String str40 = map.get("expand_subtitle");
        this(str2, jLongValue, messageActivityTypeA, str5, iIntValue, str7, channel, channel2, ackChannelIds, jLongValue4, str16, intOrNull7, str18, str19, iIntValue3, str21, jLongValue5, str23, str24, iIntValue4, str26, jLongValue6, str28, str29, fromMessageNotificationJson, str30, str31, str32, str33, str34, guildScheduledEventEntityTypeA, longOrNull9, notificationData3, str38, str39, str40 != null ? Boolean.parseBoolean(str40) : false, map.get("notification_id"));
    }
}
