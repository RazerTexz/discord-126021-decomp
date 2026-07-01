package com.lytefast.flexinput.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import b.b.a.b;
import b.b.a.g.a;
import com.lytefast.flexinput.R$e;
import com.lytefast.flexinput.R$f;
import com.lytefast.flexinput.R$g;
import com.lytefast.flexinput.R$h;
import com.otaliastudios.cameraview.CameraView;
import d0.z.d.m;
import java.io.File;
import java.util.Objects;

/* JADX INFO: compiled from: CameraFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public class CameraFragment extends Fragment {
    public static final CameraFragment$b j = new CameraFragment$b(null);

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public View cameraContainer;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public CameraView cameraView;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public ViewStub permissionsViewStub;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public ImageView cameraFacingBtn;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public ImageView cameraFlashBtn;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public ImageView takePhotoBtn;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public ImageView launchCameraBtn;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public File photoFile;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    public boolean photoFilePending;

    public static /* synthetic */ void j(CameraFragment cameraFragment, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 4567;
        }
        cameraFragment.i(i, i2);
    }

    public static void l(CameraFragment cameraFragment, String str, Exception exc, boolean z2, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            exc = null;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        String str3 = (i & 8) != 0 ? str : null;
        Objects.requireNonNull(cameraFragment);
        Log.e("Discord", str, exc);
        if (z2) {
            Toast.makeText(cameraFragment.getContext(), str3, 0).show();
        }
    }

    public final void g() {
        ImageView imageView = this.cameraFacingBtn;
        if (imageView == null) {
            m.throwUninitializedPropertyAccessException("cameraFacingBtn");
        }
        CameraView cameraView = this.cameraView;
        if (cameraView == null) {
            m.throwUninitializedPropertyAccessException("cameraView");
        }
        int iOrdinal = cameraView.getFacing().ordinal();
        int i = (iOrdinal == 0 || iOrdinal != 1) ? R$e.ic_camera_front_white_24dp : R$e.ic_camera_rear_white_24dp;
        imageView.setImageResource(i);
    }

    public final void h() {
        int i;
        String string;
        ImageView imageView = this.cameraFlashBtn;
        if (imageView == null) {
            m.throwUninitializedPropertyAccessException("cameraFlashBtn");
        }
        CameraView cameraView = this.cameraView;
        if (cameraView == null) {
            m.throwUninitializedPropertyAccessException("cameraView");
        }
        int iOrdinal = cameraView.getFlash().ordinal();
        if (iOrdinal == 0) {
            i = R$e.ic_flash_off_24dp;
        } else if (iOrdinal != 1) {
            i = iOrdinal != 3 ? R$e.ic_flash_auto_24dp : R$e.ic_flash_torch_24dp;
        } else {
            i = R$e.ic_flash_on_24dp;
        }
        imageView.setImageResource(i);
        ImageView imageView2 = this.cameraFlashBtn;
        if (imageView2 == null) {
            m.throwUninitializedPropertyAccessException("cameraFlashBtn");
        }
        CameraView cameraView2 = this.cameraView;
        if (cameraView2 == null) {
            m.throwUninitializedPropertyAccessException("cameraView");
        }
        int iOrdinal2 = cameraView2.getFlash().ordinal();
        if (iOrdinal2 == 0) {
            string = getString(R$h.flash_off);
        } else if (iOrdinal2 != 1) {
            string = (iOrdinal2 == 2 || iOrdinal2 != 3) ? getString(R$h.flash_auto) : getString(R$h.flash_torch);
        } else {
            string = getString(R$h.flash_on);
        }
        imageView2.setContentDescription(string);
    }

    public final void i(int resultCode, int requestCode) {
        File file;
        if (requestCode != 4567) {
            return;
        }
        if (resultCode == -1) {
            File file2 = this.photoFile;
            if (file2 != null) {
                Context contextRequireContext = requireContext();
                m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                contextRequireContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file2)));
                b<Object> bVarK = k();
                if (bVarK != null) {
                    bVarK.f(a.a(file2));
                }
            }
        } else if (resultCode != 0 && (file = this.photoFile) != null) {
            String string = getString(R$h.camera_intent_result_error);
            m.checkNotNullExpressionValue(string, "getString(R.string.camera_intent_result_error)");
            Toast.makeText(getContext(), string, 0).show();
            file.delete();
        }
        CameraView cameraView = this.cameraView;
        if (cameraView == null) {
            m.throwUninitializedPropertyAccessException("cameraView");
        }
        cameraView.open();
        this.photoFile = null;
        this.photoFilePending = false;
    }

    public final b<Object> k() {
        Fragment parentFragment = getParentFragment();
        Fragment parentFragment2 = parentFragment != null ? parentFragment.getParentFragment() : null;
        return (b) (parentFragment2 instanceof b ? parentFragment2 : null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        i(resultCode, requestCode);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        m.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R$g.fragment_camera, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Context context;
        PackageManager packageManager;
        super.onResume();
        View view = getView();
        boolean z2 = (view == null || (context = view.getContext()) == null || (packageManager = context.getPackageManager()) == null || !packageManager.hasSystemFeature("android.hardware.camera.any")) ? false : true;
        b<Object> bVarK = k();
        boolean z3 = bVarK != null && bVarK.hasMediaPermissions();
        if (z2 && z3) {
            View view2 = this.cameraContainer;
            if (view2 == null) {
                m.throwUninitializedPropertyAccessException("cameraContainer");
            }
            view2.setVisibility(0);
            ViewStub viewStub = this.permissionsViewStub;
            if (viewStub == null) {
                m.throwUninitializedPropertyAccessException("permissionsViewStub");
            }
            if (m.areEqual(viewStub.getTag(), Boolean.TRUE)) {
                ViewStub viewStub2 = this.permissionsViewStub;
                if (viewStub2 == null) {
                    m.throwUninitializedPropertyAccessException("permissionsViewStub");
                }
                viewStub2.setVisibility(8);
                return;
            }
            return;
        }
        View view3 = this.cameraContainer;
        if (view3 == null) {
            m.throwUninitializedPropertyAccessException("cameraContainer");
        }
        view3.setVisibility(8);
        ViewStub viewStub3 = this.permissionsViewStub;
        if (viewStub3 == null) {
            m.throwUninitializedPropertyAccessException("permissionsViewStub");
        }
        if (viewStub3.getTag() != null) {
            ViewStub viewStub4 = this.permissionsViewStub;
            if (viewStub4 == null) {
                m.throwUninitializedPropertyAccessException("permissionsViewStub");
            }
            viewStub4.setVisibility(0);
            return;
        }
        ViewStub viewStub5 = this.permissionsViewStub;
        if (viewStub5 == null) {
            m.throwUninitializedPropertyAccessException("permissionsViewStub");
        }
        viewStub5.setTag(Boolean.TRUE);
        ViewStub viewStub6 = this.permissionsViewStub;
        if (viewStub6 == null) {
            m.throwUninitializedPropertyAccessException("permissionsViewStub");
        }
        View viewInflate = viewStub6.inflate();
        viewInflate.findViewById(R$f.permissions_required_action_btn).setOnClickListener(new CameraFragment$c(this));
        View viewFindViewById = viewInflate.findViewById(R$f.permissions_required_text);
        m.checkNotNullExpressionValue(viewFindViewById, "view.findViewById<TextVi…ermissions_required_text)");
        b.a.k.b.n((TextView) viewFindViewById, R$h.system_permission_request_camera, new Object[0], null, 4);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R$f.permissions_view_stub);
        m.checkNotNullExpressionValue(viewFindViewById, "view.findViewById(R.id.permissions_view_stub)");
        this.permissionsViewStub = (ViewStub) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R$f.camera_container);
        m.checkNotNullExpressionValue(viewFindViewById2, "view.findViewById(R.id.camera_container)");
        this.cameraContainer = viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R$f.camera_view);
        m.checkNotNullExpressionValue(viewFindViewById3, "view.findViewById(R.id.camera_view)");
        CameraView cameraView = (CameraView) viewFindViewById3;
        this.cameraView = cameraView;
        if (cameraView == null) {
            m.throwUninitializedPropertyAccessException("cameraView");
        }
        cameraView.setLifecycleOwner(getViewLifecycleOwner());
        CameraView cameraView2 = this.cameraView;
        if (cameraView2 == null) {
            m.throwUninitializedPropertyAccessException("cameraView");
        }
        cameraView2.setPlaySounds(false);
        CameraView cameraView3 = this.cameraView;
        if (cameraView3 == null) {
            m.throwUninitializedPropertyAccessException("cameraView");
        }
        cameraView3.D.add(new CameraFragment$d(this, view));
        View viewFindViewById4 = view.findViewById(R$f.take_photo_btn);
        m.checkNotNullExpressionValue(viewFindViewById4, "view.findViewById(R.id.take_photo_btn)");
        ImageView imageView = (ImageView) viewFindViewById4;
        this.takePhotoBtn = imageView;
        if (imageView == null) {
            m.throwUninitializedPropertyAccessException("takePhotoBtn");
        }
        imageView.setOnClickListener(new CameraFragment$a(0, this));
        ImageView imageView2 = this.takePhotoBtn;
        if (imageView2 == null) {
            m.throwUninitializedPropertyAccessException("takePhotoBtn");
        }
        imageView2.setImageTintList(null);
        View viewFindViewById5 = view.findViewById(R$f.launch_camera_btn);
        m.checkNotNullExpressionValue(viewFindViewById5, "view.findViewById(R.id.launch_camera_btn)");
        ImageView imageView3 = (ImageView) viewFindViewById5;
        this.launchCameraBtn = imageView3;
        if (imageView3 == null) {
            m.throwUninitializedPropertyAccessException("launchCameraBtn");
        }
        imageView3.setOnClickListener(new CameraFragment$a(1, this));
        ImageView imageView4 = this.launchCameraBtn;
        if (imageView4 == null) {
            m.throwUninitializedPropertyAccessException("launchCameraBtn");
        }
        imageView4.setImageTintList(ColorStateList.valueOf(-1));
        ImageView imageView5 = this.launchCameraBtn;
        if (imageView5 == null) {
            m.throwUninitializedPropertyAccessException("launchCameraBtn");
        }
        imageView5.setImageResource(R$e.ic_launch_24dp);
        View viewFindViewById6 = view.findViewById(R$f.camera_flash_btn);
        m.checkNotNullExpressionValue(viewFindViewById6, "view.findViewById(R.id.camera_flash_btn)");
        ImageView imageView6 = (ImageView) viewFindViewById6;
        this.cameraFlashBtn = imageView6;
        if (imageView6 == null) {
            m.throwUninitializedPropertyAccessException("cameraFlashBtn");
        }
        imageView6.setOnClickListener(new CameraFragment$a(2, this));
        ImageView imageView7 = this.cameraFlashBtn;
        if (imageView7 == null) {
            m.throwUninitializedPropertyAccessException("cameraFlashBtn");
        }
        imageView7.setImageTintList(ColorStateList.valueOf(-1));
        View viewFindViewById7 = view.findViewById(R$f.camera_facing_btn);
        m.checkNotNullExpressionValue(viewFindViewById7, "view.findViewById(R.id.camera_facing_btn)");
        ImageView imageView8 = (ImageView) viewFindViewById7;
        this.cameraFacingBtn = imageView8;
        if (imageView8 == null) {
            m.throwUninitializedPropertyAccessException("cameraFacingBtn");
        }
        imageView8.setOnClickListener(new CameraFragment$a(3, this));
        ImageView imageView9 = this.cameraFacingBtn;
        if (imageView9 == null) {
            m.throwUninitializedPropertyAccessException("cameraFacingBtn");
        }
        imageView9.setImageTintList(ColorStateList.valueOf(-1));
    }
}
