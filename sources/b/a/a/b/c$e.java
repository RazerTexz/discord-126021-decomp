package b.a.a.b;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: MultiValuePropPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c$e extends FragmentStateAdapter {
    public final List<c$c> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c$e(Fragment fragment, List<c$c> list) {
        super(fragment);
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(list, "pages");
        this.a = list;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int i) {
        c$c c_c = this.a.get(i);
        c$d$a c_d_a = c$d.k;
        int i2 = c_c.a;
        CharSequence charSequence = c_c.f45b;
        CharSequence charSequence2 = c_c.c;
        Objects.requireNonNull(c_d_a);
        m.checkNotNullParameter(charSequence, "headerText");
        m.checkNotNullParameter(charSequence2, "bodyText");
        Bundle bundle = new Bundle();
        bundle.putInt("extra_image_id", i2);
        bundle.putString("extra_header_string", charSequence.toString());
        bundle.putString("extra_body_text", charSequence2.toString());
        c$d c_d = new c$d();
        c_d.setArguments(bundle);
        return c_d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.a.size();
    }
}
