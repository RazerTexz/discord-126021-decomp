package com.discord.restapi;

import androidx.appcompat.widget.ActivityChooserModel;
import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$Message {
    private final RestAPIParams$Message$Activity activity;
    private final RestAPIParams$Message$AllowedMentions allowedMentions;
    private final Long applicationId;
    private final String captchaKey;
    private final String captchaRqtoken;
    private final String content;
    private final RestAPIParams$Message$MessageReference messageReference;
    private final String nonce;
    private final List<Long> stickerIds;

    public RestAPIParams$Message(String str, String str2, Long l, RestAPIParams$Message$Activity restAPIParams$Message$Activity, List<Long> list, RestAPIParams$Message$MessageReference restAPIParams$Message$MessageReference, RestAPIParams$Message$AllowedMentions restAPIParams$Message$AllowedMentions, String str3, String str4) {
        this.content = str;
        this.nonce = str2;
        this.applicationId = l;
        this.activity = restAPIParams$Message$Activity;
        this.stickerIds = list;
        this.messageReference = restAPIParams$Message$MessageReference;
        this.allowedMentions = restAPIParams$Message$AllowedMentions;
        this.captchaKey = str3;
        this.captchaRqtoken = str4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RestAPIParams$Message copy$default(RestAPIParams$Message restAPIParams$Message, String str, String str2, Long l, RestAPIParams$Message$Activity restAPIParams$Message$Activity, List list, RestAPIParams$Message$MessageReference restAPIParams$Message$MessageReference, RestAPIParams$Message$AllowedMentions restAPIParams$Message$AllowedMentions, String str3, String str4, int i, Object obj) {
        return restAPIParams$Message.copy((i & 1) != 0 ? restAPIParams$Message.content : str, (i & 2) != 0 ? restAPIParams$Message.nonce : str2, (i & 4) != 0 ? restAPIParams$Message.applicationId : l, (i & 8) != 0 ? restAPIParams$Message.activity : restAPIParams$Message$Activity, (i & 16) != 0 ? restAPIParams$Message.stickerIds : list, (i & 32) != 0 ? restAPIParams$Message.messageReference : restAPIParams$Message$MessageReference, (i & 64) != 0 ? restAPIParams$Message.allowedMentions : restAPIParams$Message$AllowedMentions, (i & 128) != 0 ? restAPIParams$Message.captchaKey : str3, (i & 256) != 0 ? restAPIParams$Message.captchaRqtoken : str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getApplicationId() {
        return this.applicationId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final RestAPIParams$Message$Activity getActivity() {
        return this.activity;
    }

    public final List<Long> component5() {
        return this.stickerIds;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final RestAPIParams$Message$MessageReference getMessageReference() {
        return this.messageReference;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final RestAPIParams$Message$AllowedMentions getAllowedMentions() {
        return this.allowedMentions;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getCaptchaKey() {
        return this.captchaKey;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getCaptchaRqtoken() {
        return this.captchaRqtoken;
    }

    public final RestAPIParams$Message copy(String content, String nonce, Long applicationId, RestAPIParams$Message$Activity activity, List<Long> stickerIds, RestAPIParams$Message$MessageReference messageReference, RestAPIParams$Message$AllowedMentions allowedMentions, String captchaKey, String captchaRqtoken) {
        return new RestAPIParams$Message(content, nonce, applicationId, activity, stickerIds, messageReference, allowedMentions, captchaKey, captchaRqtoken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$Message)) {
            return false;
        }
        RestAPIParams$Message restAPIParams$Message = (RestAPIParams$Message) other;
        return m.areEqual(this.content, restAPIParams$Message.content) && m.areEqual(this.nonce, restAPIParams$Message.nonce) && m.areEqual(this.applicationId, restAPIParams$Message.applicationId) && m.areEqual(this.activity, restAPIParams$Message.activity) && m.areEqual(this.stickerIds, restAPIParams$Message.stickerIds) && m.areEqual(this.messageReference, restAPIParams$Message.messageReference) && m.areEqual(this.allowedMentions, restAPIParams$Message.allowedMentions) && m.areEqual(this.captchaKey, restAPIParams$Message.captchaKey) && m.areEqual(this.captchaRqtoken, restAPIParams$Message.captchaRqtoken);
    }

    public final RestAPIParams$Message$Activity getActivity() {
        return this.activity;
    }

    public final RestAPIParams$Message$AllowedMentions getAllowedMentions() {
        return this.allowedMentions;
    }

    public final Long getApplicationId() {
        return this.applicationId;
    }

    public final String getCaptchaKey() {
        return this.captchaKey;
    }

    public final String getCaptchaRqtoken() {
        return this.captchaRqtoken;
    }

    public final String getContent() {
        return this.content;
    }

    public final RestAPIParams$Message$MessageReference getMessageReference() {
        return this.messageReference;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final List<Long> getStickerIds() {
        return this.stickerIds;
    }

    public int hashCode() {
        String str = this.content;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.nonce;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l = this.applicationId;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        RestAPIParams$Message$Activity restAPIParams$Message$Activity = this.activity;
        int iHashCode4 = (iHashCode3 + (restAPIParams$Message$Activity != null ? restAPIParams$Message$Activity.hashCode() : 0)) * 31;
        List<Long> list = this.stickerIds;
        int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        RestAPIParams$Message$MessageReference restAPIParams$Message$MessageReference = this.messageReference;
        int iHashCode6 = (iHashCode5 + (restAPIParams$Message$MessageReference != null ? restAPIParams$Message$MessageReference.hashCode() : 0)) * 31;
        RestAPIParams$Message$AllowedMentions restAPIParams$Message$AllowedMentions = this.allowedMentions;
        int iHashCode7 = (iHashCode6 + (restAPIParams$Message$AllowedMentions != null ? restAPIParams$Message$AllowedMentions.hashCode() : 0)) * 31;
        String str3 = this.captchaKey;
        int iHashCode8 = (iHashCode7 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.captchaRqtoken;
        return iHashCode8 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Message(content=");
        sbU.append(this.content);
        sbU.append(", nonce=");
        sbU.append(this.nonce);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", activity=");
        sbU.append(this.activity);
        sbU.append(", stickerIds=");
        sbU.append(this.stickerIds);
        sbU.append(", messageReference=");
        sbU.append(this.messageReference);
        sbU.append(", allowedMentions=");
        sbU.append(this.allowedMentions);
        sbU.append(", captchaKey=");
        sbU.append(this.captchaKey);
        sbU.append(", captchaRqtoken=");
        return a.J(sbU, this.captchaRqtoken, ")");
    }

    public /* synthetic */ RestAPIParams$Message(String str, String str2, Long l, RestAPIParams$Message$Activity restAPIParams$Message$Activity, List list, RestAPIParams$Message$MessageReference restAPIParams$Message$MessageReference, RestAPIParams$Message$AllowedMentions restAPIParams$Message$AllowedMentions, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : restAPIParams$Message$Activity, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : restAPIParams$Message$MessageReference, (i & 64) != 0 ? null : restAPIParams$Message$AllowedMentions, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : str4);
    }
}
