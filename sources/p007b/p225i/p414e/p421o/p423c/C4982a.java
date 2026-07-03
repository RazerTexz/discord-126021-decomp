package p007b.p225i.p414e.p421o.p423c;

import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.google.zxing.NotFoundException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p414e.C4956k;
import p007b.p225i.p414e.p418n.C4963b;
import p007b.p225i.p414e.p418n.C4967f;
import p007b.p225i.p414e.p418n.C4970i;
import p007b.p225i.p414e.p418n.p419k.C4972a;

/* JADX INFO: renamed from: b.i.e.o.c.a */
/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4982a {

    /* JADX INFO: renamed from: a */
    public final C4963b f13342a;

    /* JADX INFO: renamed from: b */
    public final C4972a f13343b;

    /* JADX INFO: renamed from: b.i.e.o.c.a$b */
    /* JADX INFO: compiled from: Detector.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final C4956k f13344a;

        /* JADX INFO: renamed from: b */
        public final C4956k f13345b;

        /* JADX INFO: renamed from: c */
        public final int f13346c;

        public b(C4956k c4956k, C4956k c4956k2, int i, a aVar) {
            this.f13344a = c4956k;
            this.f13345b = c4956k2;
            this.f13346c = i;
        }

        public String toString() {
            return this.f13344a + AutocompleteViewModel.COMMAND_DISCOVER_TOKEN + this.f13345b + MentionUtilsKt.SLASH_CHAR + this.f13346c;
        }
    }

    /* JADX INFO: renamed from: b.i.e.o.c.a$c */
    /* JADX INFO: compiled from: Detector.java */
    public static final class c implements Serializable, Comparator<b> {
        public c(a aVar) {
        }

        @Override // java.util.Comparator
        public int compare(b bVar, b bVar2) {
            return bVar.f13346c - bVar2.f13346c;
        }
    }

    public C4982a(C4963b c4963b) throws NotFoundException {
        this.f13342a = c4963b;
        this.f13343b = new C4972a(c4963b, 10, c4963b.f13229j / 2, c4963b.f13230k / 2);
    }

    /* JADX INFO: renamed from: a */
    public static int m6974a(C4956k c4956k, C4956k c4956k2) {
        return C3404f.m4265Z0(C3404f.m4237Q(c4956k.f13207a, c4956k.f13208b, c4956k2.f13207a, c4956k2.f13208b));
    }

    /* JADX INFO: renamed from: b */
    public static void m6975b(Map<C4956k, Integer> map, C4956k c4956k) {
        Integer num = map.get(c4956k);
        map.put(c4956k, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    /* JADX INFO: renamed from: d */
    public static C4963b m6976d(C4963b c4963b, C4956k c4956k, C4956k c4956k2, C4956k c4956k3, C4956k c4956k4, int i, int i2) throws NotFoundException {
        float f = i - 0.5f;
        float f2 = i2 - 0.5f;
        return C4967f.f13274a.m6951a(c4963b, i, i2, C4970i.m6954a(0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, c4956k.f13207a, c4956k.f13208b, c4956k4.f13207a, c4956k4.f13208b, c4956k3.f13207a, c4956k3.f13208b, c4956k2.f13207a, c4956k2.f13208b));
    }

    /* JADX INFO: renamed from: c */
    public final boolean m6977c(C4956k c4956k) {
        float f = c4956k.f13207a;
        if (f < 0.0f) {
            return false;
        }
        C4963b c4963b = this.f13342a;
        if (f >= c4963b.f13229j) {
            return false;
        }
        float f2 = c4956k.f13208b;
        return f2 > 0.0f && f2 < ((float) c4963b.f13230k);
    }

    /* JADX INFO: renamed from: e */
    public final b m6978e(C4956k c4956k, C4956k c4956k2) {
        C4982a c4982a = this;
        int i = (int) c4956k.f13207a;
        int i2 = (int) c4956k.f13208b;
        int i3 = (int) c4956k2.f13207a;
        int i4 = (int) c4956k2.f13208b;
        boolean z2 = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z2) {
            i2 = i;
            i = i2;
            i4 = i3;
            i3 = i4;
        }
        int iAbs = Math.abs(i3 - i);
        int iAbs2 = Math.abs(i4 - i2);
        int i5 = (-iAbs) / 2;
        int i6 = i2 < i4 ? 1 : -1;
        int i7 = i >= i3 ? -1 : 1;
        boolean zM6942f = c4982a.f13342a.m6942f(z2 ? i2 : i, z2 ? i : i2);
        int i8 = 0;
        while (i != i3) {
            boolean zM6942f2 = c4982a.f13342a.m6942f(z2 ? i2 : i, z2 ? i : i2);
            if (zM6942f2 != zM6942f) {
                i8++;
                zM6942f = zM6942f2;
            }
            i5 += iAbs2;
            if (i5 > 0) {
                if (i2 == i4) {
                    break;
                }
                i2 += i6;
                i5 -= iAbs;
            }
            i += i7;
            c4982a = this;
        }
        return new b(c4956k, c4956k2, i8, null);
    }
}
