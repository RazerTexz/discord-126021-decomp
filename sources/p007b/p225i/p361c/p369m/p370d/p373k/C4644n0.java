package p007b.p225i.p361c.p369m.p370d.p373k;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v;
import p007b.p225i.p361c.p369m.p370d.p375m.C4687n;
import p007b.p225i.p361c.p369m.p370d.p375m.C4689p;
import p007b.p225i.p361c.p369m.p370d.p375m.C4690q;
import p007b.p225i.p361c.p369m.p370d.p375m.C4696w;
import p007b.p225i.p361c.p369m.p370d.p387t.C4756e;
import p007b.p225i.p361c.p369m.p370d.p387t.InterfaceC4755d;

/* JADX INFO: renamed from: b.i.c.m.d.k.n0 */
/* JADX INFO: compiled from: CrashlyticsReportDataCapture.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4644n0 {

    /* JADX INFO: renamed from: a */
    public static final String f12353a = String.format(Locale.US, "Crashlytics Android SDK/%s", "17.3.0");

    /* JADX INFO: renamed from: b */
    public static final Map<String, Integer> f12354b;

    /* JADX INFO: renamed from: c */
    public final Context f12355c;

    /* JADX INFO: renamed from: d */
    public final C4660v0 f12356d;

    /* JADX INFO: renamed from: e */
    public final C4610b f12357e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC4755d f12358f;

    static {
        HashMap map = new HashMap();
        f12354b = map;
        C1643a.m858j0(5, map, "armeabi", 6, "armeabi-v7a", 9, "arm64-v8a", 0, "x86");
        map.put("x86_64", 1);
    }

    public C4644n0(Context context, C4660v0 c4660v0, C4610b c4610b, InterfaceC4755d interfaceC4755d) {
        this.f12355c = context;
        this.f12356d = c4660v0;
        this.f12357e = c4610b;
        this.f12358f = interfaceC4755d;
    }

    /* JADX INFO: renamed from: a */
    public final AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13236b m6446a(C4756e c4756e, int i, int i2, int i3) {
        String str = c4756e.f12778b;
        String str2 = c4756e.f12777a;
        StackTraceElement[] stackTraceElementArr = c4756e.f12779c;
        int i4 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        C4756e c4756e2 = c4756e.f12780d;
        if (i3 >= i2) {
            C4756e c4756e3 = c4756e2;
            while (c4756e3 != null) {
                c4756e3 = c4756e3.f12780d;
                i4++;
            }
        }
        AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13236b abstractC13236bM6446a = null;
        Objects.requireNonNull(str, "Null type");
        C4696w c4696w = new C4696w(m6447b(stackTraceElementArr, i));
        Integer numValueOf = Integer.valueOf(i4);
        if (c4756e2 != null && i4 == 0) {
            abstractC13236bM6446a = m6446a(c4756e2, i, i2, i3 + 1);
        }
        String str3 = numValueOf == null ? " overflowCount" : "";
        if (str3.isEmpty()) {
            return new C4687n(str, str2, c4696w, abstractC13236bM6446a, numValueOf.intValue(), null);
        }
        throw new IllegalStateException(C1643a.m883w("Missing required properties:", str3));
    }

    /* JADX INFO: renamed from: b */
    public final C4696w<AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a> m6447b(StackTraceElement[] stackTraceElementArr, int i) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            C4690q.b bVar = new C4690q.b();
            bVar.f12628e = Integer.valueOf(i);
            long lineNumber = 0;
            long jMax = stackTraceElement.isNativeMethod() ? Math.max(stackTraceElement.getLineNumber(), 0L) : 0L;
            String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
            String fileName = stackTraceElement.getFileName();
            if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
                lineNumber = stackTraceElement.getLineNumber();
            }
            bVar.f12624a = Long.valueOf(jMax);
            Objects.requireNonNull(str, "Null symbol");
            bVar.f12625b = str;
            bVar.f12626c = fileName;
            bVar.f12627d = Long.valueOf(lineNumber);
            arrayList.add(bVar.m6598a());
        }
        return new C4696w<>(arrayList);
    }

    /* JADX INFO: renamed from: c */
    public final AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d m6448c(Thread thread, StackTraceElement[] stackTraceElementArr, int i) {
        String name = thread.getName();
        Objects.requireNonNull(name, "Null name");
        Integer numValueOf = Integer.valueOf(i);
        C4696w c4696w = new C4696w(m6447b(stackTraceElementArr, i));
        String str = numValueOf == null ? " importance" : "";
        if (str.isEmpty()) {
            return new C4689p(name, numValueOf.intValue(), c4696w, null);
        }
        throw new IllegalStateException(C1643a.m883w("Missing required properties:", str));
    }
}
