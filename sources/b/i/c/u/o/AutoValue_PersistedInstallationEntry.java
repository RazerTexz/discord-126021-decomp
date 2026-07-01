package b.i.c.u.o;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.c.u.o.PersistedInstallation;
import b.i.c.u.o.PersistedInstallationEntry;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.c.u.o.a, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_PersistedInstallationEntry.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_PersistedInstallationEntry extends PersistedInstallationEntry {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1784b;
    public final PersistedInstallation.a c;
    public final String d;
    public final String e;
    public final long f;
    public final long g;
    public final String h;

    /* JADX INFO: renamed from: b.i.c.u.o.a$b */
    /* JADX INFO: compiled from: AutoValue_PersistedInstallationEntry.java */
    public static final class b extends PersistedInstallationEntry.a {
        public String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PersistedInstallation.a f1785b;
        public String c;
        public String d;
        public Long e;
        public Long f;
        public String g;

        public b() {
        }

        @Override // b.i.c.u.o.PersistedInstallationEntry.a
        public PersistedInstallationEntry a() {
            String strW = this.f1785b == null ? " registrationStatus" : "";
            if (this.e == null) {
                strW = outline.w(strW, " expiresInSecs");
            }
            if (this.f == null) {
                strW = outline.w(strW, " tokenCreationEpochInSecs");
            }
            if (strW.isEmpty()) {
                return new AutoValue_PersistedInstallationEntry(this.a, this.f1785b, this.c, this.d, this.e.longValue(), this.f.longValue(), this.g, null);
            }
            throw new IllegalStateException(outline.w("Missing required properties:", strW));
        }

        @Override // b.i.c.u.o.PersistedInstallationEntry.a
        public PersistedInstallationEntry.a b(PersistedInstallation.a aVar) {
            Objects.requireNonNull(aVar, "Null registrationStatus");
            this.f1785b = aVar;
            return this;
        }

        public PersistedInstallationEntry.a c(long j) {
            this.e = Long.valueOf(j);
            return this;
        }

        public PersistedInstallationEntry.a d(long j) {
            this.f = Long.valueOf(j);
            return this;
        }

        public b(PersistedInstallationEntry persistedInstallationEntry, a aVar) {
            AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry = (AutoValue_PersistedInstallationEntry) persistedInstallationEntry;
            this.a = autoValue_PersistedInstallationEntry.f1784b;
            this.f1785b = autoValue_PersistedInstallationEntry.c;
            this.c = autoValue_PersistedInstallationEntry.d;
            this.d = autoValue_PersistedInstallationEntry.e;
            this.e = Long.valueOf(autoValue_PersistedInstallationEntry.f);
            this.f = Long.valueOf(autoValue_PersistedInstallationEntry.g);
            this.g = autoValue_PersistedInstallationEntry.h;
        }
    }

    public AutoValue_PersistedInstallationEntry(String str, PersistedInstallation.a aVar, String str2, String str3, long j, long j2, String str4, a aVar2) {
        this.f1784b = str;
        this.c = aVar;
        this.d = str2;
        this.e = str3;
        this.f = j;
        this.g = j2;
        this.h = str4;
    }

    @Override // b.i.c.u.o.PersistedInstallationEntry
    @Nullable
    public String a() {
        return this.d;
    }

    @Override // b.i.c.u.o.PersistedInstallationEntry
    public long b() {
        return this.f;
    }

    @Override // b.i.c.u.o.PersistedInstallationEntry
    @Nullable
    public String c() {
        return this.f1784b;
    }

    @Override // b.i.c.u.o.PersistedInstallationEntry
    @Nullable
    public String d() {
        return this.h;
    }

    @Override // b.i.c.u.o.PersistedInstallationEntry
    @Nullable
    public String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedInstallationEntry)) {
            return false;
        }
        PersistedInstallationEntry persistedInstallationEntry = (PersistedInstallationEntry) obj;
        String str3 = this.f1784b;
        if (str3 != null ? str3.equals(persistedInstallationEntry.c()) : persistedInstallationEntry.c() == null) {
            if (this.c.equals(persistedInstallationEntry.f()) && ((str = this.d) != null ? str.equals(persistedInstallationEntry.a()) : persistedInstallationEntry.a() == null) && ((str2 = this.e) != null ? str2.equals(persistedInstallationEntry.e()) : persistedInstallationEntry.e() == null) && this.f == persistedInstallationEntry.b() && this.g == persistedInstallationEntry.g()) {
                String str4 = this.h;
                if (str4 == null) {
                    if (persistedInstallationEntry.d() == null) {
                        return true;
                    }
                } else if (str4.equals(persistedInstallationEntry.d())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // b.i.c.u.o.PersistedInstallationEntry
    @NonNull
    public PersistedInstallation.a f() {
        return this.c;
    }

    @Override // b.i.c.u.o.PersistedInstallationEntry
    public long g() {
        return this.g;
    }

    public int hashCode() {
        String str = this.f1784b;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.c.hashCode()) * 1000003;
        String str2 = this.d;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.e;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j = this.f;
        int i = (iHashCode3 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.g;
        int i2 = (i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        String str4 = this.h;
        return i2 ^ (str4 != null ? str4.hashCode() : 0);
    }

    @Override // b.i.c.u.o.PersistedInstallationEntry
    public PersistedInstallationEntry.a k() {
        return new b(this, null);
    }

    public String toString() {
        StringBuilder sbU = outline.U("PersistedInstallationEntry{firebaseInstallationId=");
        sbU.append(this.f1784b);
        sbU.append(", registrationStatus=");
        sbU.append(this.c);
        sbU.append(", authToken=");
        sbU.append(this.d);
        sbU.append(", refreshToken=");
        sbU.append(this.e);
        sbU.append(", expiresInSecs=");
        sbU.append(this.f);
        sbU.append(", tokenCreationEpochInSecs=");
        sbU.append(this.g);
        sbU.append(", fisError=");
        return outline.J(sbU, this.h, "}");
    }
}
