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
import com.lytefast.flexinput.C11170R;
import com.lytefast.flexinput.managers.FileManager;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p000.C13003q;
import p007b.p008a.p027k.C1107b;
import p007b.p076b.p077a.InterfaceC1429b;
import p007b.p076b.p077a.p082g.C1449a;
import p007b.p452o.p453a.AbstractC5102a;
import p007b.p452o.p453a.AbstractC5104c;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.C5106e;
import p007b.p452o.p453a.C5113l;
import p007b.p452o.p453a.InterfaceC5112k;
import p007b.p452o.p453a.RunnableC5105d;
import p007b.p452o.p453a.p454m.EnumC5118e;
import p007b.p452o.p453a.p454m.EnumC5119f;
import p007b.p452o.p453a.p467r.C5206g;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

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

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public boolean photoFilePending;

    /* JADX INFO: renamed from: com.lytefast.flexinput.fragment.CameraFragment$a */
    /* JADX INFO: compiled from: java-style lambda group */
    /* JADX INFO: loaded from: classes.dex */
    public static final class ViewOnClickListenerC11175a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f22045j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Object f22046k;

        public ViewOnClickListenerC11175a(int i, Object obj) {
            this.f22045j = i;
            this.f22046k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            List listEmptyList;
            Collection<EnumC5119f> collectionM7162b;
            List listEmptyList2;
            Collection<EnumC5118e> collectionM7161a;
            int i = this.f22045j;
            if (i == 0) {
                CameraView cameraView = ((CameraFragment) this.f22046k).cameraView;
                if (cameraView == null) {
                    C12238m.throwUninitializedPropertyAccessException("cameraView");
                }
                cameraView.f22138z.mo7269O0(new C5113l.a());
                return;
            }
            Integer num = null;
            if (i == 1) {
                CameraFragment cameraFragment = (CameraFragment) this.f22046k;
                cameraFragment.photoFile = null;
                cameraFragment.photoFilePending = true;
                CameraView cameraView2 = cameraFragment.cameraView;
                if (cameraView2 == null) {
                    C12238m.throwUninitializedPropertyAccessException("cameraView");
                }
                cameraView2.close();
                return;
            }
            if (i != 2) {
                if (i != 3) {
                    throw null;
                }
                CameraFragment cameraFragment2 = (CameraFragment) this.f22046k;
                CameraView cameraView3 = cameraFragment2.cameraView;
                if (cameraView3 == null) {
                    C12238m.throwUninitializedPropertyAccessException("cameraView");
                }
                AbstractC5104c cameraOptions = cameraView3.getCameraOptions();
                if (cameraOptions == null || (collectionM7161a = cameraOptions.m7161a()) == null || (listEmptyList2 = C12163u.toList(collectionM7161a)) == null) {
                    listEmptyList2 = C12147n.emptyList();
                }
                if (listEmptyList2.size() <= 1) {
                    return;
                }
                CameraView cameraView4 = cameraFragment2.cameraView;
                if (cameraView4 == null) {
                    C12238m.throwUninitializedPropertyAccessException("cameraView");
                }
                EnumC5118e facing = cameraView4.getFacing();
                C12238m.checkNotNullExpressionValue(facing, "cameraView.facing");
                for (Integer num2 : C12147n.getIndices(listEmptyList2)) {
                    if (facing == ((EnumC5118e) listEmptyList2.get(num2.intValue()))) {
                        num = num2;
                        break;
                    }
                }
                Integer num3 = num;
                EnumC5118e enumC5118e = (EnumC5118e) C12163u.getOrNull(listEmptyList2, ((num3 != null ? num3.intValue() : 0) + 1) % listEmptyList2.size());
                if (enumC5118e != null) {
                    cameraFragment2.m9284g();
                    CameraView cameraView5 = cameraFragment2.cameraView;
                    if (cameraView5 == null) {
                        C12238m.throwUninitializedPropertyAccessException("cameraView");
                    }
                    cameraView5.setFacing(enumC5118e);
                    return;
                }
                return;
            }
            CameraFragment cameraFragment3 = (CameraFragment) this.f22046k;
            CameraView cameraView6 = cameraFragment3.cameraView;
            if (cameraView6 == null) {
                C12238m.throwUninitializedPropertyAccessException("cameraView");
            }
            AbstractC5104c cameraOptions2 = cameraView6.getCameraOptions();
            if (cameraOptions2 == null || (collectionM7162b = cameraOptions2.m7162b()) == null || (listEmptyList = C12163u.toList(collectionM7162b)) == null) {
                listEmptyList = C12147n.emptyList();
            }
            if (listEmptyList.size() <= 1) {
                return;
            }
            CameraView cameraView7 = cameraFragment3.cameraView;
            if (cameraView7 == null) {
                C12238m.throwUninitializedPropertyAccessException("cameraView");
            }
            EnumC5119f flash = cameraView7.getFlash();
            C12238m.checkNotNullExpressionValue(flash, "cameraView.flash");
            for (Integer num4 : C12147n.getIndices(listEmptyList)) {
                if (flash == ((EnumC5119f) listEmptyList.get(num4.intValue()))) {
                    num = num4;
                    break;
                }
            }
            Integer num5 = num;
            EnumC5119f enumC5119f = (EnumC5119f) C12163u.getOrNull(listEmptyList, ((num5 != null ? num5.intValue() : 0) + 1) % listEmptyList.size());
            if (enumC5119f != null) {
                try {
                    CameraView cameraView8 = cameraFragment3.cameraView;
                    if (cameraView8 == null) {
                        C12238m.throwUninitializedPropertyAccessException("cameraView");
                    }
                    cameraView8.setFlash(enumC5119f);
                    cameraFragment3.m9285h();
                } catch (Exception e) {
                    String string = cameraFragment3.getString(C11170R.h.camera_unknown_error);
                    C12238m.checkNotNullExpressionValue(string, "getString(R.string.camera_unknown_error)");
                    CameraFragment.m9283l(cameraFragment3, string, e, true, null, 8, null);
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

    /* JADX INFO: renamed from: com.lytefast.flexinput.fragment.CameraFragment$c */
    /* JADX INFO: compiled from: CameraFragment.kt */
    public static final class ViewOnClickListenerC11177c implements View.OnClickListener {
        public ViewOnClickListenerC11177c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CameraFragment cameraFragment = CameraFragment.this;
            Companion companion = CameraFragment.INSTANCE;
            InterfaceC1429b<Object> interfaceC1429bM9287k = cameraFragment.m9287k();
            if (interfaceC1429bM9287k != null) {
                interfaceC1429bM9287k.requestMediaPermissions(C13003q.f27626k);
            }
        }
    }

    /* JADX INFO: renamed from: com.lytefast.flexinput.fragment.CameraFragment$d */
    /* JADX INFO: compiled from: CameraFragment.kt */
    public static final class C11178d extends AbstractC5102a {

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ View f22049b;

        /* JADX INFO: renamed from: com.lytefast.flexinput.fragment.CameraFragment$d$a */
        /* JADX INFO: compiled from: CameraFragment.kt */
        public static final class a implements InterfaceC5112k {
            public a() {
            }

            @Override // p007b.p452o.p453a.InterfaceC5112k
            /* JADX INFO: renamed from: a */
            public final void mo7165a(File file) {
                if (file != null) {
                    Companion companion = CameraFragment.INSTANCE;
                    Context context = C11178d.this.f22049b.getContext();
                    C12238m.checkNotNullExpressionValue(context, "view.context");
                    context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
                    InterfaceC1429b<Object> interfaceC1429bM9287k = CameraFragment.this.m9287k();
                    if (interfaceC1429bM9287k != null) {
                        interfaceC1429bM9287k.mo397f(C1449a.m410a(file));
                    }
                }
            }
        }

        public C11178d(View view) {
            this.f22049b = view;
        }

        @Override // p007b.p452o.p453a.AbstractC5102a
        /* JADX INFO: renamed from: a */
        public void mo7155a() {
            CameraFragment cameraFragment = CameraFragment.this;
            if (cameraFragment.photoFilePending) {
                InterfaceC1429b<Object> interfaceC1429bM9287k = cameraFragment.m9287k();
                FileManager fileManager = interfaceC1429bM9287k != null ? interfaceC1429bM9287k.getFileManager() : null;
                File fileMo409b = fileManager != null ? fileManager.mo409b() : null;
                if (fileMo409b == null) {
                    CameraFragment.m9282j(cameraFragment, 0, 0, 3, null);
                    return;
                }
                Context contextRequireContext = cameraFragment.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                Uri uriMo408a = fileManager.mo408a(contextRequireContext, fileMo409b);
                Intent intentAddFlags = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uriMo408a).addFlags(2);
                Context contextRequireContext2 = cameraFragment.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                C12238m.checkNotNullExpressionValue(intentAddFlags, "intent");
                List<ResolveInfo> listQueryIntentActivities = contextRequireContext2.getPackageManager().queryIntentActivities(intentAddFlags, 65536);
                C12238m.checkNotNullExpressionValue(listQueryIntentActivities, "packageManager.queryInte…nager.MATCH_DEFAULT_ONLY)");
                Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
                while (it.hasNext()) {
                    contextRequireContext2.grantUriPermission(it.next().activityInfo.packageName, uriMo408a, 3);
                }
                C12238m.checkNotNullExpressionValue(intentAddFlags, "Intent(MediaStore.ACTION…nt, photoUri)\n          }");
                cameraFragment.photoFile = fileMo409b;
                try {
                    cameraFragment.startActivityForResult(intentAddFlags, 4567);
                } catch (ActivityNotFoundException unused) {
                    CameraFragment.m9282j(cameraFragment, 0, 0, 3, null);
                }
            }
        }

        @Override // p007b.p452o.p453a.AbstractC5102a
        /* JADX INFO: renamed from: b */
        public void mo7156b(CameraException cameraException) {
            C12238m.checkNotNullParameter(cameraException, "exception");
            CameraFragment cameraFragment = CameraFragment.this;
            String string = cameraFragment.getString(C11170R.h.camera_unknown_error);
            C12238m.checkNotNullExpressionValue(string, "getString(R.string.camera_unknown_error)");
            CameraFragment.m9283l(cameraFragment, string, cameraException, true, null, 8, null);
        }

        @Override // p007b.p452o.p453a.AbstractC5102a
        /* JADX INFO: renamed from: c */
        public void mo7157c(AbstractC5104c abstractC5104c) {
            C12238m.checkNotNullParameter(abstractC5104c, "cameraOptions");
            CameraFragment cameraFragment = CameraFragment.this;
            Companion companion = CameraFragment.INSTANCE;
            cameraFragment.m9285h();
            CameraFragment.this.m9284g();
            ImageView imageView = CameraFragment.this.cameraFacingBtn;
            if (imageView == null) {
                C12238m.throwUninitializedPropertyAccessException("cameraFacingBtn");
            }
            imageView.setVisibility(abstractC5104c.m7161a().size() > 1 ? 0 : 8);
            ImageView imageView2 = CameraFragment.this.cameraFlashBtn;
            if (imageView2 == null) {
                C12238m.throwUninitializedPropertyAccessException("cameraFlashBtn");
            }
            imageView2.setVisibility(abstractC5104c.m7162b().size() > 1 ? 0 : 8);
        }

        @Override // p007b.p452o.p453a.AbstractC5102a
        /* JADX INFO: renamed from: d */
        public void mo7158d(C5113l c5113l) {
            FileManager fileManager;
            File fileMo409b;
            C12238m.checkNotNullParameter(c5113l, "result");
            CameraFragment cameraFragment = CameraFragment.this;
            Companion companion = CameraFragment.INSTANCE;
            InterfaceC1429b<Object> interfaceC1429bM9287k = cameraFragment.m9287k();
            if (interfaceC1429bM9287k == null || (fileManager = interfaceC1429bM9287k.getFileManager()) == null || (fileMo409b = fileManager.mo409b()) == null) {
                return;
            }
            a aVar = new a();
            byte[] bArr = c5113l.f13714a;
            C5103b c5103b = C5106e.f13705a;
            C5206g.m7402a(new RunnableC5105d(bArr, fileMo409b, new Handler(), aVar));
        }
    }

    /* JADX INFO: renamed from: j */
    public static /* synthetic */ void m9282j(CameraFragment cameraFragment, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 4567;
        }
        cameraFragment.m9286i(i, i2);
    }

    /* JADX INFO: renamed from: l */
    public static void m9283l(CameraFragment cameraFragment, String str, Exception exc, boolean z2, String str2, int i, Object obj) {
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

    /* JADX INFO: renamed from: g */
    public final void m9284g() {
        ImageView imageView = this.cameraFacingBtn;
        if (imageView == null) {
            C12238m.throwUninitializedPropertyAccessException("cameraFacingBtn");
        }
        CameraView cameraView = this.cameraView;
        if (cameraView == null) {
            C12238m.throwUninitializedPropertyAccessException("cameraView");
        }
        int iOrdinal = cameraView.getFacing().ordinal();
        int i = (iOrdinal == 0 || iOrdinal != 1) ? C11170R.e.ic_camera_front_white_24dp : C11170R.e.ic_camera_rear_white_24dp;
        imageView.setImageResource(i);
    }

    /* JADX INFO: renamed from: h */
    public final void m9285h() {
        int i;
        String string;
        ImageView imageView = this.cameraFlashBtn;
        if (imageView == null) {
            C12238m.throwUninitializedPropertyAccessException("cameraFlashBtn");
        }
        CameraView cameraView = this.cameraView;
        if (cameraView == null) {
            C12238m.throwUninitializedPropertyAccessException("cameraView");
        }
        int iOrdinal = cameraView.getFlash().ordinal();
        if (iOrdinal == 0) {
            i = C11170R.e.ic_flash_off_24dp;
        } else if (iOrdinal != 1) {
            i = iOrdinal != 3 ? C11170R.e.ic_flash_auto_24dp : C11170R.e.ic_flash_torch_24dp;
        } else {
            i = C11170R.e.ic_flash_on_24dp;
        }
        imageView.setImageResource(i);
        ImageView imageView2 = this.cameraFlashBtn;
        if (imageView2 == null) {
            C12238m.throwUninitializedPropertyAccessException("cameraFlashBtn");
        }
        CameraView cameraView2 = this.cameraView;
        if (cameraView2 == null) {
            C12238m.throwUninitializedPropertyAccessException("cameraView");
        }
        int iOrdinal2 = cameraView2.getFlash().ordinal();
        if (iOrdinal2 == 0) {
            string = getString(C11170R.h.flash_off);
        } else if (iOrdinal2 != 1) {
            string = (iOrdinal2 == 2 || iOrdinal2 != 3) ? getString(C11170R.h.flash_auto) : getString(C11170R.h.flash_torch);
        } else {
            string = getString(C11170R.h.flash_on);
        }
        imageView2.setContentDescription(string);
    }

    /* JADX INFO: renamed from: i */
    public final void m9286i(int resultCode, int requestCode) {
        File file;
        if (requestCode != 4567) {
            return;
        }
        if (resultCode == -1) {
            File file2 = this.photoFile;
            if (file2 != null) {
                Context contextRequireContext = requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                contextRequireContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file2)));
                InterfaceC1429b<Object> interfaceC1429bM9287k = m9287k();
                if (interfaceC1429bM9287k != null) {
                    interfaceC1429bM9287k.mo397f(C1449a.m410a(file2));
                }
            }
        } else if (resultCode != 0 && (file = this.photoFile) != null) {
            String string = getString(C11170R.h.camera_intent_result_error);
            C12238m.checkNotNullExpressionValue(string, "getString(R.string.camera_intent_result_error)");
            Toast.makeText(getContext(), string, 0).show();
            file.delete();
        }
        CameraView cameraView = this.cameraView;
        if (cameraView == null) {
            C12238m.throwUninitializedPropertyAccessException("cameraView");
        }
        cameraView.open();
        this.photoFile = null;
        this.photoFilePending = false;
    }

    /* JADX INFO: renamed from: k */
    public final InterfaceC1429b<Object> m9287k() {
        Fragment parentFragment = getParentFragment();
        Fragment parentFragment2 = parentFragment != null ? parentFragment.getParentFragment() : null;
        return (InterfaceC1429b) (parentFragment2 instanceof InterfaceC1429b ? parentFragment2 : null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        m9286i(resultCode, requestCode);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C11170R.g.fragment_camera, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Context context;
        PackageManager packageManager;
        super.onResume();
        View view = getView();
        boolean z2 = (view == null || (context = view.getContext()) == null || (packageManager = context.getPackageManager()) == null || !packageManager.hasSystemFeature("android.hardware.camera.any")) ? false : true;
        InterfaceC1429b<Object> interfaceC1429bM9287k = m9287k();
        boolean z3 = interfaceC1429bM9287k != null && interfaceC1429bM9287k.hasMediaPermissions();
        if (z2 && z3) {
            View view2 = this.cameraContainer;
            if (view2 == null) {
                C12238m.throwUninitializedPropertyAccessException("cameraContainer");
            }
            view2.setVisibility(0);
            ViewStub viewStub = this.permissionsViewStub;
            if (viewStub == null) {
                C12238m.throwUninitializedPropertyAccessException("permissionsViewStub");
            }
            if (C12238m.areEqual(viewStub.getTag(), Boolean.TRUE)) {
                ViewStub viewStub2 = this.permissionsViewStub;
                if (viewStub2 == null) {
                    C12238m.throwUninitializedPropertyAccessException("permissionsViewStub");
                }
                viewStub2.setVisibility(8);
                return;
            }
            return;
        }
        View view3 = this.cameraContainer;
        if (view3 == null) {
            C12238m.throwUninitializedPropertyAccessException("cameraContainer");
        }
        view3.setVisibility(8);
        ViewStub viewStub3 = this.permissionsViewStub;
        if (viewStub3 == null) {
            C12238m.throwUninitializedPropertyAccessException("permissionsViewStub");
        }
        if (viewStub3.getTag() != null) {
            ViewStub viewStub4 = this.permissionsViewStub;
            if (viewStub4 == null) {
                C12238m.throwUninitializedPropertyAccessException("permissionsViewStub");
            }
            viewStub4.setVisibility(0);
            return;
        }
        ViewStub viewStub5 = this.permissionsViewStub;
        if (viewStub5 == null) {
            C12238m.throwUninitializedPropertyAccessException("permissionsViewStub");
        }
        viewStub5.setTag(Boolean.TRUE);
        ViewStub viewStub6 = this.permissionsViewStub;
        if (viewStub6 == null) {
            C12238m.throwUninitializedPropertyAccessException("permissionsViewStub");
        }
        View viewInflate = viewStub6.inflate();
        viewInflate.findViewById(C11170R.f.permissions_required_action_btn).setOnClickListener(new ViewOnClickListenerC11177c());
        View viewFindViewById = viewInflate.findViewById(C11170R.f.permissions_required_text);
        C12238m.checkNotNullExpressionValue(viewFindViewById, "view.findViewById<TextVi…ermissions_required_text)");
        C1107b.m221m((TextView) viewFindViewById, C11170R.h.system_permission_request_camera, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(C11170R.f.permissions_view_stub);
        C12238m.checkNotNullExpressionValue(viewFindViewById, "view.findViewById(R.id.permissions_view_stub)");
        this.permissionsViewStub = (ViewStub) viewFindViewById;
        View viewFindViewById2 = view.findViewById(C11170R.f.camera_container);
        C12238m.checkNotNullExpressionValue(viewFindViewById2, "view.findViewById(R.id.camera_container)");
        this.cameraContainer = viewFindViewById2;
        View viewFindViewById3 = view.findViewById(C11170R.f.camera_view);
        C12238m.checkNotNullExpressionValue(viewFindViewById3, "view.findViewById(R.id.camera_view)");
        CameraView cameraView = (CameraView) viewFindViewById3;
        this.cameraView = cameraView;
        if (cameraView == null) {
            C12238m.throwUninitializedPropertyAccessException("cameraView");
        }
        cameraView.setLifecycleOwner(getViewLifecycleOwner());
        CameraView cameraView2 = this.cameraView;
        if (cameraView2 == null) {
            C12238m.throwUninitializedPropertyAccessException("cameraView");
        }
        cameraView2.setPlaySounds(false);
        CameraView cameraView3 = this.cameraView;
        if (cameraView3 == null) {
            C12238m.throwUninitializedPropertyAccessException("cameraView");
        }
        cameraView3.f22113D.add(new C11178d(view));
        View viewFindViewById4 = view.findViewById(C11170R.f.take_photo_btn);
        C12238m.checkNotNullExpressionValue(viewFindViewById4, "view.findViewById(R.id.take_photo_btn)");
        ImageView imageView = (ImageView) viewFindViewById4;
        this.takePhotoBtn = imageView;
        if (imageView == null) {
            C12238m.throwUninitializedPropertyAccessException("takePhotoBtn");
        }
        imageView.setOnClickListener(new ViewOnClickListenerC11175a(0, this));
        ImageView imageView2 = this.takePhotoBtn;
        if (imageView2 == null) {
            C12238m.throwUninitializedPropertyAccessException("takePhotoBtn");
        }
        imageView2.setImageTintList(null);
        View viewFindViewById5 = view.findViewById(C11170R.f.launch_camera_btn);
        C12238m.checkNotNullExpressionValue(viewFindViewById5, "view.findViewById(R.id.launch_camera_btn)");
        ImageView imageView3 = (ImageView) viewFindViewById5;
        this.launchCameraBtn = imageView3;
        if (imageView3 == null) {
            C12238m.throwUninitializedPropertyAccessException("launchCameraBtn");
        }
        imageView3.setOnClickListener(new ViewOnClickListenerC11175a(1, this));
        ImageView imageView4 = this.launchCameraBtn;
        if (imageView4 == null) {
            C12238m.throwUninitializedPropertyAccessException("launchCameraBtn");
        }
        imageView4.setImageTintList(ColorStateList.valueOf(-1));
        ImageView imageView5 = this.launchCameraBtn;
        if (imageView5 == null) {
            C12238m.throwUninitializedPropertyAccessException("launchCameraBtn");
        }
        imageView5.setImageResource(C11170R.e.ic_launch_24dp);
        View viewFindViewById6 = view.findViewById(C11170R.f.camera_flash_btn);
        C12238m.checkNotNullExpressionValue(viewFindViewById6, "view.findViewById(R.id.camera_flash_btn)");
        ImageView imageView6 = (ImageView) viewFindViewById6;
        this.cameraFlashBtn = imageView6;
        if (imageView6 == null) {
            C12238m.throwUninitializedPropertyAccessException("cameraFlashBtn");
        }
        imageView6.setOnClickListener(new ViewOnClickListenerC11175a(2, this));
        ImageView imageView7 = this.cameraFlashBtn;
        if (imageView7 == null) {
            C12238m.throwUninitializedPropertyAccessException("cameraFlashBtn");
        }
        imageView7.setImageTintList(ColorStateList.valueOf(-1));
        View viewFindViewById7 = view.findViewById(C11170R.f.camera_facing_btn);
        C12238m.checkNotNullExpressionValue(viewFindViewById7, "view.findViewById(R.id.camera_facing_btn)");
        ImageView imageView8 = (ImageView) viewFindViewById7;
        this.cameraFacingBtn = imageView8;
        if (imageView8 == null) {
            C12238m.throwUninitializedPropertyAccessException("cameraFacingBtn");
        }
        imageView8.setOnClickListener(new ViewOnClickListenerC11175a(3, this));
        ImageView imageView9 = this.cameraFacingBtn;
        if (imageView9 == null) {
            C12238m.throwUninitializedPropertyAccessException("cameraFacingBtn");
        }
        imageView9.setImageTintList(ColorStateList.valueOf(-1));
    }
}
