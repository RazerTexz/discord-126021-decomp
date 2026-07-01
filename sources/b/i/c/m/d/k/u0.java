package b.i.c.m.d.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.m.d.m.v$c$a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: FileBackedNativeSessionFile.java */
/* JADX INFO: loaded from: classes3.dex */
public class u0 implements a1 {

    @NonNull
    public final File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final String f1696b;

    @NonNull
    public final String c;

    public u0(@NonNull String str, @NonNull String str2, @NonNull File file) {
        this.f1696b = str;
        this.c = str2;
        this.a = file;
    }

    @Override // b.i.c.m.d.k.a1
    @NonNull
    public String a() {
        return this.c;
    }

    @Override // b.i.c.m.d.k.a1
    @Nullable
    public v$c$a b() {
        byte[] byteArray;
        byte[] bArr = new byte[8192];
        try {
            InputStream inputStreamH = h();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    if (inputStreamH == null) {
                        gZIPOutputStream.close();
                        byteArrayOutputStream.close();
                        if (inputStreamH != null) {
                            inputStreamH.close();
                        }
                        byteArray = null;
                    } else {
                        while (true) {
                            try {
                                int i = inputStreamH.read(bArr);
                                if (i <= 0) {
                                    break;
                                }
                                gZIPOutputStream.write(bArr, 0, i);
                            } catch (Throwable th) {
                                try {
                                    gZIPOutputStream.close();
                                } catch (Throwable unused) {
                                }
                                throw th;
                            }
                        }
                        gZIPOutputStream.finish();
                        byteArray = byteArrayOutputStream.toByteArray();
                        gZIPOutputStream.close();
                        byteArrayOutputStream.close();
                        inputStreamH.close();
                    }
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable unused2) {
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                if (inputStreamH != null) {
                    try {
                        inputStreamH.close();
                    } catch (Throwable unused3) {
                    }
                }
                throw th3;
            }
        } catch (IOException unused4) {
        }
        if (byteArray == null) {
            return null;
        }
        Objects.requireNonNull(byteArray, "Null contents");
        String str = this.f1696b;
        Objects.requireNonNull(str, "Null filename");
        if (1 != 0) {
            return new b.i.c.m.d.m.e(str, byteArray, null);
        }
        throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", ""));
    }

    @Override // b.i.c.m.d.k.a1
    @Nullable
    public InputStream h() {
        if (this.a.exists() && this.a.isFile()) {
            try {
                return new FileInputStream(this.a);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }
}
