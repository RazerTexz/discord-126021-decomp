package com.hcaptcha.sdk;

import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;

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

    /* JADX INFO: renamed from: com.hcaptcha.sdk.HCaptchaConfig$a */
    public static class C11151a {

        /* JADX INFO: renamed from: a */
        public String f21674a;

        /* JADX INFO: renamed from: b */
        public boolean f21675b;

        /* JADX INFO: renamed from: c */
        public Boolean f21676c;

        /* JADX INFO: renamed from: d */
        public boolean f21677d;

        /* JADX INFO: renamed from: e */
        public Boolean f21678e;

        /* JADX INFO: renamed from: f */
        public String f21679f;

        /* JADX INFO: renamed from: g */
        public boolean f21680g;

        /* JADX INFO: renamed from: h */
        public String f21681h;

        /* JADX INFO: renamed from: i */
        public String f21682i;

        /* JADX INFO: renamed from: j */
        public String f21683j;

        /* JADX INFO: renamed from: k */
        public String f21684k;

        /* JADX INFO: renamed from: l */
        public String f21685l;

        /* JADX INFO: renamed from: m */
        public boolean f21686m;

        /* JADX INFO: renamed from: n */
        public String f21687n;

        /* JADX INFO: renamed from: o */
        public boolean f21688o;

        /* JADX INFO: renamed from: p */
        public HCaptchaSize f21689p;

        /* JADX INFO: renamed from: q */
        public boolean f21690q;

        /* JADX INFO: renamed from: r */
        public HCaptchaTheme f21691r;

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("HCaptchaConfig.HCaptchaConfigBuilder(siteKey=");
            sbM833U.append(this.f21674a);
            sbM833U.append(", sentry$value=");
            sbM833U.append(this.f21676c);
            sbM833U.append(", loading$value=");
            sbM833U.append(this.f21678e);
            sbM833U.append(", rqdata=");
            sbM833U.append(this.f21679f);
            sbM833U.append(", apiEndpoint$value=");
            sbM833U.append(this.f21681h);
            sbM833U.append(", endpoint=");
            sbM833U.append(this.f21682i);
            sbM833U.append(", reportapi=");
            sbM833U.append(this.f21683j);
            sbM833U.append(", assethost=");
            sbM833U.append(this.f21684k);
            sbM833U.append(", imghost=");
            sbM833U.append(this.f21685l);
            sbM833U.append(", locale$value=");
            sbM833U.append(this.f21687n);
            sbM833U.append(", size$value=");
            sbM833U.append(this.f21689p);
            sbM833U.append(", theme$value=");
            sbM833U.append(this.f21691r);
            sbM833U.append(")");
            return sbM833U.toString();
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

    public static C11151a builder() {
        return new C11151a();
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

    public C11151a toBuilder() {
        C11151a c11151a = new C11151a();
        String str = this.siteKey;
        Objects.requireNonNull(str, "siteKey is marked non-null but is null");
        c11151a.f21674a = str;
        c11151a.f21676c = this.sentry;
        c11151a.f21675b = true;
        c11151a.f21678e = this.loading;
        c11151a.f21677d = true;
        c11151a.f21679f = this.rqdata;
        c11151a.f21681h = this.apiEndpoint;
        c11151a.f21680g = true;
        c11151a.f21682i = this.endpoint;
        c11151a.f21683j = this.reportapi;
        c11151a.f21684k = this.assethost;
        c11151a.f21685l = this.imghost;
        c11151a.f21687n = this.locale;
        c11151a.f21686m = true;
        c11151a.f21689p = this.size;
        c11151a.f21688o = true;
        c11151a.f21691r = this.theme;
        c11151a.f21690q = true;
        return c11151a;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("HCaptchaConfig(siteKey=");
        sbM833U.append(getSiteKey());
        sbM833U.append(", sentry=");
        sbM833U.append(getSentry());
        sbM833U.append(", loading=");
        sbM833U.append(getLoading());
        sbM833U.append(", rqdata=");
        sbM833U.append(getRqdata());
        sbM833U.append(", apiEndpoint=");
        sbM833U.append(getApiEndpoint());
        sbM833U.append(", endpoint=");
        sbM833U.append(getEndpoint());
        sbM833U.append(", reportapi=");
        sbM833U.append(getReportapi());
        sbM833U.append(", assethost=");
        sbM833U.append(getAssethost());
        sbM833U.append(", imghost=");
        sbM833U.append(getImghost());
        sbM833U.append(", locale=");
        sbM833U.append(getLocale());
        sbM833U.append(", size=");
        sbM833U.append(getSize());
        sbM833U.append(", theme=");
        sbM833U.append(getTheme());
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
