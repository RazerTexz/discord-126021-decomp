package f0.e0.g;

import f0.c0;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: RouteSelector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m$a {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c0> f3623b;

    public m$a(List<c0> list) {
        d0.z.d.m.checkParameterIsNotNull(list, "routes");
        this.f3623b = list;
    }

    public final boolean a() {
        return this.a < this.f3623b.size();
    }

    public final c0 b() {
        if (!a()) {
            throw new NoSuchElementException();
        }
        List<c0> list = this.f3623b;
        int i = this.a;
        this.a = i + 1;
        return list.get(i);
    }
}
