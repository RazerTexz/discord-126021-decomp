package com.adjust.sdk;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AdjustConfig {
    public static final String AD_REVENUE_ADDAPTR = "addapptr";
    public static final String AD_REVENUE_ADINCUBE = "adincube";
    public static final String AD_REVENUE_ADMOB = "admob";
    public static final String AD_REVENUE_ADMOST = "admost";
    public static final String AD_REVENUE_ADTOAPP = "adtoapp";
    public static final String AD_REVENUE_AERSERV = "aerserv";
    public static final String AD_REVENUE_APPODEAL = "appodeal";
    public static final String AD_REVENUE_DELTADNA = "deltadna";
    public static final String AD_REVENUE_FB_NATIVE_AD = "facebook_native_ad";
    public static final String AD_REVENUE_FLURRY = "flurry";
    public static final String AD_REVENUE_FUSE_POWERED = "fusepowered";
    public static final String AD_REVENUE_FYBER = "fyber";
    public static final String AD_REVENUE_IRONSOURCE = "ironsource";
    public static final String AD_REVENUE_MILLENNIAL_MEDITATION = "millennial_mediation";
    public static final String AD_REVENUE_MOPUB = "mopub";
    public static final String AD_REVENUE_TAPDAQ = "tapdaq";
    public static final String AD_REVENUE_UNITYADS = "unityads";
    public static final String AD_REVENUE_UPSIGHT = "upsight";
    public static final String ENVIRONMENT_PRODUCTION = "production";
    public static final String ENVIRONMENT_SANDBOX = "sandbox";
    public String appSecret;
    public String appToken;
    public String basePath;
    public Context context;
    public Class deepLinkComponent;
    public String defaultTracker;
    public Double delayStart;
    public Boolean deviceKnown;
    public String environment;
    public boolean eventBufferingEnabled;
    public String externalDeviceId;
    public String gdprPath;
    public ILogger logger;
    public OnAttributionChangedListener onAttributionChangedListener;
    public OnDeeplinkResponseListener onDeeplinkResponseListener;
    public OnEventTrackingFailedListener onEventTrackingFailedListener;
    public OnEventTrackingSucceededListener onEventTrackingSucceededListener;
    public OnSessionTrackingFailedListener onSessionTrackingFailedListener;
    public OnSessionTrackingSucceededListener onSessionTrackingSucceededListener;
    public List<IRunActivityHandler> preLaunchActionsArray;
    public String processName;
    public String pushToken;
    public String sdkPrefix;
    public String secretId;
    public boolean sendInBackground;
    public Boolean startEnabled;
    public boolean startOffline;
    public String subscriptionPath;
    public String userAgent;

    public AdjustConfig(Context context, String str, String str2) {
        init(context, str, str2, false);
    }

    private boolean checkAppToken(String str) {
        if (str == null) {
            this.logger.error("Missing App Token", new Object[0]);
            return false;
        }
        if (str.length() == 12) {
            return true;
        }
        this.logger.error("Malformed App Token '%s'", str);
        return false;
    }

    private boolean checkContext(Context context) {
        if (context == null) {
            this.logger.error("Missing context", new Object[0]);
            return false;
        }
        if (Util.checkPermission(context, "android.permission.INTERNET")) {
            return true;
        }
        this.logger.error("Missing permission: INTERNET", new Object[0]);
        return false;
    }

    private boolean checkEnvironment(String str) {
        if (str == null) {
            this.logger.error("Missing environment", new Object[0]);
            return false;
        }
        if (str.equals(ENVIRONMENT_SANDBOX)) {
            this.logger.warnInProduction("SANDBOX: Adjust is running in Sandbox mode. Use this setting for testing. Don't forget to set the environment to `production` before publishing!", new Object[0]);
            return true;
        }
        if (str.equals("production")) {
            this.logger.warnInProduction("PRODUCTION: Adjust is running in Production mode. Use this setting only for the build that you want to publish. Set the environment to `sandbox` if you want to test your app!", new Object[0]);
            return true;
        }
        this.logger.error("Unknown environment '%s'", str);
        return false;
    }

    private void init(Context context, String str, String str2, boolean z2) {
        this.logger = AdjustFactory.getLogger();
        if (z2 && "production".equals(str2)) {
            setLogLevel(LogLevel.SUPRESS, str2);
        } else {
            setLogLevel(LogLevel.INFO, str2);
        }
        if (context != null) {
            context = context.getApplicationContext();
        }
        this.context = context;
        this.appToken = str;
        this.environment = str2;
        this.eventBufferingEnabled = false;
        this.sendInBackground = false;
    }

    public boolean isValid() {
        return checkAppToken(this.appToken) && checkEnvironment(this.environment) && checkContext(this.context);
    }

    public void setAppSecret(long j, long j2, long j3, long j4, long j5) {
        this.secretId = Util.formatString("%d", Long.valueOf(j));
        this.appSecret = Util.formatString("%d%d%d%d", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5));
    }

    public void setDeepLinkComponent(Class cls) {
        this.deepLinkComponent = cls;
    }

    public void setDefaultTracker(String str) {
        this.defaultTracker = str;
    }

    public void setDelayStart(double d) {
        this.delayStart = Double.valueOf(d);
    }

    public void setDeviceKnown(boolean z2) {
        this.deviceKnown = Boolean.valueOf(z2);
    }

    public void setEventBufferingEnabled(Boolean bool) {
        if (bool == null) {
            this.eventBufferingEnabled = false;
        } else {
            this.eventBufferingEnabled = bool.booleanValue();
        }
    }

    public void setExternalDeviceId(String str) {
        this.externalDeviceId = str;
    }

    public void setLogLevel(LogLevel logLevel) {
        setLogLevel(logLevel, this.environment);
    }

    public void setOnAttributionChangedListener(OnAttributionChangedListener onAttributionChangedListener) {
        this.onAttributionChangedListener = onAttributionChangedListener;
    }

    public void setOnDeeplinkResponseListener(OnDeeplinkResponseListener onDeeplinkResponseListener) {
        this.onDeeplinkResponseListener = onDeeplinkResponseListener;
    }

    public void setOnEventTrackingFailedListener(OnEventTrackingFailedListener onEventTrackingFailedListener) {
        this.onEventTrackingFailedListener = onEventTrackingFailedListener;
    }

    public void setOnEventTrackingSucceededListener(OnEventTrackingSucceededListener onEventTrackingSucceededListener) {
        this.onEventTrackingSucceededListener = onEventTrackingSucceededListener;
    }

    public void setOnSessionTrackingFailedListener(OnSessionTrackingFailedListener onSessionTrackingFailedListener) {
        this.onSessionTrackingFailedListener = onSessionTrackingFailedListener;
    }

    public void setOnSessionTrackingSucceededListener(OnSessionTrackingSucceededListener onSessionTrackingSucceededListener) {
        this.onSessionTrackingSucceededListener = onSessionTrackingSucceededListener;
    }

    public void setProcessName(String str) {
        this.processName = str;
    }

    @Deprecated
    public void setReadMobileEquipmentIdentity(boolean z2) {
        this.logger.warn("This method has been deprecated and shouldn't be used anymore", new Object[0]);
    }

    public void setSdkPrefix(String str) {
        this.sdkPrefix = str;
    }

    public void setSendInBackground(boolean z2) {
        this.sendInBackground = z2;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }

    private void setLogLevel(LogLevel logLevel, String str) {
        this.logger.setLogLevel(logLevel, "production".equals(str));
    }

    public AdjustConfig(Context context, String str, String str2, boolean z2) {
        init(context, str, str2, z2);
    }
}
