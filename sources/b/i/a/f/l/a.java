package b.i.a.f.l;

import androidx.annotation.Nullable;
import b.i.a.f.e.h.a$d;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements a$d {
    public static final a j = new a();

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        Objects.requireNonNull((a) obj);
        return b.c.a.a0.d.h0(null, null) && b.c.a.a0.d.h0(null, null) && b.c.a.a0.d.h0(null, null) && b.c.a.a0.d.h0(null, null) && b.c.a.a0.d.h0(null, null);
    }

    public final int hashCode() {
        Boolean bool = Boolean.FALSE;
        return Arrays.hashCode(new Object[]{bool, bool, null, bool, bool, null, null, null, null});
    }
}
