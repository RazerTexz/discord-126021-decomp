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

    /* JADX INFO: renamed from: com.adjust.sdk.ResponseData$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$adjust$sdk$ActivityKind;

        static {
            ActivityKind.values();
            int[] iArr = new int[12];
            $SwitchMap$com$adjust$sdk$ActivityKind = iArr;
            try {
                iArr[ActivityKind.SESSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.ATTRIBUTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.EVENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

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
