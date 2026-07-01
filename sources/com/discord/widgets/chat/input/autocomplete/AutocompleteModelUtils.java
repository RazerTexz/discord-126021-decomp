package com.discord.widgets.chat.input.autocomplete;

import com.discord.api.channel.ChannelUtils;
import com.discord.api.commands.ApplicationCommandAutocompleteChoice;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.commands.CommandChoice;
import com.discord.api.sticker.Sticker;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.models.commands.ApplicationSubCommand;
import com.discord.stores.CommandAutocompleteState;
import com.discord.stores.CommandAutocompleteState$Choices;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.string.StringUtilsKt;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.chat.input.autocomplete.sources.ApplicationCommandsAutocompletableSource;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.discord.widgets.chat.input.models.ApplicationCommandValue;
import com.discord.widgets.chat.input.models.AutocompleteInputSelectionModel;
import com.discord.widgets.chat.input.models.ChatInputMentionsMap;
import com.discord.widgets.chat.input.models.CommandOptionValue;
import com.discord.widgets.chat.input.models.InputSelectionModel;
import com.discord.widgets.chat.input.models.InputSelectionModel$CommandInputSelectionModel;
import com.discord.widgets.chat.input.models.InputSelectionModel$MessageInputSelectionModel;
import com.discord.widgets.chat.input.models.InputSelectionModelKt;
import com.discord.widgets.chat.input.models.MentionInputModel$VerifiedCommandInputModel;
import com.discord.widgets.chat.input.models.MentionToken;
import com.discord.widgets.chat.input.models.OptionRange;
import com.discord.widgets.chat.input.models.StringOptionValue;
import com.lytefast.flexinput.model.Attachment;
import d0.g0.t;
import d0.g0.w;
import d0.t.g0;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: AutocompleteModelUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteModelUtils {
    public static final AutocompleteModelUtils INSTANCE = new AutocompleteModelUtils();

    private AutocompleteModelUtils() {
    }

    private final MentionToken asMentionToken(String str, int i, boolean z2) {
        if (str != null) {
            Character chValueOf = ((t.isBlank(str) ^ true) && MentionUtilsKt.getDEFAULT_LEADING_IDENTIFIERS().contains(Character.valueOf(str.charAt(0)))) ? Character.valueOf(str.charAt(0)) : null;
            if (chValueOf != null || z2) {
                return new MentionToken(LeadingIdentifier.Companion.fromChar(chValueOf), str, i == 0, i);
            }
        }
        return null;
    }

    public static /* synthetic */ MentionToken asMentionToken$default(AutocompleteModelUtils autocompleteModelUtils, String str, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return autocompleteModelUtils.asMentionToken(str, i, z2);
    }

    public static /* synthetic */ ApplicationCommandData getApplicationSendData$default(AutocompleteModelUtils autocompleteModelUtils, AutocompleteInputSelectionModel autocompleteInputSelectionModel, ApplicationCommandOption applicationCommandOption, List list, List list2, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            applicationCommandOption = null;
        }
        return autocompleteModelUtils.getApplicationSendData(autocompleteInputSelectionModel, applicationCommandOption, list, list2, map);
    }

    private final boolean isSubRangeOf(IntRange intRange, IntRange intRange2) {
        return !intRange.equals(intRange2) && intRange2.contains(intRange.getFirst()) && intRange2.contains(intRange.getLast());
    }

    private final boolean lowerCaseContains(String str, String str2) {
        Locale locale = Locale.getDefault();
        m.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase(locale);
        m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        Locale locale2 = Locale.getDefault();
        m.checkNotNullExpressionValue(locale2, "Locale.getDefault()");
        Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
        String lowerCase2 = str2.toLowerCase(locale2);
        m.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
        return w.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null);
    }

    public final Map<LeadingIdentifier, List<Autocompletable>> filterAutocompletablesForInputContext(InputSelectionModel model) {
        List arrayList;
        List arrayList2;
        boolean canUserReadChannel;
        m.checkNotNullParameter(model, "model");
        List<? extends Autocompletable> listFlatten = o.flatten(model.getInputModel().getAutocompletables().values());
        if (model instanceof InputSelectionModel$MessageInputSelectionModel) {
            List<Autocompletable> listFilterAutocompletablesForMessageContext = filterAutocompletablesForMessageContext(listFlatten);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : listFilterAutocompletablesForMessageContext) {
                LeadingIdentifier leadingIdentifier = ((Autocompletable) obj).leadingIdentifier();
                Object arrayList3 = linkedHashMap.get(leadingIdentifier);
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList();
                    linkedHashMap.put(leadingIdentifier, arrayList3);
                }
                ((List) arrayList3).add(obj);
            }
            return linkedHashMap;
        }
        if (!(model instanceof InputSelectionModel$CommandInputSelectionModel)) {
            throw new NoWhenBranchMatchedException();
        }
        InputSelectionModel$CommandInputSelectionModel inputSelectionModel$CommandInputSelectionModel = (InputSelectionModel$CommandInputSelectionModel) model;
        ApplicationCommandOption selectedCommandOption = inputSelectionModel$CommandInputSelectionModel.getSelectedCommandOption();
        if (selectedCommandOption == null) {
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : listFlatten) {
                if (!(((Autocompletable) obj2) instanceof ApplicationCommandAutocompletable)) {
                    arrayList4.add(obj2);
                }
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj3 : arrayList4) {
                LeadingIdentifier leadingIdentifier2 = ((Autocompletable) obj3).leadingIdentifier();
                Object arrayList5 = linkedHashMap2.get(leadingIdentifier2);
                if (arrayList5 == null) {
                    arrayList5 = new ArrayList();
                    linkedHashMap2.put(leadingIdentifier2, arrayList5);
                }
                ((List) arrayList5).add(obj3);
            }
            return linkedHashMap2;
        }
        List<CommandChoice> choices = selectedCommandOption.getChoices();
        boolean z2 = true;
        if (choices != null && (!choices.isEmpty())) {
            List<Autocompletable> listCreateFromCommandOption = ApplicationCommandsAutocompletableSource.Companion.createFromCommandOption(selectedCommandOption);
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Object obj4 : listCreateFromCommandOption) {
                LeadingIdentifier leadingIdentifier3 = ((Autocompletable) obj4).leadingIdentifier();
                Object arrayList6 = linkedHashMap3.get(leadingIdentifier3);
                if (arrayList6 == null) {
                    arrayList6 = new ArrayList();
                    linkedHashMap3.put(leadingIdentifier3, arrayList6);
                }
                ((List) arrayList6).add(obj4);
            }
            return linkedHashMap3;
        }
        switch (selectedCommandOption.getType().ordinal()) {
            case 4:
                arrayList = ApplicationCommandsAutocompletableSource.Companion.createFromCommandOption(selectedCommandOption);
                break;
            case 5:
                arrayList = new ArrayList();
                for (Object obj5 : listFlatten) {
                    if (obj5 instanceof UserAutocompletable) {
                        arrayList.add(obj5);
                    }
                }
                break;
            case 6:
                arrayList = new ArrayList();
                for (Object obj6 : listFlatten) {
                    if (obj6 instanceof ChannelAutocompletable) {
                        arrayList.add(obj6);
                    }
                }
                List<Integer> channelTypes = selectedCommandOption.getChannelTypes();
                if (channelTypes != null && !channelTypes.isEmpty()) {
                    z2 = false;
                }
                if (!z2) {
                    arrayList2 = new ArrayList();
                    for (Object obj7 : arrayList) {
                        if (selectedCommandOption.getChannelTypes().contains(Integer.valueOf(((ChannelAutocompletable) obj7).getChannel().getType()))) {
                            arrayList2.add(obj7);
                        }
                    }
                    arrayList = arrayList2;
                }
                break;
            case 7:
                arrayList = new ArrayList();
                for (Object obj8 : listFlatten) {
                    if (obj8 instanceof RoleAutocompletable) {
                        arrayList.add(obj8);
                    }
                }
                break;
            case 8:
                arrayList = new ArrayList();
                for (Object obj9 : listFlatten) {
                    Autocompletable autocompletable = (Autocompletable) obj9;
                    if ((autocompletable instanceof UserAutocompletable) || (autocompletable instanceof RoleAutocompletable)) {
                        arrayList.add(obj9);
                    }
                }
                break;
            default:
                if (selectedCommandOption.getAutocomplete()) {
                    Map<String, CommandAutocompleteState> map = inputSelectionModel$CommandInputSelectionModel.getInputModel().getCommandOptionAutocompleteItems().get(selectedCommandOption.getName());
                    CommandAutocompleteState commandAutocompleteState = null;
                    if (map != null) {
                        CommandOptionValue commandOptionValue = inputSelectionModel$CommandInputSelectionModel.getInputModel().getInputCommandOptionValues().get(selectedCommandOption);
                        commandAutocompleteState = map.get(String.valueOf(commandOptionValue != null ? commandOptionValue.getValue() : null));
                    }
                    if (!(commandAutocompleteState instanceof CommandAutocompleteState$Choices)) {
                        arrayList = n.emptyList();
                    } else {
                        List<ApplicationCommandAutocompleteChoice> choices2 = ((CommandAutocompleteState$Choices) commandAutocompleteState).getChoices();
                        arrayList2 = new ArrayList(o.collectionSizeOrDefault(choices2, 10));
                        for (ApplicationCommandAutocompleteChoice applicationCommandAutocompleteChoice : choices2) {
                            arrayList2.add(new ApplicationCommandChoiceAutocompletable(new CommandChoice(applicationCommandAutocompleteChoice.getName(), applicationCommandAutocompleteChoice.getValue()), selectedCommandOption.getName()));
                        }
                    }
                    break;
                } else {
                    List listPlus = u.plus((Collection) ApplicationCommandsAutocompletableSource.Companion.createFromCommandOption(selectedCommandOption), (Iterable) listFlatten);
                    arrayList2 = new ArrayList();
                    for (Object obj10 : listPlus) {
                        Autocompletable autocompletable2 = (Autocompletable) obj10;
                        if (autocompletable2 instanceof ChannelAutocompletable) {
                            canUserReadChannel = ChannelUtils.v(((ChannelAutocompletable) autocompletable2).getChannel());
                        } else if (autocompletable2 instanceof UserAutocompletable) {
                            canUserReadChannel = ((UserAutocompletable) autocompletable2).getCanUserReadChannel();
                        } else {
                            canUserReadChannel = !(autocompletable2 instanceof ApplicationCommandAutocompletable);
                        }
                        if (canUserReadChannel) {
                            arrayList2.add(obj10);
                        }
                    }
                }
                arrayList = arrayList2;
                break;
        }
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        for (Object obj11 : arrayList) {
            LeadingIdentifier leadingIdentifier4 = ((Autocompletable) obj11).leadingIdentifier();
            Object arrayList7 = linkedHashMap4.get(leadingIdentifier4);
            if (arrayList7 == null) {
                arrayList7 = new ArrayList();
                linkedHashMap4.put(leadingIdentifier4, arrayList7);
            }
            ((List) arrayList7).add(obj11);
        }
        return linkedHashMap4;
    }

    public final List<Autocompletable> filterAutocompletablesForMessageContext(List<? extends Autocompletable> autocompletables) {
        boolean canMention;
        m.checkNotNullParameter(autocompletables, "autocompletables");
        ArrayList arrayList = new ArrayList();
        for (Object obj : autocompletables) {
            Autocompletable autocompletable = (Autocompletable) obj;
            if (autocompletable instanceof ChannelAutocompletable) {
                canMention = ChannelUtils.v(((ChannelAutocompletable) autocompletable).getChannel());
            } else if (autocompletable instanceof UserAutocompletable) {
                canMention = ((UserAutocompletable) autocompletable).getCanUserReadChannel();
            } else {
                canMention = autocompletable instanceof RoleAutocompletable ? ((RoleAutocompletable) autocompletable).getCanMention() : true;
            }
            if (canMention) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final List<Autocompletable> filterMentionsFromToken(MentionToken token, InputSelectionModel inputSelectionModel, Map<LeadingIdentifier, ? extends List<? extends Autocompletable>> mentions) {
        ArrayList arrayList;
        ApplicationCommandOption selectedCommandOption;
        m.checkNotNullParameter(token, "token");
        m.checkNotNullParameter(inputSelectionModel, "inputSelectionModel");
        m.checkNotNullParameter(mentions, "mentions");
        if ((inputSelectionModel instanceof InputSelectionModel$CommandInputSelectionModel) && (selectedCommandOption = ((InputSelectionModel$CommandInputSelectionModel) inputSelectionModel).getSelectedCommandOption()) != null && selectedCommandOption.getAutocomplete()) {
            return InputAutocompletablesKt.flatten(mentions);
        }
        boolean z2 = t.isBlank(token.getFormattedToken()) && token.getLeadingIdentifier() == LeadingIdentifier.NONE;
        String formattedToken = token.getFormattedToken();
        Locale locale = Locale.getDefault();
        m.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        Objects.requireNonNull(formattedToken, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = formattedToken.toLowerCase(locale);
        m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        String strReplace$default = t.replace$default(StringUtilsKt.stripAccents(lowerCase), " ", "", false, 4, (Object) null);
        if (z2 && InputSelectionModelKt.hasSelectedCommandOptionWithChoices(inputSelectionModel)) {
            List<? extends Autocompletable> list = mentions.get(LeadingIdentifier.NONE);
            if (list != null) {
                arrayList = new ArrayList();
                for (Object obj : list) {
                    if (obj instanceof ApplicationCommandChoiceAutocompletable) {
                        arrayList.add(obj);
                    }
                }
            } else {
                arrayList = null;
            }
            return arrayList != null ? arrayList : n.emptyList();
        }
        if (z2) {
            return n.emptyList();
        }
        ArrayList arrayList2 = new ArrayList();
        List<? extends Autocompletable> list2 = mentions.get(token.getLeadingIdentifier());
        if (list2 != null) {
            for (Autocompletable autocompletable : list2) {
                Iterator<String> itIterateAutocompleteMatchers = autocompletable.iterateAutocompleteMatchers();
                while (itIterateAutocompleteMatchers.hasNext()) {
                    String next = itIterateAutocompleteMatchers.next();
                    Locale locale2 = Locale.getDefault();
                    m.checkNotNullExpressionValue(locale2, "Locale.getDefault()");
                    Objects.requireNonNull(next, "null cannot be cast to non-null type java.lang.String");
                    String lowerCase2 = next.toLowerCase(locale2);
                    m.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                    if (INSTANCE.lowerCaseContains(t.replace$default(StringUtilsKt.stripAccents(lowerCase2), " ", "", false, 4, (Object) null), strReplace$default)) {
                        arrayList2.add(autocompletable);
                        break;
                    }
                }
            }
        }
        return arrayList2;
    }

    public final ApplicationCommandData getApplicationSendData(AutocompleteInputSelectionModel inputSelectionModel, ApplicationCommandOption focusedOption, List<Application> applications, List<? extends ApplicationCommand> queryCommands, Map<ApplicationCommandOption, ? extends Attachment<?>> attachments) {
        boolean z2;
        ApplicationCommandValue applicationCommandValue;
        boolean z3;
        ApplicationCommandValue applicationCommandValue2;
        OptionRange optionRange;
        IntRange value;
        boolean z4;
        m.checkNotNullParameter(applications, "applications");
        m.checkNotNullParameter(queryCommands, "queryCommands");
        m.checkNotNullParameter(attachments, "attachments");
        InputSelectionModel inputSelectionModel2 = inputSelectionModel != null ? inputSelectionModel.getInputSelectionModel() : null;
        if (!(inputSelectionModel2 instanceof InputSelectionModel$CommandInputSelectionModel)) {
            return null;
        }
        InputSelectionModel$CommandInputSelectionModel inputSelectionModel$CommandInputSelectionModel = (InputSelectionModel$CommandInputSelectionModel) inputSelectionModel2;
        ApplicationCommand selectedCommand = inputSelectionModel$CommandInputSelectionModel.getInputModel().getInputCommandContext().getSelectedCommand();
        Application selectedApplication = inputSelectionModel$CommandInputSelectionModel.getInputModel().getInputCommandContext().getSelectedApplication();
        MentionInputModel$VerifiedCommandInputModel inputModel = inputSelectionModel$CommandInputSelectionModel.getInputModel();
        if (!(inputModel instanceof MentionInputModel$VerifiedCommandInputModel)) {
            inputModel = null;
        }
        if (inputModel == null && selectedCommand != null && selectedApplication != null) {
            List listEmptyList = n.emptyList();
            List<ApplicationCommandOption> options = selectedCommand.getOptions();
            if ((options instanceof Collection) && options.isEmpty()) {
                z4 = true;
            } else {
                Iterator<T> it = options.iterator();
                while (it.hasNext()) {
                    if (!(!((ApplicationCommandOption) it.next()).getRequired())) {
                        z4 = false;
                    }
                }
                z4 = true;
            }
            return new ApplicationCommandData(selectedApplication, selectedCommand, listEmptyList, z4);
        }
        if (inputModel == null || selectedCommand == null || selectedApplication == null) {
            return null;
        }
        Map<ApplicationCommandOption, CommandOptionValue> inputCommandOptionValues = inputModel.getInputCommandOptionValues();
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(inputCommandOptionValues.size()));
        Iterator<T> it2 = inputCommandOptionValues.entrySet().iterator();
        while (it2.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it2.next();
            Object key = map$Entry.getKey();
            Object value2 = ((CommandOptionValue) map$Entry.getValue()).getValue();
            if (map$Entry.getValue() instanceof StringOptionValue) {
                List<CommandChoice> choices = ((ApplicationCommandOption) map$Entry.getKey()).getChoices();
                if ((choices == null || choices.isEmpty()) && !((ApplicationCommandOption) map$Entry.getKey()).getAutocomplete() && (optionRange = inputModel.getInputCommandOptionsRanges().get(map$Entry.getKey())) != null && (value = optionRange.getValue()) != null) {
                    int first = value.getFirst();
                    String string = ((CommandOptionValue) map$Entry.getValue()).getValue().toString();
                    Map<IntRange, Autocompletable> inputMentionsMap = inputModel.getInputMentionsMap();
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(g0.mapCapacity(inputMentionsMap.size()));
                    Iterator<T> it3 = inputMentionsMap.entrySet().iterator();
                    while (it3.hasNext()) {
                        Map$Entry map$Entry2 = (Map$Entry) it3.next();
                        linkedHashMap2.put(new IntRange(((IntRange) map$Entry2.getKey()).getFirst() - first, ((IntRange) map$Entry2.getKey()).getLast() - first), map$Entry2.getValue());
                    }
                    LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                    for (Map$Entry map$Entry3 : linkedHashMap2.entrySet()) {
                        if (((IntRange) map$Entry3.getKey()).getFirst() >= 0 && ((IntRange) map$Entry3.getKey()).getLast() <= string.length()) {
                            linkedHashMap3.put(map$Entry3.getKey(), map$Entry3.getValue());
                        }
                    }
                    value2 = AutocompleteExtensionsKt.replaceAutocompleteDataWithServerValues(string, linkedHashMap3);
                }
            }
            linkedHashMap.put(key, value2);
        }
        Map<ApplicationCommandOption, Boolean> inputCommandOptionValidity = inputModel.getInputCommandOptionValidity();
        if (!(selectedCommand instanceof ApplicationSubCommand)) {
            Collection<Boolean> collectionValues = inputCommandOptionValidity.values();
            if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
                Iterator<T> it4 = collectionValues.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        z2 = true;
                        break;
                    }
                    if (!((Boolean) it4.next()).booleanValue()) {
                        z2 = false;
                        break;
                    }
                }
            } else {
                z2 = true;
                break;
            }
            Set<ApplicationCommandOption> setKeySet = linkedHashMap.keySet();
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(setKeySet, 10));
            for (ApplicationCommandOption applicationCommandOption : setKeySet) {
                boolean zAreEqual = m.areEqual(focusedOption != null ? focusedOption.getName() : null, applicationCommandOption.getName());
                boolean z5 = (applicationCommandOption.getRequired() && linkedHashMap.get(applicationCommandOption) == null && !applicationCommandOption.getAutocomplete()) || m.areEqual(inputCommandOptionValidity.get(applicationCommandOption), Boolean.FALSE);
                z2 = z2 && !z5;
                Object obj = (!z5 || (zAreEqual && applicationCommandOption.getAutocomplete())) ? linkedHashMap.get(applicationCommandOption) : null;
                if (obj != null || applicationCommandOption.getAutocomplete()) {
                    applicationCommandValue = new ApplicationCommandValue(applicationCommandOption.getName(), obj != null ? obj : "", applicationCommandOption.getType().getType(), null, zAreEqual ? Boolean.TRUE : null, 8, null);
                } else {
                    applicationCommandValue = null;
                }
                arrayList.add(applicationCommandValue);
            }
            return new ApplicationCommandData(selectedApplication, selectedCommand, u.filterNotNull(arrayList), z2);
        }
        Collection<Boolean> collectionValues2 = inputCommandOptionValidity.values();
        if (!(collectionValues2 instanceof Collection) || !collectionValues2.isEmpty()) {
            Iterator<T> it5 = collectionValues2.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    z3 = true;
                    break;
                }
                if (!((Boolean) it5.next()).booleanValue()) {
                    z3 = false;
                    break;
                }
            }
        } else {
            z3 = true;
            break;
        }
        Set<ApplicationCommandOption> setKeySet2 = linkedHashMap.keySet();
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(setKeySet2, 10));
        for (ApplicationCommandOption applicationCommandOption2 : setKeySet2) {
            boolean zAreEqual2 = m.areEqual(focusedOption != null ? focusedOption.getName() : null, applicationCommandOption2.getName());
            boolean z6 = (applicationCommandOption2.getRequired() && linkedHashMap.get(applicationCommandOption2) == null && !applicationCommandOption2.getAutocomplete()) || m.areEqual(inputCommandOptionValidity.get(applicationCommandOption2), Boolean.FALSE);
            z3 = z3 && !z6;
            Object obj2 = (!z6 || (zAreEqual2 && applicationCommandOption2.getAutocomplete())) ? linkedHashMap.get(applicationCommandOption2) : null;
            if (obj2 != null || applicationCommandOption2.getAutocomplete()) {
                applicationCommandValue2 = new ApplicationCommandValue(applicationCommandOption2.getName(), obj2 != null ? obj2 : "", applicationCommandOption2.getType().getType(), null, zAreEqual2 ? Boolean.TRUE : null, 8, null);
            } else {
                applicationCommandValue2 = null;
            }
            arrayList2.add(applicationCommandValue2);
        }
        ApplicationSubCommand applicationSubCommand = (ApplicationSubCommand) selectedCommand;
        ApplicationCommandValue applicationCommandValue3 = new ApplicationCommandValue(applicationSubCommand.getSubCommandName(), null, ApplicationCommandType.SUBCOMMAND.getType(), u.filterNotNull(arrayList2), null, 18, null);
        String parentGroupName = applicationSubCommand.getParentGroupName();
        return parentGroupName != null ? new ApplicationCommandData(selectedApplication, applicationSubCommand.getRootCommand(), d0.t.m.listOf(new ApplicationCommandValue(parentGroupName, null, ApplicationCommandType.SUBCOMMAND_GROUP.getType(), d0.t.m.listOf(applicationCommandValue3), null, 18, null)), z3) : new ApplicationCommandData(selectedApplication, applicationSubCommand.getRootCommand(), d0.t.m.listOf(applicationCommandValue3), z3);
    }

    public final MentionToken getCommandAutocompleteToken(CharSequence input, IntRange selection, ApplicationCommandOption selectedCommandOption, boolean hasSelectedFreeformInputOption, Map<ApplicationCommandOption, OptionRange> inputCommandOptionsRanges, Map<ApplicationCommandOption, ? extends CommandOptionValue> inputCommandOptionValues) {
        String strSubstring;
        m.checkNotNullParameter(input, "input");
        m.checkNotNullParameter(selection, "selection");
        m.checkNotNullParameter(selectedCommandOption, "selectedCommandOption");
        m.checkNotNullParameter(inputCommandOptionsRanges, "inputCommandOptionsRanges");
        m.checkNotNullParameter(inputCommandOptionValues, "inputCommandOptionValues");
        Pair<String, Integer> selectedToken = MentionUtilsKt.getSelectedToken(input.toString(), selection.getFirst());
        String strComponent1 = selectedToken.component1();
        int iIntValue = selectedToken.component2().intValue();
        if (strComponent1 != null) {
            strSubstring = w.removePrefix(strComponent1, selectedCommandOption.getName() + ":");
        } else {
            strSubstring = null;
        }
        if (hasSelectedFreeformInputOption) {
            return asMentionToken$default(this, strSubstring, iIntValue, false, 2, null);
        }
        OptionRange optionRange = inputCommandOptionsRanges.get(selectedCommandOption);
        IntRange value = optionRange != null ? optionRange.getValue() : null;
        CommandOptionValue commandOptionValue = inputCommandOptionValues.get(selectedCommandOption);
        if (value != null && commandOptionValue != null && selection.getFirst() > value.getFirst()) {
            String string = commandOptionValue.getValue().toString();
            int iMin = Math.min(selection.getFirst() - value.getFirst(), commandOptionValue.getValue().toString().length());
            Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
            strSubstring = string.substring(0, iMin);
            m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        if (strSubstring == null) {
            strSubstring = "";
        }
        return asMentionToken(strSubstring, iIntValue, true);
    }

    public final MentionToken getMessageAutocompleteToken(CharSequence input, IntRange selection) {
        int i;
        String strGroup;
        m.checkNotNullParameter(input, "input");
        m.checkNotNullParameter(selection, "selection");
        Pair<String, Integer> selectedToken = MentionUtilsKt.getSelectedToken(input.toString(), selection.getFirst());
        String strComponent1 = selectedToken.component1();
        int iIntValue = selectedToken.component2().intValue();
        Pattern patternCompile = Pattern.compile("^(/([a-zA-Z0-9_-]+\\s*){1,3})(.|\\n)*");
        m.checkNotNullExpressionValue(patternCompile, "Pattern.compile(\"^(/([a-…_-]+\\\\s*){1,3})(.|\\\\n)*\")");
        Matcher matcher = patternCompile.matcher(input);
        if (matcher.matches()) {
            strGroup = matcher.group(0);
            i = 0;
        } else {
            i = iIntValue;
            strGroup = strComponent1;
        }
        return asMentionToken$default(this, strGroup, i, false, 2, null);
    }

    public final List<Sticker> getStickerMatches(MentionToken token) throws IOException {
        if ((token != null ? token.getLeadingIdentifier() : null) == LeadingIdentifier.EMOJI_AND_STICKERS) {
            String token2 = token.getToken();
            StringBuilder sb = new StringBuilder();
            int length = token2.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = token2.charAt(i);
                if (Character.isLetterOrDigit(cCharAt)) {
                    sb.append(cCharAt);
                }
            }
            String string = sb.toString();
            m.checkNotNullExpressionValue(string, "filterTo(StringBuilder(), predicate).toString()");
            if (string.length() - 1 >= 3) {
                StickerUtils stickerUtils = StickerUtils.INSTANCE;
                return u.toList(stickerUtils.findStickerMatches(t.replace(token.getToken(), token.getLeadingIdentifier().toString(), "", true), StickerUtils.getStickersForAutocomplete$default(stickerUtils, null, null, null, null, null, 31, null), true));
            }
        }
        return n.emptyList();
    }

    public final boolean isBoolean(String str) {
        String lowerCase;
        if (str != null) {
            Locale locale = Locale.getDefault();
            m.checkNotNullExpressionValue(locale, "Locale.getDefault()");
            lowerCase = str.toLowerCase(locale);
            m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        } else {
            lowerCase = null;
        }
        return m.areEqual(lowerCase, "true") || m.areEqual(lowerCase, "false");
    }

    public final ChatInputMentionsMap mapInputToMentions(String input, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> autocompletables, Map<IntRange, ? extends Autocompletable> currentInputMentionMap, boolean isCommand) {
        boolean z2;
        m.checkNotNullParameter(input, "input");
        m.checkNotNullParameter(autocompletables, "autocompletables");
        m.checkNotNullParameter(currentInputMentionMap, "currentInputMentionMap");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Iterator<Map$Entry<LeadingIdentifier, ? extends Set<? extends Autocompletable>>> it = autocompletables.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map$Entry<LeadingIdentifier, ? extends Set<? extends Autocompletable>> next = it.next();
            Character identifier = next.getKey().getIdentifier();
            if (identifier == null || w.contains$default((CharSequence) input, identifier.charValue(), false, 2, (Object) null)) {
                linkedHashMap2.put(next.getKey(), next.getValue());
            }
        }
        List<Autocompletable> listPlus = u.plus((Collection) o.flatten(linkedHashMap2.values()), (Iterable) currentInputMentionMap.values());
        if (!isCommand) {
            listPlus = filterAutocompletablesForMessageContext(listPlus);
        }
        for (Autocompletable autocompletable : listPlus) {
            Iterator<String> itIterateTextMatchers = autocompletable.iterateTextMatchers();
            while (itIterateTextMatchers.hasNext()) {
                String next2 = itIterateTextMatchers.next();
                int iIndexOf$default = w.indexOf$default((CharSequence) input, next2, 0, false, 4, (Object) null);
                while (iIndexOf$default != -1) {
                    IntRange intRange = new IntRange(iIndexOf$default, next2.length() + iIndexOf$default);
                    if (!linkedHashMap.isEmpty()) {
                        Iterator it2 = linkedHashMap.entrySet().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                Map$Entry map$Entry = (Map$Entry) it2.next();
                                IntRange intRange2 = (IntRange) map$Entry.getKey();
                                Autocompletable autocompletable2 = (Autocompletable) map$Entry.getValue();
                                if (!m.areEqual(intRange, intRange2) || !(autocompletable instanceof RoleAutocompletable) || (autocompletable2 instanceof RoleAutocompletable)) {
                                    AutocompleteModelUtils autocompleteModelUtils = INSTANCE;
                                    if (!autocompleteModelUtils.isSubRangeOf(intRange2, intRange)) {
                                        if (m.areEqual(intRange, intRange2) || autocompleteModelUtils.isSubRangeOf(intRange, intRange2)) {
                                            z2 = false;
                                        }
                                    }
                                }
                                it2.remove();
                            } else {
                                z2 = true;
                            }
                        }
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        Autocompletable autocompletable3 = currentInputMentionMap.get(intRange);
                        if (autocompletable3 != null) {
                            linkedHashMap.put(intRange, autocompletable3);
                        } else {
                            linkedHashMap.put(intRange, autocompletable);
                        }
                    }
                    iIndexOf$default = w.indexOf$default((CharSequence) input, next2, iIndexOf$default + 1, false, 4, (Object) null);
                }
            }
        }
        return new ChatInputMentionsMap(input, linkedHashMap);
    }

    public final IntRange shiftOrRemove(IntRange intRange, int i, int i2, int i3) {
        m.checkNotNullParameter(intRange, "$this$shiftOrRemove");
        if (i >= intRange.getLast()) {
            return intRange;
        }
        int i4 = (i + i3) - i2;
        int i5 = i + i2;
        int i6 = i3 - i2;
        if (i < intRange.getFirst() && i5 >= intRange.getFirst()) {
            return null;
        }
        if (i > intRange.getFirst() && i < intRange.getLast()) {
            return null;
        }
        if (i >= intRange.getFirst() && i < intRange.getLast() && i2 > 0) {
            return null;
        }
        if (intRange.getFirst() >= i4 || (intRange.getFirst() == i && i2 == 0)) {
            return new IntRange(intRange.getFirst() + i6, intRange.getLast() + i6);
        }
        return null;
    }
}
