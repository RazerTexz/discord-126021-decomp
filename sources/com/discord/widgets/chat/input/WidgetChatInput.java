package com.discord.widgets.chat.input;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.c;
import b.a.a.c$b;
import b.a.d.f;
import b.a.d.f0;
import b.a.i.t4;
import b.a.i.u4;
import b.a.i.v4;
import b.a.k.b;
import b.a.o.b$b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChatInputBinding;
import com.discord.models.member.GuildMember;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.ShareUtils;
import com.discord.utilities.ShareUtils$SharedContent;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.duration.DurationUtilsKt;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.locale.LocaleManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.ViewVisibilityObserver;
import com.discord.utilities.views.ViewVisibilityObserverProvider;
import com.discord.widgets.announcements.WidgetChannelFollowSheet;
import com.discord.widgets.announcements.WidgetChannelFollowSheet$Companion;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.input.autocomplete.InputAutocomplete;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.notice.WidgetNoticeDialog$Companion;
import com.google.android.material.button.MaterialButton;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.model.Attachment;
import d0.g;
import d0.g0.t;
import d0.z.d.a0;
import d0.z.d.m;
import java.text.NumberFormat;
import java.util.List;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChatInput.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChatInputBinding;", 0)};
    private InputAutocomplete autocomplete;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetChatInputAttachments chatAttachments;
    private WidgetChatInputEditText chatInputEditTextHolder;
    private WidgetChatInputTruncatedHint chatInputTruncatedHint;
    private final Clock clock;

    /* JADX INFO: renamed from: flexInputFragment$delegate, reason: from kotlin metadata */
    private final Lazy flexInputFragment;

    /* JADX INFO: renamed from: flexInputViewModel$delegate, reason: from kotlin metadata */
    private final Lazy flexInputViewModel;
    private final ViewVisibilityObserver inlineVoiceVisibilityObserver;
    private final MessageDraftsRepo messageDraftsRepo;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetChatInput() {
        super(R$layout.widget_chat_input);
        this.binding = FragmentViewBindingDelegateKt.viewBinding(this, WidgetChatInput$binding$2.INSTANCE, new WidgetChatInput$binding$3(this));
        this.inlineVoiceVisibilityObserver = ViewVisibilityObserverProvider.INSTANCE.get(ViewVisibilityObserverProvider.INLINE_VOICE_FEATURE);
        this.messageDraftsRepo = MessageDraftsRepo$Provider.INSTANCE.get();
        this.clock = ClockFactory.get();
        this.flexInputFragment = g.lazy(new WidgetChatInput$flexInputFragment$2(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(ChatInputViewModel.class), new WidgetChatInput$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(WidgetChatInput$viewModel$2.INSTANCE));
        this.flexInputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(AppFlexInputViewModel.class), new WidgetChatInput$appActivityViewModels$$inlined$activityViewModels$3(this), new f0(new WidgetChatInput$flexInputViewModel$2(this)));
    }

    public static final /* synthetic */ void access$configureSendListeners(WidgetChatInput widgetChatInput, ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$Loaded) {
        widgetChatInput.configureSendListeners(chatInputViewModel$ViewState$Loaded);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChatInput widgetChatInput, ChatInputViewModel$ViewState chatInputViewModel$ViewState) {
        widgetChatInput.configureUI(chatInputViewModel$ViewState);
    }

    public static final /* synthetic */ InputAutocomplete access$getAutocomplete$p(WidgetChatInput widgetChatInput) {
        return widgetChatInput.autocomplete;
    }

    public static final /* synthetic */ WidgetChatInputBinding access$getBinding$p(WidgetChatInput widgetChatInput) {
        return widgetChatInput.getBinding();
    }

    public static final /* synthetic */ WidgetChatInputEditText access$getChatInputEditTextHolder$p(WidgetChatInput widgetChatInput) {
        return widgetChatInput.chatInputEditTextHolder;
    }

    public static final /* synthetic */ WidgetChatInputTruncatedHint access$getChatInputTruncatedHint$p(WidgetChatInput widgetChatInput) {
        return widgetChatInput.chatInputTruncatedHint;
    }

    public static final /* synthetic */ FlexInputFragment access$getFlexInputFragment$p(WidgetChatInput widgetChatInput) {
        return widgetChatInput.getFlexInputFragment();
    }

    public static final /* synthetic */ AppFlexInputViewModel access$getFlexInputViewModel$p(WidgetChatInput widgetChatInput) {
        return widgetChatInput.getFlexInputViewModel();
    }

    public static final /* synthetic */ CharSequence access$getHint(WidgetChatInput widgetChatInput, Context context, Channel channel, boolean z2, boolean z3) {
        return widgetChatInput.getHint(context, channel, z2, z3);
    }

    public static final /* synthetic */ ChatInputViewModel access$getViewModel$p(WidgetChatInput widgetChatInput) {
        return widgetChatInput.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetChatInput widgetChatInput, ChatInputViewModel$Event chatInputViewModel$Event) {
        widgetChatInput.handleEvent(chatInputViewModel$Event);
    }

    public static final /* synthetic */ void access$onViewBindingDestroy(WidgetChatInput widgetChatInput, WidgetChatInputBinding widgetChatInputBinding) {
        widgetChatInput.onViewBindingDestroy(widgetChatInputBinding);
    }

    public static final /* synthetic */ void access$setAutocomplete$p(WidgetChatInput widgetChatInput, InputAutocomplete inputAutocomplete) {
        widgetChatInput.autocomplete = inputAutocomplete;
    }

    public static final /* synthetic */ void access$setChatInputEditTextHolder$p(WidgetChatInput widgetChatInput, WidgetChatInputEditText widgetChatInputEditText) {
        widgetChatInput.chatInputEditTextHolder = widgetChatInputEditText;
    }

    public static final /* synthetic */ void access$setChatInputTruncatedHint$p(WidgetChatInput widgetChatInput, WidgetChatInputTruncatedHint widgetChatInputTruncatedHint) {
        widgetChatInput.chatInputTruncatedHint = widgetChatInputTruncatedHint;
    }

    public static final /* synthetic */ void access$setWindowInsetsListeners(WidgetChatInput widgetChatInput, boolean z2) {
        widgetChatInput.setWindowInsetsListeners(z2);
    }

    public static final /* synthetic */ void access$showFollowSheet(WidgetChatInput widgetChatInput, long j, long j2) {
        widgetChatInput.showFollowSheet(j, j2);
    }

    private final void clearInput(Boolean focused, boolean clearText) {
        WidgetChatInputEditText widgetChatInputEditText = this.chatInputEditTextHolder;
        if (widgetChatInputEditText != null) {
            if (clearText) {
                getFlexInputViewModel().onInputTextChanged("", focused);
            }
            getFlexInputViewModel().clean(clearText);
            widgetChatInputEditText.clearLastTypingEmission();
            getViewModel().deleteEditingMessage();
        }
    }

    public static /* synthetic */ void clearInput$default(WidgetChatInput widgetChatInput, Boolean bool, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        widgetChatInput.clearInput(bool, z2);
    }

    private final void configureChatGuard(ChatInputViewModel$ViewState$Loaded viewState) {
        u4 u4Var = getBinding().r;
        m.checkNotNullExpressionValue(u4Var, "binding.guard");
        LinearLayout linearLayout = u4Var.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.guard.root");
        linearLayout.setVisibility(viewState.isLurking() || viewState.isVerificationLevelTriggered() || viewState.isSystemDM() || viewState.getShouldShowFollow() ? 0 : 8);
        v4 v4Var = getBinding().t;
        m.checkNotNullExpressionValue(v4Var, "binding.guardMemberVerification");
        RelativeLayout relativeLayout = v4Var.a;
        m.checkNotNullExpressionValue(relativeLayout, "binding.guardMemberVerification.root");
        u4 u4Var2 = getBinding().r;
        m.checkNotNullExpressionValue(u4Var2, "binding.guard");
        LinearLayout linearLayout2 = u4Var2.a;
        m.checkNotNullExpressionValue(linearLayout2, "binding.guard.root");
        relativeLayout.setVisibility(!(linearLayout2.getVisibility() == 0) && viewState.getShouldShowVerificationGate() ? 0 : 8);
        t4 t4Var = getBinding().f2304s;
        m.checkNotNullExpressionValue(t4Var, "binding.guardCommunicationDisabled");
        RelativeLayout relativeLayout2 = t4Var.a;
        m.checkNotNullExpressionValue(relativeLayout2, "binding.guardCommunicationDisabled.root");
        u4 u4Var3 = getBinding().r;
        m.checkNotNullExpressionValue(u4Var3, "binding.guard");
        LinearLayout linearLayout3 = u4Var3.a;
        m.checkNotNullExpressionValue(linearLayout3, "binding.guard.root");
        relativeLayout2.setVisibility(!(linearLayout3.getVisibility() == 0) && !viewState.getShouldShowVerificationGate() && viewState.isCommunicationDisabled() ? 0 : 8);
        if (viewState.isSystemDM()) {
            getBinding().r.e.setText(2131896162);
            TextView textView = getBinding().r.d;
            m.checkNotNullExpressionValue(textView, "binding.guard.chatInputGuardSubtext");
            ViewExtensions.setTextAndVisibilityBy(textView, getString(2131896163));
            MaterialButton materialButton = getBinding().r.f211b;
            m.checkNotNullExpressionValue(materialButton, "binding.guard.chatInputGuardAction");
            materialButton.setVisibility(8);
            MaterialButton materialButton2 = getBinding().r.c;
            m.checkNotNullExpressionValue(materialButton2, "binding.guard.chatInputGuardActionSecondary");
            materialButton2.setVisibility(8);
            return;
        }
        if (viewState.getShouldShowFollow()) {
            getBinding().r.e.setText(2131889049);
            MaterialButton materialButton3 = getBinding().r.f211b;
            m.checkNotNullExpressionValue(materialButton3, "binding.guard.chatInputGuardAction");
            ViewExtensions.setTextAndVisibilityBy(materialButton3, getString(2131889606));
            getBinding().r.f211b.setOnClickListener(new WidgetChatInput$configureChatGuard$1(this, viewState));
            MaterialButton materialButton4 = getBinding().r.c;
            m.checkNotNullExpressionValue(materialButton4, "binding.guard.chatInputGuardActionSecondary");
            materialButton4.setVisibility(8);
            return;
        }
        if (viewState.isLurking()) {
            if (!viewState.getShouldShowFollow()) {
                getBinding().r.e.setText(2131892659);
                MaterialButton materialButton5 = getBinding().r.f211b;
                m.checkNotNullExpressionValue(materialButton5, "binding.guard.chatInputGuardAction");
                ViewExtensions.setTextAndVisibilityBy(materialButton5, getString(2131892658));
                getBinding().r.f211b.setOnClickListener(new WidgetChatInput$configureChatGuard$4(this));
                MaterialButton materialButton6 = getBinding().r.c;
                m.checkNotNullExpressionValue(materialButton6, "binding.guard.chatInputGuardActionSecondary");
                materialButton6.setVisibility(8);
                return;
            }
            getBinding().r.e.setText(2131889049);
            MaterialButton materialButton7 = getBinding().r.f211b;
            m.checkNotNullExpressionValue(materialButton7, "binding.guard.chatInputGuardAction");
            ViewExtensions.setTextAndVisibilityBy(materialButton7, getString(2131889606));
            getBinding().r.f211b.setOnClickListener(new WidgetChatInput$configureChatGuard$2(this, viewState));
            MaterialButton materialButton8 = getBinding().r.c;
            m.checkNotNullExpressionValue(materialButton8, "binding.guard.chatInputGuardActionSecondary");
            ViewExtensions.setTextAndVisibilityBy(materialButton8, getString(2131892658));
            getBinding().r.c.setOnClickListener(new WidgetChatInput$configureChatGuard$3(this));
            return;
        }
        if (viewState.isCommunicationDisabled()) {
            String strA = f.a.a(360045138571L, null);
            TextView textView2 = getBinding().f2304s.f205b;
            m.checkNotNullExpressionValue(textView2, "binding.guardCommunicati…nicationDisabledGuardText");
            b.n(textView2, 2131889986, new Object[]{strA}, null, 4);
            getBinding().f2304s.f205b.setOnClickListener(new WidgetChatInput$configureChatGuard$5(this, strA));
            TextView textView3 = getBinding().f2304s.c;
            m.checkNotNullExpressionValue(textView3, "binding.guardCommunicati…ionDisabledGuardTimerText");
            textView3.setText(DurationUtilsKt.humanizeCountdownDuration(requireContext(), viewState.getTimeoutLeftMs()));
            return;
        }
        if (!viewState.getShouldShowVerificationGate()) {
            TextView textView4 = getBinding().r.e;
            m.checkNotNullExpressionValue(textView4, "binding.guard.chatInputGuardText");
            textView4.setText(getVerificationText(a.I(getBinding().r.e, "binding.guard.chatInputGuardText", "binding.guard.chatInputGuardText.context"), viewState.getVerificationLevelTriggered()));
            MaterialButton materialButton9 = getBinding().r.f211b;
            m.checkNotNullExpressionValue(materialButton9, "binding.guard.chatInputGuardAction");
            MaterialButton materialButton10 = getBinding().r.f211b;
            m.checkNotNullExpressionValue(materialButton10, "binding.guard.chatInputGuardAction");
            Context context = materialButton10.getContext();
            m.checkNotNullExpressionValue(context, "binding.guard.chatInputGuardAction.context");
            ViewExtensions.setTextAndVisibilityBy(materialButton9, getVerificationActionText(context, viewState.getVerificationLevelTriggered()));
            getBinding().r.f211b.setOnClickListener(new WidgetChatInput$configureChatGuard$8(this));
            MaterialButton materialButton11 = getBinding().r.c;
            m.checkNotNullExpressionValue(materialButton11, "binding.guard.chatInputGuardActionSecondary");
            materialButton11.setVisibility(8);
            return;
        }
        getBinding().t.f218b.setOnClickListener(new WidgetChatInput$configureChatGuard$6(this, viewState));
        ApplicationStatus joinRequestStatus = viewState.getJoinRequestStatus();
        if (joinRequestStatus != null) {
            int iOrdinal = joinRequestStatus.ordinal();
            if (iOrdinal == 1) {
                ImageView imageView = getBinding().t.c;
                m.checkNotNullExpressionValue(imageView, "binding.guardMemberVerif…erVerificationGuardAction");
                imageView.setVisibility(8);
                MaterialButton materialButton12 = getBinding().t.d;
                m.checkNotNullExpressionValue(materialButton12, "binding.guardMemberVerif…erVerificationGuardButton");
                materialButton12.setVisibility(0);
                getBinding().t.f.setText(2131892798);
                getBinding().t.e.setImageResource(2131232391);
                getBinding().t.c.setImageResource(2131231680);
                getBinding().t.d.setOnClickListener(new WidgetChatInput$configureChatGuard$7(this, viewState));
                return;
            }
            if (iOrdinal == 2) {
                MaterialButton materialButton13 = getBinding().t.d;
                m.checkNotNullExpressionValue(materialButton13, "binding.guardMemberVerif…erVerificationGuardButton");
                materialButton13.setVisibility(8);
                ImageView imageView2 = getBinding().t.c;
                m.checkNotNullExpressionValue(imageView2, "binding.guardMemberVerif…erVerificationGuardAction");
                imageView2.setVisibility(0);
                getBinding().t.f.setText(2131892804);
                getBinding().t.e.setImageResource(2131232390);
                getBinding().t.c.setImageResource(2131231530);
                return;
            }
        }
        MaterialButton materialButton14 = getBinding().t.d;
        m.checkNotNullExpressionValue(materialButton14, "binding.guardMemberVerif…erVerificationGuardButton");
        materialButton14.setVisibility(8);
        ImageView imageView3 = getBinding().t.c;
        m.checkNotNullExpressionValue(imageView3, "binding.guardMemberVerif…erVerificationGuardAction");
        imageView3.setVisibility(0);
        getBinding().t.f.setText(2131892813);
        getBinding().t.e.setImageResource(2131232392);
        getBinding().t.c.setImageResource(2131231530);
    }

    private final void configureContextBar(ChatInputViewModel$ViewState$Loaded viewState) {
        if (viewState.isEditing()) {
            configureContextBarEditing();
        } else {
            if (viewState.getPendingReplyState() instanceof ChatInputViewModel$ViewState$Loaded$PendingReplyState$Replying) {
                configureContextBarReplying((ChatInputViewModel$ViewState$Loaded$PendingReplyState$Replying) viewState.getPendingReplyState());
                return;
            }
            RelativeLayout relativeLayout = getBinding().e;
            m.checkNotNullExpressionValue(relativeLayout, "binding.chatInputContextBar");
            relativeLayout.setVisibility(8);
        }
    }

    private final void configureContextBarEditing() {
        RelativeLayout relativeLayout = getBinding().e;
        m.checkNotNullExpressionValue(relativeLayout, "binding.chatInputContextBar");
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = getBinding().e;
        m.checkNotNullExpressionValue(relativeLayout2, "binding.chatInputContextBar");
        relativeLayout2.setClickable(false);
        getBinding().g.setText(2131888645);
        getBinding().f.setOnClickListener(new WidgetChatInput$configureContextBarEditing$1(this));
        LinearLayout linearLayout = getBinding().h;
        m.checkNotNullExpressionValue(linearLayout, "binding.chatInputContextReplyMentionButton");
        linearLayout.setVisibility(8);
    }

    private final void configureContextBarReplying(ChatInputViewModel$ViewState$Loaded$PendingReplyState$Replying model) {
        String username;
        Context contextRequireContext = requireContext();
        RelativeLayout relativeLayout = getBinding().e;
        m.checkNotNullExpressionValue(relativeLayout, "binding.chatInputContextBar");
        relativeLayout.setVisibility(0);
        GuildMember repliedAuthorGuildMember = model.getRepliedAuthorGuildMember();
        if (repliedAuthorGuildMember == null || (username = repliedAuthorGuildMember.getNick()) == null) {
            username = model.getRepliedAuthor().getUsername();
        }
        TextView textView = getBinding().g;
        m.checkNotNullExpressionValue(textView, "binding.chatInputContextDescription");
        b.m(textView, 2131893034, new Object[]{username}, new WidgetChatInput$configureContextBarReplying$1(contextRequireContext, model));
        getBinding().e.setOnClickListener(new WidgetChatInput$configureContextBarReplying$2(this, model));
        getBinding().f.setOnClickListener(new WidgetChatInput$configureContextBarReplying$3(this));
        LinearLayout linearLayout = getBinding().h;
        m.checkNotNullExpressionValue(linearLayout, "binding.chatInputContextReplyMentionButton");
        linearLayout.setVisibility(model.getShowMentionToggle() ? 0 : 8);
        getBinding().h.setOnClickListener(new WidgetChatInput$configureContextBarReplying$4(this));
        int themedColor = model.getShouldMention() ? ColorCompat.getThemedColor(contextRequireContext, 2130968972) : ColorCompat.getThemedColor(contextRequireContext, 2130969056);
        ImageView imageView = getBinding().i;
        m.checkNotNullExpressionValue(imageView, "binding.chatInputContextReplyMentionButtonImage");
        ColorCompatKt.tintWithColor(imageView, themedColor);
        getBinding().j.setTextColor(themedColor);
        getBinding().j.setText(model.getShouldMention() ? 2131894767 : 2131894765);
    }

    private final void configureInitialText(ChatInputViewModel$ViewState$Loaded viewState) {
        String string;
        getFlexInputViewModel().hideExpressionTray();
        if (viewState.isEditing() && viewState.getEditingMessage() != null) {
            getFlexInputViewModel().onInputTextChanged(viewState.getEditingMessage().getContent().toString(), Boolean.TRUE);
            return;
        }
        CharSequence textChannelInput = this.messageDraftsRepo.getTextChannelInput(viewState.getChannelId());
        AppFlexInputViewModel flexInputViewModel = getFlexInputViewModel();
        if (textChannelInput == null || (string = textChannelInput.toString()) == null) {
            string = "";
        }
        flexInputViewModel.onInputTextChanged(string, (viewState.isEditing() || viewState.isReplying()) ? Boolean.TRUE : null);
    }

    private final void configureSendListeners(ChatInputViewModel$ViewState$Loaded viewState) {
        WidgetChatInputEditText widgetChatInputEditText = this.chatInputEditTextHolder;
        if (widgetChatInputEditText != null) {
            Context contextRequireContext = requireContext();
            MessageManager messageManager = new MessageManager(contextRequireContext, null, null, null, null, null, null, null, null, 510, null);
            WidgetChatInput$configureSendListeners$1 widgetChatInput$configureSendListeners$1 = new WidgetChatInput$configureSendListeners$1(this, contextRequireContext, messageManager);
            WidgetChatInput$configureSendListeners$3 widgetChatInput$configureSendListeners$3 = new WidgetChatInput$configureSendListeners$3(this, widgetChatInput$configureSendListeners$1, new WidgetChatInput$configureSendListeners$2(this, widgetChatInputEditText, contextRequireContext, messageManager));
            WidgetChatInput$configureSendListeners$4 widgetChatInput$configureSendListeners$4 = new WidgetChatInput$configureSendListeners$4(contextRequireContext);
            boolean z2 = widgetChatInputEditText.getChannelId() != viewState.getChannelId();
            widgetChatInputEditText.setChannelId(viewState.getChannelId(), z2);
            InputAutocomplete inputAutocomplete = this.autocomplete;
            if (inputAutocomplete != null) {
                inputAutocomplete.setOnPerformCommandAutocomplete(new WidgetChatInput$configureSendListeners$5(this, widgetChatInput$configureSendListeners$1));
            }
            widgetChatInputEditText.setOnSendListener(new WidgetChatInput$configureSendListeners$6(this, widgetChatInput$configureSendListeners$3));
            if (z2) {
                configureInitialText(viewState);
            }
            configureText(viewState);
            WidgetChatInputAttachments widgetChatInputAttachments = this.chatAttachments;
            if (widgetChatInputAttachments == null) {
                m.throwUninitializedPropertyAccessException("chatAttachments");
            }
            widgetChatInputAttachments.setInputListener(new WidgetChatInput$configureSendListeners$7(this, viewState, widgetChatInput$configureSendListeners$4, widgetChatInput$configureSendListeners$3));
        }
    }

    private final void configureText(ChatInputViewModel$ViewState$Loaded viewState) {
        if (viewState.getAbleToSendMessage()) {
            return;
        }
        b.i.a.f.e.o.f.P0(getFlexInputViewModel(), "", null, 2, null);
    }

    private final void configureUI(ChatInputViewModel$ViewState viewState) {
        if (!(viewState instanceof ChatInputViewModel$ViewState$Loading)) {
            if (viewState instanceof ChatInputViewModel$ViewState$Loaded) {
                WidgetChatInputAttachments widgetChatInputAttachments = this.chatAttachments;
                if (widgetChatInputAttachments == null) {
                    m.throwUninitializedPropertyAccessException("chatAttachments");
                }
                ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$Loaded = (ChatInputViewModel$ViewState$Loaded) viewState;
                widgetChatInputAttachments.configureFlexInputContentPages(chatInputViewModel$ViewState$Loaded.getShowCreateThreadOption());
                LinearLayout linearLayout = getBinding().q;
                m.checkNotNullExpressionValue(linearLayout, "binding.chatInputWrap");
                linearLayout.setVisibility(chatInputViewModel$ViewState$Loaded.isInputShowing() ? 0 : 8);
                configureChatGuard(chatInputViewModel$ViewState$Loaded);
                getFlexInputFragment().i(new WidgetChatInput$configureUI$1(this, viewState));
                configureContextBar(chatInputViewModel$ViewState$Loaded);
                getFlexInputViewModel().setShowExpressionTrayButtonBadge(chatInputViewModel$ViewState$Loaded.getShouldBadgeChatInput());
                return;
            }
            return;
        }
        LinearLayout linearLayout2 = getBinding().q;
        m.checkNotNullExpressionValue(linearLayout2, "binding.chatInputWrap");
        linearLayout2.setVisibility(8);
        v4 v4Var = getBinding().t;
        m.checkNotNullExpressionValue(v4Var, "binding.guardMemberVerification");
        RelativeLayout relativeLayout = v4Var.a;
        m.checkNotNullExpressionValue(relativeLayout, "binding.guardMemberVerification.root");
        relativeLayout.setVisibility(8);
        t4 t4Var = getBinding().f2304s;
        m.checkNotNullExpressionValue(t4Var, "binding.guardCommunicationDisabled");
        RelativeLayout relativeLayout2 = t4Var.a;
        m.checkNotNullExpressionValue(relativeLayout2, "binding.guardCommunicationDisabled.root");
        relativeLayout2.setVisibility(8);
        u4 u4Var = getBinding().r;
        m.checkNotNullExpressionValue(u4Var, "binding.guard");
        LinearLayout linearLayout3 = u4Var.a;
        m.checkNotNullExpressionValue(linearLayout3, "binding.guard.root");
        linearLayout3.setVisibility(8);
    }

    private final WidgetChatInputBinding getBinding() {
        return (WidgetChatInputBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final FlexInputFragment getFlexInputFragment() {
        return (FlexInputFragment) this.flexInputFragment.getValue();
    }

    private final AppFlexInputViewModel getFlexInputViewModel() {
        return (AppFlexInputViewModel) this.flexInputViewModel.getValue();
    }

    private final CharSequence getHint(Context context, Channel channel, boolean isBlocked, boolean hasSendMessagePermissions) {
        if (isBlocked) {
            String string = context.getString(2131888576);
            m.checkNotNullExpressionValue(string, "context.getString(R.stri…erification_text_blocked)");
            return string;
        }
        if (hasSendMessagePermissions) {
            return b.h(context, 2131896324, new Object[]{ChannelUtils.e(channel, context, false, 2)}, null, 4);
        }
        String string2 = context.getString(2131893282);
        m.checkNotNullExpressionValue(string2, "context.getString(R.stri…s_permission_placeholder)");
        return string2;
    }

    private final String getVerificationActionText(Context context, GuildVerificationLevel verificationLevelTriggered) {
        int iOrdinal = verificationLevelTriggered.ordinal();
        if (iOrdinal == 1) {
            return context.getString(2131897060);
        }
        if (iOrdinal != 4) {
            return null;
        }
        return context.getString(2131897072);
    }

    private final CharSequence getVerificationText(Context context, GuildVerificationLevel verificationLevelTriggered) {
        int iOrdinal = verificationLevelTriggered.ordinal();
        if (iOrdinal == 1) {
            return context.getString(2131891682);
        }
        if (iOrdinal == 2) {
            return b.h(context, 2131891680, new Object[]{"5"}, null, 4);
        }
        if (iOrdinal == 3) {
            return b.h(context, 2131891681, new Object[]{"10"}, null, 4);
        }
        if (iOrdinal != 4) {
            return null;
        }
        return context.getString(2131891683);
    }

    private final ChatInputViewModel getViewModel() {
        return (ChatInputViewModel) this.viewModel.getValue();
    }

    @SuppressLint({"StringFormatMatches"})
    private final void handleEvent(ChatInputViewModel$Event event) {
        Unit unit = null;
        if (event instanceof ChatInputViewModel$Event$FilesTooLarge) {
            getFlexInputViewModel().hideKeyboard();
            c$b c_b = c.k;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            ChatInputViewModel$Event$FilesTooLarge chatInputViewModel$Event$FilesTooLarge = (ChatInputViewModel$Event$FilesTooLarge) event;
            float currentFileSizeMB = chatInputViewModel$Event$FilesTooLarge.getCurrentFileSizeMB();
            float maxAttachmentSizeMB = chatInputViewModel$Event$FilesTooLarge.getMaxAttachmentSizeMB();
            c_b.a(parentFragmentManager, chatInputViewModel$Event$FilesTooLarge.isUserPremium(), chatInputViewModel$Event$FilesTooLarge.getMaxFileSizeMB(), maxAttachmentSizeMB, currentFileSizeMB, new WidgetChatInput$handleEvent$1(this, event), chatInputViewModel$Event$FilesTooLarge.getAttachments().size(), chatInputViewModel$Event$FilesTooLarge.getHasImage(), chatInputViewModel$Event$FilesTooLarge.getHasVideo(), chatInputViewModel$Event$FilesTooLarge.getHasGif());
            clearInput$default(this, null, false, 1, null);
            unit = Unit.a;
        } else if (event instanceof ChatInputViewModel$Event$MessageTooLong) {
            getFlexInputViewModel().hideKeyboard();
            NumberFormat numberInstance = NumberFormat.getNumberInstance(new LocaleManager().getPrimaryLocale(requireContext()));
            WidgetNoticeDialog$Companion widgetNoticeDialog$Companion = WidgetNoticeDialog.Companion;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            ChatInputViewModel$Event$MessageTooLong chatInputViewModel$Event$MessageTooLong = (ChatInputViewModel$Event$MessageTooLong) event;
            WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion, parentFragmentManager2, getString(2131892975), b.k(this, 2131892974, new Object[]{numberInstance.format(Integer.valueOf(chatInputViewModel$Event$MessageTooLong.getCurrentCharacterCount())), numberInstance.format(Integer.valueOf(chatInputViewModel$Event$MessageTooLong.getMaxCharacterCount()))}, null, 4), getString(2131893499), null, null, null, null, null, null, null, null, 0, null, 16368, null);
            unit = Unit.a;
        } else if (event instanceof ChatInputViewModel$Event$EmptyThreadName) {
            getFlexInputViewModel().hideKeyboard();
            WidgetNoticeDialog$Companion widgetNoticeDialog$Companion2 = WidgetNoticeDialog.Companion;
            FragmentManager parentFragmentManager3 = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager3, "parentFragmentManager");
            WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion2, parentFragmentManager3, null, b.k(this, 2131889314, new Object[0], null, 4), getString(2131893499), null, null, null, null, null, null, null, null, 0, null, 16370, null);
            unit = Unit.a;
        } else if (event instanceof ChatInputViewModel$Event$FailedDeliveryToRecipient) {
            getFlexInputViewModel().hideKeyboard();
            WidgetNoticeDialog$Companion widgetNoticeDialog$Companion3 = WidgetNoticeDialog.Companion;
            FragmentManager parentFragmentManager4 = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager4, "parentFragmentManager");
            WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion3, parentFragmentManager4, getString(2131888880), b.k(this, 2131887273, new Object[]{f.a.a(360060145013L, null)}, null, 4), getString(2131893499), null, null, null, null, null, null, null, null, 0, null, 16368, null);
            unit = Unit.a;
        } else if (event instanceof ChatInputViewModel$Event$AppendChatText) {
            getFlexInputViewModel().onInputTextAppended(((ChatInputViewModel$Event$AppendChatText) event).getText());
            unit = Unit.a;
        } else if (event instanceof ChatInputViewModel$Event$SetChatText) {
            getFlexInputViewModel().hideExpressionTray();
            getFlexInputViewModel().onInputTextChanged(((ChatInputViewModel$Event$SetChatText) event).getText(), Boolean.TRUE);
            unit = Unit.a;
        } else if (event instanceof ChatInputViewModel$Event$CommandInputsInvalid) {
            InputAutocomplete inputAutocomplete = this.autocomplete;
            if (inputAutocomplete != null) {
                inputAutocomplete.onCommandInputsSendError();
                unit = Unit.a;
            }
        } else if (event instanceof ChatInputViewModel$Event$ShowPremiumUpsell) {
            b.a.a.b.c$b c_b2 = b.a.a.b.c.k;
            FragmentManager parentFragmentManager5 = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager5, "parentFragmentManager");
            ChatInputViewModel$Event$ShowPremiumUpsell chatInputViewModel$Event$ShowPremiumUpsell = (ChatInputViewModel$Event$ShowPremiumUpsell) event;
            b.a.a.b.c$b.a(c_b2, parentFragmentManager5, chatInputViewModel$Event$ShowPremiumUpsell.getPage(), getString(chatInputViewModel$Event$ShowPremiumUpsell.getHeaderResId()), getString(chatInputViewModel$Event$ShowPremiumUpsell.getBodyResId()), null, null, null, null, chatInputViewModel$Event$ShowPremiumUpsell.getShowOtherPages(), chatInputViewModel$Event$ShowPremiumUpsell.getShowLearnMore(), 240);
            unit = Unit.a;
        } else {
            if (!(event instanceof ChatInputViewModel$Event$ThreadDraftClosed)) {
                throw new NoWhenBranchMatchedException();
            }
            getFlexInputViewModel().hideKeyboard();
            clearInput$default(this, null, false, 3, null);
            unit = Unit.a;
        }
        KotlinExtensionsKt.getExhaustive(unit);
    }

    private final void onViewBindingDestroy(WidgetChatInputBinding binding) {
        b.a.o.b bVarA = b$b.a();
        LinearLayout linearLayout = binding.q;
        m.checkNotNullExpressionValue(linearLayout, "binding.chatInputWrap");
        bVarA.c(linearLayout);
    }

    private final void populateDirectShareData() {
        ContentResolver contentResolver;
        List<Uri> uris;
        Long directShareId = IntentUtils.INSTANCE.getDirectShareId(getMostRecentIntent());
        if (directShareId != null) {
            long jLongValue = directShareId.longValue();
            boolean z2 = true;
            ShareUtils$SharedContent sharedContent = ShareUtils.INSTANCE.getSharedContent(getMostRecentIntent(), true);
            CharSequence text = sharedContent.getText();
            if (text != null && !t.isBlank(text)) {
                z2 = false;
            }
            if (!z2) {
                this.messageDraftsRepo.setTextChannelInput(jLongValue, sharedContent.getText().toString());
            }
            Context context = getContext();
            if (context == null || (contentResolver = context.getContentResolver()) == null || (uris = sharedContent.getUris()) == null) {
                return;
            }
            for (Uri uri : uris) {
                WidgetChatInputAttachments widgetChatInputAttachments = this.chatAttachments;
                if (widgetChatInputAttachments == null) {
                    m.throwUninitializedPropertyAccessException("chatAttachments");
                }
                widgetChatInputAttachments.addExternalAttachment(Attachment.Companion.b(uri, contentResolver));
            }
        }
    }

    private final void setWindowInsetsListeners(boolean shouldApplyWindowInsets) {
        LinearLayout linearLayout = getBinding().q;
        m.checkNotNullExpressionValue(linearLayout, "binding.chatInputWrap");
        ViewExtensions.setForwardingWindowInsetsListener(linearLayout);
        FragmentContainerView fragmentContainerView = getBinding().p;
        m.checkNotNullExpressionValue(fragmentContainerView, "binding.chatInputWidget");
        ViewExtensions.setForwardingWindowInsetsListener(fragmentContainerView);
        u4 u4Var = getBinding().r;
        m.checkNotNullExpressionValue(u4Var, "binding.guard");
        ViewCompat.setOnApplyWindowInsetsListener(u4Var.a, WidgetChatInput$setWindowInsetsListeners$1.INSTANCE);
        v4 v4Var = getBinding().t;
        m.checkNotNullExpressionValue(v4Var, "binding.guardMemberVerification");
        ViewCompat.setOnApplyWindowInsetsListener(v4Var.a, WidgetChatInput$setWindowInsetsListeners$2.INSTANCE);
        t4 t4Var = getBinding().f2304s;
        m.checkNotNullExpressionValue(t4Var, "binding.guardCommunicationDisabled");
        ViewCompat.setOnApplyWindowInsetsListener(t4Var.a, WidgetChatInput$setWindowInsetsListeners$3.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().d, new WidgetChatInput$setWindowInsetsListeners$4(this, shouldApplyWindowInsets));
        getBinding().d.requestApplyInsets();
    }

    public static /* synthetic */ void setWindowInsetsListeners$default(WidgetChatInput widgetChatInput, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        widgetChatInput.setWindowInsetsListeners(z2);
    }

    private final void showFollowSheet(long channelId, long guildId) {
        WidgetChannelFollowSheet$Companion widgetChannelFollowSheet$Companion = WidgetChannelFollowSheet.Companion;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetChannelFollowSheet$Companion.show(parentFragmentManager, channelId, guildId);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        WidgetChatInputAttachments widgetChatInputAttachments = new WidgetChatInputAttachments(getFlexInputFragment());
        this.chatAttachments = widgetChatInputAttachments;
        if (widgetChatInputAttachments == null) {
            m.throwUninitializedPropertyAccessException("chatAttachments");
        }
        widgetChatInputAttachments.configureFlexInputFragment(this);
        getFlexInputFragment().i(new WidgetChatInput$onViewBound$1(this));
        b.a.o.b bVarA = b$b.a();
        LinearLayout linearLayout = getBinding().q;
        m.checkNotNullExpressionValue(linearLayout, "binding.chatInputWrap");
        bVarA.b(linearLayout);
        setWindowInsetsListeners$default(this, false, 1, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        populateDirectShareData();
        WidgetChatInputTruncatedHint widgetChatInputTruncatedHint = this.chatInputTruncatedHint;
        if (widgetChatInputTruncatedHint != null) {
            widgetChatInputTruncatedHint.addBindedTextWatcher(this);
        }
        Observable<ChatInputViewModel$ViewState> observableR = getViewModel().observeChatInputViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetChatInput.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChatInput$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetChatInput.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChatInput$onViewBoundOrOnResume$2(this), 62, (Object) null);
        WidgetChatInputAttachments widgetChatInputAttachments = this.chatAttachments;
        if (widgetChatInputAttachments == null) {
            m.throwUninitializedPropertyAccessException("chatAttachments");
        }
        widgetChatInputAttachments.setViewModel(getFlexInputViewModel());
        InputAutocomplete inputAutocomplete = this.autocomplete;
        if (inputAutocomplete != null) {
            inputAutocomplete.onViewBoundOrOnResume();
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(this.inlineVoiceVisibilityObserver.observeIsVisible(), this, null, 2, null), WidgetChatInput.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChatInput$onViewBoundOrOnResume$3(this), 62, (Object) null);
    }
}
