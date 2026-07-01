package b.i.c.w;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class v {
    public static final Pattern a = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1798b;
    public final String c;
    public final String d;

    public v(String str, String str2) {
        String strSubstring;
        if (str2 == null || !str2.startsWith("/topics/")) {
            strSubstring = str2;
        } else {
            Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", str));
            strSubstring = str2.substring(8);
        }
        if (strSubstring == null || !a.matcher(strSubstring).matches()) {
            throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", strSubstring, "[a-zA-Z0-9-_.~%]{1,900}"));
        }
        this.f1798b = strSubstring;
        this.c = str;
        this.d = b.d.b.a.a.k(b.d.b.a.a.b(str2, b.d.b.a.a.b(str, 1)), str, "!", str2);
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.f1798b.equals(vVar.f1798b) && this.c.equals(vVar.c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.c, this.f1798b});
    }
}
