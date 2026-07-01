package b.a.q.k0;

import android.content.Context;
import android.os.Process;
import d0.z.d.m;

/* JADX INFO: compiled from: AudioPermissions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final b$a a = new b$a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f262b;
    public final boolean c;
    public final boolean d;

    public b(Context context) {
        m.checkNotNullParameter(context, "context");
        boolean z2 = context.checkPermission("android.permission.MODIFY_AUDIO_SETTINGS", Process.myPid(), Process.myUid()) == 0;
        boolean z3 = context.checkPermission("android.permission.RECORD_AUDIO", Process.myPid(), Process.myUid()) == 0;
        boolean z4 = context.checkPermission("android.permission.BLUETOOTH", Process.myPid(), Process.myUid()) == 0;
        this.f262b = z2;
        this.c = z3;
        this.d = z4;
        if (!z2) {
            b.c.a.a0.d.f1("AudioPermissions", "MODIFY_AUDIO_SETTINGS permission is missing");
        }
        if (!z3) {
            b.c.a.a0.d.f1("AudioPermissions", "RECORD_AUDIO permission is missing");
        }
        if (z4) {
            return;
        }
        b.c.a.a0.d.f1("AudioPermissions", "BLUETOOTH permission is missing");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f262b == bVar.f262b && this.c == bVar.c && this.d == bVar.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        boolean z2 = this.f262b;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.c;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.d;
        return i2 + (z4 ? 1 : z4);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("AudioPermissions(hasModifyAudioSettingsPermission=");
        sbU.append(this.f262b);
        sbU.append(", hasRecordAudioPermission=");
        sbU.append(this.c);
        sbU.append(", hasBluetoothPermission=");
        return b.d.b.a.a.O(sbU, this.d, ")");
    }
}
