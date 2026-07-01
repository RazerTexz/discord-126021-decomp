package b.a.a.b;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.i.GuildBoostUpsellDialogBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.servers.guildboost.WidgetGuildBoost;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: b.a.a.b.e, reason: use source file name */
/* JADX INFO: compiled from: GuildBoostUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildBoostUpsellDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(GuildBoostUpsellDialog.class, "binding", "getBinding()Lcom/discord/databinding/GuildBoostUpsellDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: b.a.a.b.e$a */
    /* JADX INFO: compiled from: java-style lambda group */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ long k;
        public final /* synthetic */ Object l;
        public final /* synthetic */ Object m;
        public final /* synthetic */ Object n;
        public final /* synthetic */ Object o;

        public a(int i, long j, Object obj, Object obj2, Object obj3, Object obj4) {
            this.j = i;
            this.k = j;
            this.l = obj;
            this.m = obj2;
            this.n = obj3;
            this.o = obj4;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.j;
            if (i == 0) {
                AnalyticsTracker.INSTANCE.guildBoostPromotionOpened(this.k, new Traits.Location((String) this.n, Traits.Location.Section.PREMIUM_GUILD_UPSELL_MODAL, Traits.Location.Obj.BUTTON_CTA, (String) this.o, null, 16, null), (Long) this.m);
                WidgetGuildBoost.Companion companion = WidgetGuildBoost.INSTANCE;
                Context contextRequireContext = ((GuildBoostUpsellDialog) this.l).requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                companion.create(contextRequireContext, this.k);
                ((GuildBoostUpsellDialog) this.l).dismiss();
                return;
            }
            if (i == 1) {
                AnalyticsTracker.INSTANCE.guildBoostPromotionClosed(this.k, new Traits.Location((String) this.n, Traits.Location.Section.PREMIUM_GUILD_UPSELL_MODAL, Traits.Location.Obj.BUTTON_CTA, (String) this.o, null, 16, null), (Long) this.m);
                ((GuildBoostUpsellDialog) this.l).dismiss();
                return;
            }
            if (i != 2) {
                throw null;
            }
            AnalyticsTracker.INSTANCE.guildBoostPromotionClosed(this.k, new Traits.Location((String) this.n, Traits.Location.Section.PREMIUM_GUILD_UPSELL_MODAL, Traits.Location.Obj.BUTTON_CTA, (String) this.o, null, 16, null), (Long) this.m);
            ((GuildBoostUpsellDialog) this.l).dismiss();
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
        public final void a(FragmentManager fragmentManager, long j, Long l, Integer num, Traits.Location location) {
            String str;
            String str2;
            Bundle bundleT;
            String page;
            String str3;
            String page2;
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            GuildBoostUpsellDialog guildBoostUpsellDialog = new GuildBoostUpsellDialog();
            if (num != null && num.intValue() == 1) {
                str2 = Traits.Location.ObjType.TIER_1;
            } else {
                if (num == null || num.intValue() != 2) {
                    if (num != null && num.intValue() == 3) {
                        str2 = Traits.Location.ObjType.TIER_3;
                    } else {
                        str = null;
                    }
                    bundleT = outline.T("extra_guild_id", j);
                    if (l != null) {
                        bundleT.putLong("extra_channel_id", l.longValue());
                    }
                    if (str != null) {
                        bundleT.putString("extra_object_type", str);
                    }
                    if (location != null && (page2 = location.getPage()) != null) {
                        bundleT.putString("extra_page", page2);
                    }
                    guildBoostUpsellDialog.setArguments(bundleT);
                    guildBoostUpsellDialog.show(fragmentManager, GuildBoostUpsellDialog.class.getSimpleName());
                    AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
                    String strW = outline.w("Premium Guild Upsell Modal - Tier ", str);
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
                    analyticsTracker.openModal(strW, new Traits.Location(page, location != null ? location.getSection() : null, str3, str, null, 16, null));
                }
                str2 = Traits.Location.ObjType.TIER_2;
            }
            str = str2;
            bundleT = outline.T("extra_guild_id", j);
            if (l != null) {
                bundleT.putLong("extra_channel_id", l.longValue());
            }
            if (str != null) {
                bundleT.putString("extra_object_type", str);
            }
            if (location != null) {
                bundleT.putString("extra_page", page2);
            }
            guildBoostUpsellDialog.setArguments(bundleT);
            guildBoostUpsellDialog.show(fragmentManager, GuildBoostUpsellDialog.class.getSimpleName());
            AnalyticsTracker analyticsTracker2 = AnalyticsTracker.INSTANCE;
            String strW2 = outline.w("Premium Guild Upsell Modal - Tier ", str);
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
            analyticsTracker2.openModal(strW2, new Traits.Location(page, location != null ? location.getSection() : null, str3, str, null, 16, null));
        }
    }

    /* JADX INFO: renamed from: b.a.a.b.e$c */
    /* JADX INFO: compiled from: GuildBoostUpsellDialog.kt */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<View, GuildBoostUpsellDialogBinding> {
        public static final c j = new c();

        public c() {
            super(1, GuildBoostUpsellDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GuildBoostUpsellDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public GuildBoostUpsellDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.guild_boost_upsell_close;
            ImageView imageView = (ImageView) view2.findViewById(R.id.guild_boost_upsell_close);
            if (imageView != null) {
                i = R.id.guild_boost_upsell_close_button;
                TextView textView = (TextView) view2.findViewById(R.id.guild_boost_upsell_close_button);
                if (textView != null) {
                    i = R.id.guild_boost_upsell_subscribe_button;
                    MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.guild_boost_upsell_subscribe_button);
                    if (materialButton != null) {
                        return new GuildBoostUpsellDialogBinding((RelativeLayout) view2, imageView, textView, materialButton);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    public GuildBoostUpsellDialog() {
        super(R.layout.guild_boost_upsell_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.j, null, 2, null);
    }

    public final GuildBoostUpsellDialogBinding g() {
        return (GuildBoostUpsellDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        long j2 = getArgumentsOrDefault().getLong("extra_guild_id", -1L);
        Bundle arguments = getArguments();
        Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong("extra_channel_id")) : null;
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("extra_object_type") : null;
        Bundle arguments3 = getArguments();
        Long l = lValueOf;
        String string2 = arguments3 != null ? arguments3.getString("extra_page") : null;
        String str = string;
        g().d.setOnClickListener(new a(0, j2, this, l, string2, str));
        g().f220b.setOnClickListener(new a(1, j2, this, l, string2, str));
        g().c.setOnClickListener(new a(2, j2, this, l, string2, str));
    }
}
