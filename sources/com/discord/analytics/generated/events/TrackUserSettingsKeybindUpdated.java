package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackUserSettingsKeybindUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUserSettingsKeybindUpdated implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence keybindAction = null;
    private final Boolean keybindIsBound = null;
    private final Boolean keybindHasShortcut = null;
    private final transient String analyticsSchemaTypeName = "user_settings_keybind_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUserSettingsKeybindUpdated)) {
            return false;
        }
        TrackUserSettingsKeybindUpdated trackUserSettingsKeybindUpdated = (TrackUserSettingsKeybindUpdated) other;
        return m.areEqual(this.keybindAction, trackUserSettingsKeybindUpdated.keybindAction) && m.areEqual(this.keybindIsBound, trackUserSettingsKeybindUpdated.keybindIsBound) && m.areEqual(this.keybindHasShortcut, trackUserSettingsKeybindUpdated.keybindHasShortcut);
    }

    public int hashCode() {
        CharSequence charSequence = this.keybindAction;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.keybindIsBound;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.keybindHasShortcut;
        return iHashCode2 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackUserSettingsKeybindUpdated(keybindAction=");
        sbU.append(this.keybindAction);
        sbU.append(", keybindIsBound=");
        sbU.append(this.keybindIsBound);
        sbU.append(", keybindHasShortcut=");
        return a.D(sbU, this.keybindHasShortcut, ")");
    }
}
