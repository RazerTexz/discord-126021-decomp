package d0.y;

import d0.z.d.m;
import java.io.File;

/* JADX INFO: compiled from: FileTreeWalk.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d$a extends d$c {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$a(File file) {
        super(file);
        m.checkNotNullParameter(file, "rootDir");
    }
}
