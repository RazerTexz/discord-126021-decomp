package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.util.Pair;
import androidx.core.util.Pools;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p119d.C1683f;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p115d.p122g.C1701h;
import p007b.p109f.p115d.p122g.InterfaceC1700g;
import p007b.p109f.p115d.p127l.C1717b;
import p007b.p109f.p160i.C1831b;
import p007b.p109f.p161j.p169d.C1884e;
import p007b.p109f.p161j.p175j.C1919e;
import p007b.p109f.p161j.p181p.AbstractRunnableC1976e1;
import p007b.p109f.p161j.p181p.C1974e;
import p007b.p109f.p161j.p181p.InterfaceC1994k1;
import p007b.p109f.p161j.p181p.InterfaceC1995l;
import p007b.p109f.p161j.p181p.InterfaceC2020x0;
import p007b.p109f.p161j.p181p.InterfaceC2024z0;
import p007b.p109f.p186k.C2038a;
import p007b.p109f.p190m.InterfaceC2051d;

/* JADX INFO: loaded from: classes3.dex */
public class LocalExifThumbnailProducer implements InterfaceC1994k1<C1919e> {

    /* JADX INFO: renamed from: a */
    public final Executor f19577a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1700g f19578b;

    /* JADX INFO: renamed from: c */
    public final ContentResolver f19579c;

    @InterfaceC2051d
    public class Api24Utils {
    }

    /* JADX INFO: renamed from: com.facebook.imagepipeline.producers.LocalExifThumbnailProducer$a */
    public class C10663a extends AbstractRunnableC1976e1<C1919e> {

        /* JADX INFO: renamed from: o */
        public final /* synthetic */ ImageRequest f19580o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10663a(InterfaceC1995l interfaceC1995l, InterfaceC2024z0 interfaceC2024z0, InterfaceC2020x0 interfaceC2020x0, String str, ImageRequest imageRequest) {
            super(interfaceC1995l, interfaceC2024z0, interfaceC2020x0, str);
            this.f19580o = imageRequest;
        }

        @Override // p007b.p109f.p161j.p181p.AbstractRunnableC1976e1
        /* JADX INFO: renamed from: b */
        public void mo1465b(C1919e c1919e) {
            C1919e c1919e2 = c1919e;
            if (c1919e2 != null) {
                c1919e2.close();
            }
        }

