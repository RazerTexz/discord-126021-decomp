package b.i.c.j.a;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import b.i.a.f.h.l.b0;
import b.i.a.f.h.l.g;
import b.i.c.j.a.c.c;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class b implements a {
    public static volatile a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.f.i.a.a f1656b;
    public final Map<String, ?> c;

    public b(b.i.a.f.i.a.a aVar) {
        Objects.requireNonNull(aVar, "null reference");
        this.f1656b = aVar;
        this.c = new ConcurrentHashMap();
    }

    @Override // b.i.c.j.a.a
    public void a(@NonNull String str, @NonNull String str2, Bundle bundle) {
        boolean z2;
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        if (c.a(str)) {
            boolean z3 = false;
            if (!c.f1658b.contains(str2)) {
                Iterator<String> it = c.d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = true;
                        break;
                    } else if (bundle2.containsKey(it.next())) {
                        z2 = false;
                        break;
                    }
                }
            } else {
                z2 = false;
                break;
            }
            if (z2) {
                if (!"_cmp".equals(str2)) {
                    z3 = true;
                    break;
                }
                if (c.a(str)) {
                    Iterator<String> it2 = c.d.iterator();
                    do {
                        if (!it2.hasNext()) {
                            byte b2 = -1;
                            int iHashCode = str.hashCode();
                            if (iHashCode != 101200) {
                                if (iHashCode != 101230) {
                                    if (iHashCode == 3142703 && str.equals("fiam")) {
                                        b2 = 2;
                                    }
                                } else if (str.equals("fdl")) {
                                    b2 = 1;
                                }
                            } else if (str.equals("fcm")) {
                                b2 = 0;
                            }
                            if (b2 == 0) {
                                bundle2.putString("_cis", "fcm_integration");
                            } else if (b2 == 1) {
                                bundle2.putString("_cis", "fdl_integration");
                            } else if (b2 != 2) {
                                break;
                            } else {
                                bundle2.putString("_cis", "fiam_integration");
                            }
                            z3 = true;
                            break;
                        }
                    } while (!bundle2.containsKey(it2.next()));
                }
                if (z3) {
                    if ("clx".equals(str) && "_ae".equals(str2)) {
                        bundle2.putLong("_r", 1L);
                    }
                    this.f1656b.a.c(str, str2, bundle2, true, true, null);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0063  */
    @Override // b.i.c.j.a.a
    public void b(@NonNull String str, @NonNull String str2, Object obj) {
        if (c.a(str)) {
            boolean z2 = true;
            if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
                if (!str.equals("fcm") && !str.equals("frc")) {
                    z2 = false;
                    break;
                }
            } else if ("_ln".equals(str2)) {
                if (!str.equals("fcm") && !str.equals("fiam")) {
                    z2 = false;
                    break;
                }
            } else {
                if (c.e.contains(str2)) {
                    z2 = false;
                    break;
                }
                Iterator<String> it = c.f.iterator();
                while (it.hasNext()) {
                    if (str2.matches(it.next())) {
                        z2 = false;
                        break;
                    }
                }
            }
            if (z2) {
                g gVar = this.f1656b.a;
                Objects.requireNonNull(gVar);
                gVar.e.execute(new b0(gVar, str, str2, obj, true));
            }
        }
    }

    @Override // b.i.c.j.a.a
    @WorkerThread
    public a$a c(@NonNull String str, a$b a_b) {
        Object dVar;
        Objects.requireNonNull(a_b, "null reference");
        if (!c.a(str)) {
            return null;
        }
        if ((str.isEmpty() || !this.c.containsKey(str) || this.c.get(str) == null) ? false : true) {
            return null;
        }
        b.i.a.f.i.a.a aVar = this.f1656b;
        if ("fiam".equals(str)) {
            dVar = new b.i.c.j.a.c.b(aVar, a_b);
        } else {
            dVar = ("crash".equals(str) || "clx".equals(str)) ? new b.i.c.j.a.c.d(aVar, a_b) : null;
        }
        if (dVar == null) {
            return null;
        }
        this.c.put(str, dVar);
        return new b$a(this, str);
    }
}
