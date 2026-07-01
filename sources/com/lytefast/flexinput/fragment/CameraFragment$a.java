package com.lytefast.flexinput.fragment;

import android.view.View;
import android.view.View$OnClickListener;
import b.o.a.c;
import b.o.a.l$a;
import b.o.a.m.e;
import b.o.a.m.f;
import com.lytefast.flexinput.R$h;
import com.otaliastudios.cameraview.CameraView;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class CameraFragment$a implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public CameraFragment$a(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        List listEmptyList;
        Collection<f> collectionB;
        List listEmptyList2;
        Collection<e> collectionA;
        int i = this.j;
        if (i == 0) {
            CameraView cameraView = ((CameraFragment) this.k).cameraView;
            if (cameraView == null) {
                m.throwUninitializedPropertyAccessException("cameraView");
            }
            cameraView.f3176z.O0(new l$a());
            return;
        }
        Integer num = null;
        if (i == 1) {
            CameraFragment cameraFragment = (CameraFragment) this.k;
            cameraFragment.photoFile = null;
            cameraFragment.photoFilePending = true;
            CameraView cameraView2 = cameraFragment.cameraView;
            if (cameraView2 == null) {
                m.throwUninitializedPropertyAccessException("cameraView");
            }
            cameraView2.close();
            return;
        }
        if (i != 2) {
            if (i != 3) {
                throw null;
            }
            CameraFragment cameraFragment2 = (CameraFragment) this.k;
            CameraView cameraView3 = cameraFragment2.cameraView;
            if (cameraView3 == null) {
                m.throwUninitializedPropertyAccessException("cameraView");
            }
            c cameraOptions = cameraView3.getCameraOptions();
            if (cameraOptions == null || (collectionA = cameraOptions.a()) == null || (listEmptyList2 = u.toList(collectionA)) == null) {
                listEmptyList2 = n.emptyList();
            }
            if (listEmptyList2.size() <= 1) {
                return;
            }
            CameraView cameraView4 = cameraFragment2.cameraView;
            if (cameraView4 == null) {
                m.throwUninitializedPropertyAccessException("cameraView");
            }
            e facing = cameraView4.getFacing();
            m.checkNotNullExpressionValue(facing, "cameraView.facing");
            for (Integer num2 : n.getIndices(listEmptyList2)) {
                if (facing == ((e) listEmptyList2.get(num2.intValue()))) {
                    num = num2;
                    break;
                }
            }
            Integer num3 = num;
            e eVar = (e) u.getOrNull(listEmptyList2, ((num3 != null ? num3.intValue() : 0) + 1) % listEmptyList2.size());
            if (eVar != null) {
                cameraFragment2.g();
                CameraView cameraView5 = cameraFragment2.cameraView;
                if (cameraView5 == null) {
                    m.throwUninitializedPropertyAccessException("cameraView");
                }
                cameraView5.setFacing(eVar);
                return;
            }
            return;
        }
        CameraFragment cameraFragment3 = (CameraFragment) this.k;
        CameraView cameraView6 = cameraFragment3.cameraView;
        if (cameraView6 == null) {
            m.throwUninitializedPropertyAccessException("cameraView");
        }
        c cameraOptions2 = cameraView6.getCameraOptions();
        if (cameraOptions2 == null || (collectionB = cameraOptions2.b()) == null || (listEmptyList = u.toList(collectionB)) == null) {
            listEmptyList = n.emptyList();
        }
        if (listEmptyList.size() <= 1) {
            return;
        }
        CameraView cameraView7 = cameraFragment3.cameraView;
        if (cameraView7 == null) {
            m.throwUninitializedPropertyAccessException("cameraView");
        }
        f flash = cameraView7.getFlash();
        m.checkNotNullExpressionValue(flash, "cameraView.flash");
        for (Integer num4 : n.getIndices(listEmptyList)) {
            if (flash == ((f) listEmptyList.get(num4.intValue()))) {
                num = num4;
                break;
            }
        }
        Integer num5 = num;
        f fVar = (f) u.getOrNull(listEmptyList, ((num5 != null ? num5.intValue() : 0) + 1) % listEmptyList.size());
        if (fVar != null) {
            try {
                CameraView cameraView8 = cameraFragment3.cameraView;
                if (cameraView8 == null) {
                    m.throwUninitializedPropertyAccessException("cameraView");
                }
                cameraView8.setFlash(fVar);
                cameraFragment3.h();
            } catch (Exception e) {
                String string = cameraFragment3.getString(R$h.camera_unknown_error);
                m.checkNotNullExpressionValue(string, "getString(R.string.camera_unknown_error)");
                CameraFragment.l(cameraFragment3, string, e, true, null, 8, null);
            }
        }
    }
}
