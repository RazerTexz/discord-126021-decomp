package p007b.p225i.p361c.p406w;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.regex.Pattern;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.c.w.v */
/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4884v {

    /* JADX INFO: renamed from: a */
    public static final Pattern f13046a = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* JADX INFO: renamed from: b */
    public final String f13047b;

    /* JADX INFO: renamed from: c */
    public final String f13048c;

    /* JADX INFO: renamed from: d */
    public final String f13049d;

    public C4884v(String str, String str2) {
        String strSubstring;
        if (str2 == null || !str2.startsWith("/topics/")) {
            strSubstring = str2;
        } else {
            Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", str));
            strSubstring = str2.substring(8);
        }
        if (strSubstring == null || !f13046a.matcher(strSubstring).matches()) {
            throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", strSubstring, "[a-zA-Z0-9-_.~%]{1,900}"));
        }
        this.f13047b = strSubstring;
        this.f13048c = str;
        this.f13049d = C1643a.m859k(C1643a.m841b(str2, C1643a.m841b(str, 1)), str, "!", str2);
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof C4884v)) {
            return false;
        }
        C4884v c4884v = (C4884v) obj;
        return this.f13047b.equals(c4884v.f13047b) && this.f13048c.equals(c4884v.f13048c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f13048c, this.f13047b});
    }
}
