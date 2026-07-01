package b.a.q.k0;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.content.Context;
import androidx.annotation.MainThread;
import com.discord.rtcconnection.enums.BluetoothHeadsetAudioState$b;
import com.discord.rtcconnection.enums.BluetoothProfileConnectionState$b;

/* JADX INFO: compiled from: OnBluetoothBroadcastListener.kt */
/* JADX INFO: loaded from: classes.dex */
@MainThread
public interface i {
    void a(Context context, BluetoothHeadsetAudioState$b bluetoothHeadsetAudioState$b);

    void b(BluetoothDevice bluetoothDevice);

    void c(BluetoothHeadset bluetoothHeadset);

    void d(Context context, BluetoothProfileConnectionState$b bluetoothProfileConnectionState$b);
}
