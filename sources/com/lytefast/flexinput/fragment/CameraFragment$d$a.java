package com.lytefast.flexinput.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import b.b.a.b;
import b.b.a.g.a;
import b.o.a.k;
import d0.z.d.m;
import java.io.File;

/* JADX INFO: compiled from: CameraFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CameraFragment$d$a implements k {
    public final /* synthetic */ CameraFragment$d a;

    public CameraFragment$d$a(CameraFragment$d cameraFragment$d) {
        this.a = cameraFragment$d;
    }

    @Override // b.o.a.k
    public final void a(File file) {
        if (file != null) {
            CameraFragment$b cameraFragment$b = CameraFragment.j;
            Context context = this.a.f3164b.getContext();
            m.checkNotNullExpressionValue(context, "view.context");
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
            b<Object> bVarK = this.a.a.k();
            if (bVarK != null) {
                bVarK.f(a.a(file));
            }
        }
    }
}
