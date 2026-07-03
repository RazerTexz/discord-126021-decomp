package p007b.p225i.p361c.p401u;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import p007b.p225i.p361c.p401u.p402o.AbstractC4854d;
import p007b.p225i.p361c.p401u.p404q.C4861a;

/* JADX INFO: renamed from: b.i.c.u.n */
/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4850n {

    /* JADX INFO: renamed from: a */
    public static final long f12948a = TimeUnit.HOURS.toSeconds(1);

    /* JADX INFO: renamed from: b */
    public static final Pattern f12949b = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* JADX INFO: renamed from: c */
    public static C4850n f12950c;

    /* JADX INFO: renamed from: d */
    public final C4861a f12951d;

    public C4850n(C4861a c4861a) {
        this.f12951d = c4861a;
    }

    /* JADX INFO: renamed from: c */
    public static C4850n m6770c() {
        if (C4861a.f13007a == null) {
            C4861a.f13007a = new C4861a();
        }
        C4861a c4861a = C4861a.f13007a;
        if (f12950c == null) {
            f12950c = new C4850n(c4861a);
        }
        return f12950c;
    }

    /* JADX INFO: renamed from: a */
    public long m6771a() {
        Objects.requireNonNull(this.f12951d);
        return System.currentTimeMillis();
    }

    /* JADX INFO: renamed from: b */
    public long m6772b() {
        return TimeUnit.MILLISECONDS.toSeconds(m6771a());
    }

    /* JADX INFO: renamed from: d */
    public boolean m6773d(@NonNull AbstractC4854d abstractC4854d) {
        if (TextUtils.isEmpty(abstractC4854d.mo6774a())) {
            return true;
        }
        return abstractC4854d.mo6775b() + abstractC4854d.mo6780g() < m6772b() + f12948a;
    }
}
