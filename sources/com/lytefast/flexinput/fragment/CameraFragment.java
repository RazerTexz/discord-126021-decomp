package com.lytefast.flexinput.fragment;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import b.a.k.FormatUtils;
import b.b.a.FlexInputCoordinator;
import b.b.a.g.FileUtils;
import b.o.a.CameraListener;
import b.o.a.CameraLogger;
import b.o.a.CameraOptions;
import b.o.a.CameraUtils;
import b.o.a.CameraUtils2;
import b.o.a.FileCallback;
import b.o.a.PictureResult;
import b.o.a.m.Facing;
import b.o.a.m.Flash;
import b.o.a.r.WorkerHandler;
import com.lytefast.flexinput.R;
import com.lytefast.flexinput.managers.FileManager;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import defpackage.q;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CameraFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public class CameraFragment extends Fragment {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

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

    /* JADX INFO: compiled from: java-style lambda group */
    /* JADX INFO: loaded from: classes.dex */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public a(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            List listEmptyList;
            Collection<Flash> collectionB;
            List listEmptyList2;
            Collection<Facing> collectionA;
            int i = this.j;
            if (i == 0) {
                CameraView cameraView = ((CameraFragment) this.k).cameraView;
                if (cameraView == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("cameraView");
                }
                cameraView.f3176z.O0(new PictureResult.a());
                return;
            }
            Integer num = null;
            if (i == 1) {
                CameraFragment cameraFragment = (CameraFragment) this.k;
                cameraFragment.photoFile = null;
                cameraFragment.photoFilePending = true;
                CameraView cameraView2 = cameraFragment.cameraView;
                if (cameraView2 == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("cameraView");
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
                    Intrinsics3.throwUninitializedPropertyAccessException("cameraView");
                }
                CameraOptions cameraOptions = cameraView3.getCameraOptions();
                if (cameraOptions == null || (collectionA = cameraOptions.a()) == null || (listEmptyList2 = _Collections.toList(collectionA)) == null) {
                    listEmptyList2 = Collections2.emptyList();
                }
                if (listEmptyList2.size() <= 1) {
                    return;
                }
                CameraView cameraView4 = cameraFragment2.cameraView;
                if (cameraView4 == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("cameraView");
                }
                Facing facing = cameraView4.getFacing();
                Intrinsics3.checkNotNullExpressionValue(facing, "cameraView.facing");
                for (Integer num2 : Collections2.getIndices(listEmptyList2)) {
                    if (facing == ((Facing) listEmptyList2.get(num2.intValue()))) {
                        num = num2;
                        break;
                    }
                }
                Integer num3 = num;
                Facing facing2 = (Facing) _Collections.getOrNull(listEmptyList2, ((num3 != null ? num3.intValue() : 0) + 1) % listEmptyList2.size());
                if (facing2 != null) {
                    cameraFragment2.g();
                    CameraView cameraView5 = cameraFragment2.cameraView;
                    if (cameraView5 == null) {
                        Intrinsics3.throwUninitializedPropertyAccessException("cameraView");
                    }
                    cameraView5.setFacing(facing2);
                    return;
                }
                return;
            }
            CameraFragment cameraFragment3 = (CameraFragment) this.k;
            CameraView cameraView6 = cameraFragment3.cameraView;
            if (cameraView6 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("cameraView");
            }
            CameraOptions cameraOptions2 = cameraView6.getCameraOptions();
            if (cameraOptions2 == null || (collectionB = cameraOptions2.b()) == null || (listEmptyList = _Collections.toList(collectionB)) == null) {
                listEmptyList = Collections2.emptyList();
            }
            if (listEmptyList.size() <= 1) {
                return;
            }
            CameraView cameraView7 = cameraFragment3.cameraView;
            if (cameraView7 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("cameraView");
            }
            Flash flash = cameraView7.getFlash();
            Intrinsics3.checkNotNullExpressionValue(flash, "cameraView.flash");
            for (Integer num4 : Collections2.getIndices(listEmptyList)) {
                if (flash == ((Flash) listEmptyList.get(num4.intValue()))) {
                    num = num4;
                    break;
                }
            }
            Integer num5 = num;
            Flash flash2 = (Flash) _Collections.getOrNull(listEmptyList, ((num5 != null ? num5.intValue() : 0) + 1) % listEmptyList.size());
            if (flash2 != null) {
                try {
                    CameraView cameraView8 = cameraFragment3.cameraView;
                    if (cameraView8 == null) {
                        Intrinsics3.throwUninitializedPropertyAccessException("cameraView");
                    }
                    cameraView8.setFlash(flash2);
                    cameraFragment3.h();
                } catch (Exception e) {
                    String string = cameraFragment3.getString(R.h.camera_unknown_error);
                    Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.camera_unknown_error)");
                    CameraFragment.l(cameraFragment3, string, e, true, null, 8, null);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.lytefast.flexinput.fragment.CameraFragment$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: CameraFragment.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: compiled from: CameraFragment.kt */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CameraFragment cameraFragment = CameraFragment.this;
            Companion companion = CameraFragment.INSTANCE;
            FlexInputCoordinator<Object> flexInputCoordinatorK = cameraFragment.k();
            if (flexInputCoordinatorK != null) {
                flexInputCoordinatorK.requestMediaPermissions(q.k);
            }
        }
    }

    /* JADX INFO: compiled from: CameraFragment.kt */
    public static final class d extends CameraListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f3164b;

        /* JADX INFO: compiled from: CameraFragment.kt */
        public static final class a implements FileCallback {
            public a() {
            }

            @Override // b.o.a.FileCallback
            public final void a(File file) {
                if (file != null) {
                    Companion companion = CameraFragment.INSTANCE;
                    Context context = d.this.f3164b.getContext();
                    Intrinsics3.checkNotNullExpressionValue(context, "view.context");
                    context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
                    FlexInputCoordinator<Object> flexInputCoordinatorK = CameraFragment.this.k();
                    if (flexInputCoordinatorK != null) {
                        flexInputCoordinatorK.f(FileUtils.a(file));
                    }
                }
            }
        }

        public d(View view) {
            this.f3164b = view;
        }

        @Override // b.o.a.CameraListener
        public void a() {
            CameraFragment cameraFragment = CameraFragment.this;
            if (cameraFragment.photoFilePending) {
                FlexInputCoordinator<Object> flexInputCoordinatorK = cameraFragment.k();
                FileManager fileManager = flexInputCoordinatorK != null ? flexInputCoordinatorK.getFileManager() : null;
                File fileB = fileManager != null ? fileManager.b() : null;
                if (fileB == null) {
                    CameraFragment.j(cameraFragment, 0, 0, 3, null);
                    return;
                }
                Context contextRequireContext = cameraFragment.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                Uri uriA = fileManager.a(contextRequireContext, fileB);
                Intent intentAddFlags = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uriA).addFlags(2);
                Context contextRequireContext2 = cameraFragment.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                Intrinsics3.checkNotNullExpressionValue(intentAddFlags, "intent");
                List<ResolveInfo> listQueryIntentActivities = contextRequireContext2.getPackageManager().queryIntentActivities(intentAddFlags, 65536);
                Intrinsics3.checkNotNullExpressionValue(listQueryIntentActivities, "packageManager.queryInte…nager.MATCH_DEFAULT_ONLY)");
                Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
                while (it.hasNext()) {
                    contextRequireContext2.grantUriPermission(it.next().activityInfo.packageName, uriA, 3);
                }
                Intrinsics3.checkNotNullExpressionValue(intentAddFlags, "Intent(MediaStore.ACTION…nt, photoUri)\n          }");
                cameraFragment.photoFile = fileB;
                try {
                    cameraFragment.startActivityForResult(intentAddFlags, 4567);
                } catch (ActivityNotFoundException unused) {
                    CameraFragment.j(cameraFragment, 0, 0, 3, null);
                }
            }
        }

        @Override // b.o.a.CameraListener
        public void b(CameraException cameraException) {
            Intrinsics3.checkNotNullParameter(cameraException, "exception");
            CameraFragment cameraFragment = CameraFragment.this;
            String string = cameraFragment.getString(R.h.camera_unknown_error);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.camera_unknown_error)");
            CameraFragment.l(cameraFragment, string, cameraException, true, null, 8, null);
        }

        @Override // b.o.a.CameraListener
        public void c(CameraOptions cameraOptions) {
            Intrinsics3.checkNotNullParameter(cameraOptions, "cameraOptions");
            CameraFragment cameraFragment = CameraFragment.this;
            Companion companion = CameraFragment.INSTANCE;
            cameraFragment.h();
            CameraFragment.this.g();
            ImageView imageView = CameraFragment.this.cameraFacingBtn;
            if (imageView == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("cameraFacingBtn");
            }
            imageView.setVisibility(cameraOptions.a().size() > 1 ? 0 : 8);
            ImageView imageView2 = CameraFragment.this.cameraFlashBtn;
            if (imageView2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("cameraFlashBtn");
            }
            imageView2.setVisibility(cameraOptions.b().size() > 1 ? 0 : 8);
        }

        @Override // b.o.a.CameraListener
        public void d(PictureResult pictureResult) {
            FileManager fileManager;
            File fileB;
            Intrinsics3.checkNotNullParameter(pictureResult, "result");
            CameraFragment cameraFragment = CameraFragment.this;
            Companion companion = CameraFragment.INSTANCE;
            FlexInputCoordinator<Object> flexInputCoordinatorK = cameraFragment.k();
            if (flexInputCoordinatorK == null || (fileManager = flexInputCoordinatorK.getFileManager()) == null || (fileB = fileManager.b()) == null) {
                return;
            }
            a aVar = new a();
            byte[] bArr = pictureResult.a;
            CameraLogger cameraLogger = CameraUtils2.a;
            WorkerHandler.a(new CameraUtils(bArr, fileB, new Handler(), aVar));
        }
    }

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
            Intrinsics3.throwUninitializedPropertyAccessException("cameraFacingBtn");
        }
        CameraView cameraView = this.cameraView;
        if (cameraView == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("cameraView");
        }
        int iOrdinal = cameraView.getFacing().ordinal();
        int i = (iOrdinal == 0 || iOrdinal != 1) ? R.e.ic_camera_front_white_24dp : R.e.ic_camera_rear_white_24dp;
        imageView.setImageResource(i);
    }

    public final void h() {
        int i;
        String string;
        ImageView imageView = this.cameraFlashBtn;
        if (imageView == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("cameraFlashBtn");
        }
        CameraView cameraView = this.cameraView;
        if (cameraView == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("cameraView");
        }
        int iOrdinal = cameraView.getFlash().ordinal();
        if (iOrdinal == 0) {
            i = R.e.ic_flash_off_24dp;
        } else if (iOrdinal != 1) {
            i = iOrdinal != 3 ? R.e.ic_flash_auto_24dp : R.e.ic_flash_torch_24dp;
        } else {
            i = R.e.ic_flash_on_24dp;
        }
        imageView.setImageResource(i);
        ImageView imageView2 = this.cameraFlashBtn;
        if (imageView2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("cameraFlashBtn");
        }
        CameraView cameraView2 = this.cameraView;
        if (cameraView2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("cameraView");
        }
        int iOrdinal2 = cameraView2.getFlash().ordinal();
        if (iOrdinal2 == 0) {
            string = getString(R.h.flash_off);
        } else if (iOrdinal2 != 1) {
            string = (iOrdinal2 == 2 || iOrdinal2 != 3) ? getString(R.h.flash_auto) : getString(R.h.flash_torch);
        } else {
            string = getString(R.h.flash_on);
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
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                contextRequireContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file2)));
                FlexInputCoordinator<Object> flexInputCoordinatorK = k();
                if (flexInputCoordinatorK != null) {
                    flexInputCoordinatorK.f(FileUtils.a(file2));
                }
            }
        } else if (resultCode != 0 && (file = this.photoFile) != null) {
            String string = getString(R.h.camera_intent_result_error);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.camera_intent_result_error)");
            Toast.makeText(getContext(), string, 0).show();
            file.delete();
        }
        CameraView cameraView = this.cameraView;
        if (cameraView == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("cameraView");
        }
        cameraView.open();
        this.photoFile = null;
        this.photoFilePending = false;
    }

    public final FlexInputCoordinator<Object> k() {
        Fragment parentFragment = getParentFragment();
        Fragment parentFragment2 = parentFragment != null ? parentFragment.getParentFragment() : null;
        return (FlexInputCoordinator) (parentFragment2 instanceof FlexInputCoordinator ? parentFragment2 : null);
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
        Intrinsics3.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.g.fragment_camera, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Context context;
        PackageManager packageManager;
        super.onResume();
        View view = getView();
        boolean z2 = (view == null || (context = view.getContext()) == null || (packageManager = context.getPackageManager()) == null || !packageManager.hasSystemFeature("android.hardware.camera.any")) ? false : true;
        FlexInputCoordinator<Object> flexInputCoordinatorK = k();
        boolean z3 = flexInputCoordinatorK != null && flexInputCoordinatorK.hasMediaPermissions();
        if (z2 && z3) {
            View view2 = this.cameraContainer;
            if (view2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("cameraContainer");
            }
            view2.setVisibility(0);
            ViewStub viewStub = this.permissionsViewStub;
            if (viewStub == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("permissionsViewStub");
            }
            if (Intrinsics3.areEqual(viewStub.getTag(), Boolean.TRUE)) {
                ViewStub viewStub2 = this.permissionsViewStub;
                if (viewStub2 == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("permissionsViewStub");
                }
                viewStub2.setVisibility(8);
                return;
            }
            return;
        }
        View view3 = this.cameraContainer;
        if (view3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("cameraContainer");
        }
        view3.setVisibility(8);
        ViewStub viewStub3 = this.permissionsViewStub;
        if (viewStub3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("permissionsViewStub");
        }
        if (viewStub3.getTag() != null) {
            ViewStub viewStub4 = this.permissionsViewStub;
            if (viewStub4 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("permissionsViewStub");
            }
            viewStub4.setVisibility(0);
            return;
        }
        ViewStub viewStub5 = this.permissionsViewStub;
        if (viewStub5 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("permissionsViewStub");
        }
        viewStub5.setTag(Boolean.TRUE);
        ViewStub viewStub6 = this.permissionsViewStub;
        if (viewStub6 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("permissionsViewStub");
        }
        View viewInflate = viewStub6.inflate();
        viewInflate.findViewById(R.f.permissions_required_action_btn).setOnClickListener(new c());
        View viewFindViewById = viewInflate.findViewById(R.f.permissions_required_text);
        Intrinsics3.checkNotNullExpressionValue(viewFindViewById, "view.findViewById<TextVi…ermissions_required_text)");
        FormatUtils.m((TextView) viewFindViewById, R.h.system_permission_request_camera, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.f.permissions_view_stub);
        Intrinsics3.checkNotNullExpressionValue(viewFindViewById, "view.findViewById(R.id.permissions_view_stub)");
        this.permissionsViewStub = (ViewStub) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.f.camera_container);
        Intrinsics3.checkNotNullExpressionValue(viewFindViewById2, "view.findViewById(R.id.camera_container)");
        this.cameraContainer = viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.f.camera_view);
        Intrinsics3.checkNotNullExpressionValue(viewFindViewById3, "view.findViewById(R.id.camera_view)");
        CameraView cameraView = (CameraView) viewFindViewById3;
        this.cameraView = cameraView;
        if (cameraView == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("cameraView");
        }
        cameraView.setLifecycleOwner(getViewLifecycleOwner());
        CameraView cameraView2 = this.cameraView;
        if (cameraView2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("cameraView");
        }
        cameraView2.setPlaySounds(false);
        CameraView cameraView3 = this.cameraView;
        if (cameraView3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("cameraView");
        }
        cameraView3.D.add(new d(view));
        View viewFindViewById4 = view.findViewById(R.f.take_photo_btn);
        Intrinsics3.checkNotNullExpressionValue(viewFindViewById4, "view.findViewById(R.id.take_photo_btn)");
        ImageView imageView = (ImageView) viewFindViewById4;
        this.takePhotoBtn = imageView;
        if (imageView == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("takePhotoBtn");
        }
        imageView.setOnClickListener(new a(0, this));
        ImageView imageView2 = this.takePhotoBtn;
        if (imageView2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("takePhotoBtn");
        }
        imageView2.setImageTintList(null);
        View viewFindViewById5 = view.findViewById(R.f.launch_camera_btn);
        Intrinsics3.checkNotNullExpressionValue(viewFindViewById5, "view.findViewById(R.id.launch_camera_btn)");
        ImageView imageView3 = (ImageView) viewFindViewById5;
        this.launchCameraBtn = imageView3;
        if (imageView3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("launchCameraBtn");
        }
        imageView3.setOnClickListener(new a(1, this));
        ImageView imageView4 = this.launchCameraBtn;
        if (imageView4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("launchCameraBtn");
        }
        imageView4.setImageTintList(ColorStateList.valueOf(-1));
        ImageView imageView5 = this.launchCameraBtn;
        if (imageView5 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("launchCameraBtn");
        }
        imageView5.setImageResource(R.e.ic_launch_24dp);
        View viewFindViewById6 = view.findViewById(R.f.camera_flash_btn);
        Intrinsics3.checkNotNullExpressionValue(viewFindViewById6, "view.findViewById(R.id.camera_flash_btn)");
        ImageView imageView6 = (ImageView) viewFindViewById6;
        this.cameraFlashBtn = imageView6;
        if (imageView6 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("cameraFlashBtn");
        }
        imageView6.setOnClickListener(new a(2, this));
        ImageView imageView7 = this.cameraFlashBtn;
        if (imageView7 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("cameraFlashBtn");
        }
        imageView7.setImageTintList(ColorStateList.valueOf(-1));
        View viewFindViewById7 = view.findViewById(R.f.camera_facing_btn);
        Intrinsics3.checkNotNullExpressionValue(viewFindViewById7, "view.findViewById(R.id.camera_facing_btn)");
        ImageView imageView8 = (ImageView) viewFindViewById7;
        this.cameraFacingBtn = imageView8;
        if (imageView8 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("cameraFacingBtn");
        }
        imageView8.setOnClickListener(new a(3, this));
        ImageView imageView9 = this.cameraFacingBtn;
        if (imageView9 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("cameraFacingBtn");
        }
        imageView9.setImageTintList(ColorStateList.valueOf(-1));
    }
}
