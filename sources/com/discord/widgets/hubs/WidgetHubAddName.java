package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetHubAddNameBinding;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.Loading;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.stores.utilities.Success;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.textfield.TextInputEditText;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetHubAddName.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddName extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetHubAddName.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubAddNameBinding;", 0)};

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAddName$configureUI$2 */
    /* JADX INFO: compiled from: WidgetHubAddName.kt */
    public static final class C89872 extends AbstractC12240o implements Function1<Success<? extends Void>, Unit> {
        public C89872() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Success<? extends Void> success) {
            invoke2((Success<Void>) success);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Success<Void> success) {
            C12238m.checkNotNullParameter(success, "it");
            FragmentActivity fragmentActivityM95e = WidgetHubAddName.this.m95e();
            if (fragmentActivityM95e != null) {
                fragmentActivityM95e.onBackPressed();
            }
            WidgetHubAddName widgetHubAddName = WidgetHubAddName.this;
            widgetHubAddName.hideKeyboard(widgetHubAddName.getView());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAddName$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetHubAddName.kt */
    public static final class C89891 extends AbstractC12240o implements Function1<AddNameState, Unit> {
        public C89891() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AddNameState addNameState) {
            invoke2(addNameState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AddNameState addNameState) {
            C12238m.checkNotNullParameter(addNameState, "viewState");
            WidgetHubAddName.this.configureUI(addNameState);
        }
    }

    public WidgetHubAddName() {
        super(C5419R.layout.widget_hub_add_name);
        this.args = C12083g.lazy(new WidgetHubAddName$$special$$inlined$args$1(this, "intent_args_key"));
        WidgetHubAddName$viewModel$2 widgetHubAddName$viewModel$2 = new WidgetHubAddName$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetHubAddNameViewModel.class), new WidgetHubAddName$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetHubAddName$viewModel$2));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetHubAddName$binding$2.INSTANCE, null, 2, null);
        this.validationManager = C12083g.lazy(new WidgetHubAddName$validationManager$2(this));
    }

    private final void configureUI(AddNameState state) {
        Context context = getContext();
        if (context != null) {
            C12238m.checkNotNullExpressionValue(context, "context ?: return");
            getBinding().f17143f.setIsLoading(state.getChangeNicknameAsync() instanceof Loading);
            getBinding().f17140c.setText(state.getNickname());
            TextView textView = getBinding().f17142e;
            C12238m.checkNotNullExpressionValue(textView, "binding.discordHubAddNameTitle");
            Object[] objArr = new Object[1];
            Guild guild = state.getGuild();
            objArr[0] = guild != null ? guild.getName() : null;
            textView.setText(C1107b.m213e(this, C5419R.string.hub_real_name_modal_header, objArr, (4 & 4) != 0 ? C1107b.a.f1490j : null));
            Guild guild2 = state.getGuild();
            if (guild2 != null) {
                getBinding().f17139b.m8545a(IconUtils.getForGuild$default(state.getGuild(), null, false, null, 14, null), guild2.getShortName());
            }
            RestCallStateKt.handleResponse$default(state.getChangeNicknameAsync(), context, null, null, new C89872(), 6, null);
        }
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void maybeUpdateName() {
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            WidgetHubAddNameViewModel viewModel = getViewModel();
            TextInputEditText textInputEditText = getBinding().f17140c;
            C12238m.checkNotNullExpressionValue(textInputEditText, "binding.discordHubAddNameInput");
            viewModel.setName(String.valueOf(textInputEditText.getText()));
        }
    }

    public final HubAddNameArgs getArgs() {
        return (HubAddNameArgs) this.args.getValue();
    }

    public final WidgetHubAddNameBinding getBinding() {
        return (WidgetHubAddNameBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final WidgetHubAddNameViewModel getViewModel() {
        return (WidgetHubAddNameViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f17143f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.WidgetHubAddName.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetHubAddName.this.maybeUpdateName();
            }
        });
        TextInputEditText textInputEditText = getBinding().f17140c;
        C12238m.checkNotNullExpressionValue(textInputEditText, "binding.discordHubAddNameInput");
        showKeyboard(textInputEditText);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Guild guild = StoreStream.INSTANCE.getGuilds().getGuild(getArgs().getGuildId());
        if (guild == null || !guild.isHub()) {
            FragmentActivity fragmentActivityM95e = m95e();
            if (fragmentActivityM95e != null) {
                fragmentActivityM95e.finish();
            }
            AppLog appLog = AppLog.f14950g;
            StringBuilder sbM833U = C1643a.m833U("Guild id: ");
            sbM833U.append(getArgs().getGuildId());
            Logger.e$default(appLog, "Guild is not a hub", new IllegalStateException(sbM833U.toString()), null, 4, null);
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(ObservableExtensionsKt.m8518ui(getViewModel().observeViewState()), this, null, 2, null), (Class<?>) WidgetHubAddName.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C89891());
    }
}
