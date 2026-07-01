package com.discord.widgets.voice.fullscreen.stage;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: StageCallItem.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class StageCallItem$DetailsItem extends StageCallItem {
    private final String displayName;
    private final boolean isPublic;
    private final int numAudience;
    private final int numBlocked;
    private final int numSpeakers;
    private final int numUsersConnected;
    private final String topic;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCallItem$DetailsItem(String str, String str2, int i, int i2, int i3, int i4, boolean z2) {
        super("details", 0, null);
        m.checkNotNullParameter(str2, "displayName");
        this.topic = str;
        this.displayName = str2;
        this.numUsersConnected = i;
        this.numSpeakers = i2;
        this.numAudience = i3;
        this.numBlocked = i4;
        this.isPublic = z2;
    }

    public static /* synthetic */ StageCallItem$DetailsItem copy$default(StageCallItem$DetailsItem stageCallItem$DetailsItem, String str, String str2, int i, int i2, int i3, int i4, boolean z2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = stageCallItem$DetailsItem.topic;
        }
        if ((i5 & 2) != 0) {
            str2 = stageCallItem$DetailsItem.displayName;
        }
        String str3 = str2;
        if ((i5 & 4) != 0) {
            i = stageCallItem$DetailsItem.numUsersConnected;
        }
        int i6 = i;
        if ((i5 & 8) != 0) {
            i2 = stageCallItem$DetailsItem.numSpeakers;
        }
        int i7 = i2;
        if ((i5 & 16) != 0) {
            i3 = stageCallItem$DetailsItem.numAudience;
        }
        int i8 = i3;
        if ((i5 & 32) != 0) {
            i4 = stageCallItem$DetailsItem.numBlocked;
        }
        int i9 = i4;
        if ((i5 & 64) != 0) {
            z2 = stageCallItem$DetailsItem.isPublic;
        }
        return stageCallItem$DetailsItem.copy(str, str3, i6, i7, i8, i9, z2);
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

    public final StageCallItem$DetailsItem copy(String topic, String displayName, int numUsersConnected, int numSpeakers, int numAudience, int numBlocked, boolean isPublic) {
        m.checkNotNullParameter(displayName, "displayName");
        return new StageCallItem$DetailsItem(topic, displayName, numUsersConnected, numSpeakers, numAudience, numBlocked, isPublic);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageCallItem$DetailsItem)) {
            return false;
        }
        StageCallItem$DetailsItem stageCallItem$DetailsItem = (StageCallItem$DetailsItem) other;
        return m.areEqual(this.topic, stageCallItem$DetailsItem.topic) && m.areEqual(this.displayName, stageCallItem$DetailsItem.displayName) && this.numUsersConnected == stageCallItem$DetailsItem.numUsersConnected && this.numSpeakers == stageCallItem$DetailsItem.numSpeakers && this.numAudience == stageCallItem$DetailsItem.numAudience && this.numBlocked == stageCallItem$DetailsItem.numBlocked && this.isPublic == stageCallItem$DetailsItem.isPublic;
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
        StringBuilder sbU = a.U("DetailsItem(topic=");
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
        return a.O(sbU, this.isPublic, ")");
    }
}
