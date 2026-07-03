package p007b.p452o.p453a;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: renamed from: b.o.a.b */
/* JADX INFO: compiled from: CameraLogger.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5103b {

    /* JADX INFO: renamed from: a */
    public static int f13678a;

    /* JADX INFO: renamed from: b */
    public static Set<b> f13679b;

    /* JADX INFO: renamed from: c */
    @VisibleForTesting
    public static b f13680c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public String f13681d;

    /* JADX INFO: renamed from: b.o.a.b$a */
    /* JADX INFO: compiled from: CameraLogger.java */
    public class a implements b {
        @Override // p007b.p452o.p453a.C5103b.b
        /* JADX INFO: renamed from: a */
        public void mo7160a(int i, @NonNull String str, @NonNull String str2, @Nullable Throwable th) {
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
        /* JADX INFO: renamed from: a */
        void mo7160a(int i, @NonNull String str, @NonNull String str2, @Nullable Throwable th);
    }

    static {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        f13679b = copyOnWriteArraySet;
        a aVar = new a();
        f13680c = aVar;
        f13678a = 3;
        copyOnWriteArraySet.add(aVar);
    }

    public C5103b(@NonNull String str) {
        this.f13681d = str;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public final String m7159a(int i, @NonNull Object... objArr) {
        Throwable th = null;
        if (!(f13678a <= i && f13679b.size() > 0)) {
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
        Iterator<b> it = f13679b.iterator();
        while (it.hasNext()) {
            it.next().mo7160a(i, this.f13681d, strTrim, th);
        }
        return strTrim;
    }
}
