package p007b.p076b.p077a.p079d;

import java.io.File;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import p507d0.p578f0.C12075n;
import p507d0.p580t.C12141k;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.b.a.d.g */
/* JADX INFO: compiled from: FileListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C1437g extends AbstractC12240o implements Function1<File, Sequence<? extends File>> {

    /* JADX INFO: renamed from: j */
    public static final C1437g f2143j = new C1437g();

    public C1437g() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Sequence<File> invoke(File file) {
        Sequence<File> sequenceAsSequence;
        C12238m.checkNotNullParameter(file, "$this$getFileList");
        File[] fileArrListFiles = file.listFiles();
        return (fileArrListFiles == null || (sequenceAsSequence = C12141k.asSequence(fileArrListFiles)) == null) ? C12075n.emptySequence() : sequenceAsSequence;
    }
}
