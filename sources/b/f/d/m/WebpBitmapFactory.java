package b.f.d.m;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import java.io.FileDescriptor;

/* JADX INFO: renamed from: b.f.d.m.b, reason: use source file name */
/* JADX INFO: compiled from: WebpBitmapFactory.java */
/* JADX INFO: loaded from: classes.dex */
public interface WebpBitmapFactory {

    /* JADX INFO: renamed from: b.f.d.m.b$a */
    /* JADX INFO: compiled from: WebpBitmapFactory.java */
    public interface a {
        void a(String str, String str2);
    }

    Bitmap a(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options);
}
