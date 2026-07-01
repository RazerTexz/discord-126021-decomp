package b.i.c.w;

import android.content.Intent;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f1796b;

    public m(@NonNull String str, @NonNull Intent intent) {
        b.c.a.a0.d.v(str, "evenType must be non-null");
        this.a = str;
        b.c.a.a0.d.z(intent, "intent must be non-null");
        this.f1796b = intent;
    }
}
