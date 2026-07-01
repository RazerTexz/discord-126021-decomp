package b.i.a.c.e3.b0;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: CachedContentIndex.java */
/* JADX INFO: loaded from: classes3.dex */
public class j$b implements j$c {
    public final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Cipher f934b;

    @Nullable
    public final SecretKeySpec c;

    @Nullable
    public final SecureRandom d;
    public final b.i.a.c.f3.e e;
    public boolean f;

    @Nullable
    public p g;

    public j$b(File file, @Nullable byte[] bArr, boolean z2) {
        Cipher cipher;
        SecretKeySpec secretKeySpec;
        b.c.a.a0.d.D((bArr == null && z2) ? false : true);
        if (bArr != null) {
            b.c.a.a0.d.j(bArr.length == 16);
            try {
                if (e0.a == 18) {
                    try {
                        cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
                    } catch (Throwable unused) {
                        cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                    }
                } else {
                    cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                }
                secretKeySpec = new SecretKeySpec(bArr, "AES");
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                throw new IllegalStateException(e);
            }
        } else {
            b.c.a.a0.d.j(!z2);
            cipher = null;
            secretKeySpec = null;
        }
        this.a = z2;
        this.f934b = cipher;
        this.c = secretKeySpec;
        this.d = z2 ? new SecureRandom() : null;
        this.e = new b.i.a.c.f3.e(file);
    }

    @Override // b.i.a.c.e3.b0.j$c
    public void a(i iVar, boolean z2) {
        this.f = true;
    }

