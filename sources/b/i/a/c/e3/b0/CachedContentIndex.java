package b.i.a.c.e3.b0;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.f3.AtomicFile3;
import b.i.a.c.f3.Util2;
import b.i.a.c.u2.DatabaseProvider;
import b.i.a.c.u2.VersionTable;
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

/* JADX INFO: renamed from: b.i.a.c.e3.b0.j, reason: use source file name */
/* JADX INFO: compiled from: CachedContentIndex.java */
/* JADX INFO: loaded from: classes3.dex */
public class CachedContentIndex {
    public final HashMap<String, CachedContent> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<String> f932b;
    public final SparseBooleanArray c;
    public final SparseBooleanArray d;
    public c e;

    @Nullable
    public c f;

    /* JADX INFO: renamed from: b.i.a.c.e3.b0.j$a */
    /* JADX INFO: compiled from: CachedContentIndex.java */
    public static final class a implements c {
        public static final String[] a = {ModelAuditLogEntry.CHANGE_KEY_ID, "key", "metadata"};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DatabaseProvider f933b;
        public final SparseArray<CachedContent> c = new SparseArray<>();
        public String d;
        public String e;

        public a(DatabaseProvider databaseProvider) {
            this.f933b = databaseProvider;
        }

        public static void j(SQLiteDatabase sQLiteDatabase, String str) {
            String strValueOf = String.valueOf(str);
            sQLiteDatabase.execSQL(strValueOf.length() != 0 ? "DROP TABLE IF EXISTS ".concat(strValueOf) : new String("DROP TABLE IF EXISTS "));
        }

        public static String k(String str) {
            String strValueOf = String.valueOf(str);
            return strValueOf.length() != 0 ? "ExoPlayerCacheIndex".concat(strValueOf) : new String("ExoPlayerCacheIndex");
        }

        @Override // b.i.a.c.e3.b0.CachedContentIndex.c
        public void a(CachedContent cachedContent, boolean z2) {
            if (z2) {
                this.c.delete(cachedContent.a);
            } else {
                this.c.put(cachedContent.a, null);
            }
        }

