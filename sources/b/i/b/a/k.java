package b.i.b.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: Splitter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k {
    public final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k$b f1645b;
    public final int c;

    public k(k$b k_b) {
        b$d b_d = b$d.f1641b;
        this.f1645b = k_b;
        this.a = b_d;
        this.c = Integer.MAX_VALUE;
    }

    public List<String> a(CharSequence charSequence) {
        Objects.requireNonNull(charSequence);
        j jVar = (j) this.f1645b;
        Objects.requireNonNull(jVar);
        i iVar = new i(jVar, this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (iVar.hasNext()) {
            arrayList.add(iVar.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
