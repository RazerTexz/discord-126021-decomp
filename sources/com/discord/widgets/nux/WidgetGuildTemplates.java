package com.discord.widgets.nux;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetNuxGuildTemplateBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guilds.create.CreateGuildTrigger;
import com.discord.widgets.guilds.create.StockGuildTemplate;
import com.discord.widgets.guilds.create.WidgetCreationIntent;
import com.discord.widgets.guilds.create.WidgetGuildCreate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Func0;

/* JADX INFO: compiled from: WidgetGuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public class WidgetGuildTemplates extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildTemplates.class, "binding", "getBinding()Lcom/discord/databinding/WidgetNuxGuildTemplateBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final GuildTemplatesAdapter adapter;

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetGuildTemplates.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, CreateGuildTrigger trigger, boolean isNux) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(trigger, "trigger");
            String str = isNux ? GuildTemplateAnalytics.STEP_GUILD_TEMPLATE : GuildTemplateAnalytics.IN_APP_LOCATION_TEMPLATE;
            String string = context.getString(C5419R.string.guild_template_selector_title);
            C12238m.checkNotNullExpressionValue(string, "context.getString(R.stri…_template_selector_title)");
            String string2 = context.getString(C5419R.string.guild_template_selector_description);
            C12238m.checkNotNullExpressionValue(string2, "context.getString(R.stri…ate_selector_description)");
            launch(context, new GuildCreateArgs(isNux, str, trigger, new GuildTemplateArgs(string, string2, null, false, false, 28, null), false, 16, null));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void launch(Context context, GuildCreateArgs args) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(args, "args");
            C0870j.m156d(context, WidgetGuildTemplates.class, args);
        }
    }

    public WidgetGuildTemplates() {
        super(C5419R.layout.widget_nux_guild_template);
        this.args = C12083g.lazy(new WidgetGuildTemplates$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildTemplates$binding$2.INSTANCE, null, 2, null);
        this.adapter = new GuildTemplatesAdapter(new GuildTemplatesAdapter.Callbacks() { // from class: com.discord.widgets.nux.WidgetGuildTemplates$adapter$1
            @Override // com.discord.widgets.nux.GuildTemplatesAdapter.Callbacks
            public void onTemplateClick(GuildTemplate guildTemplate) {
                C12238m.checkNotNullParameter(guildTemplate, "guildTemplate");
                WidgetGuildCreate.Options options = new WidgetGuildCreate.Options(this.this$0.getArgs().getLocation(), guildTemplate.getTemplateType(), guildTemplate.getTemplateType() == StockGuildTemplate.CREATE, this.this$0.getString(C5419R.string.guild_create_title), this.this$0.getArgs().getCloseWithResult());
                if (this.this$0.getArgs().getGuildTemplate().getSkipCreationIntent()) {
                    AnalyticsTracker.openModal$default("Create Guild Step 2", options.getAnalyticsLocation(), null, 4, null);
                    WidgetGuildCreate.Companion.showFragment(this.this$0, options);
                } else {
                    this.this$0.trackPostRegistrationTransition(GuildTemplateAnalytics.STEP_GUILD_TEMPLATE, GuildTemplateAnalytics.STEP_CREATION_INTENT);
                    WidgetCreationIntent.Companion companion = WidgetCreationIntent.Companion;
                    WidgetGuildTemplates widgetGuildTemplates = this.this$0;
                    companion.show(widgetGuildTemplates, widgetGuildTemplates.getArgs().getTrigger(), options);
                }
            }
        });
    }

    private final GuildCreateArgs getArgs() {
        return (GuildCreateArgs) this.args.getValue();
    }

    private final WidgetNuxGuildTemplateBinding getBinding() {
        return (WidgetNuxGuildTemplateBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void trackPostRegistrationSkip() {
        if (getArgs().isNux()) {
            GuildTemplateAnalytics.INSTANCE.postRegistrationSkip$app_productionGoogleRelease(GuildTemplateAnalytics.STEP_GUILD_TEMPLATE);
        }
    }

    private final void trackPostRegistrationTransition(String fromStep, String toStep) {
        if (getArgs().isNux()) {
            GuildTemplateAnalytics.INSTANCE.postRegistrationTransition$app_productionGoogleRelease(fromStep, toStep);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        trackPostRegistrationTransition(GuildTemplateAnalytics.STEP_REGISTRATION, GuildTemplateAnalytics.STEP_GUILD_TEMPLATE);
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.nux.WidgetGuildTemplates.onViewBound.1
            @Override // p658rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                WidgetGuildTemplates.this.trackPostRegistrationSkip();
                return Boolean.FALSE;
            }
        }, 0, 2, null);
        RecyclerView recyclerView = getBinding().f17328f;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setAdapter(this.adapter);
        TextView textView = getBinding().f17327e;
        C12238m.checkNotNullExpressionValue(textView, "binding.nuxGuildTemplateSectionTitle");
        textView.setText(getArgs().getGuildTemplate().getTitle());
        TextView textView2 = getBinding().f17326d;
        C12238m.checkNotNullExpressionValue(textView2, "binding.nuxGuildTemplateSectionCustomLabel");
        textView2.setText(getArgs().getGuildTemplate().getSubtitle());
        GuildTemplatesAdapter guildTemplatesAdapter = this.adapter;
        List<GuildTemplate> templates = getArgs().getGuildTemplate().getTemplates();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(templates, 10));
        Iterator<T> it = templates.iterator();
        while (it.hasNext()) {
            arrayList.add(new GuildTemplateViewType.Template((GuildTemplate) it.next()));
        }
        guildTemplatesAdapter.setItems(arrayList);
        getBinding().f17324b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.nux.WidgetGuildTemplates.onViewBound.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildTemplates.this.trackPostRegistrationTransition(GuildTemplateAnalytics.STEP_GUILD_TEMPLATE, GuildTemplateAnalytics.STEP_GUILD_JOIN);
                WidgetNuxPostRegistrationJoin.INSTANCE.show(WidgetGuildTemplates.this.requireContext());
                FragmentActivity fragmentActivityM95e = WidgetGuildTemplates.this.m95e();
                if (fragmentActivityM95e != null) {
                    fragmentActivityM95e.finish();
                }
            }
        });
        LinearLayout linearLayout = getBinding().f17325c;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.nuxGuildTemplateSectionBottom");
        linearLayout.setVisibility(getArgs().getGuildTemplate().getShowInvitePrompt() ? 0 : 8);
    }
}
