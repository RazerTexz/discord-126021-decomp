package android.support.v4.os;

import android.os.Bundle;
import java.util.Objects;
import x.a.b.c.a$a;

/* JADX INFO: loaded from: classes.dex */
public class ResultReceiver$b extends a$a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ResultReceiver f22b;

    public ResultReceiver$b(ResultReceiver resultReceiver) {
        this.f22b = resultReceiver;
    }

    @Override // x.a.b.c.a
    public void r0(int i, Bundle bundle) {
        Objects.requireNonNull(this.f22b);
        this.f22b.a(i, bundle);
    }
}
