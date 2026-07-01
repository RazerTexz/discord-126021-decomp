package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import b.d.b.a.outline;
import b.i.c.m.d.m.CrashlyticsReport;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.c.m.d.m.e, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_FilesPayload_File.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_FilesPayload_File extends CrashlyticsReport.c.a {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f1717b;

    public AutoValue_CrashlyticsReport_FilesPayload_File(String str, byte[] bArr, a aVar) {
        this.a = str;
        this.f1717b = bArr;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.c.a
    @NonNull
    public byte[] a() {
        return this.f1717b;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.c.a
    @NonNull
    public String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.c.a)) {
            return false;
        }
        CrashlyticsReport.c.a aVar = (CrashlyticsReport.c.a) obj;
        if (this.a.equals(aVar.b())) {
            if (Arrays.equals(this.f1717b, aVar instanceof AutoValue_CrashlyticsReport_FilesPayload_File ? ((AutoValue_CrashlyticsReport_FilesPayload_File) aVar).f1717b : aVar.a())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f1717b);
    }

    public String toString() {
        StringBuilder sbU = outline.U("File{filename=");
        sbU.append(this.a);
        sbU.append(", contents=");
        sbU.append(Arrays.toString(this.f1717b));
        sbU.append("}");
        return sbU.toString();
    }
}
