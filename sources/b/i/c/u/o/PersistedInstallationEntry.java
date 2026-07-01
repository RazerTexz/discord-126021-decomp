package b.i.c.u.o;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.c.u.o.PersistedInstallation;
import com.google.auto.value.AutoValue;

/* JADX INFO: renamed from: b.i.c.u.o.d, reason: use source file name */
/* JADX INFO: compiled from: PersistedInstallationEntry.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class PersistedInstallationEntry {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b.i.c.u.o.d$a */
    /* JADX INFO: compiled from: PersistedInstallationEntry.java */
    @AutoValue.Builder
    public static abstract class a {
        @NonNull
        public abstract PersistedInstallationEntry a();

        @NonNull
        public abstract a b(@NonNull PersistedInstallation.a aVar);
    }

    static {
        Long l = 0L;
        String strW = l == null ? " expiresInSecs" : "";
        if (l == null) {
            strW = outline.w(strW, " tokenCreationEpochInSecs");
        }
        if (!strW.isEmpty()) {
            throw new IllegalStateException(outline.w("Missing required properties:", strW));
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
    public abstract PersistedInstallation.a f();

    public abstract long g();

    public boolean h() {
        return f() == PersistedInstallation.a.REGISTER_ERROR;
    }

    public boolean i() {
        PersistedInstallation.a aVar = ((AutoValue_PersistedInstallationEntry) this).c;
        return aVar == PersistedInstallation.a.NOT_GENERATED || aVar == PersistedInstallation.a.ATTEMPT_MIGRATION;
    }

    public boolean j() {
        return f() == PersistedInstallation.a.REGISTERED;
    }

    @NonNull
    public abstract a k();
}
