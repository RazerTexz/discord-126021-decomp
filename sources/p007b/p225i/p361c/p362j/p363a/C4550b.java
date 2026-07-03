package p007b.p225i.p361c.p362j.p363a;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import p007b.p225i.p226a.p288f.p313h.p325l.C3592b0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;
import p007b.p225i.p226a.p288f.p330i.p331a.C3967a;
import p007b.p225i.p361c.p362j.p363a.InterfaceC4549a;
import p007b.p225i.p361c.p362j.p363a.p364c.C4552b;
import p007b.p225i.p361c.p362j.p363a.p364c.C4553c;
import p007b.p225i.p361c.p362j.p363a.p364c.C4554d;

/* JADX INFO: renamed from: b.i.c.j.a.b */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C4550b implements InterfaceC4549a {

    /* JADX INFO: renamed from: a */
    public static volatile InterfaceC4549a f12141a;

    /* JADX INFO: renamed from: b */
    public final C3967a f12142b;

    /* JADX INFO: renamed from: c */
    public final Map<String, ?> f12143c;

    /* JADX INFO: renamed from: b.i.c.j.a.b$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
    public class a implements InterfaceC4549a.a {
        public a(C4550b c4550b, String str) {
        }
    }

    public C4550b(C3967a c3967a) {
        Objects.requireNonNull(c3967a, "null reference");
        this.f12142b = c3967a;
        this.f12143c = new ConcurrentHashMap();
    }

    @Override // p007b.p225i.p361c.p362j.p363a.InterfaceC4549a
    /* JADX INFO: renamed from: a */
    public void mo6338a(@NonNull String str, @NonNull String str2, Bundle bundle) {
        boolean z2;
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        if (C4553c.m6342a(str)) {
            boolean z3 = false;
            if (!C4553c.f12150b.contains(str2)) {
                Iterator<String> it = C4553c.f12152d.iterator();
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
                if (C4553c.m6342a(str)) {
                    Iterator<String> it2 = C4553c.f12152d.iterator();
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
                    this.f12142b.f10500a.m4886c(str, str2, bundle2, true, true, null);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0063  */
    @Override // p007b.p225i.p361c.p362j.p363a.InterfaceC4549a
    /* JADX INFO: renamed from: b */
    public void mo6339b(@NonNull String str, @NonNull String str2, Object obj) {
        if (C4553c.m6342a(str)) {
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
                if (C4553c.f12153e.contains(str2)) {
                    z2 = false;
                    break;
                }
                Iterator<String> it = C4553c.f12154f.iterator();
                while (it.hasNext()) {
                    if (str2.matches(it.next())) {
                        z2 = false;
                        break;
                    }
                }
            }
            if (z2) {
                C3661g c3661g = this.f12142b.f10500a;
                Objects.requireNonNull(c3661g);
                c3661g.f9950e.execute(new C3592b0(c3661g, str, str2, obj, true));
            }
        }
    }

    @Override // p007b.p225i.p361c.p362j.p363a.InterfaceC4549a
    @WorkerThread
    /* JADX INFO: renamed from: c */
    public InterfaceC4549a.a mo6340c(@NonNull String str, InterfaceC4549a.b bVar) {
        Object c4554d;
        Objects.requireNonNull(bVar, "null reference");
        if (!C4553c.m6342a(str)) {
            return null;
        }
        if ((str.isEmpty() || !this.f12143c.containsKey(str) || this.f12143c.get(str) == null) ? false : true) {
            return null;
        }
        C3967a c3967a = this.f12142b;
        if ("fiam".equals(str)) {
            c4554d = new C4552b(c3967a, bVar);
        } else {
            c4554d = ("crash".equals(str) || "clx".equals(str)) ? new C4554d(c3967a, bVar) : null;
        }
        if (c4554d == null) {
            return null;
        }
        this.f12143c.put(str, c4554d);
        return new a(this, str);
    }
}