        @Override // b.i.a.c.e3.b0.CachedContentIndex.c
        public void b(HashMap<String, CachedContent> map) throws IOException {
            try {
                SQLiteDatabase writableDatabase = this.f933b.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    l(writableDatabase);
                    Iterator<CachedContent> it = map.values().iterator();
                    while (it.hasNext()) {
                        i(writableDatabase, it.next());
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.c.clear();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e) {
                throw new DatabaseIOException(e);
            }
        }

        @Override // b.i.a.c.e3.b0.CachedContentIndex.c
        public void c(CachedContent cachedContent) {
            this.c.put(cachedContent.a, cachedContent);
        }

        @Override // b.i.a.c.e3.b0.CachedContentIndex.c
        public boolean d() throws DatabaseIOException {
            SQLiteDatabase readableDatabase = this.f933b.getReadableDatabase();
            String str = this.d;
            Objects.requireNonNull(str);
            return VersionTable.a(readableDatabase, 1, str) != -1;
        }

        @Override // b.i.a.c.e3.b0.CachedContentIndex.c
        public void e(HashMap<String, CachedContent> map) throws IOException {
            if (this.c.size() == 0) {
                return;
            }
            try {
                SQLiteDatabase writableDatabase = this.f933b.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                for (int i = 0; i < this.c.size(); i++) {
                    try {
                        CachedContent cachedContentValueAt = this.c.valueAt(i);
                        if (cachedContentValueAt == null) {
                            int iKeyAt = this.c.keyAt(i);
                            String str = this.e;
                            Objects.requireNonNull(str);
                            writableDatabase.delete(str, "id = ?", new String[]{Integer.toString(iKeyAt)});
                        } else {
                            i(writableDatabase, cachedContentValueAt);
                        }
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                writableDatabase.setTransactionSuccessful();
                this.c.clear();
                writableDatabase.endTransaction();
            } catch (SQLException e) {
                throw new DatabaseIOException(e);
            }
        }

        @Override // b.i.a.c.e3.b0.CachedContentIndex.c
        public void f(long j) {
            String hexString = Long.toHexString(j);
            this.d = hexString;
            this.e = k(hexString);
        }

        @Override // b.i.a.c.e3.b0.CachedContentIndex.c
        public void g(HashMap<String, CachedContent> map, SparseArray<String> sparseArray) throws IOException {
            AnimatableValueParser.D(this.c.size() == 0);
            try {
                SQLiteDatabase readableDatabase = this.f933b.getReadableDatabase();
                String str = this.d;
                Objects.requireNonNull(str);
                if (VersionTable.a(readableDatabase, 1, str) != 1) {
                    SQLiteDatabase writableDatabase = this.f933b.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        l(writableDatabase);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                SQLiteDatabase readableDatabase2 = this.f933b.getReadableDatabase();
                String str2 = this.e;
                Objects.requireNonNull(str2);
                Cursor cursorQuery = readableDatabase2.query(str2, a, null, null, null, null, null);
                while (cursorQuery.moveToNext()) {
                    try {
                        int i = cursorQuery.getInt(0);
                        String string = cursorQuery.getString(1);
                        Objects.requireNonNull(string);
                        map.put(string, new CachedContent(i, string, CachedContentIndex.a(new DataInputStream(new ByteArrayInputStream(cursorQuery.getBlob(2))))));
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

        @Override // b.i.a.c.e3.b0.CachedContentIndex.c
        public void h() throws DatabaseIOException {
            DatabaseProvider databaseProvider = this.f933b;
            String str = this.d;
            Objects.requireNonNull(str);
            try {
                String strK = k(str);
                SQLiteDatabase writableDatabase = databaseProvider.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    int i = VersionTable.a;
                    try {
                        if (Util2.J(writableDatabase, "ExoPlayerVersions")) {
                            writableDatabase.delete("ExoPlayerVersions", "feature = ? AND instance_uid = ?", new String[]{Integer.toString(1), str});
                        }
                        j(writableDatabase, strK);
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

        public final void i(SQLiteDatabase sQLiteDatabase, CachedContent cachedContent) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            CachedContentIndex.b(cachedContent.e, new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ModelAuditLogEntry.CHANGE_KEY_ID, Integer.valueOf(cachedContent.a));
            contentValues.put("key", cachedContent.f930b);
            contentValues.put("metadata", byteArray);
            String str = this.e;
            Objects.requireNonNull(str);
            sQLiteDatabase.replaceOrThrow(str, null, contentValues);
        }

        public final void l(SQLiteDatabase sQLiteDatabase) throws DatabaseIOException {
            String str = this.d;
            Objects.requireNonNull(str);
            VersionTable.b(sQLiteDatabase, 1, str, 1);
            String str2 = this.e;
            Objects.requireNonNull(str2);
            j(sQLiteDatabase, str2);
            String str3 = this.e;
            sQLiteDatabase.execSQL(outline.l(outline.b(str3, 88), "CREATE TABLE ", str3, " ", "(id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)"));
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.e3.b0.j$b */
    /* JADX INFO: compiled from: CachedContentIndex.java */
    public static class b implements c {
        public final boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final Cipher f934b;

        @Nullable
        public final SecretKeySpec c;

        @Nullable
        public final SecureRandom d;
        public final AtomicFile3 e;
        public boolean f;

        @Nullable
        public ReusableBufferedOutputStream g;

        public b(File file, @Nullable byte[] bArr, boolean z2) {
            Cipher cipher;
            SecretKeySpec secretKeySpec;
            AnimatableValueParser.D((bArr == null && z2) ? false : true);
            if (bArr != null) {
                AnimatableValueParser.j(bArr.length == 16);
                try {
                    if (Util2.a == 18) {
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
                AnimatableValueParser.j(!z2);
                cipher = null;
                secretKeySpec = null;
            }
            this.a = z2;
            this.f934b = cipher;
            this.c = secretKeySpec;
            this.d = z2 ? new SecureRandom() : null;
            this.e = new AtomicFile3(file);
        }

        @Override // b.i.a.c.e3.b0.CachedContentIndex.c
        public void a(CachedContent cachedContent, boolean z2) {
            this.f = true;
        }

        @Override // b.i.a.c.e3.b0.CachedContentIndex.c
        public void b(HashMap<String, CachedContent> map) throws Throwable {
            DataOutputStream dataOutputStream = null;
            try {
                OutputStream outputStreamC = this.e.c();
                ReusableBufferedOutputStream reusableBufferedOutputStream = this.g;
                if (reusableBufferedOutputStream == null) {
                    this.g = new ReusableBufferedOutputStream(outputStreamC);
                } else {
                    reusableBufferedOutputStream.a(outputStreamC);
                }
                ReusableBufferedOutputStream reusableBufferedOutputStream2 = this.g;
                DataOutputStream dataOutputStream2 = new DataOutputStream(reusableBufferedOutputStream2);
                try {
                    dataOutputStream2.writeInt(2);
                    dataOutputStream2.writeInt(this.a ? 1 : 0);
                    if (this.a) {
                        byte[] bArr = new byte[16];
                        SecureRandom secureRandom = this.d;
                        int i = Util2.a;
                        secureRandom.nextBytes(bArr);
                        dataOutputStream2.write(bArr);
                        try {
                            this.f934b.init(1, this.c, new IvParameterSpec(bArr));
                            dataOutputStream2.flush();
                            dataOutputStream2 = new DataOutputStream(new CipherOutputStream(reusableBufferedOutputStream2, this.f934b));
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
                    for (CachedContent cachedContent : map.values()) {
                        dataOutputStream2.writeInt(cachedContent.a);
                        dataOutputStream2.writeUTF(cachedContent.f930b);
                        CachedContentIndex.b(cachedContent.e, dataOutputStream2);
                        i2 += i(cachedContent, 2);
                    }
                    dataOutputStream2.writeInt(i2);
                    AtomicFile3 atomicFile3 = this.e;
                    Objects.requireNonNull(atomicFile3);
                    dataOutputStream2.close();
                    atomicFile3.f967b.delete();
                    int i3 = Util2.a;
                    this.f = false;
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    int i4 = Util2.a;
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

        @Override // b.i.a.c.e3.b0.CachedContentIndex.c
        public void c(CachedContent cachedContent) {
            this.f = true;
        }

        @Override // b.i.a.c.e3.b0.CachedContentIndex.c
        public boolean d() {
            return this.e.a();
        }

        @Override // b.i.a.c.e3.b0.CachedContentIndex.c
        public void e(HashMap<String, CachedContent> map) throws Throwable {
            if (this.f) {
                b(map);
            }
        }

        @Override // b.i.a.c.e3.b0.CachedContentIndex.c
        public void f(long j) {
        }

        /* JADX WARN: Code duplicated, block: B:60:0x00c7  */
        /* JADX WARN: Code duplicated, block: B:76:? A[RETURN, SYNTHETIC] */
        @Override // b.i.a.c.e3.b0.CachedContentIndex.c
        public void g(HashMap<String, CachedContent> map, SparseArray<String> sparseArray) throws Throwable {
            boolean z2 = true;
            AnimatableValueParser.D(!this.f);
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
                                            int i2 = Util2.a;
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
                                    CachedContent cachedContentJ = j(i, dataInputStream2);
                                    map.put(cachedContentJ.f930b, cachedContentJ);
                                    sparseArray.put(cachedContentJ.a, cachedContentJ.f930b);
                                    i4 += i(cachedContentJ, i);
                                }
                                int i6 = dataInputStream2.readInt();
                                boolean z3 = dataInputStream2.read() == -1;
                                if (i6 == i4 && z3) {
                                    int i7 = Util2.a;
                                    try {
                                        dataInputStream2.close();
                                    } catch (IOException unused) {
                                    }
                                }
                            }
                            int i8 = Util2.a;
                            dataInputStream2.close();
                        } catch (IOException unused2) {
                            dataInputStream = dataInputStream2;
                            if (dataInputStream != null) {
                                int i9 = Util2.a;
                                dataInputStream.close();
                            }
                            z2 = false;
                            if (z2) {
                            }
                            map.clear();
                            sparseArray.clear();
                            AtomicFile3 atomicFile3 = this.e;
                            atomicFile3.a.delete();
                            atomicFile3.f967b.delete();
                        } catch (Throwable th) {
                            th = th;
                            dataInputStream = dataInputStream2;
                            if (dataInputStream != null) {
                                int i10 = Util2.a;
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
                AtomicFile3 atomicFile4 = this.e;
                atomicFile4.a.delete();
                atomicFile4.f967b.delete();
            }
        }

        @Override // b.i.a.c.e3.b0.CachedContentIndex.c
        public void h() {
            AtomicFile3 atomicFile3 = this.e;
            atomicFile3.a.delete();
            atomicFile3.f967b.delete();
        }

        public final int i(CachedContent cachedContent, int i) {
            int iHashCode = cachedContent.f930b.hashCode() + (cachedContent.a * 31);
            if (i >= 2) {
                return (iHashCode * 31) + cachedContent.e.hashCode();
            }
            long jA = ContentMetadata.a(cachedContent.e);
            return (iHashCode * 31) + ((int) (jA ^ (jA >>> 32)));
        }

        public final CachedContent j(int i, DataInputStream dataInputStream) throws IOException {
            DefaultContentMetadata defaultContentMetadataA;
            int i2 = dataInputStream.readInt();
            String utf = dataInputStream.readUTF();
            if (i < 2) {
                long j = dataInputStream.readLong();
                ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
                ContentMetadataMutations.a(contentMetadataMutations, j);
                defaultContentMetadataA = DefaultContentMetadata.a.a(contentMetadataMutations);
            } else {
                defaultContentMetadataA = CachedContentIndex.a(dataInputStream);
            }
            return new CachedContent(i2, utf, defaultContentMetadataA);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.e3.b0.j$c */
    /* JADX INFO: compiled from: CachedContentIndex.java */
    public interface c {
        void a(CachedContent cachedContent, boolean z2);

        void b(HashMap<String, CachedContent> map) throws IOException;

        void c(CachedContent cachedContent);

        boolean d() throws IOException;

        void e(HashMap<String, CachedContent> map) throws IOException;

        void f(long j);

        void g(HashMap<String, CachedContent> map, SparseArray<String> sparseArray) throws IOException;

        void h() throws IOException;
    }

    public CachedContentIndex(@Nullable DatabaseProvider databaseProvider, @Nullable File file, @Nullable byte[] bArr, boolean z2, boolean z3) {
        AnimatableValueParser.D((databaseProvider == null && file == null) ? false : true);
        this.a = new HashMap<>();
        this.f932b = new SparseArray<>();
        this.c = new SparseBooleanArray();
        this.d = new SparseBooleanArray();
        a aVar = databaseProvider != null ? new a(databaseProvider) : null;
        b bVar = file != null ? new b(new File(file, "cached_content_index.exi"), bArr, z2) : null;
        if (aVar != null && (bVar == null || !z3)) {
            this.e = aVar;
            this.f = bVar;
        } else {
            int i = Util2.a;
            this.e = bVar;
            this.f = aVar;
        }
    }

    public static DefaultContentMetadata a(DataInputStream dataInputStream) throws IOException {
        int i = dataInputStream.readInt();
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < i; i2++) {
            String utf = dataInputStream.readUTF();
            int i3 = dataInputStream.readInt();
            if (i3 < 0) {
                throw new IOException(outline.g(31, "Invalid value size: ", i3));
            }
            int iMin = Math.min(i3, 10485760);
            byte[] bArrCopyOf = Util2.f;
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
        return new DefaultContentMetadata(map);
    }

    public static void b(DefaultContentMetadata defaultContentMetadata, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry<String, byte[]>> setEntrySet = defaultContentMetadata.c.entrySet();
        dataOutputStream.writeInt(setEntrySet.size());
        for (Map.Entry<String, byte[]> entry : setEntrySet) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    @Nullable
    public CachedContent c(String str) {
        return this.a.get(str);
    }

    public CachedContent d(String str) {
        CachedContent cachedContent = this.a.get(str);
        if (cachedContent != null) {
            return cachedContent;
        }
        SparseArray<String> sparseArray = this.f932b;
        int size = sparseArray.size();
        int i = 0;
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt < 0) {
            while (i < size && i == sparseArray.keyAt(i)) {
                i++;
            }
            iKeyAt = i;
        }
        CachedContent cachedContent2 = new CachedContent(iKeyAt, str, DefaultContentMetadata.a);
        this.a.put(str, cachedContent2);
        this.f932b.put(iKeyAt, str);
        this.d.put(iKeyAt, true);
        this.e.c(cachedContent2);
        return cachedContent2;
    }

    @WorkerThread
    public void e(long j) throws IOException {
        c cVar;
        this.e.f(j);
        c cVar2 = this.f;
        if (cVar2 != null) {
            cVar2.f(j);
        }
        if (this.e.d() || (cVar = this.f) == null || !cVar.d()) {
            this.e.g(this.a, this.f932b);
        } else {
            this.f.g(this.a, this.f932b);
            this.e.b(this.a);
        }
        c cVar3 = this.f;
        if (cVar3 != null) {
            cVar3.h();
            this.f = null;
        }
    }

    public void f(String str) {
        CachedContent cachedContent = this.a.get(str);
        if (cachedContent != null && cachedContent.c.isEmpty() && cachedContent.d.isEmpty()) {
            this.a.remove(str);
            int i = cachedContent.a;
            boolean z2 = this.d.get(i);
            this.e.a(cachedContent, z2);
            if (z2) {
                this.f932b.remove(i);
                this.d.delete(i);
            } else {
                this.f932b.put(i, null);
                this.c.put(i, true);
            }
        }
    }

    @WorkerThread
    public void g() throws IOException {
        this.e.e(this.a);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            this.f932b.remove(this.c.keyAt(i));
        }
        this.c.clear();
        this.d.clear();
    }
}
