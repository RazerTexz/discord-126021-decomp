package b.a.q.k0;

import android.bluetooth.BluetoothHeadset;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: BluetoothHeadsetPrivateApi.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d$a extends o implements Function0<String> {
    public static final d$a j = new d$a();

    public d$a() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public String invoke() {
        try {
            Object obj = BluetoothHeadset.class.getField("ACTION_ACTIVE_DEVICE_CHANGED").get(null);
            if (!(obj instanceof String)) {
                obj = null;
            }
            return (String) obj;
        } catch (Throwable unused) {
            return null;
        }
    }
}
