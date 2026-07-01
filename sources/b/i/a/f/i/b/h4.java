package b.i.a.f.i.b;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import b.c.a.a0.AnimatableValueParser;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class h4 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1534b;
    public boolean c;
    public long d;
    public final /* synthetic */ d4 e;

    public h4(d4 d4Var, String str, long j) {
        this.e = d4Var;
        AnimatableValueParser.w(str);
        this.a = str;
        this.f1534b = j;
    }

    @WorkerThread
    public final long a() {
        if (!this.c) {
            this.c = true;
            this.d = this.e.w().getLong(this.a, this.f1534b);
        }
        return this.d;
    }

    @WorkerThread
    public final void b(long j) {
        SharedPreferences.Editor editorEdit = this.e.w().edit();
        editorEdit.putLong(this.a, j);
        editorEdit.apply();
        this.d = j;
    }
}
