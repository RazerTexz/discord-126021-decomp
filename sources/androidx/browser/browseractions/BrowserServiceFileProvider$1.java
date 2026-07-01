package androidx.browser.browseractions;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.concurrent.futures.ResolvableFuture;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class BrowserServiceFileProvider$1 implements Runnable {
    public final /* synthetic */ ContentResolver val$resolver;
    public final /* synthetic */ ResolvableFuture val$result;
    public final /* synthetic */ Uri val$uri;

    public BrowserServiceFileProvider$1(ContentResolver contentResolver, Uri uri, ResolvableFuture resolvableFuture) {
        this.val$resolver = contentResolver;
        this.val$uri = uri;
        this.val$result = resolvableFuture;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = this.val$resolver.openFileDescriptor(this.val$uri, "r");
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                this.val$result.setException(new FileNotFoundException());
                return;
            }
            Bitmap bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
            parcelFileDescriptorOpenFileDescriptor.close();
            if (bitmapDecodeFileDescriptor == null) {
                this.val$result.setException(new IOException("File could not be decoded."));
            } else {
                this.val$result.set(bitmapDecodeFileDescriptor);
            }
        } catch (IOException e) {
            this.val$result.setException(e);
        }
    }
}
