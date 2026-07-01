package b.i.a.b.i.e;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.b.i.e.m, reason: use source file name */
/* JADX INFO: compiled from: LogRequest.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class LogRequest {
    @Nullable
    public abstract ClientInfo2 a();

    @Nullable
    public abstract List<LogEvent> b();

    @Nullable
    public abstract Integer c();

    @Nullable
    public abstract String d();

    @Nullable
    public abstract QosTier e();

    public abstract long f();

    public abstract long g();
}
