package p007b.p109f.p161j.p181p;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.ContactsContract;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.Executor;
import p007b.p109f.p115d.p122g.InterfaceC1700g;
import p007b.p109f.p115d.p127l.C1717b;
import p007b.p109f.p161j.p175j.C1919e;

/* JADX INFO: renamed from: b.f.j.p.e0 */
/* JADX INFO: compiled from: LocalContentUriFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1975e0 extends AbstractC1981g0 {

    /* JADX INFO: renamed from: c */
    public final ContentResolver f4040c;

    public C1975e0(Executor executor, InterfaceC1700g interfaceC1700g, ContentResolver contentResolver) {
        super(executor, interfaceC1700g);
        this.f4040c = contentResolver;
    }

    @Override // p007b.p109f.p161j.p181p.AbstractC1981g0
    /* JADX INFO: renamed from: d */
    public C1919e mo1428d(ImageRequest imageRequest) throws IOException {
        C1919e c1919eM1478c;
        InputStream inputStreamCreateInputStream;
        Uri uri = imageRequest.f19585c;
        Uri uri2 = C1717b.f3138a;
        boolean z2 = false;
        if (uri.getPath() != null && C1717b.m1007c(uri) && "com.android.contacts".equals(uri.getAuthority()) && !uri.getPath().startsWith(C1717b.f3138a.getPath())) {
            z2 = true;
        }
        if (!z2) {
            if (C1717b.m1006b(uri)) {
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = this.f4040c.openFileDescriptor(uri, "r");
                    Objects.requireNonNull(parcelFileDescriptorOpenFileDescriptor);
                    c1919eM1478c = m1478c(new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()), (int) parcelFileDescriptorOpenFileDescriptor.getStatSize());
                } catch (FileNotFoundException unused) {
                    c1919eM1478c = null;
                }
                if (c1919eM1478c != null) {
                    return c1919eM1478c;
                }
            }
            InputStream inputStreamOpenInputStream = this.f4040c.openInputStream(uri);
            Objects.requireNonNull(inputStreamOpenInputStream);
            return m1478c(inputStreamOpenInputStream, -1);
        }
        if (uri.toString().endsWith("/photo")) {
            inputStreamCreateInputStream = this.f4040c.openInputStream(uri);
        } else if (uri.toString().endsWith("/display_photo")) {
            try {
                AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = this.f4040c.openAssetFileDescriptor(uri, "r");
                Objects.requireNonNull(assetFileDescriptorOpenAssetFileDescriptor);
                inputStreamCreateInputStream = assetFileDescriptorOpenAssetFileDescriptor.createInputStream();
            } catch (IOException unused2) {
                throw new IOException("Contact photo does not exist: " + uri);
            }
        } else {
            InputStream inputStreamOpenContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.f4040c, uri);
            if (inputStreamOpenContactPhotoInputStream == null) {
                throw new IOException("Contact photo does not exist: " + uri);
            }
            inputStreamCreateInputStream = inputStreamOpenContactPhotoInputStream;
        }
        Objects.requireNonNull(inputStreamCreateInputStream);
        return m1478c(inputStreamCreateInputStream, -1);
    }

    @Override // p007b.p109f.p161j.p181p.AbstractC1981g0
    /* JADX INFO: renamed from: e */
    public String mo1429e() {
        return "LocalContentUriFetchProducer";
    }
}
