package p007b.p008a.p009a.p012b;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.premium.ShinyButton;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.google.android.material.button.MaterialButton;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.C1025p1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.b.d */
/* JADX INFO: compiled from: SingleValuePropPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0812d extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f279j = {C1643a.m846d0(C0812d.class, "binding", "getBinding()Lcom/discord/databinding/SingleValuePropPremiumUpsellDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: b.a.a.b.d$a */
    /* JADX INFO: compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f282j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Object f283k;

        public a(int i, Object obj) {
            this.f282j = i;
            this.f283k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f282j;
            if (i == 0) {
                ((C0812d) this.f283k).dismiss();
                return;
            }
            if (i != 1) {
                throw null;
            }
            C0812d c0812d = (C0812d) this.f283k;
            KProperty[] kPropertyArr = C0812d.f279j;
            Objects.requireNonNull(c0812d);
            WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
            Context contextRequireContext = c0812d.requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetSettingsPremium.Companion.launch$default(companion, contextRequireContext, null, null, 6, null);
            c0812d.dismiss();
        }
    }

    /* JADX INFO: renamed from: b.a.a.b.d$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SingleValuePropPremiumUpsellDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public final void m117a(FragmentManager fragmentManager, AnalyticsTracker.PremiumUpsellType premiumUpsellType, @DrawableRes int i, String str, String str2, String str3, String str4, String str5) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(premiumUpsellType, "premiumUpsellType");
            C0812d c0812d = new C0812d();
            Bundle bundle = new Bundle();
            bundle.putInt("extra_image_drawable_res", i);
            bundle.putString("extra_header_text", str);
            bundle.putString("extra_body_text", str2);
            c0812d.setArguments(bundle);
            c0812d.show(fragmentManager, C0812d.class.getName());
            AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, premiumUpsellType, null, null, new Traits.Source(str3, str4, str5, null, null, 24, null), 6, null);
        }
    }

    /* JADX INFO: renamed from: b.a.a.b.d$c */
    /* JADX INFO: compiled from: SingleValuePropPremiumUpsellDialog.kt */
    public static final /* synthetic */ class c extends C12236k implements Function1<View, C1025p1> {

        /* JADX INFO: renamed from: j */
        public static final c f284j = new c();

        public c() {
            super(1, C1025p1.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/SingleValuePropPremiumUpsellDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C1025p1 invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.button_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(C5419R.id.button_container);
            if (linearLayout != null) {
                i = C5419R.id.close_button;
                MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.close_button);
                if (materialButton != null) {
                    i = C5419R.id.content_background;
                    View viewFindViewById = view2.findViewById(C5419R.id.content_background);
                    if (viewFindViewById != null) {
                        i = C5419R.id.get_premium_button;
                        ShinyButton shinyButton = (ShinyButton) view2.findViewById(C5419R.id.get_premium_button);
                        if (shinyButton != null) {
                            i = C5419R.id.transparent_space;
                            View viewFindViewById2 = view2.findViewById(C5419R.id.transparent_space);
                            if (viewFindViewById2 != null) {
                                i = C5419R.id.upsell_body_text;
                                TextView textView = (TextView) view2.findViewById(C5419R.id.upsell_body_text);
                                if (textView != null) {
                                    i = C5419R.id.upsell_header_text;
                                    TextView textView2 = (TextView) view2.findViewById(C5419R.id.upsell_header_text);
                                    if (textView2 != null) {
                                        i = C5419R.id.value_prop_image;
                                        ImageView imageView = (ImageView) view2.findViewById(C5419R.id.value_prop_image);
                                        if (imageView != null) {
                                            return new C1025p1((LinearLayout) view2, linearLayout, materialButton, viewFindViewById, shinyButton, viewFindViewById2, textView, textView2, imageView);
                                        }
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

    public C0812d() {
        super(C5419R.layout.single_value_prop_premium_upsell_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c.f284j, null, 2, null);
    }

    /* JADX INFO: renamed from: g */
    public final C1025p1 m116g() {
        return (C1025p1) this.binding.getValue((Fragment) this, f279j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Bundle arguments = getArguments();
        Integer numValueOf = arguments != null ? Integer.valueOf(arguments.getInt("extra_image_drawable_res")) : null;
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("extra_header_text") : null;
        Bundle arguments3 = getArguments();
        String string2 = arguments3 != null ? arguments3.getString("extra_body_text") : null;
        if (numValueOf != null) {
            m116g().f1129f.setImageDrawable(ContextCompat.getDrawable(requireContext(), numValueOf.intValue()));
        }
        if (string != null) {
            TextView textView = m116g().f1128e;
            C12238m.checkNotNullExpressionValue(textView, "binding.upsellHeaderText");
            textView.setText(string);
        }
        if (string2 != null) {
            TextView textView2 = m116g().f1127d;
            C12238m.checkNotNullExpressionValue(textView2, "binding.upsellBodyText");
            textView2.setText(string2);
        }
        m116g().f1125b.setOnClickListener(new a(0, this));
        m116g().f1126c.setOnClickListener(new a(1, this));
    }
}
