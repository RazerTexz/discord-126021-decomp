package co.discord.media_engine;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: DeviceDescription.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class VideoInputDeviceDescription {
    private final VideoInputDeviceFacing facing;
    private final String guid;
    private final String name;

    public VideoInputDeviceDescription(String str, String str2, VideoInputDeviceFacing videoInputDeviceFacing) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(str2, "guid");
        C12238m.checkNotNullParameter(videoInputDeviceFacing, "facing");
        this.name = str;
        this.guid = str2;
        this.facing = videoInputDeviceFacing;
    }

    public static /* synthetic */ VideoInputDeviceDescription copy$default(VideoInputDeviceDescription videoInputDeviceDescription, String str, String str2, VideoInputDeviceFacing videoInputDeviceFacing, int i, Object obj) {
        if ((i & 1) != 0) {
            str = videoInputDeviceDescription.name;
        }
        if ((i & 2) != 0) {
            str2 = videoInputDeviceDescription.guid;
        }
        if ((i & 4) != 0) {
            videoInputDeviceFacing = videoInputDeviceDescription.facing;
        }
        return videoInputDeviceDescription.copy(str, str2, videoInputDeviceFacing);
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
    public final VideoInputDeviceFacing getFacing() {
        return this.facing;
    }

    public final VideoInputDeviceDescription copy(String name, String guid, VideoInputDeviceFacing facing) {
        C12238m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(guid, "guid");
        C12238m.checkNotNullParameter(facing, "facing");
        return new VideoInputDeviceDescription(name, guid, facing);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoInputDeviceDescription)) {
            return false;
        }
        VideoInputDeviceDescription videoInputDeviceDescription = (VideoInputDeviceDescription) other;
        return C12238m.areEqual(this.name, videoInputDeviceDescription.name) && C12238m.areEqual(this.guid, videoInputDeviceDescription.guid) && C12238m.areEqual(this.facing, videoInputDeviceDescription.facing);
    }

    public final VideoInputDeviceFacing getFacing() {
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
        VideoInputDeviceFacing videoInputDeviceFacing = this.facing;
        return iHashCode2 + (videoInputDeviceFacing != null ? videoInputDeviceFacing.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("VideoInputDeviceDescription(name=");
        sbM833U.append(this.name);
        sbM833U.append(", guid=");
        sbM833U.append(this.guid);
        sbM833U.append(", facing=");
        sbM833U.append(this.facing);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
