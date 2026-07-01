package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetHubAddNameBinding;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallState4;
import com.discord.stores.utilities.RestCallState5;
import com.discord.stores.utilities.RestCallState6;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.textfield.TextInputEditText;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetHubAddName.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddName extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetHubAddName.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubAddNameBinding;", 0)};

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAddName$configureUI$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHubAddName.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<RestCallState6<? extends Void>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState6<? extends Void> restCallState6) {
            invoke2((RestCallState6<Void>) restCallState6);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState6<Void> restCallState6) {
            Intrinsics3.checkNotNullParameter(restCallState6, "it");
            FragmentActivity fragmentActivityE = WidgetHubAddName.this.e();
            if (fragmentActivityE != null) {
                fragmentActivityE.onBackPressed();
            }
            WidgetHubAddName widgetHubAddName = WidgetHubAddName.this;
            widgetHubAddName.hideKeyboard(widgetHubAddName.getView());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAddName$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHubAddName.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetHubAddNameViewModel2, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubAddNameViewModel2 widgetHubAddNameViewModel2) {
            invoke2(widgetHubAddNameViewModel2);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubAddNameViewModel2 widgetHubAddNameViewModel2) {
            Intrinsics3.checkNotNullParameter(widgetHubAddNameViewModel2, "viewState");
            WidgetHubAddName.this.configureUI(widgetHubAddNameViewModel2);
        }
    }

    public WidgetHubAddName() {
        super(R.layout.widget_hub_add_name);
        this.args = LazyJVM.lazy(new WidgetHubAddName$$special$$inlined$args$1(this, "intent_args_key"));
        WidgetHubAddName4 widgetHubAddName4 = new WidgetHubAddName4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetHubAddNameViewModel.class), new WidgetHubAddName$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetHubAddName4));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetHubAddName2.INSTANCE, null, 2, null);
        this.validationManager = LazyJVM.lazy(new WidgetHubAddName3(this));
    }

    private final void configureUI(WidgetHubAddNameViewModel2 state) {
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            getBinding().f.setIsLoading(state.getChangeNicknameAsync() instanceof RestCallState4);
            getBinding().c.setText(state.getNickname());
            TextView textView = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.discordHubAddNameTitle");
            Object[] objArr = new Object[1];
            Guild guild = state.getGuild();
            objArr[0] = guild != null ? guild.getName() : null;
            textView.setText(FormatUtils.e(this, R.string.hub_real_name_modal_header, objArr, (4 & 4) != 0 ? FormatUtils.a.j : null));
            Guild guild2 = state.getGuild();
            if (guild2 != null) {
                getBinding().f2467b.a(IconUtils.getForGuild$default(state.getGuild(), null, false, null, 14, null), guild2.getShortName());
            }
            RestCallState5.handleResponse$default(state.getChangeNicknameAsync(), context, null, null, new AnonymousClass2(), 6, null);
        }
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void maybeUpdateName() {
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            WidgetHubAddNameViewModel viewModel = getViewModel();
            TextInputEditText textInputEditText = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.discordHubAddNameInput");
            viewModel.setName(String.valueOf(textInputEditText.getText()));
        }
    }

    public final WidgetHubAddNameViewModel3 getArgs() {
        return (WidgetHubAddNameViewModel3) this.args.getValue();
    }

    public final WidgetHubAddNameBinding getBinding() {
        return (WidgetHubAddNameBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final WidgetHubAddNameViewModel getViewModel() {
        return (WidgetHubAddNameViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.WidgetHubAddName.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetHubAddName.this.maybeUpdateName();
            }
        });
        TextInputEditText textInputEditText = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.discordHubAddNameInput");
        showKeyboard(textInputEditText);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Guild guild = StoreStream.INSTANCE.getGuilds().getGuild(getArgs().getGuildId());
        if (guild == null || !guild.isHub()) {
            FragmentActivity fragmentActivityE = e();
            if (fragmentActivityE != null) {
                fragmentActivityE.finish();
            }
            AppLog appLog = AppLog.g;
            StringBuilder sbU = outline.U("Guild id: ");
            sbU.append(getArgs().getGuildId());
            Logger.e$default(appLog, "Guild is not a hub", new IllegalStateException(sbU.toString()), null, 4, null);
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(ObservableExtensionsKt.ui(getViewModel().observeViewState()), this, null, 2, null), (Class<?>) WidgetHubAddName.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
