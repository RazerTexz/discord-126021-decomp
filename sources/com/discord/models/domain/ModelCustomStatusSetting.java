package com.discord.models.domain;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ModelCustomStatusSetting.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelCustomStatusSetting {
    private final Long emojiId;
    private final String emojiName;
    private final String expiresAt;
    private final String text;
    public static final ModelCustomStatusSetting$Companion Companion = new ModelCustomStatusSetting$Companion(null);
    private static final ModelCustomStatusSetting CLEAR = new ModelCustomStatusSetting(null, null, null, null);

    public ModelCustomStatusSetting(String str, Long l, String str2, String str3) {
        this.text = str;
        this.emojiId = l;
        this.emojiName = str2;
        this.expiresAt = str3;
    }

    public static final /* synthetic */ ModelCustomStatusSetting access$getCLEAR$cp() {
        return CLEAR;
    }

    public static /* synthetic */ ModelCustomStatusSetting copy$default(ModelCustomStatusSetting modelCustomStatusSetting, String str, Long l, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelCustomStatusSetting.text;
        }
        if ((i & 2) != 0) {
            l = modelCustomStatusSetting.emojiId;
        }
        if ((i & 4) != 0) {
            str2 = modelCustomStatusSetting.emojiName;
        }
        if ((i & 8) != 0) {
            str3 = modelCustomStatusSetting.expiresAt;
        }
        return modelCustomStatusSetting.copy(str, l, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getEmojiId() {
        return this.emojiId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEmojiName() {
        return this.emojiName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getExpiresAt() {
        return this.expiresAt;
    }

    public final ModelCustomStatusSetting copy(String text, Long emojiId, String emojiName, String expiresAt) {
        return new ModelCustomStatusSetting(text, emojiId, emojiName, expiresAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelCustomStatusSetting)) {
            return false;
        }
        ModelCustomStatusSetting modelCustomStatusSetting = (ModelCustomStatusSetting) other;
        return m.areEqual(this.text, modelCustomStatusSetting.text) && m.areEqual(this.emojiId, modelCustomStatusSetting.emojiId) && m.areEqual(this.emojiName, modelCustomStatusSetting.emojiName) && m.areEqual(this.expiresAt, modelCustomStatusSetting.expiresAt);
    }

    public final Long getEmojiId() {
        return this.emojiId;
    }

    public final String getEmojiName() {
        return this.emojiName;
    }

    public final String getExpiresAt() {
        return this.expiresAt;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.text;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.emojiId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        String str2 = this.emojiName;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.expiresAt;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelCustomStatusSetting(text=");
        sbU.append(this.text);
        sbU.append(", emojiId=");
        sbU.append(this.emojiId);
        sbU.append(", emojiName=");
        sbU.append(this.emojiName);
        sbU.append(", expiresAt=");
        return a.J(sbU, this.expiresAt, ")");
    }
}
