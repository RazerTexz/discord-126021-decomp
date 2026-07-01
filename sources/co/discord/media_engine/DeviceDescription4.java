package co.discord.media_engine;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: co.discord.media_engine.VideoInputDeviceDescription, reason: use source file name */
/* JADX INFO: compiled from: DeviceDescription.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class DeviceDescription4 {
    private final DeviceDescription5 facing;
    private final String guid;
    private final String name;

    public DeviceDescription4(String str, String str2, DeviceDescription5 deviceDescription5) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "guid");
        Intrinsics3.checkNotNullParameter(deviceDescription5, "facing");
        this.name = str;
        this.guid = str2;
        this.facing = deviceDescription5;
    }

    public static /* synthetic */ DeviceDescription4 copy$default(DeviceDescription4 deviceDescription4, String str, String str2, DeviceDescription5 deviceDescription5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceDescription4.name;
        }
        if ((i & 2) != 0) {
            str2 = deviceDescription4.guid;
        }
        if ((i & 4) != 0) {
            deviceDescription5 = deviceDescription4.facing;
        }
        return deviceDescription4.copy(str, str2, deviceDescription5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGuid() {
        return this.guid;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final DeviceDescription5 getFacing() {
        return this.facing;
    }

    public final DeviceDescription4 copy(String name, String guid, DeviceDescription5 facing) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(guid, "guid");
        Intrinsics3.checkNotNullParameter(facing, "facing");
        return new DeviceDescription4(name, guid, facing);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceDescription4)) {
            return false;
        }
        DeviceDescription4 deviceDescription4 = (DeviceDescription4) other;
        return Intrinsics3.areEqual(this.name, deviceDescription4.name) && Intrinsics3.areEqual(this.guid, deviceDescription4.guid) && Intrinsics3.areEqual(this.facing, deviceDescription4.facing);
    }

    public final DeviceDescription5 getFacing() {
        return this.facing;
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
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        DeviceDescription5 deviceDescription5 = this.facing;
        return iHashCode2 + (deviceDescription5 != null ? deviceDescription5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("VideoInputDeviceDescription(name=");
        sbU.append(this.name);
        sbU.append(", guid=");
        sbU.append(this.guid);
        sbU.append(", facing=");
        sbU.append(this.facing);
        sbU.append(")");
        return sbU.toString();
    }
}
