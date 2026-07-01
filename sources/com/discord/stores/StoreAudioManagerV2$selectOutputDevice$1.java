package com.discord.stores;

import b.c.a.a0.d;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.rtcconnection.audio.DiscordAudioManager$AudioDevice;
import com.discord.rtcconnection.audio.DiscordAudioManager$DeviceTypes;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: StoreAudioManagerV2.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAudioManagerV2$selectOutputDevice$1 implements Runnable {
    public final /* synthetic */ DiscordAudioManager$DeviceTypes $device;

    public StoreAudioManagerV2$selectOutputDevice$1(DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes) {
        this.$device = discordAudioManager$DeviceTypes;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList;
        boolean z2;
        boolean z3;
        DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
        DiscordAudioManager discordAudioManagerD = DiscordAudioManager.d();
        DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes = this.$device;
        Objects.requireNonNull(discordAudioManagerD);
        m.checkNotNullParameter(discordAudioManager$DeviceTypes, "deviceType");
        discordAudioManagerD.c();
        if (!discordAudioManagerD.e().f262b) {
            d.f1("DiscordAudioManager", "Can't setDevice, requires MODIFY_AUDIO_SETTINGS.");
            return;
        }
        d.b1("DiscordAudioManager", "setDevice(deviceType=" + discordAudioManager$DeviceTypes + ')');
        synchronized (discordAudioManagerD.i) {
            List<DiscordAudioManager$AudioDevice> list = discordAudioManagerD.r;
            arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(DiscordAudioManager$AudioDevice.a((DiscordAudioManager$AudioDevice) it.next(), null, false, null, null, 15));
            }
        }
        DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes2 = DiscordAudioManager$DeviceTypes.DEFAULT;
        if (discordAudioManager$DeviceTypes == discordAudioManager$DeviceTypes2) {
            synchronized (discordAudioManagerD.i) {
                discordAudioManagerD.f2788z = discordAudioManager$DeviceTypes2;
            }
            discordAudioManagerD.a(arrayList);
            return;
        }
        int iOrdinal = discordAudioManager$DeviceTypes.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            z2 = false;
        } else {
            if (iOrdinal != 2 && iOrdinal != 3 && iOrdinal != 4 && iOrdinal != 5) {
                throw new NoWhenBranchMatchedException();
            }
            z2 = true;
        }
        if (z2) {
            synchronized (discordAudioManagerD.i) {
                z3 = true ^ discordAudioManagerD.r.get(discordAudioManager$DeviceTypes.getValue()).isAvailable;
            }
            if (z3) {
                return;
            }
            synchronized (discordAudioManagerD.i) {
                discordAudioManagerD.f2788z = discordAudioManager$DeviceTypes;
            }
            discordAudioManagerD.b(discordAudioManager$DeviceTypes);
        }
    }
}
