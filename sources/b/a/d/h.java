package b.a.d;

import android.os.Build$VERSION;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import androidx.annotation.MainThread;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.content.ContextCompat;
import com.discord.app.AppPermissionsRequests;
import com.discord.utilities.time.ClockFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AppPermissions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h implements AppPermissionsRequests {

    @Deprecated
    public static final HashMap<Integer, String[]> j;
    public static final h$a k = new h$a(null);
    public Function0<Unit> l;
    public Function1<? super Map<String, Boolean>, Unit> m;
    public long n;
    public final ActivityResultLauncher<String[]> o;
    public final ComponentActivity p;

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

    public h(ComponentActivity componentActivity) {
        d0.z.d.m.checkNotNullParameter(componentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.p = componentActivity;
        ActivityResultLauncher<String[]> activityResultLauncherRegisterForActivityResult = componentActivity.registerForActivityResult(new ActivityResultContracts$RequestMultiplePermissions(), new h$b(this));
        d0.z.d.m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "activity.registerForActi…rtTimeMillis = 0L\n      }");
        this.o = activityResultLauncherRegisterForActivityResult;
    }

    public static final void a(h hVar, int i) {
        m.g(hVar.p, i, 0, null, 12);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0035  */
    /* JADX WARN: Code duplicated, block: B:18:0x003e  */
    /* JADX WARN: Code duplicated, block: B:32:0x003f A[SYNTHETIC] */
    public final boolean b(int i) {
        String[] strArr = j.get(Integer.valueOf(i));
        if (strArr == null) {
            return false;
        }
        d0.z.d.m.checkNotNullExpressionValue(strArr, "PERMISSION_GROUPS[requestCode] ?: return false");
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= length) {
                break;
            }
            String str = strArr[i2];
            if (d0.z.d.m.areEqual(str, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                if (Build$VERSION.SDK_INT < 29) {
                    if (ContextCompat.checkSelfPermission(this.p, str) == 0) {
                        z2 = false;
                    }
                }
            } else if (ContextCompat.checkSelfPermission(this.p, str) == 0) {
                z2 = false;
            }
            arrayList.add(Boolean.valueOf(z2));
            i2++;
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

    public final void c(int i, Function0<Unit> function0, Function1<? super Map<String, Boolean>, Unit> function1) {
        String[] strArr = j.get(Integer.valueOf(i));
        if (strArr != null) {
            d0.z.d.m.checkNotNullExpressionValue(strArr, "PERMISSION_GROUPS[requestCode] ?: return");
            if (b(i)) {
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

    @Override // com.discord.app.AppPermissionsRequests
    @MainThread
    public boolean hasMedia() {
        return b(222);
    }

    @Override // com.discord.app.AppPermissionsRequests
    @MainThread
    public void requestCameraQRScanner(Function0<Unit> function0, Function0<Unit> function1) {
        d0.z.d.m.checkNotNullParameter(function0, "onSuccess");
        c(214, function0, new h$c(this, function1));
    }

    @Override // com.discord.app.AppPermissionsRequests
    @MainThread
    public void requestContacts(Function0<Unit> function0, Function0<Unit> function1) {
        d0.z.d.m.checkNotNullParameter(function0, "onSuccess");
        d0.z.d.m.checkNotNullParameter(function1, "onFailure");
        c(215, function0, new h$d(function1));
    }

    @Override // com.discord.app.AppPermissionsRequests
    @MainThread
    public void requestMedia(Function0<Unit> function0) {
        d0.z.d.m.checkNotNullParameter(function0, "onSuccess");
        c(222, function0, new h$e(this));
    }

    @Override // com.discord.app.AppPermissionsRequests
    @MainThread
    public void requestMediaDownload(Function0<Unit> function0) {
        d0.z.d.m.checkNotNullParameter(function0, "onSuccess");
        c(213, function0, new h$f(this));
    }

    @Override // com.discord.app.AppPermissionsRequests
    @MainThread
    public void requestMicrophone(Function0<Unit> function0, Function0<Unit> function1) {
        d0.z.d.m.checkNotNullParameter(function1, "onSuccess");
        c(211, new h$g(b(211), function1), new h$h(this, function0));
    }

    @Override // com.discord.app.AppPermissionsRequests
    @MainThread
    public void requestVideoCallPermissions(Function0<Unit> function0) {
        d0.z.d.m.checkNotNullParameter(function0, "onSuccess");
        c(210, function0, new h$i(this));
    }

    @Override // com.discord.app.AppPermissionsRequests
    @MainThread
    public void requestCameraQRScanner(Function0<Unit> function0) {
        d0.z.d.m.checkNotNullParameter(function0, "onSuccess");
        requestCameraQRScanner(function0, null);
    }
}
