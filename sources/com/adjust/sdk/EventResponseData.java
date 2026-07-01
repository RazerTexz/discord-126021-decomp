package com.adjust.sdk;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class EventResponseData extends ResponseData {
    private String callbackId;
    private String eventToken;
    private String sdkPlatform;

    public EventResponseData(ActivityPackage activityPackage) {
        this.eventToken = activityPackage.getParameters().get("event_token");
        this.callbackId = activityPackage.getParameters().get("event_callback_id");
        this.sdkPlatform = Util.getSdkPrefixPlatform(activityPackage.getClientSdk());
    }

    public AdjustEventFailure getFailureResponseData() {
        if (this.success) {
            return null;
        }
        AdjustEventFailure adjustEventFailure = new AdjustEventFailure();
        if ("unity".equals(this.sdkPlatform)) {
            String str = this.eventToken;
            if (str == null) {
                str = "";
            }
            adjustEventFailure.eventToken = str;
            String str2 = this.message;
            if (str2 == null) {
                str2 = "";
            }
            adjustEventFailure.message = str2;
            String str3 = this.timestamp;
            if (str3 == null) {
                str3 = "";
            }
            adjustEventFailure.timestamp = str3;
            String str4 = this.adid;
            if (str4 == null) {
                str4 = "";
            }
            adjustEventFailure.adid = str4;
            String str5 = this.callbackId;
            adjustEventFailure.callbackId = str5 != null ? str5 : "";
            adjustEventFailure.willRetry = this.willRetry;
            JSONObject jSONObject = this.jsonResponse;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            adjustEventFailure.jsonResponse = jSONObject;
        } else {
            adjustEventFailure.eventToken = this.eventToken;
            adjustEventFailure.message = this.message;
            adjustEventFailure.timestamp = this.timestamp;
            adjustEventFailure.adid = this.adid;
            adjustEventFailure.callbackId = this.callbackId;
            adjustEventFailure.willRetry = this.willRetry;
            adjustEventFailure.jsonResponse = this.jsonResponse;
        }
        return adjustEventFailure;
    }

    public AdjustEventSuccess getSuccessResponseData() {
        if (!this.success) {
            return null;
        }
        AdjustEventSuccess adjustEventSuccess = new AdjustEventSuccess();
        if ("unity".equals(this.sdkPlatform)) {
            String str = this.eventToken;
            if (str == null) {
                str = "";
            }
            adjustEventSuccess.eventToken = str;
            String str2 = this.message;
            if (str2 == null) {
                str2 = "";
            }
            adjustEventSuccess.message = str2;
            String str3 = this.timestamp;
            if (str3 == null) {
                str3 = "";
            }
            adjustEventSuccess.timestamp = str3;
            String str4 = this.adid;
            if (str4 == null) {
                str4 = "";
            }
            adjustEventSuccess.adid = str4;
            String str5 = this.callbackId;
            adjustEventSuccess.callbackId = str5 != null ? str5 : "";
            JSONObject jSONObject = this.jsonResponse;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            adjustEventSuccess.jsonResponse = jSONObject;
        } else {
            adjustEventSuccess.eventToken = this.eventToken;
            adjustEventSuccess.message = this.message;
            adjustEventSuccess.timestamp = this.timestamp;
            adjustEventSuccess.adid = this.adid;
            adjustEventSuccess.callbackId = this.callbackId;
            adjustEventSuccess.jsonResponse = this.jsonResponse;
        }
        return adjustEventSuccess;
    }
}
