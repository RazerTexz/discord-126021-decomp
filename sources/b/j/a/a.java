package b.j.a;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.hcaptcha.sdk.HCaptchaTokenResponse;

/* JADX INFO: loaded from: classes3.dex */
public class a extends b.j.a.f.d<HCaptchaTokenResponse> {
    public final FragmentManager e;

    public a(@NonNull Activity activity) {
        this.e = ((FragmentActivity) activity).getSupportFragmentManager();
    }
}
