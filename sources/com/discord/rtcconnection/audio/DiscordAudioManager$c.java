package com.discord.rtcconnection.audio;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.content.Context;
import androidx.annotation.MainThread;
import b.a.q.k0.i;
import b.c.a.a0.d;
import com.discord.rtcconnection.enums.BluetoothHeadsetAudioState;
import com.discord.rtcconnection.enums.BluetoothHeadsetAudioState$b;
import com.discord.rtcconnection.enums.BluetoothProfileConnectionState;
import com.discord.rtcconnection.enums.BluetoothProfileConnectionState$b;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DiscordAudioManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordAudioManager$c implements i {
    public final /* synthetic */ DiscordAudioManager a;

    public DiscordAudioManager$c(DiscordAudioManager discordAudioManager) {
        this.a = discordAudioManager;
    }

    @Override // b.a.q.k0.i
    @MainThread
    public void a(Context context, BluetoothHeadsetAudioState$b bluetoothHeadsetAudioState$b) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(bluetoothHeadsetAudioState$b, "audioState");
        BluetoothHeadsetAudioState bluetoothHeadsetAudioState = bluetoothHeadsetAudioState$b.a;
        if (bluetoothHeadsetAudioState == null) {
            bluetoothHeadsetAudioState = BluetoothHeadsetAudioState.Disconnected;
        }
        BluetoothDevice bluetoothDevice = bluetoothHeadsetAudioState$b.c;
        StringBuilder sb = new StringBuilder();
        sb.append("[onHeadsetAudioStateChanged] state: ");
        sb.append(bluetoothHeadsetAudioState);
        sb.append(", device: ");
        sb.append(bluetoothDevice != null ? bluetoothDevice.getName() : null);
        d.b1("DiscordAudioManager", sb.toString());
        int iOrdinal = bluetoothHeadsetAudioState.ordinal();
        if (iOrdinal == 0) {
            this.a.l();
            return;
        }
        if (iOrdinal != 2) {
            return;
        }
        synchronized (this.a.i) {
            DiscordAudioManager discordAudioManager = this.a;
            List<DiscordAudioManager$AudioDevice> list = discordAudioManager.r;
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
            for (DiscordAudioManager$AudioDevice discordAudioManager$AudioDevice : list) {
                arrayList.add(discordAudioManager$AudioDevice.type.ordinal() != 5 ? DiscordAudioManager$AudioDevice.a(discordAudioManager$AudioDevice, null, false, null, null, 15) : DiscordAudioManager$AudioDevice.a(discordAudioManager$AudioDevice, null, true, bluetoothDevice != null ? bluetoothDevice.getAddress() : null, bluetoothDevice != null ? bluetoothDevice.getName() : null, 1));
            }
            discordAudioManager.r = arrayList;
            discordAudioManager.f2785s.k.onNext(arrayList);
        }
    }

    @Override // b.a.q.k0.i
    @MainThread
    public void b(BluetoothDevice bluetoothDevice) {
        b.a.q.k0.d dVar = b.a.q.k0.d.c;
        if (!(((String) b.a.q.k0.d.a.getValue()) != null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (bluetoothDevice != null) {
            this.a.l();
        }
    }

    @Override // b.a.q.k0.i
    @MainThread
    public void c(BluetoothHeadset bluetoothHeadset) {
        this.a.n = bluetoothHeadset;
    }

    @Override // b.a.q.k0.i
    @MainThread
    public void d(Context context, BluetoothProfileConnectionState$b bluetoothProfileConnectionState$b) {
        ArrayList arrayList;
        DiscordAudioManager discordAudioManager;
        DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes;
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(bluetoothProfileConnectionState$b, "connectionState");
        BluetoothProfileConnectionState bluetoothProfileConnectionState = bluetoothProfileConnectionState$b.f2791b;
        if (bluetoothProfileConnectionState == null) {
            bluetoothProfileConnectionState = BluetoothProfileConnectionState.Disconnected;
        }
        BluetoothDevice bluetoothDevice = bluetoothProfileConnectionState$b.c;
        StringBuilder sb = new StringBuilder();
        sb.append("[onHeadsetConnectionStateChanged] state: ");
        sb.append(bluetoothProfileConnectionState);
        sb.append(", device: ");
        sb.append(bluetoothDevice != null ? bluetoothDevice.getName() : null);
        d.b1("DiscordAudioManager", sb.toString());
        int iOrdinal = bluetoothProfileConnectionState.ordinal();
        if (iOrdinal == 0) {
            synchronized (this.a.i) {
                List<DiscordAudioManager$AudioDevice> list = this.a.r;
                arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(DiscordAudioManager$AudioDevice.a((DiscordAudioManager$AudioDevice) it.next(), null, false, null, null, 15));
                }
            }
            DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes2 = DiscordAudioManager$DeviceTypes.BLUETOOTH_HEADSET;
            if (((DiscordAudioManager$AudioDevice) arrayList.get(discordAudioManager$DeviceTypes2.getValue())).com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_ID java.lang.String != null) {
                if (m.areEqual(bluetoothDevice != null ? bluetoothDevice.getAddress() : null, ((DiscordAudioManager$AudioDevice) arrayList.get(discordAudioManager$DeviceTypes2.getValue())).com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_ID java.lang.String)) {
                    this.a.l();
                    return;
                }
                return;
            }
            return;
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                synchronized (this.a.i) {
                    discordAudioManager = this.a;
                    discordAudioManager$DeviceTypes = discordAudioManager.t;
                }
                if (discordAudioManager$DeviceTypes == DiscordAudioManager$DeviceTypes.BLUETOOTH_HEADSET) {
                    discordAudioManager.g();
                    return;
                } else {
                    discordAudioManager.l();
                    return;
                }
            }
            if (iOrdinal != 3) {
                return;
            }
        }
        d.b1("DiscordAudioManager", "[onHeadsetConnectionStateChanged] " + bluetoothProfileConnectionState + "...");
    }
}
