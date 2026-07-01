package com.discord.utilities.streams;

import b.d.b.a.outline;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationStreamPreviews;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: StreamContext.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StreamContext {
    private final Guild guild;
    private final boolean isCurrentUserParticipating;
    private final boolean isSelfStream;
    private final Joinability joinability;
    private final StoreApplicationStreamPreviews.StreamPreview preview;
    private final ModelApplicationStream stream;
    private final User user;
    private final String userNickname;

    /* JADX INFO: compiled from: StreamContext.kt */
    public enum Joinability {
        CAN_CONNECT,
        VOICE_CHANNEL_FULL,
        MISSING_PERMISSIONS
    }

    public StreamContext(ModelApplicationStream modelApplicationStream, Guild guild, StoreApplicationStreamPreviews.StreamPreview streamPreview, Joinability joinability, User user, String str, boolean z2, boolean z3) {
        Intrinsics3.checkNotNullParameter(modelApplicationStream, "stream");
        Intrinsics3.checkNotNullParameter(joinability, "joinability");
        Intrinsics3.checkNotNullParameter(user, "user");
        this.stream = modelApplicationStream;
        this.guild = guild;
        this.preview = streamPreview;
        this.joinability = joinability;
        this.user = user;
        this.userNickname = str;
        this.isCurrentUserParticipating = z2;
        this.isSelfStream = z3;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelApplicationStream getStream() {
        return this.stream;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StoreApplicationStreamPreviews.StreamPreview getPreview() {
        return this.preview;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Joinability getJoinability() {
        return this.joinability;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getUserNickname() {
        return this.userNickname;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsCurrentUserParticipating() {
        return this.isCurrentUserParticipating;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsSelfStream() {
        return this.isSelfStream;
    }

    public final StreamContext copy(ModelApplicationStream stream, Guild guild, StoreApplicationStreamPreviews.StreamPreview preview, Joinability joinability, User user, String userNickname, boolean isCurrentUserParticipating, boolean isSelfStream) {
        Intrinsics3.checkNotNullParameter(stream, "stream");
        Intrinsics3.checkNotNullParameter(joinability, "joinability");
        Intrinsics3.checkNotNullParameter(user, "user");
        return new StreamContext(stream, guild, preview, joinability, user, userNickname, isCurrentUserParticipating, isSelfStream);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StreamContext)) {
            return false;
        }
        StreamContext streamContext = (StreamContext) other;
        return Intrinsics3.areEqual(this.stream, streamContext.stream) && Intrinsics3.areEqual(this.guild, streamContext.guild) && Intrinsics3.areEqual(this.preview, streamContext.preview) && Intrinsics3.areEqual(this.joinability, streamContext.joinability) && Intrinsics3.areEqual(this.user, streamContext.user) && Intrinsics3.areEqual(this.userNickname, streamContext.userNickname) && this.isCurrentUserParticipating == streamContext.isCurrentUserParticipating && this.isSelfStream == streamContext.isSelfStream;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final Joinability getJoinability() {
        return this.joinability;
    }

    public final StoreApplicationStreamPreviews.StreamPreview getPreview() {
        return this.preview;
    }

    public final ModelApplicationStream getStream() {
        return this.stream;
    }

    public final User getUser() {
        return this.user;
    }

    public final String getUserNickname() {
        return this.userNickname;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    public int hashCode() {
        ModelApplicationStream modelApplicationStream = this.stream;
        int iHashCode = (modelApplicationStream != null ? modelApplicationStream.hashCode() : 0) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
        StoreApplicationStreamPreviews.StreamPreview streamPreview = this.preview;
        int iHashCode3 = (iHashCode2 + (streamPreview != null ? streamPreview.hashCode() : 0)) * 31;
        Joinability joinability = this.joinability;
        int iHashCode4 = (iHashCode3 + (joinability != null ? joinability.hashCode() : 0)) * 31;
        User user = this.user;
        int iHashCode5 = (iHashCode4 + (user != null ? user.hashCode() : 0)) * 31;
        String str = this.userNickname;
        int iHashCode6 = (iHashCode5 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.isCurrentUserParticipating;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode6 + r1) * 31;
        boolean z3 = this.isSelfStream;
        return i + (z3 ? 1 : z3);
    }

    public final boolean isCurrentUserParticipating() {
        return this.isCurrentUserParticipating;
    }

    public final boolean isSelfStream() {
        return this.isSelfStream;
    }

    public String toString() {
        StringBuilder sbU = outline.U("StreamContext(stream=");
        sbU.append(this.stream);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", preview=");
        sbU.append(this.preview);
        sbU.append(", joinability=");
        sbU.append(this.joinability);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", userNickname=");
        sbU.append(this.userNickname);
        sbU.append(", isCurrentUserParticipating=");
        sbU.append(this.isCurrentUserParticipating);
        sbU.append(", isSelfStream=");
        return outline.O(sbU, this.isSelfStream, ")");
    }
}
