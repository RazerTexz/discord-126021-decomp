package d0.y;

import d0.z.d.m;
import java.io.File;

/* JADX INFO: compiled from: FileTreeWalk.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d$c {
    public final File a;

    public d$c(File file) {
        m.checkNotNullParameter(file, "root");
        this.a = file;
    }

    public final File getRoot() {
        return this.a;
    }

    public abstract File step();
}