    @Override // b.i.a.c.e3.b0.j$c
    public void b(HashMap<String, i> map) throws Throwable {
        DataOutputStream dataOutputStream = null;
        try {
            OutputStream outputStreamC = this.e.c();
            p pVar = this.g;
            if (pVar == null) {
                this.g = new p(outputStreamC);
            } else {
                pVar.a(outputStreamC);
            }
            p pVar2 = this.g;
            DataOutputStream dataOutputStream2 = new DataOutputStream(pVar2);
            try {
                dataOutputStream2.writeInt(2);
                dataOutputStream2.writeInt(this.a ? 1 : 0);
                if (this.a) {
                    byte[] bArr = new byte[16];
                    SecureRandom secureRandom = this.d;
                    int i = e0.a;
                    secureRandom.nextBytes(bArr);
                    dataOutputStream2.write(bArr);
                    try {
                        this.f934b.init(1, this.c, new IvParameterSpec(bArr));
                        dataOutputStream2.flush();
                        dataOutputStream2 = new DataOutputStream(new CipherOutputStream(pVar2, this.f934b));
                    } catch (InvalidAlgorithmParameterException e) {
                        e = e;
                        throw new IllegalStateException(e);
                    } catch (InvalidKeyException e2) {
                        e = e2;
                        throw new IllegalStateException(e);
                    }
                }
                dataOutputStream2.writeInt(map.size());
                int i2 = 0;
                for (i iVar : map.values()) {
                    dataOutputStream2.writeInt(iVar.a);
                    dataOutputStream2.writeUTF(iVar.f930b);
                    j.b(iVar.e, dataOutputStream2);
                    i2 += i(iVar, 2);
                }
                dataOutputStream2.writeInt(i2);
                b.i.a.c.f3.e eVar = this.e;
                Objects.requireNonNull(eVar);
                dataOutputStream2.close();
                eVar.f967b.delete();
                int i3 = e0.a;
                this.f = false;
            } catch (Throwable th) {
                th = th;
                dataOutputStream = dataOutputStream2;
                int i4 = e0.a;
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // b.i.a.c.e3.b0.j$c
    public void c(i iVar) {
        this.f = true;
    }

    @Override // b.i.a.c.e3.b0.j$c
    public boolean d() {
        return this.e.a();
    }

    @Override // b.i.a.c.e3.b0.j$c
    public void e(HashMap<String, i> map) throws Throwable {
        if (this.f) {
            b(map);
        }
    }

    @Override // b.i.a.c.e3.b0.j$c
    public void f(long j) {
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:76:? A[RETURN, SYNTHETIC] */
    @Override // b.i.a.c.e3.b0.j$c
    public void g(HashMap<String, i> map, SparseArray<String> sparseArray) throws Throwable {
        boolean z2 = true;
        b.c.a.a0.d.D(!this.f);
        if (this.e.a()) {
            DataInputStream dataInputStream = null;
            try {
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(this.e.b());
                    DataInputStream dataInputStream2 = new DataInputStream(bufferedInputStream);
                    try {
                        int i = dataInputStream2.readInt();
                        if (i >= 0 && i <= 2) {
                            if ((dataInputStream2.readInt() & 1) != 0) {
                                if (this.f934b != null) {
                                    byte[] bArr = new byte[16];
                                    dataInputStream2.readFully(bArr);
                                    IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
                                    try {
                                        Cipher cipher = this.f934b;
                                        SecretKeySpec secretKeySpec = this.c;
                                        int i2 = e0.a;
                                        cipher.init(2, secretKeySpec, ivParameterSpec);
                                        dataInputStream2 = new DataInputStream(new CipherInputStream(bufferedInputStream, this.f934b));
                                    } catch (InvalidAlgorithmParameterException e) {
                                        e = e;
                                        throw new IllegalStateException(e);
                                    } catch (InvalidKeyException e2) {
                                        e = e2;
                                        throw new IllegalStateException(e);
                                    }
                                }
                            } else if (this.a) {
                                this.f = true;
                            }
                            int i3 = dataInputStream2.readInt();
                            int i4 = 0;
                            for (int i5 = 0; i5 < i3; i5++) {
                                i iVarJ = j(i, dataInputStream2);
                                map.put(iVarJ.f930b, iVarJ);
                                sparseArray.put(iVarJ.a, iVarJ.f930b);
                                i4 += i(iVarJ, i);
                            }
                            int i6 = dataInputStream2.readInt();
                            boolean z3 = dataInputStream2.read() == -1;
                            if (i6 == i4 && z3) {
                                int i7 = e0.a;
                                try {
                                    dataInputStream2.close();
                                } catch (IOException unused) {
                                }
                            }
                        }
                        int i8 = e0.a;
                        dataInputStream2.close();
                    } catch (IOException unused2) {
                        dataInputStream = dataInputStream2;
                        if (dataInputStream != null) {
                            int i9 = e0.a;
                            dataInputStream.close();
                        }
                        z2 = false;
                        if (z2) {
                        }
                        map.clear();
                        sparseArray.clear();
                        b.i.a.c.f3.e eVar = this.e;
                        eVar.a.delete();
                        eVar.f967b.delete();
                    } catch (Throwable th) {
                        th = th;
                        dataInputStream = dataInputStream2;
                        if (dataInputStream != null) {
                            int i10 = e0.a;
                            try {
                                dataInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException unused4) {
                }
            } catch (IOException unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
            z2 = false;
        }
        if (z2) {
            map.clear();
            sparseArray.clear();
            b.i.a.c.f3.e eVar2 = this.e;
            eVar2.a.delete();
            eVar2.f967b.delete();
        }
    }

    @Override // b.i.a.c.e3.b0.j$c
    public void h() {
        b.i.a.c.f3.e eVar = this.e;
        eVar.a.delete();
        eVar.f967b.delete();
    }

    public final int i(i iVar, int i) {
        int iHashCode = iVar.f930b.hashCode() + (iVar.a * 31);
        if (i >= 2) {
            return (iHashCode * 31) + iVar.e.hashCode();
        }
        long jA = k.a(iVar.e);
        return (iHashCode * 31) + ((int) (jA ^ (jA >>> 32)));
    }

    public final i j(int i, DataInputStream dataInputStream) throws IOException {
        n nVarA;
        int i2 = dataInputStream.readInt();
        String utf = dataInputStream.readUTF();
        if (i < 2) {
            long j = dataInputStream.readLong();
            m mVar = new m();
            m.a(mVar, j);
            nVarA = n.a.a(mVar);
        } else {
            nVarA = j.a(dataInputStream);
        }
        return new i(i2, utf, nVarA);
    }
}
