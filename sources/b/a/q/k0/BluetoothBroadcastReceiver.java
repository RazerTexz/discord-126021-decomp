package b.a.q.k0;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.rtcconnection.enums.BluetoothBroadcastAction;
import com.discord.rtcconnection.enums.BluetoothHeadsetAudioState;
import com.discord.rtcconnection.enums.BluetoothProfileConnectionState;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.ThreadUtils;

/* JADX INFO: renamed from: b.a.q.k0.c, reason: use source file name */
/* JADX INFO: compiled from: BluetoothBroadcastReceiver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BluetoothBroadcastReceiver extends BroadcastReceiver implements BluetoothProfile.ServiceListener {
    public boolean l;
    public BluetoothHeadset m;
    public final Context n;
    public final OnBluetoothBroadcastListener o;
    public static final a k = new a(null);
    public static final Set<BluetoothBroadcastAction> j = Sets5.setOf((Object[]) new BluetoothBroadcastAction[]{BluetoothBroadcastAction.HeadsetConnectionStateChanged, BluetoothBroadcastAction.HeadsetAudioStateChanged});

    /* JADX INFO: renamed from: b.a.q.k0.c$a */
    /* JADX INFO: compiled from: BluetoothBroadcastReceiver.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public BluetoothBroadcastReceiver(Context context, OnBluetoothBroadcastListener onBluetoothBroadcastListener) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(onBluetoothBroadcastListener, "listener");
        this.n = context;
        this.o = onBluetoothBroadcastListener;
    }

    @Override // android.content.BroadcastReceiver
    @MainThread
    public void onReceive(Context context, Intent intent) {
        BluetoothBroadcastAction bluetoothBroadcastAction;
        Intrinsics3.checkNotNullParameter(context, "context");
        ThreadUtils.checkIsOnMainThread();
        if (intent == null) {
            return;
        }
        BluetoothBroadcastAction.Companion companion = BluetoothBroadcastAction.INSTANCE;
        String action = intent.getAction();
        Intrinsics3.checkNotNull(action);
        Intrinsics3.checkNotNullExpressionValue(action, "intent.action!!");
        Objects.requireNonNull(companion);
        Intrinsics3.checkNotNullParameter(action, "action");
        BluetoothBroadcastAction[] bluetoothBroadcastActionArrValues = BluetoothBroadcastAction.values();
        int i = 0;
        while (true) {
            if (i >= 5) {
                bluetoothBroadcastAction = null;
                break;
            }
            bluetoothBroadcastAction = bluetoothBroadcastActionArrValues[i];
            if (Intrinsics3.areEqual(bluetoothBroadcastAction.getAction(), action)) {
                break;
            } else {
                i++;
            }
        }
        if (bluetoothBroadcastAction == null) {
            StringBuilder sbU = outline.U("unable to parse BluetoothBroadcastAction for action: ");
            sbU.append(intent.getAction());
            AnimatableValueParser.f1("BluetoothBroadcastReceiver", sbU.toString());
            return;
        }
        AnimatableValueParser.e1("BluetoothBroadcastReceiver", "onReceive: action = " + bluetoothBroadcastAction);
        try {
            OnBluetoothBroadcastListener onBluetoothBroadcastListener = this.o;
            int iOrdinal = bluetoothBroadcastAction.ordinal();
            if (iOrdinal == 0) {
                onBluetoothBroadcastListener.d(context, BluetoothProfileConnectionState.INSTANCE.b(intent));
            } else if (iOrdinal == 1) {
                onBluetoothBroadcastListener.a(context, BluetoothHeadsetAudioState.INSTANCE.b(intent));
            } else if (iOrdinal != 4) {
                AnimatableValueParser.f1("BluetoothBroadcastReceiver", "unexpected " + bluetoothBroadcastAction);
            } else {
                Intrinsics3.checkNotNullParameter(intent, "$this$getBluetoothDeviceExtra");
                onBluetoothBroadcastListener.b((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"));
            }
        } catch (Throwable th) {
            AnimatableValueParser.c1("BluetoothBroadcastReceiver", "error handling " + bluetoothBroadcastAction, th);
        }
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
        ThreadUtils.checkIsOnMainThread();
        if (i == 1 && this.l) {
            AnimatableValueParser.b1("BluetoothBroadcastReceiver", "BluetoothProfile.ServiceListener.onServiceConnected");
            if (!(bluetoothProfile instanceof BluetoothHeadset)) {
                bluetoothProfile = null;
            }
            BluetoothHeadset bluetoothHeadset = (BluetoothHeadset) bluetoothProfile;
            this.m = bluetoothHeadset;
            this.o.c(bluetoothHeadset);
        }
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public void onServiceDisconnected(int i) {
        ThreadUtils.checkIsOnMainThread();
        if (i == 1 && this.l) {
            AnimatableValueParser.b1("BluetoothBroadcastReceiver", "BluetoothProfile.ServiceListener.onServiceDisconnected");
            this.m = null;
            this.o.c(null);
        }
    }
}
