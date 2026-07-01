package b.a.d;

import android.os.Build;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.MainThread;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.content.ContextCompat;
import com.discord.R;
import com.discord.app.AppPermissions2;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: b.a.d.h, reason: use source file name */
/* JADX INFO: compiled from: AppPermissions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppPermissions implements AppPermissions2 {

    @Deprecated
    public static final HashMap<Integer, String[]> j;
    public static final a k = new a(null);
    public Function0<Unit> l;
    public Function1<? super Map<String, Boolean>, Unit> m;
    public long n;
    public final ActivityResultLauncher<String[]> o;
    public final ComponentActivity p;

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
                Function1<? super Map<String, Boolean>, Unit> function1 = AppPermissions.this.m;
                if (function1 != null) {
                    Intrinsics3.checkNotNullExpressionValue(map2, "grantResults");
                    function1.invoke(map2);
                }
            } else {
                Function0<Unit> function0 = AppPermissions.this.l;
                if (function0 != null) {
                    function0.invoke();
                }
            }
            AppPermissions appPermissions = AppPermissions.this;
            appPermissions.m = null;
            appPermissions.l = null;
            appPermissions.n = 0L;
        }
    }

    /* JADX INFO: renamed from: b.a.d.h$c */
    /* JADX INFO: compiled from: AppPermissions.kt */
    public static final class c extends Lambda implements Function1<Map<String, ? extends Boolean>, Unit> {
        public final /* synthetic */ Function0 $onFailure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Function0 function0) {
            super(1);
            this.$onFailure = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Map<String, ? extends Boolean> map) {
            Intrinsics3.checkNotNullParameter(map, "it");
            Function0 function0 = this.$onFailure;
            if (function0 == null || ((Unit) function0.invoke()) == null) {
                AppPermissions.a(AppPermissions.this, R.string.permission_qr_scanner_denied);
            }
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.d.h$d */
    /* JADX INFO: compiled from: AppPermissions.kt */
    public static final class d extends Lambda implements Function1<Map<String, ? extends Boolean>, Unit> {
        public final /* synthetic */ Function0 $onFailure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Function0 function0) {
            super(1);
            this.$onFailure = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Map<String, ? extends Boolean> map) {
            Intrinsics3.checkNotNullParameter(map, "it");
            this.$onFailure.invoke();
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.d.h$e */
    /* JADX INFO: compiled from: AppPermissions.kt */
    public static final class e extends Lambda implements Function1<Map<String, ? extends Boolean>, Unit> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Map<String, ? extends Boolean> map) {
            Intrinsics3.checkNotNullParameter(map, "it");
            AppPermissions.a(AppPermissions.this, R.string.permission_media_denied);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.d.h$f */
    /* JADX INFO: compiled from: AppPermissions.kt */
    public static final class f extends Lambda implements Function1<Map<String, ? extends Boolean>, Unit> {
        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Map<String, ? extends Boolean> map) {
            Intrinsics3.checkNotNullParameter(map, "it");
            AppPermissions.a(AppPermissions.this, R.string.permission_media_download_denied);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.d.h$g */
    /* JADX INFO: compiled from: AppPermissions.kt */
    public static final class g extends Lambda implements Function0<Unit> {
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
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.d.h$h */
    /* JADX INFO: compiled from: AppPermissions.kt */
    public static final class h extends Lambda implements Function1<Map<String, ? extends Boolean>, Unit> {
        public final /* synthetic */ Function0 $onFailure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Function0 function0) {
            super(1);
            this.$onFailure = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Map<String, ? extends Boolean> map) {
            Intrinsics3.checkNotNullParameter(map, "it");
            Function0 function0 = this.$onFailure;
            if (function0 == null || ((Unit) function0.invoke()) == null) {
                AppPermissions.a(AppPermissions.this, R.string.permission_microphone_denied);
            }
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.d.h$i */
    /* JADX INFO: compiled from: AppPermissions.kt */
    public static final class i extends Lambda implements Function1<Map<String, ? extends Boolean>, Unit> {
        public i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Map<String, ? extends Boolean> map) {
            Map<String, ? extends Boolean> map2 = map;
            Intrinsics3.checkNotNullParameter(map2, "grantResults");
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
                    AppPermissions.a(AppPermissions.this, R.string.no_camera_access);
                } else {
                    AppPermissions.a(AppPermissions.this, R.string.no_camera_access);
                }
            } else {
                AppPermissions.a(AppPermissions.this, R.string.permission_microphone_denied);
            }
            return Unit.a;
        }
    }

    static {
        HashMap<Integer, String[]> map = new HashMap<>();
        j = map;
        map.put(211, new String[]{"android.permission.RECORD_AUDIO"});
        map.put(210, new String[]{"android.permission.RECORD_AUDIO", "android.permission.CAMERA"});
        map.put(222, new String[]{"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"});
        map.put(213, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
        map.put(214, new String[]{"android.permission.CAMERA"});
        map.put(215, new String[]{"android.permission.READ_CONTACTS"});
    }

    public AppPermissions(ComponentActivity componentActivity) {
        Intrinsics3.checkNotNullParameter(componentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.p = componentActivity;
        ActivityResultLauncher<String[]> activityResultLauncherRegisterForActivityResult = componentActivity.registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new b());
        Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "activity.registerForActi…rtTimeMillis = 0L\n      }");
        this.o = activityResultLauncherRegisterForActivityResult;
    }

    public static final void a(AppPermissions appPermissions, int i2) {
        AppToast.g(appPermissions.p, i2, 0, null, 12);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0035  */
    /* JADX WARN: Code duplicated, block: B:18:0x003e  */
    /* JADX WARN: Code duplicated, block: B:32:0x003f A[SYNTHETIC] */
    public final boolean b(int i2) {
        String[] strArr = j.get(Integer.valueOf(i2));
        if (strArr == null) {
            return false;
        }
        Intrinsics3.checkNotNullExpressionValue(strArr, "PERMISSION_GROUPS[requestCode] ?: return false");
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        int i3 = 0;
        while (true) {
            boolean z2 = true;
            if (i3 >= length) {
                break;
            }
            String str = strArr[i3];
            if (Intrinsics3.areEqual(str, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                if (Build.VERSION.SDK_INT < 29) {
                    if (ContextCompat.checkSelfPermission(this.p, str) == 0) {
                        z2 = false;
                    }
                }
            } else if (ContextCompat.checkSelfPermission(this.p, str) == 0) {
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

    public final void c(int i2, Function0<Unit> function0, Function1<? super Map<String, Boolean>, Unit> function1) {
        String[] strArr = j.get(Integer.valueOf(i2));
        if (strArr != null) {
            Intrinsics3.checkNotNullExpressionValue(strArr, "PERMISSION_GROUPS[requestCode] ?: return");
            if (b(i2)) {
                function0.invoke();
                return;
            }
            if (ClockFactory.get().currentTimeMillis() - this.n < 350) {
                return;
            }
            this.l = function0;
            this.m = function1;
            this.n = ClockFactory.get().currentTimeMillis();
            this.o.launch(strArr);
        }
    }

    @Override // com.discord.app.AppPermissions2
    @MainThread
    public boolean hasMedia() {
        return b(222);
    }

    @Override // com.discord.app.AppPermissions2
    @MainThread
    public void requestCameraQRScanner(Function0<Unit> function0, Function0<Unit> function1) {
        Intrinsics3.checkNotNullParameter(function0, "onSuccess");
        c(214, function0, new c(function1));
    }

    @Override // com.discord.app.AppPermissions2
    @MainThread
    public void requestContacts(Function0<Unit> function0, Function0<Unit> function1) {
        Intrinsics3.checkNotNullParameter(function0, "onSuccess");
        Intrinsics3.checkNotNullParameter(function1, "onFailure");
        c(215, function0, new d(function1));
    }

    @Override // com.discord.app.AppPermissions2
    @MainThread
    public void requestMedia(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "onSuccess");
        c(222, function0, new e());
    }

    @Override // com.discord.app.AppPermissions2
    @MainThread
    public void requestMediaDownload(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "onSuccess");
        c(213, function0, new f());
    }

    @Override // com.discord.app.AppPermissions2
    @MainThread
    public void requestMicrophone(Function0<Unit> function0, Function0<Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "onSuccess");
        c(211, new g(b(211), function1), new h(function0));
    }

    @Override // com.discord.app.AppPermissions2
    @MainThread
    public void requestVideoCallPermissions(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "onSuccess");
        c(210, function0, new i());
    }

    @Override // com.discord.app.AppPermissions2
    @MainThread
    public void requestCameraQRScanner(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "onSuccess");
        requestCameraQRScanner(function0, null);
    }
}
