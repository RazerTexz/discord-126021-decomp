package com.discord.utilities.systemlog;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: SystemLogUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SystemLogUtils$Tombstone {
    private final String cause;
    private final String groupBy;
    private final String groupHash;
    private final String origin;
    private final String text;
    private final String textHash;

    public SystemLogUtils$Tombstone(String str, String str2, String str3, String str4, String str5, String str6) {
        m.checkNotNullParameter(str, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        m.checkNotNullParameter(str3, "groupBy");
        m.checkNotNullParameter(str4, "origin");
        m.checkNotNullParameter(str5, "groupHash");
        m.checkNotNullParameter(str6, "textHash");
        this.text = str;
        this.cause = str2;
        this.groupBy = str3;
        this.origin = str4;
        this.groupHash = str5;
        this.textHash = str6;
    }

    public static /* synthetic */ SystemLogUtils$Tombstone copy$default(SystemLogUtils$Tombstone systemLogUtils$Tombstone, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = systemLogUtils$Tombstone.text;
        }
        if ((i & 2) != 0) {
            str2 = systemLogUtils$Tombstone.cause;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = systemLogUtils$Tombstone.groupBy;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = systemLogUtils$Tombstone.origin;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = systemLogUtils$Tombstone.groupHash;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = systemLogUtils$Tombstone.textHash;
        }
        return systemLogUtils$Tombstone.copy(str, str7, str8, str9, str10, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCause() {
        return this.cause;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGroupBy() {
        return this.groupBy;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOrigin() {
        return this.origin;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getGroupHash() {
        return this.groupHash;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTextHash() {
        return this.textHash;
    }

    public final SystemLogUtils$Tombstone copy(String text, String cause, String groupBy, String origin, String groupHash, String textHash) {
        m.checkNotNullParameter(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        m.checkNotNullParameter(groupBy, "groupBy");
        m.checkNotNullParameter(origin, "origin");
        m.checkNotNullParameter(groupHash, "groupHash");
        m.checkNotNullParameter(textHash, "textHash");
        return new SystemLogUtils$Tombstone(text, cause, groupBy, origin, groupHash, textHash);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SystemLogUtils$Tombstone)) {
            return false;
        }
        SystemLogUtils$Tombstone systemLogUtils$Tombstone = (SystemLogUtils$Tombstone) other;
        return m.areEqual(this.text, systemLogUtils$Tombstone.text) && m.areEqual(this.cause, systemLogUtils$Tombstone.cause) && m.areEqual(this.groupBy, systemLogUtils$Tombstone.groupBy) && m.areEqual(this.origin, systemLogUtils$Tombstone.origin) && m.areEqual(this.groupHash, systemLogUtils$Tombstone.groupHash) && m.areEqual(this.textHash, systemLogUtils$Tombstone.textHash);
    }

    public final String getCause() {
        return this.cause;
    }

    public final String getGroupBy() {
        return this.groupBy;
    }

    public final String getGroupHash() {
        return this.groupHash;
    }

    public final String getOrigin() {
        return this.origin;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextHash() {
        return this.textHash;
    }

    public int hashCode() {
        String str = this.text;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.cause;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.groupBy;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.origin;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.groupHash;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.textHash;
        return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Tombstone(text=");
        sbU.append(this.text);
        sbU.append(", cause=");
        sbU.append(this.cause);
        sbU.append(", groupBy=");
        sbU.append(this.groupBy);
        sbU.append(", origin=");
        sbU.append(this.origin);
        sbU.append(", groupHash=");
        sbU.append(this.groupHash);
        sbU.append(", textHash=");
        return a.J(sbU, this.textHash, ")");
    }
}
