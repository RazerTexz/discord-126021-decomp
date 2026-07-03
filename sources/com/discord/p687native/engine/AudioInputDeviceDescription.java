package com.discord.p687native.engine;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AudioInputDeviceDescription.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class AudioInputDeviceDescription {
    private final String guid;
    private final String name;

    public AudioInputDeviceDescription(String str, String str2) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(str2, "guid");
        this.name = str;
        this.guid = str2;
    }

    public static /* synthetic */ AudioInputDeviceDescription copy$default(AudioInputDeviceDescription audioInputDeviceDescription, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = audioInputDeviceDescription.name;
        }
        if ((i & 2) != 0) {
            str2 = audioInputDeviceDescription.guid;
        }
        return audioInputDeviceDescription.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGuid() {
        return this.guid;
    }

    public final AudioInputDeviceDescription copy(String name, String guid) {
        C12238m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(guid, "guid");
        return new AudioInputDeviceDescription(name, guid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AudioInputDeviceDescription)) {
            return false;
        }
        AudioInputDeviceDescription audioInputDeviceDescription = (AudioInputDeviceDescription) other;
        return C12238m.areEqual(this.name, audioInputDeviceDescription.name) && C12238m.areEqual(this.guid, audioInputDeviceDescription.guid);
    }

    public final String getGuid() {
        return this.guid;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.guid;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("AudioInputDeviceDescription(name=");
        sbM833U.append(this.name);
        sbM833U.append(", guid=");
        return C1643a.m822J(sbM833U, this.guid, ")");
    }
}
