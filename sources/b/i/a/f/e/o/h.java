package b.i.a.f.e.o;

import androidx.annotation.Nullable;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class h {
    static {
        Pattern.compile("\\$\\{(.*?)\\}");
    }

    public static boolean a(@Nullable String str) {
        return str == null || str.trim().isEmpty();
    }
}
