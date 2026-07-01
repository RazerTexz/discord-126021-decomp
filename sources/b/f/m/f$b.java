package b.f.m;

import java.util.zip.ZipEntry;

/* JADX INFO: compiled from: ExtractFromZipSoSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f$b extends m$b implements Comparable {
    public final ZipEntry l;
    public final int m;

    public f$b(String str, ZipEntry zipEntry, int i) {
        super(str, String.format("pseudo-zip-hash-1-%s-%s-%s-%s", zipEntry.getName(), Long.valueOf(zipEntry.getSize()), Long.valueOf(zipEntry.getCompressedSize()), Long.valueOf(zipEntry.getCrc())));
        this.l = zipEntry;
        this.m = i;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return this.j.compareTo(((f$b) obj).j);
    }
}
