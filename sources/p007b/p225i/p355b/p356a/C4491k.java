package p007b.p225i.p355b.p356a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import p007b.p225i.p355b.p356a.AbstractC4482b;

/* JADX INFO: renamed from: b.i.b.a.k */
/* JADX INFO: compiled from: Splitter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4491k {

    /* JADX INFO: renamed from: a */
    public final AbstractC4482b f11958a;

    /* JADX INFO: renamed from: b */
    public final b f11959b;

    /* JADX INFO: renamed from: c */
    public final int f11960c;

    /* JADX INFO: renamed from: b.i.b.a.k$a */
    /* JADX INFO: compiled from: Splitter.java */
    public static abstract class a extends AbstractC4481a<String> {

        /* JADX INFO: renamed from: l */
        public final CharSequence f11961l;

        /* JADX INFO: renamed from: m */
        public final AbstractC4482b f11962m;

        /* JADX INFO: renamed from: p */
        public int f11965p;

        /* JADX INFO: renamed from: o */
        public int f11964o = 0;

        /* JADX INFO: renamed from: n */
        public final boolean f11963n = false;

        public a(C4491k c4491k, CharSequence charSequence) {
            this.f11962m = c4491k.f11958a;
            this.f11965p = c4491k.f11960c;
            this.f11961l = charSequence;
        }
    }

    /* JADX INFO: renamed from: b.i.b.a.k$b */
    /* JADX INFO: compiled from: Splitter.java */
    public interface b {
    }

    public C4491k(b bVar) {
        AbstractC4482b.d dVar = AbstractC4482b.d.f11942b;
        this.f11959b = bVar;
        this.f11958a = dVar;
        this.f11960c = Integer.MAX_VALUE;
    }

    /* JADX INFO: renamed from: a */
    public List<String> m6215a(CharSequence charSequence) {
        Objects.requireNonNull(charSequence);
        C4490j c4490j = (C4490j) this.f11959b;
        Objects.requireNonNull(c4490j);
        C4489i c4489i = new C4489i(c4490j, this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (c4489i.hasNext()) {
            arrayList.add(c4489i.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
