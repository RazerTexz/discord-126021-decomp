package b.c.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import g0.y;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: LottieCompositionFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public static final Map<String, r<d>> a = new HashMap();

    public static r<d> a(@Nullable String str, Callable<p<d>> callable) {
        d dVar;
        if (str == null) {
            dVar = null;
        } else {
            b.c.a.y.h hVar = b.c.a.y.h.a;
            Objects.requireNonNull(hVar);
            dVar = hVar.f409b.get(str);
        }
        if (dVar != null) {
            return new r<>(new e$c(dVar));
        }
        if (str != null) {
            Map<String, r<d>> map = a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        r<d> rVar = new r<>(callable);
        if (str != null) {
            rVar.b(new e$a(str));
            rVar.a(new e$b(str));
            a.put(str, rVar);
        }
        return rVar;
    }

    @WorkerThread
    public static p<d> b(InputStream inputStream, @Nullable String str) {
        try {
            d0.z.d.m.checkParameterIsNotNull(inputStream, "$this$source");
            g0.n nVar = new g0.n(inputStream, new y());
            d0.z.d.m.checkParameterIsNotNull(nVar, "$this$buffer");
            g0.r rVar = new g0.r(nVar);
            String[] strArr = b.c.a.a0.i0.c.j;
            return c(new b.c.a.a0.i0.d(rVar), str, true);
        } finally {
            b.c.a.b0.g.b(inputStream);
        }
    }

    public static p<d> c(b.c.a.a0.i0.c cVar, @Nullable String str, boolean z2) {
        try {
            d dVarA = b.c.a.a0.t.a(cVar);
            if (str != null) {
                b.c.a.y.h hVar = b.c.a.y.h.a;
                Objects.requireNonNull(hVar);
                hVar.f409b.put(str, dVarA);
            }
            return new p<>(dVarA);
        } catch (Exception e) {
            return new p<>((Throwable) e);
        } finally {
            if (z2) {
                b.c.a.b0.g.b(cVar);
            }
        }
    }

    @WorkerThread
    public static p<d> d(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return e(zipInputStream, str);
        } finally {
            b.c.a.b0.g.b(zipInputStream);
        }
    }

    @WorkerThread
    public static p<d> e(ZipInputStream zipInputStream, @Nullable String str) {
        k next;
        HashMap map = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            d dVar = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    d0.z.d.m.checkParameterIsNotNull(zipInputStream, "$this$source");
                    g0.n nVar = new g0.n(zipInputStream, new y());
                    d0.z.d.m.checkParameterIsNotNull(nVar, "$this$buffer");
                    g0.r rVar = new g0.r(nVar);
                    String[] strArr = b.c.a.a0.i0.c.j;
                    dVar = c(new b.c.a.a0.i0.d(rVar), null, false).a;
                } else if (name.contains(".png") || name.contains(".webp")) {
                    String[] strArrSplit = name.split(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
                    map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (dVar == null) {
                return new p<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map$Entry map$Entry : map.entrySet()) {
                String str2 = (String) map$Entry.getKey();
                Iterator<k> it = dVar.d.values().iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!next.d.equals(str2));
                if (next != null) {
                    next.e = b.c.a.b0.g.e((Bitmap) map$Entry.getValue(), next.a, next.f367b);
                }
            }
            for (Map$Entry<String, k> map$Entry2 : dVar.d.entrySet()) {
                if (map$Entry2.getValue().e == null) {
                    StringBuilder sbU = b.d.b.a.a.U("There is no image for ");
                    sbU.append(map$Entry2.getValue().d);
                    return new p<>((Throwable) new IllegalStateException(sbU.toString()));
                }
            }
            if (str != null) {
                b.c.a.y.h hVar = b.c.a.y.h.a;
                Objects.requireNonNull(hVar);
                hVar.f409b.put(str, dVar);
            }
            return new p<>(dVar);
        } catch (IOException e) {
            return new p<>((Throwable) e);
        }
    }

    public static String f(Context context, @RawRes int i) {
        StringBuilder sbU = b.d.b.a.a.U("rawRes");
        sbU.append((context.getResources().getConfiguration().uiMode & 48) == 32 ? "_night_" : "_day_");
        sbU.append(i);
        return sbU.toString();
    }
}
