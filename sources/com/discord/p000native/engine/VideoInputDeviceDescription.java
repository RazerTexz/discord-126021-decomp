package com.discord.p000native.engine;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: VideoInputDeviceDescription.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class VideoInputDeviceDescription {
    private final VideoInputDeviceFacing facing;
    private final String guid;
    private final String name;

    public VideoInputDeviceDescription(String str, String str2, VideoInputDeviceFacing videoInputDeviceFacing) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "guid");
        Intrinsics3.checkNotNullParameter(videoInputDeviceFacing, "facing");
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
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(guid, "guid");
        Intrinsics3.checkNotNullParameter(facing, "facing");
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
        return Intrinsics3.areEqual(this.name, videoInputDeviceDescription.name) && Intrinsics3.areEqual(this.guid, videoInputDeviceDescription.guid) && Intrinsics3.areEqual(this.facing, videoInputDeviceDescription.facing);
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
