package com.discord.widgets.chat.input.autocomplete;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.style.MetricAffectingSpan;
import android.text.style.StyleSpan;
import androidx.annotation.ColorInt;
import androidx.annotation.MainThread;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.sticker.Sticker;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.models.commands.ApplicationSubCommand;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.user.User;
import com.discord.stores.CommandAutocompleteState;
import com.discord.stores.CommandAutocompleteState$Choices;
import com.discord.stores.CommandAutocompleteState$Failed;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreApplicationCommands;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds$Actions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import com.discord.utilities.textprocessing.FontColorSpan;
import com.discord.utilities.textprocessing.SimpleRoundedBackgroundSpan;
import com.discord.widgets.chat.AutocompleteSelectionTypes;
import com.discord.widgets.chat.MessageContent;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.input.AutocompleteStickerItem;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.chat.input.WidgetChatInputDiscoveryCommandsModel;
import com.discord.widgets.chat.input.autocomplete.commands.AutocompleteCommandUtils;
import com.discord.widgets.chat.input.emoji.EmojiAutocompletePremiumUpsellFeatureFlag;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.discord.widgets.chat.input.models.AutocompleteApplicationCommands;
import com.discord.widgets.chat.input.models.AutocompleteInputModel;
import com.discord.widgets.chat.input.models.AutocompleteInputSelectionModel;
import com.discord.widgets.chat.input.models.ChatInputMentionsMap;
import com.discord.widgets.chat.input.models.CommandOptionValue;
import com.discord.widgets.chat.input.models.InputCommandContext;
import com.discord.widgets.chat.input.models.InputSelectionModel;
import com.discord.widgets.chat.input.models.InputSelectionModel$CommandInputSelectionModel;
import com.discord.widgets.chat.input.models.InputSelectionModel$MessageInputSelectionModel;
import com.discord.widgets.chat.input.models.InputSelectionModelKt;
import com.discord.widgets.chat.input.models.MentionInputModel;
import com.discord.widgets.chat.input.models.MentionInputModel$VerifiedCommandInputModel;
import com.discord.widgets.chat.input.models.MentionInputModel$VerifiedMessageInputModel;
import com.discord.widgets.chat.input.models.MentionToken;
import com.discord.widgets.chat.input.models.OptionRange;
import com.lytefast.flexinput.model.Attachment;
import d0.d0.f;
import d0.g0.s;
import d0.g0.w;
import d0.g0.y;
import d0.t.h0;
import d0.t.n;
import d0.t.n0;
import d0.t.o;
import d0.t.o0;
import d0.t.t;
import d0.t.u;
import d0.z.d.m;
import f0.e0.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteViewModel extends d0<ViewState> {
    public static final String COMMAND_DISCOVER_TOKEN = "/";
    public static final AutocompleteViewModel$Companion Companion = new AutocompleteViewModel$Companion(null);
    public static final int DEFAULT_PLACEHOLDER_COUNT = 3;
    private final BehaviorSubject<AutocompleteInputSelectionModel> autocompleteInputSelectionModelSubject;
    private final Long channelId;
    private final Map<ApplicationCommandOption, Attachment<?>> commandAttachments;
    private final int commandOptionErrorColor;
    private final int defaultCommandOptionBackgroundColor;
    private final int defaultMentionColor;
    private final BehaviorSubject<InputEditTextAction> editTextAction;
    private final boolean emojiAutocompleteUpsellEnabled;
    private final BehaviorSubject<Event> events;
    private final AppFlexInputViewModel flexInputViewModel;
    private final BehaviorSubject<MentionInputModel> inputMentionModelSubject;
    private final BehaviorSubject<AutocompleteViewModel$SelectionState> inputSelectionSubject;
    private AutocompleteViewModel$InputState inputState;
    private AutocompleteInputSelectionModel lastAutocompleteInputSelectionModel;
    private InputSelectionModel lastChatInputModel;
    private int lastJumpedSequenceId;
    private boolean logEmojiAutocompleteUpsellViewed;
    private ApplicationCommandOption selectedOptionForAttachment;
    private final StoreApplicationCommands storeApplicationCommands;
    private final StoreExperiments storeExperiments;
    private AutocompleteViewModel$StoreState storeState;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AutocompleteViewModel(Long l, AppFlexInputViewModel appFlexInputViewModel, StoreApplicationCommands storeApplicationCommands, StoreExperiments storeExperiments, int i, int i2, int i3, Observable observable, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableAccess$observeStores;
        Long l2 = (i4 & 1) != 0 ? null : l;
        StoreApplicationCommands applicationCommands = (i4 & 4) != 0 ? StoreStream.Companion.getApplicationCommands() : storeApplicationCommands;
        if ((i4 & 128) != 0) {
            AutocompleteViewModel$Companion autocompleteViewModel$Companion = Companion;
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observableAccess$observeStores = AutocompleteViewModel$Companion.access$observeStores(autocompleteViewModel$Companion, l2, storeStream$Companion.getApplicationCommands(), storeStream$Companion.getApplicationComandFrecency());
        } else {
            observableAccess$observeStores = observable;
        }
        this(l2, appFlexInputViewModel, applicationCommands, storeExperiments, i, i2, i3, observableAccess$observeStores);
    }

    public static final /* synthetic */ BehaviorSubject access$getEvents$p(AutocompleteViewModel autocompleteViewModel) {
        return autocompleteViewModel.events;
    }

    public static final /* synthetic */ void access$handleAutocompleteInputSelectionModel(AutocompleteViewModel autocompleteViewModel, AutocompleteInputSelectionModel autocompleteInputSelectionModel) {
        autocompleteViewModel.handleAutocompleteInputSelectionModel(autocompleteInputSelectionModel);
    }

    public static final /* synthetic */ void access$handleInputSelectionModel(AutocompleteViewModel autocompleteViewModel, InputSelectionModel inputSelectionModel) throws IOException {
        autocompleteViewModel.handleInputSelectionModel(inputSelectionModel);
    }

    public static final /* synthetic */ InputSelectionModel access$handleSelectionWithInputModel(AutocompleteViewModel autocompleteViewModel, IntRange intRange, MentionInputModel mentionInputModel) {
        return autocompleteViewModel.handleSelectionWithInputModel(intRange, mentionInputModel);
    }

    public static final /* synthetic */ void access$handleStoreState(AutocompleteViewModel autocompleteViewModel, AutocompleteViewModel$StoreState autocompleteViewModel$StoreState) {
        autocompleteViewModel.handleStoreState(autocompleteViewModel$StoreState);
    }

    private final InputEditTextAction applyCommandOptionSpans(MentionInputModel$VerifiedCommandInputModel model, ApplicationCommandOption selectedOption, Set<ApplicationCommandOption> showError) {
        Object value;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (ApplicationCommandOption applicationCommandOption : model.getInputCommandOptionsRanges().keySet()) {
            boolean z2 = !showError.contains(applicationCommandOption);
            OptionRange optionRange = model.getInputCommandOptionsRanges().get(applicationCommandOption);
            if (optionRange != null) {
                int last = optionRange.getParam().getLast();
                if (!m.areEqual(selectedOption, applicationCommandOption)) {
                    last = optionRange.getValue().getLast();
                }
                int i = last;
                int i2 = this.defaultCommandOptionBackgroundColor;
                String string = null;
                Integer numValueOf = !z2 ? Integer.valueOf(this.commandOptionErrorColor) : null;
                CommandOptionValue commandOptionValue = model.getInputCommandOptionValues().get(applicationCommandOption);
                if (commandOptionValue != null && (value = commandOptionValue.getValue()) != null) {
                    string = value.toString();
                }
                linkedHashMap.put(new IntRange(optionRange.getParam().getFirst(), i), d0.t.m.listOf(new ApplicationCommandSpan(applicationCommandOption, string, optionRange.getParam().getFirst(), i, DimenUtils.dpToPixels(4), DimenUtils.dpToPixels(4), i2, DimenUtils.dpToPixels(4), numValueOf, false, AutocompleteViewModel$applyCommandOptionSpans$1$1$1.INSTANCE, 512, null)));
            }
        }
        return new InputEditTextAction$ReplacePillSpans(model.getInput(), linkedHashMap);
    }

    private final void checkForCommandsToQuery(CharSequence input, CharSequence previousInput, Channel channel) {
        AutocompleteCommandUtils autocompleteCommandUtils = AutocompleteCommandUtils.INSTANCE;
        String commandPrefix = autocompleteCommandUtils.getCommandPrefix(input);
        String commandPrefix2 = previousInput != null ? autocompleteCommandUtils.getCommandPrefix(previousInput) : null;
        if (commandPrefix == null || !(!m.areEqual(commandPrefix, commandPrefix2))) {
            return;
        }
        queryCommandsFromCommandPrefixToken((String) w.split$default((CharSequence) commandPrefix, new String[]{" "}, false, 0, 6, (Object) null).get(0), channel);
    }

    private final boolean commandCleared(AutocompleteInputSelectionModel newModel, AutocompleteInputSelectionModel oldModel) {
        MentionInputModel$VerifiedCommandInputModel inputModel;
        InputCommandContext inputCommandContext;
        MentionInputModel$VerifiedCommandInputModel inputModel2;
        InputCommandContext inputCommandContext2;
        InputSelectionModel inputSelectionModel = newModel.getInputSelectionModel();
        if (!(inputSelectionModel instanceof InputSelectionModel$CommandInputSelectionModel)) {
            inputSelectionModel = null;
        }
        InputSelectionModel$CommandInputSelectionModel inputSelectionModel$CommandInputSelectionModel = (InputSelectionModel$CommandInputSelectionModel) inputSelectionModel;
        ApplicationCommand selectedCommand = (inputSelectionModel$CommandInputSelectionModel == null || (inputModel2 = inputSelectionModel$CommandInputSelectionModel.getInputModel()) == null || (inputCommandContext2 = inputModel2.getInputCommandContext()) == null) ? null : inputCommandContext2.getSelectedCommand();
        InputSelectionModel inputSelectionModel2 = oldModel != null ? oldModel.getInputSelectionModel() : null;
        if (!(inputSelectionModel2 instanceof InputSelectionModel$CommandInputSelectionModel)) {
            inputSelectionModel2 = null;
        }
        InputSelectionModel$CommandInputSelectionModel inputSelectionModel$CommandInputSelectionModel2 = (InputSelectionModel$CommandInputSelectionModel) inputSelectionModel2;
        ApplicationCommand selectedCommand2 = (inputSelectionModel$CommandInputSelectionModel2 == null || (inputModel = inputSelectionModel$CommandInputSelectionModel2.getInputModel()) == null || (inputCommandContext = inputModel.getInputCommandContext()) == null) ? null : inputCommandContext.getSelectedCommand();
        if ((selectedCommand != null ? selectedCommand.getId() : null) == null) {
            if ((selectedCommand2 != null ? selectedCommand2.getId() : null) != null) {
                return true;
            }
        }
        return false;
    }

    @MainThread
    private final InputEditTextAction generateSpanUpdates(MentionInputModel model) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<IntRange, Autocompletable> map$Entry : model.getInputMentionsMap().entrySet()) {
            IntRange key = map$Entry.getKey();
            Autocompletable value = map$Entry.getValue();
            if (!(value instanceof ApplicationCommandAutocompletable)) {
                if (!(value instanceof RoleAutocompletable)) {
                    value = null;
                }
                RoleAutocompletable roleAutocompletable = (RoleAutocompletable) value;
                linkedHashMap.put(key, n.listOf((Object[]) new MetricAffectingSpan[]{new FontColorSpan(RoleUtils.getOpaqueColor(roleAutocompletable != null ? roleAutocompletable.getRole() : null, this.defaultMentionColor)), new StyleSpan(1)}));
            }
        }
        return new InputEditTextAction$ReplaceCharacterStyleSpans(model.getInput(), linkedHashMap);
    }

    public static /* synthetic */ ApplicationCommandData getApplicationSendData$default(AutocompleteViewModel autocompleteViewModel, ApplicationCommandOption applicationCommandOption, int i, Object obj) {
        if ((i & 1) != 0) {
            applicationCommandOption = null;
        }
        return autocompleteViewModel.getApplicationSendData(applicationCommandOption);
    }

    private final AutocompleteViewState getAutocompleteViewState(String token, List<? extends Autocompletable> autocompletables, List<AutocompleteStickerItem> stickers, boolean isAutocompletable) {
        List mutableList = u.toMutableList((Collection) autocompletables);
        if (this.emojiAutocompleteUpsellEnabled) {
            boolean reducedMotionEnabled = StoreStream.Companion.getAccessibility().getReducedMotionEnabled();
            List listFilterIsInstance = t.filterIsInstance(autocompletables, EmojiAutocompletable.class);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listFilterIsInstance) {
                if (!((EmojiAutocompletable) obj).getEmoji().isUsable()) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                List listTake = u.take(arrayList, 3);
                ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(listTake, 10));
                Iterator it = listTake.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((EmojiAutocompletable) it.next()).getEmoji());
                }
                mutableList.add(new EmojiUpsellPlaceholder(size, arrayList2, reducedMotionEnabled && ((EmojiAutocompletable) u.first((List) arrayList)).getAnimationsEnabled()));
                mutableList.removeAll(arrayList);
            }
        }
        return (isAutocompletable || (mutableList.isEmpty() ^ true) || (stickers.isEmpty() ^ true)) ? new AutocompleteViewState$Autocomplete(false, false, isAutocompletable, mutableList, stickers, token, 2, null) : AutocompleteViewState$Hidden.INSTANCE;
    }

    public static /* synthetic */ AutocompleteViewState getAutocompleteViewState$default(AutocompleteViewModel autocompleteViewModel, String str, List list, List list2, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = false;
        }
        return autocompleteViewModel.getAutocompleteViewState(str, list, list2, z2);
    }

    private final User getChannelBot(Channel channel) {
        User userA = ChannelUtils.a(channel);
        if (userA == null) {
            return null;
        }
        if (!userA.getIsBot()) {
            userA = null;
        }
        return userA;
    }

    private final SelectedCommandViewState getSelectedCommandViewState(AutocompleteInputSelectionModel model) {
        InputSelectionModel inputSelectionModel = model.getInputSelectionModel();
        if (inputSelectionModel instanceof InputSelectionModel$CommandInputSelectionModel) {
            ApplicationCommand selectedCommand = ((InputSelectionModel$CommandInputSelectionModel) model.getInputSelectionModel()).getInputModel().getInputCommandContext().getSelectedCommand();
            Application selectedApplication = ((InputSelectionModel$CommandInputSelectionModel) model.getInputSelectionModel()).getInputModel().getInputCommandContext().getSelectedApplication();
            return (selectedCommand == null || selectedApplication == null) ? SelectedCommandViewState$Hidden.INSTANCE : new SelectedCommandViewState$SelectedCommand(selectedCommand, ((InputSelectionModel$CommandInputSelectionModel) model.getInputSelectionModel()).getSelectedCommandOption(), model.getShowErrorsForOptions(), ((InputSelectionModel$CommandInputSelectionModel) model.getInputSelectionModel()).getInputModel().getInputCommandOptionValidity(), selectedApplication);
        }
        if (inputSelectionModel instanceof InputSelectionModel$MessageInputSelectionModel) {
            return SelectedCommandViewState$Hidden.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }

    @MainThread
    private final void handleAutocompleteInputSelectionModel(AutocompleteInputSelectionModel model) {
        AutocompleteViewState autocompleteViewState;
        CommandAutocompleteState commandAutocompleteState;
        AutocompleteViewModel$StoreState autocompleteViewModel$StoreState;
        WidgetChatInputDiscoveryCommandsModel browserCommands;
        WidgetChatInputDiscoveryCommandsModel browserCommands2;
        MentionToken autocompleteToken = model.getAutocompleteToken();
        AutocompleteViewState autocompleteViewState$Autocomplete = null;
        jumpedApplicationId = null;
        Long jumpedApplicationId = null;
        autocompleteViewState$Autocomplete = null;
        autocompleteViewState$Autocomplete = null;
        autocompleteViewState$Autocomplete = null;
        if (m.areEqual(model.getInputSelectionModel().getInputModel().getInput().toString(), COMMAND_DISCOVER_TOKEN)) {
            AutocompleteViewModel$StoreState autocompleteViewModel$StoreState2 = this.storeState;
            if (autocompleteViewModel$StoreState2 != null && (browserCommands2 = autocompleteViewModel$StoreState2.getBrowserCommands()) != null) {
                jumpedApplicationId = browserCommands2.getJumpedApplicationId();
            }
            if (jumpedApplicationId != null && ((autocompleteViewModel$StoreState = this.storeState) == null || (browserCommands = autocompleteViewModel$StoreState.getBrowserCommands()) == null || browserCommands.getJumpedSequenceId() != this.lastJumpedSequenceId)) {
                Integer num = this.inputState.getApplicationsPosition().get(jumpedApplicationId);
                this.events.onNext(new Event$ScrollAutocompletablesToApplication(jumpedApplicationId.longValue(), num != null ? num.intValue() : 3));
            }
            autocompleteViewState = getApplicationCommandsBrowserViewState();
        } else if (autocompleteToken != null) {
            boolean z2 = false;
            if (model.getInputSelectionModel() instanceof InputSelectionModel$CommandInputSelectionModel) {
                ApplicationCommandOption selectedCommandOption = ((InputSelectionModel$CommandInputSelectionModel) model.getInputSelectionModel()).getSelectedCommandOption();
                Map<String, CommandAutocompleteState> map = ((InputSelectionModel$CommandInputSelectionModel) model.getInputSelectionModel()).getInputModel().getCommandOptionAutocompleteItems().get(selectedCommandOption != null ? selectedCommandOption.getName() : null);
                if (map != null) {
                    CommandOptionValue commandOptionValue = ((InputSelectionModel$CommandInputSelectionModel) model.getInputSelectionModel()).getInputModel().getInputCommandOptionValues().get(selectedCommandOption);
                    commandAutocompleteState = map.get(String.valueOf(commandOptionValue != null ? commandOptionValue.getValue() : null));
                } else {
                    commandAutocompleteState = null;
                }
                if (selectedCommandOption != null && selectedCommandOption.getAutocomplete()) {
                    z2 = true;
                }
                Boolean bool = ((InputSelectionModel$CommandInputSelectionModel) model.getInputSelectionModel()).getInputModel().getInputCommandOptionValidity().get(selectedCommandOption);
                if (selectedCommandOption != null && selectedCommandOption.getAutocomplete() && !(commandAutocompleteState instanceof CommandAutocompleteState$Choices) && (!m.areEqual(bool, Boolean.TRUE))) {
                    autocompleteViewState$Autocomplete = new AutocompleteViewState$Autocomplete(true, commandAutocompleteState instanceof CommandAutocompleteState$Failed, true, n.emptyList(), n.emptyList(), autocompleteToken.getToken());
                } else if (selectedCommandOption != null && selectedCommandOption.getAutocomplete() && m.areEqual(bool, Boolean.TRUE)) {
                    autocompleteViewState$Autocomplete = AutocompleteViewState$Hidden.INSTANCE;
                }
            }
            if (autocompleteViewState$Autocomplete == null) {
                List<Autocompletable> listFilterMentionsFromToken = AutocompleteModelUtils.INSTANCE.filterMentionsFromToken(autocompleteToken, model.getInputSelectionModel(), model.getFilteredAutocompletables());
                List<Sticker> stickerMatches = model.getStickerMatches();
                ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(stickerMatches, 10));
                Iterator<T> it = stickerMatches.iterator();
                while (it.hasNext()) {
                    arrayList.add(new AutocompleteStickerItem((Sticker) it.next(), null, 0, 6, null));
                }
                autocompleteViewState = getAutocompleteViewState(autocompleteToken.getToken(), listFilterMentionsFromToken, arrayList, z2);
            } else {
                autocompleteViewState = autocompleteViewState$Autocomplete;
            }
        } else {
            autocompleteViewState = AutocompleteViewState$Hidden.INSTANCE;
        }
        SelectedCommandViewState selectedCommandViewState = getSelectedCommandViewState(model);
        ApplicationCommand applicationCommandNewSelectedCommand = newSelectedCommand(model, this.lastAutocompleteInputSelectionModel);
        if (applicationCommandNewSelectedCommand != null) {
            onNewCommandSelected(applicationCommandNewSelectedCommand);
        } else if (commandCleared(model, this.lastAutocompleteInputSelectionModel)) {
            onCommandCleared();
        }
        if (newSelectedCommandOption(model, this.lastAutocompleteInputSelectionModel) != null) {
            this.storeApplicationCommands.clearAutocompleteResults();
        }
        ApplicationCommandOption applicationCommandOptionHasAddedAttachmentOption = hasAddedAttachmentOption(model, this.lastAutocompleteInputSelectionModel);
        if (applicationCommandOptionHasAddedAttachmentOption != null) {
            selectAttachmentOption(applicationCommandOptionHasAddedAttachmentOption);
        }
        this.lastAutocompleteInputSelectionModel = model;
        updateViewState(new ViewState(autocompleteViewState, selectedCommandViewState));
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00f6  */
    @MainThread
    private final void handleInputSelectionModel(InputSelectionModel newModel) throws IOException {
        Set<ApplicationCommandOption> setEmptySet;
        MentionToken messageAutocompleteToken;
        if (newModel.getSelection().getLast() > newModel.getInputModel().getInput().length()) {
            return;
        }
        InputSelectionModel inputSelectionModel = this.lastChatInputModel;
        InputEditTextAction inputEditTextAction$ReplacePillSpans = new InputEditTextAction$ReplacePillSpans(newModel.getInputModel().getInput(), null, 2, null);
        boolean z2 = newModel instanceof InputSelectionModel$CommandInputSelectionModel;
        if (z2) {
            AutocompleteCommandUtils autocompleteCommandUtils = AutocompleteCommandUtils.INSTANCE;
            InputSelectionModel$CommandInputSelectionModel inputSelectionModel$CommandInputSelectionModel = (InputSelectionModel$CommandInputSelectionModel) newModel;
            ApplicationCommand selectedCommand = inputSelectionModel$CommandInputSelectionModel.getInputModel().getInputCommandContext().getSelectedCommand();
            ApplicationCommandOption selectedCommandOption = inputSelectionModel$CommandInputSelectionModel.getSelectedCommandOption();
            if (!(inputSelectionModel instanceof InputSelectionModel$CommandInputSelectionModel)) {
                inputSelectionModel = null;
            }
            InputSelectionModel$CommandInputSelectionModel inputSelectionModel$CommandInputSelectionModel2 = (InputSelectionModel$CommandInputSelectionModel) inputSelectionModel;
            setEmptySet = u.toMutableSet(autocompleteCommandUtils.getErrorsToShowForCommandParameters(selectedCommand, selectedCommandOption, inputSelectionModel$CommandInputSelectionModel2 != null ? inputSelectionModel$CommandInputSelectionModel2.getSelectedCommandOption() : null, inputSelectionModel$CommandInputSelectionModel.getInputModel().getInputCommandOptionValidity(), inputSelectionModel$CommandInputSelectionModel.getInputModel().getInputCommandOptionValues()));
            ApplicationCommandOption showErrorForOption = this.inputState.getShowErrorForOption();
            if (showErrorForOption != null) {
                if (m.areEqual(inputSelectionModel$CommandInputSelectionModel.getInputModel().getInputCommandOptionValidity().get(showErrorForOption), Boolean.TRUE) || (!m.areEqual(inputSelectionModel$CommandInputSelectionModel.getSelectedCommandOption(), showErrorForOption))) {
                    this.inputState = AutocompleteViewModel$InputState.copy$default(this.inputState, null, null, null, null, null, 23, null);
                } else {
                    setEmptySet.add(showErrorForOption);
                }
            }
            inputEditTextAction$ReplacePillSpans = applyCommandOptionSpans(inputSelectionModel$CommandInputSelectionModel.getInputModel(), inputSelectionModel$CommandInputSelectionModel.getSelectedCommandOption(), setEmptySet);
        } else {
            setEmptySet = n0.emptySet();
        }
        Set<ApplicationCommandOption> set = setEmptySet;
        this.editTextAction.onNext(inputEditTextAction$ReplacePillSpans);
        if (z2) {
            InputSelectionModel$CommandInputSelectionModel inputSelectionModel$CommandInputSelectionModel3 = (InputSelectionModel$CommandInputSelectionModel) newModel;
            if (inputSelectionModel$CommandInputSelectionModel3.getSelectedCommandOption() != null) {
                messageAutocompleteToken = AutocompleteModelUtils.INSTANCE.getCommandAutocompleteToken(inputSelectionModel$CommandInputSelectionModel3.getInputModel().getInput(), newModel.getSelection(), inputSelectionModel$CommandInputSelectionModel3.getSelectedCommandOption(), InputSelectionModelKt.hasSelectedFreeformInput(newModel), inputSelectionModel$CommandInputSelectionModel3.getInputModel().getInputCommandOptionsRanges(), inputSelectionModel$CommandInputSelectionModel3.getInputModel().getInputCommandOptionValues());
            } else {
                messageAutocompleteToken = AutocompleteModelUtils.INSTANCE.getMessageAutocompleteToken(newModel.getInputModel().getInput(), newModel.getSelection());
            }
        } else {
            messageAutocompleteToken = AutocompleteModelUtils.INSTANCE.getMessageAutocompleteToken(newModel.getInputModel().getInput(), newModel.getSelection());
        }
        MentionToken mentionToken = messageAutocompleteToken;
        AutocompleteModelUtils autocompleteModelUtils = AutocompleteModelUtils.INSTANCE;
        List<Sticker> stickerMatches = autocompleteModelUtils.getStickerMatches(mentionToken);
        Map<LeadingIdentifier, List<Autocompletable>> mapFilterAutocompletablesForInputContext = autocompleteModelUtils.filterAutocompletablesForInputContext(newModel);
        this.lastChatInputModel = newModel;
        this.autocompleteInputSelectionModelSubject.onNext(new AutocompleteInputSelectionModel(mentionToken, mapFilterAutocompletablesForInputContext, newModel, set, stickerMatches));
    }

    @MainThread
    private final void handleNewChannel(CharSequence currentInput, Channel oldChannel, Channel newChannel) {
        User channelBot = getChannelBot(newChannel);
        Long lValueOf = newChannel.getGuildId() == 0 ? null : Long.valueOf(newChannel.getGuildId());
        boolean z2 = true;
        if (!(!m.areEqual(oldChannel != null ? Long.valueOf(oldChannel.getGuildId()) : null, lValueOf))) {
            if ((oldChannel != null ? Long.valueOf(oldChannel.getGuildId()) : null) != null || lValueOf != null) {
                z2 = false;
            }
        }
        if (channelBot != null) {
            this.storeApplicationCommands.handleDmUserApplication(channelBot);
        } else if (z2) {
            this.storeApplicationCommands.requestFrecencyCommands(lValueOf != null ? lValueOf.longValue() : 0L);
            this.storeApplicationCommands.requestApplications(lValueOf);
        }
        String commandPrefix = currentInput != null ? AutocompleteCommandUtils.INSTANCE.getCommandPrefix(currentInput) : null;
        if (commandPrefix != null) {
            queryCommandsFromCommandPrefixToken(commandPrefix, newChannel);
        }
    }

    private final InputSelectionModel handleSelectionWithInputModel(IntRange selection, MentionInputModel inputModel) {
        if (inputModel instanceof MentionInputModel$VerifiedCommandInputModel) {
            MentionInputModel$VerifiedCommandInputModel mentionInputModel$VerifiedCommandInputModel = (MentionInputModel$VerifiedCommandInputModel) inputModel;
            return new InputSelectionModel$CommandInputSelectionModel(mentionInputModel$VerifiedCommandInputModel, selection, AutocompleteCommandUtils.INSTANCE.getSelectedCommandOption(selection.getFirst(), mentionInputModel$VerifiedCommandInputModel.getInputCommandOptionsRanges()));
        }
        if (inputModel instanceof MentionInputModel$VerifiedMessageInputModel) {
            return new InputSelectionModel$MessageInputSelectionModel(inputModel, selection);
        }
        throw new NoWhenBranchMatchedException();
    }

    @MainThread
    private final void handleStoreState(AutocompleteViewModel$StoreState newState) {
        Channel channel;
        AutocompleteViewModel$StoreState autocompleteViewModel$StoreState = this.storeState;
        if (autocompleteViewModel$StoreState == null || (channel = autocompleteViewModel$StoreState.getChannel()) == null || channel.getId() != newState.getChannel().getId()) {
            CharSequence currentInput = this.inputState.getCurrentInput();
            AutocompleteViewModel$StoreState autocompleteViewModel$StoreState2 = this.storeState;
            handleNewChannel(currentInput, autocompleteViewModel$StoreState2 != null ? autocompleteViewModel$StoreState2.getChannel() : null, newState.getChannel());
        }
        AutocompleteViewModel$StoreState autocompleteViewModel$StoreState3 = this.storeState;
        if (!m.areEqual(autocompleteViewModel$StoreState3 != null ? autocompleteViewModel$StoreState3.getFrecencyCommandIds() : null, newState.getFrecencyCommandIds())) {
            this.storeApplicationCommands.requestFrecencyCommands(newState.getChannel().getGuildId());
        }
        AutocompleteViewModel$StoreState autocompleteViewModel$StoreState4 = this.storeState;
        if ((!m.areEqual(autocompleteViewModel$StoreState4 != null ? autocompleteViewModel$StoreState4.getBrowserCommands() : null, newState.getBrowserCommands())) && newState.getBrowserCommands() != null) {
            this.inputState = AutocompleteViewModel$InputState.copy$default(this.inputState, null, null, getCommandBrowserCommandPositions(newState.getBrowserCommands()), null, null, 27, null);
        }
        this.storeState = newState;
        onDataUpdated(this.inputState, newState);
    }

    private final ApplicationCommandOption hasAddedAttachmentOption(AutocompleteInputSelectionModel newModel, AutocompleteInputSelectionModel oldModel) {
        Set setEmptySet;
        Set setEmptySet2;
        MentionInputModel$VerifiedCommandInputModel inputModel;
        Map<ApplicationCommandOption, OptionRange> inputCommandOptionsRanges;
        MentionInputModel$VerifiedCommandInputModel inputModel2;
        Map<ApplicationCommandOption, OptionRange> inputCommandOptionsRanges2;
        InputSelectionModel inputSelectionModel = newModel.getInputSelectionModel();
        if (!(inputSelectionModel instanceof InputSelectionModel$CommandInputSelectionModel)) {
            inputSelectionModel = null;
        }
        InputSelectionModel$CommandInputSelectionModel inputSelectionModel$CommandInputSelectionModel = (InputSelectionModel$CommandInputSelectionModel) inputSelectionModel;
        if (inputSelectionModel$CommandInputSelectionModel == null || (inputModel2 = inputSelectionModel$CommandInputSelectionModel.getInputModel()) == null || (inputCommandOptionsRanges2 = inputModel2.getInputCommandOptionsRanges()) == null) {
            setEmptySet = null;
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map$Entry<ApplicationCommandOption, OptionRange> map$Entry : inputCommandOptionsRanges2.entrySet()) {
                if (map$Entry.getKey().getType() == ApplicationCommandType.ATTACHMENT) {
                    linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
                }
            }
            setEmptySet = linkedHashMap.keySet();
        }
        if (setEmptySet == null) {
            setEmptySet = n0.emptySet();
        }
        InputSelectionModel inputSelectionModel2 = oldModel != null ? oldModel.getInputSelectionModel() : null;
        if (!(inputSelectionModel2 instanceof InputSelectionModel$CommandInputSelectionModel)) {
            inputSelectionModel2 = null;
        }
        InputSelectionModel$CommandInputSelectionModel inputSelectionModel$CommandInputSelectionModel2 = (InputSelectionModel$CommandInputSelectionModel) inputSelectionModel2;
        if (inputSelectionModel$CommandInputSelectionModel2 == null || (inputModel = inputSelectionModel$CommandInputSelectionModel2.getInputModel()) == null || (inputCommandOptionsRanges = inputModel.getInputCommandOptionsRanges()) == null) {
            setEmptySet2 = null;
        } else {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map$Entry<ApplicationCommandOption, OptionRange> map$Entry2 : inputCommandOptionsRanges.entrySet()) {
                if (map$Entry2.getKey().getType() == ApplicationCommandType.ATTACHMENT) {
                    linkedHashMap2.put(map$Entry2.getKey(), map$Entry2.getValue());
                }
            }
            setEmptySet2 = linkedHashMap2.keySet();
        }
        if (setEmptySet2 == null) {
            setEmptySet2 = n0.emptySet();
        }
        Set setMinus = o0.minus(setEmptySet, (Iterable) setEmptySet2);
        if (setMinus.size() == 1) {
            return (ApplicationCommandOption) u.first(setMinus);
        }
        return null;
    }

    private final ApplicationCommand newSelectedCommand(AutocompleteInputSelectionModel newModel, AutocompleteInputSelectionModel oldModel) {
        MentionInputModel$VerifiedCommandInputModel inputModel;
        InputCommandContext inputCommandContext;
        MentionInputModel$VerifiedCommandInputModel inputModel2;
        InputCommandContext inputCommandContext2;
        InputSelectionModel inputSelectionModel = newModel.getInputSelectionModel();
        if (!(inputSelectionModel instanceof InputSelectionModel$CommandInputSelectionModel)) {
            inputSelectionModel = null;
        }
        InputSelectionModel$CommandInputSelectionModel inputSelectionModel$CommandInputSelectionModel = (InputSelectionModel$CommandInputSelectionModel) inputSelectionModel;
        ApplicationCommand selectedCommand = (inputSelectionModel$CommandInputSelectionModel == null || (inputModel2 = inputSelectionModel$CommandInputSelectionModel.getInputModel()) == null || (inputCommandContext2 = inputModel2.getInputCommandContext()) == null) ? null : inputCommandContext2.getSelectedCommand();
        InputSelectionModel inputSelectionModel2 = oldModel != null ? oldModel.getInputSelectionModel() : null;
        if (!(inputSelectionModel2 instanceof InputSelectionModel$CommandInputSelectionModel)) {
            inputSelectionModel2 = null;
        }
        InputSelectionModel$CommandInputSelectionModel inputSelectionModel$CommandInputSelectionModel2 = (InputSelectionModel$CommandInputSelectionModel) inputSelectionModel2;
        ApplicationCommand selectedCommand2 = (inputSelectionModel$CommandInputSelectionModel2 == null || (inputModel = inputSelectionModel$CommandInputSelectionModel2.getInputModel()) == null || (inputCommandContext = inputModel.getInputCommandContext()) == null) ? null : inputCommandContext.getSelectedCommand();
        if (!m.areEqual(selectedCommand != null ? selectedCommand.getId() : null, selectedCommand2 != null ? selectedCommand2.getId() : null)) {
            return selectedCommand;
        }
        return null;
    }

    private final ApplicationCommandOption newSelectedCommandOption(AutocompleteInputSelectionModel newModel, AutocompleteInputSelectionModel oldModel) {
        InputSelectionModel inputSelectionModel = newModel.getInputSelectionModel();
        if (!(inputSelectionModel instanceof InputSelectionModel$CommandInputSelectionModel)) {
            inputSelectionModel = null;
        }
        InputSelectionModel$CommandInputSelectionModel inputSelectionModel$CommandInputSelectionModel = (InputSelectionModel$CommandInputSelectionModel) inputSelectionModel;
        ApplicationCommandOption selectedCommandOption = inputSelectionModel$CommandInputSelectionModel != null ? inputSelectionModel$CommandInputSelectionModel.getSelectedCommandOption() : null;
        InputSelectionModel inputSelectionModel2 = oldModel != null ? oldModel.getInputSelectionModel() : null;
        if (!(inputSelectionModel2 instanceof InputSelectionModel$CommandInputSelectionModel)) {
            inputSelectionModel2 = null;
        }
        InputSelectionModel$CommandInputSelectionModel inputSelectionModel$CommandInputSelectionModel2 = (InputSelectionModel$CommandInputSelectionModel) inputSelectionModel2;
        ApplicationCommandOption selectedCommandOption2 = inputSelectionModel$CommandInputSelectionModel2 != null ? inputSelectionModel$CommandInputSelectionModel2.getSelectedCommandOption() : null;
        if (!m.areEqual(selectedCommandOption != null ? selectedCommandOption.getName() : null, selectedCommandOption2 != null ? selectedCommandOption2.getName() : null)) {
            return selectedCommandOption;
        }
        return null;
    }

    private final void onCommandCleared() {
        this.commandAttachments.clear();
        this.flexInputViewModel.onAttachmentsUpdated(n.emptyList());
    }

    private final void onNewCommandSelected(ApplicationCommand newSelectedCommand) {
        this.commandAttachments.clear();
        this.flexInputViewModel.onAttachmentsUpdated(n.emptyList());
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        StoreAnalytics analytics = storeStream$Companion.getAnalytics();
        long id2 = storeStream$Companion.getChannelsSelected().getId();
        long applicationId = newSelectedCommand.getApplicationId();
        Long longOrNull = s.toLongOrNull(newSelectedCommand.getId());
        analytics.trackApplicationCommandSelected(id2, applicationId, longOrNull != null ? longOrNull.longValue() : 0L);
    }

    @MainThread
    private final InputEditTextAction onPreAutocompleteCompute(CharSequence input) {
        return replacementSpanCommandParamDeletion(input);
    }

    @MainThread
    private final void queryCommandsFromCommandPrefixToken(String commandPrefix, Channel channel) {
        User channelBot = getChannelBot(channel);
        Long lValueOf = channelBot != null ? Long.valueOf(channelBot.getId()) : null;
        long guildId = channel.getGuildId();
        if (commandPrefix.length() <= 1 && lValueOf == null) {
            this.storeApplicationCommands.clearQueryCommands();
        }
        if (commandPrefix.length() == 1) {
            this.storeApplicationCommands.requestInitialApplicationCommands(Long.valueOf(guildId), lValueOf, true);
            return;
        }
        if (commandPrefix.length() <= 1 || lValueOf != null) {
            return;
        }
        StoreApplicationCommands storeApplicationCommands = this.storeApplicationCommands;
        Long lValueOf2 = Long.valueOf(guildId);
        String strSubstring = commandPrefix.substring(1);
        m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        storeApplicationCommands.requestApplicationCommandsQuery(lValueOf2, strSubstring);
    }

    private final void removeAttachment(ApplicationCommandOption commandOption) {
        MentionInputModel inputModel;
        CharSequence input;
        InputSelectionModel inputSelectionModel;
        ApplicationCommand selectedCommand;
        OptionRange optionRange;
        Attachment<?> attachment = this.commandAttachments.get(commandOption);
        if (attachment != null) {
            this.commandAttachments.remove(commandOption);
            this.flexInputViewModel.removeAttachment(attachment);
            InputSelectionModel inputSelectionModel2 = this.lastChatInputModel;
            if (inputSelectionModel2 == null || (inputModel = inputSelectionModel2.getInputModel()) == null || (input = inputModel.getInput()) == null || (inputSelectionModel = this.lastChatInputModel) == null || (selectedCommand = InputSelectionModelKt.getSelectedCommand(inputSelectionModel)) == null || (optionRange = AutocompleteCommandUtils.INSTANCE.findOptionRanges(input, selectedCommand, this.commandAttachments).get(commandOption)) == null) {
                return;
            }
            this.editTextAction.onNext(new InputEditTextAction$RemoveText(input, new IntRange(optionRange.getParam().getFirst(), optionRange.getValue().getLast()), optionRange.getParam().getFirst()));
        }
    }

    @MainThread
    private final InputEditTextAction replacementSpanCommandParamDeletion(CharSequence input) {
        String string = input.toString();
        SpannedString spannedStringValueOf = SpannedString.valueOf(input);
        m.checkNotNullExpressionValue(spannedStringValueOf, "valueOf(this)");
        Object[] spans = spannedStringValueOf.getSpans(0, input.length(), SimpleRoundedBackgroundSpan.class);
        m.checkNotNullExpressionValue(spans, "getSpans(start, end, T::class.java)");
        for (SimpleRoundedBackgroundSpan simpleRoundedBackgroundSpan : (SimpleRoundedBackgroundSpan[]) spans) {
            IntRange intRange = new IntRange(spannedStringValueOf.getSpanStart(simpleRoundedBackgroundSpan), spannedStringValueOf.getSpanEnd(simpleRoundedBackgroundSpan));
            Character orNull = y.getOrNull(string, intRange.getLast());
            boolean z2 = orNull != null && orNull.charValue() == ':';
            int first = intRange.getFirst();
            int last = intRange.getLast();
            Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = string.substring(first, last);
            m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (simpleRoundedBackgroundSpan instanceof ApplicationCommandSpan) {
                ApplicationCommandSpan applicationCommandSpan = (ApplicationCommandSpan) simpleRoundedBackgroundSpan;
                if (applicationCommandSpan.getCommandOption().getType() == ApplicationCommandType.ATTACHMENT) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(applicationCommandSpan.getCommandOption().getName());
                    sb.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
                    Attachment<?> attachment = this.commandAttachments.get(applicationCommandSpan.getCommandOption());
                    sb.append(attachment != null ? attachment.getDisplayName() : null);
                    if (!w.contains$default((CharSequence) strSubstring, (CharSequence) sb.toString(), false, 2, (Object) null)) {
                        removeAttachment(applicationCommandSpan.getCommandOption());
                        return new InputEditTextAction$RemoveText(string, new IntRange(intRange.getFirst(), intRange.getLast()), Math.min(intRange.getFirst() + 1, string.length() - (intRange.getLast() - intRange.getFirst())));
                    }
                }
            }
            if (!w.contains$default((CharSequence) strSubstring, MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR, false, 2, (Object) null) && !z2) {
                return new InputEditTextAction$RemoveText(string, new IntRange(intRange.getFirst(), intRange.getLast()), intRange.getFirst());
            }
        }
        return new InputEditTextAction$None(input);
    }

    private final void selectAttachmentOption(ApplicationCommandOption applicationCommandsOption) {
        Attachment<?> attachment = this.commandAttachments.get(applicationCommandsOption);
        if (attachment != null) {
            this.selectedOptionForAttachment = applicationCommandsOption;
            this.events.onNext(new Event$PreviewAttachment(attachment));
        } else {
            this.selectedOptionForAttachment = applicationCommandsOption;
            this.events.onNext(new Event$PickAttachment(applicationCommandsOption));
        }
    }

    @MainThread
    private final void selectFirstInvalidCommandOption() {
        InputSelectionModel inputSelectionModel = this.lastChatInputModel;
        MentionInputModel inputModel = inputSelectionModel != null ? inputSelectionModel.getInputModel() : null;
        if (inputModel instanceof MentionInputModel$VerifiedCommandInputModel) {
            Map<ApplicationCommandOption, Boolean> inputCommandOptionValidity = ((MentionInputModel$VerifiedCommandInputModel) inputModel).getInputCommandOptionValidity();
            for (ApplicationCommandOption applicationCommandOption : inputCommandOptionValidity.keySet()) {
                if (m.areEqual(inputCommandOptionValidity.get(applicationCommandOption), Boolean.FALSE)) {
                    this.inputState = AutocompleteViewModel$InputState.copy$default(this.inputState, null, null, null, applicationCommandOption, null, 23, null);
                    selectCommandOption(applicationCommandOption);
                    return;
                }
            }
        }
    }

    public final void checkEmojiAutocompleteUpsellViewed(List<? extends Autocompletable> visibleItems) {
        Autocompletable autocompletablePrevious;
        m.checkNotNullParameter(visibleItems, "visibleItems");
        if (this.emojiAutocompleteUpsellEnabled && this.logEmojiAutocompleteUpsellViewed) {
            ListIterator<? extends Autocompletable> listIterator = visibleItems.listIterator(visibleItems.size());
            do {
                if (!listIterator.hasPrevious()) {
                    autocompletablePrevious = null;
                    break;
                }
                autocompletablePrevious = listIterator.previous();
            } while (!(autocompletablePrevious instanceof EmojiUpsellPlaceholder));
            if (autocompletablePrevious != null) {
                this.logEmojiAutocompleteUpsellViewed = false;
                StoreStream.Companion.getAnalytics().emojiAutocompleteUpsellInlineViewed();
            }
        }
    }

    @MainThread
    public final AutocompleteViewState getApplicationCommandsBrowserViewState() {
        Experiment userExperiment;
        AutocompleteViewModel$StoreState autocompleteViewModel$StoreState = this.storeState;
        if (autocompleteViewModel$StoreState == null || autocompleteViewModel$StoreState.getBrowserCommands() == null) {
            return AutocompleteViewState$Hidden.INSTANCE;
        }
        boolean z2 = (autocompleteViewModel$StoreState.getFrecencyCommands().isEmpty() ^ true) && (userExperiment = this.storeExperiments.getUserExperiment("2021-09_android_app_commands_frecency", true)) != null && userExperiment.getBucket() == 1;
        List<ApplicationCommand> frecencyCommands = z2 ? autocompleteViewModel$StoreState.getFrecencyCommands() : n.emptyList();
        List<Application> applications = autocompleteViewModel$StoreState.getApplications();
        ArrayList arrayList = new ArrayList();
        for (Object obj : applications) {
            Application application = (Application) obj;
            if (application.getCommandCount() > 0 || (z2 && application.getId() == -2 && (autocompleteViewModel$StoreState.getFrecencyCommands().isEmpty() ^ true))) {
                arrayList.add(obj);
            }
        }
        return new AutocompleteViewState$CommandBrowser(frecencyCommands, arrayList, autocompleteViewModel$StoreState.getBrowserCommands());
    }

    public final ApplicationCommandData getApplicationSendData(ApplicationCommandOption focusedOption) {
        AutocompleteModelUtils autocompleteModelUtils = AutocompleteModelUtils.INSTANCE;
        AutocompleteInputSelectionModel autocompleteInputSelectionModel = this.lastAutocompleteInputSelectionModel;
        AutocompleteViewModel$StoreState autocompleteViewModel$StoreState = this.storeState;
        List<Application> applications = autocompleteViewModel$StoreState != null ? autocompleteViewModel$StoreState.getApplications() : null;
        if (applications == null) {
            applications = n.emptyList();
        }
        List<Application> list = applications;
        AutocompleteViewModel$StoreState autocompleteViewModel$StoreState2 = this.storeState;
        List<ApplicationCommand> queriedCommands = autocompleteViewModel$StoreState2 != null ? autocompleteViewModel$StoreState2.getQueriedCommands() : null;
        return autocompleteModelUtils.getApplicationSendData(autocompleteInputSelectionModel, focusedOption, list, queriedCommands != null ? queriedCommands : n.emptyList(), this.commandAttachments);
    }

    public final Long getChannelId() {
        return this.channelId;
    }

    public final Map<ApplicationCommandOption, Attachment<?>> getCommandAttachments() {
        return c.A(this.commandAttachments);
    }

    @MainThread
    public final Map<Long, Integer> getCommandBrowserCommandPositions(WidgetChatInputDiscoveryCommandsModel discoveryCommands) {
        m.checkNotNullParameter(discoveryCommands, "discoveryCommands");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = 0;
        for (Pair<Application, List<Autocompletable>> pair : discoveryCommands.getCommandsByApplication()) {
            Application applicationComponent1 = pair.component1();
            List<Autocompletable> listComponent2 = pair.component2();
            Iterator<Autocompletable> it = listComponent2.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                if (!(it.next() instanceof ApplicationCommandLoadingPlaceholder)) {
                    break;
                }
                i++;
            }
            linkedHashMap.put(Long.valueOf(applicationComponent1.getId()), Integer.valueOf(f.coerceAtLeast(i, 0) + size));
            size += listComponent2.size();
        }
        return linkedHashMap;
    }

    public final int getCommandOptionErrorColor() {
        return this.commandOptionErrorColor;
    }

    public final int getDefaultCommandOptionBackgroundColor() {
        return this.defaultCommandOptionBackgroundColor;
    }

    public final int getDefaultMentionColor() {
        return this.defaultMentionColor;
    }

    public final boolean getEmojiAutocompleteUpsellEnabled() {
        return this.emojiAutocompleteUpsellEnabled;
    }

    public final AppFlexInputViewModel getFlexInputViewModel() {
        return this.flexInputViewModel;
    }

    public final AutocompleteViewModel$InputState getInputState() {
        return this.inputState;
    }

    public final int getLastJumpedSequenceId() {
        return this.lastJumpedSequenceId;
    }

    public final StoreApplicationCommands getStoreApplicationCommands() {
        return this.storeApplicationCommands;
    }

    public final AutocompleteViewModel$StoreState getStoreState() {
        return this.storeState;
    }

    public final Observable<InputEditTextAction> observeEditTextActions() {
        BehaviorSubject<InputEditTextAction> behaviorSubject = this.editTextAction;
        m.checkNotNullExpressionValue(behaviorSubject, "editTextAction");
        return behaviorSubject;
    }

    public final Observable<Event> observeEvents() {
        BehaviorSubject<Event> behaviorSubject = this.events;
        m.checkNotNullExpressionValue(behaviorSubject, "events");
        return behaviorSubject;
    }

    public final void onApplicationCommandSendError() {
        InputSelectionModel inputSelectionModel = this.lastChatInputModel;
        Object obj = null;
        MentionInputModel inputModel = inputSelectionModel != null ? inputSelectionModel.getInputModel() : null;
        if (inputModel instanceof MentionInputModel$VerifiedCommandInputModel) {
            MentionInputModel$VerifiedCommandInputModel mentionInputModel$VerifiedCommandInputModel = (MentionInputModel$VerifiedCommandInputModel) inputModel;
            ApplicationCommand selectedCommand = mentionInputModel$VerifiedCommandInputModel.getInputCommandContext().getSelectedCommand();
            if (selectedCommand != null) {
                Map<ApplicationCommandOption, Boolean> inputCommandOptionValidity = mentionInputModel$VerifiedCommandInputModel.getInputCommandOptionValidity();
                for (Object obj2 : selectedCommand.getOptions()) {
                    if (m.areEqual(inputCommandOptionValidity.get((ApplicationCommandOption) obj2), Boolean.FALSE)) {
                        obj = obj2;
                        break;
                    }
                }
                ApplicationCommandOption applicationCommandOption = (ApplicationCommandOption) obj;
                if (applicationCommandOption != null) {
                    long applicationId = selectedCommand.getApplicationId();
                    Long longOrNull = selectedCommand instanceof ApplicationSubCommand ? s.toLongOrNull(((ApplicationSubCommand) selectedCommand).getRootCommand().getId()) : s.toLongOrNull(selectedCommand.getId());
                    if (longOrNull != null) {
                        long jLongValue = longOrNull.longValue();
                        selectFirstInvalidCommandOption();
                        StoreStream.Companion.getAnalytics().trackApplicationCommandValidationFailure(applicationId, jLongValue, applicationCommandOption.getType().toString(), applicationCommandOption.getRequired());
                    }
                }
            }
        }
    }

    public final void onAttachmentRemoved(Attachment<?> attachment) {
        m.checkNotNullParameter(attachment, "attachment");
        ApplicationCommandOption applicationCommandOption = this.selectedOptionForAttachment;
        if (applicationCommandOption != null) {
            removeAttachment(applicationCommandOption);
        }
    }

    public final void onAutocompleteItemsUpdated() {
        this.logEmojiAutocompleteUpsellViewed = true;
    }

    public final void onCommandsBrowserScroll(int firstVisibleItemPosition, int lastVisibleItemPosition, int totalItems) {
        WidgetChatInputDiscoveryCommandsModel browserCommands;
        WidgetChatInputDiscoveryCommandsModel browserCommands2;
        AutocompleteViewModel$StoreState autocompleteViewModel$StoreState = this.storeState;
        if (autocompleteViewModel$StoreState == null || (browserCommands2 = autocompleteViewModel$StoreState.getBrowserCommands()) == null || !browserCommands2.getHasMoreBefore() || firstVisibleItemPosition > 3) {
            AutocompleteViewModel$StoreState autocompleteViewModel$StoreState2 = this.storeState;
            if (autocompleteViewModel$StoreState2 != null && (browserCommands = autocompleteViewModel$StoreState2.getBrowserCommands()) != null && browserCommands.getHasMoreAfter() && lastVisibleItemPosition >= (totalItems - 3) - 6) {
                StoreStream.Companion.getApplicationCommands().requestLoadMoreDown();
            }
        } else {
            StoreStream.Companion.getApplicationCommands().requestLoadMoreUp();
        }
        StoreStream.Companion.getAnalytics().trackApplicationCommandBrowserScrolled();
    }

    @MainThread
    public final InputEditTextAction onDataUpdated(AutocompleteViewModel$InputState inputState, AutocompleteViewModel$StoreState storeState) {
        MentionInputModel mentionInputModel$VerifiedMessageInputModel;
        m.checkNotNullParameter(inputState, "inputState");
        if (storeState == null) {
            return new InputEditTextAction$None(inputState.getCurrentInput());
        }
        AutocompleteApplicationCommands autocompleteApplicationCommands = new AutocompleteApplicationCommands(storeState.getApplications(), storeState.getQueriedCommands(), storeState.getBrowserCommands());
        AutocompleteInputModel autocompleteInputModel = new AutocompleteInputModel(inputState.getCurrentInput(), storeState.getAutocompletables(), autocompleteApplicationCommands);
        AutocompleteCommandUtils autocompleteCommandUtils = AutocompleteCommandUtils.INSTANCE;
        InputCommandContext inputCommandContext = autocompleteCommandUtils.getInputCommandContext(autocompleteInputModel.getInput(), storeState.getUserId(), storeState.getUserRoles(), autocompleteApplicationCommands, inputState.getSelectedCommand());
        ChatInputMentionsMap chatInputMentionsMapMapInputToMentions = AutocompleteModelUtils.INSTANCE.mapInputToMentions(autocompleteInputModel.getInput().toString(), storeState.getAutocompletables(), inputState.getInputAutocompleteMap(), inputCommandContext.getIsCommand());
        if (inputCommandContext.getSelectedCommand() != null) {
            ApplicationCommand selectedCommand = inputCommandContext.getSelectedCommand();
            Map<ApplicationCommandOption, OptionRange> mapFindOptionRanges = autocompleteCommandUtils.findOptionRanges(autocompleteInputModel.getInput(), selectedCommand, this.commandAttachments);
            Map<ApplicationCommandOption, CommandOptionValue> commandOptions = autocompleteCommandUtils.parseCommandOptions(autocompleteInputModel.getInput(), selectedCommand, chatInputMentionsMapMapInputToMentions, this.commandAttachments);
            mentionInputModel$VerifiedMessageInputModel = new MentionInputModel$VerifiedCommandInputModel(autocompleteInputModel.getInput(), autocompleteInputModel.getAutocompletables(), chatInputMentionsMapMapInputToMentions.getMentions(), null, null, null, storeState.getCommandOptionAutocompleteItems(), inputCommandContext, autocompleteInputModel.getApplicationCommands(), commandOptions, mapFindOptionRanges, autocompleteCommandUtils.getInputValidity(selectedCommand, commandOptions, this.commandAttachments, chatInputMentionsMapMapInputToMentions), 56, null);
        } else {
            mentionInputModel$VerifiedMessageInputModel = new MentionInputModel$VerifiedMessageInputModel(autocompleteInputModel.getInput(), autocompleteInputModel.getAutocompletables(), chatInputMentionsMapMapInputToMentions.getMentions());
        }
        if (mentionInputModel$VerifiedMessageInputModel instanceof MentionInputModel$VerifiedCommandInputModel) {
            InputEditTextAction inputEditTextActionAppendTextForCommandForInput = autocompleteCommandUtils.appendTextForCommandForInput((MentionInputModel$VerifiedCommandInputModel) mentionInputModel$VerifiedMessageInputModel);
            if (inputEditTextActionAppendTextForCommandForInput instanceof InputEditTextAction$InsertText) {
                return inputEditTextActionAppendTextForCommandForInput;
            }
        }
        InputEditTextAction inputEditTextAction$ClearSpans = ((inputState.getCurrentInput().length() == 0) || m.areEqual(inputState.getCurrentInput().toString(), COMMAND_DISCOVER_TOKEN)) ? new InputEditTextAction$ClearSpans(inputState.getCurrentInput()) : generateSpanUpdates(mentionInputModel$VerifiedMessageInputModel);
        this.inputMentionModelSubject.onNext(mentionInputModel$VerifiedMessageInputModel);
        this.inputState = AutocompleteViewModel$InputState.copy$default(inputState, null, inputCommandContext.getSelectedCommand(), null, null, chatInputMentionsMapMapInputToMentions.getMentions(), 13, null);
        return inputEditTextAction$ClearSpans;
    }

    @MainThread
    public final InputEditTextAction onInputTextChanged(CharSequence input, int start, int before, int count) {
        Channel channel;
        m.checkNotNullParameter(input, "input");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<IntRange, Autocompletable> map$Entry : this.inputState.getInputAutocompleteMap().entrySet()) {
            if (input.length() < map$Entry.getKey().getLast() || !map$Entry.getValue().matchesText(input.subSequence(map$Entry.getKey().getFirst(), map$Entry.getKey().getLast()).toString())) {
                IntRange intRangeShiftOrRemove = AutocompleteModelUtils.INSTANCE.shiftOrRemove(map$Entry.getKey(), start, before, count);
                if (intRangeShiftOrRemove != null) {
                    linkedHashMap.put(intRangeShiftOrRemove, map$Entry.getValue());
                }
            } else {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        this.inputState = AutocompleteViewModel$InputState.copy$default(this.inputState, null, null, null, null, linkedHashMap, 15, null);
        InputEditTextAction inputEditTextActionOnPreAutocompleteCompute = onPreAutocompleteCompute(input);
        if (!(inputEditTextActionOnPreAutocompleteCompute instanceof InputEditTextAction$None)) {
            return inputEditTextActionOnPreAutocompleteCompute;
        }
        AutocompleteViewModel$StoreState autocompleteViewModel$StoreState = this.storeState;
        if (autocompleteViewModel$StoreState != null && (channel = autocompleteViewModel$StoreState.getChannel()) != null) {
            checkForCommandsToQuery(input, this.inputState.getCurrentInput(), channel);
        }
        AutocompleteViewModel$InputState autocompleteViewModel$InputState = this.inputState;
        SpannableString spannableStringValueOf = SpannableString.valueOf(input.toString());
        m.checkNotNullExpressionValue(spannableStringValueOf, "valueOf(this)");
        return onDataUpdated(AutocompleteViewModel$InputState.copy$default(autocompleteViewModel$InputState, spannableStringValueOf, null, null, null, null, 30, null), this.storeState);
    }

    public final void onSelectionChanged(String input, int start, int finish) {
        m.checkNotNullParameter(input, "input");
        this.inputSelectionSubject.onNext(new AutocompleteViewModel$SelectionState(input, new IntRange(start, finish)));
    }

    public final MessageContent replaceAutocompletableDataWithServerValues(String content) {
        MentionInputModel inputModel;
        Map<IntRange, Autocompletable> inputMentionsMap;
        m.checkNotNullParameter(content, "content");
        InputSelectionModel inputSelectionModel = this.lastChatInputModel;
        if (inputSelectionModel == null || (inputModel = inputSelectionModel.getInputModel()) == null || (inputMentionsMap = inputModel.getInputMentionsMap()) == null) {
            return new MessageContent(content, n.emptyList());
        }
        String strReplaceAutocompleteDataWithServerValues = AutocompleteExtensionsKt.replaceAutocompleteDataWithServerValues(content, inputMentionsMap);
        List listFilterIsInstance = t.filterIsInstance(inputMentionsMap.values(), UserAutocompletable.class);
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listFilterIsInstance, 10));
        Iterator it = listFilterIsInstance.iterator();
        while (it.hasNext()) {
            arrayList.add(((UserAutocompletable) it.next()).getUser());
        }
        int length = strReplaceAutocompleteDataWithServerValues.length() - 1;
        int i = 0;
        boolean z2 = false;
        while (i <= length) {
            boolean z3 = m.compare(strReplaceAutocompleteDataWithServerValues.charAt(!z2 ? i : length), 32) <= 0;
            if (z2) {
                if (!z3) {
                    break;
                }
                length--;
            } else if (z3) {
                i++;
            } else {
                z2 = true;
            }
        }
        return new MessageContent(strReplaceAutocompleteDataWithServerValues.subSequence(i, length + 1).toString(), arrayList);
    }

    @MainThread
    public final void selectAutocompleteItem(Autocompletable autocompletable) {
        MentionToken autocompleteToken;
        InputSelectionModel inputSelectionModel;
        MentionInputModel inputModel;
        CharSequence input;
        IntRange value;
        MentionInputModel inputModel2;
        CharSequence input2;
        m.checkNotNullParameter(autocompletable, "autocompletable");
        CharSequence charSequence = "";
        if (autocompletable instanceof ApplicationCommandAutocompletable) {
            StringBuilder sb = new StringBuilder();
            sb.append(autocompletable.leadingIdentifier().getIdentifier());
            ApplicationCommandAutocompletable applicationCommandAutocompletable = (ApplicationCommandAutocompletable) autocompletable;
            sb.append(applicationCommandAutocompletable.getCommand().getName());
            sb.append(' ');
            String string = sb.toString();
            this.inputState = AutocompleteViewModel$InputState.copy$default(this.inputState, null, applicationCommandAutocompletable.getCommand(), null, null, null, 29, null);
            BehaviorSubject<InputEditTextAction> behaviorSubject = this.editTextAction;
            InputSelectionModel inputSelectionModel2 = this.lastChatInputModel;
            behaviorSubject.onNext(new InputEditTextAction$ReplaceText((inputSelectionModel2 == null || (inputModel2 = inputSelectionModel2.getInputModel()) == null || (input2 = inputModel2.getInput()) == null) ? "" : input2, string, 0, 4, null));
            return;
        }
        InputSelectionModel inputSelectionModel3 = this.lastChatInputModel;
        if (!(inputSelectionModel3 instanceof InputSelectionModel$CommandInputSelectionModel)) {
            if ((inputSelectionModel3 instanceof InputSelectionModel$MessageInputSelectionModel) || inputSelectionModel3 == null) {
                AutocompleteInputSelectionModel autocompleteInputSelectionModel = this.lastAutocompleteInputSelectionModel;
                if (autocompleteInputSelectionModel != null && (inputSelectionModel = autocompleteInputSelectionModel.getInputSelectionModel()) != null && (inputModel = inputSelectionModel.getInputModel()) != null && (input = inputModel.getInput()) != null) {
                    charSequence = input;
                }
                AutocompleteInputSelectionModel autocompleteInputSelectionModel2 = this.lastAutocompleteInputSelectionModel;
                autocompleteToken = autocompleteInputSelectionModel2 != null ? autocompleteInputSelectionModel2.getAutocompleteToken() : null;
                if (!autocompletable.getInputTextMatchers().isEmpty()) {
                    IntRange intRange = autocompleteToken != null ? new IntRange(autocompleteToken.getStartIndex(), autocompleteToken.getToken().length() + autocompleteToken.getStartIndex()) : new IntRange(charSequence.length(), charSequence.length());
                    String str = (String) u.first((List) autocompletable.getInputTextMatchers());
                    String str2 = str + ' ';
                    AutocompleteViewModel$InputState autocompleteViewModel$InputState = this.inputState;
                    Map mutableMap = h0.toMutableMap(autocompleteViewModel$InputState.getInputAutocompleteMap());
                    mutableMap.put(new IntRange(intRange.getFirst(), str.length() + intRange.getFirst()), autocompletable);
                    this.inputState = AutocompleteViewModel$InputState.copy$default(autocompleteViewModel$InputState, null, null, null, null, mutableMap, 15, null);
                    this.editTextAction.onNext(new InputEditTextAction$InsertText(charSequence, str2, intRange, str2.length() + intRange.getFirst()));
                    return;
                }
                return;
            }
            return;
        }
        InputSelectionModel$CommandInputSelectionModel inputSelectionModel$CommandInputSelectionModel = (InputSelectionModel$CommandInputSelectionModel) inputSelectionModel3;
        inputSelectionModel$CommandInputSelectionModel.getInputModel().getInputCommandContext().getSelectedCommand();
        ApplicationCommandOption selectedCommandOption = inputSelectionModel$CommandInputSelectionModel.getSelectedCommandOption();
        OptionRange optionRange = inputSelectionModel$CommandInputSelectionModel.getInputModel().getInputCommandOptionsRanges().get(selectedCommandOption);
        if (!(!autocompletable.getInputTextMatchers().isEmpty()) || selectedCommandOption == null || optionRange == null) {
            return;
        }
        String str3 = (String) u.first((List) autocompletable.getInputTextMatchers());
        String str4 = str3 + ' ';
        IntRange selection = inputSelectionModel3.getSelection();
        if (InputSelectionModelKt.hasSelectedFreeformInput(inputSelectionModel3)) {
            AutocompleteInputSelectionModel autocompleteInputSelectionModel3 = this.lastAutocompleteInputSelectionModel;
            autocompleteToken = autocompleteInputSelectionModel3 != null ? autocompleteInputSelectionModel3.getAutocompleteToken() : null;
            value = new IntRange(autocompleteToken != null ? autocompleteToken.getStartIndex() : selection.getFirst() - 1, selection.getLast());
        } else {
            value = optionRange.getValue();
        }
        AutocompleteViewModel$InputState autocompleteViewModel$InputState2 = this.inputState;
        Map mutableMap2 = h0.toMutableMap(autocompleteViewModel$InputState2.getInputAutocompleteMap());
        mutableMap2.put(new IntRange(optionRange.getValue().getFirst(), str3.length() + optionRange.getValue().getFirst()), autocompletable);
        this.inputState = AutocompleteViewModel$InputState.copy$default(autocompleteViewModel$InputState2, null, null, null, null, mutableMap2, 15, null);
        InputSelectionModel$CommandInputSelectionModel inputSelectionModel$CommandInputSelectionModel2 = (InputSelectionModel$CommandInputSelectionModel) inputSelectionModel3;
        this.editTextAction.onNext(new InputEditTextAction$InsertText(inputSelectionModel$CommandInputSelectionModel2.getInputModel().getInput(), str4, value, (str4.length() + inputSelectionModel$CommandInputSelectionModel2.getInputModel().getInput().length()) - (value.getLast() - value.getFirst())));
    }

    public final void selectCommandBrowserApplication(Application application) {
        Integer num;
        m.checkNotNullParameter(application, "application");
        AutocompleteViewModel$StoreState autocompleteViewModel$StoreState = this.storeState;
        if ((autocompleteViewModel$StoreState != null ? autocompleteViewModel$StoreState.getBrowserCommands() : null) == null || (num = this.inputState.getApplicationsPosition().get(Long.valueOf(application.getId()))) == null || !StoreStream.Companion.getApplicationCommands().hasFetchedApplicationCommands(application.getId())) {
            StoreStream.Companion.getApplicationCommands().requestDiscoverCommands(application.getId());
        } else {
            this.events.onNext(new Event$ScrollAutocompletablesToApplication(application.getId(), num.intValue()));
        }
        StoreStream.Companion.getAnalytics().trackApplicationCommandBrowserJump(application.getId());
    }

    @MainThread
    public final void selectCommandOption(ApplicationCommandOption applicationCommandsOption) {
        InputEditTextAction inputEditTextActionAppendParam$default;
        Attachment<?> attachment;
        m.checkNotNullParameter(applicationCommandsOption, "applicationCommandsOption");
        InputSelectionModel inputSelectionModel = this.lastChatInputModel;
        if (!(inputSelectionModel instanceof InputSelectionModel$CommandInputSelectionModel)) {
            boolean z2 = inputSelectionModel instanceof InputSelectionModel$MessageInputSelectionModel;
            return;
        }
        if (applicationCommandsOption.getType() == ApplicationCommandType.ATTACHMENT && (attachment = this.commandAttachments.get(applicationCommandsOption)) != null) {
            this.selectedOptionForAttachment = applicationCommandsOption;
            this.events.onNext(new Event$PreviewAttachment(attachment));
            return;
        }
        InputSelectionModel$CommandInputSelectionModel inputSelectionModel$CommandInputSelectionModel = (InputSelectionModel$CommandInputSelectionModel) inputSelectionModel;
        OptionRange optionRange = inputSelectionModel$CommandInputSelectionModel.getInputModel().getInputCommandOptionsRanges().get(applicationCommandsOption);
        IntRange value = optionRange != null ? optionRange.getValue() : null;
        if (value != null) {
            int iOrdinal = applicationCommandsOption.getType().ordinal();
            int i = 1;
            if (iOrdinal != 5 && iOrdinal != 6 && iOrdinal != 7 && iOrdinal != 8) {
                i = 0;
            }
            inputEditTextActionAppendParam$default = new InputEditTextAction$SelectText(inputSelectionModel$CommandInputSelectionModel.getInputModel().getInput(), new IntRange(value.getFirst() + i, value.getLast() + (value.getLast() != inputSelectionModel$CommandInputSelectionModel.getInputModel().getInput().length() ? -1 : 0)));
        } else {
            inputEditTextActionAppendParam$default = AutocompleteCommandUtils.appendParam$default(AutocompleteCommandUtils.INSTANCE, inputSelectionModel$CommandInputSelectionModel.getInputModel().getInput(), applicationCommandsOption, null, 4, null);
        }
        this.editTextAction.onNext(inputEditTextActionAppendParam$default);
    }

    @MainThread
    public final void selectStickerItem(Sticker sticker) {
        String strReplaceAfterLast$default;
        m.checkNotNullParameter(sticker, "sticker");
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        storeStream$Companion.getExpressionSuggestions().setExpressionSuggestionsEnabled(false);
        String string = this.inputState.getCurrentInput().toString();
        if (string.length() <= 1 || y.last(string) != ':') {
            strReplaceAfterLast$default = w.replaceAfterLast$default(string, MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR, "", null, 4, null);
        } else {
            String strSubstring = string.substring(0, w.getLastIndex(string));
            m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            strReplaceAfterLast$default = w.replaceAfterLast$default(strSubstring, MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR, "", null, 4, null);
        }
        String strSubstring2 = strReplaceAfterLast$default.substring(0, f.coerceAtLeast(strReplaceAfterLast$default.length() - 1, 0));
        m.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        this.editTextAction.onNext(new InputEditTextAction$ReplaceText(string, strSubstring2, strSubstring2.length()));
        AutocompleteInputSelectionModel autocompleteInputSelectionModel = this.lastAutocompleteInputSelectionModel;
        if (autocompleteInputSelectionModel != null) {
            storeStream$Companion.getAnalytics().trackAutocompleteSelect(storeStream$Companion.getChannelsSelected().getId(), autocompleteInputSelectionModel.getAutocompleteType(), autocompleteInputSelectionModel.getEmojiNumCount(), autocompleteInputSelectionModel.getStickerNumCount(), AutocompleteSelectionTypes.STICKER, "sticker", Long.valueOf(sticker.getId()));
        }
        storeStream$Companion.getStickers().onStickerUsed(sticker);
    }

    public final void setAttachment(Attachment<?> attachment) {
        CharSequence input;
        MentionInputModel inputModel;
        m.checkNotNullParameter(attachment, "attachment");
        ApplicationCommandOption applicationCommandOption = this.selectedOptionForAttachment;
        if (applicationCommandOption != null) {
            this.commandAttachments.put(applicationCommandOption, attachment);
            InputSelectionModel inputSelectionModel = this.lastChatInputModel;
            if (inputSelectionModel == null || (inputModel = inputSelectionModel.getInputModel()) == null || (input = inputModel.getInput()) == null) {
                input = "";
            }
            InputSelectionModel inputSelectionModel2 = this.lastChatInputModel;
            OptionRange optionRange = AutocompleteCommandUtils.INSTANCE.findOptionRanges(input, inputSelectionModel2 != null ? InputSelectionModelKt.getSelectedCommand(inputSelectionModel2) : null, this.commandAttachments).get(applicationCommandOption);
            IntRange intRange = optionRange != null ? new IntRange(optionRange.getParam().getFirst(), optionRange.getValue().getLast()) : new IntRange(input.length(), input.length());
            StringBuilder sbQ = a.Q(' ');
            sbQ.append(applicationCommandOption.getName());
            sbQ.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
            sbQ.append(attachment.getDisplayName());
            sbQ.append(' ');
            String string = sbQ.toString();
            this.editTextAction.onNext(new InputEditTextAction$InsertText(input, string, intRange, (string.length() + input.length()) - (intRange.getLast() - intRange.getFirst())));
        }
    }

    public final void setInputState(AutocompleteViewModel$InputState autocompleteViewModel$InputState) {
        m.checkNotNullParameter(autocompleteViewModel$InputState, "<set-?>");
        this.inputState = autocompleteViewModel$InputState;
    }

    public final void setLastJumpedSequenceId(int i) {
        this.lastJumpedSequenceId = i;
    }

    public final void setStoreState(AutocompleteViewModel$StoreState autocompleteViewModel$StoreState) {
        this.storeState = autocompleteViewModel$StoreState;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutocompleteViewModel(Long l, AppFlexInputViewModel appFlexInputViewModel, StoreApplicationCommands storeApplicationCommands, StoreExperiments storeExperiments, @ColorInt int i, @ColorInt int i2, @ColorInt int i3, Observable<AutocompleteViewModel$StoreState> observable) {
        super(new ViewState(AutocompleteViewState$Hidden.INSTANCE, SelectedCommandViewState$Hidden.INSTANCE));
        m.checkNotNullParameter(appFlexInputViewModel, "flexInputViewModel");
        m.checkNotNullParameter(storeApplicationCommands, "storeApplicationCommands");
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        m.checkNotNullParameter(observable, "storeObservable");
        this.channelId = l;
        this.flexInputViewModel = appFlexInputViewModel;
        this.storeApplicationCommands = storeApplicationCommands;
        this.storeExperiments = storeExperiments;
        this.defaultMentionColor = i;
        this.defaultCommandOptionBackgroundColor = i2;
        this.commandOptionErrorColor = i3;
        this.emojiAutocompleteUpsellEnabled = EmojiAutocompletePremiumUpsellFeatureFlag.Companion.getINSTANCE().isEnabled();
        this.logEmojiAutocompleteUpsellViewed = true;
        BehaviorSubject<MentionInputModel> behaviorSubjectK0 = BehaviorSubject.k0();
        this.inputMentionModelSubject = behaviorSubjectK0;
        BehaviorSubject<AutocompleteInputSelectionModel> behaviorSubjectK1 = BehaviorSubject.k0();
        this.autocompleteInputSelectionModelSubject = behaviorSubjectK1;
        BehaviorSubject<AutocompleteViewModel$SelectionState> behaviorSubjectK2 = BehaviorSubject.k0();
        this.inputSelectionSubject = behaviorSubjectK2;
        this.editTextAction = BehaviorSubject.k0();
        this.events = BehaviorSubject.k0();
        this.commandAttachments = new LinkedHashMap();
        this.inputState = new AutocompleteViewModel$InputState(null, null, null, null, null, 31, null);
        Observable observableT = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null).t(AutocompleteViewModel$1.INSTANCE);
        m.checkNotNullExpressionValue(observableT, "storeObservable\n        …ore Error\", it)\n        }");
        ObservableExtensionsKt.appSubscribe$default(observableT, AutocompleteViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AutocompleteViewModel$2(this), 62, (Object) null);
        Observable<AutocompleteViewModel$SelectionState> observableR = behaviorSubjectK2.r();
        m.checkNotNullExpressionValue(behaviorSubjectK0, "inputMentionModelSubject");
        Observable observableJ = Observable.j(observableR, ObservableExtensionsKt.computationLatest(behaviorSubjectK0), new AutocompleteViewModel$3(this));
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…inputModel)\n      }\n    }");
        ObservableExtensionsKt$filterNull$1 observableExtensionsKt$filterNull$1 = ObservableExtensionsKt$filterNull$1.INSTANCE;
        Observable observableY = observableJ.y(observableExtensionsKt$filterNull$1);
        ObservableExtensionsKt$filterNull$2 observableExtensionsKt$filterNull$2 = ObservableExtensionsKt$filterNull$2.INSTANCE;
        Observable observableG = observableY.G(observableExtensionsKt$filterNull$2);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableT2 = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableG), this, null, 2, null).t(AutocompleteViewModel$4.INSTANCE);
        m.checkNotNullExpressionValue(observableT2, "Observable.combineLatest…del Error\", it)\n        }");
        ObservableExtensionsKt.appSubscribe$default(observableT2, AutocompleteViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AutocompleteViewModel$5(this), 62, (Object) null);
        m.checkNotNullExpressionValue(behaviorSubjectK1, "autocompleteInputSelectionModelSubject");
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Observable observableT3 = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.leadingEdgeThrottle(behaviorSubjectK1, 100L, timeUnit)), this, null, 2, null).t(AutocompleteViewModel$6.INSTANCE);
        m.checkNotNullExpressionValue(observableT3, "autocompleteInputSelecti…del Error\", it)\n        }");
        ObservableExtensionsKt.appSubscribe$default(observableT3, AutocompleteViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AutocompleteViewModel$7(this), 62, (Object) null);
        m.checkNotNullExpressionValue(behaviorSubjectK1, "autocompleteInputSelectionModelSubject");
        Observable observableR2 = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(behaviorSubjectK1), this, null, 2, null).t(AutocompleteViewModel$8.INSTANCE).G(AutocompleteViewModel$9.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR2, "autocompleteInputSelecti…  .distinctUntilChanged()");
        Observable observableG2 = observableR2.y(observableExtensionsKt$filterNull$1).G(observableExtensionsKt$filterNull$2);
        m.checkNotNullExpressionValue(observableG2, "filter { it != null }.map { it!! }");
        Observable observableP = observableG2.u(new AutocompleteViewModel$10(this)).p(500L, timeUnit);
        m.checkNotNullExpressionValue(observableP, "autocompleteInputSelecti…0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableP, AutocompleteViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AutocompleteViewModel$11(this), 62, (Object) null);
        Observable observableR3 = behaviorSubjectK1.G(AutocompleteViewModel$12.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR3, "autocompleteInputSelecti… }.distinctUntilChanged()");
        StoreGuilds$Actions.requestMembers(this, observableR3, true);
        this.lastJumpedSequenceId = -1;
    }
}
