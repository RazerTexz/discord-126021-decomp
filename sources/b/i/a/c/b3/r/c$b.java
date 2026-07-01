package b.i.a.c.b3.r;

import android.graphics.PointF;
import android.util.Log;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SsaStyle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c$b {
    public static final Pattern a = Pattern.compile("\\{([^}]*)\\}");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f878b = Pattern.compile(e0.k("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
    public static final Pattern c = Pattern.compile(e0.k("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
    public static final Pattern d = Pattern.compile("\\\\an(\\d+)");

    @Nullable
    public static PointF a(String str) {
        String strGroup;
        String strGroup2;
        Matcher matcher = f878b.matcher(str);
        Matcher matcher2 = c.matcher(str);
        boolean zFind = matcher.find();
        boolean zFind2 = matcher2.find();
        if (zFind) {
            if (zFind2) {
                StringBuilder sb = new StringBuilder(str.length() + 82);
                sb.append("Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='");
                sb.append(str);
                sb.append("'");
                Log.i("SsaStyle.Overrides", sb.toString());
            }
            strGroup = matcher.group(1);
            strGroup2 = matcher.group(2);
        } else {
            if (!zFind2) {
                return null;
            }
            strGroup = matcher2.group(1);
            strGroup2 = matcher2.group(2);
        }
        Objects.requireNonNull(strGroup);
        float f = Float.parseFloat(strGroup.trim());
        Objects.requireNonNull(strGroup2);
        return new PointF(f, Float.parseFloat(strGroup2.trim()));
    }
}
