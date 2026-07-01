package d0.y;

import d0.z.d.m;
import java.io.File;

/* JADX INFO: compiled from: FileTreeWalk.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$b$b extends d$c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3590b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$b$b(d$b d_b, File file) {
        super(file);
        m.checkNotNullParameter(file, "rootFile");
    }

    @Override // d0.y.d$c
    public File step() {
        if (this.f3590b) {
            return null;
        }
        this.f3590b = true;
        return getRoot();
    }
}
