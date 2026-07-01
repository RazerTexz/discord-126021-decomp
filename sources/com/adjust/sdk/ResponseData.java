package com.adjust.sdk;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ResponseData {
    public ActivityKind activityKind;
    public String adid;
    public AdjustAttribution attribution;
    public JSONObject jsonResponse;
    public String message;
    public boolean success;
    public String timestamp;
    public TrackingState trackingState;
    public boolean willRetry;

    public static ResponseData buildResponseData(ActivityPackage activityPackage) {
        ResponseData sessionResponseData;
        ResponseData sdkClickResponseData;
        ActivityKind activityKind = activityPackage.getActivityKind();
        int iOrdinal = activityKind.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                sessionResponseData = new EventResponseData(activityPackage);
            } else if (iOrdinal != 3) {
                sdkClickResponseData = iOrdinal != 4 ? new ResponseData() : new AttributionResponseData();
            } else {
                sdkClickResponseData = new SdkClickResponseData();
            }
            sdkClickResponseData.activityKind = activityKind;
            return sdkClickResponseData;
        }
        sessionResponseData = new SessionResponseData(activityPackage);
        sdkClickResponseData = sessionResponseData;
        sdkClickResponseData.activityKind = activityKind;
        return sdkClickResponseData;
    }

    public String toString() {
        return Util.formatString("message:%s timestamp:%s json:%s", this.message, this.timestamp, this.jsonResponse);
    }
}
