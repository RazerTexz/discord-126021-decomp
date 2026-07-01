package com.lytefast.flexinput.fragment;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import b.b.a.b;
import b.o.a.a;
import b.o.a.c;
import b.o.a.d;
import b.o.a.e;
import b.o.a.l;
import b.o.a.r.g;
import com.lytefast.flexinput.R$h;
import com.lytefast.flexinput.managers.FileManager;
import com.otaliastudios.cameraview.CameraException;
import d0.z.d.m;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: CameraFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CameraFragment$d extends a {
    public final /* synthetic */ CameraFragment a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f3164b;

    public CameraFragment$d(CameraFragment cameraFragment, View view) {
        this.a = cameraFragment;
        this.f3164b = view;
    }

    @Override // b.o.a.a
    public void a() {
        CameraFragment cameraFragment = this.a;
        if (cameraFragment.photoFilePending) {
            b<Object> bVarK = cameraFragment.k();
            FileManager fileManager = bVarK != null ? bVarK.getFileManager() : null;
            File fileB = fileManager != null ? fileManager.b() : null;
            if (fileB == null) {
                CameraFragment.j(cameraFragment, 0, 0, 3, null);
                return;
            }
            Context contextRequireContext = cameraFragment.requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            Uri uriA = fileManager.a(contextRequireContext, fileB);
            Intent intentAddFlags = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uriA).addFlags(2);
            Context contextRequireContext2 = cameraFragment.requireContext();
            m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            m.checkNotNullExpressionValue(intentAddFlags, "intent");
            List<ResolveInfo> listQueryIntentActivities = contextRequireContext2.getPackageManager().queryIntentActivities(intentAddFlags, 65536);
            m.checkNotNullExpressionValue(listQueryIntentActivities, "packageManager.queryInte…nager.MATCH_DEFAULT_ONLY)");
            Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
            while (it.hasNext()) {
                contextRequireContext2.grantUriPermission(it.next().activityInfo.packageName, uriA, 3);
            }
            m.checkNotNullExpressionValue(intentAddFlags, "Intent(MediaStore.ACTION…nt, photoUri)\n          }");
            cameraFragment.photoFile = fileB;
            try {
                cameraFragment.startActivityForResult(intentAddFlags, 4567);
            } catch (ActivityNotFoundException unused) {
                CameraFragment.j(cameraFragment, 0, 0, 3, null);
            }
        }
    }

    @Override // b.o.a.a
    public void b(CameraException cameraException) {
        m.checkNotNullParameter(cameraException, "exception");
        CameraFragment cameraFragment = this.a;
        String string = cameraFragment.getString(R$h.camera_unknown_error);
        m.checkNotNullExpressionValue(string, "getString(R.string.camera_unknown_error)");
        CameraFragment.l(cameraFragment, string, cameraException, true, null, 8, null);
    }

    @Override // b.o.a.a
    public void c(c cVar) {
        m.checkNotNullParameter(cVar, "cameraOptions");
        CameraFragment cameraFragment = this.a;
        CameraFragment$b cameraFragment$b = CameraFragment.j;
        cameraFragment.h();
        this.a.g();
        ImageView imageView = this.a.cameraFacingBtn;
        if (imageView == null) {
            m.throwUninitializedPropertyAccessException("cameraFacingBtn");
        }
        imageView.setVisibility(cVar.a().size() > 1 ? 0 : 8);
        ImageView imageView2 = this.a.cameraFlashBtn;
        if (imageView2 == null) {
            m.throwUninitializedPropertyAccessException("cameraFlashBtn");
        }
        imageView2.setVisibility(cVar.b().size() > 1 ? 0 : 8);
    }

    @Override // b.o.a.a
    public void d(l lVar) {
        FileManager fileManager;
        File fileB;
        m.checkNotNullParameter(lVar, "result");
        CameraFragment cameraFragment = this.a;
        CameraFragment$b cameraFragment$b = CameraFragment.j;
        b<Object> bVarK = cameraFragment.k();
        if (bVarK == null || (fileManager = bVarK.getFileManager()) == null || (fileB = fileManager.b()) == null) {
            return;
        }
        CameraFragment$d$a cameraFragment$d$a = new CameraFragment$d$a(this);
        byte[] bArr = lVar.a;
        b.o.a.b bVar = e.a;
        g.a(new d(bArr, fileB, new Handler(), cameraFragment$d$a));
    }
}
