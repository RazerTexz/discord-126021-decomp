package com.adjust.sdk;

import android.content.ContentResolver;
import android.text.TextUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PackageBuilder {
    private static ILogger logger = AdjustFactory.getLogger();
    private ActivityStateCopy activityStateCopy;
    private AdjustConfig adjustConfig;
    public AdjustAttribution attribution;
    private long createdAt;
    public String deeplink;
    private DeviceInfo deviceInfo;
    public Map<String, String> extraParameters;
    public String rawReferrer;
    public String referrer;
    public String referrerApi;
    public String reftag;
    private SessionParameters sessionParameters;
    public long clickTimeInSeconds = -1;
    public long clickTimeInMilliseconds = -1;
    public long installBeginTimeInSeconds = -1;

    public class ActivityStateCopy {
        public int eventCount;
        public long lastInterval;
        public String pushToken;
        public int sessionCount;
        public long sessionLength;
        public int subsessionCount;
        public long timeSpent;
        public String uuid;

        public ActivityStateCopy(ActivityState activityState) {
            this.eventCount = -1;
            this.sessionCount = -1;
            this.subsessionCount = -1;
            this.timeSpent = -1L;
            this.lastInterval = -1L;
            this.sessionLength = -1L;
            this.uuid = null;
            this.pushToken = null;
            if (activityState == null) {
                return;
            }
            this.eventCount = activityState.eventCount;
            this.sessionCount = activityState.sessionCount;
            this.subsessionCount = activityState.subsessionCount;
            this.timeSpent = activityState.timeSpent;
            this.lastInterval = activityState.lastInterval;
            this.sessionLength = activityState.sessionLength;
            this.uuid = activityState.uuid;
            this.pushToken = activityState.pushToken;
        }
    }

    public PackageBuilder(AdjustConfig adjustConfig, DeviceInfo deviceInfo, ActivityState activityState, SessionParameters sessionParameters, long j) {
        this.createdAt = j;
        this.deviceInfo = deviceInfo;
        this.adjustConfig = adjustConfig;
        this.activityStateCopy = new ActivityStateCopy(activityState);
        this.sessionParameters = sessionParameters;
    }

    public static void addBoolean(Map<String, String> map, String str, Boolean bool) {
        if (bool == null) {
            return;
        }
        addLong(map, str, bool.booleanValue() ? 1L : 0L);
    }

    private static void addDate(Map<String, String> map, String str, Date date) {
        if (date == null) {
            return;
        }
        addString(map, str, Util.dateFormatter.format(date));
    }

    private static void addDateInMilliseconds(Map<String, String> map, String str, long j) {
        if (j <= 0) {
            return;
        }
        addDate(map, str, new Date(j));
    }

    private static void addDateInSeconds(Map<String, String> map, String str, long j) {
        if (j <= 0) {
            return;
        }
        addDate(map, str, new Date(j * 1000));
    }

    private static void addDouble(Map<String, String> map, String str, Double d) {
        if (d == null) {
            return;
        }
        addString(map, str, Util.formatString("%.5f", d));
    }

    private static void addDuration(Map<String, String> map, String str, long j) {
        if (j < 0) {
            return;
        }
        addLong(map, str, (j + 500) / 1000);
    }

    public static void addJsonObject(Map<String, String> map, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        addString(map, str, jSONObject.toString());
    }

    public static void addLong(Map<String, String> map, String str, long j) {
        if (j < 0) {
            return;
        }
        addString(map, str, Long.toString(j));
    }

    public static void addMapJson(Map<String, String> map, String str, Map<String, String> map2) {
        if (map2 == null || map2.size() == 0) {
            return;
        }
        addString(map, str, new JSONObject(map2).toString());
    }

    public static void addString(Map<String, String> map, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }

    private void checkDeviceIds(Map<String, String> map) {
        if (map == null || map.containsKey("mac_sha1") || map.containsKey("mac_md5") || map.containsKey("android_id") || map.containsKey("gps_adid") || map.containsKey("oaid") || map.containsKey("imei") || map.containsKey("meid") || map.containsKey("device_id") || map.containsKey("imeis") || map.containsKey("meids") || map.containsKey("device_ids")) {
            return;
        }
        logger.error("Missing device id's. Please check if Proguard is correctly set with Adjust SDK", new Object[0]);
    }

    private boolean containsPlayIds(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        return map.containsKey("gps_adid");
    }

    private Map<String, String> getAdRevenueParameters(String str, JSONObject jSONObject) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap map = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            map.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            map.putAll(oaidParameters);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(map, "android_uuid", this.activityStateCopy.uuid);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "gps_adid", this.deviceInfo.playAdId);
        addString(map, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addLong(map, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        if (!containsPlayIds(map)) {
            logger.warn("Google Advertising ID not detected, fallback to non Google Play identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(map, "mac_sha1", this.deviceInfo.macSha1);
            addString(map, "mac_md5", this.deviceInfo.macShortMd5);
            addString(map, "android_id", this.deviceInfo.androidId);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_secret", this.adjustConfig.appSecret);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addLong(map, "connectivity_type", Util.getConnectivityType(this.adjustConfig.context));
        addString(map, "country", this.deviceInfo.country);
        addString(map, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addString(map, "default_tracker", this.adjustConfig.defaultTracker);
        addBoolean(map, "device_known", this.adjustConfig.deviceKnown);
        addString(map, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addString(map, "display_height", this.deviceInfo.displayHeight);
        addString(map, "display_width", this.deviceInfo.displayWidth);
        addString(map, "environment", this.adjustConfig.environment);
        addBoolean(map, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(map, "fb_id", this.deviceInfo.fbAttributionId);
        addString(map, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(map, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        addString(map, "hardware_name", this.deviceInfo.hardwareName);
        addString(map, "installed_at", this.deviceInfo.appInstallTime);
        addString(map, "language", this.deviceInfo.language);
        addDuration(map, "last_interval", this.activityStateCopy.lastInterval);
        addString(map, "mcc", Util.getMcc(this.adjustConfig.context));
        addString(map, "mnc", Util.getMnc(this.adjustConfig.context));
        addBoolean(map, "needs_response_details", bool);
        addLong(map, "network_type", Util.getNetworkType(this.adjustConfig.context));
        addString(map, "os_build", this.deviceInfo.buildName);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.pushToken);
        addString(map, "screen_density", this.deviceInfo.screenDensity);
        addString(map, "screen_format", this.deviceInfo.screenFormat);
        addString(map, "screen_size", this.deviceInfo.screenSize);
        addString(map, "secret_id", this.adjustConfig.secretId);
        addString(map, "source", str);
        addJsonObject(map, "payload", jSONObject);
        addLong(map, "session_count", this.activityStateCopy.sessionCount);
        addDuration(map, "session_length", this.activityStateCopy.sessionLength);
        addLong(map, "subsession_count", this.activityStateCopy.subsessionCount);
        addDuration(map, "time_spent", this.activityStateCopy.timeSpent);
        addString(map, "updated_at", this.deviceInfo.appUpdateTime);
        checkDeviceIds(map);
        return map;
    }

    private Map<String, String> getAttributionParameters(String str) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap map = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            map.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            map.putAll(oaidParameters);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(map, "android_uuid", this.activityStateCopy.uuid);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "gps_adid", this.deviceInfo.playAdId);
        addString(map, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addLong(map, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        if (!containsPlayIds(map)) {
            logger.warn("Google Advertising ID not detected, fallback to non Google Play identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(map, "mac_sha1", this.deviceInfo.macSha1);
            addString(map, "mac_md5", this.deviceInfo.macShortMd5);
            addString(map, "android_id", this.deviceInfo.androidId);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_secret", this.adjustConfig.appSecret);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addBoolean(map, "device_known", this.adjustConfig.deviceKnown);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addString(map, "environment", this.adjustConfig.environment);
        addBoolean(map, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(map, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(map, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        addString(map, "initiated_by", str);
        addBoolean(map, "needs_response_details", bool);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.pushToken);
        addString(map, "secret_id", this.adjustConfig.secretId);
        checkDeviceIds(map);
        return map;
    }

    private Map<String, String> getClickParameters(String str) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap map = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            map.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            map.putAll(oaidParameters);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(map, "android_uuid", this.activityStateCopy.uuid);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "gps_adid", this.deviceInfo.playAdId);
        addString(map, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addLong(map, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        if (!containsPlayIds(map)) {
            logger.warn("Google Advertising ID not detected, fallback to non Google Play identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(map, "mac_sha1", this.deviceInfo.macSha1);
            addString(map, "mac_md5", this.deviceInfo.macShortMd5);
            addString(map, "android_id", this.deviceInfo.androidId);
        }
        AdjustAttribution adjustAttribution = this.attribution;
        if (adjustAttribution != null) {
            addString(map, "tracker", adjustAttribution.trackerName);
            addString(map, "campaign", this.attribution.campaign);
            addString(map, "adgroup", this.attribution.adgroup);
            addString(map, "creative", this.attribution.creative);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_secret", this.adjustConfig.appSecret);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addMapJson(map, Constants.CALLBACK_PARAMETERS, this.sessionParameters.callbackParameters);
        addDateInMilliseconds(map, "click_time", this.clickTimeInMilliseconds);
        addDateInSeconds(map, "click_time", this.clickTimeInSeconds);
        addLong(map, "connectivity_type", Util.getConnectivityType(this.adjustConfig.context));
        addString(map, "country", this.deviceInfo.country);
        addString(map, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addString(map, Constants.DEEPLINK, this.deeplink);
        addBoolean(map, "device_known", this.adjustConfig.deviceKnown);
        addString(map, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addString(map, "display_height", this.deviceInfo.displayHeight);
        addString(map, "display_width", this.deviceInfo.displayWidth);
        addString(map, "environment", this.adjustConfig.environment);
        addBoolean(map, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(map, "fb_id", this.deviceInfo.fbAttributionId);
        addString(map, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(map, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        addString(map, "hardware_name", this.deviceInfo.hardwareName);
        addDateInSeconds(map, "install_begin_time", this.installBeginTimeInSeconds);
        addString(map, "installed_at", this.deviceInfo.appInstallTime);
        addString(map, "language", this.deviceInfo.language);
        addDuration(map, "last_interval", this.activityStateCopy.lastInterval);
        addString(map, "mcc", Util.getMcc(this.adjustConfig.context));
        addString(map, "mnc", Util.getMnc(this.adjustConfig.context));
        addBoolean(map, "needs_response_details", bool);
        addLong(map, "network_type", Util.getNetworkType(this.adjustConfig.context));
        addString(map, "os_build", this.deviceInfo.buildName);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addMapJson(map, "params", this.extraParameters);
        addMapJson(map, Constants.PARTNER_PARAMETERS, this.sessionParameters.partnerParameters);
        addString(map, "push_token", this.activityStateCopy.pushToken);
        addString(map, "raw_referrer", this.rawReferrer);
        addString(map, Constants.REFERRER, this.referrer);
        addString(map, "referrer_api", this.referrerApi);
        addString(map, Constants.REFTAG, this.reftag);
        addString(map, "screen_density", this.deviceInfo.screenDensity);
        addString(map, "screen_format", this.deviceInfo.screenFormat);
        addString(map, "screen_size", this.deviceInfo.screenSize);
        addString(map, "secret_id", this.adjustConfig.secretId);
        addLong(map, "session_count", this.activityStateCopy.sessionCount);
        addDuration(map, "session_length", this.activityStateCopy.sessionLength);
        addString(map, "source", str);
        addLong(map, "subsession_count", this.activityStateCopy.subsessionCount);
        addDuration(map, "time_spent", this.activityStateCopy.timeSpent);
        addString(map, "updated_at", this.deviceInfo.appUpdateTime);
        checkDeviceIds(map);
        return map;
    }

    private ActivityPackage getDefaultActivityPackage(ActivityKind activityKind) {
        ActivityPackage activityPackage = new ActivityPackage(activityKind);
        activityPackage.setClientSdk(this.deviceInfo.clientSdk);
        return activityPackage;
    }

    private Map<String, String> getDisableThirdPartySharingParameters() {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap map = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            map.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            map.putAll(oaidParameters);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(map, "android_uuid", this.activityStateCopy.uuid);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "gps_adid", this.deviceInfo.playAdId);
        addString(map, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addLong(map, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        if (!containsPlayIds(map)) {
            logger.warn("Google Advertising ID not detected, fallback to non Google Play identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(map, "mac_sha1", this.deviceInfo.macSha1);
            addString(map, "mac_md5", this.deviceInfo.macShortMd5);
            addString(map, "android_id", this.deviceInfo.androidId);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_secret", this.adjustConfig.appSecret);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addBoolean(map, "device_known", this.adjustConfig.deviceKnown);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addString(map, "environment", this.adjustConfig.environment);
        addBoolean(map, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(map, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(map, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        addBoolean(map, "needs_response_details", bool);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.pushToken);
        addString(map, "secret_id", this.adjustConfig.secretId);
        checkDeviceIds(map);
        return map;
    }

    private String getEventSuffix(AdjustEvent adjustEvent) {
        Double d = adjustEvent.revenue;
        return d == null ? Util.formatString("'%s'", adjustEvent.eventToken) : Util.formatString("(%.5f %s, '%s')", d, adjustEvent.currency, adjustEvent.eventToken);
    }

    private Map<String, String> getGdprParameters() {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap map = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            map.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            map.putAll(oaidParameters);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(map, "android_uuid", this.activityStateCopy.uuid);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "gps_adid", this.deviceInfo.playAdId);
        addString(map, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addLong(map, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        if (!containsPlayIds(map)) {
            logger.warn("Google Advertising ID not detected, fallback to non Google Play identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(map, "mac_sha1", this.deviceInfo.macSha1);
            addString(map, "mac_md5", this.deviceInfo.macShortMd5);
            addString(map, "android_id", this.deviceInfo.androidId);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_secret", this.adjustConfig.appSecret);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addBoolean(map, "device_known", this.adjustConfig.deviceKnown);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addString(map, "environment", this.adjustConfig.environment);
        addBoolean(map, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(map, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(map, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        addBoolean(map, "needs_response_details", bool);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.pushToken);
        addString(map, "secret_id", this.adjustConfig.secretId);
        checkDeviceIds(map);
        return map;
    }

    private Map<String, String> getInfoParameters(String str) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap map = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            map.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            map.putAll(oaidParameters);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(map, "android_uuid", this.activityStateCopy.uuid);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "gps_adid", this.deviceInfo.playAdId);
        addString(map, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addLong(map, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        if (!containsPlayIds(map)) {
            logger.warn("Google Advertising ID not detected, fallback to non Google Play identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(map, "mac_sha1", this.deviceInfo.macSha1);
            addString(map, "mac_md5", this.deviceInfo.macShortMd5);
            addString(map, "android_id", this.deviceInfo.androidId);
        }
        addString(map, "app_secret", this.adjustConfig.appSecret);
        addString(map, "app_token", this.adjustConfig.appToken);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addBoolean(map, "device_known", this.adjustConfig.deviceKnown);
        addString(map, "environment", this.adjustConfig.environment);
        addBoolean(map, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(map, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(map, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        addBoolean(map, "needs_response_details", bool);
        addString(map, "push_token", this.activityStateCopy.pushToken);
        addString(map, "secret_id", this.adjustConfig.secretId);
        addString(map, "source", str);
        checkDeviceIds(map);
        return map;
    }

    private Map<String, String> getSessionParameters(boolean z2) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap map = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            map.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            map.putAll(oaidParameters);
        }
        if (!z2) {
            addMapJson(map, Constants.CALLBACK_PARAMETERS, this.sessionParameters.callbackParameters);
            addMapJson(map, Constants.PARTNER_PARAMETERS, this.sessionParameters.partnerParameters);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(map, "android_uuid", this.activityStateCopy.uuid);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "gps_adid", this.deviceInfo.playAdId);
        addString(map, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addLong(map, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        if (!containsPlayIds(map)) {
            logger.warn("Google Advertising ID not detected, fallback to non Google Play identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(map, "mac_sha1", this.deviceInfo.macSha1);
            addString(map, "mac_md5", this.deviceInfo.macShortMd5);
            addString(map, "android_id", this.deviceInfo.androidId);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_secret", this.adjustConfig.appSecret);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addLong(map, "connectivity_type", Util.getConnectivityType(this.adjustConfig.context));
        addString(map, "country", this.deviceInfo.country);
        addString(map, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addString(map, "default_tracker", this.adjustConfig.defaultTracker);
        addBoolean(map, "device_known", this.adjustConfig.deviceKnown);
        addString(map, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addString(map, "display_height", this.deviceInfo.displayHeight);
        addString(map, "display_width", this.deviceInfo.displayWidth);
        addString(map, "environment", this.adjustConfig.environment);
        addBoolean(map, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(map, "fb_id", this.deviceInfo.fbAttributionId);
        addString(map, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(map, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        addString(map, "hardware_name", this.deviceInfo.hardwareName);
        addString(map, "installed_at", this.deviceInfo.appInstallTime);
        addString(map, "language", this.deviceInfo.language);
        addDuration(map, "last_interval", this.activityStateCopy.lastInterval);
        addString(map, "mcc", Util.getMcc(this.adjustConfig.context));
        addString(map, "mnc", Util.getMnc(this.adjustConfig.context));
        addBoolean(map, "needs_response_details", bool);
        addLong(map, "network_type", Util.getNetworkType(this.adjustConfig.context));
        addString(map, "os_build", this.deviceInfo.buildName);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.pushToken);
        addString(map, "screen_density", this.deviceInfo.screenDensity);
        addString(map, "screen_format", this.deviceInfo.screenFormat);
        addString(map, "screen_size", this.deviceInfo.screenSize);
        addString(map, "secret_id", this.adjustConfig.secretId);
        addLong(map, "session_count", this.activityStateCopy.sessionCount);
        addDuration(map, "session_length", this.activityStateCopy.sessionLength);
        addLong(map, "subsession_count", this.activityStateCopy.subsessionCount);
        addDuration(map, "time_spent", this.activityStateCopy.timeSpent);
        addString(map, "updated_at", this.deviceInfo.appUpdateTime);
        checkDeviceIds(map);
        return map;
    }

    private Map<String, String> getSubscriptionParameters(AdjustPlayStoreSubscription adjustPlayStoreSubscription, boolean z2) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap map = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            map.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            map.putAll(oaidParameters);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(map, "android_uuid", this.activityStateCopy.uuid);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "gps_adid", this.deviceInfo.playAdId);
        addString(map, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addLong(map, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        if (!containsPlayIds(map)) {
            logger.warn("Google Advertising ID not detected, fallback to non Google Play identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(map, "mac_sha1", this.deviceInfo.macSha1);
            addString(map, "mac_md5", this.deviceInfo.macShortMd5);
            addString(map, "android_id", this.deviceInfo.androidId);
        }
        if (!z2) {
            addMapJson(map, Constants.CALLBACK_PARAMETERS, Util.mergeParameters(this.sessionParameters.callbackParameters, adjustPlayStoreSubscription.getCallbackParameters(), "Callback"));
            addMapJson(map, Constants.PARTNER_PARAMETERS, Util.mergeParameters(this.sessionParameters.partnerParameters, adjustPlayStoreSubscription.getPartnerParameters(), "Partner"));
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_secret", this.adjustConfig.appSecret);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addLong(map, "connectivity_type", Util.getConnectivityType(this.adjustConfig.context));
        addString(map, "country", this.deviceInfo.country);
        addString(map, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addString(map, "default_tracker", this.adjustConfig.defaultTracker);
        addBoolean(map, "device_known", this.adjustConfig.deviceKnown);
        addString(map, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addString(map, "display_height", this.deviceInfo.displayHeight);
        addString(map, "display_width", this.deviceInfo.displayWidth);
        addString(map, "environment", this.adjustConfig.environment);
        addBoolean(map, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(map, "fb_id", this.deviceInfo.fbAttributionId);
        addString(map, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(map, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        addString(map, "hardware_name", this.deviceInfo.hardwareName);
        addString(map, "installed_at", this.deviceInfo.appInstallTime);
        addString(map, "language", this.deviceInfo.language);
        addDuration(map, "last_interval", this.activityStateCopy.lastInterval);
        addString(map, "mcc", Util.getMcc(this.adjustConfig.context));
        addString(map, "mnc", Util.getMnc(this.adjustConfig.context));
        addBoolean(map, "needs_response_details", bool);
        addLong(map, "network_type", Util.getNetworkType(this.adjustConfig.context));
        addString(map, "os_build", this.deviceInfo.buildName);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.pushToken);
        addString(map, "screen_density", this.deviceInfo.screenDensity);
        addString(map, "screen_format", this.deviceInfo.screenFormat);
        addString(map, "screen_size", this.deviceInfo.screenSize);
        addString(map, "secret_id", this.adjustConfig.secretId);
        addLong(map, "session_count", this.activityStateCopy.sessionCount);
        addDuration(map, "session_length", this.activityStateCopy.sessionLength);
        addLong(map, "subsession_count", this.activityStateCopy.subsessionCount);
        addDuration(map, "time_spent", this.activityStateCopy.timeSpent);
        addString(map, "updated_at", this.deviceInfo.appUpdateTime);
        addLong(map, "revenue", adjustPlayStoreSubscription.getPrice());
        addDateInMilliseconds(map, "transaction_date", adjustPlayStoreSubscription.getPurchaseTime());
        addString(map, "currency", adjustPlayStoreSubscription.getCurrency());
        addString(map, "product_id", adjustPlayStoreSubscription.getSku());
        addString(map, "receipt", adjustPlayStoreSubscription.getSignature());
        addString(map, "purchase_token", adjustPlayStoreSubscription.getPurchaseToken());
        addString(map, "billing_store", adjustPlayStoreSubscription.getBillingStore());
        addString(map, "transaction_id", adjustPlayStoreSubscription.getOrderId());
        checkDeviceIds(map);
        return map;
    }

    public ActivityPackage buildAdRevenuePackage(String str, JSONObject jSONObject) {
        Map<String, String> adRevenueParameters = getAdRevenueParameters(str, jSONObject);
        ActivityKind activityKind = ActivityKind.AD_REVENUE;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/ad_revenue");
        defaultActivityPackage.setSuffix("");
        String string = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig = this.adjustConfig;
        AdjustSigner.sign(adRevenueParameters, string, clientSdk, adjustConfig.context, adjustConfig.logger);
        defaultActivityPackage.setParameters(adRevenueParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildAttributionPackage(String str) {
        Map<String, String> attributionParameters = getAttributionParameters(str);
        ActivityKind activityKind = ActivityKind.ATTRIBUTION;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("attribution");
        defaultActivityPackage.setSuffix("");
        String string = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig = this.adjustConfig;
        AdjustSigner.sign(attributionParameters, string, clientSdk, adjustConfig.context, adjustConfig.logger);
        defaultActivityPackage.setParameters(attributionParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildClickPackage(String str) {
        Map<String, String> clickParameters = getClickParameters(str);
        ActivityKind activityKind = ActivityKind.CLICK;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/sdk_click");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setClickTimeInMilliseconds(this.clickTimeInMilliseconds);
        defaultActivityPackage.setClickTimeInSeconds(this.clickTimeInSeconds);
        defaultActivityPackage.setInstallBeginTimeInSeconds(this.installBeginTimeInSeconds);
        String string = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig = this.adjustConfig;
        AdjustSigner.sign(clickParameters, string, clientSdk, adjustConfig.context, adjustConfig.logger);
        defaultActivityPackage.setParameters(clickParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildDisableThirdPartySharingPackage() {
        Map<String, String> disableThirdPartySharingParameters = getDisableThirdPartySharingParameters();
        ActivityKind activityKind = ActivityKind.DISABLE_THIRD_PARTY_SHARING;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/disable_third_party_sharing");
        defaultActivityPackage.setSuffix("");
        String string = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig = this.adjustConfig;
        AdjustSigner.sign(disableThirdPartySharingParameters, string, clientSdk, adjustConfig.context, adjustConfig.logger);
        defaultActivityPackage.setParameters(disableThirdPartySharingParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildEventPackage(AdjustEvent adjustEvent, boolean z2) {
        Map<String, String> eventParameters = getEventParameters(adjustEvent, z2);
        ActivityKind activityKind = ActivityKind.EVENT;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/event");
        defaultActivityPackage.setSuffix(getEventSuffix(adjustEvent));
        String string = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig = this.adjustConfig;
        AdjustSigner.sign(eventParameters, string, clientSdk, adjustConfig.context, adjustConfig.logger);
        defaultActivityPackage.setParameters(eventParameters);
        if (z2) {
            defaultActivityPackage.setCallbackParameters(adjustEvent.callbackParameters);
            defaultActivityPackage.setPartnerParameters(adjustEvent.partnerParameters);
        }
        return defaultActivityPackage;
    }

    public ActivityPackage buildGdprPackage() {
        Map<String, String> gdprParameters = getGdprParameters();
        ActivityKind activityKind = ActivityKind.GDPR;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/gdpr_forget_device");
        defaultActivityPackage.setSuffix("");
        String string = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig = this.adjustConfig;
        AdjustSigner.sign(gdprParameters, string, clientSdk, adjustConfig.context, adjustConfig.logger);
        defaultActivityPackage.setParameters(gdprParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildInfoPackage(String str) {
        Map<String, String> infoParameters = getInfoParameters(str);
        ActivityKind activityKind = ActivityKind.INFO;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/sdk_info");
        defaultActivityPackage.setSuffix("");
        String string = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig = this.adjustConfig;
        AdjustSigner.sign(infoParameters, string, clientSdk, adjustConfig.context, adjustConfig.logger);
        defaultActivityPackage.setParameters(infoParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildSessionPackage(boolean z2) {
        Map<String, String> sessionParameters = getSessionParameters(z2);
        ActivityKind activityKind = ActivityKind.SESSION;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/session");
        defaultActivityPackage.setSuffix("");
        String string = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig = this.adjustConfig;
        AdjustSigner.sign(sessionParameters, string, clientSdk, adjustConfig.context, adjustConfig.logger);
        defaultActivityPackage.setParameters(sessionParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildSubscriptionPackage(AdjustPlayStoreSubscription adjustPlayStoreSubscription, boolean z2) {
        Map<String, String> subscriptionParameters = getSubscriptionParameters(adjustPlayStoreSubscription, z2);
        ActivityKind activityKind = ActivityKind.SUBSCRIPTION;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/v2/purchase");
        defaultActivityPackage.setSuffix("");
        String string = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig = this.adjustConfig;
        AdjustSigner.sign(subscriptionParameters, string, clientSdk, adjustConfig.context, adjustConfig.logger);
        defaultActivityPackage.setParameters(subscriptionParameters);
        return defaultActivityPackage;
    }

    public Map<String, String> getEventParameters(AdjustEvent adjustEvent, boolean z2) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap map = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            map.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            map.putAll(oaidParameters);
        }
        if (!z2) {
            addMapJson(map, Constants.CALLBACK_PARAMETERS, Util.mergeParameters(this.sessionParameters.callbackParameters, adjustEvent.callbackParameters, "Callback"));
            addMapJson(map, Constants.PARTNER_PARAMETERS, Util.mergeParameters(this.sessionParameters.partnerParameters, adjustEvent.partnerParameters, "Partner"));
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(map, "android_uuid", this.activityStateCopy.uuid);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "gps_adid", this.deviceInfo.playAdId);
        addString(map, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addLong(map, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        if (!containsPlayIds(map)) {
            logger.warn("Google Advertising ID not detected, fallback to non Google Play identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(map, "mac_sha1", this.deviceInfo.macSha1);
            addString(map, "mac_md5", this.deviceInfo.macShortMd5);
            addString(map, "android_id", this.deviceInfo.androidId);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_secret", this.adjustConfig.appSecret);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addLong(map, "connectivity_type", Util.getConnectivityType(this.adjustConfig.context));
        addString(map, "country", this.deviceInfo.country);
        addString(map, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addString(map, "currency", adjustEvent.currency);
        addBoolean(map, "device_known", this.adjustConfig.deviceKnown);
        addString(map, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addString(map, "display_height", this.deviceInfo.displayHeight);
        addString(map, "display_width", this.deviceInfo.displayWidth);
        addString(map, "environment", this.adjustConfig.environment);
        addString(map, "event_callback_id", adjustEvent.callbackId);
        addLong(map, "event_count", this.activityStateCopy.eventCount);
        addBoolean(map, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(map, "event_token", adjustEvent.eventToken);
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(map, "fb_id", this.deviceInfo.fbAttributionId);
        addString(map, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(map, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        addString(map, "hardware_name", this.deviceInfo.hardwareName);
        addString(map, "language", this.deviceInfo.language);
        addString(map, "mcc", Util.getMcc(this.adjustConfig.context));
        addString(map, "mnc", Util.getMnc(this.adjustConfig.context));
        addBoolean(map, "needs_response_details", bool);
        addLong(map, "network_type", Util.getNetworkType(this.adjustConfig.context));
        addString(map, "os_build", this.deviceInfo.buildName);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.pushToken);
        addDouble(map, "revenue", adjustEvent.revenue);
        addString(map, "screen_density", this.deviceInfo.screenDensity);
        addString(map, "screen_format", this.deviceInfo.screenFormat);
        addString(map, "screen_size", this.deviceInfo.screenSize);
        addString(map, "secret_id", this.adjustConfig.secretId);
        addLong(map, "session_count", this.activityStateCopy.sessionCount);
        addDuration(map, "session_length", this.activityStateCopy.sessionLength);
        addLong(map, "subsession_count", this.activityStateCopy.subsessionCount);
        addDuration(map, "time_spent", this.activityStateCopy.timeSpent);
        checkDeviceIds(map);
        return map;
    }
}
