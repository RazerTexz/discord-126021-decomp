package b.i.b.a;

import b.i.b.a.CharMatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.b.a.k, reason: use source file name */
/* JADX INFO: compiled from: Splitter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Splitter3 {
    public final CharMatcher a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f1645b;
    public final int c;

    /* JADX INFO: renamed from: b.i.b.a.k$a */
    /* JADX INFO: compiled from: Splitter.java */
    public static abstract class a extends AbstractIterator<String> {
        public final CharSequence l;
        public final CharMatcher m;
        public int p;
        public int o = 0;
        public final boolean n = false;

        public a(Splitter3 splitter3, CharSequence charSequence) {
            this.m = splitter3.a;
            this.p = splitter3.c;
            this.l = charSequence;
        }
    }

    /* JADX INFO: renamed from: b.i.b.a.k$b */
    /* JADX INFO: compiled from: Splitter.java */
    public interface b {
    }

    public Splitter3(b bVar) {
        CharMatcher.d dVar = CharMatcher.d.f1641b;
        this.f1645b = bVar;
        this.a = dVar;
        this.c = Integer.MAX_VALUE;
    }

    public List<String> a(CharSequence charSequence) {
        Objects.requireNonNull(charSequence);
        Splitter2 splitter2 = (Splitter2) this.f1645b;
        Objects.requireNonNull(splitter2);
        Splitter splitter = new Splitter(splitter2, this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (splitter.hasNext()) {
            arrayList.add(splitter.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
