package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory$Options;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build$VERSION;
import android.util.Pair;
import androidx.core.util.Pools$SynchronizedPool;
import b.c.a.a0.d;
import b.f.d.d.f;
import b.f.d.e.a;
import b.f.d.g.h;
import b.f.d.l.b;
import b.f.j.j.e;
import b.f.j.p.e1;
import b.f.j.p.l;
import b.f.j.p.x0;
import b.f.j.p.z0;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class LocalExifThumbnailProducer$a extends e1<e> {
    public final /* synthetic */ ImageRequest o;
    public final /* synthetic */ LocalExifThumbnailProducer p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalExifThumbnailProducer$a(LocalExifThumbnailProducer localExifThumbnailProducer, l lVar, z0 z0Var, x0 x0Var, String str, ImageRequest imageRequest) {
        super(lVar, z0Var, x0Var, str);
        this.p = localExifThumbnailProducer;
        this.o = imageRequest;
    }

    @Override // b.f.j.p.e1
    public void b(e eVar) {
        e eVar2 = eVar;
        if (eVar2 != null) {
            eVar2.close();
        }
    }

    @Override // b.f.j.p.e1
    public Map c(e eVar) {
        return f.of("createdThumbnail", Boolean.toString(eVar != null));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0031  */
    /* JADX WARN: Code duplicated, block: B:52:0x009b  */
    @Override // b.f.j.p.e1
    public e d() throws Exception {
        String path;
        ExifInterface exifInterface;
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        int i;
        int columnIndex;
        Uri uri = this.o.c;
        LocalExifThumbnailProducer localExifThumbnailProducer = this.p;
        ContentResolver contentResolver = localExifThumbnailProducer.c;
        e eVar = null;
        Cursor cursor = null;
        pair = null;
        Pair pair = null;
        eVar = null;
        if (b.c(uri)) {
            try {
                Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (!cursorQuery.moveToFirst() || (columnIndex = cursorQuery.getColumnIndex("_data")) == -1) {
                            path = null;
                        } else {
                            path = cursorQuery.getString(columnIndex);
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } else {
                    path = null;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            path = b.d(uri) ? uri.getPath() : null;
        }
        if (path == null) {
            exifInterface = null;
        } else {
            boolean z2 = false;
            try {
                File file = new File(path);
                if (file.exists() && file.canRead()) {
                    z2 = true;
                }
                if (z2) {
                    exifInterface = new ExifInterface(path);
                } else {
                    ContentResolver contentResolver2 = localExifThumbnailProducer.c;
                    if (b.c(uri)) {
                        try {
                            assetFileDescriptorOpenAssetFileDescriptor = contentResolver2.openAssetFileDescriptor(uri, "r");
                        } catch (FileNotFoundException unused) {
                            assetFileDescriptorOpenAssetFileDescriptor = null;
                        }
                    } else {
                        assetFileDescriptorOpenAssetFileDescriptor = null;
                    }
                    if (assetFileDescriptorOpenAssetFileDescriptor == null || (i = Build$VERSION.SDK_INT) < 24) {
                        exifInterface = null;
                    } else {
                        ExifInterface exifInterface2 = i >= 24 ? new ExifInterface(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor()) : null;
                        assetFileDescriptorOpenAssetFileDescriptor.close();
                        exifInterface = exifInterface2;
                    }
                }
            } catch (IOException unused2) {
            } catch (StackOverflowError unused3) {
                a.a(LocalExifThumbnailProducer.class, "StackOverflowError in ExifInterface constructor");
            }
        }
        if (exifInterface != null && exifInterface.hasThumbnail()) {
            byte[] thumbnail = exifInterface.getThumbnail();
            Objects.requireNonNull(thumbnail);
            PooledByteBuffer pooledByteBufferB = this.p.f2901b.b(thumbnail);
            Objects.requireNonNull(this.p);
            h hVar = new h(pooledByteBufferB);
            Pools$SynchronizedPool<ByteBuffer> pools$SynchronizedPool = b.f.k.a.a;
            Pools$SynchronizedPool<ByteBuffer> pools$SynchronizedPool2 = b.f.k.a.a;
            ByteBuffer byteBufferAcquire = pools$SynchronizedPool2.acquire();
            if (byteBufferAcquire == null) {
                byteBufferAcquire = ByteBuffer.allocate(16384);
            }
            BitmapFactory$Options bitmapFactory$Options = new BitmapFactory$Options();
            bitmapFactory$Options.inJustDecodeBounds = true;
            try {
                bitmapFactory$Options.inTempStorage = byteBufferAcquire.array();
                BitmapFactory.decodeStream(hVar, null, bitmapFactory$Options);
                if (bitmapFactory$Options.outWidth != -1 && bitmapFactory$Options.outHeight != -1) {
                    pair = new Pair(Integer.valueOf(bitmapFactory$Options.outWidth), Integer.valueOf(bitmapFactory$Options.outHeight));
                }
                pools$SynchronizedPool2.release(byteBufferAcquire);
                String attribute = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION);
                Objects.requireNonNull(attribute);
                int iS0 = d.s0(Integer.parseInt(attribute));
                int iIntValue = pair != null ? ((Integer) pair.first).intValue() : -1;
                int iIntValue2 = pair != null ? ((Integer) pair.second).intValue() : -1;
                CloseableReference closeableReferenceA = CloseableReference.A(pooledByteBufferB);
                try {
                    eVar = new e(closeableReferenceA);
                    if (closeableReferenceA != null) {
                        closeableReferenceA.close();
                    }
                    eVar.l = b.f.i.b.a;
                    eVar.m = iS0;
                    eVar.o = iIntValue;
                    eVar.p = iIntValue2;
                } catch (Throwable th3) {
                    if (closeableReferenceA != null) {
                        closeableReferenceA.close();
                    }
                    throw th3;
                }
            } catch (Throwable th4) {
                b.f.k.a.a.release(byteBufferAcquire);
                throw th4;
            }
        }
        return eVar;
    }
}
