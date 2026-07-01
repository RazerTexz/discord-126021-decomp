package f0.e0.j;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import okio.ByteString;

/* JADX INFO: renamed from: f0.e0.j.b, reason: use source file name */
/* JADX INFO: compiled from: Header.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Header2 {
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
        ByteString.Companion companion = ByteString.INSTANCE;
        a = companion.c(":");
        f3633b = companion.c(":status");
        c = companion.c(":method");
        d = companion.c(":path");
        e = companion.c(":scheme");
        f = companion.c(":authority");
    }

    public Header2(ByteString byteString, ByteString byteString2) {
        Intrinsics3.checkParameterIsNotNull(byteString, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkParameterIsNotNull(byteString2, "value");
        this.h = byteString;
        this.i = byteString2;
        this.g = byteString.j() + 32 + byteString2.j();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Header2)) {
            return false;
        }
        Header2 header2 = (Header2) obj;
        return Intrinsics3.areEqual(this.h, header2.h) && Intrinsics3.areEqual(this.i, header2.i);
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
    public Header2(String str, String str2) {
        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkParameterIsNotNull(str2, "value");
        ByteString.Companion companion = ByteString.INSTANCE;
        this(companion.c(str), companion.c(str2));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header2(ByteString byteString, String str) {
        this(byteString, ByteString.INSTANCE.c(str));
        Intrinsics3.checkParameterIsNotNull(byteString, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkParameterIsNotNull(str, "value");
    }
}
