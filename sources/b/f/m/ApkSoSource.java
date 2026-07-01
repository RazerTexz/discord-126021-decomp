package b.f.m;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Parcel;
import b.f.m.ExtractFromZipSoSource;
import b.f.m.UnpackingSoSource;
import java.io.File;
import java.io.IOException;

/* JADX INFO: renamed from: b.f.m.a, reason: use source file name */
/* JADX INFO: compiled from: ApkSoSource.java */
/* JADX INFO: loaded from: classes3.dex */
public class ApkSoSource extends ExtractFromZipSoSource {
    public final int h;

    /* JADX INFO: renamed from: b.f.m.a$a */
    /* JADX INFO: compiled from: ApkSoSource.java */
    public class a extends ExtractFromZipSoSource.c {
        public File n;
        public final int o;

        public a(ExtractFromZipSoSource extractFromZipSoSource) throws IOException {
            super(extractFromZipSoSource);
            this.n = new File(ApkSoSource.this.c.getApplicationInfo().nativeLibraryDir);
            this.o = ApkSoSource.this.h;
        }
    }

    public ApkSoSource(Context context, File file, String str, int i) {
        super(context, str, file, "^lib/([^/]+)/([^/]+\\.so)$");
        this.h = i;
    }

    @Override // b.f.m.UnpackingSoSource
    public byte[] g() throws IOException {
        int i;
        File canonicalFile = this.f.getCanonicalFile();
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeByte((byte) 2);
            parcelObtain.writeString(canonicalFile.getPath());
            parcelObtain.writeLong(canonicalFile.lastModified());
            Context context = this.c;
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                try {
                    i = packageManager.getPackageInfo(context.getPackageName(), 0).versionCode;
                } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
                    i = 0;
                }
            } else {
                i = 0;
            }
            parcelObtain.writeInt(i);
            if ((this.h & 1) == 0) {
                parcelObtain.writeByte((byte) 0);
                return parcelObtain.marshall();
            }
            String str = this.c.getApplicationInfo().nativeLibraryDir;
            if (str == null) {
                parcelObtain.writeByte((byte) 1);
                return parcelObtain.marshall();
            }
            File canonicalFile2 = new File(str).getCanonicalFile();
            if (!canonicalFile2.exists()) {
                parcelObtain.writeByte((byte) 1);
                return parcelObtain.marshall();
            }
            parcelObtain.writeByte((byte) 2);
            parcelObtain.writeString(canonicalFile2.getPath());
            parcelObtain.writeLong(canonicalFile2.lastModified());
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // b.f.m.UnpackingSoSource
    public UnpackingSoSource.f i() throws IOException {
        return new a(this);
    }
}
