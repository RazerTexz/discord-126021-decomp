package b.a.q.k0;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile$ServiceListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import com.discord.rtcconnection.enums.BluetoothBroadcastAction;
import com.discord.rtcconnection.enums.BluetoothBroadcastAction$a;
import com.discord.rtcconnection.enums.BluetoothHeadsetAudioState;
import com.discord.rtcconnection.enums.BluetoothProfileConnectionState;
import d0.t.n0;
import d0.z.d.m;
import java.util.Objects;
import java.util.Set;
import org.webrtc.ThreadUtils;

/* JADX INFO: compiled from: BluetoothBroadcastReceiver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c extends BroadcastReceiver implements BluetoothProfile$ServiceListener {
    public boolean l;
    public BluetoothHeadset m;
    public final Context n;
    public final i o;
    public static final c$a k = new c$a(null);
    public static final Set<BluetoothBroadcastAction> j = n0.setOf((Object[]) new BluetoothBroadcastAction[]{BluetoothBroadcastAction.HeadsetConnectionStateChanged, BluetoothBroadcastAction.HeadsetAudioStateChanged});

    public c(Context context, i iVar) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(iVar, "listener");
        this.n = context;
        this.o = iVar;
    }

    @Override // android.content.BroadcastReceiver
    @MainThread
    public void onReceive(Context context, Intent intent) {
        BluetoothBroadcastAction bluetoothBroadcastAction;
        m.checkNotNullParameter(context, "context");
        ThreadUtils.checkIsOnMainThread();
        if (intent == null) {
            return;
        }
        BluetoothBroadcastAction$a bluetoothBroadcastAction$a = BluetoothBroadcastAction.Companion;
        String action = intent.getAction();
        m.checkNotNull(action);
        m.checkNotNullExpressionValue(action, "intent.action!!");
        Objects.requireNonNull(bluetoothBroadcastAction$a);
        m.checkNotNullParameter(action, "action");
        BluetoothBroadcastAction[] bluetoothBroadcastActionArrValues = BluetoothBroadcastAction.values();
        int i = 0;
        while (true) {
            if (i >= 5) {
                bluetoothBroadcastAction = null;
                break;
            }
            bluetoothBroadcastAction = bluetoothBroadcastActionArrValues[i];
            if (m.areEqual(bluetoothBroadcastAction.getAction(), action)) {
                break;
            } else {
                i++;
            }
        }
        if (bluetoothBroadcastAction == null) {
            StringBuilder sbU = b.d.b.a.a.U("unable to parse BluetoothBroadcastAction for action: ");
            sbU.append(intent.getAction());
            b.c.a.a0.d.f1("BluetoothBroadcastReceiver", sbU.toString());
            return;
        }
        b.c.a.a0.d.e1("BluetoothBroadcastReceiver", "onReceive: action = " + bluetoothBroadcastAction);
        try {
            i iVar = this.o;
            int iOrdinal = bluetoothBroadcastAction.ordinal();
            if (iOrdinal == 0) {
                iVar.d(context, BluetoothProfileConnectionState.Companion.b(intent));
            } else if (iOrdinal == 1) {
                iVar.a(context, BluetoothHeadsetAudioState.Companion.b(intent));
            } else if (iOrdinal != 4) {
                b.c.a.a0.d.f1("BluetoothBroadcastReceiver", "unexpected " + bluetoothBroadcastAction);
            } else {
                m.checkNotNullParameter(intent, "$this$getBluetoothDeviceExtra");
                iVar.b((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"));
            }
        } catch (Throwable th) {
            b.c.a.a0.d.c1("BluetoothBroadcastReceiver", "error handling " + bluetoothBroadcastAction, th);
        }
    }

    @Override // android.bluetooth.BluetoothProfile$ServiceListener
    public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
        ThreadUtils.checkIsOnMainThread();
        if (i == 1 && this.l) {
            b.c.a.a0.d.b1("BluetoothBroadcastReceiver", "BluetoothProfile.ServiceListener.onServiceConnected");
            if (!(bluetoothProfile instanceof BluetoothHeadset)) {
                bluetoothProfile = null;
            }
            BluetoothHeadset bluetoothHeadset = (BluetoothHeadset) bluetoothProfile;
            this.m = bluetoothHeadset;
            this.o.c(bluetoothHeadset);
        }
    }

    @Override // android.bluetooth.BluetoothProfile$ServiceListener
    public void onServiceDisconnected(int i) {
        ThreadUtils.checkIsOnMainThread();
        if (i == 1 && this.l) {
            b.c.a.a0.d.b1("BluetoothBroadcastReceiver", "BluetoothProfile.ServiceListener.onServiceDisconnected");
            this.m = null;
            this.o.c(null);
        }
    }
}
