package com.discord.widgets.hubs;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetHubDescriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubDescriptionArgs implements Parcelable {
    public static final Parcelable$Creator<HubDescriptionArgs> CREATOR = new HubDescriptionArgs$Creator();
    private final long channelId;
    private final String description;
    private final long guildId;
    private final String hubName;
    private final boolean isEditing;
    private final boolean isNewGuild;
    private final Integer primaryCategoryId;

    public HubDescriptionArgs(long j, long j2, boolean z2, String str, boolean z3, String str2, Integer num) {
        m.checkNotNullParameter(str, "hubName");
        this.guildId = j;
        this.channelId = j2;
        this.isEditing = z2;
        this.hubName = str;
        this.isNewGuild = z3;
        this.description = str2;
        this.primaryCategoryId = num;
    }

    public static /* synthetic */ HubDescriptionArgs copy$default(HubDescriptionArgs hubDescriptionArgs, long j, long j2, boolean z2, String str, boolean z3, String str2, Integer num, int i, Object obj) {
        return hubDescriptionArgs.copy((i & 1) != 0 ? hubDescriptionArgs.guildId : j, (i & 2) != 0 ? hubDescriptionArgs.channelId : j2, (i & 4) != 0 ? hubDescriptionArgs.isEditing : z2, (i & 8) != 0 ? hubDescriptionArgs.hubName : str, (i & 16) != 0 ? hubDescriptionArgs.isNewGuild : z3, (i & 32) != 0 ? hubDescriptionArgs.description : str2, (i & 64) != 0 ? hubDescriptionArgs.primaryCategoryId : num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsEditing() {
        return this.isEditing;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getHubName() {
        return this.hubName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsNewGuild() {
        return this.isNewGuild;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getPrimaryCategoryId() {
        return this.primaryCategoryId;
    }

    public final HubDescriptionArgs copy(long guildId, long channelId, boolean isEditing, String hubName, boolean isNewGuild, String description, Integer primaryCategoryId) {
        m.checkNotNullParameter(hubName, "hubName");
        return new HubDescriptionArgs(guildId, channelId, isEditing, hubName, isNewGuild, description, primaryCategoryId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HubDescriptionArgs)) {
            return false;
        }
        HubDescriptionArgs hubDescriptionArgs = (HubDescriptionArgs) other;
        return this.guildId == hubDescriptionArgs.guildId && this.channelId == hubDescriptionArgs.channelId && this.isEditing == hubDescriptionArgs.isEditing && m.areEqual(this.hubName, hubDescriptionArgs.hubName) && this.isNewGuild == hubDescriptionArgs.isNewGuild && m.areEqual(this.description, hubDescriptionArgs.description) && m.areEqual(this.primaryCategoryId, hubDescriptionArgs.primaryCategoryId);
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getHubName() {
        return this.hubName;
    }

    public final Integer getPrimaryCategoryId() {
        return this.primaryCategoryId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iA = (b.a(this.channelId) + (b.a(this.guildId) * 31)) * 31;
        boolean z2 = this.isEditing;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (iA + r0) * 31;
        String str = this.hubName;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z3 = this.isNewGuild;
        int i2 = (iHashCode + (z3 ? 1 : z3)) * 31;
        String str2 = this.description;
        int iHashCode2 = (i2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.primaryCategoryId;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public final boolean isEditing() {
        return this.isEditing;
    }

    public final boolean isNewGuild() {
        return this.isNewGuild;
    }

    public String toString() {
        StringBuilder sbU = a.U("HubDescriptionArgs(guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", isEditing=");
        sbU.append(this.isEditing);
        sbU.append(", hubName=");
        sbU.append(this.hubName);
        sbU.append(", isNewGuild=");
        sbU.append(this.isNewGuild);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", primaryCategoryId=");
        return a.F(sbU, this.primaryCategoryId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int iIntValue;
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
        parcel.writeLong(this.channelId);
        parcel.writeInt(this.isEditing ? 1 : 0);
        parcel.writeString(this.hubName);
        parcel.writeInt(this.isNewGuild ? 1 : 0);
        parcel.writeString(this.description);
        Integer num = this.primaryCategoryId;
        if (num != null) {
            parcel.writeInt(1);
            iIntValue = num.intValue();
        } else {
            iIntValue = 0;
        }
        parcel.writeInt(iIntValue);
    }

    public /* synthetic */ HubDescriptionArgs(long j, long j2, boolean z2, String str, boolean z3, String str2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, z2, str, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : num);
    }
}
