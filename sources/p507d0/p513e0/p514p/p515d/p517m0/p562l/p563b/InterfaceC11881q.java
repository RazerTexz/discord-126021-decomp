package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.q */
/* JADX INFO: compiled from: FlexibleTypeDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11881q {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.q$a */
    /* JADX INFO: compiled from: FlexibleTypeDeserializer.kt */
    public static final class a implements InterfaceC11881q {

        /* JADX INFO: renamed from: a */
        public static final a f24677a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11881q
        public AbstractC11913c0 create(C11692q c11692q, String str, AbstractC11934j0 abstractC11934j0, AbstractC11934j0 abstractC11934j1) {
            C12238m.checkNotNullParameter(c11692q, "proto");
            C12238m.checkNotNullParameter(str, "flexibleId");
            C12238m.checkNotNullParameter(abstractC11934j0, "lowerBound");
            C12238m.checkNotNullParameter(abstractC11934j1, "upperBound");
            throw new IllegalArgumentException("This method should not be used.");
        }
    }

    AbstractC11913c0 create(C11692q c11692q, String str, AbstractC11934j0 abstractC11934j0, AbstractC11934j0 abstractC11934j1);
}
