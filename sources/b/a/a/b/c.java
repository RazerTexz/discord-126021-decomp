package b.a.a.b;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import b.a.i.w0;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.view.recycler.ViewPager2ExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.discord.widgets.settings.premium.WidgetSettingsPremium$Companion;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: MultiValuePropPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(c.class, "binding", "getBinding()Lcom/discord/databinding/MultiValuePropPremiumUpsellDialogBinding;", 0)};
    public static final c$b k = new c$b(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public c$e pagerAdapter;

    public c() {
        super(R$layout.multi_value_prop_premium_upsell_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c$f.j, null, 2, null);
    }

    public static final void g(c cVar) {
        Bundle arguments = cVar.getArguments();
        String string = arguments != null ? arguments.getString("extra_page_name") : null;
        Bundle arguments2 = cVar.getArguments();
        String string2 = arguments2 != null ? arguments2.getString("extra_section_name") : null;
        Bundle arguments3 = cVar.getArguments();
        String string3 = arguments3 != null ? arguments3.getString("extra_object_name") : null;
        Bundle arguments4 = cVar.getArguments();
        AnalyticsTracker.INSTANCE.premiumSettingsOpened(new Traits$Location(string, string2, string3, arguments4 != null ? arguments4.getString("extra_object_type") : null, null, 16, null));
        WidgetSettingsPremium$Companion widgetSettingsPremium$Companion = WidgetSettingsPremium.Companion;
        Context contextRequireContext = cVar.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        WidgetSettingsPremium$Companion.launch$default(widgetSettingsPremium$Companion, contextRequireContext, null, null, 6, null);
        cVar.dismiss();
    }

    public final w0 h() {
        return (w0) this.binding.getValue((Fragment) this, j[0]);
    }

    public final boolean i() {
        Bundle arguments = getArguments();
        return arguments != null && arguments.getBoolean("extra_show_learn_more");
    }

    public final boolean j() {
        Bundle arguments = getArguments();
        return arguments != null && arguments.getBoolean("extra_show_other_pages");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String string;
        String string2;
        super.onCreate(savedInstanceState);
        AppDialog.hideKeyboard$default(this, null, 1, null);
        String string3 = getString(2131894517);
        m.checkNotNullExpressionValue(string3, "getString(R.string.premi…psell_tag_passive_mobile)");
        String string4 = getString(2131894516);
        m.checkNotNullExpressionValue(string4, "getString(R.string.premi…l_tag_description_mobile)");
        String string5 = getString(2131894502);
        m.checkNotNullExpressionValue(string5, "getString(R.string.premi…ell_emoji_passive_mobile)");
        String string6 = getString(2131894499);
        m.checkNotNullExpressionValue(string6, "getString(R.string.premi…emoji_description_mobile)");
        String string7 = getString(2131894492);
        m.checkNotNullExpressionValue(string7, "getString(R.string.premi…ed_emojis_passive_mobile)");
        String string8 = getString(2131894491);
        m.checkNotNullExpressionValue(string8, "getString(R.string.premi…mojis_description_mobile)");
        CharSequence charSequenceK = b.a.k.b.k(this, 2131894521, new Object[0], null, 4);
        Object[] objArr = {b.a.k.b.k(this, 2131889029, new Object[0], null, 4), b.a.k.b.k(this, 2131889028, new Object[0], null, 4)};
        String string9 = getString(2131894487);
        m.checkNotNullExpressionValue(string9, "getString(R.string.premi…ed_avatar_passive_mobile)");
        String string10 = getString(2131894486);
        m.checkNotNullExpressionValue(string10, "getString(R.string.premi…vatar_description_mobile)");
        String string11 = getString(2131894495);
        m.checkNotNullExpressionValue(string11, "getString(R.string.premi…ell_badge_passive_mobile)");
        String string12 = getString(2131894494);
        m.checkNotNullExpressionValue(string12, "getString(R.string.premi…badge_description_mobile)");
        List listListOf = n.listOf((Object[]) new c$c[]{new c$c(2131232449, string3, string4), new c$c(2131232368, string5, string6), new c$c(2131232317, string7, string8), new c$c(2131232451, charSequenceK, b.a.k.b.k(this, 2131894520, objArr, null, 4)), new c$c(2131232320, string9, string10), new c$c(2131232323, string11, string12)});
        Bundle arguments = getArguments();
        int i = arguments != null ? arguments.getInt("extra_page_number") : 0;
        Bundle arguments2 = getArguments();
        String str = "";
        if (arguments2 != null && arguments2.containsKey("extra_header_string")) {
            c$c c_c = (c$c) listListOf.get(i);
            Bundle arguments3 = getArguments();
            if (arguments3 == null || (string2 = arguments3.getString("extra_header_string")) == null) {
                string2 = "";
            }
            Objects.requireNonNull(c_c);
            m.checkNotNullParameter(string2, "<set-?>");
            c_c.f45b = string2;
        }
        Bundle arguments4 = getArguments();
        if (arguments4 != null && arguments4.containsKey("extra_body_text")) {
            c$c c_c2 = (c$c) listListOf.get(i);
            Bundle arguments5 = getArguments();
            if (arguments5 != null && (string = arguments5.getString("extra_body_text")) != null) {
                str = string;
            }
            Objects.requireNonNull(c_c2);
            m.checkNotNullParameter(str, "<set-?>");
            c_c2.c = str;
        }
        c$c c_c3 = (c$c) listListOf.get(i);
        List listMutableListOf = n.mutableListOf(c_c3);
        if (j()) {
            listMutableListOf.addAll(u.minus(listListOf, c_c3));
        }
        this.pagerAdapter = new c$e(this, listMutableListOf);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ViewPager2 viewPager2 = h().f;
        m.checkNotNullExpressionValue(viewPager2, "binding.premiumUpsellViewpager");
        c$e c_e = this.pagerAdapter;
        if (c_e == null) {
            m.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        viewPager2.setAdapter(c_e);
        TabLayout tabLayout = h().c;
        m.checkNotNullExpressionValue(tabLayout, "binding.premiumUpsellDots");
        tabLayout.setVisibility(j() ? 0 : 8);
        TabLayout tabLayout2 = h().c;
        m.checkNotNullExpressionValue(tabLayout2, "binding.premiumUpsellDots");
        ViewPager2 viewPager3 = h().f;
        m.checkNotNullExpressionValue(viewPager3, "binding.premiumUpsellViewpager");
        ViewPager2ExtensionsKt.setUpWithViewPager2$default(tabLayout2, viewPager3, null, 2, null);
        h().f221b.setOnClickListener(new c$a(0, this));
        MaterialButton materialButton = h().e;
        m.checkNotNullExpressionValue(materialButton, "binding.premiumUpsellLearnMore");
        materialButton.setVisibility(i() ? 0 : 8);
        h().e.setOnClickListener(new c$a(1, this));
        MaterialButton materialButton2 = h().d;
        m.checkNotNullExpressionValue(materialButton2, "binding.premiumUpsellGetPremium");
        materialButton2.setVisibility(i() ^ true ? 0 : 8);
        h().d.setOnClickListener(new c$a(2, this));
    }
}
