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
import com.discord.C5419R;
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
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.ShareUtils;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.duration.DurationUtilsKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.locale.LocaleManager;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
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
import p007b.p008a.p009a.C0816c;
import p007b.p008a.p009a.p012b.C0811c;
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p018d.C0863f0;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p025i.C1056t4;
import p007b.p008a.p025i.C1063u4;
import p007b.p008a.p025i.C1070v4;
import p007b.p008a.p027k.C1107b;
import p007b.p008a.p039o.ViewOnLayoutChangeListenerC1175b;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12083g;
import p507d0.p512d0.C11226f;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetChatInput.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChatInputBinding;", 0)};
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

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureContextBarReplying$1 */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final class C77141 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ ChatInputViewModel.ViewState.Loaded.PendingReplyState.Replying $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C77141(Context context, ChatInputViewModel.ViewState.Loaded.PendingReplyState.Replying replying) {
            super(1);
            this.$context = context;
            this.$model = replying;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.boldColor = Integer.valueOf(GuildMember.INSTANCE.getColor(this.$model.getRepliedAuthorGuildMember(), ColorCompat.getThemedColor(this.$context, C5419R.attr.colorHeaderPrimary)));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$1 */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final class C77181 extends AbstractC12240o implements Function4<ApplicationCommandData, Map<ApplicationCommandOption, ? extends Attachment<?>>, Boolean, Function1<? super Boolean, ? extends Unit>, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ MessageManager $messageManager;

        /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChatInput.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Boolean, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f27425a;
            }

            public final void invoke(boolean z2) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C77181(Context context, MessageManager messageManager) {
            super(4);
            this.$context = context;
            this.$messageManager = messageManager;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void invoke$default(C77181 c77181, ApplicationCommandData applicationCommandData, Map map, boolean z2, Function1 function1, int i, Object obj) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            if ((i & 8) != 0) {
                function1 = AnonymousClass1.INSTANCE;
            }
            c77181.invoke(applicationCommandData, (Map<ApplicationCommandOption, ? extends Attachment<?>>) map, z2, (Function1<? super Boolean, Unit>) function1);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(ApplicationCommandData applicationCommandData, Map<ApplicationCommandOption, ? extends Attachment<?>> map, Boolean bool, Function1<? super Boolean, ? extends Unit> function1) {
            invoke(applicationCommandData, map, bool.booleanValue(), (Function1<? super Boolean, Unit>) function1);
            return Unit.f27425a;
        }

        public final void invoke(ApplicationCommandData applicationCommandData, Map<ApplicationCommandOption, ? extends Attachment<?>> map, boolean z2, Function1<? super Boolean, Unit> function1) {
            C12238m.checkNotNullParameter(applicationCommandData, "applicationCommandData");
            C12238m.checkNotNullParameter(map, "attachments");
            C12238m.checkNotNullParameter(function1, "onValidationResult");
            WidgetChatInput.this.getViewModel().sendCommand(this.$context, this.$messageManager, applicationCommandData, map, z2, false, function1);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$2 */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final class C77192 extends AbstractC12240o implements Function3<List<? extends Attachment<?>>, ApplicationCommandData, Function1<? super Boolean, ? extends Unit>, Unit> {
        public final /* synthetic */ WidgetChatInputEditText $chatInput;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ MessageManager $messageManager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C77192(WidgetChatInputEditText widgetChatInputEditText, Context context, MessageManager messageManager) {
            super(3);
            this.$chatInput = widgetChatInputEditText;
            this.$context = context;
            this.$messageManager = messageManager;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Attachment<?>> list, ApplicationCommandData applicationCommandData, Function1<? super Boolean, ? extends Unit> function1) {
            invoke2(list, applicationCommandData, (Function1<? super Boolean, Unit>) function1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends Attachment<?>> list, ApplicationCommandData applicationCommandData, Function1<? super Boolean, Unit> function1) {
            MessageContent messageContent;
            MessageContent messageContent2;
            ApplicationCommand applicationCommand;
            String strInvoke;
            C12238m.checkNotNullParameter(list, "attachmentsRaw");
            C12238m.checkNotNullParameter(function1, "onValidationResult");
            InputAutocomplete inputAutocomplete = WidgetChatInput.this.autocomplete;
            if (inputAutocomplete == null || (messageContent = inputAutocomplete.getInputContent()) == null) {
                messageContent = new MessageContent(this.$chatInput.getText(), C12147n.emptyList());
            }
            if (applicationCommandData == null || (applicationCommand = applicationCommandData.getApplicationCommand()) == null || !applicationCommand.getBuiltIn()) {
                messageContent2 = messageContent;
            } else {
                ApplicationCommand applicationCommand2 = applicationCommandData.getApplicationCommand();
                List<ApplicationCommandValue> values = applicationCommandData.getValues();
                LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(values, 10)), 16));
                for (Object obj : values) {
                    linkedHashMap.put(((ApplicationCommandValue) obj).getName(), obj);
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(C12134g0.mapCapacity(linkedHashMap.size()));
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

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$3 */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final class C77203 extends AbstractC12240o implements Function2<List<? extends Attachment<?>>, Function1<? super Boolean, ? extends Unit>, Unit> {
        public final /* synthetic */ C77181 $sendCommand$1;
        public final /* synthetic */ C77192 $sendMessage$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C77203(C77181 c77181, C77192 c77192) {
            super(2);
            this.$sendCommand$1 = c77181;
            this.$sendMessage$2 = c77192;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Attachment<?>> list, Function1<? super Boolean, ? extends Unit> function1) {
            invoke2(list, (Function1<? super Boolean, Unit>) function1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends Attachment<?>> list, Function1<? super Boolean, Unit> function1) {
            C12238m.checkNotNullParameter(list, "attachmentsRaw");
            C12238m.checkNotNullParameter(function1, "onValidationResult");
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
            C77181 c77181 = this.$sendCommand$1;
            InputAutocomplete inputAutocomplete2 = WidgetChatInput.this.autocomplete;
            Map<ApplicationCommandOption, Attachment<?>> commandAttachments = inputAutocomplete2 != null ? inputAutocomplete2.getCommandAttachments() : null;
            if (commandAttachments == null) {
                commandAttachments = C12136h0.emptyMap();
            }
            c77181.invoke(applicationCommandData$default, (Map<ApplicationCommandOption, ? extends Attachment<?>>) commandAttachments, false, function1);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$4 */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final class C77214 extends AbstractC12240o implements Function1<Integer, Boolean> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C77214(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
            return Boolean.valueOf(invoke(num.intValue()));
        }

        public final boolean invoke(@StringRes int i) {
            C0876m.m169g(this.$context, i, 0, null, 12);
            return false;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$5 */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final class C77225 extends AbstractC12240o implements Function1<ApplicationCommandOption, Unit> {
        public final /* synthetic */ C77181 $sendCommand$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C77225(C77181 c77181) {
            super(1);
            this.$sendCommand$1 = c77181;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ApplicationCommandOption applicationCommandOption) {
            invoke2(applicationCommandOption);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ApplicationCommandOption applicationCommandOption) {
            C12238m.checkNotNullParameter(applicationCommandOption, "it");
            InputAutocomplete inputAutocomplete = WidgetChatInput.this.autocomplete;
            ApplicationCommandData applicationCommandData = inputAutocomplete != null ? inputAutocomplete.getApplicationCommandData(applicationCommandOption) : null;
            if (applicationCommandData != null) {
                C77181.invoke$default(this.$sendCommand$1, applicationCommandData, C12136h0.emptyMap(), true, null, 8, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$6 */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final class C77236 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ C77203 $trySend$3;

        /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$6$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChatInput.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Boolean, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f27425a;
            }

            public final void invoke(boolean z2) {
                if (z2) {
                    WidgetChatInput.clearInput$default(WidgetChatInput.this, null, false, 3, null);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C77236(C77203 c77203) {
            super(0);
            this.$trySend$3 = c77203;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$trySend$3.invoke2(C12147n.emptyList(), (Function1<? super Boolean, Unit>) new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureUI$1 */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final class C77251 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ ChatInputViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C77251(ChatInputViewModel.ViewState viewState) {
            super(0);
            this.$viewState = viewState;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
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

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$handleEvent$1 */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final class C77261 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ ChatInputViewModel.Event $event;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C77261(ChatInputViewModel.Event event) {
            super(0);
            this.$event = event;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
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

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final class C77271 extends AbstractC12240o implements Function0<Unit> {
        public C77271() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FlexEditText flexEditTextM9293l = WidgetChatInput.this.getFlexInputFragment().m9293l();
            WidgetChatInput widgetChatInput = WidgetChatInput.this;
            FlexInputFragment flexInputFragment = widgetChatInput.getFlexInputFragment();
            AppFlexInputViewModel flexInputViewModel = WidgetChatInput.this.getFlexInputViewModel();
            TextView textView = WidgetChatInput.this.getBinding().f16104k;
            C12238m.checkNotNullExpressionValue(textView, "binding.chatInputEmojiMatchingHeader");
            RecyclerView recyclerView = WidgetChatInput.this.getBinding().f16105l;
            C12238m.checkNotNullExpressionValue(recyclerView, "binding.chatInputMentionsRecycler");
            RecyclerView recyclerView2 = WidgetChatInput.this.getBinding().f16096c;
            C12238m.checkNotNullExpressionValue(recyclerView2, "binding.chatInputCategoriesRecycler");
            LinearLayout linearLayout = WidgetChatInput.this.getBinding().f16106m;
            C12238m.checkNotNullExpressionValue(linearLayout, "binding.chatInputStickersContainer");
            RecyclerView recyclerView3 = WidgetChatInput.this.getBinding().f16108o;
            C12238m.checkNotNullExpressionValue(recyclerView3, "binding.chatInputStickersRecycler");
            TextView textView2 = WidgetChatInput.this.getBinding().f16107n;
            C12238m.checkNotNullExpressionValue(textView2, "binding.chatInputStickersMatchingHeader");
            WidgetChatInputApplicationCommandsBinding widgetChatInputApplicationCommandsBinding = WidgetChatInput.this.getBinding().f16095b;
            C12238m.checkNotNullExpressionValue(widgetChatInputApplicationCommandsBinding, "binding.applicationCommandsRoot");
            InputAutocomplete inputAutocomplete = new InputAutocomplete(widgetChatInput, flexInputFragment, flexInputViewModel, flexEditTextM9293l, null, textView, recyclerView, recyclerView2, linearLayout, recyclerView3, textView2, widgetChatInputApplicationCommandsBinding);
            WidgetChatInput.this.autocomplete = inputAutocomplete;
            inputAutocomplete.onViewBoundOrOnResume();
            WidgetChatInput.this.chatInputEditTextHolder = new WidgetChatInputEditText(flexEditTextM9293l, null, 2, 0 == true ? 1 : 0);
            WidgetChatInput.this.chatInputTruncatedHint = new WidgetChatInputTruncatedHint(flexEditTextM9293l);
            WidgetChatInputTruncatedHint widgetChatInputTruncatedHint = WidgetChatInput.this.chatInputTruncatedHint;
            if (widgetChatInputTruncatedHint != null) {
                widgetChatInputTruncatedHint.addBindedTextWatcher(WidgetChatInput.this);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final /* synthetic */ class C77281 extends C12236k implements Function1<ChatInputViewModel.ViewState, Unit> {
        public C77281(WidgetChatInput widgetChatInput) {
            super(1, widgetChatInput, WidgetChatInput.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/input/ChatInputViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChatInputViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChatInputViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetChatInput) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final /* synthetic */ class C77292 extends C12236k implements Function1<ChatInputViewModel.Event, Unit> {
        public C77292(WidgetChatInput widgetChatInput) {
            super(1, widgetChatInput, WidgetChatInput.class, "handleEvent", "handleEvent(Lcom/discord/widgets/chat/input/ChatInputViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChatInputViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChatInputViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetChatInput) this.receiver).handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: WidgetChatInput.kt */
    public static final class C77303 extends AbstractC12240o implements Function1<Boolean, Unit> {
        public C77303() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            WidgetChatInput.this.setWindowInsetsListeners(!z2);
        }
    }

    public WidgetChatInput() {
        super(C5419R.layout.widget_chat_input);
        this.binding = FragmentViewBindingDelegateKt.viewBinding(this, WidgetChatInput$binding$2.INSTANCE, new WidgetChatInput$binding$3(this));
        this.inlineVoiceVisibilityObserver = ViewVisibilityObserverProvider.INSTANCE.get(ViewVisibilityObserverProvider.INLINE_VOICE_FEATURE);
        this.messageDraftsRepo = MessageDraftsRepo.Provider.INSTANCE.get();
        this.clock = ClockFactory.get();
        this.flexInputFragment = C12083g.lazy(new WidgetChatInput$flexInputFragment$2(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(ChatInputViewModel.class), new C7701xc3f142cd(this), new C0863f0(WidgetChatInput$viewModel$2.INSTANCE));
        this.flexInputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(AppFlexInputViewModel.class), new C7703xc3f142cf(this), new C0863f0(new WidgetChatInput$flexInputViewModel$2(this)));
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
        C1063u4 c1063u4 = getBinding().f16111r;
        C12238m.checkNotNullExpressionValue(c1063u4, "binding.guard");
        LinearLayout linearLayout = c1063u4.f1291a;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.guard.root");
        linearLayout.setVisibility(viewState.isLurking() || viewState.isVerificationLevelTriggered() || viewState.isSystemDM() || viewState.getShouldShowFollow() ? 0 : 8);
        C1070v4 c1070v4 = getBinding().f16113t;
        C12238m.checkNotNullExpressionValue(c1070v4, "binding.guardMemberVerification");
        RelativeLayout relativeLayout = c1070v4.f1320a;
        C12238m.checkNotNullExpressionValue(relativeLayout, "binding.guardMemberVerification.root");
        C1063u4 c1063u5 = getBinding().f16111r;
        C12238m.checkNotNullExpressionValue(c1063u5, "binding.guard");
        LinearLayout linearLayout2 = c1063u5.f1291a;
        C12238m.checkNotNullExpressionValue(linearLayout2, "binding.guard.root");
        relativeLayout.setVisibility(!(linearLayout2.getVisibility() == 0) && viewState.getShouldShowVerificationGate() ? 0 : 8);
        C1056t4 c1056t4 = getBinding().f16112s;
        C12238m.checkNotNullExpressionValue(c1056t4, "binding.guardCommunicationDisabled");
        RelativeLayout relativeLayout2 = c1056t4.f1254a;
        C12238m.checkNotNullExpressionValue(relativeLayout2, "binding.guardCommunicationDisabled.root");
        C1063u4 c1063u6 = getBinding().f16111r;
        C12238m.checkNotNullExpressionValue(c1063u6, "binding.guard");
        LinearLayout linearLayout3 = c1063u6.f1291a;
        C12238m.checkNotNullExpressionValue(linearLayout3, "binding.guard.root");
        relativeLayout2.setVisibility(!(linearLayout3.getVisibility() == 0) && !viewState.getShouldShowVerificationGate() && viewState.isCommunicationDisabled() ? 0 : 8);
        if (viewState.isSystemDM()) {
            getBinding().f16111r.f1295e.setText(C5419R.string.system_dm_channel_description);
            TextView textView = getBinding().f16111r.f1294d;
            C12238m.checkNotNullExpressionValue(textView, "binding.guard.chatInputGuardSubtext");
            ViewExtensions.setTextAndVisibilityBy(textView, getString(C5419R.string.system_dm_channel_description_subtext));
            MaterialButton materialButton = getBinding().f16111r.f1292b;
            C12238m.checkNotNullExpressionValue(materialButton, "binding.guard.chatInputGuardAction");
            materialButton.setVisibility(8);
            MaterialButton materialButton2 = getBinding().f16111r.f1293c;
            C12238m.checkNotNullExpressionValue(materialButton2, "binding.guard.chatInputGuardActionSecondary");
            materialButton2.setVisibility(8);
            return;
        }
        if (viewState.getShouldShowFollow()) {
            getBinding().f16111r.f1295e.setText(C5419R.string.follow_news_chat_input_message);
            MaterialButton materialButton3 = getBinding().f16111r.f1292b;
            C12238m.checkNotNullExpressionValue(materialButton3, "binding.guard.chatInputGuardAction");
            ViewExtensions.setTextAndVisibilityBy(materialButton3, getString(C5419R.string.game_popout_follow));
            getBinding().f16111r.f1292b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureChatGuard.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetChatInput.this.showFollowSheet(viewState.getChannel().getId(), viewState.getChannel().getGuildId());
                }
            });
            MaterialButton materialButton4 = getBinding().f16111r.f1293c;
            C12238m.checkNotNullExpressionValue(materialButton4, "binding.guard.chatInputGuardActionSecondary");
            materialButton4.setVisibility(8);
            return;
        }
        if (viewState.isLurking()) {
            if (!viewState.getShouldShowFollow()) {
                getBinding().f16111r.f1295e.setText(C5419R.string.lurker_mode_chat_input_message);
                MaterialButton materialButton5 = getBinding().f16111r.f1292b;
                C12238m.checkNotNullExpressionValue(materialButton5, "binding.guard.chatInputGuardAction");
                ViewExtensions.setTextAndVisibilityBy(materialButton5, getString(C5419R.string.lurker_mode_chat_input_button));
                getBinding().f16111r.f1292b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureChatGuard.4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WidgetChatInput.this.getViewModel().lurkGuild(WidgetChatInput.this);
                    }
                });
                MaterialButton materialButton6 = getBinding().f16111r.f1293c;
                C12238m.checkNotNullExpressionValue(materialButton6, "binding.guard.chatInputGuardActionSecondary");
                materialButton6.setVisibility(8);
                return;
            }
            getBinding().f16111r.f1295e.setText(C5419R.string.follow_news_chat_input_message);
            MaterialButton materialButton7 = getBinding().f16111r.f1292b;
            C12238m.checkNotNullExpressionValue(materialButton7, "binding.guard.chatInputGuardAction");
            ViewExtensions.setTextAndVisibilityBy(materialButton7, getString(C5419R.string.game_popout_follow));
            getBinding().f16111r.f1292b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureChatGuard.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetChatInput.this.showFollowSheet(viewState.getChannel().getId(), viewState.getChannel().getGuildId());
                }
            });
            MaterialButton materialButton8 = getBinding().f16111r.f1293c;
            C12238m.checkNotNullExpressionValue(materialButton8, "binding.guard.chatInputGuardActionSecondary");
            ViewExtensions.setTextAndVisibilityBy(materialButton8, getString(C5419R.string.lurker_mode_chat_input_button));
            getBinding().f16111r.f1293c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureChatGuard.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetChatInput.this.getViewModel().lurkGuild(WidgetChatInput.this);
                }
            });
            return;
        }
        if (viewState.isCommunicationDisabled()) {
            final String strM149a = C0862f.f507a.m149a(360045138571L, null);
            TextView textView2 = getBinding().f16112s.f1255b;
            C12238m.checkNotNullExpressionValue(textView2, "binding.guardCommunicati…nicationDisabledGuardText");
            C1107b.m221m(textView2, C5419R.string.guild_communication_disabled_chat_notice_description, new Object[]{strM149a}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
            getBinding().f16112s.f1255b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureChatGuard.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UriHandler.handle$default(UriHandler.INSTANCE, C1643a.m821I(WidgetChatInput.this.getBinding().f16112s.f1255b, "binding.guardCommunicati…nicationDisabledGuardText", "binding.guardCommunicati…DisabledGuardText.context"), strM149a, false, false, null, 28, null);
                }
            });
            TextView textView3 = getBinding().f16112s.f1256c;
            C12238m.checkNotNullExpressionValue(textView3, "binding.guardCommunicati…ionDisabledGuardTimerText");
            textView3.setText(DurationUtilsKt.humanizeCountdownDuration(requireContext(), viewState.getTimeoutLeftMs()));
            return;
        }
        if (!viewState.getShouldShowVerificationGate()) {
            TextView textView4 = getBinding().f16111r.f1295e;
            C12238m.checkNotNullExpressionValue(textView4, "binding.guard.chatInputGuardText");
            textView4.setText(getVerificationText(C1643a.m821I(getBinding().f16111r.f1295e, "binding.guard.chatInputGuardText", "binding.guard.chatInputGuardText.context"), viewState.getVerificationLevelTriggered()));
            MaterialButton materialButton9 = getBinding().f16111r.f1292b;
            C12238m.checkNotNullExpressionValue(materialButton9, "binding.guard.chatInputGuardAction");
            MaterialButton materialButton10 = getBinding().f16111r.f1292b;
            C12238m.checkNotNullExpressionValue(materialButton10, "binding.guard.chatInputGuardAction");
            Context context = materialButton10.getContext();
            C12238m.checkNotNullExpressionValue(context, "binding.guard.chatInputGuardAction.context");
            ViewExtensions.setTextAndVisibilityBy(materialButton9, getVerificationActionText(context, viewState.getVerificationLevelTriggered()));
            getBinding().f16111r.f1292b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureChatGuard.8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChatInputViewModel viewModel = WidgetChatInput.this.getViewModel();
                    C12238m.checkNotNullExpressionValue(view, "it");
                    Context context2 = view.getContext();
                    C12238m.checkNotNullExpressionValue(context2, "it.context");
                    viewModel.verifyAccount(context2);
                }
            });
            MaterialButton materialButton11 = getBinding().f16111r.f1293c;
            C12238m.checkNotNullExpressionValue(materialButton11, "binding.guard.chatInputGuardActionSecondary");
            materialButton11.setVisibility(8);
            return;
        }
        getBinding().f16113t.f1321b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureChatGuard.6

            /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureChatGuard$6$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetChatInput.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
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
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                memberVerificationUtils.maybeShowVerificationGate(contextRequireContext, parentFragmentManager, viewState.getChannel().getGuildId(), Traits.Location.Page.GUILD_CHANNEL, (48 & 16) != 0 ? null : null, (48 & 32) != 0 ? MemberVerificationUtils.C67681.INSTANCE : null, AnonymousClass1.INSTANCE);
            }
        });
        ApplicationStatus joinRequestStatus = viewState.getJoinRequestStatus();
        if (joinRequestStatus != null) {
            int iOrdinal = joinRequestStatus.ordinal();
            if (iOrdinal == 1) {
                ImageView imageView = getBinding().f16113t.f1322c;
                C12238m.checkNotNullExpressionValue(imageView, "binding.guardMemberVerif…erVerificationGuardAction");
                imageView.setVisibility(8);
                MaterialButton materialButton12 = getBinding().f16113t.f1323d;
                C12238m.checkNotNullExpressionValue(materialButton12, "binding.guardMemberVerif…erVerificationGuardButton");
                materialButton12.setVisibility(0);
                getBinding().f16113t.f1325f.setText(C5419R.string.member_verification_application_confirmation_title);
                getBinding().f16113t.f1324e.setImageResource(C5419R.drawable.img_member_verification_pending);
                getBinding().f16113t.f1322c.setImageResource(C5419R.drawable.ic_close_circle_nova_grey_24dp);
                getBinding().f16113t.f1323d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureChatGuard.7

                    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureChatGuard$7$1, reason: invalid class name */
                    /* JADX INFO: compiled from: WidgetChatInput.kt */
                    public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
                        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                        public AnonymousClass1() {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.f27425a;
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
                        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                        memberVerificationUtils.maybeShowVerificationGate(contextRequireContext, parentFragmentManager, viewState.getChannel().getGuildId(), Traits.Location.Page.GUILD_CHANNEL, (48 & 16) != 0 ? null : null, (48 & 32) != 0 ? MemberVerificationUtils.C67681.INSTANCE : null, AnonymousClass1.INSTANCE);
                    }
                });
                return;
            }
            if (iOrdinal == 2) {
                MaterialButton materialButton13 = getBinding().f16113t.f1323d;
                C12238m.checkNotNullExpressionValue(materialButton13, "binding.guardMemberVerif…erVerificationGuardButton");
                materialButton13.setVisibility(8);
                ImageView imageView2 = getBinding().f16113t.f1322c;
                C12238m.checkNotNullExpressionValue(imageView2, "binding.guardMemberVerif…erVerificationGuardAction");
                imageView2.setVisibility(0);
                getBinding().f16113t.f1325f.setText(C5419R.string.member_verification_application_rejected_title);
                getBinding().f16113t.f1324e.setImageResource(C5419R.drawable.img_member_verification_denied);
                getBinding().f16113t.f1322c.setImageResource(C5419R.drawable.ic_arrow_right_24dp);
                return;
            }
        }
        MaterialButton materialButton14 = getBinding().f16113t.f1323d;
        C12238m.checkNotNullExpressionValue(materialButton14, "binding.guardMemberVerif…erVerificationGuardButton");
        materialButton14.setVisibility(8);
        ImageView imageView3 = getBinding().f16113t.f1322c;
        C12238m.checkNotNullExpressionValue(imageView3, "binding.guardMemberVerif…erVerificationGuardAction");
        imageView3.setVisibility(0);
        getBinding().f16113t.f1325f.setText(C5419R.string.member_verification_chat_blocker_text);
        getBinding().f16113t.f1324e.setImageResource(C5419R.drawable.img_member_verification_started);
        getBinding().f16113t.f1322c.setImageResource(C5419R.drawable.ic_arrow_right_24dp);
    }

    private final void configureContextBar(ChatInputViewModel.ViewState.Loaded viewState) {
        if (viewState.isEditing()) {
            configureContextBarEditing();
        } else {
            if (viewState.getPendingReplyState() instanceof ChatInputViewModel.ViewState.Loaded.PendingReplyState.Replying) {
                configureContextBarReplying((ChatInputViewModel.ViewState.Loaded.PendingReplyState.Replying) viewState.getPendingReplyState());
                return;
            }
            RelativeLayout relativeLayout = getBinding().f16098e;
            C12238m.checkNotNullExpressionValue(relativeLayout, "binding.chatInputContextBar");
            relativeLayout.setVisibility(8);
        }
    }

    private final void configureContextBarEditing() {
        RelativeLayout relativeLayout = getBinding().f16098e;
        C12238m.checkNotNullExpressionValue(relativeLayout, "binding.chatInputContextBar");
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = getBinding().f16098e;
        C12238m.checkNotNullExpressionValue(relativeLayout2, "binding.chatInputContextBar");
        relativeLayout2.setClickable(false);
        getBinding().f16100g.setText(C5419R.string.editing_message);
        getBinding().f16099f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureContextBarEditing.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatInput.clearInput$default(WidgetChatInput.this, Boolean.FALSE, false, 2, null);
            }
        });
        LinearLayout linearLayout = getBinding().f16101h;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.chatInputContextReplyMentionButton");
        linearLayout.setVisibility(8);
    }

    private final void configureContextBarReplying(final ChatInputViewModel.ViewState.Loaded.PendingReplyState.Replying model) {
        String username;
        Context contextRequireContext = requireContext();
        RelativeLayout relativeLayout = getBinding().f16098e;
        C12238m.checkNotNullExpressionValue(relativeLayout, "binding.chatInputContextBar");
        relativeLayout.setVisibility(0);
        GuildMember repliedAuthorGuildMember = model.getRepliedAuthorGuildMember();
        if (repliedAuthorGuildMember == null || (username = repliedAuthorGuildMember.getNick()) == null) {
            username = model.getRepliedAuthor().getUsername();
        }
        TextView textView = getBinding().f16100g;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatInputContextDescription");
        C1107b.m221m(textView, C5419R.string.mobile_replying_to, new Object[]{username}, new C77141(contextRequireContext, model));
        getBinding().f16098e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureContextBarReplying.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatInput.this.getViewModel().jumpToMessageReference(model.getMessageReference());
            }
        });
        getBinding().f16099f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureContextBarReplying.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatInput.this.getViewModel().deletePendingReply();
            }
        });
        LinearLayout linearLayout = getBinding().f16101h;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.chatInputContextReplyMentionButton");
        linearLayout.setVisibility(model.getShowMentionToggle() ? 0 : 8);
        getBinding().f16101h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureContextBarReplying.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatInput.this.getViewModel().togglePendingReplyShouldMention();
            }
        });
        int themedColor = model.getShouldMention() ? ColorCompat.getThemedColor(contextRequireContext, C5419R.attr.colorControlBrandForeground) : ColorCompat.getThemedColor(contextRequireContext, C5419R.attr.colorTextMuted);
        ImageView imageView = getBinding().f16102i;
        C12238m.checkNotNullExpressionValue(imageView, "binding.chatInputContextReplyMentionButtonImage");
        ColorCompatKt.tintWithColor(imageView, themedColor);
        getBinding().f16103j.setTextColor(themedColor);
        getBinding().f16103j.setText(model.getShouldMention() ? C5419R.string.reply_mention_on : C5419R.string.reply_mention_off);
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
            C77181 c77181 = new C77181(contextRequireContext, messageManager);
            final C77203 c77203 = new C77203(c77181, new C77192(widgetChatInputEditText, contextRequireContext, messageManager));
            final C77214 c77214 = new C77214(contextRequireContext);
            boolean z2 = widgetChatInputEditText.getChannelId() != viewState.getChannelId();
            widgetChatInputEditText.setChannelId(viewState.getChannelId(), z2);
            InputAutocomplete inputAutocomplete = this.autocomplete;
            if (inputAutocomplete != null) {
                inputAutocomplete.setOnPerformCommandAutocomplete(new C77225(c77181));
            }
            widgetChatInputEditText.setOnSendListener(new C77236(c77203));
            if (z2) {
                configureInitialText(viewState);
            }
            configureText(viewState);
            WidgetChatInputAttachments widgetChatInputAttachments = this.chatAttachments;
            if (widgetChatInputAttachments == null) {
                C12238m.throwUninitializedPropertyAccessException("chatAttachments");
            }
            widgetChatInputAttachments.setInputListener(new FlexInputListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.configureSendListeners.7

                /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$7$1, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetChatInput.kt */
                public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Boolean, Unit> {
                    public final /* synthetic */ Function1 $onSendResult;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(Function1 function1) {
                        super(1);
                        this.$onSendResult = function1;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.f27425a;
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
                    C12238m.checkNotNullParameter(list, "list");
                    C12238m.checkNotNullParameter(function1, "onSendResult");
                    if (viewState.isOnCooldown() && !viewState.isEditing() && viewState.getSelectedThreadDraft() == null) {
                        function1.invoke(Boolean.valueOf(c77214.invoke(C5419R.string.channel_slowmode_desc_short)));
                        return;
                    }
                    if (viewState.isEditing() && (!list.isEmpty())) {
                        function1.invoke(Boolean.valueOf(c77214.invoke(C5419R.string.editing_with_attachment_error)));
                    } else if (viewState.getAbleToSendMessage()) {
                        c77203.invoke2(list, (Function1<? super Boolean, Unit>) new AnonymousClass1(function1));
                    } else {
                        function1.invoke(Boolean.valueOf(c77214.invoke(C5419R.string.no_send_messages_permission_placeholder)));
                    }
                }
            });
        }
    }

    private final void configureText(ChatInputViewModel.ViewState.Loaded viewState) {
        if (viewState.getAbleToSendMessage()) {
            return;
        }
        C3404f.m4235P0(getFlexInputViewModel(), "", null, 2, null);
    }

    private final void configureUI(ChatInputViewModel.ViewState viewState) {
        if (!(viewState instanceof ChatInputViewModel.ViewState.Loading)) {
            if (viewState instanceof ChatInputViewModel.ViewState.Loaded) {
                WidgetChatInputAttachments widgetChatInputAttachments = this.chatAttachments;
                if (widgetChatInputAttachments == null) {
                    C12238m.throwUninitializedPropertyAccessException("chatAttachments");
                }
                ChatInputViewModel.ViewState.Loaded loaded = (ChatInputViewModel.ViewState.Loaded) viewState;
                widgetChatInputAttachments.configureFlexInputContentPages(loaded.getShowCreateThreadOption());
                LinearLayout linearLayout = getBinding().f16110q;
                C12238m.checkNotNullExpressionValue(linearLayout, "binding.chatInputWrap");
                linearLayout.setVisibility(loaded.isInputShowing() ? 0 : 8);
                configureChatGuard(loaded);
                getFlexInputFragment().m9290i(new C77251(viewState));
                configureContextBar(loaded);
                getFlexInputViewModel().setShowExpressionTrayButtonBadge(loaded.getShouldBadgeChatInput());
                return;
            }
            return;
        }
        LinearLayout linearLayout2 = getBinding().f16110q;
        C12238m.checkNotNullExpressionValue(linearLayout2, "binding.chatInputWrap");
        linearLayout2.setVisibility(8);
        C1070v4 c1070v4 = getBinding().f16113t;
        C12238m.checkNotNullExpressionValue(c1070v4, "binding.guardMemberVerification");
        RelativeLayout relativeLayout = c1070v4.f1320a;
        C12238m.checkNotNullExpressionValue(relativeLayout, "binding.guardMemberVerification.root");
        relativeLayout.setVisibility(8);
        C1056t4 c1056t4 = getBinding().f16112s;
        C12238m.checkNotNullExpressionValue(c1056t4, "binding.guardCommunicationDisabled");
        RelativeLayout relativeLayout2 = c1056t4.f1254a;
        C12238m.checkNotNullExpressionValue(relativeLayout2, "binding.guardCommunicationDisabled.root");
        relativeLayout2.setVisibility(8);
        C1063u4 c1063u4 = getBinding().f16111r;
        C12238m.checkNotNullExpressionValue(c1063u4, "binding.guard");
        LinearLayout linearLayout3 = c1063u4.f1291a;
        C12238m.checkNotNullExpressionValue(linearLayout3, "binding.guard.root");
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
            String string = context.getString(C5419R.string.dm_verification_text_blocked);
            C12238m.checkNotNullExpressionValue(string, "context.getString(R.stri…erification_text_blocked)");
            return string;
        }
        if (hasSendMessagePermissions) {
            return C1107b.m216h(context, C5419R.string.textarea_placeholder, new Object[]{ChannelUtils.m7681e(channel, context, false, 2)}, null, 4);
        }
        String string2 = context.getString(C5419R.string.no_send_messages_permission_placeholder);
        C12238m.checkNotNullExpressionValue(string2, "context.getString(R.stri…s_permission_placeholder)");
        return string2;
    }

    private final String getVerificationActionText(Context context, GuildVerificationLevel verificationLevelTriggered) {
        int iOrdinal = verificationLevelTriggered.ordinal();
        if (iOrdinal == 1) {
            return context.getString(C5419R.string.verify_account);
        }
        if (iOrdinal != 4) {
            return null;
        }
        return context.getString(C5419R.string.verify_phone);
    }

    private final CharSequence getVerificationText(Context context, GuildVerificationLevel verificationLevelTriggered) {
        int iOrdinal = verificationLevelTriggered.ordinal();
        if (iOrdinal == 1) {
            return context.getString(C5419R.string.guild_verification_text_not_claimed);
        }
        if (iOrdinal == 2) {
            return C1107b.m216h(context, C5419R.string.guild_verification_text_account_age, new Object[]{"5"}, null, 4);
        }
        if (iOrdinal == 3) {
            return C1107b.m216h(context, C5419R.string.guild_verification_text_member_age, new Object[]{"10"}, null, 4);
        }
        if (iOrdinal != 4) {
            return null;
        }
        return context.getString(C5419R.string.guild_verification_text_not_phone_verified);
    }

    private final ChatInputViewModel getViewModel() {
        return (ChatInputViewModel) this.viewModel.getValue();
    }

    @SuppressLint({"StringFormatMatches"})
    private final void handleEvent(ChatInputViewModel.Event event) {
        Unit unit = null;
        if (event instanceof ChatInputViewModel.Event.FilesTooLarge) {
            getFlexInputViewModel().hideKeyboard();
            C0816c.Companion companion = C0816c.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            ChatInputViewModel.Event.FilesTooLarge filesTooLarge = (ChatInputViewModel.Event.FilesTooLarge) event;
            float currentFileSizeMB = filesTooLarge.getCurrentFileSizeMB();
            float maxAttachmentSizeMB = filesTooLarge.getMaxAttachmentSizeMB();
            companion.m123a(parentFragmentManager, filesTooLarge.isUserPremium(), filesTooLarge.getMaxFileSizeMB(), maxAttachmentSizeMB, currentFileSizeMB, new C77261(event), filesTooLarge.getAttachments().size(), filesTooLarge.getHasImage(), filesTooLarge.getHasVideo(), filesTooLarge.getHasGif());
            clearInput$default(this, null, false, 1, null);
            unit = Unit.f27425a;
        } else if (event instanceof ChatInputViewModel.Event.MessageTooLong) {
            getFlexInputViewModel().hideKeyboard();
            NumberFormat numberInstance = NumberFormat.getNumberInstance(new LocaleManager().getPrimaryLocale(requireContext()));
            WidgetNoticeDialog.Companion companion2 = WidgetNoticeDialog.INSTANCE;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            ChatInputViewModel.Event.MessageTooLong messageTooLong = (ChatInputViewModel.Event.MessageTooLong) event;
            WidgetNoticeDialog.Companion.show$default(companion2, parentFragmentManager2, getString(C5419R.string.message_too_long_header), C1107b.m213e(this, C5419R.string.message_too_long_body_text, new Object[]{numberInstance.format(Integer.valueOf(messageTooLong.getCurrentCharacterCount())), numberInstance.format(Integer.valueOf(messageTooLong.getMaxCharacterCount()))}, (4 & 4) != 0 ? C1107b.a.f1490j : null), getString(C5419R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
            unit = Unit.f27425a;
        } else if (event instanceof ChatInputViewModel.Event.EmptyThreadName) {
            getFlexInputViewModel().hideKeyboard();
            WidgetNoticeDialog.Companion companion3 = WidgetNoticeDialog.INSTANCE;
            FragmentManager parentFragmentManager3 = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager3, "parentFragmentManager");
            WidgetNoticeDialog.Companion.show$default(companion3, parentFragmentManager3, null, C1107b.m213e(this, C5419R.string.form_thread_name_required_error, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), getString(C5419R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16370, null);
            unit = Unit.f27425a;
        } else if (event instanceof ChatInputViewModel.Event.FailedDeliveryToRecipient) {
            getFlexInputViewModel().hideKeyboard();
            WidgetNoticeDialog.Companion companion4 = WidgetNoticeDialog.INSTANCE;
            FragmentManager parentFragmentManager4 = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager4, "parentFragmentManager");
            WidgetNoticeDialog.Companion.show$default(companion4, parentFragmentManager4, getString(C5419R.string.error), C1107b.m213e(this, C5419R.string.bot_dm_send_failed_with_help_link_mobile, new Object[]{C0862f.f507a.m149a(360060145013L, null)}, (4 & 4) != 0 ? C1107b.a.f1490j : null), getString(C5419R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
            unit = Unit.f27425a;
        } else if (event instanceof ChatInputViewModel.Event.AppendChatText) {
            getFlexInputViewModel().onInputTextAppended(((ChatInputViewModel.Event.AppendChatText) event).getText());
            unit = Unit.f27425a;
        } else if (event instanceof ChatInputViewModel.Event.SetChatText) {
            getFlexInputViewModel().hideExpressionTray();
            getFlexInputViewModel().onInputTextChanged(((ChatInputViewModel.Event.SetChatText) event).getText(), Boolean.TRUE);
            unit = Unit.f27425a;
        } else if (event instanceof ChatInputViewModel.Event.CommandInputsInvalid) {
            InputAutocomplete inputAutocomplete = this.autocomplete;
            if (inputAutocomplete != null) {
                inputAutocomplete.onCommandInputsSendError();
                unit = Unit.f27425a;
            }
        } else if (event instanceof ChatInputViewModel.Event.ShowPremiumUpsell) {
            C0811c.Companion companion5 = C0811c.INSTANCE;
            FragmentManager parentFragmentManager5 = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager5, "parentFragmentManager");
            ChatInputViewModel.Event.ShowPremiumUpsell showPremiumUpsell = (ChatInputViewModel.Event.ShowPremiumUpsell) event;
            C0811c.Companion.m114a(companion5, parentFragmentManager5, showPremiumUpsell.getPage(), getString(showPremiumUpsell.getHeaderResId()), getString(showPremiumUpsell.getBodyResId()), null, null, null, null, showPremiumUpsell.getShowOtherPages(), showPremiumUpsell.getShowLearnMore(), 240);
            unit = Unit.f27425a;
        } else {
            if (!(event instanceof ChatInputViewModel.Event.ThreadDraftClosed)) {
                throw new NoWhenBranchMatchedException();
            }
            getFlexInputViewModel().hideKeyboard();
            clearInput$default(this, null, false, 3, null);
            unit = Unit.f27425a;
        }
        KotlinExtensionsKt.getExhaustive(unit);
    }

    private final void onViewBindingDestroy(WidgetChatInputBinding binding) {
        ViewOnLayoutChangeListenerC1175b viewOnLayoutChangeListenerC1175bM232a = ViewOnLayoutChangeListenerC1175b.b.m232a();
        LinearLayout linearLayout = binding.f16110q;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.chatInputWrap");
        viewOnLayoutChangeListenerC1175bM232a.m231c(linearLayout);
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
            if (text != null && !C12103t.isBlank(text)) {
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
                    C12238m.throwUninitializedPropertyAccessException("chatAttachments");
                }
                widgetChatInputAttachments.addExternalAttachment(Attachment.INSTANCE.m9296b(uri, contentResolver));
            }
        }
    }

    private final void setWindowInsetsListeners(final boolean shouldApplyWindowInsets) {
        LinearLayout linearLayout = getBinding().f16110q;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.chatInputWrap");
        ViewExtensions.setForwardingWindowInsetsListener(linearLayout);
        FragmentContainerView fragmentContainerView = getBinding().f16109p;
        C12238m.checkNotNullExpressionValue(fragmentContainerView, "binding.chatInputWidget");
        ViewExtensions.setForwardingWindowInsetsListener(fragmentContainerView);
        C1063u4 c1063u4 = getBinding().f16111r;
        C12238m.checkNotNullExpressionValue(c1063u4, "binding.guard");
        ViewCompat.setOnApplyWindowInsetsListener(c1063u4.f1291a, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.setWindowInsetsListeners.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                C12238m.checkNotNullParameter(view, "view");
                C12238m.checkNotNullParameter(windowInsetsCompat, "insets");
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
        C1070v4 c1070v4 = getBinding().f16113t;
        C12238m.checkNotNullExpressionValue(c1070v4, "binding.guardMemberVerification");
        ViewCompat.setOnApplyWindowInsetsListener(c1070v4.f1320a, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.setWindowInsetsListeners.2
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                C12238m.checkNotNullParameter(view, "view");
                C12238m.checkNotNullParameter(windowInsetsCompat, "insets");
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
        C1056t4 c1056t4 = getBinding().f16112s;
        C12238m.checkNotNullExpressionValue(c1056t4, "binding.guardCommunicationDisabled");
        ViewCompat.setOnApplyWindowInsetsListener(c1056t4.f1254a, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.setWindowInsetsListeners.3
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                C12238m.checkNotNullParameter(view, "view");
                C12238m.checkNotNullParameter(windowInsetsCompat, "insets");
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f16097d, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.chat.input.WidgetChatInput.setWindowInsetsListeners.4
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                C12238m.checkNotNullParameter(view, "<anonymous parameter 0>");
                C12238m.checkNotNullParameter(windowInsetsCompat, "insets");
                WindowInsetsCompat windowInsetsCompatBuild = new WindowInsetsCompat.Builder().setSystemWindowInsets(Insets.m82of(0, 0, 0, shouldApplyWindowInsets ? windowInsetsCompat.getSystemWindowInsetBottom() : 0)).build();
                C12238m.checkNotNullExpressionValue(windowInsetsCompatBuild, "WindowInsetsCompat.Build…        )\n      ).build()");
                ViewCompat.dispatchApplyWindowInsets(WidgetChatInput.this.getBinding().f16110q, windowInsetsCompatBuild);
                C1063u4 c1063u5 = WidgetChatInput.this.getBinding().f16111r;
                C12238m.checkNotNullExpressionValue(c1063u5, "binding.guard");
                ViewCompat.dispatchApplyWindowInsets(c1063u5.f1291a, windowInsetsCompatBuild);
                C1070v4 c1070v5 = WidgetChatInput.this.getBinding().f16113t;
                C12238m.checkNotNullExpressionValue(c1070v5, "binding.guardMemberVerification");
                ViewCompat.dispatchApplyWindowInsets(c1070v5.f1320a, windowInsetsCompatBuild);
                C1056t4 c1056t5 = WidgetChatInput.this.getBinding().f16112s;
                C12238m.checkNotNullExpressionValue(c1056t5, "binding.guardCommunicationDisabled");
                ViewCompat.dispatchApplyWindowInsets(c1056t5.f1254a, windowInsetsCompatBuild);
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
        getBinding().f16097d.requestApplyInsets();
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
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, channelId, guildId);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        WidgetChatInputAttachments widgetChatInputAttachments = new WidgetChatInputAttachments(getFlexInputFragment());
        this.chatAttachments = widgetChatInputAttachments;
        if (widgetChatInputAttachments == null) {
            C12238m.throwUninitializedPropertyAccessException("chatAttachments");
        }
        widgetChatInputAttachments.configureFlexInputFragment(this);
        getFlexInputFragment().m9290i(new C77271());
        ViewOnLayoutChangeListenerC1175b viewOnLayoutChangeListenerC1175bM232a = ViewOnLayoutChangeListenerC1175b.b.m232a();
        LinearLayout linearLayout = getBinding().f16110q;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.chatInputWrap");
        viewOnLayoutChangeListenerC1175bM232a.m230b(linearLayout);
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
        Observable<ChatInputViewModel.ViewState> observableM11112r = getViewModel().observeChatInputViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetChatInput.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C77281(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetChatInput.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C77292(this));
        WidgetChatInputAttachments widgetChatInputAttachments = this.chatAttachments;
        if (widgetChatInputAttachments == null) {
            C12238m.throwUninitializedPropertyAccessException("chatAttachments");
        }
        widgetChatInputAttachments.setViewModel(getFlexInputViewModel());
        InputAutocomplete inputAutocomplete = this.autocomplete;
        if (inputAutocomplete != null) {
            inputAutocomplete.onViewBoundOrOnResume();
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(this.inlineVoiceVisibilityObserver.observeIsVisible(), this, null, 2, null), (Class<?>) WidgetChatInput.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C77303());
    }
}
