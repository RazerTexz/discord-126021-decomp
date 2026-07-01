package b.i.a.f.h.j;

import android.content.SharedPreferences$Editor;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p0 f1425b;

    public r0(p0 p0Var, String str, long j, q0 q0Var) {
        this.f1425b = p0Var;
        b.c.a.a0.d.w(str);
        b.c.a.a0.d.l(j > 0);
        this.a = str;
    }

    public final void a(String str) {
        if (this.f1425b.l.getLong(String.valueOf(this.a).concat(":start"), 0L) == 0) {
            Objects.requireNonNull((b.i.a.f.e.o.c) this.f1425b.j.d);
            long jCurrentTimeMillis = System.currentTimeMillis();
            SharedPreferences$Editor sharedPreferences$EditorEdit = this.f1425b.l.edit();
            sharedPreferences$EditorEdit.remove(b());
            sharedPreferences$EditorEdit.remove(c());
            sharedPreferences$EditorEdit.putLong(String.valueOf(this.a).concat(":start"), jCurrentTimeMillis);
            sharedPreferences$EditorEdit.commit();
        }
        if (str == null) {
            str = "";
        }
        synchronized (this) {
            long j = this.f1425b.l.getLong(b(), 0L);
            if (j <= 0) {
                SharedPreferences$Editor sharedPreferences$EditorEdit2 = this.f1425b.l.edit();
                sharedPreferences$EditorEdit2.putString(c(), str);
                sharedPreferences$EditorEdit2.putLong(b(), 1L);
                sharedPreferences$EditorEdit2.apply();
                return;
            }
            long j2 = j + 1;
            boolean z2 = (UUID.randomUUID().getLeastSignificantBits() & RecyclerView.FOREVER_NS) < RecyclerView.FOREVER_NS / j2;
            SharedPreferences$Editor sharedPreferences$EditorEdit3 = this.f1425b.l.edit();
            if (z2) {
                sharedPreferences$EditorEdit3.putString(c(), str);
            }
            sharedPreferences$EditorEdit3.putLong(b(), j2);
            sharedPreferences$EditorEdit3.apply();
        }
    }

    public final String b() {
        return String.valueOf(this.a).concat(":count");
    }

    public final String c() {
        return String.valueOf(this.a).concat(":value");
    }
}
