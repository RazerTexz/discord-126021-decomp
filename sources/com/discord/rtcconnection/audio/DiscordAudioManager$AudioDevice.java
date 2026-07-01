package com.discord.rtcconnection.audio;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: DiscordAudioManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class DiscordAudioManager$AudioDevice {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final DiscordAudioManager$DeviceTypes type;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean isAvailable;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String id;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final String name;

    public DiscordAudioManager$AudioDevice() {
        this(null, false, null, null, 15);
    }

    public DiscordAudioManager$AudioDevice(DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes, boolean z2, String str, String str2) {
        m.checkNotNullParameter(discordAudioManager$DeviceTypes, "type");
        this.type = discordAudioManager$DeviceTypes;
        this.isAvailable = z2;
        this.id = str;
        this.name = str2;
    }

    public static DiscordAudioManager$AudioDevice a(DiscordAudioManager$AudioDevice discordAudioManager$AudioDevice, DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes, boolean z2, String str, String str2, int i) {
        DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes2 = (i & 1) != 0 ? discordAudioManager$AudioDevice.type : null;
        if ((i & 2) != 0) {
            z2 = discordAudioManager$AudioDevice.isAvailable;
        }
        if ((i & 4) != 0) {
            str = discordAudioManager$AudioDevice.id;
        }
        if ((i & 8) != 0) {
            str2 = discordAudioManager$AudioDevice.name;
        }
        Objects.requireNonNull(discordAudioManager$AudioDevice);
        m.checkNotNullParameter(discordAudioManager$DeviceTypes2, "type");
        return new DiscordAudioManager$AudioDevice(discordAudioManager$DeviceTypes2, z2, str, str2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiscordAudioManager$AudioDevice)) {
            return false;
        }
        DiscordAudioManager$AudioDevice discordAudioManager$AudioDevice = (DiscordAudioManager$AudioDevice) other;
        return m.areEqual(this.type, discordAudioManager$AudioDevice.type) && this.isAvailable == discordAudioManager$AudioDevice.isAvailable && m.areEqual(this.id, discordAudioManager$AudioDevice.id) && m.areEqual(this.name, discordAudioManager$AudioDevice.name);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public int hashCode() {
        DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes = this.type;
        int iHashCode = (discordAudioManager$DeviceTypes != null ? discordAudioManager$DeviceTypes.hashCode() : 0) * 31;
        boolean z2 = this.isAvailable;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        String str = this.id;
        int iHashCode2 = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("AudioDevice(type=");
        sbU.append(this.type);
        sbU.append(", isAvailable=");
        sbU.append(this.isAvailable);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", name=");
        return a.J(sbU, this.name, ")");
    }

    public DiscordAudioManager$AudioDevice(DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes, boolean z2, String str, String str2, int i) {
        discordAudioManager$DeviceTypes = (i & 1) != 0 ? DiscordAudioManager$DeviceTypes.INVALID : discordAudioManager$DeviceTypes;
        z2 = (i & 2) != 0 ? false : z2;
        int i2 = i & 4;
        int i3 = i & 8;
        m.checkNotNullParameter(discordAudioManager$DeviceTypes, "type");
        this.type = discordAudioManager$DeviceTypes;
        this.isAvailable = z2;
        this.id = null;
        this.name = null;
    }
}
