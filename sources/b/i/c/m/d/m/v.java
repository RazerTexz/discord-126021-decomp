package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adjust.sdk.Constants;
import com.google.auto.value.AutoValue;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: CrashlyticsReport.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class v {
    public static final Charset a = Charset.forName(Constants.ENCODING);

    @NonNull
    public abstract String a();

    @NonNull
    public abstract String b();

    @NonNull
    public abstract String c();

    @NonNull
    public abstract String d();

    @Nullable
    public abstract v$c e();

    public abstract int f();

    @NonNull
    public abstract String g();

    @Nullable
    public abstract v$d h();

    @NonNull
    public abstract v$a i();

    @NonNull
    public v j(long j, boolean z2, @Nullable String str) {
        v$a v_aI = i();
        v$d v_d = ((b) this).h;
        if (v_d != null) {
            v$d$b v_d_bL = v_d.l();
            f$b f_b = (f$b) v_d_bL;
            f_b.d = Long.valueOf(j);
            f_b.e = Boolean.valueOf(z2);
            if (str != null) {
                f_b.g = new u(str, null);
                f_b.a();
            }
            ((b$b) v_aI).g = v_d_bL.a();
        }
        return v_aI.a();
    }
}
