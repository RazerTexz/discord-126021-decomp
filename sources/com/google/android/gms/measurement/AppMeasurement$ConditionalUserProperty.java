package com.google.android.gms.measurement;

import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import b.i.a.f.e.o.f;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class AppMeasurement$ConditionalUserProperty {

    @Keep
    public boolean mActive;

    @Keep
    public String mAppId;

    @Keep
    public long mCreationTimestamp;

    @Keep
    public String mExpiredEventName;

    @Keep
    public Bundle mExpiredEventParams;

    @Keep
    public String mName;

    @Keep
    public String mOrigin;

    @Keep
    public long mTimeToLive;

    @Keep
    public String mTimedOutEventName;

    @Keep
    public Bundle mTimedOutEventParams;

    @Keep
    public String mTriggerEventName;

    @Keep
    public long mTriggerTimeout;

    @Keep
    public String mTriggeredEventName;

    @Keep
    public Bundle mTriggeredEventParams;

    @Keep
    public long mTriggeredTimestamp;

    @Keep
    public Object mValue;

    public AppMeasurement$ConditionalUserProperty() {
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        String str = this.mAppId;
        if (str != null) {
            bundle.putString("app_id", str);
        }
        String str2 = this.mOrigin;
        if (str2 != null) {
            bundle.putString("origin", str2);
        }
        String str3 = this.mName;
        if (str3 != null) {
            bundle.putString(ModelAuditLogEntry.CHANGE_KEY_NAME, str3);
        }
        Object obj = this.mValue;
        if (obj != null) {
            f.d2(bundle, obj);
        }
        String str4 = this.mTriggerEventName;
        if (str4 != null) {
            bundle.putString("trigger_event_name", str4);
        }
        bundle.putLong("trigger_timeout", this.mTriggerTimeout);
        String str5 = this.mTimedOutEventName;
        if (str5 != null) {
            bundle.putString("timed_out_event_name", str5);
        }
        Bundle bundle2 = this.mTimedOutEventParams;
        if (bundle2 != null) {
            bundle.putBundle("timed_out_event_params", bundle2);
        }
        String str6 = this.mTriggeredEventName;
        if (str6 != null) {
            bundle.putString("triggered_event_name", str6);
        }
        Bundle bundle3 = this.mTriggeredEventParams;
        if (bundle3 != null) {
            bundle.putBundle("triggered_event_params", bundle3);
        }
        bundle.putLong("time_to_live", this.mTimeToLive);
        String str7 = this.mExpiredEventName;
        if (str7 != null) {
            bundle.putString("expired_event_name", str7);
        }
        Bundle bundle4 = this.mExpiredEventParams;
        if (bundle4 != null) {
            bundle.putBundle("expired_event_params", bundle4);
        }
        bundle.putLong("creation_timestamp", this.mCreationTimestamp);
        bundle.putBoolean("active", this.mActive);
        bundle.putLong("triggered_timestamp", this.mTriggeredTimestamp);
        return bundle;
    }

    public AppMeasurement$ConditionalUserProperty(@NonNull Bundle bundle) {
        Objects.requireNonNull(bundle, "null reference");
        this.mAppId = (String) f.S1(bundle, "app_id", String.class, null);
        this.mOrigin = (String) f.S1(bundle, "origin", String.class, null);
        this.mName = (String) f.S1(bundle, ModelAuditLogEntry.CHANGE_KEY_NAME, String.class, null);
        this.mValue = f.S1(bundle, "value", Object.class, null);
        this.mTriggerEventName = (String) f.S1(bundle, "trigger_event_name", String.class, null);
        this.mTriggerTimeout = ((Long) f.S1(bundle, "trigger_timeout", Long.class, 0L)).longValue();
        this.mTimedOutEventName = (String) f.S1(bundle, "timed_out_event_name", String.class, null);
        this.mTimedOutEventParams = (Bundle) f.S1(bundle, "timed_out_event_params", Bundle.class, null);
        this.mTriggeredEventName = (String) f.S1(bundle, "triggered_event_name", String.class, null);
        this.mTriggeredEventParams = (Bundle) f.S1(bundle, "triggered_event_params", Bundle.class, null);
        this.mTimeToLive = ((Long) f.S1(bundle, "time_to_live", Long.class, 0L)).longValue();
        this.mExpiredEventName = (String) f.S1(bundle, "expired_event_name", String.class, null);
        this.mExpiredEventParams = (Bundle) f.S1(bundle, "expired_event_params", Bundle.class, null);
        this.mActive = ((Boolean) f.S1(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
        this.mCreationTimestamp = ((Long) f.S1(bundle, "creation_timestamp", Long.class, 0L)).longValue();
        this.mTriggeredTimestamp = ((Long) f.S1(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
    }
}
