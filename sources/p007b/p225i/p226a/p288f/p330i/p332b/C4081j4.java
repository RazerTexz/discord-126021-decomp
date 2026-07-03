package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.i.b.j4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4081j4 {

    /* JADX INFO: renamed from: a */
    public final String f10845a;

    /* JADX INFO: renamed from: b */
    public boolean f10846b;

    /* JADX INFO: renamed from: c */
    public String f10847c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ C4009d4 f10848d;

    public C4081j4(C4009d4 c4009d4, String str) {
        this.f10848d = c4009d4;
        C1460d.m583w(str);
        this.f10845a = str;
    }

    @WorkerThread
    /* JADX INFO: renamed from: a */
    public final String m5694a() {
        if (!this.f10846b) {
            this.f10846b = true;
            this.f10847c = this.f10848d.m5579w().getString(this.f10845a, null);
        }
        return this.f10847c;
    }

    @WorkerThread
    /* JADX INFO: renamed from: b */
    public final void m5695b(String str) {
        SharedPreferences.Editor editorEdit = this.f10848d.m5579w().edit();
        editorEdit.putString(this.f10845a, str);
        editorEdit.apply();
        this.f10847c = str;
    }
}
