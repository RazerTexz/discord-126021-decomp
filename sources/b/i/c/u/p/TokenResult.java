package b.i.c.u.p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.u.p.AutoValue_TokenResult;
import com.google.auto.value.AutoValue;

/* JADX INFO: renamed from: b.i.c.u.p.f, reason: use source file name */
/* JADX INFO: compiled from: TokenResult.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class TokenResult {

    /* JADX INFO: renamed from: b.i.c.u.p.f$a */
    /* JADX INFO: compiled from: TokenResult.java */
    @AutoValue.Builder
    public static abstract class a {
        @NonNull
        public abstract TokenResult a();

        @NonNull
        public abstract a b(long j);
    }

    /* JADX INFO: renamed from: b.i.c.u.p.f$b */
    /* JADX INFO: compiled from: TokenResult.java */
    public enum b {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    @NonNull
    public static a a() {
        AutoValue_TokenResult.b bVar = new AutoValue_TokenResult.b();
        bVar.b(0L);
        return bVar;
    }

    @Nullable
    public abstract b b();

    @Nullable
    public abstract String c();

    @NonNull
    public abstract long d();
}
