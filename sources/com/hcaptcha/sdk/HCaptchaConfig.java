package com.hcaptcha.sdk;

import b.d.b.a.a;
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

    private static String $default$apiEndpoint() {
        return "https://hcaptcha.com/1/api.js";
    }

    private static Boolean $default$loading() {
        return Boolean.TRUE;
    }

    private static String $default$locale() {
        return Locale.getDefault().getLanguage();
    }

    private static Boolean $default$sentry() {
        return Boolean.TRUE;
    }

    private static HCaptchaSize $default$size() {
        return HCaptchaSize.INVISIBLE;
    }

    private static HCaptchaTheme $default$theme() {
        return HCaptchaTheme.LIGHT;
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

    public static /* synthetic */ Boolean access$000() {
        return $default$sentry();
    }

    public static /* synthetic */ Boolean access$100() {
        return $default$loading();
    }

    public static /* synthetic */ String access$200() {
        return $default$apiEndpoint();
    }

    public static /* synthetic */ String access$300() {
        return $default$locale();
    }

    public static /* synthetic */ HCaptchaSize access$400() {
        return $default$size();
    }

    public static /* synthetic */ HCaptchaTheme access$500() {
        return $default$theme();
    }

    public static HCaptchaConfig$a builder() {
        return new HCaptchaConfig$a();
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

    public HCaptchaConfig$a toBuilder() {
        HCaptchaConfig$a hCaptchaConfig$a = new HCaptchaConfig$a();
        String str = this.siteKey;
        Objects.requireNonNull(str, "siteKey is marked non-null but is null");
        hCaptchaConfig$a.a = str;
        hCaptchaConfig$a.c = this.sentry;
        hCaptchaConfig$a.f3141b = true;
        hCaptchaConfig$a.e = this.loading;
        hCaptchaConfig$a.d = true;
        hCaptchaConfig$a.f = this.rqdata;
        hCaptchaConfig$a.h = this.apiEndpoint;
        hCaptchaConfig$a.g = true;
        hCaptchaConfig$a.i = this.endpoint;
        hCaptchaConfig$a.j = this.reportapi;
        hCaptchaConfig$a.k = this.assethost;
        hCaptchaConfig$a.l = this.imghost;
        hCaptchaConfig$a.n = this.locale;
        hCaptchaConfig$a.m = true;
        hCaptchaConfig$a.p = this.size;
        hCaptchaConfig$a.o = true;
        hCaptchaConfig$a.r = this.theme;
        hCaptchaConfig$a.q = true;
        return hCaptchaConfig$a;
    }

    public String toString() {
        StringBuilder sbU = a.U("HCaptchaConfig(siteKey=");
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
