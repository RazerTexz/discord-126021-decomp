package p007b.p225i.p226a.p228b.p231j;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import java.util.HashMap;
import java.util.Map;
import p007b.p225i.p226a.p228b.p231j.C2434a;

/* JADX INFO: renamed from: b.i.a.b.j.f */
/* JADX INFO: compiled from: EventInternal.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class AbstractC2439f {

    /* JADX INFO: renamed from: b.i.a.b.j.f$a */
    /* JADX INFO: compiled from: EventInternal.java */
    @AutoValue.Builder
    public static abstract class a {
        /* JADX INFO: renamed from: a */
        public final a m2357a(String str, String str2) {
            mo2343c().put(str, str2);
            return this;
        }

        /* JADX INFO: renamed from: b */
        public abstract AbstractC2439f mo2342b();

        /* JADX INFO: renamed from: c */
        public abstract Map<String, String> mo2343c();
    }

    /* JADX INFO: renamed from: a */
    public final String m2354a(String str) {
        String str2 = mo2336b().get(str);
        return str2 == null ? "" : str2;
    }

    /* JADX INFO: renamed from: b */
    public abstract Map<String, String> mo2336b();

    @Nullable
    /* JADX INFO: renamed from: c */
    public abstract Integer mo2337c();

    /* JADX INFO: renamed from: d */
    public abstract C2438e mo2338d();

    /* JADX INFO: renamed from: e */
    public abstract long mo2339e();

    /* JADX INFO: renamed from: f */
    public final int m2355f(String str) {
        String str2 = mo2336b().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    /* JADX INFO: renamed from: g */
    public abstract String mo2340g();

    /* JADX INFO: renamed from: h */
    public abstract long mo2341h();

    /* JADX INFO: renamed from: i */
    public a m2356i() {
        C2434a.b bVar = new C2434a.b();
        bVar.m2346f(mo2340g());
        bVar.f5253b = mo2337c();
        bVar.m2344d(mo2338d());
        bVar.m2345e(mo2339e());
        bVar.m2347g(mo2341h());
        bVar.f5257f = new HashMap(mo2336b());
        return bVar;
    }
}
