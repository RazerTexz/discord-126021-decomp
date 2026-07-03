package p007b.p225i.p414e.p426q.p427r.p428f.p429d;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import p007b.p225i.p414e.p418n.C4962a;

/* JADX INFO: renamed from: b.i.e.q.r.f.d.j */
/* JADX INFO: compiled from: AbstractExpandedDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC5021j {

    /* JADX INFO: renamed from: a */
    public final C4962a f13439a;

    /* JADX INFO: renamed from: b */
    public final C5030s f13440b;

    public AbstractC5021j(C4962a c4962a) {
        this.f13439a = c4962a;
        this.f13440b = new C5030s(c4962a);
    }

    /* JADX INFO: renamed from: a */
    public abstract String mo7030a() throws NotFoundException, FormatException;
}
