package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetHubDescriptionBinding;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.stores.utilities.Loading;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import com.google.android.material.textfield.TextInputEditText;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescription extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetHubDescription.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubDescriptionBinding;", 0)};

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetHubDescription() {
        super(R$layout.widget_hub_description);
        this.args = g.lazy(new WidgetHubDescription$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetHubDescription$binding$2.INSTANCE, null, 2, null);
        WidgetHubDescription$viewModel$2 widgetHubDescription$viewModel$2 = new WidgetHubDescription$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetHubDescriptionViewModel.class), new WidgetHubDescription$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetHubDescription$viewModel$2));
        this.validationManager = g.lazy(new WidgetHubDescription$validationManager$2(this));
        this.loggingConfig = new LoggingConfig(false, null, new WidgetHubDescription$loggingConfig$1(this), 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetHubDescription widgetHubDescription, HubDescriptionState hubDescriptionState) {
        widgetHubDescription.configureUI(hubDescriptionState);
    }

    public static final /* synthetic */ RadioSelectorItems access$getSelectorArgs$p(WidgetHubDescription widgetHubDescription) {
        return widgetHubDescription.getSelectorArgs();
    }

    public static final /* synthetic */ void access$maybeAddServer(WidgetHubDescription widgetHubDescription) {
        widgetHubDescription.maybeAddServer();
    }

    private final void configureUI(HubDescriptionState state) {
        int i;
        String string;
        Context context = getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context ?: return");
            getBinding().h.setTitle(b.k(this, getArgs().isEditing() ? 2131891809 : 2131891760, new Object[]{state.getGuildName()}, null, 4));
            LoadingButton loadingButton = getBinding().f2470b;
            loadingButton.setOnClickListener(new WidgetHubDescription$configureUI$$inlined$apply$lambda$1(this, state));
            loadingButton.setIsLoading(state.getAddServerAsync() instanceof Loading);
            loadingButton.setText(getString(getArgs().isEditing() ? 2131895226 : 2131891743));
            TextView textView = getBinding().c;
            DirectoryEntryCategory selectedCategory = state.getSelectedCategory();
            if (selectedCategory != null) {
                selectedCategory.getTitleRes();
                i = 2130969057;
            } else {
                i = 2130969056;
            }
            textView.setTextColor(ColorCompat.getThemedColor(context, i));
            TextView textView2 = getBinding().c;
            m.checkNotNullExpressionValue(textView2, "binding.category");
            DirectoryEntryCategory selectedCategory2 = state.getSelectedCategory();
            if (selectedCategory2 == null || (string = selectedCategory2.getTitle(context)) == null) {
                string = getString(2131887462);
            }
            textView2.setText(string);
            RestCallStateKt.handleResponse$default(state.getAddServerAsync(), context, null, null, new WidgetHubDescription$configureUI$3(this), 6, null);
        }
    }

    private final RadioSelectorItems getSelectorArgs() {
        String string = requireContext().getString(2131887462);
        m.checkNotNullExpressionValue(string, "requireContext().getString(R.string.categories)");
        return new RadioSelectorItems(string, (List) getViewModel().withViewState(new WidgetHubDescription$selectorArgs$1(this)));
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void maybeAddServer() {
        if (getValidationManager().validate(true)) {
            WidgetHubDescriptionViewModel viewModel = getViewModel();
            long channelId = getArgs().getChannelId();
            long guildId = getArgs().getGuildId();
            TextInputEditText textInputEditText = getBinding().f;
            m.checkNotNullExpressionValue(textInputEditText, "binding.description");
            viewModel.addServer(channelId, guildId, String.valueOf(textInputEditText.getText()));
        }
    }

    public final HubDescriptionArgs getArgs() {
        return (HubDescriptionArgs) this.args.getValue();
    }

    public final WidgetHubDescriptionBinding getBinding() {
        return (WidgetHubDescriptionBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    public final WidgetHubDescriptionViewModel getViewModel() {
        return (WidgetHubDescriptionViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f.setText(getArgs().getDescription());
        getBinding().e.setOnClickListener(new WidgetHubDescription$onViewBound$1(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null)), WidgetHubDescription.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHubDescription$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
