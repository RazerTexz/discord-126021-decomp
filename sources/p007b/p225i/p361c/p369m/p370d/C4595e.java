package p007b.p225i.p361c.p369m.p370d;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4362f;
import p007b.p225i.p361c.p369m.p370d.p384s.C4735c;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.C4741b;

/* JADX INFO: renamed from: b.i.c.m.d.e */
/* JADX INFO: compiled from: Onboarding.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4595e implements InterfaceC4362f<C4741b, Void> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ String f12229a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C4735c f12230b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Executor f12231c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ C4598h f12232d;

    public C4595e(C4598h c4598h, String str, C4735c c4735c, Executor executor) {
        this.f12232d = c4598h;
        this.f12229a = str;
        this.f12230b = c4735c;
        this.f12231c = executor;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4362f
    @NonNull
    /* JADX INFO: renamed from: a */
    public Task<Void> mo4013a(@Nullable C4741b c4741b) throws Exception {
        try {
            C4598h.m6383a(this.f12232d, c4741b, this.f12229a, this.f12230b, this.f12231c, true);
            return null;
        } catch (Exception e) {
            if (C4592b.f12227a.m6370a(6)) {
                Log.e("FirebaseCrashlytics", "Error performing auto configuration.", e);
            }
            throw e;
        }
    }
}
