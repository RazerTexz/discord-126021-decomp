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
import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.ImmutableMap;
import b.f.d.e.FLog;
import b.f.d.g.PooledByteBufferFactory;
import b.f.d.g.PooledByteBufferInputStream;
import b.f.d.l.UriUtil;
import b.f.i.DefaultImageFormats;
import b.f.j.d.ResizeOptions;
import b.f.j.j.EncodedImage2;
import b.f.j.p.BaseProducerContextCallbacks;
import b.f.j.p.Consumer2;
import b.f.j.p.ProducerContext;
import b.f.j.p.ProducerListener2;
import b.f.j.p.StatefulProducerRunnable;
import b.f.j.p.ThumbnailProducer;
import b.f.k.BitmapUtil;
import b.f.m.DoNotOptimize;
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

/* JADX INFO: loaded from: classes3.dex */
public class LocalExifThumbnailProducer implements ThumbnailProducer<EncodedImage2> {
    public final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PooledByteBufferFactory f2901b;
    public final ContentResolver c;

    @DoNotOptimize
    public class Api24Utils {
    }

    public class a extends StatefulProducerRunnable<EncodedImage2> {
        public final /* synthetic */ ImageRequest o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Consumer2 consumer2, ProducerListener2 producerListener2, ProducerContext producerContext, String str, ImageRequest imageRequest) {
            super(consumer2, producerListener2, producerContext, str);
            this.o = imageRequest;
        }

        @Override // b.f.j.p.StatefulProducerRunnable
        public void b(EncodedImage2 encodedImage2) {
            EncodedImage2 encodedImage3 = encodedImage2;
            if (encodedImage3 != null) {
                encodedImage3.close();
            }
        }

        @Override // b.f.j.p.StatefulProducerRunnable
        public Map c(EncodedImage2 encodedImage2) {
            return ImmutableMap.of("createdThumbnail", Boolean.toString(encodedImage2 != null));
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0031  */
        /* JADX WARN: Code duplicated, block: B:52:0x009b  */
        @Override // b.f.j.p.StatefulProducerRunnable
        public EncodedImage2 d() throws Exception {
            String path;
            ExifInterface exifInterface;
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
            int i;
            int columnIndex;
            Uri uri = this.o.c;
            LocalExifThumbnailProducer localExifThumbnailProducer = LocalExifThumbnailProducer.this;
            ContentResolver contentResolver = localExifThumbnailProducer.c;
            EncodedImage2 encodedImage2 = null;
            Cursor cursor = null;
            pair = null;
            Pair pair = null;
            encodedImage2 = null;
            if (UriUtil.c(uri)) {
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
                path = UriUtil.d(uri) ? uri.getPath() : null;
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
                        if (UriUtil.c(uri)) {
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
                    FLog.a(LocalExifThumbnailProducer.class, "StackOverflowError in ExifInterface constructor");
                }
            }
            if (exifInterface != null && exifInterface.hasThumbnail()) {
                byte[] thumbnail = exifInterface.getThumbnail();
                Objects.requireNonNull(thumbnail);
                PooledByteBuffer pooledByteBufferB = LocalExifThumbnailProducer.this.f2901b.b(thumbnail);
                Objects.requireNonNull(LocalExifThumbnailProducer.this);
                PooledByteBufferInputStream pooledByteBufferInputStream = new PooledByteBufferInputStream(pooledByteBufferB);
                Pools.SynchronizedPool<ByteBuffer> synchronizedPool = BitmapUtil.a;
                Pools.SynchronizedPool<ByteBuffer> synchronizedPool2 = BitmapUtil.a;
                ByteBuffer byteBufferAcquire = synchronizedPool2.acquire();
                if (byteBufferAcquire == null) {
                    byteBufferAcquire = ByteBuffer.allocate(16384);
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                try {
                    options.inTempStorage = byteBufferAcquire.array();
                    BitmapFactory.decodeStream(pooledByteBufferInputStream, null, options);
                    if (options.outWidth != -1 && options.outHeight != -1) {
                        pair = new Pair(Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                    }
                    synchronizedPool2.release(byteBufferAcquire);
                    String attribute = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION);
                    Objects.requireNonNull(attribute);
                    int iS0 = AnimatableValueParser.s0(Integer.parseInt(attribute));
                    int iIntValue = pair != null ? ((Integer) pair.first).intValue() : -1;
                    int iIntValue2 = pair != null ? ((Integer) pair.second).intValue() : -1;
                    CloseableReference closeableReferenceA = CloseableReference.A(pooledByteBufferB);
                    try {
                        encodedImage2 = new EncodedImage2(closeableReferenceA);
                        if (closeableReferenceA != null) {
                            closeableReferenceA.close();
                        }
                        encodedImage2.l = DefaultImageFormats.a;
                        encodedImage2.m = iS0;
                        encodedImage2.o = iIntValue;
                        encodedImage2.p = iIntValue2;
                    } catch (Throwable th3) {
                        if (closeableReferenceA != null) {
                            closeableReferenceA.close();
                        }
                        throw th3;
                    }
                } catch (Throwable th4) {
                    BitmapUtil.a.release(byteBufferAcquire);
                    throw th4;
                }
            }
            return encodedImage2;
        }
    }

    public class b extends BaseProducerContextCallbacks {
        public final /* synthetic */ StatefulProducerRunnable a;

        public b(LocalExifThumbnailProducer localExifThumbnailProducer, StatefulProducerRunnable statefulProducerRunnable) {
            this.a = statefulProducerRunnable;
        }

        @Override // b.f.j.p.ProducerContextCallbacks
        public void a() {
            this.a.a();
        }
    }

    public LocalExifThumbnailProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        this.a = executor;
        this.f2901b = pooledByteBufferFactory;
        this.c = contentResolver;
    }

    @Override // b.f.j.p.ThumbnailProducer
    public boolean a(ResizeOptions resizeOptions) {
        return AnimatableValueParser.S0(512, 512, resizeOptions);
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        ProducerListener2 producerListener2O = producerContext.o();
        ImageRequest imageRequestE = producerContext.e();
        producerContext.i("local", "exif");
        a aVar = new a(consumer2, producerListener2O, producerContext, "LocalExifThumbnailProducer", imageRequestE);
        producerContext.f(new b(this, aVar));
        this.a.execute(aVar);
    }
}
