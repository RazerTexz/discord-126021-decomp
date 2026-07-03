package p007b.p008a.p041q.p042k0;

import android.content.Context;
import android.os.Process;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.k0.b */
/* JADX INFO: compiled from: AudioPermissions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1210b {

    /* JADX INFO: renamed from: a */
    public static final a f1643a = new a(null);

    /* JADX INFO: renamed from: b */
    public final boolean f1644b;

    /* JADX INFO: renamed from: c */
    public final boolean f1645c;

    /* JADX INFO: renamed from: d */
    public final boolean f1646d;

    /* JADX INFO: renamed from: b.a.q.k0.b$a */
    /* JADX INFO: compiled from: AudioPermissions.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public C1210b(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        boolean z2 = context.checkPermission("android.permission.MODIFY_AUDIO_SETTINGS", Process.myPid(), Process.myUid()) == 0;
        boolean z3 = context.checkPermission("android.permission.RECORD_AUDIO", Process.myPid(), Process.myUid()) == 0;
        boolean z4 = context.checkPermission("android.permission.BLUETOOTH", Process.myPid(), Process.myUid()) == 0;
        this.f1644b = z2;
        this.f1645c = z3;
        this.f1646d = z4;
        if (!z2) {
            C1460d.m517f1("AudioPermissions", "MODIFY_AUDIO_SETTINGS permission is missing");
        }
        if (!z3) {
            C1460d.m517f1("AudioPermissions", "RECORD_AUDIO permission is missing");
        }
        if (z4) {
            return;
        }
        C1460d.m517f1("AudioPermissions", "BLUETOOTH permission is missing");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1210b)) {
            return false;
        }
        C1210b c1210b = (C1210b) obj;
        return this.f1644b == c1210b.f1644b && this.f1645c == c1210b.f1645c && this.f1646d == c1210b.f1646d;
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
        boolean z2 = this.f1644b;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.f1645c;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.f1646d;
        return i2 + (z4 ? 1 : z4);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("AudioPermissions(hasModifyAudioSettingsPermission=");
        sbM833U.append(this.f1644b);
        sbM833U.append(", hasRecordAudioPermission=");
        sbM833U.append(this.f1645c);
        sbM833U.append(", hasBluetoothPermission=");
        return C1643a.m827O(sbM833U, this.f1646d, ")");
    }
}
