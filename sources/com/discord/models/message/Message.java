package com.discord.models.message;

import a0.a.a.b;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.application.Application;
import com.discord.api.botuikit.Component;
import com.discord.api.channel.Channel;
import com.discord.api.interaction.Interaction;
import com.discord.api.message.LocalAttachment;
import com.discord.api.message.MessageReference;
import com.discord.api.message.activity.MessageActivity;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.api.message.attachment.MessageAttachment;
import com.discord.api.message.call.MessageCall;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.message.role_subscription.RoleSubscriptionData;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerPartial;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.captcha.CaptchaHelper;
import d0.g0.Strings4;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: Message.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Message {
    private static final Map<String, MessageReaction> EMPTY_REACTIONS = Maps6.emptyMap();
    private final MessageActivity activity;
    private final MessageAllowedMentions allowedMentions;
    private final Application application;
    private final Long applicationId;
    private final List<MessageAttachment> attachments;
    private final User author;
    private Map<String, MessageReaction> cachedReactionsMap;
    private final MessageCall call;
    private final CaptchaHelper.CaptchaPayload captchaPayload;
    private final long channelId;
    private final List<Component> components;
    private final String content;
    private final UtcDateTime editedTimestamp;
    private final List<MessageEmbed> embeds;
    private final Long flags;
    private final Long guildId;
    private final transient boolean hasLocalUploads;
    private final Boolean hit;
    private final long id;
    private final Long initialAttemptTimestamp;
    private final Interaction interaction;
    private final Long lastManualAttemptTimestamp;
    private final List<LocalAttachment> localAttachments;
    private final Boolean mentionEveryone;
    private final List<Long> mentionRoles;
    private final List<User> mentions;
    private final MessageReference messageReference;
    private final String nonce;
    private final Integer numRetries;
    private final Boolean pinned;
    private final List<MessageReaction> reactions;
    private final com.discord.api.message.Message referencedMessage;
    private final RoleSubscriptionData roleSubscriptionData;
    private final List<StickerPartial> stickerItems;
    private final List<Sticker> stickers;
    private final Channel thread;
    private final UtcDateTime timestamp;
    private final Boolean tts;
    private final Integer type;
    private final Long webhookId;

    /* JADX WARN: Multi-variable type inference failed */
    public Message(long j, long j2, Long l, User user, String str, UtcDateTime utcDateTime, UtcDateTime utcDateTime2, Boolean bool, Boolean bool2, List<User> list, List<Long> list2, List<MessageAttachment> list3, List<MessageEmbed> list4, List<MessageReaction> list5, String str2, Boolean bool3, Long l2, Integer num, MessageActivity messageActivity, Application application, Long l3, MessageReference messageReference, Long l4, List<Sticker> list6, List<StickerPartial> list7, com.discord.api.message.Message message, Interaction interaction, Channel channel, List<? extends Component> list8, MessageCall messageCall, Boolean bool4, RoleSubscriptionData roleSubscriptionData, boolean z2, MessageAllowedMentions messageAllowedMentions, Integer num2, Long l5, Long l6, List<LocalAttachment> list9, CaptchaHelper.CaptchaPayload captchaPayload) {
        this.id = j;
        this.channelId = j2;
        this.guildId = l;
        this.author = user;
        this.content = str;
        this.timestamp = utcDateTime;
        this.editedTimestamp = utcDateTime2;
        this.tts = bool;
        this.mentionEveryone = bool2;
        this.mentions = list;
        this.mentionRoles = list2;
        this.attachments = list3;
        this.embeds = list4;
        this.reactions = list5;
        this.nonce = str2;
        this.pinned = bool3;
        this.webhookId = l2;
        this.type = num;
        this.activity = messageActivity;
        this.application = application;
        this.applicationId = l3;
        this.messageReference = messageReference;
        this.flags = l4;
        this.stickers = list6;
        this.stickerItems = list7;
        this.referencedMessage = message;
        this.interaction = interaction;
        this.thread = channel;
        this.components = list8;
        this.call = messageCall;
        this.hit = bool4;
        this.roleSubscriptionData = roleSubscriptionData;
        this.hasLocalUploads = z2;
        this.allowedMentions = messageAllowedMentions;
        this.numRetries = num2;
        this.lastManualAttemptTimestamp = l5;
        this.initialAttemptTimestamp = l6;
        this.localAttachments = list9;
        this.captchaPayload = captchaPayload;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Message copy$default(Message message, long j, long j2, Long l, User user, String str, UtcDateTime utcDateTime, UtcDateTime utcDateTime2, Boolean bool, Boolean bool2, List list, List list2, List list3, List list4, List list5, String str2, Boolean bool3, Long l2, Integer num, MessageActivity messageActivity, Application application, Long l3, MessageReference messageReference, Long l4, List list6, List list7, com.discord.api.message.Message message2, Interaction interaction, Channel channel, List list8, MessageCall messageCall, Boolean bool4, RoleSubscriptionData roleSubscriptionData, boolean z2, MessageAllowedMentions messageAllowedMentions, Integer num2, Long l5, Long l6, List list9, CaptchaHelper.CaptchaPayload captchaPayload, int i, int i2, Object obj) {
        return message.copy((i & 1) != 0 ? message.id : j, (i & 2) != 0 ? message.channelId : j2, (i & 4) != 0 ? message.guildId : l, (i & 8) != 0 ? message.author : user, (i & 16) != 0 ? message.content : str, (i & 32) != 0 ? message.timestamp : utcDateTime, (i & 64) != 0 ? message.editedTimestamp : utcDateTime2, (i & 128) != 0 ? message.tts : bool, (i & 256) != 0 ? message.mentionEveryone : bool2, (i & 512) != 0 ? message.mentions : list, (i & 1024) != 0 ? message.mentionRoles : list2, (i & 2048) != 0 ? message.attachments : list3, (i & 4096) != 0 ? message.embeds : list4, (i & 8192) != 0 ? message.reactions : list5, (i & 16384) != 0 ? message.nonce : str2, (i & 32768) != 0 ? message.pinned : bool3, (i & 65536) != 0 ? message.webhookId : l2, (i & 131072) != 0 ? message.type : num, (i & 262144) != 0 ? message.activity : messageActivity, (i & 524288) != 0 ? message.application : application, (i & 1048576) != 0 ? message.applicationId : l3, (i & 2097152) != 0 ? message.messageReference : messageReference, (i & 4194304) != 0 ? message.flags : l4, (i & 8388608) != 0 ? message.stickers : list6, (i & 16777216) != 0 ? message.stickerItems : list7, (i & 33554432) != 0 ? message.referencedMessage : message2, (i & 67108864) != 0 ? message.interaction : interaction, (i & 134217728) != 0 ? message.thread : channel, (i & 268435456) != 0 ? message.components : list8, (i & 536870912) != 0 ? message.call : messageCall, (i & BasicMeasure.EXACTLY) != 0 ? message.hit : bool4, (i & Integer.MIN_VALUE) != 0 ? message.roleSubscriptionData : roleSubscriptionData, (i2 & 1) != 0 ? message.hasLocalUploads : z2, (i2 & 2) != 0 ? message.allowedMentions : messageAllowedMentions, (i2 & 4) != 0 ? message.numRetries : num2, (i2 & 8) != 0 ? message.lastManualAttemptTimestamp : l5, (i2 & 16) != 0 ? message.initialAttemptTimestamp : l6, (i2 & 32) != 0 ? message.localAttachments : list9, (i2 & 64) != 0 ? message.captchaPayload : captchaPayload);
    }

    public final boolean canResend() {
        Integer num = this.type;
        return num != null && num.intValue() == -2;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public final List<User> component10() {
        return this.mentions;
    }

    public final List<Long> component11() {
        return this.mentionRoles;
    }

    public final List<MessageAttachment> component12() {
        return this.attachments;
    }

    public final List<MessageEmbed> component13() {
        return this.embeds;
    }

    public final List<MessageReaction> component14() {
        return this.reactions;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Boolean getPinned() {
        return this.pinned;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Long getWebhookId() {
        return this.webhookId;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final MessageActivity getActivity() {
        return this.activity;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final Long getApplicationId() {
        return this.applicationId;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final MessageReference getMessageReference() {
        return this.messageReference;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final Long getFlags() {
        return this.flags;
    }

    public final List<Sticker> component24() {
        return this.stickers;
    }

    public final List<StickerPartial> component25() {
        return this.stickerItems;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final com.discord.api.message.Message getReferencedMessage() {
        return this.referencedMessage;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final Interaction getInteraction() {
        return this.interaction;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final Channel getThread() {
        return this.thread;
    }

    public final List<Component> component29() {
        return this.components;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final MessageCall getCall() {
        return this.call;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final Boolean getHit() {
        return this.hit;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final RoleSubscriptionData getRoleSubscriptionData() {
        return this.roleSubscriptionData;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final boolean getHasLocalUploads() {
        return this.hasLocalUploads;
    }

    /* JADX INFO: renamed from: component34, reason: from getter */
    public final MessageAllowedMentions getAllowedMentions() {
        return this.allowedMentions;
    }

    /* JADX INFO: renamed from: component35, reason: from getter */
    public final Integer getNumRetries() {
        return this.numRetries;
    }

    /* JADX INFO: renamed from: component36, reason: from getter */
    public final Long getLastManualAttemptTimestamp() {
        return this.lastManualAttemptTimestamp;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final Long getInitialAttemptTimestamp() {
        return this.initialAttemptTimestamp;
    }

    public final List<LocalAttachment> component38() {
        return this.localAttachments;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final CaptchaHelper.CaptchaPayload getCaptchaPayload() {
        return this.captchaPayload;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final User getAuthor() {
        return this.author;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final UtcDateTime getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final UtcDateTime getEditedTimestamp() {
        return this.editedTimestamp;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Boolean getTts() {
        return this.tts;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Boolean getMentionEveryone() {
        return this.mentionEveryone;
    }

    public final Message copy(long id2, long channelId, Long guildId, User author, String content, UtcDateTime timestamp, UtcDateTime editedTimestamp, Boolean tts, Boolean mentionEveryone, List<User> mentions, List<Long> mentionRoles, List<MessageAttachment> attachments, List<MessageEmbed> embeds, List<MessageReaction> reactions, String nonce, Boolean pinned, Long webhookId, Integer type, MessageActivity activity, Application application, Long applicationId, MessageReference messageReference, Long flags, List<Sticker> stickers, List<StickerPartial> stickerItems, com.discord.api.message.Message referencedMessage, Interaction interaction, Channel thread, List<? extends Component> components, MessageCall call, Boolean hit, RoleSubscriptionData roleSubscriptionData, boolean hasLocalUploads, MessageAllowedMentions allowedMentions, Integer numRetries, Long lastManualAttemptTimestamp, Long initialAttemptTimestamp, List<LocalAttachment> localAttachments, CaptchaHelper.CaptchaPayload captchaPayload) {
        return new Message(id2, channelId, guildId, author, content, timestamp, editedTimestamp, tts, mentionEveryone, mentions, mentionRoles, attachments, embeds, reactions, nonce, pinned, webhookId, type, activity, application, applicationId, messageReference, flags, stickers, stickerItems, referencedMessage, interaction, thread, components, call, hit, roleSubscriptionData, hasLocalUploads, allowedMentions, numRetries, lastManualAttemptTimestamp, initialAttemptTimestamp, localAttachments, captchaPayload);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Message)) {
            return false;
        }
        Message message = (Message) other;
        return this.id == message.id && this.channelId == message.channelId && Intrinsics3.areEqual(this.guildId, message.guildId) && Intrinsics3.areEqual(this.author, message.author) && Intrinsics3.areEqual(this.content, message.content) && Intrinsics3.areEqual(this.timestamp, message.timestamp) && Intrinsics3.areEqual(this.editedTimestamp, message.editedTimestamp) && Intrinsics3.areEqual(this.tts, message.tts) && Intrinsics3.areEqual(this.mentionEveryone, message.mentionEveryone) && Intrinsics3.areEqual(this.mentions, message.mentions) && Intrinsics3.areEqual(this.mentionRoles, message.mentionRoles) && Intrinsics3.areEqual(this.attachments, message.attachments) && Intrinsics3.areEqual(this.embeds, message.embeds) && Intrinsics3.areEqual(this.reactions, message.reactions) && Intrinsics3.areEqual(this.nonce, message.nonce) && Intrinsics3.areEqual(this.pinned, message.pinned) && Intrinsics3.areEqual(this.webhookId, message.webhookId) && Intrinsics3.areEqual(this.type, message.type) && Intrinsics3.areEqual(this.activity, message.activity) && Intrinsics3.areEqual(this.application, message.application) && Intrinsics3.areEqual(this.applicationId, message.applicationId) && Intrinsics3.areEqual(this.messageReference, message.messageReference) && Intrinsics3.areEqual(this.flags, message.flags) && Intrinsics3.areEqual(this.stickers, message.stickers) && Intrinsics3.areEqual(this.stickerItems, message.stickerItems) && Intrinsics3.areEqual(this.referencedMessage, message.referencedMessage) && Intrinsics3.areEqual(this.interaction, message.interaction) && Intrinsics3.areEqual(this.thread, message.thread) && Intrinsics3.areEqual(this.components, message.components) && Intrinsics3.areEqual(this.call, message.call) && Intrinsics3.areEqual(this.hit, message.hit) && Intrinsics3.areEqual(this.roleSubscriptionData, message.roleSubscriptionData) && this.hasLocalUploads == message.hasLocalUploads && Intrinsics3.areEqual(this.allowedMentions, message.allowedMentions) && Intrinsics3.areEqual(this.numRetries, message.numRetries) && Intrinsics3.areEqual(this.lastManualAttemptTimestamp, message.lastManualAttemptTimestamp) && Intrinsics3.areEqual(this.initialAttemptTimestamp, message.initialAttemptTimestamp) && Intrinsics3.areEqual(this.localAttachments, message.localAttachments) && Intrinsics3.areEqual(this.captchaPayload, message.captchaPayload);
    }

    public final MessageActivity getActivity() {
        return this.activity;
    }

    public final MessageAllowedMentions getAllowedMentions() {
        return this.allowedMentions;
    }

    public final Application getApplication() {
        return this.application;
    }

    public final Long getApplicationId() {
        return this.applicationId;
    }

    public final List<MessageAttachment> getAttachments() {
        return this.attachments;
    }

    public final User getAuthor() {
        return this.author;
    }

    public final MessageCall getCall() {
        return this.call;
    }

    public final long getCallDuration() {
        UtcDateTime utcDateTimeA;
        UtcDateTime utcDateTime;
        MessageCall messageCall = this.call;
        if (messageCall == null || (utcDateTimeA = messageCall.getEndedTimestamp()) == null || (utcDateTime = this.timestamp) == null) {
            return 0L;
        }
        return utcDateTimeA.getDateTimeMillis() - utcDateTime.getDateTimeMillis();
    }

    public final CaptchaHelper.CaptchaPayload getCaptchaPayload() {
        return this.captchaPayload;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final List<Component> getComponents() {
        return this.components;
    }

    public final String getContent() {
        return this.content;
    }

    public final UtcDateTime getEditedTimestamp() {
        return this.editedTimestamp;
    }

    public final List<MessageEmbed> getEmbeds() {
        return this.embeds;
    }

    public final Long getFlags() {
        return this.flags;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final boolean getHasLocalUploads() {
        return this.hasLocalUploads;
    }

    public final Boolean getHit() {
        return this.hit;
    }

    public final long getId() {
        return this.id;
    }

    public final Long getInitialAttemptTimestamp() {
        return this.initialAttemptTimestamp;
    }

    public final Interaction getInteraction() {
        return this.interaction;
    }

    public final Long getLastManualAttemptTimestamp() {
        return this.lastManualAttemptTimestamp;
    }

    public final List<LocalAttachment> getLocalAttachments() {
        return this.localAttachments;
    }

    public final Boolean getMentionEveryone() {
        return this.mentionEveryone;
    }

    public final List<Long> getMentionRoles() {
        return this.mentionRoles;
    }

    public final List<User> getMentions() {
        return this.mentions;
    }

    public final MessageReference getMessageReference() {
        return this.messageReference;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final Integer getNumRetries() {
        return this.numRetries;
    }

    public final Boolean getPinned() {
        return this.pinned;
    }

    public final List<MessageReaction> getReactions() {
        return this.reactions;
    }

    public final Map<String, MessageReaction> getReactionsMap() {
        Map<String, MessageReaction> map = this.cachedReactionsMap;
        if (map != null) {
            Intrinsics3.checkNotNull(map);
        } else {
            List<MessageReaction> list = this.reactions;
            if (list == null || !(!list.isEmpty())) {
                map = EMPTY_REACTIONS;
            } else {
                List<MessageReaction> list2 = this.reactions;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : list2) {
                    linkedHashMap.put(((MessageReaction) obj).getEmoji().c(), obj);
                }
                map = linkedHashMap;
            }
            this.cachedReactionsMap = map;
        }
        return map;
    }

    public final com.discord.api.message.Message getReferencedMessage() {
        return this.referencedMessage;
    }

    public final RoleSubscriptionData getRoleSubscriptionData() {
        return this.roleSubscriptionData;
    }

    public final List<StickerPartial> getStickerItems() {
        return this.stickerItems;
    }

    public final List<Sticker> getStickers() {
        return this.stickers;
    }

    public final Channel getThread() {
        return this.thread;
    }

    public final UtcDateTime getTimestamp() {
        return this.timestamp;
    }

    public final Boolean getTts() {
        return this.tts;
    }

    public final Integer getType() {
        return this.type;
    }

    public final Long getWebhookId() {
        return this.webhookId;
    }

    public final boolean hasAttachments() {
        List<MessageAttachment> list = this.attachments;
        return !(list == null || list.isEmpty());
    }

    public final boolean hasEmbeds() {
        List<MessageEmbed> list = this.embeds;
        return !(list == null || list.isEmpty());
    }

    public final boolean hasFlag(long flag) {
        Long l = this.flags;
        return ((l != null ? l.longValue() : 0L) & flag) == flag;
    }

    public final boolean hasStickers() {
        List<Sticker> list = this.stickers;
        if (list == null || list.isEmpty()) {
            List<StickerPartial> list2 = this.stickerItems;
            if (list2 == null || list2.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final boolean hasThread() {
        return hasFlag(32L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v116 */
    /* JADX WARN: Type inference failed for: r0v147 */
    /* JADX WARN: Type inference failed for: r0v94, types: [int] */
    /* JADX WARN: Type inference failed for: r1v64, types: [int] */
    public int hashCode() {
        int iA = (b.a(this.channelId) + (b.a(this.id) * 31)) * 31;
        Long l = this.guildId;
        int iHashCode = (iA + (l != null ? l.hashCode() : 0)) * 31;
        User user = this.author;
        int iHashCode2 = (iHashCode + (user != null ? user.hashCode() : 0)) * 31;
        String str = this.content;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime = this.timestamp;
        int iHashCode4 = (iHashCode3 + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime2 = this.editedTimestamp;
        int iHashCode5 = (iHashCode4 + (utcDateTime2 != null ? utcDateTime2.hashCode() : 0)) * 31;
        Boolean bool = this.tts;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.mentionEveryone;
        int iHashCode7 = (iHashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        List<User> list = this.mentions;
        int iHashCode8 = (iHashCode7 + (list != null ? list.hashCode() : 0)) * 31;
        List<Long> list2 = this.mentionRoles;
        int iHashCode9 = (iHashCode8 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<MessageAttachment> list3 = this.attachments;
        int iHashCode10 = (iHashCode9 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<MessageEmbed> list4 = this.embeds;
        int iHashCode11 = (iHashCode10 + (list4 != null ? list4.hashCode() : 0)) * 31;
        List<MessageReaction> list5 = this.reactions;
        int iHashCode12 = (iHashCode11 + (list5 != null ? list5.hashCode() : 0)) * 31;
        String str2 = this.nonce;
        int iHashCode13 = (iHashCode12 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool3 = this.pinned;
        int iHashCode14 = (iHashCode13 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Long l2 = this.webhookId;
        int iHashCode15 = (iHashCode14 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Integer num = this.type;
        int iHashCode16 = (iHashCode15 + (num != null ? num.hashCode() : 0)) * 31;
        MessageActivity messageActivity = this.activity;
        int iHashCode17 = (iHashCode16 + (messageActivity != null ? messageActivity.hashCode() : 0)) * 31;
        Application application = this.application;
        int iHashCode18 = (iHashCode17 + (application != null ? application.hashCode() : 0)) * 31;
        Long l3 = this.applicationId;
        int iHashCode19 = (iHashCode18 + (l3 != null ? l3.hashCode() : 0)) * 31;
        MessageReference messageReference = this.messageReference;
        int iHashCode20 = (iHashCode19 + (messageReference != null ? messageReference.hashCode() : 0)) * 31;
        Long l4 = this.flags;
        int iHashCode21 = (iHashCode20 + (l4 != null ? l4.hashCode() : 0)) * 31;
        List<Sticker> list6 = this.stickers;
        int iHashCode22 = (iHashCode21 + (list6 != null ? list6.hashCode() : 0)) * 31;
        List<StickerPartial> list7 = this.stickerItems;
        int iHashCode23 = (iHashCode22 + (list7 != null ? list7.hashCode() : 0)) * 31;
        com.discord.api.message.Message message = this.referencedMessage;
        int iHashCode24 = (iHashCode23 + (message != null ? message.hashCode() : 0)) * 31;
        Interaction interaction = this.interaction;
        int iHashCode25 = (iHashCode24 + (interaction != null ? interaction.hashCode() : 0)) * 31;
        Channel channel = this.thread;
        int iHashCode26 = (iHashCode25 + (channel != null ? channel.hashCode() : 0)) * 31;
        List<Component> list8 = this.components;
        int iHashCode27 = (iHashCode26 + (list8 != null ? list8.hashCode() : 0)) * 31;
        MessageCall messageCall = this.call;
        int iHashCode28 = (iHashCode27 + (messageCall != null ? messageCall.hashCode() : 0)) * 31;
        Boolean bool4 = this.hit;
        int iHashCode29 = (iHashCode28 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        RoleSubscriptionData roleSubscriptionData = this.roleSubscriptionData;
        int iHashCode30 = (iHashCode29 + (roleSubscriptionData != null ? roleSubscriptionData.hashCode() : 0)) * 31;
        boolean z2 = this.hasLocalUploads;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (iHashCode30 + r0) * 31;
        MessageAllowedMentions messageAllowedMentions = this.allowedMentions;
        int iHashCode31 = (i + (messageAllowedMentions != null ? messageAllowedMentions.hashCode() : 0)) * 31;
        Integer num2 = this.numRetries;
        int iHashCode32 = (iHashCode31 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Long l5 = this.lastManualAttemptTimestamp;
        int iHashCode33 = (iHashCode32 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.initialAttemptTimestamp;
        int iHashCode34 = (iHashCode33 + (l6 != null ? l6.hashCode() : 0)) * 31;
        List<LocalAttachment> list9 = this.localAttachments;
        int iHashCode35 = (iHashCode34 + (list9 != null ? list9.hashCode() : 0)) * 31;
        CaptchaHelper.CaptchaPayload captchaPayload = this.captchaPayload;
        return iHashCode35 + (captchaPayload != null ? captchaPayload.hashCode() : 0);
    }

    public final boolean isApplicationMessage() {
        Integer num;
        Integer num2 = this.type;
        return (num2 != null && num2.intValue() == 20) || ((num = this.type) != null && num.intValue() == 23);
    }

    public final boolean isCrosspost() {
        return hasFlag(2L);
    }

    public final boolean isCrossposted() {
        return hasFlag(1L);
    }

    public final boolean isEmbeddedMessageType() {
        Integer num;
        Integer num2 = this.type;
        return (num2 != null && num2.intValue() == 19) || ((num = this.type) != null && num.intValue() == 21);
    }

    public final boolean isEphemeralMessage() {
        return hasFlag(64L);
    }

    public final boolean isFailed() {
        Integer num;
        Integer num2;
        Integer num3 = this.type;
        return (num3 != null && num3.intValue() == -3) || ((num = this.type) != null && num.intValue() == -2) || ((num2 = this.type) != null && num2.intValue() == -4);
    }

    public final boolean isInteraction() {
        Integer num;
        Integer num2 = this.type;
        return (num2 != null && num2.intValue() == -5) || ((num = this.type) != null && num.intValue() == -4) || this.interaction != null;
    }

    public final boolean isLoading() {
        return hasFlag(128L);
    }

    public final boolean isLocal() {
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4 = this.type;
        return (num4 != null && num4.intValue() == -1) || ((num = this.type) != null && num.intValue() == -2) || (((num2 = this.type) != null && num2.intValue() == -3) || isLocalApplicationCommand() || ((num3 = this.type) != null && num3.intValue() == -6));
    }

    public final boolean isLocalApplicationCommand() {
        Integer num;
        Integer num2 = this.type;
        return (num2 != null && num2.intValue() == -5) || ((num = this.type) != null && num.intValue() == -4);
    }

    public final boolean isSourceDeleted() {
        return hasFlag(8L);
    }

    public final boolean isSpotifyListeningActivity() {
        MessageActivity messageActivity = this.activity;
        return messageActivity != null && messageActivity.getType() == MessageActivityType.LISTEN && Strings4.contains$default((CharSequence) messageActivity.getPartyId(), (CharSequence) "spotify", false, 2, (Object) null);
    }

    public final boolean isSystemMessage() {
        return (isUserMessage() || isApplicationMessage()) ? false : true;
    }

    public final boolean isUrgent() {
        return hasFlag(16L);
    }

    public final boolean isUserMessage() {
        Integer num;
        Integer num2 = this.type;
        return (num2 != null && num2.intValue() == 0) || ((num = this.type) != null && num.intValue() == 19);
    }

    public final boolean isWebhook() {
        return this.webhookId != null;
    }

    public final Message merge(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "new");
        long jO = message.getId();
        long jG = message.getChannelId() != 0 ? message.getChannelId() : this.channelId;
        Long lM = message.getGuildId();
        if (lM == null) {
            lM = this.guildId;
        }
        Long l = lM;
        User userE = message.getAuthor();
        if (userE == null) {
            userE = this.author;
        }
        User user = userE;
        String strI = message.getContent();
        if (strI == null) {
            strI = this.content;
        }
        String str = strI;
        UtcDateTime utcDateTimeD = message.getTimestamp();
        if (utcDateTimeD == null) {
            utcDateTimeD = this.timestamp;
        }
        UtcDateTime utcDateTime = utcDateTimeD;
        UtcDateTime utcDateTimeJ = message.getEditedTimestamp();
        if (utcDateTimeJ == null) {
            utcDateTimeJ = this.editedTimestamp;
        }
        UtcDateTime utcDateTime2 = utcDateTimeJ;
        List<MessageAttachment> listD = message.d();
        if (listD == null) {
            listD = this.attachments;
        }
        List<MessageAttachment> list = listD;
        List<MessageEmbed> listK = message.k();
        if (listK == null) {
            listK = this.embeds;
        }
        List<MessageEmbed> list2 = listK;
        Boolean boolE = message.getTts();
        if (boolE == null) {
            boolE = this.tts;
        }
        Boolean bool = boolE;
        Boolean boolR = message.getMentionEveryone();
        if (boolR == null) {
            boolR = this.mentionEveryone;
        }
        Boolean bool2 = boolR;
        List<User> listT = message.t();
        if (listT == null) {
            listT = this.mentions;
        }
        List<User> list3 = listT;
        List<Long> listS = message.s();
        if (listS == null) {
            listS = this.mentionRoles;
        }
        List<Long> list4 = listS;
        List<MessageReaction> listX = message.x();
        if (listX == null) {
            listX = this.reactions;
        }
        List<MessageReaction> list5 = listX;
        String strV = message.getNonce();
        if (strV == null) {
            strV = this.nonce;
        }
        String str2 = strV;
        Boolean boolW = message.getPinned();
        if (boolW == null) {
            boolW = this.pinned;
        }
        Boolean bool3 = boolW;
        Long lG = message.getWebhookId();
        if (lG == null) {
            lG = this.webhookId;
        }
        Long l2 = lG;
        Integer numF = message.getType();
        if (numF == null) {
            numF = this.type;
        }
        Integer num = numF;
        MessageActivity messageActivityA = message.getActivity();
        if (messageActivityA == null) {
            messageActivityA = this.activity;
        }
        MessageActivity messageActivity = messageActivityA;
        Application applicationB = message.getApplication();
        if (applicationB == null) {
            applicationB = this.application;
        }
        Application application = applicationB;
        Long lC = message.getApplicationId();
        if (lC == null) {
            lC = this.applicationId;
        }
        Long l3 = lC;
        MessageReference messageReferenceU = message.getMessageReference();
        if (messageReferenceU == null) {
            messageReferenceU = this.messageReference;
        }
        MessageReference messageReference = messageReferenceU;
        Long l4 = message.getFlags();
        if (l4 == null) {
            l4 = this.flags;
        }
        Long l5 = l4;
        List<Sticker> listB = message.B();
        if (listB == null) {
            listB = this.stickers;
        }
        List<Sticker> list6 = listB;
        List<StickerPartial> listA = message.A();
        if (listA == null) {
            listA = this.stickerItems;
        }
        List<StickerPartial> list7 = listA;
        com.discord.api.message.Message messageY = message.getReferencedMessage();
        if (messageY == null) {
            messageY = this.referencedMessage;
        }
        com.discord.api.message.Message message2 = messageY;
        Interaction interactionP = message.getInteraction();
        if (interactionP == null) {
            interactionP = this.interaction;
        }
        Interaction interaction = interactionP;
        Channel channelC = message.getThread();
        if (channelC == null) {
            channelC = this.thread;
        }
        Channel channel = channelC;
        List<Component> listH = message.h();
        if (listH == null) {
            listH = this.components;
        }
        List<Component> list8 = listH;
        MessageCall messageCallF = message.getCall();
        if (messageCallF == null) {
            messageCallF = this.call;
        }
        MessageCall messageCall = messageCallF;
        RoleSubscriptionData roleSubscriptionDataZ = message.getRoleSubscriptionData();
        if (roleSubscriptionDataZ == null) {
            roleSubscriptionDataZ = this.roleSubscriptionData;
        }
        return copy$default(this, jO, jG, l, user, str, utcDateTime, utcDateTime2, bool, bool2, list3, list4, list, list2, list5, str2, bool3, l2, num, messageActivity, application, l3, messageReference, l5, list6, list7, message2, interaction, channel, list8, messageCall, null, roleSubscriptionDataZ, false, null, null, null, null, null, null, BasicMeasure.EXACTLY, Opcodes.LAND, null);
    }

    public final boolean shouldShowReplyPreviewAsAttachment() {
        return (this.activity == null || this.application == null) ? false : true;
    }

    public final com.discord.api.message.Message synthesizeApiMessage() {
        return new com.discord.api.message.Message(this.id, this.channelId, this.author, this.content, this.timestamp, this.editedTimestamp, this.tts, this.mentionEveryone, this.mentions, this.mentionRoles, this.attachments, this.embeds, this.reactions, this.nonce, this.pinned, this.webhookId, this.type, this.activity, this.application, this.applicationId, this.messageReference, this.flags, this.stickers, this.stickerItems, this.referencedMessage, this.interaction, this.thread, this.components, this.call, this.guildId, null, null, this.roleSubscriptionData, -1073741824, 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Message(id=");
        sbU.append(this.id);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", author=");
        sbU.append(this.author);
        sbU.append(", content=");
        sbU.append(this.content);
        sbU.append(", timestamp=");
        sbU.append(this.timestamp);
        sbU.append(", editedTimestamp=");
        sbU.append(this.editedTimestamp);
        sbU.append(", tts=");
        sbU.append(this.tts);
        sbU.append(", mentionEveryone=");
        sbU.append(this.mentionEveryone);
        sbU.append(", mentions=");
        sbU.append(this.mentions);
        sbU.append(", mentionRoles=");
        sbU.append(this.mentionRoles);
        sbU.append(", attachments=");
        sbU.append(this.attachments);
        sbU.append(", embeds=");
        sbU.append(this.embeds);
        sbU.append(", reactions=");
        sbU.append(this.reactions);
        sbU.append(", nonce=");
        sbU.append(this.nonce);
        sbU.append(", pinned=");
        sbU.append(this.pinned);
        sbU.append(", webhookId=");
        sbU.append(this.webhookId);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", activity=");
        sbU.append(this.activity);
        sbU.append(", application=");
        sbU.append(this.application);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", messageReference=");
        sbU.append(this.messageReference);
        sbU.append(", flags=");
        sbU.append(this.flags);
        sbU.append(", stickers=");
        sbU.append(this.stickers);
        sbU.append(", stickerItems=");
        sbU.append(this.stickerItems);
        sbU.append(", referencedMessage=");
        sbU.append(this.referencedMessage);
        sbU.append(", interaction=");
        sbU.append(this.interaction);
        sbU.append(", thread=");
        sbU.append(this.thread);
        sbU.append(", components=");
        sbU.append(this.components);
        sbU.append(", call=");
        sbU.append(this.call);
        sbU.append(", hit=");
        sbU.append(this.hit);
        sbU.append(", roleSubscriptionData=");
        sbU.append(this.roleSubscriptionData);
        sbU.append(", hasLocalUploads=");
        sbU.append(this.hasLocalUploads);
        sbU.append(", allowedMentions=");
        sbU.append(this.allowedMentions);
        sbU.append(", numRetries=");
        sbU.append(this.numRetries);
        sbU.append(", lastManualAttemptTimestamp=");
        sbU.append(this.lastManualAttemptTimestamp);
        sbU.append(", initialAttemptTimestamp=");
        sbU.append(this.initialAttemptTimestamp);
        sbU.append(", localAttachments=");
        sbU.append(this.localAttachments);
        sbU.append(", captchaPayload=");
        sbU.append(this.captchaPayload);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ Message(long j, long j2, Long l, User user, String str, UtcDateTime utcDateTime, UtcDateTime utcDateTime2, Boolean bool, Boolean bool2, List list, List list2, List list3, List list4, List list5, String str2, Boolean bool3, Long l2, Integer num, MessageActivity messageActivity, Application application, Long l3, MessageReference messageReference, Long l4, List list6, List list7, com.discord.api.message.Message message, Interaction interaction, Channel channel, List list8, MessageCall messageCall, Boolean bool4, RoleSubscriptionData roleSubscriptionData, boolean z2, MessageAllowedMentions messageAllowedMentions, Integer num2, Long l5, Long l6, List list9, CaptchaHelper.CaptchaPayload captchaPayload, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : user, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : utcDateTime, (i & 64) != 0 ? null : utcDateTime2, (i & 128) != 0 ? null : bool, (i & 256) != 0 ? null : bool2, (i & 512) != 0 ? null : list, (i & 1024) != 0 ? null : list2, (i & 2048) != 0 ? null : list3, (i & 4096) != 0 ? null : list4, (i & 8192) != 0 ? null : list5, (i & 16384) != 0 ? null : str2, (32768 & i) != 0 ? null : bool3, (65536 & i) != 0 ? null : l2, (131072 & i) != 0 ? null : num, (262144 & i) != 0 ? null : messageActivity, (524288 & i) != 0 ? null : application, (1048576 & i) != 0 ? null : l3, (2097152 & i) != 0 ? null : messageReference, (4194304 & i) != 0 ? null : l4, (8388608 & i) != 0 ? null : list6, (16777216 & i) != 0 ? null : list7, (33554432 & i) != 0 ? null : message, (67108864 & i) != 0 ? null : interaction, (134217728 & i) != 0 ? null : channel, (268435456 & i) != 0 ? null : list8, (536870912 & i) != 0 ? null : messageCall, (1073741824 & i) != 0 ? null : bool4, (i & Integer.MIN_VALUE) != 0 ? null : roleSubscriptionData, (i2 & 1) != 0 ? false : z2, (i2 & 2) != 0 ? null : messageAllowedMentions, (i2 & 4) != 0 ? null : num2, (i2 & 8) != 0 ? null : l5, (i2 & 16) != 0 ? null : l6, (i2 & 32) != 0 ? null : list9, (i2 & 64) != 0 ? null : captchaPayload);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Message(com.discord.api.message.Message message) {
        this(message.getId(), message.getChannelId(), message.getGuildId(), message.getAuthor(), message.getContent(), message.getTimestamp(), message.getEditedTimestamp(), message.getTts(), message.getMentionEveryone(), message.t(), message.s(), message.d(), message.k(), message.x(), message.getNonce(), message.getPinned(), message.getWebhookId(), message.getType(), message.getActivity(), message.getApplication(), message.getApplicationId(), message.getMessageReference(), message.getFlags(), message.B(), message.A(), message.getReferencedMessage(), message.getInteraction(), message.getThread(), message.h(), message.getCall(), message.getHit(), message.getRoleSubscriptionData(), false, null, null, null, null, null, null, 0, Opcodes.LAND, null);
        Intrinsics3.checkNotNullParameter(message, "message");
    }
}
