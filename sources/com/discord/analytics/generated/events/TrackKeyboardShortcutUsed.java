package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackKeyboardShortcutUsed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackKeyboardShortcutUsed implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence shortcutName = null;
    private final List<CharSequence> sourceClassList = null;
    private final transient String analyticsSchemaTypeName = "keyboard_shortcut_used";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackKeyboardShortcutUsed)) {
            return false;
        }
        TrackKeyboardShortcutUsed trackKeyboardShortcutUsed = (TrackKeyboardShortcutUsed) other;
        return C12238m.areEqual(this.shortcutName, trackKeyboardShortcutUsed.shortcutName) && C12238m.areEqual(this.sourceClassList, trackKeyboardShortcutUsed.sourceClassList);
    }

    public int hashCode() {
        CharSequence charSequence = this.shortcutName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        List<CharSequence> list = this.sourceClassList;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackKeyboardShortcutUsed(shortcutName=");
        sbM833U.append(this.shortcutName);
        sbM833U.append(", sourceClassList=");
        return C1643a.m824L(sbM833U, this.sourceClassList, ")");
    }
}
