package b.i.a.c.w2;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: DrmSessionEventListener.java */
/* JADX INFO: loaded from: classes3.dex */
public class s$a {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final b.i.a.c.a3.a0$a f1156b;
    public final CopyOnWriteArrayList<s$a$a> c;

    public s$a() {
        this.c = new CopyOnWriteArrayList<>();
        this.a = 0;
        this.f1156b = null;
    }

    public void a() {
        for (s$a$a s_a_a : this.c) {
            b.i.a.c.f3.e0.E(s_a_a.a, new i(this, s_a_a.f1157b));
        }
    }

    public void b() {
        for (s$a$a s_a_a : this.c) {
            b.i.a.c.f3.e0.E(s_a_a.a, new h(this, s_a_a.f1157b));
        }
    }

    public void c() {
        for (s$a$a s_a_a : this.c) {
            b.i.a.c.f3.e0.E(s_a_a.a, new j(this, s_a_a.f1157b));
        }
    }

    public void d(int i) {
        for (s$a$a s_a_a : this.c) {
            b.i.a.c.f3.e0.E(s_a_a.a, new l(this, s_a_a.f1157b, i));
        }
    }

    public void e(Exception exc) {
        for (s$a$a s_a_a : this.c) {
            b.i.a.c.f3.e0.E(s_a_a.a, new k(this, s_a_a.f1157b, exc));
        }
    }

    public void f() {
        for (s$a$a s_a_a : this.c) {
            b.i.a.c.f3.e0.E(s_a_a.a, new g(this, s_a_a.f1157b));
        }
    }

    @CheckResult
    public s$a g(int i, @Nullable b.i.a.c.a3.a0$a a0_a) {
        return new s$a(this.c, i, a0_a);
    }

    public s$a(CopyOnWriteArrayList<s$a$a> copyOnWriteArrayList, int i, @Nullable b.i.a.c.a3.a0$a a0_a) {
        this.c = copyOnWriteArrayList;
        this.a = i;
        this.f1156b = a0_a;
    }
}
