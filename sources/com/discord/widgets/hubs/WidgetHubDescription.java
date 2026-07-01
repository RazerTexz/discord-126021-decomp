package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetHubDescriptionBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallState4;
import com.discord.stores.utilities.RestCallState5;
import com.discord.stores.utilities.RestCallState6;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet;
import com.google.android.material.textfield.TextInputEditText;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescription extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetHubDescription.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubDescriptionBinding;", 0)};

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AppLogger2 loggingConfig;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDescription$configureUI$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHubDescription.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<RestCallState6<? extends DirectoryEntryGuild>, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState6<? extends DirectoryEntryGuild> restCallState6) {
            invoke2((RestCallState6<DirectoryEntryGuild>) restCallState6);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState6<DirectoryEntryGuild> restCallState6) {
            Intrinsics3.checkNotNullParameter(restCallState6, "it");
            StoreStream.INSTANCE.getDirectories().addServerToDirectory(WidgetHubDescription.this.getArgs().getChannelId(), restCallState6.invoke());
            WidgetHubDescription widgetHubDescription = WidgetHubDescription.this;
            widgetHubDescription.hideKeyboard(widgetHubDescription.getView());
            FragmentActivity fragmentActivityE = WidgetHubDescription.this.e();
            if (fragmentActivityE != null) {
                fragmentActivityE.setResult(-1, AnimatableValueParser.g2(new WidgetHubDescription2(restCallState6.invoke().getGuild().getId(), WidgetHubDescription.this.getArgs().getHubName())));
                fragmentActivityE.finish();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDescription$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHubDescription.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetHubDescriptionViewModel3, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3) {
            invoke2(widgetHubDescriptionViewModel3);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3) {
            Intrinsics3.checkNotNullParameter(widgetHubDescriptionViewModel3, "viewState");
            WidgetHubDescription.this.configureUI(widgetHubDescriptionViewModel3);
        }
    }

    public WidgetHubDescription() {
        super(R.layout.widget_hub_description);
        this.args = LazyJVM.lazy(new WidgetHubDescription$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetHubDescription3.INSTANCE, null, 2, null);
        WidgetHubDescription8 widgetHubDescription8 = new WidgetHubDescription8(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetHubDescriptionViewModel.class), new WidgetHubDescription$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetHubDescription8));
        this.validationManager = LazyJVM.lazy(new WidgetHubDescription7(this));
        this.loggingConfig = new AppLogger2(false, null, new WidgetHubDescription5(this), 3);
    }

    private final void configureUI(final WidgetHubDescriptionViewModel3 state) {
        int i;
        String string;
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            getBinding().h.setTitle(FormatUtils.e(this, getArgs().isEditing() ? R.string.hub_entry_update_description_title : R.string.hub_customize_existing_guild_title, new Object[]{state.getGuildName()}, (4 & 4) != 0 ? FormatUtils.a.j : null));
            LoadingButton loadingButton = getBinding().f2470b;
            loadingButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.WidgetHubDescription$configureUI$$inlined$apply$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.this$0.maybeAddServer();
                }
            });
            loadingButton.setIsLoading(state.getAddServerAsync() instanceof RestCallState4);
            loadingButton.setText(getString(getArgs().isEditing() ? R.string.save : R.string.hub_add_server_cta));
            TextView textView = getBinding().c;
            DirectoryEntryCategory selectedCategory = state.getSelectedCategory();
            if (selectedCategory != null) {
                selectedCategory.getTitleRes();
                i = R.attr.colorTextNormal;
            } else {
                i = R.attr.colorTextMuted;
            }
            textView.setTextColor(ColorCompat.getThemedColor(context, i));
            TextView textView2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.category");
            DirectoryEntryCategory selectedCategory2 = state.getSelectedCategory();
            if (selectedCategory2 == null || (string = selectedCategory2.getTitle(context)) == null) {
                string = getString(R.string.categories);
            }
            textView2.setText(string);
            RestCallState5.handleResponse$default(state.getAddServerAsync(), context, null, null, new AnonymousClass3(), 6, null);
        }
    }

    private final WidgetRadioSelectorBottomSheet3 getSelectorArgs() {
        String string = requireContext().getString(R.string.categories);
        Intrinsics3.checkNotNullExpressionValue(string, "requireContext().getString(R.string.categories)");
        return new WidgetRadioSelectorBottomSheet3(string, (List) getViewModel().withViewState(new WidgetHubDescription6(this)));
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
            Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.description");
            viewModel.addServer(channelId, guildId, String.valueOf(textInputEditText.getText()));
        }
    }

    public final WidgetHubDescriptionViewModel2 getArgs() {
        return (WidgetHubDescriptionViewModel2) this.args.getValue();
    }

    public final WidgetHubDescriptionBinding getBinding() {
        return (WidgetHubDescriptionBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    public final WidgetHubDescriptionViewModel getViewModel() {
        return (WidgetHubDescriptionViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f.setText(getArgs().getDescription());
        getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.WidgetHubDescription.onViewBound.1

            /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDescription$onViewBound$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetHubDescription.kt */
            public static final class C02981 extends Lambda implements Function1<Integer, Unit> {
                public C02981() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.a;
                }

                public final void invoke(int i) {
                    WidgetHubDescription.this.getViewModel().setCategory(i);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetRadioSelectorBottomSheet.Companion companion = WidgetRadioSelectorBottomSheet.INSTANCE;
                FragmentManager childFragmentManager = WidgetHubDescription.this.getChildFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                companion.show(childFragmentManager, WidgetHubDescription.this.getSelectorArgs(), new C02981());
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null)), (Class<?>) WidgetHubDescription.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
