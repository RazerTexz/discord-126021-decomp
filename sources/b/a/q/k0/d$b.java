package b.a.q.k0;

import android.bluetooth.BluetoothHeadset;
import d0.z.d.o;
import java.lang.reflect.Method;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: BluetoothHeadsetPrivateApi.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d$b extends o implements Function0<Method> {
    public static final d$b j = new d$b();

    public d$b() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Method invoke() {
        try {
            return BluetoothHeadset.class.getDeclaredMethod("getActiveDevice", new Class[0]);
        } catch (Throwable unused) {
            return null;
        }
    }
}
