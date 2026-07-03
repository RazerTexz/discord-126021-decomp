package p007b.p225i.p226a.p288f.p313h.p323j;

import android.content.SharedPreferences;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import java.util.UUID;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;

/* JADX INFO: renamed from: b.i.a.f.h.j.r0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3539r0 {

    /* JADX INFO: renamed from: a */
    public final String f9793a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C3535p0 f9794b;

    public C3539r0(C3535p0 c3535p0, String str, long j, C3537q0 c3537q0) {
        this.f9794b = c3535p0;
        C1460d.m583w(str);
        C1460d.m539l(j > 0);
        this.f9793a = str;
    }

    /* JADX INFO: renamed from: a */
    public final void m4496a(String str) {
        if (this.f9794b.f9777l.getLong(String.valueOf(this.f9793a).concat(":start"), 0L) == 0) {
            Objects.requireNonNull((C3401c) this.f9794b.f9684j.f9724d);
            long jCurrentTimeMillis = System.currentTimeMillis();
            SharedPreferences.Editor editorEdit = this.f9794b.f9777l.edit();
            editorEdit.remove(m4497b());
            editorEdit.remove(m4498c());
            editorEdit.putLong(String.valueOf(this.f9793a).concat(":start"), jCurrentTimeMillis);
            editorEdit.commit();
        }
        if (str == null) {
            str = "";
        }
        synchronized (this) {
            long j = this.f9794b.f9777l.getLong(m4497b(), 0L);
            if (j <= 0) {
                SharedPreferences.Editor editorEdit2 = this.f9794b.f9777l.edit();
                editorEdit2.putString(m4498c(), str);
                editorEdit2.putLong(m4497b(), 1L);
                editorEdit2.apply();
                return;
            }
            long j2 = j + 1;
            boolean z2 = (UUID.randomUUID().getLeastSignificantBits() & RecyclerView.FOREVER_NS) < RecyclerView.FOREVER_NS / j2;
            SharedPreferences.Editor editorEdit3 = this.f9794b.f9777l.edit();
            if (z2) {
                editorEdit3.putString(m4498c(), str);
            }
            editorEdit3.putLong(m4497b(), j2);
            editorEdit3.apply();
        }
    }

    /* JADX INFO: renamed from: b */
    public final String m4497b() {
        return String.valueOf(this.f9793a).concat(":count");
    }

    /* JADX INFO: renamed from: c */
    public final String m4498c() {
        return String.valueOf(this.f9793a).concat(":value");
    }
}
