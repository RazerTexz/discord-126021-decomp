package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public final class GooglePlayServicesClient$GooglePlayServicesInfo {
    private final String gpsAdid;
    private final Boolean trackingEnabled;

    public GooglePlayServicesClient$GooglePlayServicesInfo(String str, Boolean bool) {
        this.gpsAdid = str;
        this.trackingEnabled = bool;
    }

    public String getGpsAdid() {
        return this.gpsAdid;
    }

    public Boolean isTrackingEnabled() {
        return this.trackingEnabled;
    }
}
