package b.o.a;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: renamed from: b.o.a.b, reason: use source file name */
/* JADX INFO: compiled from: CameraLogger.java */
/* JADX INFO: loaded from: classes3.dex */
public final class CameraLogger {
    public static int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Set<b> f1910b;

    @VisibleForTesting
    public static b c;

    @NonNull
    public String d;

    /* JADX INFO: renamed from: b.o.a.b$a */
    /* JADX INFO: compiled from: CameraLogger.java */
    public class a implements b {
        @Override // b.o.a.CameraLogger.b
        public void a(int i, @NonNull String str, @NonNull String str2, @Nullable Throwable th) {
            if (i == 0) {
                Log.v(str, str2, th);
                return;
            }
            if (i == 1) {
                Log.i(str, str2, th);
            } else if (i == 2) {
                Log.w(str, str2, th);
            } else {
                if (i != 3) {
                    return;
                }
                Log.e(str, str2, th);
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.b$b */
    /* JADX INFO: compiled from: CameraLogger.java */
    public interface b {
        void a(int i, @NonNull String str, @NonNull String str2, @Nullable Throwable th);
    }

    static {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        f1910b = copyOnWriteArraySet;
        a aVar = new a();
        c = aVar;
        a = 3;
        copyOnWriteArraySet.add(aVar);
    }

    public CameraLogger(@NonNull String str) {
        this.d = str;
    }

    @Nullable
    public final String a(int i, @NonNull Object... objArr) {
        Throwable th = null;
        if (!(a <= i && f1910b.size() > 0)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj instanceof Throwable) {
                th = (Throwable) obj;
            }
            sb.append(String.valueOf(obj));
            sb.append(" ");
        }
        String strTrim = sb.toString().trim();
        Iterator<b> it = f1910b.iterator();
        while (it.hasNext()) {
            it.next().a(i, this.d, strTrim, th);
        }
        return strTrim;
    }
}
