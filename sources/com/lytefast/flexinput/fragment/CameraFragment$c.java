package com.lytefast.flexinput.fragment;

import android.view.View;
import android.view.View$OnClickListener;
import b.b.a.b;
import defpackage.q;

/* JADX INFO: compiled from: CameraFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CameraFragment$c implements View$OnClickListener {
    public final /* synthetic */ CameraFragment j;

    public CameraFragment$c(CameraFragment cameraFragment) {
        this.j = cameraFragment;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        CameraFragment cameraFragment = this.j;
        CameraFragment$b cameraFragment$b = CameraFragment.j;
        b<Object> bVarK = cameraFragment.k();
        if (bVarK != null) {
            bVarK.requestMediaPermissions(q.k);
        }
    }
}
