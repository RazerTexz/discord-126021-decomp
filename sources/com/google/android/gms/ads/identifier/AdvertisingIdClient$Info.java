package com.google.android.gms.ads.identifier;

/* JADX INFO: loaded from: classes3.dex */
public final class AdvertisingIdClient$Info {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2994b;

    public AdvertisingIdClient$Info(String str, boolean z2) {
        this.a = str;
        this.f2994b = z2;
    }

    public final String getId() {
        return this.a;
    }

    public final boolean isLimitAdTrackingEnabled() {
        return this.f2994b;
    }

    public final String toString() {
        String str = this.a;
        boolean z2 = this.f2994b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
        sb.append("{");
        sb.append(str);
        sb.append("}");
        sb.append(z2);
        return sb.toString();
    }
}
