package b.c.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import b.c.a.a0.LottieCompositionMoshiParser;
import b.c.a.a0.i0.JsonReader2;
import b.c.a.a0.i0.JsonUtf8Reader;
import b.c.a.b0.Utils;
import b.c.a.y.LottieCompositionCache;
import b.d.b.a.outline;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import d0.z.d.Intrinsics3;
import g0.JvmOkio;
import g0.RealBufferedSource;
import g0.Timeout2;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: renamed from: b.c.a.e, reason: use source file name */
/* JADX INFO: compiled from: LottieCompositionFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class LottieCompositionFactory {
    public static final Map<String, LottieTask2<LottieComposition>> a = new HashMap();

    /* JADX INFO: renamed from: b.c.a.e$a */
    /* JADX INFO: compiled from: LottieCompositionFactory.java */
    public class a implements LottieListener<LottieComposition> {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // b.c.a.LottieListener
        public void a(LottieComposition lottieComposition) {
            LottieCompositionFactory.a.remove(this.a);
        }
    }

    /* JADX INFO: renamed from: b.c.a.e$b */
    /* JADX INFO: compiled from: LottieCompositionFactory.java */
    public class b implements LottieListener<Throwable> {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        @Override // b.c.a.LottieListener
        public void a(Throwable th) {
            LottieCompositionFactory.a.remove(this.a);
        }
    }

    /* JADX INFO: renamed from: b.c.a.e$c */
    /* JADX INFO: compiled from: LottieCompositionFactory.java */
    public class c implements Callable<LottieResult<LottieComposition>> {
        public final /* synthetic */ LottieComposition j;

        public c(LottieComposition lottieComposition) {
            this.j = lottieComposition;
        }

        @Override // java.util.concurrent.Callable
        public LottieResult<LottieComposition> call() throws Exception {
            return new LottieResult<>(this.j);
        }
    }

    public static LottieTask2<LottieComposition> a(@Nullable String str, Callable<LottieResult<LottieComposition>> callable) {
        LottieComposition lottieComposition;
        if (str == null) {
            lottieComposition = null;
        } else {
            LottieCompositionCache lottieCompositionCache = LottieCompositionCache.a;
            Objects.requireNonNull(lottieCompositionCache);
            lottieComposition = lottieCompositionCache.f409b.get(str);
        }
        if (lottieComposition != null) {
            return new LottieTask2<>(new c(lottieComposition));
        }
        if (str != null) {
            Map<String, LottieTask2<LottieComposition>> map = a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        LottieTask2<LottieComposition> lottieTask2 = new LottieTask2<>(callable);
        if (str != null) {
            lottieTask2.b(new a(str));
            lottieTask2.a(new b(str));
            a.put(str, lottieTask2);
        }
        return lottieTask2;
    }

    @WorkerThread
    public static LottieResult<LottieComposition> b(InputStream inputStream, @Nullable String str) {
        try {
            Intrinsics3.checkParameterIsNotNull(inputStream, "$this$source");
            JvmOkio jvmOkio = new JvmOkio(inputStream, new Timeout2());
            Intrinsics3.checkParameterIsNotNull(jvmOkio, "$this$buffer");
            RealBufferedSource realBufferedSource = new RealBufferedSource(jvmOkio);
            String[] strArr = JsonReader2.j;
            return c(new JsonUtf8Reader(realBufferedSource), str, true);
        } finally {
            Utils.b(inputStream);
        }
    }

    public static LottieResult<LottieComposition> c(JsonReader2 jsonReader2, @Nullable String str, boolean z2) {
        try {
            LottieComposition lottieCompositionA = LottieCompositionMoshiParser.a(jsonReader2);
            if (str != null) {
                LottieCompositionCache lottieCompositionCache = LottieCompositionCache.a;
                Objects.requireNonNull(lottieCompositionCache);
                lottieCompositionCache.f409b.put(str, lottieCompositionA);
            }
            return new LottieResult<>(lottieCompositionA);
        } catch (Exception e) {
            return new LottieResult<>((Throwable) e);
        } finally {
            if (z2) {
                Utils.b(jsonReader2);
            }
        }
    }

    @WorkerThread
    public static LottieResult<LottieComposition> d(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return e(zipInputStream, str);
        } finally {
            Utils.b(zipInputStream);
        }
    }

    @WorkerThread
    public static LottieResult<LottieComposition> e(ZipInputStream zipInputStream, @Nullable String str) {
        LottieImageAsset next;
        HashMap map = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            LottieComposition lottieComposition = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    Intrinsics3.checkParameterIsNotNull(zipInputStream, "$this$source");
                    JvmOkio jvmOkio = new JvmOkio(zipInputStream, new Timeout2());
                    Intrinsics3.checkParameterIsNotNull(jvmOkio, "$this$buffer");
                    RealBufferedSource realBufferedSource = new RealBufferedSource(jvmOkio);
                    String[] strArr = JsonReader2.j;
                    lottieComposition = c(new JsonUtf8Reader(realBufferedSource), null, false).a;
                } else if (name.contains(".png") || name.contains(".webp")) {
                    String[] strArrSplit = name.split(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
                    map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (lottieComposition == null) {
                return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                String str2 = (String) entry.getKey();
                Iterator<LottieImageAsset> it = lottieComposition.d.values().iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!next.d.equals(str2));
                if (next != null) {
                    next.e = Utils.e((Bitmap) entry.getValue(), next.a, next.f367b);
                }
            }
            for (Map.Entry<String, LottieImageAsset> entry2 : lottieComposition.d.entrySet()) {
                if (entry2.getValue().e == null) {
                    StringBuilder sbU = outline.U("There is no image for ");
                    sbU.append(entry2.getValue().d);
                    return new LottieResult<>((Throwable) new IllegalStateException(sbU.toString()));
                }
            }
            if (str != null) {
                LottieCompositionCache lottieCompositionCache = LottieCompositionCache.a;
                Objects.requireNonNull(lottieCompositionCache);
                lottieCompositionCache.f409b.put(str, lottieComposition);
            }
            return new LottieResult<>(lottieComposition);
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    public static String f(Context context, @RawRes int i) {
        StringBuilder sbU = outline.U("rawRes");
        sbU.append((context.getResources().getConfiguration().uiMode & 48) == 32 ? "_night_" : "_day_");
        sbU.append(i);
        return sbU.toString();
    }
}
