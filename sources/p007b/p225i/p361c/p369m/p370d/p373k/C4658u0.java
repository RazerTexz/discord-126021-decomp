package p007b.p225i.p361c.p369m.p370d.p373k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.zip.GZIPOutputStream;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v;
import p007b.p225i.p361c.p369m.p370d.p375m.C4678e;

/* JADX INFO: renamed from: b.i.c.m.d.k.u0 */
/* JADX INFO: compiled from: FileBackedNativeSessionFile.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4658u0 implements InterfaceC4609a1 {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final File f12398a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final String f12399b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final String f12400c;

    public C4658u0(@NonNull String str, @NonNull String str2, @NonNull File file) {
        this.f12399b = str;
        this.f12400c = str2;
        this.f12398a = file;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p373k.InterfaceC4609a1
    @NonNull
    /* JADX INFO: renamed from: a */
    public String mo6392a() {
        return this.f12400c;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p373k.InterfaceC4609a1
    @Nullable
    /* JADX INFO: renamed from: b */
    public AbstractC4695v.c.a mo6393b() {
        byte[] byteArray;
        byte[] bArr = new byte[8192];
        try {
            InputStream inputStreamMo6394h = mo6394h();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    if (inputStreamMo6394h == null) {
                        gZIPOutputStream.close();
                        byteArrayOutputStream.close();
                        if (inputStreamMo6394h != null) {
                            inputStreamMo6394h.close();
                        }
                        byteArray = null;
                    } else {
                        while (true) {
                            try {
                                int i = inputStreamMo6394h.read(bArr);
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
                        inputStreamMo6394h.close();
                    }
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable unused2) {
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                if (inputStreamMo6394h != null) {
                    try {
                        inputStreamMo6394h.close();
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
        String str = this.f12399b;
        Objects.requireNonNull(str, "Null filename");
        if (1 != 0) {
            return new C4678e(str, byteArray, null);
        }
        throw new IllegalStateException(C1643a.m883w("Missing required properties:", ""));
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p373k.InterfaceC4609a1
    @Nullable
    /* JADX INFO: renamed from: h */
    public InputStream mo6394h() {
        if (this.f12398a.exists() && this.f12398a.isFile()) {
            try {
                return new FileInputStream(this.f12398a);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }
}
