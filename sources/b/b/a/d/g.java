package b.b.a.d;

import d0.f0.n;
import d0.z.d.o;
import java.io.File;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: FileListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends o implements Function1<File, Sequence<? extends File>> {
    public static final g j = new g();

    public g() {
        super(1);
    }

    public final Sequence<File> a(File file) {
        Sequence<File> sequenceAsSequence;
        d0.z.d.m.checkNotNullParameter(file, "$this$getFileList");
        File[] fileArrListFiles = file.listFiles();
        return (fileArrListFiles == null || (sequenceAsSequence = d0.t.k.asSequence(fileArrListFiles)) == null) ? n.emptySequence() : sequenceAsSequence;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Sequence<? extends File> invoke(File file) {
        return a(file);
    }
}
