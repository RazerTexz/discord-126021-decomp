package com.discord.utilities.analytics;

import android.os.Build;
import android.os.Build$VERSION;
import com.discord.BuildConfig;
import com.discord.utilities.accessibility.AccessibilityFeatureFlags;
import d0.g0.t;
import d0.g0.w;
import d0.o;
import d0.t.g0;
import d0.t.h0;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.s;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: AnalyticSuperProperties.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticSuperProperties {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a0.mutableProperty1(new s(AnalyticSuperProperties.class, "superProperties", "getSuperProperties()Ljava/util/Map;", 0))};
    public static final AnalyticSuperProperties INSTANCE;
    private static final String PROPERTY_ACCESSIBILITY_FEATURES = "accessibility_features";
    private static final String PROPERTY_ACCESSIBILITY_SUPPORT_ENABLED = "accessibility_support_enabled";
    private static final String PROPERTY_BROWSER = "browser";
    private static final String PROPERTY_BROWSER_USER_AGENT = "browser_user_agent";
    private static final String PROPERTY_CLIENT_BUILD_NUMBER = "client_build_number";
    private static final String PROPERTY_CLIENT_PERFORMANCE_CPU = "client_performance_cpu";
    private static final String PROPERTY_CLIENT_PERFORMANCE_MEMORY = "client_performance_memory";
    private static final String PROPERTY_CLIENT_VERSION = "client_version";
    private static final String PROPERTY_CPU_CORE_COUNT = "cpu_core_count";
    private static final String PROPERTY_DEVICE = "device";
    private static final String PROPERTY_DEVICE_ADVERTISER_ID = "device_advertiser_id";
    private static final String PROPERTY_LOCATION = "location";
    private static final String PROPERTY_MP_KEYWORD = "mp_keyword";
    private static final String PROPERTY_OS = "os";
    private static final String PROPERTY_OS_SDK_VERSION = "os_sdk_version";
    private static final String PROPERTY_OS_VERSION = "os_version";
    private static final String PROPERTY_REFERRER = "referrer";
    private static final String PROPERTY_REFERRING_DOMAIN = "referring_domain";
    private static final String PROPERTY_SEARCH_ENGINE = "search_engine";
    private static final String PROPERTY_SYSTEM_LOCALE = "system_locale";
    private static final String PROPERTY_UTM_CAMPAIGN = "utm_campaign";
    private static final String PROPERTY_UTM_CONTENT = "utm_content";
    private static final String PROPERTY_UTM_MEDIUM = "utm_medium";
    private static final String PROPERTY_UTM_SOURCE = "utm_source";
    private static final String PROPERTY_UTM_TERM = "utm_term";

    /* JADX INFO: renamed from: superProperties$delegate, reason: from kotlin metadata */
    private static final ReadWriteProperty superProperties;
    private static String superPropertiesString;
    private static String superPropertiesStringBase64;

    static {
        AnalyticSuperProperties analyticSuperProperties = new AnalyticSuperProperties();
        INSTANCE = analyticSuperProperties;
        superPropertiesString = "";
        superPropertiesStringBase64 = "";
        Map mapEmptyMap = h0.emptyMap();
        superProperties = new AnalyticSuperProperties$$special$$inlined$observable$1(mapEmptyMap, mapEmptyMap);
        analyticSuperProperties.setBaselineProperties();
    }

    private AnalyticSuperProperties() {
    }

    public static final /* synthetic */ String access$getSuperPropertiesString$p(AnalyticSuperProperties analyticSuperProperties) {
        return superPropertiesString;
    }

    public static final /* synthetic */ String access$getSuperPropertiesStringBase64$p(AnalyticSuperProperties analyticSuperProperties) {
        return superPropertiesStringBase64;
    }

    public static final /* synthetic */ void access$setSuperPropertiesString$p(AnalyticSuperProperties analyticSuperProperties, String str) {
        superPropertiesString = str;
    }

    public static final /* synthetic */ void access$setSuperPropertiesStringBase64$p(AnalyticSuperProperties analyticSuperProperties, String str) {
        superPropertiesStringBase64 = str;
    }

    private final void setBaselineProperties() {
        String string = Locale.getDefault().toString();
        m.checkNotNullExpressionValue(string, "Locale.getDefault().toString()");
        updateSuperProperties(h0.mapOf(o.to(PROPERTY_BROWSER, "Discord Android"), o.to(PROPERTY_BROWSER_USER_AGENT, BuildConfig.USER_AGENT), o.to(PROPERTY_CLIENT_BUILD_NUMBER, Integer.valueOf(BuildConfig.VERSION_CODE)), o.to(PROPERTY_CLIENT_VERSION, BuildConfig.VERSION_NAME), o.to(PROPERTY_DEVICE, Build.MODEL + ", " + Build.PRODUCT), o.to(PROPERTY_OS, "Android"), o.to(PROPERTY_OS_SDK_VERSION, String.valueOf(Build$VERSION.SDK_INT)), o.to(PROPERTY_OS_VERSION, Build$VERSION.RELEASE), o.to(PROPERTY_SYSTEM_LOCALE, t.replace$default(string, "_", "-", false, 4, (Object) null))));
    }

    private final void setSuperProperties(Map<String, ? extends Object> map) {
        superProperties.setValue(this, $$delegatedProperties[0], map);
    }

    private final synchronized void updateSuperProperties(Map<String, ? extends Object> extraSuperProperties) {
        setSuperProperties(h0.plus(getSuperProperties(), extraSuperProperties));
    }

    public final Map<String, Object> getSuperProperties() {
        return (Map) superProperties.getValue(this, $$delegatedProperties[0]);
    }

    public final String getSuperPropertiesString() {
        return superPropertiesString;
    }

    public final String getSuperPropertiesStringBase64() {
        return superPropertiesStringBase64;
    }

    public final void setAccessibilityProperties(boolean accessibilitySupportEnabled, EnumSet<AccessibilityFeatureFlags> features) {
        m.checkNotNullParameter(features, "features");
        Iterator<T> it = features.iterator();
        long value = 0;
        while (it.hasNext()) {
            value |= ((AccessibilityFeatureFlags) it.next()).getValue();
        }
        updateSuperProperties(h0.mapOf(o.to(PROPERTY_ACCESSIBILITY_SUPPORT_ENABLED, Boolean.valueOf(accessibilitySupportEnabled)), o.to(PROPERTY_ACCESSIBILITY_FEATURES, Long.valueOf(value))));
    }

    public final void setAdvertiserId(String advertiserId) {
        m.checkNotNullParameter(advertiserId, "advertiserId");
        updateSuperProperties(g0.mapOf(o.to(PROPERTY_DEVICE_ADVERTISER_ID, advertiserId)));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:47:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f3  */
    public final void setCampaignProperties(String referrerUrl) {
        boolean z2;
        m.checkNotNullParameter(referrerUrl, "referrerUrl");
        Map<String, ? extends Object> mapMutableMapOf = h0.mutableMapOf(o.to("referrer", referrerUrl));
        List listSplit$default = w.split$default((CharSequence) referrerUrl, new String[]{"&"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            arrayList.add(w.split$default((CharSequence) it.next(), new String[]{"="}, false, 0, 6, (Object) null));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((List) obj).size() == 2) {
                arrayList2.add(obj);
            }
        }
        ArrayList<List> arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            switch ((String) ((List) obj2).get(0)) {
                case "utm_content":
                case "referring_domain":
                case "utm_campaign":
                case "utm_term":
                case "mp_keyword":
                case "search_engine":
                case "utm_medium":
                case "location":
                case "utm_source":
                    z2 = true;
                    break;
                default:
                    z2 = false;
                    break;
            }
            if (z2) {
                arrayList3.add(obj2);
            }
        }
        for (List list : arrayList3) {
            mapMutableMapOf.put((String) list.get(0), (String) list.get(1));
        }
        updateSuperProperties(mapMutableMapOf);
    }

    public final void setClientPerformanceProperties(int cpu, long memoryKb, int cpuCoreCount) {
        updateSuperProperties(h0.mapOf(o.to(PROPERTY_CLIENT_PERFORMANCE_CPU, Integer.valueOf(cpu)), o.to(PROPERTY_CLIENT_PERFORMANCE_MEMORY, Long.valueOf(memoryKb)), o.to(PROPERTY_CPU_CORE_COUNT, Integer.valueOf(cpuCoreCount))));
    }
}
