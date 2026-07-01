package com.discord.widgets.chat.input.autocomplete.commands;

import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import b.d.b.a.outline;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommand2;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.stores.StoreApplicationCommandsKt;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.chat.input.autocomplete.InputEditTextAction;
import com.discord.widgets.chat.input.models.AutocompleteApplicationCommands;
import com.discord.widgets.chat.input.models.CommandOptionValue;
import com.discord.widgets.chat.input.models.InputCommandContext;
import com.discord.widgets.chat.input.models.MentionInputModel;
import com.discord.widgets.chat.input.models.OptionRange;
import com.lytefast.flexinput.model.Attachment;
import d0.g0.Regex2;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.ranges.Ranges2;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: compiled from: AutocompleteCommandUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteCommandUtils {
    public static final AutocompleteCommandUtils INSTANCE = new AutocompleteCommandUtils();

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            ApplicationCommandType.values();
            int[] iArr = new int[12];
            $EnumSwitchMapping$0 = iArr;
            ApplicationCommandType applicationCommandType = ApplicationCommandType.USER;
            iArr[applicationCommandType.ordinal()] = 1;
            ApplicationCommandType applicationCommandType2 = ApplicationCommandType.CHANNEL;
            iArr[applicationCommandType2.ordinal()] = 2;
            ApplicationCommandType applicationCommandType3 = ApplicationCommandType.ROLE;
            iArr[applicationCommandType3.ordinal()] = 3;
            ApplicationCommandType applicationCommandType4 = ApplicationCommandType.MENTIONABLE;
            iArr[applicationCommandType4.ordinal()] = 4;
            ApplicationCommandType.values();
            int[] iArr2 = new int[12];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ApplicationCommandType.SUBCOMMAND.ordinal()] = 1;
            iArr2[ApplicationCommandType.SUBCOMMAND_GROUP.ordinal()] = 2;
            ApplicationCommandType applicationCommandType5 = ApplicationCommandType.STRING;
            iArr2[applicationCommandType5.ordinal()] = 3;
            ApplicationCommandType applicationCommandType6 = ApplicationCommandType.INTEGER;
            iArr2[applicationCommandType6.ordinal()] = 4;
            ApplicationCommandType applicationCommandType7 = ApplicationCommandType.NUMBER;
            iArr2[applicationCommandType7.ordinal()] = 5;
            ApplicationCommandType applicationCommandType8 = ApplicationCommandType.BOOLEAN;
            iArr2[applicationCommandType8.ordinal()] = 6;
            iArr2[applicationCommandType.ordinal()] = 7;
            iArr2[applicationCommandType2.ordinal()] = 8;
            iArr2[applicationCommandType3.ordinal()] = 9;
            iArr2[applicationCommandType4.ordinal()] = 10;
            iArr2[ApplicationCommandType.UNKNOWN.ordinal()] = 11;
            ApplicationCommandType applicationCommandType9 = ApplicationCommandType.ATTACHMENT;
            iArr2[applicationCommandType9.ordinal()] = 12;
            ApplicationCommandType.values();
            int[] iArr3 = new int[12];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[applicationCommandType5.ordinal()] = 1;
            iArr3[applicationCommandType6.ordinal()] = 2;
            iArr3[applicationCommandType7.ordinal()] = 3;
            iArr3[applicationCommandType8.ordinal()] = 4;
            iArr3[applicationCommandType.ordinal()] = 5;
            iArr3[applicationCommandType2.ordinal()] = 6;
            iArr3[applicationCommandType3.ordinal()] = 7;
            iArr3[applicationCommandType4.ordinal()] = 8;
            iArr3[applicationCommandType9.ordinal()] = 9;
        }
    }

    private AutocompleteCommandUtils() {
    }

    public static /* synthetic */ InputEditTextAction.InsertText appendParam$default(AutocompleteCommandUtils autocompleteCommandUtils, CharSequence charSequence, ApplicationCommandOption applicationCommandOption, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        return autocompleteCommandUtils.appendParam(charSequence, applicationCommandOption, num);
    }

    private final Number asSafeNumberOrNull(Number number) {
        if (number == null || !INSTANCE.isSafeNumber(number)) {
            return null;
        }
        return number;
    }

    public static /* synthetic */ InputCommandContext getInputCommandContext$default(AutocompleteCommandUtils autocompleteCommandUtils, CharSequence charSequence, long j, List list, AutocompleteApplicationCommands autocompleteApplicationCommands, ApplicationCommand applicationCommand, int i, Object obj) {
        if ((i & 16) != 0) {
            applicationCommand = null;
        }
        return autocompleteCommandUtils.getInputCommandContext(charSequence, j, list, autocompleteApplicationCommands, applicationCommand);
    }

    private final boolean isSafeNumber(Number number) {
        double dDoubleValue = number.doubleValue();
        return dDoubleValue >= ((double) (-9007199254740991L)) && dDoubleValue <= ((double) 9007199254740991L);
    }

    private final Number parseNumber(String str) {
        if (str == null) {
            return null;
        }
        try {
            ParsePosition parsePosition = new ParsePosition(0);
            Number number = NumberFormat.getInstance().parse(str, parsePosition);
            if (parsePosition.getIndex() != str.length() || parsePosition.getIndex() == 0) {
                throw new ParseException("Invalid input", parsePosition.getIndex());
            }
            return number;
        } catch (ParseException unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004f  */
    @MainThread
    public final InputEditTextAction.InsertText appendParam(CharSequence input, ApplicationCommandOption applicationCommandsOption, Integer insertIndex) {
        Intrinsics3.checkNotNullParameter(input, "input");
        Intrinsics3.checkNotNullParameter(applicationCommandsOption, "applicationCommandsOption");
        input.length();
        String str = "";
        StringBuilder sbU = outline.U((Strings4.endsWith$default(input, ' ', false, 2, (Object) null) || insertIndex != null) ? "" : " ");
        sbU.append(applicationCommandsOption.getName());
        sbU.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        String string = sbU.toString();
        int iOrdinal = applicationCommandsOption.getType().ordinal();
        if (iOrdinal == 5) {
            str = "@";
        } else if (iOrdinal == 6) {
            str = "#";
        } else if (iOrdinal == 7 || iOrdinal == 8) {
            str = "@";
        }
        String strW = outline.w(string, str);
        int iIntValue = insertIndex != null ? insertIndex.intValue() : input.length();
        return new InputEditTextAction.InsertText(input, strW, new Ranges2(iIntValue, iIntValue), strW.length() + input.length());
    }

    @MainThread
    public final InputEditTextAction appendTextForCommandForInput(MentionInputModel.VerifiedCommandInputModel model) {
        Intrinsics3.checkNotNullParameter(model, "model");
        ApplicationCommand selectedCommand = model.getInputCommandContext().getSelectedCommand();
        if (selectedCommand != null && selectedCommand.getOptions().size() == 1) {
            ApplicationCommandOption applicationCommandOption = (ApplicationCommandOption) _Collections.first((List) selectedCommand.getOptions());
            StringBuilder sbQ = outline.Q(MentionUtils.SLASH_CHAR);
            sbQ.append(selectedCommand.getName());
            sbQ.append(' ');
            String string = sbQ.toString();
            if (!model.getInputCommandOptionsRanges().containsKey(applicationCommandOption) && model.getInput().length() > string.length() && applicationCommandOption.getType() != ApplicationCommandType.ATTACHMENT) {
                return appendParam(model.getInput(), applicationCommandOption, Integer.valueOf(string.length()));
            }
        }
        return new InputEditTextAction.None(model.getInput());
    }

    public final Map<ApplicationCommandOption, OptionRange> findOptionRanges(CharSequence charSequence, ApplicationCommand applicationCommand, Map<ApplicationCommandOption, ? extends Attachment<?>> map) {
        List<ApplicationCommandOption> options;
        Ranges2 ranges2FindValueRange;
        Intrinsics3.checkNotNullParameter(charSequence, "$this$findOptionRanges");
        Intrinsics3.checkNotNullParameter(map, "attachments");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (applicationCommand != null && (options = applicationCommand.getOptions()) != null) {
            for (ApplicationCommandOption applicationCommandOption : options) {
                AutocompleteCommandUtils autocompleteCommandUtils = INSTANCE;
                Integer numFindStartOfParam = autocompleteCommandUtils.findStartOfParam(charSequence, applicationCommandOption.getName());
                if (numFindStartOfParam != null && (ranges2FindValueRange = autocompleteCommandUtils.findValueRange(charSequence, applicationCommand, applicationCommandOption.getName())) != null) {
                    Attachment<?> attachment = map.get(applicationCommandOption);
                    String displayName = attachment != null ? attachment.getDisplayName() : null;
                }
            }
        }
        return linkedHashMap;
    }

    @VisibleForTesting
    public final Integer findStartOfParam(CharSequence charSequence, String str) {
        Ranges2 range;
        Intrinsics3.checkNotNullParameter(charSequence, "$this$findStartOfParam");
        Intrinsics3.checkNotNullParameter(str, "paramName");
        MatchResult matchResultFind$default = Regex.find$default(new Regex("[\\s|\\n]" + str + MentionUtils.EMOJIS_AND_STICKERS_CHAR), charSequence, 0, 2, null);
        int first = (matchResultFind$default == null || (range = matchResultFind$default.getRange()) == null) ? -1 : range.getFirst();
        if (first == -1) {
            return null;
        }
        return Integer.valueOf(first + 1);
    }

    @VisibleForTesting
    public final Integer findStartOfValue(CharSequence charSequence, String str) {
        Intrinsics3.checkNotNullParameter(charSequence, "$this$findStartOfValue");
        Intrinsics3.checkNotNullParameter(str, "paramName");
        Integer numFindStartOfParam = findStartOfParam(charSequence, str);
        int iIntValue = numFindStartOfParam != null ? numFindStartOfParam.intValue() : -1;
        if (iIntValue != -1) {
            return Integer.valueOf(str.length() + iIntValue + 1);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ae  */
    public final Ranges2 findValueRange(CharSequence charSequence, ApplicationCommand applicationCommand, String str) {
        int first;
        Regex2 next;
        Ranges2 range;
        ApplicationCommandOption applicationCommandOption;
        List<ApplicationCommandOption> options;
        Object next2;
        Intrinsics3.checkNotNullParameter(charSequence, "$this$findValueRange");
        Intrinsics3.checkNotNullParameter(str, "paramName");
        Integer numFindStartOfValue = findStartOfValue(charSequence, str);
        if (numFindStartOfValue == null) {
            return null;
        }
        int iIntValue = numFindStartOfValue.intValue();
        Iterator it = Regex.findAll$default(new Regex(" ([\\p{L}0-9-_]*):"), charSequence.subSequence(iIntValue, charSequence.length()).toString(), 0, 2, null).iterator();
        while (it.hasNext()) {
            Iterator<Regex2> it2 = ((MatchResult) it.next()).getGroups().iterator();
            do {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                Regex2 regex2 = next;
                if (applicationCommand == null || (options = applicationCommand.getOptions()) == null) {
                    applicationCommandOption = null;
                } else {
                    Iterator<T> it3 = options.iterator();
                    do {
                        if (!it3.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it3.next();
                    } while (!Intrinsics3.areEqual(regex2 != null ? regex2.getValue() : null, ((ApplicationCommandOption) next2).getName()));
                    applicationCommandOption = (ApplicationCommandOption) next2;
                }
            } while (!(applicationCommandOption != null));
            Regex2 regex3 = next;
            first = (regex3 == null || (range = regex3.getRange()) == null) ? -1 : range.getFirst();
            if (first != -1) {
                return first == -1 ? new Ranges2(iIntValue, charSequence.length()) : new Ranges2(iIntValue, first + iIntValue);
            }
        }
        first = -1;
        if (first == -1) {
        }
    }

    public final String getCommandPrefix(CharSequence charSequence) {
        List<String> groupValues;
        Intrinsics3.checkNotNullParameter(charSequence, "$this$getCommandPrefix");
        MatchResult matchResultFind$default = Regex.find$default(new Regex("^(/([\\p{L}0-9-_]+\\s*){0,3})"), charSequence, 0, 2, null);
        if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null) {
            return null;
        }
        return (String) _Collections.getOrNull(groupValues, 1);
    }

    public final Set<ApplicationCommandOption> getErrorsToShowForCommandParameters(ApplicationCommand selectedCommand, ApplicationCommandOption selectedCommandOption, ApplicationCommandOption previouslySelected, Map<ApplicationCommandOption, Boolean> validMap, Map<ApplicationCommandOption, ? extends CommandOptionValue> parsedCommandOptions) {
        Intrinsics3.checkNotNullParameter(validMap, "validMap");
        Intrinsics3.checkNotNullParameter(parsedCommandOptions, "parsedCommandOptions");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (selectedCommand == null) {
            return Sets5.emptySet();
        }
        for (ApplicationCommandOption applicationCommandOption : selectedCommand.getOptions()) {
            if (parsedCommandOptions.containsKey(applicationCommandOption)) {
                CommandOptionValue commandOptionValue = parsedCommandOptions.get(applicationCommandOption);
                String strValueOf = String.valueOf(commandOptionValue != null ? commandOptionValue.getValue() : null);
                boolean z2 = false;
                boolean z3 = StringsJVM.isBlank(strValueOf) || (strValueOf.length() == 1 && MentionUtils.getDEFAULT_LEADING_IDENTIFIERS().contains(Character.valueOf(strValueOf.charAt(0))));
                boolean zAreEqual = Intrinsics3.areEqual(selectedCommandOption, applicationCommandOption);
                boolean z4 = previouslySelected != null && Intrinsics3.areEqual(previouslySelected, applicationCommandOption);
                boolean zContainsKey = parsedCommandOptions.containsKey(applicationCommandOption);
                boolean z5 = (zAreEqual && z4) || (zAreEqual && z3);
                if (Intrinsics3.areEqual(validMap.get(applicationCommandOption), Boolean.FALSE) && !z5 && zContainsKey) {
                    z2 = true;
                }
                if (z2) {
                    linkedHashSet.add(applicationCommandOption);
                }
            }
        }
        return linkedHashSet;
    }

    /* JADX WARN: Code duplicated, block: B:108:0x00b6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:0x012b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:17:0x005d  */
    /* JADX WARN: Code duplicated, block: B:19:0x0063  */
    /* JADX WARN: Code duplicated, block: B:20:0x0065  */
    /* JADX WARN: Code duplicated, block: B:22:0x0068  */
    /* JADX WARN: Code duplicated, block: B:25:0x0086  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:51:0x010f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x0111  */
    /* JADX WARN: Code duplicated, block: B:56:0x0128  */
    /* JADX WARN: Code duplicated, block: B:60:0x013a  */
    /* JADX WARN: Code duplicated, block: B:61:0x013c  */
    /* JADX WARN: Code duplicated, block: B:64:0x0148  */
    /* JADX WARN: Code duplicated, block: B:67:0x0160  */
    /* JADX WARN: Code duplicated, block: B:73:0x0171 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x0173  */
    /* JADX WARN: Code duplicated, block: B:76:0x0182  */
    /* JADX WARN: Code duplicated, block: B:77:0x0187  */
    /* JADX WARN: Code duplicated, block: B:81:0x0196  */
    /* JADX WARN: Code duplicated, block: B:82:0x0198  */
    /* JADX WARN: Code duplicated, block: B:83:0x019a  */
    /* JADX WARN: Instruction removed from duplicated block: B:41:0x00ca, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:83:0x019a, please report this as an issue */
    public final InputCommandContext getInputCommandContext(CharSequence input, long userId, List<Long> userRoles, AutocompleteApplicationCommands applicationCommands, ApplicationCommand selectedCommand) {
        ApplicationCommand applicationCommand;
        boolean z2;
        String strSubstring;
        ArrayList arrayList;
        ArrayList arrayList2;
        int length;
        boolean z3;
        Iterator it;
        Object next;
        String name;
        Object next2;
        String name2;
        Object obj;
        ApplicationCommand applicationCommand2;
        String name3;
        ApplicationCommand applicationCommand3;
        boolean zHasPermission;
        boolean z4;
        ApplicationCommand applicationCommand4;
        boolean zHasPermission2;
        boolean z5;
        boolean z6;
        long j = userId;
        List<Long> list = userRoles;
        Intrinsics3.checkNotNullParameter(input, "input");
        Intrinsics3.checkNotNullParameter(list, "userRoles");
        Intrinsics3.checkNotNullParameter(applicationCommands, "applicationCommands");
        String commandPrefix = getCommandPrefix(input);
        Application application = null;
        Object obj2 = null;
        if (commandPrefix != null) {
            if (selectedCommand != null) {
                String strSubstring2 = commandPrefix.substring(1);
                Intrinsics3.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                StringBuilder sb = new StringBuilder();
                String name4 = selectedCommand.getName();
                if (name4 == null) {
                    name4 = "";
                }
                if (!StringsJVM.startsWith$default(strSubstring2, outline.J(sb, name4, " "), false, 2, null)) {
                    String strSubstring3 = commandPrefix.substring(1);
                    Intrinsics3.checkNotNullExpressionValue(strSubstring3, "(this as java.lang.String).substring(startIndex)");
                    String name5 = selectedCommand.getName();
                    if (!Intrinsics3.areEqual(strSubstring3, name5 != null ? name5 : "")) {
                        if (commandPrefix.length() > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            List<ApplicationCommand> listFlattenSubCommands = StoreApplicationCommandsKt.flattenSubCommands(applicationCommands.getQueryCommands());
                            strSubstring = commandPrefix.substring(1);
                            Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
                            arrayList = new ArrayList();
                            for (Object obj3 : listFlattenSubCommands) {
                                applicationCommand4 = (ApplicationCommand) obj3;
                                zHasPermission2 = ApplicationCommand2.hasPermission(applicationCommand4, j, list);
                                if (StringsJVM.startsWith$default(applicationCommand4.getName(), strSubstring, false, 2, null) || !(!Intrinsics3.areEqual(strSubstring, applicationCommand4.getName()))) {
                                    z5 = false;
                                } else {
                                    z5 = true;
                                }
                                if (zHasPermission2 || !z5) {
                                    z6 = false;
                                } else {
                                    z6 = true;
                                }
                                if (z6) {
                                    arrayList.add(obj3);
                                }
                            }
                            arrayList2 = new ArrayList();
                            length = 0;
                            z3 = false;
                            for (Object obj4 : listFlattenSubCommands) {
                                applicationCommand3 = (ApplicationCommand) obj4;
                                zHasPermission = ApplicationCommand2.hasPermission(applicationCommand3, j, list);
                                boolean zAreEqual = Intrinsics3.areEqual(strSubstring, applicationCommand3.getName());
                                boolean zStartsWith$default = StringsJVM.startsWith$default(strSubstring, applicationCommand3.getName() + " ", false, 2, null);
                                if (zHasPermission || !(zStartsWith$default || zAreEqual)) {
                                    z4 = false;
                                } else {
                                    z4 = true;
                                }
                                if (!z4 && applicationCommand3.getName().length() == length) {
                                    z3 = true;
                                } else if (z4 && applicationCommand3.getName().length() > length) {
                                    length = applicationCommand3.getName().length();
                                    z3 = false;
                                }
                                if (z4) {
                                    arrayList2.add(obj4);
                                }
                                j = userId;
                                list = userRoles;
                            }
                            it = arrayList2.iterator();
                            if (it.hasNext()) {
                                next = it.next();
                                if (it.hasNext()) {
                                    name = ((ApplicationCommand) next).getName();
                                    do {
                                        next2 = it.next();
                                        name2 = ((ApplicationCommand) next2).getName();
                                        if (name.compareTo(name2) < 0) {
                                            next = next2;
                                            name = name2;
                                        }
                                    } while (it.hasNext());
                                }
                                obj = next;
                            } else {
                                obj = null;
                            }
                            applicationCommand = (ApplicationCommand) obj;
                            if (arrayList.isEmpty()) {
                                if (z3) {
                                    String string = input.subSequence(1, input.length()).toString();
                                    if (applicationCommand != null) {
                                        name3 = applicationCommand.getName();
                                    } else {
                                        name3 = null;
                                    }
                                    obj2 = null;
                                    applicationCommand2 = StringsJVM.startsWith$default(string, Intrinsics3.stringPlus(name3, " "), false, 2, null) ? null : null;
                                } else {
                                    obj2 = null;
                                }
                            }
                            applicationCommand = applicationCommand2;
                            obj2 = applicationCommand;
                        }
                    }
                }
                applicationCommand = selectedCommand;
            } else {
                if (commandPrefix.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    List<ApplicationCommand> listFlattenSubCommands2 = StoreApplicationCommandsKt.flattenSubCommands(applicationCommands.getQueryCommands());
                    strSubstring = commandPrefix.substring(1);
                    Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
                    arrayList = new ArrayList();
                    while (r11.hasNext()) {
                        applicationCommand4 = (ApplicationCommand) obj3;
                        zHasPermission2 = ApplicationCommand2.hasPermission(applicationCommand4, j, list);
                        if (StringsJVM.startsWith$default(applicationCommand4.getName(), strSubstring, false, 2, null)) {
                            z5 = false;
                        } else {
                            z5 = false;
                        }
                        if (zHasPermission2) {
                            z6 = false;
                        } else {
                            z6 = false;
                        }
                        if (z6) {
                            arrayList.add(obj3);
                        }
                    }
                    arrayList2 = new ArrayList();
                    length = 0;
                    z3 = false;
                    while (r6.hasNext()) {
                        applicationCommand3 = (ApplicationCommand) obj4;
                        zHasPermission = ApplicationCommand2.hasPermission(applicationCommand3, j, list);
                        boolean zAreEqual2 = Intrinsics3.areEqual(strSubstring, applicationCommand3.getName());
                        boolean zStartsWith$default2 = StringsJVM.startsWith$default(strSubstring, applicationCommand3.getName() + " ", false, 2, null);
                        if (zHasPermission) {
                            z4 = false;
                        } else {
                            z4 = false;
                        }
                        if (!z4) {
                            if (z4) {
                                length = applicationCommand3.getName().length();
                                z3 = false;
                            }
                        } else if (z4) {
                            length = applicationCommand3.getName().length();
                            z3 = false;
                        }
                        if (z4) {
                            arrayList2.add(obj4);
                        }
                        j = userId;
                        list = userRoles;
                    }
                    it = arrayList2.iterator();
                    if (it.hasNext()) {
                        obj = null;
                    } else {
                        next = it.next();
                        if (it.hasNext()) {
                            name = ((ApplicationCommand) next).getName();
                            do {
                                next2 = it.next();
                                name2 = ((ApplicationCommand) next2).getName();
                                if (name.compareTo(name2) < 0) {
                                    next = next2;
                                    name = name2;
                                }
                            } while (it.hasNext());
                        }
                        obj = next;
                    }
                    applicationCommand = (ApplicationCommand) obj;
                    if (arrayList.isEmpty()) {
                        if (z3) {
                            String string2 = input.subSequence(1, input.length()).toString();
                            if (applicationCommand != null) {
                                name3 = applicationCommand.getName();
                            } else {
                                name3 = null;
                            }
                            obj2 = null;
                            if (StringsJVM.startsWith$default(string2, Intrinsics3.stringPlus(name3, " "), false, 2, null)) {
                            }
                        } else {
                            obj2 = null;
                        }
                    }
                    applicationCommand = applicationCommand2;
                    obj2 = applicationCommand;
                } else {
                    applicationCommand = selectedCommand;
                }
            }
            for (Object obj5 : applicationCommands.getApplications()) {
                if (applicationCommand != null && ((Application) obj5).getId() == applicationCommand.getApplicationId()) {
                    obj2 = obj5;
                    break;
                }
            }
            application = (Application) obj2;
        } else {
            applicationCommand = null;
        }
        return new InputCommandContext(application, applicationCommand);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:45:0x00de  */
    /* JADX WARN: Code duplicated, block: B:70:0x0126  */
    /* JADX WARN: Code duplicated, block: B:85:0x015d  */
    /* JADX WARN: Code duplicated, block: B:87:0x0163  */
    /* JADX WARN: Code duplicated, block: B:96:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:98:0x01a9  */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v40 java.lang.Object, still in use, count: 2, list:
          (r3v40 java.lang.Object) from 0x00c8: PHI (r3 I:??) = (r3v37 java.lang.Object), (r3v40 java.lang.Object) binds: [B:37:0x00c7, B:130:0x00c8] A[DONT_GENERATE, DONT_INLINE]
          (r3v40 java.lang.Object) from 0x00b6: CHECK_CAST (com.discord.widgets.chat.input.autocomplete.ApplicationCommandChoiceAutocompletable) (r3v40 java.lang.Object)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    public final java.util.Map<com.discord.models.commands.ApplicationCommandOption, java.lang.Boolean> getInputValidity(com.discord.models.commands.ApplicationCommand r12, java.util.Map<com.discord.models.commands.ApplicationCommandOption, ? extends com.discord.widgets.chat.input.models.CommandOptionValue> r13, java.util.Map<com.discord.models.commands.ApplicationCommandOption, ? extends com.lytefast.flexinput.model.Attachment<?>> r14, com.discord.widgets.chat.input.models.ChatInputMentionsMap r15) {
        /*
            Method dump skipped, instruction units count: 524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.discord.widgets.chat.input.autocomplete.commands.AutocompleteCommandUtils.getInputValidity(com.discord.models.commands.ApplicationCommand, java.util.Map, java.util.Map, com.discord.widgets.chat.input.models.ChatInputMentionsMap):java.util.Map");
    }

    public final ApplicationCommand getSelectedCommand(List<? extends ApplicationCommand> commands, String prefix, String input, long userId, List<Long> roles) {
        Intrinsics3.checkNotNullParameter(commands, "commands");
        Intrinsics3.checkNotNullParameter(prefix, "prefix");
        Intrinsics3.checkNotNullParameter(input, "input");
        Intrinsics3.checkNotNullParameter(roles, "roles");
        Object obj = null;
        if (!(prefix.length() > 0)) {
            return null;
        }
        for (Object obj2 : commands) {
            ApplicationCommand applicationCommand = (ApplicationCommand) obj2;
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(MentionUtils.SLASH_CHAR) + applicationCommand.getName());
            sb.append(' ');
            if (StringsJVM.startsWith$default(input, sb.toString(), false, 2, null) && ApplicationCommand2.hasPermission(applicationCommand, userId, roles)) {
                obj = obj2;
                break;
            }
        }
        return (ApplicationCommand) obj;
    }

    public final ApplicationCommandOption getSelectedCommandOption(int cursorPosition, Map<ApplicationCommandOption, OptionRange> optionRanges) {
        Set<ApplicationCommandOption> setKeySet;
        if (optionRanges == null || (setKeySet = optionRanges.keySet()) == null) {
            return null;
        }
        for (ApplicationCommandOption applicationCommandOption : setKeySet) {
            OptionRange optionRange = optionRanges.get(applicationCommandOption);
            if (optionRange != null && optionRange.getParam().getFirst() < cursorPosition && optionRange.getValue().getLast() >= cursorPosition && applicationCommandOption.getType() != ApplicationCommandType.ATTACHMENT) {
                return applicationCommandOption;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x009c  */
    /* JADX WARN: Code duplicated, block: B:19:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:22:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:28:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:31:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:37:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:39:0x0100  */
    /* JADX WARN: Code duplicated, block: B:41:0x0104  */
    /* JADX WARN: Code duplicated, block: B:42:0x0111  */
    /* JADX WARN: Code duplicated, block: B:44:0x0115  */
    /* JADX WARN: Code duplicated, block: B:45:0x0122  */
    /* JADX WARN: Code duplicated, block: B:47:0x0126  */
    /* JADX WARN: Code duplicated, block: B:50:0x012b  */
    /* JADX WARN: Code duplicated, block: B:52:0x0136  */
    /* JADX WARN: Code duplicated, block: B:54:0x013a  */
    /* JADX WARN: Code duplicated, block: B:57:0x013f  */
    /* JADX WARN: Code duplicated, block: B:58:0x0149  */
    /* JADX WARN: Code duplicated, block: B:60:0x014d  */
    /* JADX WARN: Code duplicated, block: B:63:0x0152  */
    /* JADX WARN: Code duplicated, block: B:64:0x015c  */
    /* JADX WARN: Code duplicated, block: B:66:0x0164  */
    /* JADX WARN: Code duplicated, block: B:67:0x016e  */
    /* JADX WARN: Code duplicated, block: B:69:0x0178  */
    /* JADX WARN: Code duplicated, block: B:70:0x017f  */
    /* JADX WARN: Code duplicated, block: B:72:0x0189  */
    /* JADX WARN: Code duplicated, block: B:73:0x0193  */
    /* JADX WARN: Code duplicated, block: B:82:0x019f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x019a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x01b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x01a7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x00c9 A[SYNTHETIC] */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r6v16 java.lang.Object, still in use, count: 2, list:
          (r6v16 java.lang.Object) from 0x0084: PHI (r6 I:??) = (r6v1 java.lang.Object), (r6v16 java.lang.Object) binds: [B:11:0x0083, B:91:0x0084] A[DONT_GENERATE, DONT_INLINE]
          (r6v16 java.lang.Object) from 0x007a: CHECK_CAST (com.discord.widgets.chat.input.autocomplete.Autocompletable) (r6v16 java.lang.Object)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    public final java.util.Map<com.discord.models.commands.ApplicationCommandOption, com.discord.widgets.chat.input.models.CommandOptionValue> parseCommandOptions(java.lang.CharSequence r11, com.discord.models.commands.ApplicationCommand r12, com.discord.widgets.chat.input.models.ChatInputMentionsMap r13, java.util.Map<com.discord.models.commands.ApplicationCommandOption, ? extends com.lytefast.flexinput.model.Attachment<?>> r14) {
        /*
            Method dump skipped, instruction units count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.discord.widgets.chat.input.autocomplete.commands.AutocompleteCommandUtils.parseCommandOptions(java.lang.CharSequence, com.discord.models.commands.ApplicationCommand, com.discord.widgets.chat.input.models.ChatInputMentionsMap, java.util.Map):java.util.Map");
    }

    public final String transformParameterSpannableString(String str) {
        if (str == null) {
            return null;
        }
        if (Strings4.endsWith$default((CharSequence) Strings4.trim(str).toString(), MentionUtils.EMOJIS_AND_STICKERS_CHAR, false, 2, (Object) null)) {
            return Strings4.trim(str).toString();
        }
        if (!Strings4.contains$default((CharSequence) str, MentionUtils.EMOJIS_AND_STICKERS_CHAR, false, 2, (Object) null)) {
            return str;
        }
        List listSplit$default = Strings4.split$default((CharSequence) str, new char[]{MentionUtils.EMOJIS_AND_STICKERS_CHAR}, false, 0, 6, (Object) null);
        String str2 = (String) _Collections.firstOrNull(listSplit$default);
        String string = str2 != null ? Strings4.trim(str2).toString() : null;
        String strJoinToString$default = _Collections.joinToString$default(listSplit$default.subList(1, listSplit$default.size()), ":", null, null, 0, null, null, 62, null);
        Objects.requireNonNull(strJoinToString$default, "null cannot be cast to non-null type kotlin.CharSequence");
        return outline.y(string, ": ", Strings4.trim(strJoinToString$default).toString());
    }

    private final Integer asSafeNumberOrNull(Integer num) {
        if (num == null) {
            return null;
        }
        int iIntValue = num.intValue();
        if (INSTANCE.isSafeNumber(Integer.valueOf(iIntValue))) {
            return Integer.valueOf(iIntValue);
        }
        return null;
    }

    private final Long asSafeNumberOrNull(Long l) {
        if (l == null) {
            return null;
        }
        long jLongValue = l.longValue();
        if (INSTANCE.isSafeNumber(Long.valueOf(jLongValue))) {
            return Long.valueOf(jLongValue);
        }
        return null;
    }
}
