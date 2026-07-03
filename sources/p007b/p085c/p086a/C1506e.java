package p007b.p085c.p086a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import p007b.p085c.p086a.p087a0.C1485t;
import p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c;
import p007b.p085c.p086a.p087a0.p088i0.C1474d;
import p007b.p085c.p086a.p089b0.C1499g;
import p007b.p085c.p086a.p095y.C1569h;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p615g0.C12397n;
import p615g0.C12401r;
import p615g0.C12408y;

/* JADX INFO: renamed from: b.c.a.e */
/* JADX INFO: compiled from: LottieCompositionFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class C1506e {

    /* JADX INFO: renamed from: a */
    public static final Map<String, C1519r<C1505d>> f2351a = new HashMap();

    /* JADX INFO: renamed from: b.c.a.e$a */
    /* JADX INFO: compiled from: LottieCompositionFactory.java */
    public class a implements InterfaceC1513l<C1505d> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ String f2352a;

        public a(String str) {
            this.f2352a = str;
        }

        @Override // p007b.p085c.p086a.InterfaceC1513l
        /* JADX INFO: renamed from: a */
        public void mo680a(C1505d c1505d) {
            C1506e.f2351a.remove(this.f2352a);
        }
    }

    /* JADX INFO: renamed from: b.c.a.e$b */
    /* JADX INFO: compiled from: LottieCompositionFactory.java */
    public class b implements InterfaceC1513l<Throwable> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ String f2353a;

        public b(String str) {
            this.f2353a = str;
        }

        @Override // p007b.p085c.p086a.InterfaceC1513l
        /* JADX INFO: renamed from: a */
        public void mo680a(Throwable th) {
            C1506e.f2351a.remove(this.f2353a);
        }
    }

    /* JADX INFO: renamed from: b.c.a.e$c */
    /* JADX INFO: compiled from: LottieCompositionFactory.java */
    public class c implements Callable<C1517p<C1505d>> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ C1505d f2354j;

        public c(C1505d c1505d) {
            this.f2354j = c1505d;
        }

        @Override // java.util.concurrent.Callable
        public C1517p<C1505d> call() throws Exception {
            return new C1517p<>(this.f2354j);
        }
    }

    /* JADX INFO: renamed from: a */
    public static C1519r<C1505d> m674a(@Nullable String str, Callable<C1517p<C1505d>> callable) {
        C1505d c1505d;
        if (str == null) {
            c1505d = null;
        } else {
            C1569h c1569h = C1569h.f2715a;
            Objects.requireNonNull(c1569h);
            c1505d = c1569h.f2716b.get(str);
        }
        if (c1505d != null) {
            return new C1519r<>(new c(c1505d));
        }
        if (str != null) {
            Map<String, C1519r<C1505d>> map = f2351a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        C1519r<C1505d> c1519r = new C1519r<>(callable);
        if (str != null) {
            c1519r.m706b(new a(str));
            c1519r.m705a(new b(str));
            f2351a.put(str, c1519r);
        }
        return c1519r;
    }

    @WorkerThread
    /* JADX INFO: renamed from: b */
    public static C1517p<C1505d> m675b(InputStream inputStream, @Nullable String str) {
        try {
            C12238m.checkParameterIsNotNull(inputStream, "$this$source");
            C12397n c12397n = new C12397n(inputStream, new C12408y());
            C12238m.checkParameterIsNotNull(c12397n, "$this$buffer");
            C12401r c12401r = new C12401r(c12397n);
            String[] strArr = AbstractC1473c.f2236j;
            return m676c(new C1474d(c12401r), str, true);
        } finally {
            C1499g.m658b(inputStream);
        }
    }

    /* JADX INFO: renamed from: c */
    public static C1517p<C1505d> m676c(AbstractC1473c abstractC1473c, @Nullable String str, boolean z2) {
        try {
            C1505d c1505dM635a = C1485t.m635a(abstractC1473c);
            if (str != null) {
                C1569h c1569h = C1569h.f2715a;
                Objects.requireNonNull(c1569h);
                c1569h.f2716b.put(str, c1505dM635a);
            }
            return new C1517p<>(c1505dM635a);
        } catch (Exception e) {
            return new C1517p<>((Throwable) e);
        } finally {
            if (z2) {
                C1499g.m658b(abstractC1473c);
            }
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: d */
    public static C1517p<C1505d> m677d(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return m678e(zipInputStream, str);
        } finally {
            C1499g.m658b(zipInputStream);
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: e */
    public static C1517p<C1505d> m678e(ZipInputStream zipInputStream, @Nullable String str) {
        C1512k next;
        HashMap map = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            C1505d c1505d = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    C12238m.checkParameterIsNotNull(zipInputStream, "$this$source");
                    C12397n c12397n = new C12397n(zipInputStream, new C12408y());
                    C12238m.checkParameterIsNotNull(c12397n, "$this$buffer");
                    C12401r c12401r = new C12401r(c12397n);
                    String[] strArr = AbstractC1473c.f2236j;
                    c1505d = m676c(new C1474d(c12401r), null, false).f2449a;
                } else if (name.contains(".png") || name.contains(".webp")) {
                    String[] strArrSplit = name.split(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
                    map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (c1505d == null) {
                return new C1517p<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                String str2 = (String) entry.getKey();
                Iterator<C1512k> it = c1505d.f2339d.values().iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!next.f2417d.equals(str2));
                if (next != null) {
                    next.f2418e = C1499g.m661e((Bitmap) entry.getValue(), next.f2414a, next.f2415b);
                }
            }
            for (Map.Entry<String, C1512k> entry2 : c1505d.f2339d.entrySet()) {
                if (entry2.getValue().f2418e == null) {
                    StringBuilder sbM833U = C1643a.m833U("There is no image for ");
                    sbM833U.append(entry2.getValue().f2417d);
                    return new C1517p<>((Throwable) new IllegalStateException(sbM833U.toString()));
                }
            }
            if (str != null) {
                C1569h c1569h = C1569h.f2715a;
                Objects.requireNonNull(c1569h);
                c1569h.f2716b.put(str, c1505d);
            }
            return new C1517p<>(c1505d);
        } catch (IOException e) {
            return new C1517p<>((Throwable) e);
        }
    }

    /* JADX INFO: renamed from: f */
    public static String m679f(Context context, @RawRes int i) {
        StringBuilder sbM833U = C1643a.m833U("rawRes");
        sbM833U.append((context.getResources().getConfiguration().uiMode & 48) == 32 ? "_night_" : "_day_");
        sbM833U.append(i);
        return sbM833U.toString();
    }
}
