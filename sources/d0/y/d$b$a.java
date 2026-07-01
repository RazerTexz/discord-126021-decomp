package d0.y;

import d0.z.d.m;
import java.io.File;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: FileTreeWalk.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$b$a extends d$a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3589b;
    public File[] c;
    public int d;
    public boolean e;
    public final /* synthetic */ d$b f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$b$a(d$b d_b, File file) {
        super(file);
        m.checkNotNullParameter(file, "rootDir");
        this.f = d_b;
    }

    @Override // d0.y.d$c
    public File step() {
        if (!this.e && this.c == null) {
            Function1 function1Access$getOnEnter$p = d.access$getOnEnter$p(this.f.m);
            if (function1Access$getOnEnter$p != null && !((Boolean) function1Access$getOnEnter$p.invoke(getRoot())).booleanValue()) {
                return null;
            }
            File[] fileArrListFiles = getRoot().listFiles();
            this.c = fileArrListFiles;
            if (fileArrListFiles == null) {
                Function2 function2Access$getOnFail$p = d.access$getOnFail$p(this.f.m);
                if (function2Access$getOnFail$p != null) {
                }
                this.e = true;
            }
        }
        File[] fileArr = this.c;
        if (fileArr != null) {
            int i = this.d;
            m.checkNotNull(fileArr);
            if (i < fileArr.length) {
                File[] fileArr2 = this.c;
                m.checkNotNull(fileArr2);
                int i2 = this.d;
                this.d = i2 + 1;
                return fileArr2[i2];
            }
        }
        if (!this.f3589b) {
            this.f3589b = true;
            return getRoot();
        }
        Function1 function1Access$getOnLeave$p = d.access$getOnLeave$p(this.f.m);
        if (function1Access$getOnLeave$p != null) {
        }
        return null;
    }
}
