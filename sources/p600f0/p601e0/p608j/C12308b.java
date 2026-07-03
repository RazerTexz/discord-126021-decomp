package p600f0.p601e0.p608j;

import com.discord.models.domain.ModelAuditLogEntry;
import okio.ByteString;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: f0.e0.j.b */
/* JADX INFO: compiled from: Header.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12308b {

    /* JADX INFO: renamed from: a */
    public static final ByteString f25580a;

    /* JADX INFO: renamed from: b */
    public static final ByteString f25581b;

    /* JADX INFO: renamed from: c */
    public static final ByteString f25582c;

    /* JADX INFO: renamed from: d */
    public static final ByteString f25583d;

    /* JADX INFO: renamed from: e */
    public static final ByteString f25584e;

    /* JADX INFO: renamed from: f */
    public static final ByteString f25585f;

    /* JADX INFO: renamed from: g */
    public final int f25586g;

    /* JADX INFO: renamed from: h */
    public final ByteString f25587h;

    /* JADX INFO: renamed from: i */
    public final ByteString f25588i;

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        f25580a = companion.m11012c(":");
        f25581b = companion.m11012c(":status");
        f25582c = companion.m11012c(":method");
        f25583d = companion.m11012c(":path");
        f25584e = companion.m11012c(":scheme");
        f25585f = companion.m11012c(":authority");
    }

    public C12308b(ByteString byteString, ByteString byteString2) {
        C12238m.checkParameterIsNotNull(byteString, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkParameterIsNotNull(byteString2, "value");
        this.f25587h = byteString;
        this.f25588i = byteString2;
        this.f25586g = byteString.mo10502j() + 32 + byteString2.mo10502j();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12308b)) {
            return false;
        }
        C12308b c12308b = (C12308b) obj;
        return C12238m.areEqual(this.f25587h, c12308b.f25587h) && C12238m.areEqual(this.f25588i, c12308b.f25588i);
    }

    public int hashCode() {
        ByteString byteString = this.f25587h;
        int iHashCode = (byteString != null ? byteString.hashCode() : 0) * 31;
        ByteString byteString2 = this.f25588i;
        return iHashCode + (byteString2 != null ? byteString2.hashCode() : 0);
    }

    public String toString() {
        return this.f25587h.m11008q() + ": " + this.f25588i.m11008q();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C12308b(String str, String str2) {
        C12238m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkParameterIsNotNull(str2, "value");
        ByteString.Companion companion = ByteString.INSTANCE;
        this(companion.m11012c(str), companion.m11012c(str2));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C12308b(ByteString byteString, String str) {
        this(byteString, ByteString.INSTANCE.m11012c(str));
        C12238m.checkParameterIsNotNull(byteString, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkParameterIsNotNull(str, "value");
    }
}
