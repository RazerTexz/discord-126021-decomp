package p007b.p008a.p009a.p012b;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.app.AppFragment;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.view.recycler.ViewPager2ExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.C1064u5;
import p007b.p008a.p025i.C1073w0;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.b.c */
/* JADX INFO: compiled from: MultiValuePropPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0811c extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f264j = {C1643a.m846d0(C0811c.class, "binding", "getBinding()Lcom/discord/databinding/MultiValuePropPremiumUpsellDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public e pagerAdapter;

    /* JADX INFO: renamed from: b.a.a.b.c$a */
    /* JADX INFO: compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f268j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Object f269k;

        public a(int i, Object obj) {
            this.f268j = i;
            this.f269k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f268j;
            if (i == 0) {
                ((C0811c) this.f269k).dismiss();
            } else if (i == 1) {
                C0811c.m110g((C0811c) this.f269k);
            } else {
                if (i != 2) {
                    throw null;
                }
                C0811c.m110g((C0811c) this.f269k);
            }
        }
    }

    /* JADX INFO: renamed from: b.a.a.b.c$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MultiValuePropPremiumUpsellDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public static void m114a(Companion companion, FragmentManager fragmentManager, int i, String str, String str2, String str3, String str4, String str5, String str6, boolean z2, boolean z3, int i2) {
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
            Objects.requireNonNull(companion);
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C0811c c0811c = new C0811c();
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
            c0811c.setArguments(bundle);
            c0811c.show(fragmentManager, C0811c.class.getName());
        }
    }

    /* JADX INFO: renamed from: b.a.a.b.c$c */
    /* JADX INFO: compiled from: MultiValuePropPremiumUpsellDialog.kt */
    public static final class c {

        /* JADX INFO: renamed from: a */
        public final int f270a;

        /* JADX INFO: renamed from: b */
        public CharSequence f271b;

        /* JADX INFO: renamed from: c */
        public CharSequence f272c;

        public c(@DrawableRes int i, CharSequence charSequence, CharSequence charSequence2) {
            C12238m.checkNotNullParameter(charSequence, "headerText");
            C12238m.checkNotNullParameter(charSequence2, "bodyText");
            this.f270a = i;
            this.f271b = charSequence;
            this.f272c = charSequence2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f270a == cVar.f270a && C12238m.areEqual(this.f271b, cVar.f271b) && C12238m.areEqual(this.f272c, cVar.f272c);
        }

        public int hashCode() {
            int i = this.f270a * 31;
            CharSequence charSequence = this.f271b;
            int iHashCode = (i + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
            CharSequence charSequence2 = this.f272c;
            return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("UpsellData(imageResId=");
            sbM833U.append(this.f270a);
            sbM833U.append(", headerText=");
            sbM833U.append(this.f271b);
            sbM833U.append(", bodyText=");
            return C1643a.m817E(sbM833U, this.f272c, ")");
        }
    }

    /* JADX INFO: renamed from: b.a.a.b.c$d */
    /* JADX INFO: compiled from: MultiValuePropPremiumUpsellDialog.kt */
    public static final class d extends AppFragment {

        /* JADX INFO: renamed from: j */
        public static final /* synthetic */ KProperty[] f273j = {C1643a.m846d0(d.class, "binding", "getBinding()Lcom/discord/databinding/WidgetPremiumUpsellBinding;", 0)};

        /* JADX INFO: renamed from: k, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: renamed from: l, reason: from kotlin metadata */
        public final FragmentViewBindingDelegate binding;

        /* JADX INFO: renamed from: b.a.a.b.c$d$a, reason: from kotlin metadata */
        /* JADX INFO: compiled from: MultiValuePropPremiumUpsellDialog.kt */
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX INFO: renamed from: b.a.a.b.c$d$b */
        /* JADX INFO: compiled from: MultiValuePropPremiumUpsellDialog.kt */
        public static final /* synthetic */ class b extends C12236k implements Function1<View, C1064u5> {

            /* JADX INFO: renamed from: j */
            public static final b f276j = new b();

            public b() {
                super(1, C1064u5.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetPremiumUpsellBinding;", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public C1064u5 invoke(View view) {
                View view2 = view;
                C12238m.checkNotNullParameter(view2, "p1");
                int i = C5419R.id.premium_upsell_body;
                TextView textView = (TextView) view2.findViewById(C5419R.id.premium_upsell_body);
                if (textView != null) {
                    i = C5419R.id.premium_upsell_header;
                    TextView textView2 = (TextView) view2.findViewById(C5419R.id.premium_upsell_header);
                    if (textView2 != null) {
                        i = C5419R.id.premium_upsell_img;
                        ImageView imageView = (ImageView) view2.findViewById(C5419R.id.premium_upsell_img);
                        if (imageView != null) {
                            return new C1064u5((LinearLayout) view2, textView, textView2, imageView);
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
            }
        }

        public d() {
            super(C5419R.layout.widget_premium_upsell);
            this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b.f276j, null, 2, null);
        }

        /* JADX INFO: renamed from: g */
        public final C1064u5 m115g() {
            return (C1064u5) this.binding.getValue((Fragment) this, f273j[0]);
        }

        @Override // com.discord.app.AppFragment
        public void onViewBoundOrOnResume() {
            String string;
            super.onViewBoundOrOnResume();
            ImageView imageView = m115g().f1299d;
            Bundle arguments = getArguments();
            imageView.setImageResource(arguments != null ? arguments.getInt("extra_image_id") : 0);
            TextView textView = m115g().f1298c;
            C12238m.checkNotNullExpressionValue(textView, "binding.premiumUpsellHeader");
            Bundle arguments2 = getArguments();
            textView.setText(arguments2 != null ? arguments2.getString("extra_header_string") : null);
            TextView textView2 = m115g().f1297b;
            C12238m.checkNotNullExpressionValue(textView2, "binding.premiumUpsellBody");
            Bundle arguments3 = getArguments();
            textView2.setText((arguments3 == null || (string = arguments3.getString("extra_body_text")) == null) ? "" : C1107b.m215g(string, new Object[0], (2 & 2) != 0 ? C1107b.e.f1494j : null));
        }
    }

    /* JADX INFO: renamed from: b.a.a.b.c$e */
    /* JADX INFO: compiled from: MultiValuePropPremiumUpsellDialog.kt */
    public static final class e extends FragmentStateAdapter {

        /* JADX INFO: renamed from: a */
        public final List<c> f277a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment, List<c> list) {
            super(fragment);
            C12238m.checkNotNullParameter(fragment, "fragment");
            C12238m.checkNotNullParameter(list, "pages");
            this.f277a = list;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i) {
            c cVar = this.f277a.get(i);
            d.Companion companion = d.INSTANCE;
            int i2 = cVar.f270a;
            CharSequence charSequence = cVar.f271b;
            CharSequence charSequence2 = cVar.f272c;
            Objects.requireNonNull(companion);
            C12238m.checkNotNullParameter(charSequence, "headerText");
            C12238m.checkNotNullParameter(charSequence2, "bodyText");
            Bundle bundle = new Bundle();
            bundle.putInt("extra_image_id", i2);
            bundle.putString("extra_header_string", charSequence.toString());
            bundle.putString("extra_body_text", charSequence2.toString());
            d dVar = new d();
            dVar.setArguments(bundle);
            return dVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: getItemCount */
        public int getPageSize() {
            return this.f277a.size();
        }
    }

    /* JADX INFO: renamed from: b.a.a.b.c$f */
    /* JADX INFO: compiled from: MultiValuePropPremiumUpsellDialog.kt */
    public static final /* synthetic */ class f extends C12236k implements Function1<View, C1073w0> {

        /* JADX INFO: renamed from: j */
        public static final f f278j = new f();

        public f() {
            super(1, C1073w0.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/MultiValuePropPremiumUpsellDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C1073w0 invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.premium_upsell_button_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(C5419R.id.premium_upsell_button_container);
            if (linearLayout != null) {
                i = C5419R.id.premium_upsell_close;
                MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.premium_upsell_close);
                if (materialButton != null) {
                    i = C5419R.id.premium_upsell_divider;
                    View viewFindViewById = view2.findViewById(C5419R.id.premium_upsell_divider);
                    if (viewFindViewById != null) {
                        i = C5419R.id.premium_upsell_dots;
                        TabLayout tabLayout = (TabLayout) view2.findViewById(C5419R.id.premium_upsell_dots);
                        if (tabLayout != null) {
                            i = C5419R.id.premium_upsell_get_premium;
                            MaterialButton materialButton2 = (MaterialButton) view2.findViewById(C5419R.id.premium_upsell_get_premium);
                            if (materialButton2 != null) {
                                i = C5419R.id.premium_upsell_learn_more;
                                MaterialButton materialButton3 = (MaterialButton) view2.findViewById(C5419R.id.premium_upsell_learn_more);
                                if (materialButton3 != null) {
                                    i = C5419R.id.premium_upsell_viewpager;
                                    ViewPager2 viewPager2 = (ViewPager2) view2.findViewById(C5419R.id.premium_upsell_viewpager);
                                    if (viewPager2 != null) {
                                        return new C1073w0((RelativeLayout) view2, linearLayout, materialButton, viewFindViewById, tabLayout, materialButton2, materialButton3, viewPager2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    public C0811c() {
        super(C5419R.layout.multi_value_prop_premium_upsell_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, f.f278j, null, 2, null);
    }

    /* JADX INFO: renamed from: g */
    public static final void m110g(C0811c c0811c) {
        Bundle arguments = c0811c.getArguments();
        String string = arguments != null ? arguments.getString("extra_page_name") : null;
        Bundle arguments2 = c0811c.getArguments();
        String string2 = arguments2 != null ? arguments2.getString("extra_section_name") : null;
        Bundle arguments3 = c0811c.getArguments();
        String string3 = arguments3 != null ? arguments3.getString("extra_object_name") : null;
        Bundle arguments4 = c0811c.getArguments();
        AnalyticsTracker.INSTANCE.premiumSettingsOpened(new Traits.Location(string, string2, string3, arguments4 != null ? arguments4.getString("extra_object_type") : null, null, 16, null));
        WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
        Context contextRequireContext = c0811c.requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        WidgetSettingsPremium.Companion.launch$default(companion, contextRequireContext, null, null, 6, null);
        c0811c.dismiss();
    }

    /* JADX INFO: renamed from: h */
    public final C1073w0 m111h() {
        return (C1073w0) this.binding.getValue((Fragment) this, f264j[0]);
    }

    /* JADX INFO: renamed from: i */
    public final boolean m112i() {
        Bundle arguments = getArguments();
        return arguments != null && arguments.getBoolean("extra_show_learn_more");
    }

    /* JADX INFO: renamed from: j */
    public final boolean m113j() {
        Bundle arguments = getArguments();
        return arguments != null && arguments.getBoolean("extra_show_other_pages");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String string;
        String string2;
        super.onCreate(savedInstanceState);
        AppDialog.hideKeyboard$default(this, null, 1, null);
        String string3 = getString(C5419R.string.premium_upsell_tag_passive_mobile);
        C12238m.checkNotNullExpressionValue(string3, "getString(R.string.premi…psell_tag_passive_mobile)");
        String string4 = getString(C5419R.string.premium_upsell_tag_description_mobile);
        C12238m.checkNotNullExpressionValue(string4, "getString(R.string.premi…l_tag_description_mobile)");
        String string5 = getString(C5419R.string.premium_upsell_emoji_passive_mobile);
        C12238m.checkNotNullExpressionValue(string5, "getString(R.string.premi…ell_emoji_passive_mobile)");
        String string6 = getString(C5419R.string.premium_upsell_emoji_description_mobile);
        C12238m.checkNotNullExpressionValue(string6, "getString(R.string.premi…emoji_description_mobile)");
        String string7 = getString(C5419R.string.premium_upsell_animated_emojis_passive_mobile);
        C12238m.checkNotNullExpressionValue(string7, "getString(R.string.premi…ed_emojis_passive_mobile)");
        String string8 = getString(C5419R.string.premium_upsell_animated_emojis_description_mobile);
        C12238m.checkNotNullExpressionValue(string8, "getString(R.string.premi…mojis_description_mobile)");
        CharSequence charSequenceM213e = C1107b.m213e(this, C5419R.string.premium_upsell_upload_passive_mobile, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null);
        Object[] objArr = {C1107b.m213e(this, C5419R.string.file_upload_limit_standard, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), C1107b.m213e(this, C5419R.string.file_upload_limit_premium_tier_2, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null)};
        String string9 = getString(C5419R.string.premium_upsell_animated_avatar_passive_mobile);
        C12238m.checkNotNullExpressionValue(string9, "getString(R.string.premi…ed_avatar_passive_mobile)");
        String string10 = getString(C5419R.string.premium_upsell_animated_avatar_description_mobile);
        C12238m.checkNotNullExpressionValue(string10, "getString(R.string.premi…vatar_description_mobile)");
        String string11 = getString(C5419R.string.premium_upsell_badge_passive_mobile);
        C12238m.checkNotNullExpressionValue(string11, "getString(R.string.premi…ell_badge_passive_mobile)");
        String string12 = getString(C5419R.string.premium_upsell_badge_description_mobile);
        C12238m.checkNotNullExpressionValue(string12, "getString(R.string.premi…badge_description_mobile)");
        List listListOf = C12147n.listOf((Object[]) new c[]{new c(C5419R.drawable.img_tag_upsell, string3, string4), new c(C5419R.drawable.img_global_emoji_upsell, string5, string6), new c(C5419R.drawable.img_animated_emoji_upsell, string7, string8), new c(C5419R.drawable.img_upload_upsell, charSequenceM213e, C1107b.m213e(this, C5419R.string.premium_upsell_upload_description_mobile, objArr, (4 & 4) != 0 ? C1107b.a.f1490j : null)), new c(C5419R.drawable.img_avatar_upsell, string9, string10), new c(C5419R.drawable.img_badge_upsell, string11, string12)});
        Bundle arguments = getArguments();
        int i = arguments != null ? arguments.getInt("extra_page_number") : 0;
        Bundle arguments2 = getArguments();
        String str = "";
        if (arguments2 != null && arguments2.containsKey("extra_header_string")) {
            c cVar = (c) listListOf.get(i);
            Bundle arguments3 = getArguments();
            if (arguments3 == null || (string2 = arguments3.getString("extra_header_string")) == null) {
                string2 = "";
            }
            Objects.requireNonNull(cVar);
            C12238m.checkNotNullParameter(string2, "<set-?>");
            cVar.f271b = string2;
        }
        Bundle arguments4 = getArguments();
        if (arguments4 != null && arguments4.containsKey("extra_body_text")) {
            c cVar2 = (c) listListOf.get(i);
            Bundle arguments5 = getArguments();
            if (arguments5 != null && (string = arguments5.getString("extra_body_text")) != null) {
                str = string;
            }
            Objects.requireNonNull(cVar2);
            C12238m.checkNotNullParameter(str, "<set-?>");
            cVar2.f272c = str;
        }
        c cVar3 = (c) listListOf.get(i);
        List listMutableListOf = C12147n.mutableListOf(cVar3);
        if (m113j()) {
            listMutableListOf.addAll(C12163u.minus(listListOf, cVar3));
        }
        this.pagerAdapter = new e(this, listMutableListOf);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ViewPager2 viewPager2 = m111h().f1337f;
        C12238m.checkNotNullExpressionValue(viewPager2, "binding.premiumUpsellViewpager");
        e eVar = this.pagerAdapter;
        if (eVar == null) {
            C12238m.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        viewPager2.setAdapter(eVar);
        TabLayout tabLayout = m111h().f1334c;
        C12238m.checkNotNullExpressionValue(tabLayout, "binding.premiumUpsellDots");
        tabLayout.setVisibility(m113j() ? 0 : 8);
        TabLayout tabLayout2 = m111h().f1334c;
        C12238m.checkNotNullExpressionValue(tabLayout2, "binding.premiumUpsellDots");
        ViewPager2 viewPager3 = m111h().f1337f;
        C12238m.checkNotNullExpressionValue(viewPager3, "binding.premiumUpsellViewpager");
        ViewPager2ExtensionsKt.setUpWithViewPager2$default(tabLayout2, viewPager3, null, 2, null);
        m111h().f1333b.setOnClickListener(new a(0, this));
        MaterialButton materialButton = m111h().f1336e;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.premiumUpsellLearnMore");
        materialButton.setVisibility(m112i() ? 0 : 8);
        m111h().f1336e.setOnClickListener(new a(1, this));
        MaterialButton materialButton2 = m111h().f1335d;
        C12238m.checkNotNullExpressionValue(materialButton2, "binding.premiumUpsellGetPremium");
        materialButton2.setVisibility(m112i() ^ true ? 0 : 8);
        m111h().f1335d.setOnClickListener(new a(2, this));
    }
}
