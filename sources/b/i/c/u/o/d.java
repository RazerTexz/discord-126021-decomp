package b.i.c.u.o;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: PersistedInstallationEntry.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class d {
    public static final /* synthetic */ int a = 0;

    static {
        Long l = 0L;
        String strW = l == null ? " expiresInSecs" : "";
        if (l == null) {
            strW = b.d.b.a.a.w(strW, " tokenCreationEpochInSecs");
        }
        if (!strW.isEmpty()) {
            throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
        }
        l.longValue();
        l.longValue();
    }

    @Nullable
    public abstract String a();

    public abstract long b();

    @Nullable
    public abstract String c();

    @Nullable
    public abstract String d();

    @Nullable
    public abstract String e();

    @NonNull
    public abstract c$a f();

    public abstract long g();

    public boolean h() {
        return f() == c$a.REGISTER_ERROR;
    }

    public boolean i() {
        c$a c_a = ((a) this).c;
        return c_a == c$a.NOT_GENERATED || c_a == c$a.ATTEMPT_MIGRATION;
    }

    public boolean j() {
        return f() == c$a.REGISTERED;
    }

    @NonNull
    public abstract d$a k();
}
