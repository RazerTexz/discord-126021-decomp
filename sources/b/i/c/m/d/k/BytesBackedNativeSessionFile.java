package b.i.c.m.d.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_FilesPayload_File;
import b.i.c.m.d.m.CrashlyticsReport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: renamed from: b.i.c.m.d.k.f, reason: use source file name */
/* JADX INFO: compiled from: BytesBackedNativeSessionFile.java */
/* JADX INFO: loaded from: classes3.dex */
public class BytesBackedNativeSessionFile implements NativeSessionFile {

    @Nullable
    public final byte[] a;

    public BytesBackedNativeSessionFile(@NonNull String str, @NonNull String str2, @Nullable byte[] bArr) {
        this.a = bArr;
    }

    @Override // b.i.c.m.d.k.NativeSessionFile
    @NonNull
    public String a() {
        return "logs";
    }

    @Override // b.i.c.m.d.k.NativeSessionFile
    @Nullable
    public CrashlyticsReport.c.a b() {
        byte[] byteArray;
        byte[] bArr = this.a;
        if (bArr == null || bArr.length == 0) {
            byteArray = null;
        } else {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream.write(this.a);
                        gZIPOutputStream.finish();
                        byteArray = byteArrayOutputStream.toByteArray();
                        gZIPOutputStream.close();
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        try {
                            gZIPOutputStream.close();
                        } catch (Throwable unused) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable unused2) {
                    }
                    throw th2;
                }
            } catch (IOException unused3) {
                byteArray = null;
            }
        }
        if (byteArray == null) {
            return null;
        }
        return new AutoValue_CrashlyticsReport_FilesPayload_File("logs_file", byteArray, null);
    }

    @Override // b.i.c.m.d.k.NativeSessionFile
    @Nullable
    public InputStream h() {
        byte[] bArr = this.a;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return new ByteArrayInputStream(this.a);
    }
}
