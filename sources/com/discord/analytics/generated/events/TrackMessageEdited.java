package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackMessageEdited.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMessageEdited implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long messageId = null;
    private final Long messageType = null;
    private final Long channel = null;
    private final Long channelType = null;
    private final Boolean private = null;
    private final Long server = null;
    private final Long numAttachments = null;
    private final Long maxAttachmentSize = null;
    private final List<Long> recipientIds = null;
    private final List<Long> mentionIds = null;
    private final Long length = null;
    private final Long wordCount = null;
    private final Long emojiUnicode = null;
    private final Long emojiCustom = null;
    private final Long emojiCustomExternal = null;
    private final Long emojiManaged = null;
    private final Long emojiManagedExternal = null;
    private final Long emojiAnimated = null;
    private final Boolean emojiOnly = null;
    private final Long numEmbeds = null;
    private final Long clientApplicationId = null;
    private final Long applicationId = null;
    private final List<Long> attachmentIds = null;
    private final Long activityAction = null;
    private final CharSequence activityPartyPlatform = null;
    private final Boolean hasSpoiler = null;
    private final Boolean probablyHasMarkdown = null;
    private final Long referenceMessageId = null;
    private final Long referenceMessageChannel = null;
    private final Long referenceMessageGuild = null;
    private final Long replyAgeSeconds = null;
    private final List<Long> stickerIds = null;
    private final Long numUrls = null;
    private final Long numMentions = null;
    private final List<Long> mentionRoleIds = null;
    private final transient String analyticsSchemaTypeName = "message_edited";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMessageEdited)) {
            return false;
        }
        TrackMessageEdited trackMessageEdited = (TrackMessageEdited) other;
        return C12238m.areEqual(this.messageId, trackMessageEdited.messageId) && C12238m.areEqual(this.messageType, trackMessageEdited.messageType) && C12238m.areEqual(this.channel, trackMessageEdited.channel) && C12238m.areEqual(this.channelType, trackMessageEdited.channelType) && C12238m.areEqual(this.private, trackMessageEdited.private) && C12238m.areEqual(this.server, trackMessageEdited.server) && C12238m.areEqual(this.numAttachments, trackMessageEdited.numAttachments) && C12238m.areEqual(this.maxAttachmentSize, trackMessageEdited.maxAttachmentSize) && C12238m.areEqual(this.recipientIds, trackMessageEdited.recipientIds) && C12238m.areEqual(this.mentionIds, trackMessageEdited.mentionIds) && C12238m.areEqual(this.length, trackMessageEdited.length) && C12238m.areEqual(this.wordCount, trackMessageEdited.wordCount) && C12238m.areEqual(this.emojiUnicode, trackMessageEdited.emojiUnicode) && C12238m.areEqual(this.emojiCustom, trackMessageEdited.emojiCustom) && C12238m.areEqual(this.emojiCustomExternal, trackMessageEdited.emojiCustomExternal) && C12238m.areEqual(this.emojiManaged, trackMessageEdited.emojiManaged) && C12238m.areEqual(this.emojiManagedExternal, trackMessageEdited.emojiManagedExternal) && C12238m.areEqual(this.emojiAnimated, trackMessageEdited.emojiAnimated) && C12238m.areEqual(this.emojiOnly, trackMessageEdited.emojiOnly) && C12238m.areEqual(this.numEmbeds, trackMessageEdited.numEmbeds) && C12238m.areEqual(this.clientApplicationId, trackMessageEdited.clientApplicationId) && C12238m.areEqual(this.applicationId, trackMessageEdited.applicationId) && C12238m.areEqual(this.attachmentIds, trackMessageEdited.attachmentIds) && C12238m.areEqual(this.activityAction, trackMessageEdited.activityAction) && C12238m.areEqual(this.activityPartyPlatform, trackMessageEdited.activityPartyPlatform) && C12238m.areEqual(this.hasSpoiler, trackMessageEdited.hasSpoiler) && C12238m.areEqual(this.probablyHasMarkdown, trackMessageEdited.probablyHasMarkdown) && C12238m.areEqual(this.referenceMessageId, trackMessageEdited.referenceMessageId) && C12238m.areEqual(this.referenceMessageChannel, trackMessageEdited.referenceMessageChannel) && C12238m.areEqual(this.referenceMessageGuild, trackMessageEdited.referenceMessageGuild) && C12238m.areEqual(this.replyAgeSeconds, trackMessageEdited.replyAgeSeconds) && C12238m.areEqual(this.stickerIds, trackMessageEdited.stickerIds) && C12238m.areEqual(this.numUrls, trackMessageEdited.numUrls) && C12238m.areEqual(this.numMentions, trackMessageEdited.numMentions) && C12238m.areEqual(this.mentionRoleIds, trackMessageEdited.mentionRoleIds);
    }

    public int hashCode() {
        Long l = this.messageId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.messageType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.channel;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.channelType;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Boolean bool = this.private;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l5 = this.server;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.numAttachments;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.maxAttachmentSize;
        int iHashCode8 = (iHashCode7 + (l7 != null ? l7.hashCode() : 0)) * 31;
        List<Long> list = this.recipientIds;
        int iHashCode9 = (iHashCode8 + (list != null ? list.hashCode() : 0)) * 31;
        List<Long> list2 = this.mentionIds;
        int iHashCode10 = (iHashCode9 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Long l8 = this.length;
        int iHashCode11 = (iHashCode10 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.wordCount;
        int iHashCode12 = (iHashCode11 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.emojiUnicode;
        int iHashCode13 = (iHashCode12 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.emojiCustom;
        int iHashCode14 = (iHashCode13 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.emojiCustomExternal;
        int iHashCode15 = (iHashCode14 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.emojiManaged;
        int iHashCode16 = (iHashCode15 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.emojiManagedExternal;
        int iHashCode17 = (iHashCode16 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.emojiAnimated;
        int iHashCode18 = (iHashCode17 + (l15 != null ? l15.hashCode() : 0)) * 31;
        Boolean bool2 = this.emojiOnly;
        int iHashCode19 = (iHashCode18 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l16 = this.numEmbeds;
        int iHashCode20 = (iHashCode19 + (l16 != null ? l16.hashCode() : 0)) * 31;
        Long l17 = this.clientApplicationId;
        int iHashCode21 = (iHashCode20 + (l17 != null ? l17.hashCode() : 0)) * 31;
        Long l18 = this.applicationId;
        int iHashCode22 = (iHashCode21 + (l18 != null ? l18.hashCode() : 0)) * 31;
        List<Long> list3 = this.attachmentIds;
        int iHashCode23 = (iHashCode22 + (list3 != null ? list3.hashCode() : 0)) * 31;
        Long l19 = this.activityAction;
        int iHashCode24 = (iHashCode23 + (l19 != null ? l19.hashCode() : 0)) * 31;
        CharSequence charSequence = this.activityPartyPlatform;
        int iHashCode25 = (iHashCode24 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool3 = this.hasSpoiler;
        int iHashCode26 = (iHashCode25 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.probablyHasMarkdown;
        int iHashCode27 = (iHashCode26 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Long l20 = this.referenceMessageId;
        int iHashCode28 = (iHashCode27 + (l20 != null ? l20.hashCode() : 0)) * 31;
        Long l21 = this.referenceMessageChannel;
        int iHashCode29 = (iHashCode28 + (l21 != null ? l21.hashCode() : 0)) * 31;
        Long l22 = this.referenceMessageGuild;
        int iHashCode30 = (iHashCode29 + (l22 != null ? l22.hashCode() : 0)) * 31;
        Long l23 = this.replyAgeSeconds;
        int iHashCode31 = (iHashCode30 + (l23 != null ? l23.hashCode() : 0)) * 31;
        List<Long> list4 = this.stickerIds;
        int iHashCode32 = (iHashCode31 + (list4 != null ? list4.hashCode() : 0)) * 31;
        Long l24 = this.numUrls;
        int iHashCode33 = (iHashCode32 + (l24 != null ? l24.hashCode() : 0)) * 31;
        Long l25 = this.numMentions;
        int iHashCode34 = (iHashCode33 + (l25 != null ? l25.hashCode() : 0)) * 31;
        List<Long> list5 = this.mentionRoleIds;
        return iHashCode34 + (list5 != null ? list5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackMessageEdited(messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", messageType=");
        sbM833U.append(this.messageType);
        sbM833U.append(", channel=");
        sbM833U.append(this.channel);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", private=");
        sbM833U.append(this.private);
        sbM833U.append(", server=");
        sbM833U.append(this.server);
        sbM833U.append(", numAttachments=");
        sbM833U.append(this.numAttachments);
        sbM833U.append(", maxAttachmentSize=");
        sbM833U.append(this.maxAttachmentSize);
        sbM833U.append(", recipientIds=");
        sbM833U.append(this.recipientIds);
        sbM833U.append(", mentionIds=");
        sbM833U.append(this.mentionIds);
        sbM833U.append(", length=");
        sbM833U.append(this.length);
        sbM833U.append(", wordCount=");
        sbM833U.append(this.wordCount);
        sbM833U.append(", emojiUnicode=");
        sbM833U.append(this.emojiUnicode);
        sbM833U.append(", emojiCustom=");
        sbM833U.append(this.emojiCustom);
        sbM833U.append(", emojiCustomExternal=");
        sbM833U.append(this.emojiCustomExternal);
        sbM833U.append(", emojiManaged=");
        sbM833U.append(this.emojiManaged);
        sbM833U.append(", emojiManagedExternal=");
        sbM833U.append(this.emojiManagedExternal);
        sbM833U.append(", emojiAnimated=");
        sbM833U.append(this.emojiAnimated);
        sbM833U.append(", emojiOnly=");
        sbM833U.append(this.emojiOnly);
        sbM833U.append(", numEmbeds=");
        sbM833U.append(this.numEmbeds);
        sbM833U.append(", clientApplicationId=");
        sbM833U.append(this.clientApplicationId);
        sbM833U.append(", applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", attachmentIds=");
        sbM833U.append(this.attachmentIds);
        sbM833U.append(", activityAction=");
        sbM833U.append(this.activityAction);
        sbM833U.append(", activityPartyPlatform=");
        sbM833U.append(this.activityPartyPlatform);
        sbM833U.append(", hasSpoiler=");
        sbM833U.append(this.hasSpoiler);
        sbM833U.append(", probablyHasMarkdown=");
        sbM833U.append(this.probablyHasMarkdown);
        sbM833U.append(", referenceMessageId=");
        sbM833U.append(this.referenceMessageId);
        sbM833U.append(", referenceMessageChannel=");
        sbM833U.append(this.referenceMessageChannel);
        sbM833U.append(", referenceMessageGuild=");
        sbM833U.append(this.referenceMessageGuild);
        sbM833U.append(", replyAgeSeconds=");
        sbM833U.append(this.replyAgeSeconds);
        sbM833U.append(", stickerIds=");
        sbM833U.append(this.stickerIds);
        sbM833U.append(", numUrls=");
        sbM833U.append(this.numUrls);
        sbM833U.append(", numMentions=");
        sbM833U.append(this.numMentions);
        sbM833U.append(", mentionRoleIds=");
        return C1643a.m824L(sbM833U, this.mentionRoleIds, ")");
    }
}
