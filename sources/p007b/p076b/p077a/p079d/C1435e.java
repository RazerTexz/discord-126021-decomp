package p007b.p076b.p077a.p079d;

import com.lytefast.flexinput.model.Attachment;
import java.util.Comparator;
import p507d0.p582u.C12169a;

/* JADX INFO: renamed from: b.b.a.d.e */
/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C1435e<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return C12169a.compareValues(((Attachment) t).getUri(), ((Attachment) t2).getUri());
    }
}
