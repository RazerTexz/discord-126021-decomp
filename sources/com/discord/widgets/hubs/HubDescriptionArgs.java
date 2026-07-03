package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubDescriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubDescriptionArgs implements Parcelable {
    public static final Parcelable.Creator<HubDescriptionArgs> CREATOR = new Creator();
    private final long channelId;
    private final String description;
    private final long guildId;
    private final String hubName;
    private final boolean isEditing;
    private final boolean isNewGuild;
    private final Integer primaryCategoryId;

    public static class Creator implements Parcelable.Creator<HubDescriptionArgs> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HubDescriptionArgs createFromParcel(Parcel parcel) {
            C12238m.checkNotNullParameter(parcel, "in");
            return new HubDescriptionArgs(parcel.readLong(), parcel.readLong(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HubDescriptionArgs[] newArray(int i) {
            return new HubDescriptionArgs[i];
        }
    }

    public HubDescriptionArgs(long j, long j2, boolean z2, String str, boolean z3, String str2, Integer num) {
        C12238m.checkNotNullParameter(str, "hubName");
        this.guildId = j;
        this.channelId = j2;
        this.isEditing = z2;
        this.hubName = str;
        this.isNewGuild = z3;
        this.description = str2;
        this.primaryCategoryId = num;
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
        C12238m.checkNotNullParameter(hubName, "hubName");
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
        return this.guildId == hubDescriptionArgs.guildId && this.channelId == hubDescriptionArgs.channelId && this.isEditing == hubDescriptionArgs.isEditing && C12238m.areEqual(this.hubName, hubDescriptionArgs.hubName) && this.isNewGuild == hubDescriptionArgs.isNewGuild && C12238m.areEqual(this.description, hubDescriptionArgs.description) && C12238m.areEqual(this.primaryCategoryId, hubDescriptionArgs.primaryCategoryId);
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
        int iM3a = (C0002b.m3a(this.channelId) + (C0002b.m3a(this.guildId) * 31)) * 31;
        boolean z2 = this.isEditing;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (iM3a + r0) * 31;
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
        StringBuilder sbM833U = C1643a.m833U("HubDescriptionArgs(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", isEditing=");
        sbM833U.append(this.isEditing);
        sbM833U.append(", hubName=");
        sbM833U.append(this.hubName);
        sbM833U.append(", isNewGuild=");
        sbM833U.append(this.isNewGuild);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", primaryCategoryId=");
        return C1643a.m818F(sbM833U, this.primaryCategoryId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int iIntValue;
        C12238m.checkNotNullParameter(parcel, "parcel");
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
