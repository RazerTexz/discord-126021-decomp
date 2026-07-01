package b.b.a.d;

import d0.f0.n;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.File;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: renamed from: b.b.a.d.g, reason: use source file name */
/* JADX INFO: compiled from: FileListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FileListAdapter2 extends Lambda implements Function1<File, Sequence<? extends File>> {
    public static final FileListAdapter2 j = new FileListAdapter2();

    public FileListAdapter2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Sequence<File> invoke(File file) {
        Sequence<File> sequenceAsSequence;
        Intrinsics3.checkNotNullParameter(file, "$this$getFileList");
        File[] fileArrListFiles = file.listFiles();
        return (fileArrListFiles == null || (sequenceAsSequence = _Arrays.asSequence(fileArrListFiles)) == null) ? n.emptySequence() : sequenceAsSequence;
    }
}
