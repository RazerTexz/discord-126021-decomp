package com.discord.api.message;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.discord.api.application.Application;
import com.discord.api.botuikit.Component;
import com.discord.api.channel.Channel;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.interaction.Interaction;
import com.discord.api.message.activity.MessageActivity;
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
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: Message.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Message {
    private final MessageActivity activity;
    private final Application application;
    private final Long applicationId;
    private final List<MessageAttachment> attachments;
    private final User author;
    private final MessageCall call;
    private final long channelId;
    private final List<Component> components;
    private final String content;
    private final UtcDateTime editedTimestamp;
    private final List<MessageEmbed> embeds;
    private final Long flags;
    private final Long guildId;
    private final Boolean hit;
    private final long id;
    private final Interaction interaction;
    private final GuildMember member;
    private final Boolean mentionEveryone;
    private final List<Long> mentionRoles;
    private final List<User> mentions;
    private final MessageReference messageReference;
    private final String nonce;
    private final Boolean pinned;
    private final List<MessageReaction> reactions;
    private final Message referencedMessage;
    private final RoleSubscriptionData roleSubscriptionData;
    private final List<StickerPartial> stickerItems;
    private final List<Sticker> stickers;
    private final Channel thread;
    private final UtcDateTime timestamp;
    private final Boolean tts;
    private final Integer type;
    private final Long webhookId;

    public Message(long j, long j2, User user, String str, UtcDateTime utcDateTime, UtcDateTime utcDateTime2, Boolean bool, Boolean bool2, List list, List list2, List list3, List list4, List list5, String str2, Boolean bool3, Long l, Integer num, MessageActivity messageActivity, Application application, Long l2, MessageReference messageReference, Long l3, List list6, List list7, Message message, Interaction interaction, Channel channel, List list8, MessageCall messageCall, Long l4, GuildMember guildMember, Boolean bool4, RoleSubscriptionData roleSubscriptionData, int i, int i2) {
        User user2 = (i & 4) != 0 ? null : user;
        String str3 = (i & 8) != 0 ? null : str;
        UtcDateTime utcDateTime3 = (i & 16) != 0 ? null : utcDateTime;
        UtcDateTime utcDateTime4 = (i & 32) != 0 ? null : utcDateTime2;
        Boolean bool5 = (i & 64) != 0 ? null : bool;
        Boolean bool6 = (i & 128) != 0 ? null : bool2;
        List list9 = (i & 256) != 0 ? null : list;
        List list10 = (i & 512) != 0 ? null : list2;
        List list11 = (i & 1024) != 0 ? null : list3;
        List list12 = (i & 2048) != 0 ? null : list4;
        List list13 = (i & 4096) != 0 ? null : list5;
        String str4 = (i & 8192) != 0 ? null : str2;
        Boolean bool7 = (i & 16384) != 0 ? null : bool3;
        Long l5 = (i & 32768) != 0 ? null : l;
        Integer num2 = (i & 65536) != 0 ? null : num;
        MessageActivity messageActivity2 = (i & 131072) != 0 ? null : messageActivity;
        Application application2 = (i & 262144) != 0 ? null : application;
        Long l6 = (i & 524288) != 0 ? null : l2;
        MessageReference messageReference2 = (i & 1048576) != 0 ? null : messageReference;
        Long l7 = (i & 2097152) != 0 ? null : l3;
        List list14 = (i & 4194304) != 0 ? null : list6;
        List list15 = (i & 8388608) != 0 ? null : list7;
        Message message2 = (i & 16777216) != 0 ? null : message;
        Interaction interaction2 = (i & 33554432) != 0 ? null : interaction;
        Channel channel2 = (i & 67108864) != 0 ? null : channel;
        List list16 = (i & 134217728) != 0 ? null : list8;
        MessageCall messageCall2 = (i & 268435456) != 0 ? null : messageCall;
        Long l8 = (i & 536870912) != 0 ? null : l4;
        int i3 = i & BasicMeasure.EXACTLY;
        int i4 = i & Integer.MIN_VALUE;
        RoleSubscriptionData roleSubscriptionData2 = (i2 & 1) != 0 ? null : roleSubscriptionData;
        this.id = j;
        this.channelId = j2;
        this.author = user2;
        this.content = str3;
        this.timestamp = utcDateTime3;
        this.editedTimestamp = utcDateTime4;
        this.tts = bool5;
        this.mentionEveryone = bool6;
        this.mentions = list9;
        this.mentionRoles = list10;
        this.attachments = list11;
        this.embeds = list12;
        this.reactions = list13;
        this.nonce = str4;
        this.pinned = bool7;
        this.webhookId = l5;
        this.type = num2;
        this.activity = messageActivity2;
        this.application = application2;
        this.applicationId = l6;
        this.messageReference = messageReference2;
        this.flags = l7;
        this.stickers = list14;
        this.stickerItems = list15;
        this.referencedMessage = message2;
        this.interaction = interaction2;
        this.thread = channel2;
        this.components = list16;
        this.call = messageCall2;
        this.guildId = l8;
        this.member = null;
        this.hit = null;
        this.roleSubscriptionData = roleSubscriptionData2;
    }

    public final List<StickerPartial> A() {
        return this.stickerItems;
    }

    public final List<Sticker> B() {
        return this.stickers;
    }

    /* JADX INFO: renamed from: C, reason: from getter */
    public final Channel getThread() {
        return this.thread;
    }

    /* JADX INFO: renamed from: D, reason: from getter */
    public final UtcDateTime getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: E, reason: from getter */
    public final Boolean getTts() {
        return this.tts;
    }

    /* JADX INFO: renamed from: F, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: G, reason: from getter */
    public final Long getWebhookId() {
        return this.webhookId;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final MessageActivity getActivity() {
        return this.activity;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final Long getApplicationId() {
        return this.applicationId;
    }

    public final List<MessageAttachment> d() {
        return this.attachments;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final User getAuthor() {
        return this.author;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Message)) {
            return false;
        }
        Message message = (Message) other;
        return this.id == message.id && this.channelId == message.channelId && Intrinsics3.areEqual(this.author, message.author) && Intrinsics3.areEqual(this.content, message.content) && Intrinsics3.areEqual(this.timestamp, message.timestamp) && Intrinsics3.areEqual(this.editedTimestamp, message.editedTimestamp) && Intrinsics3.areEqual(this.tts, message.tts) && Intrinsics3.areEqual(this.mentionEveryone, message.mentionEveryone) && Intrinsics3.areEqual(this.mentions, message.mentions) && Intrinsics3.areEqual(this.mentionRoles, message.mentionRoles) && Intrinsics3.areEqual(this.attachments, message.attachments) && Intrinsics3.areEqual(this.embeds, message.embeds) && Intrinsics3.areEqual(this.reactions, message.reactions) && Intrinsics3.areEqual(this.nonce, message.nonce) && Intrinsics3.areEqual(this.pinned, message.pinned) && Intrinsics3.areEqual(this.webhookId, message.webhookId) && Intrinsics3.areEqual(this.type, message.type) && Intrinsics3.areEqual(this.activity, message.activity) && Intrinsics3.areEqual(this.application, message.application) && Intrinsics3.areEqual(this.applicationId, message.applicationId) && Intrinsics3.areEqual(this.messageReference, message.messageReference) && Intrinsics3.areEqual(this.flags, message.flags) && Intrinsics3.areEqual(this.stickers, message.stickers) && Intrinsics3.areEqual(this.stickerItems, message.stickerItems) && Intrinsics3.areEqual(this.referencedMessage, message.referencedMessage) && Intrinsics3.areEqual(this.interaction, message.interaction) && Intrinsics3.areEqual(this.thread, message.thread) && Intrinsics3.areEqual(this.components, message.components) && Intrinsics3.areEqual(this.call, message.call) && Intrinsics3.areEqual(this.guildId, message.guildId) && Intrinsics3.areEqual(this.member, message.member) && Intrinsics3.areEqual(this.hit, message.hit) && Intrinsics3.areEqual(this.roleSubscriptionData, message.roleSubscriptionData);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final MessageCall getCall() {
        return this.call;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    public final List<Component> h() {
        return this.components;
    }

    public int hashCode() {
        long j = this.id;
        long j2 = this.channelId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        User user = this.author;
        int iHashCode = (i + (user != null ? user.hashCode() : 0)) * 31;
        String str = this.content;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime = this.timestamp;
        int iHashCode3 = (iHashCode2 + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime2 = this.editedTimestamp;
        int iHashCode4 = (iHashCode3 + (utcDateTime2 != null ? utcDateTime2.hashCode() : 0)) * 31;
        Boolean bool = this.tts;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.mentionEveryone;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        List<User> list = this.mentions;
        int iHashCode7 = (iHashCode6 + (list != null ? list.hashCode() : 0)) * 31;
        List<Long> list2 = this.mentionRoles;
        int iHashCode8 = (iHashCode7 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<MessageAttachment> list3 = this.attachments;
        int iHashCode9 = (iHashCode8 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<MessageEmbed> list4 = this.embeds;
        int iHashCode10 = (iHashCode9 + (list4 != null ? list4.hashCode() : 0)) * 31;
        List<MessageReaction> list5 = this.reactions;
        int iHashCode11 = (iHashCode10 + (list5 != null ? list5.hashCode() : 0)) * 31;
        String str2 = this.nonce;
        int iHashCode12 = (iHashCode11 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool3 = this.pinned;
        int iHashCode13 = (iHashCode12 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Long l = this.webhookId;
        int iHashCode14 = (iHashCode13 + (l != null ? l.hashCode() : 0)) * 31;
        Integer num = this.type;
        int iHashCode15 = (iHashCode14 + (num != null ? num.hashCode() : 0)) * 31;
        MessageActivity messageActivity = this.activity;
        int iHashCode16 = (iHashCode15 + (messageActivity != null ? messageActivity.hashCode() : 0)) * 31;
        Application application = this.application;
        int iHashCode17 = (iHashCode16 + (application != null ? application.hashCode() : 0)) * 31;
        Long l2 = this.applicationId;
        int iHashCode18 = (iHashCode17 + (l2 != null ? l2.hashCode() : 0)) * 31;
        MessageReference messageReference = this.messageReference;
        int iHashCode19 = (iHashCode18 + (messageReference != null ? messageReference.hashCode() : 0)) * 31;
        Long l3 = this.flags;
        int iHashCode20 = (iHashCode19 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<Sticker> list6 = this.stickers;
        int iHashCode21 = (iHashCode20 + (list6 != null ? list6.hashCode() : 0)) * 31;
        List<StickerPartial> list7 = this.stickerItems;
        int iHashCode22 = (iHashCode21 + (list7 != null ? list7.hashCode() : 0)) * 31;
        Message message = this.referencedMessage;
        int iHashCode23 = (iHashCode22 + (message != null ? message.hashCode() : 0)) * 31;
        Interaction interaction = this.interaction;
        int iHashCode24 = (iHashCode23 + (interaction != null ? interaction.hashCode() : 0)) * 31;
        Channel channel = this.thread;
        int iHashCode25 = (iHashCode24 + (channel != null ? channel.hashCode() : 0)) * 31;
        List<Component> list8 = this.components;
        int iHashCode26 = (iHashCode25 + (list8 != null ? list8.hashCode() : 0)) * 31;
        MessageCall messageCall = this.call;
        int iHashCode27 = (iHashCode26 + (messageCall != null ? messageCall.hashCode() : 0)) * 31;
        Long l4 = this.guildId;
        int iHashCode28 = (iHashCode27 + (l4 != null ? l4.hashCode() : 0)) * 31;
        GuildMember guildMember = this.member;
        int iHashCode29 = (iHashCode28 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        Boolean bool4 = this.hit;
        int iHashCode30 = (iHashCode29 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        RoleSubscriptionData roleSubscriptionData = this.roleSubscriptionData;
        return iHashCode30 + (roleSubscriptionData != null ? roleSubscriptionData.hashCode() : 0);
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final UtcDateTime getEditedTimestamp() {
        return this.editedTimestamp;
    }

    public final List<MessageEmbed> k() {
        return this.embeds;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final Long getFlags() {
        return this.flags;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final Boolean getHit() {
        return this.hit;
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: p, reason: from getter */
    public final Interaction getInteraction() {
        return this.interaction;
    }

    /* JADX INFO: renamed from: q, reason: from getter */
    public final GuildMember getMember() {
        return this.member;
    }

    /* JADX INFO: renamed from: r, reason: from getter */
    public final Boolean getMentionEveryone() {
        return this.mentionEveryone;
    }

    public final List<Long> s() {
        return this.mentionRoles;
    }

    public final List<User> t() {
        return this.mentions;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Message(id=");
        sbU.append(this.id);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
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
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", member=");
        sbU.append(this.member);
        sbU.append(", hit=");
        sbU.append(this.hit);
        sbU.append(", roleSubscriptionData=");
        sbU.append(this.roleSubscriptionData);
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX INFO: renamed from: u, reason: from getter */
    public final MessageReference getMessageReference() {
        return this.messageReference;
    }

    /* JADX INFO: renamed from: v, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    /* JADX INFO: renamed from: w, reason: from getter */
    public final Boolean getPinned() {
        return this.pinned;
    }

    public final List<MessageReaction> x() {
        return this.reactions;
    }

    /* JADX INFO: renamed from: y, reason: from getter */
    public final Message getReferencedMessage() {
        return this.referencedMessage;
    }

    /* JADX INFO: renamed from: z, reason: from getter */
    public final RoleSubscriptionData getRoleSubscriptionData() {
        return this.roleSubscriptionData;
    }
}
