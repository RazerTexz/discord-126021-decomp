package b.i.c.m.d.i;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: CrashlyticsOriginAnalyticsEventLogger.java */
/* JADX INFO: loaded from: classes3.dex */
public class e implements a {

    @NonNull
    public final b.i.c.j.a.a a;

    public e(@NonNull b.i.c.j.a.a aVar) {
        this.a = aVar;
    }

    @Override // b.i.c.m.d.i.a
    public void a(@NonNull String str, @Nullable Bundle bundle) {
        this.a.a("clx", str, bundle);
    }
}
