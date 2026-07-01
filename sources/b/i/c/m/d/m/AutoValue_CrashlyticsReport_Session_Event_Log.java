package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import b.d.b.a.outline;
import b.i.c.m.d.m.CrashlyticsReport;

/* JADX INFO: renamed from: b.i.c.m.d.m.s, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Log.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_Event_Log extends CrashlyticsReport.d.AbstractC0049d.c {
    public final String a;

    public AutoValue_CrashlyticsReport_Session_Event_Log(String str, a aVar) {
        this.a = str;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.c
    @NonNull
    public String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.d.AbstractC0049d.c) {
            return this.a.equals(((CrashlyticsReport.d.AbstractC0049d.c) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return outline.J(outline.U("Log{content="), this.a, "}");
    }
}
