package p007b.p076b.p077a.p079d;

import com.lytefast.flexinput.adapters.FileListAdapter;
import com.lytefast.flexinput.model.Attachment;
import java.io.File;
import java.util.Comparator;
import java.util.Objects;
import p507d0.p582u.C12169a;

/* JADX INFO: renamed from: b.b.a.d.f */
/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C1436f<T> implements Comparator {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ FileListAdapter.AsyncTaskC11173a f2142j;

    public C1436f(FileListAdapter.AsyncTaskC11173a asyncTaskC11173a) {
        this.f2142j = asyncTaskC11173a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        Objects.requireNonNull(this.f2142j);
        File file = (File) ((Attachment) t2).getData();
        Long lValueOf = Long.valueOf(file != null ? file.lastModified() : 0L);
        Objects.requireNonNull(this.f2142j);
        File file2 = (File) ((Attachment) t).getData();
        return C12169a.compareValues(lValueOf, Long.valueOf(file2 != null ? file2.lastModified() : 0L));
    }
}
