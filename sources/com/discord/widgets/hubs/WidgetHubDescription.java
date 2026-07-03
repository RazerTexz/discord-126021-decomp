package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetHubDescriptionBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.Loading;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.stores.utilities.Success;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet;
import com.google.android.material.textfield.TextInputEditText;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p027k.C1107b;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescription extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetHubDescription.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubDescriptionBinding;", 0)};

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDescription$configureUI$3 */
    /* JADX INFO: compiled from: WidgetHubDescription.kt */
    public static final class C90093 extends AbstractC12240o implements Function1<Success<? extends DirectoryEntryGuild>, Unit> {
        public C90093() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Success<? extends DirectoryEntryGuild> success) {
            invoke2((Success<DirectoryEntryGuild>) success);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Success<DirectoryEntryGuild> success) {
            C12238m.checkNotNullParameter(success, "it");
            StoreStream.INSTANCE.getDirectories().addServerToDirectory(WidgetHubDescription.this.getArgs().getChannelId(), success.invoke());
            WidgetHubDescription widgetHubDescription = WidgetHubDescription.this;
            widgetHubDescription.hideKeyboard(widgetHubDescription.getView());
            FragmentActivity fragmentActivityM95e = WidgetHubDescription.this.m95e();
            if (fragmentActivityM95e != null) {
                fragmentActivityM95e.setResult(-1, C1460d.m522g2(new DescriptionResult(success.invoke().getGuild().getId(), WidgetHubDescription.this.getArgs().getHubName())));
                fragmentActivityM95e.finish();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDescription$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetHubDescription.kt */
    public static final class C90111 extends AbstractC12240o implements Function1<HubDescriptionState, Unit> {
        public C90111() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HubDescriptionState hubDescriptionState) {
            invoke2(hubDescriptionState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(HubDescriptionState hubDescriptionState) {
            C12238m.checkNotNullParameter(hubDescriptionState, "viewState");
            WidgetHubDescription.this.configureUI(hubDescriptionState);
        }
    }

    public WidgetHubDescription() {
        super(C5419R.layout.widget_hub_description);
        this.args = C12083g.lazy(new WidgetHubDescription$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetHubDescription$binding$2.INSTANCE, null, 2, null);
        WidgetHubDescription$viewModel$2 widgetHubDescription$viewModel$2 = new WidgetHubDescription$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetHubDescriptionViewModel.class), new WidgetHubDescription$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetHubDescription$viewModel$2));
        this.validationManager = C12083g.lazy(new WidgetHubDescription$validationManager$2(this));
        this.loggingConfig = new LoggingConfig(false, null, new WidgetHubDescription$loggingConfig$1(this), 3);
    }

    private final void configureUI(final HubDescriptionState state) {
        int i;
        String string;
        Context context = getContext();
        if (context != null) {
            C12238m.checkNotNullExpressionValue(context, "context ?: return");
            getBinding().f17161h.setTitle(C1107b.m213e(this, getArgs().isEditing() ? C5419R.string.hub_entry_update_description_title : C5419R.string.hub_customize_existing_guild_title, new Object[]{state.getGuildName()}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
            LoadingButton loadingButton = getBinding().f17155b;
            loadingButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.WidgetHubDescription$configureUI$$inlined$apply$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.this$0.maybeAddServer();
                }
            });
            loadingButton.setIsLoading(state.getAddServerAsync() instanceof Loading);
            loadingButton.setText(getString(getArgs().isEditing() ? C5419R.string.save : C5419R.string.hub_add_server_cta));
            TextView textView = getBinding().f17156c;
            DirectoryEntryCategory selectedCategory = state.getSelectedCategory();
            if (selectedCategory != null) {
                selectedCategory.getTitleRes();
                i = C5419R.attr.colorTextNormal;
            } else {
                i = C5419R.attr.colorTextMuted;
            }
            textView.setTextColor(ColorCompat.getThemedColor(context, i));
            TextView textView2 = getBinding().f17156c;
            C12238m.checkNotNullExpressionValue(textView2, "binding.category");
            DirectoryEntryCategory selectedCategory2 = state.getSelectedCategory();
            if (selectedCategory2 == null || (string = selectedCategory2.getTitle(context)) == null) {
                string = getString(C5419R.string.categories);
            }
            textView2.setText(string);
            RestCallStateKt.handleResponse$default(state.getAddServerAsync(), context, null, null, new C90093(), 6, null);
        }
    }

    private final RadioSelectorItems getSelectorArgs() {
        String string = requireContext().getString(C5419R.string.categories);
        C12238m.checkNotNullExpressionValue(string, "requireContext().getString(R.string.categories)");
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
            TextInputEditText textInputEditText = getBinding().f17159f;
            C12238m.checkNotNullExpressionValue(textInputEditText, "binding.description");
            viewModel.addServer(channelId, guildId, String.valueOf(textInputEditText.getText()));
        }
    }

    public final HubDescriptionArgs getArgs() {
        return (HubDescriptionArgs) this.args.getValue();
    }

    public final WidgetHubDescriptionBinding getBinding() {
        return (WidgetHubDescriptionBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    public final WidgetHubDescriptionViewModel getViewModel() {
        return (WidgetHubDescriptionViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f17159f.setText(getArgs().getDescription());
        getBinding().f17158e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.WidgetHubDescription.onViewBound.1

            /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDescription$onViewBound$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetHubDescription.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Integer, Unit> {
                public AnonymousClass1() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.f27425a;
                }

                public final void invoke(int i) {
                    WidgetHubDescription.this.getViewModel().setCategory(i);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetRadioSelectorBottomSheet.Companion companion = WidgetRadioSelectorBottomSheet.INSTANCE;
                FragmentManager childFragmentManager = WidgetHubDescription.this.getChildFragmentManager();
                C12238m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                companion.show(childFragmentManager, WidgetHubDescription.this.getSelectorArgs(), new AnonymousClass1());
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null)), (Class<?>) WidgetHubDescription.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C90111());
    }
}
