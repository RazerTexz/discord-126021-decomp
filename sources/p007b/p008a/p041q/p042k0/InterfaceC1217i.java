package p007b.p008a.p041q.p042k0;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.content.Context;
import androidx.annotation.MainThread;
import com.discord.rtcconnection.enums.BluetoothHeadsetAudioState;
import com.discord.rtcconnection.enums.BluetoothProfileConnectionState;

/* JADX INFO: renamed from: b.a.q.k0.i */
/* JADX INFO: compiled from: OnBluetoothBroadcastListener.kt */
/* JADX INFO: loaded from: classes.dex */
@MainThread
public interface InterfaceC1217i {
    /* JADX INFO: renamed from: a */
    void mo286a(Context context, BluetoothHeadsetAudioState.C5633b c5633b);

    /* JADX INFO: renamed from: b */
    void mo287b(BluetoothDevice bluetoothDevice);

    /* JADX INFO: renamed from: c */
    void mo288c(BluetoothHeadset bluetoothHeadset);

    /* JADX INFO: renamed from: d */
    void mo289d(Context context, BluetoothProfileConnectionState.C5635b c5635b);
}
