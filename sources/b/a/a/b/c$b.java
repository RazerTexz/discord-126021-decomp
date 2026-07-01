package b.a.a.b;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MultiValuePropPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c$b {
    public c$b(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public static void a(c$b c_b, FragmentManager fragmentManager, int i, String str, String str2, String str3, String str4, String str5, String str6, boolean z2, boolean z3, int i2) {
        if ((i2 & 4) != 0) {
            str = null;
        }
        if ((i2 & 8) != 0) {
            str2 = null;
        }
        if ((i2 & 16) != 0) {
            str3 = null;
        }
        if ((i2 & 32) != 0) {
            str4 = null;
        }
        if ((i2 & 64) != 0) {
            str5 = null;
        }
        if ((i2 & 128) != 0) {
            str6 = null;
        }
        if ((i2 & 256) != 0) {
            z2 = true;
        }
        if ((i2 & 512) != 0) {
            z3 = true;
        }
        Objects.requireNonNull(c_b);
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putInt("extra_page_number", i);
        if (str != null) {
            bundle.putString("extra_header_string", str);
        }
        if (str2 != null) {
            bundle.putString("extra_body_text", str2);
        }
        bundle.putString("extra_page_name", str3);
        bundle.putString("extra_section_name", str4);
        bundle.putString("extra_object_name", str5);
        bundle.putString("extra_object_type", str6);
        bundle.putBoolean("extra_show_other_pages", z2);
        bundle.putBoolean("extra_show_learn_more", z3);
        cVar.setArguments(bundle);
        cVar.show(fragmentManager, c.class.getName());
    }
}
