package f0.e0.n;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: f0.e0.n.f, reason: use source file name */
/* JADX INFO: compiled from: WebSocketExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class WebSocketExtensions {
    public final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f3664b;
    public final boolean c;
    public final Integer d;
    public final boolean e;
    public final boolean f;

    public WebSocketExtensions() {
        this.a = false;
        this.f3664b = null;
        this.c = false;
        this.d = null;
        this.e = false;
        this.f = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
        return this.a == webSocketExtensions.a && Intrinsics3.areEqual(this.f3664b, webSocketExtensions.f3664b) && this.c == webSocketExtensions.c && Intrinsics3.areEqual(this.d, webSocketExtensions.d) && this.e == webSocketExtensions.e && this.f == webSocketExtensions.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        boolean z2 = this.a;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        Integer num = this.f3664b;
        int iHashCode = (i + (num != null ? num.hashCode() : 0)) * 31;
        boolean z3 = this.c;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (iHashCode + r2) * 31;
        Integer num2 = this.d;
        int iHashCode2 = (i2 + (num2 != null ? num2.hashCode() : 0)) * 31;
        boolean z4 = this.e;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (iHashCode2 + r3) * 31;
        boolean z5 = this.f;
        return i3 + (z5 ? 1 : z5);
    }

    public String toString() {
        StringBuilder sbU = outline.U("WebSocketExtensions(perMessageDeflate=");
        sbU.append(this.a);
        sbU.append(", clientMaxWindowBits=");
        sbU.append(this.f3664b);
        sbU.append(", clientNoContextTakeover=");
        sbU.append(this.c);
        sbU.append(", serverMaxWindowBits=");
        sbU.append(this.d);
        sbU.append(", serverNoContextTakeover=");
        sbU.append(this.e);
        sbU.append(", unknownValues=");
        return outline.O(sbU, this.f, ")");
    }

    public WebSocketExtensions(boolean z2, Integer num, boolean z3, Integer num2, boolean z4, boolean z5) {
        this.a = z2;
        this.f3664b = num;
        this.c = z3;
        this.d = num2;
        this.e = z4;
        this.f = z5;
    }
}
