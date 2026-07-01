package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import b.c.a.a0.d;
import b.f.d.g.g;
import b.f.j.j.e;
import b.f.j.p.k1;
import b.f.j.p.l;
import b.f.j.p.x0;
import b.f.j.p.z0;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class LocalExifThumbnailProducer implements k1<e> {
    public final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f2901b;
    public final ContentResolver c;

    public LocalExifThumbnailProducer(Executor executor, g gVar, ContentResolver contentResolver) {
        this.a = executor;
        this.f2901b = gVar;
        this.c = contentResolver;
    }

    @Override // b.f.j.p.k1
    public boolean a(b.f.j.d.e eVar) {
        return d.S0(512, 512, eVar);
    }

    @Override // b.f.j.p.w0
    public void b(l<e> lVar, x0 x0Var) {
        z0 z0VarO = x0Var.o();
        ImageRequest imageRequestE = x0Var.e();
        x0Var.i("local", "exif");
        LocalExifThumbnailProducer$a localExifThumbnailProducer$a = new LocalExifThumbnailProducer$a(this, lVar, z0VarO, x0Var, "LocalExifThumbnailProducer", imageRequestE);
        x0Var.f(new LocalExifThumbnailProducer$b(this, localExifThumbnailProducer$a));
        this.a.execute(localExifThumbnailProducer$a);
    }
}
