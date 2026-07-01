package b.i.c.u.p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: TokenResult.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class f {
    @NonNull
    public static f$a a() {
        b$b b_b = new b$b();
        b_b.b(0L);
        return b_b;
    }

    @Nullable
    public abstract f$b b();

    @Nullable
    public abstract String c();

    @NonNull
    public abstract long d();
}
