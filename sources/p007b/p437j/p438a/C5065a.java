package p007b.p437j.p438a;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.hcaptcha.sdk.HCaptchaTokenResponse;
import p007b.p437j.p438a.p439f.AbstractC5073d;

/* JADX INFO: renamed from: b.j.a.a */
/* JADX INFO: loaded from: classes3.dex */
public class C5065a extends AbstractC5073d<HCaptchaTokenResponse> {

    /* JADX INFO: renamed from: e */
    public final FragmentManager f13580e;

    public C5065a(@NonNull Activity activity) {
        this.f13580e = ((FragmentActivity) activity).getSupportFragmentManager();
    }
}
