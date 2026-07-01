package b.i.c.u.p;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

/* JADX INFO: renamed from: b.i.c.u.p.d, reason: use source file name */
/* JADX INFO: compiled from: InstallationResponse.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class InstallationResponse {

    /* JADX INFO: renamed from: b.i.c.u.p.d$a */
    /* JADX INFO: compiled from: InstallationResponse.java */
    public enum a {
        OK,
        BAD_CONFIG
    }

    @Nullable
    public abstract TokenResult a();

    @Nullable
    public abstract String b();

    @Nullable
    public abstract String c();

    @Nullable
    public abstract a d();

    @Nullable
    public abstract String e();
}
