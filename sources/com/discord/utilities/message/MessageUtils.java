package com.discord.utilities.message;

import android.content.Context;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelRecipientNick;
import com.discord.api.interaction.Interaction;
import com.discord.api.message.role_subscription.RoleSubscriptionData;
import com.discord.api.sticker.StickerFormatType;
import com.discord.api.sticker.StickerPartial;
import com.discord.api.user.User;
import com.discord.i18n.RenderContext;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.utilities.context.ContextExtensions;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MessageUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageUtils {
    private static final StickerPartial[] ROLE_SUBSCRIPTION_PURCHASE_STICKERS;
    private static final Comparator<Long> SORT_BY_IDS_COMPARATOR;
    private static final StickerPartial[] WELCOME_STICKERS;
    public static final MessageUtils INSTANCE = new MessageUtils();
    private static final int[] WELCOME_MESSAGES = {R.string.system_message_guild_member_join_001, R.string.system_message_guild_member_join_002, R.string.system_message_guild_member_join_003, R.string.system_message_guild_member_join_004, R.string.system_message_guild_member_join_005, R.string.system_message_guild_member_join_006, R.string.system_message_guild_member_join_007, R.string.system_message_guild_member_join_008, R.string.system_message_guild_member_join_009, R.string.system_message_guild_member_join_010, R.string.system_message_guild_member_join_011, R.string.system_message_guild_member_join_012, R.string.system_message_guild_member_join_013};

    /* JADX INFO: renamed from: com.discord.utilities.message.MessageUtils$getSystemMessageRoleSubscriptionPurchase$1, reason: invalid class name */
    /* JADX INFO: compiled from: MessageUtils.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        }
    }

    static {
        StickerFormatType stickerFormatType = StickerFormatType.LOTTIE;
        StickerFormatType stickerFormatType2 = StickerFormatType.APNG;
        WELCOME_STICKERS = new StickerPartial[]{new StickerPartial(749054660769218631L, stickerFormatType, "Wumpus waves hello"), new StickerPartial(751606379340365864L, stickerFormatType, "Nelly peeks around a wall and waves hello"), new StickerPartial(754108890559283200L, stickerFormatType, "Clyde cheerfully waving"), new StickerPartial(781291131828699156L, stickerFormatType2, "Choco waves in greeting"), new StickerPartial(816087792291282944L, stickerFormatType, "Doggo spins and greets you"), new StickerPartial(819128604311027752L, stickerFormatType, "Peach raising her arms in distress")};
        ROLE_SUBSCRIPTION_PURCHASE_STICKERS = new StickerPartial[]{new StickerPartial(781323471249604648L, stickerFormatType2, "Cheerful Choco jumps out of gift box"), new StickerPartial(781324642736144424L, stickerFormatType2, "Cheerful Choco preens against window"), new StickerPartial(781323769960202280L, stickerFormatType2, "Cheerful Choco sparkles"), new StickerPartial(781324722394103808L, stickerFormatType2, "Cheerful Choco cheers"), new StickerPartial(813951723822645278L, stickerFormatType2, "Cheerful Choco gives thumbs up")};
        SORT_BY_IDS_COMPARATOR = new Comparator<Long>() { // from class: com.discord.utilities.message.MessageUtils$SORT_BY_IDS_COMPARATOR$1
            @Override // java.util.Comparator
            public final int compare(Long l, Long l2) {
                return MessageUtils.compareMessages(l, l2);
            }
        };
    }

    private MessageUtils() {
    }

    public static final int compareMessages(Long messageId1, Long messageId2) {
        long jLongValue = messageId1 != null ? messageId1.longValue() : 0L;
        long jLongValue2 = messageId2 != null ? messageId2.longValue() : 0L;
        if (jLongValue == jLongValue2) {
            return 0;
        }
        return jLongValue < jLongValue2 ? -1 : 1;
    }

    public static final Map<Long, String> getNickOrUsernames(Message message, Channel channel, Map<Long, GuildMember> guildMembers, List<ChannelRecipientNick> nicks) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
        List<User> mentions = message.getMentions();
        HashMap map = new HashMap((mentions != null ? mentions.size() : 0) + 1);
        List<User> mentions2 = message.getMentions();
        if (mentions2 != null) {
            for (User user : mentions2) {
                map.put(Long.valueOf(user.getId()), GuildMember.INSTANCE.getNickOrUsername(new CoreUser(user), guildMembers.get(Long.valueOf(user.getId())), channel, nicks));
            }
        }
        User author = message.getAuthor();
        if (author != null) {
            map.put(Long.valueOf(author.getId()), GuildMember.INSTANCE.getNickOrUsername(new CoreUser(author), guildMembers.get(Long.valueOf(author.getId())), channel, nicks));
        }
        Interaction interaction = message.getInteraction();
        User user2 = interaction != null ? interaction.getUser() : null;
        if (user2 != null) {
            map.put(Long.valueOf(user2.getId()), GuildMember.INSTANCE.getNickOrUsername(new CoreUser(user2), guildMembers.get(Long.valueOf(user2.getId())), channel, nicks));
        }
        return map;
    }

    public static /* synthetic */ Map getNickOrUsernames$default(Message message, Channel channel, Map map, List list, int i, Object obj) {
        if ((i & 8) != 0) {
            list = null;
        }
        return getNickOrUsernames(message, channel, map, list);
    }

    public static final Comparator<Long> getSORT_BY_IDS_COMPARATOR() {
        return SORT_BY_IDS_COMPARATOR;
    }

    public static /* synthetic */ void getSORT_BY_IDS_COMPARATOR$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CharSequence getSystemMessageRoleSubscriptionPurchase$default(MessageUtils messageUtils, Context context, String str, String str2, RoleSubscriptionData roleSubscriptionData, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            function1 = AnonymousClass1.INSTANCE;
        }
        return messageUtils.getSystemMessageRoleSubscriptionPurchase(context, str, str2, roleSubscriptionData, function1);
    }

    public static final boolean isNewer(Long messageId1, Long messageId2) {
        return compareMessages(messageId1, messageId2) < 0;
    }

    public final StickerPartial getRoleSubscriptionPurchaseSticker(long meUserId, long messageId) {
        long snowflake = TimeUtils.parseSnowflake(Long.valueOf(messageId)) + TimeUtils.parseSnowflake(Long.valueOf(meUserId));
        StickerPartial[] stickerPartialArr = ROLE_SUBSCRIPTION_PURCHASE_STICKERS;
        return stickerPartialArr[(int) (snowflake % ((long) stickerPartialArr.length))];
    }

    public final CharSequence getSystemMessageRoleSubscriptionPurchase(Context context, String str, String str2, RoleSubscriptionData roleSubscriptionData, Function1<? super RenderContext, Unit> function1) {
        Intrinsics3.checkNotNullParameter(context, "$this$getSystemMessageRoleSubscriptionPurchase");
        Intrinsics3.checkNotNullParameter(function1, "initializer");
        Locale localeOrNull = ContextExtensions.getLocaleOrNull(context);
        if ((!Intrinsics3.areEqual(localeOrNull != null ? localeOrNull.getLanguage() : null, new Locale("en").getLanguage())) || roleSubscriptionData == null) {
            return FormatUtils.b(context, R.string.reply_quote_message_not_loaded, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        String tierName = roleSubscriptionData.getTierName();
        if (roleSubscriptionData.getTotalMonthsSubscribed() > 0) {
            return FormatUtils.b(context, roleSubscriptionData.getIsRenewal() ? R.string.system_message_role_subscription_renew_with_duration_mobile : R.string.system_message_role_subscription_join_with_duration_mobile, new Object[]{str2, tierName, str, StringResourceUtils.getI18nPluralString(context, R.plurals.system_message_role_subscription_join_with_duration_mobile_months, roleSubscriptionData.getTotalMonthsSubscribed(), Integer.valueOf(roleSubscriptionData.getTotalMonthsSubscribed()))}, function1);
        }
        return FormatUtils.b(context, roleSubscriptionData.getIsRenewal() ? R.string.system_message_role_subscription_renew_mobile : R.string.system_message_role_subscription_join_mobile, new Object[]{str2, tierName, str}, function1);
    }

    public final int getSystemMessageUserJoin(Context context, long messageId) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Locale localeOrNull = ContextExtensions.getLocaleOrNull(context);
        return WELCOME_MESSAGES[(int) (Intrinsics3.areEqual(localeOrNull != null ? localeOrNull.getLanguage() : null, new Locale("en").getLanguage()) ^ true ? 0L : TimeUtils.parseSnowflake(Long.valueOf(messageId)) % ((long) WELCOME_MESSAGES.length))];
    }

    public final StickerPartial getWelcomeSticker(long meUserId, long messageId) {
        long snowflake = TimeUtils.parseSnowflake(Long.valueOf(messageId)) + TimeUtils.parseSnowflake(Long.valueOf(meUserId));
        StickerPartial[] stickerPartialArr = WELCOME_STICKERS;
        return stickerPartialArr[(int) (snowflake % ((long) stickerPartialArr.length))];
    }
}
