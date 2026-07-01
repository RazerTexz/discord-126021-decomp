package b.i.e.q.r.f.d;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: AbstractExpandedDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j {
    public final b.i.e.n.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f1867b;

    public j(b.i.e.n.a aVar) {
        this.a = aVar;
        this.f1867b = new s(aVar);
    }

    public abstract String a() throws NotFoundException, FormatException;
}
