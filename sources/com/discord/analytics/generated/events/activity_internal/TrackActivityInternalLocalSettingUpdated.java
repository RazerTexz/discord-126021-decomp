package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadataReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackActivityInternalLocalSettingUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalLocalSettingUpdated implements AnalyticsSchema, TrackBaseReceiver, TrackActivityInternalMetadataReceiver {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final CharSequence settingName = null;
    private final CharSequence phase = null;
    private final CharSequence valueStr = null;
    private final CharSequence prevValueStr = null;
    private final Boolean valueBool = null;
    private final Boolean prevValueBool = null;
    private final Long valueInt = null;
    private final Long prevValueInt = null;
    private final Float valueFloat = null;
    private final Float prevValueFloat = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_local_setting_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalLocalSettingUpdated)) {
            return false;
        }
        TrackActivityInternalLocalSettingUpdated trackActivityInternalLocalSettingUpdated = (TrackActivityInternalLocalSettingUpdated) other;
        return m.areEqual(this.settingName, trackActivityInternalLocalSettingUpdated.settingName) && m.areEqual(this.phase, trackActivityInternalLocalSettingUpdated.phase) && m.areEqual(this.valueStr, trackActivityInternalLocalSettingUpdated.valueStr) && m.areEqual(this.prevValueStr, trackActivityInternalLocalSettingUpdated.prevValueStr) && m.areEqual(this.valueBool, trackActivityInternalLocalSettingUpdated.valueBool) && m.areEqual(this.prevValueBool, trackActivityInternalLocalSettingUpdated.prevValueBool) && m.areEqual(this.valueInt, trackActivityInternalLocalSettingUpdated.valueInt) && m.areEqual(this.prevValueInt, trackActivityInternalLocalSettingUpdated.prevValueInt) && m.areEqual(this.valueFloat, trackActivityInternalLocalSettingUpdated.valueFloat) && m.areEqual(this.prevValueFloat, trackActivityInternalLocalSettingUpdated.prevValueFloat);
    }

    public int hashCode() {
        CharSequence charSequence = this.settingName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.phase;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.valueStr;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.prevValueStr;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Boolean bool = this.valueBool;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.prevValueBool;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l = this.valueInt;
        int iHashCode7 = (iHashCode6 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.prevValueInt;
        int iHashCode8 = (iHashCode7 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Float f = this.valueFloat;
        int iHashCode9 = (iHashCode8 + (f != null ? f.hashCode() : 0)) * 31;
        Float f2 = this.prevValueFloat;
        return iHashCode9 + (f2 != null ? f2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackActivityInternalLocalSettingUpdated(settingName=");
        sbU.append(this.settingName);
        sbU.append(", phase=");
        sbU.append(this.phase);
        sbU.append(", valueStr=");
        sbU.append(this.valueStr);
        sbU.append(", prevValueStr=");
        sbU.append(this.prevValueStr);
        sbU.append(", valueBool=");
        sbU.append(this.valueBool);
        sbU.append(", prevValueBool=");
        sbU.append(this.prevValueBool);
        sbU.append(", valueInt=");
        sbU.append(this.valueInt);
        sbU.append(", prevValueInt=");
        sbU.append(this.prevValueInt);
        sbU.append(", valueFloat=");
        sbU.append(this.valueFloat);
        sbU.append(", prevValueFloat=");
        sbU.append(this.prevValueFloat);
        sbU.append(")");
        return sbU.toString();
    }
}
