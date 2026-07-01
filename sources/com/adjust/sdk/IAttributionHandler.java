package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public interface IAttributionHandler {
    void checkSdkClickResponse(SdkClickResponseData sdkClickResponseData);

    void checkSessionResponse(SessionResponseData sessionResponseData);

    void getAttribution();

    void init(IActivityHandler iActivityHandler, boolean z2);

    void pauseSending();

    void resumeSending();

    void teardown();
}
