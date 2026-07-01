package com.discord.widgets.nux;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetNuxGuildTemplateBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.g;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetGuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public class WidgetGuildTemplates extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildTemplates.class, "binding", "getBinding()Lcom/discord/databinding/WidgetNuxGuildTemplateBinding;", 0)};
    public static final WidgetGuildTemplates$Companion Companion = new WidgetGuildTemplates$Companion(null);
    private final GuildTemplatesAdapter adapter;

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetGuildTemplates() {
        super(R$layout.widget_nux_guild_template);
        this.args = g.lazy(new WidgetGuildTemplates$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildTemplates$binding$2.INSTANCE, null, 2, null);
        this.adapter = new GuildTemplatesAdapter(new WidgetGuildTemplates$adapter$1(this));
    }

    public static final /* synthetic */ GuildCreateArgs access$getArgs$p(WidgetGuildTemplates widgetGuildTemplates) {
        return widgetGuildTemplates.getArgs();
    }

    public static final /* synthetic */ void access$trackPostRegistrationSkip(WidgetGuildTemplates widgetGuildTemplates) {
        widgetGuildTemplates.trackPostRegistrationSkip();
    }

    public static final /* synthetic */ void access$trackPostRegistrationTransition(WidgetGuildTemplates widgetGuildTemplates, String str, String str2) {
        widgetGuildTemplates.trackPostRegistrationTransition(str, str2);
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
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        trackPostRegistrationTransition(GuildTemplateAnalytics.STEP_REGISTRATION, GuildTemplateAnalytics.STEP_GUILD_TEMPLATE);
        AppFragment.setOnBackPressed$default(this, new WidgetGuildTemplates$onViewBound$1(this), 0, 2, null);
        RecyclerView recyclerView = getBinding().f;
        m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setAdapter(this.adapter);
        TextView textView = getBinding().e;
        m.checkNotNullExpressionValue(textView, "binding.nuxGuildTemplateSectionTitle");
        textView.setText(getArgs().getGuildTemplate().getTitle());
        TextView textView2 = getBinding().d;
        m.checkNotNullExpressionValue(textView2, "binding.nuxGuildTemplateSectionCustomLabel");
        textView2.setText(getArgs().getGuildTemplate().getSubtitle());
        GuildTemplatesAdapter guildTemplatesAdapter = this.adapter;
        List<GuildTemplate> templates = getArgs().getGuildTemplate().getTemplates();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(templates, 10));
        Iterator<T> it = templates.iterator();
        while (it.hasNext()) {
            arrayList.add(new GuildTemplateViewType$Template((GuildTemplate) it.next()));
        }
        guildTemplatesAdapter.setItems(arrayList);
        getBinding().f2505b.setOnClickListener(new WidgetGuildTemplates$onViewBound$3(this));
        LinearLayout linearLayout = getBinding().c;
        m.checkNotNullExpressionValue(linearLayout, "binding.nuxGuildTemplateSectionBottom");
        linearLayout.setVisibility(getArgs().getGuildTemplate().getShowInvitePrompt() ? 0 : 8);
    }
}
