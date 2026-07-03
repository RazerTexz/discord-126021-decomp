package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.keybindAction, trackUserSettingsKeybindUpdated.keybindAction) && C12238m.areEqual(this.keybindIsBound, trackUserSettingsKeybindUpdated.keybindIsBound) && C12238m.areEqual(this.keybindHasShortcut, trackUserSettingsKeybindUpdated.keybindHasShortcut);
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
        StringBuilder sbM833U = C1643a.m833U("TrackUserSettingsKeybindUpdated(keybindAction=");
        sbM833U.append(this.keybindAction);
        sbM833U.append(", keybindIsBound=");
        sbM833U.append(this.keybindIsBound);
        sbM833U.append(", keybindHasShortcut=");
        return C1643a.m816D(sbM833U, this.keybindHasShortcut, ")");
    }
}
