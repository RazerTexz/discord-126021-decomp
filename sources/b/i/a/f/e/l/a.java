package b.i.a.f.e.l;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import b.i.a.f.e.k.f;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1394b;
    public final int c;

    public a(@RecentlyNonNull String str, @RecentlyNonNull String... strArr) {
        String string;
        if (strArr.length == 0) {
            string = "";
        } else {
            StringBuilder sbQ = b.d.b.a.a.Q('[');
            for (String str2 : strArr) {
                if (sbQ.length() > 1) {
                    sbQ.append(",");
                }
                sbQ.append(str2);
            }
            sbQ.append("] ");
            string = sbQ.toString();
        }
        this.f1394b = string;
        this.a = str;
        new f(str);
        int i = 2;
        while (i <= 7 && !Log.isLoggable(this.a, i)) {
            i++;
        }
        this.c = i;
    }

    public void a(@RecentlyNonNull String str, @Nullable Object... objArr) {
        if (this.c <= 3) {
            String str2 = this.a;
            if (objArr.length > 0) {
                str = String.format(Locale.US, str, objArr);
            }
            Log.d(str2, this.f1394b.concat(str));
        }
    }

    public void b(@RecentlyNonNull String str, @Nullable Object... objArr) {
        String str2 = this.a;
        if (objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        Log.e(str2, this.f1394b.concat(str));
    }
}
