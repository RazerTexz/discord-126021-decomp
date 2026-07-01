package b.i.a.f.i.b;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import b.c.a.a0.AnimatableValueParser;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class k4 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1541b;
    public final String c;
    public final long d;
    public final /* synthetic */ d4 e;

    public k4(d4 d4Var, String str, long j, g4 g4Var) {
        this.e = d4Var;
        AnimatableValueParser.w(str);
        AnimatableValueParser.l(j > 0);
        this.a = str.concat(":start");
        this.f1541b = str.concat(":count");
        this.c = str.concat(":value");
        this.d = j;
    }

    @WorkerThread
    public final void a() {
        this.e.b();
        Objects.requireNonNull((b.i.a.f.e.o.c) this.e.a.o);
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.e.w().edit();
        editorEdit.remove(this.f1541b);
        editorEdit.remove(this.c);
        editorEdit.putLong(this.a, jCurrentTimeMillis);
        editorEdit.apply();
    }
}
