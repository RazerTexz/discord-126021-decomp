package b.f.b.b;

import java.io.IOException;

/* JADX INFO: compiled from: DefaultDiskStorage.java */
/* JADX INFO: loaded from: classes.dex */
public class a$e extends IOException {
    public a$e(long j, long j2) {
        super("File was not written completely. Expected: " + j + ", found: " + j2);
    }
}
