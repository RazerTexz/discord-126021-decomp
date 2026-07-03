package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;

/* JADX INFO: renamed from: b.i.a.f.i.b.k4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4092k4 {

    /* JADX INFO: renamed from: a */
    public final String f10871a;

    /* JADX INFO: renamed from: b */
    public final String f10872b;

    /* JADX INFO: renamed from: c */
    public final String f10873c;

    /* JADX INFO: renamed from: d */
    public final long f10874d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C4009d4 f10875e;

    public C4092k4(C4009d4 c4009d4, String str, long j, C4045g4 c4045g4) {
        this.f10875e = c4009d4;
        C1460d.m583w(str);
        C1460d.m539l(j > 0);
        this.f10871a = str.concat(":start");
        this.f10872b = str.concat(":count");
        this.f10873c = str.concat(":value");
        this.f10874d = j;
    }

    @WorkerThread
    /* JADX INFO: renamed from: a */
    public final void m5696a() {
        this.f10875e.mo5848b();
        Objects.requireNonNull((C3401c) this.f10875e.f11202a.f11267o);
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.f10875e.m5579w().edit();
        editorEdit.remove(this.f10872b);
        editorEdit.remove(this.f10873c);
        editorEdit.putLong(this.f10871a, jCurrentTimeMillis);
        editorEdit.apply();
    }
}
