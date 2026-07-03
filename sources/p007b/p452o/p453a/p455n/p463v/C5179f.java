package p007b.p452o.p453a.p455n.p463v;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;
import p007b.p225i.p226a.p288f.p340n.C4358c0;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4357c;
import p007b.p452o.p453a.p455n.AbstractC5135i;
import p007b.p452o.p453a.p455n.p463v.C5174a;

/* JADX INFO: renamed from: b.o.a.n.v.f */
/* JADX INFO: compiled from: CameraStateOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5179f extends C5174a {

    /* JADX INFO: renamed from: f */
    public EnumC5178e f14028f;

    /* JADX INFO: renamed from: g */
    public EnumC5178e f14029g;

    /* JADX INFO: renamed from: h */
    public int f14030h;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: b.o.a.n.v.f$a */
    /* JADX INFO: compiled from: CameraStateOrchestrator.java */
    public class a<T> implements InterfaceC4357c<T> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ int f14031a;

        public a(int i) {
            this.f14031a = i;
        }

        @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4357c
        public void onComplete(@NonNull Task<T> task) {
            int i = this.f14031a;
            C5179f c5179f = C5179f.this;
            if (i == c5179f.f14030h) {
                c5179f.f14029g = c5179f.f14028f;
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: b.o.a.n.v.f$b */
    /* JADX INFO: compiled from: CameraStateOrchestrator.java */
    public class b<T> implements Callable<Task<T>> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ EnumC5178e f14033j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ String f14034k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ EnumC5178e f14035l;

        /* JADX INFO: renamed from: m */
        public final /* synthetic */ Callable f14036m;

        /* JADX INFO: renamed from: n */
        public final /* synthetic */ boolean f14037n;

        public b(EnumC5178e enumC5178e, String str, EnumC5178e enumC5178e2, Callable callable, boolean z2) {
            this.f14033j = enumC5178e;
            this.f14034k = str;
            this.f14035l = enumC5178e2;
            this.f14036m = callable;
            this.f14037n = z2;
        }

        @Override // java.util.concurrent.Callable
        public Object call() throws Exception {
            C5179f c5179f = C5179f.this;
            if (c5179f.f14028f == this.f14033j) {
                return ((Task) this.f14036m.call()).mo6015j(AbstractC5135i.this.f13919k.f14133g, new C5180g(this));
            }
            C5174a.f14005a.m7159a(2, this.f14034k.toUpperCase(), "- State mismatch, aborting. current:", C5179f.this.f14028f, "from:", this.f14033j, "to:", this.f14035l);
            C4358c0 c4358c0 = new C4358c0();
            c4358c0.m6026u();
            return c4358c0;
        }
    }

    public C5179f(@NonNull C5174a.b bVar) {
        super(bVar);
        EnumC5178e enumC5178e = EnumC5178e.OFF;
        this.f14028f = enumC5178e;
        this.f14029g = enumC5178e;
        this.f14030h = 0;
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public <T> Task<T> m7368f(@NonNull EnumC5178e enumC5178e, @NonNull EnumC5178e enumC5178e2, boolean z2, @NonNull Callable<Task<T>> callable) {
        String str;
        int i = this.f14030h + 1;
        this.f14030h = i;
        this.f14029g = enumC5178e2;
        boolean z3 = !enumC5178e2.m7367f(enumC5178e);
        if (z3) {
            str = enumC5178e.name() + " << " + enumC5178e2.name();
        } else {
            str = enumC5178e.name() + " >> " + enumC5178e2.name();
        }
        Task<T> taskM7365d = m7365d(str, z2, 0L, new b(enumC5178e, str, enumC5178e2, callable, z3));
        taskM7365d.mo6007b(new a(i));
        return taskM7365d;
    }
}
