package b.i.a.f.e;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z extends x {
    public static final WeakReference<byte[]> c = new WeakReference<>(null);
    public WeakReference<byte[]> d;

    public z(byte[] bArr) {
        super(bArr);
        this.d = c;
    }

    @Override // b.i.a.f.e.x
    public final byte[] g() {
        byte[] bArrT0;
        synchronized (this) {
            bArrT0 = this.d.get();
            if (bArrT0 == null) {
                bArrT0 = t0();
                this.d = new WeakReference<>(bArrT0);
            }
        }
        return bArrT0;
    }

    public abstract byte[] t0();
}
