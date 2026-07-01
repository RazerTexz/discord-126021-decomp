package com.discord.widgets.voice.fullscreen.stage;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.widgets.voice.fullscreen.CallParticipant;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StageCallItem.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class StageCallItem implements MGRecyclerDataPayload {
    public static final int TYPE_AUDIENCE = 3;
    public static final int TYPE_AUDIENCE_HEADER = 2;
    public static final int TYPE_DETAILS = 0;
    public static final int TYPE_DIVIDER = 4;
    public static final int TYPE_MEDIA = 6;
    public static final int TYPE_PRESTART_DETAILS = 5;
    public static final int TYPE_SPEAKER = 1;
    private final String key;
    private final int type;

    /* JADX INFO: compiled from: StageCallItem.kt */
    public static final /* data */ class AudienceHeaderItem extends StageCallItem {
        private final int audienceSize;

        public AudienceHeaderItem(int i) {
            super("audience-header", 2, null);
            this.audienceSize = i;
        }

        public static /* synthetic */ AudienceHeaderItem copy$default(AudienceHeaderItem audienceHeaderItem, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = audienceHeaderItem.audienceSize;
            }
            return audienceHeaderItem.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getAudienceSize() {
            return this.audienceSize;
        }

        public final AudienceHeaderItem copy(int audienceSize) {
            return new AudienceHeaderItem(audienceSize);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof AudienceHeaderItem) && this.audienceSize == ((AudienceHeaderItem) other).audienceSize;
            }
            return true;
        }

        public final int getAudienceSize() {
            return this.audienceSize;
        }

        public int hashCode() {
            return this.audienceSize;
        }

        public String toString() {
            return outline.B(outline.U("AudienceHeaderItem(audienceSize="), this.audienceSize, ")");
        }
    }

    /* JADX INFO: compiled from: StageCallItem.kt */
    public static final /* data */ class AudienceItem extends StageCallItem implements StageCallItem2, Comparable<AudienceItem> {
        private final Channel channel;
        private final GuildRole hoistedGuildRole;
        private final boolean isBlocked;
        private final StoreVoiceParticipants.VoiceUser voiceUser;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AudienceItem(StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, GuildRole guildRole, boolean z2) {
            super("audience-" + voiceUser.getUser().getId(), 3, null);
            Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.voiceUser = voiceUser;
            this.channel = channel;
            this.hoistedGuildRole = guildRole;
            this.isBlocked = z2;
        }

        public static /* synthetic */ AudienceItem copy$default(AudienceItem audienceItem, StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, GuildRole guildRole, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                voiceUser = audienceItem.getVoiceUser();
            }
            if ((i & 2) != 0) {
                channel = audienceItem.getChannel();
            }
            if ((i & 4) != 0) {
                guildRole = audienceItem.hoistedGuildRole;
            }
            if ((i & 8) != 0) {
                z2 = audienceItem.isBlocked;
            }
            return audienceItem.copy(voiceUser, channel, guildRole, z2);
        }

        public final StoreVoiceParticipants.VoiceUser component1() {
            return getVoiceUser();
        }

        public final Channel component2() {
            return getChannel();
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final GuildRole getHoistedGuildRole() {
            return this.hoistedGuildRole;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsBlocked() {
            return this.isBlocked;
        }

        public final AudienceItem copy(StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, GuildRole hoistedGuildRole, boolean isBlocked) {
            Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new AudienceItem(voiceUser, channel, hoistedGuildRole, isBlocked);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AudienceItem)) {
                return false;
            }
            AudienceItem audienceItem = (AudienceItem) other;
            return Intrinsics3.areEqual(getVoiceUser(), audienceItem.getVoiceUser()) && Intrinsics3.areEqual(getChannel(), audienceItem.getChannel()) && Intrinsics3.areEqual(this.hoistedGuildRole, audienceItem.hoistedGuildRole) && this.isBlocked == audienceItem.isBlocked;
        }

        @Override // com.discord.widgets.voice.fullscreen.stage.StageCallItem2
        public Channel getChannel() {
            return this.channel;
        }

        public final GuildRole getHoistedGuildRole() {
            return this.hoistedGuildRole;
        }

        @Override // com.discord.widgets.voice.fullscreen.stage.StageCallItem2
        public StoreVoiceParticipants.VoiceUser getVoiceUser() {
            return this.voiceUser;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            StoreVoiceParticipants.VoiceUser voiceUser = getVoiceUser();
            int iHashCode = (voiceUser != null ? voiceUser.hashCode() : 0) * 31;
            Channel channel = getChannel();
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            GuildRole guildRole = this.hoistedGuildRole;
            int iHashCode3 = (iHashCode2 + (guildRole != null ? guildRole.hashCode() : 0)) * 31;
            boolean z2 = this.isBlocked;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode3 + r1;
        }

        public final boolean isBlocked() {
            return this.isBlocked;
        }

        public String toString() {
            StringBuilder sbU = outline.U("AudienceItem(voiceUser=");
            sbU.append(getVoiceUser());
            sbU.append(", channel=");
            sbU.append(getChannel());
            sbU.append(", hoistedGuildRole=");
            sbU.append(this.hoistedGuildRole);
            sbU.append(", isBlocked=");
            return outline.O(sbU, this.isBlocked, ")");
        }

        @Override // java.lang.Comparable
        public int compareTo(AudienceItem other) {
            Intrinsics3.checkNotNullParameter(other, "other");
            return RoleUtils.getROLE_COMPARATOR().compare(this.hoistedGuildRole, other.hoistedGuildRole);
        }
    }

    /* JADX INFO: compiled from: StageCallItem.kt */
    public static final /* data */ class DetailsItem extends StageCallItem {
        private final String displayName;
        private final boolean isPublic;
        private final int numAudience;
        private final int numBlocked;
        private final int numSpeakers;
        private final int numUsersConnected;
        private final String topic;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DetailsItem(String str, String str2, int i, int i2, int i3, int i4, boolean z2) {
            super("details", 0, null);
            Intrinsics3.checkNotNullParameter(str2, "displayName");
            this.topic = str;
            this.displayName = str2;
            this.numUsersConnected = i;
            this.numSpeakers = i2;
            this.numAudience = i3;
            this.numBlocked = i4;
            this.isPublic = z2;
        }

        public static /* synthetic */ DetailsItem copy$default(DetailsItem detailsItem, String str, String str2, int i, int i2, int i3, int i4, boolean z2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = detailsItem.topic;
            }
            if ((i5 & 2) != 0) {
                str2 = detailsItem.displayName;
            }
            String str3 = str2;
            if ((i5 & 4) != 0) {
                i = detailsItem.numUsersConnected;
            }
            int i6 = i;
            if ((i5 & 8) != 0) {
                i2 = detailsItem.numSpeakers;
            }
            int i7 = i2;
            if ((i5 & 16) != 0) {
                i3 = detailsItem.numAudience;
            }
            int i8 = i3;
            if ((i5 & 32) != 0) {
                i4 = detailsItem.numBlocked;
            }
            int i9 = i4;
            if ((i5 & 64) != 0) {
                z2 = detailsItem.isPublic;
            }
            return detailsItem.copy(str, str3, i6, i7, i8, i9, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTopic() {
            return this.topic;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getDisplayName() {
            return this.displayName;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getNumUsersConnected() {
            return this.numUsersConnected;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getNumSpeakers() {
            return this.numSpeakers;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getNumAudience() {
            return this.numAudience;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getNumBlocked() {
            return this.numBlocked;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getIsPublic() {
            return this.isPublic;
        }

        public final DetailsItem copy(String topic, String displayName, int numUsersConnected, int numSpeakers, int numAudience, int numBlocked, boolean isPublic) {
            Intrinsics3.checkNotNullParameter(displayName, "displayName");
            return new DetailsItem(topic, displayName, numUsersConnected, numSpeakers, numAudience, numBlocked, isPublic);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DetailsItem)) {
                return false;
            }
            DetailsItem detailsItem = (DetailsItem) other;
            return Intrinsics3.areEqual(this.topic, detailsItem.topic) && Intrinsics3.areEqual(this.displayName, detailsItem.displayName) && this.numUsersConnected == detailsItem.numUsersConnected && this.numSpeakers == detailsItem.numSpeakers && this.numAudience == detailsItem.numAudience && this.numBlocked == detailsItem.numBlocked && this.isPublic == detailsItem.isPublic;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final int getNumAudience() {
            return this.numAudience;
        }

        public final int getNumBlocked() {
            return this.numBlocked;
        }

        public final int getNumSpeakers() {
            return this.numSpeakers;
        }

        public final int getNumUsersConnected() {
            return this.numUsersConnected;
        }

        public final String getTopic() {
            return this.topic;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v8 */
        public int hashCode() {
            String str = this.topic;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.displayName;
            int iHashCode2 = (((((((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.numUsersConnected) * 31) + this.numSpeakers) * 31) + this.numAudience) * 31) + this.numBlocked) * 31;
            boolean z2 = this.isPublic;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        public final boolean isPublic() {
            return this.isPublic;
        }

        public String toString() {
            StringBuilder sbU = outline.U("DetailsItem(topic=");
            sbU.append(this.topic);
            sbU.append(", displayName=");
            sbU.append(this.displayName);
            sbU.append(", numUsersConnected=");
            sbU.append(this.numUsersConnected);
            sbU.append(", numSpeakers=");
            sbU.append(this.numSpeakers);
            sbU.append(", numAudience=");
            sbU.append(this.numAudience);
            sbU.append(", numBlocked=");
            sbU.append(this.numBlocked);
            sbU.append(", isPublic=");
            return outline.O(sbU, this.isPublic, ")");
        }
    }

    /* JADX INFO: compiled from: StageCallItem.kt */
    public static final class DividerItem extends StageCallItem {
        public static final DividerItem INSTANCE = new DividerItem();

        private DividerItem() {
            super("divider", 4, null);
        }
    }

    /* JADX INFO: compiled from: StageCallItem.kt */
    public static final /* data */ class MediaItem extends StageCallItem implements StageCallItem2 {
        private final Channel channel;
        private final boolean isBlocked;
        private final boolean isModerator;
        private final MediaType mediaType;
        private final VideoCallParticipantView.ParticipantData participantData;
        private final CallParticipant.UserOrStreamParticipant userOrStreamParticipant;
        private final StoreVoiceParticipants.VoiceUser voiceUser;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaItem(StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, boolean z2, boolean z3, MediaType mediaType, CallParticipant.UserOrStreamParticipant userOrStreamParticipant) {
            super("media-" + voiceUser.getUser().getId() + '-' + mediaType, 6, null);
            Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(mediaType, "mediaType");
            Intrinsics3.checkNotNullParameter(userOrStreamParticipant, "userOrStreamParticipant");
            this.voiceUser = voiceUser;
            this.channel = channel;
            this.isModerator = z2;
            this.isBlocked = z3;
            this.mediaType = mediaType;
            this.userOrStreamParticipant = userOrStreamParticipant;
            this.participantData = userOrStreamParticipant.getParticipantData();
        }

        public static /* synthetic */ MediaItem copy$default(MediaItem mediaItem, StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, boolean z2, boolean z3, MediaType mediaType, CallParticipant.UserOrStreamParticipant userOrStreamParticipant, int i, Object obj) {
            if ((i & 1) != 0) {
                voiceUser = mediaItem.getVoiceUser();
            }
            if ((i & 2) != 0) {
                channel = mediaItem.getChannel();
            }
            Channel channel2 = channel;
            if ((i & 4) != 0) {
                z2 = mediaItem.isModerator;
            }
            boolean z4 = z2;
            if ((i & 8) != 0) {
                z3 = mediaItem.isBlocked;
            }
            boolean z5 = z3;
            if ((i & 16) != 0) {
                mediaType = mediaItem.mediaType;
            }
            MediaType mediaType2 = mediaType;
            if ((i & 32) != 0) {
                userOrStreamParticipant = mediaItem.userOrStreamParticipant;
            }
            return mediaItem.copy(voiceUser, channel2, z4, z5, mediaType2, userOrStreamParticipant);
        }

        public final StoreVoiceParticipants.VoiceUser component1() {
            return getVoiceUser();
        }

        public final Channel component2() {
            return getChannel();
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsModerator() {
            return this.isModerator;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsBlocked() {
            return this.isBlocked;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final MediaType getMediaType() {
            return this.mediaType;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final CallParticipant.UserOrStreamParticipant getUserOrStreamParticipant() {
            return this.userOrStreamParticipant;
        }

        public final MediaItem copy(StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, boolean isModerator, boolean isBlocked, MediaType mediaType, CallParticipant.UserOrStreamParticipant userOrStreamParticipant) {
            Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(mediaType, "mediaType");
            Intrinsics3.checkNotNullParameter(userOrStreamParticipant, "userOrStreamParticipant");
            return new MediaItem(voiceUser, channel, isModerator, isBlocked, mediaType, userOrStreamParticipant);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MediaItem)) {
                return false;
            }
            MediaItem mediaItem = (MediaItem) other;
            return Intrinsics3.areEqual(getVoiceUser(), mediaItem.getVoiceUser()) && Intrinsics3.areEqual(getChannel(), mediaItem.getChannel()) && this.isModerator == mediaItem.isModerator && this.isBlocked == mediaItem.isBlocked && Intrinsics3.areEqual(this.mediaType, mediaItem.mediaType) && Intrinsics3.areEqual(this.userOrStreamParticipant, mediaItem.userOrStreamParticipant);
        }

        @Override // com.discord.widgets.voice.fullscreen.stage.StageCallItem2
        public Channel getChannel() {
            return this.channel;
        }

        public final MediaType getMediaType() {
            return this.mediaType;
        }

        public final VideoCallParticipantView.ParticipantData getParticipantData() {
            return this.participantData;
        }

        public final CallParticipant.UserOrStreamParticipant getUserOrStreamParticipant() {
            return this.userOrStreamParticipant;
        }

        @Override // com.discord.widgets.voice.fullscreen.stage.StageCallItem2
        public StoreVoiceParticipants.VoiceUser getVoiceUser() {
            return this.voiceUser;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            StoreVoiceParticipants.VoiceUser voiceUser = getVoiceUser();
            int iHashCode = (voiceUser != null ? voiceUser.hashCode() : 0) * 31;
            Channel channel = getChannel();
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            boolean z2 = this.isModerator;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode2 + r2) * 31;
            boolean z3 = this.isBlocked;
            int i2 = (i + (z3 ? 1 : z3)) * 31;
            MediaType mediaType = this.mediaType;
            int iHashCode3 = (i2 + (mediaType != null ? mediaType.hashCode() : 0)) * 31;
            CallParticipant.UserOrStreamParticipant userOrStreamParticipant = this.userOrStreamParticipant;
            return iHashCode3 + (userOrStreamParticipant != null ? userOrStreamParticipant.hashCode() : 0);
        }

        public final boolean isBlocked() {
            return this.isBlocked;
        }

        public final boolean isModerator() {
            return this.isModerator;
        }

        public String toString() {
            StringBuilder sbU = outline.U("MediaItem(voiceUser=");
            sbU.append(getVoiceUser());
            sbU.append(", channel=");
            sbU.append(getChannel());
            sbU.append(", isModerator=");
            sbU.append(this.isModerator);
            sbU.append(", isBlocked=");
            sbU.append(this.isBlocked);
            sbU.append(", mediaType=");
            sbU.append(this.mediaType);
            sbU.append(", userOrStreamParticipant=");
            sbU.append(this.userOrStreamParticipant);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: StageCallItem.kt */
    public enum MediaType {
        USER,
        STREAM
    }

    /* JADX INFO: compiled from: StageCallItem.kt */
    public static final /* data */ class PreStartDetailsItem extends StageCallItem {
        private final int numAudience;
        private final int numSpeakers;
        private final String subtitle;
        private final String title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PreStartDetailsItem(String str, String str2, int i, int i2) {
            super("pre-start-details", 5, null);
            Intrinsics3.checkNotNullParameter(str, "title");
            Intrinsics3.checkNotNullParameter(str2, "subtitle");
            this.title = str;
            this.subtitle = str2;
            this.numSpeakers = i;
            this.numAudience = i2;
        }

        public static /* synthetic */ PreStartDetailsItem copy$default(PreStartDetailsItem preStartDetailsItem, String str, String str2, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = preStartDetailsItem.title;
            }
            if ((i3 & 2) != 0) {
                str2 = preStartDetailsItem.subtitle;
            }
            if ((i3 & 4) != 0) {
                i = preStartDetailsItem.numSpeakers;
            }
            if ((i3 & 8) != 0) {
                i2 = preStartDetailsItem.numAudience;
            }
            return preStartDetailsItem.copy(str, str2, i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSubtitle() {
            return this.subtitle;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getNumSpeakers() {
            return this.numSpeakers;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getNumAudience() {
            return this.numAudience;
        }

        public final PreStartDetailsItem copy(String title, String subtitle, int numSpeakers, int numAudience) {
            Intrinsics3.checkNotNullParameter(title, "title");
            Intrinsics3.checkNotNullParameter(subtitle, "subtitle");
            return new PreStartDetailsItem(title, subtitle, numSpeakers, numAudience);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PreStartDetailsItem)) {
                return false;
            }
            PreStartDetailsItem preStartDetailsItem = (PreStartDetailsItem) other;
            return Intrinsics3.areEqual(this.title, preStartDetailsItem.title) && Intrinsics3.areEqual(this.subtitle, preStartDetailsItem.subtitle) && this.numSpeakers == preStartDetailsItem.numSpeakers && this.numAudience == preStartDetailsItem.numAudience;
        }

        public final int getNumAudience() {
            return this.numAudience;
        }

        public final int getNumSpeakers() {
            return this.numSpeakers;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.subtitle;
            return ((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.numSpeakers) * 31) + this.numAudience;
        }

        public String toString() {
            StringBuilder sbU = outline.U("PreStartDetailsItem(title=");
            sbU.append(this.title);
            sbU.append(", subtitle=");
            sbU.append(this.subtitle);
            sbU.append(", numSpeakers=");
            sbU.append(this.numSpeakers);
            sbU.append(", numAudience=");
            return outline.B(sbU, this.numAudience, ")");
        }
    }

    /* JADX INFO: compiled from: StageCallItem.kt */
    public static final /* data */ class SpeakerItem extends StageCallItem implements StageCallItem2 {
        private final Channel channel;
        private final boolean isBlocked;
        private final boolean isModerator;
        private final String positionKey;
        private final int speakersPerRow;
        private final StoreVoiceParticipants.VoiceUser voiceUser;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SpeakerItem(StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, boolean z2, String str, int i, boolean z3) {
            super("speaker-" + voiceUser.getUser().getId(), 1, null);
            Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(str, "positionKey");
            this.voiceUser = voiceUser;
            this.channel = channel;
            this.isModerator = z2;
            this.positionKey = str;
            this.speakersPerRow = i;
            this.isBlocked = z3;
        }

        public static /* synthetic */ SpeakerItem copy$default(SpeakerItem speakerItem, StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, boolean z2, String str, int i, boolean z3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                voiceUser = speakerItem.getVoiceUser();
            }
            if ((i2 & 2) != 0) {
                channel = speakerItem.getChannel();
            }
            Channel channel2 = channel;
            if ((i2 & 4) != 0) {
                z2 = speakerItem.isModerator;
            }
            boolean z4 = z2;
            if ((i2 & 8) != 0) {
                str = speakerItem.positionKey;
            }
            String str2 = str;
            if ((i2 & 16) != 0) {
                i = speakerItem.speakersPerRow;
            }
            int i3 = i;
            if ((i2 & 32) != 0) {
                z3 = speakerItem.isBlocked;
            }
            return speakerItem.copy(voiceUser, channel2, z4, str2, i3, z3);
        }

        public final StoreVoiceParticipants.VoiceUser component1() {
            return getVoiceUser();
        }

        public final Channel component2() {
            return getChannel();
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsModerator() {
            return this.isModerator;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getPositionKey() {
            return this.positionKey;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getSpeakersPerRow() {
            return this.speakersPerRow;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsBlocked() {
            return this.isBlocked;
        }

        public final SpeakerItem copy(StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, boolean isModerator, String positionKey, int speakersPerRow, boolean isBlocked) {
            Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(positionKey, "positionKey");
            return new SpeakerItem(voiceUser, channel, isModerator, positionKey, speakersPerRow, isBlocked);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SpeakerItem)) {
                return false;
            }
            SpeakerItem speakerItem = (SpeakerItem) other;
            return Intrinsics3.areEqual(getVoiceUser(), speakerItem.getVoiceUser()) && Intrinsics3.areEqual(getChannel(), speakerItem.getChannel()) && this.isModerator == speakerItem.isModerator && Intrinsics3.areEqual(this.positionKey, speakerItem.positionKey) && this.speakersPerRow == speakerItem.speakersPerRow && this.isBlocked == speakerItem.isBlocked;
        }

        @Override // com.discord.widgets.voice.fullscreen.stage.StageCallItem2
        public Channel getChannel() {
            return this.channel;
        }

        public final String getPositionKey() {
            return this.positionKey;
        }

        public final int getSpeakersPerRow() {
            return this.speakersPerRow;
        }

        @Override // com.discord.widgets.voice.fullscreen.stage.StageCallItem2
        public StoreVoiceParticipants.VoiceUser getVoiceUser() {
            return this.voiceUser;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v8 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            StoreVoiceParticipants.VoiceUser voiceUser = getVoiceUser();
            int iHashCode = (voiceUser != null ? voiceUser.hashCode() : 0) * 31;
            Channel channel = getChannel();
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            boolean z2 = this.isModerator;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode2 + r2) * 31;
            String str = this.positionKey;
            int iHashCode3 = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.speakersPerRow) * 31;
            boolean z3 = this.isBlocked;
            return iHashCode3 + (z3 ? 1 : z3);
        }

        public final boolean isBlocked() {
            return this.isBlocked;
        }

        public final boolean isModerator() {
            return this.isModerator;
        }

        public String toString() {
            StringBuilder sbU = outline.U("SpeakerItem(voiceUser=");
            sbU.append(getVoiceUser());
            sbU.append(", channel=");
            sbU.append(getChannel());
            sbU.append(", isModerator=");
            sbU.append(this.isModerator);
            sbU.append(", positionKey=");
            sbU.append(this.positionKey);
            sbU.append(", speakersPerRow=");
            sbU.append(this.speakersPerRow);
            sbU.append(", isBlocked=");
            return outline.O(sbU, this.isBlocked, ")");
        }
    }

    private StageCallItem(String str, int i) {
        this.key = str;
        this.type = i;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public /* synthetic */ StageCallItem(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i);
    }
}
