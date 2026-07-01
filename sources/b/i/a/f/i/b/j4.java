package b.i.a.f.i.b;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import b.c.a.a0.AnimatableValueParser;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class j4 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1540b;
    public String c;
    public final /* synthetic */ d4 d;

    public j4(d4 d4Var, String str) {
        this.d = d4Var;
        AnimatableValueParser.w(str);
        this.a = str;
    }

    @WorkerThread
    public final String a() {
        if (!this.f1540b) {
            this.f1540b = true;
            this.c = this.d.w().getString(this.a, null);
        }
        return this.c;
    }

    @WorkerThread
    public final void b(String str) {
        SharedPreferences.Editor editorEdit = this.d.w().edit();
        editorEdit.putString(this.a, str);
        editorEdit.apply();
        this.c = str;
    }
}
