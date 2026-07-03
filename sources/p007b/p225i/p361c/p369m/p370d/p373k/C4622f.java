package p007b.p225i.p361c.p369m.p370d.p373k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;
import p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v;
import p007b.p225i.p361c.p369m.p370d.p375m.C4678e;

/* JADX INFO: renamed from: b.i.c.m.d.k.f */
/* JADX INFO: compiled from: BytesBackedNativeSessionFile.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4622f implements InterfaceC4609a1 {

    /* JADX INFO: renamed from: a */
    @Nullable
    public final byte[] f12285a;

    public C4622f(@NonNull String str, @NonNull String str2, @Nullable byte[] bArr) {
        this.f12285a = bArr;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p373k.InterfaceC4609a1
    @NonNull
    /* JADX INFO: renamed from: a */
    public String mo6392a() {
        return "logs";
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p373k.InterfaceC4609a1
    @Nullable
    /* JADX INFO: renamed from: b */
    public AbstractC4695v.c.a mo6393b() {
        byte[] byteArray;
        byte[] bArr = this.f12285a;
        if (bArr == null || bArr.length == 0) {
            byteArray = null;
        } else {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream.write(this.f12285a);
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
        return new C4678e("logs_file", byteArray, null);
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p373k.InterfaceC4609a1
    @Nullable
    /* JADX INFO: renamed from: h */
    public InputStream mo6394h() {
        byte[] bArr = this.f12285a;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return new ByteArrayInputStream(this.f12285a);
    }
}
