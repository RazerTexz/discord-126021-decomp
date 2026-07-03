package p007b.p008a.p009a.p012b;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.servers.guildboost.WidgetGuildBoost;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.C1072w;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.b.e */
/* JADX INFO: compiled from: GuildBoostUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0813e extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f285j = {C1643a.m846d0(C0813e.class, "binding", "getBinding()Lcom/discord/databinding/GuildBoostUpsellDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: b.a.a.b.e$a */
    /* JADX INFO: compiled from: java-style lambda group */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f288j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ long f289k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ Object f290l;

        /* JADX INFO: renamed from: m */
        public final /* synthetic */ Object f291m;

        /* JADX INFO: renamed from: n */
        public final /* synthetic */ Object f292n;

        /* JADX INFO: renamed from: o */
        public final /* synthetic */ Object f293o;

        public a(int i, long j, Object obj, Object obj2, Object obj3, Object obj4) {
            this.f288j = i;
            this.f289k = j;
            this.f290l = obj;
            this.f291m = obj2;
            this.f292n = obj3;
            this.f293o = obj4;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f288j;
            if (i == 0) {
                AnalyticsTracker.INSTANCE.guildBoostPromotionOpened(this.f289k, new Traits.Location((String) this.f292n, Traits.Location.Section.PREMIUM_GUILD_UPSELL_MODAL, Traits.Location.Obj.BUTTON_CTA, (String) this.f293o, null, 16, null), (Long) this.f291m);
                WidgetGuildBoost.Companion companion = WidgetGuildBoost.INSTANCE;
                Context contextRequireContext = ((C0813e) this.f290l).requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                companion.create(contextRequireContext, this.f289k);
                ((C0813e) this.f290l).dismiss();
                return;
            }
            if (i == 1) {
                AnalyticsTracker.INSTANCE.guildBoostPromotionClosed(this.f289k, new Traits.Location((String) this.f292n, Traits.Location.Section.PREMIUM_GUILD_UPSELL_MODAL, Traits.Location.Obj.BUTTON_CTA, (String) this.f293o, null, 16, null), (Long) this.f291m);
                ((C0813e) this.f290l).dismiss();
                return;
            }
            if (i != 2) {
                throw null;
            }
            AnalyticsTracker.INSTANCE.guildBoostPromotionClosed(this.f289k, new Traits.Location((String) this.f292n, Traits.Location.Section.PREMIUM_GUILD_UPSELL_MODAL, Traits.Location.Obj.BUTTON_CTA, (String) this.f293o, null, 16, null), (Long) this.f291m);
            ((C0813e) this.f290l).dismiss();
        }
    }

    /* JADX INFO: renamed from: b.a.a.b.e$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: GuildBoostUpsellDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0041  */
        /* JADX WARN: Code duplicated, block: B:24:0x004c  */
        /* JADX WARN: Code duplicated, block: B:31:0x0076  */
        /* JADX WARN: Code duplicated, block: B:32:0x007c  */
        /* JADX WARN: Code duplicated, block: B:34:0x007f  */
        /* JADX WARN: Code duplicated, block: B:35:0x0085  */
        /* JADX WARN: Code duplicated, block: B:37:0x0088  */
        /* JADX INFO: renamed from: a */
        public final void m119a(FragmentManager fragmentManager, long j, Long l, Integer num, Traits.Location location) {
            String str;
            String str2;
            Bundle bundleM832T;
            String page;
            String str3;
            String page2;
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C0813e c0813e = new C0813e();
            if (num != null && num.intValue() == 1) {
                str2 = Traits.Location.ObjType.TIER_1;
            } else {
                if (num == null || num.intValue() != 2) {
                    if (num != null && num.intValue() == 3) {
                        str2 = Traits.Location.ObjType.TIER_3;
                    } else {
                        str = null;
                    }
                    bundleM832T = C1643a.m832T("extra_guild_id", j);
                    if (l != null) {
                        bundleM832T.putLong("extra_channel_id", l.longValue());
                    }
                    if (str != null) {
                        bundleM832T.putString("extra_object_type", str);
                    }
                    if (location != null && (page2 = location.getPage()) != null) {
                        bundleM832T.putString("extra_page", page2);
                    }
                    c0813e.setArguments(bundleM832T);
                    c0813e.show(fragmentManager, C0813e.class.getSimpleName());
                    AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
                    String strM883w = C1643a.m883w("Premium Guild Upsell Modal - Tier ", str);
                    if (location != null) {
                        page = location.getPage();
                    } else {
                        page = null;
                    }
                    if (location != null) {
                        str3 = location.get_object();
                    } else {
                        str3 = null;
                    }
                    analyticsTracker.openModal(strM883w, new Traits.Location(page, location != null ? location.getSection() : null, str3, str, null, 16, null));
                }
                str2 = Traits.Location.ObjType.TIER_2;
            }
            str = str2;
            bundleM832T = C1643a.m832T("extra_guild_id", j);
            if (l != null) {
                bundleM832T.putLong("extra_channel_id", l.longValue());
            }
            if (str != null) {
                bundleM832T.putString("extra_object_type", str);
            }
            if (location != null) {
                bundleM832T.putString("extra_page", page2);
            }
            c0813e.setArguments(bundleM832T);
            c0813e.show(fragmentManager, C0813e.class.getSimpleName());
            AnalyticsTracker analyticsTracker2 = AnalyticsTracker.INSTANCE;
            String strM883w2 = C1643a.m883w("Premium Guild Upsell Modal - Tier ", str);
            if (location != null) {
                page = location.getPage();
            } else {
                page = null;
            }
            if (location != null) {
                str3 = location.get_object();
            } else {
                str3 = null;
            }
            analyticsTracker2.openModal(strM883w2, new Traits.Location(page, location != null ? location.getSection() : null, str3, str, null, 16, null));
        }
    }

    /* JADX INFO: renamed from: b.a.a.b.e$c */
    /* JADX INFO: compiled from: GuildBoostUpsellDialog.kt */
    public static final /* synthetic */ class c extends C12236k implements Function1<View, C1072w> {

        /* JADX INFO: renamed from: j */
        public static final c f294j = new c();

        public c() {
            super(1, C1072w.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GuildBoostUpsellDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C1072w invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.guild_boost_upsell_close;
            ImageView imageView = (ImageView) view2.findViewById(C5419R.id.guild_boost_upsell_close);
            if (imageView != null) {
                i = C5419R.id.guild_boost_upsell_close_button;
                TextView textView = (TextView) view2.findViewById(C5419R.id.guild_boost_upsell_close_button);
                if (textView != null) {
                    i = C5419R.id.guild_boost_upsell_subscribe_button;
                    MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.guild_boost_upsell_subscribe_button);
                    if (materialButton != null) {
                        return new C1072w((RelativeLayout) view2, imageView, textView, materialButton);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    public C0813e() {
        super(C5419R.layout.guild_boost_upsell_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c.f294j, null, 2, null);
    }

    /* JADX INFO: renamed from: g */
    public final C1072w m118g() {
        return (C1072w) this.binding.getValue((Fragment) this, f285j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        long j = getArgumentsOrDefault().getLong("extra_guild_id", -1L);
        Bundle arguments = getArguments();
        Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong("extra_channel_id")) : null;
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("extra_object_type") : null;
        Bundle arguments3 = getArguments();
        Long l = lValueOf;
        String string2 = arguments3 != null ? arguments3.getString("extra_page") : null;
        String str = string;
        m118g().f1331d.setOnClickListener(new a(0, j, this, l, string2, str));
        m118g().f1329b.setOnClickListener(new a(1, j, this, l, string2, str));
        m118g().f1330c.setOnClickListener(new a(2, j, this, l, string2, str));
    }
}
