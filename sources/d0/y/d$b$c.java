package d0.y;

import d0.z.d.m;
import java.io.File;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: FileTreeWalk.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$b$c extends d$a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3591b;
    public File[] c;
    public int d;
    public final /* synthetic */ d$b e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$b$c(d$b d_b, File file) {
        super(file);
        m.checkNotNullParameter(file, "rootDir");
        this.e = d_b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0085, code lost:
    
        if (r0.length == 0) goto L31;
     */
    @Override // d0.y.d$c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public File step() {
        Function2 function2Access$getOnFail$p;
        if (!this.f3591b) {
            Function1 function1Access$getOnEnter$p = d.access$getOnEnter$p(this.e.m);
            if (function1Access$getOnEnter$p != null && !((Boolean) function1Access$getOnEnter$p.invoke(getRoot())).booleanValue()) {
                return null;
            }
            this.f3591b = true;
            return getRoot();
        }
        File[] fileArr = this.c;
        if (fileArr != null) {
            int i = this.d;
            m.checkNotNull(fileArr);
            if (i >= fileArr.length) {
                Function1 function1Access$getOnLeave$p = d.access$getOnLeave$p(this.e.m);
                if (function1Access$getOnLeave$p != null) {
                }
                return null;
            }
        }
        if (this.c == null) {
            File[] fileArrListFiles = getRoot().listFiles();
            this.c = fileArrListFiles;
            if (fileArrListFiles == null && (function2Access$getOnFail$p = d.access$getOnFail$p(this.e.m)) != null) {
            }
            File[] fileArr2 = this.c;
            if (fileArr2 != null) {
                m.checkNotNull(fileArr2);
            }
            Function1 function1Access$getOnLeave$p2 = d.access$getOnLeave$p(this.e.m);
            if (function1Access$getOnLeave$p2 != null) {
            }
            return null;
        }
        File[] fileArr3 = this.c;
        m.checkNotNull(fileArr3);
        int i2 = this.d;
        this.d = i2 + 1;
        return fileArr3[i2];
    }
}
