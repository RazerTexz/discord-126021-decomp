package com.discord.stores;

import android.net.Uri;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreDynamicLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreDynamicLink$DynamicLinkData {
    private final String attemptId;
    private final String authToken;
    private final String fingerprint;
    private final String guildTemplateCode;
    private final String inviteCode;
    private final Uri uri;

    public StoreDynamicLink$DynamicLinkData(Uri uri, String str, String str2, String str3, String str4, String str5) {
        this.uri = uri;
        this.fingerprint = str;
        this.attemptId = str2;
        this.inviteCode = str3;
        this.guildTemplateCode = str4;
        this.authToken = str5;
    }

    public static /* synthetic */ StoreDynamicLink$DynamicLinkData copy$default(StoreDynamicLink$DynamicLinkData storeDynamicLink$DynamicLinkData, Uri uri, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = storeDynamicLink$DynamicLinkData.uri;
        }
        if ((i & 2) != 0) {
            str = storeDynamicLink$DynamicLinkData.fingerprint;
        }
        String str6 = str;
        if ((i & 4) != 0) {
            str2 = storeDynamicLink$DynamicLinkData.attemptId;
        }
        String str7 = str2;
        if ((i & 8) != 0) {
            str3 = storeDynamicLink$DynamicLinkData.inviteCode;
        }
        String str8 = str3;
        if ((i & 16) != 0) {
            str4 = storeDynamicLink$DynamicLinkData.guildTemplateCode;
        }
        String str9 = str4;
        if ((i & 32) != 0) {
            str5 = storeDynamicLink$DynamicLinkData.authToken;
        }
        return storeDynamicLink$DynamicLinkData.copy(uri, str6, str7, str8, str9, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Uri getUri() {
        return this.uri;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFingerprint() {
        return this.fingerprint;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAttemptId() {
        return this.attemptId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getInviteCode() {
        return this.inviteCode;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getGuildTemplateCode() {
        return this.guildTemplateCode;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAuthToken() {
        return this.authToken;
    }

    public final StoreDynamicLink$DynamicLinkData copy(Uri uri, String fingerprint, String attemptId, String inviteCode, String guildTemplateCode, String authToken) {
        return new StoreDynamicLink$DynamicLinkData(uri, fingerprint, attemptId, inviteCode, guildTemplateCode, authToken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreDynamicLink$DynamicLinkData)) {
            return false;
        }
        StoreDynamicLink$DynamicLinkData storeDynamicLink$DynamicLinkData = (StoreDynamicLink$DynamicLinkData) other;
        return m.areEqual(this.uri, storeDynamicLink$DynamicLinkData.uri) && m.areEqual(this.fingerprint, storeDynamicLink$DynamicLinkData.fingerprint) && m.areEqual(this.attemptId, storeDynamicLink$DynamicLinkData.attemptId) && m.areEqual(this.inviteCode, storeDynamicLink$DynamicLinkData.inviteCode) && m.areEqual(this.guildTemplateCode, storeDynamicLink$DynamicLinkData.guildTemplateCode) && m.areEqual(this.authToken, storeDynamicLink$DynamicLinkData.authToken);
    }

    public final String getAttemptId() {
        return this.attemptId;
    }

    public final String getAuthToken() {
        return this.authToken;
    }

    public final String getFingerprint() {
        return this.fingerprint;
    }

    public final String getGuildTemplateCode() {
        return this.guildTemplateCode;
    }

    public final String getInviteCode() {
        return this.inviteCode;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        Uri uri = this.uri;
        int iHashCode = (uri != null ? uri.hashCode() : 0) * 31;
        String str = this.fingerprint;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.attemptId;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.inviteCode;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.guildTemplateCode;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.authToken;
        return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("DynamicLinkData(uri=");
        sbU.append(this.uri);
        sbU.append(", fingerprint=");
        sbU.append(this.fingerprint);
        sbU.append(", attemptId=");
        sbU.append(this.attemptId);
        sbU.append(", inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", guildTemplateCode=");
        sbU.append(this.guildTemplateCode);
        sbU.append(", authToken=");
        return a.J(sbU, this.authToken, ")");
    }
}
