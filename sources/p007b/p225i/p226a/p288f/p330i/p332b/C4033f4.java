package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.i.b.f4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4033f4 {

    /* JADX INFO: renamed from: a */
    public final String f10712a;

    /* JADX INFO: renamed from: b */
    public final boolean f10713b;

    /* JADX INFO: renamed from: c */
    public boolean f10714c;

    /* JADX INFO: renamed from: d */
    public boolean f10715d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C4009d4 f10716e;

    public C4033f4(C4009d4 c4009d4, String str, boolean z2) {
        this.f10716e = c4009d4;
        C1460d.m583w(str);
        this.f10712a = str;
        this.f10713b = z2;
    }

    @WorkerThread
    /* JADX INFO: renamed from: a */
    public final void m5596a(boolean z2) {
        SharedPreferences.Editor editorEdit = this.f10716e.m5579w().edit();
        editorEdit.putBoolean(this.f10712a, z2);
        editorEdit.apply();
        this.f10715d = z2;
    }

    @WorkerThread
    /* JADX INFO: renamed from: b */
    public final boolean m5597b() {
        if (!this.f10714c) {
            this.f10714c = true;
            this.f10715d = this.f10716e.m5579w().getBoolean(this.f10712a, this.f10713b);
        }
        return this.f10715d;
    }
}
