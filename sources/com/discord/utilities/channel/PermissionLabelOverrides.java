package com.discord.utilities.channel;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ChannelPermissionUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class PermissionLabelOverrides {
    private final CharSequence announcementChannelSubtext;
    private final CharSequence categoryEveryoneSubtext;
    private final String categoryLabel;
    private final CharSequence categorySubtext;
    private final String stageChannelEveryoneSubtext;
    private final CharSequence stageChannelSubtext;
    private final String textChannelEveryoneSubtext;
    private final String voiceChannelEveryoneSubtext;
    private final String voiceChannelSubtext;

    public PermissionLabelOverrides(CharSequence charSequence, String str, String str2, CharSequence charSequence2, String str3, String str4, String str5, CharSequence charSequence3, CharSequence charSequence4) {
        m.checkNotNullParameter(charSequence, "categorySubtext");
        this.categorySubtext = charSequence;
        this.categoryLabel = str;
        this.voiceChannelSubtext = str2;
        this.stageChannelSubtext = charSequence2;
        this.textChannelEveryoneSubtext = str3;
        this.voiceChannelEveryoneSubtext = str4;
        this.stageChannelEveryoneSubtext = str5;
        this.categoryEveryoneSubtext = charSequence3;
        this.announcementChannelSubtext = charSequence4;
    }

    public static /* synthetic */ PermissionLabelOverrides copy$default(PermissionLabelOverrides permissionLabelOverrides, CharSequence charSequence, String str, String str2, CharSequence charSequence2, String str3, String str4, String str5, CharSequence charSequence3, CharSequence charSequence4, int i, Object obj) {
        return permissionLabelOverrides.copy((i & 1) != 0 ? permissionLabelOverrides.categorySubtext : charSequence, (i & 2) != 0 ? permissionLabelOverrides.categoryLabel : str, (i & 4) != 0 ? permissionLabelOverrides.voiceChannelSubtext : str2, (i & 8) != 0 ? permissionLabelOverrides.stageChannelSubtext : charSequence2, (i & 16) != 0 ? permissionLabelOverrides.textChannelEveryoneSubtext : str3, (i & 32) != 0 ? permissionLabelOverrides.voiceChannelEveryoneSubtext : str4, (i & 64) != 0 ? permissionLabelOverrides.stageChannelEveryoneSubtext : str5, (i & 128) != 0 ? permissionLabelOverrides.categoryEveryoneSubtext : charSequence3, (i & 256) != 0 ? permissionLabelOverrides.announcementChannelSubtext : charSequence4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CharSequence getCategorySubtext() {
        return this.categorySubtext;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCategoryLabel() {
        return this.categoryLabel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getVoiceChannelSubtext() {
        return this.voiceChannelSubtext;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final CharSequence getStageChannelSubtext() {
        return this.stageChannelSubtext;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTextChannelEveryoneSubtext() {
        return this.textChannelEveryoneSubtext;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getVoiceChannelEveryoneSubtext() {
        return this.voiceChannelEveryoneSubtext;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getStageChannelEveryoneSubtext() {
        return this.stageChannelEveryoneSubtext;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final CharSequence getCategoryEveryoneSubtext() {
        return this.categoryEveryoneSubtext;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final CharSequence getAnnouncementChannelSubtext() {
        return this.announcementChannelSubtext;
    }

    public final PermissionLabelOverrides copy(CharSequence categorySubtext, String categoryLabel, String voiceChannelSubtext, CharSequence stageChannelSubtext, String textChannelEveryoneSubtext, String voiceChannelEveryoneSubtext, String stageChannelEveryoneSubtext, CharSequence categoryEveryoneSubtext, CharSequence announcementChannelSubtext) {
        m.checkNotNullParameter(categorySubtext, "categorySubtext");
        return new PermissionLabelOverrides(categorySubtext, categoryLabel, voiceChannelSubtext, stageChannelSubtext, textChannelEveryoneSubtext, voiceChannelEveryoneSubtext, stageChannelEveryoneSubtext, categoryEveryoneSubtext, announcementChannelSubtext);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionLabelOverrides)) {
            return false;
        }
        PermissionLabelOverrides permissionLabelOverrides = (PermissionLabelOverrides) other;
        return m.areEqual(this.categorySubtext, permissionLabelOverrides.categorySubtext) && m.areEqual(this.categoryLabel, permissionLabelOverrides.categoryLabel) && m.areEqual(this.voiceChannelSubtext, permissionLabelOverrides.voiceChannelSubtext) && m.areEqual(this.stageChannelSubtext, permissionLabelOverrides.stageChannelSubtext) && m.areEqual(this.textChannelEveryoneSubtext, permissionLabelOverrides.textChannelEveryoneSubtext) && m.areEqual(this.voiceChannelEveryoneSubtext, permissionLabelOverrides.voiceChannelEveryoneSubtext) && m.areEqual(this.stageChannelEveryoneSubtext, permissionLabelOverrides.stageChannelEveryoneSubtext) && m.areEqual(this.categoryEveryoneSubtext, permissionLabelOverrides.categoryEveryoneSubtext) && m.areEqual(this.announcementChannelSubtext, permissionLabelOverrides.announcementChannelSubtext);
    }

    public final CharSequence getAnnouncementChannelSubtext() {
        return this.announcementChannelSubtext;
    }

    public final CharSequence getCategoryEveryoneSubtext() {
        return this.categoryEveryoneSubtext;
    }

    public final String getCategoryLabel() {
        return this.categoryLabel;
    }

    public final CharSequence getCategorySubtext() {
        return this.categorySubtext;
    }

    public final String getStageChannelEveryoneSubtext() {
        return this.stageChannelEveryoneSubtext;
    }

    public final CharSequence getStageChannelSubtext() {
        return this.stageChannelSubtext;
    }

    public final String getTextChannelEveryoneSubtext() {
        return this.textChannelEveryoneSubtext;
    }

    public final String getVoiceChannelEveryoneSubtext() {
        return this.voiceChannelEveryoneSubtext;
    }

    public final String getVoiceChannelSubtext() {
        return this.voiceChannelSubtext;
    }

    public int hashCode() {
        CharSequence charSequence = this.categorySubtext;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        String str = this.categoryLabel;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.voiceChannelSubtext;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.stageChannelSubtext;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        String str3 = this.textChannelEveryoneSubtext;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.voiceChannelEveryoneSubtext;
        int iHashCode6 = (iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.stageChannelEveryoneSubtext;
        int iHashCode7 = (iHashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.categoryEveryoneSubtext;
        int iHashCode8 = (iHashCode7 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.announcementChannelSubtext;
        return iHashCode8 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("PermissionLabelOverrides(categorySubtext=");
        sbU.append(this.categorySubtext);
        sbU.append(", categoryLabel=");
        sbU.append(this.categoryLabel);
        sbU.append(", voiceChannelSubtext=");
        sbU.append(this.voiceChannelSubtext);
        sbU.append(", stageChannelSubtext=");
        sbU.append(this.stageChannelSubtext);
        sbU.append(", textChannelEveryoneSubtext=");
        sbU.append(this.textChannelEveryoneSubtext);
        sbU.append(", voiceChannelEveryoneSubtext=");
        sbU.append(this.voiceChannelEveryoneSubtext);
        sbU.append(", stageChannelEveryoneSubtext=");
        sbU.append(this.stageChannelEveryoneSubtext);
        sbU.append(", categoryEveryoneSubtext=");
        sbU.append(this.categoryEveryoneSubtext);
        sbU.append(", announcementChannelSubtext=");
        return a.E(sbU, this.announcementChannelSubtext, ")");
    }

    public /* synthetic */ PermissionLabelOverrides(CharSequence charSequence, String str, String str2, CharSequence charSequence2, String str3, String str4, String str5, CharSequence charSequence3, CharSequence charSequence4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : charSequence2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : charSequence3, (i & 256) == 0 ? charSequence4 : null);
    }
}
