package com.discord.p000native.engine;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: AudioInputDeviceDescription.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class AudioInputDeviceDescription {
    private final String guid;
    private final String name;

    public AudioInputDeviceDescription(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "guid");
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
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(guid, "guid");
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
        return Intrinsics3.areEqual(this.name, audioInputDeviceDescription.name) && Intrinsics3.areEqual(this.guid, audioInputDeviceDescription.guid);
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
        StringBuilder sbU = outline.U("AudioInputDeviceDescription(name=");
        sbU.append(this.name);
        sbU.append(", guid=");
        return outline.J(sbU, this.guid, ")");
    }
}
