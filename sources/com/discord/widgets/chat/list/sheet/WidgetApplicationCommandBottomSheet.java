package com.discord.widgets.chat.list.sheet;

import android.content.Context;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.commands.ApplicationCommandData;
import com.discord.api.commands.ApplicationCommandValue;
import com.discord.api.user.User;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetApplicationCommandBottomSheetBinding;
import com.discord.models.commands.Application;
import com.discord.models.member.GuildMember;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.g0.t;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheet extends AppBottomSheet {
    public static final String ARG_MESSAGE_NONCE = "arg_message_nonce";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetApplicationCommandBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetApplicationCommandBottomSheetBinding;", 0)};
    public static final WidgetApplicationCommandBottomSheet$Companion Companion = new WidgetApplicationCommandBottomSheet$Companion(null);

    public WidgetApplicationCommandBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetApplicationCommandBottomSheet$binding$2.INSTANCE, null, 2, null);
        WidgetApplicationCommandBottomSheet$viewModel$2 widgetApplicationCommandBottomSheet$viewModel$2 = new WidgetApplicationCommandBottomSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetApplicationCommandBottomSheetViewModel.class), new WidgetApplicationCommandBottomSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetApplicationCommandBottomSheet$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetApplicationCommandBottomSheet widgetApplicationCommandBottomSheet, WidgetApplicationCommandBottomSheetViewModel$ViewState widgetApplicationCommandBottomSheetViewModel$ViewState) {
        widgetApplicationCommandBottomSheet.configureUI(widgetApplicationCommandBottomSheetViewModel$ViewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetApplicationCommandBottomSheet widgetApplicationCommandBottomSheet) {
        return widgetApplicationCommandBottomSheet.getArgumentsOrDefault();
    }

    private final void configureCommandTitle(WidgetApplicationCommandBottomSheetViewModel$ViewState$Loaded viewState) {
        String name;
        String nick;
        User bot;
        StringBuilder sbQ = a.Q(MentionUtilsKt.SLASH_CHAR);
        sbQ.append(viewState.getApplicationCommandData().getName());
        String string = sbQ.toString();
        Application application = viewState.getApplication();
        String username = null;
        if (application == null || (bot = application.getBot()) == null || (name = bot.getUsername()) == null) {
            Application application2 = viewState.getApplication();
            name = application2 != null ? application2.getName() : null;
        }
        int themedColor = ColorCompat.getThemedColor(requireContext(), 2130969057);
        Application application3 = viewState.getApplication();
        if (application3 != null) {
            SimpleDraweeView simpleDraweeView = getBinding().f2226b;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.commandBottomSheetCommandAvatar");
            IconUtils.setApplicationIcon(simpleDraweeView, application3);
        }
        TextView textView = getBinding().f;
        m.checkNotNullExpressionValue(textView, "binding.commandBottomSheetCommandTitle");
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
        CharSequence charSequenceD = b.d(textView, 2131896170, objArr, new WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1(this, viewState, themedColor));
        TextView textView2 = getBinding().f;
        m.checkNotNullExpressionValue(textView2, "binding.commandBottomSheetCommandTitle");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView3 = getBinding().f;
        m.checkNotNullExpressionValue(textView3, "binding.commandBottomSheetCommandTitle");
        textView3.setText(charSequenceD);
        TextView textView4 = getBinding().g;
        m.checkNotNullExpressionValue(textView4, "binding.commandBottomShe…mmandTitleApplicationName");
        textView4.setVisibility(name != null ? 0 : 8);
        TextView textView5 = getBinding().g;
        m.checkNotNullExpressionValue(textView5, "binding.commandBottomShe…mmandTitleApplicationName");
        textView5.setText(name);
    }

    private final void configureSlashCommandString(WidgetApplicationCommandBottomSheetViewModel$ViewState$Loaded viewState) {
        ApplicationCommandData applicationCommandData = viewState.getApplicationCommandData();
        List<ApplicationCommandValue> listB = viewState.getApplicationCommandData().b();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        StringBuilder sbQ = a.Q(MentionUtilsKt.SLASH_CHAR);
        sbQ.append(applicationCommandData.getName());
        sbQ.append(' ');
        spannableStringBuilder.append((CharSequence) sbQ.toString());
        if (listB != null) {
            Iterator<T> it = listB.iterator();
            while (it.hasNext()) {
                spannableStringBuilder.append((CharSequence) configureSlashCommandString(viewState, (ApplicationCommandValue) it.next()));
            }
        }
        TextView textView = getBinding().c;
        m.checkNotNullExpressionValue(textView, "binding.commandBottomSheetCommandContent");
        textView.setText(spannableStringBuilder);
    }

    private final Spannable configureSlashCommandStringOptions(WidgetApplicationCommandBottomSheetViewModel$ViewState$Loaded viewState, ApplicationCommandValue option) {
        Integer valueColor;
        int themedColor = ColorCompat.getThemedColor(this, 2130968989);
        WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam widgetApplicationCommandBottomSheetViewModel$SlashCommandParam = viewState.getCommandValues().get(option.getName());
        if ((widgetApplicationCommandBottomSheetViewModel$SlashCommandParam != null ? widgetApplicationCommandBottomSheetViewModel$SlashCommandParam.getValueColor() : null) != null && ((valueColor = widgetApplicationCommandBottomSheetViewModel$SlashCommandParam.getValueColor()) == null || valueColor.intValue() != 0)) {
            themedColor = widgetApplicationCommandBottomSheetViewModel$SlashCommandParam.getValueColor().intValue();
        }
        String value = widgetApplicationCommandBottomSheetViewModel$SlashCommandParam != null ? widgetApplicationCommandBottomSheetViewModel$SlashCommandParam.getValue() : null;
        SpannableStringBuilder spannableStringBuilderAppend = new SpannableStringBuilder().append((CharSequence) option.getName());
        if (!(value == null || t.isBlank(value))) {
            SpannableStringBuilder spannableStringBuilderAppend2 = spannableStringBuilderAppend.append((CharSequence) ": ");
            m.checkNotNullExpressionValue(spannableStringBuilderAppend2, "builder.append(\": \")");
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(themedColor);
            int length = spannableStringBuilderAppend2.length();
            spannableStringBuilderAppend2.append((CharSequence) (value + ' '));
            spannableStringBuilderAppend2.setSpan(foregroundColorSpan, length, spannableStringBuilderAppend2.length(), 17);
        }
        m.checkNotNullExpressionValue(spannableStringBuilderAppend, "builder");
        return spannableStringBuilderAppend;
    }

    private final void configureUI(WidgetApplicationCommandBottomSheetViewModel$ViewState viewState) {
        boolean z2 = viewState instanceof WidgetApplicationCommandBottomSheetViewModel$ViewState$Loading;
        ProgressBar progressBar = getBinding().e;
        m.checkNotNullExpressionValue(progressBar, "binding.commandBottomSheetCommandLoader");
        progressBar.setVisibility(z2 ? 0 : 8);
        MaterialButton materialButton = getBinding().d;
        m.checkNotNullExpressionValue(materialButton, "binding.commandBottomSheetCommandCopyButton");
        materialButton.setEnabled(!z2);
        if (!(viewState instanceof WidgetApplicationCommandBottomSheetViewModel$ViewState$Loaded)) {
            if (viewState instanceof WidgetApplicationCommandBottomSheetViewModel$ViewState$Failed) {
                dismiss();
            }
        } else {
            MaterialButton materialButton2 = getBinding().d;
            m.checkNotNullExpressionValue(materialButton2, "binding.commandBottomSheetCommandCopyButton");
            materialButton2.setEnabled(true);
            configureLoaded((WidgetApplicationCommandBottomSheetViewModel$ViewState$Loaded) viewState);
        }
    }

    private final WidgetApplicationCommandBottomSheetBinding getBinding() {
        return (WidgetApplicationCommandBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetApplicationCommandBottomSheetViewModel getViewModel() {
        return (WidgetApplicationCommandBottomSheetViewModel) this.viewModel.getValue();
    }

    public final void configureLoaded(WidgetApplicationCommandBottomSheetViewModel$ViewState$Loaded viewState) {
        m.checkNotNullParameter(viewState, "viewState");
        configureCommandTitle(viewState);
        configureSlashCommandString(viewState);
        getBinding().d.setOnClickListener(new WidgetApplicationCommandBottomSheet$configureLoaded$1(this, viewState));
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_application_command_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AppBottomSheet.hideKeyboard$default(this, null, 1, null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetApplicationCommandBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetApplicationCommandBottomSheet$onResume$1(this), 62, (Object) null);
    }

    private final Spannable configureSlashCommandString(WidgetApplicationCommandBottomSheetViewModel$ViewState$Loaded viewState, ApplicationCommandValue option) {
        List<ApplicationCommandValue> listC = option.c();
        if (listC == null || listC.isEmpty()) {
            return configureSlashCommandStringOptions(viewState, option);
        }
        SpannableStringBuilder spannableStringBuilderAppend = new SpannableStringBuilder().append((CharSequence) (option.getName() + ' '));
        List<ApplicationCommandValue> listC2 = option.c();
        if (listC2 != null) {
            Iterator<T> it = listC2.iterator();
            while (it.hasNext()) {
                spannableStringBuilderAppend.append((CharSequence) configureSlashCommandString(viewState, (ApplicationCommandValue) it.next()));
            }
        }
        return spannableStringBuilderAppend;
    }
}
