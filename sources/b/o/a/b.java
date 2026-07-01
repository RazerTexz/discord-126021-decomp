package b.o.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: CameraLogger.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Set<b$b> f1910b;

    @VisibleForTesting
    public static b$b c;

    @NonNull
    public String d;

    static {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        f1910b = copyOnWriteArraySet;
        b$a b_a = new b$a();
        c = b_a;
        a = 3;
        copyOnWriteArraySet.add(b_a);
    }

    public b(@NonNull String str) {
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
        Iterator<b$b> it = f1910b.iterator();
        while (it.hasNext()) {
            it.next().a(i, this.d, strTrim, th);
        }
        return strTrim;
    }
}
