package b.f.j.p;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.ContactsContract;
import b.f.d.g.PooledByteBufferFactory;
import b.f.d.l.UriUtil;
import b.f.j.j.EncodedImage2;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.f.j.p.e0, reason: use source file name */
/* JADX INFO: compiled from: LocalContentUriFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class LocalContentUriFetchProducer extends LocalFetchProducer {
    public final ContentResolver c;

    public LocalContentUriFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        this.c = contentResolver;
    }

    @Override // b.f.j.p.LocalFetchProducer
    public EncodedImage2 d(ImageRequest imageRequest) throws IOException {
        EncodedImage2 encodedImage2C;
        InputStream inputStreamCreateInputStream;
        Uri uri = imageRequest.c;
        Uri uri2 = UriUtil.a;
        boolean z2 = false;
        if (uri.getPath() != null && UriUtil.c(uri) && "com.android.contacts".equals(uri.getAuthority()) && !uri.getPath().startsWith(UriUtil.a.getPath())) {
            z2 = true;
        }
        if (!z2) {
            if (UriUtil.b(uri)) {
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = this.c.openFileDescriptor(uri, "r");
                    Objects.requireNonNull(parcelFileDescriptorOpenFileDescriptor);
                    encodedImage2C = c(new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()), (int) parcelFileDescriptorOpenFileDescriptor.getStatSize());
                } catch (FileNotFoundException unused) {
                    encodedImage2C = null;
                }
                if (encodedImage2C != null) {
                    return encodedImage2C;
                }
            }
            InputStream inputStreamOpenInputStream = this.c.openInputStream(uri);
            Objects.requireNonNull(inputStreamOpenInputStream);
            return c(inputStreamOpenInputStream, -1);
        }
        if (uri.toString().endsWith("/photo")) {
            inputStreamCreateInputStream = this.c.openInputStream(uri);
        } else if (uri.toString().endsWith("/display_photo")) {
            try {
                AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = this.c.openAssetFileDescriptor(uri, "r");
                Objects.requireNonNull(assetFileDescriptorOpenAssetFileDescriptor);
                inputStreamCreateInputStream = assetFileDescriptorOpenAssetFileDescriptor.createInputStream();
            } catch (IOException unused2) {
                throw new IOException("Contact photo does not exist: " + uri);
            }
        } else {
            InputStream inputStreamOpenContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.c, uri);
            if (inputStreamOpenContactPhotoInputStream == null) {
                throw new IOException("Contact photo does not exist: " + uri);
            }
            inputStreamCreateInputStream = inputStreamOpenContactPhotoInputStream;
        }
        Objects.requireNonNull(inputStreamCreateInputStream);
        return c(inputStreamCreateInputStream, -1);
    }

    @Override // b.f.j.p.LocalFetchProducer
    public String e() {
        return "LocalContentUriFetchProducer";
    }
}
