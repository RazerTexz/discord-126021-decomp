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
import com.discord.C5419R;
import com.discord.api.commands.ApplicationCommandData;
import com.discord.api.commands.ApplicationCommandValue;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheet extends AppBottomSheet {
    public static final String ARG_MESSAGE_NONCE = "arg_message_nonce";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetApplicationCommandBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetApplicationCommandBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long interactionId, long messageId, long channelId, Long guildId, long userId, long applicationId, String messageNonce) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            boolean z2 = false;
            Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2021-03_android_app_slash_commands_bottom_sheet_disabled", false);
            if (userExperiment != null && userExperiment.getBucket() == 1) {
                z2 = true;
            }
            if (z2) {
                return;
            }
            WidgetApplicationCommandBottomSheet widgetApplicationCommandBottomSheet = new WidgetApplicationCommandBottomSheet();
            Bundle bundleM832T = C1643a.m832T("com.discord.intent.extra.EXTRA_INTERACTION_ID", interactionId);
            bundleM832T.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            bundleM832T.putLong("com.discord.intent.extra.EXTRA_MESSAGE_ID", messageId);
            if (guildId != null) {
                bundleM832T.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId.longValue());
            }
            bundleM832T.putLong("com.discord.intent.extra.EXTRA_USER_ID", userId);
            bundleM832T.putLong("com.discord.intent.extra.EXTRA_APPLICATION_ID", applicationId);
            bundleM832T.putString(WidgetApplicationCommandBottomSheet.ARG_MESSAGE_NONCE, messageNonce);
            widgetApplicationCommandBottomSheet.setArguments(bundleM832T);
            widgetApplicationCommandBottomSheet.show(fragmentManager, WidgetApplicationCommandBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet$onResume$1 */
    /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
    public static final class C81661 extends AbstractC12240o implements Function1<WidgetApplicationCommandBottomSheetViewModel.ViewState, Unit> {
        public C81661() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetApplicationCommandBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetApplicationCommandBottomSheetViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            WidgetApplicationCommandBottomSheet.this.configureUI(viewState);
        }
    }

    public WidgetApplicationCommandBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetApplicationCommandBottomSheet$binding$2.INSTANCE, null, 2, null);
        WidgetApplicationCommandBottomSheet$viewModel$2 widgetApplicationCommandBottomSheet$viewModel$2 = new WidgetApplicationCommandBottomSheet$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetApplicationCommandBottomSheetViewModel.class), new C8163xa0238236(c0865g0), new C0869i0(widgetApplicationCommandBottomSheet$viewModel$2));
    }

    private final void configureCommandTitle(WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded viewState) {
        String name;
        String nick;
        User bot;
        StringBuilder sbM829Q = C1643a.m829Q(MentionUtilsKt.SLASH_CHAR);
        sbM829Q.append(viewState.getApplicationCommandData().getName());
        String string = sbM829Q.toString();
        Application application = viewState.getApplication();
        String username = null;
        if (application == null || (bot = application.getBot()) == null || (name = bot.getUsername()) == null) {
            Application application2 = viewState.getApplication();
            name = application2 != null ? application2.getName() : null;
        }
        int themedColor = ColorCompat.getThemedColor(requireContext(), C5419R.attr.colorTextNormal);
        Application application3 = viewState.getApplication();
        if (application3 != null) {
            SimpleDraweeView simpleDraweeView = getBinding().f15651b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.commandBottomSheetCommandAvatar");
            IconUtils.setApplicationIcon(simpleDraweeView, application3);
        }
        TextView textView = getBinding().f15655f;
        C12238m.checkNotNullExpressionValue(textView, "binding.commandBottomSheetCommandTitle");
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
        CharSequence charSequenceM212d = C1107b.m212d(textView, C5419R.string.system_message_application_command_used_as_title, objArr, new C8164x8e57eda6(this, viewState, themedColor));
        TextView textView2 = getBinding().f15655f;
        C12238m.checkNotNullExpressionValue(textView2, "binding.commandBottomSheetCommandTitle");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView3 = getBinding().f15655f;
        C12238m.checkNotNullExpressionValue(textView3, "binding.commandBottomSheetCommandTitle");
        textView3.setText(charSequenceM212d);
        TextView textView4 = getBinding().f15656g;
        C12238m.checkNotNullExpressionValue(textView4, "binding.commandBottomShe…mmandTitleApplicationName");
        textView4.setVisibility(name != null ? 0 : 8);
        TextView textView5 = getBinding().f15656g;
        C12238m.checkNotNullExpressionValue(textView5, "binding.commandBottomShe…mmandTitleApplicationName");
        textView5.setText(name);
    }

    private final void configureSlashCommandString(WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded viewState) {
        ApplicationCommandData applicationCommandData = viewState.getApplicationCommandData();
        List<ApplicationCommandValue> listM7725b = viewState.getApplicationCommandData().m7725b();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        StringBuilder sbM829Q = C1643a.m829Q(MentionUtilsKt.SLASH_CHAR);
        sbM829Q.append(applicationCommandData.getName());
        sbM829Q.append(' ');
        spannableStringBuilder.append((CharSequence) sbM829Q.toString());
        if (listM7725b != null) {
            Iterator<T> it = listM7725b.iterator();
            while (it.hasNext()) {
                spannableStringBuilder.append((CharSequence) configureSlashCommandString(viewState, (ApplicationCommandValue) it.next()));
            }
        }
        TextView textView = getBinding().f15652c;
        C12238m.checkNotNullExpressionValue(textView, "binding.commandBottomSheetCommandContent");
        textView.setText(spannableStringBuilder);
    }

    private final Spannable configureSlashCommandStringOptions(WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded viewState, ApplicationCommandValue option) {
        Integer valueColor;
        int themedColor = ColorCompat.getThemedColor(this, C5419R.attr.colorHeaderPrimary);
        WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam slashCommandParam = viewState.getCommandValues().get(option.getName());
        if ((slashCommandParam != null ? slashCommandParam.getValueColor() : null) != null && ((valueColor = slashCommandParam.getValueColor()) == null || valueColor.intValue() != 0)) {
            themedColor = slashCommandParam.getValueColor().intValue();
        }
        String value = slashCommandParam != null ? slashCommandParam.getValue() : null;
        SpannableStringBuilder spannableStringBuilderAppend = new SpannableStringBuilder().append((CharSequence) option.getName());
        if (!(value == null || C12103t.isBlank(value))) {
            SpannableStringBuilder spannableStringBuilderAppend2 = spannableStringBuilderAppend.append((CharSequence) ": ");
            C12238m.checkNotNullExpressionValue(spannableStringBuilderAppend2, "builder.append(\": \")");
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(themedColor);
            int length = spannableStringBuilderAppend2.length();
            spannableStringBuilderAppend2.append((CharSequence) (value + ' '));
            spannableStringBuilderAppend2.setSpan(foregroundColorSpan, length, spannableStringBuilderAppend2.length(), 17);
        }
        C12238m.checkNotNullExpressionValue(spannableStringBuilderAppend, "builder");
        return spannableStringBuilderAppend;
    }

    private final void configureUI(WidgetApplicationCommandBottomSheetViewModel.ViewState viewState) {
        boolean z2 = viewState instanceof WidgetApplicationCommandBottomSheetViewModel.ViewState.Loading;
        ProgressBar progressBar = getBinding().f15654e;
        C12238m.checkNotNullExpressionValue(progressBar, "binding.commandBottomSheetCommandLoader");
        progressBar.setVisibility(z2 ? 0 : 8);
        MaterialButton materialButton = getBinding().f15653d;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.commandBottomSheetCommandCopyButton");
        materialButton.setEnabled(!z2);
        if (!(viewState instanceof WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded)) {
            if (viewState instanceof WidgetApplicationCommandBottomSheetViewModel.ViewState.Failed) {
                dismiss();
            }
        } else {
            MaterialButton materialButton2 = getBinding().f15653d;
            C12238m.checkNotNullExpressionValue(materialButton2, "binding.commandBottomSheetCommandCopyButton");
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
        C12238m.checkNotNullParameter(viewState, "viewState");
        configureCommandTitle(viewState);
        configureSlashCommandString(viewState);
        getBinding().f15653d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet.configureLoaded.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Context contextRequireContext = WidgetApplicationCommandBottomSheet.this.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                C0876m.m165c(contextRequireContext, WidgetApplicationCommandBottomSheetKt.toSlashCommandCopyString(viewState.getApplicationCommandData(), viewState.getCommandValues()), 0, 4);
                WidgetApplicationCommandBottomSheet.this.dismiss();
            }
        });
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_application_command_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AppBottomSheet.hideKeyboard$default(this, null, 1, null);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetApplicationCommandBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C81661());
    }

    private final Spannable configureSlashCommandString(WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded viewState, ApplicationCommandValue option) {
        List<ApplicationCommandValue> listM7741c = option.m7741c();
        if (listM7741c == null || listM7741c.isEmpty()) {
            return configureSlashCommandStringOptions(viewState, option);
        }
        SpannableStringBuilder spannableStringBuilderAppend = new SpannableStringBuilder().append((CharSequence) (option.getName() + ' '));
        List<ApplicationCommandValue> listM7741c2 = option.m7741c();
        if (listM7741c2 != null) {
            Iterator<T> it = listM7741c2.iterator();
            while (it.hasNext()) {
                spannableStringBuilderAppend.append((CharSequence) configureSlashCommandString(viewState, (ApplicationCommandValue) it.next()));
            }
        }
        return spannableStringBuilderAppend;
    }
}
