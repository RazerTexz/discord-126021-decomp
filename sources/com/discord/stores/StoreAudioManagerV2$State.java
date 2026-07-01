package com.discord.stores;

import b.d.b.a.a;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.rtcconnection.audio.DiscordAudioManager$AudioDevice;
import com.discord.rtcconnection.audio.DiscordAudioManager$DeviceTypes;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreAudioManagerV2.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreAudioManagerV2$State {
    private DiscordAudioManager$DeviceTypes activeAudioDevice;
    private List<DiscordAudioManager$AudioDevice> audioDevices;

    public StoreAudioManagerV2$State() {
        this(null, null, 3, null);
    }

    public StoreAudioManagerV2$State(List<DiscordAudioManager$AudioDevice> list, DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes) {
        m.checkNotNullParameter(list, "audioDevices");
        m.checkNotNullParameter(discordAudioManager$DeviceTypes, "activeAudioDevice");
        this.audioDevices = list;
        this.activeAudioDevice = discordAudioManager$DeviceTypes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreAudioManagerV2$State copy$default(StoreAudioManagerV2$State storeAudioManagerV2$State, List list, DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes, int i, Object obj) {
        if ((i & 1) != 0) {
            list = storeAudioManagerV2$State.audioDevices;
        }
        if ((i & 2) != 0) {
            discordAudioManager$DeviceTypes = storeAudioManagerV2$State.activeAudioDevice;
        }
        return storeAudioManagerV2$State.copy(list, discordAudioManager$DeviceTypes);
    }

    public final List<DiscordAudioManager$AudioDevice> component1() {
        return this.audioDevices;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final DiscordAudioManager$DeviceTypes getActiveAudioDevice() {
        return this.activeAudioDevice;
    }

    public final StoreAudioManagerV2$State copy(List<DiscordAudioManager$AudioDevice> audioDevices, DiscordAudioManager$DeviceTypes activeAudioDevice) {
        m.checkNotNullParameter(audioDevices, "audioDevices");
        m.checkNotNullParameter(activeAudioDevice, "activeAudioDevice");
        return new StoreAudioManagerV2$State(audioDevices, activeAudioDevice);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreAudioManagerV2$State)) {
            return false;
        }
        StoreAudioManagerV2$State storeAudioManagerV2$State = (StoreAudioManagerV2$State) other;
        return m.areEqual(this.audioDevices, storeAudioManagerV2$State.audioDevices) && m.areEqual(this.activeAudioDevice, storeAudioManagerV2$State.activeAudioDevice);
    }

    public final DiscordAudioManager$DeviceTypes getActiveAudioDevice() {
        return this.activeAudioDevice;
    }

    public final List<DiscordAudioManager$AudioDevice> getAudioDevices() {
        return this.audioDevices;
    }

    public int hashCode() {
        List<DiscordAudioManager$AudioDevice> list = this.audioDevices;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes = this.activeAudioDevice;
        return iHashCode + (discordAudioManager$DeviceTypes != null ? discordAudioManager$DeviceTypes.hashCode() : 0);
    }

    public final void setActiveAudioDevice(DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes) {
        m.checkNotNullParameter(discordAudioManager$DeviceTypes, "<set-?>");
        this.activeAudioDevice = discordAudioManager$DeviceTypes;
    }

    public final void setAudioDevices(List<DiscordAudioManager$AudioDevice> list) {
        m.checkNotNullParameter(list, "<set-?>");
        this.audioDevices = list;
    }

    public String toString() {
        StringBuilder sbU = a.U("State(audioDevices=");
        sbU.append(this.audioDevices);
        sbU.append(", activeAudioDevice=");
        sbU.append(this.activeAudioDevice);
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StoreAudioManagerV2$State(List list, DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
            list = DiscordAudioManager.f();
        }
        this(list, (i & 2) != 0 ? DiscordAudioManager$DeviceTypes.INVALID : discordAudioManager$DeviceTypes);
    }
}
