package b.f.j.p;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.ContactsContract$Contacts;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: LocalContentUriFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class e0 extends g0 {
    public final ContentResolver c;

    public e0(Executor executor, b.f.d.g.g gVar, ContentResolver contentResolver) {
        super(executor, gVar);
        this.c = contentResolver;
    }

    @Override // b.f.j.p.g0
    public b.f.j.j.e d(ImageRequest imageRequest) throws IOException {
        b.f.j.j.e eVarC;
        InputStream inputStreamCreateInputStream;
        Uri uri = imageRequest.c;
        Uri uri2 = b.f.d.l.b.a;
        boolean z2 = false;
        if (uri.getPath() != null && b.f.d.l.b.c(uri) && "com.android.contacts".equals(uri.getAuthority()) && !uri.getPath().startsWith(b.f.d.l.b.a.getPath())) {
            z2 = true;
        }
        if (!z2) {
            if (b.f.d.l.b.b(uri)) {
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = this.c.openFileDescriptor(uri, "r");
                    Objects.requireNonNull(parcelFileDescriptorOpenFileDescriptor);
                    eVarC = c(new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()), (int) parcelFileDescriptorOpenFileDescriptor.getStatSize());
                } catch (FileNotFoundException unused) {
                    eVarC = null;
                }
                if (eVarC != null) {
                    return eVarC;
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
            InputStream inputStreamOpenContactPhotoInputStream = ContactsContract$Contacts.openContactPhotoInputStream(this.c, uri);
            if (inputStreamOpenContactPhotoInputStream == null) {
                throw new IOException("Contact photo does not exist: " + uri);
            }
            inputStreamCreateInputStream = inputStreamOpenContactPhotoInputStream;
        }
        Objects.requireNonNull(inputStreamCreateInputStream);
        return c(inputStreamCreateInputStream, -1);
    }

    @Override // b.f.j.p.g0
    public String e() {
        return "LocalContentUriFetchProducer";
    }
}
