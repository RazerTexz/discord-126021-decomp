package com.discord.widgets.hubs;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.hubs.HubDescriptionArgs, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubDescriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHubDescriptionViewModel2 implements Parcelable {
    public static final Parcelable.Creator<WidgetHubDescriptionViewModel2> CREATOR = new Creator();
    private final long channelId;
    private final String description;
    private final long guildId;
    private final String hubName;
    private final boolean isEditing;
    private final boolean isNewGuild;
    private final Integer primaryCategoryId;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.HubDescriptionArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetHubDescriptionViewModel2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubDescriptionViewModel2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetHubDescriptionViewModel2(parcel.readLong(), parcel.readLong(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubDescriptionViewModel2[] newArray(int i) {
            return new WidgetHubDescriptionViewModel2[i];
        }
    }

    public WidgetHubDescriptionViewModel2(long j, long j2, boolean z2, String str, boolean z3, String str2, Integer num) {
        Intrinsics3.checkNotNullParameter(str, "hubName");
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

    public final WidgetHubDescriptionViewModel2 copy(long guildId, long channelId, boolean isEditing, String hubName, boolean isNewGuild, String description, Integer primaryCategoryId) {
        Intrinsics3.checkNotNullParameter(hubName, "hubName");
        return new WidgetHubDescriptionViewModel2(guildId, channelId, isEditing, hubName, isNewGuild, description, primaryCategoryId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubDescriptionViewModel2)) {
            return false;
        }
        WidgetHubDescriptionViewModel2 widgetHubDescriptionViewModel2 = (WidgetHubDescriptionViewModel2) other;
        return this.guildId == widgetHubDescriptionViewModel2.guildId && this.channelId == widgetHubDescriptionViewModel2.channelId && this.isEditing == widgetHubDescriptionViewModel2.isEditing && Intrinsics3.areEqual(this.hubName, widgetHubDescriptionViewModel2.hubName) && this.isNewGuild == widgetHubDescriptionViewModel2.isNewGuild && Intrinsics3.areEqual(this.description, widgetHubDescriptionViewModel2.description) && Intrinsics3.areEqual(this.primaryCategoryId, widgetHubDescriptionViewModel2.primaryCategoryId);
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
        StringBuilder sbU = outline.U("HubDescriptionArgs(guildId=");
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
        return outline.F(sbU, this.primaryCategoryId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int iIntValue;
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
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

    public /* synthetic */ WidgetHubDescriptionViewModel2(long j, long j2, boolean z2, String str, boolean z3, String str2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, z2, str, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : num);
    }
}
