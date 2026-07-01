package com.hcaptcha.sdk;

import b.d.b.a.a;

/* JADX INFO: loaded from: classes3.dex */
public class HCaptchaConfig$a {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3141b;
    public Boolean c;
    public boolean d;
    public Boolean e;
    public String f;
    public boolean g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public boolean m;
    public String n;
    public boolean o;
    public HCaptchaSize p;
    public boolean q;
    public HCaptchaTheme r;

    public String toString() {
        StringBuilder sbU = a.U("HCaptchaConfig.HCaptchaConfigBuilder(siteKey=");
        sbU.append(this.a);
        sbU.append(", sentry$value=");
        sbU.append(this.c);
        sbU.append(", loading$value=");
        sbU.append(this.e);
        sbU.append(", rqdata=");
        sbU.append(this.f);
        sbU.append(", apiEndpoint$value=");
        sbU.append(this.h);
        sbU.append(", endpoint=");
        sbU.append(this.i);
        sbU.append(", reportapi=");
        sbU.append(this.j);
        sbU.append(", assethost=");
        sbU.append(this.k);
        sbU.append(", imghost=");
        sbU.append(this.l);
        sbU.append(", locale$value=");
        sbU.append(this.n);
        sbU.append(", size$value=");
        sbU.append(this.p);
        sbU.append(", theme$value=");
        sbU.append(this.r);
        sbU.append(")");
        return sbU.toString();
    }
}
