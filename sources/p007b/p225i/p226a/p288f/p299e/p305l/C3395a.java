package p007b.p225i.p226a.p288f.p299e.p305l;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import java.util.Locale;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p304k.C3353f;

/* JADX INFO: renamed from: b.i.a.f.e.l.a */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3395a {

    /* JADX INFO: renamed from: a */
    public final String f9577a;

    /* JADX INFO: renamed from: b */
    public final String f9578b;

    /* JADX INFO: renamed from: c */
    public final int f9579c;

    public C3395a(@RecentlyNonNull String str, @RecentlyNonNull String... strArr) {
        String string;
        if (strArr.length == 0) {
            string = "";
        } else {
            StringBuilder sbM829Q = C1643a.m829Q('[');
            for (String str2 : strArr) {
                if (sbM829Q.length() > 1) {
                    sbM829Q.append(",");
                }
                sbM829Q.append(str2);
            }
            sbM829Q.append("] ");
            string = sbM829Q.toString();
        }
        this.f9578b = string;
        this.f9577a = str;
        new C3353f(str);
        int i = 2;
        while (i <= 7 && !Log.isLoggable(this.f9577a, i)) {
            i++;
        }
        this.f9579c = i;
    }

    /* JADX INFO: renamed from: a */
    public void m4179a(@RecentlyNonNull String str, @Nullable Object... objArr) {
        if (this.f9579c <= 3) {
            String str2 = this.f9577a;
            if (objArr.length > 0) {
                str = String.format(Locale.US, str, objArr);
            }
            Log.d(str2, this.f9578b.concat(str));
        }
    }

    /* JADX INFO: renamed from: b */
    public void m4180b(@RecentlyNonNull String str, @Nullable Object... objArr) {
        String str2 = this.f9577a;
        if (objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        Log.e(str2, this.f9578b.concat(str));
    }
}
