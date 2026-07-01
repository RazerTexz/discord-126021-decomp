package b.f.m;

import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: ApkSoSource.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$a extends f$c {
    public File n;
    public final int o;
    public final /* synthetic */ a p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$a(a aVar, f fVar) throws IOException {
        super(aVar, fVar);
        this.p = aVar;
        this.n = new File(aVar.c.getApplicationInfo().nativeLibraryDir);
        this.o = aVar.h;
    }
}
