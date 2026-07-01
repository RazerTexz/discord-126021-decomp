package com.hcaptcha.sdk;

import b.d.b.a.outline;
import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class HCaptchaConfig implements Serializable {
    private String apiEndpoint;
    private String assethost;
    private String endpoint;
    private String imghost;
    private Boolean loading;
    private String locale;
    private String reportapi;
    private String rqdata;
    private Boolean sentry;
    private String siteKey;
    private HCaptchaSize size;
    private HCaptchaTheme theme;

    public static class a {
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
            StringBuilder sbU = outline.U("HCaptchaConfig.HCaptchaConfigBuilder(siteKey=");
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

    private static String $default$apiEndpoint() {
        return "https://hcaptcha.com/1/api.js";
    }

    private static String $default$locale() {
        return Locale.getDefault().getLanguage();
    }

    public HCaptchaConfig(String str, Boolean bool, Boolean bool2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, HCaptchaSize hCaptchaSize, HCaptchaTheme hCaptchaTheme) {
        Objects.requireNonNull(str, "siteKey is marked non-null but is null");
        this.siteKey = str;
        this.sentry = bool;
        this.loading = bool2;
        this.rqdata = str2;
        this.apiEndpoint = str3;
        this.endpoint = str4;
        this.reportapi = str5;
        this.assethost = str6;
        this.imghost = str7;
        this.locale = str8;
        this.size = hCaptchaSize;
        this.theme = hCaptchaTheme;
    }

    public static a builder() {
        return new a();
    }

    public boolean canEqual(Object obj) {
        return obj instanceof HCaptchaConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HCaptchaConfig)) {
            return false;
        }
        HCaptchaConfig hCaptchaConfig = (HCaptchaConfig) obj;
        if (!hCaptchaConfig.canEqual(this)) {
            return false;
        }
        Boolean sentry = getSentry();
        Boolean sentry2 = hCaptchaConfig.getSentry();
        if (sentry != null ? !sentry.equals(sentry2) : sentry2 != null) {
            return false;
        }
        Boolean loading = getLoading();
        Boolean loading2 = hCaptchaConfig.getLoading();
        if (loading != null ? !loading.equals(loading2) : loading2 != null) {
            return false;
        }
        String siteKey = getSiteKey();
        String siteKey2 = hCaptchaConfig.getSiteKey();
        if (siteKey != null ? !siteKey.equals(siteKey2) : siteKey2 != null) {
            return false;
        }
        String rqdata = getRqdata();
        String rqdata2 = hCaptchaConfig.getRqdata();
        if (rqdata != null ? !rqdata.equals(rqdata2) : rqdata2 != null) {
            return false;
        }
        String apiEndpoint = getApiEndpoint();
        String apiEndpoint2 = hCaptchaConfig.getApiEndpoint();
        if (apiEndpoint != null ? !apiEndpoint.equals(apiEndpoint2) : apiEndpoint2 != null) {
            return false;
        }
        String endpoint = getEndpoint();
        String endpoint2 = hCaptchaConfig.getEndpoint();
        if (endpoint != null ? !endpoint.equals(endpoint2) : endpoint2 != null) {
            return false;
        }
        String reportapi = getReportapi();
        String reportapi2 = hCaptchaConfig.getReportapi();
        if (reportapi != null ? !reportapi.equals(reportapi2) : reportapi2 != null) {
            return false;
        }
        String assethost = getAssethost();
        String assethost2 = hCaptchaConfig.getAssethost();
        if (assethost != null ? !assethost.equals(assethost2) : assethost2 != null) {
            return false;
        }
        String imghost = getImghost();
        String imghost2 = hCaptchaConfig.getImghost();
        if (imghost != null ? !imghost.equals(imghost2) : imghost2 != null) {
            return false;
        }
        String locale = getLocale();
        String locale2 = hCaptchaConfig.getLocale();
        if (locale != null ? !locale.equals(locale2) : locale2 != null) {
            return false;
        }
        HCaptchaSize size = getSize();
        HCaptchaSize size2 = hCaptchaConfig.getSize();
        if (size != null ? !size.equals(size2) : size2 != null) {
            return false;
        }
        HCaptchaTheme theme = getTheme();
        HCaptchaTheme theme2 = hCaptchaConfig.getTheme();
        return theme != null ? theme.equals(theme2) : theme2 == null;
    }

    public String getApiEndpoint() {
        return this.apiEndpoint;
    }

    public String getAssethost() {
        return this.assethost;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public String getImghost() {
        return this.imghost;
    }

    public Boolean getLoading() {
        return this.loading;
    }

    public String getLocale() {
        return this.locale;
    }

    public String getReportapi() {
        return this.reportapi;
    }

    public String getRqdata() {
        return this.rqdata;
    }

    public Boolean getSentry() {
        return this.sentry;
    }

    public String getSiteKey() {
        return this.siteKey;
    }

    public HCaptchaSize getSize() {
        return this.size;
    }

    public HCaptchaTheme getTheme() {
        return this.theme;
    }

    public int hashCode() {
        Boolean sentry = getSentry();
        int iHashCode = sentry == null ? 43 : sentry.hashCode();
        Boolean loading = getLoading();
        int iHashCode2 = ((iHashCode + 59) * 59) + (loading == null ? 43 : loading.hashCode());
        String siteKey = getSiteKey();
        int iHashCode3 = (iHashCode2 * 59) + (siteKey == null ? 43 : siteKey.hashCode());
        String rqdata = getRqdata();
        int iHashCode4 = (iHashCode3 * 59) + (rqdata == null ? 43 : rqdata.hashCode());
        String apiEndpoint = getApiEndpoint();
        int iHashCode5 = (iHashCode4 * 59) + (apiEndpoint == null ? 43 : apiEndpoint.hashCode());
        String endpoint = getEndpoint();
        int iHashCode6 = (iHashCode5 * 59) + (endpoint == null ? 43 : endpoint.hashCode());
        String reportapi = getReportapi();
        int iHashCode7 = (iHashCode6 * 59) + (reportapi == null ? 43 : reportapi.hashCode());
        String assethost = getAssethost();
        int iHashCode8 = (iHashCode7 * 59) + (assethost == null ? 43 : assethost.hashCode());
        String imghost = getImghost();
        int iHashCode9 = (iHashCode8 * 59) + (imghost == null ? 43 : imghost.hashCode());
        String locale = getLocale();
        int iHashCode10 = (iHashCode9 * 59) + (locale == null ? 43 : locale.hashCode());
        HCaptchaSize size = getSize();
        int iHashCode11 = (iHashCode10 * 59) + (size == null ? 43 : size.hashCode());
        HCaptchaTheme theme = getTheme();
        return (iHashCode11 * 59) + (theme != null ? theme.hashCode() : 43);
    }

    public void setApiEndpoint(String str) {
        this.apiEndpoint = str;
    }

    public void setAssethost(String str) {
        this.assethost = str;
    }

    public void setEndpoint(String str) {
        this.endpoint = str;
    }

    public void setImghost(String str) {
        this.imghost = str;
    }

    public void setLoading(Boolean bool) {
        this.loading = bool;
    }

    public void setLocale(String str) {
        this.locale = str;
    }

    public void setReportapi(String str) {
        this.reportapi = str;
    }

    public void setRqdata(String str) {
        this.rqdata = str;
    }

    public void setSentry(Boolean bool) {
        this.sentry = bool;
    }

    public void setSiteKey(String str) {
        Objects.requireNonNull(str, "siteKey is marked non-null but is null");
        this.siteKey = str;
    }

    public void setSize(HCaptchaSize hCaptchaSize) {
        this.size = hCaptchaSize;
    }

    public void setTheme(HCaptchaTheme hCaptchaTheme) {
        this.theme = hCaptchaTheme;
    }

    public a toBuilder() {
        a aVar = new a();
        String str = this.siteKey;
        Objects.requireNonNull(str, "siteKey is marked non-null but is null");
        aVar.a = str;
        aVar.c = this.sentry;
        aVar.f3141b = true;
        aVar.e = this.loading;
        aVar.d = true;
        aVar.f = this.rqdata;
        aVar.h = this.apiEndpoint;
        aVar.g = true;
        aVar.i = this.endpoint;
        aVar.j = this.reportapi;
        aVar.k = this.assethost;
        aVar.l = this.imghost;
        aVar.n = this.locale;
        aVar.m = true;
        aVar.p = this.size;
        aVar.o = true;
        aVar.r = this.theme;
        aVar.q = true;
        return aVar;
    }

    public String toString() {
        StringBuilder sbU = outline.U("HCaptchaConfig(siteKey=");
        sbU.append(getSiteKey());
        sbU.append(", sentry=");
        sbU.append(getSentry());
        sbU.append(", loading=");
        sbU.append(getLoading());
        sbU.append(", rqdata=");
        sbU.append(getRqdata());
        sbU.append(", apiEndpoint=");
        sbU.append(getApiEndpoint());
        sbU.append(", endpoint=");
        sbU.append(getEndpoint());
        sbU.append(", reportapi=");
        sbU.append(getReportapi());
        sbU.append(", assethost=");
        sbU.append(getAssethost());
        sbU.append(", imghost=");
        sbU.append(getImghost());
        sbU.append(", locale=");
        sbU.append(getLocale());
        sbU.append(", size=");
        sbU.append(getSize());
        sbU.append(", theme=");
        sbU.append(getTheme());
        sbU.append(")");
        return sbU.toString();
    }
}
