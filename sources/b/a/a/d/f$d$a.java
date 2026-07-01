package b.a.a.d;

import com.discord.models.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f$d$a extends f$d {
    public final User a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f47b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$d$a(User user, String str, boolean z2, boolean z3, boolean z4) {
        super(null);
        m.checkNotNullParameter(user, "user");
        this.a = user;
        this.f47b = str;
        this.c = z2;
        this.d = z3;
        this.e = z4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f$d$a)) {
            return false;
        }
        f$d$a f_d_a = (f$d$a) obj;
        return m.areEqual(this.a, f_d_a.a) && m.areEqual(this.f47b, f_d_a.f47b) && this.c == f_d_a.c && this.d == f_d_a.d && this.e == f_d_a.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        User user = this.a;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        String str = this.f47b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.c;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean z3 = this.d;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.e;
        return i2 + (z4 ? 1 : z4);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Loaded(user=");
        sbU.append(this.a);
        sbU.append(", userNickname=");
        sbU.append(this.f47b);
        sbU.append(", showBlockItem=");
        sbU.append(this.c);
        sbU.append(", showUnblockItem=");
        sbU.append(this.d);
        sbU.append(", showRemoveFriendItem=");
        return b.d.b.a.a.O(sbU, this.e, ")");
    }
}
