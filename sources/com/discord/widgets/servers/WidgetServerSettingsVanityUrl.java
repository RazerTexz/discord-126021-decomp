package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsVanityUrlBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams$VanityUrl;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetServerSettingsVanityUrl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsVanityUrl extends AppFragment {
    private static final long ANIMATION_DURATION = 250;
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final LoggingConfig loggingConfig;
    private final StatefulViews state;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsVanityUrl.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsVanityUrlBinding;", 0)};
    public static final WidgetServerSettingsVanityUrl$Companion Companion = new WidgetServerSettingsVanityUrl$Companion(null);

    public WidgetServerSettingsVanityUrl() {
        super(R$layout.widget_server_settings_vanity_url);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsVanityUrl$binding$2.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R$id.server_settings_vanity_input);
        this.guildId = g.lazy(new WidgetServerSettingsVanityUrl$guildId$2(this));
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsVanityUrl$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureInviteCode(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl, String str, int i) {
        widgetServerSettingsVanityUrl.configureInviteCode(str, i);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl, WidgetServerSettingsVanityUrl$Model widgetServerSettingsVanityUrl$Model) {
        widgetServerSettingsVanityUrl.configureUI(widgetServerSettingsVanityUrl$Model);
    }

    public static final /* synthetic */ WidgetServerSettingsVanityUrlBinding access$getBinding$p(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl) {
        return widgetServerSettingsVanityUrl.getBinding();
    }

    public static final /* synthetic */ StatefulViews access$getState$p(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl) {
        return widgetServerSettingsVanityUrl.state;
    }

    public static final /* synthetic */ void access$showLoadingUI(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl, boolean z2) {
        widgetServerSettingsVanityUrl.showLoadingUI(z2);
    }

    public static final /* synthetic */ void access$updateVanityUrl(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl, long j, String str) {
        widgetServerSettingsVanityUrl.updateVanityUrl(j, str);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0070  */
    /* JADX WARN: Code duplicated, block: B:31:0x0096  */
    private final void configureInviteCode(String code, int uses) {
        boolean z2;
        boolean z3;
        TextInputLayout textInputLayout = getBinding().f2588b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsVanityInput");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().f2588b;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsVanityInput");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), code));
        getBinding().f2588b.clearFocus();
        if (code != null) {
            if (code.length() > 0) {
                String strW = a.w("https://discord.gg/", code);
                TextView textView = getBinding().c;
                m.checkNotNullExpressionValue(textView, "binding.serverSettingsVanityUrlCurrentUrl");
                b.n(textView, 2131897026, new Object[]{strW}, null, 4);
            }
        }
        TextView textView2 = getBinding().c;
        m.checkNotNullExpressionValue(textView2, "binding.serverSettingsVanityUrlCurrentUrl");
        if (code == null) {
            z2 = false;
        } else {
            if (code.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        textView2.setVisibility(z2 ? 0 : 8);
        TextView textView3 = getBinding().i;
        m.checkNotNullExpressionValue(textView3, "binding.serverSettingsVanityUrlRemove");
        if (code == null) {
            z3 = false;
        } else {
            if (code.length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        textView3.setVisibility(z3 ? 0 : 8);
        if (code == null) {
            getBinding().e.setText(2131897021);
            return;
        }
        CharSequence i18nPluralString = StringResourceUtilsKt.getI18nPluralString(requireContext(), R$plurals.vanity_url_header_uses_uses, uses, Integer.valueOf(uses));
        TextView textView4 = getBinding().e;
        m.checkNotNullExpressionValue(textView4, "binding.serverSettingsVanityUrlHeader");
        b.n(textView4, 2131897023, new Object[]{i18nPluralString}, null, 4);
    }

    private final void configureUI(WidgetServerSettingsVanityUrl$Model model) {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        showLoadingUI(false);
        setActionBarTitle(2131897021);
        setActionBarSubtitle(model.getGuildName());
        configureInviteCode(model.getVanityUrl(), model.getVanityUrlUses());
        this.state.configureSaveActionView(getBinding().j);
        getBinding().j.setOnClickListener(new WidgetServerSettingsVanityUrl$configureUI$1(this, model));
        getBinding().i.setOnClickListener(new WidgetServerSettingsVanityUrl$configureUI$2(this, model));
    }

    private final WidgetServerSettingsVanityUrlBinding getBinding() {
        return (WidgetServerSettingsVanityUrlBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final void showLoadingUI(boolean loading) {
        ProgressBar progressBar = getBinding().g;
        m.checkNotNullExpressionValue(progressBar, "binding.serverSettingsVanityUrlLoadingIndicator");
        progressBar.setVisibility(loading ? 0 : 8);
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.serverSettingsVanityUrlErrorText");
        textView.setVisibility(8);
        TextView textView2 = getBinding().i;
        m.checkNotNullExpressionValue(textView2, "binding.serverSettingsVanityUrlRemove");
        textView2.setEnabled(!loading);
    }

    private final void updateVanityUrl(long guildId, String code) {
        showLoadingUI(true);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().updateVanityUrl(guildId, new RestAPIParams$VanityUrl(code)), false, 1, null), this, null, 2, null), WidgetServerSettingsVanityUrl.class, getContext(), (Function1) null, new WidgetServerSettingsVanityUrl$updateVanityUrl$2(this), (Function0) null, (Function0) null, new WidgetServerSettingsVanityUrl$updateVanityUrl$1(this), 52, (Object) null);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        showLoadingUI(true);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetServerSettingsVanityUrl$Model.Companion.get(getGuildId()), this, null, 2, null), WidgetServerSettingsVanityUrl.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsVanityUrl$onResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextInputLayout textInputLayout = getBinding().f2588b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsVanityInput");
        ViewExtensions.setOnEditTextFocusChangeListener(textInputLayout, new WidgetServerSettingsVanityUrl$onViewBound$1(this));
        getBinding().f.setOnClickListener(new WidgetServerSettingsVanityUrl$onViewBound$2(this));
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        FloatingActionButton floatingActionButton = getBinding().j;
        TextInputLayout textInputLayout2 = getBinding().f2588b;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsVanityInput");
        statefulViews.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout2);
    }
}
