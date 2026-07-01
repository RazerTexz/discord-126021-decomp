package com.discord.widgets.chat.list.sheet;

import android.content.Context;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.commands.ApplicationCommandData;
import com.discord.api.commands.ApplicationCommandData3;
import com.discord.api.user.User;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetApplicationCommandBottomSheetBinding;
import com.discord.models.commands.Application;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheet extends AppBottomSheet {
    public static final String ARG_MESSAGE_NONCE = "arg_message_nonce";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetApplicationCommandBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetApplicationCommandBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long interactionId, long messageId, long channelId, Long guildId, long userId, long applicationId, String messageNonce) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            boolean z2 = false;
            Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2021-03_android_app_slash_commands_bottom_sheet_disabled", false);
            if (userExperiment != null && userExperiment.getBucket() == 1) {
                z2 = true;
            }
            if (z2) {
                return;
            }
            WidgetApplicationCommandBottomSheet widgetApplicationCommandBottomSheet = new WidgetApplicationCommandBottomSheet();
            Bundle bundleT = outline.T("com.discord.intent.extra.EXTRA_INTERACTION_ID", interactionId);
            bundleT.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            bundleT.putLong("com.discord.intent.extra.EXTRA_MESSAGE_ID", messageId);
            if (guildId != null) {
                bundleT.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId.longValue());
            }
            bundleT.putLong("com.discord.intent.extra.EXTRA_USER_ID", userId);
            bundleT.putLong("com.discord.intent.extra.EXTRA_APPLICATION_ID", applicationId);
            bundleT.putString(WidgetApplicationCommandBottomSheet.ARG_MESSAGE_NONCE, messageNonce);
            widgetApplicationCommandBottomSheet.setArguments(bundleT);
            widgetApplicationCommandBottomSheet.show(fragmentManager, WidgetApplicationCommandBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetApplicationCommandBottomSheetViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetApplicationCommandBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetApplicationCommandBottomSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetApplicationCommandBottomSheet.this.configureUI(viewState);
        }
    }

    public WidgetApplicationCommandBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetApplicationCommandBottomSheet2.INSTANCE, null, 2, null);
        WidgetApplicationCommandBottomSheet4 widgetApplicationCommandBottomSheet4 = new WidgetApplicationCommandBottomSheet4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetApplicationCommandBottomSheetViewModel.class), new WidgetApplicationCommandBottomSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetApplicationCommandBottomSheet4));
    }

    private final void configureCommandTitle(WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded viewState) {
        String name;
        String nick;
        User bot;
        StringBuilder sbQ = outline.Q(MentionUtils.SLASH_CHAR);
        sbQ.append(viewState.getApplicationCommandData().getName());
        String string = sbQ.toString();
        Application application = viewState.getApplication();
        String username = null;
        if (application == null || (bot = application.getBot()) == null || (name = bot.getUsername()) == null) {
            Application application2 = viewState.getApplication();
            name = application2 != null ? application2.getName() : null;
        }
        int themedColor = ColorCompat.getThemedColor(requireContext(), R.attr.colorTextNormal);
        Application application3 = viewState.getApplication();
        if (application3 != null) {
            SimpleDraweeView simpleDraweeView = getBinding().f2226b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.commandBottomSheetCommandAvatar");
            IconUtils.setApplicationIcon(simpleDraweeView, application3);
        }
        TextView textView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.commandBottomSheetCommandTitle");
        Object[] objArr = new Object[2];
        GuildMember interactionUser = viewState.getInteractionUser();
        if (interactionUser == null || (nick = interactionUser.getNick()) == null) {
            com.discord.models.user.User user = viewState.getUser();
            if (user != null) {
                username = user.getUsername();
            }
        } else {
            username = nick;
        }
        objArr[0] = username;
        objArr[1] = string;
        CharSequence charSequenceD = FormatUtils.d(textView, R.string.system_message_application_command_used_as_title, objArr, new WidgetApplicationCommandBottomSheet3(this, viewState, themedColor));
        TextView textView2 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.commandBottomSheetCommandTitle");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView3 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.commandBottomSheetCommandTitle");
        textView3.setText(charSequenceD);
        TextView textView4 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.commandBottomShe…mmandTitleApplicationName");
        textView4.setVisibility(name != null ? 0 : 8);
        TextView textView5 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.commandBottomShe…mmandTitleApplicationName");
        textView5.setText(name);
    }

    private final void configureSlashCommandString(WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded viewState) {
        ApplicationCommandData applicationCommandData = viewState.getApplicationCommandData();
        List<ApplicationCommandData3> listB = viewState.getApplicationCommandData().b();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        StringBuilder sbQ = outline.Q(MentionUtils.SLASH_CHAR);
        sbQ.append(applicationCommandData.getName());
        sbQ.append(' ');
        spannableStringBuilder.append((CharSequence) sbQ.toString());
        if (listB != null) {
            Iterator<T> it = listB.iterator();
            while (it.hasNext()) {
                spannableStringBuilder.append((CharSequence) configureSlashCommandString(viewState, (ApplicationCommandData3) it.next()));
            }
        }
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.commandBottomSheetCommandContent");
        textView.setText(spannableStringBuilder);
    }

    private final Spannable configureSlashCommandStringOptions(WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded viewState, ApplicationCommandData3 option) {
        Integer valueColor;
        int themedColor = ColorCompat.getThemedColor(this, R.attr.colorHeaderPrimary);
        WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam slashCommandParam = viewState.getCommandValues().get(option.getName());
        if ((slashCommandParam != null ? slashCommandParam.getValueColor() : null) != null && ((valueColor = slashCommandParam.getValueColor()) == null || valueColor.intValue() != 0)) {
            themedColor = slashCommandParam.getValueColor().intValue();
        }
        String value = slashCommandParam != null ? slashCommandParam.getValue() : null;
        SpannableStringBuilder spannableStringBuilderAppend = new SpannableStringBuilder().append((CharSequence) option.getName());
        if (!(value == null || StringsJVM.isBlank(value))) {
            SpannableStringBuilder spannableStringBuilderAppend2 = spannableStringBuilderAppend.append((CharSequence) ": ");
            Intrinsics3.checkNotNullExpressionValue(spannableStringBuilderAppend2, "builder.append(\": \")");
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(themedColor);
            int length = spannableStringBuilderAppend2.length();
            spannableStringBuilderAppend2.append((CharSequence) (value + ' '));
            spannableStringBuilderAppend2.setSpan(foregroundColorSpan, length, spannableStringBuilderAppend2.length(), 17);
        }
        Intrinsics3.checkNotNullExpressionValue(spannableStringBuilderAppend, "builder");
        return spannableStringBuilderAppend;
    }

    private final void configureUI(WidgetApplicationCommandBottomSheetViewModel.ViewState viewState) {
        boolean z2 = viewState instanceof WidgetApplicationCommandBottomSheetViewModel.ViewState.Loading;
        ProgressBar progressBar = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.commandBottomSheetCommandLoader");
        progressBar.setVisibility(z2 ? 0 : 8);
        MaterialButton materialButton = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.commandBottomSheetCommandCopyButton");
        materialButton.setEnabled(!z2);
        if (!(viewState instanceof WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded)) {
            if (viewState instanceof WidgetApplicationCommandBottomSheetViewModel.ViewState.Failed) {
                dismiss();
            }
        } else {
            MaterialButton materialButton2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.commandBottomSheetCommandCopyButton");
            materialButton2.setEnabled(true);
            configureLoaded((WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded) viewState);
        }
    }

    private final WidgetApplicationCommandBottomSheetBinding getBinding() {
        return (WidgetApplicationCommandBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetApplicationCommandBottomSheetViewModel getViewModel() {
        return (WidgetApplicationCommandBottomSheetViewModel) this.viewModel.getValue();
    }

    public final void configureLoaded(final WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        configureCommandTitle(viewState);
        configureSlashCommandString(viewState);
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet.configureLoaded.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Context contextRequireContext = WidgetApplicationCommandBottomSheet.this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                AppToast.c(contextRequireContext, WidgetApplicationCommandBottomSheet5.toSlashCommandCopyString(viewState.getApplicationCommandData(), viewState.getCommandValues()), 0, 4);
                WidgetApplicationCommandBottomSheet.this.dismiss();
            }
        });
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_application_command_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AppBottomSheet.hideKeyboard$default(this, null, 1, null);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetApplicationCommandBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    private final Spannable configureSlashCommandString(WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded viewState, ApplicationCommandData3 option) {
        List<ApplicationCommandData3> listC = option.c();
        if (listC == null || listC.isEmpty()) {
            return configureSlashCommandStringOptions(viewState, option);
        }
        SpannableStringBuilder spannableStringBuilderAppend = new SpannableStringBuilder().append((CharSequence) (option.getName() + ' '));
        List<ApplicationCommandData3> listC2 = option.c();
        if (listC2 != null) {
            Iterator<T> it = listC2.iterator();
            while (it.hasNext()) {
                spannableStringBuilderAppend.append((CharSequence) configureSlashCommandString(viewState, (ApplicationCommandData3) it.next()));
            }
        }
        return spannableStringBuilderAppend;
    }
}
