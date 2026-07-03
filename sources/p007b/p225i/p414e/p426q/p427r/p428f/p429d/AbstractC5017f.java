package p007b.p225i.p414e.p426q.p427r.p428f.p429d;

import com.google.zxing.NotFoundException;
import p007b.p225i.p414e.p418n.C4962a;

/* JADX INFO: renamed from: b.i.e.q.r.f.d.f */
/* JADX INFO: compiled from: AI013x0xDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC5017f extends AbstractC5020i {
    public AbstractC5017f(C4962a c4962a) {
        super(c4962a);
    }

    @Override // p007b.p225i.p414e.p426q.p427r.p428f.p429d.AbstractC5021j
    /* JADX INFO: renamed from: a */
    public String mo7030a() throws NotFoundException {
        if (this.f13439a.f13228k != 60) {
            throw NotFoundException.f21665l;
        }
        StringBuilder sb = new StringBuilder();
        m7031b(sb, 5);
        m7033f(sb, 45, 15);
        return sb.toString();
    }
}
