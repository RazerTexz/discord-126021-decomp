package b.a.a;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.stores.StoreStream;
import com.discord.utilities.rest.FileUploadAlertType;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ImageUploadFailedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c$b {
    public c$b(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final void a(FragmentManager fragmentManager, boolean z2, int i, float f, float f2, Function0<Unit> function0, int i2, boolean z3, boolean z4, boolean z5) {
        d0.z.d.m.checkNotNullParameter(fragmentManager, "fragmentManager");
        float f3 = 1048576;
        StoreStream.Companion.getAnalytics().trackFileUploadAlertViewed(z2 ? FileUploadAlertType.OVER_MAX_SIZE : FileUploadAlertType.NITRO_UPSELL, i2, (int) (f * f3), (int) (f3 * f2), z3, z4, z2);
        c cVar = new c();
        cVar.onResendCompressed = function0;
        Bundle bundle = new Bundle();
        bundle.putBoolean("PARAM_IS_USER_PREMIUM", z2);
        bundle.putBoolean("PARAM_CAN_COMPRESS", (z4 || z5) ? false : true);
        bundle.putInt("PARAM_MAX_FILE_SIZE_MB", i);
        cVar.setArguments(bundle);
        cVar.show(fragmentManager, ImageUploadDialog.class.getName());
    }
}
