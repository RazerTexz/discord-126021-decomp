package b.a.q.k0;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.content.Context;
import androidx.annotation.MainThread;
import com.discord.rtcconnection.enums.BluetoothHeadsetAudioState;
import com.discord.rtcconnection.enums.BluetoothProfileConnectionState;

/* JADX INFO: renamed from: b.a.q.k0.i, reason: use source file name */
/* JADX INFO: compiled from: OnBluetoothBroadcastListener.kt */
/* JADX INFO: loaded from: classes.dex */
@MainThread
public interface OnBluetoothBroadcastListener {
    void a(Context context, BluetoothHeadsetAudioState.b bVar);

    void b(BluetoothDevice bluetoothDevice);

    void c(BluetoothHeadset bluetoothHeadset);

    void d(Context context, BluetoothProfileConnectionState.b bVar);
}
