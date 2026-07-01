package b.b.a.d;

import com.lytefast.flexinput.adapters.FileListAdapter;
import com.lytefast.flexinput.model.Attachment;
import java.io.File;
import java.util.Comparator;
import java.util.Objects;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f<T> implements Comparator {
    public final /* synthetic */ FileListAdapter.a j;

    public f(FileListAdapter.a aVar) {
        this.j = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        Objects.requireNonNull(this.j);
        File file = (File) ((Attachment) t2).getData();
        Long lValueOf = Long.valueOf(file != null ? file.lastModified() : 0L);
        Objects.requireNonNull(this.j);
        File file2 = (File) ((Attachment) t).getData();
        return d0.u.a.compareValues(lValueOf, Long.valueOf(file2 != null ? file2.lastModified() : 0L));
    }
}
