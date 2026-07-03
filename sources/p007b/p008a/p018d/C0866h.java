package p007b.p008a.p018d;

import android.os.Build;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.MainThread;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.content.ContextCompat;
import com.discord.C5419R;
import com.discord.app.AppPermissionsRequests;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.ClockFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.d.h */
/* JADX INFO: compiled from: AppPermissions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0866h implements AppPermissionsRequests {

    /* JADX INFO: renamed from: j */
    @Deprecated
    public static final HashMap<Integer, String[]> f508j;

    /* JADX INFO: renamed from: k */
    public static final a f509k = new a(null);

    /* JADX INFO: renamed from: l */
    public Function0<Unit> f510l;

    /* JADX INFO: renamed from: m */
    public Function1<? super Map<String, Boolean>, Unit> f511m;

    /* JADX INFO: renamed from: n */
    public long f512n;

    /* JADX INFO: renamed from: o */
    public final ActivityResultLauncher<String[]> f513o;

    /* JADX INFO: renamed from: p */
    public final ComponentActivity f514p;

    /* JADX INFO: renamed from: b.a.d.h$a */
    /* JADX INFO: compiled from: AppPermissions.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.d.h$b */
    /* JADX INFO: compiled from: AppPermissions.kt */
    public static final class b<O> implements ActivityResultCallback<Map<String, Boolean>> {
        public b() {
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public void onActivityResult(Map<String, Boolean> map) {
            Map<String, Boolean> map2 = map;
            if (map2.containsValue(Boolean.FALSE)) {
                Function1<? super Map<String, Boolean>, Unit> function1 = C0866h.this.f511m;
                if (function1 != null) {
                    C12238m.checkNotNullExpressionValue(map2, "grantResults");
                    function1.invoke(map2);
                }
            } else {
                Function0<Unit> function0 = C0866h.this.f510l;
                if (function0 != null) {
                    function0.invoke();
                }
            }
            C0866h c0866h = C0866h.this;
            c0866h.f511m = null;
            c0866h.f510l = null;
            c0866h.f512n = 0L;
        }
    }

    /* JADX INFO: renamed from: b.a.d.h$c */
    /* JADX INFO: compiled from: AppPermissions.kt */
    public static final class c extends AbstractC12240o implements Function1<Map<String, ? extends Boolean>, Unit> {
        public final /* synthetic */ Function0 $onFailure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Function0 function0) {
            super(1);
            this.$onFailure = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Map<String, ? extends Boolean> map) {
            C12238m.checkNotNullParameter(map, "it");
            Function0 function0 = this.$onFailure;
            if (function0 == null || ((Unit) function0.invoke()) == null) {
                C0866h.m151a(C0866h.this, C5419R.string.permission_qr_scanner_denied);
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.d.h$d */
    /* JADX INFO: compiled from: AppPermissions.kt */
    public static final class d extends AbstractC12240o implements Function1<Map<String, ? extends Boolean>, Unit> {
        public final /* synthetic */ Function0 $onFailure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Function0 function0) {
            super(1);
            this.$onFailure = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Map<String, ? extends Boolean> map) {
            C12238m.checkNotNullParameter(map, "it");
            this.$onFailure.invoke();
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.d.h$e */
    /* JADX INFO: compiled from: AppPermissions.kt */
    public static final class e extends AbstractC12240o implements Function1<Map<String, ? extends Boolean>, Unit> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Map<String, ? extends Boolean> map) {
            C12238m.checkNotNullParameter(map, "it");
            C0866h.m151a(C0866h.this, C5419R.string.permission_media_denied);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.d.h$f */
    /* JADX INFO: compiled from: AppPermissions.kt */
    public static final class f extends AbstractC12240o implements Function1<Map<String, ? extends Boolean>, Unit> {
        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Map<String, ? extends Boolean> map) {
            C12238m.checkNotNullParameter(map, "it");
            C0866h.m151a(C0866h.this, C5419R.string.permission_media_download_denied);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.d.h$g */
    /* JADX INFO: compiled from: AppPermissions.kt */
    public static final class g extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ boolean $hadPermissions;
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(boolean z2, Function0 function0) {
            super(0);
            this.$hadPermissions = z2;
            this.$onSuccess = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (!this.$hadPermissions) {
                StoreStream.INSTANCE.getMediaEngine().handleMicrophonePermissionGranted();
            }
            StoreStream.INSTANCE.getMediaEngine().setAudioInputEnabled(true);
            this.$onSuccess.invoke();
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.d.h$h */
    /* JADX INFO: compiled from: AppPermissions.kt */
    public static final class h extends AbstractC12240o implements Function1<Map<String, ? extends Boolean>, Unit> {
        public final /* synthetic */ Function0 $onFailure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Function0 function0) {
            super(1);
            this.$onFailure = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Map<String, ? extends Boolean> map) {
            C12238m.checkNotNullParameter(map, "it");
            Function0 function0 = this.$onFailure;
            if (function0 == null || ((Unit) function0.invoke()) == null) {
                C0866h.m151a(C0866h.this, C5419R.string.permission_microphone_denied);
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.d.h$i */
    /* JADX INFO: compiled from: AppPermissions.kt */
    public static final class i extends AbstractC12240o implements Function1<Map<String, ? extends Boolean>, Unit> {
        public i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Map<String, ? extends Boolean> map) {
            Map<String, ? extends Boolean> map2 = map;
            C12238m.checkNotNullParameter(map2, "grantResults");
            Boolean bool = map2.get("android.permission.RECORD_AUDIO");
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            if (bool.booleanValue()) {
                Boolean bool2 = map2.get("android.permission.CAMERA");
                if (bool2 == null) {
                    bool2 = Boolean.FALSE;
                }
                if (bool2.booleanValue()) {
                    C0866h.m151a(C0866h.this, C5419R.string.no_camera_access);
                } else {
                    C0866h.m151a(C0866h.this, C5419R.string.no_camera_access);
                }
            } else {
                C0866h.m151a(C0866h.this, C5419R.string.permission_microphone_denied);
            }
            return Unit.f27425a;
        }
    }

    static {
        HashMap<Integer, String[]> map = new HashMap<>();
        f508j = map;
        map.put(211, new String[]{"android.permission.RECORD_AUDIO"});
        map.put(210, new String[]{"android.permission.RECORD_AUDIO", "android.permission.CAMERA"});
        map.put(222, new String[]{"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"});
        map.put(213, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
        map.put(214, new String[]{"android.permission.CAMERA"});
        map.put(215, new String[]{"android.permission.READ_CONTACTS"});
    }

    public C0866h(ComponentActivity componentActivity) {
        C12238m.checkNotNullParameter(componentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.f514p = componentActivity;
        ActivityResultLauncher<String[]> activityResultLauncherRegisterForActivityResult = componentActivity.registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new b());
        C12238m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "activity.registerForActi…rtTimeMillis = 0L\n      }");
        this.f513o = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: renamed from: a */
    public static final void m151a(C0866h c0866h, int i2) {
        C0876m.m169g(c0866h.f514p, i2, 0, null, 12);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0035  */
    /* JADX WARN: Code duplicated, block: B:18:0x003e  */
    /* JADX WARN: Code duplicated, block: B:32:0x003f A[SYNTHETIC] */
    /* JADX INFO: renamed from: b */
    public final boolean m152b(int i2) {
        String[] strArr = f508j.get(Integer.valueOf(i2));
        if (strArr == null) {
            return false;
        }
        C12238m.checkNotNullExpressionValue(strArr, "PERMISSION_GROUPS[requestCode] ?: return false");
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        int i3 = 0;
        while (true) {
            boolean z2 = true;
            if (i3 >= length) {
                break;
            }
            String str = strArr[i3];
            if (C12238m.areEqual(str, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                if (Build.VERSION.SDK_INT < 29) {
                    if (ContextCompat.checkSelfPermission(this.f514p, str) == 0) {
                        z2 = false;
                    }
                }
            } else if (ContextCompat.checkSelfPermission(this.f514p, str) == 0) {
                z2 = false;
            }
            arrayList.add(Boolean.valueOf(z2));
            i3++;
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!((Boolean) it.next()).booleanValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: c */
    public final void m153c(int i2, Function0<Unit> function0, Function1<? super Map<String, Boolean>, Unit> function1) {
        String[] strArr = f508j.get(Integer.valueOf(i2));
        if (strArr != null) {
            C12238m.checkNotNullExpressionValue(strArr, "PERMISSION_GROUPS[requestCode] ?: return");
            if (m152b(i2)) {
                function0.invoke();
                return;
            }
            if (ClockFactory.get().currentTimeMillis() - this.f512n < 350) {
                return;
            }
            this.f510l = function0;
            this.f511m = function1;
            this.f512n = ClockFactory.get().currentTimeMillis();
            this.f513o.launch(strArr);
        }
    }

    @Override // com.discord.app.AppPermissionsRequests
    @MainThread
    public boolean hasMedia() {
        return m152b(222);
    }

    @Override // com.discord.app.AppPermissionsRequests
    @MainThread
    public void requestCameraQRScanner(Function0<Unit> function0, Function0<Unit> function1) {
        C12238m.checkNotNullParameter(function0, "onSuccess");
        m153c(214, function0, new c(function1));
    }

    @Override // com.discord.app.AppPermissionsRequests
    @MainThread
    public void requestContacts(Function0<Unit> function0, Function0<Unit> function1) {
        C12238m.checkNotNullParameter(function0, "onSuccess");
        C12238m.checkNotNullParameter(function1, "onFailure");
        m153c(215, function0, new d(function1));
    }

    @Override // com.discord.app.AppPermissionsRequests
    @MainThread
    public void requestMedia(Function0<Unit> function0) {
        C12238m.checkNotNullParameter(function0, "onSuccess");
        m153c(222, function0, new e());
    }

    @Override // com.discord.app.AppPermissionsRequests
    @MainThread
    public void requestMediaDownload(Function0<Unit> function0) {
        C12238m.checkNotNullParameter(function0, "onSuccess");
        m153c(213, function0, new f());
    }

    @Override // com.discord.app.AppPermissionsRequests
    @MainThread
    public void requestMicrophone(Function0<Unit> function0, Function0<Unit> function1) {
        C12238m.checkNotNullParameter(function1, "onSuccess");
        m153c(211, new g(m152b(211), function1), new h(function0));
    }

    @Override // com.discord.app.AppPermissionsRequests
    @MainThread
    public void requestVideoCallPermissions(Function0<Unit> function0) {
        C12238m.checkNotNullParameter(function0, "onSuccess");
        m153c(210, function0, new i());
    }

    @Override // com.discord.app.AppPermissionsRequests
    @MainThread
    public void requestCameraQRScanner(Function0<Unit> function0) {
        C12238m.checkNotNullParameter(function0, "onSuccess");
        requestCameraQRScanner(function0, null);
    }
}
