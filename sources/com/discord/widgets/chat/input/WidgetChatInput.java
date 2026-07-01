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
import androidx.annotation.StringRes;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.ImageUploadFailedDialog;
import b.a.a.b.MultiValuePropPremiumUpsellDialog;
import b.a.d.AppHelpDesk;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates2;
import b.a.i.WidgetChatInputCommunicationDisabledGuardBinding;
import b.a.i.WidgetChatInputGuardBinding;
import b.a.i.WidgetChatInputMemberVerificationGuardBinding;
import b.a.k.FormatUtils;
import b.a.o.PanelsChildGestureRegionObserver;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChatInputApplicationCommandsBinding;
import com.discord.databinding.WidgetChatInputBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.models.member.GuildMember;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.ShareUtils;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.duration.DurationUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.locale.LocaleManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.ViewVisibilityObserver;
import com.discord.utilities.views.ViewVisibilityObserverProvider;
import com.discord.widgets.announcements.WidgetChannelFollowSheet;
import com.discord.widgets.chat.MessageContent;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.input.ChatInputViewModel;
import com.discord.widgets.chat.input.MessageDraftsRepo;
import com.discord.widgets.chat.input.autocomplete.InputAutocomplete;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.discord.widgets.chat.input.models.ApplicationCommandValue;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.google.android.material.button.MaterialButton;
import com.lytefast.flexinput.FlexInputListener;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.widget.FlexEditText;
import d0.LazyJVM;
import d0.d0._Ranges;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChatInput.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChatInputBinding;", 0)};
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

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            ApplicationStatus.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[ApplicationStatus.REJECTED.ordinal()] = 1;
            iArr[ApplicationStatus.PENDING.ordinal()] = 2;
            GuildVerificationLevel.values();
            int[] iArr2 = new int[5];
            $EnumSwitchMapping$1 = iArr2;
            GuildVerificationLevel guildVerificationLevel = GuildVerificationLevel.LOW;
            iArr2[guildVerificationLevel.ordinal()] = 1;
            iArr2[GuildVerificationLevel.MEDIUM.ordinal()] = 2;
            iArr2[GuildVerificationLevel.HIGH.ordinal()] = 3;
            GuildVerificationLevel guildVerificationLevel2 = GuildVerificationLevel.HIGHEST;
            iArr2[guildVerificationLevel2.ordinal()] = 4;
            GuildVerificationLevel.values();
            int[] iArr3 = new int[5];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[guildVerificationLevel.ordinal()] = 1;
            iArr3[guildVerificationLevel2.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureContextBarReplying$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ ChatInputViewModel.ViewState.Loaded.PendingReplyState.Replying $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, ChatInputViewModel.ViewState.Loaded.PendingReplyState.Replying replying) {
            super(1);
            this.$context = context;
            this.$model = replying;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.boldColor = Integer.valueOf(GuildMember.INSTANCE.getColor(this.$model.getRepliedAuthorGuildMember(), ColorCompat.getThemedColor(this.$context, R.attr.colorHeaderPrimary)));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final class AnonymousClass1 extends Lambda implements Function4<ApplicationCommandData, Map<ApplicationCommandOption, ? extends Attachment<?>>, Boolean, Function1<? super Boolean, ? extends Unit>, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ MessageManager $messageManager;

        /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetChatInput.kt */
        public static final class C02521 extends Lambda implements Function1<Boolean, Unit> {
            public static final C02521 INSTANCE = new C02521();

            public C02521() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.a;
            }

            public final void invoke(boolean z2) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, MessageManager messageManager) {
            super(4);
            this.$context = context;
            this.$messageManager = messageManager;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void invoke$default(AnonymousClass1 anonymousClass1, ApplicationCommandData applicationCommandData, Map map, boolean z2, Function1 function1, int i, Object obj) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            if ((i & 8) != 0) {
                function1 = C02521.INSTANCE;
            }
            anonymousClass1.invoke(applicationCommandData, (Map<ApplicationCommandOption, ? extends Attachment<?>>) map, z2, (Function1<? super Boolean, Unit>) function1);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(ApplicationCommandData applicationCommandData, Map<ApplicationCommandOption, ? extends Attachment<?>> map, Boolean bool, Function1<? super Boolean, ? extends Unit> function1) {
            invoke(applicationCommandData, map, bool.booleanValue(), (Function1<? super Boolean, Unit>) function1);
            return Unit.a;
        }

        public final void invoke(ApplicationCommandData applicationCommandData, Map<ApplicationCommandOption, ? extends Attachment<?>> map, boolean z2, Function1<? super Boolean, Unit> function1) {
            Intrinsics3.checkNotNullParameter(applicationCommandData, "applicationCommandData");
            Intrinsics3.checkNotNullParameter(map, "attachments");
            Intrinsics3.checkNotNullParameter(function1, "onValidationResult");
            WidgetChatInput.this.getViewModel().sendCommand(this.$context, this.$messageManager, applicationCommandData, map, z2, false, function1);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final class AnonymousClass2 extends Lambda implements Function3<List<? extends Attachment<?>>, ApplicationCommandData, Function1<? super Boolean, ? extends Unit>, Unit> {
        public final /* synthetic */ WidgetChatInputEditText $chatInput;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ MessageManager $messageManager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(WidgetChatInputEditText widgetChatInputEditText, Context context, MessageManager messageManager) {
            super(3);
            this.$chatInput = widgetChatInputEditText;
            this.$context = context;
            this.$messageManager = messageManager;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Attachment<?>> list, ApplicationCommandData applicationCommandData, Function1<? super Boolean, ? extends Unit> function1) {
            invoke2(list, applicationCommandData, (Function1<? super Boolean, Unit>) function1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends Attachment<?>> list, ApplicationCommandData applicationCommandData, Function1<? super Boolean, Unit> function1) {
            MessageContent messageContent;
            MessageContent messageContent2;
            ApplicationCommand applicationCommand;
            String strInvoke;
            Intrinsics3.checkNotNullParameter(list, "attachmentsRaw");
            Intrinsics3.checkNotNullParameter(function1, "onValidationResult");
            InputAutocomplete inputAutocomplete = WidgetChatInput.this.autocomplete;
            if (inputAutocomplete == null || (messageContent = inputAutocomplete.getInputContent()) == null) {
                messageContent = new MessageContent(this.$chatInput.getText(), Collections2.emptyList());
            }
            if (applicationCommandData == null || (applicationCommand = applicationCommandData.getApplicationCommand()) == null || !applicationCommand.getBuiltIn()) {
                messageContent2 = messageContent;
            } else {
                ApplicationCommand applicationCommand2 = applicationCommandData.getApplicationCommand();
                List<ApplicationCommandValue> values = applicationCommandData.getValues();
                LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(values, 10)), 16));
                for (Object obj : values) {
                    linkedHashMap.put(((ApplicationCommandValue) obj).getName(), obj);
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsJVM.mapCapacity(linkedHashMap.size()));
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    linkedHashMap2.put(entry.getKey(), ((ApplicationCommandValue) entry.getValue()).getValue());
                }
                WidgetChatInput.this.getViewModel().onCommandUsed(applicationCommandData);
                Function1<Map<String, ? extends Object>, String> execute = applicationCommand2.getExecute();
                if (execute == null || (strInvoke = execute.invoke(linkedHashMap2)) == null) {
                    strInvoke = "";
                }
                messageContent2 = new MessageContent(strInvoke, messageContent.getMentionedUsers());
            }
            WidgetChatInput.this.getViewModel().sendMessage(this.$context, this.$messageManager, messageContent2, list, (16 & 16) != 0 ? false : false, function1);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final class AnonymousClass3 extends Lambda implements Function2<List<? extends Attachment<?>>, Function1<? super Boolean, ? extends Unit>, Unit> {
        public final /* synthetic */ AnonymousClass1 $sendCommand$1;
        public final /* synthetic */ AnonymousClass2 $sendMessage$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AnonymousClass1 anonymousClass1, AnonymousClass2 anonymousClass2) {
            super(2);
            this.$sendCommand$1 = anonymousClass1;
            this.$sendMessage$2 = anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Attachment<?>> list, Function1<? super Boolean, ? extends Unit> function1) {
            invoke2(list, (Function1<? super Boolean, Unit>) function1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends Attachment<?>> list, Function1<? super Boolean, Unit> function1) {
            Intrinsics3.checkNotNullParameter(list, "attachmentsRaw");
            Intrinsics3.checkNotNullParameter(function1, "onValidationResult");
            InputAutocomplete inputAutocomplete = WidgetChatInput.this.autocomplete;
            ApplicationCommandData applicationCommandData$default = inputAutocomplete != null ? InputAutocomplete.getApplicationCommandData$default(inputAutocomplete, null, 1, null) : null;
            if (applicationCommandData$default != null && !applicationCommandData$default.getValidInputs()) {
                WidgetChatInput.this.getViewModel().onCommandInputsInvalid();
                return;
            }
            if (applicationCommandData$default == null || applicationCommandData$default.getApplicationCommand().getBuiltIn()) {
                this.$sendMessage$2.invoke2(list, applicationCommandData$default, function1);
                return;
            }
            AnonymousClass1 anonymousClass1 = this.$sendCommand$1;
            InputAutocomplete inputAutocomplete2 = WidgetChatInput.this.autocomplete;
            Map<ApplicationCommandOption, Attachment<?>> commandAttachments = inputAutocomplete2 != null ? inputAutocomplete2.getCommandAttachments() : null;
            if (commandAttachments == null) {
                commandAttachments = Maps6.emptyMap();
            }
            anonymousClass1.invoke(applicationCommandData$default, (Map<ApplicationCommandOption, ? extends Attachment<?>>) commandAttachments, false, function1);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<Integer, Boolean> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
            return Boolean.valueOf(invoke(num.intValue()));
        }

        public final boolean invoke(@StringRes int i) {
            AppToast.g(this.$context, i, 0, null, 12);
            return false;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<ApplicationCommandOption, Unit> {
        public final /* synthetic */ AnonymousClass1 $sendCommand$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(AnonymousClass1 anonymousClass1) {
            super(1);
            this.$sendCommand$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ApplicationCommandOption applicationCommandOption) {
            invoke2(applicationCommandOption);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ApplicationCommandOption applicationCommandOption) {
            Intrinsics3.checkNotNullParameter(applicationCommandOption, "it");
            InputAutocomplete inputAutocomplete = WidgetChatInput.this.autocomplete;
            ApplicationCommandData applicationCommandData = inputAutocomplete != null ? inputAutocomplete.getApplicationCommandData(applicationCommandOption) : null;
            if (applicationCommandData != null) {
                AnonymousClass1.invoke$default(this.$sendCommand$1, applicationCommandData, Maps6.emptyMap(), true, null, 8, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$6, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final class AnonymousClass6 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AnonymousClass3 $trySend$3;

        /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$6$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChatInput.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.a;
            }

            public final void invoke(boolean z2) {
                if (z2) {
                    WidgetChatInput.clearInput$default(WidgetChatInput.this, null, false, 3, null);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(AnonymousClass3 anonymousClass3) {
            super(0);
            this.$trySend$3 = anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$trySend$3.invoke2(Collections2.emptyList(), (Function1<? super Boolean, Unit>) new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureUI$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ChatInputViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ChatInputViewModel.ViewState viewState) {
            super(0);
            this.$viewState = viewState;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetChatInputTruncatedHint widgetChatInputTruncatedHint = WidgetChatInput.this.chatInputTruncatedHint;
            if (widgetChatInputTruncatedHint != null) {
                WidgetChatInput widgetChatInput = WidgetChatInput.this;
                widgetChatInputTruncatedHint.setHint(widgetChatInput.getHint(widgetChatInput.requireContext(), ((ChatInputViewModel.ViewState.Loaded) this.$viewState).getChannel(), ((ChatInputViewModel.ViewState.Loaded) this.$viewState).isBlocked(), ((ChatInputViewModel.ViewState.Loaded) this.$viewState).getAbleToSendMessage()));
            }
            WidgetChatInput.this.configureSendListeners((ChatInputViewModel.ViewState.Loaded) this.$viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$handleEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ChatInputViewModel.Event $event;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ChatInputViewModel.Event event) {
            super(0);
            this.$event = event;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Function0<Unit> onResendCompressed = ((ChatInputViewModel.Event.FilesTooLarge) this.$event).getOnResendCompressed();
            if (onResendCompressed != null) {
                onResendCompressed.invoke();
            }
            WidgetChatInput.clearInput$default(WidgetChatInput.this, null, true, 1, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FlexEditText flexEditTextL = WidgetChatInput.this.getFlexInputFragment().l();
            WidgetChatInput widgetChatInput = WidgetChatInput.this;
            FlexInputFragment flexInputFragment = widgetChatInput.getFlexInputFragment();
            AppFlexInputViewModel flexInputViewModel = WidgetChatInput.this.getFlexInputViewModel();
            TextView textView = WidgetChatInput.this.getBinding().k;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatInputEmojiMatchingHeader");
            RecyclerView recyclerView = WidgetChatInput.this.getBinding().l;
            Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.chatInputMentionsRecycler");
            RecyclerView recyclerView2 = WidgetChatInput.this.getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.chatInputCategoriesRecycler");
            LinearLayout linearLayout = WidgetChatInput.this.getBinding().m;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.chatInputStickersContainer");
            RecyclerView recyclerView3 = WidgetChatInput.this.getBinding().o;
            Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.chatInputStickersRecycler");
            TextView textView2 = WidgetChatInput.this.getBinding().n;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatInputStickersMatchingHeader");
            WidgetChatInputApplicationCommandsBinding widgetChatInputApplicationCommandsBinding = WidgetChatInput.this.getBinding().f2303b;
            Intrinsics3.checkNotNullExpressionValue(widgetChatInputApplicationCommandsBinding, "binding.applicationCommandsRoot");
            InputAutocomplete inputAutocomplete = new InputAutocomplete(widgetChatInput, flexInputFragment, flexInputViewModel, flexEditTextL, null, textView, recyclerView, recyclerView2, linearLayout, recyclerView3, textView2, widgetChatInputApplicationCommandsBinding);
            WidgetChatInput.this.autocomplete = inputAutocomplete;
            inputAutocomplete.onViewBoundOrOnResume();
            WidgetChatInput.this.chatInputEditTextHolder = new WidgetChatInputEditText(flexEditTextL, null, 2, 0 == true ? 1 : 0);
            WidgetChatInput.this.chatInputTruncatedHint = new WidgetChatInputTruncatedHint(flexEditTextL);
            WidgetChatInputTruncatedHint widgetChatInputTruncatedHint = WidgetChatInput.this.chatInputTruncatedHint;
            if (widgetChatInputTruncatedHint != null) {
                widgetChatInputTruncatedHint.addBindedTextWatcher(WidgetChatInput.this);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ChatInputViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetChatInput widgetChatInput) {
            super(1, widgetChatInput, WidgetChatInput.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/input/ChatInputViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChatInputViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChatInputViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetChatInput) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<ChatInputViewModel.Event, Unit> {
        public AnonymousClass2(WidgetChatInput widgetChatInput) {
            super(1, widgetChatInput, WidgetChatInput.class, "handleEvent", "handleEvent(Lcom/discord/widgets/chat/input/ChatInputViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChatInputViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChatInputViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            ((WidgetChatInput) this.receiver).handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$onViewBoundOrOnResume$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Boolean, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            WidgetChatInput.this.setWindowInsetsListeners(!z2);
        }
    }

    public WidgetChatInput() {
        super(R.layout.widget_chat_input);
        this.binding = FragmentViewBindingDelegate3.viewBinding(this, WidgetChatInput2.INSTANCE, new WidgetChatInput3(this));
        this.inlineVoiceVisibilityObserver = ViewVisibilityObserverProvider.INSTANCE.get(ViewVisibilityObserverProvider.INLINE_VOICE_FEATURE);
        this.messageDraftsRepo = MessageDraftsRepo.Provider.INSTANCE.get();
        this.clock = ClockFactory.get();
        this.flexInputFragment = LazyJVM.lazy(new WidgetChatInput4(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ChatInputViewModel.class), new WidgetChatInput$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetChatInput6.INSTANCE));
        this.flexInputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(AppFlexInputViewModel.class), new WidgetChatInput$appActivityViewModels$$inlined$activityViewModels$3(this), new AppViewModelDelegates2(new WidgetChatInput5(this)));
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

    private final void configureChatGuard(final ChatInputViewModel.ViewState.Loaded viewState) {
        WidgetChatInputGuardBinding widgetChatInputGuardBinding = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputGuardBinding, "binding.guard");
        LinearLayout linearLayout = widgetChatInputGuardBinding.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.guard.root");
        linearLayout.setVisibility(viewState.isLurking() || viewState.isVerificationLevelTriggered() || viewState.isSystemDM() || viewState.getShouldShowFollow() ? 0 : 8);
        WidgetChatInputMemberVerificationGuardBinding widgetChatInputMemberVerificationGuardBinding = getBinding().t;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputMemberVerificationGuardBinding, "binding.guardMemberVerification");
        RelativeLayout relativeLayout = widgetChatInputMemberVerificationGuardBinding.a;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.guardMemberVerification.root");
        WidgetChatInputGuardBinding widgetChatInputGuardBinding2 = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputGuardBinding2, "binding.guard");
        LinearLayout linearLayout2 = widgetChatInputGuardBinding2.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.guard.root");
        relativeLayout.setVisibility(!(linearLayout2.getVisibility() == 0) && viewState.getShouldShowVerificationGate() ? 0 : 8);
        WidgetChatInputCommunicationDisabledGuardBinding widgetChatInputCommunicationDisabledGuardBinding = getBinding().f2304s;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputCommunicationDisabledGuardBinding, "binding.guardCommunicationDisabled");
        RelativeLayout relativeLayout2 = widgetChatInputCommunicationDisabledGuardBinding.a;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout2, "binding.guardCommunicationDisabled.root");
        WidgetChatInputGuardBinding widgetChatInputGuardBinding3 = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputGuardBinding3, "binding.guard");
        LinearLayout linearLayout3 = widgetChatInputGuardBinding3.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.guard.root");
        relativeLayout2.setVisibility(!(linearLayout3.getVisibility() == 0) && !viewState.getShouldShowVerificationGate() && viewState.isCommunicationDisabled() ? 0 : 8);
        if (viewState.isSystemDM()) {
            getBinding().r.e.setText(R.string.system_dm_channel_description);
            TextView textView = getBinding().r.d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guard.chatInputGuardSubtext");
            ViewExtensions.setTextAndVisibilityBy(textView, getString(R.string.system_dm_channel_description_subtext));
            MaterialButton materialButton = getBinding().r.f211b;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guard.chatInputGuardAction");
            materialButton.setVisibility(8);
            MaterialButton materialButton2 = getBinding().r.c;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.guard.chatInputGuardActionSecondary");
            materialButton2.setVisibility(8);
            return;
        }
        if (viewState.getShouldShowFollow()) {
            getBinding().r.e.setText(R.string.follow_news_chat_input_message);
            MaterialButton materialButton3 = getBinding().r.f211b;
            Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.guard.chatInputGuardAction");
            ViewExtensions.setTextAndVisibilityBy(materialButton3, getString(R.string.game_popout_follow));
            getBinding().r.f211b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureChatGuard.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetChatInput.this.showFollowSheet(viewState.getChannel().getId(), viewState.getChannel().getGuildId());
                }
            });
            MaterialButton materialButton4 = getBinding().r.c;
            Intrinsics3.checkNotNullExpressionValue(materialButton4, "binding.guard.chatInputGuardActionSecondary");
            materialButton4.setVisibility(8);
            return;
        }
        if (viewState.isLurking()) {
            if (!viewState.getShouldShowFollow()) {
                getBinding().r.e.setText(R.string.lurker_mode_chat_input_message);
                MaterialButton materialButton5 = getBinding().r.f211b;
                Intrinsics3.checkNotNullExpressionValue(materialButton5, "binding.guard.chatInputGuardAction");
                ViewExtensions.setTextAndVisibilityBy(materialButton5, getString(R.string.lurker_mode_chat_input_button));
                getBinding().r.f211b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureChatGuard.4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WidgetChatInput.this.getViewModel().lurkGuild(WidgetChatInput.this);
                    }
                });
                MaterialButton materialButton6 = getBinding().r.c;
                Intrinsics3.checkNotNullExpressionValue(materialButton6, "binding.guard.chatInputGuardActionSecondary");
                materialButton6.setVisibility(8);
                return;
            }
            getBinding().r.e.setText(R.string.follow_news_chat_input_message);
            MaterialButton materialButton7 = getBinding().r.f211b;
            Intrinsics3.checkNotNullExpressionValue(materialButton7, "binding.guard.chatInputGuardAction");
            ViewExtensions.setTextAndVisibilityBy(materialButton7, getString(R.string.game_popout_follow));
            getBinding().r.f211b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureChatGuard.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetChatInput.this.showFollowSheet(viewState.getChannel().getId(), viewState.getChannel().getGuildId());
                }
            });
            MaterialButton materialButton8 = getBinding().r.c;
            Intrinsics3.checkNotNullExpressionValue(materialButton8, "binding.guard.chatInputGuardActionSecondary");
            ViewExtensions.setTextAndVisibilityBy(materialButton8, getString(R.string.lurker_mode_chat_input_button));
            getBinding().r.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureChatGuard.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetChatInput.this.getViewModel().lurkGuild(WidgetChatInput.this);
                }
            });
            return;
        }
        if (viewState.isCommunicationDisabled()) {
            final String strA = AppHelpDesk.a.a(360045138571L, null);
            TextView textView2 = getBinding().f2304s.f205b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guardCommunicati…nicationDisabledGuardText");
            FormatUtils.m(textView2, R.string.guild_communication_disabled_chat_notice_description, new Object[]{strA}, (4 & 4) != 0 ? FormatUtils.g.j : null);
            getBinding().f2304s.f205b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureChatGuard.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UriHandler.handle$default(UriHandler.INSTANCE, outline.I(WidgetChatInput.this.getBinding().f2304s.f205b, "binding.guardCommunicati…nicationDisabledGuardText", "binding.guardCommunicati…DisabledGuardText.context"), strA, false, false, null, 28, null);
                }
            });
            TextView textView3 = getBinding().f2304s.c;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guardCommunicati…ionDisabledGuardTimerText");
            textView3.setText(DurationUtils.humanizeCountdownDuration(requireContext(), viewState.getTimeoutLeftMs()));
            return;
        }
        if (!viewState.getShouldShowVerificationGate()) {
            TextView textView4 = getBinding().r.e;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.guard.chatInputGuardText");
            textView4.setText(getVerificationText(outline.I(getBinding().r.e, "binding.guard.chatInputGuardText", "binding.guard.chatInputGuardText.context"), viewState.getVerificationLevelTriggered()));
            MaterialButton materialButton9 = getBinding().r.f211b;
            Intrinsics3.checkNotNullExpressionValue(materialButton9, "binding.guard.chatInputGuardAction");
            MaterialButton materialButton10 = getBinding().r.f211b;
            Intrinsics3.checkNotNullExpressionValue(materialButton10, "binding.guard.chatInputGuardAction");
            Context context = materialButton10.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.guard.chatInputGuardAction.context");
            ViewExtensions.setTextAndVisibilityBy(materialButton9, getVerificationActionText(context, viewState.getVerificationLevelTriggered()));
            getBinding().r.f211b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureChatGuard.8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChatInputViewModel viewModel = WidgetChatInput.this.getViewModel();
                    Intrinsics3.checkNotNullExpressionValue(view, "it");
                    Context context2 = view.getContext();
                    Intrinsics3.checkNotNullExpressionValue(context2, "it.context");
                    viewModel.verifyAccount(context2);
                }
            });
            MaterialButton materialButton11 = getBinding().r.c;
            Intrinsics3.checkNotNullExpressionValue(materialButton11, "binding.guard.chatInputGuardActionSecondary");
            materialButton11.setVisibility(8);
            return;
        }
        getBinding().t.f218b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureChatGuard.6

            /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureChatGuard$6$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetChatInput.kt */
            public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemberVerificationUtils memberVerificationUtils = MemberVerificationUtils.INSTANCE;
                Context contextRequireContext = WidgetChatInput.this.requireContext();
                FragmentManager parentFragmentManager = WidgetChatInput.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                memberVerificationUtils.maybeShowVerificationGate(contextRequireContext, parentFragmentManager, viewState.getChannel().getGuildId(), Traits.Location.Page.GUILD_CHANNEL, (48 & 16) != 0 ? null : null, (48 & 32) != 0 ? MemberVerificationUtils.AnonymousClass1.INSTANCE : null, AnonymousClass1.INSTANCE);
            }
        });
        ApplicationStatus joinRequestStatus = viewState.getJoinRequestStatus();
        if (joinRequestStatus != null) {
            int iOrdinal = joinRequestStatus.ordinal();
            if (iOrdinal == 1) {
                ImageView imageView = getBinding().t.c;
                Intrinsics3.checkNotNullExpressionValue(imageView, "binding.guardMemberVerif…erVerificationGuardAction");
                imageView.setVisibility(8);
                MaterialButton materialButton12 = getBinding().t.d;
                Intrinsics3.checkNotNullExpressionValue(materialButton12, "binding.guardMemberVerif…erVerificationGuardButton");
                materialButton12.setVisibility(0);
                getBinding().t.f.setText(R.string.member_verification_application_confirmation_title);
                getBinding().t.e.setImageResource(R.drawable.img_member_verification_pending);
                getBinding().t.c.setImageResource(R.drawable.ic_close_circle_nova_grey_24dp);
                getBinding().t.d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureChatGuard.7

                    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureChatGuard$7$1, reason: invalid class name */
                    /* JADX INFO: compiled from: WidgetChatInput.kt */
                    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
                        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                        public AnonymousClass1() {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MemberVerificationUtils memberVerificationUtils = MemberVerificationUtils.INSTANCE;
                        Context contextRequireContext = WidgetChatInput.this.requireContext();
                        FragmentManager parentFragmentManager = WidgetChatInput.this.getParentFragmentManager();
                        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                        memberVerificationUtils.maybeShowVerificationGate(contextRequireContext, parentFragmentManager, viewState.getChannel().getGuildId(), Traits.Location.Page.GUILD_CHANNEL, (48 & 16) != 0 ? null : null, (48 & 32) != 0 ? MemberVerificationUtils.AnonymousClass1.INSTANCE : null, AnonymousClass1.INSTANCE);
                    }
                });
                return;
            }
            if (iOrdinal == 2) {
                MaterialButton materialButton13 = getBinding().t.d;
                Intrinsics3.checkNotNullExpressionValue(materialButton13, "binding.guardMemberVerif…erVerificationGuardButton");
                materialButton13.setVisibility(8);
                ImageView imageView2 = getBinding().t.c;
                Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.guardMemberVerif…erVerificationGuardAction");
                imageView2.setVisibility(0);
                getBinding().t.f.setText(R.string.member_verification_application_rejected_title);
                getBinding().t.e.setImageResource(R.drawable.img_member_verification_denied);
                getBinding().t.c.setImageResource(R.drawable.ic_arrow_right_24dp);
                return;
            }
        }
        MaterialButton materialButton14 = getBinding().t.d;
        Intrinsics3.checkNotNullExpressionValue(materialButton14, "binding.guardMemberVerif…erVerificationGuardButton");
        materialButton14.setVisibility(8);
        ImageView imageView3 = getBinding().t.c;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.guardMemberVerif…erVerificationGuardAction");
        imageView3.setVisibility(0);
        getBinding().t.f.setText(R.string.member_verification_chat_blocker_text);
        getBinding().t.e.setImageResource(R.drawable.img_member_verification_started);
        getBinding().t.c.setImageResource(R.drawable.ic_arrow_right_24dp);
    }

    private final void configureContextBar(ChatInputViewModel.ViewState.Loaded viewState) {
        if (viewState.isEditing()) {
            configureContextBarEditing();
        } else {
            if (viewState.getPendingReplyState() instanceof ChatInputViewModel.ViewState.Loaded.PendingReplyState.Replying) {
                configureContextBarReplying((ChatInputViewModel.ViewState.Loaded.PendingReplyState.Replying) viewState.getPendingReplyState());
                return;
            }
            RelativeLayout relativeLayout = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.chatInputContextBar");
            relativeLayout.setVisibility(8);
        }
    }

    private final void configureContextBarEditing() {
        RelativeLayout relativeLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.chatInputContextBar");
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout2, "binding.chatInputContextBar");
        relativeLayout2.setClickable(false);
        getBinding().g.setText(R.string.editing_message);
        getBinding().f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureContextBarEditing.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatInput.clearInput$default(WidgetChatInput.this, Boolean.FALSE, false, 2, null);
            }
        });
        LinearLayout linearLayout = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.chatInputContextReplyMentionButton");
        linearLayout.setVisibility(8);
    }

    private final void configureContextBarReplying(final ChatInputViewModel.ViewState.Loaded.PendingReplyState.Replying model) {
        String username;
        Context contextRequireContext = requireContext();
        RelativeLayout relativeLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.chatInputContextBar");
        relativeLayout.setVisibility(0);
        GuildMember repliedAuthorGuildMember = model.getRepliedAuthorGuildMember();
        if (repliedAuthorGuildMember == null || (username = repliedAuthorGuildMember.getNick()) == null) {
            username = model.getRepliedAuthor().getUsername();
        }
        TextView textView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatInputContextDescription");
        FormatUtils.m(textView, R.string.mobile_replying_to, new Object[]{username}, new AnonymousClass1(contextRequireContext, model));
        getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureContextBarReplying.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatInput.this.getViewModel().jumpToMessageReference(model.getMessageReference());
            }
        });
        getBinding().f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureContextBarReplying.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatInput.this.getViewModel().deletePendingReply();
            }
        });
        LinearLayout linearLayout = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.chatInputContextReplyMentionButton");
        linearLayout.setVisibility(model.getShowMentionToggle() ? 0 : 8);
        getBinding().h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureContextBarReplying.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatInput.this.getViewModel().togglePendingReplyShouldMention();
            }
        });
        int themedColor = model.getShouldMention() ? ColorCompat.getThemedColor(contextRequireContext, R.attr.colorControlBrandForeground) : ColorCompat.getThemedColor(contextRequireContext, R.attr.colorTextMuted);
        ImageView imageView = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.chatInputContextReplyMentionButtonImage");
        ColorCompat2.tintWithColor(imageView, themedColor);
        getBinding().j.setTextColor(themedColor);
        getBinding().j.setText(model.getShouldMention() ? R.string.reply_mention_on : R.string.reply_mention_off);
    }

    private final void configureInitialText(ChatInputViewModel.ViewState.Loaded viewState) {
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

    private final void configureSendListeners(final ChatInputViewModel.ViewState.Loaded viewState) {
        WidgetChatInputEditText widgetChatInputEditText = this.chatInputEditTextHolder;
        if (widgetChatInputEditText != null) {
            Context contextRequireContext = requireContext();
            MessageManager messageManager = new MessageManager(contextRequireContext, null, null, null, null, null, null, null, null, 510, null);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(contextRequireContext, messageManager);
            final AnonymousClass3 anonymousClass3 = new AnonymousClass3(anonymousClass1, new AnonymousClass2(widgetChatInputEditText, contextRequireContext, messageManager));
            final AnonymousClass4 anonymousClass4 = new AnonymousClass4(contextRequireContext);
            boolean z2 = widgetChatInputEditText.getChannelId() != viewState.getChannelId();
            widgetChatInputEditText.setChannelId(viewState.getChannelId(), z2);
            InputAutocomplete inputAutocomplete = this.autocomplete;
            if (inputAutocomplete != null) {
                inputAutocomplete.setOnPerformCommandAutocomplete(new AnonymousClass5(anonymousClass1));
            }
            widgetChatInputEditText.setOnSendListener(new AnonymousClass6(anonymousClass3));
            if (z2) {
                configureInitialText(viewState);
            }
            configureText(viewState);
            WidgetChatInputAttachments widgetChatInputAttachments = this.chatAttachments;
            if (widgetChatInputAttachments == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("chatAttachments");
            }
            widgetChatInputAttachments.setInputListener(new FlexInputListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureSendListeners.7

                /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$7$1, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetChatInput.kt */
                public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
                    public final /* synthetic */ Function1 $onSendResult;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(Function1 function1) {
                        super(1);
                        this.$onSendResult = function1;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.a;
                    }

                    public final void invoke(boolean z2) {
                        if (z2) {
                            WidgetChatInput.clearInput$default(WidgetChatInput.this, null, false, 3, null);
                        }
                        this.$onSendResult.invoke(Boolean.valueOf(z2));
                    }
                }

                @Override // com.lytefast.flexinput.FlexInputListener
                public final void onSend(String str, List<? extends Attachment<?>> list, Function1<? super Boolean, Unit> function1) {
                    Intrinsics3.checkNotNullParameter(list, "list");
                    Intrinsics3.checkNotNullParameter(function1, "onSendResult");
                    if (viewState.isOnCooldown() && !viewState.isEditing() && viewState.getSelectedThreadDraft() == null) {
                        function1.invoke(Boolean.valueOf(anonymousClass4.invoke(R.string.channel_slowmode_desc_short)));
                        return;
                    }
                    if (viewState.isEditing() && (!list.isEmpty())) {
                        function1.invoke(Boolean.valueOf(anonymousClass4.invoke(R.string.editing_with_attachment_error)));
                    } else if (viewState.getAbleToSendMessage()) {
                        anonymousClass3.invoke2(list, (Function1<? super Boolean, Unit>) new AnonymousClass1(function1));
                    } else {
                        function1.invoke(Boolean.valueOf(anonymousClass4.invoke(R.string.no_send_messages_permission_placeholder)));
                    }
                }
            });
        }
    }

    private final void configureText(ChatInputViewModel.ViewState.Loaded viewState) {
        if (viewState.getAbleToSendMessage()) {
            return;
        }
        f.P0(getFlexInputViewModel(), "", null, 2, null);
    }

    private final void configureUI(ChatInputViewModel.ViewState viewState) {
        if (!(viewState instanceof ChatInputViewModel.ViewState.Loading)) {
            if (viewState instanceof ChatInputViewModel.ViewState.Loaded) {
                WidgetChatInputAttachments widgetChatInputAttachments = this.chatAttachments;
                if (widgetChatInputAttachments == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("chatAttachments");
                }
                ChatInputViewModel.ViewState.Loaded loaded = (ChatInputViewModel.ViewState.Loaded) viewState;
                widgetChatInputAttachments.configureFlexInputContentPages(loaded.getShowCreateThreadOption());
                LinearLayout linearLayout = getBinding().q;
                Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.chatInputWrap");
                linearLayout.setVisibility(loaded.isInputShowing() ? 0 : 8);
                configureChatGuard(loaded);
                getFlexInputFragment().i(new AnonymousClass1(viewState));
                configureContextBar(loaded);
                getFlexInputViewModel().setShowExpressionTrayButtonBadge(loaded.getShouldBadgeChatInput());
                return;
            }
            return;
        }
        LinearLayout linearLayout2 = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.chatInputWrap");
        linearLayout2.setVisibility(8);
        WidgetChatInputMemberVerificationGuardBinding widgetChatInputMemberVerificationGuardBinding = getBinding().t;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputMemberVerificationGuardBinding, "binding.guardMemberVerification");
        RelativeLayout relativeLayout = widgetChatInputMemberVerificationGuardBinding.a;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.guardMemberVerification.root");
        relativeLayout.setVisibility(8);
        WidgetChatInputCommunicationDisabledGuardBinding widgetChatInputCommunicationDisabledGuardBinding = getBinding().f2304s;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputCommunicationDisabledGuardBinding, "binding.guardCommunicationDisabled");
        RelativeLayout relativeLayout2 = widgetChatInputCommunicationDisabledGuardBinding.a;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout2, "binding.guardCommunicationDisabled.root");
        relativeLayout2.setVisibility(8);
        WidgetChatInputGuardBinding widgetChatInputGuardBinding = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputGuardBinding, "binding.guard");
        LinearLayout linearLayout3 = widgetChatInputGuardBinding.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.guard.root");
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
            String string = context.getString(R.string.dm_verification_text_blocked);
            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.stri…erification_text_blocked)");
            return string;
        }
        if (hasSendMessagePermissions) {
            return FormatUtils.b(context, R.string.textarea_placeholder, new Object[]{ChannelUtils.e(channel, context, false, 2)}, (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        String string2 = context.getString(R.string.no_send_messages_permission_placeholder);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…s_permission_placeholder)");
        return string2;
    }

    private final String getVerificationActionText(Context context, GuildVerificationLevel verificationLevelTriggered) {
        int iOrdinal = verificationLevelTriggered.ordinal();
        if (iOrdinal == 1) {
            return context.getString(R.string.verify_account);
        }
        if (iOrdinal != 4) {
            return null;
        }
        return context.getString(R.string.verify_phone);
    }

    private final CharSequence getVerificationText(Context context, GuildVerificationLevel verificationLevelTriggered) {
        int iOrdinal = verificationLevelTriggered.ordinal();
        if (iOrdinal == 1) {
            return context.getString(R.string.guild_verification_text_not_claimed);
        }
        if (iOrdinal == 2) {
            return FormatUtils.b(context, R.string.guild_verification_text_account_age, new Object[]{"5"}, (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        if (iOrdinal == 3) {
            return FormatUtils.b(context, R.string.guild_verification_text_member_age, new Object[]{"10"}, (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        if (iOrdinal != 4) {
            return null;
        }
        return context.getString(R.string.guild_verification_text_not_phone_verified);
    }

    private final ChatInputViewModel getViewModel() {
        return (ChatInputViewModel) this.viewModel.getValue();
    }

    @SuppressLint({"StringFormatMatches"})
    private final void handleEvent(ChatInputViewModel.Event event) {
        Unit unit = null;
        if (event instanceof ChatInputViewModel.Event.FilesTooLarge) {
            getFlexInputViewModel().hideKeyboard();
            ImageUploadFailedDialog.Companion companion = ImageUploadFailedDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            ChatInputViewModel.Event.FilesTooLarge filesTooLarge = (ChatInputViewModel.Event.FilesTooLarge) event;
            float currentFileSizeMB = filesTooLarge.getCurrentFileSizeMB();
            float maxAttachmentSizeMB = filesTooLarge.getMaxAttachmentSizeMB();
            companion.a(parentFragmentManager, filesTooLarge.isUserPremium(), filesTooLarge.getMaxFileSizeMB(), maxAttachmentSizeMB, currentFileSizeMB, new AnonymousClass1(event), filesTooLarge.getAttachments().size(), filesTooLarge.getHasImage(), filesTooLarge.getHasVideo(), filesTooLarge.getHasGif());
            clearInput$default(this, null, false, 1, null);
            unit = Unit.a;
        } else if (event instanceof ChatInputViewModel.Event.MessageTooLong) {
            getFlexInputViewModel().hideKeyboard();
            NumberFormat numberInstance = NumberFormat.getNumberInstance(new LocaleManager().getPrimaryLocale(requireContext()));
            WidgetNoticeDialog.Companion companion2 = WidgetNoticeDialog.INSTANCE;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            ChatInputViewModel.Event.MessageTooLong messageTooLong = (ChatInputViewModel.Event.MessageTooLong) event;
            WidgetNoticeDialog.Companion.show$default(companion2, parentFragmentManager2, getString(R.string.message_too_long_header), FormatUtils.e(this, R.string.message_too_long_body_text, new Object[]{numberInstance.format(Integer.valueOf(messageTooLong.getCurrentCharacterCount())), numberInstance.format(Integer.valueOf(messageTooLong.getMaxCharacterCount()))}, (4 & 4) != 0 ? FormatUtils.a.j : null), getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
            unit = Unit.a;
        } else if (event instanceof ChatInputViewModel.Event.EmptyThreadName) {
            getFlexInputViewModel().hideKeyboard();
            WidgetNoticeDialog.Companion companion3 = WidgetNoticeDialog.INSTANCE;
            FragmentManager parentFragmentManager3 = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager3, "parentFragmentManager");
            WidgetNoticeDialog.Companion.show$default(companion3, parentFragmentManager3, null, FormatUtils.e(this, R.string.form_thread_name_required_error, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16370, null);
            unit = Unit.a;
        } else if (event instanceof ChatInputViewModel.Event.FailedDeliveryToRecipient) {
            getFlexInputViewModel().hideKeyboard();
            WidgetNoticeDialog.Companion companion4 = WidgetNoticeDialog.INSTANCE;
            FragmentManager parentFragmentManager4 = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager4, "parentFragmentManager");
            WidgetNoticeDialog.Companion.show$default(companion4, parentFragmentManager4, getString(R.string.error), FormatUtils.e(this, R.string.bot_dm_send_failed_with_help_link_mobile, new Object[]{AppHelpDesk.a.a(360060145013L, null)}, (4 & 4) != 0 ? FormatUtils.a.j : null), getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
            unit = Unit.a;
        } else if (event instanceof ChatInputViewModel.Event.AppendChatText) {
            getFlexInputViewModel().onInputTextAppended(((ChatInputViewModel.Event.AppendChatText) event).getText());
            unit = Unit.a;
        } else if (event instanceof ChatInputViewModel.Event.SetChatText) {
            getFlexInputViewModel().hideExpressionTray();
            getFlexInputViewModel().onInputTextChanged(((ChatInputViewModel.Event.SetChatText) event).getText(), Boolean.TRUE);
            unit = Unit.a;
        } else if (event instanceof ChatInputViewModel.Event.CommandInputsInvalid) {
            InputAutocomplete inputAutocomplete = this.autocomplete;
            if (inputAutocomplete != null) {
                inputAutocomplete.onCommandInputsSendError();
                unit = Unit.a;
            }
        } else if (event instanceof ChatInputViewModel.Event.ShowPremiumUpsell) {
            MultiValuePropPremiumUpsellDialog.Companion companion5 = MultiValuePropPremiumUpsellDialog.INSTANCE;
            FragmentManager parentFragmentManager5 = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager5, "parentFragmentManager");
            ChatInputViewModel.Event.ShowPremiumUpsell showPremiumUpsell = (ChatInputViewModel.Event.ShowPremiumUpsell) event;
            MultiValuePropPremiumUpsellDialog.Companion.a(companion5, parentFragmentManager5, showPremiumUpsell.getPage(), getString(showPremiumUpsell.getHeaderResId()), getString(showPremiumUpsell.getBodyResId()), null, null, null, null, showPremiumUpsell.getShowOtherPages(), showPremiumUpsell.getShowLearnMore(), 240);
            unit = Unit.a;
        } else {
            if (!(event instanceof ChatInputViewModel.Event.ThreadDraftClosed)) {
                throw new NoWhenBranchMatchedException();
            }
            getFlexInputViewModel().hideKeyboard();
            clearInput$default(this, null, false, 3, null);
            unit = Unit.a;
        }
        KotlinExtensions.getExhaustive(unit);
    }

    private final void onViewBindingDestroy(WidgetChatInputBinding binding) {
        PanelsChildGestureRegionObserver panelsChildGestureRegionObserverA = PanelsChildGestureRegionObserver.b.a();
        LinearLayout linearLayout = binding.q;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.chatInputWrap");
        panelsChildGestureRegionObserverA.c(linearLayout);
    }

    private final void populateDirectShareData() {
        ContentResolver contentResolver;
        List<Uri> uris;
        Long directShareId = IntentUtils.INSTANCE.getDirectShareId(getMostRecentIntent());
        if (directShareId != null) {
            long jLongValue = directShareId.longValue();
            boolean z2 = true;
            ShareUtils.SharedContent sharedContent = ShareUtils.INSTANCE.getSharedContent(getMostRecentIntent(), true);
            CharSequence text = sharedContent.getText();
            if (text != null && !StringsJVM.isBlank(text)) {
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
                    Intrinsics3.throwUninitializedPropertyAccessException("chatAttachments");
                }
                widgetChatInputAttachments.addExternalAttachment(Attachment.INSTANCE.b(uri, contentResolver));
            }
        }
    }

    private final void setWindowInsetsListeners(final boolean shouldApplyWindowInsets) {
        LinearLayout linearLayout = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.chatInputWrap");
        ViewExtensions.setForwardingWindowInsetsListener(linearLayout);
        FragmentContainerView fragmentContainerView = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView, "binding.chatInputWidget");
        ViewExtensions.setForwardingWindowInsetsListener(fragmentContainerView);
        WidgetChatInputGuardBinding widgetChatInputGuardBinding = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputGuardBinding, "binding.guard");
        ViewCompat.setOnApplyWindowInsetsListener(widgetChatInputGuardBinding.a, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.setWindowInsetsListeners.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                Intrinsics3.checkNotNullParameter(view, "view");
                Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
        WidgetChatInputMemberVerificationGuardBinding widgetChatInputMemberVerificationGuardBinding = getBinding().t;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputMemberVerificationGuardBinding, "binding.guardMemberVerification");
        ViewCompat.setOnApplyWindowInsetsListener(widgetChatInputMemberVerificationGuardBinding.a, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.setWindowInsetsListeners.2
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                Intrinsics3.checkNotNullParameter(view, "view");
                Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
        WidgetChatInputCommunicationDisabledGuardBinding widgetChatInputCommunicationDisabledGuardBinding = getBinding().f2304s;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputCommunicationDisabledGuardBinding, "binding.guardCommunicationDisabled");
        ViewCompat.setOnApplyWindowInsetsListener(widgetChatInputCommunicationDisabledGuardBinding.a, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.setWindowInsetsListeners.3
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                Intrinsics3.checkNotNullParameter(view, "view");
                Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().d, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.setWindowInsetsListeners.4
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
                WindowInsetsCompat windowInsetsCompatBuild = new WindowInsetsCompat.Builder().setSystemWindowInsets(Insets.of(0, 0, 0, shouldApplyWindowInsets ? windowInsetsCompat.getSystemWindowInsetBottom() : 0)).build();
                Intrinsics3.checkNotNullExpressionValue(windowInsetsCompatBuild, "WindowInsetsCompat.Build…        )\n      ).build()");
                ViewCompat.dispatchApplyWindowInsets(WidgetChatInput.this.getBinding().q, windowInsetsCompatBuild);
                WidgetChatInputGuardBinding widgetChatInputGuardBinding2 = WidgetChatInput.this.getBinding().r;
                Intrinsics3.checkNotNullExpressionValue(widgetChatInputGuardBinding2, "binding.guard");
                ViewCompat.dispatchApplyWindowInsets(widgetChatInputGuardBinding2.a, windowInsetsCompatBuild);
                WidgetChatInputMemberVerificationGuardBinding widgetChatInputMemberVerificationGuardBinding2 = WidgetChatInput.this.getBinding().t;
                Intrinsics3.checkNotNullExpressionValue(widgetChatInputMemberVerificationGuardBinding2, "binding.guardMemberVerification");
                ViewCompat.dispatchApplyWindowInsets(widgetChatInputMemberVerificationGuardBinding2.a, windowInsetsCompatBuild);
                WidgetChatInputCommunicationDisabledGuardBinding widgetChatInputCommunicationDisabledGuardBinding2 = WidgetChatInput.this.getBinding().f2304s;
                Intrinsics3.checkNotNullExpressionValue(widgetChatInputCommunicationDisabledGuardBinding2, "binding.guardCommunicationDisabled");
                ViewCompat.dispatchApplyWindowInsets(widgetChatInputCommunicationDisabledGuardBinding2.a, windowInsetsCompatBuild);
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
        getBinding().d.requestApplyInsets();
    }

    public static /* synthetic */ void setWindowInsetsListeners$default(WidgetChatInput widgetChatInput, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        widgetChatInput.setWindowInsetsListeners(z2);
    }

    private final void showFollowSheet(long channelId, long guildId) {
        WidgetChannelFollowSheet.Companion companion = WidgetChannelFollowSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, channelId, guildId);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        WidgetChatInputAttachments widgetChatInputAttachments = new WidgetChatInputAttachments(getFlexInputFragment());
        this.chatAttachments = widgetChatInputAttachments;
        if (widgetChatInputAttachments == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("chatAttachments");
        }
        widgetChatInputAttachments.configureFlexInputFragment(this);
        getFlexInputFragment().i(new AnonymousClass1());
        PanelsChildGestureRegionObserver panelsChildGestureRegionObserverA = PanelsChildGestureRegionObserver.b.a();
        LinearLayout linearLayout = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.chatInputWrap");
        panelsChildGestureRegionObserverA.b(linearLayout);
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
        Observable<ChatInputViewModel.ViewState> observableR = getViewModel().observeChatInputViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), (Class<?>) WidgetChatInput.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetChatInput.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
        WidgetChatInputAttachments widgetChatInputAttachments = this.chatAttachments;
        if (widgetChatInputAttachments == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("chatAttachments");
        }
        widgetChatInputAttachments.setViewModel(getFlexInputViewModel());
        InputAutocomplete inputAutocomplete = this.autocomplete;
        if (inputAutocomplete != null) {
            inputAutocomplete.onViewBoundOrOnResume();
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(this.inlineVoiceVisibilityObserver.observeIsVisible(), this, null, 2, null), (Class<?>) WidgetChatInput.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
    }
}
