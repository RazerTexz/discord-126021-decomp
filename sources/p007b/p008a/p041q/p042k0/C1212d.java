package p007b.p008a.p041q.p042k0;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothHeadset;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.q.k0.d */
/* JADX INFO: compiled from: BluetoothHeadsetPrivateApi.kt */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"DiscouragedPrivateApi"})
public final class C1212d {

    /* JADX INFO: renamed from: a */
    public static final Lazy f1653a = C12083g.lazy(a.f1656j);

    /* JADX INFO: renamed from: b */
    public static final Lazy f1654b = C12083g.lazy(b.f1657j);

    /* JADX INFO: renamed from: c */
    public static final C1212d f1655c = null;

    /* JADX INFO: renamed from: b.a.q.k0.d$a */
    /* JADX INFO: compiled from: BluetoothHeadsetPrivateApi.kt */
    public static final class a extends AbstractC12240o implements Function0<String> {

        /* JADX INFO: renamed from: j */
        public static final a f1656j = new a();

        public a() {
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

    /* JADX INFO: renamed from: b.a.q.k0.d$b */
    /* JADX INFO: compiled from: BluetoothHeadsetPrivateApi.kt */
    public static final class b extends AbstractC12240o implements Function0<Method> {

        /* JADX INFO: renamed from: j */
        public static final b f1657j = new b();

        public b() {
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
}
