package b.i.a.f.i.b;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import b.c.a.a0.AnimatableValueParser;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class f4 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1533b;
    public boolean c;
    public boolean d;
    public final /* synthetic */ d4 e;

    public f4(d4 d4Var, String str, boolean z2) {
        this.e = d4Var;
        AnimatableValueParser.w(str);
        this.a = str;
        this.f1533b = z2;
    }

    @WorkerThread
    public final void a(boolean z2) {
        SharedPreferences.Editor editorEdit = this.e.w().edit();
        editorEdit.putBoolean(this.a, z2);
        editorEdit.apply();
        this.d = z2;
    }

    @WorkerThread
    public final boolean b() {
        if (!this.c) {
            this.c = true;
            this.d = this.e.w().getBoolean(this.a, this.f1533b);
        }
        return this.d;
    }
}
