package p007b.p225i.p361c.p401u.p402o;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.c.u.o.d */
/* JADX INFO: compiled from: PersistedInstallationEntry.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class AbstractC4854d {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f12977a = 0;

    /* JADX INFO: renamed from: b.i.c.u.o.d$a */
    /* JADX INFO: compiled from: PersistedInstallationEntry.java */
    @AutoValue.Builder
    public static abstract class a {
        @NonNull
        /* JADX INFO: renamed from: a */
        public abstract AbstractC4854d mo6782a();

        @NonNull
        /* JADX INFO: renamed from: b */
        public abstract a mo6783b(@NonNull C4853c.a aVar);
    }

    static {
        Long l = 0L;
        String strM883w = l == null ? " expiresInSecs" : "";
        if (l == null) {
            strM883w = C1643a.m883w(strM883w, " tokenCreationEpochInSecs");
        }
        if (!strM883w.isEmpty()) {
            throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w));
        }
        l.longValue();
        l.longValue();
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public abstract String mo6774a();

    /* JADX INFO: renamed from: b */
    public abstract long mo6775b();

    @Nullable
    /* JADX INFO: renamed from: c */
    public abstract String mo6776c();

    @Nullable
    /* JADX INFO: renamed from: d */
    public abstract String mo6777d();

    @Nullable
    /* JADX INFO: renamed from: e */
    public abstract String mo6778e();

    @NonNull
    /* JADX INFO: renamed from: f */
    public abstract C4853c.a mo6779f();

    /* JADX INFO: renamed from: g */
    public abstract long mo6780g();

    /* JADX INFO: renamed from: h */
    public boolean m6789h() {
        return mo6779f() == C4853c.a.REGISTER_ERROR;
    }

    /* JADX INFO: renamed from: i */
    public boolean m6790i() {
        C4853c.a aVar = ((C4851a) this).f12953c;
        return aVar == C4853c.a.NOT_GENERATED || aVar == C4853c.a.ATTEMPT_MIGRATION;
    }

    /* JADX INFO: renamed from: j */
    public boolean m6791j() {
        return mo6779f() == C4853c.a.REGISTERED;
    }

    @NonNull
    /* JADX INFO: renamed from: k */
    public abstract a mo6781k();
}
