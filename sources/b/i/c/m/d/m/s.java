package b.i.c.m.d.m;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Log.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends v$d$d$c {
    public final String a;

    public s(String str, s$a s_a) {
        this.a = str;
    }

    @Override // b.i.c.m.d.m.v$d$d$c
    @NonNull
    public String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v$d$d$c) {
            return this.a.equals(((v$d$d$c) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return b.d.b.a.a.J(b.d.b.a.a.U("Log{content="), this.a, "}");
    }
}