        @Override // p007b.p109f.p161j.p181p.AbstractRunnableC1976e1
        /* JADX INFO: renamed from: c */
        public Map mo1466c(C1919e c1919e) {
            return C1683f.m967of("createdThumbnail", Boolean.toString(c1919e != null));
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0031  */
        /* JADX WARN: Code duplicated, block: B:52:0x009b  */
        @Override // p007b.p109f.p161j.p181p.AbstractRunnableC1976e1
        /* JADX INFO: renamed from: d */
        public C1919e mo1467d() throws Exception {
            String path;
            ExifInterface exifInterface;
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
            int i;
            int columnIndex;
            Uri uri = this.f19580o.f19585c;
            LocalExifThumbnailProducer localExifThumbnailProducer = LocalExifThumbnailProducer.this;
            ContentResolver contentResolver = localExifThumbnailProducer.f19579c;
            C1919e c1919e = null;
            Cursor cursor = null;
            pair = null;
            Pair pair = null;
            c1919e = null;
            if (C1717b.m1007c(uri)) {
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
                path = C1717b.m1008d(uri) ? uri.getPath() : null;
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
                        ContentResolver contentResolver2 = localExifThumbnailProducer.f19579c;
                        if (C1717b.m1007c(uri)) {
                            try {
                                assetFileDescriptorOpenAssetFileDescriptor = contentResolver2.openAssetFileDescriptor(uri, "r");
                            } catch (FileNotFoundException unused) {
                                assetFileDescriptorOpenAssetFileDescriptor = null;
                            }
                        } else {
                            assetFileDescriptorOpenAssetFileDescriptor = null;
                        }
                        if (assetFileDescriptorOpenAssetFileDescriptor == null || (i = Build.VERSION.SDK_INT) < 24) {
                            exifInterface = null;
                        } else {
                            ExifInterface exifInterface2 = i >= 24 ? new ExifInterface(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor()) : null;
                            assetFileDescriptorOpenAssetFileDescriptor.close();
                            exifInterface = exifInterface2;
                        }
                    }
                } catch (IOException unused2) {
                } catch (StackOverflowError unused3) {
                    C1691a.m973a(LocalExifThumbnailProducer.class, "StackOverflowError in ExifInterface constructor");
                }
            }
            if (exifInterface != null && exifInterface.hasThumbnail()) {
                byte[] thumbnail = exifInterface.getThumbnail();
                Objects.requireNonNull(thumbnail);
                PooledByteBuffer pooledByteBufferMo994b = LocalExifThumbnailProducer.this.f19578b.mo994b(thumbnail);
                Objects.requireNonNull(LocalExifThumbnailProducer.this);
                C1701h c1701h = new C1701h(pooledByteBufferMo994b);
                Pools.SynchronizedPool<ByteBuffer> synchronizedPool = C2038a.f4275a;
                Pools.SynchronizedPool<ByteBuffer> synchronizedPool2 = C2038a.f4275a;
                ByteBuffer byteBufferAcquire = synchronizedPool2.acquire();
                if (byteBufferAcquire == null) {
                    byteBufferAcquire = ByteBuffer.allocate(16384);
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                try {
                    options.inTempStorage = byteBufferAcquire.array();
                    BitmapFactory.decodeStream(c1701h, null, options);
                    if (options.outWidth != -1 && options.outHeight != -1) {
                        pair = new Pair(Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                    }
                    synchronizedPool2.release(byteBufferAcquire);
                    String attribute = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION);
                    Objects.requireNonNull(attribute);
                    int iM568s0 = C1460d.m568s0(Integer.parseInt(attribute));
                    int iIntValue = pair != null ? ((Integer) pair.first).intValue() : -1;
                    int iIntValue2 = pair != null ? ((Integer) pair.second).intValue() : -1;
                    CloseableReference closeableReferenceM8632A = CloseableReference.m8632A(pooledByteBufferMo994b);
                    try {
                        c1919e = new C1919e(closeableReferenceM8632A);
                        if (closeableReferenceM8632A != null) {
                            closeableReferenceM8632A.close();
                        }
                        c1919e.f3893l = C1831b.f3585a;
                        c1919e.f3894m = iM568s0;
                        c1919e.f3896o = iIntValue;
                        c1919e.f3897p = iIntValue2;
                    } catch (Throwable th3) {
                        if (closeableReferenceM8632A != null) {
                            closeableReferenceM8632A.close();
                        }
                        throw th3;
                    }
                } catch (Throwable th4) {
                    C2038a.f4275a.release(byteBufferAcquire);
                    throw th4;
                }
            }
            return c1919e;
        }
    }

    /* JADX INFO: renamed from: com.facebook.imagepipeline.producers.LocalExifThumbnailProducer$b */
    public class C10664b extends C1974e {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ AbstractRunnableC1976e1 f19582a;

        public C10664b(LocalExifThumbnailProducer localExifThumbnailProducer, AbstractRunnableC1976e1 abstractRunnableC1976e1) {
            this.f19582a = abstractRunnableC1976e1;
        }

        @Override // p007b.p109f.p161j.p181p.InterfaceC2022y0
        /* JADX INFO: renamed from: a */
        public void mo1438a() {
            this.f19582a.m1464a();
        }
    }

    public LocalExifThumbnailProducer(Executor executor, InterfaceC1700g interfaceC1700g, ContentResolver contentResolver) {
        this.f19577a = executor;
        this.f19578b = interfaceC1700g;
        this.f19579c = contentResolver;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC1994k1
    /* JADX INFO: renamed from: a */
    public boolean mo1474a(C1884e c1884e) {
        return C1460d.m472S0(512, 512, c1884e);
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2018w0
    /* JADX INFO: renamed from: b */
    public void mo1417b(InterfaceC1995l<C1919e> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        InterfaceC2024z0 interfaceC2024z0Mo1457o = interfaceC2020x0.mo1457o();
        ImageRequest imageRequestMo1447e = interfaceC2020x0.mo1447e();
        interfaceC2020x0.mo1451i("local", "exif");
        C10663a c10663a = new C10663a(interfaceC1995l, interfaceC2024z0Mo1457o, interfaceC2020x0, "LocalExifThumbnailProducer", imageRequestMo1447e);
        interfaceC2020x0.mo1448f(new C10664b(this, c10663a));
        this.f19577a.execute(c10663a);
    }
}
