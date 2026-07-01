package com.discord.utilities.analytics;

import android.os.Build;
import android.util.Base64;
import com.discord.BuildConfig;
import com.discord.utilities.accessibility.AccessibilityFeatureFlags;
import com.google.gson.Gson;
import d0.Tuples;
import d0.b0.ObservableProperty;
import d0.g0.Charsets2;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.MutablePropertyReference1Impl;
import d0.z.d.Reflection2;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.properties.Interfaces;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: AnalyticSuperProperties.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticSuperProperties {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection2.mutableProperty1(new MutablePropertyReference1Impl(AnalyticSuperProperties.class, "superProperties", "getSuperProperties()Ljava/util/Map;", 0))};
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
    private static final Interfaces superProperties;
    private static String superPropertiesString;
    private static String superPropertiesStringBase64;

    static {
        AnalyticSuperProperties analyticSuperProperties = new AnalyticSuperProperties();
        INSTANCE = analyticSuperProperties;
        superPropertiesString = "";
        superPropertiesStringBase64 = "";
        final Map mapEmptyMap = Maps6.emptyMap();
        superProperties = new ObservableProperty<Map<String, ? extends Object>>(mapEmptyMap) { // from class: com.discord.utilities.analytics.AnalyticSuperProperties$$special$$inlined$observable$1
            @Override // d0.b0.ObservableProperty
            public void afterChange(KProperty<?> property, Map<String, ? extends Object> oldValue, Map<String, ? extends Object> newValue) {
                Intrinsics3.checkNotNullParameter(property, "property");
                AnalyticSuperProperties analyticSuperProperties2 = AnalyticSuperProperties.INSTANCE;
                String strM = new Gson().m(newValue);
                if (strM == null) {
                    strM = "{}";
                }
                AnalyticSuperProperties.superPropertiesString = strM;
                String superPropertiesString2 = analyticSuperProperties2.getSuperPropertiesString();
                Charset charset = Charsets2.a;
                Objects.requireNonNull(superPropertiesString2, "null cannot be cast to non-null type java.lang.String");
                byte[] bytes = superPropertiesString2.getBytes(charset);
                Intrinsics3.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                String strEncodeToString = Base64.encodeToString(bytes, 2);
                Intrinsics3.checkNotNullExpressionValue(strEncodeToString, "Base64.encodeToString(su…eArray(), Base64.NO_WRAP)");
                AnalyticSuperProperties.superPropertiesStringBase64 = strEncodeToString;
            }
        };
        analyticSuperProperties.setBaselineProperties();
    }

    private AnalyticSuperProperties() {
    }

    private final void setBaselineProperties() {
        String string = Locale.getDefault().toString();
        Intrinsics3.checkNotNullExpressionValue(string, "Locale.getDefault().toString()");
        updateSuperProperties(Maps6.mapOf(Tuples.to(PROPERTY_BROWSER, "Discord Android"), Tuples.to(PROPERTY_BROWSER_USER_AGENT, BuildConfig.USER_AGENT), Tuples.to(PROPERTY_CLIENT_BUILD_NUMBER, Integer.valueOf(BuildConfig.VERSION_CODE)), Tuples.to(PROPERTY_CLIENT_VERSION, BuildConfig.VERSION_NAME), Tuples.to(PROPERTY_DEVICE, Build.MODEL + ", " + Build.PRODUCT), Tuples.to(PROPERTY_OS, "Android"), Tuples.to(PROPERTY_OS_SDK_VERSION, String.valueOf(Build.VERSION.SDK_INT)), Tuples.to(PROPERTY_OS_VERSION, Build.VERSION.RELEASE), Tuples.to(PROPERTY_SYSTEM_LOCALE, StringsJVM.replace$default(string, "_", "-", false, 4, (Object) null))));
    }

    private final void setSuperProperties(Map<String, ? extends Object> map) {
        superProperties.setValue(this, $$delegatedProperties[0], map);
    }

    private final synchronized void updateSuperProperties(Map<String, ? extends Object> extraSuperProperties) {
        setSuperProperties(Maps6.plus(getSuperProperties(), extraSuperProperties));
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
        Intrinsics3.checkNotNullParameter(features, "features");
        Iterator<T> it = features.iterator();
        long value = 0;
        while (it.hasNext()) {
            value |= ((AccessibilityFeatureFlags) it.next()).getValue();
        }
        updateSuperProperties(Maps6.mapOf(Tuples.to(PROPERTY_ACCESSIBILITY_SUPPORT_ENABLED, Boolean.valueOf(accessibilitySupportEnabled)), Tuples.to(PROPERTY_ACCESSIBILITY_FEATURES, Long.valueOf(value))));
    }

    public final void setAdvertiserId(String advertiserId) {
        Intrinsics3.checkNotNullParameter(advertiserId, "advertiserId");
        updateSuperProperties(MapsJVM.mapOf(Tuples.to(PROPERTY_DEVICE_ADVERTISER_ID, advertiserId)));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:47:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f3  */
    public final void setCampaignProperties(String referrerUrl) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(referrerUrl, "referrerUrl");
        Map<String, ? extends Object> mapMutableMapOf = Maps6.mutableMapOf(Tuples.to("referrer", referrerUrl));
        List listSplit$default = Strings4.split$default((CharSequence) referrerUrl, new String[]{"&"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            arrayList.add(Strings4.split$default((CharSequence) it.next(), new String[]{"="}, false, 0, 6, (Object) null));
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
        updateSuperProperties(Maps6.mapOf(Tuples.to(PROPERTY_CLIENT_PERFORMANCE_CPU, Integer.valueOf(cpu)), Tuples.to(PROPERTY_CLIENT_PERFORMANCE_MEMORY, Long.valueOf(memoryKb)), Tuples.to(PROPERTY_CPU_CORE_COUNT, Integer.valueOf(cpuCoreCount))));
    }
}
