package f0.e0.j;

import com.discord.models.domain.ModelAuditLogEntry;
import okio.ByteString;
import okio.ByteString$a;

/* JADX INFO: compiled from: Header.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final ByteString a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ByteString f3633b;
    public static final ByteString c;
    public static final ByteString d;
    public static final ByteString e;
    public static final ByteString f;
    public final int g;
    public final ByteString h;
    public final ByteString i;

    static {
        ByteString$a byteString$a = ByteString.k;
        a = byteString$a.c(":");
        f3633b = byteString$a.c(":status");
        c = byteString$a.c(":method");
        d = byteString$a.c(":path");
        e = byteString$a.c(":scheme");
        f = byteString$a.c(":authority");
    }

    public b(ByteString byteString, ByteString byteString2) {
        d0.z.d.m.checkParameterIsNotNull(byteString, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkParameterIsNotNull(byteString2, "value");
        this.h = byteString;
        this.i = byteString2;
        this.g = byteString.j() + 32 + byteString2.j();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return d0.z.d.m.areEqual(this.h, bVar.h) && d0.z.d.m.areEqual(this.i, bVar.i);
    }

    public int hashCode() {
        ByteString byteString = this.h;
        int iHashCode = (byteString != null ? byteString.hashCode() : 0) * 31;
        ByteString byteString2 = this.i;
        return iHashCode + (byteString2 != null ? byteString2.hashCode() : 0);
    }

    public String toString() {
        return this.h.q() + ": " + this.i.q();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(String str, String str2) {
        d0.z.d.m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkParameterIsNotNull(str2, "value");
        ByteString$a byteString$a = ByteString.k;
        this(byteString$a.c(str), byteString$a.c(str2));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(ByteString byteString, String str) {
        this(byteString, ByteString.k.c(str));
        d0.z.d.m.checkParameterIsNotNull(byteString, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkParameterIsNotNull(str, "value");
    }
}
