package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.i.b.h4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4057h4 {

    /* JADX INFO: renamed from: a */
    public final String f10766a;

    /* JADX INFO: renamed from: b */
    public final long f10767b;

    /* JADX INFO: renamed from: c */
    public boolean f10768c;

    /* JADX INFO: renamed from: d */
    public long f10769d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C4009d4 f10770e;

    public C4057h4(C4009d4 c4009d4, String str, long j) {
        this.f10770e = c4009d4;
        C1460d.m583w(str);
        this.f10766a = str;
        this.f10767b = j;
    }

    @WorkerThread
    /* JADX INFO: renamed from: a */
    public final long m5648a() {
        if (!this.f10768c) {
            this.f10768c = true;
            this.f10769d = this.f10770e.m5579w().getLong(this.f10766a, this.f10767b);
        }
        return this.f10769d;
    }

    @WorkerThread
    /* JADX INFO: renamed from: b */
    public final void m5649b(long j) {
        SharedPreferences.Editor editorEdit = this.f10770e.m5579w().edit();
        editorEdit.putLong(this.f10766a, j);
        editorEdit.apply();
        this.f10769d = j;
    }
}
