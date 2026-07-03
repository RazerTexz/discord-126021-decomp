package p007b.p225i.p226a.p242c.p257e3.p258b0;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.exoplayer2.database.DatabaseIOException;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p259f3.C2737e;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p264u2.C2949d;
import p007b.p225i.p226a.p242c.p264u2.InterfaceC2946a;

/* JADX INFO: renamed from: b.i.a.c.e3.b0.j */
/* JADX INFO: compiled from: CachedContentIndex.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2691j {

    /* JADX INFO: renamed from: a */
    public final HashMap<String, C2690i> f6478a;

    /* JADX INFO: renamed from: b */
    public final SparseArray<String> f6479b;

    /* JADX INFO: renamed from: c */
    public final SparseBooleanArray f6480c;

    /* JADX INFO: renamed from: d */
    public final SparseBooleanArray f6481d;

    /* JADX INFO: renamed from: e */
    public c f6482e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public c f6483f;

    /* JADX INFO: renamed from: b.i.a.c.e3.b0.j$a */
    /* JADX INFO: compiled from: CachedContentIndex.java */
    public static final class a implements c {

        /* JADX INFO: renamed from: a */
        public static final String[] f6484a = {ModelAuditLogEntry.CHANGE_KEY_ID, "key", "metadata"};

        /* JADX INFO: renamed from: b */
        public final InterfaceC2946a f6485b;

        /* JADX INFO: renamed from: c */
        public final SparseArray<C2690i> f6486c = new SparseArray<>();

        /* JADX INFO: renamed from: d */
        public String f6487d;

        /* JADX INFO: renamed from: e */
        public String f6488e;

        public a(InterfaceC2946a interfaceC2946a) {
            this.f6485b = interfaceC2946a;
        }

        /* JADX INFO: renamed from: j */
        public static void m2800j(SQLiteDatabase sQLiteDatabase, String str) {
            String strValueOf = String.valueOf(str);
            sQLiteDatabase.execSQL(strValueOf.length() != 0 ? "DROP TABLE IF EXISTS ".concat(strValueOf) : new String("DROP TABLE IF EXISTS "));
        }

        /* JADX INFO: renamed from: k */
        public static String m2801k(String str) {
            String strValueOf = String.valueOf(str);
            return strValueOf.length() != 0 ? "ExoPlayerCacheIndex".concat(strValueOf) : new String("ExoPlayerCacheIndex");
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.C2691j.c
        /* JADX INFO: renamed from: a */
        public void mo2802a(C2690i c2690i, boolean z2) {
            if (z2) {
                this.f6486c.delete(c2690i.f6471a);
            } else {
                this.f6486c.put(c2690i.f6471a, null);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.C2691j.c
        /* JADX INFO: renamed from: b */
        public void mo2803b(HashMap<String, C2690i> map) throws IOException {
            try {
                SQLiteDatabase writableDatabase = this.f6485b.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    m2811l(writableDatabase);
                    Iterator<C2690i> it = map.values().iterator();
                    while (it.hasNext()) {
                        m2810i(writableDatabase, it.next());
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.f6486c.clear();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e) {
                throw new DatabaseIOException(e);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.C2691j.c
        /* JADX INFO: renamed from: c */
        public void mo2804c(C2690i c2690i) {
            this.f6486c.put(c2690i.f6471a, c2690i);
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.C2691j.c
        /* JADX INFO: renamed from: d */
        public boolean mo2805d() throws DatabaseIOException {
            SQLiteDatabase readableDatabase = this.f6485b.getReadableDatabase();
            String str = this.f6487d;
            Objects.requireNonNull(str);
            return C2949d.m3545a(readableDatabase, 1, str) != -1;
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.C2691j.c
        /* JADX INFO: renamed from: e */
        public void mo2806e(HashMap<String, C2690i> map) throws IOException {
            if (this.f6486c.size() == 0) {
                return;
            }
            try {
                SQLiteDatabase writableDatabase = this.f6485b.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                for (int i = 0; i < this.f6486c.size(); i++) {
                    try {
                        C2690i c2690iValueAt = this.f6486c.valueAt(i);
                        if (c2690iValueAt == null) {
                            int iKeyAt = this.f6486c.keyAt(i);
                            String str = this.f6488e;
                            Objects.requireNonNull(str);
                            writableDatabase.delete(str, "id = ?", new String[]{Integer.toString(iKeyAt)});
                        } else {
                            m2810i(writableDatabase, c2690iValueAt);
                        }
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                writableDatabase.setTransactionSuccessful();
                this.f6486c.clear();
                writableDatabase.endTransaction();
            } catch (SQLException e) {
                throw new DatabaseIOException(e);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.C2691j.c
        /* JADX INFO: renamed from: f */
        public void mo2807f(long j) {
            String hexString = Long.toHexString(j);
            this.f6487d = hexString;
            this.f6488e = m2801k(hexString);
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.C2691j.c
        /* JADX INFO: renamed from: g */
        public void mo2808g(HashMap<String, C2690i> map, SparseArray<String> sparseArray) throws IOException {
            C1460d.m426D(this.f6486c.size() == 0);
            try {
                SQLiteDatabase readableDatabase = this.f6485b.getReadableDatabase();
                String str = this.f6487d;
                Objects.requireNonNull(str);
                if (C2949d.m3545a(readableDatabase, 1, str) != 1) {
                    SQLiteDatabase writableDatabase = this.f6485b.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        m2811l(writableDatabase);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                SQLiteDatabase readableDatabase2 = this.f6485b.getReadableDatabase();
                String str2 = this.f6488e;
                Objects.requireNonNull(str2);
                Cursor cursorQuery = readableDatabase2.query(str2, f6484a, null, null, null, null, null);
                while (cursorQuery.moveToNext()) {
                    try {
                        int i = cursorQuery.getInt(0);
                        String string = cursorQuery.getString(1);
                        Objects.requireNonNull(string);
                        map.put(string, new C2690i(i, string, C2691j.m2793a(new DataInputStream(new ByteArrayInputStream(cursorQuery.getBlob(2))))));
                        sparseArray.put(i, string);
                    } catch (Throwable th2) {
                        if (cursorQuery != null) {
                            try {
                                cursorQuery.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
                cursorQuery.close();
            } catch (SQLiteException e) {
                map.clear();
                sparseArray.clear();
                throw new DatabaseIOException(e);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.C2691j.c
        /* JADX INFO: renamed from: h */
        public void mo2809h() throws DatabaseIOException {
            InterfaceC2946a interfaceC2946a = this.f6485b;
            String str = this.f6487d;
            Objects.requireNonNull(str);
            try {
                String strM2801k = m2801k(str);
                SQLiteDatabase writableDatabase = interfaceC2946a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    int i = C2949d.f7887a;
                    try {
                        if (C2738e0.m2989J(writableDatabase, "ExoPlayerVersions")) {
                            writableDatabase.delete("ExoPlayerVersions", "feature = ? AND instance_uid = ?", new String[]{Integer.toString(1), str});
                        }
                        m2800j(writableDatabase, strM2801k);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (SQLException e) {
                        throw new DatabaseIOException(e);
                    }
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }

        /* JADX INFO: renamed from: i */
        public final void m2810i(SQLiteDatabase sQLiteDatabase, C2690i c2690i) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            C2691j.m2794b(c2690i.f6475e, new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ModelAuditLogEntry.CHANGE_KEY_ID, Integer.valueOf(c2690i.f6471a));
            contentValues.put("key", c2690i.f6472b);
            contentValues.put("metadata", byteArray);
            String str = this.f6488e;
            Objects.requireNonNull(str);
            sQLiteDatabase.replaceOrThrow(str, null, contentValues);
        }

        /* JADX INFO: renamed from: l */
        public final void m2811l(SQLiteDatabase sQLiteDatabase) throws DatabaseIOException {
            String str = this.f6487d;
            Objects.requireNonNull(str);
            C2949d.m3546b(sQLiteDatabase, 1, str, 1);
            String str2 = this.f6488e;
            Objects.requireNonNull(str2);
            m2800j(sQLiteDatabase, str2);
            String str3 = this.f6488e;
            sQLiteDatabase.execSQL(C1643a.m861l(C1643a.m841b(str3, 88), "CREATE TABLE ", str3, " ", "(id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)"));
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.e3.b0.j$b */
    /* JADX INFO: compiled from: CachedContentIndex.java */
    public static class b implements c {

        /* JADX INFO: renamed from: a */
        public final boolean f6489a;

        /* JADX INFO: renamed from: b */
        @Nullable
        public final Cipher f6490b;

        /* JADX INFO: renamed from: c */
        @Nullable
        public final SecretKeySpec f6491c;

        /* JADX INFO: renamed from: d */
        @Nullable
        public final SecureRandom f6492d;

        /* JADX INFO: renamed from: e */
        public final C2737e f6493e;

        /* JADX INFO: renamed from: f */
        public boolean f6494f;

        /* JADX INFO: renamed from: g */
        @Nullable
        public C2697p f6495g;

        public b(File file, @Nullable byte[] bArr, boolean z2) {
            Cipher cipher;
            SecretKeySpec secretKeySpec;
            C1460d.m426D((bArr == null && z2) ? false : true);
            if (bArr != null) {
                C1460d.m531j(bArr.length == 16);
                try {
                    if (C2738e0.f6708a == 18) {
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
                C1460d.m531j(!z2);
                cipher = null;
                secretKeySpec = null;
            }
            this.f6489a = z2;
            this.f6490b = cipher;
            this.f6491c = secretKeySpec;
            this.f6492d = z2 ? new SecureRandom() : null;
            this.f6493e = new C2737e(file);
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.C2691j.c
        /* JADX INFO: renamed from: a */
        public void mo2802a(C2690i c2690i, boolean z2) {
            this.f6494f = true;
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.C2691j.c
        /* JADX INFO: renamed from: b */
        public void mo2803b(HashMap<String, C2690i> map) throws Throwable {
            DataOutputStream dataOutputStream = null;
            try {
                OutputStream outputStreamM2979c = this.f6493e.m2979c();
                C2697p c2697p = this.f6495g;
                if (c2697p == null) {
                    this.f6495g = new C2697p(outputStreamM2979c);
                } else {
                    c2697p.m2822a(outputStreamM2979c);
                }
                C2697p c2697p2 = this.f6495g;
                DataOutputStream dataOutputStream2 = new DataOutputStream(c2697p2);
                try {
                    dataOutputStream2.writeInt(2);
                    dataOutputStream2.writeInt(this.f6489a ? 1 : 0);
                    if (this.f6489a) {
                        byte[] bArr = new byte[16];
                        SecureRandom secureRandom = this.f6492d;
                        int i = C2738e0.f6708a;
                        secureRandom.nextBytes(bArr);
                        dataOutputStream2.write(bArr);
                        try {
                            this.f6490b.init(1, this.f6491c, new IvParameterSpec(bArr));
                            dataOutputStream2.flush();
                            dataOutputStream2 = new DataOutputStream(new CipherOutputStream(c2697p2, this.f6490b));
                        } catch (InvalidAlgorithmParameterException e) {
                            e = e;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e2) {
                            e = e2;
                            throw new IllegalStateException(e);
                        }
                    }
                    dataOutputStream2.writeInt(map.size());
                    int iM2812i = 0;
                    for (C2690i c2690i : map.values()) {
                        dataOutputStream2.writeInt(c2690i.f6471a);
                        dataOutputStream2.writeUTF(c2690i.f6472b);
                        C2691j.m2794b(c2690i.f6475e, dataOutputStream2);
                        iM2812i += m2812i(c2690i, 2);
                    }
                    dataOutputStream2.writeInt(iM2812i);
                    C2737e c2737e = this.f6493e;
                    Objects.requireNonNull(c2737e);
                    dataOutputStream2.close();
                    c2737e.f6705b.delete();
                    int i2 = C2738e0.f6708a;
                    this.f6494f = false;
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    int i3 = C2738e0.f6708a;
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

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.C2691j.c
        /* JADX INFO: renamed from: c */
        public void mo2804c(C2690i c2690i) {
            this.f6494f = true;
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.C2691j.c
        /* JADX INFO: renamed from: d */
        public boolean mo2805d() {
            return this.f6493e.m2977a();
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.C2691j.c
        /* JADX INFO: renamed from: e */
        public void mo2806e(HashMap<String, C2690i> map) throws Throwable {
            if (this.f6494f) {
                mo2803b(map);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.C2691j.c
        /* JADX INFO: renamed from: f */
        public void mo2807f(long j) {
        }

        /* JADX WARN: Code duplicated, block: B:60:0x00c7  */
        /* JADX WARN: Code duplicated, block: B:76:? A[RETURN, SYNTHETIC] */
        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.C2691j.c
        /* JADX INFO: renamed from: g */
        public void mo2808g(HashMap<String, C2690i> map, SparseArray<String> sparseArray) throws Throwable {
            boolean z2 = true;
            C1460d.m426D(!this.f6494f);
            if (this.f6493e.m2977a()) {
                DataInputStream dataInputStream = null;
                try {
                    try {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(this.f6493e.m2978b());
                        DataInputStream dataInputStream2 = new DataInputStream(bufferedInputStream);
                        try {
                            int i = dataInputStream2.readInt();
                            if (i >= 0 && i <= 2) {
                                if ((dataInputStream2.readInt() & 1) != 0) {
                                    if (this.f6490b != null) {
                                        byte[] bArr = new byte[16];
                                        dataInputStream2.readFully(bArr);
                                        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
                                        try {
                                            Cipher cipher = this.f6490b;
                                            SecretKeySpec secretKeySpec = this.f6491c;
                                            int i2 = C2738e0.f6708a;
                                            cipher.init(2, secretKeySpec, ivParameterSpec);
                                            dataInputStream2 = new DataInputStream(new CipherInputStream(bufferedInputStream, this.f6490b));
                                        } catch (InvalidAlgorithmParameterException e) {
                                            e = e;
                                            throw new IllegalStateException(e);
                                        } catch (InvalidKeyException e2) {
                                            e = e2;
                                            throw new IllegalStateException(e);
                                        }
                                    }
                                } else if (this.f6489a) {
                                    this.f6494f = true;
                                }
                                int i3 = dataInputStream2.readInt();
                                int iM2812i = 0;
                                for (int i4 = 0; i4 < i3; i4++) {
                                    C2690i c2690iM2813j = m2813j(i, dataInputStream2);
                                    map.put(c2690iM2813j.f6472b, c2690iM2813j);
                                    sparseArray.put(c2690iM2813j.f6471a, c2690iM2813j.f6472b);
                                    iM2812i += m2812i(c2690iM2813j, i);
                                }
                                int i5 = dataInputStream2.readInt();
                                boolean z3 = dataInputStream2.read() == -1;
                                if (i5 == iM2812i && z3) {
                                    int i6 = C2738e0.f6708a;
                                    try {
                                        dataInputStream2.close();
                                    } catch (IOException unused) {
                                    }
                                }
                            }
                            int i7 = C2738e0.f6708a;
                            dataInputStream2.close();
                        } catch (IOException unused2) {
                            dataInputStream = dataInputStream2;
                            if (dataInputStream != null) {
                                int i8 = C2738e0.f6708a;
                                dataInputStream.close();
                            }
                            z2 = false;
                            if (z2) {
                            }
                            map.clear();
                            sparseArray.clear();
                            C2737e c2737e = this.f6493e;
                            c2737e.f6704a.delete();
                            c2737e.f6705b.delete();
                        } catch (Throwable th) {
                            th = th;
                            dataInputStream = dataInputStream2;
                            if (dataInputStream != null) {
                                int i9 = C2738e0.f6708a;
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
                C2737e c2737e2 = this.f6493e;
                c2737e2.f6704a.delete();
                c2737e2.f6705b.delete();
            }
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.C2691j.c
        /* JADX INFO: renamed from: h */
        public void mo2809h() {
            C2737e c2737e = this.f6493e;
            c2737e.f6704a.delete();
            c2737e.f6705b.delete();
        }

        /* JADX INFO: renamed from: i */
        public final int m2812i(C2690i c2690i, int i) {
            int iHashCode = c2690i.f6472b.hashCode() + (c2690i.f6471a * 31);
            if (i >= 2) {
                return (iHashCode * 31) + c2690i.f6475e.hashCode();
            }
            long jM2814a = C2692k.m2814a(c2690i.f6475e);
            return (iHashCode * 31) + ((int) (jM2814a ^ (jM2814a >>> 32)));
        }

        /* JADX INFO: renamed from: j */
        public final C2690i m2813j(int i, DataInputStream dataInputStream) throws IOException {
            C2695n c2695nM2793a;
            int i2 = dataInputStream.readInt();
            String utf = dataInputStream.readUTF();
            if (i < 2) {
                long j = dataInputStream.readLong();
                C2694m c2694m = new C2694m();
                C2694m.m2815a(c2694m, j);
                c2695nM2793a = C2695n.f6498a.m2817a(c2694m);
            } else {
                c2695nM2793a = C2691j.m2793a(dataInputStream);
            }
            return new C2690i(i2, utf, c2695nM2793a);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.e3.b0.j$c */
    /* JADX INFO: compiled from: CachedContentIndex.java */
    public interface c {
        /* JADX INFO: renamed from: a */
        void mo2802a(C2690i c2690i, boolean z2);

        /* JADX INFO: renamed from: b */
        void mo2803b(HashMap<String, C2690i> map) throws IOException;

        /* JADX INFO: renamed from: c */
        void mo2804c(C2690i c2690i);

        /* JADX INFO: renamed from: d */
        boolean mo2805d() throws IOException;

        /* JADX INFO: renamed from: e */
        void mo2806e(HashMap<String, C2690i> map) throws IOException;

        /* JADX INFO: renamed from: f */
        void mo2807f(long j);

        /* JADX INFO: renamed from: g */
        void mo2808g(HashMap<String, C2690i> map, SparseArray<String> sparseArray) throws IOException;

        /* JADX INFO: renamed from: h */
        void mo2809h() throws IOException;
    }

    public C2691j(@Nullable InterfaceC2946a interfaceC2946a, @Nullable File file, @Nullable byte[] bArr, boolean z2, boolean z3) {
        C1460d.m426D((interfaceC2946a == null && file == null) ? false : true);
        this.f6478a = new HashMap<>();
        this.f6479b = new SparseArray<>();
        this.f6480c = new SparseBooleanArray();
        this.f6481d = new SparseBooleanArray();
        a aVar = interfaceC2946a != null ? new a(interfaceC2946a) : null;
        b bVar = file != null ? new b(new File(file, "cached_content_index.exi"), bArr, z2) : null;
        if (aVar != null && (bVar == null || !z3)) {
            this.f6482e = aVar;
            this.f6483f = bVar;
        } else {
            int i = C2738e0.f6708a;
            this.f6482e = bVar;
            this.f6483f = aVar;
        }
    }

    /* JADX INFO: renamed from: a */
    public static C2695n m2793a(DataInputStream dataInputStream) throws IOException {
        int i = dataInputStream.readInt();
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < i; i2++) {
            String utf = dataInputStream.readUTF();
            int i3 = dataInputStream.readInt();
            if (i3 < 0) {
                throw new IOException(C1643a.m851g(31, "Invalid value size: ", i3));
            }
            int iMin = Math.min(i3, 10485760);
            byte[] bArrCopyOf = C2738e0.f6713f;
            int i4 = 0;
            while (i4 != i3) {
                int i5 = i4 + iMin;
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i5);
                dataInputStream.readFully(bArrCopyOf, i4, iMin);
                iMin = Math.min(i3 - i5, 10485760);
                i4 = i5;
            }
            map.put(utf, bArrCopyOf);
        }
        return new C2695n(map);
    }

    /* JADX INFO: renamed from: b */
    public static void m2794b(C2695n c2695n, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry<String, byte[]>> setEntrySet = c2695n.f6500c.entrySet();
        dataOutputStream.writeInt(setEntrySet.size());
        for (Map.Entry<String, byte[]> entry : setEntrySet) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public C2690i m2795c(String str) {
        return this.f6478a.get(str);
    }

    /* JADX INFO: renamed from: d */
    public C2690i m2796d(String str) {
        C2690i c2690i = this.f6478a.get(str);
        if (c2690i != null) {
            return c2690i;
        }
        SparseArray<String> sparseArray = this.f6479b;
        int size = sparseArray.size();
        int i = 0;
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt < 0) {
            while (i < size && i == sparseArray.keyAt(i)) {
                i++;
            }
            iKeyAt = i;
        }
        C2690i c2690i2 = new C2690i(iKeyAt, str, C2695n.f6498a);
        this.f6478a.put(str, c2690i2);
        this.f6479b.put(iKeyAt, str);
        this.f6481d.put(iKeyAt, true);
        this.f6482e.mo2804c(c2690i2);
        return c2690i2;
    }

    @WorkerThread
    /* JADX INFO: renamed from: e */
    public void m2797e(long j) throws IOException {
        c cVar;
        this.f6482e.mo2807f(j);
        c cVar2 = this.f6483f;
        if (cVar2 != null) {
            cVar2.mo2807f(j);
        }
        if (this.f6482e.mo2805d() || (cVar = this.f6483f) == null || !cVar.mo2805d()) {
            this.f6482e.mo2808g(this.f6478a, this.f6479b);
        } else {
            this.f6483f.mo2808g(this.f6478a, this.f6479b);
            this.f6482e.mo2803b(this.f6478a);
        }
        c cVar3 = this.f6483f;
        if (cVar3 != null) {
            cVar3.mo2809h();
            this.f6483f = null;
        }
    }

    /* JADX INFO: renamed from: f */
    public void m2798f(String str) {
        C2690i c2690i = this.f6478a.get(str);
        if (c2690i != null && c2690i.f6473c.isEmpty() && c2690i.f6474d.isEmpty()) {
            this.f6478a.remove(str);
            int i = c2690i.f6471a;
            boolean z2 = this.f6481d.get(i);
            this.f6482e.mo2802a(c2690i, z2);
            if (z2) {
                this.f6479b.remove(i);
                this.f6481d.delete(i);
            } else {
                this.f6479b.put(i, null);
                this.f6480c.put(i, true);
            }
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: g */
    public void m2799g() throws IOException {
        this.f6482e.mo2806e(this.f6478a);
        int size = this.f6480c.size();
        for (int i = 0; i < size; i++) {
            this.f6479b.remove(this.f6480c.keyAt(i));
        }
        this.f6480c.clear();
        this.f6481d.clear();
    }
}
